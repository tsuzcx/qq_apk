package com.tencent.mobileqq.highway.conn;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.codec.HttpProtocolDataCodec;
import com.tencent.mobileqq.highway.codec.IProtocolCodecListener;
import com.tencent.mobileqq.highway.codec.TcpProtocolDataCodec;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.segment.IRequestListener;
import com.tencent.mobileqq.highway.segment.RequestHeartBreak;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class SyncTcpConnection
  implements IConnection, IProtocolCodecListener
{
  public static final int DEDAULT_CONN_TIMEOUT_xG = 20000;
  public static final int DEFAULT_CONN_TIMEOUT_Wi = 10000;
  public static final int DEFAULT_READ_BUF_SIZE = 32768;
  public static final int DEFAULT_READ_TIMEOUT = 30000;
  public static final int DEFAULT_SEND_BUF_SIZE = 524288;
  public static final int HEARTBREAK_DELTA = 20000;
  private static final int MAX_CONTINUE_HREAT = 2;
  private StringBuilder closeDebug = new StringBuilder("ConnTag:");
  private int connId;
  private ConnReportInfo connInfo = null;
  private IConnectionListener connListener;
  private ConnManager connManager;
  private int connType = 1;
  private int continueHeartBreak = 0;
  private TcpProtocolDataCodec dataCodec;
  private AtomicBoolean isConn = new AtomicBoolean(false);
  private AtomicBoolean isRunning = new AtomicBoolean(false);
  private volatile boolean isUrgent = false;
  private AtomicBoolean isWritting = new AtomicBoolean(false);
  private long lastHeartBreakTime = 0L;
  private ReentrantLock lock = new ReentrantLock();
  private ConnWorker mConnHandler;
  private HandlerThread mConnThread;
  private int mConnTimeOut = 0;
  private EndPoint mEp;
  private MsfSocketInputBuffer mInputBuffer = null;
  private int mNetFlowDw = 0;
  private int mNetFlowUp = 0;
  private OutputStream mOutputStream;
  private int mReadBufferSize;
  private ReadThread mReadThread;
  private int mReadTimeout;
  private Handler mServletHandler = null;
  private Socket mSocket;
  private int protoType = 1;
  private InetSocketAddress serverAddress = null;
  private AtomicBoolean shouldCloseConn = new AtomicBoolean(false);
  
  public SyncTcpConnection(ConnManager paramConnManager, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, EndPoint paramEndPoint, ConnReportInfo paramConnReportInfo)
  {
    if (paramEndPoint.protoType == 2) {}
    for (this.dataCodec = new HttpProtocolDataCodec();; this.dataCodec = new TcpProtocolDataCodec())
    {
      this.protoType = paramEndPoint.protoType;
      this.connManager = paramConnManager;
      this.mReadBufferSize = paramInt1;
      this.mReadTimeout = paramInt3;
      this.connId = paramInt4;
      this.mEp = paramEndPoint;
      this.connInfo = paramConnReportInfo;
      this.connType = paramInt5;
      this.mConnTimeOut = paramInt2;
      this.mConnThread = new HandlerThread("BDH-CONN" + paramInt4);
      this.dataCodec.setProtocolCodecListener(this);
      this.mServletHandler = new Handler(Looper.getMainLooper());
      return;
    }
  }
  
  private void closeConn(final int paramInt)
  {
    QLog.d("BDH_LOG", 1, "CCloseConn at : ConnId:" + this.connId + " Src:" + paramInt);
    if (this.mInputBuffer != null)
    {
      localObject1 = this.mInputBuffer.instream;
      if (localObject1 != null) {
        setExclusiveStream(false, localObject1.toString());
      }
    }
    if (this.mOutputStream != null) {
      setExclusiveStream(false, this.mOutputStream.toString());
    }
    this.isRunning.set(false);
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool3 = false;
    boolean bool1 = bool5;
    boolean bool2 = bool6;
    for (;;)
    {
      try
      {
        if (this.mSocket == null) {
          return;
        }
        bool1 = bool5;
        bool2 = bool6;
        if (!this.isConn.get()) {
          return;
        }
        bool1 = bool5;
        bool2 = bool6;
        boolean bool7 = this.lock.tryLock(30000L, TimeUnit.MILLISECONDS);
        if (!bool7) {
          continue;
        }
        bool3 = bool4;
      }
      catch (InterruptedException localInterruptedException)
      {
        final int i;
        BdhLogUtil.LogException("C", "CloseConn Error.", localInterruptedException);
        continue;
        bool1 = bool5;
        bool2 = bool6;
        this.shouldCloseConn.set(true);
        bool1 = bool3;
        continue;
      }
      catch (Exception localException1)
      {
        label228:
        BdhLogUtil.LogException("C", "CloseConn Error.", localException1);
        bool1 = bool2;
        continue;
      }
      try
      {
        localObject1 = this.mConnHandler;
        if (localObject1 != null)
        {
          bool3 = bool4;
          ((ConnWorker)localObject1).notifyToQuit();
        }
        bool3 = bool4;
        this.mInputBuffer = null;
        bool3 = bool4;
        this.mOutputStream = null;
        bool3 = bool4;
      }
      finally
      {
        bool1 = bool3;
        bool2 = bool3;
        this.lock.unlock();
        bool1 = bool3;
        bool2 = bool3;
      }
    }
    try
    {
      if (this.mSocket != null)
      {
        bool3 = bool4;
        this.mSocket.close();
      }
    }
    catch (Exception localException2)
    {
      break label228;
    }
    bool3 = bool4;
    this.isConn.set(false);
    bool3 = bool4;
    this.mSocket = null;
    bool3 = bool4;
    this.mReadThread = null;
    bool1 = true;
    bool5 = true;
    bool2 = true;
    bool4 = true;
    bool3 = bool1;
    this.connInfo.finished = true;
    bool3 = bool1;
    this.connInfo.connLifeLong = (SystemClock.uptimeMillis() - this.connInfo.connStartTime);
    bool3 = bool1;
    paramInt = this.mNetFlowUp;
    bool3 = bool1;
    i = this.mNetFlowDw;
    bool3 = bool1;
    this.mNetFlowUp = 0;
    bool3 = bool1;
    this.mNetFlowDw = 0;
    bool3 = bool1;
    this.mServletHandler.post(new Runnable()
    {
      public void run()
      {
        HwServlet.reportTraffic4PicUp(SyncTcpConnection.this.connManager.engine.app, SyncTcpConnection.this.connInfo.serverIp, SyncTcpConnection.this.connInfo.port, true, paramInt);
        HwServlet.reportTraffic4PicUp(SyncTcpConnection.this.connManager.engine.app, SyncTcpConnection.this.connInfo.serverIp, SyncTcpConnection.this.connInfo.port, false, i);
      }
    });
    bool1 = bool5;
    this.lock.unlock();
    bool1 = bool4;
    Object localObject1 = this.connListener;
    if (localObject1 != null) {
      ((IConnectionListener)localObject1).onDisConnect(this.connId, this);
    }
    BdhLogUtil.LogEvent("C", "CloseConn End. connId:" + this.connId + " isCloseSuccess:" + bool1);
    return;
  }
  
  private void doSendData()
  {
    for (;;)
    {
      if ((!this.isRunning.get()) || (this.isWritting.get())) {
        label20:
        return;
      }
      try
      {
        ??? = this.connManager.pullNextRequest(this, this.isUrgent);
        if (??? == null)
        {
          this.isWritting.set(false);
          if ((SystemClock.uptimeMillis() - this.lastHeartBreakTime <= 60000L) || (this.connType == 2)) {
            break label20;
          }
          this.lastHeartBreakTime = SystemClock.uptimeMillis();
          ??? = this.connManager;
          i = this.connId;
          if (this.continueHeartBreak == 0)
          {
            bool = true;
            label98:
            ((ConnManager)???).onConnectionIdle(i, bool);
            return;
          }
        }
      }
      catch (Exception localException2)
      {
        int i;
        boolean bool;
        BdhLogUtil.LogException("C", "SendThread Error.", localException2);
        synchronized (this.closeDebug)
        {
          this.closeDebug.append("By SendWorker :" + localException2.getMessage() + ";");
          closeConn(2);
          continue;
          bool = false;
          break label98;
          this.isWritting.set(true);
          ((HwRequest)???).endpoint = this.mEp;
          if ((??? instanceof RequestHeartBreak))
          {
            if (this.continueHeartBreak > 2)
            {
              this.connInfo.killSelf = true;
              closeConn(4);
              return;
            }
            this.continueHeartBreak += 1;
          }
          for (;;)
          {
            try
            {
              arrayOfByte = ((HwRequest)???).getRequestBody();
              if ((arrayOfByte != null) || (!((HwRequest)???).hasRequestBody())) {
                break label309;
              }
              ((HwRequest)???).reqListener.handleError(-1004);
              this.isWritting.set(false);
            }
            catch (Exception localException1)
            {
              this.isWritting.set(false);
            }
            break;
            this.continueHeartBreak = 0;
            this.lastHeartBreakTime = 0L;
          }
          label309:
          byte[] arrayOfByte = this.dataCodec.encodeC2SData(this.mEp, localException1, arrayOfByte);
          if (arrayOfByte == null)
          {
            this.isWritting.set(false);
            continue;
          }
          if (localException1.retryCount == 0)
          {
            localObject3 = this.connInfo;
            ((ConnReportInfo)localObject3).sentRequestCount += 1;
            localObject3 = this.connInfo;
            ((ConnReportInfo)localObject3).sentDataLen += arrayOfByte.length;
            localException1.sendTime = SystemClock.uptimeMillis();
            long l1 = SystemClock.uptimeMillis();
            localObject3 = this.mOutputStream;
            if (localObject3 != null)
            {
              ((OutputStream)localObject3).write(arrayOfByte);
              ((OutputStream)localObject3).flush();
            }
            i = arrayOfByte.length;
            this.connManager.increaseDataFlowUp(i);
            long l2 = SystemClock.uptimeMillis();
            this.mNetFlowUp += i;
            localException1.reqListener.handleSendEnd(this.connId, this.protoType, this.connType);
            BdhLogUtil.LogEvent("R", "SendRequest End. CostTrace  reqId: " + localException1.getHwSeq() + " SendComsume:" + localException1.sendComsume + " WriteComsume:" + (l2 - l1) + " ConnID:" + this.connId + " ReqInfo:" + localException1.dumpBaseInfo() + " ContinueHeartBreak:" + this.continueHeartBreak);
            if (this.protoType != 1) {
              continue;
            }
            this.isWritting.set(false);
            continue;
          }
          Object localObject3 = this.connInfo;
          ((ConnReportInfo)localObject3).sentRetryCount += 1;
        }
      }
    }
  }
  
  /* Error */
  private int openConn(EndPoint paramEndPoint)
  {
    // Byte code:
    //   0: ldc 241
    //   2: iconst_1
    //   3: new 113	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 465
    //   13: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_1
    //   17: getfield 469	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   20: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 471
    //   26: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: getfield 474	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   33: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: ldc_w 476
    //   39: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 150	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connId	I
    //   46: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: ldc_w 478
    //   52: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: getfield 137	com/tencent/mobileqq/highway/utils/EndPoint:protoType	I
    //   59: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 480
    //   65: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_0
    //   69: getfield 101	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connType	I
    //   72: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_0
    //   82: getfield 97	com/tencent/mobileqq/highway/conn/SyncTcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   85: invokevirtual 273	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   88: ifne +13 -> 101
    //   91: aload_0
    //   92: getfield 95	com/tencent/mobileqq/highway/conn/SyncTcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   95: invokevirtual 273	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   98: ifeq +26 -> 124
    //   101: aload_0
    //   102: getfield 97	com/tencent/mobileqq/highway/conn/SyncTcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   105: invokevirtual 273	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   108: ifeq +16 -> 124
    //   111: aload_0
    //   112: getfield 97	com/tencent/mobileqq/highway/conn/SyncTcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   115: iconst_0
    //   116: invokevirtual 267	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   119: aload_0
    //   120: iconst_2
    //   121: invokespecial 227	com/tencent/mobileqq/highway/conn/SyncTcpConnection:closeConn	(I)V
    //   124: iconst_0
    //   125: istore 9
    //   127: iconst_0
    //   128: istore 7
    //   130: iconst_0
    //   131: istore 10
    //   133: iconst_0
    //   134: istore 6
    //   136: bipush 14
    //   138: istore_2
    //   139: invokestatic 306	android/os/SystemClock:uptimeMillis	()J
    //   142: lstore 16
    //   144: ldc2_w 481
    //   147: lstore 14
    //   149: iload_2
    //   150: istore 4
    //   152: aload_0
    //   153: getfield 88	com/tencent/mobileqq/highway/conn/SyncTcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   156: ldc2_w 274
    //   159: getstatic 281	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   162: invokevirtual 285	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   165: istore 8
    //   167: iload_2
    //   168: istore 4
    //   170: iload 8
    //   172: ifeq +842 -> 1014
    //   175: iload 9
    //   177: istore 6
    //   179: iload_2
    //   180: istore 4
    //   182: lload 14
    //   184: lstore 12
    //   186: iload 10
    //   188: istore 8
    //   190: iload_2
    //   191: istore_3
    //   192: aload_0
    //   193: new 484	java/net/InetSocketAddress
    //   196: dup
    //   197: aload_1
    //   198: getfield 469	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   201: aload_1
    //   202: getfield 474	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   205: invokespecial 487	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   208: putfield 103	com/tencent/mobileqq/highway/conn/SyncTcpConnection:serverAddress	Ljava/net/InetSocketAddress;
    //   211: iload 9
    //   213: istore 6
    //   215: iload_2
    //   216: istore 4
    //   218: lload 14
    //   220: lstore 12
    //   222: iload 10
    //   224: istore 8
    //   226: iload_2
    //   227: istore_3
    //   228: aload_0
    //   229: getfield 95	com/tencent/mobileqq/highway/conn/SyncTcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   232: iconst_0
    //   233: invokevirtual 267	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   236: iload 9
    //   238: istore 6
    //   240: iload_2
    //   241: istore 4
    //   243: lload 14
    //   245: lstore 12
    //   247: iload 10
    //   249: istore 8
    //   251: iload_2
    //   252: istore_3
    //   253: aload_0
    //   254: new 290	java/net/Socket
    //   257: dup
    //   258: invokespecial 488	java/net/Socket:<init>	()V
    //   261: putfield 269	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   264: iload 9
    //   266: istore 6
    //   268: iload_2
    //   269: istore 4
    //   271: lload 14
    //   273: lstore 12
    //   275: iload 10
    //   277: istore 8
    //   279: iload_2
    //   280: istore_3
    //   281: aload_0
    //   282: getfield 269	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   285: iconst_1
    //   286: invokevirtual 491	java/net/Socket:setKeepAlive	(Z)V
    //   289: iload 9
    //   291: istore 6
    //   293: iload_2
    //   294: istore 4
    //   296: lload 14
    //   298: lstore 12
    //   300: iload 10
    //   302: istore 8
    //   304: iload_2
    //   305: istore_3
    //   306: aload_0
    //   307: getfield 269	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   310: iconst_1
    //   311: invokevirtual 494	java/net/Socket:setTcpNoDelay	(Z)V
    //   314: iload 9
    //   316: istore 6
    //   318: iload_2
    //   319: istore 4
    //   321: lload 14
    //   323: lstore 12
    //   325: iload 10
    //   327: istore 8
    //   329: iload_2
    //   330: istore_3
    //   331: aload_0
    //   332: getfield 269	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   335: aload_0
    //   336: getfield 148	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mReadTimeout	I
    //   339: invokevirtual 497	java/net/Socket:setSoTimeout	(I)V
    //   342: iload 9
    //   344: istore 6
    //   346: iload_2
    //   347: istore 4
    //   349: lload 14
    //   351: lstore 12
    //   353: iload 10
    //   355: istore 8
    //   357: iload_2
    //   358: istore_3
    //   359: aload_0
    //   360: getfield 269	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   363: ldc 27
    //   365: invokevirtual 500	java/net/Socket:setSendBufferSize	(I)V
    //   368: iload 9
    //   370: istore 6
    //   372: iload_2
    //   373: istore 4
    //   375: lload 14
    //   377: lstore 12
    //   379: iload 10
    //   381: istore 8
    //   383: iload_2
    //   384: istore_3
    //   385: invokestatic 306	android/os/SystemClock:uptimeMillis	()J
    //   388: lstore 14
    //   390: iload 9
    //   392: istore 6
    //   394: iload_2
    //   395: istore 4
    //   397: lload 14
    //   399: lstore 12
    //   401: iload 10
    //   403: istore 8
    //   405: iload_2
    //   406: istore_3
    //   407: aload_0
    //   408: getfield 269	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   411: aload_0
    //   412: getfield 103	com/tencent/mobileqq/highway/conn/SyncTcpConnection:serverAddress	Ljava/net/InetSocketAddress;
    //   415: aload_0
    //   416: getfield 107	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mConnTimeOut	I
    //   419: invokevirtual 504	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   422: iload 9
    //   424: istore 6
    //   426: iload_2
    //   427: istore 4
    //   429: lload 14
    //   431: lstore 12
    //   433: iload 10
    //   435: istore 8
    //   437: iload_2
    //   438: istore_3
    //   439: invokestatic 306	android/os/SystemClock:uptimeMillis	()J
    //   442: lload 14
    //   444: lsub
    //   445: lstore 14
    //   447: iload 9
    //   449: istore 6
    //   451: iload_2
    //   452: istore 4
    //   454: lload 14
    //   456: lstore 12
    //   458: iload 10
    //   460: istore 8
    //   462: iload_2
    //   463: istore_3
    //   464: aload_0
    //   465: aload_0
    //   466: getfield 269	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   469: invokevirtual 508	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   472: putfield 264	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   475: iload 9
    //   477: istore 6
    //   479: iload_2
    //   480: istore 4
    //   482: lload 14
    //   484: lstore 12
    //   486: iload 10
    //   488: istore 8
    //   490: iload_2
    //   491: istore_3
    //   492: aload_0
    //   493: new 253	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   496: dup
    //   497: aload_0
    //   498: getfield 269	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   501: aload_0
    //   502: getfield 146	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mReadBufferSize	I
    //   505: ldc_w 510
    //   508: iconst_m1
    //   509: invokespecial 513	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
    //   512: putfield 105	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   515: iload 9
    //   517: istore 6
    //   519: iload_2
    //   520: istore 4
    //   522: lload 14
    //   524: lstore 12
    //   526: iload 10
    //   528: istore 8
    //   530: iload_2
    //   531: istore_3
    //   532: iconst_1
    //   533: aload_0
    //   534: getfield 105	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   537: getfield 257	com/tencent/qphone/base/util/MsfSocketInputBuffer:instream	Ljava/io/InputStream;
    //   540: invokevirtual 258	java/lang/Object:toString	()Ljava/lang/String;
    //   543: invokestatic 262	com/tencent/mobileqq/highway/conn/SyncTcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   546: iload 9
    //   548: istore 6
    //   550: iload_2
    //   551: istore 4
    //   553: lload 14
    //   555: lstore 12
    //   557: iload 10
    //   559: istore 8
    //   561: iload_2
    //   562: istore_3
    //   563: iconst_1
    //   564: aload_0
    //   565: getfield 264	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   568: invokevirtual 258	java/lang/Object:toString	()Ljava/lang/String;
    //   571: invokestatic 262	com/tencent/mobileqq/highway/conn/SyncTcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   574: iload 9
    //   576: istore 6
    //   578: iload_2
    //   579: istore 4
    //   581: lload 14
    //   583: lstore 12
    //   585: iload 10
    //   587: istore 8
    //   589: iload_2
    //   590: istore_3
    //   591: aload_0
    //   592: new 15	com/tencent/mobileqq/highway/conn/SyncTcpConnection$ReadThread
    //   595: dup
    //   596: aload_0
    //   597: invokespecial 515	com/tencent/mobileqq/highway/conn/SyncTcpConnection$ReadThread:<init>	(Lcom/tencent/mobileqq/highway/conn/SyncTcpConnection;)V
    //   600: putfield 295	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/SyncTcpConnection$ReadThread;
    //   603: iload 9
    //   605: istore 6
    //   607: iload_2
    //   608: istore 4
    //   610: lload 14
    //   612: lstore 12
    //   614: iload 10
    //   616: istore 8
    //   618: iload_2
    //   619: istore_3
    //   620: aload_0
    //   621: getfield 111	com/tencent/mobileqq/highway/conn/SyncTcpConnection:isRunning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   624: iconst_1
    //   625: invokevirtual 267	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   628: iload 9
    //   630: istore 6
    //   632: iload_2
    //   633: istore 4
    //   635: lload 14
    //   637: lstore 12
    //   639: iload 10
    //   641: istore 8
    //   643: iload_2
    //   644: istore_3
    //   645: aload_0
    //   646: getfield 295	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/SyncTcpConnection$ReadThread;
    //   649: invokevirtual 518	com/tencent/mobileqq/highway/conn/SyncTcpConnection$ReadThread:start	()V
    //   652: iload 9
    //   654: istore 6
    //   656: iload_2
    //   657: istore 4
    //   659: lload 14
    //   661: lstore 12
    //   663: iload 10
    //   665: istore 8
    //   667: iload_2
    //   668: istore_3
    //   669: aload_0
    //   670: getfield 95	com/tencent/mobileqq/highway/conn/SyncTcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   673: iconst_1
    //   674: invokevirtual 267	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   677: iconst_1
    //   678: istore 7
    //   680: iconst_1
    //   681: istore 10
    //   683: iconst_1
    //   684: istore 11
    //   686: iconst_1
    //   687: istore 9
    //   689: iload 7
    //   691: istore 6
    //   693: iload_2
    //   694: istore 4
    //   696: lload 14
    //   698: lstore 12
    //   700: iload 11
    //   702: istore 8
    //   704: iload_2
    //   705: istore_3
    //   706: new 113	java/lang/StringBuilder
    //   709: dup
    //   710: ldc_w 520
    //   713: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   716: astore 18
    //   718: iload 7
    //   720: istore 6
    //   722: iload_2
    //   723: istore 4
    //   725: lload 14
    //   727: lstore 12
    //   729: iload 11
    //   731: istore 8
    //   733: iload_2
    //   734: istore_3
    //   735: aload_0
    //   736: getfield 152	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mEp	Lcom/tencent/mobileqq/highway/utils/EndPoint;
    //   739: getfield 469	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   742: ldc_w 522
    //   745: invokevirtual 528	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   748: ifeq +126 -> 874
    //   751: iload 7
    //   753: istore 6
    //   755: iload_2
    //   756: istore 4
    //   758: lload 14
    //   760: lstore 12
    //   762: iload 11
    //   764: istore 8
    //   766: iload_2
    //   767: istore_3
    //   768: aload_0
    //   769: getfield 269	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   772: invokevirtual 532	java/net/Socket:getRemoteSocketAddress	()Ljava/net/SocketAddress;
    //   775: astore 19
    //   777: aload 19
    //   779: ifnull +95 -> 874
    //   782: iload 7
    //   784: istore 6
    //   786: iload_2
    //   787: istore 4
    //   789: lload 14
    //   791: lstore 12
    //   793: iload 11
    //   795: istore 8
    //   797: iload_2
    //   798: istore_3
    //   799: aload 19
    //   801: instanceof 484
    //   804: ifeq +70 -> 874
    //   807: iload 7
    //   809: istore 6
    //   811: iload_2
    //   812: istore 4
    //   814: lload 14
    //   816: lstore 12
    //   818: iload 11
    //   820: istore 8
    //   822: iload_2
    //   823: istore_3
    //   824: aload 19
    //   826: checkcast 484	java/net/InetSocketAddress
    //   829: invokevirtual 536	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   832: invokevirtual 541	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   835: astore 19
    //   837: iload 7
    //   839: istore 6
    //   841: iload_2
    //   842: istore 4
    //   844: lload 14
    //   846: lstore 12
    //   848: iload 11
    //   850: istore 8
    //   852: iload_2
    //   853: istore_3
    //   854: aload 18
    //   856: ldc_w 543
    //   859: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: aload 19
    //   864: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: ldc_w 545
    //   870: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: pop
    //   874: iconst_0
    //   875: istore 4
    //   877: iconst_0
    //   878: istore 5
    //   880: iconst_0
    //   881: istore_3
    //   882: iconst_0
    //   883: istore_2
    //   884: iload 7
    //   886: istore 6
    //   888: lload 14
    //   890: lstore 12
    //   892: iload 11
    //   894: istore 8
    //   896: ldc_w 332
    //   899: new 113	java/lang/StringBuilder
    //   902: dup
    //   903: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   906: ldc_w 547
    //   909: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: aload_1
    //   913: getfield 469	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   916: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: ldc_w 471
    //   922: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: aload_1
    //   926: getfield 474	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   929: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   932: ldc_w 476
    //   935: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: aload_0
    //   939: getfield 150	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connId	I
    //   942: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   945: ldc_w 549
    //   948: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: lload 14
    //   953: invokevirtual 447	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   956: ldc_w 551
    //   959: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: aload 18
    //   964: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   967: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: ldc_w 553
    //   973: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: aload_0
    //   977: getfield 269	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mSocket	Ljava/net/Socket;
    //   980: invokevirtual 556	java/net/Socket:getLocalPort	()I
    //   983: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   986: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   989: invokestatic 345	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   992: iload 10
    //   994: istore 7
    //   996: iload 5
    //   998: istore 4
    //   1000: aload_0
    //   1001: getfield 88	com/tencent/mobileqq/highway/conn/SyncTcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1004: invokevirtual 322	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1007: iload_2
    //   1008: istore 4
    //   1010: iload 9
    //   1012: istore 6
    //   1014: aload_0
    //   1015: getfield 128	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1018: iload 6
    //   1020: putfield 559	com/tencent/mobileqq/highway/conn/ConnReportInfo:result	Z
    //   1023: aload_0
    //   1024: getfield 128	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1027: invokestatic 306	android/os/SystemClock:uptimeMillis	()J
    //   1030: aload_0
    //   1031: getfield 128	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1034: getfield 309	com/tencent/mobileqq/highway/conn/ConnReportInfo:connStartTime	J
    //   1037: lsub
    //   1038: putfield 562	com/tencent/mobileqq/highway/conn/ConnReportInfo:connElapseTime	J
    //   1041: invokestatic 306	android/os/SystemClock:uptimeMillis	()J
    //   1044: lstore 12
    //   1046: aload_0
    //   1047: getfield 324	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   1050: ifnull +100 -> 1150
    //   1053: ldc 241
    //   1055: iconst_1
    //   1056: new 113	java/lang/StringBuilder
    //   1059: dup
    //   1060: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   1063: ldc_w 564
    //   1066: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: aload_0
    //   1070: getfield 150	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connId	I
    //   1073: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1076: ldc_w 566
    //   1079: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: iload 6
    //   1084: invokevirtual 339	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1087: ldc_w 568
    //   1090: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: iload 4
    //   1095: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1098: ldc_w 570
    //   1101: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1104: lload 12
    //   1106: lload 16
    //   1108: lsub
    //   1109: invokevirtual 447	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1112: ldc_w 572
    //   1115: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1121: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1124: aload_0
    //   1125: getfield 324	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   1128: iload 6
    //   1130: aload_0
    //   1131: getfield 150	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connId	I
    //   1134: aload_0
    //   1135: aload_0
    //   1136: getfield 152	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mEp	Lcom/tencent/mobileqq/highway/utils/EndPoint;
    //   1139: iload 4
    //   1141: aload_0
    //   1142: getfield 128	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1145: invokeinterface 576 7 0
    //   1150: iload 6
    //   1152: ifeq +673 -> 1825
    //   1155: aload_0
    //   1156: getfield 128	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1159: invokestatic 306	android/os/SystemClock:uptimeMillis	()J
    //   1162: putfield 579	com/tencent/mobileqq/highway/conn/ConnReportInfo:connLifeBegin	J
    //   1165: aload_0
    //   1166: getfield 207	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/SyncTcpConnection$ConnWorker;
    //   1169: invokevirtual 582	com/tencent/mobileqq/highway/conn/SyncTcpConnection$ConnWorker:wakeupToWrite	()V
    //   1172: iload 4
    //   1174: ireturn
    //   1175: astore 18
    //   1177: iload 6
    //   1179: istore 8
    //   1181: iload 4
    //   1183: istore_3
    //   1184: aload_0
    //   1185: getfield 144	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connManager	Lcom/tencent/mobileqq/highway/conn/ConnManager;
    //   1188: invokevirtual 585	com/tencent/mobileqq/highway/conn/ConnManager:hasNet	()Z
    //   1191: istore 7
    //   1193: iload 6
    //   1195: istore 8
    //   1197: iload 4
    //   1199: istore_3
    //   1200: ldc_w 332
    //   1203: new 113	java/lang/StringBuilder
    //   1206: dup
    //   1207: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   1210: ldc_w 587
    //   1213: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: aload_1
    //   1217: getfield 469	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   1220: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: ldc_w 471
    //   1226: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: aload_1
    //   1230: getfield 474	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   1233: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1236: ldc_w 476
    //   1239: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1242: aload_0
    //   1243: getfield 150	com/tencent/mobileqq/highway/conn/SyncTcpConnection:connId	I
    //   1246: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1249: ldc_w 549
    //   1252: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1255: lload 12
    //   1257: invokevirtual 447	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1260: ldc_w 589
    //   1263: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: iload 7
    //   1268: invokevirtual 339	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1271: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1274: aload 18
    //   1276: invokestatic 351	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1279: iload 6
    //   1281: istore 8
    //   1283: iload 4
    //   1285: istore_3
    //   1286: aload 18
    //   1288: invokevirtual 590	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1291: invokevirtual 593	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1294: astore 19
    //   1296: iload 7
    //   1298: ifne +78 -> 1376
    //   1301: iconst_3
    //   1302: istore_2
    //   1303: iload 6
    //   1305: istore 7
    //   1307: iload_2
    //   1308: istore 4
    //   1310: aload_0
    //   1311: getfield 88	com/tencent/mobileqq/highway/conn/SyncTcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1314: invokevirtual 322	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1317: iload_2
    //   1318: istore 4
    //   1320: goto -306 -> 1014
    //   1323: astore 18
    //   1325: ldc_w 332
    //   1328: new 113	java/lang/StringBuilder
    //   1331: dup
    //   1332: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   1335: ldc_w 595
    //   1338: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1341: aload_1
    //   1342: getfield 469	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   1345: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: ldc_w 471
    //   1351: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: aload_1
    //   1355: getfield 474	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   1358: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1361: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1364: aload 18
    //   1366: invokestatic 351	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1369: iload 7
    //   1371: istore 6
    //   1373: goto -359 -> 1014
    //   1376: iload 6
    //   1378: istore 8
    //   1380: iload 4
    //   1382: istore_3
    //   1383: aload 19
    //   1385: ldc_w 597
    //   1388: invokevirtual 601	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1391: iconst_m1
    //   1392: if_icmple +8 -> 1400
    //   1395: iconst_1
    //   1396: istore_2
    //   1397: goto -94 -> 1303
    //   1400: iload 6
    //   1402: istore 8
    //   1404: iload 4
    //   1406: istore_3
    //   1407: aload 19
    //   1409: ldc_w 603
    //   1412: invokevirtual 601	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1415: iconst_m1
    //   1416: if_icmple +8 -> 1424
    //   1419: iconst_2
    //   1420: istore_2
    //   1421: goto -118 -> 1303
    //   1424: iload 6
    //   1426: istore 8
    //   1428: iload 4
    //   1430: istore_3
    //   1431: aload 19
    //   1433: ldc_w 605
    //   1436: invokevirtual 601	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1439: iconst_m1
    //   1440: if_icmple +8 -> 1448
    //   1443: iconst_3
    //   1444: istore_2
    //   1445: goto -142 -> 1303
    //   1448: iload 6
    //   1450: istore 8
    //   1452: iload 4
    //   1454: istore_3
    //   1455: aload 19
    //   1457: ldc_w 607
    //   1460: invokevirtual 601	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1463: iconst_m1
    //   1464: if_icmple +8 -> 1472
    //   1467: iconst_4
    //   1468: istore_2
    //   1469: goto -166 -> 1303
    //   1472: iload 6
    //   1474: istore 8
    //   1476: iload 4
    //   1478: istore_3
    //   1479: aload 19
    //   1481: ldc_w 609
    //   1484: invokevirtual 601	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1487: iconst_m1
    //   1488: if_icmple +8 -> 1496
    //   1491: iconst_5
    //   1492: istore_2
    //   1493: goto -190 -> 1303
    //   1496: iload 6
    //   1498: istore 8
    //   1500: iload 4
    //   1502: istore_3
    //   1503: aload 19
    //   1505: ldc_w 611
    //   1508: invokevirtual 601	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1511: iconst_m1
    //   1512: if_icmple +9 -> 1521
    //   1515: bipush 6
    //   1517: istore_2
    //   1518: goto -215 -> 1303
    //   1521: iload 6
    //   1523: istore 8
    //   1525: iload 4
    //   1527: istore_3
    //   1528: aload 19
    //   1530: ldc_w 613
    //   1533: invokevirtual 601	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1536: iconst_m1
    //   1537: if_icmpgt +298 -> 1835
    //   1540: iload 6
    //   1542: istore 8
    //   1544: iload 4
    //   1546: istore_3
    //   1547: aload 19
    //   1549: ldc_w 615
    //   1552: invokevirtual 601	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1555: iconst_m1
    //   1556: if_icmple +6 -> 1562
    //   1559: goto +276 -> 1835
    //   1562: iload 6
    //   1564: istore 8
    //   1566: iload 4
    //   1568: istore_3
    //   1569: aload 19
    //   1571: ldc_w 617
    //   1574: invokevirtual 601	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1577: iconst_m1
    //   1578: if_icmple +9 -> 1587
    //   1581: bipush 8
    //   1583: istore_2
    //   1584: goto -281 -> 1303
    //   1587: iload 6
    //   1589: istore 8
    //   1591: iload 4
    //   1593: istore_3
    //   1594: aload 19
    //   1596: ldc_w 619
    //   1599: invokevirtual 601	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1602: iconst_m1
    //   1603: if_icmple +9 -> 1612
    //   1606: bipush 9
    //   1608: istore_2
    //   1609: goto -306 -> 1303
    //   1612: iload 6
    //   1614: istore 8
    //   1616: iload 4
    //   1618: istore_3
    //   1619: aload 19
    //   1621: ldc_w 621
    //   1624: invokevirtual 601	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1627: iconst_m1
    //   1628: if_icmple +9 -> 1637
    //   1631: bipush 10
    //   1633: istore_2
    //   1634: goto -331 -> 1303
    //   1637: iload 6
    //   1639: istore 8
    //   1641: iload 4
    //   1643: istore_3
    //   1644: aload 19
    //   1646: ldc_w 623
    //   1649: invokevirtual 601	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1652: iconst_m1
    //   1653: if_icmple +9 -> 1662
    //   1656: bipush 11
    //   1658: istore_2
    //   1659: goto -356 -> 1303
    //   1662: iload 6
    //   1664: istore 8
    //   1666: iload 4
    //   1668: istore_3
    //   1669: aload 19
    //   1671: ldc_w 625
    //   1674: invokevirtual 601	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1677: iconst_m1
    //   1678: if_icmple +9 -> 1687
    //   1681: bipush 12
    //   1683: istore_2
    //   1684: goto -381 -> 1303
    //   1687: iload 6
    //   1689: istore 8
    //   1691: iload 4
    //   1693: istore_3
    //   1694: aload 19
    //   1696: ldc_w 627
    //   1699: invokevirtual 601	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1702: iconst_m1
    //   1703: if_icmple +9 -> 1712
    //   1706: bipush 7
    //   1708: istore_2
    //   1709: goto -406 -> 1303
    //   1712: iload 6
    //   1714: istore 8
    //   1716: iload 4
    //   1718: istore_3
    //   1719: aload 19
    //   1721: ldc_w 629
    //   1724: invokevirtual 601	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1727: iconst_m1
    //   1728: if_icmple +9 -> 1737
    //   1731: bipush 13
    //   1733: istore_2
    //   1734: goto -431 -> 1303
    //   1737: bipush 14
    //   1739: istore 4
    //   1741: iload 6
    //   1743: istore 8
    //   1745: iload 4
    //   1747: istore_3
    //   1748: aload 18
    //   1750: invokestatic 635	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1753: astore 18
    //   1755: iload 4
    //   1757: istore_2
    //   1758: iload 6
    //   1760: istore 8
    //   1762: iload 4
    //   1764: istore_3
    //   1765: aload 18
    //   1767: invokevirtual 638	java/lang/String:length	()I
    //   1770: sipush 200
    //   1773: if_icmple -470 -> 1303
    //   1776: iload 6
    //   1778: istore 8
    //   1780: iload 4
    //   1782: istore_3
    //   1783: aload 18
    //   1785: iconst_0
    //   1786: sipush 200
    //   1789: invokevirtual 642	java/lang/String:substring	(II)Ljava/lang/String;
    //   1792: pop
    //   1793: iload 4
    //   1795: istore_2
    //   1796: goto -493 -> 1303
    //   1799: astore 18
    //   1801: iload 8
    //   1803: istore 7
    //   1805: iload_3
    //   1806: istore 4
    //   1808: aload_0
    //   1809: getfield 88	com/tencent/mobileqq/highway/conn/SyncTcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1812: invokevirtual 322	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1815: iload 8
    //   1817: istore 7
    //   1819: iload_3
    //   1820: istore 4
    //   1822: aload 18
    //   1824: athrow
    //   1825: aload_0
    //   1826: getfield 207	com/tencent/mobileqq/highway/conn/SyncTcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/SyncTcpConnection$ConnWorker;
    //   1829: invokevirtual 288	com/tencent/mobileqq/highway/conn/SyncTcpConnection$ConnWorker:notifyToQuit	()V
    //   1832: iload 4
    //   1834: ireturn
    //   1835: bipush 7
    //   1837: istore_2
    //   1838: goto -535 -> 1303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1841	0	this	SyncTcpConnection
    //   0	1841	1	paramEndPoint	EndPoint
    //   138	1700	2	i	int
    //   191	1629	3	j	int
    //   150	1683	4	k	int
    //   878	119	5	m	int
    //   134	1643	6	bool1	boolean
    //   128	1690	7	bool2	boolean
    //   165	1651	8	bool3	boolean
    //   125	886	9	bool4	boolean
    //   131	862	10	bool5	boolean
    //   684	209	11	bool6	boolean
    //   184	1072	12	l1	long
    //   147	805	14	l2	long
    //   142	965	16	l3	long
    //   716	247	18	localStringBuilder	StringBuilder
    //   1175	112	18	localThrowable	java.lang.Throwable
    //   1323	426	18	localInterruptedException	InterruptedException
    //   1753	31	18	str	String
    //   1799	24	18	localObject1	Object
    //   775	945	19	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   192	211	1175	java/lang/Throwable
    //   228	236	1175	java/lang/Throwable
    //   253	264	1175	java/lang/Throwable
    //   281	289	1175	java/lang/Throwable
    //   306	314	1175	java/lang/Throwable
    //   331	342	1175	java/lang/Throwable
    //   359	368	1175	java/lang/Throwable
    //   385	390	1175	java/lang/Throwable
    //   407	422	1175	java/lang/Throwable
    //   439	447	1175	java/lang/Throwable
    //   464	475	1175	java/lang/Throwable
    //   492	515	1175	java/lang/Throwable
    //   532	546	1175	java/lang/Throwable
    //   563	574	1175	java/lang/Throwable
    //   591	603	1175	java/lang/Throwable
    //   620	628	1175	java/lang/Throwable
    //   645	652	1175	java/lang/Throwable
    //   669	677	1175	java/lang/Throwable
    //   706	718	1175	java/lang/Throwable
    //   735	751	1175	java/lang/Throwable
    //   768	777	1175	java/lang/Throwable
    //   799	807	1175	java/lang/Throwable
    //   824	837	1175	java/lang/Throwable
    //   854	874	1175	java/lang/Throwable
    //   896	992	1175	java/lang/Throwable
    //   152	167	1323	java/lang/InterruptedException
    //   1000	1007	1323	java/lang/InterruptedException
    //   1310	1317	1323	java/lang/InterruptedException
    //   1808	1815	1323	java/lang/InterruptedException
    //   1822	1825	1323	java/lang/InterruptedException
    //   192	211	1799	finally
    //   228	236	1799	finally
    //   253	264	1799	finally
    //   281	289	1799	finally
    //   306	314	1799	finally
    //   331	342	1799	finally
    //   359	368	1799	finally
    //   385	390	1799	finally
    //   407	422	1799	finally
    //   439	447	1799	finally
    //   464	475	1799	finally
    //   492	515	1799	finally
    //   532	546	1799	finally
    //   563	574	1799	finally
    //   591	603	1799	finally
    //   620	628	1799	finally
    //   645	652	1799	finally
    //   669	677	1799	finally
    //   706	718	1799	finally
    //   735	751	1799	finally
    //   768	777	1799	finally
    //   799	807	1799	finally
    //   824	837	1799	finally
    //   854	874	1799	finally
    //   896	992	1799	finally
    //   1184	1193	1799	finally
    //   1200	1279	1799	finally
    //   1286	1296	1799	finally
    //   1383	1395	1799	finally
    //   1407	1419	1799	finally
    //   1431	1443	1799	finally
    //   1455	1467	1799	finally
    //   1479	1491	1799	finally
    //   1503	1515	1799	finally
    //   1528	1540	1799	finally
    //   1547	1559	1799	finally
    //   1569	1581	1799	finally
    //   1594	1606	1799	finally
    //   1619	1631	1799	finally
    //   1644	1656	1799	finally
    //   1669	1681	1799	finally
    //   1694	1706	1799	finally
    //   1719	1731	1799	finally
    //   1748	1755	1799	finally
    //   1765	1776	1799	finally
    //   1783	1793	1799	finally
  }
  
  public static void setExclusiveStream(boolean paramBoolean, String paramString)
  {
    synchronized (BaseApplication.exclusiveStreamList)
    {
      ArrayList localArrayList2 = BaseApplication.exclusiveStreamList;
      if (paramBoolean)
      {
        localArrayList2.add(paramString);
        return;
      }
      localArrayList2.remove(paramString);
    }
  }
  
  public void connect()
  {
    BdhLogUtil.LogEvent("C", "Connect : About to send conn request.");
    this.mConnThread.start();
    this.mConnHandler = new ConnWorker(this.mConnThread.getLooper());
    this.mConnHandler.sendEmptyMessage(1);
    this.connInfo.connStartTime = SystemClock.uptimeMillis();
    this.connInfo.serverIp = this.mEp.host;
    this.connInfo.port = this.mEp.port;
  }
  
  public void disConnect()
  {
    synchronized (this.closeDebug)
    {
      this.closeDebug.append("By : disConnect;");
      closeConn(3);
      return;
    }
  }
  
  public int getConnId()
  {
    return this.connId;
  }
  
  public int getConnType()
  {
    return this.connType;
  }
  
  public EndPoint getEndPoint()
  {
    return this.mEp;
  }
  
  public int getProtoType()
  {
    return this.protoType;
  }
  
  public boolean isWritable()
  {
    return (this.isRunning.get()) && (!this.isWritting.get());
  }
  
  public void onDecodeInvalidData(int paramInt)
  {
    QLog.d("BDH_LOG", 1, "C.  ConnId:" + this.connId + " Host:" + this.mEp.host + " Port:" + this.mEp.port + " OnDecodeInvalidData : code : " + paramInt);
    if (this.connListener != null) {
      this.connListener.onRecvInvalidData(this.mEp);
    }
    disConnect();
  }
  
  public void onDecodeSucessfully(List<HwResponse> paramList)
  {
    this.connInfo.recvRespCount = paramList.size();
    this.connManager.onDecodeSucessfully(paramList);
    if (this.protoType == 2)
    {
      this.isWritting.compareAndSet(true, false);
      if (this.connType != 1) {
        break label52;
      }
      wakeupChannel();
    }
    label52:
    while (this.connType != 2) {
      return;
    }
    disConnect();
    this.connManager.wakeupConnectionToWrite(1, false);
  }
  
  public void onEncodePkgError(HwRequest paramHwRequest, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    HwResponse localHwResponse = new HwResponse();
    localHwResponse.hwSeq = paramHwRequest.getHwSeq();
    localHwResponse.cmd = paramHwRequest.hwCmd;
    localHwResponse.errCode = paramInt;
    localHwResponse.recvTime = SystemClock.uptimeMillis();
    localHwResponse.shouldRetry = false;
    this.connManager.onDecodeSucessfully(localArrayList);
  }
  
  public void setConnectListener(IConnectionListener paramIConnectionListener)
  {
    this.connListener = paramIConnectionListener;
  }
  
  public void setUrgentFlag(boolean paramBoolean)
  {
    this.isUrgent = paramBoolean;
    wakeupChannel();
  }
  
  public void wakeupChannel()
  {
    ConnWorker localConnWorker = this.mConnHandler;
    if ((this.isRunning.get()) && (localConnWorker != null)) {
      localConnWorker.wakeupToWrite();
    }
  }
  
  class ConnWorker
    extends Handler
  {
    public static final int CONN = 1;
    public static final int QUIT = 3;
    public static final int SEND = 2;
    
    public ConnWorker(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1) {
        SyncTcpConnection.this.openConn(SyncTcpConnection.this.mEp);
      }
      do
      {
        return;
        if (paramMessage.what == 2)
        {
          SyncTcpConnection.this.doSendData();
          return;
        }
      } while (paramMessage.what != 3);
      SyncTcpConnection.this.mConnThread.quit();
      SyncTcpConnection.access$1102(SyncTcpConnection.this, null);
      SyncTcpConnection.access$1202(SyncTcpConnection.this, null);
    }
    
    public void notifyToQuit()
    {
      if (SyncTcpConnection.this.mConnHandler != null) {
        SyncTcpConnection.this.mConnHandler.sendEmptyMessage(3);
      }
    }
    
    public void wakeupToWrite()
    {
      ConnWorker localConnWorker = SyncTcpConnection.this.mConnHandler;
      if (localConnWorker != null) {
        localConnWorker.sendEmptyMessage(2);
      }
    }
  }
  
  class ReadThread
    extends Thread
  {
    ReadThread() {}
    
    public void run()
    {
      while (SyncTcpConnection.this.isRunning.get()) {
        try
        {
          ??? = SyncTcpConnection.this.mInputBuffer;
          if (??? == null) {
            return;
          }
          while (!((MsfSocketInputBuffer)???).isDataAvailable(30000)) {
            if (!SyncTcpConnection.this.isRunning.get()) {
              return;
            }
          }
          if (SyncTcpConnection.this.isRunning.get())
          {
            int i = ((MsfSocketInputBuffer)???).getBufferlen();
            ConnReportInfo localConnReportInfo = SyncTcpConnection.this.connInfo;
            localConnReportInfo.receiveDataLen += i;
            SyncTcpConnection.this.connManager.increaseDataFlowDw(i);
            SyncTcpConnection.access$402(SyncTcpConnection.this, SyncTcpConnection.this.mNetFlowDw + i);
            SyncTcpConnection.this.dataCodec.onRecvData((MsfSocketInputBuffer)???);
            ((MsfSocketInputBuffer)???).reset();
          }
        }
        catch (Exception localException)
        {
          BdhLogUtil.LogException("C", "ReadThread Error.", localException);
          synchronized (SyncTcpConnection.this.closeDebug)
          {
            SyncTcpConnection.this.closeDebug.append("By ReadThread : " + localException.getMessage() + ";");
            SyncTcpConnection.this.closeConn(1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.SyncTcpConnection
 * JD-Core Version:    0.7.0.1
 */