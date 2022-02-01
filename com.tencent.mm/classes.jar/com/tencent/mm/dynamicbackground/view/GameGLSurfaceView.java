package com.tencent.mm.dynamicbackground.view;

import android.content.Context;
import android.opengl.EGL14;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.a.c;
import java.io.Writer;
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
  private static final k mcm;
  private boolean mDetached;
  private AtomicBoolean mck;
  private l mcl;
  private final WeakReference<GameGLSurfaceView> mcn;
  public j mco;
  private o mcp;
  private e mcq;
  private f mcr;
  private h mcs;
  private m mct;
  private boolean mcu;
  private int mcv;
  private int mcw;
  private boolean mcx;
  
  static
  {
    AppMethodBeat.i(103073);
    mcm = new k((byte)0);
    AppMethodBeat.o(103073);
  }
  
  public GameGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103053);
    this.mck = new AtomicBoolean(false);
    this.mcn = new WeakReference(this);
    this.mcu = false;
    init();
    AppMethodBeat.o(103053);
  }
  
  public GameGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(233213);
    this.mck = new AtomicBoolean(false);
    this.mcn = new WeakReference(this);
    this.mcu = false;
    init();
    AppMethodBeat.o(233213);
  }
  
  private void aTN()
  {
    AppMethodBeat.i(103072);
    if (this.mco != null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
      AppMethodBeat.o(103072);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(103072);
  }
  
  private void init()
  {
    AppMethodBeat.i(233214);
    getHolder().addCallback(this);
    AppMethodBeat.o(233214);
  }
  
  public final void aTL()
  {
    AppMethodBeat.i(233255);
    this.mco = new j(this.mcn);
    this.mco.mcQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(233218);
        if (GameGLSurfaceView.a(GameGLSurfaceView.this) != null) {
          GameGLSurfaceView.a(GameGLSurfaceView.this);
        }
        GameGLSurfaceView.b(GameGLSurfaceView.this).set(true);
        AppMethodBeat.o(233218);
      }
    };
    this.mco.start();
    AppMethodBeat.o(233255);
  }
  
  public final void aTM()
  {
    AppMethodBeat.i(103060);
    setEGLConfigChooser(new b());
    AppMethodBeat.o(103060);
  }
  
  public int getDebugFlags()
  {
    return this.mcv;
  }
  
  public javax.microedition.khronos.egl.EGLContext getEGLContext()
  {
    AppMethodBeat.i(233284);
    javax.microedition.khronos.egl.EGLContext localEGLContext = j.a(this.mco).mcN;
    AppMethodBeat.o(233284);
    return localEGLContext;
  }
  
  public long getEGLContextNativeHandle()
  {
    AppMethodBeat.i(233290);
    long l = j.a(this.mco).nativeHandle;
    AppMethodBeat.o(233290);
    return l;
  }
  
  public boolean getIsSwapNow()
  {
    return this.mcu;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.mcx;
  }
  
  public int getRenderMode()
  {
    AppMethodBeat.i(103063);
    int i = this.mco.getRenderMode();
    AppMethodBeat.o(103063);
    return i;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(103070);
    super.onAttachedToWindow();
    c.i("MicroMsg.GameGLSurfaceView", "onAttachedToWindow reattach =" + this.mDetached, new Object[0]);
    if ((this.mDetached) && (this.mcp != null)) {
      if (this.mco == null) {
        break label112;
      }
    }
    label112:
    for (int i = this.mco.getRenderMode();; i = 1)
    {
      this.mco = new j(this.mcn);
      if (i != 1) {
        this.mco.setRenderMode(i);
      }
      this.mco.start();
      this.mDetached = false;
      AppMethodBeat.o(103070);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(103071);
    c.i("MicroMsg.GameGLSurfaceView", "onDetachedFromWindow", new Object[0]);
    if (this.mco != null) {
      this.mco.aTU();
    }
    this.mDetached = true;
    super.onDetachedFromWindow();
    AppMethodBeat.o(103071);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(103068);
    j localj = this.mco;
    c.i("MicroMsg.GLThread", "onPause before ui lock tid=" + localj.getId(), new Object[0]);
    synchronized (localj.mdi)
    {
      c.i("MicroMsg.GLThread", "onPause ui lock tid=" + localj.getId(), new Object[0]);
      localj.mcV = true;
      c.i("MicroMsg.GLThread", "onPause send command tid=" + localj.getId(), new Object[0]);
      if (localj.mcR.isAlive()) {
        localj.mcS.sendEmptyMessage(2);
      }
      AppMethodBeat.o(103068);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(103069);
    c.i("MicroMsg.GameGLSurfaceView", "onResume", new Object[0]);
    j localj = this.mco;
    if (localj.mcR.isAlive()) {
      localj.mcS.sendEmptyMessage(3);
    }
    AppMethodBeat.o(103069);
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.mcv = paramInt;
  }
  
  public void setEGLConfigChooser(e parame)
  {
    AppMethodBeat.i(103058);
    aTN();
    this.mcq = parame;
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
    aTN();
    this.mcw = paramInt;
    AppMethodBeat.o(103061);
  }
  
  public void setEGLContextFactory(f paramf)
  {
    AppMethodBeat.i(103056);
    aTN();
    this.mcr = paramf;
    AppMethodBeat.o(103056);
  }
  
  public void setEGLWindowSurfaceFactory(h paramh)
  {
    AppMethodBeat.i(103057);
    aTN();
    this.mcs = paramh;
    AppMethodBeat.o(103057);
  }
  
  public void setFps(int paramInt) {}
  
  public void setGLWrapper(m paramm)
  {
    this.mct = paramm;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.mcx = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(103062);
    this.mco.setRenderMode(paramInt);
    AppMethodBeat.o(103062);
  }
  
  public void setRenderer(o paramo)
  {
    AppMethodBeat.i(103055);
    aTN();
    if (this.mcq == null) {
      this.mcq = new p();
    }
    if (this.mcr == null) {
      this.mcr = new c((byte)0);
    }
    if (this.mcs == null) {
      this.mcs = new d((byte)0);
    }
    this.mcp = paramo;
    AppMethodBeat.o(103055);
  }
  
  public void setSwapNow(boolean paramBoolean)
  {
    this.mcu = paramBoolean;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(103066);
    paramSurfaceHolder = this.mco;
    if (paramSurfaceHolder.mcR.isAlive())
    {
      Message localMessage = Message.obtain();
      localMessage.what = 4;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      paramSurfaceHolder.mcS.sendMessage(localMessage);
    }
    AppMethodBeat.o(103066);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(103064);
    c.i("MicroMsg.GameGLSurfaceView", "alvinluo GameGLSurfaceView surfaceCreated", new Object[0]);
    paramSurfaceHolder = this.mco;
    if (paramSurfaceHolder.mcR.isAlive()) {
      paramSurfaceHolder.mcS.sendEmptyMessage(0);
    }
    AppMethodBeat.o(103064);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(103065);
    paramSurfaceHolder = this.mco;
    if (paramSurfaceHolder.mcR.isAlive()) {
      paramSurfaceHolder.mcS.sendEmptyMessage(1);
    }
    AppMethodBeat.o(103065);
  }
  
  public void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(103067);
    c.i("MicroMsg.GameGLSurfaceView", "surfaceRedrawNeeded", new Object[0]);
    if (this.mco != null)
    {
      paramSurfaceHolder = this.mco;
      if (paramSurfaceHolder.mcR.isAlive()) {
        paramSurfaceHolder.mcS.sendEmptyMessage(6);
      }
    }
    AppMethodBeat.o(103067);
  }
  
  abstract class a
    implements GameGLSurfaceView.e
  {
    protected int[] mcz;
    
    public a(int[] paramArrayOfInt)
    {
      if ((GameGLSurfaceView.c(GameGLSurfaceView.this) != 2) && (GameGLSurfaceView.c(GameGLSurfaceView.this) != 3))
      {
        this.mcz = paramArrayOfInt;
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
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.mcz, null, 0, arrayOfInt)) {
        throw new IllegalArgumentException("eglChooseConfig failed");
      }
      int i = arrayOfInt[0];
      if (i <= 0) {
        throw new IllegalArgumentException("No configs match configSpec");
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.mcz, arrayOfEGLConfig, i, arrayOfInt)) {
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
    private int[] mcA;
    protected int mcB;
    protected int mcC;
    protected int mcD;
    protected int mcE;
    protected int mcF;
    protected int mcG;
    
    public b()
    {
      super(new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 8, 12344 });
      AppMethodBeat.i(102978);
      this.mcA = new int[1];
      this.mcB = 8;
      this.mcC = 8;
      this.mcD = 8;
      this.mcE = 8;
      this.mcF = 16;
      this.mcG = 8;
      AppMethodBeat.o(102978);
    }
    
    private int b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
    {
      AppMethodBeat.i(102980);
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.mcA))
      {
        paramInt = this.mcA[0];
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
        int k = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
        int m = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
        if ((k >= this.mcF) && (m >= this.mcG))
        {
          k = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
          m = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
          int n = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
          int i1 = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
          if ((k == this.mcB) && (m == this.mcC) && (n == this.mcD) && (i1 == this.mcE))
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
    private int mcH = 12440;
    
    private c() {}
    
    public final javax.microedition.khronos.egl.EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, javax.microedition.khronos.egl.EGLContext paramEGLContext)
    {
      AppMethodBeat.i(102981);
      c.i("MicroMsg.GLThread", "createContext", new Object[0]);
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = this.mcH;
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
        GameGLSurfaceView.i.ap("eglDestroyContex", paramEGL10.eglGetError());
      }
      AppMethodBeat.o(102982);
    }
  }
  
  static final class d
    implements GameGLSurfaceView.h
  {
    public final EGLSurface b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
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
    
    public final void b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
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
    WeakReference<GameGLSurfaceView> mcI;
    EGL10 mcJ;
    EGLDisplay mcK;
    EGLSurface mcL;
    EGLConfig mcM;
    javax.microedition.khronos.egl.EGLContext mcN;
    EGLSurface mcO;
    long nativeHandle = -1L;
    
    public i(WeakReference<GameGLSurfaceView> paramWeakReference)
    {
      this.mcI = paramWeakReference;
    }
    
    public static void ap(String paramString, int paramInt)
    {
      AppMethodBeat.i(103034);
      paramString = aq(paramString, paramInt);
      c.e("MicroMsg.GLThread", "throwEglException tid=" + Thread.currentThread().getId() + " " + paramString, new Object[0]);
      paramString = new RuntimeException(paramString);
      AppMethodBeat.o(103034);
      throw paramString;
    }
    
    private static String aq(String paramString, int paramInt)
    {
      AppMethodBeat.i(103036);
      paramString = paramString + " failed: " + GameGLSurfaceView.g.getErrorString(paramInt);
      AppMethodBeat.o(103036);
      return paramString;
    }
    
    public static void j(String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(103035);
      c.w(paramString1, aq(paramString2, paramInt), new Object[0]);
      AppMethodBeat.o(103035);
    }
    
    final void aTP()
    {
      AppMethodBeat.i(103033);
      if ((this.mcL != null) && (this.mcL != EGL10.EGL_NO_SURFACE))
      {
        Object localObject = this.mcJ;
        EGLDisplay localEGLDisplay = this.mcK;
        EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
        ((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
        localObject = (GameGLSurfaceView)this.mcI.get();
        if (localObject != null) {
          GameGLSurfaceView.f((GameGLSurfaceView)localObject).b(this.mcJ, this.mcK, this.mcL);
        }
        this.mcL = null;
      }
      AppMethodBeat.o(103033);
    }
    
    public final void start()
    {
      AppMethodBeat.i(103032);
      c.w("MicroMsg.GLThread", "start() tid=" + Thread.currentThread().getId(), new Object[0]);
      this.mcJ = ((EGL10)javax.microedition.khronos.egl.EGLContext.getEGL());
      this.mcK = this.mcJ.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      if (this.mcK == EGL10.EGL_NO_DISPLAY)
      {
        localObject = new RuntimeException("eglGetDisplay failed");
        AppMethodBeat.o(103032);
        throw ((Throwable)localObject);
      }
      Object localObject = new int[2];
      if (!this.mcJ.eglInitialize(this.mcK, (int[])localObject))
      {
        localObject = new RuntimeException("eglInitialize failed");
        AppMethodBeat.o(103032);
        throw ((Throwable)localObject);
      }
      localObject = (GameGLSurfaceView)this.mcI.get();
      if (localObject == null)
      {
        this.mcM = null;
        this.mcN = null;
        c.w("MicroMsg.GameGLSurfaceView", "alvinluo EglHelper start but view is null and set mEglConfig = null, mEglContext = null", new Object[0]);
      }
      for (;;)
      {
        if ((this.mcN == null) || (this.mcN == EGL10.EGL_NO_CONTEXT))
        {
          this.mcN = null;
          ap("createContext", this.mcJ.eglGetError());
        }
        c.w("MicroMsg.GLThread", "createContext " + this.mcN + " tid=" + Thread.currentThread().getId(), new Object[0]);
        this.mcO = this.mcJ.eglCreatePbufferSurface(this.mcK, this.mcM, new int[] { 12375, 16, 12374, 16, 12344 });
        this.mcJ.eglMakeCurrent(this.mcK, this.mcO, this.mcO, this.mcN);
        this.nativeHandle = EGL14.eglGetCurrentContext().getNativeHandle();
        this.mcL = null;
        AppMethodBeat.o(103032);
        return;
        this.mcM = GameGLSurfaceView.d((GameGLSurfaceView)localObject).chooseConfig(this.mcJ, this.mcK);
        c.i("MicroMsg.GameGLSurfaceView", "alvinluo EglHelper start chooseConfig end config: %s, display: %s", new Object[] { Integer.valueOf(this.mcM.hashCode()), Integer.valueOf(this.mcK.hashCode()) });
        this.mcN = GameGLSurfaceView.e((GameGLSurfaceView)localObject).a(this.mcJ, this.mcK, this.mcM, EGL10.EGL_NO_CONTEXT);
        c.i("MicroMsg.GameGLSurfaceView", "alvinluo EglHelper start createContext end", new Object[0]);
      }
    }
  }
  
  public static final class j
    extends Thread
  {
    private boolean cgD;
    private int mHeight;
    private int mRenderMode;
    private int mWidth;
    private WeakReference<GameGLSurfaceView> mcI;
    public Runnable mcP;
    Runnable mcQ;
    HandlerThread mcR;
    a mcS;
    private boolean mcT;
    private boolean mcU;
    boolean mcV;
    private boolean mcW;
    private boolean mcX;
    private boolean mcY;
    private boolean mcZ;
    private boolean mda;
    private boolean mdb;
    private boolean mdc;
    private boolean mdd;
    private boolean mde;
    private boolean mdf;
    private LinkedList<Runnable> mdg;
    private boolean mdh;
    final Object mdi;
    private GameGLSurfaceView.i mdj;
    
    j(WeakReference<GameGLSurfaceView> paramWeakReference)
    {
      AppMethodBeat.i(103037);
      this.mdg = new LinkedList();
      this.mdh = true;
      this.mdi = new Object();
      this.mWidth = 0;
      this.mHeight = 0;
      this.mdd = true;
      this.mRenderMode = 1;
      this.mde = false;
      this.mcR = new HandlerThread("MicroMsg.GLCommandThread" + getId());
      this.mcR.start();
      this.mcS = new a(this.mcR.getLooper());
      this.mcI = paramWeakReference;
      AppMethodBeat.o(103037);
    }
    
    private void aTQ()
    {
      if (this.mda)
      {
        this.mda = false;
        this.mdb = false;
      }
    }
    
    private void aTR()
    {
      AppMethodBeat.i(103039);
      if (this.mcZ)
      {
        this.mcZ = false;
        GameGLSurfaceView.aTO().notifyAll();
      }
      AppMethodBeat.o(103039);
    }
    
    /* Error */
    private void aTS()
    {
      // Byte code:
      //   0: ldc 154
      //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: new 156	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i
      //   9: dup
      //   10: aload_0
      //   11: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcI	Ljava/lang/ref/WeakReference;
      //   14: invokespecial 158	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:<init>	(Ljava/lang/ref/WeakReference;)V
      //   17: putfield 129	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mdj	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i;
      //   20: aload_0
      //   21: iconst_0
      //   22: putfield 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcZ	Z
      //   25: aload_0
      //   26: iconst_0
      //   27: putfield 135	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mda	Z
      //   30: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   33: astore 15
      //   35: aload 15
      //   37: monitorenter
      //   38: aload_0
      //   39: iconst_0
      //   40: putfield 81	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mde	Z
      //   43: aload 15
      //   45: monitorexit
      //   46: aload_0
      //   47: getfield 160	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcQ	Ljava/lang/Runnable;
      //   50: ifnull +12 -> 62
      //   53: aload_0
      //   54: getfield 160	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcQ	Ljava/lang/Runnable;
      //   57: invokeinterface 165 1 0
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
      //   92: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
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
      //   113: getfield 167	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcT	Z
      //   116: ifeq +41 -> 157
      //   119: aload_0
      //   120: getfield 169	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcP	Ljava/lang/Runnable;
      //   123: ifnull +12 -> 135
      //   126: aload_0
      //   127: getfield 169	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcP	Ljava/lang/Runnable;
      //   130: invokeinterface 165 1 0
      //   135: aload 16
      //   137: monitorexit
      //   138: ldc 154
      //   140: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   143: return
      //   144: astore 16
      //   146: aload 15
      //   148: monitorexit
      //   149: ldc 154
      //   151: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   154: aload 16
      //   156: athrow
      //   157: aload_0
      //   158: getfield 171	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:cgD	Z
      //   161: ifne +66 -> 227
      //   164: aload_0
      //   165: getfield 137	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mdb	Z
      //   168: ifeq +59 -> 227
      //   171: aload_0
      //   172: getfield 64	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mdg	Ljava/util/LinkedList;
      //   175: invokevirtual 175	java/util/LinkedList:isEmpty	()Z
      //   178: ifne +49 -> 227
      //   181: aload_0
      //   182: getfield 64	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mdg	Ljava/util/LinkedList;
      //   185: iconst_0
      //   186: invokevirtual 179	java/util/LinkedList:remove	(I)Ljava/lang/Object;
      //   189: checkcast 162	java/lang/Runnable
      //   192: astore 15
      //   194: aload 16
      //   196: monitorexit
      //   197: aload 15
      //   199: ifnull +974 -> 1173
      //   202: aload 15
      //   204: invokeinterface 165 1 0
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
      //   231: getfield 171	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:cgD	Z
      //   234: aload_0
      //   235: getfield 181	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcV	Z
      //   238: if_icmpeq +95 -> 333
      //   241: aload_0
      //   242: getfield 181	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcV	Z
      //   245: istore 14
      //   247: aload_0
      //   248: aload_0
      //   249: getfield 181	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcV	Z
      //   252: putfield 171	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:cgD	Z
      //   255: iload 14
      //   257: ifeq +472 -> 729
      //   260: aload_0
      //   261: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcI	Ljava/lang/ref/WeakReference;
      //   264: invokevirtual 187	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   267: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   270: astore 17
      //   272: aload 17
      //   274: ifnull +13 -> 287
      //   277: aload 17
      //   279: invokestatic 190	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:i	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$o;
      //   282: invokeinterface 195 1 0
      //   287: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   290: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   293: ldc 197
      //   295: new 85	java/lang/StringBuilder
      //   298: dup
      //   299: ldc 199
      //   301: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   304: aload_0
      //   305: getfield 171	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:cgD	Z
      //   308: invokevirtual 202	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   311: ldc 204
      //   313: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   316: aload_0
      //   317: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   320: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   323: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   326: iconst_0
      //   327: anewarray 68	java/lang/Object
      //   330: invokestatic 212	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   333: aload_0
      //   334: getfield 214	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mdc	Z
      //   337: ifeq +46 -> 383
      //   340: ldc 197
      //   342: new 85	java/lang/StringBuilder
      //   345: dup
      //   346: ldc 216
      //   348: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   351: aload_0
      //   352: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   355: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   358: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   361: iconst_0
      //   362: anewarray 68	java/lang/Object
      //   365: invokestatic 212	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   368: aload_0
      //   369: invokespecial 218	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aTQ	()V
      //   372: aload_0
      //   373: invokespecial 220	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aTR	()V
      //   376: aload_0
      //   377: iconst_0
      //   378: putfield 214	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mdc	Z
      //   381: iconst_1
      //   382: istore_1
      //   383: iload 5
      //   385: istore 12
      //   387: iload 5
      //   389: ifeq +14 -> 403
      //   392: aload_0
      //   393: invokespecial 218	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aTQ	()V
      //   396: aload_0
      //   397: invokespecial 220	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aTR	()V
      //   400: iconst_0
      //   401: istore 12
      //   403: iload 14
      //   405: ifeq +42 -> 447
      //   408: aload_0
      //   409: getfield 135	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mda	Z
      //   412: ifeq +35 -> 447
      //   415: ldc 197
      //   417: new 85	java/lang/StringBuilder
      //   420: dup
      //   421: ldc 222
      //   423: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   426: aload_0
      //   427: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   430: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   433: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   436: iconst_0
      //   437: anewarray 68	java/lang/Object
      //   440: invokestatic 212	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   443: aload_0
      //   444: invokespecial 218	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aTQ	()V
      //   447: iload 14
      //   449: ifeq +67 -> 516
      //   452: aload_0
      //   453: getfield 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcZ	Z
      //   456: ifeq +60 -> 516
      //   459: aload_0
      //   460: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcI	Ljava/lang/ref/WeakReference;
      //   463: invokevirtual 187	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   466: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   469: astore 17
      //   471: aload 17
      //   473: ifnonnull +347 -> 820
      //   476: iconst_0
      //   477: istore 14
      //   479: iload 14
      //   481: ifne +35 -> 516
      //   484: aload_0
      //   485: invokespecial 220	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aTR	()V
      //   488: ldc 197
      //   490: new 85	java/lang/StringBuilder
      //   493: dup
      //   494: ldc 224
      //   496: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   499: aload_0
      //   500: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   503: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   506: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   509: iconst_0
      //   510: anewarray 68	java/lang/Object
      //   513: invokestatic 212	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   516: aload_0
      //   517: getfield 132	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcW	Z
      //   520: ifne +65 -> 585
      //   523: aload_0
      //   524: getfield 226	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcY	Z
      //   527: ifne +58 -> 585
      //   530: ldc 197
      //   532: new 85	java/lang/StringBuilder
      //   535: dup
      //   536: ldc 228
      //   538: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   541: aload_0
      //   542: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   545: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   548: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   551: iconst_0
      //   552: anewarray 68	java/lang/Object
      //   555: invokestatic 212	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   558: aload_0
      //   559: getfield 135	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mda	Z
      //   562: ifeq +7 -> 569
      //   565: aload_0
      //   566: invokespecial 218	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aTQ	()V
      //   569: aload_0
      //   570: iconst_1
      //   571: putfield 226	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcY	Z
      //   574: aload_0
      //   575: iconst_0
      //   576: putfield 230	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcX	Z
      //   579: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   582: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   585: aload_0
      //   586: getfield 132	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcW	Z
      //   589: ifeq +49 -> 638
      //   592: aload_0
      //   593: getfield 226	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcY	Z
      //   596: ifeq +42 -> 638
      //   599: ldc 197
      //   601: new 85	java/lang/StringBuilder
      //   604: dup
      //   605: ldc 232
      //   607: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   610: aload_0
      //   611: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   614: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   617: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   620: iconst_0
      //   621: anewarray 68	java/lang/Object
      //   624: invokestatic 212	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   627: aload_0
      //   628: iconst_0
      //   629: putfield 226	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcY	Z
      //   632: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   635: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   638: iload 4
      //   640: istore 13
      //   642: iload 4
      //   644: ifeq +50 -> 694
      //   647: ldc 197
      //   649: new 85	java/lang/StringBuilder
      //   652: dup
      //   653: ldc 234
      //   655: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   658: aload_0
      //   659: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   662: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   665: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   668: iconst_0
      //   669: anewarray 68	java/lang/Object
      //   672: invokestatic 212	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   675: aload_0
      //   676: iconst_0
      //   677: putfield 81	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mde	Z
      //   680: iconst_0
      //   681: istore 13
      //   683: aload_0
      //   684: iconst_1
      //   685: putfield 236	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mdf	Z
      //   688: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   691: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   694: aload_0
      //   695: getfield 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcZ	Z
      //   698: ifne +179 -> 877
      //   701: ldc 197
      //   703: ldc 238
      //   705: iconst_0
      //   706: anewarray 68	java/lang/Object
      //   709: invokestatic 212	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   730: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcI	Ljava/lang/ref/WeakReference;
      //   733: invokevirtual 187	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   736: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   739: astore 17
      //   741: aload 17
      //   743: ifnull -456 -> 287
      //   746: aload 17
      //   748: invokestatic 190	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:i	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$o;
      //   751: invokeinterface 241 1 0
      //   756: goto -469 -> 287
      //   759: astore 15
      //   761: aload 16
      //   763: monitorexit
      //   764: ldc 154
      //   766: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   769: aload 15
      //   771: athrow
      //   772: astore 15
      //   774: ldc 197
      //   776: aload 15
      //   778: ldc 243
      //   780: iconst_0
      //   781: anewarray 68	java/lang/Object
      //   784: invokestatic 247	com/tencent/mm/dynamicbackground/a/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   787: aload_0
      //   788: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcI	Ljava/lang/ref/WeakReference;
      //   791: invokevirtual 187	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   794: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   797: astore 15
      //   799: aload 15
      //   801: ifnull +13 -> 814
      //   804: aload 15
      //   806: invokestatic 190	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:i	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$o;
      //   809: invokeinterface 250 1 0
      //   814: ldc 154
      //   816: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   819: return
      //   820: aload 17
      //   822: invokestatic 253	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:j	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Z
      //   825: istore 14
      //   827: goto -348 -> 479
      //   830: aload_0
      //   831: getfield 129	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mdj	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i;
      //   834: invokevirtual 254	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:start	()V
      //   837: aload_0
      //   838: iconst_1
      //   839: putfield 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcZ	Z
      //   842: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   845: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   848: iconst_1
      //   849: istore_3
      //   850: iload 13
      //   852: istore 4
      //   854: iload 12
      //   856: istore 5
      //   858: goto -664 -> 194
      //   861: astore 15
      //   863: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   866: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   869: ldc 154
      //   871: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   874: aload 15
      //   876: athrow
      //   877: aload_0
      //   878: invokespecial 257	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aTT	()Z
      //   881: ifeq +1649 -> 2530
      //   884: iload_3
      //   885: istore 4
      //   887: aload_0
      //   888: getfield 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcZ	Z
      //   891: ifne +1648 -> 2539
      //   894: ldc 197
      //   896: ldc 238
      //   898: iconst_0
      //   899: anewarray 68	java/lang/Object
      //   902: invokestatic 212	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   923: getfield 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcZ	Z
      //   926: ifeq +47 -> 973
      //   929: iload_2
      //   930: istore 5
      //   932: iload 7
      //   934: istore 4
      //   936: iload 6
      //   938: istore 8
      //   940: aload_0
      //   941: getfield 135	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mda	Z
      //   944: ifne +29 -> 973
      //   947: ldc 197
      //   949: ldc_w 259
      //   952: iconst_0
      //   953: anewarray 68	java/lang/Object
      //   956: invokestatic 212	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   959: aload_0
      //   960: iconst_1
      //   961: putfield 135	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mda	Z
      //   964: iconst_1
      //   965: istore 4
      //   967: iconst_1
      //   968: istore 8
      //   970: iconst_1
      //   971: istore 5
      //   973: aload_0
      //   974: getfield 135	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mda	Z
      //   977: ifeq +156 -> 1133
      //   980: aload_0
      //   981: getfield 66	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mdh	Z
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
      //   1003: putfield 81	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mde	Z
      //   1006: ldc 197
      //   1008: new 85	java/lang/StringBuilder
      //   1011: dup
      //   1012: ldc_w 261
      //   1015: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1018: aload_0
      //   1019: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   1022: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1025: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1028: iconst_0
      //   1029: anewarray 68	java/lang/Object
      //   1032: invokestatic 212	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1035: iconst_1
      //   1036: istore 7
      //   1038: aload_0
      //   1039: iconst_0
      //   1040: putfield 66	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mdh	Z
      //   1043: aload_0
      //   1044: iconst_0
      //   1045: putfield 77	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mdd	Z
      //   1048: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1051: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   1054: aload_0
      //   1055: getfield 81	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mde	Z
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
      //   1094: getfield 129	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mdj	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i;
      //   1097: invokevirtual 254	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:start	()V
      //   1100: aload_0
      //   1101: iconst_1
      //   1102: putfield 141	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcZ	Z
      //   1105: iconst_1
      //   1106: istore 4
      //   1108: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1111: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   1114: goto +1425 -> 2539
      //   1117: astore 15
      //   1119: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1122: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   1125: ldc 154
      //   1127: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1130: aload 15
      //   1132: athrow
      //   1133: ldc 197
      //   1135: ldc_w 263
      //   1138: iconst_0
      //   1139: anewarray 68	java/lang/Object
      //   1142: invokestatic 266	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1145: iload 8
      //   1147: istore 6
      //   1149: iload 4
      //   1151: istore 7
      //   1153: iload 5
      //   1155: istore_2
      //   1156: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1159: invokevirtual 269	java/lang/Object:wait	()V
      //   1162: iload 13
      //   1164: istore 4
      //   1166: iload 12
      //   1168: istore 5
      //   1170: goto -1058 -> 112
      //   1173: iload 7
      //   1175: ifeq +1313 -> 2488
      //   1178: ldc 197
      //   1180: ldc_w 271
      //   1183: iconst_0
      //   1184: anewarray 68	java/lang/Object
      //   1187: invokestatic 274	com/tencent/mm/dynamicbackground/a/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1190: aload_0
      //   1191: getfield 129	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mdj	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i;
      //   1194: astore 16
      //   1196: ldc 197
      //   1198: new 85	java/lang/StringBuilder
      //   1201: dup
      //   1202: ldc_w 276
      //   1205: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1208: invokestatic 280	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1211: invokevirtual 281	java/lang/Thread:getId	()J
      //   1214: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1217: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1220: iconst_0
      //   1221: anewarray 68	java/lang/Object
      //   1224: invokestatic 274	com/tencent/mm/dynamicbackground/a/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1227: aload 16
      //   1229: getfield 285	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcJ	Ljavax/microedition/khronos/egl/EGL10;
      //   1232: ifnonnull +23 -> 1255
      //   1235: new 151	java/lang/RuntimeException
      //   1238: dup
      //   1239: ldc_w 287
      //   1242: invokespecial 288	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1245: astore 15
      //   1247: ldc 154
      //   1249: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1252: aload 15
      //   1254: athrow
      //   1255: aload 16
      //   1257: getfield 292	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcK	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1260: ifnonnull +23 -> 1283
      //   1263: new 151	java/lang/RuntimeException
      //   1266: dup
      //   1267: ldc_w 294
      //   1270: invokespecial 288	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1273: astore 15
      //   1275: ldc 154
      //   1277: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1280: aload 15
      //   1282: athrow
      //   1283: aload 16
      //   1285: getfield 298	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcM	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1288: ifnonnull +23 -> 1311
      //   1291: new 151	java/lang/RuntimeException
      //   1294: dup
      //   1295: ldc_w 300
      //   1298: invokespecial 288	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1301: astore 15
      //   1303: ldc 154
      //   1305: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1308: aload 15
      //   1310: athrow
      //   1311: aload 16
      //   1313: invokevirtual 303	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:aTP	()V
      //   1316: aload 16
      //   1318: getfield 304	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcI	Ljava/lang/ref/WeakReference;
      //   1321: invokevirtual 187	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1324: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   1327: astore 17
      //   1329: aload 17
      //   1331: ifnull +352 -> 1683
      //   1334: aload 16
      //   1336: aload 17
      //   1338: invokestatic 308	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:f	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$h;
      //   1341: aload 16
      //   1343: getfield 285	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcJ	Ljavax/microedition/khronos/egl/EGL10;
      //   1346: aload 16
      //   1348: getfield 292	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcK	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1351: aload 16
      //   1353: getfield 298	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcM	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1356: aload 17
      //   1358: invokevirtual 312	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:getHolder	()Landroid/view/SurfaceHolder;
      //   1361: invokeinterface 318 5 0
      //   1366: putfield 322	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcL	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1369: aload 16
      //   1371: getfield 322	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcL	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1374: ifnull +14 -> 1388
      //   1377: aload 16
      //   1379: getfield 322	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcL	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1382: getstatic 327	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1385: if_acmpne +307 -> 1692
      //   1388: aload 16
      //   1390: getfield 285	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcJ	Ljavax/microedition/khronos/egl/EGL10;
      //   1393: invokeinterface 331 1 0
      //   1398: sipush 12299
      //   1401: if_icmpne +1144 -> 2545
      //   1404: ldc 197
      //   1406: ldc_w 333
      //   1409: iconst_0
      //   1410: anewarray 68	java/lang/Object
      //   1413: invokestatic 266	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1416: goto +1129 -> 2545
      //   1419: iload 8
      //   1421: ifeq +380 -> 1801
      //   1424: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1427: astore 16
      //   1429: aload 16
      //   1431: monitorenter
      //   1432: aload_0
      //   1433: iconst_1
      //   1434: putfield 137	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mdb	Z
      //   1437: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1440: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   1443: aload 16
      //   1445: monitorexit
      //   1446: iload_3
      //   1447: ifne +1104 -> 2551
      //   1450: ldc 197
      //   1452: ldc_w 335
      //   1455: iconst_0
      //   1456: anewarray 68	java/lang/Object
      //   1459: invokestatic 212	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1462: aload_0
      //   1463: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcI	Ljava/lang/ref/WeakReference;
      //   1466: invokevirtual 187	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1469: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   1472: astore 16
      //   1474: aload 16
      //   1476: ifnull +1075 -> 2551
      //   1479: aload 16
      //   1481: invokestatic 190	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:i	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$o;
      //   1484: invokeinterface 338 1 0
      //   1489: goto +1062 -> 2551
      //   1492: iload 6
      //   1494: istore 8
      //   1496: iload 6
      //   1498: ifeq +127 -> 1625
      //   1501: ldc 197
      //   1503: ldc_w 340
      //   1506: iconst_0
      //   1507: anewarray 68	java/lang/Object
      //   1510: invokestatic 274	com/tencent/mm/dynamicbackground/a/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1513: aload_0
      //   1514: getfield 129	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mdj	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i;
      //   1517: astore 17
      //   1519: aload 17
      //   1521: getfield 344	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcN	Ljavax/microedition/khronos/egl/EGLContext;
      //   1524: invokevirtual 350	javax/microedition/khronos/egl/EGLContext:getGL	()Ljavax/microedition/khronos/opengles/GL;
      //   1527: astore 16
      //   1529: aload 17
      //   1531: getfield 304	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcI	Ljava/lang/ref/WeakReference;
      //   1534: invokevirtual 187	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1537: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   1540: astore 17
      //   1542: aload 17
      //   1544: ifnull +1013 -> 2557
      //   1547: aload 17
      //   1549: invokestatic 354	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:g	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$m;
      //   1552: ifnull +15 -> 1567
      //   1555: aload 17
      //   1557: invokestatic 354	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:g	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$m;
      //   1560: invokeinterface 359 1 0
      //   1565: astore 16
      //   1567: aload 17
      //   1569: invokestatic 363	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:h	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)I
      //   1572: iconst_3
      //   1573: iand
      //   1574: ifeq +983 -> 2557
      //   1577: iconst_0
      //   1578: istore 6
      //   1580: aload 17
      //   1582: invokestatic 363	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:h	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)I
      //   1585: iconst_1
      //   1586: iand
      //   1587: ifeq +6 -> 1593
      //   1590: iconst_1
      //   1591: istore 6
      //   1593: aload 17
      //   1595: invokestatic 363	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:h	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)I
      //   1598: iconst_2
      //   1599: iand
      //   1600: ifeq +933 -> 2533
      //   1603: new 365	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$n
      //   1606: dup
      //   1607: invokespecial 366	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$n:<init>	()V
      //   1610: astore 17
      //   1612: aload 16
      //   1614: iload 6
      //   1616: aload 17
      //   1618: invokestatic 372	android/opengl/GLDebugHelper:wrap	(Ljavax/microedition/khronos/opengles/GL;ILjava/io/Writer;)Ljavax/microedition/khronos/opengles/GL;
      //   1621: pop
      //   1622: goto +935 -> 2557
      //   1625: iload_3
      //   1626: ifeq +11 -> 1637
      //   1629: aload_0
      //   1630: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcI	Ljava/lang/ref/WeakReference;
      //   1633: invokevirtual 187	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1636: pop
      //   1637: iload_3
      //   1638: ifeq +245 -> 1883
      //   1641: ldc 197
      //   1643: ldc_w 374
      //   1646: iconst_0
      //   1647: anewarray 68	java/lang/Object
      //   1650: invokestatic 274	com/tencent/mm/dynamicbackground/a/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1653: aload_0
      //   1654: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcI	Ljava/lang/ref/WeakReference;
      //   1657: invokevirtual 187	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1660: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   1663: astore 16
      //   1665: aload 16
      //   1667: ifnull +201 -> 1868
      //   1670: aload 16
      //   1672: invokestatic 190	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:i	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$o;
      //   1675: invokeinterface 377 1 0
      //   1680: goto +883 -> 2563
      //   1683: aload 16
      //   1685: aconst_null
      //   1686: putfield 322	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcL	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1689: goto -320 -> 1369
      //   1692: aload 16
      //   1694: getfield 285	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcJ	Ljavax/microedition/khronos/egl/EGL10;
      //   1697: aload 16
      //   1699: getfield 292	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcK	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1702: aload 16
      //   1704: getfield 322	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcL	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1707: aload 16
      //   1709: getfield 322	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcL	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1712: aload 16
      //   1714: getfield 344	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcN	Ljavax/microedition/khronos/egl/EGLContext;
      //   1717: invokeinterface 381 5 0
      //   1722: ifne +28 -> 1750
      //   1725: ldc_w 383
      //   1728: ldc_w 384
      //   1731: aload 16
      //   1733: getfield 285	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcJ	Ljavax/microedition/khronos/egl/EGL10;
      //   1736: invokeinterface 331 1 0
      //   1741: invokestatic 387	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:j	(Ljava/lang/String;Ljava/lang/String;I)V
      //   1744: iconst_0
      //   1745: istore 8
      //   1747: goto -328 -> 1419
      //   1750: aload 16
      //   1752: getfield 390	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcO	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1755: ifnull +829 -> 2584
      //   1758: aload 16
      //   1760: getfield 285	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcJ	Ljavax/microedition/khronos/egl/EGL10;
      //   1763: aload 16
      //   1765: getfield 292	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcK	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1768: aload 16
      //   1770: getfield 390	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcO	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1773: invokeinterface 394 3 0
      //   1778: pop
      //   1779: aload 16
      //   1781: aconst_null
      //   1782: putfield 390	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcO	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1785: goto +799 -> 2584
      //   1788: astore 15
      //   1790: aload 16
      //   1792: monitorexit
      //   1793: ldc 154
      //   1795: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1798: aload 15
      //   1800: athrow
      //   1801: ldc 197
      //   1803: ldc_w 396
      //   1806: iconst_0
      //   1807: anewarray 68	java/lang/Object
      //   1810: invokestatic 266	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1813: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1816: astore 16
      //   1818: aload 16
      //   1820: monitorenter
      //   1821: aload_0
      //   1822: iconst_1
      //   1823: putfield 137	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mdb	Z
      //   1826: aload_0
      //   1827: iconst_1
      //   1828: putfield 230	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcX	Z
      //   1831: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   1834: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   1837: aload 16
      //   1839: monitorexit
      //   1840: iload_2
      //   1841: istore 8
      //   1843: iload 7
      //   1845: istore_2
      //   1846: iload_1
      //   1847: istore 7
      //   1849: iload 8
      //   1851: istore_1
      //   1852: goto -1760 -> 92
      //   1855: astore 15
      //   1857: aload 16
      //   1859: monitorexit
      //   1860: ldc 154
      //   1862: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1865: aload 15
      //   1867: athrow
      //   1868: ldc 197
      //   1870: ldc_w 398
      //   1873: iconst_0
      //   1874: anewarray 68	java/lang/Object
      //   1877: invokestatic 266	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1880: goto +683 -> 2563
      //   1883: iload_2
      //   1884: ifeq +601 -> 2485
      //   1887: ldc 197
      //   1889: new 85	java/lang/StringBuilder
      //   1892: dup
      //   1893: ldc_w 400
      //   1896: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1899: iload 10
      //   1901: invokevirtual 403	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1904: ldc_w 405
      //   1907: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1910: iload 11
      //   1912: invokevirtual 403	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1915: ldc_w 407
      //   1918: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1921: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1924: iconst_0
      //   1925: anewarray 68	java/lang/Object
      //   1928: invokestatic 274	com/tencent/mm/dynamicbackground/a/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1931: aload_0
      //   1932: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcI	Ljava/lang/ref/WeakReference;
      //   1935: invokevirtual 187	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1938: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   1941: astore 16
      //   1943: aload 16
      //   1945: ifnull +645 -> 2590
      //   1948: aload 16
      //   1950: invokestatic 190	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:i	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$o;
      //   1953: iload 10
      //   1955: iload 11
      //   1957: invokeinterface 411 3 0
      //   1962: ldc 197
      //   1964: ldc_w 413
      //   1967: iconst_0
      //   1968: anewarray 68	java/lang/Object
      //   1971: invokestatic 266	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1974: goto +616 -> 2590
      //   1977: aload_0
      //   1978: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcI	Ljava/lang/ref/WeakReference;
      //   1981: invokevirtual 187	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1984: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   1987: astore 17
      //   1989: aload 17
      //   1991: ifnull +63 -> 2054
      //   1994: aload 17
      //   1996: invokestatic 190	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:i	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$o;
      //   1999: invokeinterface 416 1 0
      //   2004: invokestatic 420	java/lang/Thread:sleep	(J)V
      //   2007: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   2010: astore 16
      //   2012: aload 16
      //   2014: monitorenter
      //   2015: aload_0
      //   2016: getfield 71	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mdi	Ljava/lang/Object;
      //   2019: astore 18
      //   2021: aload 18
      //   2023: monitorenter
      //   2024: aload_0
      //   2025: invokespecial 257	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aTT	()Z
      //   2028: ifeq +307 -> 2335
      //   2031: aload_0
      //   2032: getfield 181	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcV	Z
      //   2035: ifne +300 -> 2335
      //   2038: aload 17
      //   2040: invokestatic 190	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:i	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$o;
      //   2043: invokeinterface 423 1 0
      //   2048: aload 18
      //   2050: monitorexit
      //   2051: aload 16
      //   2053: monitorexit
      //   2054: aload_0
      //   2055: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcI	Ljava/lang/ref/WeakReference;
      //   2058: invokevirtual 187	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   2061: pop
      //   2062: sipush 12288
      //   2065: istore 12
      //   2067: iconst_1
      //   2068: istore 14
      //   2070: aload_0
      //   2071: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcI	Ljava/lang/ref/WeakReference;
      //   2074: invokevirtual 187	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   2077: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   2080: astore 16
      //   2082: aload 16
      //   2084: ifnull +10 -> 2094
      //   2087: aload 16
      //   2089: invokevirtual 426	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:getIsSwapNow	()Z
      //   2092: istore 14
      //   2094: iload 14
      //   2096: ifeq +107 -> 2203
      //   2099: aload_0
      //   2100: getfield 129	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mdj	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i;
      //   2103: astore 17
      //   2105: sipush 12288
      //   2108: istore 6
      //   2110: iload 6
      //   2112: istore 12
      //   2114: aload 17
      //   2116: getfield 292	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcK	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   2119: ifnull +84 -> 2203
      //   2122: iload 6
      //   2124: istore 12
      //   2126: aload 17
      //   2128: getfield 292	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcK	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   2131: getstatic 429	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   2134: if_acmpeq +69 -> 2203
      //   2137: iload 6
      //   2139: istore 12
      //   2141: aload 17
      //   2143: getfield 322	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcL	Ljavax/microedition/khronos/egl/EGLSurface;
      //   2146: ifnull +57 -> 2203
      //   2149: iload 6
      //   2151: istore 12
      //   2153: aload 17
      //   2155: getfield 322	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcL	Ljavax/microedition/khronos/egl/EGLSurface;
      //   2158: getstatic 327	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
      //   2161: if_acmpeq +42 -> 2203
      //   2164: iload 6
      //   2166: istore 12
      //   2168: aload 17
      //   2170: getfield 285	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcJ	Ljavax/microedition/khronos/egl/EGL10;
      //   2173: aload 17
      //   2175: getfield 292	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcK	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   2178: aload 17
      //   2180: getfield 322	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcL	Ljavax/microedition/khronos/egl/EGLSurface;
      //   2183: invokeinterface 432 3 0
      //   2188: ifne +15 -> 2203
      //   2191: aload 17
      //   2193: getfield 285	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:mcJ	Ljavax/microedition/khronos/egl/EGL10;
      //   2196: invokeinterface 331 1 0
      //   2201: istore 12
      //   2203: aload 16
      //   2205: ifnull +390 -> 2595
      //   2208: aload 16
      //   2210: iconst_1
      //   2211: invokevirtual 436	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:setSwapNow	(Z)V
      //   2214: goto +381 -> 2595
      //   2217: ldc_w 438
      //   2220: ldc_w 439
      //   2223: iload 12
      //   2225: invokestatic 387	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$i:j	(Ljava/lang/String;Ljava/lang/String;I)V
      //   2228: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   2231: astore 16
      //   2233: aload 16
      //   2235: monitorenter
      //   2236: aload_0
      //   2237: iconst_1
      //   2238: putfield 230	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcX	Z
      //   2241: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   2244: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   2247: aload 16
      //   2249: monitorexit
      //   2250: iload 5
      //   2252: istore 6
      //   2254: iload 9
      //   2256: ifeq +218 -> 2474
      //   2259: iconst_1
      //   2260: istore 5
      //   2262: iconst_0
      //   2263: istore 4
      //   2265: iload 4
      //   2267: istore 9
      //   2269: iload_2
      //   2270: istore 12
      //   2272: iload 7
      //   2274: istore_2
      //   2275: iload 5
      //   2277: istore 4
      //   2279: iload 6
      //   2281: istore 5
      //   2283: iload_1
      //   2284: istore 7
      //   2286: iload 8
      //   2288: istore 6
      //   2290: iload 12
      //   2292: istore_1
      //   2293: goto -2201 -> 92
      //   2296: astore 15
      //   2298: ldc 197
      //   2300: ldc_w 413
      //   2303: iconst_0
      //   2304: anewarray 68	java/lang/Object
      //   2307: invokestatic 266	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2310: ldc 154
      //   2312: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2315: aload 15
      //   2317: athrow
      //   2318: astore 16
      //   2320: ldc 197
      //   2322: ldc_w 441
      //   2325: iconst_0
      //   2326: anewarray 68	java/lang/Object
      //   2329: invokestatic 274	com/tencent/mm/dynamicbackground/a/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2332: goto -325 -> 2007
      //   2335: ldc 197
      //   2337: ldc_w 443
      //   2340: iconst_4
      //   2341: anewarray 68	java/lang/Object
      //   2344: dup
      //   2345: iconst_0
      //   2346: aload_0
      //   2347: getfield 181	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcV	Z
      //   2350: invokestatic 449	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   2353: aastore
      //   2354: dup
      //   2355: iconst_1
      //   2356: aload_0
      //   2357: getfield 171	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:cgD	Z
      //   2360: invokestatic 449	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   2363: aastore
      //   2364: dup
      //   2365: iconst_2
      //   2366: aload_0
      //   2367: getfield 132	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcW	Z
      //   2370: invokestatic 449	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   2373: aastore
      //   2374: dup
      //   2375: iconst_3
      //   2376: aload_0
      //   2377: getfield 230	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcX	Z
      //   2380: invokestatic 449	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   2383: aastore
      //   2384: invokestatic 212	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2387: goto -339 -> 2048
      //   2390: astore 15
      //   2392: aload 18
      //   2394: monitorexit
      //   2395: ldc 154
      //   2397: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2400: aload 15
      //   2402: athrow
      //   2403: astore 15
      //   2405: aload 16
      //   2407: monitorexit
      //   2408: ldc 154
      //   2410: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2413: aload 15
      //   2415: athrow
      //   2416: ldc 197
      //   2418: new 85	java/lang/StringBuilder
      //   2421: dup
      //   2422: ldc_w 451
      //   2425: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   2428: aload_0
      //   2429: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   2432: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2435: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2438: iconst_0
      //   2439: anewarray 68	java/lang/Object
      //   2442: invokestatic 212	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2445: iconst_1
      //   2446: istore 6
      //   2448: goto -194 -> 2254
      //   2451: astore 15
      //   2453: aload 16
      //   2455: monitorexit
      //   2456: ldc 154
      //   2458: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2461: aload 15
      //   2463: athrow
      //   2464: astore 15
      //   2466: ldc 154
      //   2468: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2471: aload 15
      //   2473: athrow
      //   2474: iload 4
      //   2476: istore 5
      //   2478: iload 9
      //   2480: istore 4
      //   2482: goto -217 -> 2265
      //   2485: goto -508 -> 1977
      //   2488: goto -996 -> 1492
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
      //   2536: goto -924 -> 1612
      //   2539: iload 4
      //   2541: istore_3
      //   2542: goto -1631 -> 911
      //   2545: iconst_0
      //   2546: istore 8
      //   2548: goto -1129 -> 1419
      //   2551: iconst_0
      //   2552: istore 7
      //   2554: goto -1062 -> 1492
      //   2557: iconst_0
      //   2558: istore 8
      //   2560: goto -935 -> 1625
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
      //   2587: goto -1168 -> 1419
      //   2590: iconst_0
      //   2591: istore_2
      //   2592: goto -615 -> 1977
      //   2595: iload 5
      //   2597: istore 6
      //   2599: iload 12
      //   2601: lookupswitch	default:+27->2628, 12288:+-347->2254, 12302:+-185->2416
      //   2629: impdep1
      //   2630: lsub
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
      //   228	1867	14	bool	boolean
      //   33	178	15	localObject1	Object
      //   759	11	15	localObject2	Object
      //   772	5	15	localThrowable	Throwable
      //   797	8	15	localGameGLSurfaceView	GameGLSurfaceView
      //   861	14	15	localRuntimeException1	RuntimeException
      //   1117	14	15	localRuntimeException2	RuntimeException
      //   1245	64	15	localRuntimeException3	RuntimeException
      //   1788	11	15	localObject3	Object
      //   1855	11	15	localObject4	Object
      //   2296	20	15	localObject5	Object
      //   2390	11	15	localObject6	Object
      //   2403	11	15	localObject7	Object
      //   2451	11	15	localObject8	Object
      //   2464	8	15	localObject9	Object
      //   95	41	16	localk	GameGLSurfaceView.k
      //   144	618	16	localObject10	Object
      //   2318	136	16	localException	java.lang.Exception
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
      //   92	100	772	finally
      //   202	209	772	finally
      //   761	772	772	finally
      //   1178	1255	772	finally
      //   1255	1283	772	finally
      //   1283	1311	772	finally
      //   1311	1329	772	finally
      //   1334	1369	772	finally
      //   1369	1388	772	finally
      //   1388	1416	772	finally
      //   1424	1432	772	finally
      //   1450	1474	772	finally
      //   1479	1489	772	finally
      //   1501	1542	772	finally
      //   1547	1567	772	finally
      //   1567	1577	772	finally
      //   1580	1590	772	finally
      //   1593	1612	772	finally
      //   1612	1622	772	finally
      //   1629	1637	772	finally
      //   1641	1665	772	finally
      //   1670	1680	772	finally
      //   1683	1689	772	finally
      //   1692	1744	772	finally
      //   1750	1785	772	finally
      //   1790	1801	772	finally
      //   1801	1821	772	finally
      //   1857	1868	772	finally
      //   1868	1880	772	finally
      //   1887	1943	772	finally
      //   1962	1974	772	finally
      //   1977	1989	772	finally
      //   1994	2007	772	finally
      //   2007	2015	772	finally
      //   2054	2062	772	finally
      //   2070	2082	772	finally
      //   2087	2094	772	finally
      //   2099	2105	772	finally
      //   2114	2122	772	finally
      //   2126	2137	772	finally
      //   2141	2149	772	finally
      //   2153	2164	772	finally
      //   2168	2203	772	finally
      //   2208	2214	772	finally
      //   2217	2236	772	finally
      //   2298	2318	772	finally
      //   2320	2332	772	finally
      //   2405	2416	772	finally
      //   2416	2445	772	finally
      //   2453	2464	772	finally
      //   830	837	861	java/lang/RuntimeException
      //   1093	1100	1117	java/lang/RuntimeException
      //   1432	1446	1788	finally
      //   1821	1840	1855	finally
      //   1948	1962	2296	finally
      //   1994	2007	2318	java/lang/Exception
      //   2024	2048	2390	finally
      //   2048	2051	2390	finally
      //   2335	2387	2390	finally
      //   2015	2024	2403	finally
      //   2051	2054	2403	finally
      //   2392	2403	2403	finally
      //   2236	2250	2451	finally
      //   774	799	2464	finally
      //   804	814	2464	finally
    }
    
    private boolean aTT()
    {
      return (!this.cgD) && (this.mcW) && (!this.mcX) && (this.mWidth > 0) && (this.mHeight > 0) && ((this.mdd) || (this.mRenderMode == 1));
    }
    
    public final void aTU()
    {
      AppMethodBeat.i(233256);
      if (this.mcR.isAlive()) {
        this.mcS.sendEmptyMessage(5);
      }
      AppMethodBeat.o(233256);
    }
    
    public final int getRenderMode()
    {
      AppMethodBeat.i(103043);
      synchronized (GameGLSurfaceView.aTO())
      {
        int i = this.mRenderMode;
        AppMethodBeat.o(103043);
        return i;
      }
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc_w 479
      //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: new 85	java/lang/StringBuilder
      //   10: dup
      //   11: ldc 197
      //   13: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   16: aload_0
      //   17: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   20: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   23: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   26: invokevirtual 482	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:setName	(Ljava/lang/String;)V
      //   29: ldc 197
      //   31: new 85	java/lang/StringBuilder
      //   34: dup
      //   35: ldc_w 484
      //   38: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   41: aload_0
      //   42: invokevirtual 94	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:getId	()J
      //   45: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   48: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   51: iconst_0
      //   52: anewarray 68	java/lang/Object
      //   55: invokestatic 212	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   58: invokestatic 489	android/os/Process:myTid	()I
      //   61: bipush 248
      //   63: invokestatic 492	android/os/Process:setThreadPriority	(II)V
      //   66: aload_0
      //   67: invokespecial 494	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aTS	()V
      //   70: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   73: aload_0
      //   74: invokevirtual 499	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k:n	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j;)V
      //   77: ldc_w 479
      //   80: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   83: return
      //   84: astore_1
      //   85: ldc 197
      //   87: aload_1
      //   88: ldc_w 501
      //   91: iconst_0
      //   92: anewarray 68	java/lang/Object
      //   95: invokestatic 247	com/tencent/mm/dynamicbackground/a/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   98: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   101: aload_0
      //   102: invokevirtual 499	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k:n	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j;)V
      //   105: ldc_w 479
      //   108: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   111: return
      //   112: astore_1
      //   113: ldc 197
      //   115: ldc_w 503
      //   118: iconst_1
      //   119: anewarray 68	java/lang/Object
      //   122: dup
      //   123: iconst_0
      //   124: aload_1
      //   125: invokestatic 509	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   128: aastore
      //   129: invokestatic 266	com/tencent/mm/dynamicbackground/a/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   132: aload_0
      //   133: getfield 119	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:mcI	Ljava/lang/ref/WeakReference;
      //   136: invokevirtual 187	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   139: checkcast 6	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView
      //   142: astore_1
      //   143: aload_1
      //   144: ifnull +12 -> 156
      //   147: aload_1
      //   148: invokestatic 190	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:i	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;)Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$o;
      //   151: invokeinterface 250 1 0
      //   156: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   159: aload_0
      //   160: invokevirtual 499	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k:n	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j;)V
      //   163: ldc_w 479
      //   166: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   169: return
      //   170: astore_1
      //   171: invokestatic 145	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView:aTO	()Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k;
      //   174: aload_0
      //   175: invokevirtual 499	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$k:n	(Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j;)V
      //   178: ldc_w 479
      //   181: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   184: aload_1
      //   185: athrow
      //   186: astore_1
      //   187: goto -121 -> 66
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	190	0	this	j
      //   84	4	1	localInterruptedException	java.lang.InterruptedException
      //   112	13	1	localThrowable	Throwable
      //   142	6	1	localGameGLSurfaceView	GameGLSurfaceView
      //   170	15	1	localObject	Object
      //   186	1	1	localException	java.lang.Exception
      // Exception table:
      //   from	to	target	type
      //   66	70	84	java/lang/InterruptedException
      //   66	70	112	finally
      //   85	98	170	finally
      //   113	143	170	finally
      //   147	156	170	finally
      //   58	66	186	java/lang/Exception
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
      synchronized (GameGLSurfaceView.aTO())
      {
        this.mRenderMode = paramInt;
        GameGLSurfaceView.aTO().notifyAll();
        AppMethodBeat.o(103042);
        return;
      }
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
        AppMethodBeat.i(233211);
        for (;;)
        {
          synchronized (GameGLSurfaceView.aTO())
          {
            switch (paramMessage.what)
            {
            case 0: 
              AppMethodBeat.o(233211);
              return;
              c.i("MicroMsg.GLThread", "surfaceCreated tid=" + GameGLSurfaceView.j.this.getId(), new Object[0]);
              GameGLSurfaceView.j.a(GameGLSurfaceView.j.this, true);
              GameGLSurfaceView.j.b(GameGLSurfaceView.j.this);
              GameGLSurfaceView.aTO().notifyAll();
            }
          }
          c.i("MicroMsg.GLThread", "surfaceDestroyed tid=" + GameGLSurfaceView.j.this.getId(), new Object[0]);
          GameGLSurfaceView.j.a(GameGLSurfaceView.j.this, false);
          GameGLSurfaceView.aTO().notifyAll();
          continue;
          c.i("MicroMsg.GLThread", "onPause tid=" + GameGLSurfaceView.j.this.getId(), new Object[0]);
          GameGLSurfaceView.j.b(GameGLSurfaceView.j.this, true);
          GameGLSurfaceView.aTO().notifyAll();
          continue;
          c.i("MicroMsg.GLThread", "onResume tid=" + GameGLSurfaceView.j.this.getId(), new Object[0]);
          GameGLSurfaceView.j.b(GameGLSurfaceView.j.this, false);
          GameGLSurfaceView.j.c(GameGLSurfaceView.j.this);
          GameGLSurfaceView.j.d(GameGLSurfaceView.j.this);
          GameGLSurfaceView.aTO().notifyAll();
          continue;
          int i = paramMessage.arg1;
          int j = paramMessage.arg2;
          if ((GameGLSurfaceView.j.e(GameGLSurfaceView.j.this) == i) && (GameGLSurfaceView.j.f(GameGLSurfaceView.j.this) == j))
          {
            AppMethodBeat.o(233211);
            return;
          }
          c.i("MicroMsg.GLThread", "windowResize w:%d h:%d tid=", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(GameGLSurfaceView.j.this.getId()) });
          GameGLSurfaceView.j.a(GameGLSurfaceView.j.this, i);
          GameGLSurfaceView.j.b(GameGLSurfaceView.j.this, j);
          GameGLSurfaceView.j.g(GameGLSurfaceView.j.this);
          GameGLSurfaceView.j.c(GameGLSurfaceView.j.this);
          GameGLSurfaceView.j.d(GameGLSurfaceView.j.this);
          GameGLSurfaceView.aTO().notifyAll();
          continue;
          c.i("MicroMsg.GLThread", "requestExitAndWaitForDestroy tid=" + GameGLSurfaceView.j.this.getId(), new Object[0]);
          GameGLSurfaceView.j.h(GameGLSurfaceView.j.this);
          paramMessage = (GameGLSurfaceView)GameGLSurfaceView.j.i(GameGLSurfaceView.j.this).get();
          if (paramMessage != null) {
            GameGLSurfaceView.i(paramMessage).aTH();
          }
          GameGLSurfaceView.aTO().notifyAll();
          continue;
          c.i("MicroMsg.GLThread", "requestRender tid=" + GameGLSurfaceView.j.this.getId(), new Object[0]);
          GameGLSurfaceView.j.c(GameGLSurfaceView.j.this);
          GameGLSurfaceView.aTO().notifyAll();
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
            locali.aTP();
            GameGLSurfaceView.j.j(paramj);
            GameGLSurfaceView.j.k(paramj);
          }
        }
        finally {}
        try
        {
          locali = GameGLSurfaceView.j.a(paramj);
          c.w("MicroMsg.GLThread", "finish() tid=" + Thread.currentThread().getId(), new Object[0]);
          if (locali.mcN != null)
          {
            GameGLSurfaceView localGameGLSurfaceView2 = (GameGLSurfaceView)locali.mcI.get();
            if (localGameGLSurfaceView2 != null) {
              GameGLSurfaceView.e(localGameGLSurfaceView2).destroyContext(locali.mcJ, locali.mcK, locali.mcN);
            }
            locali.mcN = null;
          }
          if (locali.mcK != null)
          {
            locali.mcJ.eglTerminate(locali.mcK);
            locali.mcK = null;
          }
        }
        finally
        {
          c.e(TAG, "alvinluo GLThread#threadExiting finish stack = [%s]", new Object[] { Log.getStackTraceString(localThrowable) });
          if (localGameGLSurfaceView1 == null) {
            continue;
          }
          GameGLSurfaceView.i(localGameGLSurfaceView1).aTI();
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
    public abstract GL aTV();
  }
  
  static final class n
    extends Writer
  {
    private StringBuilder mBuilder;
    
    n()
    {
      AppMethodBeat.i(103048);
      this.mBuilder = new StringBuilder();
      AppMethodBeat.o(103048);
    }
    
    private void GF()
    {
      AppMethodBeat.i(103052);
      if (this.mBuilder.length() > 0)
      {
        c.v("GLSurfaceView", this.mBuilder.toString(), new Object[0]);
        this.mBuilder.delete(0, this.mBuilder.length());
      }
      AppMethodBeat.o(103052);
    }
    
    public final void close()
    {
      AppMethodBeat.i(103049);
      GF();
      AppMethodBeat.o(103049);
    }
    
    public final void flush()
    {
      AppMethodBeat.i(103050);
      GF();
      AppMethodBeat.o(103050);
    }
    
    public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(103051);
      int i = 0;
      if (i < paramInt2)
      {
        char c = paramArrayOfChar[(paramInt1 + i)];
        if (c == '\n') {
          GF();
        }
        for (;;)
        {
          i += 1;
          break;
          this.mBuilder.append(c);
        }
      }
      AppMethodBeat.o(103051);
    }
  }
  
  public static abstract interface o
  {
    public abstract void aTC();
    
    public abstract void aTD();
    
    public abstract long aTF();
    
    public abstract void aTG();
    
    public abstract void aTH();
    
    public abstract void aTI();
    
    public abstract void dF(int paramInt1, int paramInt2);
    
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.view.GameGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */