package com.tencent.mm.gpu.service;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openglapihook.FuncSeeker;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mmkv.MMKV;

public class GpuHookServiceImpl
  extends GpuHookService
{
  private EGLDisplay fZZ;
  private EGLConfig gaa;
  private EGLContext gab;
  private EGLSurface gac;
  
  public final void ael()
  {
    AppMethodBeat.i(209439);
    if (!((b)g.ab(b.class)).a(b.a.pLS, true))
    {
      AppMethodBeat.o(209439);
      return;
    }
    MMKV.initialize(ai.getContext());
    aw localaw = aw.aKT("mmkv_gpu_service_key_muti");
    localaw.putBoolean("key_has_function_seek_start", true);
    this.fZZ = EGL14.eglGetDisplay(0);
    if (this.fZZ != EGL14.EGL_NO_DISPLAY)
    {
      int[] arrayOfInt = new int[2];
      if (EGL14.eglInitialize(this.fZZ, arrayOfInt, 0, arrayOfInt, 1))
      {
        arrayOfInt = new int[1];
        EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.fZZ, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344 }, 0, arrayOfEGLConfig, 0, 1, arrayOfInt, 0))
        {
          this.gaa = arrayOfEGLConfig[0];
          this.gab = EGL14.eglCreateContext(this.fZZ, this.gaa, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
          if (this.gab != EGL14.EGL_NO_CONTEXT)
          {
            this.gac = EGL14.eglCreatePbufferSurface(this.fZZ, this.gaa, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
            if ((this.gac != EGL14.EGL_NO_SURFACE) && (EGL14.eglMakeCurrent(this.fZZ, this.gac, this.gac, this.gab))) {
              GLES20.glFlush();
            }
          }
        }
      }
    }
    int i = FuncSeeker.getFuncIndex("glGenTextures");
    int j = FuncSeeker.getFuncIndex("glDeleteTextures");
    int k = FuncSeeker.getFuncIndex("glGenBuffers");
    int m = FuncSeeker.getFuncIndex("glDeleteBuffers");
    int n = FuncSeeker.getFuncIndex("glGenFramebuffers");
    int i1 = FuncSeeker.getFuncIndex("glDeleteFramebuffers");
    int i2 = FuncSeeker.getFuncIndex("glGenRenderbuffers");
    int i3 = FuncSeeker.getFuncIndex("glDeleteRenderbuffers");
    int i4 = FuncSeeker.getFuncIndex("glGetError");
    localaw.putInt("glGenTextures_index", i);
    localaw.putInt("glDeleteTextures_index", j);
    localaw.putInt("glGenBuffers_index", k);
    localaw.putInt("glDeleteBuffers_index", m);
    localaw.putInt("glGenFramebuffers_index", n);
    localaw.putInt("glDeleteFramebuffers_index", i1);
    localaw.putInt("glGenRenderbuffers_index", i2);
    localaw.putInt("glDeleteRenderbuffers_index", i3);
    localaw.putInt("glGetError_index", i4);
    localaw.putBoolean("key_finish_function_seek", true);
    localaw.commit();
    EGL14.eglDestroySurface(this.fZZ, this.gac);
    EGL14.eglDestroyContext(this.fZZ, this.gab);
    EGL14.eglReleaseThread();
    EGL14.eglTerminate(this.fZZ);
    this.fZZ = null;
    this.gaa = null;
    this.gab = null;
    this.gac = null;
    new StringBuilder().append(ai.getProcessName()).append(": System.exit()");
    System.exit(0);
    AppMethodBeat.o(209439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.gpu.service.GpuHookServiceImpl
 * JD-Core Version:    0.7.0.1
 */