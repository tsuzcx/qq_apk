package com.tencent.tmassistant.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.tmassistantbase.a.k;

public abstract class b
  implements ServiceConnection
{
  public static final String CONNTECTSTATE_CONNECTING = "CONNECTING";
  public static final String CONNTECTSTATE_FINISH = "FINISH";
  public static final String CONNTECTSTATE_INIT = "INIT";
  protected static final String TAG = "TMAssistantDownloadClientBase";
  protected String connectState = "INIT";
  public String mClientKey;
  protected Context mContext;
  protected String mDwonloadServiceName = null;
  protected IInterface mServiceCallback = null;
  protected IInterface mServiceInterface = null;
  protected final Object mThreadlock = new Object();
  
  public b(Context paramContext, String paramString1, String paramString2)
  {
    k.c("TMAssistantDownloadClientBase", "enter");
    k.c("TMAssistantDownloadClientBase", "context: " + paramContext + "; clientKey: " + paramString1 + "; downloadServiceName: " + paramString2);
    this.mContext = paramContext;
    this.mClientKey = paramString1;
    this.mDwonloadServiceName = paramString2;
    k.c("TMAssistantDownloadClientBase", "exit");
  }
  
  protected abstract Intent getBindServiceIntent();
  
  protected IInterface getServiceInterface()
  {
    if ((this.mContext != null) && (this.mContext.getMainLooper().getThread().getId() == Thread.currentThread().getId()))
    {
      k.e("TMAssistantDownloadClientBase", "TMAssistantDownloadSDKClient must be called in other Thread(no MainThread)");
      throw new Exception("TMAssistantDownloadSDKClient must be called in other Thread(no MainThread)");
    }
    if (this.mServiceInterface == null)
    {
      initTMAssistantDownloadSDK();
      this.connectState = "CONNECTING";
    }
    synchronized (this.mThreadlock)
    {
      this.mThreadlock.wait(10000L);
      if (this.mServiceInterface == null)
      {
        k.e("TMAssistantDownloadClientBase", "TMAssistantDownloadSDKClient ServiceInterface is null");
        throw new Exception("TMAssistantDownloadSDKClient ServiceInterface is null");
      }
    }
    return this.mServiceInterface;
  }
  
  public boolean initTMAssistantDownloadSDK()
  {
    boolean bool = true;
    try
    {
      k.c("TMAssistantDownloadClientBase", "enter");
      if (this.connectState != "INIT")
      {
        k.c("TMAssistantDownloadClientBase", "returnValue: " + true);
        k.c("TMAssistantDownloadClientBase", "exit");
      }
      for (;;)
      {
        return bool;
        k.c("TMAssistantDownloadClientBase", "clientKey:" + this.mClientKey + ",mServiceInterface:" + this.mServiceInterface + ",threadId:" + Thread.currentThread().getId());
        this.connectState = "INIT";
        if (this.mServiceInterface == null) {
          break;
        }
        this.connectState = "FINISH";
        k.c("TMAssistantDownloadClientBase", "returnValue: " + true);
        k.c("TMAssistantDownloadClientBase", "exit");
      }
      if (this.mContext == null) {
        break label245;
      }
    }
    finally {}
    Object localObject2 = this.mDwonloadServiceName;
    if (localObject2 != null) {}
    for (;;)
    {
      try
      {
        localObject2 = getBindServiceIntent();
        bool = this.mContext.bindService((Intent)localObject2, this, 1);
        k.c("TMAssistantDownloadClientBase", "returnValue: " + bool);
        k.c("TMAssistantDownloadClientBase", "exit");
      }
      catch (Exception localException)
      {
        k.b("TMAssistantDownloadClientBase", "Exception: ", localException);
        localException.printStackTrace();
      }
      label245:
      bool = false;
    }
  }
  
  protected abstract void onDownloadSDKServiceInvalid();
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    k.c("TMAssistantDownloadClientBase", "enter");
    k.c("TMAssistantDownloadClientBase", "ComponentName:" + ??? + "; IBinder:" + paramIBinder);
    stubAsInterface(paramIBinder);
    this.connectState = "FINISH";
    synchronized (this.mThreadlock)
    {
      this.mThreadlock.notifyAll();
      k.c("TMAssistantDownloadClientBase", "clientKey:" + this.mClientKey + ",mServiceInterface:" + this.mServiceInterface + ",IBinder:" + paramIBinder + ",threadId:" + Thread.currentThread().getId());
    }
    try
    {
      if ((this.mServiceInterface != null) && (this.mServiceCallback != null)) {
        registerServiceCallback();
      }
      k.c("TMAssistantDownloadClientBase", "exit");
      return;
      paramIBinder = finally;
      throw paramIBinder;
    }
    catch (RemoteException ???)
    {
      for (;;)
      {
        k.b("TMAssistantDownloadClientBase", "exception:", ???);
        onDownloadSDKServiceInvalid();
      }
    }
  }
  
  /* Error */
  public void onServiceDisconnected(ComponentName arg1)
  {
    // Byte code:
    //   0: ldc 19
    //   2: ldc 46
    //   4: invokestatic 52	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: ldc 19
    //   9: new 54	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   16: ldc 162
    //   18: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 52	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: ldc 19
    //   33: new 54	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   40: ldc 133
    //   42: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 76	com/tencent/tmassistant/common/b:mClientKey	Ljava/lang/String;
    //   49: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 52	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_0
    //   59: monitorenter
    //   60: aload_0
    //   61: aconst_null
    //   62: putfield 40	com/tencent/tmassistant/common/b:mServiceInterface	Landroid/os/IInterface;
    //   65: aload_0
    //   66: ldc 16
    //   68: putfield 38	com/tencent/tmassistant/common/b:connectState	Ljava/lang/String;
    //   71: aload_0
    //   72: getfield 44	com/tencent/tmassistant/common/b:mThreadlock	Ljava/lang/Object;
    //   75: astore_1
    //   76: aload_1
    //   77: monitorenter
    //   78: aload_0
    //   79: getfield 44	com/tencent/tmassistant/common/b:mThreadlock	Ljava/lang/Object;
    //   82: invokevirtual 171	java/lang/Object:notifyAll	()V
    //   85: aload_1
    //   86: monitorexit
    //   87: aload_0
    //   88: invokevirtual 180	com/tencent/tmassistant/common/b:onDownloadSDKServiceInvalid	()V
    //   91: aload_0
    //   92: monitorexit
    //   93: ldc 19
    //   95: ldc 78
    //   97: invokestatic 52	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: return
    //   101: astore_2
    //   102: aload_1
    //   103: monitorexit
    //   104: aload_2
    //   105: athrow
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	b
    //   101	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   78	87	101	finally
    //   102	104	101	finally
    //   60	78	106	finally
    //   87	93	106	finally
    //   104	106	106	finally
    //   107	109	106	finally
  }
  
  protected abstract void registerServiceCallback();
  
  protected abstract void stubAsInterface(IBinder paramIBinder);
  
  /* Error */
  public void unInitTMAssistantDownloadSDK()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 19
    //   4: ldc 46
    //   6: invokestatic 52	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: ldc 19
    //   11: new 54	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   18: ldc 133
    //   20: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 76	com/tencent/tmassistant/common/b:mClientKey	Ljava/lang/String;
    //   27: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 135
    //   32: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: getfield 40	com/tencent/tmassistant/common/b:mServiceInterface	Landroid/os/IInterface;
    //   39: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   42: ldc 137
    //   44: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokestatic 104	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   50: invokevirtual 101	java/lang/Thread:getId	()J
    //   53: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   56: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 52	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_0
    //   63: getfield 40	com/tencent/tmassistant/common/b:mServiceInterface	Landroid/os/IInterface;
    //   66: ifnull +16 -> 82
    //   69: aload_0
    //   70: getfield 42	com/tencent/tmassistant/common/b:mServiceCallback	Landroid/os/IInterface;
    //   73: astore_1
    //   74: aload_1
    //   75: ifnull +7 -> 82
    //   78: aload_0
    //   79: invokevirtual 186	com/tencent/tmassistant/common/b:unRegisterServiceCallback	()V
    //   82: aload_0
    //   83: getfield 74	com/tencent/tmassistant/common/b:mContext	Landroid/content/Context;
    //   86: ifnull +22 -> 108
    //   89: aload_0
    //   90: ifnull +18 -> 108
    //   93: aload_0
    //   94: getfield 40	com/tencent/tmassistant/common/b:mServiceInterface	Landroid/os/IInterface;
    //   97: ifnull +11 -> 108
    //   100: aload_0
    //   101: getfield 74	com/tencent/tmassistant/common/b:mContext	Landroid/content/Context;
    //   104: aload_0
    //   105: invokevirtual 190	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   108: aload_0
    //   109: aconst_null
    //   110: putfield 40	com/tencent/tmassistant/common/b:mServiceInterface	Landroid/os/IInterface;
    //   113: aload_0
    //   114: aconst_null
    //   115: putfield 42	com/tencent/tmassistant/common/b:mServiceCallback	Landroid/os/IInterface;
    //   118: aload_0
    //   119: ldc 16
    //   121: putfield 38	com/tencent/tmassistant/common/b:connectState	Ljava/lang/String;
    //   124: ldc 19
    //   126: ldc 78
    //   128: invokestatic 52	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_0
    //   132: monitorexit
    //   133: return
    //   134: astore_1
    //   135: ldc 19
    //   137: ldc 148
    //   139: aload_1
    //   140: invokestatic 152	com/tencent/tmassistantbase/a/k:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: goto -61 -> 82
    //   146: astore_1
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	b
    //   73	2	1	localIInterface	IInterface
    //   134	6	1	localRemoteException	RemoteException
    //   146	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   78	82	134	android/os/RemoteException
    //   2	74	146	finally
    //   78	82	146	finally
    //   82	89	146	finally
    //   93	108	146	finally
    //   108	131	146	finally
    //   135	143	146	finally
  }
  
  protected abstract void unRegisterServiceCallback();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.b
 * JD-Core Version:    0.7.0.1
 */