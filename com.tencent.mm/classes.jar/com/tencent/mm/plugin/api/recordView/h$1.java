package com.tencent.mm.plugin.api.recordView;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class h$1
  implements Runnable
{
  h$1(h paramh, EGLContext paramEGLContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(76386);
    Object localObject1 = this.gOE;
    EGLContext localEGLContext = this.gOD;
    int i = this.gOE.gNA;
    int j = this.gOE.gNB;
    ((h)localObject1).gOC = EGL14.eglGetDisplay(0);
    if (((h)localObject1).gOC == EGL14.EGL_NO_DISPLAY)
    {
      localObject1 = new RuntimeException("unable to get EGL14 display");
      AppMethodBeat.o(76386);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = new int[2];
    if (!EGL14.eglInitialize(((h)localObject1).gOC, (int[])localObject2, 0, (int[])localObject2, 1))
    {
      ((h)localObject1).gOC = null;
      localObject1 = new RuntimeException("eglInitialize failed");
      AppMethodBeat.o(76386);
      throw ((Throwable)localObject1);
    }
    localObject2 = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    EGL14.eglChooseConfig(((h)localObject1).gOC, ((h)localObject1).eZt, 0, (EGLConfig[])localObject2, 0, 1, arrayOfInt, 0);
    if (localObject2[0] == null)
    {
      localObject1 = new RuntimeException("chooseConfig failed");
      AppMethodBeat.o(76386);
      throw ((Throwable)localObject1);
    }
    ((h)localObject1).eZz = EGL14.eglCreateContext(((h)localObject1).gOC, localObject2[0], localEGLContext, new int[] { 12440, 2, 12344 }, 0);
    if (((h)localObject1).eZz == EGL14.EGL_NO_CONTEXT)
    {
      localObject1 = new RuntimeException("EGL error " + EGL14.eglGetError());
      AppMethodBeat.o(76386);
      throw ((Throwable)localObject1);
    }
    h.xK("eglCreateContext");
    ((h)localObject1).eZy = null;
    try
    {
      ((h)localObject1).eZy = EGL14.eglCreatePbufferSurface(((h)localObject1).gOC, localObject2[0], new int[] { 12375, i, 12374, j, 12344 }, 0);
      h.xK("eglCreatePbufferSurface");
      if (((((h)localObject1).eZy == null) || (((h)localObject1).eZy == EGL14.EGL_NO_SURFACE)) && (EGL14.eglGetError() == 12299)) {
        ab.e("MicroMsg.YUVDateRenderToRBGBufferThread", "makeMyEGLCurrentSurface:returned EGL_BAD_NATIVE_WINDOW.");
      }
      if (!EGL14.eglMakeCurrent(((h)localObject1).gOC, ((h)localObject1).eZy, ((h)localObject1).eZy, ((h)localObject1).eZz)) {
        ab.w("MicroMsg.YUVDateRenderToRBGBufferThread", "eglMakeCurrent:" + EGL14.eglGetError());
      }
      localObject1 = this.gOE;
      i = this.gOE.gOA;
      j = this.gOE.gOB;
      ((h)localObject1).gOy = new i(i, j);
      ((h)localObject1).gOy.onSurfaceCreated(null, null);
      ((h)localObject1).gOy.onSurfaceChanged(null, i, j);
      if (((h)localObject1).gOz != null) {
        ((h)localObject1).gOy.buffer = ((h)localObject1).gOz.getBuffer();
      }
      AppMethodBeat.o(76386);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        ab.e("MicroMsg.YUVDateRenderToRBGBufferThread", "eglCreateWindowSurface", new Object[] { localIllegalArgumentException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.h.1
 * JD-Core Version:    0.7.0.1
 */