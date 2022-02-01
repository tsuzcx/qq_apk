package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.opengl.GLES20;
import android.util.AttributeSet;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMTextureView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class MPExoVideoTextureView
  extends MMTextureView
{
  int mVideoHeight;
  int mVideoWidth;
  x vZi;
  
  public MPExoVideoTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MPExoVideoTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6261);
    this.vZi = new x();
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    AppMethodBeat.o(6261);
  }
  
  public final void dhZ()
  {
    AppMethodBeat.i(6266);
    try
    {
      Object localObject1 = getSurfaceTexture();
      if (localObject1 != null)
      {
        Log.i("MicroMsg.MPExoVideoTextureView", "%d releaseSurface", new Object[] { Integer.valueOf(hashCode()) });
        EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
        EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        localEGL10.eglInitialize(localEGLDisplay, null);
        Object localObject2 = new EGLConfig[1];
        int[] arrayOfInt = new int[1];
        localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344 }, (EGLConfig[])localObject2, 1, arrayOfInt);
        arrayOfInt = localObject2[0];
        localObject2 = localEGL10.eglCreateContext(localEGLDisplay, arrayOfInt, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
        localObject1 = localEGL10.eglCreateWindowSurface(localEGLDisplay, arrayOfInt, localObject1, new int[] { 12344 });
        localEGL10.eglMakeCurrent(localEGLDisplay, (EGLSurface)localObject1, (EGLSurface)localObject1, (EGLContext)localObject2);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        localEGL10.eglSwapBuffers(localEGLDisplay, (EGLSurface)localObject1);
        localEGL10.eglDestroySurface(localEGLDisplay, (EGLSurface)localObject1);
        localObject1 = EGL10.EGL_NO_SURFACE;
        localEGL10.eglMakeCurrent(localEGLDisplay, (EGLSurface)localObject1, (EGLSurface)localObject1, EGL10.EGL_NO_CONTEXT);
        localEGL10.eglDestroyContext(localEGLDisplay, (EGLContext)localObject2);
        localEGL10.eglTerminate(localEGLDisplay);
      }
      AppMethodBeat.o(6266);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MPExoVideoTextureView", localException, "release surface", new Object[0]);
      AppMethodBeat.o(6266);
    }
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
    this.vZi.G(paramInt1, paramInt2, i, j);
    setMeasuredDimension(this.vZi.sJw, this.vZi.sJx);
    AppMethodBeat.o(6265);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(6264);
    this.vZi.a(parame);
    requestLayout();
    AppMethodBeat.o(6264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoTextureView
 * JD-Core Version:    0.7.0.1
 */