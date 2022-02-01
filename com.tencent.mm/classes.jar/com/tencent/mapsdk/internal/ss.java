package com.tencent.mapsdk.internal;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
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
import javax.microedition.khronos.opengles.GL10;

public class ss
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  public static final String a = "tms-gl";
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 60;
  private static final String h = "GLSurfaceView";
  private static final boolean i = false;
  private static final boolean j = false;
  private static final boolean k = false;
  private static final boolean l = false;
  private static final boolean m = false;
  private static final boolean n = true;
  private static final boolean o = false;
  private static final j p;
  i g;
  private final WeakReference<ss> q;
  private m r;
  private boolean s;
  private e t;
  private f u;
  private g v;
  private k w;
  private int x;
  private int y;
  private boolean z;
  
  static
  {
    AppMethodBeat.i(223991);
    p = new j((byte)0);
    AppMethodBeat.o(223991);
  }
  
  public ss(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(223839);
    this.q = new WeakReference(this);
    d();
    AppMethodBeat.o(223839);
  }
  
  private ss(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(223851);
    this.q = new WeakReference(this);
    d();
    AppMethodBeat.o(223851);
  }
  
  public static String a(String paramString)
  {
    AppMethodBeat.i(223825);
    paramString = "tms-gl." + paramString + ".a4edf66";
    AppMethodBeat.o(223825);
    return paramString;
  }
  
  private void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(223898);
    i locali = this.g;
    if (paramRunnable == null)
    {
      paramRunnable = new IllegalArgumentException("r must not be null");
      AppMethodBeat.o(223898);
      throw paramRunnable;
    }
    synchronized (p)
    {
      locali.n.add(paramRunnable);
      p.notifyAll();
      AppMethodBeat.o(223898);
      return;
    }
  }
  
  private void d()
  {
    AppMethodBeat.i(223862);
    getHolder().addCallback(this);
    AppMethodBeat.o(223862);
  }
  
  private void e()
  {
    AppMethodBeat.i(223873);
    setEGLConfigChooser(new b(8, 16));
    AppMethodBeat.o(223873);
  }
  
  private void f()
  {
    AppMethodBeat.i(223883);
    this.g.c();
    AppMethodBeat.o(223883);
  }
  
  private void h()
  {
    AppMethodBeat.i(223912);
    if (this.g != null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
      AppMethodBeat.o(223912);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(223912);
  }
  
  public void a()
  {
    AppMethodBeat.i(224208);
    this.g.e();
    AppMethodBeat.o(224208);
  }
  
  public final void a(float paramFloat)
  {
    AppMethodBeat.i(224000);
    if (this.g != null)
    {
      this.g.a(paramFloat);
      this.g.c();
    }
    AppMethodBeat.o(224000);
  }
  
  public final void a(m paramm, float paramFloat)
  {
    AppMethodBeat.i(224078);
    h();
    if (this.t == null) {
      this.t = new n(true);
    }
    if (this.u == null) {
      this.u = new c((byte)0);
    }
    if (this.v == null) {
      this.v = new d((byte)0);
    }
    this.r = paramm;
    this.g = new i(this.q);
    this.g.a(paramFloat);
    this.g.start();
    AppMethodBeat.o(224078);
  }
  
  public void b()
  {
    AppMethodBeat.i(224198);
    this.g.d();
    AppMethodBeat.o(224198);
  }
  
  public void c()
  {
    AppMethodBeat.i(224236);
    if (this.g != null) {
      this.g.f();
    }
    AppMethodBeat.o(224236);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(224009);
    try
    {
      if (this.g != null) {
        this.g.f();
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(224009);
    }
  }
  
  public int getDebugFlags()
  {
    return this.x;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.z;
  }
  
  public int getRenderMode()
  {
    AppMethodBeat.i(224150);
    int i1 = this.g.b();
    AppMethodBeat.o(224150);
    return i1;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(224218);
    super.onAttachedToWindow();
    if (this.s) {
      this.g.e();
    }
    this.s = false;
    AppMethodBeat.o(224218);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(224228);
    if (this.g != null) {
      this.g.d();
    }
    this.s = true;
    super.onDetachedFromWindow();
    AppMethodBeat.o(224228);
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setEGLConfigChooser(e parame)
  {
    AppMethodBeat.i(224108);
    h();
    this.t = parame;
    AppMethodBeat.o(224108);
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    AppMethodBeat.i(224119);
    setEGLConfigChooser(new n(paramBoolean));
    AppMethodBeat.o(224119);
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    AppMethodBeat.i(224129);
    h();
    this.y = paramInt;
    AppMethodBeat.o(224129);
  }
  
  public void setEGLContextFactory(f paramf)
  {
    AppMethodBeat.i(224086);
    h();
    this.u = paramf;
    AppMethodBeat.o(224086);
  }
  
  public void setEGLWindowSurfaceFactory(g paramg)
  {
    AppMethodBeat.i(224098);
    h();
    this.v = paramg;
    AppMethodBeat.o(224098);
  }
  
  public void setGLWrapper(k paramk)
  {
    this.w = paramk;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(224140);
    i locali = this.g;
    if ((paramInt < 0) || (paramInt > 1))
    {
      ??? = new IllegalArgumentException("renderMode");
      AppMethodBeat.o(224140);
      throw ((Throwable)???);
    }
    synchronized (p)
    {
      locali.k = paramInt;
      p.notifyAll();
      AppMethodBeat.o(224140);
      return;
    }
  }
  
  public void setRenderer(m paramm)
  {
    AppMethodBeat.i(224065);
    a(paramm, 60.0F);
    AppMethodBeat.o(224065);
  }
  
  public void surfaceChanged(SurfaceHolder arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(224192);
    i locali = this.g;
    for (;;)
    {
      synchronized (p)
      {
        locali.i = paramInt2;
        locali.j = paramInt3;
        locali.o = true;
        locali.l = true;
        locali.m = false;
        p.notifyAll();
        if ((locali.a) || (locali.b) || (locali.m)) {
          break;
        }
        if ((locali.e) && (locali.f))
        {
          boolean bool = locali.a();
          if (bool)
          {
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break;
            }
            try
            {
              p.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
      paramInt1 = 0;
    }
    AppMethodBeat.o(224192);
  }
  
  public void surfaceCreated(SurfaceHolder arg1)
  {
    AppMethodBeat.i(224163);
    i locali = this.g;
    synchronized (p)
    {
      locali.c = true;
      locali.g = false;
      p.notifyAll();
      for (;;)
      {
        if ((locali.d) && (!locali.g))
        {
          boolean bool = locali.a;
          if (!bool) {
            try
            {
              p.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(224163);
  }
  
  public void surfaceDestroyed(SurfaceHolder arg1)
  {
    AppMethodBeat.i(224179);
    i locali = this.g;
    synchronized (p)
    {
      locali.c = false;
      p.notifyAll();
      for (;;)
      {
        if (!locali.d)
        {
          boolean bool = locali.a;
          if (!bool) {
            try
            {
              p.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(224179);
  }
  
  abstract class a
    implements ss.e
  {
    protected int[] a;
    
    public a(int[] paramArrayOfInt)
    {
      if (ss.a(ss.this) != 2) {}
      for (;;)
      {
        this.a = paramArrayOfInt;
        return;
        this$1 = new int[15];
        System.arraycopy(paramArrayOfInt, 0, ss.this, 0, 12);
        ss.this[12] = 12352;
        ss.this[13] = 4;
        ss.this[14] = 12344;
        paramArrayOfInt = ss.this;
      }
    }
    
    private int[] a(int[] paramArrayOfInt)
    {
      if (ss.a(ss.this) != 2) {
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
    
    public final EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
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
    extends ss.a
  {
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    private int[] j;
    
    public b(int paramInt1, int paramInt2)
    {
      super(new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, paramInt1, 12325, paramInt2, 12326, 0, 12344 });
      AppMethodBeat.i(224896);
      this.j = new int[1];
      this.c = 8;
      this.d = 8;
      this.e = 8;
      this.f = paramInt1;
      this.g = paramInt2;
      this.h = 0;
      AppMethodBeat.o(224896);
    }
    
    private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
    {
      AppMethodBeat.i(224906);
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.j))
      {
        paramInt = this.j[0];
        AppMethodBeat.o(224906);
        return paramInt;
      }
      AppMethodBeat.o(224906);
      return 0;
    }
    
    public final EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      AppMethodBeat.i(224919);
      int m = paramArrayOfEGLConfig.length;
      int k = 0;
      while (k < m)
      {
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[k];
        int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
        int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
        if ((n >= this.g) && (i1 >= this.h))
        {
          n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
          i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
          int i2 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
          int i3 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
          if ((n == this.c) && (i1 == this.d) && (i2 == this.e) && (i3 == this.f))
          {
            AppMethodBeat.o(224919);
            return localEGLConfig;
          }
        }
        k += 1;
      }
      AppMethodBeat.o(224919);
      return null;
    }
  }
  
  final class c
    implements ss.f
  {
    private int b = 12440;
    
    private c() {}
    
    public final EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      AppMethodBeat.i(224943);
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = this.b;
      arrayOfInt[1] = ss.a(ss.this);
      arrayOfInt[2] = 12344;
      EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
      if (ss.a(ss.this) != 0) {}
      for (;;)
      {
        paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
        AppMethodBeat.o(224943);
        return paramEGL10;
        arrayOfInt = null;
      }
    }
    
    public final void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      AppMethodBeat.i(224954);
      if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
      {
        new StringBuilder("display:").append(paramEGLDisplay).append(" context: ").append(paramEGLContext);
        paramEGL10.eglGetError();
        ss.h.a("eglDestroyContex");
      }
      AppMethodBeat.o(224954);
    }
  }
  
  static final class d
    implements ss.g
  {
    public final EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
    {
      Object localObject = null;
      AppMethodBeat.i(224782);
      try
      {
        paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
        AppMethodBeat.o(224782);
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
    
    public final void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      AppMethodBeat.i(224791);
      paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
      AppMethodBeat.o(224791);
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
  
  static final class h
  {
    WeakReference<ss> a;
    EGL10 b;
    EGLDisplay c;
    EGLSurface d;
    EGLConfig e;
    EGLContext f;
    
    public h(WeakReference<ss> paramWeakReference)
    {
      this.a = paramWeakReference;
    }
    
    public static void a(String paramString)
    {
      AppMethodBeat.i(225012);
      paramString = new RuntimeException(c(paramString));
      AppMethodBeat.o(225012);
      throw paramString;
    }
    
    public static void a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(225024);
      c(paramString2);
      AppMethodBeat.o(225024);
    }
    
    private void b(String paramString)
    {
      AppMethodBeat.i(225003);
      this.b.eglGetError();
      a(paramString);
      AppMethodBeat.o(225003);
    }
    
    private static String c(String paramString)
    {
      AppMethodBeat.i(225039);
      paramString = paramString + " failed: ";
      AppMethodBeat.o(225039);
      return paramString;
    }
    
    private void c()
    {
      AppMethodBeat.i(224952);
      this.b = ((EGL10)EGLContext.getEGL());
      this.c = this.b.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      if (this.c == EGL10.EGL_NO_DISPLAY)
      {
        localObject = new RuntimeException("eglGetDisplay failed");
        AppMethodBeat.o(224952);
        throw ((Throwable)localObject);
      }
      Object localObject = new int[2];
      if (!this.b.eglInitialize(this.c, (int[])localObject))
      {
        localObject = new RuntimeException("eglInitialize failed");
        AppMethodBeat.o(224952);
        throw ((Throwable)localObject);
      }
      localObject = (ss)this.a.get();
      if (localObject == null) {
        this.e = null;
      }
      for (this.f = null;; this.f = ss.c((ss)localObject).a(this.b, this.c, this.e))
      {
        if ((this.f == null) || (this.f == EGL10.EGL_NO_CONTEXT))
        {
          this.f = null;
          this.b.eglGetError();
          a("createContext");
        }
        this.d = null;
        AppMethodBeat.o(224952);
        return;
        this.e = ss.b((ss)localObject).a(this.b, this.c);
      }
    }
    
    private boolean d()
    {
      AppMethodBeat.i(224963);
      if (this.b == null)
      {
        localObject = new RuntimeException("egl not initialized");
        AppMethodBeat.o(224963);
        throw ((Throwable)localObject);
      }
      if (this.c == null)
      {
        localObject = new RuntimeException("eglDisplay not initialized");
        AppMethodBeat.o(224963);
        throw ((Throwable)localObject);
      }
      if (this.e == null)
      {
        localObject = new RuntimeException("mEglConfig not initialized");
        AppMethodBeat.o(224963);
        throw ((Throwable)localObject);
      }
      a();
      Object localObject = (ss)this.a.get();
      if (localObject != null) {}
      for (this.d = ss.d((ss)localObject).a(this.b, this.c, this.e, ((ss)localObject).getHolder()); (this.d == null) || (this.d == EGL10.EGL_NO_SURFACE); this.d = null)
      {
        this.b.eglGetError();
        AppMethodBeat.o(224963);
        return false;
      }
      if (!this.b.eglMakeCurrent(this.c, this.d, this.d, this.f))
      {
        this.b.eglGetError();
        a("EGLHelper", "eglMakeCurrent");
        AppMethodBeat.o(224963);
        return false;
      }
      AppMethodBeat.o(224963);
      return true;
    }
    
    private GL e()
    {
      AppMethodBeat.i(224972);
      GL localGL = this.f.getGL();
      ss localss = (ss)this.a.get();
      Object localObject = localGL;
      int i;
      if (localss != null)
      {
        if (ss.e(localss) != null) {
          localGL = ss.e(localss).a();
        }
        localObject = localGL;
        if ((ss.f(localss) & 0x3) != 0)
        {
          i = 0;
          if ((ss.f(localss) & 0x1) != 0) {
            i = 1;
          }
          if ((ss.f(localss) & 0x2) == 0) {
            break label109;
          }
        }
      }
      label109:
      for (localObject = new ss.l();; localObject = null)
      {
        localObject = GLDebugHelper.wrap(localGL, i, (Writer)localObject);
        AppMethodBeat.o(224972);
        return localObject;
      }
    }
    
    private int f()
    {
      AppMethodBeat.i(224981);
      if (!this.b.eglSwapBuffers(this.c, this.d))
      {
        int i = this.b.eglGetError();
        AppMethodBeat.o(224981);
        return i;
      }
      AppMethodBeat.o(224981);
      return 12288;
    }
    
    private void g()
    {
      AppMethodBeat.i(224990);
      a();
      AppMethodBeat.o(224990);
    }
    
    final void a()
    {
      AppMethodBeat.i(225051);
      if ((this.d != null) && (this.d != EGL10.EGL_NO_SURFACE))
      {
        Object localObject = this.b;
        EGLDisplay localEGLDisplay = this.c;
        EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
        ((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
        localObject = (ss)this.a.get();
        if (localObject != null) {
          ss.d((ss)localObject).a(this.b, this.c, this.d);
        }
        this.d = null;
      }
      AppMethodBeat.o(225051);
    }
    
    public final void b()
    {
      AppMethodBeat.i(225062);
      if (this.f != null)
      {
        ss localss = (ss)this.a.get();
        if (localss != null) {
          ss.c(localss).a(this.b, this.c, this.f);
        }
        this.f = null;
      }
      if (this.c != null)
      {
        this.b.eglTerminate(this.c);
        this.c = null;
      }
      AppMethodBeat.o(225062);
    }
  }
  
  static final class i
    extends Thread
  {
    boolean a;
    boolean b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    int i;
    int j;
    int k;
    boolean l;
    boolean m;
    ArrayList<Runnable> n;
    boolean o;
    private long p;
    private boolean q;
    private boolean r;
    private boolean s;
    private float t;
    private ss.h u;
    private WeakReference<ss> v;
    
    i(WeakReference<ss> paramWeakReference)
    {
      AppMethodBeat.i(225041);
      this.n = new ArrayList();
      this.o = true;
      this.t = 60.0F;
      this.i = 0;
      this.j = 0;
      this.l = true;
      this.k = 1;
      this.v = paramWeakReference;
      setName(ss.a("SV"));
      AppMethodBeat.o(225041);
    }
    
    private void a(int paramInt)
    {
      AppMethodBeat.i(225135);
      if ((paramInt < 0) || (paramInt > 1))
      {
        ??? = new IllegalArgumentException("renderMode");
        AppMethodBeat.o(225135);
        throw ((Throwable)???);
      }
      synchronized (ss.g())
      {
        this.k = paramInt;
        ss.g().notifyAll();
        AppMethodBeat.o(225135);
        return;
      }
    }
    
    private void a(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(225175);
      for (;;)
      {
        synchronized (ss.g())
        {
          this.i = paramInt1;
          this.j = paramInt2;
          this.o = true;
          this.l = true;
          this.m = false;
          ss.g().notifyAll();
          if ((this.a) || (this.b) || (this.m)) {
            break;
          }
          if ((this.e) && (this.f))
          {
            boolean bool = a();
            if (bool)
            {
              paramInt1 = 1;
              if (paramInt1 == 0) {
                break;
              }
              try
              {
                ss.g().wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
        paramInt1 = 0;
      }
      AppMethodBeat.o(225175);
    }
    
    private void a(Runnable paramRunnable)
    {
      AppMethodBeat.i(225195);
      if (paramRunnable == null)
      {
        paramRunnable = new IllegalArgumentException("r must not be null");
        AppMethodBeat.o(225195);
        throw paramRunnable;
      }
      synchronized (ss.g())
      {
        this.n.add(paramRunnable);
        ss.g().notifyAll();
        AppMethodBeat.o(225195);
        return;
      }
    }
    
    private void g()
    {
      AppMethodBeat.i(225050);
      if (this.f)
      {
        this.f = false;
        this.u.a();
      }
      AppMethodBeat.o(225050);
    }
    
    private void h()
    {
      AppMethodBeat.i(225060);
      if (this.e)
      {
        this.u.b();
        this.e = false;
        ss.g().c(this);
      }
      AppMethodBeat.o(225060);
    }
    
    /* Error */
    private void i()
    {
      // Byte code:
      //   0: ldc 153
      //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: new 138	com/tencent/mapsdk/internal/ss$h
      //   9: dup
      //   10: aload_0
      //   11: getfield 68	com/tencent/mapsdk/internal/ss$i:v	Ljava/lang/ref/WeakReference;
      //   14: invokespecial 155	com/tencent/mapsdk/internal/ss$h:<init>	(Ljava/lang/ref/WeakReference;)V
      //   17: putfield 136	com/tencent/mapsdk/internal/ss$i:u	Lcom/tencent/mapsdk/internal/ss$h;
      //   20: aload_0
      //   21: iconst_0
      //   22: putfield 109	com/tencent/mapsdk/internal/ss$i:e	Z
      //   25: aload_0
      //   26: iconst_0
      //   27: putfield 111	com/tencent/mapsdk/internal/ss$i:f	Z
      //   30: iconst_0
      //   31: istore 6
      //   33: iconst_0
      //   34: istore_2
      //   35: iconst_0
      //   36: istore_3
      //   37: iconst_0
      //   38: istore 7
      //   40: iconst_0
      //   41: istore 5
      //   43: iconst_0
      //   44: istore 9
      //   46: iconst_0
      //   47: istore 4
      //   49: iconst_0
      //   50: istore 12
      //   52: iconst_0
      //   53: istore 10
      //   55: aconst_null
      //   56: astore 24
      //   58: iconst_0
      //   59: istore_1
      //   60: aconst_null
      //   61: astore 25
      //   63: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   66: astore 26
      //   68: aload 26
      //   70: monitorenter
      //   71: iload 12
      //   73: istore 8
      //   75: iload 7
      //   77: istore 12
      //   79: iload 4
      //   81: istore 14
      //   83: iload 8
      //   85: istore 7
      //   87: iload_2
      //   88: istore 4
      //   90: aload_0
      //   91: getfield 157	com/tencent/mapsdk/internal/ss$i:q	Z
      //   94: ifeq +71 -> 165
      //   97: aload_0
      //   98: getfield 68	com/tencent/mapsdk/internal/ss$i:v	Ljava/lang/ref/WeakReference;
      //   101: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   104: checkcast 6	com/tencent/mapsdk/internal/ss
      //   107: astore 24
      //   109: aload 24
      //   111: ifnull +13 -> 124
      //   114: aload 24
      //   116: invokestatic 166	com/tencent/mapsdk/internal/ss:g	(Lcom/tencent/mapsdk/internal/ss;)Lcom/tencent/mapsdk/internal/ss$m;
      //   119: invokeinterface 171 1 0
      //   124: aload 26
      //   126: monitorexit
      //   127: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   130: astore 24
      //   132: aload 24
      //   134: monitorenter
      //   135: aload_0
      //   136: invokespecial 173	com/tencent/mapsdk/internal/ss$i:g	()V
      //   139: aload_0
      //   140: invokespecial 175	com/tencent/mapsdk/internal/ss$i:h	()V
      //   143: aload 24
      //   145: monitorexit
      //   146: ldc 153
      //   148: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   151: return
      //   152: astore 25
      //   154: aload 24
      //   156: monitorexit
      //   157: ldc 153
      //   159: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   162: aload 25
      //   164: athrow
      //   165: aload_0
      //   166: getfield 53	com/tencent/mapsdk/internal/ss$i:n	Ljava/util/ArrayList;
      //   169: invokevirtual 178	java/util/ArrayList:isEmpty	()Z
      //   172: ifne +74 -> 246
      //   175: aload_0
      //   176: getfield 53	com/tencent/mapsdk/internal/ss$i:n	Ljava/util/ArrayList;
      //   179: iconst_0
      //   180: invokevirtual 182	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   183: checkcast 184	java/lang/Runnable
      //   186: astore 24
      //   188: iload 7
      //   190: istore_2
      //   191: iload_3
      //   192: istore 8
      //   194: iload 12
      //   196: istore_3
      //   197: iload 5
      //   199: istore 7
      //   201: iload 14
      //   203: istore 5
      //   205: iload_2
      //   206: istore 12
      //   208: aload 26
      //   210: monitorexit
      //   211: aload 24
      //   213: ifnull +873 -> 1086
      //   216: aload 24
      //   218: invokeinterface 187 1 0
      //   223: aconst_null
      //   224: astore 24
      //   226: iload 4
      //   228: istore_2
      //   229: iload 5
      //   231: istore 4
      //   233: iload 7
      //   235: istore 5
      //   237: iload_3
      //   238: istore 7
      //   240: iload 8
      //   242: istore_3
      //   243: goto -180 -> 63
      //   246: aload_0
      //   247: getfield 107	com/tencent/mapsdk/internal/ss$i:b	Z
      //   250: aload_0
      //   251: getfield 189	com/tencent/mapsdk/internal/ss$i:r	Z
      //   254: if_icmpeq +1771 -> 2025
      //   257: aload_0
      //   258: getfield 189	com/tencent/mapsdk/internal/ss$i:r	Z
      //   261: istore 19
      //   263: aload_0
      //   264: aload_0
      //   265: getfield 189	com/tencent/mapsdk/internal/ss$i:r	Z
      //   268: putfield 107	com/tencent/mapsdk/internal/ss$i:b	Z
      //   271: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   274: invokevirtual 97	java/lang/Object:notifyAll	()V
      //   277: aload_0
      //   278: getfield 191	com/tencent/mapsdk/internal/ss$i:h	Z
      //   281: ifeq +1737 -> 2018
      //   284: aload_0
      //   285: invokespecial 173	com/tencent/mapsdk/internal/ss$i:g	()V
      //   288: aload_0
      //   289: invokespecial 175	com/tencent/mapsdk/internal/ss$i:h	()V
      //   292: aload_0
      //   293: iconst_0
      //   294: putfield 191	com/tencent/mapsdk/internal/ss$i:h	Z
      //   297: iconst_1
      //   298: istore 8
      //   300: iload 12
      //   302: istore 11
      //   304: iload 12
      //   306: ifeq +14 -> 320
      //   309: aload_0
      //   310: invokespecial 173	com/tencent/mapsdk/internal/ss$i:g	()V
      //   313: aload_0
      //   314: invokespecial 175	com/tencent/mapsdk/internal/ss$i:h	()V
      //   317: iconst_0
      //   318: istore 11
      //   320: iload 19
      //   322: ifeq +14 -> 336
      //   325: aload_0
      //   326: getfield 111	com/tencent/mapsdk/internal/ss$i:f	Z
      //   329: ifeq +7 -> 336
      //   332: aload_0
      //   333: invokespecial 173	com/tencent/mapsdk/internal/ss$i:g	()V
      //   336: iload 19
      //   338: ifeq +54 -> 392
      //   341: aload_0
      //   342: getfield 109	com/tencent/mapsdk/internal/ss$i:e	Z
      //   345: ifeq +47 -> 392
      //   348: aload_0
      //   349: getfield 68	com/tencent/mapsdk/internal/ss$i:v	Ljava/lang/ref/WeakReference;
      //   352: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   355: checkcast 6	com/tencent/mapsdk/internal/ss
      //   358: astore 27
      //   360: aload 27
      //   362: ifnull +1675 -> 2037
      //   365: aload 27
      //   367: invokestatic 194	com/tencent/mapsdk/internal/ss:h	(Lcom/tencent/mapsdk/internal/ss;)Z
      //   370: ifeq +1667 -> 2037
      //   373: iconst_1
      //   374: istore_2
      //   375: iload_2
      //   376: ifeq +12 -> 388
      //   379: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   382: invokevirtual 195	com/tencent/mapsdk/internal/ss$j:a	()Z
      //   385: ifeq +7 -> 392
      //   388: aload_0
      //   389: invokespecial 175	com/tencent/mapsdk/internal/ss$i:h	()V
      //   392: iload 19
      //   394: ifeq +19 -> 413
      //   397: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   400: invokevirtual 197	com/tencent/mapsdk/internal/ss$j:b	()Z
      //   403: ifeq +10 -> 413
      //   406: aload_0
      //   407: getfield 136	com/tencent/mapsdk/internal/ss$i:u	Lcom/tencent/mapsdk/internal/ss$h;
      //   410: invokevirtual 143	com/tencent/mapsdk/internal/ss$h:b	()V
      //   413: aload_0
      //   414: getfield 199	com/tencent/mapsdk/internal/ss$i:c	Z
      //   417: ifne +37 -> 454
      //   420: aload_0
      //   421: getfield 201	com/tencent/mapsdk/internal/ss$i:d	Z
      //   424: ifne +30 -> 454
      //   427: aload_0
      //   428: getfield 111	com/tencent/mapsdk/internal/ss$i:f	Z
      //   431: ifeq +7 -> 438
      //   434: aload_0
      //   435: invokespecial 173	com/tencent/mapsdk/internal/ss$i:g	()V
      //   438: aload_0
      //   439: iconst_1
      //   440: putfield 201	com/tencent/mapsdk/internal/ss$i:d	Z
      //   443: aload_0
      //   444: iconst_0
      //   445: putfield 203	com/tencent/mapsdk/internal/ss$i:s	Z
      //   448: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   451: invokevirtual 97	java/lang/Object:notifyAll	()V
      //   454: aload_0
      //   455: getfield 199	com/tencent/mapsdk/internal/ss$i:c	Z
      //   458: ifeq +21 -> 479
      //   461: aload_0
      //   462: getfield 201	com/tencent/mapsdk/internal/ss$i:d	Z
      //   465: ifeq +14 -> 479
      //   468: aload_0
      //   469: iconst_0
      //   470: putfield 201	com/tencent/mapsdk/internal/ss$i:d	Z
      //   473: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   476: invokevirtual 97	java/lang/Object:notifyAll	()V
      //   479: iload 14
      //   481: istore 13
      //   483: iload 9
      //   485: istore 12
      //   487: iload 14
      //   489: ifeq +20 -> 509
      //   492: iconst_0
      //   493: istore 12
      //   495: iconst_0
      //   496: istore 13
      //   498: aload_0
      //   499: iconst_1
      //   500: putfield 103	com/tencent/mapsdk/internal/ss$i:m	Z
      //   503: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   506: invokevirtual 97	java/lang/Object:notifyAll	()V
      //   509: iload 4
      //   511: istore 18
      //   513: iload 8
      //   515: istore 14
      //   517: iload 5
      //   519: istore 17
      //   521: iload_3
      //   522: istore 15
      //   524: iload 6
      //   526: istore 16
      //   528: aload_0
      //   529: invokevirtual 114	com/tencent/mapsdk/internal/ss$i:a	()Z
      //   532: ifeq +514 -> 1046
      //   535: iload 8
      //   537: istore 7
      //   539: iload 6
      //   541: istore_2
      //   542: aload_0
      //   543: getfield 109	com/tencent/mapsdk/internal/ss$i:e	Z
      //   546: ifne +14 -> 560
      //   549: iload 8
      //   551: ifeq +157 -> 708
      //   554: iconst_0
      //   555: istore 7
      //   557: iload 6
      //   559: istore_2
      //   560: iload 4
      //   562: istore 9
      //   564: iload 5
      //   566: istore 8
      //   568: iload_3
      //   569: istore 6
      //   571: aload_0
      //   572: getfield 109	com/tencent/mapsdk/internal/ss$i:e	Z
      //   575: ifeq +35 -> 610
      //   578: iload 4
      //   580: istore 9
      //   582: iload 5
      //   584: istore 8
      //   586: iload_3
      //   587: istore 6
      //   589: aload_0
      //   590: getfield 111	com/tencent/mapsdk/internal/ss$i:f	Z
      //   593: ifne +17 -> 610
      //   596: aload_0
      //   597: iconst_1
      //   598: putfield 111	com/tencent/mapsdk/internal/ss$i:f	Z
      //   601: iconst_1
      //   602: istore 9
      //   604: iconst_1
      //   605: istore 6
      //   607: iconst_1
      //   608: istore 8
      //   610: iload 9
      //   612: istore 18
      //   614: iload 7
      //   616: istore 14
      //   618: iload 8
      //   620: istore 17
      //   622: iload 6
      //   624: istore 15
      //   626: iload_2
      //   627: istore 16
      //   629: aload_0
      //   630: getfield 111	com/tencent/mapsdk/internal/ss$i:f	Z
      //   633: ifeq +413 -> 1046
      //   636: aload_0
      //   637: getfield 55	com/tencent/mapsdk/internal/ss$i:o	Z
      //   640: ifeq +1362 -> 2002
      //   643: iconst_1
      //   644: istore 8
      //   646: aload_0
      //   647: getfield 60	com/tencent/mapsdk/internal/ss$i:i	I
      //   650: istore_1
      //   651: aload_0
      //   652: getfield 62	com/tencent/mapsdk/internal/ss$i:j	I
      //   655: istore_3
      //   656: iconst_1
      //   657: istore 9
      //   659: iconst_1
      //   660: istore 4
      //   662: aload_0
      //   663: iconst_0
      //   664: putfield 55	com/tencent/mapsdk/internal/ss$i:o	Z
      //   667: aload_0
      //   668: iconst_0
      //   669: putfield 64	com/tencent/mapsdk/internal/ss$i:l	Z
      //   672: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   675: invokevirtual 97	java/lang/Object:notifyAll	()V
      //   678: iload_1
      //   679: istore 10
      //   681: iload_3
      //   682: istore_1
      //   683: iload 7
      //   685: istore 12
      //   687: iload 13
      //   689: istore 5
      //   691: iload 8
      //   693: istore 7
      //   695: iload 11
      //   697: istore_3
      //   698: iload 6
      //   700: istore 8
      //   702: iload_2
      //   703: istore 6
      //   705: goto -497 -> 208
      //   708: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   711: aload_0
      //   712: invokevirtual 205	com/tencent/mapsdk/internal/ss$j:b	(Lcom/tencent/mapsdk/internal/ss$i;)Z
      //   715: istore 19
      //   717: iload 8
      //   719: istore 7
      //   721: iload 6
      //   723: istore_2
      //   724: iload 19
      //   726: ifeq -166 -> 560
      //   729: aload_0
      //   730: getfield 136	com/tencent/mapsdk/internal/ss$i:u	Lcom/tencent/mapsdk/internal/ss$h;
      //   733: astore 27
      //   735: aload 27
      //   737: invokestatic 211	javax/microedition/khronos/egl/EGLContext:getEGL	()Ljavax/microedition/khronos/egl/EGL;
      //   740: checkcast 213	javax/microedition/khronos/egl/EGL10
      //   743: putfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   746: aload 27
      //   748: aload 27
      //   750: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   753: getstatic 220	javax/microedition/khronos/egl/EGL10:EGL_DEFAULT_DISPLAY	Ljava/lang/Object;
      //   756: invokeinterface 224 2 0
      //   761: putfield 227	com/tencent/mapsdk/internal/ss$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   764: aload 27
      //   766: getfield 227	com/tencent/mapsdk/internal/ss$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   769: getstatic 230	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   772: if_acmpne +91 -> 863
      //   775: new 152	java/lang/RuntimeException
      //   778: dup
      //   779: ldc 232
      //   781: invokespecial 233	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   784: astore 27
      //   786: ldc 153
      //   788: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   791: aload 27
      //   793: athrow
      //   794: astore 27
      //   796: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   799: aload_0
      //   800: invokevirtual 148	com/tencent/mapsdk/internal/ss$j:c	(Lcom/tencent/mapsdk/internal/ss$i;)V
      //   803: aload_0
      //   804: iconst_1
      //   805: putfield 109	com/tencent/mapsdk/internal/ss$i:e	Z
      //   808: iconst_1
      //   809: istore_2
      //   810: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   813: invokevirtual 97	java/lang/Object:notifyAll	()V
      //   816: iload 8
      //   818: istore 7
      //   820: goto -260 -> 560
      //   823: astore 24
      //   825: aload 26
      //   827: monitorexit
      //   828: ldc 153
      //   830: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   833: aload 24
      //   835: athrow
      //   836: astore 24
      //   838: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   841: astore 24
      //   843: aload 24
      //   845: monitorenter
      //   846: aload_0
      //   847: invokespecial 173	com/tencent/mapsdk/internal/ss$i:g	()V
      //   850: aload_0
      //   851: invokespecial 175	com/tencent/mapsdk/internal/ss$i:h	()V
      //   854: aload 24
      //   856: monitorexit
      //   857: ldc 153
      //   859: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   862: return
      //   863: iconst_2
      //   864: newarray int
      //   866: astore 28
      //   868: aload 27
      //   870: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   873: aload 27
      //   875: getfield 227	com/tencent/mapsdk/internal/ss$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   878: aload 28
      //   880: invokeinterface 237 3 0
      //   885: ifne +22 -> 907
      //   888: new 152	java/lang/RuntimeException
      //   891: dup
      //   892: ldc 239
      //   894: invokespecial 233	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   897: astore 27
      //   899: ldc 153
      //   901: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   904: aload 27
      //   906: athrow
      //   907: aload 27
      //   909: getfield 241	com/tencent/mapsdk/internal/ss$h:a	Ljava/lang/ref/WeakReference;
      //   912: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   915: checkcast 6	com/tencent/mapsdk/internal/ss
      //   918: astore 28
      //   920: aload 28
      //   922: ifnonnull +66 -> 988
      //   925: aload 27
      //   927: aconst_null
      //   928: putfield 244	com/tencent/mapsdk/internal/ss$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
      //   931: aload 27
      //   933: aconst_null
      //   934: putfield 247	com/tencent/mapsdk/internal/ss$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   937: aload 27
      //   939: getfield 247	com/tencent/mapsdk/internal/ss$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   942: ifnull +14 -> 956
      //   945: aload 27
      //   947: getfield 247	com/tencent/mapsdk/internal/ss$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   950: getstatic 250	javax/microedition/khronos/egl/EGL10:EGL_NO_CONTEXT	Ljavax/microedition/khronos/egl/EGLContext;
      //   953: if_acmpne +26 -> 979
      //   956: aload 27
      //   958: aconst_null
      //   959: putfield 247	com/tencent/mapsdk/internal/ss$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   962: aload 27
      //   964: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   967: invokeinterface 254 1 0
      //   972: pop
      //   973: ldc_w 256
      //   976: invokestatic 258	com/tencent/mapsdk/internal/ss$h:a	(Ljava/lang/String;)V
      //   979: aload 27
      //   981: aconst_null
      //   982: putfield 261	com/tencent/mapsdk/internal/ss$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   985: goto -182 -> 803
      //   988: aload 27
      //   990: aload 28
      //   992: invokestatic 264	com/tencent/mapsdk/internal/ss:b	(Lcom/tencent/mapsdk/internal/ss;)Lcom/tencent/mapsdk/internal/ss$e;
      //   995: aload 27
      //   997: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1000: aload 27
      //   1002: getfield 227	com/tencent/mapsdk/internal/ss$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1005: invokeinterface 269 3 0
      //   1010: putfield 244	com/tencent/mapsdk/internal/ss$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1013: aload 27
      //   1015: aload 28
      //   1017: invokestatic 272	com/tencent/mapsdk/internal/ss:c	(Lcom/tencent/mapsdk/internal/ss;)Lcom/tencent/mapsdk/internal/ss$f;
      //   1020: aload 27
      //   1022: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1025: aload 27
      //   1027: getfield 227	com/tencent/mapsdk/internal/ss$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1030: aload 27
      //   1032: getfield 244	com/tencent/mapsdk/internal/ss$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1035: invokeinterface 277 4 0
      //   1040: putfield 247	com/tencent/mapsdk/internal/ss$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   1043: goto -106 -> 937
      //   1046: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   1049: invokevirtual 117	java/lang/Object:wait	()V
      //   1052: iload 14
      //   1054: istore 7
      //   1056: iload 18
      //   1058: istore 4
      //   1060: iload 13
      //   1062: istore 14
      //   1064: iload 12
      //   1066: istore 9
      //   1068: iload 17
      //   1070: istore 5
      //   1072: iload 11
      //   1074: istore 12
      //   1076: iload 15
      //   1078: istore_3
      //   1079: iload 16
      //   1081: istore 6
      //   1083: goto -993 -> 90
      //   1086: iload 4
      //   1088: ifeq +908 -> 1996
      //   1091: aload_0
      //   1092: getfield 136	com/tencent/mapsdk/internal/ss$i:u	Lcom/tencent/mapsdk/internal/ss$h;
      //   1095: astore 26
      //   1097: aload 26
      //   1099: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1102: ifnonnull +52 -> 1154
      //   1105: new 152	java/lang/RuntimeException
      //   1108: dup
      //   1109: ldc_w 279
      //   1112: invokespecial 233	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1115: astore 24
      //   1117: ldc 153
      //   1119: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1122: aload 24
      //   1124: athrow
      //   1125: astore 25
      //   1127: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   1130: astore 24
      //   1132: aload 24
      //   1134: monitorenter
      //   1135: aload_0
      //   1136: invokespecial 173	com/tencent/mapsdk/internal/ss$i:g	()V
      //   1139: aload_0
      //   1140: invokespecial 175	com/tencent/mapsdk/internal/ss$i:h	()V
      //   1143: aload 24
      //   1145: monitorexit
      //   1146: ldc 153
      //   1148: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1151: aload 25
      //   1153: athrow
      //   1154: aload 26
      //   1156: getfield 227	com/tencent/mapsdk/internal/ss$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1159: ifnonnull +23 -> 1182
      //   1162: new 152	java/lang/RuntimeException
      //   1165: dup
      //   1166: ldc_w 281
      //   1169: invokespecial 233	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1172: astore 24
      //   1174: ldc 153
      //   1176: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1179: aload 24
      //   1181: athrow
      //   1182: aload 26
      //   1184: getfield 244	com/tencent/mapsdk/internal/ss$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1187: ifnonnull +23 -> 1210
      //   1190: new 152	java/lang/RuntimeException
      //   1193: dup
      //   1194: ldc_w 283
      //   1197: invokespecial 233	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1200: astore 24
      //   1202: ldc 153
      //   1204: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1207: aload 24
      //   1209: athrow
      //   1210: aload 26
      //   1212: invokevirtual 140	com/tencent/mapsdk/internal/ss$h:a	()V
      //   1215: aload 26
      //   1217: getfield 241	com/tencent/mapsdk/internal/ss$h:a	Ljava/lang/ref/WeakReference;
      //   1220: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1223: checkcast 6	com/tencent/mapsdk/internal/ss
      //   1226: astore 27
      //   1228: aload 27
      //   1230: ifnull +543 -> 1773
      //   1233: aload 26
      //   1235: aload 27
      //   1237: invokestatic 286	com/tencent/mapsdk/internal/ss:d	(Lcom/tencent/mapsdk/internal/ss;)Lcom/tencent/mapsdk/internal/ss$g;
      //   1240: aload 26
      //   1242: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1245: aload 26
      //   1247: getfield 227	com/tencent/mapsdk/internal/ss$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1250: aload 26
      //   1252: getfield 244	com/tencent/mapsdk/internal/ss$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1255: aload 27
      //   1257: invokevirtual 290	com/tencent/mapsdk/internal/ss:getHolder	()Landroid/view/SurfaceHolder;
      //   1260: invokeinterface 295 5 0
      //   1265: putfield 261	com/tencent/mapsdk/internal/ss$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1268: aload 26
      //   1270: getfield 261	com/tencent/mapsdk/internal/ss$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1273: ifnull +14 -> 1287
      //   1276: aload 26
      //   1278: getfield 261	com/tencent/mapsdk/internal/ss$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1281: getstatic 298	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1284: if_acmpne +498 -> 1782
      //   1287: aload 26
      //   1289: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1292: invokeinterface 254 1 0
      //   1297: pop
      //   1298: iconst_0
      //   1299: istore_2
      //   1300: iload_2
      //   1301: ifeq +552 -> 1853
      //   1304: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   1307: astore 26
      //   1309: aload 26
      //   1311: monitorenter
      //   1312: aload_0
      //   1313: iconst_1
      //   1314: putfield 300	com/tencent/mapsdk/internal/ss$i:g	Z
      //   1317: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   1320: invokevirtual 97	java/lang/Object:notifyAll	()V
      //   1323: aload 26
      //   1325: monitorexit
      //   1326: iconst_0
      //   1327: istore_2
      //   1328: iload 8
      //   1330: istore 11
      //   1332: iload 8
      //   1334: ifeq +139 -> 1473
      //   1337: aload_0
      //   1338: getfield 136	com/tencent/mapsdk/internal/ss$i:u	Lcom/tencent/mapsdk/internal/ss$h;
      //   1341: astore 26
      //   1343: aload 26
      //   1345: getfield 247	com/tencent/mapsdk/internal/ss$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   1348: invokevirtual 304	javax/microedition/khronos/egl/EGLContext:getGL	()Ljavax/microedition/khronos/opengles/GL;
      //   1351: astore 25
      //   1353: aload 26
      //   1355: getfield 241	com/tencent/mapsdk/internal/ss$h:a	Ljava/lang/ref/WeakReference;
      //   1358: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1361: checkcast 6	com/tencent/mapsdk/internal/ss
      //   1364: astore 27
      //   1366: aload 25
      //   1368: astore 26
      //   1370: aload 27
      //   1372: ifnull +617 -> 1989
      //   1375: aload 27
      //   1377: invokestatic 307	com/tencent/mapsdk/internal/ss:e	(Lcom/tencent/mapsdk/internal/ss;)Lcom/tencent/mapsdk/internal/ss$k;
      //   1380: ifnull +15 -> 1395
      //   1383: aload 27
      //   1385: invokestatic 307	com/tencent/mapsdk/internal/ss:e	(Lcom/tencent/mapsdk/internal/ss;)Lcom/tencent/mapsdk/internal/ss$k;
      //   1388: invokeinterface 311 1 0
      //   1393: astore 25
      //   1395: aload 25
      //   1397: astore 26
      //   1399: aload 27
      //   1401: invokestatic 314	com/tencent/mapsdk/internal/ss:f	(Lcom/tencent/mapsdk/internal/ss;)I
      //   1404: iconst_3
      //   1405: iand
      //   1406: ifeq +583 -> 1989
      //   1409: iconst_0
      //   1410: istore 4
      //   1412: aload 27
      //   1414: invokestatic 314	com/tencent/mapsdk/internal/ss:f	(Lcom/tencent/mapsdk/internal/ss;)I
      //   1417: iconst_1
      //   1418: iand
      //   1419: ifeq +6 -> 1425
      //   1422: iconst_1
      //   1423: istore 4
      //   1425: aload 27
      //   1427: invokestatic 314	com/tencent/mapsdk/internal/ss:f	(Lcom/tencent/mapsdk/internal/ss;)I
      //   1430: iconst_2
      //   1431: iand
      //   1432: ifeq +551 -> 1983
      //   1435: new 316	com/tencent/mapsdk/internal/ss$l
      //   1438: dup
      //   1439: invokespecial 317	com/tencent/mapsdk/internal/ss$l:<init>	()V
      //   1442: astore 26
      //   1444: aload 25
      //   1446: iload 4
      //   1448: aload 26
      //   1450: invokestatic 323	android/opengl/GLDebugHelper:wrap	(Ljavax/microedition/khronos/opengles/GL;ILjava/io/Writer;)Ljavax/microedition/khronos/opengles/GL;
      //   1453: astore 25
      //   1455: aload 25
      //   1457: checkcast 325	javax/microedition/khronos/opengles/GL10
      //   1460: astore 25
      //   1462: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   1465: aload 25
      //   1467: invokevirtual 328	com/tencent/mapsdk/internal/ss$j:a	(Ljavax/microedition/khronos/opengles/GL10;)V
      //   1470: iconst_0
      //   1471: istore 11
      //   1473: iload 6
      //   1475: istore 8
      //   1477: iload 6
      //   1479: ifeq +42 -> 1521
      //   1482: aload_0
      //   1483: getfield 68	com/tencent/mapsdk/internal/ss$i:v	Ljava/lang/ref/WeakReference;
      //   1486: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1489: checkcast 6	com/tencent/mapsdk/internal/ss
      //   1492: astore 26
      //   1494: aload 26
      //   1496: ifnull +546 -> 2042
      //   1499: aload 26
      //   1501: invokestatic 166	com/tencent/mapsdk/internal/ss:g	(Lcom/tencent/mapsdk/internal/ss;)Lcom/tencent/mapsdk/internal/ss$m;
      //   1504: aload 25
      //   1506: aload_0
      //   1507: getfield 136	com/tencent/mapsdk/internal/ss$i:u	Lcom/tencent/mapsdk/internal/ss$h;
      //   1510: getfield 244	com/tencent/mapsdk/internal/ss$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1513: invokeinterface 331 3 0
      //   1518: goto +524 -> 2042
      //   1521: iload 7
      //   1523: istore 6
      //   1525: iload 7
      //   1527: ifeq +38 -> 1565
      //   1530: aload_0
      //   1531: getfield 68	com/tencent/mapsdk/internal/ss$i:v	Ljava/lang/ref/WeakReference;
      //   1534: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1537: checkcast 6	com/tencent/mapsdk/internal/ss
      //   1540: astore 26
      //   1542: aload 26
      //   1544: ifnull +504 -> 2048
      //   1547: aload 26
      //   1549: invokestatic 166	com/tencent/mapsdk/internal/ss:g	(Lcom/tencent/mapsdk/internal/ss;)Lcom/tencent/mapsdk/internal/ss$m;
      //   1552: aload 25
      //   1554: iload 10
      //   1556: iload_1
      //   1557: invokeinterface 334 4 0
      //   1562: goto +486 -> 2048
      //   1565: aload_0
      //   1566: getfield 336	com/tencent/mapsdk/internal/ss$i:p	J
      //   1569: lconst_0
      //   1570: lcmp
      //   1571: ifeq +7 -> 1578
      //   1574: invokestatic 342	java/lang/System:currentTimeMillis	()J
      //   1577: pop2
      //   1578: aload_0
      //   1579: invokestatic 342	java/lang/System:currentTimeMillis	()J
      //   1582: putfield 336	com/tencent/mapsdk/internal/ss$i:p	J
      //   1585: invokestatic 342	java/lang/System:currentTimeMillis	()J
      //   1588: lstore 20
      //   1590: aload_0
      //   1591: getfield 68	com/tencent/mapsdk/internal/ss$i:v	Ljava/lang/ref/WeakReference;
      //   1594: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1597: checkcast 6	com/tencent/mapsdk/internal/ss
      //   1600: astore 26
      //   1602: aload 26
      //   1604: ifnull +427 -> 2031
      //   1607: aload 26
      //   1609: invokestatic 166	com/tencent/mapsdk/internal/ss:g	(Lcom/tencent/mapsdk/internal/ss;)Lcom/tencent/mapsdk/internal/ss$m;
      //   1612: aload 25
      //   1614: invokeinterface 345 2 0
      //   1619: istore 19
      //   1621: invokestatic 342	java/lang/System:currentTimeMillis	()J
      //   1624: lstore 22
      //   1626: iload_3
      //   1627: istore 7
      //   1629: iload 19
      //   1631: ifeq +81 -> 1712
      //   1634: aload_0
      //   1635: getfield 136	com/tencent/mapsdk/internal/ss$i:u	Lcom/tencent/mapsdk/internal/ss$h;
      //   1638: astore 26
      //   1640: aload 26
      //   1642: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1645: aload 26
      //   1647: getfield 227	com/tencent/mapsdk/internal/ss$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1650: aload 26
      //   1652: getfield 261	com/tencent/mapsdk/internal/ss$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1655: invokeinterface 349 3 0
      //   1660: ifne +432 -> 2092
      //   1663: aload 26
      //   1665: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1668: invokeinterface 254 1 0
      //   1673: istore 4
      //   1675: goto +379 -> 2054
      //   1678: ldc_w 351
      //   1681: ldc_w 352
      //   1684: invokestatic 355	com/tencent/mapsdk/internal/ss$h:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   1687: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   1690: astore 26
      //   1692: aload 26
      //   1694: monitorenter
      //   1695: aload_0
      //   1696: iconst_1
      //   1697: putfield 203	com/tencent/mapsdk/internal/ss$i:s	Z
      //   1700: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   1703: invokevirtual 97	java/lang/Object:notifyAll	()V
      //   1706: aload 26
      //   1708: monitorexit
      //   1709: iload_3
      //   1710: istore 7
      //   1712: iload 5
      //   1714: istore 4
      //   1716: iload 9
      //   1718: ifeq +6 -> 1724
      //   1721: iconst_1
      //   1722: istore 4
      //   1724: ldc_w 356
      //   1727: aload_0
      //   1728: getfield 58	com/tencent/mapsdk/internal/ss$i:t	F
      //   1731: fdiv
      //   1732: lload 22
      //   1734: lload 20
      //   1736: lsub
      //   1737: l2f
      //   1738: fsub
      //   1739: f2i
      //   1740: istore_3
      //   1741: iload_3
      //   1742: ifle +196 -> 1938
      //   1745: aload_0
      //   1746: monitorenter
      //   1747: iload_3
      //   1748: i2l
      //   1749: lstore 20
      //   1751: aload_0
      //   1752: lload 20
      //   1754: invokevirtual 359	java/lang/Object:wait	(J)V
      //   1757: aload_0
      //   1758: monitorexit
      //   1759: iload 6
      //   1761: istore 5
      //   1763: iload 11
      //   1765: istore_3
      //   1766: iload 8
      //   1768: istore 6
      //   1770: goto -1707 -> 63
      //   1773: aload 26
      //   1775: aconst_null
      //   1776: putfield 261	com/tencent/mapsdk/internal/ss$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1779: goto -511 -> 1268
      //   1782: aload 26
      //   1784: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1787: aload 26
      //   1789: getfield 227	com/tencent/mapsdk/internal/ss$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1792: aload 26
      //   1794: getfield 261	com/tencent/mapsdk/internal/ss$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1797: aload 26
      //   1799: getfield 261	com/tencent/mapsdk/internal/ss$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1802: aload 26
      //   1804: getfield 247	com/tencent/mapsdk/internal/ss$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   1807: invokeinterface 363 5 0
      //   1812: ifne +275 -> 2087
      //   1815: aload 26
      //   1817: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1820: invokeinterface 254 1 0
      //   1825: pop
      //   1826: ldc_w 365
      //   1829: ldc_w 366
      //   1832: invokestatic 355	com/tencent/mapsdk/internal/ss$h:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   1835: iconst_0
      //   1836: istore_2
      //   1837: goto -537 -> 1300
      //   1840: astore 24
      //   1842: aload 26
      //   1844: monitorexit
      //   1845: ldc 153
      //   1847: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1850: aload 24
      //   1852: athrow
      //   1853: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   1856: astore 26
      //   1858: aload 26
      //   1860: monitorenter
      //   1861: aload_0
      //   1862: iconst_1
      //   1863: putfield 300	com/tencent/mapsdk/internal/ss$i:g	Z
      //   1866: aload_0
      //   1867: iconst_1
      //   1868: putfield 203	com/tencent/mapsdk/internal/ss$i:s	Z
      //   1871: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   1874: invokevirtual 97	java/lang/Object:notifyAll	()V
      //   1877: aload 26
      //   1879: monitorexit
      //   1880: iload 4
      //   1882: istore_2
      //   1883: iload 5
      //   1885: istore 4
      //   1887: iload 7
      //   1889: istore 5
      //   1891: iload_3
      //   1892: istore 7
      //   1894: iload 8
      //   1896: istore_3
      //   1897: goto -1834 -> 63
      //   1900: astore 24
      //   1902: aload 26
      //   1904: monitorexit
      //   1905: ldc 153
      //   1907: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1910: aload 24
      //   1912: athrow
      //   1913: astore 24
      //   1915: aload 26
      //   1917: monitorexit
      //   1918: ldc 153
      //   1920: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1923: aload 24
      //   1925: athrow
      //   1926: astore 24
      //   1928: aload_0
      //   1929: monitorexit
      //   1930: ldc 153
      //   1932: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1935: aload 24
      //   1937: athrow
      //   1938: iload 6
      //   1940: istore 5
      //   1942: iload 11
      //   1944: istore_3
      //   1945: iload 8
      //   1947: istore 6
      //   1949: goto -1886 -> 63
      //   1952: astore 25
      //   1954: aload 24
      //   1956: monitorexit
      //   1957: ldc 153
      //   1959: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1962: aload 25
      //   1964: athrow
      //   1965: astore 25
      //   1967: aload 24
      //   1969: monitorexit
      //   1970: ldc 153
      //   1972: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1975: aload 25
      //   1977: athrow
      //   1978: astore 26
      //   1980: goto -223 -> 1757
      //   1983: aconst_null
      //   1984: astore 26
      //   1986: goto -542 -> 1444
      //   1989: aload 26
      //   1991: astore 25
      //   1993: goto -538 -> 1455
      //   1996: iload 4
      //   1998: istore_2
      //   1999: goto -671 -> 1328
      //   2002: iload_1
      //   2003: istore_3
      //   2004: iload 10
      //   2006: istore_1
      //   2007: iload 9
      //   2009: istore 4
      //   2011: iload 12
      //   2013: istore 9
      //   2015: goto -1348 -> 667
      //   2018: iload 7
      //   2020: istore 8
      //   2022: goto -1722 -> 300
      //   2025: iconst_0
      //   2026: istore 19
      //   2028: goto -1751 -> 277
      //   2031: iconst_0
      //   2032: istore 19
      //   2034: goto -413 -> 1621
      //   2037: iconst_0
      //   2038: istore_2
      //   2039: goto -1664 -> 375
      //   2042: iconst_0
      //   2043: istore 8
      //   2045: goto -524 -> 1521
      //   2048: iconst_0
      //   2049: istore 6
      //   2051: goto -486 -> 1565
      //   2054: iload_3
      //   2055: istore 7
      //   2057: iload 4
      //   2059: lookupswitch	default:+25->2084, 12288:+-347->1712, 12302:+41->2100
      //   2085: impdep1
      //   2086: fmul
      //   2087: iconst_1
      //   2088: istore_2
      //   2089: goto -789 -> 1300
      //   2092: sipush 12288
      //   2095: istore 4
      //   2097: goto -43 -> 2054
      //   2100: iconst_1
      //   2101: istore 7
      //   2103: goto -391 -> 1712
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2106	0	this	i
      //   59	1948	1	i1	int
      //   34	2055	2	i2	int
      //   36	2019	3	i3	int
      //   47	2049	4	i4	int
      //   41	1900	5	i5	int
      //   31	2019	6	i6	int
      //   38	2064	7	i7	int
      //   73	1971	8	i8	int
      //   44	1970	9	i9	int
      //   53	1952	10	i10	int
      //   302	1641	11	i11	int
      //   50	1962	12	i12	int
      //   481	580	13	i13	int
      //   81	982	14	i14	int
      //   522	555	15	i15	int
      //   526	554	16	i16	int
      //   519	550	17	i17	int
      //   511	546	18	i18	int
      //   261	1772	19	bool	boolean
      //   1588	165	20	l1	long
      //   1624	109	22	l2	long
      //   56	169	24	localObject1	Object
      //   823	11	24	localObject2	Object
      //   836	1	24	localException	java.lang.Exception
      //   841	367	24	localObject3	Object
      //   1840	11	24	localObject4	Object
      //   1900	11	24	localObject5	Object
      //   1913	11	24	localObject6	Object
      //   1926	42	24	localObject7	Object
      //   61	1	25	localObject8	Object
      //   152	11	25	localObject9	Object
      //   1125	27	25	localObject10	Object
      //   1351	262	25	localObject11	Object
      //   1952	11	25	localObject12	Object
      //   1965	11	25	localObject13	Object
      //   1991	1	25	localObject14	Object
      //   1978	1	26	localInterruptedException	InterruptedException
      //   1984	6	26	localObject16	Object
      //   358	434	27	localObject17	Object
      //   794	80	27	localRuntimeException	RuntimeException
      //   897	529	27	localObject18	Object
      //   866	150	28	localObject19	Object
      // Exception table:
      //   from	to	target	type
      //   135	146	152	finally
      //   729	794	794	java/lang/RuntimeException
      //   863	907	794	java/lang/RuntimeException
      //   907	920	794	java/lang/RuntimeException
      //   925	937	794	java/lang/RuntimeException
      //   937	956	794	java/lang/RuntimeException
      //   956	979	794	java/lang/RuntimeException
      //   979	985	794	java/lang/RuntimeException
      //   988	1043	794	java/lang/RuntimeException
      //   90	109	823	finally
      //   114	124	823	finally
      //   124	127	823	finally
      //   165	188	823	finally
      //   208	211	823	finally
      //   246	277	823	finally
      //   277	297	823	finally
      //   309	317	823	finally
      //   325	336	823	finally
      //   341	360	823	finally
      //   365	373	823	finally
      //   379	388	823	finally
      //   388	392	823	finally
      //   397	413	823	finally
      //   413	438	823	finally
      //   438	454	823	finally
      //   454	479	823	finally
      //   498	509	823	finally
      //   528	535	823	finally
      //   542	549	823	finally
      //   571	578	823	finally
      //   589	601	823	finally
      //   629	643	823	finally
      //   646	656	823	finally
      //   662	667	823	finally
      //   667	678	823	finally
      //   708	717	823	finally
      //   729	794	823	finally
      //   796	803	823	finally
      //   803	808	823	finally
      //   810	816	823	finally
      //   863	907	823	finally
      //   907	920	823	finally
      //   925	937	823	finally
      //   937	956	823	finally
      //   956	979	823	finally
      //   979	985	823	finally
      //   988	1043	823	finally
      //   1046	1052	823	finally
      //   63	71	836	java/lang/Exception
      //   216	223	836	java/lang/Exception
      //   825	836	836	java/lang/Exception
      //   1091	1125	836	java/lang/Exception
      //   1154	1182	836	java/lang/Exception
      //   1182	1210	836	java/lang/Exception
      //   1210	1228	836	java/lang/Exception
      //   1233	1268	836	java/lang/Exception
      //   1268	1287	836	java/lang/Exception
      //   1287	1298	836	java/lang/Exception
      //   1304	1312	836	java/lang/Exception
      //   1337	1366	836	java/lang/Exception
      //   1375	1395	836	java/lang/Exception
      //   1399	1409	836	java/lang/Exception
      //   1412	1422	836	java/lang/Exception
      //   1425	1444	836	java/lang/Exception
      //   1444	1455	836	java/lang/Exception
      //   1455	1470	836	java/lang/Exception
      //   1482	1494	836	java/lang/Exception
      //   1499	1518	836	java/lang/Exception
      //   1530	1542	836	java/lang/Exception
      //   1547	1562	836	java/lang/Exception
      //   1565	1578	836	java/lang/Exception
      //   1578	1602	836	java/lang/Exception
      //   1607	1621	836	java/lang/Exception
      //   1621	1626	836	java/lang/Exception
      //   1634	1675	836	java/lang/Exception
      //   1678	1695	836	java/lang/Exception
      //   1724	1741	836	java/lang/Exception
      //   1745	1747	836	java/lang/Exception
      //   1773	1779	836	java/lang/Exception
      //   1782	1835	836	java/lang/Exception
      //   1842	1853	836	java/lang/Exception
      //   1853	1861	836	java/lang/Exception
      //   1902	1913	836	java/lang/Exception
      //   1915	1926	836	java/lang/Exception
      //   1928	1938	836	java/lang/Exception
      //   63	71	1125	finally
      //   216	223	1125	finally
      //   825	836	1125	finally
      //   1091	1125	1125	finally
      //   1154	1182	1125	finally
      //   1182	1210	1125	finally
      //   1210	1228	1125	finally
      //   1233	1268	1125	finally
      //   1268	1287	1125	finally
      //   1287	1298	1125	finally
      //   1304	1312	1125	finally
      //   1337	1366	1125	finally
      //   1375	1395	1125	finally
      //   1399	1409	1125	finally
      //   1412	1422	1125	finally
      //   1425	1444	1125	finally
      //   1444	1455	1125	finally
      //   1455	1470	1125	finally
      //   1482	1494	1125	finally
      //   1499	1518	1125	finally
      //   1530	1542	1125	finally
      //   1547	1562	1125	finally
      //   1565	1578	1125	finally
      //   1578	1602	1125	finally
      //   1607	1621	1125	finally
      //   1621	1626	1125	finally
      //   1634	1675	1125	finally
      //   1678	1695	1125	finally
      //   1724	1741	1125	finally
      //   1745	1747	1125	finally
      //   1773	1779	1125	finally
      //   1782	1835	1125	finally
      //   1842	1853	1125	finally
      //   1853	1861	1125	finally
      //   1902	1913	1125	finally
      //   1915	1926	1125	finally
      //   1928	1938	1125	finally
      //   1312	1326	1840	finally
      //   1861	1880	1900	finally
      //   1695	1709	1913	finally
      //   1751	1757	1926	finally
      //   1757	1759	1926	finally
      //   846	857	1952	finally
      //   1135	1146	1965	finally
      //   1751	1757	1978	java/lang/InterruptedException
    }
    
    private boolean j()
    {
      AppMethodBeat.i(225120);
      if ((this.e) && (this.f) && (a()))
      {
        AppMethodBeat.o(225120);
        return true;
      }
      AppMethodBeat.o(225120);
      return false;
    }
    
    private void k()
    {
      AppMethodBeat.i(225148);
      synchronized (ss.g())
      {
        this.c = true;
        this.g = false;
        ss.g().notifyAll();
        for (;;)
        {
          if ((this.d) && (!this.g))
          {
            boolean bool = this.a;
            if (!bool) {
              try
              {
                ss.g().wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
      AppMethodBeat.o(225148);
    }
    
    private void l()
    {
      AppMethodBeat.i(225160);
      synchronized (ss.g())
      {
        this.c = false;
        ss.g().notifyAll();
        for (;;)
        {
          if (!this.d)
          {
            boolean bool = this.a;
            if (!bool) {
              try
              {
                ss.g().wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
      AppMethodBeat.o(225160);
    }
    
    private void m()
    {
      AppMethodBeat.i(225185);
      synchronized (ss.g())
      {
        this.h = true;
        ss.g().notifyAll();
        AppMethodBeat.o(225185);
        return;
      }
    }
    
    public final void a(float paramFloat)
    {
      AppMethodBeat.i(225314);
      if (paramFloat <= 1.0F)
      {
        kh.e("TRD", "帧率设置不在有效值范围内");
        AppMethodBeat.o(225314);
        return;
      }
      this.t = paramFloat;
      AppMethodBeat.o(225314);
    }
    
    final boolean a()
    {
      return (!this.b) && (this.c) && (!this.s) && (this.i > 0) && (this.j > 0) && ((this.l) || (this.k == 1));
    }
    
    public final int b()
    {
      AppMethodBeat.i(225257);
      synchronized (ss.g())
      {
        int i1 = this.k;
        AppMethodBeat.o(225257);
        return i1;
      }
    }
    
    public final void c()
    {
      AppMethodBeat.i(225269);
      synchronized (ss.g())
      {
        this.l = true;
        ss.g().notifyAll();
        AppMethodBeat.o(225269);
        return;
      }
    }
    
    public final void d()
    {
      AppMethodBeat.i(225282);
      synchronized (ss.g())
      {
        this.r = true;
        ss.g().notifyAll();
        for (;;)
        {
          if (!this.a)
          {
            boolean bool = this.b;
            if (!bool) {
              try
              {
                ss.g().wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
      AppMethodBeat.o(225282);
    }
    
    public final void e()
    {
      AppMethodBeat.i(225293);
      synchronized (ss.g())
      {
        this.r = false;
        this.l = true;
        this.m = false;
        ss.g().notifyAll();
        for (;;)
        {
          if ((!this.a) && (this.b))
          {
            boolean bool = this.m;
            if (!bool) {
              try
              {
                ss.g().wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
      AppMethodBeat.o(225293);
    }
    
    public final void f()
    {
      AppMethodBeat.i(225303);
      synchronized (ss.g())
      {
        this.q = true;
        ss.g().notifyAll();
        for (;;)
        {
          boolean bool = this.a;
          if (!bool) {
            try
            {
              ss.g().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
      AppMethodBeat.o(225303);
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc_w 386
      //   3: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: new 138	com/tencent/mapsdk/internal/ss$h
      //   10: dup
      //   11: aload_0
      //   12: getfield 68	com/tencent/mapsdk/internal/ss$i:v	Ljava/lang/ref/WeakReference;
      //   15: invokespecial 155	com/tencent/mapsdk/internal/ss$h:<init>	(Ljava/lang/ref/WeakReference;)V
      //   18: putfield 136	com/tencent/mapsdk/internal/ss$i:u	Lcom/tencent/mapsdk/internal/ss$h;
      //   21: aload_0
      //   22: iconst_0
      //   23: putfield 109	com/tencent/mapsdk/internal/ss$i:e	Z
      //   26: aload_0
      //   27: iconst_0
      //   28: putfield 111	com/tencent/mapsdk/internal/ss$i:f	Z
      //   31: iconst_0
      //   32: istore 6
      //   34: iconst_0
      //   35: istore_2
      //   36: iconst_0
      //   37: istore_3
      //   38: iconst_0
      //   39: istore 7
      //   41: iconst_0
      //   42: istore 5
      //   44: iconst_0
      //   45: istore 9
      //   47: iconst_0
      //   48: istore 4
      //   50: iconst_0
      //   51: istore 12
      //   53: iconst_0
      //   54: istore 10
      //   56: aconst_null
      //   57: astore 24
      //   59: iconst_0
      //   60: istore_1
      //   61: aconst_null
      //   62: astore 25
      //   64: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   67: astore 26
      //   69: aload 26
      //   71: monitorenter
      //   72: iload 12
      //   74: istore 8
      //   76: iload 7
      //   78: istore 12
      //   80: iload 4
      //   82: istore 14
      //   84: iload 8
      //   86: istore 7
      //   88: iload_2
      //   89: istore 4
      //   91: aload_0
      //   92: getfield 157	com/tencent/mapsdk/internal/ss$i:q	Z
      //   95: ifeq +102 -> 197
      //   98: aload_0
      //   99: getfield 68	com/tencent/mapsdk/internal/ss$i:v	Ljava/lang/ref/WeakReference;
      //   102: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   105: checkcast 6	com/tencent/mapsdk/internal/ss
      //   108: astore 24
      //   110: aload 24
      //   112: ifnull +13 -> 125
      //   115: aload 24
      //   117: invokestatic 166	com/tencent/mapsdk/internal/ss:g	(Lcom/tencent/mapsdk/internal/ss;)Lcom/tencent/mapsdk/internal/ss$m;
      //   120: invokeinterface 171 1 0
      //   125: aload 26
      //   127: monitorexit
      //   128: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   131: astore 24
      //   133: aload 24
      //   135: monitorenter
      //   136: aload_0
      //   137: invokespecial 173	com/tencent/mapsdk/internal/ss$i:g	()V
      //   140: aload_0
      //   141: invokespecial 175	com/tencent/mapsdk/internal/ss$i:h	()V
      //   144: aload 24
      //   146: monitorexit
      //   147: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   150: aload_0
      //   151: invokevirtual 388	com/tencent/mapsdk/internal/ss$j:a	(Lcom/tencent/mapsdk/internal/ss$i;)V
      //   154: ldc_w 386
      //   157: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   160: return
      //   161: astore 25
      //   163: aload 24
      //   165: monitorexit
      //   166: ldc_w 386
      //   169: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   172: aload 25
      //   174: athrow
      //   175: astore 24
      //   177: invokestatic 121	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   180: invokevirtual 124	java/lang/Thread:interrupt	()V
      //   183: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   186: aload_0
      //   187: invokevirtual 388	com/tencent/mapsdk/internal/ss$j:a	(Lcom/tencent/mapsdk/internal/ss$i;)V
      //   190: ldc_w 386
      //   193: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   196: return
      //   197: aload_0
      //   198: getfield 53	com/tencent/mapsdk/internal/ss$i:n	Ljava/util/ArrayList;
      //   201: invokevirtual 178	java/util/ArrayList:isEmpty	()Z
      //   204: ifne +74 -> 278
      //   207: aload_0
      //   208: getfield 53	com/tencent/mapsdk/internal/ss$i:n	Ljava/util/ArrayList;
      //   211: iconst_0
      //   212: invokevirtual 182	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   215: checkcast 184	java/lang/Runnable
      //   218: astore 24
      //   220: iload 7
      //   222: istore_2
      //   223: iload_3
      //   224: istore 8
      //   226: iload 12
      //   228: istore_3
      //   229: iload 5
      //   231: istore 7
      //   233: iload 14
      //   235: istore 5
      //   237: iload_2
      //   238: istore 12
      //   240: aload 26
      //   242: monitorexit
      //   243: aload 24
      //   245: ifnull +905 -> 1150
      //   248: aload 24
      //   250: invokeinterface 187 1 0
      //   255: aconst_null
      //   256: astore 24
      //   258: iload 4
      //   260: istore_2
      //   261: iload 5
      //   263: istore 4
      //   265: iload 7
      //   267: istore 5
      //   269: iload_3
      //   270: istore 7
      //   272: iload 8
      //   274: istore_3
      //   275: goto -211 -> 64
      //   278: aload_0
      //   279: getfield 107	com/tencent/mapsdk/internal/ss$i:b	Z
      //   282: aload_0
      //   283: getfield 189	com/tencent/mapsdk/internal/ss$i:r	Z
      //   286: if_icmpeq +1799 -> 2085
      //   289: aload_0
      //   290: getfield 189	com/tencent/mapsdk/internal/ss$i:r	Z
      //   293: istore 19
      //   295: aload_0
      //   296: aload_0
      //   297: getfield 189	com/tencent/mapsdk/internal/ss$i:r	Z
      //   300: putfield 107	com/tencent/mapsdk/internal/ss$i:b	Z
      //   303: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   306: invokevirtual 97	java/lang/Object:notifyAll	()V
      //   309: aload_0
      //   310: getfield 191	com/tencent/mapsdk/internal/ss$i:h	Z
      //   313: ifeq +1765 -> 2078
      //   316: aload_0
      //   317: invokespecial 173	com/tencent/mapsdk/internal/ss$i:g	()V
      //   320: aload_0
      //   321: invokespecial 175	com/tencent/mapsdk/internal/ss$i:h	()V
      //   324: aload_0
      //   325: iconst_0
      //   326: putfield 191	com/tencent/mapsdk/internal/ss$i:h	Z
      //   329: iconst_1
      //   330: istore 8
      //   332: iload 12
      //   334: istore 11
      //   336: iload 12
      //   338: ifeq +14 -> 352
      //   341: aload_0
      //   342: invokespecial 173	com/tencent/mapsdk/internal/ss$i:g	()V
      //   345: aload_0
      //   346: invokespecial 175	com/tencent/mapsdk/internal/ss$i:h	()V
      //   349: iconst_0
      //   350: istore 11
      //   352: iload 19
      //   354: ifeq +14 -> 368
      //   357: aload_0
      //   358: getfield 111	com/tencent/mapsdk/internal/ss$i:f	Z
      //   361: ifeq +7 -> 368
      //   364: aload_0
      //   365: invokespecial 173	com/tencent/mapsdk/internal/ss$i:g	()V
      //   368: iload 19
      //   370: ifeq +54 -> 424
      //   373: aload_0
      //   374: getfield 109	com/tencent/mapsdk/internal/ss$i:e	Z
      //   377: ifeq +47 -> 424
      //   380: aload_0
      //   381: getfield 68	com/tencent/mapsdk/internal/ss$i:v	Ljava/lang/ref/WeakReference;
      //   384: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   387: checkcast 6	com/tencent/mapsdk/internal/ss
      //   390: astore 27
      //   392: aload 27
      //   394: ifnull +1703 -> 2097
      //   397: aload 27
      //   399: invokestatic 194	com/tencent/mapsdk/internal/ss:h	(Lcom/tencent/mapsdk/internal/ss;)Z
      //   402: ifeq +1695 -> 2097
      //   405: iconst_1
      //   406: istore_2
      //   407: iload_2
      //   408: ifeq +12 -> 420
      //   411: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   414: invokevirtual 195	com/tencent/mapsdk/internal/ss$j:a	()Z
      //   417: ifeq +7 -> 424
      //   420: aload_0
      //   421: invokespecial 175	com/tencent/mapsdk/internal/ss$i:h	()V
      //   424: iload 19
      //   426: ifeq +19 -> 445
      //   429: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   432: invokevirtual 197	com/tencent/mapsdk/internal/ss$j:b	()Z
      //   435: ifeq +10 -> 445
      //   438: aload_0
      //   439: getfield 136	com/tencent/mapsdk/internal/ss$i:u	Lcom/tencent/mapsdk/internal/ss$h;
      //   442: invokevirtual 143	com/tencent/mapsdk/internal/ss$h:b	()V
      //   445: aload_0
      //   446: getfield 199	com/tencent/mapsdk/internal/ss$i:c	Z
      //   449: ifne +37 -> 486
      //   452: aload_0
      //   453: getfield 201	com/tencent/mapsdk/internal/ss$i:d	Z
      //   456: ifne +30 -> 486
      //   459: aload_0
      //   460: getfield 111	com/tencent/mapsdk/internal/ss$i:f	Z
      //   463: ifeq +7 -> 470
      //   466: aload_0
      //   467: invokespecial 173	com/tencent/mapsdk/internal/ss$i:g	()V
      //   470: aload_0
      //   471: iconst_1
      //   472: putfield 201	com/tencent/mapsdk/internal/ss$i:d	Z
      //   475: aload_0
      //   476: iconst_0
      //   477: putfield 203	com/tencent/mapsdk/internal/ss$i:s	Z
      //   480: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   483: invokevirtual 97	java/lang/Object:notifyAll	()V
      //   486: aload_0
      //   487: getfield 199	com/tencent/mapsdk/internal/ss$i:c	Z
      //   490: ifeq +21 -> 511
      //   493: aload_0
      //   494: getfield 201	com/tencent/mapsdk/internal/ss$i:d	Z
      //   497: ifeq +14 -> 511
      //   500: aload_0
      //   501: iconst_0
      //   502: putfield 201	com/tencent/mapsdk/internal/ss$i:d	Z
      //   505: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   508: invokevirtual 97	java/lang/Object:notifyAll	()V
      //   511: iload 14
      //   513: istore 13
      //   515: iload 9
      //   517: istore 12
      //   519: iload 14
      //   521: ifeq +20 -> 541
      //   524: iconst_0
      //   525: istore 12
      //   527: iconst_0
      //   528: istore 13
      //   530: aload_0
      //   531: iconst_1
      //   532: putfield 103	com/tencent/mapsdk/internal/ss$i:m	Z
      //   535: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   538: invokevirtual 97	java/lang/Object:notifyAll	()V
      //   541: iload 4
      //   543: istore 18
      //   545: iload 8
      //   547: istore 14
      //   549: iload 5
      //   551: istore 17
      //   553: iload_3
      //   554: istore 15
      //   556: iload 6
      //   558: istore 16
      //   560: aload_0
      //   561: invokevirtual 114	com/tencent/mapsdk/internal/ss$i:a	()Z
      //   564: ifeq +546 -> 1110
      //   567: iload 8
      //   569: istore 7
      //   571: iload 6
      //   573: istore_2
      //   574: aload_0
      //   575: getfield 109	com/tencent/mapsdk/internal/ss$i:e	Z
      //   578: ifne +14 -> 592
      //   581: iload 8
      //   583: ifeq +157 -> 740
      //   586: iconst_0
      //   587: istore 7
      //   589: iload 6
      //   591: istore_2
      //   592: iload 4
      //   594: istore 9
      //   596: iload 5
      //   598: istore 8
      //   600: iload_3
      //   601: istore 6
      //   603: aload_0
      //   604: getfield 109	com/tencent/mapsdk/internal/ss$i:e	Z
      //   607: ifeq +35 -> 642
      //   610: iload 4
      //   612: istore 9
      //   614: iload 5
      //   616: istore 8
      //   618: iload_3
      //   619: istore 6
      //   621: aload_0
      //   622: getfield 111	com/tencent/mapsdk/internal/ss$i:f	Z
      //   625: ifne +17 -> 642
      //   628: aload_0
      //   629: iconst_1
      //   630: putfield 111	com/tencent/mapsdk/internal/ss$i:f	Z
      //   633: iconst_1
      //   634: istore 9
      //   636: iconst_1
      //   637: istore 6
      //   639: iconst_1
      //   640: istore 8
      //   642: iload 9
      //   644: istore 18
      //   646: iload 7
      //   648: istore 14
      //   650: iload 8
      //   652: istore 17
      //   654: iload 6
      //   656: istore 15
      //   658: iload_2
      //   659: istore 16
      //   661: aload_0
      //   662: getfield 111	com/tencent/mapsdk/internal/ss$i:f	Z
      //   665: ifeq +445 -> 1110
      //   668: aload_0
      //   669: getfield 55	com/tencent/mapsdk/internal/ss$i:o	Z
      //   672: ifeq +1390 -> 2062
      //   675: iconst_1
      //   676: istore 8
      //   678: aload_0
      //   679: getfield 60	com/tencent/mapsdk/internal/ss$i:i	I
      //   682: istore_1
      //   683: aload_0
      //   684: getfield 62	com/tencent/mapsdk/internal/ss$i:j	I
      //   687: istore_3
      //   688: iconst_1
      //   689: istore 9
      //   691: iconst_1
      //   692: istore 4
      //   694: aload_0
      //   695: iconst_0
      //   696: putfield 55	com/tencent/mapsdk/internal/ss$i:o	Z
      //   699: aload_0
      //   700: iconst_0
      //   701: putfield 64	com/tencent/mapsdk/internal/ss$i:l	Z
      //   704: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   707: invokevirtual 97	java/lang/Object:notifyAll	()V
      //   710: iload_1
      //   711: istore 10
      //   713: iload_3
      //   714: istore_1
      //   715: iload 7
      //   717: istore 12
      //   719: iload 13
      //   721: istore 5
      //   723: iload 8
      //   725: istore 7
      //   727: iload 11
      //   729: istore_3
      //   730: iload 6
      //   732: istore 8
      //   734: iload_2
      //   735: istore 6
      //   737: goto -497 -> 240
      //   740: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   743: aload_0
      //   744: invokevirtual 205	com/tencent/mapsdk/internal/ss$j:b	(Lcom/tencent/mapsdk/internal/ss$i;)Z
      //   747: istore 19
      //   749: iload 8
      //   751: istore 7
      //   753: iload 6
      //   755: istore_2
      //   756: iload 19
      //   758: ifeq -166 -> 592
      //   761: aload_0
      //   762: getfield 136	com/tencent/mapsdk/internal/ss$i:u	Lcom/tencent/mapsdk/internal/ss$h;
      //   765: astore 27
      //   767: aload 27
      //   769: invokestatic 211	javax/microedition/khronos/egl/EGLContext:getEGL	()Ljavax/microedition/khronos/egl/EGL;
      //   772: checkcast 213	javax/microedition/khronos/egl/EGL10
      //   775: putfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   778: aload 27
      //   780: aload 27
      //   782: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   785: getstatic 220	javax/microedition/khronos/egl/EGL10:EGL_DEFAULT_DISPLAY	Ljava/lang/Object;
      //   788: invokeinterface 224 2 0
      //   793: putfield 227	com/tencent/mapsdk/internal/ss$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   796: aload 27
      //   798: getfield 227	com/tencent/mapsdk/internal/ss$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   801: getstatic 230	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   804: if_acmpne +122 -> 926
      //   807: new 152	java/lang/RuntimeException
      //   810: dup
      //   811: ldc 232
      //   813: invokespecial 233	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   816: astore 27
      //   818: ldc_w 386
      //   821: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   824: aload 27
      //   826: athrow
      //   827: astore 27
      //   829: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   832: aload_0
      //   833: invokevirtual 148	com/tencent/mapsdk/internal/ss$j:c	(Lcom/tencent/mapsdk/internal/ss$i;)V
      //   836: aload_0
      //   837: iconst_1
      //   838: putfield 109	com/tencent/mapsdk/internal/ss$i:e	Z
      //   841: iconst_1
      //   842: istore_2
      //   843: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   846: invokevirtual 97	java/lang/Object:notifyAll	()V
      //   849: iload 8
      //   851: istore 7
      //   853: goto -261 -> 592
      //   856: astore 24
      //   858: aload 26
      //   860: monitorexit
      //   861: ldc_w 386
      //   864: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   867: aload 24
      //   869: athrow
      //   870: astore 24
      //   872: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   875: astore 24
      //   877: aload 24
      //   879: monitorenter
      //   880: aload_0
      //   881: invokespecial 173	com/tencent/mapsdk/internal/ss$i:g	()V
      //   884: aload_0
      //   885: invokespecial 175	com/tencent/mapsdk/internal/ss$i:h	()V
      //   888: aload 24
      //   890: monitorexit
      //   891: goto -744 -> 147
      //   894: astore 25
      //   896: aload 24
      //   898: monitorexit
      //   899: ldc_w 386
      //   902: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   905: aload 25
      //   907: athrow
      //   908: astore 24
      //   910: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   913: aload_0
      //   914: invokevirtual 388	com/tencent/mapsdk/internal/ss$j:a	(Lcom/tencent/mapsdk/internal/ss$i;)V
      //   917: ldc_w 386
      //   920: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   923: aload 24
      //   925: athrow
      //   926: iconst_2
      //   927: newarray int
      //   929: astore 28
      //   931: aload 27
      //   933: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   936: aload 27
      //   938: getfield 227	com/tencent/mapsdk/internal/ss$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   941: aload 28
      //   943: invokeinterface 237 3 0
      //   948: ifne +23 -> 971
      //   951: new 152	java/lang/RuntimeException
      //   954: dup
      //   955: ldc 239
      //   957: invokespecial 233	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   960: astore 27
      //   962: ldc_w 386
      //   965: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   968: aload 27
      //   970: athrow
      //   971: aload 27
      //   973: getfield 241	com/tencent/mapsdk/internal/ss$h:a	Ljava/lang/ref/WeakReference;
      //   976: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   979: checkcast 6	com/tencent/mapsdk/internal/ss
      //   982: astore 28
      //   984: aload 28
      //   986: ifnonnull +66 -> 1052
      //   989: aload 27
      //   991: aconst_null
      //   992: putfield 244	com/tencent/mapsdk/internal/ss$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
      //   995: aload 27
      //   997: aconst_null
      //   998: putfield 247	com/tencent/mapsdk/internal/ss$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   1001: aload 27
      //   1003: getfield 247	com/tencent/mapsdk/internal/ss$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   1006: ifnull +14 -> 1020
      //   1009: aload 27
      //   1011: getfield 247	com/tencent/mapsdk/internal/ss$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   1014: getstatic 250	javax/microedition/khronos/egl/EGL10:EGL_NO_CONTEXT	Ljavax/microedition/khronos/egl/EGLContext;
      //   1017: if_acmpne +26 -> 1043
      //   1020: aload 27
      //   1022: aconst_null
      //   1023: putfield 247	com/tencent/mapsdk/internal/ss$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   1026: aload 27
      //   1028: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1031: invokeinterface 254 1 0
      //   1036: pop
      //   1037: ldc_w 256
      //   1040: invokestatic 258	com/tencent/mapsdk/internal/ss$h:a	(Ljava/lang/String;)V
      //   1043: aload 27
      //   1045: aconst_null
      //   1046: putfield 261	com/tencent/mapsdk/internal/ss$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1049: goto -213 -> 836
      //   1052: aload 27
      //   1054: aload 28
      //   1056: invokestatic 264	com/tencent/mapsdk/internal/ss:b	(Lcom/tencent/mapsdk/internal/ss;)Lcom/tencent/mapsdk/internal/ss$e;
      //   1059: aload 27
      //   1061: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1064: aload 27
      //   1066: getfield 227	com/tencent/mapsdk/internal/ss$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1069: invokeinterface 269 3 0
      //   1074: putfield 244	com/tencent/mapsdk/internal/ss$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1077: aload 27
      //   1079: aload 28
      //   1081: invokestatic 272	com/tencent/mapsdk/internal/ss:c	(Lcom/tencent/mapsdk/internal/ss;)Lcom/tencent/mapsdk/internal/ss$f;
      //   1084: aload 27
      //   1086: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1089: aload 27
      //   1091: getfield 227	com/tencent/mapsdk/internal/ss$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1094: aload 27
      //   1096: getfield 244	com/tencent/mapsdk/internal/ss$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1099: invokeinterface 277 4 0
      //   1104: putfield 247	com/tencent/mapsdk/internal/ss$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   1107: goto -106 -> 1001
      //   1110: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   1113: invokevirtual 117	java/lang/Object:wait	()V
      //   1116: iload 14
      //   1118: istore 7
      //   1120: iload 18
      //   1122: istore 4
      //   1124: iload 13
      //   1126: istore 14
      //   1128: iload 12
      //   1130: istore 9
      //   1132: iload 17
      //   1134: istore 5
      //   1136: iload 11
      //   1138: istore 12
      //   1140: iload 15
      //   1142: istore_3
      //   1143: iload 16
      //   1145: istore 6
      //   1147: goto -1056 -> 91
      //   1150: iload 4
      //   1152: ifeq +904 -> 2056
      //   1155: aload_0
      //   1156: getfield 136	com/tencent/mapsdk/internal/ss$i:u	Lcom/tencent/mapsdk/internal/ss$h;
      //   1159: astore 26
      //   1161: aload 26
      //   1163: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1166: ifnonnull +54 -> 1220
      //   1169: new 152	java/lang/RuntimeException
      //   1172: dup
      //   1173: ldc_w 279
      //   1176: invokespecial 233	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1179: astore 24
      //   1181: ldc_w 386
      //   1184: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1187: aload 24
      //   1189: athrow
      //   1190: astore 25
      //   1192: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   1195: astore 24
      //   1197: aload 24
      //   1199: monitorenter
      //   1200: aload_0
      //   1201: invokespecial 173	com/tencent/mapsdk/internal/ss$i:g	()V
      //   1204: aload_0
      //   1205: invokespecial 175	com/tencent/mapsdk/internal/ss$i:h	()V
      //   1208: aload 24
      //   1210: monitorexit
      //   1211: ldc_w 386
      //   1214: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1217: aload 25
      //   1219: athrow
      //   1220: aload 26
      //   1222: getfield 227	com/tencent/mapsdk/internal/ss$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1225: ifnonnull +24 -> 1249
      //   1228: new 152	java/lang/RuntimeException
      //   1231: dup
      //   1232: ldc_w 281
      //   1235: invokespecial 233	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1238: astore 24
      //   1240: ldc_w 386
      //   1243: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1246: aload 24
      //   1248: athrow
      //   1249: aload 26
      //   1251: getfield 244	com/tencent/mapsdk/internal/ss$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1254: ifnonnull +24 -> 1278
      //   1257: new 152	java/lang/RuntimeException
      //   1260: dup
      //   1261: ldc_w 283
      //   1264: invokespecial 233	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1267: astore 24
      //   1269: ldc_w 386
      //   1272: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1275: aload 24
      //   1277: athrow
      //   1278: aload 26
      //   1280: invokevirtual 140	com/tencent/mapsdk/internal/ss$h:a	()V
      //   1283: aload 26
      //   1285: getfield 241	com/tencent/mapsdk/internal/ss$h:a	Ljava/lang/ref/WeakReference;
      //   1288: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1291: checkcast 6	com/tencent/mapsdk/internal/ss
      //   1294: astore 27
      //   1296: aload 27
      //   1298: ifnull +543 -> 1841
      //   1301: aload 26
      //   1303: aload 27
      //   1305: invokestatic 286	com/tencent/mapsdk/internal/ss:d	(Lcom/tencent/mapsdk/internal/ss;)Lcom/tencent/mapsdk/internal/ss$g;
      //   1308: aload 26
      //   1310: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1313: aload 26
      //   1315: getfield 227	com/tencent/mapsdk/internal/ss$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1318: aload 26
      //   1320: getfield 244	com/tencent/mapsdk/internal/ss$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1323: aload 27
      //   1325: invokevirtual 290	com/tencent/mapsdk/internal/ss:getHolder	()Landroid/view/SurfaceHolder;
      //   1328: invokeinterface 295 5 0
      //   1333: putfield 261	com/tencent/mapsdk/internal/ss$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1336: aload 26
      //   1338: getfield 261	com/tencent/mapsdk/internal/ss$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1341: ifnull +14 -> 1355
      //   1344: aload 26
      //   1346: getfield 261	com/tencent/mapsdk/internal/ss$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1349: getstatic 298	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1352: if_acmpne +498 -> 1850
      //   1355: aload 26
      //   1357: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1360: invokeinterface 254 1 0
      //   1365: pop
      //   1366: iconst_0
      //   1367: istore_2
      //   1368: iload_2
      //   1369: ifeq +553 -> 1922
      //   1372: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   1375: astore 26
      //   1377: aload 26
      //   1379: monitorenter
      //   1380: aload_0
      //   1381: iconst_1
      //   1382: putfield 300	com/tencent/mapsdk/internal/ss$i:g	Z
      //   1385: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   1388: invokevirtual 97	java/lang/Object:notifyAll	()V
      //   1391: aload 26
      //   1393: monitorexit
      //   1394: iconst_0
      //   1395: istore_2
      //   1396: iload 8
      //   1398: istore 11
      //   1400: iload 8
      //   1402: ifeq +139 -> 1541
      //   1405: aload_0
      //   1406: getfield 136	com/tencent/mapsdk/internal/ss$i:u	Lcom/tencent/mapsdk/internal/ss$h;
      //   1409: astore 26
      //   1411: aload 26
      //   1413: getfield 247	com/tencent/mapsdk/internal/ss$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   1416: invokevirtual 304	javax/microedition/khronos/egl/EGLContext:getGL	()Ljavax/microedition/khronos/opengles/GL;
      //   1419: astore 25
      //   1421: aload 26
      //   1423: getfield 241	com/tencent/mapsdk/internal/ss$h:a	Ljava/lang/ref/WeakReference;
      //   1426: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1429: checkcast 6	com/tencent/mapsdk/internal/ss
      //   1432: astore 27
      //   1434: aload 25
      //   1436: astore 26
      //   1438: aload 27
      //   1440: ifnull +609 -> 2049
      //   1443: aload 27
      //   1445: invokestatic 307	com/tencent/mapsdk/internal/ss:e	(Lcom/tencent/mapsdk/internal/ss;)Lcom/tencent/mapsdk/internal/ss$k;
      //   1448: ifnull +15 -> 1463
      //   1451: aload 27
      //   1453: invokestatic 307	com/tencent/mapsdk/internal/ss:e	(Lcom/tencent/mapsdk/internal/ss;)Lcom/tencent/mapsdk/internal/ss$k;
      //   1456: invokeinterface 311 1 0
      //   1461: astore 25
      //   1463: aload 25
      //   1465: astore 26
      //   1467: aload 27
      //   1469: invokestatic 314	com/tencent/mapsdk/internal/ss:f	(Lcom/tencent/mapsdk/internal/ss;)I
      //   1472: iconst_3
      //   1473: iand
      //   1474: ifeq +575 -> 2049
      //   1477: iconst_0
      //   1478: istore 4
      //   1480: aload 27
      //   1482: invokestatic 314	com/tencent/mapsdk/internal/ss:f	(Lcom/tencent/mapsdk/internal/ss;)I
      //   1485: iconst_1
      //   1486: iand
      //   1487: ifeq +6 -> 1493
      //   1490: iconst_1
      //   1491: istore 4
      //   1493: aload 27
      //   1495: invokestatic 314	com/tencent/mapsdk/internal/ss:f	(Lcom/tencent/mapsdk/internal/ss;)I
      //   1498: iconst_2
      //   1499: iand
      //   1500: ifeq +543 -> 2043
      //   1503: new 316	com/tencent/mapsdk/internal/ss$l
      //   1506: dup
      //   1507: invokespecial 317	com/tencent/mapsdk/internal/ss$l:<init>	()V
      //   1510: astore 26
      //   1512: aload 25
      //   1514: iload 4
      //   1516: aload 26
      //   1518: invokestatic 323	android/opengl/GLDebugHelper:wrap	(Ljavax/microedition/khronos/opengles/GL;ILjava/io/Writer;)Ljavax/microedition/khronos/opengles/GL;
      //   1521: astore 25
      //   1523: aload 25
      //   1525: checkcast 325	javax/microedition/khronos/opengles/GL10
      //   1528: astore 25
      //   1530: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   1533: aload 25
      //   1535: invokevirtual 328	com/tencent/mapsdk/internal/ss$j:a	(Ljavax/microedition/khronos/opengles/GL10;)V
      //   1538: iconst_0
      //   1539: istore 11
      //   1541: iload 6
      //   1543: istore 8
      //   1545: iload 6
      //   1547: ifeq +42 -> 1589
      //   1550: aload_0
      //   1551: getfield 68	com/tencent/mapsdk/internal/ss$i:v	Ljava/lang/ref/WeakReference;
      //   1554: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1557: checkcast 6	com/tencent/mapsdk/internal/ss
      //   1560: astore 26
      //   1562: aload 26
      //   1564: ifnull +538 -> 2102
      //   1567: aload 26
      //   1569: invokestatic 166	com/tencent/mapsdk/internal/ss:g	(Lcom/tencent/mapsdk/internal/ss;)Lcom/tencent/mapsdk/internal/ss$m;
      //   1572: aload 25
      //   1574: aload_0
      //   1575: getfield 136	com/tencent/mapsdk/internal/ss$i:u	Lcom/tencent/mapsdk/internal/ss$h;
      //   1578: getfield 244	com/tencent/mapsdk/internal/ss$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1581: invokeinterface 331 3 0
      //   1586: goto +516 -> 2102
      //   1589: iload 7
      //   1591: istore 6
      //   1593: iload 7
      //   1595: ifeq +38 -> 1633
      //   1598: aload_0
      //   1599: getfield 68	com/tencent/mapsdk/internal/ss$i:v	Ljava/lang/ref/WeakReference;
      //   1602: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1605: checkcast 6	com/tencent/mapsdk/internal/ss
      //   1608: astore 26
      //   1610: aload 26
      //   1612: ifnull +496 -> 2108
      //   1615: aload 26
      //   1617: invokestatic 166	com/tencent/mapsdk/internal/ss:g	(Lcom/tencent/mapsdk/internal/ss;)Lcom/tencent/mapsdk/internal/ss$m;
      //   1620: aload 25
      //   1622: iload 10
      //   1624: iload_1
      //   1625: invokeinterface 334 4 0
      //   1630: goto +478 -> 2108
      //   1633: aload_0
      //   1634: getfield 336	com/tencent/mapsdk/internal/ss$i:p	J
      //   1637: lconst_0
      //   1638: lcmp
      //   1639: ifeq +7 -> 1646
      //   1642: invokestatic 342	java/lang/System:currentTimeMillis	()J
      //   1645: pop2
      //   1646: aload_0
      //   1647: invokestatic 342	java/lang/System:currentTimeMillis	()J
      //   1650: putfield 336	com/tencent/mapsdk/internal/ss$i:p	J
      //   1653: invokestatic 342	java/lang/System:currentTimeMillis	()J
      //   1656: lstore 20
      //   1658: aload_0
      //   1659: getfield 68	com/tencent/mapsdk/internal/ss$i:v	Ljava/lang/ref/WeakReference;
      //   1662: invokevirtual 163	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1665: checkcast 6	com/tencent/mapsdk/internal/ss
      //   1668: astore 26
      //   1670: aload 26
      //   1672: ifnull +419 -> 2091
      //   1675: aload 26
      //   1677: invokestatic 166	com/tencent/mapsdk/internal/ss:g	(Lcom/tencent/mapsdk/internal/ss;)Lcom/tencent/mapsdk/internal/ss$m;
      //   1680: aload 25
      //   1682: invokeinterface 345 2 0
      //   1687: istore 19
      //   1689: invokestatic 342	java/lang/System:currentTimeMillis	()J
      //   1692: lstore 22
      //   1694: iload_3
      //   1695: istore 7
      //   1697: iload 19
      //   1699: ifeq +81 -> 1780
      //   1702: aload_0
      //   1703: getfield 136	com/tencent/mapsdk/internal/ss$i:u	Lcom/tencent/mapsdk/internal/ss$h;
      //   1706: astore 26
      //   1708: aload 26
      //   1710: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1713: aload 26
      //   1715: getfield 227	com/tencent/mapsdk/internal/ss$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1718: aload 26
      //   1720: getfield 261	com/tencent/mapsdk/internal/ss$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1723: invokeinterface 349 3 0
      //   1728: ifne +424 -> 2152
      //   1731: aload 26
      //   1733: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1736: invokeinterface 254 1 0
      //   1741: istore 4
      //   1743: goto +371 -> 2114
      //   1746: ldc_w 351
      //   1749: ldc_w 352
      //   1752: invokestatic 355	com/tencent/mapsdk/internal/ss$h:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   1755: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   1758: astore 26
      //   1760: aload 26
      //   1762: monitorenter
      //   1763: aload_0
      //   1764: iconst_1
      //   1765: putfield 203	com/tencent/mapsdk/internal/ss$i:s	Z
      //   1768: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   1771: invokevirtual 97	java/lang/Object:notifyAll	()V
      //   1774: aload 26
      //   1776: monitorexit
      //   1777: iload_3
      //   1778: istore 7
      //   1780: iload 5
      //   1782: istore 4
      //   1784: iload 9
      //   1786: ifeq +6 -> 1792
      //   1789: iconst_1
      //   1790: istore 4
      //   1792: ldc_w 356
      //   1795: aload_0
      //   1796: getfield 58	com/tencent/mapsdk/internal/ss$i:t	F
      //   1799: fdiv
      //   1800: lload 22
      //   1802: lload 20
      //   1804: lsub
      //   1805: l2f
      //   1806: fsub
      //   1807: f2i
      //   1808: istore_3
      //   1809: iload_3
      //   1810: ifle +200 -> 2010
      //   1813: aload_0
      //   1814: monitorenter
      //   1815: iload_3
      //   1816: i2l
      //   1817: lstore 20
      //   1819: aload_0
      //   1820: lload 20
      //   1822: invokevirtual 359	java/lang/Object:wait	(J)V
      //   1825: aload_0
      //   1826: monitorexit
      //   1827: iload 6
      //   1829: istore 5
      //   1831: iload 11
      //   1833: istore_3
      //   1834: iload 8
      //   1836: istore 6
      //   1838: goto -1774 -> 64
      //   1841: aload 26
      //   1843: aconst_null
      //   1844: putfield 261	com/tencent/mapsdk/internal/ss$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1847: goto -511 -> 1336
      //   1850: aload 26
      //   1852: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1855: aload 26
      //   1857: getfield 227	com/tencent/mapsdk/internal/ss$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1860: aload 26
      //   1862: getfield 261	com/tencent/mapsdk/internal/ss$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1865: aload 26
      //   1867: getfield 261	com/tencent/mapsdk/internal/ss$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1870: aload 26
      //   1872: getfield 247	com/tencent/mapsdk/internal/ss$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   1875: invokeinterface 363 5 0
      //   1880: ifne +267 -> 2147
      //   1883: aload 26
      //   1885: getfield 216	com/tencent/mapsdk/internal/ss$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1888: invokeinterface 254 1 0
      //   1893: pop
      //   1894: ldc_w 365
      //   1897: ldc_w 366
      //   1900: invokestatic 355	com/tencent/mapsdk/internal/ss$h:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   1903: iconst_0
      //   1904: istore_2
      //   1905: goto -537 -> 1368
      //   1908: astore 24
      //   1910: aload 26
      //   1912: monitorexit
      //   1913: ldc_w 386
      //   1916: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1919: aload 24
      //   1921: athrow
      //   1922: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   1925: astore 26
      //   1927: aload 26
      //   1929: monitorenter
      //   1930: aload_0
      //   1931: iconst_1
      //   1932: putfield 300	com/tencent/mapsdk/internal/ss$i:g	Z
      //   1935: aload_0
      //   1936: iconst_1
      //   1937: putfield 203	com/tencent/mapsdk/internal/ss$i:s	Z
      //   1940: invokestatic 92	com/tencent/mapsdk/internal/ss:g	()Lcom/tencent/mapsdk/internal/ss$j;
      //   1943: invokevirtual 97	java/lang/Object:notifyAll	()V
      //   1946: aload 26
      //   1948: monitorexit
      //   1949: iload 4
      //   1951: istore_2
      //   1952: iload 5
      //   1954: istore 4
      //   1956: iload 7
      //   1958: istore 5
      //   1960: iload_3
      //   1961: istore 7
      //   1963: iload 8
      //   1965: istore_3
      //   1966: goto -1902 -> 64
      //   1969: astore 24
      //   1971: aload 26
      //   1973: monitorexit
      //   1974: ldc_w 386
      //   1977: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1980: aload 24
      //   1982: athrow
      //   1983: astore 24
      //   1985: aload 26
      //   1987: monitorexit
      //   1988: ldc_w 386
      //   1991: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1994: aload 24
      //   1996: athrow
      //   1997: astore 24
      //   1999: aload_0
      //   2000: monitorexit
      //   2001: ldc_w 386
      //   2004: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2007: aload 24
      //   2009: athrow
      //   2010: iload 6
      //   2012: istore 5
      //   2014: iload 11
      //   2016: istore_3
      //   2017: iload 8
      //   2019: istore 6
      //   2021: goto -1957 -> 64
      //   2024: astore 25
      //   2026: aload 24
      //   2028: monitorexit
      //   2029: ldc_w 386
      //   2032: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2035: aload 25
      //   2037: athrow
      //   2038: astore 26
      //   2040: goto -215 -> 1825
      //   2043: aconst_null
      //   2044: astore 26
      //   2046: goto -534 -> 1512
      //   2049: aload 26
      //   2051: astore 25
      //   2053: goto -530 -> 1523
      //   2056: iload 4
      //   2058: istore_2
      //   2059: goto -663 -> 1396
      //   2062: iload_1
      //   2063: istore_3
      //   2064: iload 10
      //   2066: istore_1
      //   2067: iload 9
      //   2069: istore 4
      //   2071: iload 12
      //   2073: istore 9
      //   2075: goto -1376 -> 699
      //   2078: iload 7
      //   2080: istore 8
      //   2082: goto -1750 -> 332
      //   2085: iconst_0
      //   2086: istore 19
      //   2088: goto -1779 -> 309
      //   2091: iconst_0
      //   2092: istore 19
      //   2094: goto -405 -> 1689
      //   2097: iconst_0
      //   2098: istore_2
      //   2099: goto -1692 -> 407
      //   2102: iconst_0
      //   2103: istore 8
      //   2105: goto -516 -> 1589
      //   2108: iconst_0
      //   2109: istore 6
      //   2111: goto -478 -> 1633
      //   2114: iload_3
      //   2115: istore 7
      //   2117: iload 4
      //   2119: lookupswitch	default:+25->2144, 12288:+-339->1780, 12302:+41->2160
      //   2145: impdep1
      //   2146: frem
      //   2147: iconst_1
      //   2148: istore_2
      //   2149: goto -781 -> 1368
      //   2152: sipush 12288
      //   2155: istore 4
      //   2157: goto -43 -> 2114
      //   2160: iconst_1
      //   2161: istore 7
      //   2163: goto -383 -> 1780
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2166	0	this	i
      //   60	2007	1	i1	int
      //   35	2114	2	i2	int
      //   37	2078	3	i3	int
      //   48	2108	4	i4	int
      //   42	1971	5	i5	int
      //   32	2078	6	i6	int
      //   39	2123	7	i7	int
      //   74	2030	8	i8	int
      //   45	2029	9	i9	int
      //   54	2011	10	i10	int
      //   334	1681	11	i11	int
      //   51	2021	12	i12	int
      //   513	612	13	i13	int
      //   82	1045	14	i14	int
      //   554	587	15	i15	int
      //   558	586	16	i16	int
      //   551	582	17	i17	int
      //   543	578	18	i18	int
      //   293	1800	19	bool	boolean
      //   1656	165	20	l1	long
      //   1692	109	22	l2	long
      //   57	107	24	localObject1	Object
      //   175	1	24	localInterruptedException1	InterruptedException
      //   218	39	24	localRunnable	Runnable
      //   856	12	24	localObject2	Object
      //   870	1	24	localException	java.lang.Exception
      //   875	22	24	localj	ss.j
      //   908	16	24	localObject3	Object
      //   1179	97	24	localObject4	Object
      //   1908	12	24	localObject5	Object
      //   1969	12	24	localObject6	Object
      //   1983	12	24	localObject7	Object
      //   1997	30	24	localObject8	Object
      //   62	1	25	localObject9	Object
      //   161	12	25	localObject10	Object
      //   894	12	25	localObject11	Object
      //   1190	28	25	localObject12	Object
      //   1419	262	25	localObject13	Object
      //   2024	12	25	localObject14	Object
      //   2051	1	25	localObject15	Object
      //   2038	1	26	localInterruptedException2	InterruptedException
      //   2044	6	26	localObject17	Object
      //   390	435	27	localObject18	Object
      //   827	110	27	localRuntimeException	RuntimeException
      //   960	534	27	localObject19	Object
      //   929	151	28	localObject20	Object
      // Exception table:
      //   from	to	target	type
      //   136	147	161	finally
      //   6	31	175	java/lang/InterruptedException
      //   128	136	175	java/lang/InterruptedException
      //   163	175	175	java/lang/InterruptedException
      //   872	880	175	java/lang/InterruptedException
      //   896	908	175	java/lang/InterruptedException
      //   1192	1200	175	java/lang/InterruptedException
      //   1211	1220	175	java/lang/InterruptedException
      //   2026	2038	175	java/lang/InterruptedException
      //   761	827	827	java/lang/RuntimeException
      //   926	971	827	java/lang/RuntimeException
      //   971	984	827	java/lang/RuntimeException
      //   989	1001	827	java/lang/RuntimeException
      //   1001	1020	827	java/lang/RuntimeException
      //   1020	1043	827	java/lang/RuntimeException
      //   1043	1049	827	java/lang/RuntimeException
      //   1052	1107	827	java/lang/RuntimeException
      //   91	110	856	finally
      //   115	125	856	finally
      //   125	128	856	finally
      //   197	220	856	finally
      //   240	243	856	finally
      //   278	309	856	finally
      //   309	329	856	finally
      //   341	349	856	finally
      //   357	368	856	finally
      //   373	392	856	finally
      //   397	405	856	finally
      //   411	420	856	finally
      //   420	424	856	finally
      //   429	445	856	finally
      //   445	470	856	finally
      //   470	486	856	finally
      //   486	511	856	finally
      //   530	541	856	finally
      //   560	567	856	finally
      //   574	581	856	finally
      //   603	610	856	finally
      //   621	633	856	finally
      //   661	675	856	finally
      //   678	688	856	finally
      //   694	699	856	finally
      //   699	710	856	finally
      //   740	749	856	finally
      //   761	827	856	finally
      //   829	836	856	finally
      //   836	841	856	finally
      //   843	849	856	finally
      //   926	971	856	finally
      //   971	984	856	finally
      //   989	1001	856	finally
      //   1001	1020	856	finally
      //   1020	1043	856	finally
      //   1043	1049	856	finally
      //   1052	1107	856	finally
      //   1110	1116	856	finally
      //   64	72	870	java/lang/Exception
      //   248	255	870	java/lang/Exception
      //   858	870	870	java/lang/Exception
      //   1155	1190	870	java/lang/Exception
      //   1220	1249	870	java/lang/Exception
      //   1249	1278	870	java/lang/Exception
      //   1278	1296	870	java/lang/Exception
      //   1301	1336	870	java/lang/Exception
      //   1336	1355	870	java/lang/Exception
      //   1355	1366	870	java/lang/Exception
      //   1372	1380	870	java/lang/Exception
      //   1405	1434	870	java/lang/Exception
      //   1443	1463	870	java/lang/Exception
      //   1467	1477	870	java/lang/Exception
      //   1480	1490	870	java/lang/Exception
      //   1493	1512	870	java/lang/Exception
      //   1512	1523	870	java/lang/Exception
      //   1523	1538	870	java/lang/Exception
      //   1550	1562	870	java/lang/Exception
      //   1567	1586	870	java/lang/Exception
      //   1598	1610	870	java/lang/Exception
      //   1615	1630	870	java/lang/Exception
      //   1633	1646	870	java/lang/Exception
      //   1646	1670	870	java/lang/Exception
      //   1675	1689	870	java/lang/Exception
      //   1689	1694	870	java/lang/Exception
      //   1702	1743	870	java/lang/Exception
      //   1746	1763	870	java/lang/Exception
      //   1792	1809	870	java/lang/Exception
      //   1813	1815	870	java/lang/Exception
      //   1841	1847	870	java/lang/Exception
      //   1850	1903	870	java/lang/Exception
      //   1910	1922	870	java/lang/Exception
      //   1922	1930	870	java/lang/Exception
      //   1971	1983	870	java/lang/Exception
      //   1985	1997	870	java/lang/Exception
      //   1999	2010	870	java/lang/Exception
      //   880	891	894	finally
      //   6	31	908	finally
      //   128	136	908	finally
      //   163	175	908	finally
      //   177	183	908	finally
      //   872	880	908	finally
      //   896	908	908	finally
      //   1192	1200	908	finally
      //   1211	1220	908	finally
      //   2026	2038	908	finally
      //   64	72	1190	finally
      //   248	255	1190	finally
      //   858	870	1190	finally
      //   1155	1190	1190	finally
      //   1220	1249	1190	finally
      //   1249	1278	1190	finally
      //   1278	1296	1190	finally
      //   1301	1336	1190	finally
      //   1336	1355	1190	finally
      //   1355	1366	1190	finally
      //   1372	1380	1190	finally
      //   1405	1434	1190	finally
      //   1443	1463	1190	finally
      //   1467	1477	1190	finally
      //   1480	1490	1190	finally
      //   1493	1512	1190	finally
      //   1512	1523	1190	finally
      //   1523	1538	1190	finally
      //   1550	1562	1190	finally
      //   1567	1586	1190	finally
      //   1598	1610	1190	finally
      //   1615	1630	1190	finally
      //   1633	1646	1190	finally
      //   1646	1670	1190	finally
      //   1675	1689	1190	finally
      //   1689	1694	1190	finally
      //   1702	1743	1190	finally
      //   1746	1763	1190	finally
      //   1792	1809	1190	finally
      //   1813	1815	1190	finally
      //   1841	1847	1190	finally
      //   1850	1903	1190	finally
      //   1910	1922	1190	finally
      //   1922	1930	1190	finally
      //   1971	1983	1190	finally
      //   1985	1997	1190	finally
      //   1999	2010	1190	finally
      //   1380	1394	1908	finally
      //   1930	1949	1969	finally
      //   1763	1777	1983	finally
      //   1819	1825	1997	finally
      //   1825	1827	1997	finally
      //   1200	1211	2024	finally
      //   1819	1825	2038	java/lang/InterruptedException
    }
  }
  
  static final class j
  {
    private static String a = "GLThreadManager";
    private static final int g = 131072;
    private static final String h = "Q3Dimension MSM7500 ";
    private boolean b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;
    private ss.i i;
    
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
    
    public final void a(ss.i parami)
    {
      try
      {
        AppMethodBeat.i(224484);
        ss.i.a(parami);
        if (this.i == parami) {
          this.i = null;
        }
        notifyAll();
        AppMethodBeat.o(224484);
        return;
      }
      finally {}
    }
    
    /* Error */
    public final void a(GL10 paramGL10)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_3
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 63
      //   6: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 65	com/tencent/mapsdk/internal/ss$j:d	Z
      //   13: ifne +65 -> 78
      //   16: aload_0
      //   17: invokespecial 67	com/tencent/mapsdk/internal/ss$j:c	()V
      //   20: aload_1
      //   21: sipush 7937
      //   24: invokeinterface 73 2 0
      //   29: astore_1
      //   30: aload_0
      //   31: getfield 39	com/tencent/mapsdk/internal/ss$j:c	I
      //   34: ldc 12
      //   36: if_icmpge +23 -> 59
      //   39: aload_1
      //   40: ldc 15
      //   42: invokevirtual 79	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   45: ifne +41 -> 86
      //   48: iconst_1
      //   49: istore_2
      //   50: aload_0
      //   51: iload_2
      //   52: putfield 41	com/tencent/mapsdk/internal/ss$j:e	Z
      //   55: aload_0
      //   56: invokevirtual 58	java/lang/Object:notifyAll	()V
      //   59: aload_0
      //   60: getfield 41	com/tencent/mapsdk/internal/ss$j:e	Z
      //   63: ifne +28 -> 91
      //   66: iload_3
      //   67: istore_2
      //   68: aload_0
      //   69: iload_2
      //   70: putfield 81	com/tencent/mapsdk/internal/ss$j:f	Z
      //   73: aload_0
      //   74: iconst_1
      //   75: putfield 65	com/tencent/mapsdk/internal/ss$j:d	Z
      //   78: ldc 63
      //   80: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   0	101	1	paramGL10	GL10
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
    
    public final boolean a()
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
    public final boolean b()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 83
      //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: invokespecial 67	com/tencent/mapsdk/internal/ss$j:c	()V
      //   11: aload_0
      //   12: getfield 41	com/tencent/mapsdk/internal/ss$j:e	Z
      //   15: ifne +14 -> 29
      //   18: iconst_1
      //   19: istore_1
      //   20: ldc 83
      //   22: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   25: aload_0
      //   26: monitorexit
      //   27: iload_1
      //   28: ireturn
      //   29: iconst_0
      //   30: istore_1
      //   31: ldc 83
      //   33: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    public final boolean b(ss.i arg1)
    {
      boolean bool = true;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(224494);
          if ((this.i == ???) || (this.i == null))
          {
            this.i = ???;
            notifyAll();
            AppMethodBeat.o(224494);
            return bool;
          }
          c();
          if (this.e)
          {
            AppMethodBeat.o(224494);
            continue;
          }
          if (this.i == null) {
            break label97;
          }
        }
        finally {}
        ss.i locali = this.i;
        synchronized (ss.g())
        {
          locali.h = true;
          ss.g().notifyAll();
          label97:
          bool = false;
          AppMethodBeat.o(224494);
        }
      }
    }
    
    public final void c(ss.i parami)
    {
      try
      {
        AppMethodBeat.i(224506);
        if (this.i == parami) {
          this.i = null;
        }
        notifyAll();
        AppMethodBeat.o(224506);
        return;
      }
      finally {}
    }
  }
  
  public static abstract interface k
  {
    public abstract GL a();
  }
  
  static final class l
    extends Writer
  {
    private StringBuilder a;
    
    l()
    {
      AppMethodBeat.i(224375);
      this.a = new StringBuilder();
      AppMethodBeat.o(224375);
    }
    
    private void a()
    {
      AppMethodBeat.i(224387);
      if (this.a.length() > 0) {
        this.a.delete(0, this.a.length());
      }
      AppMethodBeat.o(224387);
    }
    
    public final void close()
    {
      AppMethodBeat.i(224398);
      a();
      AppMethodBeat.o(224398);
    }
    
    public final void flush()
    {
      AppMethodBeat.i(224407);
      a();
      AppMethodBeat.o(224407);
    }
    
    public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(224419);
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
      AppMethodBeat.o(224419);
    }
  }
  
  public static abstract interface m
  {
    public abstract void T();
    
    public abstract void a(GL10 paramGL10, int paramInt1, int paramInt2);
    
    public abstract void a(GL10 paramGL10, EGLConfig paramEGLConfig);
    
    public abstract boolean a(GL10 paramGL10);
  }
  
  final class n
    extends ss.b
  {
    public n(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ss
 * JD-Core Version:    0.7.0.1
 */