package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class MMSightCameraGLSurfaceView
  extends GLSurfaceView
{
  private android.opengl.EGLContext lau;
  int lfC;
  int nqW;
  int nqX;
  a nrg;
  private int nrh;
  private c nri;
  
  public MMSightCameraGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(89201);
    this.nrg = null;
    this.nrh = 0;
    init();
    AppMethodBeat.o(89201);
  }
  
  public MMSightCameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(89202);
    this.nrg = null;
    this.nrh = 0;
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
      setEGLContextFactory(new b());
      setEGLConfigChooser(new MMSightCameraGLSurfaceView.a(this));
      this.nrg = new a();
      setRenderer(this.nrg);
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
  
  public android.opengl.EGLContext getEglContext()
  {
    return this.lau;
  }
  
  public int getFrameHeight()
  {
    return this.nqX;
  }
  
  public int getFrameRotate()
  {
    return this.lfC;
  }
  
  public int getFrameWidth()
  {
    return this.nqW;
  }
  
  public void setOnEglEnableListener(c paramc)
  {
    this.nri = paramc;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89206);
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    Log.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceChanged, format: %s, w: %s, h: %s this: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this });
    AppMethodBeat.o(89206);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(89204);
    super.surfaceCreated(paramSurfaceHolder);
    Log.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceCreated: %s this: %s %s", new Object[] { paramSurfaceHolder, this, Integer.valueOf(getId()) });
    this.lau = EGL14.eglGetCurrentContext();
    if (this.nri != null) {
      this.nri.enable();
    }
    AppMethodBeat.o(89204);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(89205);
    super.surfaceDestroyed(paramSurfaceHolder);
    Log.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceDestroyed: %s this: %s", new Object[] { paramSurfaceHolder, this });
    AppMethodBeat.o(89205);
  }
  
  final class b
    implements GLSurfaceView.EGLContextFactory
  {
    private int jCT = 12440;
    
    b() {}
    
    public final javax.microedition.khronos.egl.EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      AppMethodBeat.i(89199);
      Log.w("MicroMsg.MMSightCameraGLSurfaceView", "creating OpenGL ES 2.0 context");
      int i = this.jCT;
      paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
      AppMethodBeat.o(89199);
      return paramEGL10;
    }
    
    public final void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, javax.microedition.khronos.egl.EGLContext paramEGLContext)
    {
      AppMethodBeat.i(89200);
      paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
      AppMethodBeat.o(89200);
    }
  }
  
  public static abstract interface c
  {
    public abstract void enable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */