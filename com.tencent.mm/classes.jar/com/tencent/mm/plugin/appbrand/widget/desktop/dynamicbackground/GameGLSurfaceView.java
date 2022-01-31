package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import android.content.Context;
import android.opengl.GLException;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.Writer;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class GameGLSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback2
{
  private static final GameGLSurfaceView.k jhf;
  public GameGLSurfaceView.j jhg;
  private n jhh;
  private GameGLSurfaceView.e jhi;
  private GameGLSurfaceView.f jhj;
  private GameGLSurfaceView.h jhk;
  private GameGLSurfaceView.l jhl;
  private boolean jhm;
  private int mDebugFlags;
  private boolean mDetached;
  private int mEGLContextClientVersion;
  private boolean mPreserveEGLContextOnPause;
  private final WeakReference<GameGLSurfaceView> mThisWeakRef;
  
  static
  {
    AppMethodBeat.i(134114);
    jhf = new GameGLSurfaceView.k((byte)0);
    AppMethodBeat.o(134114);
  }
  
  public GameGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(134094);
    this.mThisWeakRef = new WeakReference(this);
    this.jhm = false;
    getHolder().addCallback(this);
    AppMethodBeat.o(134094);
  }
  
  private void checkRenderThreadState()
  {
    AppMethodBeat.i(134113);
    if (this.jhg != null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
      AppMethodBeat.o(134113);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(134113);
  }
  
  public final void aQc()
  {
    AppMethodBeat.i(134101);
    setEGLConfigChooser(new GameGLSurfaceView.b(this));
    AppMethodBeat.o(134101);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(134095);
    try
    {
      if (this.jhg != null) {
        this.jhg.aQg();
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(134095);
    }
  }
  
  public int getDebugFlags()
  {
    return this.mDebugFlags;
  }
  
  public boolean getIsSwapNow()
  {
    return this.jhm;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.mPreserveEGLContextOnPause;
  }
  
  public int getRenderMode()
  {
    AppMethodBeat.i(134104);
    int i = this.jhg.getRenderMode();
    AppMethodBeat.o(134104);
    return i;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(134111);
    super.onAttachedToWindow();
    c.c.i("MicroMsg.GameGLSurfaceView", "onAttachedToWindow reattach =" + this.mDetached, new Object[0]);
    if ((this.mDetached) && (this.jhh != null)) {
      if (this.jhg == null) {
        break label112;
      }
    }
    label112:
    for (int i = this.jhg.getRenderMode();; i = 1)
    {
      this.jhg = new GameGLSurfaceView.j(this.mThisWeakRef);
      if (i != 1) {
        this.jhg.setRenderMode(i);
      }
      this.jhg.start();
      this.mDetached = false;
      AppMethodBeat.o(134111);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(134112);
    c.c.i("MicroMsg.GameGLSurfaceView", "onDetachedFromWindow", new Object[0]);
    if (this.jhg != null) {
      this.jhg.aQg();
    }
    this.mDetached = true;
    super.onDetachedFromWindow();
    AppMethodBeat.o(134112);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(156897);
    this.jhg.onPause();
    AppMethodBeat.o(156897);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(134110);
    c.c.i("MicroMsg.GameGLSurfaceView", "onResume", new Object[0]);
    GameGLSurfaceView.j localj = this.jhg;
    synchronized (jhf)
    {
      c.c.i("MicroMsg.GLThread", "onResume tid=" + localj.getId(), new Object[0]);
      localj.mRequestPaused = false;
      localj.jhw = false;
      localj.mRequestRender = true;
      localj.mRenderComplete = false;
      jhf.notifyAll();
      for (;;)
      {
        if ((!localj.mExited) && (localj.mPaused) && (!localj.mRenderComplete))
        {
          c.c.i("MicroMsg.GLThread", "onResume waiting for !mPaused.", new Object[0]);
          try
          {
            jhf.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
    AppMethodBeat.o(134110);
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.mDebugFlags = paramInt;
  }
  
  public void setEGLConfigChooser(GameGLSurfaceView.e parame)
  {
    AppMethodBeat.i(134099);
    checkRenderThreadState();
    this.jhi = parame;
    AppMethodBeat.o(134099);
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    AppMethodBeat.i(134100);
    setEGLConfigChooser(new GameGLSurfaceView.o(this));
    AppMethodBeat.o(134100);
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    AppMethodBeat.i(134102);
    checkRenderThreadState();
    this.mEGLContextClientVersion = paramInt;
    AppMethodBeat.o(134102);
  }
  
  public void setEGLContextFactory(GameGLSurfaceView.f paramf)
  {
    AppMethodBeat.i(134097);
    checkRenderThreadState();
    this.jhj = paramf;
    AppMethodBeat.o(134097);
  }
  
  public void setEGLWindowSurfaceFactory(GameGLSurfaceView.h paramh)
  {
    AppMethodBeat.i(134098);
    checkRenderThreadState();
    this.jhk = paramh;
    AppMethodBeat.o(134098);
  }
  
  public void setFps(int paramInt) {}
  
  public void setGLWrapper(GameGLSurfaceView.l paraml)
  {
    this.jhl = paraml;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.mPreserveEGLContextOnPause = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(134103);
    this.jhg.setRenderMode(paramInt);
    AppMethodBeat.o(134103);
  }
  
  public void setRenderer(n paramn)
  {
    AppMethodBeat.i(134096);
    checkRenderThreadState();
    if (this.jhi == null) {
      this.jhi = new GameGLSurfaceView.o(this);
    }
    if (this.jhj == null) {
      this.jhj = new GameGLSurfaceView.c(this, (byte)0);
    }
    if (this.jhk == null) {
      this.jhk = new GameGLSurfaceView.d((byte)0);
    }
    this.jhh = paramn;
    this.jhg = new GameGLSurfaceView.j(this.mThisWeakRef);
    this.jhg.start();
    AppMethodBeat.o(134096);
  }
  
  public void setSwapNow(boolean paramBoolean)
  {
    this.jhm = paramBoolean;
  }
  
  public void surfaceChanged(SurfaceHolder arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(134107);
    GameGLSurfaceView.j localj = this.jhg;
    for (;;)
    {
      synchronized (jhf)
      {
        if ((localj.mWidth == paramInt2) && (localj.mHeight == paramInt3))
        {
          AppMethodBeat.o(134107);
          return;
        }
        localj.mWidth = paramInt2;
        localj.mHeight = paramInt3;
        localj.mSizeChanged = true;
        localj.mRequestRender = true;
        localj.mRenderComplete = false;
        localj.jhv = true;
        if (Thread.currentThread() == localj)
        {
          AppMethodBeat.o(134107);
          return;
        }
        jhf.notifyAll();
        if ((localj.mExited) || (localj.mPaused) || (localj.mRenderComplete)) {
          break;
        }
        if ((localj.mHaveEglContext) && (localj.mHaveEglSurface) && (localj.readyToDraw()))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break;
          }
          c.c.i("MicroMsg.GLThread", "onWindowResize waiting for render complete from tid=" + localj.getId(), new Object[0]);
          try
          {
            jhf.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
      paramInt1 = 0;
    }
    AppMethodBeat.o(134107);
  }
  
  public void surfaceCreated(SurfaceHolder arg1)
  {
    AppMethodBeat.i(134105);
    c.c.i("MicroMsg.GameGLSurfaceView", "alvinluo GameGLSurfaceView surfaceCreated", new Object[0]);
    GameGLSurfaceView.j localj = this.jhg;
    synchronized (jhf)
    {
      c.c.i("MicroMsg.GLThread", "surfaceCreated tid=" + localj.getId(), new Object[0]);
      localj.mHasSurface = true;
      localj.mFinishedCreatingEglSurface = false;
      localj.jhv = true;
      jhf.notifyAll();
      for (;;)
      {
        if ((localj.mWaitingForSurface) && (!localj.mFinishedCreatingEglSurface))
        {
          boolean bool = localj.mExited;
          if (!bool) {
            try
            {
              jhf.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(134105);
  }
  
  public void surfaceDestroyed(SurfaceHolder arg1)
  {
    AppMethodBeat.i(134106);
    GameGLSurfaceView.j localj = this.jhg;
    synchronized (jhf)
    {
      c.c.i("MicroMsg.GLThread", "surfaceDestroyed tid=" + localj.getId(), new Object[0]);
      localj.mHasSurface = false;
      localj.jhv = true;
      jhf.notifyAll();
      for (;;)
      {
        if (!localj.mWaitingForSurface)
        {
          boolean bool = localj.mExited;
          if (!bool) {
            try
            {
              jhf.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(134106);
  }
  
  public void surfaceRedrawNeeded(SurfaceHolder arg1)
  {
    AppMethodBeat.i(134108);
    if (this.jhg != null)
    {
      GameGLSurfaceView.j localj = this.jhg;
      synchronized (jhf)
      {
        localj.mRequestRender = true;
        jhf.notifyAll();
        AppMethodBeat.o(134108);
        return;
      }
    }
    AppMethodBeat.o(134108);
  }
  
  public static final class g
    implements EGL11
  {
    private EGL10 jho;
    Writer jhp;
    boolean jhq;
    boolean jhr;
    private int jhs;
    
    private void FD(String paramString)
    {
      AppMethodBeat.i(134050);
      log(paramString + '\n');
      AppMethodBeat.o(134050);
    }
    
    private void FE(String paramString)
    {
      AppMethodBeat.i(134061);
      log(" returns " + paramString + ";\n");
      flush();
      AppMethodBeat.o(134061);
    }
    
    private void a(String paramString, EGLContext paramEGLContext)
    {
      AppMethodBeat.i(134059);
      if (paramEGLContext == EGL10.EGL_NO_CONTEXT)
      {
        cY(paramString, "EGL10.EGL_NO_CONTEXT");
        AppMethodBeat.o(134059);
        return;
      }
      cY(paramString, toString(paramEGLContext));
      AppMethodBeat.o(134059);
    }
    
    private void a(String paramString, EGLDisplay paramEGLDisplay)
    {
      AppMethodBeat.i(134058);
      if (paramEGLDisplay == EGL10.EGL_DEFAULT_DISPLAY)
      {
        cY(paramString, "EGL10.EGL_DEFAULT_DISPLAY");
        AppMethodBeat.o(134058);
        return;
      }
      if (paramEGLDisplay == EGL_NO_DISPLAY)
      {
        cY(paramString, "EGL10.EGL_NO_DISPLAY");
        AppMethodBeat.o(134058);
        return;
      }
      cY(paramString, toString(paramEGLDisplay));
      AppMethodBeat.o(134058);
    }
    
    private void a(String paramString, EGLSurface paramEGLSurface)
    {
      AppMethodBeat.i(134060);
      if (paramEGLSurface == EGL10.EGL_NO_SURFACE)
      {
        cY(paramString, "EGL10.EGL_NO_SURFACE");
        AppMethodBeat.o(134060);
        return;
      }
      cY(paramString, toString(paramEGLSurface));
      AppMethodBeat.o(134060);
    }
    
    private void a(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(134066);
      if (paramArrayOfInt == null)
      {
        cY(paramString, "null");
        AppMethodBeat.o(134066);
        return;
      }
      cY(paramString, c(paramArrayOfInt.length, paramArrayOfInt));
      AppMethodBeat.o(134066);
    }
    
    private void bA(Object paramObject)
    {
      AppMethodBeat.i(134064);
      FE(toString(paramObject));
      AppMethodBeat.o(134064);
    }
    
    private void bB(String paramString, int paramInt)
    {
      AppMethodBeat.i(134056);
      cY(paramString, Integer.toString(paramInt));
      AppMethodBeat.o(134056);
    }
    
    private static String c(int paramInt, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(134068);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{\n");
      int j = paramArrayOfInt.length;
      int i = 0;
      if (i < paramInt)
      {
        int k = i + 0;
        localStringBuilder.append(" [" + k + "] = ");
        if ((k < 0) || (k >= j)) {
          localStringBuilder.append("out of bounds");
        }
        for (;;)
        {
          localStringBuilder.append('\n');
          i += 1;
          break;
          localStringBuilder.append(paramArrayOfInt[k]);
        }
      }
      localStringBuilder.append("}");
      paramArrayOfInt = localStringBuilder.toString();
      AppMethodBeat.o(134068);
      return paramArrayOfInt;
    }
    
    private void cY(String paramString1, String paramString2)
    {
      AppMethodBeat.i(134053);
      int i = this.jhs;
      this.jhs = (i + 1);
      if (i > 0) {
        log(", ");
      }
      if (this.jhq) {
        log(paramString1 + "=");
      }
      log(paramString2);
      AppMethodBeat.o(134053);
    }
    
    private void checkError()
    {
      AppMethodBeat.i(134049);
      int i = this.jho.eglGetError();
      if (i != 12288)
      {
        Object localObject = "eglError: " + getErrorString(i);
        FD((String)localObject);
        if (this.jhr)
        {
          localObject = new GLException(i, (String)localObject);
          AppMethodBeat.o(134049);
          throw ((Throwable)localObject);
        }
      }
      AppMethodBeat.o(134049);
    }
    
    private void end()
    {
      AppMethodBeat.i(134054);
      log(");\n");
      flush();
      AppMethodBeat.o(134054);
    }
    
    private static String f(int paramInt, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(134069);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{\n");
      int j = paramArrayOfObject.length;
      int i = 0;
      if (i < paramInt)
      {
        int k = i + 0;
        localStringBuilder.append(" [" + k + "] = ");
        if ((k < 0) || (k >= j)) {
          localStringBuilder.append("out of bounds");
        }
        for (;;)
        {
          localStringBuilder.append('\n');
          i += 1;
          break;
          localStringBuilder.append(paramArrayOfObject[k]);
        }
      }
      localStringBuilder.append("}");
      paramArrayOfObject = localStringBuilder.toString();
      AppMethodBeat.o(134069);
      return paramArrayOfObject;
    }
    
    private void fj(boolean paramBoolean)
    {
      AppMethodBeat.i(134063);
      FE(Boolean.toString(paramBoolean));
      AppMethodBeat.o(134063);
    }
    
    private void flush()
    {
      AppMethodBeat.i(134055);
      try
      {
        this.jhp.flush();
        AppMethodBeat.o(134055);
        return;
      }
      catch (IOException localIOException)
      {
        this.jhp = null;
        AppMethodBeat.o(134055);
      }
    }
    
    public static String getErrorString(int paramInt)
    {
      AppMethodBeat.i(134071);
      switch (paramInt)
      {
      default: 
        String str = qh(paramInt);
        AppMethodBeat.o(134071);
        return str;
      case 12288: 
        AppMethodBeat.o(134071);
        return "EGL_SUCCESS";
      case 12289: 
        AppMethodBeat.o(134071);
        return "EGL_NOT_INITIALIZED";
      case 12290: 
        AppMethodBeat.o(134071);
        return "EGL_BAD_ACCESS";
      case 12291: 
        AppMethodBeat.o(134071);
        return "EGL_BAD_ALLOC";
      case 12292: 
        AppMethodBeat.o(134071);
        return "EGL_BAD_ATTRIBUTE";
      case 12293: 
        AppMethodBeat.o(134071);
        return "EGL_BAD_CONFIG";
      case 12294: 
        AppMethodBeat.o(134071);
        return "EGL_BAD_CONTEXT";
      case 12295: 
        AppMethodBeat.o(134071);
        return "EGL_BAD_CURRENT_SURFACE";
      case 12296: 
        AppMethodBeat.o(134071);
        return "EGL_BAD_DISPLAY";
      case 12297: 
        AppMethodBeat.o(134071);
        return "EGL_BAD_MATCH";
      case 12298: 
        AppMethodBeat.o(134071);
        return "EGL_BAD_NATIVE_PIXMAP";
      case 12299: 
        AppMethodBeat.o(134071);
        return "EGL_BAD_NATIVE_WINDOW";
      case 12300: 
        AppMethodBeat.o(134071);
        return "EGL_BAD_PARAMETER";
      case 12301: 
        AppMethodBeat.o(134071);
        return "EGL_BAD_SURFACE";
      }
      AppMethodBeat.o(134071);
      return "EGL_CONTEXT_LOST";
    }
    
    private void log(String paramString)
    {
      AppMethodBeat.i(134051);
      try
      {
        this.jhp.write(paramString);
        AppMethodBeat.o(134051);
        return;
      }
      catch (IOException paramString)
      {
        AppMethodBeat.o(134051);
      }
    }
    
    private void m(String paramString, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(134067);
      if (paramArrayOfObject == null)
      {
        cY(paramString, "null");
        AppMethodBeat.o(134067);
        return;
      }
      cY(paramString, f(paramArrayOfObject.length, paramArrayOfObject));
      AppMethodBeat.o(134067);
    }
    
    private void o(String paramString, Object paramObject)
    {
      AppMethodBeat.i(134057);
      cY(paramString, toString(paramObject));
      AppMethodBeat.o(134057);
    }
    
    private void qg(int paramInt)
    {
      AppMethodBeat.i(134062);
      FE(Integer.toString(paramInt));
      AppMethodBeat.o(134062);
    }
    
    private static String qh(int paramInt)
    {
      AppMethodBeat.i(134070);
      String str = "0x" + Integer.toHexString(paramInt);
      AppMethodBeat.o(134070);
      return str;
    }
    
    private static String toString(Object paramObject)
    {
      AppMethodBeat.i(134065);
      if (paramObject == null)
      {
        AppMethodBeat.o(134065);
        return "null";
      }
      paramObject = paramObject.toString();
      AppMethodBeat.o(134065);
      return paramObject;
    }
    
    private void zH(String paramString)
    {
      AppMethodBeat.i(134052);
      log(paramString + '(');
      this.jhs = 0;
      AppMethodBeat.o(134052);
    }
    
    public final boolean eglChooseConfig(EGLDisplay paramEGLDisplay, int[] paramArrayOfInt1, EGLConfig[] paramArrayOfEGLConfig, int paramInt, int[] paramArrayOfInt2)
    {
      AppMethodBeat.i(134025);
      zH("eglChooseConfig");
      a("display", paramEGLDisplay);
      a("attrib_list", paramArrayOfInt1);
      bB("config_size", paramInt);
      end();
      boolean bool = this.jho.eglChooseConfig(paramEGLDisplay, paramArrayOfInt1, paramArrayOfEGLConfig, paramInt, paramArrayOfInt2);
      m("configs", paramArrayOfEGLConfig);
      a("num_config", paramArrayOfInt2);
      fj(bool);
      checkError();
      AppMethodBeat.o(134025);
      return bool;
    }
    
    public final boolean eglCopyBuffers(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface, Object paramObject)
    {
      AppMethodBeat.i(134026);
      zH("eglCopyBuffers");
      a("display", paramEGLDisplay);
      a("surface", paramEGLSurface);
      o("native_pixmap", paramObject);
      end();
      boolean bool = this.jho.eglCopyBuffers(paramEGLDisplay, paramEGLSurface, paramObject);
      fj(bool);
      checkError();
      AppMethodBeat.o(134026);
      return bool;
    }
    
    public final EGLContext eglCreateContext(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, EGLContext paramEGLContext, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(134027);
      zH("eglCreateContext");
      a("display", paramEGLDisplay);
      o("config", paramEGLConfig);
      a("share_context", paramEGLContext);
      a("attrib_list", paramArrayOfInt);
      end();
      paramEGLDisplay = this.jho.eglCreateContext(paramEGLDisplay, paramEGLConfig, paramEGLContext, paramArrayOfInt);
      bA(paramEGLDisplay);
      checkError();
      AppMethodBeat.o(134027);
      return paramEGLDisplay;
    }
    
    public final EGLSurface eglCreatePbufferSurface(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(134028);
      zH("eglCreatePbufferSurface");
      a("display", paramEGLDisplay);
      o("config", paramEGLConfig);
      a("attrib_list", paramArrayOfInt);
      end();
      paramEGLDisplay = this.jho.eglCreatePbufferSurface(paramEGLDisplay, paramEGLConfig, paramArrayOfInt);
      bA(paramEGLDisplay);
      checkError();
      AppMethodBeat.o(134028);
      return paramEGLDisplay;
    }
    
    public final EGLSurface eglCreatePixmapSurface(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(134029);
      zH("eglCreatePixmapSurface");
      a("display", paramEGLDisplay);
      o("config", paramEGLConfig);
      o("native_pixmap", paramObject);
      a("attrib_list", paramArrayOfInt);
      end();
      paramEGLDisplay = this.jho.eglCreatePixmapSurface(paramEGLDisplay, paramEGLConfig, paramObject, paramArrayOfInt);
      bA(paramEGLDisplay);
      checkError();
      AppMethodBeat.o(134029);
      return paramEGLDisplay;
    }
    
    public final EGLSurface eglCreateWindowSurface(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(134030);
      zH("eglCreateWindowSurface");
      a("display", paramEGLDisplay);
      o("config", paramEGLConfig);
      o("native_window", paramObject);
      a("attrib_list", paramArrayOfInt);
      end();
      paramEGLDisplay = this.jho.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, paramArrayOfInt);
      bA(paramEGLDisplay);
      checkError();
      AppMethodBeat.o(134030);
      return paramEGLDisplay;
    }
    
    public final boolean eglDestroyContext(EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      AppMethodBeat.i(134031);
      zH("eglDestroyContext");
      a("display", paramEGLDisplay);
      a("context", paramEGLContext);
      end();
      boolean bool = this.jho.eglDestroyContext(paramEGLDisplay, paramEGLContext);
      fj(bool);
      checkError();
      AppMethodBeat.o(134031);
      return bool;
    }
    
    public final boolean eglDestroySurface(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      AppMethodBeat.i(134032);
      zH("eglDestroySurface");
      a("display", paramEGLDisplay);
      a("surface", paramEGLSurface);
      end();
      boolean bool = this.jho.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
      fj(bool);
      checkError();
      AppMethodBeat.o(134032);
      return bool;
    }
    
    public final boolean eglGetConfigAttrib(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(134033);
      zH("eglGetConfigAttrib");
      a("display", paramEGLDisplay);
      o("config", paramEGLConfig);
      bB("attribute", paramInt);
      end();
      boolean bool = this.jho.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, paramArrayOfInt);
      a("value", paramArrayOfInt);
      fj(bool);
      checkError();
      AppMethodBeat.o(134033);
      return false;
    }
    
    public final boolean eglGetConfigs(EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig, int paramInt, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(134034);
      zH("eglGetConfigs");
      a("display", paramEGLDisplay);
      bB("config_size", paramInt);
      end();
      boolean bool = this.jho.eglGetConfigs(paramEGLDisplay, paramArrayOfEGLConfig, paramInt, paramArrayOfInt);
      m("configs", paramArrayOfEGLConfig);
      a("num_config", paramArrayOfInt);
      fj(bool);
      checkError();
      AppMethodBeat.o(134034);
      return bool;
    }
    
    public final EGLContext eglGetCurrentContext()
    {
      AppMethodBeat.i(134035);
      zH("eglGetCurrentContext");
      end();
      EGLContext localEGLContext = this.jho.eglGetCurrentContext();
      bA(localEGLContext);
      checkError();
      AppMethodBeat.o(134035);
      return localEGLContext;
    }
    
    public final EGLDisplay eglGetCurrentDisplay()
    {
      AppMethodBeat.i(134036);
      zH("eglGetCurrentDisplay");
      end();
      EGLDisplay localEGLDisplay = this.jho.eglGetCurrentDisplay();
      bA(localEGLDisplay);
      checkError();
      AppMethodBeat.o(134036);
      return localEGLDisplay;
    }
    
    public final EGLSurface eglGetCurrentSurface(int paramInt)
    {
      AppMethodBeat.i(134037);
      zH("eglGetCurrentSurface");
      bB("readdraw", paramInt);
      end();
      EGLSurface localEGLSurface = this.jho.eglGetCurrentSurface(paramInt);
      bA(localEGLSurface);
      checkError();
      AppMethodBeat.o(134037);
      return localEGLSurface;
    }
    
    public final EGLDisplay eglGetDisplay(Object paramObject)
    {
      AppMethodBeat.i(134038);
      zH("eglGetDisplay");
      o("native_display", paramObject);
      end();
      paramObject = this.jho.eglGetDisplay(paramObject);
      bA(paramObject);
      checkError();
      AppMethodBeat.o(134038);
      return paramObject;
    }
    
    public final int eglGetError()
    {
      AppMethodBeat.i(134039);
      zH("eglGetError");
      end();
      int i = this.jho.eglGetError();
      FE(getErrorString(i));
      AppMethodBeat.o(134039);
      return i;
    }
    
    public final boolean eglInitialize(EGLDisplay paramEGLDisplay, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(134040);
      zH("eglInitialize");
      a("display", paramEGLDisplay);
      end();
      boolean bool = this.jho.eglInitialize(paramEGLDisplay, paramArrayOfInt);
      fj(bool);
      a("major_minor", paramArrayOfInt);
      checkError();
      AppMethodBeat.o(134040);
      return bool;
    }
    
    public final boolean eglMakeCurrent(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface1, EGLSurface paramEGLSurface2, EGLContext paramEGLContext)
    {
      AppMethodBeat.i(134041);
      zH("eglMakeCurrent");
      a("display", paramEGLDisplay);
      a("draw", paramEGLSurface1);
      a("read", paramEGLSurface2);
      a("context", paramEGLContext);
      end();
      boolean bool = this.jho.eglMakeCurrent(paramEGLDisplay, paramEGLSurface1, paramEGLSurface2, paramEGLContext);
      fj(bool);
      checkError();
      AppMethodBeat.o(134041);
      return bool;
    }
    
    public final boolean eglQueryContext(EGLDisplay paramEGLDisplay, EGLContext paramEGLContext, int paramInt, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(134042);
      zH("eglQueryContext");
      a("display", paramEGLDisplay);
      a("context", paramEGLContext);
      bB("attribute", paramInt);
      end();
      boolean bool = this.jho.eglQueryContext(paramEGLDisplay, paramEGLContext, paramInt, paramArrayOfInt);
      qg(paramArrayOfInt[0]);
      fj(bool);
      checkError();
      AppMethodBeat.o(134042);
      return bool;
    }
    
    public final String eglQueryString(EGLDisplay paramEGLDisplay, int paramInt)
    {
      AppMethodBeat.i(134043);
      zH("eglQueryString");
      a("display", paramEGLDisplay);
      bB("name", paramInt);
      end();
      paramEGLDisplay = this.jho.eglQueryString(paramEGLDisplay, paramInt);
      FE(paramEGLDisplay);
      checkError();
      AppMethodBeat.o(134043);
      return paramEGLDisplay;
    }
    
    public final boolean eglQuerySurface(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface, int paramInt, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(134044);
      zH("eglQuerySurface");
      a("display", paramEGLDisplay);
      a("surface", paramEGLSurface);
      bB("attribute", paramInt);
      end();
      boolean bool = this.jho.eglQuerySurface(paramEGLDisplay, paramEGLSurface, paramInt, paramArrayOfInt);
      qg(paramArrayOfInt[0]);
      fj(bool);
      checkError();
      AppMethodBeat.o(134044);
      return bool;
    }
    
    public final boolean eglSwapBuffers(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      AppMethodBeat.i(134045);
      zH("eglSwapBuffers");
      a("display", paramEGLDisplay);
      a("surface", paramEGLSurface);
      end();
      boolean bool = this.jho.eglSwapBuffers(paramEGLDisplay, paramEGLSurface);
      fj(bool);
      checkError();
      AppMethodBeat.o(134045);
      return bool;
    }
    
    public final boolean eglTerminate(EGLDisplay paramEGLDisplay)
    {
      AppMethodBeat.i(134046);
      zH("eglTerminate");
      a("display", paramEGLDisplay);
      end();
      boolean bool = this.jho.eglTerminate(paramEGLDisplay);
      fj(bool);
      checkError();
      AppMethodBeat.o(134046);
      return bool;
    }
    
    public final boolean eglWaitGL()
    {
      AppMethodBeat.i(134047);
      zH("eglWaitGL");
      end();
      boolean bool = this.jho.eglWaitGL();
      fj(bool);
      checkError();
      AppMethodBeat.o(134047);
      return bool;
    }
    
    public final boolean eglWaitNative(int paramInt, Object paramObject)
    {
      AppMethodBeat.i(134048);
      zH("eglWaitNative");
      bB("engine", paramInt);
      o("bindTarget", paramObject);
      end();
      boolean bool = this.jho.eglWaitNative(paramInt, paramObject);
      fj(bool);
      checkError();
      AppMethodBeat.o(134048);
      return bool;
    }
  }
  
  static final class m
    extends Writer
  {
    private StringBuilder mBuilder;
    
    m()
    {
      AppMethodBeat.i(134089);
      this.mBuilder = new StringBuilder();
      AppMethodBeat.o(134089);
    }
    
    private void flushBuilder()
    {
      AppMethodBeat.i(134093);
      if (this.mBuilder.length() > 0)
      {
        c.c.v("GLSurfaceView", this.mBuilder.toString(), new Object[0]);
        this.mBuilder.delete(0, this.mBuilder.length());
      }
      AppMethodBeat.o(134093);
    }
    
    public final void close()
    {
      AppMethodBeat.i(134090);
      flushBuilder();
      AppMethodBeat.o(134090);
    }
    
    public final void flush()
    {
      AppMethodBeat.i(134091);
      flushBuilder();
      AppMethodBeat.o(134091);
    }
    
    public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(134092);
      int i = 0;
      if (i < paramInt2)
      {
        char c = paramArrayOfChar[(paramInt1 + i)];
        if (c == '\n') {
          flushBuilder();
        }
        for (;;)
        {
          i += 1;
          break;
          this.mBuilder.append(c);
        }
      }
      AppMethodBeat.o(134092);
    }
  }
  
  public static abstract interface n
  {
    public abstract void aPJ();
    
    public abstract void aPK();
    
    public abstract void aPL();
    
    public abstract void aPM();
    
    public abstract void dt(int paramInt1, int paramInt2);
    
    public abstract void onDestroy();
    
    public abstract void onPause();
    
    public abstract void onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */