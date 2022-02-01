package com.tencent.mobileqq.highway.transaction;

import android.os.Environment;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.DataHole;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.QueryHoleRsp;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Transaction
{
  public static final long C2C_FileSize_Limit = 19922944L;
  public static final int HOLE_MASK_FIN = 3;
  public static final int HOLE_MASK_INIT = 0;
  public static final int HOLE_MASK_SENT = 2;
  public static final int HOLE_MASK_WAIT = 1;
  public static final int HOLE_SIZE_PER_HOLE = 4096;
  public static final String rep_Ip_ConnCost = "param_Ip_ConnCost";
  public static final String rep_Ip_Index = "param_ip_index";
  public static final String rep_bdhTrans = "rep_bdhTrans";
  public static final String rep_confMaxConn = "param_conf_connNum";
  public static final String rep_confSegNum = "param_conf_segNum";
  public static final String rep_confSegSize = "param_conf_segSize";
  public static final String rep_connNUm = "connNum:";
  public static final String rep_connType = "connType";
  public static final String rep_dwFlow_Xg = "dwFlow_Xg";
  public static final String rep_dwFlow_wifi = "dwFlow_WiFi";
  public static final String rep_finLost = "param_fin_lost";
  public static final String rep_has_net = "hasNet";
  public static final String rep_hb_has_resp = "heartHasResp";
  public static final String rep_heart_resp = "param_heart_resp";
  public static final String rep_ip = "ip:";
  public static final String rep_isPreConnExist = "PreConnExist:";
  public static final String rep_is_connected = "isConnected";
  public static final String rep_net_type = "net:";
  public static final String rep_progress = "progress";
  public static final String rep_proto = "proto";
  public static final String rep_retry_code = "param_retry_code";
  public static final String rep_retry_max = "param_max_retry_times";
  public static final String rep_retry_seg_count = "param_retry_seg_count";
  public static final String rep_retry_total = "param_total_retry_times";
  public static final String rep_segsPerConn = "segspercnt";
  public static final String rep_slice_num = "sn:";
  public static final String rep_time_cache = "tc_p:";
  public static final String rep_time_ht = "tc_h:";
  public static final String rep_time_send = "tc_s:";
  public static final String rep_upFlow_Xg = "upFlow_Xg";
  public static final String rep_upFlow_wifi = "upFlow_WiFi";
  public byte[] MD5;
  public Tracker TRACKER = null;
  private AtomicBoolean TimerStarted = new AtomicBoolean(false);
  public boolean bFINLost = false;
  public boolean bHasNet = false;
  public volatile boolean bQueryForFIN = false;
  public byte[] bitmap;
  private ITransactionCallback cb;
  public long confConnNum;
  public long confSegNum;
  public long confSegSize;
  public int connNum;
  public String connType;
  public String filePath;
  public AtomicBoolean hasSwitch2BackupChannel = new AtomicBoolean(false);
  public String ipAddr;
  public long ipConnCost = 0L;
  public int ipIndex = -1;
  public boolean isConnected = false;
  public AtomicBoolean isFinish = new AtomicBoolean(false);
  public byte[] mBuExtendinfo;
  public int mBuzCmdId;
  public HashMap<Integer, AtomicInteger> mDataFlowOfChannel = new HashMap();
  private AtomicBoolean mIsPause = new AtomicBoolean(false);
  private boolean mIsPreConnExist = false;
  private HashMap<String, String> mReportParams = new HashMap();
  public int mRetryTimes_SegsMax = 0;
  public int mRetryTimes_SegsNum = 0;
  public int mRetryTimes_SegsTotal = 0;
  public TransTimeOutMonitor mTimeOutMonitor;
  private TransactionWorker mTransWorker;
  public int netType;
  private int offset;
  public String peerUin;
  public String protoType;
  private RandomAccessFile raf;
  public int retryCode;
  public int sliceNum = 0;
  public byte[] ticket;
  public int timeCost_Cache = 0;
  public int timeCost_Ht = 0;
  public int timeCost_Send = 0;
  public int totalLength = 0;
  int transationId = -1;
  private int transferedSize = 0;
  
  public Transaction(String paramString1, int paramInt1, String paramString2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, ITransactionCallback paramITransactionCallback)
  {
    this.peerUin = paramString1;
    this.filePath = paramString2;
    this.offset = paramInt2;
    this.mBuzCmdId = paramInt1;
    if (this.offset < 0) {
      this.offset = 0;
    }
    this.MD5 = paramArrayOfByte2;
    this.ticket = paramArrayOfByte1;
    this.cb = paramITransactionCallback;
  }
  
  private int analysisIOProblem(IOException paramIOException)
  {
    paramIOException = paramIOException.getMessage();
    String str = Environment.getExternalStorageState();
    if (paramIOException.contains("EACCES")) {}
    do
    {
      return 9039;
      if (paramIOException.contains("ENOSPC")) {
        return 9040;
      }
    } while ((paramIOException.contains("Read-only")) || (!"mounted".equals(str)));
    return 9303;
  }
  
  private void extendTimeExceedLimit()
  {
    TransTimeOutMonitor localTransTimeOutMonitor = this.mTimeOutMonitor;
    if (localTransTimeOutMonitor.needExtendTimeExceedLimit())
    {
      BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " ExtendTimeExceedLimit.");
      localTransTimeOutMonitor.isKilled = true;
      if (this.mTransWorker != null)
      {
        this.mTimeOutMonitor = new TransTimeOutMonitor();
        this.mTransWorker.startTransRunnable(localTransTimeOutMonitor, this.mTimeOutMonitor);
      }
    }
  }
  
  private void finish(boolean paramBoolean)
  {
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "Finish. IsSuccess:" + paramBoolean);
    if (this.mTransWorker != null)
    {
      this.mTransWorker.onTransactionFinish(paramBoolean, this);
      this.mTransWorker = null;
    }
    try
    {
      if (this.raf != null)
      {
        this.raf.close();
        this.raf = null;
      }
      return;
    }
    catch (IOException localIOException)
    {
      BdhLogUtil.LogException("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "Finish Error: IsSuccess:" + paramBoolean, localIOException);
    }
  }
  
  private boolean isPause()
  {
    return this.mIsPause.get();
  }
  
  private void setReportInfo()
  {
    String str = "UnKnow";
    switch (this.netType)
    {
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = new StringBuilder("");
      localObject1 = this.mDataFlowOfChannel.values().iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (AtomicInteger)((Iterator)localObject1).next();
        if (i >= 5) {
          break;
        }
        if (i > 0) {
          ((StringBuilder)localObject2).append("_");
        }
        ((StringBuilder)localObject2).append(((AtomicInteger)localObject3).get());
        i += 1;
      }
      str = "WiFi";
      continue;
      str = "3G";
      continue;
      str = "2G";
      continue;
      str = "4G";
      continue;
      str = "CABLE";
    }
    Object localObject1 = this.mTransWorker.getHeartBreakInfo();
    this.ipConnCost = this.mTransWorker.getIpConnectCost();
    Object localObject3 = this.mTransWorker.getReportDataFlow();
    StringBuilder localStringBuilder1 = new StringBuilder("");
    localStringBuilder1.append("sn:").append(this.sliceNum).append(";");
    localStringBuilder1.append("tc_s:").append(this.timeCost_Send).append(";");
    localStringBuilder1.append("tc_h:").append(this.timeCost_Ht).append(";");
    localStringBuilder1.append("tc_p:").append(this.timeCost_Cache).append(";");
    localStringBuilder1.append("net:").append(str).append(";");
    localStringBuilder1.append("ip:").append(this.ipAddr).append(";");
    localStringBuilder1.append("connNum:").append(this.connNum).append(";");
    StringBuilder localStringBuilder2 = localStringBuilder1.append("PreConnExist:");
    if (this.mIsPreConnExist)
    {
      str = "1";
      localStringBuilder2.append(str).append(";");
      localStringBuilder1.append("param_conf_segSize").append(":").append(this.confSegSize).append(";");
      localStringBuilder1.append("param_conf_segNum").append(":").append(this.confSegNum).append(";");
      localStringBuilder1.append("param_conf_connNum").append(":").append(this.confConnNum).append(";");
      localStringBuilder1.append("proto").append(":").append(this.protoType).append(";");
      localStringBuilder1.append("connType").append(":").append(this.connType).append(";");
      localStringBuilder2 = localStringBuilder1.append("hasNet").append(":");
      if (!this.bHasNet) {
        break label963;
      }
      str = "true";
      label540:
      localStringBuilder2.append(str).append(";");
      localStringBuilder1.append("progress").append(":").append(this.transferedSize).append(";");
      localStringBuilder2 = localStringBuilder1.append("isConnected").append(":");
      if (!this.isConnected) {
        break label970;
      }
      str = "true";
      label606:
      localStringBuilder2.append(str).append(";");
      localStringBuilder1.append("heartHasResp").append(":").append((String)localObject1);
      this.mReportParams.put("upFlow_WiFi", String.valueOf(localObject3[0]));
      this.mReportParams.put("dwFlow_WiFi", String.valueOf(localObject3[1]));
      this.mReportParams.put("upFlow_Xg", String.valueOf(localObject3[2]));
      this.mReportParams.put("dwFlow_Xg", String.valueOf(localObject3[3]));
      this.mReportParams.put("tc_p:", String.valueOf(this.timeCost_Cache));
      this.mReportParams.put("rep_bdhTrans", localStringBuilder1.toString());
      this.mReportParams.put("param_conf_segSize", String.valueOf(this.confSegSize));
      this.mReportParams.put("param_conf_segNum", String.valueOf(this.confSegNum));
      this.mReportParams.put("param_conf_connNum", String.valueOf(this.confConnNum));
      this.mReportParams.put("segspercnt", ((StringBuilder)localObject2).toString());
      localObject2 = this.mReportParams;
      if (!this.bFINLost) {
        break label977;
      }
      str = String.valueOf(true);
      label821:
      ((HashMap)localObject2).put("param_fin_lost", str);
      this.mReportParams.put("param_retry_seg_count", String.valueOf(this.mRetryTimes_SegsNum));
      this.mReportParams.put("param_total_retry_times", String.valueOf(this.mRetryTimes_SegsTotal));
      this.mReportParams.put("param_max_retry_times", String.valueOf(this.mRetryTimes_SegsMax));
      this.mReportParams.put("param_retry_code", String.valueOf(this.retryCode));
      localObject2 = this.mReportParams;
      if (localObject1 == null) {
        break label985;
      }
    }
    label963:
    label970:
    label977:
    label985:
    for (str = "1";; str = "0")
    {
      ((HashMap)localObject2).put("param_heart_resp", str);
      this.mReportParams.put("param_ip_index", String.valueOf(this.ipIndex));
      this.mReportParams.put("param_Ip_ConnCost", String.valueOf(this.ipConnCost));
      return;
      str = "0";
      break;
      str = "false";
      break label540;
      str = "false";
      break label606;
      str = String.valueOf(false);
      break label821;
    }
  }
  
  private void startTimeoutTimer()
  {
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "startTimeoutTimer.");
    Object localObject = this.cb;
    if (localObject != null) {
      ((ITransactionCallback)localObject).onTransStart();
    }
    if (this.mTransWorker != null)
    {
      localObject = this.mTimeOutMonitor;
      ((TransTimeOutMonitor)localObject).isKilled = true;
      this.mTimeOutMonitor = new TransTimeOutMonitor();
      this.mTransWorker.startTransRunnable((Runnable)localObject, this.mTimeOutMonitor);
    }
  }
  
  private void stopTimeoutTimer()
  {
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " StopTimeoutTime.");
    this.TimerStarted.set(false);
    this.mTimeOutMonitor.isKilled = true;
    if (this.mTransWorker != null) {
      this.mTransWorker.stopTransRunnable(this.mTimeOutMonitor);
    }
  }
  
  private void updateRetryInfo(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if (paramInt > this.mRetryTimes_SegsMax) {
      this.mRetryTimes_SegsMax = paramInt;
    }
    this.mRetryTimes_SegsNum += 1;
    this.mRetryTimes_SegsTotal += paramInt;
  }
  
  void cancelTransaction()
  {
    if (!this.isFinish.compareAndSet(false, true)) {
      return;
    }
    this.TRACKER.logStep("CANCL", "");
    stopTimeoutTimer();
    finish(false);
  }
  
  /* Error */
  public byte[] getData(DataTransInfo paramDataTransInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 187	com/tencent/mobileqq/highway/transaction/Transaction:isFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 355	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifeq +16 -> 25
    //   12: aload_1
    //   13: iconst_0
    //   14: putfield 499	com/tencent/mobileqq/highway/transaction/DataTransInfo:errno	I
    //   17: aconst_null
    //   18: astore 5
    //   20: aload_0
    //   21: monitorexit
    //   22: aload 5
    //   24: areturn
    //   25: iconst_0
    //   26: istore_3
    //   27: aload_1
    //   28: getfield 502	com/tencent/mobileqq/highway/transaction/DataTransInfo:length	I
    //   31: istore_2
    //   32: aload_1
    //   33: getfield 502	com/tencent/mobileqq/highway/transaction/DataTransInfo:length	I
    //   36: newarray byte
    //   38: astore 6
    //   40: aload_0
    //   41: getfield 340	com/tencent/mobileqq/highway/transaction/Transaction:raf	Ljava/io/RandomAccessFile;
    //   44: aload_1
    //   45: getfield 503	com/tencent/mobileqq/highway/transaction/DataTransInfo:offset	I
    //   48: i2l
    //   49: invokevirtual 507	java/io/RandomAccessFile:seek	(J)V
    //   52: aload 6
    //   54: astore 5
    //   56: iload_3
    //   57: aload_1
    //   58: getfield 502	com/tencent/mobileqq/highway/transaction/DataTransInfo:length	I
    //   61: if_icmpge -41 -> 20
    //   64: aload_0
    //   65: getfield 340	com/tencent/mobileqq/highway/transaction/Transaction:raf	Ljava/io/RandomAccessFile;
    //   68: aload 6
    //   70: iload_3
    //   71: iload_2
    //   72: invokevirtual 511	java/io/RandomAccessFile:read	([BII)I
    //   75: istore 4
    //   77: iload 4
    //   79: iconst_m1
    //   80: if_icmpne +16 -> 96
    //   83: aload_1
    //   84: sipush 9303
    //   87: putfield 499	com/tencent/mobileqq/highway/transaction/DataTransInfo:errno	I
    //   90: aconst_null
    //   91: astore 5
    //   93: goto -73 -> 20
    //   96: iload_3
    //   97: iload 4
    //   99: iadd
    //   100: istore_3
    //   101: iload_2
    //   102: iload 4
    //   104: isub
    //   105: istore_2
    //   106: goto -54 -> 52
    //   109: astore 5
    //   111: ldc_w 285
    //   114: new 287	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   121: ldc_w 290
    //   124: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_0
    //   128: getfield 238	com/tencent/mobileqq/highway/transaction/Transaction:mBuzCmdId	I
    //   131: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: ldc_w 299
    //   137: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: invokevirtual 303	com/tencent/mobileqq/highway/transaction/Transaction:getTransationId	()I
    //   144: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: ldc_w 513
    //   150: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: aload 5
    //   158: invokestatic 351	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   161: aload_1
    //   162: aload_0
    //   163: aload 5
    //   165: invokespecial 515	com/tencent/mobileqq/highway/transaction/Transaction:analysisIOProblem	(Ljava/io/IOException;)I
    //   168: putfield 499	com/tencent/mobileqq/highway/transaction/DataTransInfo:errno	I
    //   171: aconst_null
    //   172: astore 5
    //   174: goto -154 -> 20
    //   177: astore_1
    //   178: aload_0
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	Transaction
    //   0	182	1	paramDataTransInfo	DataTransInfo
    //   31	75	2	i	int
    //   26	75	3	j	int
    //   75	30	4	k	int
    //   18	74	5	localObject1	Object
    //   109	55	5	localIOException	IOException
    //   172	1	5	localObject2	Object
    //   38	31	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   27	52	109	java/io/IOException
    //   56	77	109	java/io/IOException
    //   83	90	109	java/io/IOException
    //   2	17	177	finally
    //   27	52	177	finally
    //   56	77	177	finally
    //   83	90	177	finally
    //   111	171	177	finally
  }
  
  public int getTransationId()
  {
    return this.transationId;
  }
  
  int initSegmentList(TransactionWorker paramTransactionWorker, boolean paramBoolean)
  {
    this.mIsPreConnExist = paramBoolean;
    File localFile = new File(this.filePath);
    this.mTransWorker = paramTransactionWorker;
    if (localFile.exists())
    {
      if (!localFile.canRead()) {
        return 9070;
      }
      this.totalLength = ((int)localFile.length());
      if (this.totalLength > 19922944L) {
        return 9063;
      }
      if (this.totalLength <= 0) {
        return 9071;
      }
      int i;
      int k;
      for (;;)
      {
        try
        {
          this.raf = new RandomAccessFile(localFile, "r");
          int j = this.totalLength / 4096;
          i = j;
          if (this.totalLength % 4096 != 0) {
            i = j + 1;
          }
          k = this.offset / 4096;
          this.bitmap = new byte[i];
          j = 0;
          if (j >= i) {
            break;
          }
          if (j < k)
          {
            this.bitmap[j] = 3;
            j += 1;
          }
          else
          {
            this.bitmap[j] = 0;
          }
        }
        catch (FileNotFoundException paramTransactionWorker)
        {
          return 9042;
        }
      }
      this.TRACKER = new Tracker(this.transationId, this.totalLength);
      this.mTimeOutMonitor = new TransTimeOutMonitor();
      this.TRACKER.logStep("INITI", "DotsNum:" + i + " StartHole:" + k);
      return 0;
    }
    return 9042;
  }
  
  public void onQuertHoleError(byte[] paramArrayOfByte)
  {
    if (this.isFinish.get()) {
      return;
    }
    BdhLogUtil.LogEvent("R", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " QueryDebug Query OnQuertHoleError : CopyBitmap:" + Arrays.toString(paramArrayOfByte) + " CurrentBitmap:" + Arrays.toString(this.bitmap));
    int i = 0;
    while (i < this.bitmap.length)
    {
      if (paramArrayOfByte[i] == 2) {
        this.bitmap[i] = 0;
      }
      i += 1;
    }
    this.TRACKER.logStep("QUERY", "QueryHoleError Bitmap:" + Arrays.toString(this.bitmap));
    this.mTransWorker.notifyToSend();
  }
  
  public void onQueryHoleResp(CSDataHighwayHead.QueryHoleRsp paramQueryHoleRsp, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (this.isFinish.get()) {
      return;
    }
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + " \tT_ID:" + getTransationId() + "\tQueryHoleResp。");
    int i = paramQueryHoleRsp.uint32_result.get();
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    BdhUtils.copyData(arrayOfByte, 0, paramArrayOfByte, 0, paramArrayOfByte.length);
    if (i != 0)
    {
      onQuertHoleError(paramArrayOfByte);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("Holes:");
    paramQueryHoleRsp = paramQueryHoleRsp.rpt_data_hole.get();
    i = 0;
    if ((paramQueryHoleRsp != null) && (!paramQueryHoleRsp.isEmpty()))
    {
      paramQueryHoleRsp = paramQueryHoleRsp.iterator();
      if (paramQueryHoleRsp.hasNext())
      {
        CSDataHighwayHead.DataHole localDataHole = (CSDataHighwayHead.DataHole)paramQueryHoleRsp.next();
        int n = (int)localDataHole.uint64_begin.get();
        int i1 = (int)localDataHole.uint64_end.get();
        int k = n / 4096;
        int m = (i1 - 1) / 4096;
        j = i;
        if (m > i) {
          j = m;
        }
        localStringBuilder.append("Holes Start:").append(k).append(" End:").append(m);
        BdhLogUtil.LogEvent("R", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " OnQueryHoleResp : holes :  HoleStart:" + n + " HoleEnd:" + i1 + " BitmapS:" + k + " BitmapE:" + m);
        for (;;)
        {
          i = j;
          if (k > m) {
            break;
          }
          if (paramArrayOfByte[k] == 2) {
            paramArrayOfByte[k] = 0;
          }
          k += 1;
        }
      }
      int j = i;
      if (i >= paramArrayOfByte.length) {
        j = paramArrayOfByte.length - 1;
      }
      while (j < paramArrayOfByte.length)
      {
        paramArrayOfByte[j] = 0;
        j += 1;
      }
      i = 0;
      if (i < paramArrayOfByte.length)
      {
        if ((arrayOfByte[i] == 2) && (paramArrayOfByte[i] == 0) && ((this.bQueryForFIN) || (this.bitmap[i] != 3))) {
          this.bitmap[i] = 0;
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramArrayOfByte[i] == 2) {
            this.bitmap[i] = 3;
          }
        }
      }
    }
    else
    {
      localStringBuilder.append("null");
    }
    this.TRACKER.logStep("QUERY", "QueryHoleResp " + localStringBuilder.toString());
    BdhLogUtil.LogEvent("R", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " OnQueryHoleResp : Merged : CopyBitmap:" + Arrays.toString(paramArrayOfByte) + " CurrentBitmap:" + Arrays.toString(this.bitmap));
    this.mTransWorker.notifyToSend();
  }
  
  public void onSwitchToBackupChannel()
  {
    stopTimeoutTimer();
    if (this.hasSwitch2BackupChannel.get()) {}
    do
    {
      return;
      this.hasSwitch2BackupChannel.set(true);
    } while (this.cb == null);
    this.cb.onSwitch2BackupChannel();
  }
  
  public void onTransFailed(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    if (!this.isFinish.compareAndSet(false, true)) {
      return;
    }
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " OnTransFailed : ERR_C:" + paramInt1 + " ERR_H:" + paramInt2 + " ERR_B:" + paramInt3);
    stopTimeoutTimer();
    updateRetryInfo(paramInt4);
    if (paramInt3 != 0) {
      paramInt1 = paramInt3;
    }
    for (;;)
    {
      paramInt2 = paramInt1;
      if (this.mTransWorker != null)
      {
        this.bHasNet = this.mTransWorker.updateAndCheckNet();
        this.isConnected = this.mTransWorker.isNetworkConnected();
        if ((!this.bHasNet) || (!this.isConnected)) {
          paramInt1 = 9004;
        }
        if (paramInt1 != -1002)
        {
          paramInt2 = paramInt1;
          if (paramInt1 != -1005) {}
        }
        else
        {
          this.mTransWorker.dumpEngineInfo();
          this.TRACKER.logStep("QUERY", "TransFailed  Bitmap:" + Arrays.toString(this.bitmap));
          String str = this.TRACKER.dumpTrackerInfo();
          QLog.d("T", 1, "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " TRACEKERINFO:" + str);
          paramInt2 = paramInt1;
          if (this.mTransWorker.getConnErroCode() == 3) {
            paramInt2 = -1007;
          }
        }
      }
      setReportInfo();
      finish(false);
      this.mBuExtendinfo = paramArrayOfByte;
      if (this.cb == null) {
        break;
      }
      this.cb.onFailed(paramInt2, this.mBuExtendinfo, this.mReportParams);
      return;
      if (paramInt2 != 0) {
        paramInt1 = paramInt2;
      }
    }
  }
  
  public void onTransProgress(DataTransInfo paramDataTransInfo)
  {
    if (this.isFinish.get()) {}
    do
    {
      do
      {
        int m;
        int n;
        do
        {
          return;
          extendTimeExceedLimit();
          updateRetryInfo(paramDataTransInfo.retryTimes);
          if (paramDataTransInfo != null)
          {
            this.timeCost_Send = ((int)(this.timeCost_Send + (paramDataTransInfo.timeCost_req - paramDataTransInfo.timeCost_hw - paramDataTransInfo.timeCost_cache)));
            this.timeCost_Ht = ((int)(this.timeCost_Ht + paramDataTransInfo.timeCost_hw));
            this.timeCost_Cache = ((int)(this.timeCost_Cache + paramDataTransInfo.timeCost_cache));
          }
          m = paramDataTransInfo.bitmapS;
          n = paramDataTransInfo.bitmapE;
        } while (n >= this.bitmap.length);
        i = m;
        while (i <= n)
        {
          this.bitmap[i] = 3;
          i += 1;
        }
        int j = 0;
        i = 0;
        while (i < this.bitmap.length)
        {
          int k = j;
          if (this.bitmap[i] == 3) {
            k = j + 1;
          }
          i += 1;
          j = k;
        }
        this.transferedSize = (j * 4096);
        if (this.bitmap[(this.bitmap.length - 1)] == 3) {
          this.transferedSize -= this.bitmap.length * 4096 - this.totalLength;
        }
        if (this.transferedSize >= this.totalLength)
        {
          BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "NotifySegmentProgress Error : Finish flag is lost.");
          this.bFINLost = true;
        }
        if (this.cb != null)
        {
          BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " NotifySegmentProgress Total:" + this.totalLength + " TransSize:" + this.transferedSize + " allHoles:" + this.bitmap.length + " [" + m + ":" + n + "]");
          this.cb.onUpdateProgress(this.transferedSize);
        }
        this.TRACKER.logStep("PRGRS", "TransProgress Start:" + m + " End:" + n);
      } while ((!this.bFINLost) || (this.bQueryForFIN));
      this.bQueryForFIN = true;
      paramDataTransInfo = this.mTransWorker;
    } while (paramDataTransInfo == null);
    byte[] arrayOfByte = new byte[this.bitmap.length];
    int i = 0;
    while (i <= this.bitmap.length - 1)
    {
      arrayOfByte[i] = 2;
      i += 1;
    }
    paramDataTransInfo.queryTransaction(this, arrayOfByte);
    this.TRACKER.logStep("QUERY", "FinFlagLost  Bitmap:" + Arrays.toString(this.bitmap));
  }
  
  public void onTransSuccess(DataTransInfo paramDataTransInfo, byte[] paramArrayOfByte)
  {
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " NotifySegmentSuccess");
    if (!this.isFinish.compareAndSet(false, true)) {}
    do
    {
      return;
      stopTimeoutTimer();
      updateRetryInfo(paramDataTransInfo.retryTimes);
      if (paramDataTransInfo != null)
      {
        this.timeCost_Send = ((int)(this.timeCost_Send + (paramDataTransInfo.timeCost_req - paramDataTransInfo.timeCost_hw - paramDataTransInfo.timeCost_cache)));
        this.timeCost_Ht = ((int)(this.timeCost_Ht + paramDataTransInfo.timeCost_hw));
        this.timeCost_Cache = ((int)(this.timeCost_Cache + paramDataTransInfo.timeCost_cache));
      }
      setReportInfo();
      finish(true);
      this.mBuExtendinfo = paramArrayOfByte;
      this.transferedSize = this.totalLength;
    } while (this.cb == null);
    this.cb.onSuccess(this.mBuExtendinfo, this.mReportParams);
  }
  
  DataTransInfo peekNextSegment(int paramInt, HwNetSegConf paramHwNetSegConf)
  {
    if ((this.isFinish.get()) || (isPause())) {
      return null;
    }
    if (this.TimerStarted.compareAndSet(false, true)) {
      startTimeoutTimer();
    }
    if ((this.confSegSize == 0L) && (paramHwNetSegConf != null))
    {
      this.confSegSize = ((int)paramHwNetSegConf.segSize);
      this.confSegNum = ((int)paramHwNetSegConf.segNum);
      this.confConnNum = ((int)paramHwNetSegConf.curConnNum);
    }
    int i = paramInt / 4096;
    int m = i;
    if (paramInt % 4096 > 0) {
      m = i + 1;
    }
    i = -1;
    int n = -1;
    paramInt = 0;
    label107:
    int k = n;
    int j = i;
    if (paramInt < this.bitmap.length)
    {
      if (this.bitmap[paramInt] == 0)
      {
        j = i;
        if (i == -1) {
          j = paramInt;
        }
        if (paramInt != this.bitmap.length - 1)
        {
          k = j;
          if (m != paramInt + 1 - j) {
            break label309;
          }
        }
        k = paramInt;
      }
    }
    else
    {
      label172:
      if (j == -1) {
        break label307;
      }
      this.sliceNum += 1;
      paramHwNetSegConf = new DataTransInfo(this);
      paramHwNetSegConf.fileSize = this.totalLength;
      paramHwNetSegConf.offset = (j * 4096);
      paramHwNetSegConf.bitmapS = j;
      paramHwNetSegConf.bitmapE = k;
      if (k != this.bitmap.length - 1) {
        break label319;
      }
    }
    label307:
    label309:
    label319:
    for (paramHwNetSegConf.length = ((k - j) * 4096 + (this.totalLength - (this.bitmap.length - 1) * 4096));; paramHwNetSegConf.length = ((k - j + 1) * 4096))
    {
      paramInt = j;
      while (paramInt <= k)
      {
        this.bitmap[paramInt] = 1;
        paramInt += 1;
      }
      k = i;
      if (i != -1)
      {
        k = paramInt;
        j = i;
        break label172;
        break;
      }
      paramInt += 1;
      i = k;
      break label107;
    }
    this.TRACKER.logStep("SLICE", "Start:" + j + " End:" + k + " Length:" + paramHwNetSegConf.length);
    return paramHwNetSegConf;
  }
  
  public void setPause(boolean paramBoolean)
  {
    this.mIsPause.set(paramBoolean);
    if (isPause()) {
      stopTimeoutTimer();
    }
  }
  
  class TransTimeOutMonitor
    implements Runnable
  {
    public volatile boolean isKilled = false;
    public long mStartTime = 0L;
    
    public TransTimeOutMonitor() {}
    
    public boolean needExtendTimeExceedLimit()
    {
      return SystemClock.uptimeMillis() - this.mStartTime >= 60000L;
    }
    
    public void run()
    {
      if (!this.isKilled) {
        Transaction.this.onTransFailed(-1002, -1002, -1002, 0, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.transaction.Transaction
 * JD-Core Version:    0.7.0.1
 */