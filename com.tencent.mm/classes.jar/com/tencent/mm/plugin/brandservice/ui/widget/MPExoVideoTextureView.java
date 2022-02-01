package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.AttributeSet;
import android.view.Surface;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.MMTextureView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class MPExoVideoTextureView
  extends MMTextureView
{
  private int mVideoHeight;
  private int mVideoWidth;
  private u nQg;
  
  public MPExoVideoTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MPExoVideoTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6261);
    this.nQg = new u();
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    AppMethodBeat.o(6261);
  }
  
  private static void h(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(6267);
    EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
    EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    localEGL10.eglInitialize(localEGLDisplay, null);
    Object localObject = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344 }, (EGLConfig[])localObject, 1, arrayOfInt);
    arrayOfInt = localObject[0];
    localObject = localEGL10.eglCreateContext(localEGLDisplay, arrayOfInt, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    paramSurfaceTexture = localEGL10.eglCreateWindowSurface(localEGLDisplay, arrayOfInt, paramSurfaceTexture, new int[] { 12344 });
    localEGL10.eglMakeCurrent(localEGLDisplay, paramSurfaceTexture, paramSurfaceTexture, (EGLContext)localObject);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16384);
    localEGL10.eglSwapBuffers(localEGLDisplay, paramSurfaceTexture);
    localEGL10.eglDestroySurface(localEGLDisplay, paramSurfaceTexture);
    paramSurfaceTexture = EGL10.EGL_NO_SURFACE;
    localEGL10.eglMakeCurrent(localEGLDisplay, paramSurfaceTexture, paramSurfaceTexture, EGL10.EGL_NO_CONTEXT);
    localEGL10.eglDestroyContext(localEGLDisplay, (EGLContext)localObject);
    localEGL10.eglTerminate(localEGLDisplay);
    AppMethodBeat.o(6267);
  }
  
  public final void bNN()
  {
    AppMethodBeat.i(6263);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    localLayoutParams.addRule(13);
    setLayoutParams(localLayoutParams);
    AppMethodBeat.o(6263);
  }
  
  public final void bNO()
  {
    AppMethodBeat.i(6266);
    try
    {
      SurfaceTexture localSurfaceTexture = getSurfaceTexture();
      if (localSurfaceTexture != null)
      {
        ac.i("MicroMsg.MPExoVideoTextureView", "%d releaseSurface", new Object[] { Integer.valueOf(hashCode()) });
        h(localSurfaceTexture);
      }
      AppMethodBeat.o(6266);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MPExoVideoTextureView", localException, "release surface", new Object[0]);
      AppMethodBeat.o(6266);
    }
  }
  
  public final void h(final Surface paramSurface)
  {
    AppMethodBeat.i(6268);
    h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6260);
        try
        {
          if ((paramSurface != null) && (paramSurface.isValid()))
          {
            ac.i("MicroMsg.MPExoVideoTextureView", "%d release surface [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramSurface.hashCode()) });
            paramSurface.release();
          }
          AppMethodBeat.o(6260);
          return;
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.MPExoVideoTextureView", localException, "release Surface error", new Object[0]);
          AppMethodBeat.o(6260);
        }
      }
    });
    AppMethodBeat.o(6268);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6265);
    if ((this.mVideoWidth == 0) || (this.mVideoHeight == 0))
    {
      setMeasuredDimension(1, 1);
      AppMethodBeat.o(6265);
      return;
    }
    paramInt1 = getDefaultSize(1, paramInt1);
    paramInt2 = getDefaultSize(1, paramInt2);
    int i = this.mVideoWidth;
    int j = this.mVideoHeight;
    this.nQg.x(paramInt1, paramInt2, i, j);
    setMeasuredDimension(this.nQg.kWD, this.nQg.kWE);
    AppMethodBeat.o(6265);
  }
  
  public void setScaleType(h.e parame)
  {
    AppMethodBeat.i(6264);
    this.nQg.a(parame);
    requestLayout();
    AppMethodBeat.o(6264);
  }
  
  public final void setVideoSize(int paramInt1, int paramInt2)
  {
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(6262);
    bNO();
    this.nQg.reset();
    AppMethodBeat.o(6262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoTextureView
 * JD-Core Version:    0.7.0.1
 */