package com.tencent.liteav.renderer;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

public class TXCGLSurfaceViewBase
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private static final j a;
  protected boolean b;
  protected boolean c;
  protected final WeakReference<TXCGLSurfaceViewBase> d;
  protected boolean e;
  protected boolean f;
  private i g;
  private GLSurfaceView.Renderer h;
  private boolean i;
  private e j;
  private f k;
  private g l;
  private k m;
  private int n;
  private int o;
  private boolean p;
  
  static
  {
    AppMethodBeat.i(16888);
    a = new j(null);
    AppMethodBeat.o(16888);
  }
  
  public TXCGLSurfaceViewBase(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(16866);
    this.b = false;
    this.c = false;
    this.d = new WeakReference(this);
    a();
    AppMethodBeat.o(16866);
  }
  
  public TXCGLSurfaceViewBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(16867);
    this.b = false;
    this.c = false;
    this.d = new WeakReference(this);
    a();
    AppMethodBeat.o(16867);
  }
  
  private void a()
  {
    AppMethodBeat.i(16869);
    getHolder().addCallback(this);
    AppMethodBeat.o(16869);
  }
  
  private void g()
  {
    AppMethodBeat.i(182251);
    if (this.g != null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
      AppMethodBeat.o(182251);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(182251);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(16875);
    setEGLConfigChooser(new b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
    AppMethodBeat.o(16875);
  }
  
  protected void b() {}
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(16882);
    this.b = paramBoolean;
    if ((!this.b) && (this.c) && (this.g != null))
    {
      TXCLog.w("TXCGLSurfaceViewBase", "background capture destroy surface when not enable background run");
      this.g.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16781);
          TXCGLSurfaceViewBase.this.b();
          AppMethodBeat.o(16781);
        }
      });
      this.g.g();
    }
    AppMethodBeat.o(16882);
  }
  
  protected int c()
  {
    return 0;
  }
  
  public boolean d()
  {
    AppMethodBeat.i(182252);
    boolean bool = this.g.a();
    AppMethodBeat.o(182252);
    return bool;
  }
  
  public int e()
  {
    AppMethodBeat.i(182253);
    int i1 = this.g.b();
    AppMethodBeat.o(182253);
    return i1;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(16868);
    try
    {
      if (this.g != null) {
        this.g.h();
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(16868);
    }
  }
  
  public int getDebugFlags()
  {
    return this.n;
  }
  
  public h getEGLHelper()
  {
    AppMethodBeat.i(16887);
    h localh = this.g.c();
    AppMethodBeat.o(16887);
    return localh;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.p;
  }
  
  public int getRenderMode()
  {
    AppMethodBeat.i(16878);
    int i1 = this.g.e();
    AppMethodBeat.o(16878);
    return i1;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(16883);
    super.onAttachedToWindow();
    if ((this.i) && (this.h != null)) {
      if (this.g == null) {
        break label86;
      }
    }
    label86:
    for (int i1 = this.g.e();; i1 = 1)
    {
      this.g = new i(this.d);
      if (i1 != 1) {
        this.g.a(i1);
      }
      this.g.start();
      this.i = false;
      AppMethodBeat.o(16883);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(16884);
    if ((this.b) && (this.g != null))
    {
      TXCLog.w("TXCGLSurfaceViewBase", "background capture destroy surface when onDetachedFromWindow");
      this.g.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16754);
          TXCGLSurfaceViewBase.this.b();
          AppMethodBeat.o(16754);
        }
      });
      this.g.g();
    }
    if (this.g != null) {
      this.g.h();
    }
    this.i = true;
    super.onDetachedFromWindow();
    AppMethodBeat.o(16884);
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setEGLConfigChooser(e parame)
  {
    AppMethodBeat.i(16873);
    g();
    this.j = parame;
    AppMethodBeat.o(16873);
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    AppMethodBeat.i(16874);
    setEGLConfigChooser(new m(paramBoolean));
    AppMethodBeat.o(16874);
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    AppMethodBeat.i(16876);
    g();
    this.o = paramInt;
    AppMethodBeat.o(16876);
  }
  
  public void setEGLContextFactory(f paramf)
  {
    AppMethodBeat.i(16871);
    g();
    this.k = paramf;
    AppMethodBeat.o(16871);
  }
  
  public void setEGLWindowSurfaceFactory(g paramg)
  {
    AppMethodBeat.i(16872);
    g();
    this.l = paramg;
    AppMethodBeat.o(16872);
  }
  
  public void setGLWrapper(k paramk)
  {
    this.m = paramk;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(16877);
    this.g.a(paramInt);
    AppMethodBeat.o(16877);
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    AppMethodBeat.i(16870);
    g();
    if (this.j == null) {
      this.j = new m(true);
    }
    if (this.k == null) {
      this.k = new c(null);
    }
    if (this.l == null) {
      this.l = new d(null);
    }
    this.h = paramRenderer;
    this.g = new i(this.d);
    this.g.start();
    TXCLog.i("TXCGLSurfaceViewBase", "setRenderer-->mGLThread.start");
    AppMethodBeat.o(16870);
  }
  
  protected void setRunInBackground(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(16881);
    this.g.a(paramInt2, paramInt3);
    AppMethodBeat.o(16881);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(16879);
    this.g.f();
    setRunInBackground(false);
    AppMethodBeat.o(16879);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(16880);
    setRunInBackground(true);
    if (!this.b)
    {
      this.g.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16751);
          TXCGLSurfaceViewBase.this.b();
          AppMethodBeat.o(16751);
        }
      });
      this.g.g();
    }
    AppMethodBeat.o(16880);
  }
  
  abstract class a
    implements TXCGLSurfaceViewBase.e
  {
    protected int[] a = a(paramArrayOfInt);
    
    public a(int[] paramArrayOfInt) {}
    
    private int[] a(int[] paramArrayOfInt)
    {
      if (TXCGLSurfaceViewBase.h(TXCGLSurfaceViewBase.this) != 2) {
        return paramArrayOfInt;
      }
      int i = paramArrayOfInt.length;
      int[] arrayOfInt = new int[i + 2];
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i - 1);
      arrayOfInt[(i - 1)] = 12352;
      arrayOfInt[i] = 4;
      arrayOfInt[(i + 1)] = 12344;
      return arrayOfInt;
    }
    
    public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
    {
      int[] arrayOfInt = new int[1];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.a, null, 0, arrayOfInt)) {
        throw new IllegalArgumentException("eglChooseConfig failed");
      }
      int i = arrayOfInt[0];
      if (i <= 0) {
        throw new IllegalArgumentException("No configs match configSpec");
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.a, arrayOfEGLConfig, i, arrayOfInt)) {
        throw new IllegalArgumentException("eglChooseConfig#2 failed");
      }
      paramEGL10 = a(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
      if (paramEGL10 == null) {
        throw new IllegalArgumentException("No config chosen");
      }
      return paramEGL10;
    }
    
    abstract EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
  }
  
  class b
    extends TXCGLSurfaceViewBase.a
  {
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    private int[] j;
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      super(new int[] { 12324, paramInt1, 12323, paramInt2, 12322, paramInt3, 12321, paramInt4, 12325, paramInt5, 12326, paramInt6, 12344 });
      AppMethodBeat.i(16903);
      this.j = new int[1];
      this.c = paramInt1;
      this.d = paramInt2;
      this.e = paramInt3;
      this.f = paramInt4;
      this.g = paramInt5;
      this.h = paramInt6;
      AppMethodBeat.o(16903);
    }
    
    private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(16905);
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.j))
      {
        paramInt1 = this.j[0];
        AppMethodBeat.o(16905);
        return paramInt1;
      }
      AppMethodBeat.o(16905);
      return paramInt2;
    }
    
    public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      AppMethodBeat.i(16904);
      int m = paramArrayOfEGLConfig.length;
      int k = 0;
      while (k < m)
      {
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[k];
        int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
        int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
        if ((n >= this.g) && (i1 >= this.h))
        {
          n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
          i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
          int i2 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
          int i3 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
          if ((n == this.c) && (i1 == this.d) && (i2 == this.e) && (i3 == this.f))
          {
            AppMethodBeat.o(16904);
            return localEGLConfig;
          }
        }
        k += 1;
      }
      AppMethodBeat.o(16904);
      return null;
    }
  }
  
  class c
    implements TXCGLSurfaceViewBase.f
  {
    private int b = 12440;
    
    private c() {}
    
    public EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      AppMethodBeat.i(16779);
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = this.b;
      arrayOfInt[1] = TXCGLSurfaceViewBase.h(TXCGLSurfaceViewBase.this);
      arrayOfInt[2] = 12344;
      EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
      if (TXCGLSurfaceViewBase.h(TXCGLSurfaceViewBase.this) != 0) {}
      for (;;)
      {
        paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
        AppMethodBeat.o(16779);
        return paramEGL10;
        arrayOfInt = null;
      }
    }
    
    public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      AppMethodBeat.i(16780);
      if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
      {
        TXCLog.e("DefaultContextFactory", "display:" + paramEGLDisplay + " context: " + paramEGLContext);
        TXCGLSurfaceViewBase.h.a("eglDestroyContex", paramEGL10.eglGetError());
      }
      AppMethodBeat.o(16780);
    }
  }
  
  static class d
    implements TXCGLSurfaceViewBase.g
  {
    public EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
    {
      Object localObject = null;
      AppMethodBeat.i(16752);
      try
      {
        paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
        AppMethodBeat.o(16752);
        return paramEGL10;
      }
      catch (IllegalArgumentException paramEGL10)
      {
        for (;;)
        {
          TXCLog.e("TXCGLSurfaceViewBase", "eglCreateWindowSurface");
          TXCLog.e("TXCGLSurfaceViewBase", paramEGL10.toString());
          paramEGL10 = localObject;
        }
      }
    }
    
    public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      AppMethodBeat.i(16753);
      paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
      AppMethodBeat.o(16753);
    }
  }
  
  public static abstract interface e
  {
    public abstract EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay);
  }
  
  public static abstract interface f
  {
    public abstract EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig);
    
    public abstract void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext);
  }
  
  public static abstract interface g
  {
    public abstract EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject);
    
    public abstract void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface);
  }
  
  public static class h
  {
    EGL10 a;
    EGLDisplay b;
    EGLSurface c;
    EGLConfig d;
    EGLContext e;
    private WeakReference<TXCGLSurfaceViewBase> f;
    
    public h(WeakReference<TXCGLSurfaceViewBase> paramWeakReference)
    {
      this.f = paramWeakReference;
    }
    
    private void a(String paramString)
    {
      AppMethodBeat.i(16929);
      a(paramString, this.a.eglGetError());
      AppMethodBeat.o(16929);
    }
    
    public static void a(String paramString, int paramInt)
    {
      AppMethodBeat.i(16930);
      paramString = new RuntimeException(b(paramString, paramInt));
      AppMethodBeat.o(16930);
      throw paramString;
    }
    
    public static void a(String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(16931);
      TXCLog.w(paramString1, b(paramString2, paramInt));
      AppMethodBeat.o(16931);
    }
    
    public static String b(String paramString, int paramInt)
    {
      AppMethodBeat.i(16932);
      paramString = paramString + " failed: " + paramInt;
      AppMethodBeat.o(16932);
      return paramString;
    }
    
    private void i()
    {
      AppMethodBeat.i(182259);
      if ((this.c != null) && (this.c != EGL10.EGL_NO_SURFACE))
      {
        Object localObject = this.a;
        EGLDisplay localEGLDisplay = this.b;
        EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
        ((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
        localObject = (TXCGLSurfaceViewBase)this.f.get();
        if (localObject != null)
        {
          TXCGLSurfaceViewBase.e((TXCGLSurfaceViewBase)localObject).a(this.a, this.b, this.c);
          ((TXCGLSurfaceViewBase)localObject).e = false;
        }
        this.c = null;
      }
      AppMethodBeat.o(182259);
    }
    
    public void a()
    {
      AppMethodBeat.i(16921);
      this.a = ((EGL10)EGLContext.getEGL());
      this.b = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      if (this.b == EGL10.EGL_NO_DISPLAY)
      {
        localObject = new RuntimeException("eglGetDisplay failed");
        AppMethodBeat.o(16921);
        throw ((Throwable)localObject);
      }
      Object localObject = new int[2];
      if (!this.a.eglInitialize(this.b, (int[])localObject))
      {
        localObject = new RuntimeException("eglInitialize failed");
        AppMethodBeat.o(16921);
        throw ((Throwable)localObject);
      }
      localObject = (TXCGLSurfaceViewBase)this.f.get();
      if (localObject == null) {
        this.d = null;
      }
      for (this.e = null;; this.e = TXCGLSurfaceViewBase.d((TXCGLSurfaceViewBase)localObject).a(this.a, this.b, this.d))
      {
        if ((this.e == null) || (this.e == EGL10.EGL_NO_CONTEXT))
        {
          this.e = null;
          a("createContext");
        }
        if (localObject != null) {
          ((TXCGLSurfaceViewBase)localObject).f = true;
        }
        this.c = null;
        AppMethodBeat.o(16921);
        return;
        this.d = TXCGLSurfaceViewBase.c((TXCGLSurfaceViewBase)localObject).a(this.a, this.b);
      }
    }
    
    public boolean b()
    {
      AppMethodBeat.i(16922);
      if (this.a == null)
      {
        localObject = new RuntimeException("egl not initialized");
        AppMethodBeat.o(16922);
        throw ((Throwable)localObject);
      }
      if (this.b == null)
      {
        localObject = new RuntimeException("eglDisplay not initialized");
        AppMethodBeat.o(16922);
        throw ((Throwable)localObject);
      }
      if (this.d == null)
      {
        localObject = new RuntimeException("mEglConfig not initialized");
        AppMethodBeat.o(16922);
        throw ((Throwable)localObject);
      }
      i();
      Object localObject = (TXCGLSurfaceViewBase)this.f.get();
      if (localObject != null) {}
      for (this.c = TXCGLSurfaceViewBase.e((TXCGLSurfaceViewBase)localObject).a(this.a, this.b, this.d, ((TXCGLSurfaceViewBase)localObject).getHolder()); (this.c == null) || (this.c == EGL10.EGL_NO_SURFACE); this.c = null)
      {
        if (this.a.eglGetError() == 12299) {
          TXCLog.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
        }
        AppMethodBeat.o(16922);
        return false;
      }
      if (!this.a.eglMakeCurrent(this.b, this.c, this.c, this.e))
      {
        a("EGLHelper", "eglMakeCurrent", this.a.eglGetError());
        AppMethodBeat.o(16922);
        return false;
      }
      if (localObject != null) {
        ((TXCGLSurfaceViewBase)localObject).e = true;
      }
      AppMethodBeat.o(16922);
      return true;
    }
    
    public boolean c()
    {
      AppMethodBeat.i(182255);
      if (!this.a.eglMakeCurrent(this.b, this.c, this.c, this.e))
      {
        a("EGLHelper", "eglMakeCurrent", this.a.eglGetError());
        AppMethodBeat.o(182255);
        return false;
      }
      AppMethodBeat.o(182255);
      return true;
    }
    
    public int d()
    {
      AppMethodBeat.i(182256);
      int i = f();
      AppMethodBeat.o(182256);
      return i;
    }
    
    GL e()
    {
      AppMethodBeat.i(182257);
      GL localGL2 = this.e.getGL();
      TXCGLSurfaceViewBase localTXCGLSurfaceViewBase = (TXCGLSurfaceViewBase)this.f.get();
      Object localObject = localGL2;
      GL localGL1;
      int i;
      if (localTXCGLSurfaceViewBase != null)
      {
        localGL1 = localGL2;
        if (TXCGLSurfaceViewBase.f(localTXCGLSurfaceViewBase) != null) {
          localGL1 = TXCGLSurfaceViewBase.f(localTXCGLSurfaceViewBase).a(localGL2);
        }
        localObject = localGL1;
        if ((TXCGLSurfaceViewBase.g(localTXCGLSurfaceViewBase) & 0x3) != 0)
        {
          i = 0;
          if ((TXCGLSurfaceViewBase.g(localTXCGLSurfaceViewBase) & 0x1) != 0) {
            i = 1;
          }
          if ((TXCGLSurfaceViewBase.g(localTXCGLSurfaceViewBase) & 0x2) == 0) {
            break label116;
          }
        }
      }
      label116:
      for (localObject = new TXCGLSurfaceViewBase.l();; localObject = null)
      {
        localObject = GLDebugHelper.wrap(localGL1, i, (Writer)localObject);
        AppMethodBeat.o(182257);
        return localObject;
      }
    }
    
    public int f()
    {
      AppMethodBeat.i(182258);
      if (!this.a.eglSwapBuffers(this.b, this.c))
      {
        int i = this.a.eglGetError();
        AppMethodBeat.o(182258);
        return i;
      }
      AppMethodBeat.o(182258);
      return 12288;
    }
    
    public void g()
    {
      AppMethodBeat.i(16928);
      i();
      AppMethodBeat.o(16928);
    }
    
    public void h()
    {
      AppMethodBeat.i(16927);
      if (this.e != null)
      {
        TXCGLSurfaceViewBase localTXCGLSurfaceViewBase = (TXCGLSurfaceViewBase)this.f.get();
        if (localTXCGLSurfaceViewBase != null) {
          TXCGLSurfaceViewBase.d(localTXCGLSurfaceViewBase).a(this.a, this.b, this.e);
        }
        this.e = null;
      }
      if (this.b != null)
      {
        this.a.eglTerminate(this.b);
        this.b = null;
      }
      AppMethodBeat.o(16927);
    }
  }
  
  static class i
    extends Thread
  {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private ArrayList<Runnable> q;
    private boolean r;
    private TXCGLSurfaceViewBase.h s;
    private WeakReference<TXCGLSurfaceViewBase> t;
    
    i(WeakReference<TXCGLSurfaceViewBase> paramWeakReference)
    {
      AppMethodBeat.i(16824);
      this.q = new ArrayList();
      this.r = true;
      this.l = 0;
      this.m = 0;
      this.o = true;
      this.n = 1;
      this.t = paramWeakReference;
      AppMethodBeat.o(16824);
    }
    
    /* Error */
    private void j()
    {
      // Byte code:
      //   0: sipush 16828
      //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: new 72	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$h
      //   10: dup
      //   11: aload_0
      //   12: getfield 60	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:t	Ljava/lang/ref/WeakReference;
      //   15: invokespecial 74	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$h:<init>	(Ljava/lang/ref/WeakReference;)V
      //   18: putfield 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:s	Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$h;
      //   21: aload_0
      //   22: iconst_0
      //   23: putfield 78	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:h	Z
      //   26: aload_0
      //   27: iconst_0
      //   28: putfield 80	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:i	Z
      //   31: iconst_0
      //   32: istore_3
      //   33: iconst_0
      //   34: istore 4
      //   36: iconst_0
      //   37: istore 6
      //   39: iconst_0
      //   40: istore_2
      //   41: iconst_0
      //   42: istore 5
      //   44: iconst_0
      //   45: istore 8
      //   47: iconst_0
      //   48: istore_1
      //   49: iconst_0
      //   50: istore 12
      //   52: iconst_0
      //   53: istore 9
      //   55: iconst_0
      //   56: istore 10
      //   58: aconst_null
      //   59: astore 22
      //   61: aconst_null
      //   62: astore 21
      //   64: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   67: astore 23
      //   69: aload 23
      //   71: monitorenter
      //   72: iload 12
      //   74: istore 7
      //   76: aload_0
      //   77: getfield 85	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:a	Z
      //   80: ifeq +46 -> 126
      //   83: aload 23
      //   85: monitorexit
      //   86: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   89: astore 21
      //   91: aload 21
      //   93: monitorenter
      //   94: aload_0
      //   95: invokespecial 87	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:k	()V
      //   98: aload_0
      //   99: invokespecial 89	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:l	()V
      //   102: aload 21
      //   104: monitorexit
      //   105: sipush 16828
      //   108: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   111: return
      //   112: astore 22
      //   114: aload 21
      //   116: monitorexit
      //   117: sipush 16828
      //   120: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   123: aload 22
      //   125: athrow
      //   126: aload_0
      //   127: getfield 48	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:q	Ljava/util/ArrayList;
      //   130: invokevirtual 93	java/util/ArrayList:isEmpty	()Z
      //   133: ifne +63 -> 196
      //   136: aload_0
      //   137: getfield 48	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:q	Ljava/util/ArrayList;
      //   140: iconst_0
      //   141: invokevirtual 97	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   144: checkcast 99	java/lang/Runnable
      //   147: astore 22
      //   149: iload 7
      //   151: istore 12
      //   153: iload 9
      //   155: istore 13
      //   157: iload 4
      //   159: istore 7
      //   161: iload_1
      //   162: istore 4
      //   164: aload 23
      //   166: monitorexit
      //   167: aload 22
      //   169: ifnull +629 -> 798
      //   172: aload 22
      //   174: invokeinterface 102 1 0
      //   179: aconst_null
      //   180: astore 22
      //   182: iload 4
      //   184: istore_1
      //   185: iload 7
      //   187: istore 4
      //   189: iload 13
      //   191: istore 9
      //   193: goto -129 -> 64
      //   196: aload_0
      //   197: getfield 104	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:d	Z
      //   200: aload_0
      //   201: getfield 106	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:c	Z
      //   204: if_icmpeq +979 -> 1183
      //   207: aload_0
      //   208: getfield 106	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:c	Z
      //   211: istore 19
      //   213: aload_0
      //   214: aload_0
      //   215: getfield 106	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:c	Z
      //   218: putfield 104	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:d	Z
      //   221: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   224: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   227: aload_0
      //   228: getfield 113	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:k	Z
      //   231: ifeq +19 -> 250
      //   234: aload_0
      //   235: invokespecial 87	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:k	()V
      //   238: aload_0
      //   239: invokespecial 89	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:l	()V
      //   242: aload_0
      //   243: iconst_0
      //   244: putfield 113	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:k	Z
      //   247: iconst_1
      //   248: istore 7
      //   250: iload_2
      //   251: istore 11
      //   253: iload_2
      //   254: ifeq +14 -> 268
      //   257: aload_0
      //   258: invokespecial 87	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:k	()V
      //   261: aload_0
      //   262: invokespecial 89	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:l	()V
      //   265: iconst_0
      //   266: istore 11
      //   268: iload 19
      //   270: ifeq +14 -> 284
      //   273: aload_0
      //   274: getfield 80	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:i	Z
      //   277: ifeq +7 -> 284
      //   280: aload_0
      //   281: invokespecial 87	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:k	()V
      //   284: iload 19
      //   286: ifeq +48 -> 334
      //   289: aload_0
      //   290: getfield 78	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:h	Z
      //   293: ifeq +41 -> 334
      //   296: aload_0
      //   297: getfield 60	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:t	Ljava/lang/ref/WeakReference;
      //   300: invokevirtual 119	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   303: checkcast 6	com/tencent/liteav/renderer/TXCGLSurfaceViewBase
      //   306: astore 24
      //   308: aload 24
      //   310: ifnonnull +333 -> 643
      //   313: iconst_0
      //   314: istore 20
      //   316: iload 20
      //   318: ifeq +12 -> 330
      //   321: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   324: invokevirtual 123	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:a	()Z
      //   327: ifeq +7 -> 334
      //   330: aload_0
      //   331: invokespecial 89	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:l	()V
      //   334: iload 19
      //   336: ifeq +19 -> 355
      //   339: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   342: invokevirtual 125	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:b	()Z
      //   345: ifeq +10 -> 355
      //   348: aload_0
      //   349: getfield 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:s	Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$h;
      //   352: invokevirtual 127	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$h:h	()V
      //   355: aload_0
      //   356: getfield 129	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:e	Z
      //   359: ifne +37 -> 396
      //   362: aload_0
      //   363: getfield 131	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:g	Z
      //   366: ifne +30 -> 396
      //   369: aload_0
      //   370: getfield 80	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:i	Z
      //   373: ifeq +7 -> 380
      //   376: aload_0
      //   377: invokespecial 87	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:k	()V
      //   380: aload_0
      //   381: iconst_1
      //   382: putfield 131	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:g	Z
      //   385: aload_0
      //   386: iconst_0
      //   387: putfield 133	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:f	Z
      //   390: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   393: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   396: aload_0
      //   397: getfield 129	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:e	Z
      //   400: ifeq +21 -> 421
      //   403: aload_0
      //   404: getfield 131	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:g	Z
      //   407: ifeq +14 -> 421
      //   410: aload_0
      //   411: iconst_0
      //   412: putfield 131	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:g	Z
      //   415: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   418: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   421: iload_1
      //   422: istore 12
      //   424: iload 8
      //   426: istore 13
      //   428: iload_1
      //   429: ifeq +20 -> 449
      //   432: iconst_0
      //   433: istore 13
      //   435: iconst_0
      //   436: istore 12
      //   438: aload_0
      //   439: iconst_1
      //   440: putfield 135	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:p	Z
      //   443: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   446: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   449: iload 4
      //   451: istore 18
      //   453: iload 7
      //   455: istore 14
      //   457: iload 5
      //   459: istore 17
      //   461: iload 6
      //   463: istore 15
      //   465: iload_3
      //   466: istore 16
      //   468: aload_0
      //   469: invokespecial 137	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:m	()Z
      //   472: ifeq +288 -> 760
      //   475: iload 7
      //   477: istore_2
      //   478: iload_3
      //   479: istore_1
      //   480: aload_0
      //   481: getfield 78	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:h	Z
      //   484: ifne +12 -> 496
      //   487: iload 7
      //   489: ifeq +164 -> 653
      //   492: iconst_0
      //   493: istore_2
      //   494: iload_3
      //   495: istore_1
      //   496: iload 4
      //   498: istore 8
      //   500: iload 5
      //   502: istore 7
      //   504: iload 6
      //   506: istore_3
      //   507: aload_0
      //   508: getfield 78	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:h	Z
      //   511: ifeq +34 -> 545
      //   514: iload 4
      //   516: istore 8
      //   518: iload 5
      //   520: istore 7
      //   522: iload 6
      //   524: istore_3
      //   525: aload_0
      //   526: getfield 80	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:i	Z
      //   529: ifne +16 -> 545
      //   532: aload_0
      //   533: iconst_1
      //   534: putfield 80	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:i	Z
      //   537: iconst_1
      //   538: istore 8
      //   540: iconst_1
      //   541: istore_3
      //   542: iconst_1
      //   543: istore 7
      //   545: iload 8
      //   547: istore 18
      //   549: iload_2
      //   550: istore 14
      //   552: iload 7
      //   554: istore 17
      //   556: iload_3
      //   557: istore 15
      //   559: iload_1
      //   560: istore 16
      //   562: aload_0
      //   563: getfield 80	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:i	Z
      //   566: ifeq +194 -> 760
      //   569: aload_0
      //   570: getfield 50	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:r	Z
      //   573: ifeq +591 -> 1164
      //   576: iconst_1
      //   577: istore 5
      //   579: aload_0
      //   580: getfield 52	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:l	I
      //   583: istore 9
      //   585: aload_0
      //   586: getfield 54	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:m	I
      //   589: istore 4
      //   591: iconst_1
      //   592: istore 8
      //   594: iconst_1
      //   595: istore 6
      //   597: aload_0
      //   598: iconst_0
      //   599: putfield 50	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:r	Z
      //   602: aload_0
      //   603: iconst_0
      //   604: putfield 56	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:o	Z
      //   607: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   610: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   613: iload 4
      //   615: istore 10
      //   617: iload 12
      //   619: istore 4
      //   621: iload 6
      //   623: istore 7
      //   625: iload 9
      //   627: istore 13
      //   629: iload_2
      //   630: istore 12
      //   632: iload 11
      //   634: istore_2
      //   635: iload_3
      //   636: istore 6
      //   638: iload_1
      //   639: istore_3
      //   640: goto -476 -> 164
      //   643: aload 24
      //   645: invokestatic 140	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:a	(Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase;)Z
      //   648: istore 20
      //   650: goto -334 -> 316
      //   653: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   656: aload_0
      //   657: invokevirtual 143	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:b	(Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$i;)Z
      //   660: istore 19
      //   662: iload 7
      //   664: istore_2
      //   665: iload_3
      //   666: istore_1
      //   667: iload 19
      //   669: ifeq -173 -> 496
      //   672: aload_0
      //   673: getfield 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:s	Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$h;
      //   676: invokevirtual 145	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$h:a	()V
      //   679: aload_0
      //   680: iconst_1
      //   681: putfield 78	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:h	Z
      //   684: iconst_1
      //   685: istore_1
      //   686: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   689: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   692: iload 7
      //   694: istore_2
      //   695: goto -199 -> 496
      //   698: astore 21
      //   700: aload 23
      //   702: monitorexit
      //   703: sipush 16828
      //   706: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   709: aload 21
      //   711: athrow
      //   712: astore 22
      //   714: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   717: astore 21
      //   719: aload 21
      //   721: monitorenter
      //   722: aload_0
      //   723: invokespecial 87	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:k	()V
      //   726: aload_0
      //   727: invokespecial 89	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:l	()V
      //   730: aload 21
      //   732: monitorexit
      //   733: sipush 16828
      //   736: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   739: aload 22
      //   741: athrow
      //   742: astore 21
      //   744: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   747: aload_0
      //   748: invokevirtual 148	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:c	(Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$i;)V
      //   751: sipush 16828
      //   754: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   757: aload 21
      //   759: athrow
      //   760: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   763: invokevirtual 151	java/lang/Object:wait	()V
      //   766: iload 12
      //   768: istore_1
      //   769: iload 18
      //   771: istore 4
      //   773: iload 14
      //   775: istore 7
      //   777: iload 13
      //   779: istore 8
      //   781: iload 17
      //   783: istore 5
      //   785: iload 11
      //   787: istore_2
      //   788: iload 15
      //   790: istore 6
      //   792: iload 16
      //   794: istore_3
      //   795: goto -719 -> 76
      //   798: iload 7
      //   800: istore 9
      //   802: iload 7
      //   804: ifeq +38 -> 842
      //   807: aload_0
      //   808: getfield 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:s	Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$h;
      //   811: invokevirtual 152	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$h:b	()Z
      //   814: ifeq +258 -> 1072
      //   817: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   820: astore 23
      //   822: aload 23
      //   824: monitorenter
      //   825: aload_0
      //   826: iconst_1
      //   827: putfield 154	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:j	Z
      //   830: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   833: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   836: aload 23
      //   838: monitorexit
      //   839: iconst_0
      //   840: istore 9
      //   842: iload 6
      //   844: ifeq +317 -> 1161
      //   847: aload_0
      //   848: getfield 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:s	Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$h;
      //   851: invokevirtual 157	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$h:e	()Ljavax/microedition/khronos/opengles/GL;
      //   854: checkcast 159	javax/microedition/khronos/opengles/GL10
      //   857: astore 21
      //   859: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   862: aload 21
      //   864: invokevirtual 162	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:a	(Ljavax/microedition/khronos/opengles/GL10;)V
      //   867: iconst_0
      //   868: istore 6
      //   870: iload_3
      //   871: istore 7
      //   873: iload_3
      //   874: ifeq +42 -> 916
      //   877: aload_0
      //   878: getfield 60	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:t	Ljava/lang/ref/WeakReference;
      //   881: invokevirtual 119	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   884: checkcast 6	com/tencent/liteav/renderer/TXCGLSurfaceViewBase
      //   887: astore 23
      //   889: aload 23
      //   891: ifnull +311 -> 1202
      //   894: aload 23
      //   896: invokestatic 165	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:b	(Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase;)Landroid/opengl/GLSurfaceView$Renderer;
      //   899: aload 21
      //   901: aload_0
      //   902: getfield 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:s	Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$h;
      //   905: getfield 168	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$h:d	Ljavax/microedition/khronos/egl/EGLConfig;
      //   908: invokeinterface 174 3 0
      //   913: goto +289 -> 1202
      //   916: iload 5
      //   918: istore_3
      //   919: iload 5
      //   921: ifeq +39 -> 960
      //   924: aload_0
      //   925: getfield 60	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:t	Ljava/lang/ref/WeakReference;
      //   928: invokevirtual 119	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   931: checkcast 6	com/tencent/liteav/renderer/TXCGLSurfaceViewBase
      //   934: astore 23
      //   936: aload 23
      //   938: ifnull +270 -> 1208
      //   941: aload 23
      //   943: invokestatic 165	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:b	(Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase;)Landroid/opengl/GLSurfaceView$Renderer;
      //   946: aload 21
      //   948: iload 13
      //   950: iload 10
      //   952: invokeinterface 178 4 0
      //   957: goto +251 -> 1208
      //   960: aload_0
      //   961: getfield 60	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:t	Ljava/lang/ref/WeakReference;
      //   964: invokevirtual 119	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   967: checkcast 6	com/tencent/liteav/renderer/TXCGLSurfaceViewBase
      //   970: astore 23
      //   972: aload 23
      //   974: ifnull +221 -> 1195
      //   977: aload 23
      //   979: invokestatic 165	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:b	(Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase;)Landroid/opengl/GLSurfaceView$Renderer;
      //   982: aload 21
      //   984: invokeinterface 181 2 0
      //   989: aload 23
      //   991: invokevirtual 184	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:c	()I
      //   994: istore_1
      //   995: goto +218 -> 1213
      //   998: ldc 186
      //   1000: ldc 188
      //   1002: iload_1
      //   1003: invokestatic 191	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$h:a	(Ljava/lang/String;Ljava/lang/String;I)V
      //   1006: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   1009: astore 23
      //   1011: aload 23
      //   1013: monitorenter
      //   1014: aload_0
      //   1015: iconst_1
      //   1016: putfield 133	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:f	Z
      //   1019: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   1022: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   1025: aload 23
      //   1027: monitorexit
      //   1028: iload_2
      //   1029: istore 11
      //   1031: iload 8
      //   1033: ifeq +156 -> 1189
      //   1036: iconst_1
      //   1037: istore_1
      //   1038: iload 9
      //   1040: istore 4
      //   1042: iload 13
      //   1044: istore 9
      //   1046: iload_3
      //   1047: istore 5
      //   1049: iload 11
      //   1051: istore_2
      //   1052: iload 7
      //   1054: istore_3
      //   1055: goto -991 -> 64
      //   1058: astore 21
      //   1060: aload 23
      //   1062: monitorexit
      //   1063: sipush 16828
      //   1066: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1069: aload 21
      //   1071: athrow
      //   1072: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   1075: astore 23
      //   1077: aload 23
      //   1079: monitorenter
      //   1080: aload_0
      //   1081: iconst_1
      //   1082: putfield 154	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:j	Z
      //   1085: aload_0
      //   1086: iconst_1
      //   1087: putfield 133	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:f	Z
      //   1090: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   1093: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   1096: aload 23
      //   1098: monitorexit
      //   1099: iload 4
      //   1101: istore_1
      //   1102: iload 7
      //   1104: istore 4
      //   1106: iload 13
      //   1108: istore 9
      //   1110: goto -1046 -> 64
      //   1113: astore 21
      //   1115: aload 23
      //   1117: monitorexit
      //   1118: sipush 16828
      //   1121: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1124: aload 21
      //   1126: athrow
      //   1127: iconst_1
      //   1128: istore 11
      //   1130: goto -99 -> 1031
      //   1133: astore 21
      //   1135: aload 23
      //   1137: monitorexit
      //   1138: sipush 16828
      //   1141: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1144: aload 21
      //   1146: athrow
      //   1147: astore 22
      //   1149: aload 21
      //   1151: monitorexit
      //   1152: sipush 16828
      //   1155: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1158: aload 22
      //   1160: athrow
      //   1161: goto -291 -> 870
      //   1164: iload 10
      //   1166: istore 4
      //   1168: iload 8
      //   1170: istore 6
      //   1172: iload 13
      //   1174: istore 8
      //   1176: iload 7
      //   1178: istore 5
      //   1180: goto -578 -> 602
      //   1183: iconst_0
      //   1184: istore 19
      //   1186: goto -959 -> 227
      //   1189: iload 4
      //   1191: istore_1
      //   1192: goto -154 -> 1038
      //   1195: sipush 12288
      //   1198: istore_1
      //   1199: goto +14 -> 1213
      //   1202: iconst_0
      //   1203: istore 7
      //   1205: goto -289 -> 916
      //   1208: iconst_0
      //   1209: istore_3
      //   1210: goto -250 -> 960
      //   1213: iload_2
      //   1214: istore 11
      //   1216: iload_1
      //   1217: lookupswitch	default:+27->1244, 12288:+-186->1031, 12302:+-90->1127
      //   1245: impdep2
      //   1246: lconst_1
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1247	0	this	i
      //   48	1169	1	i1	int
      //   40	1174	2	i2	int
      //   32	1178	3	i3	int
      //   34	1156	4	i4	int
      //   42	1137	5	i5	int
      //   37	1134	6	i6	int
      //   74	1130	7	i7	int
      //   45	1130	8	i8	int
      //   53	1056	9	i9	int
      //   56	1109	10	i10	int
      //   251	964	11	i11	int
      //   50	717	12	i12	int
      //   155	1018	13	i13	int
      //   455	319	14	i14	int
      //   463	326	15	i15	int
      //   466	327	16	i16	int
      //   459	323	17	i17	int
      //   451	319	18	i18	int
      //   211	974	19	bool1	boolean
      //   314	335	20	bool2	boolean
      //   62	53	21	localj1	TXCGLSurfaceViewBase.j
      //   698	12	21	localObject1	Object
      //   742	16	21	localRuntimeException	RuntimeException
      //   857	126	21	localGL10	javax.microedition.khronos.opengles.GL10
      //   1058	12	21	localObject2	Object
      //   1113	12	21	localObject3	Object
      //   1133	17	21	localObject4	Object
      //   59	1	22	localObject5	Object
      //   112	12	22	localObject6	Object
      //   147	34	22	localRunnable	Runnable
      //   712	28	22	localObject7	Object
      //   1147	12	22	localObject8	Object
      //   306	338	24	localTXCGLSurfaceViewBase	TXCGLSurfaceViewBase
      // Exception table:
      //   from	to	target	type
      //   94	105	112	finally
      //   114	117	112	finally
      //   76	86	698	finally
      //   126	149	698	finally
      //   164	167	698	finally
      //   196	227	698	finally
      //   227	247	698	finally
      //   257	265	698	finally
      //   273	284	698	finally
      //   289	308	698	finally
      //   321	330	698	finally
      //   330	334	698	finally
      //   339	355	698	finally
      //   355	380	698	finally
      //   380	396	698	finally
      //   396	421	698	finally
      //   438	449	698	finally
      //   468	475	698	finally
      //   480	487	698	finally
      //   507	514	698	finally
      //   525	537	698	finally
      //   562	576	698	finally
      //   579	591	698	finally
      //   597	602	698	finally
      //   602	613	698	finally
      //   643	650	698	finally
      //   653	662	698	finally
      //   672	679	698	finally
      //   679	684	698	finally
      //   686	692	698	finally
      //   700	703	698	finally
      //   744	760	698	finally
      //   760	766	698	finally
      //   64	72	712	finally
      //   172	179	712	finally
      //   703	712	712	finally
      //   807	825	712	finally
      //   847	867	712	finally
      //   877	889	712	finally
      //   894	913	712	finally
      //   924	936	712	finally
      //   941	957	712	finally
      //   960	972	712	finally
      //   977	995	712	finally
      //   998	1014	712	finally
      //   1063	1072	712	finally
      //   1072	1080	712	finally
      //   1118	1127	712	finally
      //   1138	1147	712	finally
      //   672	679	742	java/lang/RuntimeException
      //   825	839	1058	finally
      //   1060	1063	1058	finally
      //   1080	1099	1113	finally
      //   1115	1118	1113	finally
      //   1014	1028	1133	finally
      //   1135	1138	1133	finally
      //   722	733	1147	finally
      //   1149	1152	1147	finally
    }
    
    private void k()
    {
      AppMethodBeat.i(16829);
      if (this.i)
      {
        this.i = false;
        this.s.g();
      }
      AppMethodBeat.o(16829);
    }
    
    private void l()
    {
      AppMethodBeat.i(182248);
      if (this.h)
      {
        this.s.h();
        this.h = false;
        TXCGLSurfaceViewBase localTXCGLSurfaceViewBase = (TXCGLSurfaceViewBase)this.t.get();
        if (localTXCGLSurfaceViewBase != null) {
          localTXCGLSurfaceViewBase.f = false;
        }
        TXCGLSurfaceViewBase.f().c(this);
      }
      AppMethodBeat.o(182248);
    }
    
    private boolean m()
    {
      return (!this.d) && (this.e) && (!this.f) && (this.l > 0) && (this.m > 0) && ((this.o) || (this.n == 1));
    }
    
    public void a(int paramInt)
    {
      AppMethodBeat.i(16831);
      if ((paramInt < 0) || (paramInt > 1))
      {
        ??? = new IllegalArgumentException("renderMode");
        AppMethodBeat.o(16831);
        throw ((Throwable)???);
      }
      synchronized (TXCGLSurfaceViewBase.f())
      {
        this.n = paramInt;
        TXCGLSurfaceViewBase.f().notifyAll();
        AppMethodBeat.o(16831);
        return;
      }
    }
    
    public void a(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(16835);
      synchronized (TXCGLSurfaceViewBase.f())
      {
        this.l = paramInt1;
        this.m = paramInt2;
        this.r = true;
        this.o = true;
        this.p = false;
        TXCGLSurfaceViewBase.f().notifyAll();
        for (;;)
        {
          if ((!this.b) && (!this.d) && (!this.p))
          {
            boolean bool = d();
            if (bool) {
              try
              {
                TXCGLSurfaceViewBase.f().wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
      AppMethodBeat.o(16835);
    }
    
    public void a(Runnable paramRunnable)
    {
      AppMethodBeat.i(16838);
      if (paramRunnable == null)
      {
        paramRunnable = new IllegalArgumentException("r must not be null");
        AppMethodBeat.o(16838);
        throw paramRunnable;
      }
      synchronized (TXCGLSurfaceViewBase.f())
      {
        this.q.add(paramRunnable);
        TXCGLSurfaceViewBase.f().notifyAll();
        AppMethodBeat.o(16838);
        return;
      }
    }
    
    public boolean a()
    {
      AppMethodBeat.i(182246);
      boolean bool = this.s.c();
      AppMethodBeat.o(182246);
      return bool;
    }
    
    public int b()
    {
      AppMethodBeat.i(182247);
      int i1 = this.s.d();
      AppMethodBeat.o(182247);
      return i1;
    }
    
    public TXCGLSurfaceViewBase.h c()
    {
      return this.s;
    }
    
    public boolean d()
    {
      AppMethodBeat.i(182249);
      if ((this.h) && (this.i) && (m()))
      {
        AppMethodBeat.o(182249);
        return true;
      }
      AppMethodBeat.o(182249);
      return false;
    }
    
    public int e()
    {
      AppMethodBeat.i(182250);
      synchronized (TXCGLSurfaceViewBase.f())
      {
        int i1 = this.n;
        AppMethodBeat.o(182250);
        return i1;
      }
    }
    
    public void f()
    {
      AppMethodBeat.i(16834);
      synchronized (TXCGLSurfaceViewBase.f())
      {
        this.e = true;
        this.j = false;
        TXCGLSurfaceViewBase.f().notifyAll();
        for (;;)
        {
          if ((this.g) && (!this.j))
          {
            boolean bool = this.b;
            if (!bool) {
              try
              {
                TXCGLSurfaceViewBase.f().wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
      AppMethodBeat.o(16834);
    }
    
    public void g()
    {
      AppMethodBeat.i(16836);
      synchronized (TXCGLSurfaceViewBase.f())
      {
        this.e = false;
        TXCGLSurfaceViewBase.f().notifyAll();
        for (;;)
        {
          if (!this.g)
          {
            boolean bool = this.b;
            if (!bool) {
              try
              {
                TXCGLSurfaceViewBase.f().wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
      AppMethodBeat.o(16836);
    }
    
    public void h()
    {
      AppMethodBeat.i(16837);
      synchronized (TXCGLSurfaceViewBase.f())
      {
        this.a = true;
        TXCGLSurfaceViewBase.f().notifyAll();
        for (;;)
        {
          boolean bool = this.b;
          if (!bool) {
            try
            {
              TXCGLSurfaceViewBase.f().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
      AppMethodBeat.o(16837);
    }
    
    public void i()
    {
      AppMethodBeat.i(16827);
      this.k = true;
      TXCGLSurfaceViewBase.f().notifyAll();
      AppMethodBeat.o(16827);
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: sipush 16825
      //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: new 232	java/lang/StringBuilder
      //   10: dup
      //   11: ldc 234
      //   13: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   16: aload_0
      //   17: invokevirtual 239	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:getId	()J
      //   20: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   23: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   26: invokevirtual 250	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:setName	(Ljava/lang/String;)V
      //   29: aload_0
      //   30: invokespecial 252	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:j	()V
      //   33: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   36: aload_0
      //   37: invokevirtual 254	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:a	(Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$i;)V
      //   40: sipush 16825
      //   43: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   46: return
      //   47: astore_1
      //   48: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   51: aload_0
      //   52: invokevirtual 254	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:a	(Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$i;)V
      //   55: sipush 16825
      //   58: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   61: return
      //   62: astore_1
      //   63: invokestatic 83	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
      //   66: aload_0
      //   67: invokevirtual 254	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:a	(Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$i;)V
      //   70: sipush 16825
      //   73: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   76: aload_1
      //   77: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	78	0	this	i
      //   47	1	1	localInterruptedException	InterruptedException
      //   62	15	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   29	33	47	java/lang/InterruptedException
      //   29	33	62	finally
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
    private TXCGLSurfaceViewBase.i g;
    
    private void c()
    {
      this.c = 131072;
      this.e = true;
      this.b = true;
    }
    
    public void a(TXCGLSurfaceViewBase.i parami)
    {
      try
      {
        AppMethodBeat.i(16933);
        TXCGLSurfaceViewBase.i.a(parami, true);
        if (this.g == parami) {
          this.g = null;
        }
        notifyAll();
        AppMethodBeat.o(16933);
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
      //   4: sipush 16937
      //   7: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   10: aload_0
      //   11: getfield 60	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:d	Z
      //   14: ifne +65 -> 79
      //   17: aload_0
      //   18: invokespecial 62	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:c	()V
      //   21: aload_1
      //   22: sipush 7937
      //   25: invokeinterface 68 2 0
      //   30: astore_1
      //   31: aload_0
      //   32: getfield 33	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:c	I
      //   35: ldc 31
      //   37: if_icmpge +23 -> 60
      //   40: aload_1
      //   41: ldc 70
      //   43: invokevirtual 76	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   46: ifne +42 -> 88
      //   49: iconst_1
      //   50: istore_2
      //   51: aload_0
      //   52: iload_2
      //   53: putfield 35	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:e	Z
      //   56: aload_0
      //   57: invokevirtual 54	java/lang/Object:notifyAll	()V
      //   60: aload_0
      //   61: getfield 35	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:e	Z
      //   64: ifne +29 -> 93
      //   67: iload_3
      //   68: istore_2
      //   69: aload_0
      //   70: iload_2
      //   71: putfield 78	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:f	Z
      //   74: aload_0
      //   75: iconst_1
      //   76: putfield 60	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:d	Z
      //   79: sipush 16937
      //   82: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   85: aload_0
      //   86: monitorexit
      //   87: return
      //   88: iconst_0
      //   89: istore_2
      //   90: goto -39 -> 51
      //   93: iconst_0
      //   94: istore_2
      //   95: goto -26 -> 69
      //   98: astore_1
      //   99: aload_0
      //   100: monitorexit
      //   101: aload_1
      //   102: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	103	0	this	j
      //   0	103	1	paramGL10	javax.microedition.khronos.opengles.GL10
      //   50	45	2	bool1	boolean
      //   1	67	3	bool2	boolean
      // Exception table:
      //   from	to	target	type
      //   4	49	98	finally
      //   51	60	98	finally
      //   60	67	98	finally
      //   69	79	98	finally
      //   79	85	98	finally
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
      //   2: sipush 16936
      //   5: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: invokespecial 62	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:c	()V
      //   12: aload_0
      //   13: getfield 35	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:e	Z
      //   16: ifne +15 -> 31
      //   19: iconst_1
      //   20: istore_1
      //   21: sipush 16936
      //   24: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   27: aload_0
      //   28: monitorexit
      //   29: iload_1
      //   30: ireturn
      //   31: iconst_0
      //   32: istore_1
      //   33: sipush 16936
      //   36: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   39: goto -12 -> 27
      //   42: astore_2
      //   43: aload_0
      //   44: monitorexit
      //   45: aload_2
      //   46: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	47	0	this	j
      //   20	13	1	bool	boolean
      //   42	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	19	42	finally
      //   21	27	42	finally
      //   33	39	42	finally
    }
    
    public boolean b(TXCGLSurfaceViewBase.i parami)
    {
      AppMethodBeat.i(16934);
      if ((this.g == parami) || (this.g == null))
      {
        this.g = parami;
        notifyAll();
        AppMethodBeat.o(16934);
        return true;
      }
      c();
      if (this.e)
      {
        AppMethodBeat.o(16934);
        return true;
      }
      if (this.g != null) {
        this.g.i();
      }
      AppMethodBeat.o(16934);
      return false;
    }
    
    public void c(TXCGLSurfaceViewBase.i parami)
    {
      AppMethodBeat.i(16935);
      if (this.g == parami) {
        this.g = null;
      }
      notifyAll();
      AppMethodBeat.o(16935);
    }
  }
  
  public static abstract interface k
  {
    public abstract GL a(GL paramGL);
  }
  
  static class l
    extends Writer
  {
    private StringBuilder a;
    
    l()
    {
      AppMethodBeat.i(16842);
      this.a = new StringBuilder();
      AppMethodBeat.o(16842);
    }
    
    private void a()
    {
      AppMethodBeat.i(16846);
      if (this.a.length() > 0)
      {
        TXCLog.v("TXCGLSurfaceViewBase", this.a.toString());
        this.a.delete(0, this.a.length());
      }
      AppMethodBeat.o(16846);
    }
    
    public void close()
    {
      AppMethodBeat.i(16843);
      a();
      AppMethodBeat.o(16843);
    }
    
    public void flush()
    {
      AppMethodBeat.i(16844);
      a();
      AppMethodBeat.o(16844);
    }
    
    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(16845);
      int i = 0;
      if (i < paramInt2)
      {
        char c = paramArrayOfChar[(paramInt1 + i)];
        if (c == '\n') {
          a();
        }
        for (;;)
        {
          i += 1;
          break;
          this.a.append(c);
        }
      }
      AppMethodBeat.o(16845);
    }
  }
  
  class m
    extends TXCGLSurfaceViewBase.b
  {
    public m(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceViewBase
 * JD-Core Version:    0.7.0.1
 */