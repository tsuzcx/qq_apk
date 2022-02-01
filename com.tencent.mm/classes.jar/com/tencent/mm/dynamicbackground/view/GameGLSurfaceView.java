package com.tencent.mm.dynamicbackground.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.a.c;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

public class GameGLSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback2
{
  private static final k ggo;
  private final WeakReference<GameGLSurfaceView> ggp;
  private j ggq;
  private n ggr;
  private e ggs;
  private f ggt;
  private h ggu;
  private l ggv;
  private boolean ggw;
  private int ggx;
  private int ggy;
  private boolean ggz;
  private boolean mDetached;
  
  static
  {
    AppMethodBeat.i(103073);
    ggo = new k((byte)0);
    AppMethodBeat.o(103073);
  }
  
  public GameGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103053);
    this.ggp = new WeakReference(this);
    this.ggw = false;
    getHolder().addCallback(this);
    AppMethodBeat.o(103053);
  }
  
  private void aee()
  {
    AppMethodBeat.i(103072);
    if (this.ggq != null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
      AppMethodBeat.o(103072);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(103072);
  }
  
  public final void aed()
  {
    AppMethodBeat.i(103060);
    setEGLConfigChooser(new b());
    AppMethodBeat.o(103060);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(103054);
    try
    {
      if (this.ggq != null) {
        this.ggq.aen();
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(103054);
    }
  }
  
  public int getDebugFlags()
  {
    return this.ggx;
  }
  
  public boolean getIsSwapNow()
  {
    return this.ggw;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.ggz;
  }
  
  public int getRenderMode()
  {
    AppMethodBeat.i(103063);
    int i = this.ggq.getRenderMode();
    AppMethodBeat.o(103063);
    return i;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(103070);
    super.onAttachedToWindow();
    c.i("MicroMsg.GameGLSurfaceView", "onAttachedToWindow reattach =" + this.mDetached, new Object[0]);
    if ((this.mDetached) && (this.ggr != null)) {
      if (this.ggq == null) {
        break label112;
      }
    }
    label112:
    for (int i = this.ggq.getRenderMode();; i = 1)
    {
      this.ggq = new j(this.ggp);
      if (i != 1) {
        this.ggq.setRenderMode(i);
      }
      this.ggq.start();
      this.mDetached = false;
      AppMethodBeat.o(103070);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(103071);
    c.i("MicroMsg.GameGLSurfaceView", "onDetachedFromWindow", new Object[0]);
    if (this.ggq != null) {
      this.ggq.aen();
    }
    this.mDetached = true;
    super.onDetachedFromWindow();
    AppMethodBeat.o(103071);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(103068);
    j localj = this.ggq;
    synchronized (ggo)
    {
      c.i("MicroMsg.GLThread", "onPause tid=" + localj.getId(), new Object[0]);
      localj.ggY = true;
      ggo.notifyAll();
      for (;;)
      {
        if ((!localj.ggW) && (!localj.Ct))
        {
          c.i("MicroMsg.GLThread", "onPause waiting for mPaused.", new Object[0]);
          try
          {
            ggo.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
    AppMethodBeat.o(103068);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(103069);
    c.i("MicroMsg.GameGLSurfaceView", "onResume", new Object[0]);
    j localj = this.ggq;
    synchronized (ggo)
    {
      c.i("MicroMsg.GLThread", "onResume tid=" + localj.getId(), new Object[0]);
      localj.ggY = false;
      localj.gha = false;
      localj.ghi = true;
      localj.ghk = false;
      ggo.notifyAll();
      for (;;)
      {
        if ((!localj.ggW) && (localj.Ct) && (!localj.ghk))
        {
          c.i("MicroMsg.GLThread", "onResume waiting for !mPaused.", new Object[0]);
          try
          {
            ggo.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
    AppMethodBeat.o(103069);
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.ggx = paramInt;
  }
  
  public void setEGLConfigChooser(e parame)
  {
    AppMethodBeat.i(103058);
    aee();
    this.ggs = parame;
    AppMethodBeat.o(103058);
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    AppMethodBeat.i(103059);
    setEGLConfigChooser(new o());
    AppMethodBeat.o(103059);
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    AppMethodBeat.i(103061);
    aee();
    this.ggy = paramInt;
    AppMethodBeat.o(103061);
  }
  
  public void setEGLContextFactory(f paramf)
  {
    AppMethodBeat.i(103056);
    aee();
    this.ggt = paramf;
    AppMethodBeat.o(103056);
  }
  
  public void setEGLWindowSurfaceFactory(h paramh)
  {
    AppMethodBeat.i(103057);
    aee();
    this.ggu = paramh;
    AppMethodBeat.o(103057);
  }
  
  public void setFps(int paramInt) {}
  
  public void setGLWrapper(l paraml)
  {
    this.ggv = paraml;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.ggz = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(103062);
    this.ggq.setRenderMode(paramInt);
    AppMethodBeat.o(103062);
  }
  
  public void setRenderer(n paramn)
  {
    AppMethodBeat.i(103055);
    aee();
    if (this.ggs == null) {
      this.ggs = new o();
    }
    if (this.ggt == null) {
      this.ggt = new c((byte)0);
    }
    if (this.ggu == null) {
      this.ggu = new d((byte)0);
    }
    this.ggr = paramn;
    this.ggq = new j(this.ggp);
    this.ggq.start();
    AppMethodBeat.o(103055);
  }
  
  public void setSwapNow(boolean paramBoolean)
  {
    this.ggw = paramBoolean;
  }
  
  public void surfaceChanged(SurfaceHolder arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(103066);
    j localj = this.ggq;
    for (;;)
    {
      synchronized (ggo)
      {
        if ((localj.mWidth == paramInt2) && (localj.mHeight == paramInt3))
        {
          AppMethodBeat.o(103066);
          return;
        }
        localj.mWidth = paramInt2;
        localj.mHeight = paramInt3;
        localj.ghm = true;
        localj.ghi = true;
        localj.ghk = false;
        localj.ggZ = true;
        if (Thread.currentThread() == localj)
        {
          AppMethodBeat.o(103066);
          return;
        }
        ggo.notifyAll();
        if ((localj.ggW) || (localj.Ct) || (localj.ghk)) {
          break;
        }
        if ((localj.ghe) && (localj.ghf) && (localj.ael()))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break;
          }
          c.i("MicroMsg.GLThread", "onWindowResize waiting for render complete from tid=" + localj.getId(), new Object[0]);
          try
          {
            ggo.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
      paramInt1 = 0;
    }
    AppMethodBeat.o(103066);
  }
  
  public void surfaceCreated(SurfaceHolder arg1)
  {
    AppMethodBeat.i(103064);
    c.i("MicroMsg.GameGLSurfaceView", "alvinluo GameGLSurfaceView surfaceCreated", new Object[0]);
    j localj = this.ggq;
    synchronized (ggo)
    {
      c.i("MicroMsg.GLThread", "surfaceCreated tid=" + localj.getId(), new Object[0]);
      localj.ghb = true;
      localj.ghg = false;
      localj.ggZ = true;
      ggo.notifyAll();
      for (;;)
      {
        if ((localj.ghd) && (!localj.ghg))
        {
          boolean bool = localj.ggW;
          if (!bool) {
            try
            {
              ggo.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(103064);
  }
  
  public void surfaceDestroyed(SurfaceHolder arg1)
  {
    AppMethodBeat.i(103065);
    j localj = this.ggq;
    synchronized (ggo)
    {
      c.i("MicroMsg.GLThread", "surfaceDestroyed tid=" + localj.getId(), new Object[0]);
      localj.ghb = false;
      localj.ggZ = true;
      ggo.notifyAll();
      for (;;)
      {
        if (!localj.ghd)
        {
          boolean bool = localj.ggW;
          if (!bool) {
            try
            {
              ggo.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(103065);
  }
  
  public void surfaceRedrawNeeded(SurfaceHolder arg1)
  {
    AppMethodBeat.i(103067);
    if (this.ggq != null)
    {
      j localj = this.ggq;
      synchronized (ggo)
      {
        localj.ghi = true;
        ggo.notifyAll();
        AppMethodBeat.o(103067);
        return;
      }
    }
    AppMethodBeat.o(103067);
  }
  
  abstract class a
    implements GameGLSurfaceView.e
  {
    protected int[] ggA;
    
    public a(int[] paramArrayOfInt)
    {
      if ((GameGLSurfaceView.a(GameGLSurfaceView.this) != 2) && (GameGLSurfaceView.a(GameGLSurfaceView.this) != 3))
      {
        this.ggA = paramArrayOfInt;
        return;
      }
      this$1 = new int[15];
      System.arraycopy(paramArrayOfInt, 0, GameGLSurfaceView.this, 0, 12);
      GameGLSurfaceView.this[12] = 12352;
      if (GameGLSurfaceView.a(GameGLSurfaceView.this) == 2) {
        GameGLSurfaceView.this[13] = 4;
      }
      for (;;)
      {
        GameGLSurfaceView.this[14] = 12344;
        paramArrayOfInt = GameGLSurfaceView.this;
        break;
        GameGLSurfaceView.this[13] = 64;
      }
    }
    
    abstract EGLConfig b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
    
    public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
    {
      int[] arrayOfInt = new int[1];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.ggA, null, 0, arrayOfInt)) {
        throw new IllegalArgumentException("eglChooseConfig failed");
      }
      int i = arrayOfInt[0];
      if (i <= 0) {
        throw new IllegalArgumentException("No configs match configSpec");
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.ggA, arrayOfEGLConfig, i, arrayOfInt)) {
        throw new IllegalArgumentException("eglChooseConfig#2 failed");
      }
      paramEGL10 = b(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
      if (paramEGL10 == null) {
        throw new IllegalArgumentException("No config chosen");
      }
      return paramEGL10;
    }
  }
  
  class b
    extends GameGLSurfaceView.a
  {
    private int[] ggC;
    protected int ggD;
    protected int ggE;
    protected int ggF;
    protected int ggG;
    protected int ggH;
    protected int ggI;
    
    public b()
    {
      super(new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 8, 12344 });
      AppMethodBeat.i(102978);
      this.ggC = new int[1];
      this.ggD = 8;
      this.ggE = 8;
      this.ggF = 8;
      this.ggG = 8;
      this.ggH = 16;
      this.ggI = 8;
      AppMethodBeat.o(102978);
    }
    
    private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
    {
      AppMethodBeat.i(102980);
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.ggC))
      {
        paramInt = this.ggC[0];
        AppMethodBeat.o(102980);
        return paramInt;
      }
      AppMethodBeat.o(102980);
      return 0;
    }
    
    public final EGLConfig b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      AppMethodBeat.i(102979);
      int j = paramArrayOfEGLConfig.length;
      int i = 0;
      while (i < j)
      {
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
        int k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
        int m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
        if ((k >= this.ggH) && (m >= this.ggI))
        {
          k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
          m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
          int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
          int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
          if ((k == this.ggD) && (m == this.ggE) && (n == this.ggF) && (i1 == this.ggG))
          {
            AppMethodBeat.o(102979);
            return localEGLConfig;
          }
        }
        i += 1;
      }
      AppMethodBeat.o(102979);
      return null;
    }
  }
  
  final class c
    implements GameGLSurfaceView.f
  {
    private int EGL_CONTEXT_CLIENT_VERSION = 12440;
    
    private c() {}
    
    public final EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, EGLContext paramEGLContext)
    {
      AppMethodBeat.i(102981);
      c.i("MicroMsg.GLThread", "createContext", new Object[0]);
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = this.EGL_CONTEXT_CLIENT_VERSION;
      arrayOfInt[1] = GameGLSurfaceView.a(GameGLSurfaceView.this);
      arrayOfInt[2] = 12344;
      if (GameGLSurfaceView.a(GameGLSurfaceView.this) != 0) {}
      for (;;)
      {
        paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, paramEGLContext, arrayOfInt);
        AppMethodBeat.o(102981);
        return paramEGL10;
        arrayOfInt = null;
      }
    }
    
    public final void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      AppMethodBeat.i(102982);
      c.i("MicroMsg.GLThread", " destroyContext tid=" + Thread.currentThread().getId(), new Object[0]);
      if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
      {
        c.e("MicroMsg.GLThread", "display:" + paramEGLDisplay + " context: " + paramEGLContext, new Object[0]);
        GameGLSurfaceView.i.N("eglDestroyContex", paramEGL10.eglGetError());
      }
      AppMethodBeat.o(102982);
    }
  }
  
  static final class d
    implements GameGLSurfaceView.h
  {
    public final EGLSurface createWindowSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
    {
      Object localObject = null;
      AppMethodBeat.i(102983);
      try
      {
        paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
        AppMethodBeat.o(102983);
        return paramEGL10;
      }
      catch (IllegalArgumentException paramEGL10)
      {
        for (;;)
        {
          c.e("MicroMsg.GameGLSurfaceView", "eglCreateWindowSurface", new Object[] { paramEGL10 });
          paramEGL10 = localObject;
        }
      }
    }
    
    public final void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      AppMethodBeat.i(102984);
      paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
      AppMethodBeat.o(102984);
    }
  }
  
  public static abstract interface e
  {
    public abstract EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay);
  }
  
  public static abstract interface f
  {
    public abstract EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, EGLContext paramEGLContext);
    
    public abstract void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext);
  }
  
  public static abstract interface h
  {
    public abstract EGLSurface createWindowSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject);
    
    public abstract void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface);
  }
  
  static final class i
  {
    WeakReference<GameGLSurfaceView> ggO;
    EGL10 ggP;
    EGLDisplay ggQ;
    EGLSurface ggR;
    EGLConfig ggS;
    EGLContext ggT;
    EGLSurface ggU;
    
    public i(WeakReference<GameGLSurfaceView> paramWeakReference)
    {
      this.ggO = paramWeakReference;
    }
    
    public static void N(String paramString, int paramInt)
    {
      AppMethodBeat.i(103034);
      paramString = O(paramString, paramInt);
      c.e("MicroMsg.GLThread", "throwEglException tid=" + Thread.currentThread().getId() + " " + paramString, new Object[0]);
      paramString = new RuntimeException(paramString);
      AppMethodBeat.o(103034);
      throw paramString;
    }
    
    private static String O(String paramString, int paramInt)
    {
      AppMethodBeat.i(103036);
      paramString = paramString + " failed: " + GameGLSurfaceView.g.getErrorString(paramInt);
      AppMethodBeat.o(103036);
      return paramString;
    }
    
    public static void h(String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(103035);
      c.w(paramString1, O(paramString2, paramInt), new Object[0]);
      AppMethodBeat.o(103035);
    }
    
    final void aeg()
    {
      AppMethodBeat.i(103033);
      if ((this.ggR != null) && (this.ggR != EGL10.EGL_NO_SURFACE))
      {
        Object localObject = this.ggP;
        EGLDisplay localEGLDisplay = this.ggQ;
        EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
        ((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
        localObject = (GameGLSurfaceView)this.ggO.get();
        if (localObject != null) {
          GameGLSurfaceView.d((GameGLSurfaceView)localObject).destroySurface(this.ggP, this.ggQ, this.ggR);
        }
        this.ggR = null;
      }
      AppMethodBeat.o(103033);
    }
    
    public final void start()
    {
      AppMethodBeat.i(103032);
      c.w("MicroMsg.GLThread", "start() tid=" + Thread.currentThread().getId(), new Object[0]);
      this.ggP = ((EGL10)EGLContext.getEGL());
      this.ggQ = this.ggP.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      if (this.ggQ == EGL10.EGL_NO_DISPLAY)
      {
        localObject = new RuntimeException("eglGetDisplay failed");
        AppMethodBeat.o(103032);
        throw ((Throwable)localObject);
      }
      Object localObject = new int[2];
      if (!this.ggP.eglInitialize(this.ggQ, (int[])localObject))
      {
        localObject = new RuntimeException("eglInitialize failed");
        AppMethodBeat.o(103032);
        throw ((Throwable)localObject);
      }
      localObject = (GameGLSurfaceView)this.ggO.get();
      if (localObject == null)
      {
        this.ggS = null;
        this.ggT = null;
        c.w("MicroMsg.GameGLSurfaceView", "alvinluo EglHelper start but view is null and set mEglConfig = null, mEglContext = null", new Object[0]);
      }
      for (;;)
      {
        if ((this.ggT == null) || (this.ggT == EGL10.EGL_NO_CONTEXT))
        {
          this.ggT = null;
          N("createContext", this.ggP.eglGetError());
        }
        c.w("MicroMsg.GLThread", "createContext " + this.ggT + " tid=" + Thread.currentThread().getId(), new Object[0]);
        this.ggU = this.ggP.eglCreatePbufferSurface(this.ggQ, this.ggS, new int[] { 12375, 16, 12374, 16, 12344 });
        this.ggP.eglMakeCurrent(this.ggQ, this.ggU, this.ggU, this.ggT);
        this.ggR = null;
        AppMethodBeat.o(103032);
        return;
        this.ggS = GameGLSurfaceView.b((GameGLSurfaceView)localObject).chooseConfig(this.ggP, this.ggQ);
        c.i("MicroMsg.GameGLSurfaceView", "alvinluo EglHelper start chooseConfig end config: %s, display: %s", new Object[] { Integer.valueOf(this.ggS.hashCode()), Integer.valueOf(this.ggQ.hashCode()) });
        this.ggT = GameGLSurfaceView.c((GameGLSurfaceView)localObject).a(this.ggP, this.ggQ, this.ggS, EGL10.EGL_NO_CONTEXT);
        c.i("MicroMsg.GameGLSurfaceView", "alvinluo EglHelper start createContext end", new Object[0]);
      }
    }
  }
  
  static final class j
    extends Thread
  {
    boolean Ct;
    private WeakReference<GameGLSurfaceView> ggO;
    private boolean ggV;
    boolean ggW;
    private boolean ggX;
    boolean ggY;
    boolean ggZ;
    boolean gha;
    boolean ghb;
    private boolean ghc;
    boolean ghd;
    boolean ghe;
    boolean ghf;
    boolean ghg;
    private boolean ghh;
    boolean ghi;
    private boolean ghj;
    boolean ghk;
    private LinkedList<Runnable> ghl;
    boolean ghm;
    private GameGLSurfaceView.i ghn;
    int mHeight;
    private int mRenderMode;
    int mWidth;
    
    j(WeakReference<GameGLSurfaceView> paramWeakReference)
    {
      AppMethodBeat.i(103037);
      this.ghl = new LinkedList();
      this.ghm = true;
      try
      {
        setPriority(10);
        label31:
        this.mWidth = 0;
        this.mHeight = 0;
        this.ghi = true;
        this.mRenderMode = 1;
        this.ghj = false;
        this.ggO = paramWeakReference;
        AppMethodBeat.o(103037);
        return;
      }
      catch (Exception localException)
      {
        break label31;
      }
    }
    
    private void aeh()
    {
      if (this.ghf)
      {
        this.ghf = false;
        this.ghg = false;
      }
    }
    
    private void aei()
    {
      AppMethodBeat.i(103039);
      if (this.ghe)
      {
        this.ghe = false;
        GameGLSurfaceView.aef().notifyAll();
      }
      AppMethodBeat.o(103039);
    }
    
    /* Error */
    private void aej()
    {
      // Byte code:
      //   0: ldc 106
      //   2: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: new 108	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i
      //   9: dup
      //   10: aload_0
      //   11: getfield 74	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ggO	Ljava/lang/ref/WeakReference;
      //   14: invokespecial 110	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:<init>	(Ljava/lang/ref/WeakReference;)V
      //   17: putfield 112	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghn	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i;
      //   20: aload_0
      //   21: iconst_0
      //   22: putfield 91	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghe	Z
      //   25: aload_0
      //   26: iconst_0
      //   27: putfield 85	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghf	Z
      //   30: invokestatic 95	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aef	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   33: astore 15
      //   35: aload 15
      //   37: monitorenter
      //   38: aload_0
      //   39: iconst_0
      //   40: putfield 72	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghj	Z
      //   43: aload 15
      //   45: monitorexit
      //   46: iconst_0
      //   47: istore_3
      //   48: iconst_0
      //   49: istore 4
      //   51: iconst_0
      //   52: istore 5
      //   54: iconst_0
      //   55: istore 7
      //   57: iconst_0
      //   58: istore 9
      //   60: iconst_0
      //   61: istore 6
      //   63: iconst_0
      //   64: istore_2
      //   65: iconst_0
      //   66: istore 10
      //   68: iconst_0
      //   69: istore 11
      //   71: aconst_null
      //   72: astore 15
      //   74: iconst_0
      //   75: istore_1
      //   76: invokestatic 95	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aef	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   79: astore 16
      //   81: aload 16
      //   83: monitorenter
      //   84: iload_2
      //   85: istore 8
      //   87: iload_1
      //   88: istore_2
      //   89: iload 8
      //   91: istore_1
      //   92: aload_0
      //   93: getfield 114	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ggV	Z
      //   96: ifeq +25 -> 121
      //   99: aload 16
      //   101: monitorexit
      //   102: ldc 106
      //   104: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   107: return
      //   108: astore 16
      //   110: aload 15
      //   112: monitorexit
      //   113: ldc 106
      //   115: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   118: aload 16
      //   120: athrow
      //   121: aload_0
      //   122: getfield 116	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:Ct	Z
      //   125: ifne +62 -> 187
      //   128: aload_0
      //   129: getfield 87	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghg	Z
      //   132: ifeq +55 -> 187
      //   135: aload_0
      //   136: getfield 57	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghl	Ljava/util/LinkedList;
      //   139: invokevirtual 120	java/util/LinkedList:isEmpty	()Z
      //   142: ifne +45 -> 187
      //   145: aload_0
      //   146: getfield 57	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghl	Ljava/util/LinkedList;
      //   149: iconst_0
      //   150: invokevirtual 124	java/util/LinkedList:remove	(I)Ljava/lang/Object;
      //   153: checkcast 126	java/lang/Runnable
      //   156: astore 15
      //   158: aload 16
      //   160: monitorexit
      //   161: aload 15
      //   163: ifnull +1010 -> 1173
      //   166: aload 15
      //   168: invokeinterface 129 1 0
      //   173: aconst_null
      //   174: astore 15
      //   176: iload_2
      //   177: istore 8
      //   179: iload_1
      //   180: istore_2
      //   181: iload 8
      //   183: istore_1
      //   184: goto -108 -> 76
      //   187: iconst_0
      //   188: istore 14
      //   190: aload_0
      //   191: getfield 116	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:Ct	Z
      //   194: aload_0
      //   195: getfield 131	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ggY	Z
      //   198: if_icmpeq +95 -> 293
      //   201: aload_0
      //   202: getfield 131	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ggY	Z
      //   205: istore 14
      //   207: aload_0
      //   208: aload_0
      //   209: getfield 131	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ggY	Z
      //   212: putfield 116	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:Ct	Z
      //   215: iload 14
      //   217: ifeq +472 -> 689
      //   220: aload_0
      //   221: getfield 74	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ggO	Ljava/lang/ref/WeakReference;
      //   224: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   227: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   230: astore 17
      //   232: aload 17
      //   234: ifnull +13 -> 247
      //   237: aload 17
      //   239: invokestatic 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:g	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$n;
      //   242: invokeinterface 146 1 0
      //   247: invokestatic 95	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aef	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   250: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   253: ldc 148
      //   255: new 150	java/lang/StringBuilder
      //   258: dup
      //   259: ldc 152
      //   261: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   264: aload_0
      //   265: getfield 116	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:Ct	Z
      //   268: invokevirtual 159	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   271: ldc 161
      //   273: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   276: aload_0
      //   277: invokevirtual 168	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   280: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   283: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   286: iconst_0
      //   287: anewarray 97	java/lang/Object
      //   290: invokestatic 180	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   293: aload_0
      //   294: getfield 182	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghh	Z
      //   297: ifeq +46 -> 343
      //   300: ldc 148
      //   302: new 150	java/lang/StringBuilder
      //   305: dup
      //   306: ldc 184
      //   308: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   311: aload_0
      //   312: invokevirtual 168	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   315: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   318: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   321: iconst_0
      //   322: anewarray 97	java/lang/Object
      //   325: invokestatic 180	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   328: aload_0
      //   329: invokespecial 186	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aeh	()V
      //   332: aload_0
      //   333: invokespecial 188	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aei	()V
      //   336: aload_0
      //   337: iconst_0
      //   338: putfield 182	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghh	Z
      //   341: iconst_1
      //   342: istore_1
      //   343: iload 7
      //   345: istore 12
      //   347: iload 7
      //   349: ifeq +14 -> 363
      //   352: aload_0
      //   353: invokespecial 186	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aeh	()V
      //   356: aload_0
      //   357: invokespecial 188	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aei	()V
      //   360: iconst_0
      //   361: istore 12
      //   363: iload 14
      //   365: ifeq +42 -> 407
      //   368: aload_0
      //   369: getfield 85	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghf	Z
      //   372: ifeq +35 -> 407
      //   375: ldc 148
      //   377: new 150	java/lang/StringBuilder
      //   380: dup
      //   381: ldc 190
      //   383: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   386: aload_0
      //   387: invokevirtual 168	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   390: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   393: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   396: iconst_0
      //   397: anewarray 97	java/lang/Object
      //   400: invokestatic 180	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   403: aload_0
      //   404: invokespecial 186	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aeh	()V
      //   407: iload 14
      //   409: ifeq +67 -> 476
      //   412: aload_0
      //   413: getfield 91	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghe	Z
      //   416: ifeq +60 -> 476
      //   419: aload_0
      //   420: getfield 74	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ggO	Ljava/lang/ref/WeakReference;
      //   423: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   426: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   429: astore 17
      //   431: aload 17
      //   433: ifnonnull +347 -> 780
      //   436: iconst_0
      //   437: istore 14
      //   439: iload 14
      //   441: ifne +35 -> 476
      //   444: aload_0
      //   445: invokespecial 188	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aei	()V
      //   448: ldc 148
      //   450: new 150	java/lang/StringBuilder
      //   453: dup
      //   454: ldc 192
      //   456: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   459: aload_0
      //   460: invokevirtual 168	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   463: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   466: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   469: iconst_0
      //   470: anewarray 97	java/lang/Object
      //   473: invokestatic 180	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   476: aload_0
      //   477: getfield 194	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghb	Z
      //   480: ifne +65 -> 545
      //   483: aload_0
      //   484: getfield 196	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghd	Z
      //   487: ifne +58 -> 545
      //   490: ldc 148
      //   492: new 150	java/lang/StringBuilder
      //   495: dup
      //   496: ldc 198
      //   498: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   501: aload_0
      //   502: invokevirtual 168	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   505: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   508: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   511: iconst_0
      //   512: anewarray 97	java/lang/Object
      //   515: invokestatic 180	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   518: aload_0
      //   519: getfield 85	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghf	Z
      //   522: ifeq +7 -> 529
      //   525: aload_0
      //   526: invokespecial 186	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aeh	()V
      //   529: aload_0
      //   530: iconst_1
      //   531: putfield 196	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghd	Z
      //   534: aload_0
      //   535: iconst_0
      //   536: putfield 200	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghc	Z
      //   539: invokestatic 95	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aef	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   542: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   545: aload_0
      //   546: getfield 194	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghb	Z
      //   549: ifeq +49 -> 598
      //   552: aload_0
      //   553: getfield 196	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghd	Z
      //   556: ifeq +42 -> 598
      //   559: ldc 148
      //   561: new 150	java/lang/StringBuilder
      //   564: dup
      //   565: ldc 202
      //   567: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   570: aload_0
      //   571: invokevirtual 168	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   574: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   577: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   580: iconst_0
      //   581: anewarray 97	java/lang/Object
      //   584: invokestatic 180	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   587: aload_0
      //   588: iconst_0
      //   589: putfield 196	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghd	Z
      //   592: invokestatic 95	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aef	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   595: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   598: iload 6
      //   600: istore 13
      //   602: iload 6
      //   604: ifeq +50 -> 654
      //   607: ldc 148
      //   609: new 150	java/lang/StringBuilder
      //   612: dup
      //   613: ldc 204
      //   615: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   618: aload_0
      //   619: invokevirtual 168	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   622: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   625: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   628: iconst_0
      //   629: anewarray 97	java/lang/Object
      //   632: invokestatic 180	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   635: aload_0
      //   636: iconst_0
      //   637: putfield 72	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghj	Z
      //   640: iconst_0
      //   641: istore 13
      //   643: aload_0
      //   644: iconst_1
      //   645: putfield 206	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghk	Z
      //   648: invokestatic 95	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aef	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   651: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   654: aload_0
      //   655: getfield 91	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghe	Z
      //   658: ifne +179 -> 837
      //   661: ldc 148
      //   663: ldc 208
      //   665: iconst_0
      //   666: anewarray 97	java/lang/Object
      //   669: invokestatic 180	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   672: iload_1
      //   673: ifeq +117 -> 790
      //   676: iconst_0
      //   677: istore_1
      //   678: iload 13
      //   680: istore 6
      //   682: iload 12
      //   684: istore 7
      //   686: goto -528 -> 158
      //   689: aload_0
      //   690: getfield 74	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ggO	Ljava/lang/ref/WeakReference;
      //   693: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   696: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   699: astore 17
      //   701: aload 17
      //   703: ifnull -456 -> 247
      //   706: aload 17
      //   708: invokestatic 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:g	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$n;
      //   711: invokeinterface 211 1 0
      //   716: goto -469 -> 247
      //   719: astore 15
      //   721: aload 16
      //   723: monitorexit
      //   724: ldc 106
      //   726: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   729: aload 15
      //   731: athrow
      //   732: astore 15
      //   734: ldc 148
      //   736: aload 15
      //   738: ldc 213
      //   740: iconst_0
      //   741: anewarray 97	java/lang/Object
      //   744: invokestatic 217	com/tencent/mm/dynamicbackground/a/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   747: aload_0
      //   748: getfield 74	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ggO	Ljava/lang/ref/WeakReference;
      //   751: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   754: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   757: astore 15
      //   759: aload 15
      //   761: ifnull +13 -> 774
      //   764: aload 15
      //   766: invokestatic 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:g	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$n;
      //   769: invokeinterface 220 1 0
      //   774: ldc 106
      //   776: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   779: return
      //   780: aload 17
      //   782: invokestatic 224	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:h	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Z
      //   785: istore 14
      //   787: goto -348 -> 439
      //   790: aload_0
      //   791: getfield 112	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghn	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i;
      //   794: invokevirtual 227	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:start	()V
      //   797: aload_0
      //   798: iconst_1
      //   799: putfield 91	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghe	Z
      //   802: invokestatic 95	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aef	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   805: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   808: iconst_1
      //   809: istore_3
      //   810: iload 13
      //   812: istore 6
      //   814: iload 12
      //   816: istore 7
      //   818: goto -660 -> 158
      //   821: astore 15
      //   823: invokestatic 95	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aef	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   826: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   829: ldc 106
      //   831: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   834: aload 15
      //   836: athrow
      //   837: aload_0
      //   838: invokevirtual 230	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ael	()Z
      //   841: ifeq +1543 -> 2384
      //   844: iload_3
      //   845: istore 6
      //   847: aload_0
      //   848: getfield 91	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghe	Z
      //   851: ifne +1542 -> 2393
      //   854: ldc 148
      //   856: ldc 208
      //   858: iconst_0
      //   859: anewarray 97	java/lang/Object
      //   862: invokestatic 180	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   865: iload_1
      //   866: ifeq +189 -> 1055
      //   869: iconst_0
      //   870: istore_1
      //   871: iload_2
      //   872: istore 7
      //   874: iload 4
      //   876: istore 6
      //   878: iload 5
      //   880: istore 8
      //   882: aload_0
      //   883: getfield 91	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghe	Z
      //   886: ifeq +46 -> 932
      //   889: iload_2
      //   890: istore 7
      //   892: iload 4
      //   894: istore 6
      //   896: iload 5
      //   898: istore 8
      //   900: aload_0
      //   901: getfield 85	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghf	Z
      //   904: ifne +28 -> 932
      //   907: ldc 148
      //   909: ldc 232
      //   911: iconst_0
      //   912: anewarray 97	java/lang/Object
      //   915: invokestatic 180	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   918: aload_0
      //   919: iconst_1
      //   920: putfield 85	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghf	Z
      //   923: iconst_1
      //   924: istore 6
      //   926: iconst_1
      //   927: istore 8
      //   929: iconst_1
      //   930: istore 7
      //   932: aload_0
      //   933: getfield 85	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghf	Z
      //   936: ifeq +159 -> 1095
      //   939: aload_0
      //   940: getfield 59	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghm	Z
      //   943: ifeq +1427 -> 2370
      //   946: iconst_1
      //   947: istore 7
      //   949: aload_0
      //   950: getfield 64	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mWidth	I
      //   953: istore_2
      //   954: aload_0
      //   955: getfield 66	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mHeight	I
      //   958: istore 4
      //   960: aload_0
      //   961: iconst_1
      //   962: putfield 72	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghj	Z
      //   965: ldc 148
      //   967: new 150	java/lang/StringBuilder
      //   970: dup
      //   971: ldc 234
      //   973: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   976: aload_0
      //   977: invokevirtual 168	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   980: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   983: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   986: iconst_0
      //   987: anewarray 97	java/lang/Object
      //   990: invokestatic 180	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   993: iconst_1
      //   994: istore 5
      //   996: aload_0
      //   997: iconst_0
      //   998: putfield 59	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghm	Z
      //   1001: aload_0
      //   1002: iconst_0
      //   1003: putfield 68	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghi	Z
      //   1006: invokestatic 95	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aef	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1009: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   1012: aload_0
      //   1013: getfield 72	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghj	Z
      //   1016: istore 14
      //   1018: iload 14
      //   1020: ifeq +1321 -> 2341
      //   1023: iconst_1
      //   1024: istore 9
      //   1026: iload 4
      //   1028: istore 11
      //   1030: iload_2
      //   1031: istore 10
      //   1033: iload 7
      //   1035: istore_2
      //   1036: iload 13
      //   1038: istore 6
      //   1040: iload 12
      //   1042: istore 7
      //   1044: iload 5
      //   1046: istore 4
      //   1048: iload 8
      //   1050: istore 5
      //   1052: goto -894 -> 158
      //   1055: aload_0
      //   1056: getfield 112	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghn	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i;
      //   1059: invokevirtual 227	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:start	()V
      //   1062: aload_0
      //   1063: iconst_1
      //   1064: putfield 91	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghe	Z
      //   1067: iconst_1
      //   1068: istore 6
      //   1070: invokestatic 95	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aef	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1073: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   1076: goto +1317 -> 2393
      //   1079: astore 15
      //   1081: invokestatic 95	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aef	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1084: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   1087: ldc 106
      //   1089: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1092: aload 15
      //   1094: athrow
      //   1095: ldc 148
      //   1097: ldc 236
      //   1099: iconst_0
      //   1100: anewarray 97	java/lang/Object
      //   1103: invokestatic 239	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1106: iload 8
      //   1108: istore 5
      //   1110: iload 6
      //   1112: istore 4
      //   1114: iload 7
      //   1116: istore_2
      //   1117: aload_0
      //   1118: invokespecial 242	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aem	()Z
      //   1121: ifeq +35 -> 1156
      //   1124: ldc 148
      //   1126: ldc 244
      //   1128: iconst_1
      //   1129: anewarray 97	java/lang/Object
      //   1132: dup
      //   1133: iconst_0
      //   1134: aload_0
      //   1135: getfield 116	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:Ct	Z
      //   1138: invokestatic 250	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   1141: aastore
      //   1142: invokestatic 180	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1145: iload 13
      //   1147: istore 6
      //   1149: iload 12
      //   1151: istore 7
      //   1153: goto -995 -> 158
      //   1156: invokestatic 95	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aef	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1159: invokevirtual 253	java/lang/Object:wait	()V
      //   1162: iload 13
      //   1164: istore 6
      //   1166: iload 12
      //   1168: istore 7
      //   1170: goto -1078 -> 92
      //   1173: iload 4
      //   1175: ifeq +1163 -> 2338
      //   1178: ldc 148
      //   1180: ldc 255
      //   1182: iconst_0
      //   1183: anewarray 97	java/lang/Object
      //   1186: invokestatic 258	com/tencent/mm/dynamicbackground/a/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1189: aload_0
      //   1190: getfield 112	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghn	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i;
      //   1193: astore 16
      //   1195: ldc 148
      //   1197: new 150	java/lang/StringBuilder
      //   1200: dup
      //   1201: ldc_w 260
      //   1204: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1207: invokestatic 264	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1210: invokevirtual 265	java/lang/Thread:getId	()J
      //   1213: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1216: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1219: iconst_0
      //   1220: anewarray 97	java/lang/Object
      //   1223: invokestatic 258	com/tencent/mm/dynamicbackground/a/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1226: aload 16
      //   1228: getfield 269	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggP	Ljavax/microedition/khronos/egl/EGL10;
      //   1231: ifnonnull +33 -> 1264
      //   1234: new 105	java/lang/RuntimeException
      //   1237: dup
      //   1238: ldc_w 271
      //   1241: invokespecial 272	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1244: astore 15
      //   1246: ldc 106
      //   1248: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1251: aload 15
      //   1253: athrow
      //   1254: astore 15
      //   1256: ldc 106
      //   1258: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1261: aload 15
      //   1263: athrow
      //   1264: aload 16
      //   1266: getfield 276	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggQ	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1269: ifnonnull +23 -> 1292
      //   1272: new 105	java/lang/RuntimeException
      //   1275: dup
      //   1276: ldc_w 278
      //   1279: invokespecial 272	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1282: astore 15
      //   1284: ldc 106
      //   1286: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1289: aload 15
      //   1291: athrow
      //   1292: aload 16
      //   1294: getfield 282	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggS	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1297: ifnonnull +23 -> 1320
      //   1300: new 105	java/lang/RuntimeException
      //   1303: dup
      //   1304: ldc_w 284
      //   1307: invokespecial 272	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1310: astore 15
      //   1312: ldc 106
      //   1314: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1317: aload 15
      //   1319: athrow
      //   1320: aload 16
      //   1322: invokevirtual 287	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:aeg	()V
      //   1325: aload 16
      //   1327: getfield 288	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggO	Ljava/lang/ref/WeakReference;
      //   1330: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1333: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   1336: astore 17
      //   1338: aload 17
      //   1340: ifnull +352 -> 1692
      //   1343: aload 16
      //   1345: aload 17
      //   1347: invokestatic 292	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:d	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$h;
      //   1350: aload 16
      //   1352: getfield 269	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggP	Ljavax/microedition/khronos/egl/EGL10;
      //   1355: aload 16
      //   1357: getfield 276	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggQ	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1360: aload 16
      //   1362: getfield 282	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggS	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1365: aload 17
      //   1367: invokevirtual 296	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:getHolder	()Landroid/view/SurfaceHolder;
      //   1370: invokeinterface 302 5 0
      //   1375: putfield 306	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggR	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1378: aload 16
      //   1380: getfield 306	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggR	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1383: ifnull +14 -> 1397
      //   1386: aload 16
      //   1388: getfield 306	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggR	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1391: getstatic 311	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1394: if_acmpne +307 -> 1701
      //   1397: aload 16
      //   1399: getfield 269	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggP	Ljavax/microedition/khronos/egl/EGL10;
      //   1402: invokeinterface 315 1 0
      //   1407: sipush 12299
      //   1410: if_icmpne +989 -> 2399
      //   1413: ldc 148
      //   1415: ldc_w 317
      //   1418: iconst_0
      //   1419: anewarray 97	java/lang/Object
      //   1422: invokestatic 239	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1425: goto +974 -> 2399
      //   1428: iload 8
      //   1430: ifeq +383 -> 1813
      //   1433: invokestatic 95	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aef	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1436: astore 16
      //   1438: aload 16
      //   1440: monitorenter
      //   1441: aload_0
      //   1442: iconst_1
      //   1443: putfield 87	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghg	Z
      //   1446: invokestatic 95	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aef	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1449: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   1452: aload 16
      //   1454: monitorexit
      //   1455: iload_3
      //   1456: ifne +949 -> 2405
      //   1459: ldc 148
      //   1461: ldc_w 319
      //   1464: iconst_0
      //   1465: anewarray 97	java/lang/Object
      //   1468: invokestatic 180	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1471: aload_0
      //   1472: getfield 74	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ggO	Ljava/lang/ref/WeakReference;
      //   1475: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1478: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   1481: astore 16
      //   1483: aload 16
      //   1485: ifnull +920 -> 2405
      //   1488: aload 16
      //   1490: invokestatic 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:g	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$n;
      //   1493: invokeinterface 322 1 0
      //   1498: goto +907 -> 2405
      //   1501: iload 5
      //   1503: istore 8
      //   1505: iload 5
      //   1507: ifeq +127 -> 1634
      //   1510: ldc 148
      //   1512: ldc_w 324
      //   1515: iconst_0
      //   1516: anewarray 97	java/lang/Object
      //   1519: invokestatic 258	com/tencent/mm/dynamicbackground/a/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1522: aload_0
      //   1523: getfield 112	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghn	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i;
      //   1526: astore 17
      //   1528: aload 17
      //   1530: getfield 328	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggT	Ljavax/microedition/khronos/egl/EGLContext;
      //   1533: invokevirtual 334	javax/microedition/khronos/egl/EGLContext:getGL	()Ljavax/microedition/khronos/opengles/GL;
      //   1536: astore 16
      //   1538: aload 17
      //   1540: getfield 288	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggO	Ljava/lang/ref/WeakReference;
      //   1543: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1546: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   1549: astore 17
      //   1551: aload 17
      //   1553: ifnull +858 -> 2411
      //   1556: aload 17
      //   1558: invokestatic 337	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:e	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$l;
      //   1561: ifnull +15 -> 1576
      //   1564: aload 17
      //   1566: invokestatic 337	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:e	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$l;
      //   1569: invokeinterface 342 1 0
      //   1574: astore 16
      //   1576: aload 17
      //   1578: invokestatic 346	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:f	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)I
      //   1581: iconst_3
      //   1582: iand
      //   1583: ifeq +828 -> 2411
      //   1586: iconst_0
      //   1587: istore 5
      //   1589: aload 17
      //   1591: invokestatic 346	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:f	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)I
      //   1594: iconst_1
      //   1595: iand
      //   1596: ifeq +6 -> 1602
      //   1599: iconst_1
      //   1600: istore 5
      //   1602: aload 17
      //   1604: invokestatic 346	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:f	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)I
      //   1607: iconst_2
      //   1608: iand
      //   1609: ifeq +778 -> 2387
      //   1612: new 348	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$m
      //   1615: dup
      //   1616: invokespecial 349	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$m:<init>	()V
      //   1619: astore 17
      //   1621: aload 16
      //   1623: iload 5
      //   1625: aload 17
      //   1627: invokestatic 355	android/opengl/GLDebugHelper:wrap	(Ljavax/microedition/khronos/opengles/GL;ILjava/io/Writer;)Ljavax/microedition/khronos/opengles/GL;
      //   1630: pop
      //   1631: goto +780 -> 2411
      //   1634: iload_3
      //   1635: ifeq +11 -> 1646
      //   1638: aload_0
      //   1639: getfield 74	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ggO	Ljava/lang/ref/WeakReference;
      //   1642: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1645: pop
      //   1646: iload_3
      //   1647: ifeq +244 -> 1891
      //   1650: ldc 148
      //   1652: ldc_w 357
      //   1655: iconst_0
      //   1656: anewarray 97	java/lang/Object
      //   1659: invokestatic 258	com/tencent/mm/dynamicbackground/a/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1662: aload_0
      //   1663: getfield 74	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ggO	Ljava/lang/ref/WeakReference;
      //   1666: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1669: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   1672: astore 16
      //   1674: aload 16
      //   1676: ifnull +200 -> 1876
      //   1679: aload 16
      //   1681: invokestatic 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:g	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$n;
      //   1684: invokeinterface 360 1 0
      //   1689: goto +728 -> 2417
      //   1692: aload 16
      //   1694: aconst_null
      //   1695: putfield 306	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggR	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1698: goto -320 -> 1378
      //   1701: aload 16
      //   1703: getfield 269	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggP	Ljavax/microedition/khronos/egl/EGL10;
      //   1706: aload 16
      //   1708: getfield 276	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggQ	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1711: aload 16
      //   1713: getfield 306	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggR	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1716: aload 16
      //   1718: getfield 306	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggR	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1721: aload 16
      //   1723: getfield 328	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggT	Ljavax/microedition/khronos/egl/EGLContext;
      //   1726: invokeinterface 364 5 0
      //   1731: ifne +28 -> 1759
      //   1734: ldc_w 366
      //   1737: ldc_w 367
      //   1740: aload 16
      //   1742: getfield 269	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggP	Ljavax/microedition/khronos/egl/EGL10;
      //   1745: invokeinterface 315 1 0
      //   1750: invokestatic 370	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:h	(Ljava/lang/String;Ljava/lang/String;I)V
      //   1753: iconst_0
      //   1754: istore 8
      //   1756: goto -328 -> 1428
      //   1759: aload 16
      //   1761: getfield 373	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggU	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1764: ifnull +30 -> 1794
      //   1767: aload 16
      //   1769: getfield 269	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggP	Ljavax/microedition/khronos/egl/EGL10;
      //   1772: aload 16
      //   1774: getfield 276	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggQ	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1777: aload 16
      //   1779: getfield 373	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggU	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1782: invokeinterface 377 3 0
      //   1787: pop
      //   1788: aload 16
      //   1790: aconst_null
      //   1791: putfield 373	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggU	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1794: iconst_1
      //   1795: istore 8
      //   1797: goto -369 -> 1428
      //   1800: astore 15
      //   1802: aload 16
      //   1804: monitorexit
      //   1805: ldc 106
      //   1807: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1810: aload 15
      //   1812: athrow
      //   1813: ldc 148
      //   1815: ldc_w 379
      //   1818: iconst_0
      //   1819: anewarray 97	java/lang/Object
      //   1822: invokestatic 239	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1825: invokestatic 95	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aef	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1828: astore 16
      //   1830: aload 16
      //   1832: monitorenter
      //   1833: aload_0
      //   1834: iconst_1
      //   1835: putfield 87	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghg	Z
      //   1838: aload_0
      //   1839: iconst_1
      //   1840: putfield 200	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghc	Z
      //   1843: invokestatic 95	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aef	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1846: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   1849: aload 16
      //   1851: monitorexit
      //   1852: iload_2
      //   1853: istore 8
      //   1855: iload_1
      //   1856: istore_2
      //   1857: iload 8
      //   1859: istore_1
      //   1860: goto -1784 -> 76
      //   1863: astore 15
      //   1865: aload 16
      //   1867: monitorexit
      //   1868: ldc 106
      //   1870: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1873: aload 15
      //   1875: athrow
      //   1876: ldc 148
      //   1878: ldc_w 381
      //   1881: iconst_0
      //   1882: anewarray 97	java/lang/Object
      //   1885: invokestatic 239	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1888: goto +529 -> 2417
      //   1891: iload_2
      //   1892: ifeq +443 -> 2335
      //   1895: ldc 148
      //   1897: new 150	java/lang/StringBuilder
      //   1900: dup
      //   1901: ldc_w 383
      //   1904: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1907: iload 10
      //   1909: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1912: ldc_w 388
      //   1915: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1918: iload 11
      //   1920: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1923: ldc_w 390
      //   1926: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1929: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1932: iconst_0
      //   1933: anewarray 97	java/lang/Object
      //   1936: invokestatic 258	com/tencent/mm/dynamicbackground/a/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1939: aload_0
      //   1940: getfield 74	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ggO	Ljava/lang/ref/WeakReference;
      //   1943: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1946: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   1949: astore 16
      //   1951: aload 16
      //   1953: ifnull +481 -> 2434
      //   1956: aload 16
      //   1958: invokestatic 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:g	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$n;
      //   1961: iload 10
      //   1963: iload 11
      //   1965: invokeinterface 394 3 0
      //   1970: ldc 148
      //   1972: ldc_w 396
      //   1975: iconst_0
      //   1976: anewarray 97	java/lang/Object
      //   1979: invokestatic 239	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1982: goto +452 -> 2434
      //   1985: aload_0
      //   1986: getfield 74	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ggO	Ljava/lang/ref/WeakReference;
      //   1989: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1992: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   1995: astore 16
      //   1997: aload 16
      //   1999: ifnull +13 -> 2012
      //   2002: aload 16
      //   2004: invokestatic 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:g	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$n;
      //   2007: invokeinterface 399 1 0
      //   2012: aload_0
      //   2013: getfield 74	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ggO	Ljava/lang/ref/WeakReference;
      //   2016: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   2019: pop
      //   2020: sipush 12288
      //   2023: istore 12
      //   2025: iconst_1
      //   2026: istore 14
      //   2028: aload_0
      //   2029: getfield 74	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ggO	Ljava/lang/ref/WeakReference;
      //   2032: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   2035: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   2038: astore 16
      //   2040: aload 16
      //   2042: ifnull +10 -> 2052
      //   2045: aload 16
      //   2047: invokevirtual 402	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:getIsSwapNow	()Z
      //   2050: istore 14
      //   2052: iload 14
      //   2054: ifeq +107 -> 2161
      //   2057: aload_0
      //   2058: getfield 112	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghn	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i;
      //   2061: astore 17
      //   2063: sipush 12288
      //   2066: istore 5
      //   2068: iload 5
      //   2070: istore 12
      //   2072: aload 17
      //   2074: getfield 276	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggQ	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   2077: ifnull +84 -> 2161
      //   2080: iload 5
      //   2082: istore 12
      //   2084: aload 17
      //   2086: getfield 276	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggQ	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   2089: getstatic 405	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   2092: if_acmpeq +69 -> 2161
      //   2095: iload 5
      //   2097: istore 12
      //   2099: aload 17
      //   2101: getfield 306	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggR	Ljavax/microedition/khronos/egl/EGLSurface;
      //   2104: ifnull +57 -> 2161
      //   2107: iload 5
      //   2109: istore 12
      //   2111: aload 17
      //   2113: getfield 306	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggR	Ljavax/microedition/khronos/egl/EGLSurface;
      //   2116: getstatic 311	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
      //   2119: if_acmpeq +42 -> 2161
      //   2122: iload 5
      //   2124: istore 12
      //   2126: aload 17
      //   2128: getfield 269	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggP	Ljavax/microedition/khronos/egl/EGL10;
      //   2131: aload 17
      //   2133: getfield 276	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggQ	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   2136: aload 17
      //   2138: getfield 306	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggR	Ljavax/microedition/khronos/egl/EGLSurface;
      //   2141: invokeinterface 408 3 0
      //   2146: ifne +15 -> 2161
      //   2149: aload 17
      //   2151: getfield 269	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:ggP	Ljavax/microedition/khronos/egl/EGL10;
      //   2154: invokeinterface 315 1 0
      //   2159: istore 12
      //   2161: aload 16
      //   2163: ifnull +276 -> 2439
      //   2166: aload 16
      //   2168: iconst_1
      //   2169: invokevirtual 412	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:setSwapNow	(Z)V
      //   2172: goto +267 -> 2439
      //   2175: ldc_w 414
      //   2178: ldc_w 415
      //   2181: iload 12
      //   2183: invokestatic 370	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:h	(Ljava/lang/String;Ljava/lang/String;I)V
      //   2186: invokestatic 95	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aef	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   2189: astore 16
      //   2191: aload 16
      //   2193: monitorenter
      //   2194: aload_0
      //   2195: iconst_1
      //   2196: putfield 200	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:ghc	Z
      //   2199: invokestatic 95	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aef	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   2202: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   2205: aload 16
      //   2207: monitorexit
      //   2208: iload 7
      //   2210: istore 5
      //   2212: iload 9
      //   2214: ifeq +110 -> 2324
      //   2217: iconst_1
      //   2218: istore 7
      //   2220: iconst_0
      //   2221: istore 6
      //   2223: aload_0
      //   2224: invokespecial 418	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aek	()V
      //   2227: iload 6
      //   2229: istore 9
      //   2231: iload_2
      //   2232: istore 12
      //   2234: iload 7
      //   2236: istore 6
      //   2238: iload 5
      //   2240: istore 7
      //   2242: iload_1
      //   2243: istore_2
      //   2244: iload 8
      //   2246: istore 5
      //   2248: iload 12
      //   2250: istore_1
      //   2251: goto -2175 -> 76
      //   2254: astore 15
      //   2256: ldc 148
      //   2258: ldc_w 396
      //   2261: iconst_0
      //   2262: anewarray 97	java/lang/Object
      //   2265: invokestatic 239	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2268: ldc 106
      //   2270: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2273: aload 15
      //   2275: athrow
      //   2276: ldc 148
      //   2278: new 150	java/lang/StringBuilder
      //   2281: dup
      //   2282: ldc_w 420
      //   2285: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   2288: aload_0
      //   2289: invokevirtual 168	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   2292: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2295: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2298: iconst_0
      //   2299: anewarray 97	java/lang/Object
      //   2302: invokestatic 180	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2305: iconst_1
      //   2306: istore 5
      //   2308: goto -96 -> 2212
      //   2311: astore 15
      //   2313: aload 16
      //   2315: monitorexit
      //   2316: ldc 106
      //   2318: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2321: aload 15
      //   2323: athrow
      //   2324: iload 6
      //   2326: istore 7
      //   2328: iload 9
      //   2330: istore 6
      //   2332: goto -109 -> 2223
      //   2335: goto -350 -> 1985
      //   2338: goto -837 -> 1501
      //   2341: iload 4
      //   2343: istore 11
      //   2345: iload_2
      //   2346: istore 10
      //   2348: iload 7
      //   2350: istore_2
      //   2351: iload 13
      //   2353: istore 6
      //   2355: iload 12
      //   2357: istore 7
      //   2359: iload 5
      //   2361: istore 4
      //   2363: iload 8
      //   2365: istore 5
      //   2367: goto -2209 -> 158
      //   2370: iload 11
      //   2372: istore 4
      //   2374: iload 10
      //   2376: istore_2
      //   2377: iload 6
      //   2379: istore 5
      //   2381: goto -1380 -> 1001
      //   2384: goto -1267 -> 1117
      //   2387: aconst_null
      //   2388: astore 17
      //   2390: goto -769 -> 1621
      //   2393: iload 6
      //   2395: istore_3
      //   2396: goto -1525 -> 871
      //   2399: iconst_0
      //   2400: istore 8
      //   2402: goto -974 -> 1428
      //   2405: iconst_0
      //   2406: istore 4
      //   2408: goto -907 -> 1501
      //   2411: iconst_0
      //   2412: istore 8
      //   2414: goto -780 -> 1634
      //   2417: iconst_0
      //   2418: istore_3
      //   2419: iload_2
      //   2420: istore 12
      //   2422: iload_1
      //   2423: istore_2
      //   2424: iload 8
      //   2426: istore 5
      //   2428: iload 12
      //   2430: istore_1
      //   2431: goto -2355 -> 76
      //   2434: iconst_0
      //   2435: istore_2
      //   2436: goto -451 -> 1985
      //   2439: iload 7
      //   2441: istore 5
      //   2443: iload 12
      //   2445: lookupswitch	default:+27->2472, 12288:+-233->2212, 12302:+-169->2276
      //   2473: impdep1
      //   2474: <illegal opcode>
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2475	0	this	j
      //   75	2356	1	i	int
      //   64	2372	2	j	int
      //   47	2372	3	k	int
      //   49	2358	4	m	int
      //   52	2390	5	n	int
      //   61	2333	6	i1	int
      //   55	2385	7	i2	int
      //   85	2340	8	i3	int
      //   58	2271	9	i4	int
      //   66	2309	10	i5	int
      //   69	2302	11	i6	int
      //   345	2099	12	i7	int
      //   600	1752	13	i8	int
      //   188	1865	14	bool	boolean
      //   33	142	15	localObject1	Object
      //   719	11	15	localObject2	Object
      //   732	5	15	localThrowable	Throwable
      //   757	8	15	localGameGLSurfaceView	GameGLSurfaceView
      //   821	14	15	localRuntimeException1	RuntimeException
      //   1079	14	15	localRuntimeException2	RuntimeException
      //   1244	8	15	localRuntimeException3	RuntimeException
      //   1254	8	15	localObject3	Object
      //   1282	36	15	localRuntimeException4	RuntimeException
      //   1800	11	15	localObject4	Object
      //   1863	11	15	localObject5	Object
      //   2254	20	15	localObject6	Object
      //   2311	11	15	localObject7	Object
      //   79	21	16	localk	GameGLSurfaceView.k
      //   108	614	16	localObject8	Object
      //   230	2159	17	localObject10	Object
      // Exception table:
      //   from	to	target	type
      //   38	46	108	finally
      //   110	113	108	finally
      //   92	102	719	finally
      //   121	158	719	finally
      //   158	161	719	finally
      //   190	215	719	finally
      //   220	232	719	finally
      //   237	247	719	finally
      //   247	293	719	finally
      //   293	341	719	finally
      //   352	360	719	finally
      //   368	407	719	finally
      //   412	431	719	finally
      //   444	476	719	finally
      //   476	529	719	finally
      //   529	545	719	finally
      //   545	598	719	finally
      //   607	640	719	finally
      //   643	654	719	finally
      //   654	672	719	finally
      //   689	701	719	finally
      //   706	716	719	finally
      //   721	724	719	finally
      //   780	787	719	finally
      //   790	797	719	finally
      //   797	808	719	finally
      //   823	837	719	finally
      //   837	844	719	finally
      //   847	865	719	finally
      //   882	889	719	finally
      //   900	923	719	finally
      //   932	946	719	finally
      //   949	993	719	finally
      //   996	1001	719	finally
      //   1001	1018	719	finally
      //   1055	1062	719	finally
      //   1062	1067	719	finally
      //   1070	1076	719	finally
      //   1081	1095	719	finally
      //   1095	1106	719	finally
      //   1117	1145	719	finally
      //   1156	1162	719	finally
      //   76	84	732	java/lang/Throwable
      //   166	173	732	java/lang/Throwable
      //   724	732	732	java/lang/Throwable
      //   1178	1254	732	java/lang/Throwable
      //   1264	1292	732	java/lang/Throwable
      //   1292	1320	732	java/lang/Throwable
      //   1320	1338	732	java/lang/Throwable
      //   1343	1378	732	java/lang/Throwable
      //   1378	1397	732	java/lang/Throwable
      //   1397	1425	732	java/lang/Throwable
      //   1433	1441	732	java/lang/Throwable
      //   1459	1483	732	java/lang/Throwable
      //   1488	1498	732	java/lang/Throwable
      //   1510	1551	732	java/lang/Throwable
      //   1556	1576	732	java/lang/Throwable
      //   1576	1586	732	java/lang/Throwable
      //   1589	1599	732	java/lang/Throwable
      //   1602	1621	732	java/lang/Throwable
      //   1621	1631	732	java/lang/Throwable
      //   1638	1646	732	java/lang/Throwable
      //   1650	1674	732	java/lang/Throwable
      //   1679	1689	732	java/lang/Throwable
      //   1692	1698	732	java/lang/Throwable
      //   1701	1753	732	java/lang/Throwable
      //   1759	1794	732	java/lang/Throwable
      //   1805	1813	732	java/lang/Throwable
      //   1813	1833	732	java/lang/Throwable
      //   1868	1876	732	java/lang/Throwable
      //   1876	1888	732	java/lang/Throwable
      //   1895	1951	732	java/lang/Throwable
      //   1970	1982	732	java/lang/Throwable
      //   1985	1997	732	java/lang/Throwable
      //   2002	2012	732	java/lang/Throwable
      //   2012	2020	732	java/lang/Throwable
      //   2028	2040	732	java/lang/Throwable
      //   2045	2052	732	java/lang/Throwable
      //   2057	2063	732	java/lang/Throwable
      //   2072	2080	732	java/lang/Throwable
      //   2084	2095	732	java/lang/Throwable
      //   2099	2107	732	java/lang/Throwable
      //   2111	2122	732	java/lang/Throwable
      //   2126	2161	732	java/lang/Throwable
      //   2166	2172	732	java/lang/Throwable
      //   2175	2194	732	java/lang/Throwable
      //   2223	2227	732	java/lang/Throwable
      //   2256	2276	732	java/lang/Throwable
      //   2276	2305	732	java/lang/Throwable
      //   2316	2324	732	java/lang/Throwable
      //   790	797	821	java/lang/RuntimeException
      //   1055	1062	1079	java/lang/RuntimeException
      //   76	84	1254	finally
      //   166	173	1254	finally
      //   724	732	1254	finally
      //   734	759	1254	finally
      //   764	774	1254	finally
      //   1178	1254	1254	finally
      //   1264	1292	1254	finally
      //   1292	1320	1254	finally
      //   1320	1338	1254	finally
      //   1343	1378	1254	finally
      //   1378	1397	1254	finally
      //   1397	1425	1254	finally
      //   1433	1441	1254	finally
      //   1459	1483	1254	finally
      //   1488	1498	1254	finally
      //   1510	1551	1254	finally
      //   1556	1576	1254	finally
      //   1576	1586	1254	finally
      //   1589	1599	1254	finally
      //   1602	1621	1254	finally
      //   1621	1631	1254	finally
      //   1638	1646	1254	finally
      //   1650	1674	1254	finally
      //   1679	1689	1254	finally
      //   1692	1698	1254	finally
      //   1701	1753	1254	finally
      //   1759	1794	1254	finally
      //   1805	1813	1254	finally
      //   1813	1833	1254	finally
      //   1868	1876	1254	finally
      //   1876	1888	1254	finally
      //   1895	1951	1254	finally
      //   1970	1982	1254	finally
      //   1985	1997	1254	finally
      //   2002	2012	1254	finally
      //   2012	2020	1254	finally
      //   2028	2040	1254	finally
      //   2045	2052	1254	finally
      //   2057	2063	1254	finally
      //   2072	2080	1254	finally
      //   2084	2095	1254	finally
      //   2099	2107	1254	finally
      //   2111	2122	1254	finally
      //   2126	2161	1254	finally
      //   2166	2172	1254	finally
      //   2175	2194	1254	finally
      //   2223	2227	1254	finally
      //   2256	2276	1254	finally
      //   2276	2305	1254	finally
      //   2316	2324	1254	finally
      //   1441	1455	1800	finally
      //   1802	1805	1800	finally
      //   1833	1852	1863	finally
      //   1865	1868	1863	finally
      //   1956	1970	2254	finally
      //   2194	2208	2311	finally
      //   2313	2316	2311	finally
    }
    
    private void aek()
    {
      AppMethodBeat.i(103041);
      Runnable localRunnable = null;
      label207:
      for (;;)
      {
        synchronized (GameGLSurfaceView.aef())
        {
          if (!aem())
          {
            AppMethodBeat.o(103041);
            return;
          }
          if (this.ggZ)
          {
            this.ggZ = false;
            c.i("MicroMsg.GLThread", "Request leave PAUSE_ALSO_DO_DRAW", new Object[0]);
            AppMethodBeat.o(103041);
            return;
          }
          if (this.ghl.isEmpty()) {
            break label207;
          }
          localRunnable = (Runnable)this.ghl.remove(0);
          if (localRunnable != null)
          {
            localRunnable.run();
            localRunnable = null;
          }
        }
        ??? = (GameGLSurfaceView)this.ggO.get();
        if (??? != null) {
          try
          {
            GameGLSurfaceView.g((GameGLSurfaceView)???).adZ();
          }
          catch (Exception localException)
          {
            c.e("MicroMsg.GLThread", Log.getStackTraceString(localException) + " readyToPauseAlsoDoDraw while() ", new Object[0]);
          }
        } else {
          synchronized (GameGLSurfaceView.aef())
          {
            this.ggV = true;
            AppMethodBeat.o(103041);
            return;
          }
        }
      }
    }
    
    private boolean aem()
    {
      return (this.Ct) && (this.gha) && (this.mWidth > 0) && (this.mHeight > 0) && ((!this.ghi) || (this.mRenderMode == 1));
    }
    
    final boolean ael()
    {
      return (!this.Ct) && (this.ghb) && (!this.ghc) && (this.mWidth > 0) && (this.mHeight > 0) && ((this.ghi) || (this.mRenderMode == 1));
    }
    
    public final void aen()
    {
      AppMethodBeat.i(103044);
      synchronized (GameGLSurfaceView.aef())
      {
        c.i("MicroMsg.GLThread", "requestExitAndWaitForDestory tid=" + getId(), new Object[0]);
        this.ggV = true;
        this.ggX = true;
        this.ggZ = true;
        GameGLSurfaceView.aef().notifyAll();
        for (;;)
        {
          boolean bool = this.ggW;
          if (!bool) {
            try
            {
              GameGLSurfaceView.aef().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
      AppMethodBeat.o(103044);
    }
    
    public final int getRenderMode()
    {
      AppMethodBeat.i(103043);
      synchronized (GameGLSurfaceView.aef())
      {
        int i = this.mRenderMode;
        AppMethodBeat.o(103043);
        return i;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(103038);
      setName("MicroMsg.GLThread" + getId());
      c.i("MicroMsg.GLThread", "starting tid=" + getId(), new Object[0]);
      try
      {
        aej();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        c.printErrStackTrace("MicroMsg.GLThread", localInterruptedException, "InterruptedException", new Object[0]);
        return;
      }
      catch (Throwable localThrowable)
      {
        c.e("MicroMsg.GLThread", "alvinluo GLThread#run() stack = [%s]", new Object[] { Log.getStackTraceString(localThrowable) });
        GameGLSurfaceView localGameGLSurfaceView = (GameGLSurfaceView)this.ggO.get();
        if (localGameGLSurfaceView != null) {
          GameGLSurfaceView.g(localGameGLSurfaceView).aea();
        }
        return;
      }
      finally
      {
        GameGLSurfaceView.aef().f(this);
        AppMethodBeat.o(103038);
      }
    }
    
    public final void setRenderMode(int paramInt)
    {
      AppMethodBeat.i(103042);
      if ((paramInt < 0) || (paramInt > 1))
      {
        ??? = new IllegalArgumentException("renderMode");
        AppMethodBeat.o(103042);
        throw ((Throwable)???);
      }
      synchronized (GameGLSurfaceView.aef())
      {
        this.mRenderMode = paramInt;
        GameGLSurfaceView.aef().notifyAll();
        AppMethodBeat.o(103042);
        return;
      }
    }
  }
  
  static final class k
  {
    private static String TAG = "GLThreadManager";
    
    public final void f(GameGLSurfaceView.j paramj)
    {
      for (;;)
      {
        GameGLSurfaceView.i locali;
        try
        {
          AppMethodBeat.i(103047);
          c.i("MicroMsg.GLThread", "exiting tid=" + paramj.getId(), new Object[0]);
          localGameGLSurfaceView1 = (GameGLSurfaceView)GameGLSurfaceView.j.a(paramj).get();
          if (localGameGLSurfaceView1 != null)
          {
            GameGLSurfaceView.g(localGameGLSurfaceView1).onDestroy();
            locali = GameGLSurfaceView.j.b(paramj);
            c.w("MicroMsg.GLThread", "destroySurface()  tid=" + Thread.currentThread().getId(), new Object[0]);
            locali.aeg();
            GameGLSurfaceView.j.c(paramj);
            GameGLSurfaceView.j.d(paramj);
          }
        }
        finally {}
        try
        {
          locali = GameGLSurfaceView.j.b(paramj);
          c.w("MicroMsg.GLThread", "finish() tid=" + Thread.currentThread().getId(), new Object[0]);
          if (locali.ggT != null)
          {
            GameGLSurfaceView localGameGLSurfaceView2 = (GameGLSurfaceView)locali.ggO.get();
            if (localGameGLSurfaceView2 != null) {
              GameGLSurfaceView.c(localGameGLSurfaceView2).destroyContext(locali.ggP, locali.ggQ, locali.ggT);
            }
            locali.ggT = null;
          }
          if (locali.ggQ != null)
          {
            locali.ggP.eglTerminate(locali.ggQ);
            locali.ggQ = null;
          }
        }
        catch (Throwable localThrowable)
        {
          c.e(TAG, "alvinluo GLThread#threadExiting finish stack = [%s]", new Object[] { Log.getStackTraceString(localThrowable) });
          if (localGameGLSurfaceView1 == null) {
            continue;
          }
          GameGLSurfaceView.g(localGameGLSurfaceView1).aea();
          continue;
        }
        GameGLSurfaceView.j.e(paramj);
        notifyAll();
        AppMethodBeat.o(103047);
        return;
        c.i("MicroMsg.GLThread", "onFinalize:view = null", new Object[0]);
      }
    }
  }
  
  public static abstract interface l
  {
    public abstract GL aeo();
  }
  
  public static abstract interface n
  {
    public abstract void adW();
    
    public abstract void adX();
    
    public abstract void adZ();
    
    public abstract void aea();
    
    public abstract void cu(int paramInt1, int paramInt2);
    
    public abstract void onDestroy();
    
    public abstract void onPause();
    
    public abstract void onResume();
  }
  
  final class o
    extends GameGLSurfaceView.b
  {
    public o()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.view.GameGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */