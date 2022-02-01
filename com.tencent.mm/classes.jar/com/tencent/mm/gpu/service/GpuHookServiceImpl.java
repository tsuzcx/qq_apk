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
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mmkv.MMKV;

public class GpuHookServiceImpl
  extends GpuHookService
{
  private EGLConfig hiT;
  private EGLContext hiU;
  private EGLSurface hiV;
  private EGLDisplay mEGLDisplay;
  
  public final void axt()
  {
    AppMethodBeat.i(186207);
    if (!((b)g.af(b.class)).a(b.a.rNX, true))
    {
      AppMethodBeat.o(186207);
      return;
    }
    MMKV.initialize(MMApplicationContext.getContext());
    Object localObject1 = MultiProcessMMKV.getMMKV("mmkv_gpu_service_key_muti");
    ((MultiProcessMMKV)localObject1).putBoolean("key_has_function_seek_start", true);
    this.mEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY)
    {
      localObject2 = new int[2];
      if (EGL14.eglInitialize(this.mEGLDisplay, (int[])localObject2, 0, (int[])localObject2, 1))
      {
        localObject2 = new int[1];
        EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.mEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344 }, 0, arrayOfEGLConfig, 0, 1, (int[])localObject2, 0))
        {
          this.hiT = arrayOfEGLConfig[0];
          this.hiU = EGL14.eglCreateContext(this.mEGLDisplay, this.hiT, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
          if (this.hiU != EGL14.EGL_NO_CONTEXT)
          {
            this.hiV = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.hiT, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
            if ((this.hiV != EGL14.EGL_NO_SURFACE) && (EGL14.eglMakeCurrent(this.mEGLDisplay, this.hiV, this.hiV, this.hiU))) {
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
    ((MultiProcessMMKV)localObject1).putInt("glGenTextures_index", i);
    ((MultiProcessMMKV)localObject1).putInt("glDeleteTextures_index", j);
    ((MultiProcessMMKV)localObject1).putInt("glGenBuffers_index", k);
    ((MultiProcessMMKV)localObject1).putInt("glDeleteBuffers_index", m);
    ((MultiProcessMMKV)localObject1).putInt("glGenFramebuffers_index", n);
    ((MultiProcessMMKV)localObject1).putInt("glDeleteFramebuffers_index", i1);
    ((MultiProcessMMKV)localObject1).putInt("glGenRenderbuffers_index", i2);
    ((MultiProcessMMKV)localObject1).putInt("glDeleteRenderbuffers_index", i3);
    ((MultiProcessMMKV)localObject1).putInt("glGetError_index", i4);
    ((MultiProcessMMKV)localObject1).putBoolean("key_finish_function_seek", true);
    ((MultiProcessMMKV)localObject1).commit();
    EGL14.eglDestroySurface(this.mEGLDisplay, this.hiV);
    EGL14.eglDestroyContext(this.mEGLDisplay, this.hiU);
    EGL14.eglReleaseThread();
    EGL14.eglTerminate(this.mEGLDisplay);
    this.mEGLDisplay = null;
    this.hiT = null;
    this.hiU = null;
    this.hiV = null;
    new StringBuilder().append(MMApplicationContext.getProcessName()).append(": System.exit()");
    localObject1 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/gpu/service/GpuHookServiceImpl", "main", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/gpu/service/GpuHookServiceImpl", "main", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    AppMethodBeat.o(186207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.gpu.service.GpuHookServiceImpl
 * JD-Core Version:    0.7.0.1
 */