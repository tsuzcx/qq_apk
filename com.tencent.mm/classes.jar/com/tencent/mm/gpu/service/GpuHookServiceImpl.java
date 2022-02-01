package com.tencent.mm.gpu.service;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openglapihook.FuncSeeker;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mmkv.MMKV;

public class GpuHookServiceImpl
  extends GpuHookService
{
  private EGLDisplay gwe;
  private EGLConfig gwf;
  private EGLContext gwg;
  private EGLSurface gwh;
  
  public final void ahh()
  {
    AppMethodBeat.i(209675);
    if (!((b)g.ab(b.class)).a(b.a.qwm, true))
    {
      AppMethodBeat.o(209675);
      return;
    }
    MMKV.initialize(ak.getContext());
    Object localObject1 = ay.aRW("mmkv_gpu_service_key_muti");
    ((ay)localObject1).putBoolean("key_has_function_seek_start", true);
    this.gwe = EGL14.eglGetDisplay(0);
    if (this.gwe != EGL14.EGL_NO_DISPLAY)
    {
      localObject2 = new int[2];
      if (EGL14.eglInitialize(this.gwe, (int[])localObject2, 0, (int[])localObject2, 1))
      {
        localObject2 = new int[1];
        EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.gwe, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344 }, 0, arrayOfEGLConfig, 0, 1, (int[])localObject2, 0))
        {
          this.gwf = arrayOfEGLConfig[0];
          this.gwg = EGL14.eglCreateContext(this.gwe, this.gwf, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
          if (this.gwg != EGL14.EGL_NO_CONTEXT)
          {
            this.gwh = EGL14.eglCreatePbufferSurface(this.gwe, this.gwf, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
            if ((this.gwh != EGL14.EGL_NO_SURFACE) && (EGL14.eglMakeCurrent(this.gwe, this.gwh, this.gwh, this.gwg))) {
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
    ((ay)localObject1).putInt("glGenTextures_index", i);
    ((ay)localObject1).putInt("glDeleteTextures_index", j);
    ((ay)localObject1).putInt("glGenBuffers_index", k);
    ((ay)localObject1).putInt("glDeleteBuffers_index", m);
    ((ay)localObject1).putInt("glGenFramebuffers_index", n);
    ((ay)localObject1).putInt("glDeleteFramebuffers_index", i1);
    ((ay)localObject1).putInt("glGenRenderbuffers_index", i2);
    ((ay)localObject1).putInt("glDeleteRenderbuffers_index", i3);
    ((ay)localObject1).putInt("glGetError_index", i4);
    ((ay)localObject1).putBoolean("key_finish_function_seek", true);
    ((ay)localObject1).commit();
    EGL14.eglDestroySurface(this.gwe, this.gwh);
    EGL14.eglDestroyContext(this.gwe, this.gwg);
    EGL14.eglReleaseThread();
    EGL14.eglTerminate(this.gwe);
    this.gwe = null;
    this.gwf = null;
    this.gwg = null;
    this.gwh = null;
    new StringBuilder().append(ak.getProcessName()).append(": System.exit()");
    localObject1 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/gpu/service/GpuHookServiceImpl", "main", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/gpu/service/GpuHookServiceImpl", "main", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    AppMethodBeat.o(209675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.service.GpuHookServiceImpl
 * JD-Core Version:    0.7.0.1
 */