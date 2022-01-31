package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

class MMSightCameraGLSurfaceView
  extends GLSurfaceView
{
  EGLContext eZz;
  int fbz;
  int gNA;
  int gNB;
  a gNI;
  private int gNJ;
  
  public MMSightCameraGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76319);
    this.gNI = null;
    this.gNJ = 0;
    init();
    AppMethodBeat.o(76319);
  }
  
  public MMSightCameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(76320);
    this.gNI = null;
    this.gNJ = 0;
    init();
    AppMethodBeat.o(76320);
  }
  
  private void init()
  {
    AppMethodBeat.i(76321);
    getHolder().addCallback(this);
    try
    {
      getHolder().setType(2);
      setEGLContextFactory(new MMSightCameraGLSurfaceView.b(this));
      setEGLConfigChooser(new MMSightCameraGLSurfaceView.a(this));
      this.gNI = new a();
      setRenderer(this.gNI);
      setRenderMode(0);
      AppMethodBeat.o(76321);
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
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(76324);
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    ab.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceChanged, format: %s, w: %s, h: %s this: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this });
    AppMethodBeat.o(76324);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(76322);
    super.surfaceCreated(paramSurfaceHolder);
    ab.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceCreated: %s this: %s %s", new Object[] { paramSurfaceHolder, this, Integer.valueOf(getId()) });
    this.eZz = EGL14.eglGetCurrentContext();
    AppMethodBeat.o(76322);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(76323);
    super.surfaceDestroyed(paramSurfaceHolder);
    ab.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceDestroyed: %s this: %s", new Object[] { paramSurfaceHolder, this });
    AppMethodBeat.o(76323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */