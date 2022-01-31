package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class c
  extends Thread
{
  private int a = 12440;
  private int b = 4;
  private WeakReference<b> c;
  private EGL10 d;
  private EGLContext e;
  private EGLDisplay f;
  private EGLSurface g;
  private EGLConfig h;
  private WeakReference<SurfaceTexture> i;
  private boolean j = false;
  
  c(WeakReference<b> paramWeakReference)
  {
    this.c = paramWeakReference;
  }
  
  private EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, EGLContext paramEGLContext)
  {
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, paramEGLContext, new int[] { this.a, 2, 12344 });
  }
  
  private void c()
  {
    try
    {
      b localb = (b)this.c.get();
      if (localb != null) {
        localb.c();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void d()
  {
    try
    {
      b localb = (b)this.c.get();
      if (localb != null) {
        localb.d();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private boolean e()
  {
    try
    {
      Thread.sleep(10L);
      if (this.c != null)
      {
        b localb = (b)this.c.get();
        if (localb != null)
        {
          boolean bool = localb.e();
          return bool;
        }
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  private void f()
  {
    Object localObject = (b)this.c.get();
    if (localObject == null) {}
    for (;;)
    {
      return;
      this.d = ((EGL10)EGLContext.getEGL());
      this.f = this.d.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      int[] arrayOfInt = new int[2];
      this.d.eglInitialize(this.f, arrayOfInt);
      this.h = h();
      localObject = ((b)localObject).f();
      if (localObject != null) {
        this.i = new WeakReference(localObject);
      }
      this.g = this.d.eglCreateWindowSurface(this.f, this.h, localObject, null);
      this.e = a(this.d, this.f, this.h, EGL10.EGL_NO_CONTEXT);
      TXCLog.w("TXCVideoRenderThread", "vrender: init egl @context=" + this.e + ",surface=" + this.g);
      try
      {
        if ((this.g == null) || (this.g == EGL10.EGL_NO_SURFACE)) {
          throw new RuntimeException("GL error:" + GLUtils.getEGLErrorString(this.d.eglGetError()));
        }
        if (!this.d.eglMakeCurrent(this.f, this.g, this.g, this.e)) {
          throw new RuntimeException("GL Make current Error" + GLUtils.getEGLErrorString(this.d.eglGetError()));
        }
      }
      catch (Exception localException) {}
    }
  }
  
  private void g()
  {
    this.d.eglMakeCurrent(this.f, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
    this.d.eglDestroyContext(this.f, this.e);
    this.d.eglDestroySurface(this.f, this.g);
    this.d.eglTerminate(this.f);
    this.i = null;
    TXCLog.w("TXCVideoRenderThread", "vrender: uninit egl @context=" + this.e + ",surface=" + this.g);
  }
  
  private EGLConfig h()
  {
    int[] arrayOfInt1 = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt2 = i();
    if (!this.d.eglChooseConfig(this.f, arrayOfInt2, arrayOfEGLConfig, 1, arrayOfInt1)) {
      throw new IllegalArgumentException("Failed to choose config:" + GLUtils.getEGLErrorString(this.d.eglGetError()));
    }
    if (arrayOfInt1[0] > 0) {
      return arrayOfEGLConfig[0];
    }
    return null;
  }
  
  private int[] i()
  {
    return new int[] { 12352, this.b, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344 };
  }
  
  public EGLContext a()
  {
    return this.e;
  }
  
  public void b()
  {
    this.j = false;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 122	java/lang/StringBuilder
    //   4: dup
    //   5: ldc 202
    //   7: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: aload_0
    //   11: invokevirtual 206	com/tencent/liteav/renderer/c:getId	()J
    //   14: invokevirtual 209	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: invokevirtual 212	com/tencent/liteav/renderer/c:setName	(Ljava/lang/String;)V
    //   23: aload_0
    //   24: iconst_1
    //   25: putfield 35	com/tencent/liteav/renderer/c:j	Z
    //   28: aload_0
    //   29: invokespecial 214	com/tencent/liteav/renderer/c:f	()V
    //   32: aload_0
    //   33: invokespecial 215	com/tencent/liteav/renderer/c:c	()V
    //   36: aload_0
    //   37: getfield 35	com/tencent/liteav/renderer/c:j	Z
    //   40: ifeq +52 -> 92
    //   43: aload_0
    //   44: invokespecial 216	com/tencent/liteav/renderer/c:e	()Z
    //   47: ifeq -11 -> 36
    //   50: aload_0
    //   51: getfield 78	com/tencent/liteav/renderer/c:d	Ljavax/microedition/khronos/egl/EGL10;
    //   54: ifnull -18 -> 36
    //   57: aload_0
    //   58: getfield 88	com/tencent/liteav/renderer/c:f	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   61: ifnull -25 -> 36
    //   64: aload_0
    //   65: getfield 111	com/tencent/liteav/renderer/c:g	Ljavax/microedition/khronos/egl/EGLSurface;
    //   68: ifnull -32 -> 36
    //   71: aload_0
    //   72: getfield 78	com/tencent/liteav/renderer/c:d	Ljavax/microedition/khronos/egl/EGL10;
    //   75: aload_0
    //   76: getfield 88	com/tencent/liteav/renderer/c:f	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   79: aload_0
    //   80: getfield 111	com/tencent/liteav/renderer/c:g	Ljavax/microedition/khronos/egl/EGLSurface;
    //   83: invokeinterface 219 3 0
    //   88: pop
    //   89: goto -53 -> 36
    //   92: aload_0
    //   93: invokespecial 220	com/tencent/liteav/renderer/c:d	()V
    //   96: aload_0
    //   97: invokespecial 222	com/tencent/liteav/renderer/c:g	()V
    //   100: return
    //   101: astore_1
    //   102: aload_1
    //   103: athrow
    //   104: astore_1
    //   105: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	c
    //   101	2	1	localObject	Object
    //   104	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   23	36	101	finally
    //   36	89	101	finally
    //   92	100	101	finally
    //   23	36	104	java/lang/Exception
    //   36	89	104	java/lang/Exception
    //   92	100	104	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.renderer.c
 * JD-Core Version:    0.7.0.1
 */