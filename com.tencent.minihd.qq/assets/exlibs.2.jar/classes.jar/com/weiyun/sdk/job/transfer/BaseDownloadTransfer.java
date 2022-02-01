package com.weiyun.sdk.job.transfer;

import android.os.Build.VERSION;
import com.weiyun.sdk.ErrorCode;
import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.util.NetworkUtils;
import com.weiyun.sdk.util.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;

public class BaseDownloadTransfer
  implements Transfer
{
  private static final String TAG = "BaseDownloadTransfer";
  protected final DownloadJobContext mContext;
  protected RandomAccessFile mDestFileWriter;
  protected final AddressFetcher.TransferAddress mDownloadAddress;
  protected final BaseDownloadJob mJob;
  protected long mOffset;
  protected long mSplitSize = 8388608L;
  protected long mStartTime;
  protected int mTimeoutTimes = 0;
  protected boolean mUseSplitDownload = false;
  
  public BaseDownloadTransfer(AddressFetcher.TransferAddress paramTransferAddress, DownloadJobContext paramDownloadJobContext, BaseDownloadJob paramBaseDownloadJob)
  {
    this.mDownloadAddress = paramTransferAddress;
    this.mContext = paramDownloadJobContext;
    this.mJob = paramBaseDownloadJob;
  }
  
  private Transfer.Result checkJob()
  {
    if (!this.mJob.isAlive()) {
      return new Transfer.Result(-10002, "取消了上传、下载过程!");
    }
    if (!this.mJob.checkEnvironment()) {
      return new Transfer.Result(this.mJob.getLastErrorNo(), "没有网络!");
    }
    return null;
  }
  
  private Transfer.Result handleError(boolean paramBoolean, int paramInt, Transfer.Result paramResult)
  {
    long l;
    if ((paramResult.mRet == -30002) || (paramResult.mRet == -30028) || (paramResult.mRet == -30029))
    {
      this.mTimeoutTimes += 1;
      if ((!ErrorCode.isNetworkError(paramResult.mRet)) || (!paramBoolean) || (!this.mJob.isAlive())) {
        break label204;
      }
      l = (1200.0D * Math.pow(paramInt, 0.5D));
      Log.i("BaseDownloadTransfer", "Last transfer network error, so rollback, sleep time = " + l + ", id = " + this.mJob.getId());
    }
    for (;;)
    {
      try
      {
        Thread.sleep(l);
        if ((paramResult.mRet == -30016) && (NetworkUtils.isCnwapConnection(null)) && (isSupportSplitDownload()))
        {
          if (this.mUseSplitDownload) {
            break label271;
          }
          this.mUseSplitDownload = true;
        }
        return new Transfer.Result(0, null);
      }
      catch (InterruptedException paramResult)
      {
        Log.w("BaseDownloadTransfer", paramResult.getMessage(), paramResult);
        return new Transfer.Result(-10002, Utils.getStackTraceAsString(paramResult));
      }
      this.mTimeoutTimes = 0;
      break;
      label204:
      if ((paramResult.mRet == -29110) || (paramResult.mRet == -29006))
      {
        Log.w("BaseDownloadTransfer", "file offset is wrong! offset :" + this.mContext.getCurSize());
        return cutFileToZero();
      }
      if (paramResult.mRet == -29203)
      {
        return paramResult;
        label271:
        this.mSplitSize /= 2L;
        this.mSplitSize = Math.max(this.mSplitSize, 8192L);
      }
    }
  }
  
  private void report(Transfer.Result paramResult)
  {
    switch (paramResult.mRet)
    {
    default: 
      this.mJob.reportDownloadTransferSize(3, paramResult.mRet, this.mStartTime, System.currentTimeMillis(), this.mContext.getCurSize() - this.mOffset, paramResult.mErrMsg);
      return;
    case 0: 
      this.mJob.reportDownloadTransferSize(0, 0, this.mStartTime, System.currentTimeMillis(), this.mContext.getCurSize() - this.mOffset, paramResult.mErrMsg);
      return;
    }
    this.mJob.reportDownloadTransferSize(1, -10002, this.mStartTime, System.currentTimeMillis(), this.mContext.getCurSize() - this.mOffset, paramResult.mErrMsg);
  }
  
  protected Transfer.Result acquireResource()
  {
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    Object localObject2 = localObject1;
    if (j < 2) {}
    Object localObject3;
    try
    {
      this.mDestFileWriter = new RandomAccessFile(this.mContext.getDataFilePath(), "rwd");
      i = 0;
      localObject2 = localObject1;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        localObject1 = localFileNotFoundException;
        Log.e("BaseDownloadTransfer", "", localFileNotFoundException);
        if (Utils.checkFileExist(this.mContext.getDataDirectoryPath()))
        {
          i = -10008;
          localObject3 = localObject1;
        }
        else
        {
          if (Utils.checkDirAndCreate(this.mContext.getDataDirectoryPath())) {
            break;
          }
          i = -10008;
          localObject3 = localObject1;
        }
      }
      i = -10006;
      j += 1;
    }
    if (localObject2 == null) {}
    for (localObject1 = null;; localObject1 = Utils.getStackTraceAsString(localObject3))
    {
      return new Transfer.Result(i, (String)localObject1);
      break;
    }
  }
  
  protected URL createUrl()
    throws MalformedURLException
  {
    return new URL("http", this.mDownloadAddress.getHost(), this.mDownloadAddress.getPort(), this.mDownloadAddress.getFile());
  }
  
  protected Transfer.Result cutFileToZero()
  {
    this.mOffset = 0L;
    this.mContext.setCurSize(0L);
    try
    {
      this.mDestFileWriter.setLength(0L);
      return new Transfer.Result(0, null);
    }
    catch (IOException localIOException)
    {
      Log.w("BaseDownloadTransfer", localIOException);
      return new Transfer.Result(-10008, Utils.getStackTraceAsString(localIOException));
    }
  }
  
  protected Transfer.Result doDownload()
  {
    if (!isSupportContinueInterruption())
    {
      localResult = cutFileToZero();
      if (localResult.mRet != 0) {
        return localResult;
      }
    }
    Transfer.Result localResult = doDownloadImpl();
    if ((localResult.mRet == -10002) && (this.mContext.getTotalSize() != 0L) && (this.mContext.getTotalSize() == this.mContext.getCurSize()))
    {
      Log.i("BaseDownloadTransfer", "user canceled a finished job!");
      return new Transfer.Result(0, null);
    }
    return localResult;
  }
  
  /* Error */
  protected Transfer.Result doDownloadImpl()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 18
    //   3: aconst_null
    //   4: astore 28
    //   6: aconst_null
    //   7: astore 29
    //   9: aconst_null
    //   10: astore 27
    //   12: aconst_null
    //   13: astore 26
    //   15: aconst_null
    //   16: astore 24
    //   18: aconst_null
    //   19: astore 20
    //   21: aconst_null
    //   22: astore 25
    //   24: iconst_0
    //   25: istore_3
    //   26: iconst_0
    //   27: istore 4
    //   29: iload_3
    //   30: istore_1
    //   31: aload 27
    //   33: astore 21
    //   35: iload 4
    //   37: istore_2
    //   38: aload 18
    //   40: astore 22
    //   42: aload 28
    //   44: astore 23
    //   46: aload 29
    //   48: astore 17
    //   50: aload 20
    //   52: astore 19
    //   54: aload_0
    //   55: invokevirtual 268	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:createUrl	()Ljava/net/URL;
    //   58: astore 30
    //   60: iload_3
    //   61: istore_1
    //   62: aload 27
    //   64: astore 21
    //   66: iload 4
    //   68: istore_2
    //   69: aload 18
    //   71: astore 22
    //   73: aload 28
    //   75: astore 23
    //   77: aload 29
    //   79: astore 17
    //   81: aload 20
    //   83: astore 19
    //   85: aload 30
    //   87: invokevirtual 272	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   90: checkcast 274	java/net/HttpURLConnection
    //   93: astore 18
    //   95: iload_3
    //   96: istore_1
    //   97: aload 18
    //   99: astore 21
    //   101: iload 4
    //   103: istore_2
    //   104: aload 18
    //   106: astore 22
    //   108: aload 18
    //   110: astore 23
    //   112: aload 18
    //   114: astore 17
    //   116: aload 20
    //   118: astore 19
    //   120: aload_0
    //   121: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   124: aload 18
    //   126: invokevirtual 277	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   129: invokevirtual 278	java/net/URL:getHost	()Ljava/lang/String;
    //   132: invokevirtual 282	com/weiyun/sdk/job/DownloadJobContext:setServerip	(Ljava/lang/String;)V
    //   135: iload_3
    //   136: istore_1
    //   137: aload 18
    //   139: astore 21
    //   141: iload 4
    //   143: istore_2
    //   144: aload 18
    //   146: astore 22
    //   148: aload 18
    //   150: astore 23
    //   152: aload 18
    //   154: astore 17
    //   156: aload 20
    //   158: astore 19
    //   160: aload_0
    //   161: aload 18
    //   163: invokevirtual 286	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:setHttpHeader	(Ljava/net/HttpURLConnection;)V
    //   166: iload_3
    //   167: istore_1
    //   168: aload 18
    //   170: astore 21
    //   172: iload 4
    //   174: istore_2
    //   175: aload 18
    //   177: astore 22
    //   179: aload 18
    //   181: astore 23
    //   183: aload 18
    //   185: astore 17
    //   187: aload 20
    //   189: astore 19
    //   191: aload_0
    //   192: getfield 45	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mJob	Lcom/weiyun/sdk/job/BaseDownloadJob;
    //   195: invokevirtual 54	com/weiyun/sdk/job/BaseDownloadJob:isAlive	()Z
    //   198: ifne +106 -> 304
    //   201: iload_3
    //   202: istore_1
    //   203: aload 18
    //   205: astore 21
    //   207: iload 4
    //   209: istore_2
    //   210: aload 18
    //   212: astore 22
    //   214: aload 18
    //   216: astore 23
    //   218: aload 18
    //   220: astore 17
    //   222: aload 20
    //   224: astore 19
    //   226: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   229: dup
    //   230: sipush -10002
    //   233: ldc 58
    //   235: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   238: astore 20
    //   240: iconst_0
    //   241: ifeq +11 -> 252
    //   244: new 288	java/lang/NullPointerException
    //   247: dup
    //   248: invokespecial 289	java/lang/NullPointerException:<init>	()V
    //   251: athrow
    //   252: aload 20
    //   254: astore 17
    //   256: aload 18
    //   258: ifnull +12 -> 270
    //   261: aload 18
    //   263: invokevirtual 292	java/net/HttpURLConnection:disconnect	()V
    //   266: aload 20
    //   268: astore 17
    //   270: aload 17
    //   272: areturn
    //   273: astore 17
    //   275: ldc 10
    //   277: invokestatic 296	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   280: invokevirtual 299	java/lang/Thread:getName	()Ljava/lang/String;
    //   283: aload 17
    //   285: invokestatic 143	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   288: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   291: dup
    //   292: sipush -30017
    //   295: aload 17
    //   297: invokestatic 149	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   300: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   303: areturn
    //   304: iload_3
    //   305: istore_1
    //   306: aload 18
    //   308: astore 21
    //   310: iload 4
    //   312: istore_2
    //   313: aload 18
    //   315: astore 22
    //   317: aload 18
    //   319: astore 23
    //   321: aload 18
    //   323: astore 17
    //   325: aload 20
    //   327: astore 19
    //   329: aload 18
    //   331: invokevirtual 302	java/net/HttpURLConnection:connect	()V
    //   334: iconst_1
    //   335: istore_3
    //   336: iconst_1
    //   337: istore 5
    //   339: iload 5
    //   341: istore_1
    //   342: aload 18
    //   344: astore 21
    //   346: iload 4
    //   348: istore_2
    //   349: aload 18
    //   351: astore 22
    //   353: aload 18
    //   355: astore 23
    //   357: aload 18
    //   359: astore 17
    //   361: aload 20
    //   363: astore 19
    //   365: aload 18
    //   367: invokevirtual 305	java/net/HttpURLConnection:getResponseCode	()I
    //   370: istore 8
    //   372: iconst_1
    //   373: istore 4
    //   375: iconst_1
    //   376: istore 6
    //   378: iload 8
    //   380: sipush 200
    //   383: if_icmpeq +209 -> 592
    //   386: iload 8
    //   388: sipush 206
    //   391: if_icmpeq +201 -> 592
    //   394: iload 5
    //   396: istore_1
    //   397: aload 18
    //   399: astore 21
    //   401: iload 6
    //   403: istore_2
    //   404: aload 18
    //   406: astore 22
    //   408: aload 18
    //   410: astore 23
    //   412: aload 18
    //   414: astore 17
    //   416: aload 20
    //   418: astore 19
    //   420: aload 18
    //   422: ldc_w 307
    //   425: invokevirtual 311	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   428: astore 28
    //   430: aload 28
    //   432: ifnull +160 -> 592
    //   435: iload 5
    //   437: istore_1
    //   438: aload 18
    //   440: astore 21
    //   442: iload 6
    //   444: istore_2
    //   445: aload 18
    //   447: astore 22
    //   449: aload 18
    //   451: astore 23
    //   453: aload 18
    //   455: astore 17
    //   457: aload 20
    //   459: astore 19
    //   461: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   464: dup
    //   465: aload 28
    //   467: invokestatic 317	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   470: ldc_w 319
    //   473: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   476: astore 27
    //   478: iconst_0
    //   479: ifeq +11 -> 490
    //   482: new 288	java/lang/NullPointerException
    //   485: dup
    //   486: invokespecial 289	java/lang/NullPointerException:<init>	()V
    //   489: athrow
    //   490: aload 27
    //   492: astore 17
    //   494: aload 18
    //   496: ifnull -226 -> 270
    //   499: aload 18
    //   501: invokevirtual 292	java/net/HttpURLConnection:disconnect	()V
    //   504: aload 27
    //   506: areturn
    //   507: astore 17
    //   509: ldc 10
    //   511: invokestatic 296	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   514: invokevirtual 299	java/lang/Thread:getName	()Ljava/lang/String;
    //   517: aload 17
    //   519: invokestatic 143	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   522: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   525: dup
    //   526: sipush -30017
    //   529: aload 17
    //   531: invokestatic 149	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   534: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   537: areturn
    //   538: astore 17
    //   540: iload 5
    //   542: istore_1
    //   543: aload 18
    //   545: astore 21
    //   547: iload 6
    //   549: istore_2
    //   550: aload 18
    //   552: astore 22
    //   554: aload 18
    //   556: astore 23
    //   558: aload 18
    //   560: astore 17
    //   562: aload 20
    //   564: astore 19
    //   566: ldc 10
    //   568: new 95	java/lang/StringBuilder
    //   571: dup
    //   572: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   575: ldc_w 321
    //   578: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload 28
    //   583: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokestatic 158	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   592: iload 8
    //   594: sipush 200
    //   597: if_icmpeq +185 -> 782
    //   600: iload 8
    //   602: sipush 206
    //   605: if_icmpeq +177 -> 782
    //   608: iload 5
    //   610: istore_1
    //   611: aload 18
    //   613: astore 21
    //   615: iload 6
    //   617: istore_2
    //   618: aload 18
    //   620: astore 22
    //   622: aload 18
    //   624: astore 23
    //   626: aload 18
    //   628: astore 17
    //   630: aload 20
    //   632: astore 19
    //   634: ldc 10
    //   636: new 95	java/lang/StringBuilder
    //   639: dup
    //   640: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   643: ldc_w 323
    //   646: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: aload_0
    //   650: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   653: invokevirtual 326	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   656: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: ldc_w 328
    //   662: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: iload 8
    //   667: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   670: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokestatic 158	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   676: iload 5
    //   678: istore_1
    //   679: aload 18
    //   681: astore 21
    //   683: iload 6
    //   685: istore_2
    //   686: aload 18
    //   688: astore 22
    //   690: aload 18
    //   692: astore 23
    //   694: aload 18
    //   696: astore 17
    //   698: aload 20
    //   700: astore 19
    //   702: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   705: dup
    //   706: iload 8
    //   708: sipush 30000
    //   711: isub
    //   712: iload 8
    //   714: invokestatic 337	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   717: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   720: astore 20
    //   722: iconst_0
    //   723: ifeq +11 -> 734
    //   726: new 288	java/lang/NullPointerException
    //   729: dup
    //   730: invokespecial 289	java/lang/NullPointerException:<init>	()V
    //   733: athrow
    //   734: aload 20
    //   736: astore 17
    //   738: aload 18
    //   740: ifnull -470 -> 270
    //   743: aload 18
    //   745: invokevirtual 292	java/net/HttpURLConnection:disconnect	()V
    //   748: aload 20
    //   750: areturn
    //   751: astore 17
    //   753: ldc 10
    //   755: invokestatic 296	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   758: invokevirtual 299	java/lang/Thread:getName	()Ljava/lang/String;
    //   761: aload 17
    //   763: invokestatic 143	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   766: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   769: dup
    //   770: sipush -30017
    //   773: aload 17
    //   775: invokestatic 149	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   778: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   781: areturn
    //   782: iload 5
    //   784: istore_1
    //   785: aload 18
    //   787: astore 21
    //   789: iload 6
    //   791: istore_2
    //   792: aload 18
    //   794: astore 22
    //   796: aload 18
    //   798: astore 23
    //   800: aload 18
    //   802: astore 17
    //   804: aload 20
    //   806: astore 19
    //   808: new 95	java/lang/StringBuilder
    //   811: dup
    //   812: ldc_w 339
    //   815: invokespecial 341	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   818: aload_0
    //   819: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   822: invokevirtual 326	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   825: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: ldc_w 343
    //   831: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: aload 30
    //   836: invokevirtual 344	java/net/URL:toString	()Ljava/lang/String;
    //   839: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: ldc_w 346
    //   845: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: aload_0
    //   849: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   852: invokevirtual 156	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   855: invokevirtual 105	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   858: ldc_w 348
    //   861: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: aload 18
    //   866: invokevirtual 351	java/net/HttpURLConnection:getContentLength	()I
    //   869: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   872: pop
    //   873: ldc2_w 352
    //   876: lstore 13
    //   878: ldc2_w 352
    //   881: lstore 9
    //   883: iload 5
    //   885: istore_1
    //   886: aload 18
    //   888: astore 21
    //   890: iload 6
    //   892: istore_2
    //   893: aload 18
    //   895: astore 22
    //   897: aload 18
    //   899: astore 23
    //   901: aload 18
    //   903: astore 17
    //   905: aload 20
    //   907: astore 19
    //   909: aload 18
    //   911: ldc_w 355
    //   914: invokevirtual 311	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   917: astore 27
    //   919: lload 13
    //   921: lstore 11
    //   923: aload 27
    //   925: ifnull +36 -> 961
    //   928: iload 5
    //   930: istore_1
    //   931: aload 18
    //   933: astore 21
    //   935: iload 6
    //   937: istore_2
    //   938: aload 18
    //   940: astore 22
    //   942: aload 18
    //   944: astore 23
    //   946: aload 18
    //   948: astore 17
    //   950: aload 20
    //   952: astore 19
    //   954: aload 27
    //   956: invokestatic 361	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   959: lstore 11
    //   961: iload 5
    //   963: istore_1
    //   964: aload 18
    //   966: astore 21
    //   968: iload 6
    //   970: istore_2
    //   971: aload 18
    //   973: astore 22
    //   975: aload 18
    //   977: astore 23
    //   979: aload 18
    //   981: astore 17
    //   983: aload 20
    //   985: astore 19
    //   987: aload 18
    //   989: ldc_w 363
    //   992: invokevirtual 311	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   995: astore 27
    //   997: lload 9
    //   999: lstore 13
    //   1001: aload 27
    //   1003: ifnull +78 -> 1081
    //   1006: iload 5
    //   1008: istore_1
    //   1009: aload 18
    //   1011: astore 21
    //   1013: iload 6
    //   1015: istore_2
    //   1016: aload 18
    //   1018: astore 22
    //   1020: aload 18
    //   1022: astore 23
    //   1024: aload 18
    //   1026: astore 17
    //   1028: aload 20
    //   1030: astore 19
    //   1032: aload 27
    //   1034: ldc_w 365
    //   1037: invokevirtual 368	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1040: istore 7
    //   1042: iload 5
    //   1044: istore_1
    //   1045: aload 18
    //   1047: astore 21
    //   1049: iload 6
    //   1051: istore_2
    //   1052: aload 18
    //   1054: astore 22
    //   1056: aload 18
    //   1058: astore 17
    //   1060: aload 20
    //   1062: astore 19
    //   1064: aload 27
    //   1066: iload 7
    //   1068: iconst_1
    //   1069: iadd
    //   1070: invokevirtual 371	java/lang/String:substring	(I)Ljava/lang/String;
    //   1073: invokestatic 374	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1076: invokevirtual 377	java/lang/Long:longValue	()J
    //   1079: lstore 13
    //   1081: ldc2_w 352
    //   1084: lstore 15
    //   1086: iload 8
    //   1088: sipush 200
    //   1091: if_icmpne +759 -> 1850
    //   1094: lload 11
    //   1096: lconst_0
    //   1097: lcmp
    //   1098: ifle +752 -> 1850
    //   1101: lload 11
    //   1103: lstore 9
    //   1105: lload 9
    //   1107: lconst_0
    //   1108: lcmp
    //   1109: ifle +909 -> 2018
    //   1112: iload 5
    //   1114: istore_1
    //   1115: aload 18
    //   1117: astore 21
    //   1119: iload 6
    //   1121: istore_2
    //   1122: aload 18
    //   1124: astore 22
    //   1126: aload 18
    //   1128: astore 23
    //   1130: aload 18
    //   1132: astore 17
    //   1134: aload 20
    //   1136: astore 19
    //   1138: aload_0
    //   1139: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1142: invokevirtual 260	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   1145: lconst_0
    //   1146: lcmp
    //   1147: ifgt +871 -> 2018
    //   1150: iload 5
    //   1152: istore_1
    //   1153: aload 18
    //   1155: astore 21
    //   1157: iload 6
    //   1159: istore_2
    //   1160: aload 18
    //   1162: astore 22
    //   1164: aload 18
    //   1166: astore 23
    //   1168: aload 18
    //   1170: astore 17
    //   1172: aload 20
    //   1174: astore 19
    //   1176: aload_0
    //   1177: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1180: lload 9
    //   1182: invokevirtual 380	com/weiyun/sdk/job/DownloadJobContext:setTotalSize	(J)V
    //   1185: lload 11
    //   1187: lconst_0
    //   1188: lcmp
    //   1189: ifne +1621 -> 2810
    //   1192: iload 5
    //   1194: istore_1
    //   1195: aload 18
    //   1197: astore 21
    //   1199: iload 6
    //   1201: istore_2
    //   1202: aload 18
    //   1204: astore 22
    //   1206: aload 18
    //   1208: astore 23
    //   1210: aload 18
    //   1212: astore 17
    //   1214: aload 20
    //   1216: astore 19
    //   1218: ldc 10
    //   1220: new 95	java/lang/StringBuilder
    //   1223: dup
    //   1224: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1227: ldc_w 382
    //   1230: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: aload_0
    //   1234: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1237: invokevirtual 326	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   1240: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: ldc_w 384
    //   1246: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1252: invokestatic 158	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1255: iload 5
    //   1257: istore_1
    //   1258: aload 18
    //   1260: astore 21
    //   1262: iload 6
    //   1264: istore_2
    //   1265: aload 18
    //   1267: astore 22
    //   1269: aload 18
    //   1271: astore 23
    //   1273: aload 18
    //   1275: astore 17
    //   1277: aload 20
    //   1279: astore 19
    //   1281: aload_0
    //   1282: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1285: invokevirtual 260	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   1288: lconst_0
    //   1289: lcmp
    //   1290: ifle +1314 -> 2604
    //   1293: iload 5
    //   1295: istore_1
    //   1296: aload 18
    //   1298: astore 21
    //   1300: iload 6
    //   1302: istore_2
    //   1303: aload 18
    //   1305: astore 22
    //   1307: aload 18
    //   1309: astore 23
    //   1311: aload 18
    //   1313: astore 17
    //   1315: aload 20
    //   1317: astore 19
    //   1319: aload_0
    //   1320: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1323: invokevirtual 260	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   1326: aload_0
    //   1327: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1330: invokevirtual 156	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1333: lcmp
    //   1334: ifgt +1270 -> 2604
    //   1337: iload 5
    //   1339: istore_1
    //   1340: aload 18
    //   1342: astore 21
    //   1344: iload 6
    //   1346: istore_2
    //   1347: aload 18
    //   1349: astore 22
    //   1351: aload 18
    //   1353: astore 23
    //   1355: aload 18
    //   1357: astore 17
    //   1359: aload 20
    //   1361: astore 19
    //   1363: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1366: dup
    //   1367: iconst_0
    //   1368: aconst_null
    //   1369: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1372: astore 20
    //   1374: iconst_0
    //   1375: ifeq +11 -> 1386
    //   1378: new 288	java/lang/NullPointerException
    //   1381: dup
    //   1382: invokespecial 289	java/lang/NullPointerException:<init>	()V
    //   1385: athrow
    //   1386: aload 20
    //   1388: astore 17
    //   1390: aload 18
    //   1392: ifnull -1122 -> 270
    //   1395: aload 18
    //   1397: invokevirtual 292	java/net/HttpURLConnection:disconnect	()V
    //   1400: aload 20
    //   1402: areturn
    //   1403: astore 17
    //   1405: ldc 10
    //   1407: invokestatic 296	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1410: invokevirtual 299	java/lang/Thread:getName	()Ljava/lang/String;
    //   1413: aload 17
    //   1415: invokestatic 143	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1418: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1421: dup
    //   1422: sipush -30017
    //   1425: aload 17
    //   1427: invokestatic 149	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1430: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1433: areturn
    //   1434: astore 17
    //   1436: iload 5
    //   1438: istore_1
    //   1439: aload 18
    //   1441: astore 21
    //   1443: iload 6
    //   1445: istore_2
    //   1446: aload 18
    //   1448: astore 22
    //   1450: aload 18
    //   1452: astore 23
    //   1454: aload 18
    //   1456: astore 17
    //   1458: aload 20
    //   1460: astore 19
    //   1462: ldc 10
    //   1464: new 95	java/lang/StringBuilder
    //   1467: dup
    //   1468: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1471: ldc_w 386
    //   1474: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1477: aload 27
    //   1479: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1482: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1485: invokestatic 388	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1488: lload 13
    //   1490: lstore 11
    //   1492: goto -531 -> 961
    //   1495: astore 17
    //   1497: aload 25
    //   1499: astore 20
    //   1501: aload 21
    //   1503: astore 18
    //   1505: aload 17
    //   1507: astore 21
    //   1509: aload 18
    //   1511: astore 17
    //   1513: aload 20
    //   1515: astore 19
    //   1517: ldc 10
    //   1519: new 95	java/lang/StringBuilder
    //   1522: dup
    //   1523: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1526: ldc_w 323
    //   1529: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: aload_0
    //   1533: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1536: invokevirtual 391	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   1539: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1542: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1545: aload 21
    //   1547: invokestatic 143	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1550: aload 18
    //   1552: astore 17
    //   1554: aload 20
    //   1556: astore 19
    //   1558: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1561: dup
    //   1562: aload 21
    //   1564: invokestatic 397	com/weiyun/sdk/util/ErrCodeUtil:getErrCodeFromIOException	(Ljava/io/IOException;)I
    //   1567: aload 21
    //   1569: invokestatic 149	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1572: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1575: astore 21
    //   1577: aload 18
    //   1579: astore 17
    //   1581: aload 20
    //   1583: astore 19
    //   1585: aload 21
    //   1587: getfield 77	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1590: sipush -30002
    //   1593: if_icmpne +1562 -> 3155
    //   1596: iload_1
    //   1597: ifne +1558 -> 3155
    //   1600: aload 18
    //   1602: astore 17
    //   1604: aload 20
    //   1606: astore 19
    //   1608: aload 21
    //   1610: sipush -30028
    //   1613: putfield 77	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1616: aload 20
    //   1618: ifnull +8 -> 1626
    //   1621: aload 20
    //   1623: invokevirtual 402	java/io/InputStream:close	()V
    //   1626: aload 21
    //   1628: astore 17
    //   1630: aload 18
    //   1632: ifnull -1362 -> 270
    //   1635: aload 18
    //   1637: invokevirtual 292	java/net/HttpURLConnection:disconnect	()V
    //   1640: aload 21
    //   1642: areturn
    //   1643: astore 17
    //   1645: ldc 10
    //   1647: invokestatic 296	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1650: invokevirtual 299	java/lang/Thread:getName	()Ljava/lang/String;
    //   1653: aload 17
    //   1655: invokestatic 143	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1658: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1661: dup
    //   1662: sipush -30017
    //   1665: aload 17
    //   1667: invokestatic 149	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1670: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1673: areturn
    //   1674: astore 27
    //   1676: iload 5
    //   1678: istore_1
    //   1679: aload 18
    //   1681: astore 21
    //   1683: iload 6
    //   1685: istore_2
    //   1686: aload 18
    //   1688: astore 22
    //   1690: aload 18
    //   1692: astore 23
    //   1694: aload 18
    //   1696: astore 17
    //   1698: aload 20
    //   1700: astore 19
    //   1702: ldc 10
    //   1704: aload 27
    //   1706: invokestatic 250	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1709: lload 9
    //   1711: lstore 13
    //   1713: goto -632 -> 1081
    //   1716: astore 21
    //   1718: aload 26
    //   1720: astore 20
    //   1722: aload 22
    //   1724: astore 18
    //   1726: aload 18
    //   1728: astore 17
    //   1730: aload 20
    //   1732: astore 19
    //   1734: ldc 10
    //   1736: new 95	java/lang/StringBuilder
    //   1739: dup
    //   1740: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1743: ldc_w 323
    //   1746: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1749: aload_0
    //   1750: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1753: invokevirtual 391	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   1756: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1759: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1762: aload 21
    //   1764: invokestatic 143	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1767: aload 18
    //   1769: astore 17
    //   1771: aload 20
    //   1773: astore 19
    //   1775: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1778: dup
    //   1779: sipush -10002
    //   1782: aload 21
    //   1784: invokestatic 149	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1787: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1790: astore 21
    //   1792: aload 20
    //   1794: ifnull +8 -> 1802
    //   1797: aload 20
    //   1799: invokevirtual 402	java/io/InputStream:close	()V
    //   1802: aload 21
    //   1804: astore 17
    //   1806: aload 18
    //   1808: ifnull -1538 -> 270
    //   1811: aload 18
    //   1813: invokevirtual 292	java/net/HttpURLConnection:disconnect	()V
    //   1816: aload 21
    //   1818: areturn
    //   1819: astore 17
    //   1821: ldc 10
    //   1823: invokestatic 296	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1826: invokevirtual 299	java/lang/Thread:getName	()Ljava/lang/String;
    //   1829: aload 17
    //   1831: invokestatic 143	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1834: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1837: dup
    //   1838: sipush -30017
    //   1841: aload 17
    //   1843: invokestatic 149	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1846: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1849: areturn
    //   1850: iload 8
    //   1852: sipush 206
    //   1855: if_icmpne +17 -> 1872
    //   1858: lload 13
    //   1860: lconst_0
    //   1861: lcmp
    //   1862: ifle +10 -> 1872
    //   1865: lload 13
    //   1867: lstore 9
    //   1869: goto -764 -> 1105
    //   1872: iload 5
    //   1874: istore_1
    //   1875: aload 18
    //   1877: astore 21
    //   1879: iload 6
    //   1881: istore_2
    //   1882: aload 18
    //   1884: astore 22
    //   1886: aload 18
    //   1888: astore 23
    //   1890: aload 18
    //   1892: astore 17
    //   1894: aload 20
    //   1896: astore 19
    //   1898: ldc 10
    //   1900: new 95	java/lang/StringBuilder
    //   1903: dup
    //   1904: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1907: ldc_w 404
    //   1910: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1913: iload 8
    //   1915: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1918: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1921: invokestatic 158	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1924: lload 15
    //   1926: lstore 9
    //   1928: iload 5
    //   1930: istore_1
    //   1931: aload 18
    //   1933: astore 21
    //   1935: iload 6
    //   1937: istore_2
    //   1938: aload 18
    //   1940: astore 22
    //   1942: aload 18
    //   1944: astore 23
    //   1946: aload 18
    //   1948: astore 17
    //   1950: aload 20
    //   1952: astore 19
    //   1954: aload_0
    //   1955: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1958: invokevirtual 260	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   1961: lconst_0
    //   1962: lcmp
    //   1963: ifgt -858 -> 1105
    //   1966: lload 15
    //   1968: lstore 9
    //   1970: lload 11
    //   1972: lconst_0
    //   1973: lcmp
    //   1974: ifle -869 -> 1105
    //   1977: iload 5
    //   1979: istore_1
    //   1980: aload 18
    //   1982: astore 21
    //   1984: iload 6
    //   1986: istore_2
    //   1987: aload 18
    //   1989: astore 22
    //   1991: aload 18
    //   1993: astore 23
    //   1995: aload 18
    //   1997: astore 17
    //   1999: aload 20
    //   2001: astore 19
    //   2003: aload_0
    //   2004: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2007: invokevirtual 156	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   2010: lload 11
    //   2012: ladd
    //   2013: lstore 9
    //   2015: goto -910 -> 1105
    //   2018: lload 9
    //   2020: lconst_0
    //   2021: lcmp
    //   2022: ifle +476 -> 2498
    //   2025: iload 5
    //   2027: istore_1
    //   2028: aload 18
    //   2030: astore 21
    //   2032: iload 6
    //   2034: istore_2
    //   2035: aload 18
    //   2037: astore 22
    //   2039: aload 18
    //   2041: astore 23
    //   2043: aload 18
    //   2045: astore 17
    //   2047: aload 20
    //   2049: astore 19
    //   2051: aload_0
    //   2052: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2055: invokevirtual 260	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   2058: lload 9
    //   2060: lcmp
    //   2061: ifeq +437 -> 2498
    //   2064: iload 5
    //   2066: istore_1
    //   2067: aload 18
    //   2069: astore 21
    //   2071: iload 6
    //   2073: istore_2
    //   2074: aload 18
    //   2076: astore 22
    //   2078: aload 18
    //   2080: astore 23
    //   2082: aload 18
    //   2084: astore 17
    //   2086: aload 20
    //   2088: astore 19
    //   2090: aload_0
    //   2091: invokevirtual 254	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:isSupportContinueInterruption	()Z
    //   2094: ifeq +82 -> 2176
    //   2097: iload 5
    //   2099: istore_1
    //   2100: aload 18
    //   2102: astore 21
    //   2104: iload 6
    //   2106: istore_2
    //   2107: aload 18
    //   2109: astore 22
    //   2111: aload 18
    //   2113: astore 23
    //   2115: aload 18
    //   2117: astore 17
    //   2119: aload 20
    //   2121: astore 19
    //   2123: ldc 10
    //   2125: new 95	java/lang/StringBuilder
    //   2128: dup
    //   2129: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2132: ldc_w 406
    //   2135: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2138: aload_0
    //   2139: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2142: invokevirtual 260	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   2145: invokevirtual 105	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2148: ldc_w 408
    //   2151: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2154: lload 11
    //   2156: invokevirtual 105	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2159: ldc_w 410
    //   2162: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2165: lload 13
    //   2167: invokevirtual 105	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2170: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2173: invokestatic 158	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2176: iload 5
    //   2178: istore_1
    //   2179: aload 18
    //   2181: astore 21
    //   2183: iload 6
    //   2185: istore_2
    //   2186: aload 18
    //   2188: astore 22
    //   2190: aload 18
    //   2192: astore 23
    //   2194: aload 18
    //   2196: astore 17
    //   2198: aload 20
    //   2200: astore 19
    //   2202: aload_0
    //   2203: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2206: invokevirtual 156	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   2209: lconst_0
    //   2210: lcmp
    //   2211: ifne +216 -> 2427
    //   2214: lload 9
    //   2216: lload 11
    //   2218: lcmp
    //   2219: ifne +208 -> 2427
    //   2222: iload 5
    //   2224: istore_1
    //   2225: aload 18
    //   2227: astore 21
    //   2229: iload 6
    //   2231: istore_2
    //   2232: aload 18
    //   2234: astore 22
    //   2236: aload 18
    //   2238: astore 23
    //   2240: aload 18
    //   2242: astore 17
    //   2244: aload 20
    //   2246: astore 19
    //   2248: aload_0
    //   2249: invokevirtual 136	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:isSupportSplitDownload	()Z
    //   2252: ifne +175 -> 2427
    //   2255: iload 5
    //   2257: istore_1
    //   2258: aload 18
    //   2260: astore 21
    //   2262: iload 6
    //   2264: istore_2
    //   2265: aload 18
    //   2267: astore 22
    //   2269: aload 18
    //   2271: astore 23
    //   2273: aload 18
    //   2275: astore 17
    //   2277: aload 20
    //   2279: astore 19
    //   2281: aload_0
    //   2282: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2285: lload 9
    //   2287: invokevirtual 380	com/weiyun/sdk/job/DownloadJobContext:setTotalSize	(J)V
    //   2290: goto -1105 -> 1185
    //   2293: astore 21
    //   2295: aload 24
    //   2297: astore 20
    //   2299: aload 23
    //   2301: astore 18
    //   2303: aload 18
    //   2305: astore 17
    //   2307: aload 20
    //   2309: astore 19
    //   2311: ldc 10
    //   2313: new 95	java/lang/StringBuilder
    //   2316: dup
    //   2317: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2320: ldc_w 323
    //   2323: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2326: aload_0
    //   2327: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2330: invokevirtual 391	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   2333: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2336: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2339: aload 21
    //   2341: invokestatic 143	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2344: aload 18
    //   2346: astore 17
    //   2348: aload 20
    //   2350: astore 19
    //   2352: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2355: dup
    //   2356: sipush -10014
    //   2359: aload 21
    //   2361: invokestatic 149	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2364: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2367: astore 21
    //   2369: aload 20
    //   2371: ifnull +8 -> 2379
    //   2374: aload 20
    //   2376: invokevirtual 402	java/io/InputStream:close	()V
    //   2379: aload 21
    //   2381: astore 17
    //   2383: aload 18
    //   2385: ifnull -2115 -> 270
    //   2388: aload 18
    //   2390: invokevirtual 292	java/net/HttpURLConnection:disconnect	()V
    //   2393: aload 21
    //   2395: areturn
    //   2396: astore 17
    //   2398: ldc 10
    //   2400: invokestatic 296	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2403: invokevirtual 299	java/lang/Thread:getName	()Ljava/lang/String;
    //   2406: aload 17
    //   2408: invokestatic 143	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2411: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2414: dup
    //   2415: sipush -30017
    //   2418: aload 17
    //   2420: invokestatic 149	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2423: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2426: areturn
    //   2427: lload 9
    //   2429: lload 13
    //   2431: lcmp
    //   2432: ifne -1247 -> 1185
    //   2435: iload 5
    //   2437: istore_1
    //   2438: aload 18
    //   2440: astore 21
    //   2442: iload 6
    //   2444: istore_2
    //   2445: aload 18
    //   2447: astore 22
    //   2449: aload 18
    //   2451: astore 23
    //   2453: aload 18
    //   2455: astore 17
    //   2457: aload 20
    //   2459: astore 19
    //   2461: aload_0
    //   2462: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2465: lload 9
    //   2467: invokevirtual 380	com/weiyun/sdk/job/DownloadJobContext:setTotalSize	(J)V
    //   2470: goto -1285 -> 1185
    //   2473: astore 18
    //   2475: aload 19
    //   2477: ifnull +8 -> 2485
    //   2480: aload 19
    //   2482: invokevirtual 402	java/io/InputStream:close	()V
    //   2485: aload 17
    //   2487: ifnull +8 -> 2495
    //   2490: aload 17
    //   2492: invokevirtual 292	java/net/HttpURLConnection:disconnect	()V
    //   2495: aload 18
    //   2497: athrow
    //   2498: lload 9
    //   2500: lconst_0
    //   2501: lcmp
    //   2502: ifge -1317 -> 1185
    //   2505: iload 5
    //   2507: istore_1
    //   2508: aload 18
    //   2510: astore 21
    //   2512: iload 6
    //   2514: istore_2
    //   2515: aload 18
    //   2517: astore 22
    //   2519: aload 18
    //   2521: astore 23
    //   2523: aload 18
    //   2525: astore 17
    //   2527: aload 20
    //   2529: astore 19
    //   2531: ldc 10
    //   2533: new 95	java/lang/StringBuilder
    //   2536: dup
    //   2537: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2540: ldc_w 412
    //   2543: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2546: aload_0
    //   2547: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2550: invokevirtual 326	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   2553: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2556: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2559: invokestatic 158	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2562: iload 5
    //   2564: istore_1
    //   2565: aload 18
    //   2567: astore 21
    //   2569: iload 6
    //   2571: istore_2
    //   2572: aload 18
    //   2574: astore 22
    //   2576: aload 18
    //   2578: astore 23
    //   2580: aload 18
    //   2582: astore 17
    //   2584: aload 20
    //   2586: astore 19
    //   2588: ldc 10
    //   2590: aload 18
    //   2592: invokevirtual 416	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   2595: invokevirtual 417	java/lang/Object:toString	()Ljava/lang/String;
    //   2598: invokestatic 121	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2601: goto -1416 -> 1185
    //   2604: iload 8
    //   2606: sipush 206
    //   2609: if_icmpne +102 -> 2711
    //   2612: iload 5
    //   2614: istore_1
    //   2615: aload 18
    //   2617: astore 21
    //   2619: iload 6
    //   2621: istore_2
    //   2622: aload 18
    //   2624: astore 22
    //   2626: aload 18
    //   2628: astore 23
    //   2630: aload 18
    //   2632: astore 17
    //   2634: aload 20
    //   2636: astore 19
    //   2638: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2641: dup
    //   2642: sipush -29005
    //   2645: aconst_null
    //   2646: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2649: astore 20
    //   2651: iconst_0
    //   2652: ifeq +11 -> 2663
    //   2655: new 288	java/lang/NullPointerException
    //   2658: dup
    //   2659: invokespecial 289	java/lang/NullPointerException:<init>	()V
    //   2662: athrow
    //   2663: aload 20
    //   2665: astore 17
    //   2667: aload 18
    //   2669: ifnull -2399 -> 270
    //   2672: aload 18
    //   2674: invokevirtual 292	java/net/HttpURLConnection:disconnect	()V
    //   2677: aload 20
    //   2679: areturn
    //   2680: astore 17
    //   2682: ldc 10
    //   2684: invokestatic 296	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2687: invokevirtual 299	java/lang/Thread:getName	()Ljava/lang/String;
    //   2690: aload 17
    //   2692: invokestatic 143	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2695: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2698: dup
    //   2699: sipush -30017
    //   2702: aload 17
    //   2704: invokestatic 149	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2707: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2710: areturn
    //   2711: iload 5
    //   2713: istore_1
    //   2714: aload 18
    //   2716: astore 21
    //   2718: iload 6
    //   2720: istore_2
    //   2721: aload 18
    //   2723: astore 22
    //   2725: aload 18
    //   2727: astore 23
    //   2729: aload 18
    //   2731: astore 17
    //   2733: aload 20
    //   2735: astore 19
    //   2737: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2740: dup
    //   2741: sipush -29001
    //   2744: aconst_null
    //   2745: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2748: astore 20
    //   2750: iconst_0
    //   2751: ifeq +11 -> 2762
    //   2754: new 288	java/lang/NullPointerException
    //   2757: dup
    //   2758: invokespecial 289	java/lang/NullPointerException:<init>	()V
    //   2761: athrow
    //   2762: aload 20
    //   2764: astore 17
    //   2766: aload 18
    //   2768: ifnull -2498 -> 270
    //   2771: aload 18
    //   2773: invokevirtual 292	java/net/HttpURLConnection:disconnect	()V
    //   2776: aload 20
    //   2778: areturn
    //   2779: astore 17
    //   2781: ldc 10
    //   2783: invokestatic 296	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2786: invokevirtual 299	java/lang/Thread:getName	()Ljava/lang/String;
    //   2789: aload 17
    //   2791: invokestatic 143	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2794: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2797: dup
    //   2798: sipush -30017
    //   2801: aload 17
    //   2803: invokestatic 149	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2806: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2809: areturn
    //   2810: iload 5
    //   2812: istore_1
    //   2813: aload 18
    //   2815: astore 21
    //   2817: iload 6
    //   2819: istore_2
    //   2820: aload 18
    //   2822: astore 22
    //   2824: aload 18
    //   2826: astore 23
    //   2828: aload 18
    //   2830: astore 17
    //   2832: aload 20
    //   2834: astore 19
    //   2836: aload_0
    //   2837: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2840: invokevirtual 156	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   2843: lstore 9
    //   2845: iload 5
    //   2847: istore_1
    //   2848: aload 18
    //   2850: astore 21
    //   2852: iload 6
    //   2854: istore_2
    //   2855: aload 18
    //   2857: astore 22
    //   2859: aload 18
    //   2861: astore 23
    //   2863: aload 18
    //   2865: astore 17
    //   2867: aload 20
    //   2869: astore 19
    //   2871: new 419	java/io/BufferedInputStream
    //   2874: dup
    //   2875: aload 18
    //   2877: invokevirtual 423	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2880: invokespecial 426	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   2883: astore 20
    //   2885: aload_0
    //   2886: aload 20
    //   2888: invokevirtual 430	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:readHttpContent	(Ljava/io/InputStream;)I
    //   2891: istore_2
    //   2892: iload_2
    //   2893: istore_1
    //   2894: iload_2
    //   2895: sipush -10002
    //   2898: if_icmpne +31 -> 2929
    //   2901: iload_2
    //   2902: istore_1
    //   2903: aload_0
    //   2904: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2907: invokevirtual 156	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   2910: lload 9
    //   2912: lsub
    //   2913: lload 11
    //   2915: lcmp
    //   2916: ifne +13 -> 2929
    //   2919: ldc 10
    //   2921: ldc_w 432
    //   2924: invokestatic 121	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2927: iconst_0
    //   2928: istore_1
    //   2929: iload_1
    //   2930: ifne +160 -> 3090
    //   2933: aload_0
    //   2934: invokevirtual 136	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:isSupportSplitDownload	()Z
    //   2937: ifeq +153 -> 3090
    //   2940: aload_0
    //   2941: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2944: invokevirtual 156	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   2947: aload_0
    //   2948: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2951: invokevirtual 260	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   2954: lcmp
    //   2955: iflt +68 -> 3023
    //   2958: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2961: dup
    //   2962: iconst_0
    //   2963: aconst_null
    //   2964: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2967: astore 17
    //   2969: aload 20
    //   2971: ifnull +8 -> 2979
    //   2974: aload 20
    //   2976: invokevirtual 402	java/io/InputStream:close	()V
    //   2979: aload 18
    //   2981: ifnull +8 -> 2989
    //   2984: aload 18
    //   2986: invokevirtual 292	java/net/HttpURLConnection:disconnect	()V
    //   2989: aload 17
    //   2991: areturn
    //   2992: astore 17
    //   2994: ldc 10
    //   2996: invokestatic 296	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2999: invokevirtual 299	java/lang/Thread:getName	()Ljava/lang/String;
    //   3002: aload 17
    //   3004: invokestatic 143	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3007: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   3010: dup
    //   3011: sipush -30017
    //   3014: aload 17
    //   3016: invokestatic 149	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3019: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   3022: areturn
    //   3023: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   3026: dup
    //   3027: sipush -10020
    //   3030: aconst_null
    //   3031: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   3034: astore 17
    //   3036: aload 20
    //   3038: ifnull +8 -> 3046
    //   3041: aload 20
    //   3043: invokevirtual 402	java/io/InputStream:close	()V
    //   3046: aload 18
    //   3048: ifnull +8 -> 3056
    //   3051: aload 18
    //   3053: invokevirtual 292	java/net/HttpURLConnection:disconnect	()V
    //   3056: aload 17
    //   3058: areturn
    //   3059: astore 17
    //   3061: ldc 10
    //   3063: invokestatic 296	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3066: invokevirtual 299	java/lang/Thread:getName	()Ljava/lang/String;
    //   3069: aload 17
    //   3071: invokestatic 143	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3074: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   3077: dup
    //   3078: sipush -30017
    //   3081: aload 17
    //   3083: invokestatic 149	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3086: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   3089: areturn
    //   3090: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   3093: dup
    //   3094: iload_1
    //   3095: aconst_null
    //   3096: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   3099: astore 17
    //   3101: aload 20
    //   3103: ifnull +8 -> 3111
    //   3106: aload 20
    //   3108: invokevirtual 402	java/io/InputStream:close	()V
    //   3111: aload 18
    //   3113: ifnull +8 -> 3121
    //   3116: aload 18
    //   3118: invokevirtual 292	java/net/HttpURLConnection:disconnect	()V
    //   3121: aload 17
    //   3123: areturn
    //   3124: astore 17
    //   3126: ldc 10
    //   3128: invokestatic 296	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3131: invokevirtual 299	java/lang/Thread:getName	()Ljava/lang/String;
    //   3134: aload 17
    //   3136: invokestatic 143	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3139: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   3142: dup
    //   3143: sipush -30017
    //   3146: aload 17
    //   3148: invokestatic 149	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3151: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   3154: areturn
    //   3155: aload 18
    //   3157: astore 17
    //   3159: aload 20
    //   3161: astore 19
    //   3163: aload 21
    //   3165: getfield 77	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   3168: sipush -30002
    //   3171: if_icmpne -1555 -> 1616
    //   3174: iload_2
    //   3175: ifne -1559 -> 1616
    //   3178: aload 18
    //   3180: astore 17
    //   3182: aload 20
    //   3184: astore 19
    //   3186: aload 21
    //   3188: sipush -30029
    //   3191: putfield 77	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   3194: goto -1578 -> 1616
    //   3197: astore 17
    //   3199: ldc 10
    //   3201: invokestatic 296	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3204: invokevirtual 299	java/lang/Thread:getName	()Ljava/lang/String;
    //   3207: aload 17
    //   3209: invokestatic 143	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3212: new 56	com/weiyun/sdk/job/transfer/Transfer$Result
    //   3215: dup
    //   3216: sipush -30017
    //   3219: aload 17
    //   3221: invokestatic 149	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3224: invokespecial 61	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   3227: areturn
    //   3228: astore 21
    //   3230: aload 20
    //   3232: astore 19
    //   3234: aload 18
    //   3236: astore 17
    //   3238: aload 21
    //   3240: astore 18
    //   3242: goto -767 -> 2475
    //   3245: astore 21
    //   3247: goto -944 -> 2303
    //   3250: astore 21
    //   3252: goto -1526 -> 1726
    //   3255: astore 21
    //   3257: iload_3
    //   3258: istore_1
    //   3259: iload 4
    //   3261: istore_2
    //   3262: goto -1753 -> 1509
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3265	0	this	BaseDownloadTransfer
    //   30	3229	1	i	int
    //   37	3225	2	j	int
    //   25	3233	3	k	int
    //   27	3233	4	m	int
    //   337	2509	5	n	int
    //   376	2477	6	i1	int
    //   1040	30	7	i2	int
    //   370	2240	8	i3	int
    //   881	2030	9	l1	long
    //   921	1993	11	l2	long
    //   876	1554	13	l3	long
    //   1084	883	15	l4	long
    //   48	223	17	localObject1	Object
    //   273	23	17	localIOException1	IOException
    //   323	170	17	localObject2	Object
    //   507	23	17	localIOException2	IOException
    //   538	1	17	localNumberFormatException1	java.lang.NumberFormatException
    //   560	177	17	localObject3	Object
    //   751	23	17	localIOException3	IOException
    //   802	587	17	localObject4	Object
    //   1403	23	17	localIOException4	IOException
    //   1434	1	17	localNumberFormatException2	java.lang.NumberFormatException
    //   1456	1	17	localObject5	Object
    //   1495	11	17	localIOException5	IOException
    //   1511	118	17	localObject6	Object
    //   1643	23	17	localIOException6	IOException
    //   1696	109	17	localObject7	Object
    //   1819	23	17	localIOException7	IOException
    //   1892	490	17	localObject8	Object
    //   2396	23	17	localIOException8	IOException
    //   2455	211	17	localObject9	Object
    //   2680	23	17	localIOException9	IOException
    //   2731	34	17	localObject10	Object
    //   2779	23	17	localIOException10	IOException
    //   2830	160	17	localObject11	Object
    //   2992	23	17	localIOException11	IOException
    //   3034	23	17	localResult1	Transfer.Result
    //   3059	23	17	localIOException12	IOException
    //   3099	23	17	localResult2	Transfer.Result
    //   3124	23	17	localIOException13	IOException
    //   3157	24	17	localObject12	Object
    //   3197	23	17	localIOException14	IOException
    //   3236	1	17	localObject13	Object
    //   1	2453	18	localObject14	Object
    //   2473	762	18	localObject15	Object
    //   3240	1	18	localObject16	Object
    //   52	3181	19	localObject17	Object
    //   19	3212	20	localObject18	Object
    //   33	1649	21	localObject19	Object
    //   1716	67	21	localInterruptedException1	InterruptedException
    //   1790	471	21	localObject20	Object
    //   2293	67	21	localException1	java.lang.Exception
    //   2367	820	21	localObject21	Object
    //   3228	11	21	localObject22	Object
    //   3245	1	21	localException2	java.lang.Exception
    //   3250	1	21	localInterruptedException2	InterruptedException
    //   3255	1	21	localIOException15	IOException
    //   40	2818	22	localObject23	Object
    //   44	2818	23	localObject24	Object
    //   16	2280	24	localObject25	Object
    //   22	1476	25	localObject26	Object
    //   13	1706	26	localObject27	Object
    //   10	1468	27	localObject28	Object
    //   1674	31	27	localException3	java.lang.Exception
    //   4	578	28	str	String
    //   7	71	29	localObject29	Object
    //   58	777	30	localURL	URL
    // Exception table:
    //   from	to	target	type
    //   244	252	273	java/io/IOException
    //   261	266	273	java/io/IOException
    //   482	490	507	java/io/IOException
    //   499	504	507	java/io/IOException
    //   461	478	538	java/lang/NumberFormatException
    //   726	734	751	java/io/IOException
    //   743	748	751	java/io/IOException
    //   1378	1386	1403	java/io/IOException
    //   1395	1400	1403	java/io/IOException
    //   954	961	1434	java/lang/NumberFormatException
    //   54	60	1495	java/io/IOException
    //   85	95	1495	java/io/IOException
    //   120	135	1495	java/io/IOException
    //   160	166	1495	java/io/IOException
    //   191	201	1495	java/io/IOException
    //   226	240	1495	java/io/IOException
    //   329	334	1495	java/io/IOException
    //   365	372	1495	java/io/IOException
    //   420	430	1495	java/io/IOException
    //   461	478	1495	java/io/IOException
    //   566	592	1495	java/io/IOException
    //   634	676	1495	java/io/IOException
    //   702	722	1495	java/io/IOException
    //   808	873	1495	java/io/IOException
    //   909	919	1495	java/io/IOException
    //   954	961	1495	java/io/IOException
    //   987	997	1495	java/io/IOException
    //   1032	1042	1495	java/io/IOException
    //   1064	1081	1495	java/io/IOException
    //   1138	1150	1495	java/io/IOException
    //   1176	1185	1495	java/io/IOException
    //   1218	1255	1495	java/io/IOException
    //   1281	1293	1495	java/io/IOException
    //   1319	1337	1495	java/io/IOException
    //   1363	1374	1495	java/io/IOException
    //   1462	1488	1495	java/io/IOException
    //   1702	1709	1495	java/io/IOException
    //   1898	1924	1495	java/io/IOException
    //   1954	1966	1495	java/io/IOException
    //   2003	2015	1495	java/io/IOException
    //   2051	2064	1495	java/io/IOException
    //   2090	2097	1495	java/io/IOException
    //   2123	2176	1495	java/io/IOException
    //   2202	2214	1495	java/io/IOException
    //   2248	2255	1495	java/io/IOException
    //   2281	2290	1495	java/io/IOException
    //   2461	2470	1495	java/io/IOException
    //   2531	2562	1495	java/io/IOException
    //   2588	2601	1495	java/io/IOException
    //   2638	2651	1495	java/io/IOException
    //   2737	2750	1495	java/io/IOException
    //   2836	2845	1495	java/io/IOException
    //   2871	2885	1495	java/io/IOException
    //   1621	1626	1643	java/io/IOException
    //   1635	1640	1643	java/io/IOException
    //   1064	1081	1674	java/lang/Exception
    //   54	60	1716	java/lang/InterruptedException
    //   85	95	1716	java/lang/InterruptedException
    //   120	135	1716	java/lang/InterruptedException
    //   160	166	1716	java/lang/InterruptedException
    //   191	201	1716	java/lang/InterruptedException
    //   226	240	1716	java/lang/InterruptedException
    //   329	334	1716	java/lang/InterruptedException
    //   365	372	1716	java/lang/InterruptedException
    //   420	430	1716	java/lang/InterruptedException
    //   461	478	1716	java/lang/InterruptedException
    //   566	592	1716	java/lang/InterruptedException
    //   634	676	1716	java/lang/InterruptedException
    //   702	722	1716	java/lang/InterruptedException
    //   808	873	1716	java/lang/InterruptedException
    //   909	919	1716	java/lang/InterruptedException
    //   954	961	1716	java/lang/InterruptedException
    //   987	997	1716	java/lang/InterruptedException
    //   1032	1042	1716	java/lang/InterruptedException
    //   1064	1081	1716	java/lang/InterruptedException
    //   1138	1150	1716	java/lang/InterruptedException
    //   1176	1185	1716	java/lang/InterruptedException
    //   1218	1255	1716	java/lang/InterruptedException
    //   1281	1293	1716	java/lang/InterruptedException
    //   1319	1337	1716	java/lang/InterruptedException
    //   1363	1374	1716	java/lang/InterruptedException
    //   1462	1488	1716	java/lang/InterruptedException
    //   1702	1709	1716	java/lang/InterruptedException
    //   1898	1924	1716	java/lang/InterruptedException
    //   1954	1966	1716	java/lang/InterruptedException
    //   2003	2015	1716	java/lang/InterruptedException
    //   2051	2064	1716	java/lang/InterruptedException
    //   2090	2097	1716	java/lang/InterruptedException
    //   2123	2176	1716	java/lang/InterruptedException
    //   2202	2214	1716	java/lang/InterruptedException
    //   2248	2255	1716	java/lang/InterruptedException
    //   2281	2290	1716	java/lang/InterruptedException
    //   2461	2470	1716	java/lang/InterruptedException
    //   2531	2562	1716	java/lang/InterruptedException
    //   2588	2601	1716	java/lang/InterruptedException
    //   2638	2651	1716	java/lang/InterruptedException
    //   2737	2750	1716	java/lang/InterruptedException
    //   2836	2845	1716	java/lang/InterruptedException
    //   2871	2885	1716	java/lang/InterruptedException
    //   1797	1802	1819	java/io/IOException
    //   1811	1816	1819	java/io/IOException
    //   54	60	2293	java/lang/Exception
    //   85	95	2293	java/lang/Exception
    //   120	135	2293	java/lang/Exception
    //   160	166	2293	java/lang/Exception
    //   191	201	2293	java/lang/Exception
    //   226	240	2293	java/lang/Exception
    //   329	334	2293	java/lang/Exception
    //   365	372	2293	java/lang/Exception
    //   420	430	2293	java/lang/Exception
    //   461	478	2293	java/lang/Exception
    //   566	592	2293	java/lang/Exception
    //   634	676	2293	java/lang/Exception
    //   702	722	2293	java/lang/Exception
    //   808	873	2293	java/lang/Exception
    //   909	919	2293	java/lang/Exception
    //   954	961	2293	java/lang/Exception
    //   987	997	2293	java/lang/Exception
    //   1032	1042	2293	java/lang/Exception
    //   1138	1150	2293	java/lang/Exception
    //   1176	1185	2293	java/lang/Exception
    //   1218	1255	2293	java/lang/Exception
    //   1281	1293	2293	java/lang/Exception
    //   1319	1337	2293	java/lang/Exception
    //   1363	1374	2293	java/lang/Exception
    //   1462	1488	2293	java/lang/Exception
    //   1702	1709	2293	java/lang/Exception
    //   1898	1924	2293	java/lang/Exception
    //   1954	1966	2293	java/lang/Exception
    //   2003	2015	2293	java/lang/Exception
    //   2051	2064	2293	java/lang/Exception
    //   2090	2097	2293	java/lang/Exception
    //   2123	2176	2293	java/lang/Exception
    //   2202	2214	2293	java/lang/Exception
    //   2248	2255	2293	java/lang/Exception
    //   2281	2290	2293	java/lang/Exception
    //   2461	2470	2293	java/lang/Exception
    //   2531	2562	2293	java/lang/Exception
    //   2588	2601	2293	java/lang/Exception
    //   2638	2651	2293	java/lang/Exception
    //   2737	2750	2293	java/lang/Exception
    //   2836	2845	2293	java/lang/Exception
    //   2871	2885	2293	java/lang/Exception
    //   2374	2379	2396	java/io/IOException
    //   2388	2393	2396	java/io/IOException
    //   54	60	2473	finally
    //   85	95	2473	finally
    //   120	135	2473	finally
    //   160	166	2473	finally
    //   191	201	2473	finally
    //   226	240	2473	finally
    //   329	334	2473	finally
    //   365	372	2473	finally
    //   420	430	2473	finally
    //   461	478	2473	finally
    //   566	592	2473	finally
    //   634	676	2473	finally
    //   702	722	2473	finally
    //   808	873	2473	finally
    //   909	919	2473	finally
    //   954	961	2473	finally
    //   987	997	2473	finally
    //   1032	1042	2473	finally
    //   1064	1081	2473	finally
    //   1138	1150	2473	finally
    //   1176	1185	2473	finally
    //   1218	1255	2473	finally
    //   1281	1293	2473	finally
    //   1319	1337	2473	finally
    //   1363	1374	2473	finally
    //   1462	1488	2473	finally
    //   1517	1550	2473	finally
    //   1558	1577	2473	finally
    //   1585	1596	2473	finally
    //   1608	1616	2473	finally
    //   1702	1709	2473	finally
    //   1734	1767	2473	finally
    //   1775	1792	2473	finally
    //   1898	1924	2473	finally
    //   1954	1966	2473	finally
    //   2003	2015	2473	finally
    //   2051	2064	2473	finally
    //   2090	2097	2473	finally
    //   2123	2176	2473	finally
    //   2202	2214	2473	finally
    //   2248	2255	2473	finally
    //   2281	2290	2473	finally
    //   2311	2344	2473	finally
    //   2352	2369	2473	finally
    //   2461	2470	2473	finally
    //   2531	2562	2473	finally
    //   2588	2601	2473	finally
    //   2638	2651	2473	finally
    //   2737	2750	2473	finally
    //   2836	2845	2473	finally
    //   2871	2885	2473	finally
    //   3163	3174	2473	finally
    //   3186	3194	2473	finally
    //   2655	2663	2680	java/io/IOException
    //   2672	2677	2680	java/io/IOException
    //   2754	2762	2779	java/io/IOException
    //   2771	2776	2779	java/io/IOException
    //   2974	2979	2992	java/io/IOException
    //   2984	2989	2992	java/io/IOException
    //   3041	3046	3059	java/io/IOException
    //   3051	3056	3059	java/io/IOException
    //   3106	3111	3124	java/io/IOException
    //   3116	3121	3124	java/io/IOException
    //   2480	2485	3197	java/io/IOException
    //   2490	2495	3197	java/io/IOException
    //   2885	2892	3228	finally
    //   2903	2927	3228	finally
    //   2933	2969	3228	finally
    //   3023	3036	3228	finally
    //   3090	3101	3228	finally
    //   2885	2892	3245	java/lang/Exception
    //   2903	2927	3245	java/lang/Exception
    //   2933	2969	3245	java/lang/Exception
    //   3023	3036	3245	java/lang/Exception
    //   3090	3101	3245	java/lang/Exception
    //   2885	2892	3250	java/lang/InterruptedException
    //   2903	2927	3250	java/lang/InterruptedException
    //   2933	2969	3250	java/lang/InterruptedException
    //   3023	3036	3250	java/lang/InterruptedException
    //   3090	3101	3250	java/lang/InterruptedException
    //   2885	2892	3255	java/io/IOException
    //   2903	2927	3255	java/io/IOException
    //   2933	2969	3255	java/io/IOException
    //   3023	3036	3255	java/io/IOException
    //   3090	3101	3255	java/io/IOException
  }
  
  protected int getMaxTryTimes()
  {
    return 3;
  }
  
  protected long getSplitSize()
  {
    return this.mSplitSize;
  }
  
  protected boolean isSupportContinueInterruption()
  {
    return false;
  }
  
  protected boolean isSupportSplitDownload()
  {
    return false;
  }
  
  protected int moveToTarget()
  {
    Utils.checkDirAndCreate(this.mContext.getDestDirectoryPath());
    if (!new File(this.mContext.getDataFilePath()).renameTo(new File(this.mContext.getDestFilePath())))
    {
      if (Utils.checkFileExist(this.mContext.getDestFilePath()) == true)
      {
        String str = Utils.generateNewFilename(this.mContext.getDestFileName());
        this.mJob.renameDestFile(str);
      }
    }
    else {
      return 0;
    }
    Log.e("BaseDownloadTransfer", "rename to target file failed. target =" + this.mContext.getDestFilePath());
    return -10008;
  }
  
  protected Transfer.Result processDownload()
  {
    Transfer.Result localResult1 = acquireResource();
    if (localResult1.mRet != 0) {
      return localResult1;
    }
    int k = 1;
    long l = this.mStartTime;
    int j = 0;
    int i = 0;
    Transfer.Result localResult2 = localResult1;
    for (;;)
    {
      try
      {
        if (i < getMaxTryTimes())
        {
          if (k == 0) {
            l = System.currentTimeMillis();
          }
          localResult2 = checkJob();
          if (localResult2 != null) {
            return localResult2;
          }
          if (k == 0)
          {
            this.mJob.reportDownloadTransferSize(2, localResult1.mRet, this.mStartTime, l, this.mContext.getCurSize() - this.mOffset, localResult1.mErrMsg);
            this.mStartTime = l;
            this.mOffset = this.mContext.getCurSize();
          }
          localResult1 = doDownload();
          k = localResult1.mRet;
          if (k == 0) {
            localResult2 = localResult1;
          }
        }
        else
        {
          releaseResource();
          if (localResult2.mRet != 0) {
            break label335;
          }
          i = moveToTarget();
          if (i != 0) {
            break label327;
          }
          localResult1 = null;
          return new Transfer.Result(i, localResult1);
        }
        k = i;
        if (this.mOffset < this.mContext.getCurSize())
        {
          k = i;
          if (isSupportContinueInterruption())
          {
            Log.w("BaseDownloadTransfer", "get data " + (this.mContext.getCurSize() - this.mOffset) + ", meet error:" + localResult1.mRet);
            k = -1;
          }
        }
        boolean bool;
        if (k + 1 < getMaxTryTimes())
        {
          bool = true;
          localResult2 = handleError(bool, j, localResult1);
          i = localResult2.mRet;
          if (i != 0) {
            return localResult2;
          }
        }
        else
        {
          bool = false;
          continue;
        }
        i = k + 1;
        j += 1;
        k = 0;
        break;
      }
      finally
      {
        releaseResource();
      }
      label327:
      String str = "读写文件失败";
    }
    label335:
    return localResult2;
  }
  
  protected int readHttpContent(InputStream paramInputStream)
    throws SocketTimeoutException, IOException, InterruptedException
  {
    boolean bool = false;
    for (;;)
    {
      int i;
      ByteArrayPool.ByteArrayBuffer localByteArrayBuffer;
      try
      {
        if (this.mDestFileWriter.getFilePointer() != this.mContext.getCurSize()) {
          this.mDestFileWriter.seek(this.mContext.getCurSize());
        }
        i = -1;
        localByteArrayBuffer = ByteArrayPool.getInstance().createBuffer();
        if (!this.mJob.isAlive())
        {
          i = -10002;
          paramInputStream = ByteArrayPool.getInstance();
          if (i == 0) {
            bool = true;
          }
          paramInputStream.freeBuffer(localByteArrayBuffer, bool);
          return i;
        }
      }
      catch (IOException paramInputStream)
      {
        Log.w("BaseDownloadTransfer", paramInputStream);
        return -10016;
      }
      if (!this.mJob.checkEnvironment())
      {
        i = this.mJob.getLastErrorNo();
      }
      else
      {
        int j = paramInputStream.read(localByteArrayBuffer.backingArray, 0, 40960);
        if (-1 == j) {
          i = 0;
        } else {
          try
          {
            this.mDestFileWriter.write(localByteArrayBuffer.backingArray, 0, j);
            this.mContext.setCurSize(this.mContext.getCurSize() + j);
            this.mJob.notifyProgressChanged(this.mContext.getCurSize(), this.mContext.getTotalSize());
            if (j > 0) {}
          }
          catch (IOException paramInputStream)
          {
            Log.w("BaseDownloadTransfer", paramInputStream);
            i = -10008;
          }
        }
      }
    }
  }
  
  protected void releaseResource()
  {
    try
    {
      RandomAccessFile localRandomAccessFile = this.mDestFileWriter;
      if (localRandomAccessFile != null) {
        localRandomAccessFile.close();
      }
      this.mDestFileWriter = null;
      return;
    }
    catch (IOException localIOException)
    {
      Log.w("BaseDownloadTransfer", localIOException);
    }
  }
  
  protected void setHttpHeader(HttpURLConnection paramHttpURLConnection)
    throws ProtocolException
  {
    if (!NetworkUtils.isWIFI(null))
    {
      paramHttpURLConnection.setConnectTimeout(this.mTimeoutTimes * 5000 + 45000);
      paramHttpURLConnection.setReadTimeout(this.mTimeoutTimes * 5000 + 45000);
      paramHttpURLConnection.setRequestMethod("GET");
      paramHttpURLConnection.setRequestProperty("Accept", "*/*");
      paramHttpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
      paramHttpURLConnection.setRequestProperty("Charset", "UTF-8");
      if ((Build.VERSION.SDK == null) || (Build.VERSION.SDK_INT <= 13)) {
        break label166;
      }
      paramHttpURLConnection.setRequestProperty("Connection", "close");
      paramHttpURLConnection.setRequestProperty("Proxy-Connection", "close");
    }
    for (;;)
    {
      paramHttpURLConnection.setRequestProperty("Pragma", "no-cache");
      paramHttpURLConnection.setRequestProperty("Content-type", "text/octet");
      return;
      paramHttpURLConnection.setConnectTimeout(this.mTimeoutTimes * 5000 + 30000);
      paramHttpURLConnection.setReadTimeout(this.mTimeoutTimes * 5000 + 45000);
      break;
      label166:
      paramHttpURLConnection.setRequestProperty("Connection", "Keep-Alive");
      paramHttpURLConnection.setRequestProperty("Proxy-Connection", "Keep-Alive");
    }
  }
  
  public int transfer()
  {
    this.mStartTime = System.currentTimeMillis();
    this.mOffset = this.mContext.getCurSize();
    Transfer.Result localResult = processDownload();
    report(localResult);
    return localResult.mRet;
  }
  
  protected boolean usingSplitDownload()
  {
    return this.mUseSplitDownload;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.transfer.BaseDownloadTransfer
 * JD-Core Version:    0.7.0.1
 */