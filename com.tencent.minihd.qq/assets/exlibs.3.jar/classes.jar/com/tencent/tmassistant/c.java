package com.tencent.tmassistant;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.tmassistantbase.a.k;

public abstract class c
  implements ServiceConnection
{
  protected Context b;
  public String c;
  protected String d = null;
  protected String e = "INIT";
  protected IInterface f = null;
  protected IInterface g = null;
  protected final Object h = new Object();
  
  public c(Context paramContext, String paramString1, String paramString2)
  {
    this.b = paramContext;
    this.c = paramString1;
    this.d = paramString2;
  }
  
  protected abstract void a();
  
  protected abstract void a(IBinder paramIBinder);
  
  protected abstract void b();
  
  protected abstract Intent c();
  
  protected abstract void d();
  
  public boolean e()
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        String str = this.e;
        if (str == "FINISH") {
          return bool1;
        }
        k.c("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK,clientKey:" + this.c + ",mServiceInterface:" + this.f + ",threadId:" + Thread.currentThread().getId());
        this.e = "INIT";
        if (this.f != null)
        {
          this.e = "FINISH";
          continue;
        }
        bool2 = false;
      }
      finally {}
      boolean bool2;
      boolean bool3 = false;
      bool1 = bool3;
      if (this.b == null) {
        continue;
      }
      Object localObject2 = this.d;
      bool1 = bool3;
      if (localObject2 == null) {
        continue;
      }
      try
      {
        localObject2 = c();
        bool1 = this.b.bindService((Intent)localObject2, this, 1);
        k.c("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK bindResult:" + bool1);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          bool1 = bool2;
        }
      }
    }
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 49
    //   4: new 51	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   11: ldc 107
    //   13: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: getfield 38	com/tencent/tmassistant/c:c	Ljava/lang/String;
    //   20: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 60
    //   25: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 30	com/tencent/tmassistant/c:f	Landroid/os/IInterface;
    //   32: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: ldc 65
    //   37: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokestatic 71	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   43: invokevirtual 75	java/lang/Thread:getId	()J
    //   46: invokevirtual 78	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 87	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield 30	com/tencent/tmassistant/c:f	Landroid/os/IInterface;
    //   59: ifnull +16 -> 75
    //   62: aload_0
    //   63: getfield 32	com/tencent/tmassistant/c:g	Landroid/os/IInterface;
    //   66: astore_1
    //   67: aload_1
    //   68: ifnull +7 -> 75
    //   71: aload_0
    //   72: invokevirtual 109	com/tencent/tmassistant/c:d	()V
    //   75: aload_0
    //   76: getfield 36	com/tencent/tmassistant/c:b	Landroid/content/Context;
    //   79: ifnull +22 -> 101
    //   82: aload_0
    //   83: ifnull +18 -> 101
    //   86: aload_0
    //   87: getfield 30	com/tencent/tmassistant/c:f	Landroid/os/IInterface;
    //   90: ifnull +11 -> 101
    //   93: aload_0
    //   94: getfield 36	com/tencent/tmassistant/c:b	Landroid/content/Context;
    //   97: aload_0
    //   98: invokevirtual 113	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   101: aload_0
    //   102: aconst_null
    //   103: putfield 30	com/tencent/tmassistant/c:f	Landroid/os/IInterface;
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield 32	com/tencent/tmassistant/c:g	Landroid/os/IInterface;
    //   111: aload_0
    //   112: ldc 26
    //   114: putfield 28	com/tencent/tmassistant/c:e	Ljava/lang/String;
    //   117: aload_0
    //   118: monitorexit
    //   119: return
    //   120: astore_1
    //   121: goto -46 -> 75
    //   124: astore_1
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	c
    //   66	2	1	localIInterface	IInterface
    //   120	1	1	localRemoteException	RemoteException
    //   124	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   71	75	120	android/os/RemoteException
    //   2	67	124	finally
    //   71	75	124	finally
    //   75	82	124	finally
    //   86	101	124	finally
    //   101	117	124	finally
  }
  
  protected IInterface g()
  {
    if ((this.b != null) && (this.b.getMainLooper().getThread().getId() == Thread.currentThread().getId())) {
      throw new Exception("TMAssistantDownloadSDKClient must be called in other Thread(no MainThread)");
    }
    if (this.f == null)
    {
      e();
      this.e = "CONNECTING";
    }
    synchronized (this.h)
    {
      this.h.wait(10000L);
      if (this.f == null) {
        throw new Exception("TMAssistantDownloadSDKClient ServiceInterface is null");
      }
    }
    return this.f;
  }
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    a(paramIBinder);
    this.e = "FINISH";
    synchronized (this.h)
    {
      this.h.notifyAll();
      k.c("TMAssistantDownloadSDKClient", "onServiceConnected,clientKey:" + this.c + ",mServiceInterface:" + this.f + ",IBinder:" + paramIBinder + ",threadId:" + Thread.currentThread().getId());
    }
  }
  
  /* Error */
  public void onServiceDisconnected(ComponentName arg1)
  {
    // Byte code:
    //   0: ldc 49
    //   2: new 51	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   9: ldc 159
    //   11: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_0
    //   15: getfield 38	com/tencent/tmassistant/c:c	Ljava/lang/String;
    //   18: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 87	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_0
    //   28: monitorenter
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 30	com/tencent/tmassistant/c:f	Landroid/os/IInterface;
    //   34: aload_0
    //   35: ldc 26
    //   37: putfield 28	com/tencent/tmassistant/c:e	Ljava/lang/String;
    //   40: aload_0
    //   41: getfield 34	com/tencent/tmassistant/c:h	Ljava/lang/Object;
    //   44: astore_1
    //   45: aload_1
    //   46: monitorenter
    //   47: aload_0
    //   48: getfield 34	com/tencent/tmassistant/c:h	Ljava/lang/Object;
    //   51: invokevirtual 147	java/lang/Object:notifyAll	()V
    //   54: aload_1
    //   55: monitorexit
    //   56: aload_0
    //   57: invokevirtual 155	com/tencent/tmassistant/c:a	()V
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: astore_2
    //   64: aload_1
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	c
    //   63	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   47	56	63	finally
    //   64	66	63	finally
    //   29	47	68	finally
    //   56	62	68	finally
    //   66	68	68	finally
    //   69	71	68	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistant.c
 * JD-Core Version:    0.7.0.1
 */