package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.mm.sdk.platformtools.y;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

final class MMSightCameraGLSurfaceView$b
  implements GLSurfaceView.EGLContextFactory
{
  private int EGL_CONTEXT_CLIENT_VERSION = 12440;
  
  MMSightCameraGLSurfaceView$b(MMSightCameraGLSurfaceView paramMMSightCameraGLSurfaceView) {}
  
  public final EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    y.w("MicroMsg.MMSightCameraGLSurfaceView", "creating OpenGL ES 2.0 context");
    int i = this.EGL_CONTEXT_CLIENT_VERSION;
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
  }
  
  public final void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView.b
 * JD-Core Version:    0.7.0.1
 */