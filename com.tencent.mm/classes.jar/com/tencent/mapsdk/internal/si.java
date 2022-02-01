package com.tencent.mapsdk.internal;

import android.opengl.GLUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

public final class si
  extends Thread
{
  private static float d = 60.0F;
  private static final int m = 12440;
  private static final int n = 4;
  private static long q = 1500L;
  private static final String r = "TextureGLRenderThread";
  private WeakReference<sj> a;
  private AtomicBoolean b;
  private AtomicBoolean c;
  private WeakReference<Object> e;
  private volatile boolean f;
  private EGLConfig g;
  private EGL10 h;
  private EGLDisplay i;
  private EGLContext j;
  private EGLSurface k;
  private GL l;
  private volatile long o;
  private boolean p;
  
  public si(sj paramsj)
  {
    AppMethodBeat.i(224202);
    this.b = new AtomicBoolean(true);
    this.c = new AtomicBoolean(false);
    this.f = false;
    this.g = null;
    this.i = EGL10.EGL_NO_DISPLAY;
    this.j = EGL10.EGL_NO_CONTEXT;
    this.k = EGL10.EGL_NO_SURFACE;
    this.o = 0L;
    this.p = false;
    this.a = new WeakReference(paramsj);
    setName(ss.a("TR"));
    AppMethodBeat.o(224202);
  }
  
  public static void a(float paramFloat)
  {
    AppMethodBeat.i(224290);
    if (paramFloat <= 0.0F)
    {
      kh.e("TRD", "帧率设置不在有效值范围内");
      AppMethodBeat.o(224290);
      return;
    }
    d = paramFloat;
    AppMethodBeat.o(224290);
  }
  
  private boolean e()
  {
    AppMethodBeat.i(224226);
    try
    {
      if (this.e != null)
      {
        localObject = this.e.get();
        if (localObject != null) {}
      }
      else
      {
        AppMethodBeat.o(224226);
        return false;
      }
      Object localObject = this.e.get();
      this.h = ((EGL10)EGLContext.getEGL());
      this.i = this.h.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      if (this.i == EGL10.EGL_NO_DISPLAY)
      {
        kh.d("TextureGLRenderThread", "eglGetdisplay failed,mEglDisplay == EGL10.EGL_NO_DISPLAY,errorDetail:" + GLUtils.getEGLErrorString(this.h.eglGetError()));
        AppMethodBeat.o(224226);
        return false;
      }
      int[] arrayOfInt = new int[2];
      if (!this.h.eglInitialize(this.i, arrayOfInt))
      {
        kh.d("TextureGLRenderThread", "eglInitialize failed,errorDetail:" + GLUtils.getEGLErrorString(this.h.eglGetError()));
        AppMethodBeat.o(224226);
        return false;
      }
      arrayOfInt = new int[1];
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      if (!this.h.eglChooseConfig(this.i, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 0, 12352, 4, 12344 }, arrayOfEGLConfig, 1, arrayOfInt))
      {
        kh.d("TextureGLRenderThread", "eglChooseConfig failed,errorDetail:" + GLUtils.getEGLErrorString(this.h.eglGetError()));
        AppMethodBeat.o(224226);
        return false;
      }
      this.g = arrayOfEGLConfig[0];
      this.k = this.h.eglCreateWindowSurface(this.i, this.g, localObject, null);
      if (this.k == EGL10.EGL_NO_SURFACE)
      {
        kh.d("TextureGLRenderThread", "eglCreateWindowSurface failed,mEglSurface == EGL10.EGL_NO_SURFACE,errorDetail:" + GLUtils.getEGLErrorString(this.h.eglGetError()));
        AppMethodBeat.o(224226);
        return false;
      }
      this.j = this.h.eglCreateContext(this.i, arrayOfEGLConfig[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
      if (this.j == EGL10.EGL_NO_CONTEXT)
      {
        kh.d("TextureGLRenderThread", "eglCreateContext failed,mEglContext == EGL10.EGL_NO_CONTEXT,errorDetail:" + GLUtils.getEGLErrorString(this.h.eglGetError()));
        AppMethodBeat.o(224226);
        return false;
      }
      if (!this.h.eglMakeCurrent(this.i, this.k, this.k, this.j))
      {
        kh.d("TextureGLRenderThread", "eglMakeCurrent failed,errorDetail:" + GLUtils.getEGLErrorString(this.h.eglGetError()));
        AppMethodBeat.o(224226);
        return false;
      }
      this.l = this.j.getGL();
    }
    finally
    {
      for (;;)
      {
        kh.d("TextureGLRenderThread", "initializeGLContext failed,errorDetail:" + Log.getStackTraceString(localThrowable));
      }
    }
    AppMethodBeat.o(224226);
    return true;
  }
  
  private void f()
  {
    AppMethodBeat.i(224237);
    while (this.b.get())
    {
      g();
      try
      {
        if (this.e != null)
        {
          Object localObject = this.e.get();
          if (localObject != null) {}
        }
        else
        {
          AppMethodBeat.o(224237);
          return;
        }
        this.k = this.h.eglCreateWindowSurface(this.i, this.g, this.e.get(), null);
        if (this.k != EGL10.EGL_NO_SURFACE) {
          break label146;
        }
        kh.d("TextureGLRenderThread", "eglCreateWindowSurface failed,errorDetail:" + GLUtils.getEGLErrorString(this.h.eglGetError()));
        continue;
      }
      finally
      {
        kh.d("TextureGLRenderThread", "updateSurface failed,errorDetail:" + Log.getStackTraceString(localThrowable));
      }
      continue;
      label146:
      if (!this.h.eglMakeCurrent(this.i, this.k, this.k, this.j))
      {
        kh.d("TextureGLRenderThread", "eglMakeCurrent failed,errorDetail:" + GLUtils.getEGLErrorString(this.h.eglGetError()));
      }
      else
      {
        AppMethodBeat.o(224237);
        return;
      }
    }
    AppMethodBeat.o(224237);
  }
  
  private void g()
  {
    AppMethodBeat.i(224246);
    if ((this.k == null) || (this.k == EGL10.EGL_NO_SURFACE))
    {
      kh.d("TRD", "the EglSurface is null or status is EGL_NO_SURFACE");
      AppMethodBeat.o(224246);
      return;
    }
    this.h.eglDestroySurface(this.i, this.k);
    this.k = EGL10.EGL_NO_SURFACE;
    AppMethodBeat.o(224246);
  }
  
  private void h()
  {
    AppMethodBeat.i(224254);
    if ((this.j == null) || (this.j == EGL10.EGL_NO_CONTEXT))
    {
      kh.d("TRD", "the EglContext is null or status is EGL_NO_CONTEXT");
      AppMethodBeat.o(224254);
      return;
    }
    this.h.eglDestroyContext(this.i, this.j);
    this.j = EGL10.EGL_NO_CONTEXT;
    AppMethodBeat.o(224254);
  }
  
  private void i()
  {
    AppMethodBeat.i(224264);
    if ((this.i == null) || (this.i == EGL10.EGL_NO_DISPLAY))
    {
      kh.d("TRD", "the EglDisplay is null or status is EGL_NO_DISPLAY");
      AppMethodBeat.o(224264);
      return;
    }
    this.h.eglTerminate(this.i);
    this.i = EGL10.EGL_NO_DISPLAY;
    AppMethodBeat.o(224264);
  }
  
  private void j()
  {
    AppMethodBeat.i(224277);
    g();
    if ((this.j == null) || (this.j == EGL10.EGL_NO_CONTEXT)) {
      kh.d("TRD", "the EglContext is null or status is EGL_NO_CONTEXT");
    }
    while ((this.i == null) || (this.i == EGL10.EGL_NO_DISPLAY))
    {
      kh.d("TRD", "the EglDisplay is null or status is EGL_NO_DISPLAY");
      AppMethodBeat.o(224277);
      return;
      this.h.eglDestroyContext(this.i, this.j);
      this.j = EGL10.EGL_NO_CONTEXT;
    }
    this.h.eglTerminate(this.i);
    this.i = EGL10.EGL_NO_DISPLAY;
    AppMethodBeat.o(224277);
  }
  
  public final void a()
  {
    AppMethodBeat.i(224339);
    this.c.set(true);
    try
    {
      notifyAll();
      return;
    }
    finally
    {
      AppMethodBeat.o(224339);
    }
  }
  
  public final void a(Object paramObject)
  {
    AppMethodBeat.i(224377);
    if ((this.e != null) && (this.e.get() != null)) {
      this.f = true;
    }
    this.e = new WeakReference(paramObject);
    try
    {
      notifyAll();
      return;
    }
    finally
    {
      AppMethodBeat.o(224377);
    }
  }
  
  public final void b()
  {
    AppMethodBeat.i(224352);
    this.c.set(false);
    try
    {
      notifyAll();
      return;
    }
    finally
    {
      AppMethodBeat.o(224352);
    }
  }
  
  public final void c()
  {
    AppMethodBeat.i(224363);
    this.b.set(false);
    this.c.set(false);
    try
    {
      notifyAll();
      interrupt();
      AppMethodBeat.o(224363);
      return;
    }
    finally
    {
      AppMethodBeat.o(224363);
    }
  }
  
  public final void d()
  {
    AppMethodBeat.i(224388);
    this.p = true;
    this.o = System.currentTimeMillis();
    AppMethodBeat.o(224388);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc_w 282
    //   3: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 284	java/lang/Thread:run	()V
    //   10: aload_0
    //   11: getfield 105	com/tencent/mapsdk/internal/si:a	Ljava/lang/ref/WeakReference;
    //   14: ifnull +26 -> 40
    //   17: aload_0
    //   18: getfield 105	com/tencent/mapsdk/internal/si:a	Ljava/lang/ref/WeakReference;
    //   21: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   24: ifnull +16 -> 40
    //   27: aload_0
    //   28: getfield 105	com/tencent/mapsdk/internal/si:a	Ljava/lang/ref/WeakReference;
    //   31: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   34: checkcast 286	com/tencent/mapsdk/internal/sj
    //   37: invokevirtual 289	com/tencent/mapsdk/internal/sj:D	()V
    //   40: iconst_0
    //   41: istore_2
    //   42: aload_0
    //   43: getfield 71	com/tencent/mapsdk/internal/si:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   46: invokevirtual 228	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   49: ifeq +557 -> 606
    //   52: aload_0
    //   53: getfield 71	com/tencent/mapsdk/internal/si:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   56: invokevirtual 228	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   59: ifeq +44 -> 103
    //   62: aload_0
    //   63: getfield 133	com/tencent/mapsdk/internal/si:e	Ljava/lang/ref/WeakReference;
    //   66: ifnull +13 -> 79
    //   69: aload_0
    //   70: getfield 133	com/tencent/mapsdk/internal/si:e	Ljava/lang/ref/WeakReference;
    //   73: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   76: ifnonnull +27 -> 103
    //   79: aload_0
    //   80: monitorenter
    //   81: aload_0
    //   82: invokevirtual 292	java/lang/Object:wait	()V
    //   85: aload_0
    //   86: monitorexit
    //   87: goto -35 -> 52
    //   90: astore 7
    //   92: aload_0
    //   93: monitorexit
    //   94: ldc_w 282
    //   97: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload 7
    //   102: athrow
    //   103: iload_2
    //   104: ifne +665 -> 769
    //   107: aload_0
    //   108: invokespecial 294	com/tencent/mapsdk/internal/si:e	()Z
    //   111: istore_2
    //   112: iload_2
    //   113: ifeq +653 -> 766
    //   116: aload_0
    //   117: monitorenter
    //   118: aload_0
    //   119: getfield 71	com/tencent/mapsdk/internal/si:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   122: invokevirtual 228	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   125: ifeq +82 -> 207
    //   128: aload_0
    //   129: getfield 73	com/tencent/mapsdk/internal/si:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   132: invokevirtual 228	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   135: ifeq +72 -> 207
    //   138: aload_0
    //   139: invokevirtual 292	java/lang/Object:wait	()V
    //   142: goto -24 -> 118
    //   145: astore 7
    //   147: aload_0
    //   148: monitorexit
    //   149: ldc_w 282
    //   152: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aload 7
    //   157: athrow
    //   158: astore 7
    //   160: aload_0
    //   161: getfield 71	com/tencent/mapsdk/internal/si:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   164: invokevirtual 228	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   167: ifne +11 -> 178
    //   170: aload 7
    //   172: instanceof 281
    //   175: ifne +29 -> 204
    //   178: ldc 20
    //   180: new 155	java/lang/StringBuilder
    //   183: dup
    //   184: ldc_w 296
    //   187: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   190: aload 7
    //   192: invokestatic 225	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   195: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 179	com/tencent/mapsdk/internal/kh:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: goto -162 -> 42
    //   207: aload_0
    //   208: monitorexit
    //   209: aload_0
    //   210: getfield 75	com/tencent/mapsdk/internal/si:f	Z
    //   213: ifeq +52 -> 265
    //   216: aload_0
    //   217: getfield 71	com/tencent/mapsdk/internal/si:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   220: invokevirtual 228	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   223: ifeq +28 -> 251
    //   226: aload_0
    //   227: invokespecial 230	com/tencent/mapsdk/internal/si:g	()V
    //   230: aload_0
    //   231: getfield 133	com/tencent/mapsdk/internal/si:e	Ljava/lang/ref/WeakReference;
    //   234: ifnull +17 -> 251
    //   237: aload_0
    //   238: getfield 133	com/tencent/mapsdk/internal/si:e	Ljava/lang/ref/WeakReference;
    //   241: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   244: astore 7
    //   246: aload 7
    //   248: ifnonnull +159 -> 407
    //   251: aload_0
    //   252: iconst_1
    //   253: putfield 98	com/tencent/mapsdk/internal/si:p	Z
    //   256: aload_0
    //   257: iconst_0
    //   258: putfield 75	com/tencent/mapsdk/internal/si:f	Z
    //   261: aload_0
    //   262: invokevirtual 298	com/tencent/mapsdk/internal/si:d	()V
    //   265: aload_0
    //   266: getfield 105	com/tencent/mapsdk/internal/si:a	Ljava/lang/ref/WeakReference;
    //   269: ifnull +305 -> 574
    //   272: aload_0
    //   273: getfield 105	com/tencent/mapsdk/internal/si:a	Ljava/lang/ref/WeakReference;
    //   276: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   279: ifnull +295 -> 574
    //   282: aload_0
    //   283: getfield 105	com/tencent/mapsdk/internal/si:a	Ljava/lang/ref/WeakReference;
    //   286: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   289: checkcast 286	com/tencent/mapsdk/internal/sj
    //   292: astore 7
    //   294: aload_0
    //   295: getfield 98	com/tencent/mapsdk/internal/si:p	Z
    //   298: ifeq +279 -> 577
    //   301: invokestatic 278	java/lang/System:currentTimeMillis	()J
    //   304: aload_0
    //   305: getfield 96	com/tencent/mapsdk/internal/si:o	J
    //   308: lsub
    //   309: getstatic 53	com/tencent/mapsdk/internal/si:q	J
    //   312: lcmp
    //   313: ifge +264 -> 577
    //   316: aload 7
    //   318: ifnull +8 -> 326
    //   321: aload 7
    //   323: invokevirtual 301	com/tencent/mapsdk/internal/sj:H	()V
    //   326: invokestatic 278	java/lang/System:currentTimeMillis	()J
    //   329: lstore_3
    //   330: aload 7
    //   332: ifnull +36 -> 368
    //   335: aload 7
    //   337: aload_0
    //   338: getfield 217	com/tencent/mapsdk/internal/si:l	Ljavax/microedition/khronos/opengles/GL;
    //   341: checkcast 303	javax/microedition/khronos/opengles/GL10
    //   344: invokevirtual 306	com/tencent/mapsdk/internal/sj:a	(Ljavax/microedition/khronos/opengles/GL10;)Z
    //   347: ifeq +21 -> 368
    //   350: aload_0
    //   351: getfield 145	com/tencent/mapsdk/internal/si:h	Ljavax/microedition/khronos/egl/EGL10;
    //   354: aload_0
    //   355: getfield 84	com/tencent/mapsdk/internal/si:i	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   358: aload_0
    //   359: getfield 94	com/tencent/mapsdk/internal/si:k	Ljavax/microedition/khronos/egl/EGLSurface;
    //   362: invokeinterface 309 3 0
    //   367: pop
    //   368: invokestatic 278	java/lang/System:currentTimeMillis	()J
    //   371: lstore 5
    //   373: ldc_w 310
    //   376: getstatic 49	com/tencent/mapsdk/internal/si:d	F
    //   379: fdiv
    //   380: lload 5
    //   382: lload_3
    //   383: lsub
    //   384: l2f
    //   385: fsub
    //   386: f2i
    //   387: istore_1
    //   388: iload_1
    //   389: ifle +214 -> 603
    //   392: aload_0
    //   393: monitorenter
    //   394: iload_1
    //   395: i2l
    //   396: lstore_3
    //   397: aload_0
    //   398: lload_3
    //   399: invokevirtual 313	java/lang/Object:wait	(J)V
    //   402: aload_0
    //   403: monitorexit
    //   404: goto -362 -> 42
    //   407: aload_0
    //   408: aload_0
    //   409: getfield 145	com/tencent/mapsdk/internal/si:h	Ljavax/microedition/khronos/egl/EGL10;
    //   412: aload_0
    //   413: getfield 84	com/tencent/mapsdk/internal/si:i	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   416: aload_0
    //   417: getfield 77	com/tencent/mapsdk/internal/si:g	Ljavax/microedition/khronos/egl/EGLConfig;
    //   420: aload_0
    //   421: getfield 133	com/tencent/mapsdk/internal/si:e	Ljava/lang/ref/WeakReference;
    //   424: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   427: aconst_null
    //   428: invokeinterface 197 5 0
    //   433: putfield 94	com/tencent/mapsdk/internal/si:k	Ljavax/microedition/khronos/egl/EGLSurface;
    //   436: aload_0
    //   437: getfield 94	com/tencent/mapsdk/internal/si:k	Ljavax/microedition/khronos/egl/EGLSurface;
    //   440: getstatic 92	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
    //   443: if_acmpne +68 -> 511
    //   446: ldc 20
    //   448: new 155	java/lang/StringBuilder
    //   451: dup
    //   452: ldc 232
    //   454: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   457: aload_0
    //   458: getfield 145	com/tencent/mapsdk/internal/si:h	Ljavax/microedition/khronos/egl/EGL10;
    //   461: invokeinterface 163 1 0
    //   466: invokestatic 169	android/opengl/GLUtils:getEGLErrorString	(I)Ljava/lang/String;
    //   469: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 179	com/tencent/mapsdk/internal/kh:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   478: goto -262 -> 216
    //   481: astore 7
    //   483: ldc 20
    //   485: new 155	java/lang/StringBuilder
    //   488: dup
    //   489: ldc 234
    //   491: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   494: aload 7
    //   496: invokestatic 225	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   499: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 179	com/tencent/mapsdk/internal/kh:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   508: goto -292 -> 216
    //   511: aload_0
    //   512: getfield 145	com/tencent/mapsdk/internal/si:h	Ljavax/microedition/khronos/egl/EGL10;
    //   515: aload_0
    //   516: getfield 84	com/tencent/mapsdk/internal/si:i	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   519: aload_0
    //   520: getfield 94	com/tencent/mapsdk/internal/si:k	Ljavax/microedition/khronos/egl/EGLSurface;
    //   523: aload_0
    //   524: getfield 94	com/tencent/mapsdk/internal/si:k	Ljavax/microedition/khronos/egl/EGLSurface;
    //   527: aload_0
    //   528: getfield 89	com/tencent/mapsdk/internal/si:j	Ljavax/microedition/khronos/egl/EGLContext;
    //   531: invokeinterface 209 5 0
    //   536: ifne -285 -> 251
    //   539: ldc 20
    //   541: new 155	java/lang/StringBuilder
    //   544: dup
    //   545: ldc 211
    //   547: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   550: aload_0
    //   551: getfield 145	com/tencent/mapsdk/internal/si:h	Ljavax/microedition/khronos/egl/EGL10;
    //   554: invokeinterface 163 1 0
    //   559: invokestatic 169	android/opengl/GLUtils:getEGLErrorString	(I)Ljava/lang/String;
    //   562: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 179	com/tencent/mapsdk/internal/kh:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: goto -355 -> 216
    //   574: goto -532 -> 42
    //   577: aload_0
    //   578: iconst_0
    //   579: putfield 98	com/tencent/mapsdk/internal/si:p	Z
    //   582: aload_0
    //   583: lconst_0
    //   584: putfield 96	com/tencent/mapsdk/internal/si:o	J
    //   587: goto -261 -> 326
    //   590: astore 7
    //   592: aload_0
    //   593: monitorexit
    //   594: ldc_w 282
    //   597: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   600: aload 7
    //   602: athrow
    //   603: goto -561 -> 42
    //   606: aload_0
    //   607: getfield 105	com/tencent/mapsdk/internal/si:a	Ljava/lang/ref/WeakReference;
    //   610: ifnull +31 -> 641
    //   613: aload_0
    //   614: getfield 105	com/tencent/mapsdk/internal/si:a	Ljava/lang/ref/WeakReference;
    //   617: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   620: ifnull +21 -> 641
    //   623: aload_0
    //   624: getfield 105	com/tencent/mapsdk/internal/si:a	Ljava/lang/ref/WeakReference;
    //   627: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   630: checkcast 286	com/tencent/mapsdk/internal/sj
    //   633: invokevirtual 316	com/tencent/mapsdk/internal/sj:E	()V
    //   636: aload_0
    //   637: aconst_null
    //   638: putfield 105	com/tencent/mapsdk/internal/si:a	Ljava/lang/ref/WeakReference;
    //   641: aload_0
    //   642: invokespecial 230	com/tencent/mapsdk/internal/si:g	()V
    //   645: aload_0
    //   646: getfield 89	com/tencent/mapsdk/internal/si:j	Ljavax/microedition/khronos/egl/EGLContext;
    //   649: ifnull +13 -> 662
    //   652: aload_0
    //   653: getfield 89	com/tencent/mapsdk/internal/si:j	Ljavax/microedition/khronos/egl/EGLContext;
    //   656: getstatic 87	javax/microedition/khronos/egl/EGL10:EGL_NO_CONTEXT	Ljavax/microedition/khronos/egl/EGLContext;
    //   659: if_acmpne +41 -> 700
    //   662: ldc 122
    //   664: ldc 244
    //   666: invokestatic 179	com/tencent/mapsdk/internal/kh:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   669: aload_0
    //   670: getfield 84	com/tencent/mapsdk/internal/si:i	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   673: ifnull +13 -> 686
    //   676: aload_0
    //   677: getfield 84	com/tencent/mapsdk/internal/si:i	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   680: getstatic 82	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   683: if_acmpne +45 -> 728
    //   686: ldc 122
    //   688: ldc 251
    //   690: invokestatic 179	com/tencent/mapsdk/internal/kh:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   693: ldc_w 282
    //   696: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   699: return
    //   700: aload_0
    //   701: getfield 145	com/tencent/mapsdk/internal/si:h	Ljavax/microedition/khronos/egl/EGL10;
    //   704: aload_0
    //   705: getfield 84	com/tencent/mapsdk/internal/si:i	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   708: aload_0
    //   709: getfield 89	com/tencent/mapsdk/internal/si:j	Ljavax/microedition/khronos/egl/EGLContext;
    //   712: invokeinterface 248 3 0
    //   717: pop
    //   718: aload_0
    //   719: getstatic 87	javax/microedition/khronos/egl/EGL10:EGL_NO_CONTEXT	Ljavax/microedition/khronos/egl/EGLContext;
    //   722: putfield 89	com/tencent/mapsdk/internal/si:j	Ljavax/microedition/khronos/egl/EGLContext;
    //   725: goto -56 -> 669
    //   728: aload_0
    //   729: getfield 145	com/tencent/mapsdk/internal/si:h	Ljavax/microedition/khronos/egl/EGL10;
    //   732: aload_0
    //   733: getfield 84	com/tencent/mapsdk/internal/si:i	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   736: invokeinterface 255 2 0
    //   741: pop
    //   742: aload_0
    //   743: getstatic 82	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   746: putfield 84	com/tencent/mapsdk/internal/si:i	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   749: ldc_w 282
    //   752: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   755: return
    //   756: astore 7
    //   758: goto -673 -> 85
    //   761: astore 7
    //   763: goto -361 -> 402
    //   766: goto -724 -> 42
    //   769: goto -657 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	772	0	this	si
    //   387	8	1	i1	int
    //   41	72	2	bool	boolean
    //   329	70	3	l1	long
    //   371	10	5	l2	long
    //   90	11	7	localObject1	Object
    //   145	11	7	localObject2	Object
    //   158	33	7	localThrowable1	Throwable
    //   244	92	7	localObject3	Object
    //   481	14	7	localThrowable2	Throwable
    //   590	11	7	localObject4	Object
    //   756	1	7	localInterruptedException1	java.lang.InterruptedException
    //   761	1	7	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   81	85	90	finally
    //   85	87	90	finally
    //   118	142	145	finally
    //   207	209	145	finally
    //   116	118	158	finally
    //   147	158	158	finally
    //   209	216	158	finally
    //   216	230	158	finally
    //   251	265	158	finally
    //   265	316	158	finally
    //   321	326	158	finally
    //   326	330	158	finally
    //   335	368	158	finally
    //   368	388	158	finally
    //   392	394	158	finally
    //   483	508	158	finally
    //   577	587	158	finally
    //   592	603	158	finally
    //   230	246	481	finally
    //   407	478	481	finally
    //   511	571	481	finally
    //   397	402	590	finally
    //   402	404	590	finally
    //   81	85	756	java/lang/InterruptedException
    //   397	402	761	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.si
 * JD-Core Version:    0.7.0.1
 */