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
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mmkv.MMKV;

public class GpuHookServiceImpl
  extends GpuHookService
{
  private EGLSurface gtA;
  private EGLDisplay gtx;
  private EGLConfig gty;
  private EGLContext gtz;
  
  public final void agS()
  {
    AppMethodBeat.i(219553);
    if (!((b)g.ab(b.class)).a(b.a.qpF, true))
    {
      AppMethodBeat.o(219553);
      return;
    }
    MMKV.initialize(aj.getContext());
    Object localObject1 = ax.aQz("mmkv_gpu_service_key_muti");
    ((ax)localObject1).putBoolean("key_has_function_seek_start", true);
    this.gtx = EGL14.eglGetDisplay(0);
    if (this.gtx != EGL14.EGL_NO_DISPLAY)
    {
      localObject2 = new int[2];
      if (EGL14.eglInitialize(this.gtx, (int[])localObject2, 0, (int[])localObject2, 1))
      {
        localObject2 = new int[1];
        EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.gtx, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344 }, 0, arrayOfEGLConfig, 0, 1, (int[])localObject2, 0))
        {
          this.gty = arrayOfEGLConfig[0];
          this.gtz = EGL14.eglCreateContext(this.gtx, this.gty, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
          if (this.gtz != EGL14.EGL_NO_CONTEXT)
          {
            this.gtA = EGL14.eglCreatePbufferSurface(this.gtx, this.gty, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
            if ((this.gtA != EGL14.EGL_NO_SURFACE) && (EGL14.eglMakeCurrent(this.gtx, this.gtA, this.gtA, this.gtz))) {
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
    ((ax)localObject1).putInt("glGenTextures_index", i);
    ((ax)localObject1).putInt("glDeleteTextures_index", j);
    ((ax)localObject1).putInt("glGenBuffers_index", k);
    ((ax)localObject1).putInt("glDeleteBuffers_index", m);
    ((ax)localObject1).putInt("glGenFramebuffers_index", n);
    ((ax)localObject1).putInt("glDeleteFramebuffers_index", i1);
    ((ax)localObject1).putInt("glGenRenderbuffers_index", i2);
    ((ax)localObject1).putInt("glDeleteRenderbuffers_index", i3);
    ((ax)localObject1).putInt("glGetError_index", i4);
    ((ax)localObject1).putBoolean("key_finish_function_seek", true);
    ((ax)localObject1).commit();
    EGL14.eglDestroySurface(this.gtx, this.gtA);
    EGL14.eglDestroyContext(this.gtx, this.gtz);
    EGL14.eglReleaseThread();
    EGL14.eglTerminate(this.gtx);
    this.gtx = null;
    this.gty = null;
    this.gtz = null;
    this.gtA = null;
    new StringBuilder().append(aj.getProcessName()).append(": System.exit()");
    localObject1 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/gpu/service/GpuHookServiceImpl", "main", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/gpu/service/GpuHookServiceImpl", "main", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    AppMethodBeat.o(219553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.service.GpuHookServiceImpl
 * JD-Core Version:    0.7.0.1
 */