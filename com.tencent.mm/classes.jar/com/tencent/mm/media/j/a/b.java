package com.tencent.mm.media.j.a;

import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/render/config/RenderContextFactory;", "Landroid/opengl/GLSurfaceView$EGLContextFactory;", "()V", "EGL_CONTEXT_CLIENT_VERSION", "", "TAG", "", "createContext", "Ljavax/microedition/khronos/egl/EGLContext;", "egl", "Ljavax/microedition/khronos/egl/EGL10;", "display", "Ljavax/microedition/khronos/egl/EGLDisplay;", "eglConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "destroyContext", "", "context", "plugin-mediaeditor_release"})
public final class b
  implements GLSurfaceView.EGLContextFactory
{
  private final int EGL_CONTEXT_CLIENT_VERSION = 12440;
  private final String TAG = "MicroMsg.RenderContextFactory";
  
  public final EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(93851);
    p.h(paramEGL10, "egl");
    p.h(paramEGLDisplay, "display");
    p.h(paramEGLConfig, "eglConfig");
    Log.w(this.TAG, "creating OpenGL ES 2.0 context");
    int i = MultiProcessMMKV.getMMKV("mmkv_gl_key").decodeInt("support_egl_context_client_version", 3);
    int j = this.EGL_CONTEXT_CLIENT_VERSION;
    paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { j, i, 12344 });
    p.g(paramEGL10, "egl.eglCreateContext(dis…_NO_CONTEXT, attrib_list)");
    AppMethodBeat.o(93851);
    return paramEGL10;
  }
  
  public final void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(93852);
    p.h(paramEGL10, "egl");
    p.h(paramEGLDisplay, "display");
    p.h(paramEGLContext, "context");
    Log.w(this.TAG, "destroyContext OpenGL ES 2.0 Context");
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
    AppMethodBeat.o(93852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.j.a.b
 * JD-Core Version:    0.7.0.1
 */