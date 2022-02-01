package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class MMSightCameraGLSurfaceView
  extends GLSurfaceView
{
  private EGLContext hoR;
  int huh;
  a juC;
  private int juD;
  private c juE;
  int jus;
  int jut;
  
  public MMSightCameraGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(89201);
    this.juC = null;
    this.juD = 0;
    init();
    AppMethodBeat.o(89201);
  }
  
  public MMSightCameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(89202);
    this.juC = null;
    this.juD = 0;
    init();
    AppMethodBeat.o(89202);
  }
  
  private void init()
  {
    AppMethodBeat.i(89203);
    getHolder().addCallback(this);
    try
    {
      getHolder().setType(2);
      setEGLContextFactory(new MMSightCameraGLSurfaceView.b(this));
      setEGLConfigChooser(new MMSightCameraGLSurfaceView.a(this));
      this.juC = new a();
      setRenderer(this.juC);
      setRenderMode(0);
      AppMethodBeat.o(89203);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          getHolder().setType(1);
        }
        catch (Exception localException2)
        {
          try
          {
            getHolder().setType(0);
          }
          catch (Exception localException3) {}
        }
      }
    }
  }
  
  public EGLContext getEglContext()
  {
    return this.hoR;
  }
  
  public int getFrameHeight()
  {
    return this.jut;
  }
  
  public int getFrameRotate()
  {
    return this.huh;
  }
  
  public int getFrameWidth()
  {
    return this.jus;
  }
  
  public void setOnEglEnableListener(c paramc)
  {
    this.juE = paramc;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89206);
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    ad.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceChanged, format: %s, w: %s, h: %s this: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this });
    AppMethodBeat.o(89206);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(89204);
    super.surfaceCreated(paramSurfaceHolder);
    ad.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceCreated: %s this: %s %s", new Object[] { paramSurfaceHolder, this, Integer.valueOf(getId()) });
    this.hoR = EGL14.eglGetCurrentContext();
    if (this.juE != null) {
      this.juE.enable();
    }
    AppMethodBeat.o(89204);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(89205);
    super.surfaceDestroyed(paramSurfaceHolder);
    ad.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceDestroyed: %s this: %s", new Object[] { paramSurfaceHolder, this });
    AppMethodBeat.o(89205);
  }
  
  public static abstract interface c
  {
    public abstract void enable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */