package com.tencent.mm.plugin.api.recordView;

import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class h$3
  implements Runnable
{
  h$3(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(76388);
    Object localObject = this.gOE.gOy;
    if (((i)localObject).eYw != 0) {
      GLES20.glDeleteTextures(1, new int[] { ((i)localObject).eYw }, 0);
    }
    if (((i)localObject).eYx != 0) {
      GLES20.glDeleteFramebuffers(1, new int[] { ((i)localObject).eYx }, 0);
    }
    localObject = this.gOE.gOC;
    EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
    EGL14.eglMakeCurrent((EGLDisplay)localObject, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
    if ((this.gOE.eZy != null) && (this.gOE.eZz != null) && (this.gOE.gOC != null))
    {
      EGL14.eglDestroySurface(this.gOE.gOC, this.gOE.eZy);
      EGL14.eglDestroyContext(this.gOE.gOC, this.gOE.eZz);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.gOE.gOC);
      this.gOE.eZz = null;
      this.gOE.gOC = null;
      this.gOE.eZy = null;
    }
    this.gOE.eVR.removeCallbacksAndMessages(null);
    this.gOE.eVQ.quitSafely();
    AppMethodBeat.o(76388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.h.3
 * JD-Core Version:    0.7.0.1
 */