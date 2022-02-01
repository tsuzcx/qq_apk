package com.tencent.mm.gpu.c;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.PluginGpuRes;
import com.tencent.mm.gpu.d.b;
import com.tencent.mm.gpu.d.c.3;
import com.tencent.mm.gpu.d.d;
import com.tencent.mm.openglapihook.OpenGLHook.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.wxperf.jni.egl.EglHook.OnChangeListener;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements OpenGLHook.a, EglHook.OnChangeListener
{
  private long gtH = 0L;
  
  public final void a(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(219499);
    if (parama.iHk != 1285)
    {
      AppMethodBeat.o(219499);
      return;
    }
    long l = System.currentTimeMillis();
    int i;
    int j;
    if (l - this.gtH > 300000L)
    {
      this.gtH = l;
      i = com.tencent.mm.gpu.e.c.wl(aj.getProcessName());
      if (i != -1)
      {
        j = PluginGpuRes.getCurrSpend();
        if (j > 0) {
          break label164;
        }
        ad.e("Gpu.GpuResReport", "spend error, spend = ".concat(String.valueOf(j)));
      }
    }
    for (;;)
    {
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219498);
          ax localax = ax.aQA("mmkv_gpu_service_key_single");
          localax.putInt("glGetErrorOOM_is_die", 0);
          localax.commit();
          AppMethodBeat.o(219498);
        }
      }, 180000L);
      parama = ax.aQA("mmkv_gpu_service_key_single");
      parama.putInt("glGetErrorOOM_is_die", 1);
      parama.commit();
      i = com.tencent.mm.gpu.e.c.wl(aj.getProcessName());
      if (i == -1) {
        break label371;
      }
      j = PluginGpuRes.getCurrSpend();
      if (j > 0) {
        break;
      }
      ad.e("Gpu.GpuResReport", "spend error, spend = ".concat(String.valueOf(j)));
      AppMethodBeat.o(219499);
      return;
      label164:
      com.tencent.mm.gpu.e.c.e(i, 136L, 1L);
    }
    if (j <= 3) {
      com.tencent.mm.gpu.e.c.e(i, 82L, 1L);
    }
    if (j <= 30)
    {
      com.tencent.mm.gpu.e.c.e(i, 7L, 1L);
      AppMethodBeat.o(219499);
      return;
    }
    if (j <= 60)
    {
      com.tencent.mm.gpu.e.c.e(i, 16L, 1L);
      AppMethodBeat.o(219499);
      return;
    }
    if (j <= 90)
    {
      com.tencent.mm.gpu.e.c.e(i, 25L, 1L);
      AppMethodBeat.o(219499);
      return;
    }
    if (j <= 120)
    {
      com.tencent.mm.gpu.e.c.e(i, 34L, 1L);
      AppMethodBeat.o(219499);
      return;
    }
    if (j <= 150)
    {
      com.tencent.mm.gpu.e.c.e(i, 43L, 1L);
      AppMethodBeat.o(219499);
      return;
    }
    if (j <= 180)
    {
      com.tencent.mm.gpu.e.c.e(i, 52L, 1L);
      AppMethodBeat.o(219499);
      return;
    }
    if (j <= 240)
    {
      com.tencent.mm.gpu.e.c.e(i, 61L, 1L);
      AppMethodBeat.o(219499);
      return;
    }
    if (j <= 300)
    {
      com.tencent.mm.gpu.e.c.e(i, 70L, 1L);
      AppMethodBeat.o(219499);
      return;
    }
    com.tencent.mm.gpu.e.c.e(i, 79L, 1L);
    label371:
    AppMethodBeat.o(219499);
  }
  
  public final void b(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(219500);
    parama = parama.iHj;
    if (parama.length == 0)
    {
      ad.e("Gpu.OpenglHookListener", "onGlGenTextures, ids length = 0");
      AppMethodBeat.o(219500);
      return;
    }
    long l = EGL14.eglGetCurrentContext().getNativeHandle();
    ArrayList localArrayList = new ArrayList();
    int j = parama.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new d(1, parama[i], l));
      i += 1;
    }
    com.tencent.mm.gpu.d.c.agM().W(localArrayList);
    AppMethodBeat.o(219500);
  }
  
  public final void c(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(219501);
    parama = parama.iHj;
    if (parama.length == 0)
    {
      ad.e("Gpu.OpenglHookListener", "onGlDeleteTextures, ids length = 0");
      AppMethodBeat.o(219501);
      return;
    }
    long l = EGL14.eglGetCurrentContext().getNativeHandle();
    ArrayList localArrayList = new ArrayList();
    int j = parama.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new d(1, parama[i], l));
      i += 1;
    }
    com.tencent.mm.gpu.d.c.agM().X(localArrayList);
    AppMethodBeat.o(219501);
  }
  
  public final void d(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(219502);
    parama = parama.iHj;
    if (parama.length == 0)
    {
      ad.e("Gpu.OpenglHookListener", "onGlGenBuffers, ids length = 0");
      AppMethodBeat.o(219502);
      return;
    }
    long l = EGL14.eglGetCurrentContext().getNativeHandle();
    ArrayList localArrayList = new ArrayList();
    int j = parama.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new d(2, parama[i], l));
      i += 1;
    }
    com.tencent.mm.gpu.d.c.agM().W(localArrayList);
    AppMethodBeat.o(219502);
  }
  
  public final void e(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(219503);
    parama = parama.iHj;
    if (parama.length == 0)
    {
      ad.e("Gpu.OpenglHookListener", "onGlDeleteBuffers, ids length = 0");
      AppMethodBeat.o(219503);
      return;
    }
    long l = EGL14.eglGetCurrentContext().getNativeHandle();
    ArrayList localArrayList = new ArrayList();
    int j = parama.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new d(2, parama[i], l));
      i += 1;
    }
    com.tencent.mm.gpu.d.c.agM().X(localArrayList);
    AppMethodBeat.o(219503);
  }
  
  public final void f(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(219504);
    parama = parama.iHj;
    if (parama.length == 0)
    {
      ad.e("Gpu.OpenglHookListener", "onGlGenFramebuffers, ids length = 0");
      AppMethodBeat.o(219504);
      return;
    }
    long l = EGL14.eglGetCurrentContext().getNativeHandle();
    ArrayList localArrayList = new ArrayList();
    int j = parama.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new d(3, parama[i], l));
      i += 1;
    }
    com.tencent.mm.gpu.d.c.agM().W(localArrayList);
    AppMethodBeat.o(219504);
  }
  
  public final void g(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(219505);
    parama = parama.iHj;
    if (parama.length == 0)
    {
      ad.e("Gpu.OpenglHookListener", "onGlDeleteFramebuffers, ids length = 0");
      AppMethodBeat.o(219505);
      return;
    }
    long l = EGL14.eglGetCurrentContext().getNativeHandle();
    ArrayList localArrayList = new ArrayList();
    int j = parama.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new d(3, parama[i], l));
      i += 1;
    }
    com.tencent.mm.gpu.d.c.agM().X(localArrayList);
    AppMethodBeat.o(219505);
  }
  
  public final void h(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(219506);
    parama = parama.iHj;
    if (parama.length == 0)
    {
      ad.e("Gpu.OpenglHookListener", "onGlGenRenderbuffers, ids length = 0");
      AppMethodBeat.o(219506);
      return;
    }
    long l = EGL14.eglGetCurrentContext().getNativeHandle();
    ArrayList localArrayList = new ArrayList();
    int j = parama.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new d(4, parama[i], l));
      i += 1;
    }
    com.tencent.mm.gpu.d.c.agM().W(localArrayList);
    AppMethodBeat.o(219506);
  }
  
  public final void i(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(219507);
    parama = parama.iHj;
    if (parama.length == 0)
    {
      ad.e("Gpu.OpenglHookListener", "onGlDeleteRenderbuffers, ids length = 0");
      AppMethodBeat.o(219507);
      return;
    }
    long l = EGL14.eglGetCurrentContext().getNativeHandle();
    ArrayList localArrayList = new ArrayList();
    int j = parama.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new d(4, parama[i], l));
      i += 1;
    }
    com.tencent.mm.gpu.d.c.agM().X(localArrayList);
    AppMethodBeat.o(219507);
  }
  
  public final void onCreateEglContext(com.tencent.wxperf.jni.egl.a parama)
  {
    AppMethodBeat.i(219508);
    if (PluginGpuRes.gtw)
    {
      ax.aQA("mmkv_gpu_service_key_single").putBoolean("eglCreateContext_status", true);
      ad.e("Gpu.OpenglHookListener", "onCreateEglContext needCheckMMKV, put KEY_EGL_CREATE_CONTEXT_STATUS == true");
    }
    ad.e("Gpu.OpenglHookListener", "onCreateEglContext " + parama.MoH);
    com.tencent.mm.gpu.e.c.e(com.tencent.mm.gpu.e.c.wl(aj.getProcessName()), 178L, 1L);
    com.tencent.mm.gpu.d.a.agK().a(new b(17, parama.MoH));
    AppMethodBeat.o(219508);
  }
  
  public final void onCreateEglWindowSurface(com.tencent.wxperf.jni.egl.a parama)
  {
    AppMethodBeat.i(219510);
    if (PluginGpuRes.gtw)
    {
      ax.aQA("mmkv_gpu_service_key_single").putBoolean("eglCreateSurface_status", true);
      ad.e("Gpu.OpenglHookListener", "onCreatePbufferSurface needCheckMMKV, put KEY_EGL_CREATE_SURFACE_STATUS == true");
    }
    ad.e("Gpu.OpenglHookListener", "onCreateEglWindowSurface " + parama.MoH);
    com.tencent.mm.gpu.e.c.e(com.tencent.mm.gpu.e.c.wl(aj.getProcessName()), 180L, 1L);
    com.tencent.mm.gpu.d.a.agK().a(new b(18, parama.MoH));
    AppMethodBeat.o(219510);
  }
  
  public final void onCreatePbufferSurface(com.tencent.wxperf.jni.egl.a parama)
  {
    AppMethodBeat.i(219511);
    if (PluginGpuRes.gtw)
    {
      ax.aQA("mmkv_gpu_service_key_single").putBoolean("eglCreateSurface_status", true);
      ad.e("Gpu.OpenglHookListener", "onCreatePbufferSurface needCheckMMKV, put KEY_EGL_CREATE_SURFACE_STATUS == true");
    }
    ad.e("Gpu.OpenglHookListener", "onCreatePbufferSurface = " + parama.MoH);
    com.tencent.mm.gpu.e.c.e(com.tencent.mm.gpu.e.c.wl(aj.getProcessName()), 181L, 1L);
    com.tencent.mm.gpu.d.a.agK().a(new b(18, parama.MoH));
    AppMethodBeat.o(219511);
  }
  
  public final void onDeleteEglContext(long paramLong)
  {
    AppMethodBeat.i(219509);
    if (PluginGpuRes.gtw)
    {
      ax.aQA("mmkv_gpu_service_key_single").putBoolean("eglDestroyContext_status", true);
      ad.e("Gpu.OpenglHookListener", "onDeleteEglContext needCheckMMKV, put KEY_EGL_CREATE_CONTEXT_STATUS == true");
    }
    ad.e("Gpu.OpenglHookListener", "onDeleteEglContext ".concat(String.valueOf(paramLong)));
    com.tencent.mm.gpu.e.c.e(com.tencent.mm.gpu.e.c.wl(aj.getProcessName()), 179L, 1L);
    com.tencent.mm.gpu.d.a.agK().b(new b(17, paramLong));
    com.tencent.mm.gpu.d.c localc = com.tencent.mm.gpu.d.c.agM();
    localc.gtL.post(new c.3(localc, paramLong));
    AppMethodBeat.o(219509);
  }
  
  public final void onDeleteEglSurface(long paramLong)
  {
    AppMethodBeat.i(219512);
    if (PluginGpuRes.gtw)
    {
      ax.aQA("mmkv_gpu_service_key_single").putBoolean("eglDestroySurface_status", true);
      ad.e("Gpu.OpenglHookListener", "onDeleteEglSurface needCheckMMKV, put KEY_EGL_DESTROY_SURFACE_STATUS == true");
    }
    ad.e("Gpu.OpenglHookListener", "onDeleteEglSurface = ".concat(String.valueOf(paramLong)));
    com.tencent.mm.gpu.e.c.e(com.tencent.mm.gpu.e.c.wl(aj.getProcessName()), 182L, 1L);
    com.tencent.mm.gpu.d.a.agK().b(new b(18, paramLong));
    AppMethodBeat.o(219512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.c.a
 * JD-Core Version:    0.7.0.1
 */