package com.tencent.mm.plugin.emojicapture.ui;

import a.d.b.g;
import android.opengl.GLSurfaceView.EGLContextFactory;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public final class b
  implements GLSurfaceView.EGLContextFactory
{
  public final EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    g.k(paramEGL10, "egl");
    g.k(paramEGLDisplay, "display");
    g.k(paramEGLConfig, "eglConfig");
    paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    g.j(paramEGL10, "egl.eglCreateContext(dis…_NO_CONTEXT, attrib_list)");
    return paramEGL10;
  }
  
  public final void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    g.k(paramEGL10, "egl");
    g.k(paramEGLDisplay, "display");
    g.k(paramEGLContext, "context");
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b
 * JD-Core Version:    0.7.0.1
 */