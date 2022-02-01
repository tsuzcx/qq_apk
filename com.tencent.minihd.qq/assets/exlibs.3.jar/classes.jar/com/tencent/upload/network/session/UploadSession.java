package com.tencent.upload.network.session;

import FileUpload.SvcResponsePacket;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.base.os.info.NetworkDash;
import com.tencent.upload.common.HandlerWapper;
import com.tencent.upload.common.LogPrint;
import com.tencent.upload.common.StringUtils;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadLog;
import com.tencent.upload.network.action.ActionResponse;
import com.tencent.upload.network.action.HandshakeAction;
import com.tencent.upload.network.action.HandshakeAction.IHandshakeListener;
import com.tencent.upload.network.action.IActionRequest;
import com.tencent.upload.network.base.Connection;
import com.tencent.upload.network.base.HttpConnection;
import com.tencent.upload.network.base.IConnectionCallback;
import com.tencent.upload.network.base.TcpConnection;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.protocol.utils.ProtocolUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class UploadSession
  implements IUploadSession, IConnectionCallback
{
  private static final AtomicInteger SEND_SEQUENCE = new AtomicInteger(0);
  private static final String TAG = "Session";
  private LinkedList<IActionRequest> mActionRequests;
  private String mClientIp;
  private String mConnectedIp;
  private HandlerWapper mHandler;
  private HandshakeAction mHandshakeAction;
  private int mHandshakeRequestSequence;
  private final int mHashCode = hashCode();
  private Connection mMainConnection;
  private final int mNeedRedirect;
  private ByteBuffer mReceivedBuffer;
  private UploadRoute mRedirectRoute;
  private SparseArray<RequestWapper> mSendingMap;
  private volatile int mSessionState;
  private SparseArray<RequestWapper> mTimeoutMap;
  private UploadRoute mUploadRoute;
  private final WeakReference<IUploadSessionCallback> mUploadSessionCallback;
  
  public UploadSession(boolean paramBoolean, Looper paramLooper, IUploadSessionCallback paramIUploadSessionCallback)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.mNeedRedirect = i;
      this.mHandler = new HandlerWapper(paramLooper);
      this.mReceivedBuffer = ByteBuffer.allocate(128);
      this.mActionRequests = new LinkedList();
      this.mSendingMap = new SparseArray();
      this.mTimeoutMap = new SparseArray();
      this.mUploadSessionCallback = new WeakReference(paramIUploadSessionCallback);
      doSetSessionState(0);
      return;
    }
  }
  
  private void doCleanup()
  {
    UploadLog.d("Session", this.mHashCode + " doCleanup");
    this.mReceivedBuffer.clear();
    this.mActionRequests.clear();
    this.mSendingMap.clear();
    doClearAllTimeout();
  }
  
  private void doClearAllTimeout()
  {
    int j = this.mTimeoutMap.size();
    int i = 0;
    if (i >= j)
    {
      this.mTimeoutMap.clear();
      return;
    }
    RequestWapper localRequestWapper = (RequestWapper)this.mTimeoutMap.valueAt(i);
    if (localRequestWapper == null) {}
    for (;;)
    {
      i += 1;
      break;
      this.mHandler.removeCallbacks(localRequestWapper.runnable);
      localRequestWapper.runnable = null;
      UploadLog.d("Session", this.mHashCode + " doClearAllTimeout remove: timeout runnable:" + LogPrint.hashCode(localRequestWapper.runnable) + " reqSeq:" + this.mTimeoutMap.keyAt(i));
    }
  }
  
  private void doClose()
  {
    if (this.mMainConnection != null)
    {
      this.mMainConnection.stop();
      this.mMainConnection = null;
    }
    doSetSessionState(0);
  }
  
  private void doConnect(IConnectionCallback paramIConnectionCallback, boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramIConnectionCallback != this.mMainConnection)
    {
      paramIConnectionCallback = (Connection)paramIConnectionCallback;
      UploadLog.d("Session", this.mHashCode + " onConnect:" + paramBoolean + " errorCode:" + paramInt + " !mMainConnection:" + paramIConnectionCallback.hashCode());
      paramIConnectionCallback.stop();
    }
    do
    {
      do
      {
        return;
        UploadLog.d("Session", this.mHashCode + " onConnect:" + paramBoolean + " errorCode:" + paramInt + " main connectionHashCode:" + paramIConnectionCallback.hashCode());
        if (this.mSessionState == 2)
        {
          UploadLog.w("Session", this.mHashCode + " doConnect ESTALISHED!");
          return;
        }
        if (this.mSessionState != 1) {
          break;
        }
        if (paramBoolean)
        {
          this.mConnectedIp = ((Connection)paramIConnectionCallback).getConnectedIp();
          sendHandshake();
          return;
        }
        paramIConnectionCallback = (IUploadSessionCallback)this.mUploadSessionCallback.get();
      } while (paramIConnectionCallback == null);
      paramIConnectionCallback.onFailToOpen(this, 0, false);
      return;
    } while (this.mSessionState != 0);
    UploadLog.w("Session", this.mHashCode + " onConnect:" + paramBoolean + " errorCode:" + paramInt + " NO_CONNECTION!");
  }
  
  private void doDisconnect(IConnectionCallback paramIConnectionCallback)
  {
    if (paramIConnectionCallback != this.mMainConnection)
    {
      paramIConnectionCallback = (Connection)paramIConnectionCallback;
      paramIConnectionCallback.stop();
      UploadLog.d("Session", this.mHashCode + " onDisconnect, !mMainConnection:" + paramIConnectionCallback.hashCode());
    }
    do
    {
      return;
      UploadLog.d("Session", this.mHashCode + " onDisconnect");
      paramIConnectionCallback = (IUploadSessionCallback)this.mUploadSessionCallback.get();
    } while (paramIConnectionCallback == null);
    paramIConnectionCallback.onClose(this);
  }
  
  private byte[] doDivideReceivedBuffer()
  {
    if (this.mReceivedBuffer.position() == 0) {
      return null;
    }
    if (this.mReceivedBuffer.position() < 4)
    {
      UploadLog.w("Session", this.mHashCode + " doDivideReceivedBuffer: size < 4");
      return new byte[0];
    }
    byte[] arrayOfByte = this.mReceivedBuffer.array();
    int i = arrayOfByte[3] & 0xFF | (arrayOfByte[2] & 0xFF) << 8 | (arrayOfByte[1] & 0xFF) << 16 | (arrayOfByte[0] & 0xFF) << 24;
    if ((i > UploadConfiguration.getMaxSessionPacketSize()) || (i < 1))
    {
      UploadLog.w("Session", this.mHashCode + " doDivideReceivedBuffer size > max, size:" + i);
      return new byte[0];
    }
    if (i > this.mReceivedBuffer.position()) {
      return null;
    }
    arrayOfByte = new byte[i];
    this.mReceivedBuffer.flip();
    this.mReceivedBuffer.get(arrayOfByte);
    this.mReceivedBuffer.compact();
    return arrayOfByte;
  }
  
  private void doError(IConnectionCallback paramIConnectionCallback, int paramInt, String paramString)
  {
    boolean bool = false;
    if (paramIConnectionCallback != this.mMainConnection) {}
    do
    {
      do
      {
        do
        {
          return;
          UploadLog.d("Session", this.mHashCode + " doError: sessionError:" + paramInt);
          if (this.mSessionState != 2) {
            break;
          }
          paramIConnectionCallback = (IUploadSessionCallback)this.mUploadSessionCallback.get();
        } while (paramIConnectionCallback == null);
        paramIConnectionCallback.onError(this, paramInt, paramString);
        return;
        if (this.mSessionState != 1) {
          break;
        }
        if (this.mHandshakeAction != null)
        {
          this.mHandshakeAction.onError(this, paramInt, paramString, false);
          this.mHandshakeAction = null;
          return;
        }
        paramIConnectionCallback = (IUploadSessionCallback)this.mUploadSessionCallback.get();
      } while (paramIConnectionCallback == null);
      if (paramInt == 35000) {
        bool = true;
      }
      paramIConnectionCallback.onFailToOpen(this, 1, bool);
      return;
    } while (this.mSessionState != 0);
    UploadLog.w("Session", "doError at NO_CONNECTION!");
  }
  
  private void doHandleHandshake(ActionResponse paramActionResponse)
  {
    if (this.mHandshakeAction != null)
    {
      this.mHandshakeAction.onResponse(this, paramActionResponse);
      this.mHandshakeAction = null;
      this.mHandshakeRequestSequence = 0;
    }
    do
    {
      return;
      paramActionResponse = (IUploadSessionCallback)this.mUploadSessionCallback.get();
    } while (paramActionResponse == null);
    paramActionResponse.onFailToOpen(this, 1, false);
  }
  
  private void doHandleResponse(ActionResponse paramActionResponse)
  {
    if (this.mSessionState == 2)
    {
      IUploadSessionCallback localIUploadSessionCallback = (IUploadSessionCallback)this.mUploadSessionCallback.get();
      if (localIUploadSessionCallback != null) {
        localIUploadSessionCallback.onReceive(this, paramActionResponse);
      }
    }
    do
    {
      return;
      if (this.mSessionState == 1)
      {
        doHandleHandshake(paramActionResponse);
        return;
      }
    } while (this.mSessionState != 0);
    UploadLog.w("Session", this.mHashCode + " doRecv: at SessionState.NO_CONNECTION");
  }
  
  private void doHandleTimeout(ActionResponse paramActionResponse)
  {
    if ((paramActionResponse == null) || (paramActionResponse.getReponsePacket() == null)) {
      return;
    }
    int j = paramActionResponse.getRequestSequence();
    int i = j;
    if (this.mSessionState == 1)
    {
      i = j;
      if (this.mHandshakeAction != null) {
        i = this.mHandshakeRequestSequence;
      }
    }
    SparseArray localSparseArray = this.mTimeoutMap;
    RequestWapper localRequestWapper = (RequestWapper)localSparseArray.get(i);
    if (localRequestWapper == null)
    {
      UploadLog.e("Session", this.mHashCode + " doHandleTimeout return, wapper == null reqSeq:" + i);
      return;
    }
    if (paramActionResponse.getReponsePacket().iCmdID == 2)
    {
      i = getResponseTimeout(localRequestWapper.request);
      this.mHandler.removeCallbacks(localRequestWapper.runnable);
      this.mHandler.postDelayed(localRequestWapper.runnable, i);
      return;
    }
    this.mHandler.removeCallbacks(localRequestWapper.runnable);
    localRequestWapper.runnable = null;
    localSparseArray.delete(i);
    UploadLog.d("Session", this.mHashCode + " doHandleTimeout: remove runnable:" + LogPrint.hashCode(localRequestWapper.runnable) + " reqSeq:" + i + " actSeq:" + localRequestWapper.request.getActionSequence() + " timeoutMap size:" + localSparseArray.size());
  }
  
  private void doReceiveBuffer(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    int i = this.mReceivedBuffer.position() + paramArrayOfByte.length;
    if (this.mReceivedBuffer.capacity() < i)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
      this.mReceivedBuffer.flip();
      localByteBuffer.put(this.mReceivedBuffer);
      this.mReceivedBuffer = localByteBuffer;
    }
    this.mReceivedBuffer.put(paramArrayOfByte);
  }
  
  private void doRecv(IConnectionCallback paramIConnectionCallback, byte[] paramArrayOfByte)
  {
    doReceiveBuffer(paramArrayOfByte);
    int i = 0;
    paramIConnectionCallback = doDivideReceivedBuffer();
    if (paramIConnectionCallback == null) {
      label16:
      if (i != 0)
      {
        if (this.mSessionState != 2) {
          break label283;
        }
        paramIConnectionCallback = new byte[512];
        paramArrayOfByte = this.mReceivedBuffer.array();
        System.arraycopy(paramArrayOfByte, 0, paramIConnectionCallback, 0, Math.min(paramArrayOfByte.length, 512));
        UploadLog.e("Session", this.mHashCode + " doRecv divide exception");
        paramArrayOfByte = (IUploadSessionCallback)this.mUploadSessionCallback.get();
        if (paramArrayOfByte != null) {
          paramArrayOfByte.onError(this, 30300, "divide exception, doDivideReceived(ascii):" + StringUtils.bytesToAscii(paramIConnectionCallback, paramIConnectionCallback.length));
        }
      }
    }
    label283:
    do
    {
      return;
      if (paramIConnectionCallback.length == 0)
      {
        i = 1;
        break label16;
      }
      paramArrayOfByte = new ActionResponse();
      boolean bool = paramArrayOfByte.decodeHead(paramIConnectionCallback);
      UploadLog.d("Session", this.mHashCode + " doRecv: decode:" + bool + " Rsp cmd:" + paramArrayOfByte.getReponsePacket().iCmdID + " actSeq:" + paramArrayOfByte.getActionSequence() + " reqSeq:" + paramArrayOfByte.getRequestSequence() + " buf.length:" + paramIConnectionCallback.length + " receivedBuffer position:" + this.mReceivedBuffer.position());
      if (!bool)
      {
        i = 1;
        break label16;
      }
      doHandleTimeout(paramArrayOfByte);
      doHandleResponse(paramArrayOfByte);
      break;
      if (this.mSessionState == 1)
      {
        doHandleHandshake(null);
        return;
      }
    } while (this.mSessionState != 0);
    UploadLog.w("Session", this.mHashCode + " doRecv: at SessionState.NO_CONNECTION");
  }
  
  /* Error */
  private void doRetrieveSendData(RequestWapper paramRequestWapper, RetrieveSendDataResult paramRetrieveSendDataResult, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: putfield 490	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:retrieveResult	I
    //   5: aload_2
    //   6: aconst_null
    //   7: putfield 494	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:sendData	[B
    //   10: aload_1
    //   11: getfield 404	com/tencent/upload/network/session/UploadSession$RequestWapper:request	Lcom/tencent/upload/network/action/IActionRequest;
    //   14: invokeinterface 498 1 0
    //   19: astore 21
    //   21: aconst_null
    //   22: astore 18
    //   24: aconst_null
    //   25: astore 17
    //   27: aload_1
    //   28: getfield 404	com/tencent/upload/network/session/UploadSession$RequestWapper:request	Lcom/tencent/upload/network/action/IActionRequest;
    //   31: invokeinterface 501 1 0
    //   36: istore 6
    //   38: invokestatic 504	com/tencent/upload/common/UploadConfiguration:getNdkSendDataSize	()I
    //   41: istore 5
    //   43: iload 5
    //   45: istore 4
    //   47: aload_1
    //   48: getfield 508	com/tencent/upload/network/session/UploadSession$RequestWapper:headIsSent	Z
    //   51: ifne +106 -> 157
    //   54: aload_1
    //   55: getfield 404	com/tencent/upload/network/session/UploadSession$RequestWapper:request	Lcom/tencent/upload/network/action/IActionRequest;
    //   58: invokeinterface 511 1 0
    //   63: astore 18
    //   65: aload 18
    //   67: ifnonnull +18 -> 85
    //   70: aload_2
    //   71: sipush 30700
    //   74: putfield 490	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:retrieveResult	I
    //   77: aload_2
    //   78: ldc_w 513
    //   81: putfield 516	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:description	Ljava/lang/String;
    //   84: return
    //   85: aload_1
    //   86: aload 18
    //   88: arraylength
    //   89: putfield 519	com/tencent/upload/network/session/UploadSession$RequestWapper:headSizeSent	I
    //   92: iload_3
    //   93: ifeq +18 -> 111
    //   96: aload_1
    //   97: getfield 404	com/tencent/upload/network/session/UploadSession$RequestWapper:request	Lcom/tencent/upload/network/action/IActionRequest;
    //   100: invokeinterface 501 1 0
    //   105: aload 18
    //   107: arraylength
    //   108: iadd
    //   109: istore 5
    //   111: iload 5
    //   113: aload 18
    //   115: arraylength
    //   116: isub
    //   117: istore 4
    //   119: iload 4
    //   121: ifge +18 -> 139
    //   124: aload_2
    //   125: sipush 30700
    //   128: putfield 490	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:retrieveResult	I
    //   131: aload_2
    //   132: ldc_w 521
    //   135: putfield 516	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:description	Ljava/lang/String;
    //   138: return
    //   139: aload 18
    //   141: astore 17
    //   143: aload 18
    //   145: ifnull +55 -> 200
    //   148: iconst_1
    //   149: istore 10
    //   151: aload_2
    //   152: iload 10
    //   154: putfield 524	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:sendEncodeHead	Z
    //   157: aload 21
    //   159: ifnull +742 -> 901
    //   162: aload_1
    //   163: getfield 527	com/tencent/upload/network/session/UploadSession$RequestWapper:fileSizeSent	I
    //   166: iload 6
    //   168: if_icmpge +733 -> 901
    //   171: aload 21
    //   173: invokevirtual 533	java/io/File:length	()J
    //   176: lstore 11
    //   178: lload 11
    //   180: lconst_0
    //   181: lcmp
    //   182: ifne +24 -> 206
    //   185: aload_2
    //   186: sipush 30500
    //   189: putfield 490	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:retrieveResult	I
    //   192: aload_2
    //   193: ldc_w 535
    //   196: putfield 516	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:description	Ljava/lang/String;
    //   199: return
    //   200: iconst_0
    //   201: istore 10
    //   203: goto -52 -> 151
    //   206: iload 4
    //   208: istore 5
    //   210: iload_3
    //   211: ifeq +14 -> 225
    //   214: aload_1
    //   215: getfield 404	com/tencent/upload/network/session/UploadSession$RequestWapper:request	Lcom/tencent/upload/network/action/IActionRequest;
    //   218: invokeinterface 501 1 0
    //   223: istore 5
    //   225: iload 5
    //   227: istore 4
    //   229: iload 6
    //   231: aload_1
    //   232: getfield 527	com/tencent/upload/network/session/UploadSession$RequestWapper:fileSizeSent	I
    //   235: iload 5
    //   237: iadd
    //   238: if_icmpge +12 -> 250
    //   241: iload 6
    //   243: aload_1
    //   244: getfield 527	com/tencent/upload/network/session/UploadSession$RequestWapper:fileSizeSent	I
    //   247: isub
    //   248: istore 4
    //   250: iload 4
    //   252: ifge +18 -> 270
    //   255: aload_2
    //   256: sipush 30700
    //   259: putfield 490	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:retrieveResult	I
    //   262: aload_2
    //   263: ldc_w 537
    //   266: putfield 516	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:description	Ljava/lang/String;
    //   269: return
    //   270: aload_1
    //   271: getfield 404	com/tencent/upload/network/session/UploadSession$RequestWapper:request	Lcom/tencent/upload/network/action/IActionRequest;
    //   274: invokeinterface 540 1 0
    //   279: aload_1
    //   280: getfield 527	com/tencent/upload/network/session/UploadSession$RequestWapper:fileSizeSent	I
    //   283: iadd
    //   284: istore 8
    //   286: iload 4
    //   288: istore 5
    //   290: lload 11
    //   292: iload 8
    //   294: iload 4
    //   296: iadd
    //   297: i2l
    //   298: lcmp
    //   299: ifge +12 -> 311
    //   302: lload 11
    //   304: iload 8
    //   306: i2l
    //   307: lsub
    //   308: l2i
    //   309: istore 5
    //   311: iload 5
    //   313: ifge +55 -> 368
    //   316: aload_2
    //   317: sipush 30700
    //   320: putfield 490	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:retrieveResult	I
    //   323: aload_2
    //   324: new 202	java/lang/StringBuilder
    //   327: dup
    //   328: ldc_w 542
    //   331: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   334: lload 11
    //   336: invokevirtual 545	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   339: ldc_w 547
    //   342: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: iload 8
    //   347: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   350: ldc_w 549
    //   353: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: iload 5
    //   358: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   361: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: putfield 516	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:description	Ljava/lang/String;
    //   367: return
    //   368: iconst_0
    //   369: istore 6
    //   371: aload 18
    //   373: ifnull +160 -> 533
    //   376: aload 18
    //   378: arraylength
    //   379: istore 6
    //   381: iload 6
    //   383: iload 5
    //   385: iadd
    //   386: newarray byte
    //   388: astore_1
    //   389: aload 18
    //   391: iconst_0
    //   392: aload_1
    //   393: iconst_0
    //   394: iload 6
    //   396: invokestatic 453	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   399: aload_1
    //   400: astore 18
    //   402: aconst_null
    //   403: astore 19
    //   405: aconst_null
    //   406: astore_1
    //   407: aconst_null
    //   408: astore 20
    //   410: iconst_0
    //   411: istore 7
    //   413: lconst_0
    //   414: lstore 11
    //   416: new 551	java/io/FileInputStream
    //   419: dup
    //   420: aload 21
    //   422: invokespecial 554	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   425: astore 17
    //   427: iload 8
    //   429: ifgt +113 -> 542
    //   432: lload 11
    //   434: lstore 13
    //   436: iload 7
    //   438: istore 4
    //   440: lload 13
    //   442: iload 8
    //   444: i2l
    //   445: lcmp
    //   446: ifeq +155 -> 601
    //   449: iload 4
    //   451: istore 7
    //   453: aload 17
    //   455: ifnull +8 -> 463
    //   458: aload 17
    //   460: invokevirtual 557	java/io/FileInputStream:close	()V
    //   463: iload 7
    //   465: iload 5
    //   467: if_icmpeq +408 -> 875
    //   470: aload_2
    //   471: sipush 30700
    //   474: putfield 490	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:retrieveResult	I
    //   477: aload_2
    //   478: new 202	java/lang/StringBuilder
    //   481: dup
    //   482: ldc_w 559
    //   485: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   488: iload 7
    //   490: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   493: ldc_w 561
    //   496: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: iload 5
    //   501: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   504: ldc_w 563
    //   507: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: lload 13
    //   512: invokevirtual 545	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   515: ldc_w 547
    //   518: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: iload 8
    //   523: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   526: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: putfield 516	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:description	Ljava/lang/String;
    //   532: return
    //   533: iload 5
    //   535: newarray byte
    //   537: astore 18
    //   539: goto -137 -> 402
    //   542: iload 8
    //   544: i2l
    //   545: lstore 13
    //   547: aload 17
    //   549: lload 13
    //   551: lload 11
    //   553: lsub
    //   554: invokevirtual 567	java/io/FileInputStream:skip	(J)J
    //   557: lstore 15
    //   559: iload 7
    //   561: istore 4
    //   563: lload 11
    //   565: lstore 13
    //   567: lload 15
    //   569: lconst_0
    //   570: lcmp
    //   571: ifle -131 -> 440
    //   574: lload 11
    //   576: lload 15
    //   578: ladd
    //   579: lstore 13
    //   581: lload 13
    //   583: lstore 11
    //   585: lload 13
    //   587: iload 8
    //   589: i2l
    //   590: lcmp
    //   591: ifne -164 -> 427
    //   594: iload 7
    //   596: istore 4
    //   598: goto -158 -> 440
    //   601: aload 17
    //   603: aload 18
    //   605: iload 6
    //   607: iload 4
    //   609: iadd
    //   610: iload 5
    //   612: iload 4
    //   614: isub
    //   615: invokevirtual 571	java/io/FileInputStream:read	([BII)I
    //   618: istore 9
    //   620: iload 4
    //   622: istore 7
    //   624: iload 9
    //   626: ifle -173 -> 453
    //   629: iload 4
    //   631: iload 9
    //   633: iadd
    //   634: istore 7
    //   636: iload 7
    //   638: istore 4
    //   640: iload 7
    //   642: iload 5
    //   644: if_icmpne -204 -> 440
    //   647: goto -194 -> 453
    //   650: astore 18
    //   652: aload 20
    //   654: astore 17
    //   656: aload 17
    //   658: astore_1
    //   659: ldc 40
    //   661: aload 18
    //   663: invokevirtual 572	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   666: invokestatic 293	com/tencent/upload/common/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   669: aload 17
    //   671: astore_1
    //   672: aload_2
    //   673: sipush 30500
    //   676: putfield 490	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:retrieveResult	I
    //   679: aload 17
    //   681: astore_1
    //   682: new 202	java/lang/StringBuilder
    //   685: dup
    //   686: ldc_w 574
    //   689: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   692: astore 19
    //   694: aload 21
    //   696: ifnull +79 -> 775
    //   699: aload 17
    //   701: astore_1
    //   702: new 202	java/lang/StringBuilder
    //   705: dup
    //   706: aload 21
    //   708: invokevirtual 575	java/io/File:toString	()Ljava/lang/String;
    //   711: invokestatic 577	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   714: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   717: ldc_w 579
    //   720: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: aload 21
    //   725: invokevirtual 582	java/io/File:exists	()Z
    //   728: invokevirtual 282	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   731: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   734: astore 18
    //   736: aload 17
    //   738: astore_1
    //   739: aload_2
    //   740: aload 19
    //   742: aload 18
    //   744: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: putfield 516	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:description	Ljava/lang/String;
    //   753: aload 17
    //   755: ifnull -671 -> 84
    //   758: aload 17
    //   760: invokevirtual 557	java/io/FileInputStream:close	()V
    //   763: return
    //   764: astore_1
    //   765: ldc 40
    //   767: aload_1
    //   768: invokevirtual 583	java/io/IOException:toString	()Ljava/lang/String;
    //   771: invokestatic 293	com/tencent/upload/common/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   774: return
    //   775: ldc_w 585
    //   778: astore 18
    //   780: goto -44 -> 736
    //   783: aload 17
    //   785: astore_1
    //   786: ldc 40
    //   788: aload 18
    //   790: invokevirtual 583	java/io/IOException:toString	()Ljava/lang/String;
    //   793: invokestatic 293	com/tencent/upload/common/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   796: aload 17
    //   798: astore_1
    //   799: aload_2
    //   800: sipush 30600
    //   803: putfield 490	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:retrieveResult	I
    //   806: aload 17
    //   808: astore_1
    //   809: aload_2
    //   810: ldc_w 587
    //   813: putfield 516	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:description	Ljava/lang/String;
    //   816: aload 17
    //   818: ifnull -734 -> 84
    //   821: aload 17
    //   823: invokevirtual 557	java/io/FileInputStream:close	()V
    //   826: return
    //   827: astore_1
    //   828: ldc 40
    //   830: aload_1
    //   831: invokevirtual 583	java/io/IOException:toString	()Ljava/lang/String;
    //   834: invokestatic 293	com/tencent/upload/common/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   837: return
    //   838: astore_2
    //   839: aload_1
    //   840: ifnull +7 -> 847
    //   843: aload_1
    //   844: invokevirtual 557	java/io/FileInputStream:close	()V
    //   847: aload_2
    //   848: athrow
    //   849: astore_1
    //   850: ldc 40
    //   852: aload_1
    //   853: invokevirtual 583	java/io/IOException:toString	()Ljava/lang/String;
    //   856: invokestatic 293	com/tencent/upload/common/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   859: goto -12 -> 847
    //   862: astore_1
    //   863: ldc 40
    //   865: aload_1
    //   866: invokevirtual 583	java/io/IOException:toString	()Ljava/lang/String;
    //   869: invokestatic 293	com/tencent/upload/common/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   872: goto -409 -> 463
    //   875: aload_2
    //   876: iload 5
    //   878: putfield 590	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:sendFileSize	I
    //   881: aload 18
    //   883: ifnonnull +94 -> 977
    //   886: aload_2
    //   887: sipush 30700
    //   890: putfield 490	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:retrieveResult	I
    //   893: aload_2
    //   894: ldc_w 592
    //   897: putfield 516	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:description	Ljava/lang/String;
    //   900: return
    //   901: aload 21
    //   903: ifnonnull +23 -> 926
    //   906: iload 6
    //   908: ifle +18 -> 926
    //   911: aload_2
    //   912: sipush 30500
    //   915: putfield 490	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:retrieveResult	I
    //   918: aload_2
    //   919: ldc_w 594
    //   922: putfield 516	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:description	Ljava/lang/String;
    //   925: return
    //   926: aload 17
    //   928: astore 18
    //   930: aload 21
    //   932: ifnull -51 -> 881
    //   935: aload 17
    //   937: astore 18
    //   939: iload 6
    //   941: ifgt -60 -> 881
    //   944: aload_2
    //   945: sipush 30500
    //   948: putfield 490	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:retrieveResult	I
    //   951: aload_2
    //   952: new 202	java/lang/StringBuilder
    //   955: dup
    //   956: ldc_w 596
    //   959: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   962: aload 21
    //   964: invokevirtual 575	java/io/File:toString	()Ljava/lang/String;
    //   967: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   973: putfield 516	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:description	Ljava/lang/String;
    //   976: return
    //   977: aload_2
    //   978: iconst_0
    //   979: putfield 490	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:retrieveResult	I
    //   982: aload_2
    //   983: aload 18
    //   985: putfield 494	com/tencent/upload/network/session/UploadSession$RetrieveSendDataResult:sendData	[B
    //   988: return
    //   989: astore_2
    //   990: aload 17
    //   992: astore_1
    //   993: goto -154 -> 839
    //   996: astore 18
    //   998: goto -215 -> 783
    //   1001: astore 18
    //   1003: goto -347 -> 656
    //   1006: astore 18
    //   1008: aload 19
    //   1010: astore 17
    //   1012: goto -229 -> 783
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1015	0	this	UploadSession
    //   0	1015	1	paramRequestWapper	RequestWapper
    //   0	1015	2	paramRetrieveSendDataResult	RetrieveSendDataResult
    //   0	1015	3	paramBoolean	boolean
    //   45	594	4	i	int
    //   41	836	5	j	int
    //   36	904	6	k	int
    //   411	234	7	m	int
    //   284	304	8	n	int
    //   618	16	9	i1	int
    //   149	53	10	bool	boolean
    //   176	408	11	l1	long
    //   434	152	13	l2	long
    //   557	20	15	l3	long
    //   25	986	17	localObject1	Object
    //   22	582	18	localObject2	Object
    //   650	12	18	localFileNotFoundException1	java.io.FileNotFoundException
    //   734	250	18	localObject3	Object
    //   996	1	18	localIOException1	java.io.IOException
    //   1001	1	18	localFileNotFoundException2	java.io.FileNotFoundException
    //   1006	1	18	localIOException2	java.io.IOException
    //   403	606	19	localStringBuilder	java.lang.StringBuilder
    //   408	245	20	localObject4	Object
    //   19	944	21	localFile	File
    // Exception table:
    //   from	to	target	type
    //   416	427	650	java/io/FileNotFoundException
    //   758	763	764	java/io/IOException
    //   821	826	827	java/io/IOException
    //   416	427	838	finally
    //   659	669	838	finally
    //   672	679	838	finally
    //   682	694	838	finally
    //   702	736	838	finally
    //   739	753	838	finally
    //   786	796	838	finally
    //   799	806	838	finally
    //   809	816	838	finally
    //   843	847	849	java/io/IOException
    //   458	463	862	java/io/IOException
    //   547	559	989	finally
    //   601	620	989	finally
    //   547	559	996	java/io/IOException
    //   601	620	996	java/io/IOException
    //   547	559	1001	java/io/FileNotFoundException
    //   601	620	1001	java/io/FileNotFoundException
    //   416	427	1006	java/io/IOException
  }
  
  private void doSendBegin(int paramInt)
  {
    RequestWapper localRequestWapper = (RequestWapper)this.mSendingMap.get(paramInt);
    if (localRequestWapper == null)
    {
      UploadLog.e("Session", this.mHashCode + " doSendBegin wapper == null");
      return;
    }
    doStartTimeout(localRequestWapper);
  }
  
  private void doSendEnd(int paramInt)
  {
    RequestWapper localRequestWapper = (RequestWapper)this.mSendingMap.get(paramInt);
    if (localRequestWapper == null)
    {
      UploadLog.w("Session", this.mHashCode + " doSendEnd wapper== null");
      return;
    }
    this.mSendingMap.delete(paramInt);
    if (!localRequestWapper.requestHasSentOver())
    {
      paramInt = nextSendSequence();
      this.mSendingMap.put(paramInt, localRequestWapper);
      doSendRequest(localRequestWapper, paramInt);
      return;
    }
    if (this.mHandshakeAction != null) {
      this.mHandshakeAction.onRequest(this, localRequestWapper.request);
    }
    for (;;)
    {
      doSendFirstRequest();
      return;
      IUploadSessionCallback localIUploadSessionCallback = (IUploadSessionCallback)this.mUploadSessionCallback.get();
      if (localIUploadSessionCallback != null) {
        localIUploadSessionCallback.onSend(this, localRequestWapper.request);
      }
    }
  }
  
  private void doSendFirstRequest()
  {
    if (this.mActionRequests.isEmpty()) {
      return;
    }
    RequestWapper localRequestWapper = new RequestWapper((IActionRequest)this.mActionRequests.removeFirst());
    int i = nextSendSequence();
    Connection localConnection = this.mMainConnection;
    if (localConnection != null) {
      localRequestWapper.connectionHashCode = localConnection.hashCode();
    }
    UploadLog.d("Session", this.mHashCode + " doSendFirst: mSendingMap put, sendSeq:" + i + " actSeq:" + localRequestWapper.request.getActionSequence() + " mActionRequests size:" + this.mActionRequests.size());
    this.mSendingMap.put(i, localRequestWapper);
    doSendRequest(localRequestWapper, i);
  }
  
  private void doSendRequest(RequestWapper paramRequestWapper, int paramInt)
  {
    Connection localConnection = null;
    if (this.mMainConnection.hashCode() == paramRequestWapper.connectionHashCode) {
      localConnection = this.mMainConnection;
    }
    if (localConnection == null)
    {
      UploadLog.e("Session", this.mHashCode + " doSendRequest no connection, actSeq:" + paramRequestWapper.request.getActionSequence() + " sendSeq:" + paramInt + " reqSeq:" + paramRequestWapper.request.getActionSequence());
      paramRequestWapper.connectionHashCode = 0;
      doError(localConnection, 31000, "doSendRequest has no connection");
      return;
    }
    RetrieveSendDataResult localRetrieveSendDataResult = new RetrieveSendDataResult(null);
    if (paramRequestWapper.request.isPartFileMode()) {
      doRetrieveSendData(paramRequestWapper, localRetrieveSendDataResult, true);
    }
    while (localRetrieveSendDataResult.retrieveResult != 0)
    {
      UploadLog.e("Session", this.mHashCode + " doSendRequest retrieveResult:" + localRetrieveSendDataResult.retrieveResult + " actSeq:" + paramRequestWapper.request.getActionSequence() + " reqSeq:" + paramRequestWapper.request.getRequestSequence() + " sendSeq:" + paramInt);
      this.mSendingMap.delete(paramInt);
      doError(localConnection, localRetrieveSendDataResult.retrieveResult, localRetrieveSendDataResult.description);
      return;
      doRetrieveSendData(paramRequestWapper, localRetrieveSendDataResult, false);
    }
    int i = getSendTimeout(localRetrieveSendDataResult.sendData.length);
    boolean bool = localConnection.sendAsync(localRetrieveSendDataResult.sendData, paramInt, i, 60000);
    if (!bool)
    {
      UploadLog.e("Session", this.mHashCode + " doSendRequest sendAsync:" + bool);
      this.mSendingMap.delete(paramInt);
      doError(localConnection, 30200, "doSendRequest sendAsync false");
      return;
    }
    localConnection.wakeUp();
    if (localRetrieveSendDataResult.sendEncodeHead) {
      paramRequestWapper.headIsSent = true;
    }
    paramRequestWapper.fileSizeSent += localRetrieveSendDataResult.sendFileSize;
    bool = paramRequestWapper.requestHasSentOver();
    UploadLog.d("Session", this.mHashCode + " doSendRequest:" + bool + " sendSeq:" + paramInt + " actSeq:" + paramRequestWapper.request.getActionSequence() + " reqSeq:" + paramRequestWapper.request.getRequestSequence() + " cmd:" + paramRequestWapper.request.getCommandId() + " HeadS:" + paramRequestWapper.headSizeSent + " fileS:" + paramRequestWapper.fileSizeSent + " totalFileS:" + paramRequestWapper.request.getFileSendLenght());
  }
  
  private void doSendTimeout(IConnectionCallback paramIConnectionCallback, int paramInt1, int paramInt2)
  {
    if (paramIConnectionCallback != this.mMainConnection)
    {
      paramIConnectionCallback = (Connection)paramIConnectionCallback;
      paramIConnectionCallback.stop();
      UploadLog.d("Session", this.mHashCode + " doSendTimeout, !mMainConnection:" + LogPrint.hashCode(paramIConnectionCallback));
    }
    do
    {
      do
      {
        do
        {
          return;
          UploadLog.w("Session", this.mHashCode + " main connection:" + LogPrint.hashCode(paramIConnectionCallback) + " sendSeq:" + paramInt1);
          if (this.mSessionState != 2) {
            break;
          }
          paramIConnectionCallback = (IUploadSessionCallback)this.mUploadSessionCallback.get();
        } while (paramIConnectionCallback == null);
        paramIConnectionCallback.onError(this, 30400, "doSendTimeout reason:" + paramInt2);
        return;
        if (this.mSessionState != 1) {
          break;
        }
        paramIConnectionCallback = (IUploadSessionCallback)this.mUploadSessionCallback.get();
      } while (paramIConnectionCallback == null);
      paramIConnectionCallback.onFailToOpen(this, 1, false);
      return;
    } while (this.mSessionState != 0);
    UploadLog.w("Session", " doSendTimeout at NO_CONNECTION!");
  }
  
  private void doSetSessionState(int paramInt)
  {
    if (this.mSessionState == paramInt) {}
    do
    {
      return;
      this.mSessionState = paramInt;
      UploadLog.d("Session", this.mHashCode + " doSetSessionState：" + IUploadSession.SessionState.print(paramInt));
    } while (paramInt != 0);
    doCleanup();
  }
  
  private void doStartTimeout(RequestWapper paramRequestWapper)
  {
    if ((paramRequestWapper == null) || (paramRequestWapper.runnable != null)) {
      return;
    }
    final int i = paramRequestWapper.request.getRequestSequence();
    if (this.mTimeoutMap.get(i) == paramRequestWapper)
    {
      UploadLog.w("Session", this.mHashCode + " doStartTimeout timeout runnable:" + hashCode() + " reqSeq:" + i + " has start timeout!");
      return;
    }
    Runnable local10 = new Runnable()
    {
      public void run()
      {
        Object localObject2 = UploadSession.this.mTimeoutMap;
        Object localObject1 = (UploadSession.RequestWapper)((SparseArray)localObject2).get(i);
        if ((localObject1 == null) || (((UploadSession.RequestWapper)localObject1).runnable != this)) {
          UploadLog.w("Session", UploadSession.this.mHashCode + " execute timeout runnable:" + hashCode() + " reqSeq:" + i + " has been removed");
        }
        label282:
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                UploadLog.w("Session", UploadSession.this.mHashCode + " execute timeout runnable:" + hashCode() + " reqSeq:" + i + " actSeq:" + ((UploadSession.RequestWapper)localObject1).request.getActionSequence());
                ((SparseArray)localObject2).remove(i);
                UploadSession.this.mHandler.removeCallbacks(((UploadSession.RequestWapper)localObject1).runnable);
                ((UploadSession.RequestWapper)localObject1).runnable = null;
                if (UploadSession.this.mSessionState != 2) {
                  break label282;
                }
                if ((UploadSession.this.mUploadRoute == null) || (UploadSession.this.mUploadRoute.getProtocol() != 1)) {
                  break;
                }
                localObject1 = (IUploadSessionCallback)UploadSession.this.mUploadSessionCallback.get();
              } while (localObject1 == null);
              ((IUploadSessionCallback)localObject1).onError(UploadSession.this, 30800, "tcp data response timeout");
              return;
              localObject2 = (IUploadSessionCallback)UploadSession.this.mUploadSessionCallback.get();
            } while (localObject2 == null);
            ((IUploadSessionCallback)localObject2).onReceiveTimeout(UploadSession.this, ((UploadSession.RequestWapper)localObject1).request);
            return;
            if (UploadSession.this.mSessionState != 1) {
              break;
            }
            UploadSession.this.mHandshakeAction = null;
            localObject1 = (IUploadSessionCallback)UploadSession.this.mUploadSessionCallback.get();
          } while (localObject1 == null);
          ((IUploadSessionCallback)localObject1).onFailToOpen(UploadSession.this, 1, false);
          return;
        } while (UploadSession.this.mSessionState != 0);
        UploadLog.w("Session", UploadSession.this.mHashCode + " execute timeout runnable:" + hashCode() + " reqSeq:" + i + " actSeq:" + ((UploadSession.RequestWapper)localObject1).request.getActionSequence() + " NO_CONNECTION!");
      }
    };
    this.mHandler.removeCallbacks(paramRequestWapper.runnable);
    paramRequestWapper.runnable = local10;
    this.mTimeoutMap.put(i, paramRequestWapper);
    i = getResponseTimeout(paramRequestWapper.request);
    this.mHandler.postDelayed(local10, i);
  }
  
  private static final int getResponseTimeout(IActionRequest paramIActionRequest)
  {
    int j = UploadConfiguration.getDataTimeout();
    boolean bool = NetworkDash.isMobile();
    int i = j;
    if (bool) {
      i = j + j;
    }
    j = i;
    if (paramIActionRequest.isPartFileMode()) {
      if (!bool) {
        break label48;
      }
    }
    label48:
    for (j = 5;; j = 20)
    {
      j = i + paramIActionRequest.getFileSendLenght() / j;
      return j;
    }
  }
  
  private static final int getSendTimeout(int paramInt)
  {
    int i = 60000;
    boolean bool = NetworkDash.isMobile();
    if (bool) {
      i = 60000 + 60000;
    }
    if (bool) {}
    for (int j = 5;; j = 20) {
      return i + paramInt / j;
    }
  }
  
  private static final int nextSendSequence()
  {
    return SEND_SEQUENCE.incrementAndGet();
  }
  
  private void sendHandshake()
  {
    int i = ProtocolUtil.nextRequestSequence();
    Object localObject = new HandshakeAction(i, this.mNeedRedirect, new HandshakeAction.IHandshakeListener()
    {
      public void onFailtoShakeHands(HandshakeAction paramAnonymousHandshakeAction, boolean paramAnonymousBoolean)
      {
        paramAnonymousHandshakeAction = (IUploadSessionCallback)UploadSession.this.mUploadSessionCallback.get();
        if (paramAnonymousHandshakeAction != null) {
          paramAnonymousHandshakeAction.onFailToOpen(UploadSession.this, 1, paramAnonymousBoolean);
        }
      }
      
      public void onFailtoUnpackHandshake(HandshakeAction paramAnonymousHandshakeAction)
      {
        paramAnonymousHandshakeAction = (IUploadSessionCallback)UploadSession.this.mUploadSessionCallback.get();
        if (paramAnonymousHandshakeAction != null) {
          paramAnonymousHandshakeAction.onFailToOpen(UploadSession.this, 2, false);
        }
      }
      
      public void onShakeHands(HandshakeAction paramAnonymousHandshakeAction)
      {
        UploadRoute localUploadRoute = paramAnonymousHandshakeAction.getRedirectRoute();
        if ((localUploadRoute != null) && (UploadSession.this.mUploadRoute != null)) {
          localUploadRoute.setProtocol(UploadSession.this.mUploadRoute.getProtocol());
        }
        UploadSession.this.mRedirectRoute = localUploadRoute;
        UploadConfiguration.setUploadServerTimePair(paramAnonymousHandshakeAction.getUploadServerTimePair());
        UploadSession.this.mClientIp = paramAnonymousHandshakeAction.getClientIp();
        UploadSession.this.doSetSessionState(2);
        paramAnonymousHandshakeAction = (IUploadSessionCallback)UploadSession.this.mUploadSessionCallback.get();
        if (paramAnonymousHandshakeAction != null) {
          paramAnonymousHandshakeAction.onOpen(UploadSession.this);
        }
      }
    });
    if (!((HandshakeAction)localObject).onSend(this))
    {
      UploadLog.w("Session", this.mHashCode + " sendHandshake action send failed");
      localObject = (IUploadSessionCallback)this.mUploadSessionCallback.get();
      if (localObject != null) {
        ((IUploadSessionCallback)localObject).onFailToOpen(this, 1, false);
      }
      return;
    }
    this.mHandshakeRequestSequence = i;
    this.mHandshakeAction = ((HandshakeAction)localObject);
  }
  
  public void cancel(int paramInt)
  {
    Object localObject1 = this.mActionRequests.iterator();
    int i;
    if (!((Iterator)localObject1).hasNext())
    {
      localObject1 = new LinkedList();
      int j = this.mSendingMap.size();
      i = 0;
      if (i < j) {
        break label159;
      }
      label43:
      if (((LinkedList)localObject1).size() > 0) {
        break label293;
      }
      j = this.mTimeoutMap.size();
      i = 0;
      if (i < j) {
        break label314;
      }
    }
    for (;;)
    {
      if (((LinkedList)localObject1).size() <= 0)
      {
        return;
        Object localObject2 = (IActionRequest)((Iterator)localObject1).next();
        if ((localObject2 == null) || (((IActionRequest)localObject2).getActionSequence() != paramInt)) {
          break;
        }
        ((Iterator)localObject1).remove();
        UploadLog.d("Session", this.mHashCode + " cancel: mActionRequests remove: actSeq:" + paramInt + " request:" + LogPrint.hashCode(localObject2));
        break;
        label159:
        localObject2 = (RequestWapper)this.mSendingMap.valueAt(i);
        if ((localObject2 == null) || (((RequestWapper)localObject2).request.getActionSequence() != paramInt)) {}
        int k;
        for (;;)
        {
          i += 1;
          break;
          k = this.mSendingMap.keyAt(i);
          ((LinkedList)localObject1).add(Integer.valueOf(k));
          UploadLog.d("Session", this.mHashCode + " cancel: mSendingMap remove: sendSeq:" + k + " actSeq:" + ((RequestWapper)localObject2).request.getActionSequence() + " reqSeq:" + ((RequestWapper)localObject2).request.getRequestSequence());
        }
        label293:
        this.mSendingMap.remove(((Integer)((LinkedList)localObject1).removeFirst()).intValue());
        break label43;
        label314:
        localObject2 = (RequestWapper)this.mTimeoutMap.valueAt(i);
        if ((localObject2 == null) || (((RequestWapper)localObject2).request.getActionSequence() != paramInt)) {}
        for (;;)
        {
          i += 1;
          break;
          k = this.mTimeoutMap.keyAt(i);
          ((LinkedList)localObject1).add(Integer.valueOf(k));
          UploadLog.d("Session", this.mHashCode + " cancel: mTimeoutMap remove runnable:" + LogPrint.hashCode(((RequestWapper)localObject2).runnable) + "reqSeq:" + k + " actSeq:" + ((RequestWapper)localObject2).request.getActionSequence());
          this.mHandler.removeCallbacks(((RequestWapper)localObject2).runnable);
          ((RequestWapper)localObject2).runnable = null;
        }
      }
      this.mTimeoutMap.remove(((Integer)((LinkedList)localObject1).removeFirst()).intValue());
    }
  }
  
  public void close()
  {
    UploadLog.d("Session", this.mHashCode + " close");
    doClose();
  }
  
  public String getClientIp()
  {
    return this.mClientIp;
  }
  
  public String getConnectedIp()
  {
    return this.mConnectedIp;
  }
  
  public UploadRoute getRedirectRoute()
  {
    return this.mRedirectRoute;
  }
  
  public UploadRoute getUploadRoute()
  {
    return this.mUploadRoute;
  }
  
  public boolean isEstablished()
  {
    return this.mSessionState == 2;
  }
  
  public boolean isIdle()
  {
    return (this.mActionRequests.size() == 0) && (this.mSendingMap.size() == 0) && (this.mTimeoutMap.size() == 0);
  }
  
  public boolean isRedirect()
  {
    return (this.mUploadRoute != null) && (this.mUploadRoute.getRouteCategory() == 2);
  }
  
  public void onConnect(final IConnectionCallback paramIConnectionCallback, final boolean paramBoolean, final int paramInt, final String paramString)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        UploadSession.this.doConnect(paramIConnectionCallback, paramBoolean, paramInt, paramString);
      }
    });
  }
  
  public void onDisconnect(final IConnectionCallback paramIConnectionCallback)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        UploadSession.this.doDisconnect(paramIConnectionCallback);
      }
    });
  }
  
  public void onError(final IConnectionCallback paramIConnectionCallback, final int paramInt)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        UploadLog.w("Session", UploadSession.this.mHashCode + " Connection:" + LogPrint.hashCode(paramIConnectionCallback) + " onError: socketStatus:" + paramInt);
        int i = 30100;
        if ((paramInt == 113) || (paramInt == 101) || (paramInt == 100)) {
          i = 35000;
        }
        for (;;)
        {
          UploadSession.this.doError(paramIConnectionCallback, i, "ndkNetworkError, socketStatus:" + paramInt);
          return;
          if (paramInt == 526) {
            i = 30300;
          }
        }
      }
    });
  }
  
  public void onRecv(final IConnectionCallback paramIConnectionCallback, final byte[] paramArrayOfByte)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        UploadSession.this.doRecv(paramIConnectionCallback, paramArrayOfByte);
      }
    });
  }
  
  public void onSendBegin(IConnectionCallback paramIConnectionCallback, final int paramInt)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        UploadSession.this.doSendBegin(paramInt);
      }
    });
  }
  
  public void onSendEnd(IConnectionCallback paramIConnectionCallback, final int paramInt)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        UploadSession.this.doSendEnd(paramInt);
      }
    });
  }
  
  public void onSendTimeOut(final IConnectionCallback paramIConnectionCallback, final int paramInt1, final int paramInt2)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        UploadSession.this.doSendTimeout(paramIConnectionCallback, paramInt1, paramInt2);
      }
    });
  }
  
  public void onStart(IConnectionCallback paramIConnectionCallback)
  {
    if (paramIConnectionCallback != this.mMainConnection) {
      return;
    }
    UploadLog.d("Session", this.mHashCode + " onStart");
  }
  
  public boolean open(UploadRoute paramUploadRoute)
  {
    return open(paramUploadRoute, UploadConfiguration.getConnectionTimeout());
  }
  
  public boolean open(UploadRoute paramUploadRoute, int paramInt)
  {
    if (this.mSessionState != 0)
    {
      UploadLog.w("Session", this.mHashCode + " open return false, state is illegel");
      return false;
    }
    if (paramUploadRoute == null)
    {
      UploadLog.w("Session", this.mHashCode + " open return false, route is illegel");
      return false;
    }
    int i = paramInt;
    if (paramInt <= 0) {
      i = UploadConfiguration.getConnectionTimeout();
    }
    paramInt = paramUploadRoute.getProtocol();
    if ((this.mUploadRoute != null) && (this.mUploadRoute.getProtocol() != paramInt) && (this.mMainConnection != null)) {
      this.mMainConnection.stop();
    }
    if (paramInt == 1) {
      this.mMainConnection = new TcpConnection(this);
    }
    while (this.mMainConnection == null)
    {
      UploadLog.w("Session", this.mHashCode + " open conn is null");
      return false;
      if (paramInt == 2) {
        this.mMainConnection = new HttpConnection(this);
      }
    }
    if (!this.mMainConnection.start())
    {
      UploadLog.w("Session", this.mHashCode + " open start async failed");
      return false;
    }
    boolean bool = this.mMainConnection.connectAsync(paramUploadRoute.getIp(), paramUploadRoute.getPort(), paramUploadRoute.getProxyIp(), paramUploadRoute.getPorxyPort(), i);
    if (bool)
    {
      this.mUploadRoute = paramUploadRoute;
      doSetSessionState(1);
      return bool;
    }
    this.mUploadRoute = null;
    return bool;
  }
  
  public boolean send(IActionRequest paramIActionRequest)
  {
    if ((this.mSessionState != 2) && (this.mSessionState != 1))
    {
      UploadLog.e("Session", this.mHashCode + " send return false, state is illegel");
      return false;
    }
    if (paramIActionRequest == null)
    {
      UploadLog.e("Session", this.mHashCode + " send return false, request is illegel");
      return false;
    }
    this.mActionRequests.addLast(paramIActionRequest);
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        UploadSession.this.doSendFirstRequest();
      }
    });
    UploadLog.d("Session", this.mHashCode + " send: actSeq:" + paramIActionRequest.getActionSequence() + " reqSeq:" + paramIActionRequest.getRequestSequence() + " mActionRequests:" + this.mActionRequests.size());
    return true;
  }
  
  private static final class RequestWapper
  {
    public int connectionHashCode;
    public int fileSizeSent;
    public boolean headIsSent;
    public int headSizeSent;
    public final IActionRequest request;
    public Runnable runnable;
    
    public RequestWapper(IActionRequest paramIActionRequest)
    {
      this.request = paramIActionRequest;
      this.headIsSent = false;
    }
    
    public boolean requestHasSentOver()
    {
      File localFile = this.request.getFile();
      if (this.fileSizeSent == this.request.getFileSendLenght()) {}
      for (int i = 1; ((!this.headIsSent) || (localFile != null)) && ((!this.headIsSent) || (localFile == null) || (i == 0)); i = 0) {
        return false;
      }
      return true;
    }
  }
  
  private static final class RetrieveSendDataResult
  {
    String description = "";
    int retrieveResult = 0;
    byte[] sendData = null;
    boolean sendEncodeHead = false;
    int sendFileSize = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.session.UploadSession
 * JD-Core Version:    0.7.0.1
 */