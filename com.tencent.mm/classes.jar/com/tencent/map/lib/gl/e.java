package com.tencent.map.lib.gl;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class e
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private static final j a;
  private final WeakReference<e> b;
  private e.i c;
  private e.m d;
  private boolean e;
  private e.e f;
  private e.f g;
  private e.g h;
  private e.k i;
  private int j;
  private int k;
  private boolean l;
  
  static
  {
    AppMethodBeat.i(98123);
    a = new j(null);
    AppMethodBeat.o(98123);
  }
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98102);
    this.b = new WeakReference(this);
    a();
    AppMethodBeat.o(98102);
  }
  
  private void a()
  {
    AppMethodBeat.i(98104);
    getHolder().addCallback(this);
    AppMethodBeat.o(98104);
  }
  
  private void d()
  {
    AppMethodBeat.i(98122);
    if (this.c != null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
      AppMethodBeat.o(98122);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(98122);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(98110);
    setEGLConfigChooser(new e.b(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
    AppMethodBeat.o(98110);
  }
  
  public void b()
  {
    AppMethodBeat.i(98114);
    this.c.c();
    AppMethodBeat.o(98114);
  }
  
  public void e()
  {
    AppMethodBeat.i(98119);
    this.c.g();
    AppMethodBeat.o(98119);
  }
  
  public void f()
  {
    AppMethodBeat.i(98118);
    this.c.f();
    AppMethodBeat.o(98118);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(98103);
    try
    {
      if (this.c != null) {
        this.c.h();
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(98103);
    }
  }
  
  public int getDebugFlags()
  {
    return this.j;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.l;
  }
  
  public int getRenderMode()
  {
    AppMethodBeat.i(98113);
    int m = this.c.b();
    AppMethodBeat.o(98113);
    return m;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(98120);
    super.onAttachedToWindow();
    if ((this.e) && (this.d != null)) {
      if (this.c == null) {
        break label84;
      }
    }
    label84:
    for (int m = this.c.b();; m = 1)
    {
      this.c = new e.i(this.b);
      if (m != 1) {
        this.c.a(m);
      }
      this.c.start();
      this.e = false;
      AppMethodBeat.o(98120);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(98121);
    if (this.c != null) {
      this.c.h();
    }
    this.e = true;
    super.onDetachedFromWindow();
    AppMethodBeat.o(98121);
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setEGLConfigChooser(e.e parame)
  {
    AppMethodBeat.i(98108);
    d();
    this.f = parame;
    AppMethodBeat.o(98108);
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    AppMethodBeat.i(98109);
    setEGLConfigChooser(new e.n(this, paramBoolean));
    AppMethodBeat.o(98109);
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    AppMethodBeat.i(98111);
    d();
    this.k = paramInt;
    AppMethodBeat.o(98111);
  }
  
  public void setEGLContextFactory(e.f paramf)
  {
    AppMethodBeat.i(98106);
    d();
    this.g = paramf;
    AppMethodBeat.o(98106);
  }
  
  public void setEGLWindowSurfaceFactory(e.g paramg)
  {
    AppMethodBeat.i(98107);
    d();
    this.h = paramg;
    AppMethodBeat.o(98107);
  }
  
  public void setGLWrapper(e.k paramk)
  {
    this.i = paramk;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(98112);
    this.c.a(paramInt);
    AppMethodBeat.o(98112);
  }
  
  public void setRenderer(e.m paramm)
  {
    AppMethodBeat.i(98105);
    d();
    if (this.f == null) {
      this.f = new e.n(this, true);
    }
    if (this.g == null) {
      this.g = new c(null);
    }
    if (this.h == null) {
      this.h = new d(null);
    }
    this.d = paramm;
    this.c = new e.i(this.b);
    this.c.start();
    AppMethodBeat.o(98105);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(98117);
    this.c.a(paramInt2, paramInt3);
    AppMethodBeat.o(98117);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(98115);
    this.c.d();
    AppMethodBeat.o(98115);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(98116);
    this.c.e();
    AppMethodBeat.o(98116);
  }
  
  class c
    implements e.f
  {
    private int b = 12440;
    
    private c() {}
    
    public EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      AppMethodBeat.i(98060);
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = this.b;
      arrayOfInt[1] = e.a(e.this);
      arrayOfInt[2] = 12344;
      EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
      if (e.a(e.this) != 0) {}
      for (;;)
      {
        paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
        AppMethodBeat.o(98060);
        return paramEGL10;
        arrayOfInt = null;
      }
    }
    
    public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      AppMethodBeat.i(98061);
      if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
      {
        new StringBuilder("display:").append(paramEGLDisplay).append(" context: ").append(paramEGLContext);
        e.h.a("eglDestroyContex", paramEGL10.eglGetError());
      }
      AppMethodBeat.o(98061);
    }
  }
  
  static class d
    implements e.g
  {
    public EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
    {
      Object localObject = null;
      AppMethodBeat.i(98062);
      try
      {
        paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
        AppMethodBeat.o(98062);
        return paramEGL10;
      }
      catch (IllegalArgumentException paramEGL10)
      {
        for (;;)
        {
          paramEGL10 = localObject;
        }
      }
      catch (OutOfMemoryError paramEGL10)
      {
        for (;;)
        {
          paramEGL10 = localObject;
        }
      }
    }
    
    public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      AppMethodBeat.i(98063);
      paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
      AppMethodBeat.o(98063);
    }
  }
  
  static class j
  {
    private static String a = "GLThreadManager";
    private boolean b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;
    private e.i g;
    
    private void c()
    {
      if (!this.b)
      {
        this.c = 131072;
        if (this.c >= 131072) {
          this.e = true;
        }
        this.b = true;
      }
    }
    
    public void a(e.i parami)
    {
      try
      {
        AppMethodBeat.i(98091);
        e.i.a(parami, true);
        if (this.g == parami) {
          this.g = null;
        }
        notifyAll();
        AppMethodBeat.o(98091);
        return;
      }
      finally {}
    }
    
    /* Error */
    public void a(javax.microedition.khronos.opengles.GL10 paramGL10)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_3
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 60
      //   6: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 62	com/tencent/map/lib/gl/e$j:d	Z
      //   13: ifne +65 -> 78
      //   16: aload_0
      //   17: invokespecial 64	com/tencent/map/lib/gl/e$j:c	()V
      //   20: aload_1
      //   21: sipush 7937
      //   24: invokeinterface 70 2 0
      //   29: astore_1
      //   30: aload_0
      //   31: getfield 35	com/tencent/map/lib/gl/e$j:c	I
      //   34: ldc 33
      //   36: if_icmpge +23 -> 59
      //   39: aload_1
      //   40: ldc 72
      //   42: invokevirtual 78	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   45: ifne +41 -> 86
      //   48: iconst_1
      //   49: istore_2
      //   50: aload_0
      //   51: iload_2
      //   52: putfield 37	com/tencent/map/lib/gl/e$j:e	Z
      //   55: aload_0
      //   56: invokevirtual 55	java/lang/Object:notifyAll	()V
      //   59: aload_0
      //   60: getfield 37	com/tencent/map/lib/gl/e$j:e	Z
      //   63: ifne +28 -> 91
      //   66: iload_3
      //   67: istore_2
      //   68: aload_0
      //   69: iload_2
      //   70: putfield 80	com/tencent/map/lib/gl/e$j:f	Z
      //   73: aload_0
      //   74: iconst_1
      //   75: putfield 62	com/tencent/map/lib/gl/e$j:d	Z
      //   78: ldc 60
      //   80: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   83: aload_0
      //   84: monitorexit
      //   85: return
      //   86: iconst_0
      //   87: istore_2
      //   88: goto -38 -> 50
      //   91: iconst_0
      //   92: istore_2
      //   93: goto -25 -> 68
      //   96: astore_1
      //   97: aload_0
      //   98: monitorexit
      //   99: aload_1
      //   100: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	101	0	this	j
      //   0	101	1	paramGL10	javax.microedition.khronos.opengles.GL10
      //   49	44	2	bool1	boolean
      //   1	66	3	bool2	boolean
      // Exception table:
      //   from	to	target	type
      //   4	48	96	finally
      //   50	59	96	finally
      //   59	66	96	finally
      //   68	78	96	finally
      //   78	83	96	finally
    }
    
    public boolean a()
    {
      try
      {
        boolean bool = this.f;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    /* Error */
    public boolean b()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 82
      //   4: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: invokespecial 64	com/tencent/map/lib/gl/e$j:c	()V
      //   11: aload_0
      //   12: getfield 37	com/tencent/map/lib/gl/e$j:e	Z
      //   15: ifne +14 -> 29
      //   18: iconst_1
      //   19: istore_1
      //   20: ldc 82
      //   22: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   25: aload_0
      //   26: monitorexit
      //   27: iload_1
      //   28: ireturn
      //   29: iconst_0
      //   30: istore_1
      //   31: ldc 82
      //   33: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: goto -11 -> 25
      //   39: astore_2
      //   40: aload_0
      //   41: monitorexit
      //   42: aload_2
      //   43: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	44	0	this	j
      //   19	12	1	bool	boolean
      //   39	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	18	39	finally
      //   20	25	39	finally
      //   31	36	39	finally
    }
    
    public boolean b(e.i parami)
    {
      AppMethodBeat.i(98092);
      if ((this.g == parami) || (this.g == null))
      {
        this.g = parami;
        notifyAll();
        AppMethodBeat.o(98092);
        return true;
      }
      c();
      if (this.e)
      {
        AppMethodBeat.o(98092);
        return true;
      }
      if (this.g != null) {
        this.g.i();
      }
      AppMethodBeat.o(98092);
      return false;
    }
    
    public void c(e.i parami)
    {
      AppMethodBeat.i(98093);
      if (this.g == parami) {
        this.g = null;
      }
      notifyAll();
      AppMethodBeat.o(98093);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.lib.gl.e
 * JD-Core Version:    0.7.0.1
 */