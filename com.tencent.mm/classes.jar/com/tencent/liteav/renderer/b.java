package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class b
  extends Thread
{
  private int a;
  private int b;
  private WeakReference<a> c;
  private EGL10 d;
  private EGLContext e;
  private EGLDisplay f;
  private EGLSurface g;
  private EGLConfig h;
  private WeakReference<SurfaceTexture> i;
  private boolean j;
  private int k;
  private int l;
  private Object m;
  
  b(WeakReference<a> paramWeakReference)
  {
    AppMethodBeat.i(146751);
    this.a = 12440;
    this.b = 4;
    this.j = false;
    this.k = 1280;
    this.l = 720;
    this.m = new Object();
    this.c = paramWeakReference;
    AppMethodBeat.o(146751);
  }
  
  private EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(67270);
    paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, paramEGLContext, new int[] { this.a, 2, 12344 });
    AppMethodBeat.o(67270);
    return paramEGL10;
  }
  
  private void d()
  {
    AppMethodBeat.i(67264);
    try
    {
      a locala = (a)this.c.get();
      if (locala != null) {
        locala.c();
      }
      AppMethodBeat.o(67264);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(67264);
    }
  }
  
  private void e()
  {
    AppMethodBeat.i(146753);
    try
    {
      a locala = (a)this.c.get();
      if (locala != null) {
        locala.d();
      }
      AppMethodBeat.o(146753);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(146753);
    }
  }
  
  private boolean f()
  {
    AppMethodBeat.i(146754);
    try
    {
      if (this.c != null)
      {
        a locala = (a)this.c.get();
        if (locala != null)
        {
          boolean bool = locala.e();
          AppMethodBeat.o(146754);
          return bool;
        }
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(146754);
    }
    return false;
  }
  
  private void g()
  {
    AppMethodBeat.i(67267);
    if (this.c != null)
    {
      a locala = (a)this.c.get();
      if (locala != null) {
        locala.o();
      }
    }
    AppMethodBeat.o(67267);
  }
  
  private void h()
  {
    AppMethodBeat.i(67268);
    if (this.c != null)
    {
      a locala = (a)this.c.get();
      if (locala != null) {
        locala.p();
      }
    }
    AppMethodBeat.o(67268);
  }
  
  private void i()
  {
    AppMethodBeat.i(67269);
    Object localObject = (a)this.c.get();
    if (localObject == null)
    {
      AppMethodBeat.o(67269);
      return;
    }
    this.d = ((EGL10)EGLContext.getEGL());
    this.f = this.d.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    int[] arrayOfInt = new int[2];
    this.d.eglInitialize(this.f, arrayOfInt);
    this.h = k();
    localObject = ((a)localObject).f();
    if (localObject != null) {
      this.i = new WeakReference(localObject);
    }
    int n;
    int i1;
    for (this.g = this.d.eglCreateWindowSurface(this.f, this.h, localObject, null);; this.g = this.d.eglCreatePbufferSurface(this.f, this.h, new int[] { 12375, n, 12374, i1, 12344 }))
    {
      this.e = a(this.d, this.f, this.h, EGL10.EGL_NO_CONTEXT);
      TXCLog.w("TXCVideoRenderThread", "vrender: init egl @context=" + this.e + ",surface=" + this.g);
      try
      {
        if ((this.g != null) && (this.g != EGL10.EGL_NO_SURFACE)) {
          break;
        }
        localObject = new RuntimeException("GL error:" + GLUtils.getEGLErrorString(this.d.eglGetError()));
        AppMethodBeat.o(67269);
        throw ((Throwable)localObject);
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(67269);
        return;
      }
      n = this.k;
      i1 = this.l;
    }
    if (!this.d.eglMakeCurrent(this.f, this.g, this.g, this.e))
    {
      RuntimeException localRuntimeException = new RuntimeException("GL Make current Error" + GLUtils.getEGLErrorString(this.d.eglGetError()));
      AppMethodBeat.o(67269);
      throw localRuntimeException;
    }
    AppMethodBeat.o(67269);
  }
  
  private void j()
  {
    AppMethodBeat.i(146755);
    EGL10 localEGL10 = this.d;
    EGLDisplay localEGLDisplay = this.f;
    EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
    localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
    this.d.eglDestroyContext(this.f, this.e);
    this.d.eglDestroySurface(this.f, this.g);
    this.d.eglTerminate(this.f);
    this.i = null;
    TXCLog.w("TXCVideoRenderThread", "vrender: uninit egl @context=" + this.e + ",surface=" + this.g);
    AppMethodBeat.o(146755);
  }
  
  private EGLConfig k()
  {
    AppMethodBeat.i(146756);
    Object localObject = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = l();
    if (!this.d.eglChooseConfig(this.f, arrayOfInt, arrayOfEGLConfig, 1, (int[])localObject))
    {
      localObject = new IllegalArgumentException("Failed to choose config:" + GLUtils.getEGLErrorString(this.d.eglGetError()));
      AppMethodBeat.o(146756);
      throw ((Throwable)localObject);
    }
    if (localObject[0] > 0)
    {
      localObject = arrayOfEGLConfig[0];
      AppMethodBeat.o(146756);
      return localObject;
    }
    AppMethodBeat.o(146756);
    return null;
  }
  
  private int[] l()
  {
    return new int[] { 12352, this.b, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344 };
  }
  
  public EGLContext a()
  {
    return this.e;
  }
  
  public void b()
  {
    AppMethodBeat.i(146752);
    this.j = false;
    c();
    AppMethodBeat.o(146752);
  }
  
  public void c()
  {
    AppMethodBeat.i(67263);
    synchronized (this.m)
    {
      this.m.notifyAll();
      AppMethodBeat.o(67263);
      return;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 242
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: new 149	java/lang/StringBuilder
    //   9: dup
    //   10: ldc 244
    //   12: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: invokevirtual 248	com/tencent/liteav/renderer/b:getId	()J
    //   19: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   22: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokevirtual 254	com/tencent/liteav/renderer/b:setName	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 45	com/tencent/liteav/renderer/b:j	Z
    //   33: aload_0
    //   34: invokespecial 256	com/tencent/liteav/renderer/b:i	()V
    //   37: aload_0
    //   38: invokespecial 257	com/tencent/liteav/renderer/b:d	()V
    //   41: aload_0
    //   42: invokespecial 259	com/tencent/liteav/renderer/b:g	()V
    //   45: aload_0
    //   46: getfield 45	com/tencent/liteav/renderer/b:j	Z
    //   49: ifeq +119 -> 168
    //   52: aload_0
    //   53: invokespecial 261	com/tencent/liteav/renderer/b:f	()Z
    //   56: ifeq +62 -> 118
    //   59: aload_0
    //   60: getfield 106	com/tencent/liteav/renderer/b:d	Ljavax/microedition/khronos/egl/EGL10;
    //   63: ifnull +55 -> 118
    //   66: aload_0
    //   67: getfield 115	com/tencent/liteav/renderer/b:f	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   70: ifnull +48 -> 118
    //   73: aload_0
    //   74: getfield 138	com/tencent/liteav/renderer/b:g	Ljavax/microedition/khronos/egl/EGLSurface;
    //   77: ifnull +41 -> 118
    //   80: aload_0
    //   81: getfield 56	com/tencent/liteav/renderer/b:c	Ljava/lang/ref/WeakReference;
    //   84: ifnonnull +70 -> 154
    //   87: aconst_null
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +28 -> 118
    //   93: aload_1
    //   94: invokevirtual 127	com/tencent/liteav/renderer/a:f	()Landroid/graphics/SurfaceTexture;
    //   97: ifnull +21 -> 118
    //   100: aload_0
    //   101: getfield 106	com/tencent/liteav/renderer/b:d	Ljavax/microedition/khronos/egl/EGL10;
    //   104: aload_0
    //   105: getfield 115	com/tencent/liteav/renderer/b:f	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   108: aload_0
    //   109: getfield 138	com/tencent/liteav/renderer/b:g	Ljavax/microedition/khronos/egl/EGLSurface;
    //   112: invokeinterface 264 3 0
    //   117: pop
    //   118: aload_0
    //   119: getfield 54	com/tencent/liteav/renderer/b:m	Ljava/lang/Object;
    //   122: astore_1
    //   123: aload_1
    //   124: monitorenter
    //   125: aload_0
    //   126: getfield 54	com/tencent/liteav/renderer/b:m	Ljava/lang/Object;
    //   129: invokevirtual 267	java/lang/Object:wait	()V
    //   132: aload_1
    //   133: monitorexit
    //   134: goto -89 -> 45
    //   137: astore_2
    //   138: aload_1
    //   139: monitorexit
    //   140: ldc 242
    //   142: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_2
    //   146: athrow
    //   147: astore_1
    //   148: ldc 242
    //   150: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: return
    //   154: aload_0
    //   155: getfield 56	com/tencent/liteav/renderer/b:c	Ljava/lang/ref/WeakReference;
    //   158: invokevirtual 79	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   161: checkcast 81	com/tencent/liteav/renderer/a
    //   164: astore_1
    //   165: goto -76 -> 89
    //   168: aload_0
    //   169: invokespecial 269	com/tencent/liteav/renderer/b:h	()V
    //   172: aload_0
    //   173: invokespecial 271	com/tencent/liteav/renderer/b:e	()V
    //   176: aload_0
    //   177: invokespecial 273	com/tencent/liteav/renderer/b:j	()V
    //   180: ldc 242
    //   182: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: return
    //   186: astore_1
    //   187: ldc 242
    //   189: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aload_1
    //   193: athrow
    //   194: astore_2
    //   195: goto -63 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	b
    //   147	1	1	localException	Exception
    //   164	1	1	locala	a
    //   186	7	1	localObject2	Object
    //   137	9	2	localObject3	Object
    //   194	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   125	132	137	finally
    //   132	134	137	finally
    //   138	140	137	finally
    //   28	45	147	java/lang/Exception
    //   45	87	147	java/lang/Exception
    //   93	118	147	java/lang/Exception
    //   118	125	147	java/lang/Exception
    //   140	147	147	java/lang/Exception
    //   154	165	147	java/lang/Exception
    //   168	180	147	java/lang/Exception
    //   28	45	186	finally
    //   45	87	186	finally
    //   93	118	186	finally
    //   118	125	186	finally
    //   140	147	186	finally
    //   154	165	186	finally
    //   168	180	186	finally
    //   125	132	194	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.renderer.b
 * JD-Core Version:    0.7.0.1
 */