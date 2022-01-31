package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import com.tencent.magicbrush.a.d.f;
import com.tencent.mm.plugin.appbrand.game.f.b;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class GameGLSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback2
{
  private static final GameGLSurfaceView.k fYG = new GameGLSurfaceView.k((byte)0);
  private final WeakReference<GameGLSurfaceView> fYH = new WeakReference(this);
  public GameGLSurfaceView.j fYI;
  private GameGLSurfaceView.n fYJ;
  private GameGLSurfaceView.e fYK;
  private f fYL;
  private GameGLSurfaceView.h fYM;
  private GameGLSurfaceView.l fYN;
  private boolean fYO = false;
  private int fYP;
  private int fYQ;
  private boolean fYR;
  private final b fYS = new b();
  private boolean mDetached;
  
  public GameGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public GameGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void afO()
  {
    if (this.fYI != null) {
      throw new IllegalStateException("setRenderer has already been called for this instance.");
    }
  }
  
  private void init()
  {
    h.fZZ.gab = this;
    getHolder().addCallback(this);
  }
  
  protected void finalize()
  {
    try
    {
      if (this.fYI != null) {
        this.fYI.afX();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getDebugFlags()
  {
    return this.fYP;
  }
  
  public boolean getIsSwapNow()
  {
    return this.fYO;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.fYR;
  }
  
  public int getRenderMode()
  {
    return this.fYI.getRenderMode();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    d.f.i("MicroMsg.GameGLSurfaceView", "onAttachedToWindow reattach =" + this.mDetached, new Object[0]);
    if ((this.mDetached) && (this.fYJ != null)) {
      if (this.fYI == null) {
        break label102;
      }
    }
    label102:
    for (int i = this.fYI.getRenderMode();; i = 1)
    {
      this.fYI = new GameGLSurfaceView.j(this.fYH);
      if (i != 1) {
        this.fYI.setRenderMode(i);
      }
      this.fYI.start();
      this.mDetached = false;
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    d.f.i("MicroMsg.GameGLSurfaceView", "onDetachedFromWindow", new Object[0]);
    if (this.fYI != null) {
      this.fYI.afX();
    }
    this.mDetached = true;
    super.onDetachedFromWindow();
  }
  
  public final void queueEvent(Runnable paramRunnable)
  {
    GameGLSurfaceView.j localj = this.fYI;
    if (paramRunnable == null) {
      throw new IllegalArgumentException("r must not be null");
    }
    synchronized (fYG)
    {
      localj.fZs.add(paramRunnable);
      fYG.notifyAll();
      return;
    }
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.fYP = paramInt;
  }
  
  public void setEGLConfigChooser(GameGLSurfaceView.e parame)
  {
    afO();
    this.fYK = parame;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new GameGLSurfaceView.o(this));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    afO();
    this.fYQ = paramInt;
  }
  
  public void setEGLContextFactory(f paramf)
  {
    afO();
    this.fYL = paramf;
  }
  
  public void setEGLWindowSurfaceFactory(GameGLSurfaceView.h paramh)
  {
    afO();
    this.fYM = paramh;
  }
  
  public void setFps(int paramInt)
  {
    b localb = this.fYS;
    if ((paramInt < 10) || (paramInt > 60)) {
      return;
    }
    localb.gdm = b.lc(paramInt);
  }
  
  public void setGLWrapper(GameGLSurfaceView.l paraml)
  {
    this.fYN = paraml;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.fYR = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.fYI.setRenderMode(paramInt);
  }
  
  public void setRenderer(a parama)
  {
    afO();
    if (this.fYK == null) {
      this.fYK = new GameGLSurfaceView.o(this);
    }
    if (this.fYL == null) {
      this.fYL = new GameGLSurfaceView.c(this, (byte)0);
    }
    if (this.fYM == null) {
      this.fYM = new GameGLSurfaceView.d((byte)0);
    }
    this.fYJ = parama;
    this.fYI = new GameGLSurfaceView.j(this.fYH);
    this.fYI.start();
  }
  
  public void setSwapNow(boolean paramBoolean)
  {
    this.fYO = paramBoolean;
  }
  
  public void surfaceChanged(SurfaceHolder arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    GameGLSurfaceView.j localj = this.fYI;
    synchronized (fYG)
    {
      if ((localj.mWidth == paramInt2) && (localj.mHeight == paramInt3)) {
        return;
      }
      localj.mWidth = paramInt2;
      localj.mHeight = paramInt3;
      localj.fZt = true;
      localj.fZp = true;
      localj.fZr = false;
      localj.fZg = true;
      if (Thread.currentThread() == localj) {
        return;
      }
    }
    fYG.notifyAll();
    if ((!localObject.fZd) && (!localObject.sn) && (!localObject.fZr)) {
      if ((!localObject.fZl) || (!localObject.fZm) || (!localObject.afV())) {
        break label203;
      }
    }
    label200:
    label203:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      for (;;)
      {
        if (paramInt1 == 0) {
          break label200;
        }
        d.f.i("MicroMsg.GLThread", "onWindowResize waiting for render complete from tid=" + localObject.getId(), new Object[0]);
        try
        {
          fYG.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          Thread.currentThread().interrupt();
        }
      }
      break;
      return;
    }
  }
  
  public void surfaceCreated(SurfaceHolder arg1)
  {
    GameGLSurfaceView.j localj = this.fYI;
    synchronized (fYG)
    {
      d.f.i("MicroMsg.GLThread", "surfaceCreated tid=" + localj.getId(), new Object[0]);
      localj.fZi = true;
      localj.fZn = false;
      localj.fZg = true;
      fYG.notifyAll();
      for (;;)
      {
        if ((localj.fZk) && (!localj.fZn))
        {
          boolean bool = localj.fZd;
          if (!bool) {
            try
            {
              fYG.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder arg1)
  {
    GameGLSurfaceView.j localj = this.fYI;
    synchronized (fYG)
    {
      d.f.i("MicroMsg.GLThread", "surfaceDestroyed tid=" + localj.getId(), new Object[0]);
      localj.fZi = false;
      localj.fZg = true;
      fYG.notifyAll();
      for (;;)
      {
        if (!localj.fZk)
        {
          boolean bool = localj.fZd;
          if (!bool) {
            try
            {
              fYG.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void surfaceRedrawNeeded(SurfaceHolder arg1)
  {
    if (this.fYI != null)
    {
      GameGLSurfaceView.j localj = this.fYI;
      synchronized (fYG)
      {
        localj.fZp = true;
        fYG.notifyAll();
        return;
      }
    }
  }
  
  public static abstract interface f
  {
    public abstract EGLContext b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, EGLContext paramEGLContext);
    
    public abstract void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */