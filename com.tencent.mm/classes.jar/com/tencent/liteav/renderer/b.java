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
    AppMethodBeat.i(16890);
    this.a = 12440;
    this.b = 4;
    this.j = false;
    this.k = 1280;
    this.l = 720;
    this.m = new Object();
    this.c = paramWeakReference;
    AppMethodBeat.o(16890);
  }
  
  private EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(16901);
    paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, paramEGLContext, new int[] { this.a, 2, 12344 });
    AppMethodBeat.o(16901);
    return paramEGL10;
  }
  
  private void d()
  {
    AppMethodBeat.i(16894);
    try
    {
      a locala = (a)this.c.get();
      if (locala != null) {
        locala.a(this);
      }
      AppMethodBeat.o(16894);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(16894);
    }
  }
  
  private void e()
  {
    AppMethodBeat.i(16895);
    try
    {
      a locala = (a)this.c.get();
      if (locala != null) {
        locala.b(this);
      }
      AppMethodBeat.o(16895);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(16895);
    }
  }
  
  private boolean f()
  {
    AppMethodBeat.i(16896);
    try
    {
      if (this.c != null)
      {
        a locala = (a)this.c.get();
        if (locala != null)
        {
          boolean bool = locala.c();
          AppMethodBeat.o(16896);
          return bool;
        }
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(16896);
    }
    return false;
  }
  
  private void g()
  {
    AppMethodBeat.i(16897);
    if (this.c != null)
    {
      a locala = (a)this.c.get();
      if (locala != null) {
        locala.l();
      }
    }
    AppMethodBeat.o(16897);
  }
  
  private void h()
  {
    AppMethodBeat.i(16898);
    if (this.c != null)
    {
      a locala = (a)this.c.get();
      if (locala != null) {
        locala.m();
      }
    }
    AppMethodBeat.o(16898);
  }
  
  private void i()
  {
    AppMethodBeat.i(16899);
    Object localObject = (a)this.c.get();
    if (localObject == null)
    {
      AppMethodBeat.o(16899);
      return;
    }
    this.d = ((EGL10)EGLContext.getEGL());
    this.f = this.d.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    int[] arrayOfInt = new int[2];
    this.d.eglInitialize(this.f, arrayOfInt);
    this.h = k();
    localObject = ((a)localObject).d();
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
        AppMethodBeat.o(16899);
        throw ((Throwable)localObject);
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(16899);
        return;
      }
      n = this.k;
      i1 = this.l;
    }
    if (!this.d.eglMakeCurrent(this.f, this.g, this.g, this.e))
    {
      RuntimeException localRuntimeException = new RuntimeException("GL Make current Error" + GLUtils.getEGLErrorString(this.d.eglGetError()));
      AppMethodBeat.o(16899);
      throw localRuntimeException;
    }
    AppMethodBeat.o(16899);
  }
  
  private void j()
  {
    AppMethodBeat.i(16900);
    EGL10 localEGL10 = this.d;
    EGLDisplay localEGLDisplay = this.f;
    EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
    localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
    this.d.eglDestroyContext(this.f, this.e);
    this.d.eglDestroySurface(this.f, this.g);
    this.d.eglTerminate(this.f);
    this.i = null;
    TXCLog.w("TXCVideoRenderThread", "vrender: uninit egl @context=" + this.e + ",surface=" + this.g);
    AppMethodBeat.o(16900);
  }
  
  private EGLConfig k()
  {
    AppMethodBeat.i(16902);
    Object localObject = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = l();
    if (!this.d.eglChooseConfig(this.f, arrayOfInt, arrayOfEGLConfig, 1, (int[])localObject))
    {
      localObject = new IllegalArgumentException("Failed to choose config:" + GLUtils.getEGLErrorString(this.d.eglGetError()));
      AppMethodBeat.o(16902);
      throw ((Throwable)localObject);
    }
    if (localObject[0] > 0)
    {
      localObject = arrayOfEGLConfig[0];
      AppMethodBeat.o(16902);
      return localObject;
    }
    AppMethodBeat.o(16902);
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
    AppMethodBeat.i(16892);
    this.j = false;
    c();
    AppMethodBeat.o(16892);
  }
  
  public void c()
  {
    AppMethodBeat.i(16893);
    synchronized (this.m)
    {
      this.m.notifyAll();
      AppMethodBeat.o(16893);
      return;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: sipush 16891
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: new 140	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 231
    //   13: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokevirtual 235	com/tencent/liteav/renderer/b:getId	()J
    //   20: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokevirtual 241	com/tencent/liteav/renderer/b:setName	(Ljava/lang/String;)V
    //   29: aload_0
    //   30: iconst_1
    //   31: putfield 44	com/tencent/liteav/renderer/b:j	Z
    //   34: aload_0
    //   35: invokespecial 243	com/tencent/liteav/renderer/b:i	()V
    //   38: aload_0
    //   39: invokespecial 245	com/tencent/liteav/renderer/b:d	()V
    //   42: aload_0
    //   43: invokespecial 247	com/tencent/liteav/renderer/b:g	()V
    //   46: aload_0
    //   47: getfield 44	com/tencent/liteav/renderer/b:j	Z
    //   50: ifeq +121 -> 171
    //   53: aload_0
    //   54: invokespecial 249	com/tencent/liteav/renderer/b:f	()Z
    //   57: ifeq +62 -> 119
    //   60: aload_0
    //   61: getfield 98	com/tencent/liteav/renderer/b:d	Ljavax/microedition/khronos/egl/EGL10;
    //   64: ifnull +55 -> 119
    //   67: aload_0
    //   68: getfield 107	com/tencent/liteav/renderer/b:f	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   71: ifnull +48 -> 119
    //   74: aload_0
    //   75: getfield 129	com/tencent/liteav/renderer/b:g	Ljavax/microedition/khronos/egl/EGLSurface;
    //   78: ifnull +41 -> 119
    //   81: aload_0
    //   82: getfield 55	com/tencent/liteav/renderer/b:c	Ljava/lang/ref/WeakReference;
    //   85: ifnonnull +72 -> 157
    //   88: aconst_null
    //   89: astore_1
    //   90: aload_1
    //   91: ifnull +28 -> 119
    //   94: aload_1
    //   95: invokevirtual 119	com/tencent/liteav/renderer/a:d	()Landroid/graphics/SurfaceTexture;
    //   98: ifnull +21 -> 119
    //   101: aload_0
    //   102: getfield 98	com/tencent/liteav/renderer/b:d	Ljavax/microedition/khronos/egl/EGL10;
    //   105: aload_0
    //   106: getfield 107	com/tencent/liteav/renderer/b:f	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   109: aload_0
    //   110: getfield 129	com/tencent/liteav/renderer/b:g	Ljavax/microedition/khronos/egl/EGLSurface;
    //   113: invokeinterface 252 3 0
    //   118: pop
    //   119: aload_0
    //   120: getfield 53	com/tencent/liteav/renderer/b:m	Ljava/lang/Object;
    //   123: astore_1
    //   124: aload_1
    //   125: monitorenter
    //   126: aload_0
    //   127: getfield 53	com/tencent/liteav/renderer/b:m	Ljava/lang/Object;
    //   130: invokevirtual 255	java/lang/Object:wait	()V
    //   133: aload_1
    //   134: monitorexit
    //   135: goto -89 -> 46
    //   138: astore_2
    //   139: aload_1
    //   140: monitorexit
    //   141: sipush 16891
    //   144: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload_2
    //   148: athrow
    //   149: astore_1
    //   150: sipush 16891
    //   153: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: return
    //   157: aload_0
    //   158: getfield 55	com/tencent/liteav/renderer/b:c	Ljava/lang/ref/WeakReference;
    //   161: invokevirtual 76	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   164: checkcast 78	com/tencent/liteav/renderer/a
    //   167: astore_1
    //   168: goto -78 -> 90
    //   171: aload_0
    //   172: invokespecial 257	com/tencent/liteav/renderer/b:h	()V
    //   175: aload_0
    //   176: invokespecial 259	com/tencent/liteav/renderer/b:e	()V
    //   179: aload_0
    //   180: invokespecial 261	com/tencent/liteav/renderer/b:j	()V
    //   183: sipush 16891
    //   186: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: return
    //   190: astore_1
    //   191: sipush 16891
    //   194: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: aload_1
    //   198: athrow
    //   199: astore_2
    //   200: goto -67 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	b
    //   149	1	1	localException	Exception
    //   167	1	1	locala	a
    //   190	8	1	localObject2	Object
    //   138	10	2	localObject3	Object
    //   199	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   126	133	138	finally
    //   133	135	138	finally
    //   139	141	138	finally
    //   29	46	149	java/lang/Exception
    //   46	88	149	java/lang/Exception
    //   94	119	149	java/lang/Exception
    //   119	126	149	java/lang/Exception
    //   141	149	149	java/lang/Exception
    //   157	168	149	java/lang/Exception
    //   171	183	149	java/lang/Exception
    //   29	46	190	finally
    //   46	88	190	finally
    //   94	119	190	finally
    //   119	126	190	finally
    //   141	149	190	finally
    //   157	168	190	finally
    //   171	183	190	finally
    //   126	133	199	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.b
 * JD-Core Version:    0.7.0.1
 */