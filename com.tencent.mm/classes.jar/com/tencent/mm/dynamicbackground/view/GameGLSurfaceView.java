package com.tencent.mm.dynamicbackground.view;

import android.content.Context;
import android.opengl.EGL14;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.a.c;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

public class GameGLSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback2
{
  private static final k jCy;
  public j jCA;
  private o jCB;
  private e jCC;
  private f jCD;
  private h jCE;
  private m jCF;
  private boolean jCG;
  private int jCH;
  private int jCI;
  private boolean jCJ;
  private AtomicBoolean jCw;
  private l jCx;
  private final WeakReference<GameGLSurfaceView> jCz;
  private boolean mDetached;
  
  static
  {
    AppMethodBeat.i(103073);
    jCy = new k((byte)0);
    AppMethodBeat.o(103073);
  }
  
  public GameGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103053);
    this.jCw = new AtomicBoolean(false);
    this.jCz = new WeakReference(this);
    this.jCG = false;
    init();
    AppMethodBeat.o(103053);
  }
  
  public GameGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(213970);
    this.jCw = new AtomicBoolean(false);
    this.jCz = new WeakReference(this);
    this.jCG = false;
    init();
    AppMethodBeat.o(213970);
  }
  
  private void aAS()
  {
    AppMethodBeat.i(103072);
    if (this.jCA != null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
      AppMethodBeat.o(103072);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(103072);
  }
  
  private void init()
  {
    AppMethodBeat.i(213971);
    getHolder().addCallback(this);
    AppMethodBeat.o(213971);
  }
  
  public final void aAQ()
  {
    AppMethodBeat.i(213974);
    this.jCA = new j(this.jCz);
    this.jCA.jDc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213886);
        if (GameGLSurfaceView.a(GameGLSurfaceView.this) != null) {
          GameGLSurfaceView.a(GameGLSurfaceView.this);
        }
        GameGLSurfaceView.b(GameGLSurfaceView.this).set(true);
        AppMethodBeat.o(213886);
      }
    };
    this.jCA.start();
    AppMethodBeat.o(213974);
  }
  
  public final void aAR()
  {
    AppMethodBeat.i(103060);
    setEGLConfigChooser(new b());
    AppMethodBeat.o(103060);
  }
  
  public int getDebugFlags()
  {
    return this.jCH;
  }
  
  public javax.microedition.khronos.egl.EGLContext getEGLContext()
  {
    AppMethodBeat.i(213977);
    javax.microedition.khronos.egl.EGLContext localEGLContext = j.a(this.jCA).jCZ;
    AppMethodBeat.o(213977);
    return localEGLContext;
  }
  
  public long getEGLContextNativeHandle()
  {
    AppMethodBeat.i(213978);
    long l = j.a(this.jCA).nativeHandle;
    AppMethodBeat.o(213978);
    return l;
  }
  
  public boolean getIsSwapNow()
  {
    return this.jCG;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.jCJ;
  }
  
  public int getRenderMode()
  {
    AppMethodBeat.i(103063);
    int i = this.jCA.getRenderMode();
    AppMethodBeat.o(103063);
    return i;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(103070);
    super.onAttachedToWindow();
    c.i("MicroMsg.GameGLSurfaceView", "onAttachedToWindow reattach =" + this.mDetached, new Object[0]);
    if ((this.mDetached) && (this.jCB != null)) {
      if (this.jCA == null) {
        break label112;
      }
    }
    label112:
    for (int i = this.jCA.getRenderMode();; i = 1)
    {
      this.jCA = new j(this.jCz);
      if (i != 1) {
        this.jCA.setRenderMode(i);
      }
      this.jCA.start();
      this.mDetached = false;
      AppMethodBeat.o(103070);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(103071);
    c.i("MicroMsg.GameGLSurfaceView", "onDetachedFromWindow", new Object[0]);
    if (this.jCA != null) {
      this.jCA.aAZ();
    }
    this.mDetached = true;
    super.onDetachedFromWindow();
    AppMethodBeat.o(103071);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(103068);
    j localj = this.jCA;
    c.i("MicroMsg.GLThread", "onPause before ui lock tid=" + localj.getId(), new Object[0]);
    synchronized (localj.jDt)
    {
      c.i("MicroMsg.GLThread", "onPause ui lock tid=" + localj.getId(), new Object[0]);
      localj.jDh = true;
      c.i("MicroMsg.GLThread", "onPause send command tid=" + localj.getId(), new Object[0]);
      if (localj.jDd.isAlive()) {
        localj.jDe.sendEmptyMessage(2);
      }
      AppMethodBeat.o(103068);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(103069);
    c.i("MicroMsg.GameGLSurfaceView", "onResume", new Object[0]);
    j localj = this.jCA;
    if (localj.jDd.isAlive()) {
      localj.jDe.sendEmptyMessage(3);
    }
    AppMethodBeat.o(103069);
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.jCH = paramInt;
  }
  
  public void setEGLConfigChooser(e parame)
  {
    AppMethodBeat.i(103058);
    aAS();
    this.jCC = parame;
    AppMethodBeat.o(103058);
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    AppMethodBeat.i(103059);
    setEGLConfigChooser(new p());
    AppMethodBeat.o(103059);
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    AppMethodBeat.i(103061);
    aAS();
    this.jCI = paramInt;
    AppMethodBeat.o(103061);
  }
  
  public void setEGLContextFactory(f paramf)
  {
    AppMethodBeat.i(103056);
    aAS();
    this.jCD = paramf;
    AppMethodBeat.o(103056);
  }
  
  public void setEGLWindowSurfaceFactory(h paramh)
  {
    AppMethodBeat.i(103057);
    aAS();
    this.jCE = paramh;
    AppMethodBeat.o(103057);
  }
  
  public void setFps(int paramInt) {}
  
  public void setGLWrapper(m paramm)
  {
    this.jCF = paramm;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.jCJ = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(103062);
    this.jCA.setRenderMode(paramInt);
    AppMethodBeat.o(103062);
  }
  
  public void setRenderer(o paramo)
  {
    AppMethodBeat.i(103055);
    aAS();
    if (this.jCC == null) {
      this.jCC = new p();
    }
    if (this.jCD == null) {
      this.jCD = new c((byte)0);
    }
    if (this.jCE == null) {
      this.jCE = new GameGLSurfaceView.d((byte)0);
    }
    this.jCB = paramo;
    AppMethodBeat.o(103055);
  }
  
  public void setSwapNow(boolean paramBoolean)
  {
    this.jCG = paramBoolean;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(103066);
    paramSurfaceHolder = this.jCA;
    if (paramSurfaceHolder.jDd.isAlive())
    {
      Message localMessage = Message.obtain();
      localMessage.what = 4;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      paramSurfaceHolder.jDe.sendMessage(localMessage);
    }
    AppMethodBeat.o(103066);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(103064);
    c.i("MicroMsg.GameGLSurfaceView", "alvinluo GameGLSurfaceView surfaceCreated", new Object[0]);
    paramSurfaceHolder = this.jCA;
    if (paramSurfaceHolder.jDd.isAlive()) {
      paramSurfaceHolder.jDe.sendEmptyMessage(0);
    }
    AppMethodBeat.o(103064);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(103065);
    paramSurfaceHolder = this.jCA;
    if (paramSurfaceHolder.jDd.isAlive()) {
      paramSurfaceHolder.jDe.sendEmptyMessage(1);
    }
    AppMethodBeat.o(103065);
  }
  
  public void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(103067);
    c.i("MicroMsg.GameGLSurfaceView", "surfaceRedrawNeeded", new Object[0]);
    if (this.jCA != null)
    {
      paramSurfaceHolder = this.jCA;
      if (paramSurfaceHolder.jDd.isAlive()) {
        paramSurfaceHolder.jDe.sendEmptyMessage(6);
      }
    }
    AppMethodBeat.o(103067);
  }
  
  abstract class a
    implements GameGLSurfaceView.e
  {
    protected int[] jCL;
    
    public a(int[] paramArrayOfInt)
    {
      if ((GameGLSurfaceView.c(GameGLSurfaceView.this) != 2) && (GameGLSurfaceView.c(GameGLSurfaceView.this) != 3))
      {
        this.jCL = paramArrayOfInt;
        return;
      }
      this$1 = new int[15];
      System.arraycopy(paramArrayOfInt, 0, GameGLSurfaceView.this, 0, 12);
      GameGLSurfaceView.this[12] = 12352;
      if (GameGLSurfaceView.c(GameGLSurfaceView.this) == 2) {
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
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.jCL, null, 0, arrayOfInt)) {
        throw new IllegalArgumentException("eglChooseConfig failed");
      }
      int i = arrayOfInt[0];
      if (i <= 0) {
        throw new IllegalArgumentException("No configs match configSpec");
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.jCL, arrayOfEGLConfig, i, arrayOfInt)) {
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
    private int[] jCM;
    protected int jCN;
    protected int jCO;
    protected int jCP;
    protected int jCQ;
    protected int jCR;
    protected int jCS;
    
    public b()
    {
      super(new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 8, 12344 });
      AppMethodBeat.i(102978);
      this.jCM = new int[1];
      this.jCN = 8;
      this.jCO = 8;
      this.jCP = 8;
      this.jCQ = 8;
      this.jCR = 16;
      this.jCS = 8;
      AppMethodBeat.o(102978);
    }
    
    private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
    {
      AppMethodBeat.i(102980);
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.jCM))
      {
        paramInt = this.jCM[0];
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
        if ((k >= this.jCR) && (m >= this.jCS))
        {
          k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
          m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
          int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
          int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
          if ((k == this.jCN) && (m == this.jCO) && (n == this.jCP) && (i1 == this.jCQ))
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
    private int jCT = 12440;
    
    private c() {}
    
    public final javax.microedition.khronos.egl.EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, javax.microedition.khronos.egl.EGLContext paramEGLContext)
    {
      AppMethodBeat.i(102981);
      c.i("MicroMsg.GLThread", "createContext", new Object[0]);
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = this.jCT;
      arrayOfInt[1] = GameGLSurfaceView.c(GameGLSurfaceView.this);
      arrayOfInt[2] = 12344;
      if (GameGLSurfaceView.c(GameGLSurfaceView.this) != 0) {}
      for (;;)
      {
        paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, paramEGLContext, arrayOfInt);
        AppMethodBeat.o(102981);
        return paramEGL10;
        arrayOfInt = null;
      }
    }
    
    public final void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, javax.microedition.khronos.egl.EGLContext paramEGLContext)
    {
      AppMethodBeat.i(102982);
      c.i("MicroMsg.GLThread", " destroyContext tid=" + Thread.currentThread().getId(), new Object[0]);
      if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
      {
        c.e("MicroMsg.GLThread", "display:" + paramEGLDisplay + " context: " + paramEGLContext, new Object[0]);
        GameGLSurfaceView.i.ag("eglDestroyContex", paramEGL10.eglGetError());
      }
      AppMethodBeat.o(102982);
    }
  }
  
  public static abstract interface e
  {
    public abstract EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay);
  }
  
  public static abstract interface f
  {
    public abstract javax.microedition.khronos.egl.EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, javax.microedition.khronos.egl.EGLContext paramEGLContext);
    
    public abstract void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, javax.microedition.khronos.egl.EGLContext paramEGLContext);
  }
  
  public static final class g
    implements EGL11
  {
    public static String getErrorString(int paramInt)
    {
      AppMethodBeat.i(103030);
      switch (paramInt)
      {
      default: 
        String str = "0x" + Integer.toHexString(paramInt);
        AppMethodBeat.o(103030);
        return str;
      case 12288: 
        AppMethodBeat.o(103030);
        return "EGL_SUCCESS";
      case 12289: 
        AppMethodBeat.o(103030);
        return "EGL_NOT_INITIALIZED";
      case 12290: 
        AppMethodBeat.o(103030);
        return "EGL_BAD_ACCESS";
      case 12291: 
        AppMethodBeat.o(103030);
        return "EGL_BAD_ALLOC";
      case 12292: 
        AppMethodBeat.o(103030);
        return "EGL_BAD_ATTRIBUTE";
      case 12293: 
        AppMethodBeat.o(103030);
        return "EGL_BAD_CONFIG";
      case 12294: 
        AppMethodBeat.o(103030);
        return "EGL_BAD_CONTEXT";
      case 12295: 
        AppMethodBeat.o(103030);
        return "EGL_BAD_CURRENT_SURFACE";
      case 12296: 
        AppMethodBeat.o(103030);
        return "EGL_BAD_DISPLAY";
      case 12297: 
        AppMethodBeat.o(103030);
        return "EGL_BAD_MATCH";
      case 12298: 
        AppMethodBeat.o(103030);
        return "EGL_BAD_NATIVE_PIXMAP";
      case 12299: 
        AppMethodBeat.o(103030);
        return "EGL_BAD_NATIVE_WINDOW";
      case 12300: 
        AppMethodBeat.o(103030);
        return "EGL_BAD_PARAMETER";
      case 12301: 
        AppMethodBeat.o(103030);
        return "EGL_BAD_SURFACE";
      }
      AppMethodBeat.o(103030);
      return "EGL_CONTEXT_LOST";
    }
    
    public final boolean eglChooseConfig(EGLDisplay paramEGLDisplay, int[] paramArrayOfInt1, EGLConfig[] paramArrayOfEGLConfig, int paramInt, int[] paramArrayOfInt2)
    {
      AppMethodBeat.i(102985);
      AppMethodBeat.o(102985);
      throw null;
    }
    
    public final boolean eglCopyBuffers(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface, Object paramObject)
    {
      AppMethodBeat.i(102986);
      AppMethodBeat.o(102986);
      throw null;
    }
    
    public final javax.microedition.khronos.egl.EGLContext eglCreateContext(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, javax.microedition.khronos.egl.EGLContext paramEGLContext, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(102987);
      AppMethodBeat.o(102987);
      throw null;
    }
    
    public final EGLSurface eglCreatePbufferSurface(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(102988);
      AppMethodBeat.o(102988);
      throw null;
    }
    
    public final EGLSurface eglCreatePixmapSurface(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(102989);
      AppMethodBeat.o(102989);
      throw null;
    }
    
    public final EGLSurface eglCreateWindowSurface(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(102990);
      AppMethodBeat.o(102990);
      throw null;
    }
    
    public final boolean eglDestroyContext(EGLDisplay paramEGLDisplay, javax.microedition.khronos.egl.EGLContext paramEGLContext)
    {
      AppMethodBeat.i(102991);
      AppMethodBeat.o(102991);
      throw null;
    }
    
    public final boolean eglDestroySurface(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      AppMethodBeat.i(102992);
      AppMethodBeat.o(102992);
      throw null;
    }
    
    public final boolean eglGetConfigAttrib(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(102993);
      AppMethodBeat.o(102993);
      throw null;
    }
    
    public final boolean eglGetConfigs(EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig, int paramInt, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(102994);
      AppMethodBeat.o(102994);
      throw null;
    }
    
    public final javax.microedition.khronos.egl.EGLContext eglGetCurrentContext()
    {
      AppMethodBeat.i(102995);
      AppMethodBeat.o(102995);
      throw null;
    }
    
    public final EGLDisplay eglGetCurrentDisplay()
    {
      AppMethodBeat.i(102996);
      AppMethodBeat.o(102996);
      throw null;
    }
    
    public final EGLSurface eglGetCurrentSurface(int paramInt)
    {
      AppMethodBeat.i(102997);
      AppMethodBeat.o(102997);
      throw null;
    }
    
    public final EGLDisplay eglGetDisplay(Object paramObject)
    {
      AppMethodBeat.i(102998);
      AppMethodBeat.o(102998);
      throw null;
    }
    
    public final int eglGetError()
    {
      AppMethodBeat.i(102999);
      AppMethodBeat.o(102999);
      throw null;
    }
    
    public final boolean eglInitialize(EGLDisplay paramEGLDisplay, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(103000);
      AppMethodBeat.o(103000);
      throw null;
    }
    
    public final boolean eglMakeCurrent(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface1, EGLSurface paramEGLSurface2, javax.microedition.khronos.egl.EGLContext paramEGLContext)
    {
      AppMethodBeat.i(103001);
      AppMethodBeat.o(103001);
      throw null;
    }
    
    public final boolean eglQueryContext(EGLDisplay paramEGLDisplay, javax.microedition.khronos.egl.EGLContext paramEGLContext, int paramInt, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(103002);
      AppMethodBeat.o(103002);
      throw null;
    }
    
    public final String eglQueryString(EGLDisplay paramEGLDisplay, int paramInt)
    {
      AppMethodBeat.i(103003);
      AppMethodBeat.o(103003);
      throw null;
    }
    
    public final boolean eglQuerySurface(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface, int paramInt, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(103004);
      AppMethodBeat.o(103004);
      throw null;
    }
    
    public final boolean eglSwapBuffers(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      AppMethodBeat.i(103005);
      AppMethodBeat.o(103005);
      throw null;
    }
    
    public final boolean eglTerminate(EGLDisplay paramEGLDisplay)
    {
      AppMethodBeat.i(103006);
      AppMethodBeat.o(103006);
      throw null;
    }
    
    public final boolean eglWaitGL()
    {
      AppMethodBeat.i(103007);
      AppMethodBeat.o(103007);
      throw null;
    }
    
    public final boolean eglWaitNative(int paramInt, Object paramObject)
    {
      AppMethodBeat.i(103008);
      AppMethodBeat.o(103008);
      throw null;
    }
  }
  
  public static abstract interface h
  {
    public abstract EGLSurface b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject);
    
    public abstract void b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface);
  }
  
  static final class i
  {
    WeakReference<GameGLSurfaceView> jCU;
    EGL10 jCV;
    EGLDisplay jCW;
    EGLSurface jCX;
    EGLConfig jCY;
    javax.microedition.khronos.egl.EGLContext jCZ;
    EGLSurface jDa;
    long nativeHandle = -1L;
    
    public i(WeakReference<GameGLSurfaceView> paramWeakReference)
    {
      this.jCU = paramWeakReference;
    }
    
    public static void ag(String paramString, int paramInt)
    {
      AppMethodBeat.i(103034);
      paramString = ah(paramString, paramInt);
      c.e("MicroMsg.GLThread", "throwEglException tid=" + Thread.currentThread().getId() + " " + paramString, new Object[0]);
      paramString = new RuntimeException(paramString);
      AppMethodBeat.o(103034);
      throw paramString;
    }
    
    private static String ah(String paramString, int paramInt)
    {
      AppMethodBeat.i(103036);
      paramString = paramString + " failed: " + GameGLSurfaceView.g.getErrorString(paramInt);
      AppMethodBeat.o(103036);
      return paramString;
    }
    
    public static void g(String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(103035);
      c.w(paramString1, ah(paramString2, paramInt), new Object[0]);
      AppMethodBeat.o(103035);
    }
    
    final void aAU()
    {
      AppMethodBeat.i(103033);
      if ((this.jCX != null) && (this.jCX != EGL10.EGL_NO_SURFACE))
      {
        Object localObject = this.jCV;
        EGLDisplay localEGLDisplay = this.jCW;
        EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
        ((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
        localObject = (GameGLSurfaceView)this.jCU.get();
        if (localObject != null) {
          GameGLSurfaceView.f((GameGLSurfaceView)localObject).b(this.jCV, this.jCW, this.jCX);
        }
        this.jCX = null;
      }
      AppMethodBeat.o(103033);
    }
    
    public final void start()
    {
      AppMethodBeat.i(103032);
      c.w("MicroMsg.GLThread", "start() tid=" + Thread.currentThread().getId(), new Object[0]);
      this.jCV = ((EGL10)javax.microedition.khronos.egl.EGLContext.getEGL());
      this.jCW = this.jCV.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      if (this.jCW == EGL10.EGL_NO_DISPLAY)
      {
        localObject = new RuntimeException("eglGetDisplay failed");
        AppMethodBeat.o(103032);
        throw ((Throwable)localObject);
      }
      Object localObject = new int[2];
      if (!this.jCV.eglInitialize(this.jCW, (int[])localObject))
      {
        localObject = new RuntimeException("eglInitialize failed");
        AppMethodBeat.o(103032);
        throw ((Throwable)localObject);
      }
      localObject = (GameGLSurfaceView)this.jCU.get();
      if (localObject == null)
      {
        this.jCY = null;
        this.jCZ = null;
        c.w("MicroMsg.GameGLSurfaceView", "alvinluo EglHelper start but view is null and set mEglConfig = null, mEglContext = null", new Object[0]);
      }
      for (;;)
      {
        if ((this.jCZ == null) || (this.jCZ == EGL10.EGL_NO_CONTEXT))
        {
          this.jCZ = null;
          ag("createContext", this.jCV.eglGetError());
        }
        c.w("MicroMsg.GLThread", "createContext " + this.jCZ + " tid=" + Thread.currentThread().getId(), new Object[0]);
        this.jDa = this.jCV.eglCreatePbufferSurface(this.jCW, this.jCY, new int[] { 12375, 16, 12374, 16, 12344 });
        this.jCV.eglMakeCurrent(this.jCW, this.jDa, this.jDa, this.jCZ);
        this.nativeHandle = EGL14.eglGetCurrentContext().getNativeHandle();
        this.jCX = null;
        AppMethodBeat.o(103032);
        return;
        this.jCY = GameGLSurfaceView.d((GameGLSurfaceView)localObject).chooseConfig(this.jCV, this.jCW);
        c.i("MicroMsg.GameGLSurfaceView", "alvinluo EglHelper start chooseConfig end config: %s, display: %s", new Object[] { Integer.valueOf(this.jCY.hashCode()), Integer.valueOf(this.jCW.hashCode()) });
        this.jCZ = GameGLSurfaceView.e((GameGLSurfaceView)localObject).a(this.jCV, this.jCW, this.jCY, EGL10.EGL_NO_CONTEXT);
        c.i("MicroMsg.GameGLSurfaceView", "alvinluo EglHelper start createContext end", new Object[0]);
      }
    }
  }
  
  public static final class j
    extends Thread
  {
    private boolean arU;
    private boolean jAs;
    private WeakReference<GameGLSurfaceView> jCU;
    private Runnable jDb;
    Runnable jDc;
    HandlerThread jDd;
    a jDe;
    private boolean jDf;
    private boolean jDg;
    boolean jDh;
    private boolean jDi;
    private boolean jDj;
    private boolean jDk;
    private boolean jDl;
    private boolean jDm;
    private boolean jDn;
    private boolean jDo;
    private boolean jDp;
    private boolean jDq;
    private LinkedList<Runnable> jDr;
    private boolean jDs;
    final Object jDt;
    private GameGLSurfaceView.i jDu;
    private int mHeight;
    private int mRenderMode;
    private int mWidth;
    
    j(WeakReference<GameGLSurfaceView> paramWeakReference)
    {
      AppMethodBeat.i(103037);
      this.jDr = new LinkedList();
      this.jDs = true;
      this.jDt = new Object();
      this.mWidth = 0;
      this.mHeight = 0;
      this.jAs = true;
      this.mRenderMode = 1;
      this.jDp = false;
      this.jDd = new HandlerThread("MicroMsg.GLCommandThread" + getId());
      this.jDd.start();
      this.jDe = new a(this.jDd.getLooper());
      this.jCU = paramWeakReference;
      AppMethodBeat.o(103037);
    }
    
    private void aAV()
    {
      if (this.jDm)
      {
        this.jDm = false;
        this.jDn = false;
      }
    }
    
    private void aAW()
    {
      AppMethodBeat.i(103039);
      if (this.jDl)
      {
        this.jDl = false;
        GameGLSurfaceView.aAT().notifyAll();
      }
      AppMethodBeat.o(103039);
    }
    
    /* Error */
    private void aAX()
    {
      // Byte code:
      //   0: ldc 156
      //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: new 158	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i
      //   9: dup
      //   10: aload_0
      //   11: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jCU	Ljava/lang/ref/WeakReference;
      //   14: invokespecial 160	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:<init>	(Ljava/lang/ref/WeakReference;)V
      //   17: putfield 129	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDu	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i;
      //   20: aload_0
      //   21: iconst_0
      //   22: putfield 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDl	Z
      //   25: aload_0
      //   26: iconst_0
      //   27: putfield 135	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDm	Z
      //   30: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   33: astore 15
      //   35: aload 15
      //   37: monitorenter
      //   38: aload_0
      //   39: iconst_0
      //   40: putfield 81	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDp	Z
      //   43: aload 15
      //   45: monitorexit
      //   46: aload_0
      //   47: getfield 162	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDc	Ljava/lang/Runnable;
      //   50: ifnull +12 -> 62
      //   53: aload_0
      //   54: getfield 162	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDc	Ljava/lang/Runnable;
      //   57: invokeinterface 167 1 0
      //   62: iconst_0
      //   63: istore_3
      //   64: iconst_0
      //   65: istore_2
      //   66: iconst_0
      //   67: istore 6
      //   69: iconst_0
      //   70: istore 5
      //   72: iconst_0
      //   73: istore 9
      //   75: iconst_0
      //   76: istore 4
      //   78: iconst_0
      //   79: istore 7
      //   81: iconst_0
      //   82: istore 10
      //   84: iconst_0
      //   85: istore 11
      //   87: aconst_null
      //   88: astore 15
      //   90: iconst_0
      //   91: istore_1
      //   92: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   95: astore 16
      //   97: aload 16
      //   99: monitorenter
      //   100: iload_1
      //   101: istore 8
      //   103: iload 7
      //   105: istore_1
      //   106: iload_2
      //   107: istore 7
      //   109: iload 8
      //   111: istore_2
      //   112: aload_0
      //   113: getfield 169	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDf	Z
      //   116: ifeq +41 -> 157
      //   119: aload_0
      //   120: getfield 171	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDb	Ljava/lang/Runnable;
      //   123: ifnull +12 -> 135
      //   126: aload_0
      //   127: getfield 171	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDb	Ljava/lang/Runnable;
      //   130: invokeinterface 167 1 0
      //   135: aload 16
      //   137: monitorexit
      //   138: ldc 156
      //   140: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   143: return
      //   144: astore 16
      //   146: aload 15
      //   148: monitorexit
      //   149: ldc 156
      //   151: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   154: aload 16
      //   156: athrow
      //   157: aload_0
      //   158: getfield 173	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:arU	Z
      //   161: ifne +66 -> 227
      //   164: aload_0
      //   165: getfield 137	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDn	Z
      //   168: ifeq +59 -> 227
      //   171: aload_0
      //   172: getfield 64	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDr	Ljava/util/LinkedList;
      //   175: invokevirtual 177	java/util/LinkedList:isEmpty	()Z
      //   178: ifne +49 -> 227
      //   181: aload_0
      //   182: getfield 64	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDr	Ljava/util/LinkedList;
      //   185: iconst_0
      //   186: invokevirtual 181	java/util/LinkedList:remove	(I)Ljava/lang/Object;
      //   189: checkcast 164	java/lang/Runnable
      //   192: astore 15
      //   194: aload 16
      //   196: monitorexit
      //   197: aload 15
      //   199: ifnull +974 -> 1173
      //   202: aload 15
      //   204: invokeinterface 167 1 0
      //   209: aconst_null
      //   210: astore 15
      //   212: iload_2
      //   213: istore 8
      //   215: iload 7
      //   217: istore_2
      //   218: iload_1
      //   219: istore 7
      //   221: iload 8
      //   223: istore_1
      //   224: goto -132 -> 92
      //   227: iconst_0
      //   228: istore 14
      //   230: aload_0
      //   231: getfield 173	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:arU	Z
      //   234: aload_0
      //   235: getfield 183	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDh	Z
      //   238: if_icmpeq +95 -> 333
      //   241: aload_0
      //   242: getfield 183	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDh	Z
      //   245: istore 14
      //   247: aload_0
      //   248: aload_0
      //   249: getfield 183	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDh	Z
      //   252: putfield 173	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:arU	Z
      //   255: iload 14
      //   257: ifeq +472 -> 729
      //   260: aload_0
      //   261: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jCU	Ljava/lang/ref/WeakReference;
      //   264: invokevirtual 189	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   267: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   270: astore 17
      //   272: aload 17
      //   274: ifnull +13 -> 287
      //   277: aload 17
      //   279: invokestatic 192	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:i	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$o;
      //   282: invokeinterface 197 1 0
      //   287: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   290: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   293: ldc 199
      //   295: new 85	java/lang/StringBuilder
      //   298: dup
      //   299: ldc 201
      //   301: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   304: aload_0
      //   305: getfield 173	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:arU	Z
      //   308: invokevirtual 204	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   311: ldc 206
      //   313: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   316: aload_0
      //   317: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   320: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   323: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   326: iconst_0
      //   327: anewarray 68	java/lang/Object
      //   330: invokestatic 214	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   333: aload_0
      //   334: getfield 216	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDo	Z
      //   337: ifeq +46 -> 383
      //   340: ldc 199
      //   342: new 85	java/lang/StringBuilder
      //   345: dup
      //   346: ldc 218
      //   348: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   351: aload_0
      //   352: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   355: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   358: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   361: iconst_0
      //   362: anewarray 68	java/lang/Object
      //   365: invokestatic 214	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   368: aload_0
      //   369: invokespecial 220	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aAV	()V
      //   372: aload_0
      //   373: invokespecial 222	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aAW	()V
      //   376: aload_0
      //   377: iconst_0
      //   378: putfield 216	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDo	Z
      //   381: iconst_1
      //   382: istore_1
      //   383: iload 5
      //   385: istore 12
      //   387: iload 5
      //   389: ifeq +14 -> 403
      //   392: aload_0
      //   393: invokespecial 220	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aAV	()V
      //   396: aload_0
      //   397: invokespecial 222	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aAW	()V
      //   400: iconst_0
      //   401: istore 12
      //   403: iload 14
      //   405: ifeq +42 -> 447
      //   408: aload_0
      //   409: getfield 135	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDm	Z
      //   412: ifeq +35 -> 447
      //   415: ldc 199
      //   417: new 85	java/lang/StringBuilder
      //   420: dup
      //   421: ldc 224
      //   423: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   426: aload_0
      //   427: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   430: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   433: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   436: iconst_0
      //   437: anewarray 68	java/lang/Object
      //   440: invokestatic 214	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   443: aload_0
      //   444: invokespecial 220	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aAV	()V
      //   447: iload 14
      //   449: ifeq +67 -> 516
      //   452: aload_0
      //   453: getfield 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDl	Z
      //   456: ifeq +60 -> 516
      //   459: aload_0
      //   460: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jCU	Ljava/lang/ref/WeakReference;
      //   463: invokevirtual 189	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   466: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   469: astore 17
      //   471: aload 17
      //   473: ifnonnull +347 -> 820
      //   476: iconst_0
      //   477: istore 14
      //   479: iload 14
      //   481: ifne +35 -> 516
      //   484: aload_0
      //   485: invokespecial 222	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aAW	()V
      //   488: ldc 199
      //   490: new 85	java/lang/StringBuilder
      //   493: dup
      //   494: ldc 226
      //   496: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   499: aload_0
      //   500: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   503: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   506: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   509: iconst_0
      //   510: anewarray 68	java/lang/Object
      //   513: invokestatic 214	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   516: aload_0
      //   517: getfield 132	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDi	Z
      //   520: ifne +65 -> 585
      //   523: aload_0
      //   524: getfield 228	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDk	Z
      //   527: ifne +58 -> 585
      //   530: ldc 199
      //   532: new 85	java/lang/StringBuilder
      //   535: dup
      //   536: ldc 230
      //   538: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   541: aload_0
      //   542: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   545: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   548: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   551: iconst_0
      //   552: anewarray 68	java/lang/Object
      //   555: invokestatic 214	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   558: aload_0
      //   559: getfield 135	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDm	Z
      //   562: ifeq +7 -> 569
      //   565: aload_0
      //   566: invokespecial 220	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aAV	()V
      //   569: aload_0
      //   570: iconst_1
      //   571: putfield 228	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDk	Z
      //   574: aload_0
      //   575: iconst_0
      //   576: putfield 232	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDj	Z
      //   579: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   582: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   585: aload_0
      //   586: getfield 132	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDi	Z
      //   589: ifeq +49 -> 638
      //   592: aload_0
      //   593: getfield 228	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDk	Z
      //   596: ifeq +42 -> 638
      //   599: ldc 199
      //   601: new 85	java/lang/StringBuilder
      //   604: dup
      //   605: ldc 234
      //   607: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   610: aload_0
      //   611: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   614: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   617: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   620: iconst_0
      //   621: anewarray 68	java/lang/Object
      //   624: invokestatic 214	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   627: aload_0
      //   628: iconst_0
      //   629: putfield 228	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDk	Z
      //   632: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   635: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   638: iload 4
      //   640: istore 13
      //   642: iload 4
      //   644: ifeq +50 -> 694
      //   647: ldc 199
      //   649: new 85	java/lang/StringBuilder
      //   652: dup
      //   653: ldc 236
      //   655: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   658: aload_0
      //   659: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   662: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   665: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   668: iconst_0
      //   669: anewarray 68	java/lang/Object
      //   672: invokestatic 214	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   675: aload_0
      //   676: iconst_0
      //   677: putfield 81	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDp	Z
      //   680: iconst_0
      //   681: istore 13
      //   683: aload_0
      //   684: iconst_1
      //   685: putfield 238	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDq	Z
      //   688: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   691: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   694: aload_0
      //   695: getfield 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDl	Z
      //   698: ifne +179 -> 877
      //   701: ldc 199
      //   703: ldc 240
      //   705: iconst_0
      //   706: anewarray 68	java/lang/Object
      //   709: invokestatic 214	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   712: iload_1
      //   713: ifeq +117 -> 830
      //   716: iconst_0
      //   717: istore_1
      //   718: iload 13
      //   720: istore 4
      //   722: iload 12
      //   724: istore 5
      //   726: goto -532 -> 194
      //   729: aload_0
      //   730: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jCU	Ljava/lang/ref/WeakReference;
      //   733: invokevirtual 189	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   736: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   739: astore 17
      //   741: aload 17
      //   743: ifnull -456 -> 287
      //   746: aload 17
      //   748: invokestatic 192	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:i	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$o;
      //   751: invokeinterface 243 1 0
      //   756: goto -469 -> 287
      //   759: astore 15
      //   761: aload 16
      //   763: monitorexit
      //   764: ldc 156
      //   766: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   769: aload 15
      //   771: athrow
      //   772: astore 15
      //   774: ldc 199
      //   776: aload 15
      //   778: ldc 245
      //   780: iconst_0
      //   781: anewarray 68	java/lang/Object
      //   784: invokestatic 249	com/tencent/mm/dynamicbackground/a/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   787: aload_0
      //   788: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jCU	Ljava/lang/ref/WeakReference;
      //   791: invokevirtual 189	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   794: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   797: astore 15
      //   799: aload 15
      //   801: ifnull +13 -> 814
      //   804: aload 15
      //   806: invokestatic 192	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:i	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$o;
      //   809: invokeinterface 252 1 0
      //   814: ldc 156
      //   816: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   819: return
      //   820: aload 17
      //   822: invokestatic 255	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:j	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Z
      //   825: istore 14
      //   827: goto -348 -> 479
      //   830: aload_0
      //   831: getfield 129	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDu	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i;
      //   834: invokevirtual 256	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:start	()V
      //   837: aload_0
      //   838: iconst_1
      //   839: putfield 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDl	Z
      //   842: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   845: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   848: iconst_1
      //   849: istore_3
      //   850: iload 13
      //   852: istore 4
      //   854: iload 12
      //   856: istore 5
      //   858: goto -664 -> 194
      //   861: astore 15
      //   863: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   866: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   869: ldc 156
      //   871: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   874: aload 15
      //   876: athrow
      //   877: aload_0
      //   878: invokespecial 259	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aAY	()Z
      //   881: ifeq +1649 -> 2530
      //   884: iload_3
      //   885: istore 4
      //   887: aload_0
      //   888: getfield 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDl	Z
      //   891: ifne +1648 -> 2539
      //   894: ldc 199
      //   896: ldc 240
      //   898: iconst_0
      //   899: anewarray 68	java/lang/Object
      //   902: invokestatic 214	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   905: iload_1
      //   906: ifeq +187 -> 1093
      //   909: iconst_0
      //   910: istore_1
      //   911: iload_2
      //   912: istore 5
      //   914: iload 7
      //   916: istore 4
      //   918: iload 6
      //   920: istore 8
      //   922: aload_0
      //   923: getfield 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDl	Z
      //   926: ifeq +47 -> 973
      //   929: iload_2
      //   930: istore 5
      //   932: iload 7
      //   934: istore 4
      //   936: iload 6
      //   938: istore 8
      //   940: aload_0
      //   941: getfield 135	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDm	Z
      //   944: ifne +29 -> 973
      //   947: ldc 199
      //   949: ldc_w 261
      //   952: iconst_0
      //   953: anewarray 68	java/lang/Object
      //   956: invokestatic 214	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   959: aload_0
      //   960: iconst_1
      //   961: putfield 135	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDm	Z
      //   964: iconst_1
      //   965: istore 4
      //   967: iconst_1
      //   968: istore 8
      //   970: iconst_1
      //   971: istore 5
      //   973: aload_0
      //   974: getfield 135	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDm	Z
      //   977: ifeq +156 -> 1133
      //   980: aload_0
      //   981: getfield 66	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDs	Z
      //   984: ifeq +1532 -> 2516
      //   987: iconst_1
      //   988: istore 5
      //   990: aload_0
      //   991: getfield 73	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mWidth	I
      //   994: istore_2
      //   995: aload_0
      //   996: getfield 75	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mHeight	I
      //   999: istore 6
      //   1001: aload_0
      //   1002: iconst_1
      //   1003: putfield 81	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDp	Z
      //   1006: ldc 199
      //   1008: new 85	java/lang/StringBuilder
      //   1011: dup
      //   1012: ldc_w 263
      //   1015: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1018: aload_0
      //   1019: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   1022: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1025: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1028: iconst_0
      //   1029: anewarray 68	java/lang/Object
      //   1032: invokestatic 214	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1035: iconst_1
      //   1036: istore 7
      //   1038: aload_0
      //   1039: iconst_0
      //   1040: putfield 66	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDs	Z
      //   1043: aload_0
      //   1044: iconst_0
      //   1045: putfield 77	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jAs	Z
      //   1048: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1051: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   1054: aload_0
      //   1055: getfield 81	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDp	Z
      //   1058: istore 14
      //   1060: iload 14
      //   1062: ifeq +1429 -> 2491
      //   1065: iconst_1
      //   1066: istore 9
      //   1068: iload_2
      //   1069: istore 10
      //   1071: iload 5
      //   1073: istore_2
      //   1074: iload 13
      //   1076: istore 4
      //   1078: iload 12
      //   1080: istore 5
      //   1082: iload 6
      //   1084: istore 11
      //   1086: iload 8
      //   1088: istore 6
      //   1090: goto -896 -> 194
      //   1093: aload_0
      //   1094: getfield 129	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDu	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i;
      //   1097: invokevirtual 256	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:start	()V
      //   1100: aload_0
      //   1101: iconst_1
      //   1102: putfield 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDl	Z
      //   1105: iconst_1
      //   1106: istore 4
      //   1108: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1111: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   1114: goto +1425 -> 2539
      //   1117: astore 15
      //   1119: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1122: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   1125: ldc 156
      //   1127: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1130: aload 15
      //   1132: athrow
      //   1133: ldc 199
      //   1135: ldc_w 265
      //   1138: iconst_0
      //   1139: anewarray 68	java/lang/Object
      //   1142: invokestatic 268	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1145: iload 8
      //   1147: istore 6
      //   1149: iload 4
      //   1151: istore 7
      //   1153: iload 5
      //   1155: istore_2
      //   1156: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1159: invokevirtual 271	java/lang/Object:wait	()V
      //   1162: iload 13
      //   1164: istore 4
      //   1166: iload 12
      //   1168: istore 5
      //   1170: goto -1058 -> 112
      //   1173: iload 7
      //   1175: ifeq +1313 -> 2488
      //   1178: ldc 199
      //   1180: ldc_w 273
      //   1183: iconst_0
      //   1184: anewarray 68	java/lang/Object
      //   1187: invokestatic 276	com/tencent/mm/dynamicbackground/a/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1190: aload_0
      //   1191: getfield 129	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDu	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i;
      //   1194: astore 16
      //   1196: ldc 199
      //   1198: new 85	java/lang/StringBuilder
      //   1201: dup
      //   1202: ldc_w 278
      //   1205: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1208: invokestatic 282	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1211: invokevirtual 283	java/lang/Thread:getId	()J
      //   1214: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1217: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1220: iconst_0
      //   1221: anewarray 68	java/lang/Object
      //   1224: invokestatic 276	com/tencent/mm/dynamicbackground/a/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1227: aload 16
      //   1229: getfield 287	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCV	Ljavax/microedition/khronos/egl/EGL10;
      //   1232: ifnonnull +33 -> 1265
      //   1235: new 153	java/lang/RuntimeException
      //   1238: dup
      //   1239: ldc_w 289
      //   1242: invokespecial 290	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1245: astore 15
      //   1247: ldc 156
      //   1249: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1252: aload 15
      //   1254: athrow
      //   1255: astore 15
      //   1257: ldc 156
      //   1259: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1262: aload 15
      //   1264: athrow
      //   1265: aload 16
      //   1267: getfield 294	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCW	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1270: ifnonnull +23 -> 1293
      //   1273: new 153	java/lang/RuntimeException
      //   1276: dup
      //   1277: ldc_w 296
      //   1280: invokespecial 290	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1283: astore 15
      //   1285: ldc 156
      //   1287: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1290: aload 15
      //   1292: athrow
      //   1293: aload 16
      //   1295: getfield 300	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCY	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1298: ifnonnull +23 -> 1321
      //   1301: new 153	java/lang/RuntimeException
      //   1304: dup
      //   1305: ldc_w 302
      //   1308: invokespecial 290	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1311: astore 15
      //   1313: ldc 156
      //   1315: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1318: aload 15
      //   1320: athrow
      //   1321: aload 16
      //   1323: invokevirtual 305	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:aAU	()V
      //   1326: aload 16
      //   1328: getfield 306	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCU	Ljava/lang/ref/WeakReference;
      //   1331: invokevirtual 189	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1334: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   1337: astore 17
      //   1339: aload 17
      //   1341: ifnull +352 -> 1693
      //   1344: aload 16
      //   1346: aload 17
      //   1348: invokestatic 310	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:f	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$h;
      //   1351: aload 16
      //   1353: getfield 287	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCV	Ljavax/microedition/khronos/egl/EGL10;
      //   1356: aload 16
      //   1358: getfield 294	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCW	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1361: aload 16
      //   1363: getfield 300	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCY	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1366: aload 17
      //   1368: invokevirtual 314	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:getHolder	()Landroid/view/SurfaceHolder;
      //   1371: invokeinterface 320 5 0
      //   1376: putfield 324	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCX	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1379: aload 16
      //   1381: getfield 324	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCX	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1384: ifnull +14 -> 1398
      //   1387: aload 16
      //   1389: getfield 324	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCX	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1392: getstatic 329	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1395: if_acmpne +307 -> 1702
      //   1398: aload 16
      //   1400: getfield 287	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCV	Ljavax/microedition/khronos/egl/EGL10;
      //   1403: invokeinterface 333 1 0
      //   1408: sipush 12299
      //   1411: if_icmpne +1134 -> 2545
      //   1414: ldc 199
      //   1416: ldc_w 335
      //   1419: iconst_0
      //   1420: anewarray 68	java/lang/Object
      //   1423: invokestatic 268	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1426: goto +1119 -> 2545
      //   1429: iload 8
      //   1431: ifeq +380 -> 1811
      //   1434: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1437: astore 16
      //   1439: aload 16
      //   1441: monitorenter
      //   1442: aload_0
      //   1443: iconst_1
      //   1444: putfield 137	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDn	Z
      //   1447: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1450: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   1453: aload 16
      //   1455: monitorexit
      //   1456: iload_3
      //   1457: ifne +1094 -> 2551
      //   1460: ldc 199
      //   1462: ldc_w 337
      //   1465: iconst_0
      //   1466: anewarray 68	java/lang/Object
      //   1469: invokestatic 214	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1472: aload_0
      //   1473: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jCU	Ljava/lang/ref/WeakReference;
      //   1476: invokevirtual 189	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1479: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   1482: astore 16
      //   1484: aload 16
      //   1486: ifnull +1065 -> 2551
      //   1489: aload 16
      //   1491: invokestatic 192	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:i	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$o;
      //   1494: invokeinterface 340 1 0
      //   1499: goto +1052 -> 2551
      //   1502: iload 6
      //   1504: istore 8
      //   1506: iload 6
      //   1508: ifeq +127 -> 1635
      //   1511: ldc 199
      //   1513: ldc_w 342
      //   1516: iconst_0
      //   1517: anewarray 68	java/lang/Object
      //   1520: invokestatic 276	com/tencent/mm/dynamicbackground/a/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1523: aload_0
      //   1524: getfield 129	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDu	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i;
      //   1527: astore 17
      //   1529: aload 17
      //   1531: getfield 346	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCZ	Ljavax/microedition/khronos/egl/EGLContext;
      //   1534: invokevirtual 352	javax/microedition/khronos/egl/EGLContext:getGL	()Ljavax/microedition/khronos/opengles/GL;
      //   1537: astore 16
      //   1539: aload 17
      //   1541: getfield 306	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCU	Ljava/lang/ref/WeakReference;
      //   1544: invokevirtual 189	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1547: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   1550: astore 17
      //   1552: aload 17
      //   1554: ifnull +1003 -> 2557
      //   1557: aload 17
      //   1559: invokestatic 356	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:g	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$m;
      //   1562: ifnull +15 -> 1577
      //   1565: aload 17
      //   1567: invokestatic 356	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:g	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$m;
      //   1570: invokeinterface 361 1 0
      //   1575: astore 16
      //   1577: aload 17
      //   1579: invokestatic 365	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:h	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)I
      //   1582: iconst_3
      //   1583: iand
      //   1584: ifeq +973 -> 2557
      //   1587: iconst_0
      //   1588: istore 6
      //   1590: aload 17
      //   1592: invokestatic 365	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:h	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)I
      //   1595: iconst_1
      //   1596: iand
      //   1597: ifeq +6 -> 1603
      //   1600: iconst_1
      //   1601: istore 6
      //   1603: aload 17
      //   1605: invokestatic 365	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:h	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)I
      //   1608: iconst_2
      //   1609: iand
      //   1610: ifeq +923 -> 2533
      //   1613: new 367	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$n
      //   1616: dup
      //   1617: invokespecial 368	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$n:<init>	()V
      //   1620: astore 17
      //   1622: aload 16
      //   1624: iload 6
      //   1626: aload 17
      //   1628: invokestatic 374	android/opengl/GLDebugHelper:wrap	(Ljavax/microedition/khronos/opengles/GL;ILjava/io/Writer;)Ljavax/microedition/khronos/opengles/GL;
      //   1631: pop
      //   1632: goto +925 -> 2557
      //   1635: iload_3
      //   1636: ifeq +11 -> 1647
      //   1639: aload_0
      //   1640: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jCU	Ljava/lang/ref/WeakReference;
      //   1643: invokevirtual 189	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1646: pop
      //   1647: iload_3
      //   1648: ifeq +245 -> 1893
      //   1651: ldc 199
      //   1653: ldc_w 376
      //   1656: iconst_0
      //   1657: anewarray 68	java/lang/Object
      //   1660: invokestatic 276	com/tencent/mm/dynamicbackground/a/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1663: aload_0
      //   1664: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jCU	Ljava/lang/ref/WeakReference;
      //   1667: invokevirtual 189	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1670: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   1673: astore 16
      //   1675: aload 16
      //   1677: ifnull +201 -> 1878
      //   1680: aload 16
      //   1682: invokestatic 192	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:i	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$o;
      //   1685: invokeinterface 379 1 0
      //   1690: goto +873 -> 2563
      //   1693: aload 16
      //   1695: aconst_null
      //   1696: putfield 324	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCX	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1699: goto -320 -> 1379
      //   1702: aload 16
      //   1704: getfield 287	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCV	Ljavax/microedition/khronos/egl/EGL10;
      //   1707: aload 16
      //   1709: getfield 294	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCW	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1712: aload 16
      //   1714: getfield 324	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCX	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1717: aload 16
      //   1719: getfield 324	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCX	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1722: aload 16
      //   1724: getfield 346	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCZ	Ljavax/microedition/khronos/egl/EGLContext;
      //   1727: invokeinterface 383 5 0
      //   1732: ifne +28 -> 1760
      //   1735: ldc_w 385
      //   1738: ldc_w 386
      //   1741: aload 16
      //   1743: getfield 287	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCV	Ljavax/microedition/khronos/egl/EGL10;
      //   1746: invokeinterface 333 1 0
      //   1751: invokestatic 389	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:g	(Ljava/lang/String;Ljava/lang/String;I)V
      //   1754: iconst_0
      //   1755: istore 8
      //   1757: goto -328 -> 1429
      //   1760: aload 16
      //   1762: getfield 392	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jDa	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1765: ifnull +819 -> 2584
      //   1768: aload 16
      //   1770: getfield 287	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCV	Ljavax/microedition/khronos/egl/EGL10;
      //   1773: aload 16
      //   1775: getfield 294	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCW	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1778: aload 16
      //   1780: getfield 392	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jDa	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1783: invokeinterface 396 3 0
      //   1788: pop
      //   1789: aload 16
      //   1791: aconst_null
      //   1792: putfield 392	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jDa	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1795: goto +789 -> 2584
      //   1798: astore 15
      //   1800: aload 16
      //   1802: monitorexit
      //   1803: ldc 156
      //   1805: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1808: aload 15
      //   1810: athrow
      //   1811: ldc 199
      //   1813: ldc_w 398
      //   1816: iconst_0
      //   1817: anewarray 68	java/lang/Object
      //   1820: invokestatic 268	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1823: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1826: astore 16
      //   1828: aload 16
      //   1830: monitorenter
      //   1831: aload_0
      //   1832: iconst_1
      //   1833: putfield 137	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDn	Z
      //   1836: aload_0
      //   1837: iconst_1
      //   1838: putfield 232	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDj	Z
      //   1841: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1844: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   1847: aload 16
      //   1849: monitorexit
      //   1850: iload_2
      //   1851: istore 8
      //   1853: iload 7
      //   1855: istore_2
      //   1856: iload_1
      //   1857: istore 7
      //   1859: iload 8
      //   1861: istore_1
      //   1862: goto -1770 -> 92
      //   1865: astore 15
      //   1867: aload 16
      //   1869: monitorexit
      //   1870: ldc 156
      //   1872: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1875: aload 15
      //   1877: athrow
      //   1878: ldc 199
      //   1880: ldc_w 400
      //   1883: iconst_0
      //   1884: anewarray 68	java/lang/Object
      //   1887: invokestatic 268	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1890: goto +673 -> 2563
      //   1893: iload_2
      //   1894: ifeq +591 -> 2485
      //   1897: ldc 199
      //   1899: new 85	java/lang/StringBuilder
      //   1902: dup
      //   1903: ldc_w 402
      //   1906: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1909: iload 10
      //   1911: invokevirtual 405	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1914: ldc_w 407
      //   1917: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1920: iload 11
      //   1922: invokevirtual 405	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1925: ldc_w 409
      //   1928: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1931: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1934: iconst_0
      //   1935: anewarray 68	java/lang/Object
      //   1938: invokestatic 276	com/tencent/mm/dynamicbackground/a/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1941: aload_0
      //   1942: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jCU	Ljava/lang/ref/WeakReference;
      //   1945: invokevirtual 189	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1948: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   1951: astore 16
      //   1953: aload 16
      //   1955: ifnull +635 -> 2590
      //   1958: aload 16
      //   1960: invokestatic 192	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:i	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$o;
      //   1963: iload 10
      //   1965: iload 11
      //   1967: invokeinterface 413 3 0
      //   1972: ldc 199
      //   1974: ldc_w 415
      //   1977: iconst_0
      //   1978: anewarray 68	java/lang/Object
      //   1981: invokestatic 268	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1984: goto +606 -> 2590
      //   1987: aload_0
      //   1988: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jCU	Ljava/lang/ref/WeakReference;
      //   1991: invokevirtual 189	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1994: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   1997: astore 17
      //   1999: aload 17
      //   2001: ifnull +63 -> 2064
      //   2004: aload 17
      //   2006: invokestatic 192	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:i	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$o;
      //   2009: invokeinterface 418 1 0
      //   2014: invokestatic 422	java/lang/Thread:sleep	(J)V
      //   2017: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   2020: astore 16
      //   2022: aload 16
      //   2024: monitorenter
      //   2025: aload_0
      //   2026: getfield 71	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDt	Ljava/lang/Object;
      //   2029: astore 18
      //   2031: aload 18
      //   2033: monitorenter
      //   2034: aload_0
      //   2035: invokespecial 259	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aAY	()Z
      //   2038: ifeq +307 -> 2345
      //   2041: aload_0
      //   2042: getfield 183	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDh	Z
      //   2045: ifne +300 -> 2345
      //   2048: aload 17
      //   2050: invokestatic 192	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:i	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$o;
      //   2053: invokeinterface 425 1 0
      //   2058: aload 18
      //   2060: monitorexit
      //   2061: aload 16
      //   2063: monitorexit
      //   2064: aload_0
      //   2065: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jCU	Ljava/lang/ref/WeakReference;
      //   2068: invokevirtual 189	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   2071: pop
      //   2072: sipush 12288
      //   2075: istore 12
      //   2077: iconst_1
      //   2078: istore 14
      //   2080: aload_0
      //   2081: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jCU	Ljava/lang/ref/WeakReference;
      //   2084: invokevirtual 189	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   2087: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   2090: astore 16
      //   2092: aload 16
      //   2094: ifnull +10 -> 2104
      //   2097: aload 16
      //   2099: invokevirtual 428	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:getIsSwapNow	()Z
      //   2102: istore 14
      //   2104: iload 14
      //   2106: ifeq +107 -> 2213
      //   2109: aload_0
      //   2110: getfield 129	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDu	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i;
      //   2113: astore 17
      //   2115: sipush 12288
      //   2118: istore 6
      //   2120: iload 6
      //   2122: istore 12
      //   2124: aload 17
      //   2126: getfield 294	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCW	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   2129: ifnull +84 -> 2213
      //   2132: iload 6
      //   2134: istore 12
      //   2136: aload 17
      //   2138: getfield 294	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCW	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   2141: getstatic 431	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   2144: if_acmpeq +69 -> 2213
      //   2147: iload 6
      //   2149: istore 12
      //   2151: aload 17
      //   2153: getfield 324	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCX	Ljavax/microedition/khronos/egl/EGLSurface;
      //   2156: ifnull +57 -> 2213
      //   2159: iload 6
      //   2161: istore 12
      //   2163: aload 17
      //   2165: getfield 324	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCX	Ljavax/microedition/khronos/egl/EGLSurface;
      //   2168: getstatic 329	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
      //   2171: if_acmpeq +42 -> 2213
      //   2174: iload 6
      //   2176: istore 12
      //   2178: aload 17
      //   2180: getfield 287	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCV	Ljavax/microedition/khronos/egl/EGL10;
      //   2183: aload 17
      //   2185: getfield 294	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCW	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   2188: aload 17
      //   2190: getfield 324	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCX	Ljavax/microedition/khronos/egl/EGLSurface;
      //   2193: invokeinterface 434 3 0
      //   2198: ifne +15 -> 2213
      //   2201: aload 17
      //   2203: getfield 287	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:jCV	Ljavax/microedition/khronos/egl/EGL10;
      //   2206: invokeinterface 333 1 0
      //   2211: istore 12
      //   2213: aload 16
      //   2215: ifnull +380 -> 2595
      //   2218: aload 16
      //   2220: iconst_1
      //   2221: invokevirtual 438	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:setSwapNow	(Z)V
      //   2224: goto +371 -> 2595
      //   2227: ldc_w 440
      //   2230: ldc_w 441
      //   2233: iload 12
      //   2235: invokestatic 389	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:g	(Ljava/lang/String;Ljava/lang/String;I)V
      //   2238: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   2241: astore 16
      //   2243: aload 16
      //   2245: monitorenter
      //   2246: aload_0
      //   2247: iconst_1
      //   2248: putfield 232	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDj	Z
      //   2251: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aAT	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   2254: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   2257: aload 16
      //   2259: monitorexit
      //   2260: iload 5
      //   2262: istore 6
      //   2264: iload 9
      //   2266: ifeq +208 -> 2474
      //   2269: iconst_1
      //   2270: istore 5
      //   2272: iconst_0
      //   2273: istore 4
      //   2275: iload 4
      //   2277: istore 9
      //   2279: iload_2
      //   2280: istore 12
      //   2282: iload 7
      //   2284: istore_2
      //   2285: iload 5
      //   2287: istore 4
      //   2289: iload 6
      //   2291: istore 5
      //   2293: iload_1
      //   2294: istore 7
      //   2296: iload 8
      //   2298: istore 6
      //   2300: iload 12
      //   2302: istore_1
      //   2303: goto -2211 -> 92
      //   2306: astore 15
      //   2308: ldc 199
      //   2310: ldc_w 415
      //   2313: iconst_0
      //   2314: anewarray 68	java/lang/Object
      //   2317: invokestatic 268	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2320: ldc 156
      //   2322: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2325: aload 15
      //   2327: athrow
      //   2328: astore 16
      //   2330: ldc 199
      //   2332: ldc_w 443
      //   2335: iconst_0
      //   2336: anewarray 68	java/lang/Object
      //   2339: invokestatic 276	com/tencent/mm/dynamicbackground/a/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2342: goto -325 -> 2017
      //   2345: ldc 199
      //   2347: ldc_w 445
      //   2350: iconst_4
      //   2351: anewarray 68	java/lang/Object
      //   2354: dup
      //   2355: iconst_0
      //   2356: aload_0
      //   2357: getfield 183	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDh	Z
      //   2360: invokestatic 451	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   2363: aastore
      //   2364: dup
      //   2365: iconst_1
      //   2366: aload_0
      //   2367: getfield 173	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:arU	Z
      //   2370: invokestatic 451	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   2373: aastore
      //   2374: dup
      //   2375: iconst_2
      //   2376: aload_0
      //   2377: getfield 132	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDi	Z
      //   2380: invokestatic 451	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   2383: aastore
      //   2384: dup
      //   2385: iconst_3
      //   2386: aload_0
      //   2387: getfield 232	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:jDj	Z
      //   2390: invokestatic 451	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   2393: aastore
      //   2394: invokestatic 214	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2397: goto -339 -> 2058
      //   2400: astore 15
      //   2402: aload 18
      //   2404: monitorexit
      //   2405: ldc 156
      //   2407: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2410: aload 15
      //   2412: athrow
      //   2413: astore 15
      //   2415: aload 16
      //   2417: monitorexit
      //   2418: ldc 156
      //   2420: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2423: aload 15
      //   2425: athrow
      //   2426: ldc 199
      //   2428: new 85	java/lang/StringBuilder
      //   2431: dup
      //   2432: ldc_w 453
      //   2435: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   2438: aload_0
      //   2439: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   2442: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2445: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2448: iconst_0
      //   2449: anewarray 68	java/lang/Object
      //   2452: invokestatic 214	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2455: iconst_1
      //   2456: istore 6
      //   2458: goto -194 -> 2264
      //   2461: astore 15
      //   2463: aload 16
      //   2465: monitorexit
      //   2466: ldc 156
      //   2468: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2471: aload 15
      //   2473: athrow
      //   2474: iload 4
      //   2476: istore 5
      //   2478: iload 9
      //   2480: istore 4
      //   2482: goto -207 -> 2275
      //   2485: goto -498 -> 1987
      //   2488: goto -986 -> 1502
      //   2491: iload_2
      //   2492: istore 10
      //   2494: iload 5
      //   2496: istore_2
      //   2497: iload 13
      //   2499: istore 4
      //   2501: iload 12
      //   2503: istore 5
      //   2505: iload 6
      //   2507: istore 11
      //   2509: iload 8
      //   2511: istore 6
      //   2513: goto -2319 -> 194
      //   2516: iload 11
      //   2518: istore 6
      //   2520: iload 10
      //   2522: istore_2
      //   2523: iload 4
      //   2525: istore 7
      //   2527: goto -1484 -> 1043
      //   2530: goto -1374 -> 1156
      //   2533: aconst_null
      //   2534: astore 17
      //   2536: goto -914 -> 1622
      //   2539: iload 4
      //   2541: istore_3
      //   2542: goto -1631 -> 911
      //   2545: iconst_0
      //   2546: istore 8
      //   2548: goto -1119 -> 1429
      //   2551: iconst_0
      //   2552: istore 7
      //   2554: goto -1052 -> 1502
      //   2557: iconst_0
      //   2558: istore 8
      //   2560: goto -925 -> 1635
      //   2563: iconst_0
      //   2564: istore_3
      //   2565: iload_2
      //   2566: istore 12
      //   2568: iload 7
      //   2570: istore_2
      //   2571: iload_1
      //   2572: istore 7
      //   2574: iload 8
      //   2576: istore 6
      //   2578: iload 12
      //   2580: istore_1
      //   2581: goto -2489 -> 92
      //   2584: iconst_1
      //   2585: istore 8
      //   2587: goto -1158 -> 1429
      //   2590: iconst_0
      //   2591: istore_2
      //   2592: goto -605 -> 1987
      //   2595: iload 5
      //   2597: istore 6
      //   2599: iload 12
      //   2601: lookupswitch	default:+27->2628, 12288:+-337->2264, 12302:+-175->2426
      //   2629: impdep1
      //   2630: ddiv
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2631	0	this	j
      //   91	2490	1	i	int
      //   65	2527	2	j	int
      //   63	2502	3	k	int
      //   76	2464	4	m	int
      //   70	2526	5	n	int
      //   67	2531	6	i1	int
      //   79	2494	7	i2	int
      //   101	2485	8	i3	int
      //   73	2406	9	i4	int
      //   82	2439	10	i5	int
      //   85	2432	11	i6	int
      //   385	2215	12	i7	int
      //   640	1858	13	i8	int
      //   228	1877	14	bool	boolean
      //   33	178	15	localObject1	Object
      //   759	11	15	localObject2	Object
      //   772	5	15	localThrowable	Throwable
      //   797	8	15	localGameGLSurfaceView	GameGLSurfaceView
      //   861	14	15	localRuntimeException1	RuntimeException
      //   1117	14	15	localRuntimeException2	RuntimeException
      //   1245	8	15	localRuntimeException3	RuntimeException
      //   1255	8	15	localObject3	Object
      //   1283	36	15	localRuntimeException4	RuntimeException
      //   1798	11	15	localObject4	Object
      //   1865	11	15	localObject5	Object
      //   2306	20	15	localObject6	Object
      //   2400	11	15	localObject7	Object
      //   2413	11	15	localObject8	Object
      //   2461	11	15	localObject9	Object
      //   95	41	16	localk	GameGLSurfaceView.k
      //   144	618	16	localObject10	Object
      //   2328	136	16	localException	Exception
      //   270	2265	17	localObject12	Object
      // Exception table:
      //   from	to	target	type
      //   38	46	144	finally
      //   112	135	759	finally
      //   135	138	759	finally
      //   157	194	759	finally
      //   194	197	759	finally
      //   230	255	759	finally
      //   260	272	759	finally
      //   277	287	759	finally
      //   287	333	759	finally
      //   333	381	759	finally
      //   392	400	759	finally
      //   408	447	759	finally
      //   452	471	759	finally
      //   484	516	759	finally
      //   516	569	759	finally
      //   569	585	759	finally
      //   585	638	759	finally
      //   647	680	759	finally
      //   683	694	759	finally
      //   694	712	759	finally
      //   729	741	759	finally
      //   746	756	759	finally
      //   820	827	759	finally
      //   830	837	759	finally
      //   837	848	759	finally
      //   863	877	759	finally
      //   877	884	759	finally
      //   887	905	759	finally
      //   922	929	759	finally
      //   940	964	759	finally
      //   973	987	759	finally
      //   990	1035	759	finally
      //   1038	1043	759	finally
      //   1043	1060	759	finally
      //   1093	1100	759	finally
      //   1100	1105	759	finally
      //   1108	1114	759	finally
      //   1119	1133	759	finally
      //   1133	1145	759	finally
      //   1156	1162	759	finally
      //   92	100	772	java/lang/Throwable
      //   202	209	772	java/lang/Throwable
      //   761	772	772	java/lang/Throwable
      //   1178	1255	772	java/lang/Throwable
      //   1265	1293	772	java/lang/Throwable
      //   1293	1321	772	java/lang/Throwable
      //   1321	1339	772	java/lang/Throwable
      //   1344	1379	772	java/lang/Throwable
      //   1379	1398	772	java/lang/Throwable
      //   1398	1426	772	java/lang/Throwable
      //   1434	1442	772	java/lang/Throwable
      //   1460	1484	772	java/lang/Throwable
      //   1489	1499	772	java/lang/Throwable
      //   1511	1552	772	java/lang/Throwable
      //   1557	1577	772	java/lang/Throwable
      //   1577	1587	772	java/lang/Throwable
      //   1590	1600	772	java/lang/Throwable
      //   1603	1622	772	java/lang/Throwable
      //   1622	1632	772	java/lang/Throwable
      //   1639	1647	772	java/lang/Throwable
      //   1651	1675	772	java/lang/Throwable
      //   1680	1690	772	java/lang/Throwable
      //   1693	1699	772	java/lang/Throwable
      //   1702	1754	772	java/lang/Throwable
      //   1760	1795	772	java/lang/Throwable
      //   1800	1811	772	java/lang/Throwable
      //   1811	1831	772	java/lang/Throwable
      //   1867	1878	772	java/lang/Throwable
      //   1878	1890	772	java/lang/Throwable
      //   1897	1953	772	java/lang/Throwable
      //   1972	1984	772	java/lang/Throwable
      //   1987	1999	772	java/lang/Throwable
      //   2004	2017	772	java/lang/Throwable
      //   2017	2025	772	java/lang/Throwable
      //   2064	2072	772	java/lang/Throwable
      //   2080	2092	772	java/lang/Throwable
      //   2097	2104	772	java/lang/Throwable
      //   2109	2115	772	java/lang/Throwable
      //   2124	2132	772	java/lang/Throwable
      //   2136	2147	772	java/lang/Throwable
      //   2151	2159	772	java/lang/Throwable
      //   2163	2174	772	java/lang/Throwable
      //   2178	2213	772	java/lang/Throwable
      //   2218	2224	772	java/lang/Throwable
      //   2227	2246	772	java/lang/Throwable
      //   2308	2328	772	java/lang/Throwable
      //   2330	2342	772	java/lang/Throwable
      //   2415	2426	772	java/lang/Throwable
      //   2426	2455	772	java/lang/Throwable
      //   2463	2474	772	java/lang/Throwable
      //   830	837	861	java/lang/RuntimeException
      //   1093	1100	1117	java/lang/RuntimeException
      //   92	100	1255	finally
      //   202	209	1255	finally
      //   761	772	1255	finally
      //   774	799	1255	finally
      //   804	814	1255	finally
      //   1178	1255	1255	finally
      //   1265	1293	1255	finally
      //   1293	1321	1255	finally
      //   1321	1339	1255	finally
      //   1344	1379	1255	finally
      //   1379	1398	1255	finally
      //   1398	1426	1255	finally
      //   1434	1442	1255	finally
      //   1460	1484	1255	finally
      //   1489	1499	1255	finally
      //   1511	1552	1255	finally
      //   1557	1577	1255	finally
      //   1577	1587	1255	finally
      //   1590	1600	1255	finally
      //   1603	1622	1255	finally
      //   1622	1632	1255	finally
      //   1639	1647	1255	finally
      //   1651	1675	1255	finally
      //   1680	1690	1255	finally
      //   1693	1699	1255	finally
      //   1702	1754	1255	finally
      //   1760	1795	1255	finally
      //   1800	1811	1255	finally
      //   1811	1831	1255	finally
      //   1867	1878	1255	finally
      //   1878	1890	1255	finally
      //   1897	1953	1255	finally
      //   1972	1984	1255	finally
      //   1987	1999	1255	finally
      //   2004	2017	1255	finally
      //   2017	2025	1255	finally
      //   2064	2072	1255	finally
      //   2080	2092	1255	finally
      //   2097	2104	1255	finally
      //   2109	2115	1255	finally
      //   2124	2132	1255	finally
      //   2136	2147	1255	finally
      //   2151	2159	1255	finally
      //   2163	2174	1255	finally
      //   2178	2213	1255	finally
      //   2218	2224	1255	finally
      //   2227	2246	1255	finally
      //   2308	2328	1255	finally
      //   2330	2342	1255	finally
      //   2415	2426	1255	finally
      //   2426	2455	1255	finally
      //   2463	2474	1255	finally
      //   1442	1456	1798	finally
      //   1831	1850	1865	finally
      //   1958	1972	2306	finally
      //   2004	2017	2328	java/lang/Exception
      //   2034	2058	2400	finally
      //   2058	2061	2400	finally
      //   2345	2397	2400	finally
      //   2025	2034	2413	finally
      //   2061	2064	2413	finally
      //   2402	2413	2413	finally
      //   2246	2260	2461	finally
    }
    
    private boolean aAY()
    {
      return (!this.arU) && (this.jDi) && (!this.jDj) && (this.mWidth > 0) && (this.mHeight > 0) && ((this.jAs) || (this.mRenderMode == 1));
    }
    
    public final void aAZ()
    {
      AppMethodBeat.i(213932);
      if (this.jDd.isAlive()) {
        this.jDe.sendEmptyMessage(5);
      }
      AppMethodBeat.o(213932);
    }
    
    public final int getRenderMode()
    {
      AppMethodBeat.i(103043);
      synchronized (GameGLSurfaceView.aAT())
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
        Process.setThreadPriority(Process.myTid(), -8);
        try
        {
          label66:
          aAX();
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
          GameGLSurfaceView localGameGLSurfaceView = (GameGLSurfaceView)this.jCU.get();
          if (localGameGLSurfaceView != null) {
            GameGLSurfaceView.i(localGameGLSurfaceView).aAN();
          }
          return;
        }
        finally
        {
          GameGLSurfaceView.aAT().n(this);
          AppMethodBeat.o(103038);
        }
      }
      catch (Exception localException)
      {
        break label66;
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
      synchronized (GameGLSurfaceView.aAT())
      {
        this.mRenderMode = paramInt;
        GameGLSurfaceView.aAT().notifyAll();
        AppMethodBeat.o(103042);
        return;
      }
    }
    
    public final void w(Runnable paramRunnable)
    {
      this.jDb = paramRunnable;
    }
    
    final class a
      extends Handler
    {
      public a(Looper paramLooper)
      {
        super();
      }
      
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(213915);
        for (;;)
        {
          synchronized (GameGLSurfaceView.aAT())
          {
            switch (paramMessage.what)
            {
            case 0: 
              AppMethodBeat.o(213915);
              return;
              c.i("MicroMsg.GLThread", "surfaceCreated tid=" + GameGLSurfaceView.j.this.getId(), new Object[0]);
              GameGLSurfaceView.j.a(GameGLSurfaceView.j.this, true);
              GameGLSurfaceView.j.b(GameGLSurfaceView.j.this);
              GameGLSurfaceView.aAT().notifyAll();
            }
          }
          c.i("MicroMsg.GLThread", "surfaceDestroyed tid=" + GameGLSurfaceView.j.this.getId(), new Object[0]);
          GameGLSurfaceView.j.a(GameGLSurfaceView.j.this, false);
          GameGLSurfaceView.aAT().notifyAll();
          continue;
          c.i("MicroMsg.GLThread", "onPause tid=" + GameGLSurfaceView.j.this.getId(), new Object[0]);
          GameGLSurfaceView.j.b(GameGLSurfaceView.j.this, true);
          GameGLSurfaceView.aAT().notifyAll();
          continue;
          c.i("MicroMsg.GLThread", "onResume tid=" + GameGLSurfaceView.j.this.getId(), new Object[0]);
          GameGLSurfaceView.j.b(GameGLSurfaceView.j.this, false);
          GameGLSurfaceView.j.c(GameGLSurfaceView.j.this);
          GameGLSurfaceView.j.d(GameGLSurfaceView.j.this);
          GameGLSurfaceView.aAT().notifyAll();
          continue;
          int i = paramMessage.arg1;
          int j = paramMessage.arg2;
          if ((GameGLSurfaceView.j.e(GameGLSurfaceView.j.this) == i) && (GameGLSurfaceView.j.f(GameGLSurfaceView.j.this) == j))
          {
            AppMethodBeat.o(213915);
            return;
          }
          c.i("MicroMsg.GLThread", "windowResize w:%d h:%d tid=", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(GameGLSurfaceView.j.this.getId()) });
          GameGLSurfaceView.j.a(GameGLSurfaceView.j.this, i);
          GameGLSurfaceView.j.b(GameGLSurfaceView.j.this, j);
          GameGLSurfaceView.j.g(GameGLSurfaceView.j.this);
          GameGLSurfaceView.j.c(GameGLSurfaceView.j.this);
          GameGLSurfaceView.j.d(GameGLSurfaceView.j.this);
          GameGLSurfaceView.aAT().notifyAll();
          continue;
          c.i("MicroMsg.GLThread", "requestExitAndWaitForDestroy tid=" + GameGLSurfaceView.j.this.getId(), new Object[0]);
          GameGLSurfaceView.j.h(GameGLSurfaceView.j.this);
          paramMessage = (GameGLSurfaceView)GameGLSurfaceView.j.i(GameGLSurfaceView.j.this).get();
          if (paramMessage != null) {
            GameGLSurfaceView.i(paramMessage).aAM();
          }
          GameGLSurfaceView.aAT().notifyAll();
          continue;
          c.i("MicroMsg.GLThread", "requestRender tid=" + GameGLSurfaceView.j.this.getId(), new Object[0]);
          GameGLSurfaceView.j.c(GameGLSurfaceView.j.this);
          GameGLSurfaceView.aAT().notifyAll();
        }
      }
    }
  }
  
  static final class k
  {
    private static String TAG = "GLThreadManager";
    
    public final void n(GameGLSurfaceView.j paramj)
    {
      for (;;)
      {
        GameGLSurfaceView.i locali;
        try
        {
          AppMethodBeat.i(103047);
          c.i("MicroMsg.GLThread", "exiting tid=" + paramj.getId(), new Object[0]);
          localGameGLSurfaceView1 = (GameGLSurfaceView)GameGLSurfaceView.j.i(paramj).get();
          if (localGameGLSurfaceView1 != null)
          {
            GameGLSurfaceView.i(localGameGLSurfaceView1).onDestroy();
            locali = GameGLSurfaceView.j.a(paramj);
            c.w("MicroMsg.GLThread", "destroySurface()  tid=" + Thread.currentThread().getId(), new Object[0]);
            locali.aAU();
            GameGLSurfaceView.j.j(paramj);
            GameGLSurfaceView.j.k(paramj);
          }
        }
        finally {}
        try
        {
          locali = GameGLSurfaceView.j.a(paramj);
          c.w("MicroMsg.GLThread", "finish() tid=" + Thread.currentThread().getId(), new Object[0]);
          if (locali.jCZ != null)
          {
            GameGLSurfaceView localGameGLSurfaceView2 = (GameGLSurfaceView)locali.jCU.get();
            if (localGameGLSurfaceView2 != null) {
              GameGLSurfaceView.e(localGameGLSurfaceView2).destroyContext(locali.jCV, locali.jCW, locali.jCZ);
            }
            locali.jCZ = null;
          }
          if (locali.jCW != null)
          {
            locali.jCV.eglTerminate(locali.jCW);
            locali.jCW = null;
          }
        }
        catch (Throwable localThrowable)
        {
          c.e(TAG, "alvinluo GLThread#threadExiting finish stack = [%s]", new Object[] { Log.getStackTraceString(localThrowable) });
          if (localGameGLSurfaceView1 == null) {
            continue;
          }
          GameGLSurfaceView.i(localGameGLSurfaceView1).aAN();
          continue;
        }
        GameGLSurfaceView.j.l(paramj);
        GameGLSurfaceView.j.m(paramj).quit();
        notifyAll();
        AppMethodBeat.o(103047);
        return;
        c.i("MicroMsg.GLThread", "onFinalize:view = null", new Object[0]);
      }
    }
  }
  
  public static abstract interface l {}
  
  public static abstract interface m
  {
    public abstract GL aBa();
  }
  
  public static abstract interface o
  {
    public abstract void aAH();
    
    public abstract void aAI();
    
    public abstract long aAK();
    
    public abstract void aAL();
    
    public abstract void aAM();
    
    public abstract void aAN();
    
    public abstract void cR(int paramInt1, int paramInt2);
    
    public abstract void onDestroy();
    
    public abstract void onPause();
    
    public abstract void onResume();
  }
  
  final class p
    extends GameGLSurfaceView.b
  {
    public p()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.view.GameGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */