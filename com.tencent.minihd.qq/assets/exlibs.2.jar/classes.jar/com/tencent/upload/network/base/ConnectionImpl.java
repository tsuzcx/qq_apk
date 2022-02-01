package com.tencent.upload.network.base;

import com.tencent.base.os.Native;
import com.tencent.upload.common.UploadLog;
import java.lang.ref.WeakReference;

public class ConnectionImpl
{
  private static final int MSG_ID_ON_CONNECT = 1;
  private static final int MSG_ID_ON_DISCONNECT = 2;
  private static final int MSG_ID_ON_ERROR = 3;
  private static final int MSG_ID_ON_MSGPROC = 8;
  private static final int MSG_ID_ON_RECV = 5;
  private static final int MSG_ID_ON_SENDBEGIN = 6;
  private static final int MSG_ID_ON_SENDEND = 7;
  private static final int MSG_ID_ON_START = 0;
  private static final int MSG_ID_ON_TIMEOUT = 4;
  private static final String TAG = "NavtieConn";
  private static volatile boolean sIsLibraryPrepared;
  private IConnectionCallback mCallback = null;
  private final int mHashCode = hashCode();
  private IMsgCallback mMsgCallback = null;
  private int mNativeContext;
  private final int mType;
  
  static
  {
    boolean bool3 = false;
    sIsLibraryPrepared = false;
    try
    {
      boolean bool2 = Native.loadLibrary("networkbase");
      boolean bool4 = Native.loadLibrary("uploadnetwork");
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = Native.loadLibrary("networkbase");
        }
      }
      native_init();
      bool2 = bool3;
      if (bool1)
      {
        bool2 = bool3;
        if (bool4) {
          bool2 = true;
        }
      }
      sIsLibraryPrepared = bool2;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      UploadLog.e("NavtieConn", localUnsatisfiedLinkError.toString());
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      UploadLog.e("NavtieConn", localNullPointerException.toString());
      return;
    }
    catch (Exception localException)
    {
      UploadLog.e("NavtieConn", localException.toString());
    }
  }
  
  public ConnectionImpl(int paramInt1, int paramInt2)
  {
    this.mType = paramInt1;
    native_setup(new WeakReference(this), this.mType, paramInt2);
    UploadLog.w("NavtieConn", this.mHashCode + " ConnectionImpl");
  }
  
  public static final boolean isLibraryPrepared()
  {
    return sIsLibraryPrepared;
  }
  
  private final native void native_finalize();
  
  private static final native void native_init();
  
  private final native void native_setup(Object paramObject, int paramInt1, int paramInt2);
  
  private void onConnect(boolean paramBoolean, int paramInt, String paramString)
  {
    if (this.mCallback == null) {
      return;
    }
    this.mCallback.onConnect(this.mCallback, paramBoolean, paramInt, paramString);
  }
  
  private void onDisconnect()
  {
    if (this.mCallback == null) {
      return;
    }
    this.mCallback.onDisconnect(this.mCallback);
  }
  
  private void onError(int paramInt)
  {
    if (this.mCallback == null) {
      return;
    }
    this.mCallback.onError(this.mCallback, paramInt);
  }
  
  private void onMsgProc(int paramInt1, Object paramObject, int paramInt2)
  {
    if (this.mMsgCallback == null) {
      return;
    }
    this.mMsgCallback.onMsgCallback(this.mMsgCallback, paramInt1, paramObject, paramInt2);
  }
  
  private void onRecv(byte[] paramArrayOfByte)
  {
    if (this.mCallback == null) {
      return;
    }
    this.mCallback.onRecv(this.mCallback, paramArrayOfByte);
  }
  
  private void onSendBegin(int paramInt)
  {
    if (this.mCallback == null) {
      return;
    }
    this.mCallback.onSendBegin(this.mCallback, paramInt);
  }
  
  private void onSendEnd(int paramInt)
  {
    if (this.mCallback == null) {
      return;
    }
    this.mCallback.onSendEnd(this.mCallback, paramInt);
  }
  
  private void onStart()
  {
    if (this.mCallback == null) {
      return;
    }
    this.mCallback.onStart(this.mCallback);
  }
  
  private void onTimeOut(int paramInt1, int paramInt2)
  {
    if (this.mCallback == null) {
      return;
    }
    this.mCallback.onSendTimeOut(this.mCallback, paramInt1, paramInt2);
  }
  
  private static void postEventFromNative(Object paramObject1, int paramInt1, int paramInt2, int paramInt3, Object paramObject2)
  {
    if (!(paramObject1 instanceof WeakReference))
    {
      UploadLog.w("NavtieConn", "fromNative: !(ConnectionImpl_ref instanceof WeakReference<?>)");
      return;
    }
    paramObject1 = ((WeakReference)paramObject1).get();
    if (!(paramObject1 instanceof ConnectionImpl))
    {
      UploadLog.w("NavtieConn", "fromNative: !(ref instanceof ConnectionImpl)");
      return;
    }
    paramObject1 = (ConnectionImpl)paramObject1;
    int i = paramObject1.getHashCode();
    UploadLog.d("NavtieConn", i + " fromNative:" + print(paramInt1));
    switch (paramInt1)
    {
    default: 
      UploadLog.e("NavtieConn", i + " Unknown message type " + paramInt1);
      return;
    case 0: 
      paramObject1.onStart();
      return;
    case 1: 
      if (paramInt2 != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramObject1.onConnect(bool, paramInt3, (String)paramObject2);
        return;
      }
    case 2: 
      paramObject1.onDisconnect();
      return;
    case 3: 
      paramObject1.onError(paramInt2);
      return;
    case 4: 
      paramObject1.onTimeOut(paramInt2, paramInt3);
      return;
    case 6: 
      paramObject1.onSendBegin(paramInt2);
      return;
    case 7: 
      paramObject1.onSendEnd(paramInt2);
      return;
    case 8: 
      paramObject1.onMsgProc(paramInt2, paramObject2, paramInt3);
      return;
    }
    paramObject1.onRecv((byte[])paramObject2);
  }
  
  private static final String print(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown msg";
    case 0: 
      return "onStart";
    case 1: 
      return "onConnect";
    case 2: 
      return "onDisconnect";
    case 3: 
      return "onError";
    case 4: 
      return "onTimeout";
    case 5: 
      return "onRecv";
    case 6: 
      return "sendBegin";
    case 7: 
      return "sendEnd";
    }
    return "msgProc";
  }
  
  public static void printLog(int paramInt, String paramString)
  {
    UploadLog.d("jni", paramString);
  }
  
  public native boolean PostMessage(int paramInt1, Object paramObject, int paramInt2);
  
  public native boolean SendData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native boolean connect(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4);
  
  public native boolean disconnect();
  
  protected void finalize()
  {
    UploadLog.w("NavtieConn", this.mHashCode + " finalize");
    try
    {
      native_finalize();
      super.finalize();
      return;
    }
    catch (Throwable localThrowable) {}catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public final int getHashCode()
  {
    return this.mHashCode;
  }
  
  public native boolean isRunning();
  
  public native boolean isSendDone(int paramInt);
  
  public native void removeAllSendData();
  
  public native void removeSendData(int paramInt);
  
  public void setCallback(IConnectionCallback paramIConnectionCallback)
  {
    this.mCallback = paramIConnectionCallback;
  }
  
  public void setMsgCallback(IMsgCallback paramIMsgCallback)
  {
    this.mMsgCallback = paramIMsgCallback;
  }
  
  public native boolean start();
  
  public native boolean stop();
  
  public native void wakeUp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.base.ConnectionImpl
 * JD-Core Version:    0.7.0.1
 */