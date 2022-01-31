package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.mm.sdk.platformtools.y;

class MMSightCameraGLSurfaceView
  extends GLSurfaceView
{
  int fvY;
  int fvZ;
  a fws = null;
  private int fwt = 0;
  int fwu;
  
  public MMSightCameraGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MMSightCameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    getHolder().addCallback(this);
    try
    {
      getHolder().setType(2);
      setEGLContextFactory(new MMSightCameraGLSurfaceView.b(this));
      setEGLConfigChooser(new MMSightCameraGLSurfaceView.a(this));
      this.fws = new a();
      setRenderer(this.fws);
      setRenderMode(0);
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
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    y.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceChanged, format: %s, w: %s, h: %s this: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this });
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceCreated(paramSurfaceHolder);
    y.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceCreated: %s this: %s %s", new Object[] { paramSurfaceHolder, this, Integer.valueOf(getId()) });
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
    y.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceDestroyed: %s this: %s", new Object[] { paramSurfaceHolder, this });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */