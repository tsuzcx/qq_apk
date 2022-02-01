package com.tencent.upload.biz;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.tencent.imageservice.ImageProcessData;
import com.tencent.imageservice.ImageProcessService;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.common.UploadLog;

public class ImageProcessProxy
{
  protected static final int sfWaitBindTime = 10000;
  volatile boolean mBound;
  private final ServiceConnection mConnection = new ServiceConnection()
  {
    /* Error */
    public void onServiceConnected(ComponentName arg1, android.os.IBinder paramAnonymousIBinder)
    {
      // Byte code:
      //   0: ldc 24
      //   2: ldc 25
      //   4: invokestatic 31	com/tencent/upload/common/UploadLog:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   7: aload_0
      //   8: getfield 14	com/tencent/upload/biz/ImageProcessProxy$1:this$0	Lcom/tencent/upload/biz/ImageProcessProxy;
      //   11: new 33	android/os/Messenger
      //   14: dup
      //   15: aload_2
      //   16: invokespecial 36	android/os/Messenger:<init>	(Landroid/os/IBinder;)V
      //   19: putfield 40	com/tencent/upload/biz/ImageProcessProxy:mService	Landroid/os/Messenger;
      //   22: aload_0
      //   23: getfield 14	com/tencent/upload/biz/ImageProcessProxy$1:this$0	Lcom/tencent/upload/biz/ImageProcessProxy;
      //   26: iconst_1
      //   27: putfield 44	com/tencent/upload/biz/ImageProcessProxy:mBound	Z
      //   30: aconst_null
      //   31: iconst_2
      //   32: invokestatic 50	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
      //   35: astore_1
      //   36: aload_1
      //   37: aload_0
      //   38: getfield 14	com/tencent/upload/biz/ImageProcessProxy$1:this$0	Lcom/tencent/upload/biz/ImageProcessProxy;
      //   41: getfield 53	com/tencent/upload/biz/ImageProcessProxy:mMessenger	Landroid/os/Messenger;
      //   44: putfield 56	android/os/Message:replyTo	Landroid/os/Messenger;
      //   47: aload_0
      //   48: getfield 14	com/tencent/upload/biz/ImageProcessProxy$1:this$0	Lcom/tencent/upload/biz/ImageProcessProxy;
      //   51: getfield 40	com/tencent/upload/biz/ImageProcessProxy:mService	Landroid/os/Messenger;
      //   54: ifnull +14 -> 68
      //   57: aload_0
      //   58: getfield 14	com/tencent/upload/biz/ImageProcessProxy$1:this$0	Lcom/tencent/upload/biz/ImageProcessProxy;
      //   61: getfield 40	com/tencent/upload/biz/ImageProcessProxy:mService	Landroid/os/Messenger;
      //   64: aload_1
      //   65: invokevirtual 60	android/os/Messenger:send	(Landroid/os/Message;)V
      //   68: aload_0
      //   69: getfield 14	com/tencent/upload/biz/ImageProcessProxy$1:this$0	Lcom/tencent/upload/biz/ImageProcessProxy;
      //   72: getfield 64	com/tencent/upload/biz/ImageProcessProxy:mProcessCallback	Lcom/tencent/upload/biz/ImageProcessProxy$IImageCompressorCallback;
      //   75: invokeinterface 68 1 0
      //   80: aload_0
      //   81: getfield 14	com/tencent/upload/biz/ImageProcessProxy$1:this$0	Lcom/tencent/upload/biz/ImageProcessProxy;
      //   84: getfield 72	com/tencent/upload/biz/ImageProcessProxy:mLock	[B
      //   87: astore_1
      //   88: aload_1
      //   89: monitorenter
      //   90: aload_0
      //   91: getfield 14	com/tencent/upload/biz/ImageProcessProxy$1:this$0	Lcom/tencent/upload/biz/ImageProcessProxy;
      //   94: getfield 72	com/tencent/upload/biz/ImageProcessProxy:mLock	[B
      //   97: invokevirtual 75	java/lang/Object:notify	()V
      //   100: aload_1
      //   101: monitorexit
      //   102: return
      //   103: astore_1
      //   104: ldc 24
      //   106: ldc 77
      //   108: aload_1
      //   109: invokestatic 81	com/tencent/upload/common/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   112: goto -44 -> 68
      //   115: astore_2
      //   116: aload_1
      //   117: monitorexit
      //   118: aload_2
      //   119: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	120	0	this	1
      //   0	120	2	paramAnonymousIBinder	android.os.IBinder
      // Exception table:
      //   from	to	target	type
      //   47	68	103	java/lang/Exception
      //   90	102	115	finally
      //   116	118	115	finally
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      UploadLog.d("ServiceImpl", "onServiceDisconnected");
      ImageProcessProxy.this.mBound = false;
      ImageProcessProxy.this.mService = null;
    }
  };
  Context mContext = UploadGlobalConfig.getContext();
  byte[] mLock = new byte[0];
  final Messenger mMessenger = new Messenger(new IncomingHandler(null));
  IImageCompressorCallback mProcessCallback;
  Messenger mService = null;
  
  public ImageProcessProxy(IImageCompressorCallback paramIImageCompressorCallback)
  {
    this.mProcessCallback = paramIImageCompressorCallback;
  }
  
  public boolean asyncCopyAndCompressFile(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    UploadLog.v("ServiceImpl", "send MSG_COPY_AND_COMPRESS_IMAGE_REQUEST mBound = " + this.mBound + " flowId=" + paramInt1);
    if (!this.mBound) {
      return false;
    }
    Message localMessage = Message.obtain(null, 1);
    localMessage.arg1 = paramInt1;
    localMessage.replyTo = this.mMessenger;
    paramString2 = FileUtils.getTempFilePath(this.mContext, paramString1, paramString2, paramInt1);
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    localMessage.getData().putParcelable("KEY_MSG_COMPRESS", new ImageProcessData(paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, null));
    try
    {
      if (this.mService != null)
      {
        this.mService.send(localMessage);
        return true;
      }
    }
    catch (Exception paramString1)
    {
      UploadLog.w("ServiceImpl", "ImageCompressor", paramString1);
    }
    return false;
  }
  
  public boolean init()
  {
    if (this.mBound) {
      return true;
    }
    UploadLog.v("ServiceImpl", "start bindService");
    synchronized (this.mLock)
    {
      this.mContext.bindService(new Intent(this.mContext, ImageProcessService.class), this.mConnection, 1);
    }
    try
    {
      this.mLock.wait(10000L);
      label59:
      UploadLog.v("ServiceImpl", "end bindService mBound = " + this.mBound);
      return this.mBound;
      localObject = finally;
      throw localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label59;
    }
  }
  
  public void release()
  {
    if (!this.mBound) {
      return;
    }
    this.mContext.unbindService(this.mConnection);
    this.mBound = false;
  }
  
  public static abstract interface IImageCompressorCallback
  {
    public abstract void onCompressFinish(int paramInt, String paramString1, String paramString2);
    
    public abstract void onPidObtained(int paramInt);
    
    public abstract void onServiceConnected();
  }
  
  @SuppressLint({"HandlerLeak"})
  private class IncomingHandler
    extends Handler
  {
    private IncomingHandler() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        super.handleMessage(paramMessage);
        return;
      case 101: 
        UploadLog.v("ServiceImpl", "receive MSG_COPY_AND_COMPRESS_IMAGE_RESPONSE flowId=" + paramMessage.arg1);
        Object localObject2 = null;
        paramMessage.getData().setClassLoader(ImageProcessData.class.getClassLoader());
        Object localObject4 = paramMessage.getData().getParcelable("KEY_MSG_COMPRESS");
        Object localObject3 = null;
        Object localObject1 = localObject3;
        if ((localObject4 instanceof ImageProcessData))
        {
          ImageProcessData localImageProcessData = (ImageProcessData)localObject4;
          localObject4 = localImageProcessData.originalFilePath;
          localObject1 = localObject3;
          localObject2 = localObject4;
          if (!TextUtils.isEmpty(localImageProcessData.msg))
          {
            UploadLog.d("ServiceImpl", localImageProcessData.msg);
            localObject1 = localImageProcessData.msg;
            localObject2 = localObject4;
          }
        }
        ImageProcessProxy.this.mProcessCallback.onCompressFinish(paramMessage.arg1, localObject2, (String)localObject1);
        return;
      }
      UploadLog.v("ServiceImpl", "receive MSG_OBTAIN_PID_RESPONSE pid:" + paramMessage.arg1);
      ImageProcessProxy.this.mProcessCallback.onPidObtained(paramMessage.arg1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.biz.ImageProcessProxy
 * JD-Core Version:    0.7.0.1
 */