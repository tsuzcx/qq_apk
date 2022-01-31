package com.tencent.mm.media.i;

import a.f.b.j;
import a.l;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "", "disPlay", "Landroid/opengl/EGLDisplay;", "eglSurface", "Landroid/opengl/EGLSurface;", "eglContext", "Landroid/opengl/EGLContext;", "(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)V", "getDisPlay", "()Landroid/opengl/EGLDisplay;", "setDisPlay", "(Landroid/opengl/EGLDisplay;)V", "getEglContext", "()Landroid/opengl/EGLContext;", "setEglContext", "(Landroid/opengl/EGLContext;)V", "getEglSurface", "()Landroid/opengl/EGLSurface;", "setEglSurface", "(Landroid/opengl/EGLSurface;)V", "plugin-mediaeditor_release"})
public final class b$b
{
  public EGLDisplay eZx;
  public EGLSurface eZy;
  public EGLContext eZz;
  
  public b$b(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(13125);
    this.eZx = paramEGLDisplay;
    this.eZy = paramEGLSurface;
    this.eZz = paramEGLContext;
    AppMethodBeat.o(13125);
  }
  
  public final void a(EGLContext paramEGLContext)
  {
    AppMethodBeat.i(152102);
    j.q(paramEGLContext, "<set-?>");
    this.eZz = paramEGLContext;
    AppMethodBeat.o(152102);
  }
  
  public final void a(EGLDisplay paramEGLDisplay)
  {
    AppMethodBeat.i(152100);
    j.q(paramEGLDisplay, "<set-?>");
    this.eZx = paramEGLDisplay;
    AppMethodBeat.o(152100);
  }
  
  public final void a(EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(152101);
    j.q(paramEGLSurface, "<set-?>");
    this.eZy = paramEGLSurface;
    AppMethodBeat.o(152101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.i.b.b
 * JD-Core Version:    0.7.0.1
 */