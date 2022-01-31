package com.tencent.liteav.screencapture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

public class a
{
  protected Handler a = null;
  protected volatile HandlerThread b = null;
  protected volatile a.a c = null;
  protected volatile WeakReference<c> d = null;
  protected volatile int e = 0;
  protected int f = 720;
  protected int g = 1280;
  protected int h = 20;
  protected boolean i = false;
  private Object j = null;
  
  public a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      b.a().a(paramContext);
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    if (Build.VERSION.SDK_INT < 21)
    {
      a(20000004, null);
      return 20000004;
    }
    a();
    return 0;
  }
  
  /* Error */
  protected void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 89	com/tencent/liteav/screencapture/a:b	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: new 91	android/os/HandlerThread
    //   10: dup
    //   11: ldc 93
    //   13: invokespecial 96	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   16: putfield 39	com/tencent/liteav/screencapture/a:b	Landroid/os/HandlerThread;
    //   19: aload_0
    //   20: getfield 39	com/tencent/liteav/screencapture/a:b	Landroid/os/HandlerThread;
    //   23: invokevirtual 99	android/os/HandlerThread:start	()V
    //   26: aload_0
    //   27: new 8	com/tencent/liteav/screencapture/a$a
    //   30: dup
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 39	com/tencent/liteav/screencapture/a:b	Landroid/os/HandlerThread;
    //   36: invokevirtual 102	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   39: aload_0
    //   40: invokespecial 105	com/tencent/liteav/screencapture/a$a:<init>	(Lcom/tencent/liteav/screencapture/a;Landroid/os/Looper;Lcom/tencent/liteav/screencapture/a;)V
    //   43: putfield 41	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 45	com/tencent/liteav/screencapture/a:e	I
    //   51: iconst_1
    //   52: iadd
    //   53: putfield 45	com/tencent/liteav/screencapture/a:e	I
    //   56: aload_0
    //   57: getfield 41	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   60: aload_0
    //   61: getfield 45	com/tencent/liteav/screencapture/a:e	I
    //   64: putfield 107	com/tencent/liteav/screencapture/a$a:a	I
    //   67: aload_0
    //   68: getfield 41	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   71: aload_0
    //   72: getfield 47	com/tencent/liteav/screencapture/a:f	I
    //   75: putfield 108	com/tencent/liteav/screencapture/a$a:e	I
    //   78: aload_0
    //   79: getfield 41	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   82: aload_0
    //   83: getfield 49	com/tencent/liteav/screencapture/a:g	I
    //   86: putfield 109	com/tencent/liteav/screencapture/a$a:f	I
    //   89: aload_0
    //   90: getfield 41	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   93: astore_2
    //   94: aload_0
    //   95: getfield 51	com/tencent/liteav/screencapture/a:h	I
    //   98: ifgt +19 -> 117
    //   101: iconst_1
    //   102: istore_1
    //   103: aload_2
    //   104: iload_1
    //   105: putfield 110	com/tencent/liteav/screencapture/a$a:g	I
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_0
    //   111: bipush 100
    //   113: invokevirtual 113	com/tencent/liteav/screencapture/a:a	(I)V
    //   116: return
    //   117: aload_0
    //   118: getfield 51	com/tencent/liteav/screencapture/a:h	I
    //   121: istore_1
    //   122: goto -19 -> 103
    //   125: astore_2
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_2
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	a
    //   102	20	1	k	int
    //   93	11	2	locala	a.a
    //   125	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	101	125	finally
    //   103	110	125	finally
    //   117	122	125	finally
    //   126	128	125	finally
  }
  
  protected void a(int paramInt)
  {
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessage(paramInt);
      }
      return;
    }
    finally {}
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    c localc = c();
    if (localc != null) {
      localc.a(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
    }
  }
  
  protected void a(int paramInt, long paramLong)
  {
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessageDelayed(paramInt, paramLong);
      }
      return;
    }
    finally {}
  }
  
  protected void a(int paramInt, Runnable paramRunnable)
  {
    try
    {
      if (this.c != null)
      {
        Message localMessage = new Message();
        localMessage.what = paramInt;
        localMessage.obj = paramRunnable;
        this.c.sendMessage(localMessage);
      }
      return;
    }
    finally {}
  }
  
  protected void a(int paramInt, EGLContext paramEGLContext)
  {
    c localc = c();
    if (localc != null) {
      localc.a(paramInt, paramEGLContext);
    }
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    b.a().a(parama);
  }
  
  public void a(c paramc)
  {
    this.d = new WeakReference(paramc);
  }
  
  public void a(Object paramObject)
  {
    this.j = paramObject;
    b();
  }
  
  public void a(Runnable paramRunnable)
  {
    try
    {
      if (this.c != null) {
        this.c.post(paramRunnable);
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  /* Error */
  public void a(final boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   6: ifnull +23 -> 29
    //   9: aload_0
    //   10: getfield 41	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   13: new 6	com/tencent/liteav/screencapture/a$1
    //   16: dup
    //   17: aload_0
    //   18: iload_1
    //   19: invokespecial 163	com/tencent/liteav/screencapture/a$1:<init>	(Lcom/tencent/liteav/screencapture/a;Z)V
    //   22: invokevirtual 159	com/tencent/liteav/screencapture/a$a:post	(Ljava/lang/Runnable;)Z
    //   25: pop
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: iload_1
    //   31: putfield 53	com/tencent/liteav/screencapture/a:i	Z
    //   34: goto -8 -> 26
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	a
    //   0	42	1	paramBoolean	boolean
    //   37	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	37	finally
    //   26	28	37	finally
    //   29	34	37	finally
    //   38	40	37	finally
  }
  
  protected void b()
  {
    try
    {
      this.e += 1;
      if (this.c != null)
      {
        HandlerThread localHandlerThread = this.b;
        a(101, new a.2(this, this.c, localHandlerThread));
      }
      this.c = null;
      this.b = null;
      return;
    }
    finally {}
  }
  
  protected c c()
  {
    if (this.d == null) {
      return null;
    }
    return (c)this.d.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.screencapture.a
 * JD-Core Version:    0.7.0.1
 */