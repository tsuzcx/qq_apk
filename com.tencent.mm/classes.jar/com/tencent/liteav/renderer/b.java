package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

class b
  extends Thread
{
  private WeakReference<a> a;
  private boolean b;
  private int c;
  private int d;
  private Object e;
  private c f;
  private com.tencent.liteav.basic.d.b g;
  private Object h;
  
  b(WeakReference<a> paramWeakReference)
  {
    AppMethodBeat.i(16890);
    this.b = false;
    this.c = 1280;
    this.d = 720;
    this.e = new Object();
    this.f = null;
    this.g = null;
    this.h = null;
    this.a = paramWeakReference;
    AppMethodBeat.o(16890);
  }
  
  private void f()
  {
    AppMethodBeat.i(187387);
    try
    {
      a locala = (a)this.a.get();
      if (locala != null) {
        locala.a(this);
      }
      AppMethodBeat.o(187387);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(187387);
    }
  }
  
  private void g()
  {
    AppMethodBeat.i(16897);
    try
    {
      a locala = (a)this.a.get();
      if (locala != null) {
        locala.b(this);
      }
      AppMethodBeat.o(16897);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(16897);
    }
  }
  
  private boolean h()
  {
    AppMethodBeat.i(187388);
    try
    {
      if (this.a != null)
      {
        a locala = (a)this.a.get();
        if (locala != null)
        {
          boolean bool = locala.c();
          AppMethodBeat.o(187388);
          return bool;
        }
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(187388);
    }
    return false;
  }
  
  private void i()
  {
    AppMethodBeat.i(16899);
    if (this.a != null)
    {
      a locala = (a)this.a.get();
      if (locala != null) {
        locala.k();
      }
    }
    AppMethodBeat.o(16899);
  }
  
  private void j()
  {
    AppMethodBeat.i(16900);
    if (this.a != null)
    {
      a locala = (a)this.a.get();
      if (locala != null) {
        locala.l();
      }
    }
    AppMethodBeat.o(16900);
  }
  
  private void k()
  {
    AppMethodBeat.i(187389);
    Object localObject = (a)this.a.get();
    if (localObject == null)
    {
      AppMethodBeat.o(187389);
      return;
    }
    localObject = ((a)localObject).d();
    if (localObject != null) {}
    for (localObject = new Surface((SurfaceTexture)localObject);; localObject = null)
    {
      if ((this.h == null) || ((this.h instanceof javax.microedition.khronos.egl.EGLContext))) {
        this.g = com.tencent.liteav.basic.d.b.a(null, (javax.microedition.khronos.egl.EGLContext)this.h, (Surface)localObject, this.c, this.d);
      }
      for (;;)
      {
        TXCLog.w("TXCVideoRenderThread", "vrender: init egl share context " + this.h + ", create context" + a());
        e();
        AppMethodBeat.o(187389);
        return;
        this.f = c.a(null, (android.opengl.EGLContext)this.h, (Surface)localObject, this.c, this.d);
      }
    }
  }
  
  private void l()
  {
    AppMethodBeat.i(187390);
    TXCLog.w("TXCVideoRenderThread", "vrender: uninit egl " + a());
    if (this.g != null)
    {
      this.g.c();
      this.g = null;
    }
    if (this.f != null)
    {
      this.f.c();
      this.f = null;
    }
    AppMethodBeat.o(187390);
  }
  
  public Object a()
  {
    AppMethodBeat.i(187386);
    Object localObject;
    if (this.g != null)
    {
      localObject = this.g.d();
      AppMethodBeat.o(187386);
      return localObject;
    }
    if (this.f != null)
    {
      localObject = this.f.e();
      AppMethodBeat.o(187386);
      return localObject;
    }
    AppMethodBeat.o(187386);
    return null;
  }
  
  public void a(Object paramObject)
  {
    this.h = paramObject;
  }
  
  public void b()
  {
    AppMethodBeat.i(16892);
    this.b = false;
    c();
    AppMethodBeat.o(16892);
  }
  
  public void c()
  {
    AppMethodBeat.i(16893);
    synchronized (this.e)
    {
      this.e.notifyAll();
      AppMethodBeat.o(16893);
      return;
    }
  }
  
  public void d()
  {
    AppMethodBeat.i(16894);
    if (this.g != null) {
      this.g.a();
    }
    if (this.f != null) {
      this.f.d();
    }
    AppMethodBeat.o(16894);
  }
  
  public void e()
  {
    AppMethodBeat.i(16895);
    if (this.g != null) {
      this.g.b();
    }
    if (this.f != null) {
      this.f.b();
    }
    AppMethodBeat.o(16895);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: sipush 16891
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: new 102	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 166
    //   13: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokevirtual 170	com/tencent/liteav/renderer/b:getId	()J
    //   20: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokevirtual 176	com/tencent/liteav/renderer/b:setName	(Ljava/lang/String;)V
    //   29: aload_0
    //   30: iconst_1
    //   31: putfield 32	com/tencent/liteav/renderer/b:b	Z
    //   34: aload_0
    //   35: invokespecial 177	com/tencent/liteav/renderer/b:k	()V
    //   38: aload_0
    //   39: invokespecial 179	com/tencent/liteav/renderer/b:f	()V
    //   42: aload_0
    //   43: invokespecial 181	com/tencent/liteav/renderer/b:i	()V
    //   46: aload_0
    //   47: getfield 32	com/tencent/liteav/renderer/b:b	Z
    //   50: ifeq +86 -> 136
    //   53: aload_0
    //   54: invokespecial 183	com/tencent/liteav/renderer/b:h	()Z
    //   57: ifeq +27 -> 84
    //   60: aload_0
    //   61: getfield 49	com/tencent/liteav/renderer/b:a	Ljava/lang/ref/WeakReference;
    //   64: ifnonnull +58 -> 122
    //   67: aconst_null
    //   68: astore_1
    //   69: aload_1
    //   70: ifnull +14 -> 84
    //   73: aload_1
    //   74: invokevirtual 86	com/tencent/liteav/renderer/a:d	()Landroid/graphics/SurfaceTexture;
    //   77: ifnull +7 -> 84
    //   80: aload_0
    //   81: invokevirtual 185	com/tencent/liteav/renderer/b:d	()V
    //   84: aload_0
    //   85: getfield 41	com/tencent/liteav/renderer/b:e	Ljava/lang/Object;
    //   88: astore_1
    //   89: aload_1
    //   90: monitorenter
    //   91: aload_0
    //   92: getfield 41	com/tencent/liteav/renderer/b:e	Ljava/lang/Object;
    //   95: invokevirtual 188	java/lang/Object:wait	()V
    //   98: aload_1
    //   99: monitorexit
    //   100: goto -54 -> 46
    //   103: astore_2
    //   104: aload_1
    //   105: monitorexit
    //   106: sipush 16891
    //   109: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload_2
    //   113: athrow
    //   114: astore_1
    //   115: sipush 16891
    //   118: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: return
    //   122: aload_0
    //   123: getfield 49	com/tencent/liteav/renderer/b:a	Ljava/lang/ref/WeakReference;
    //   126: invokevirtual 64	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   129: checkcast 66	com/tencent/liteav/renderer/a
    //   132: astore_1
    //   133: goto -64 -> 69
    //   136: aload_0
    //   137: invokespecial 190	com/tencent/liteav/renderer/b:j	()V
    //   140: aload_0
    //   141: invokespecial 192	com/tencent/liteav/renderer/b:g	()V
    //   144: aload_0
    //   145: invokespecial 193	com/tencent/liteav/renderer/b:l	()V
    //   148: sipush 16891
    //   151: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: return
    //   155: astore_1
    //   156: sipush 16891
    //   159: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload_1
    //   163: athrow
    //   164: astore_2
    //   165: goto -67 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	b
    //   114	1	1	localException	Exception
    //   132	1	1	locala	a
    //   155	8	1	localObject2	Object
    //   103	10	2	localObject3	Object
    //   164	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   91	98	103	finally
    //   98	100	103	finally
    //   104	106	103	finally
    //   29	46	114	java/lang/Exception
    //   46	67	114	java/lang/Exception
    //   73	84	114	java/lang/Exception
    //   84	91	114	java/lang/Exception
    //   106	114	114	java/lang/Exception
    //   122	133	114	java/lang/Exception
    //   136	148	114	java/lang/Exception
    //   29	46	155	finally
    //   46	67	155	finally
    //   73	84	155	finally
    //   84	91	155	finally
    //   106	114	155	finally
    //   122	133	155	finally
    //   136	148	155	finally
    //   91	98	164	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.b
 * JD-Core Version:    0.7.0.1
 */