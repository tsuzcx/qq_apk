package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class GLSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback2
{
  private static final GLSurfaceView.j jgV;
  private GLSurfaceView.i jgW;
  private GLSurfaceView.m jgX;
  private e jgY;
  private GLSurfaceView.f jgZ;
  private GLSurfaceView.g jha;
  private GLSurfaceView.k jhb;
  private int mDebugFlags;
  private boolean mDetached;
  private int mEGLContextClientVersion;
  private boolean mPreserveEGLContextOnPause;
  private final WeakReference<GLSurfaceView> mThisWeakRef;
  
  static
  {
    AppMethodBeat.i(134017);
    jgV = new GLSurfaceView.j((byte)0);
    AppMethodBeat.o(134017);
  }
  
  public GLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(134000);
    this.mThisWeakRef = new WeakReference(this);
    getHolder().addCallback(this);
    AppMethodBeat.o(134000);
  }
  
  private void checkRenderThreadState()
  {
    AppMethodBeat.i(134016);
    if (this.jgW != null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
      AppMethodBeat.o(134016);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(134016);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(134001);
    try
    {
      if (this.jgW != null) {
        this.jgW.requestExitAndWait();
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(134001);
    }
  }
  
  public int getDebugFlags()
  {
    return this.mDebugFlags;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.mPreserveEGLContextOnPause;
  }
  
  public int getRenderMode()
  {
    AppMethodBeat.i(134009);
    int i = this.jgW.getRenderMode();
    AppMethodBeat.o(134009);
    return i;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(134014);
    super.onAttachedToWindow();
    ab.d("CustomGLSurfaceView", "onAttachedToWindow reattach =" + this.mDetached);
    if ((this.mDetached) && (this.jgX != null)) {
      if (this.jgW == null) {
        break label108;
      }
    }
    label108:
    for (int i = this.jgW.getRenderMode();; i = 1)
    {
      this.jgW = new GLSurfaceView.i(this.mThisWeakRef);
      if (i != 1) {
        this.jgW.setRenderMode(i);
      }
      this.jgW.start();
      this.mDetached = false;
      AppMethodBeat.o(134014);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(134015);
    ab.d("CustomGLSurfaceView", "onDetachedFromWindow");
    if (this.jgW != null) {
      this.jgW.requestExitAndWait();
    }
    this.mDetached = true;
    super.onDetachedFromWindow();
    AppMethodBeat.o(134015);
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.mDebugFlags = paramInt;
  }
  
  public void setEGLConfigChooser(e parame)
  {
    AppMethodBeat.i(134005);
    checkRenderThreadState();
    this.jgY = parame;
    AppMethodBeat.o(134005);
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    AppMethodBeat.i(134006);
    setEGLConfigChooser(new GLSurfaceView.n(this, paramBoolean));
    AppMethodBeat.o(134006);
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    AppMethodBeat.i(134007);
    checkRenderThreadState();
    this.mEGLContextClientVersion = paramInt;
    AppMethodBeat.o(134007);
  }
  
  public void setEGLContextFactory(GLSurfaceView.f paramf)
  {
    AppMethodBeat.i(134003);
    checkRenderThreadState();
    this.jgZ = paramf;
    AppMethodBeat.o(134003);
  }
  
  public void setEGLWindowSurfaceFactory(GLSurfaceView.g paramg)
  {
    AppMethodBeat.i(134004);
    checkRenderThreadState();
    this.jha = paramg;
    AppMethodBeat.o(134004);
  }
  
  public void setGLWrapper(GLSurfaceView.k paramk)
  {
    this.jhb = paramk;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.mPreserveEGLContextOnPause = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(134008);
    this.jgW.setRenderMode(paramInt);
    AppMethodBeat.o(134008);
  }
  
  public void setRenderer(GLSurfaceView.m paramm)
  {
    AppMethodBeat.i(134002);
    checkRenderThreadState();
    if (this.jgY == null) {
      this.jgY = new GLSurfaceView.n(this, true);
    }
    if (this.jgZ == null) {
      this.jgZ = new GLSurfaceView.c(this, (byte)0);
    }
    if (this.jha == null) {
      this.jha = new GLSurfaceView.d((byte)0);
    }
    this.jgX = paramm;
    this.jgW = new GLSurfaceView.i(this.mThisWeakRef);
    this.jgW.start();
    AppMethodBeat.o(134002);
  }
  
  public void surfaceChanged(SurfaceHolder arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(134012);
    GLSurfaceView.i locali = this.jgW;
    for (;;)
    {
      synchronized (jgV)
      {
        locali.mWidth = paramInt2;
        locali.mHeight = paramInt3;
        locali.mSizeChanged = true;
        locali.mRequestRender = true;
        locali.mRenderComplete = false;
        if (Thread.currentThread() == locali)
        {
          AppMethodBeat.o(134012);
          return;
        }
        jgV.notifyAll();
        if ((locali.mExited) || (locali.mPaused) || (locali.mRenderComplete)) {
          break;
        }
        if ((locali.mHaveEglContext) && (locali.mHaveEglSurface) && (locali.readyToDraw()))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break;
          }
          ab.i("Main thread", "onWindowResize waiting for render complete from tid=" + locali.getId());
          try
          {
            jgV.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
      paramInt1 = 0;
    }
    AppMethodBeat.o(134012);
  }
  
  public void surfaceCreated(SurfaceHolder arg1)
  {
    AppMethodBeat.i(134010);
    GLSurfaceView.i locali = this.jgW;
    synchronized (jgV)
    {
      ab.i("GLThread", "surfaceCreated tid=" + locali.getId());
      locali.mHasSurface = true;
      locali.mFinishedCreatingEglSurface = false;
      jgV.notifyAll();
      for (;;)
      {
        if ((locali.mWaitingForSurface) && (!locali.mFinishedCreatingEglSurface))
        {
          boolean bool = locali.mExited;
          if (!bool) {
            try
            {
              jgV.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(134010);
  }
  
  public void surfaceDestroyed(SurfaceHolder arg1)
  {
    AppMethodBeat.i(134011);
    GLSurfaceView.i locali = this.jgW;
    synchronized (jgV)
    {
      ab.i("GLThread", "surfaceDestroyed tid=" + locali.getId());
      locali.mHasSurface = false;
      jgV.notifyAll();
      for (;;)
      {
        if (!locali.mWaitingForSurface)
        {
          boolean bool = locali.mExited;
          if (!bool) {
            try
            {
              jgV.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(134011);
  }
  
  @Deprecated
  public void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceRedrawNeededAsync(SurfaceHolder arg1, Runnable paramRunnable)
  {
    AppMethodBeat.i(134013);
    if (this.jgW != null)
    {
      GLSurfaceView.i locali = this.jgW;
      synchronized (jgV)
      {
        if (Thread.currentThread() == locali)
        {
          AppMethodBeat.o(134013);
          return;
        }
        locali.mWantRenderNotification = true;
        locali.mRequestRender = true;
        locali.mRenderComplete = false;
        locali.mFinishDrawingRunnable = paramRunnable;
        jgV.notifyAll();
        AppMethodBeat.o(134013);
        return;
      }
    }
    AppMethodBeat.o(134013);
  }
  
  public static abstract interface e
  {
    public abstract EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView
 * JD-Core Version:    0.7.0.1
 */