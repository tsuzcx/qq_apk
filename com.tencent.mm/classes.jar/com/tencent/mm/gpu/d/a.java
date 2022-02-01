package com.tencent.mm.gpu.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openglapihook.OpenGLHook.a;
import com.tencent.mm.openglapihook.OpenGLInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  implements OpenGLHook.a
{
  public final void c(OpenGLInfo paramOpenGLInfo)
  {
    AppMethodBeat.i(210812);
    Log.i("MicroMsg.OpenglHookListener", "onGlGenTextures:".concat(String.valueOf(paramOpenGLInfo)));
    AppMethodBeat.o(210812);
  }
  
  public final void d(OpenGLInfo paramOpenGLInfo)
  {
    AppMethodBeat.i(210813);
    Log.i("MicroMsg.OpenglHookListener", "onGlDeleteTextures:".concat(String.valueOf(paramOpenGLInfo)));
    AppMethodBeat.o(210813);
  }
  
  public final void e(OpenGLInfo paramOpenGLInfo)
  {
    AppMethodBeat.i(210814);
    Log.i("MicroMsg.OpenglHookListener", "onGlGenBuffers:".concat(String.valueOf(paramOpenGLInfo)));
    AppMethodBeat.o(210814);
  }
  
  public final void f(OpenGLInfo paramOpenGLInfo)
  {
    AppMethodBeat.i(210815);
    Log.i("MicroMsg.OpenglHookListener", "onGlDeleteBuffers:".concat(String.valueOf(paramOpenGLInfo)));
    AppMethodBeat.o(210815);
  }
  
  public final void g(OpenGLInfo paramOpenGLInfo)
  {
    AppMethodBeat.i(210816);
    Log.i("MicroMsg.OpenglHookListener", "onGlGenFramebuffers:".concat(String.valueOf(paramOpenGLInfo)));
    AppMethodBeat.o(210816);
  }
  
  public final void h(OpenGLInfo paramOpenGLInfo)
  {
    AppMethodBeat.i(210818);
    Log.i("MicroMsg.OpenglHookListener", "onGlDeleteFramebuffers:".concat(String.valueOf(paramOpenGLInfo)));
    AppMethodBeat.o(210818);
  }
  
  public final void i(OpenGLInfo paramOpenGLInfo)
  {
    AppMethodBeat.i(210819);
    Log.i("MicroMsg.OpenglHookListener", "onGlGenRenderbuffers:".concat(String.valueOf(paramOpenGLInfo)));
    AppMethodBeat.o(210819);
  }
  
  public final void j(OpenGLInfo paramOpenGLInfo)
  {
    AppMethodBeat.i(210821);
    Log.i("MicroMsg.OpenglHookListener", "onGlDeleteRenderbuffers:".concat(String.valueOf(paramOpenGLInfo)));
    AppMethodBeat.o(210821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.gpu.d.a
 * JD-Core Version:    0.7.0.1
 */