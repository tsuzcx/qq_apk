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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.wxperf.jni.egl.EglHook.OnChangeListener;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements OpenGLHook.a, EglHook.OnChangeListener
{
  private long gwo = 0L;
  
  public final void a(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(209621);
    if (parama.iKd != 1285)
    {
      AppMethodBeat.o(209621);
      return;
    }
    long l = System.currentTimeMillis();
    int i;
    int j;
    if (l - this.gwo > 300000L)
    {
      this.gwo = l;
      i = com.tencent.mm.gpu.e.c.wU(ak.getProcessName());
      if (i != -1)
      {
        j = PluginGpuRes.getCurrSpend();
        if (j > 0) {
          break label164;
        }
        ae.e("Gpu.GpuResReport", "spend error, spend = ".concat(String.valueOf(j)));
      }
    }
    for (;;)
    {
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(209620);
          ay localay = ay.aRX("mmkv_gpu_service_key_single");
          localay.putInt("glGetErrorOOM_is_die", 0);
          localay.commit();
          AppMethodBeat.o(209620);
        }
      }, 180000L);
      parama = ay.aRX("mmkv_gpu_service_key_single");
      parama.putInt("glGetErrorOOM_is_die", 1);
      parama.commit();
      i = com.tencent.mm.gpu.e.c.wU(ak.getProcessName());
      if (i == -1) {
        break label371;
      }
      j = PluginGpuRes.getCurrSpend();
      if (j > 0) {
        break;
      }
      ae.e("Gpu.GpuResReport", "spend error, spend = ".concat(String.valueOf(j)));
      AppMethodBeat.o(209621);
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
      AppMethodBeat.o(209621);
      return;
    }
    if (j <= 60)
    {
      com.tencent.mm.gpu.e.c.e(i, 16L, 1L);
      AppMethodBeat.o(209621);
      return;
    }
    if (j <= 90)
    {
      com.tencent.mm.gpu.e.c.e(i, 25L, 1L);
      AppMethodBeat.o(209621);
      return;
    }
    if (j <= 120)
    {
      com.tencent.mm.gpu.e.c.e(i, 34L, 1L);
      AppMethodBeat.o(209621);
      return;
    }
    if (j <= 150)
    {
      com.tencent.mm.gpu.e.c.e(i, 43L, 1L);
      AppMethodBeat.o(209621);
      return;
    }
    if (j <= 180)
    {
      com.tencent.mm.gpu.e.c.e(i, 52L, 1L);
      AppMethodBeat.o(209621);
      return;
    }
    if (j <= 240)
    {
      com.tencent.mm.gpu.e.c.e(i, 61L, 1L);
      AppMethodBeat.o(209621);
      return;
    }
    if (j <= 300)
    {
      com.tencent.mm.gpu.e.c.e(i, 70L, 1L);
      AppMethodBeat.o(209621);
      return;
    }
    com.tencent.mm.gpu.e.c.e(i, 79L, 1L);
    label371:
    AppMethodBeat.o(209621);
  }
  
  public final void b(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(209622);
    parama = parama.iKc;
    if (parama.length == 0)
    {
      ae.e("Gpu.OpenglHookListener", "onGlGenTextures, ids length = 0");
      AppMethodBeat.o(209622);
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
    com.tencent.mm.gpu.d.c.ahb().W(localArrayList);
    AppMethodBeat.o(209622);
  }
  
  public final void c(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(209623);
    parama = parama.iKc;
    if (parama.length == 0)
    {
      ae.e("Gpu.OpenglHookListener", "onGlDeleteTextures, ids length = 0");
      AppMethodBeat.o(209623);
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
    com.tencent.mm.gpu.d.c.ahb().X(localArrayList);
    AppMethodBeat.o(209623);
  }
  
  public final void d(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(209624);
    parama = parama.iKc;
    if (parama.length == 0)
    {
      ae.e("Gpu.OpenglHookListener", "onGlGenBuffers, ids length = 0");
      AppMethodBeat.o(209624);
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
    com.tencent.mm.gpu.d.c.ahb().W(localArrayList);
    AppMethodBeat.o(209624);
  }
  
  public final void e(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(209625);
    parama = parama.iKc;
    if (parama.length == 0)
    {
      ae.e("Gpu.OpenglHookListener", "onGlDeleteBuffers, ids length = 0");
      AppMethodBeat.o(209625);
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
    com.tencent.mm.gpu.d.c.ahb().X(localArrayList);
    AppMethodBeat.o(209625);
  }
  
  public final void f(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(209626);
    parama = parama.iKc;
    if (parama.length == 0)
    {
      ae.e("Gpu.OpenglHookListener", "onGlGenFramebuffers, ids length = 0");
      AppMethodBeat.o(209626);
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
    com.tencent.mm.gpu.d.c.ahb().W(localArrayList);
    AppMethodBeat.o(209626);
  }
  
  public final void g(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(209627);
    parama = parama.iKc;
    if (parama.length == 0)
    {
      ae.e("Gpu.OpenglHookListener", "onGlDeleteFramebuffers, ids length = 0");
      AppMethodBeat.o(209627);
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
    com.tencent.mm.gpu.d.c.ahb().X(localArrayList);
    AppMethodBeat.o(209627);
  }
  
  public final void h(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(209628);
    parama = parama.iKc;
    if (parama.length == 0)
    {
      ae.e("Gpu.OpenglHookListener", "onGlGenRenderbuffers, ids length = 0");
      AppMethodBeat.o(209628);
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
    com.tencent.mm.gpu.d.c.ahb().W(localArrayList);
    AppMethodBeat.o(209628);
  }
  
  public final void i(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(209629);
    parama = parama.iKc;
    if (parama.length == 0)
    {
      ae.e("Gpu.OpenglHookListener", "onGlDeleteRenderbuffers, ids length = 0");
      AppMethodBeat.o(209629);
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
    com.tencent.mm.gpu.d.c.ahb().X(localArrayList);
    AppMethodBeat.o(209629);
  }
  
  public final void onCreateEglContext(com.tencent.wxperf.jni.egl.a parama)
  {
    AppMethodBeat.i(209630);
    if (PluginGpuRes.gwd)
    {
      ay.aRX("mmkv_gpu_service_key_single").putBoolean("eglCreateContext_status", true);
      ae.e("Gpu.OpenglHookListener", "onCreateEglContext needCheckMMKV, put KEY_EGL_CREATE_CONTEXT_STATUS == true");
    }
    ae.e("Gpu.OpenglHookListener", "onCreateEglContext " + parama.MLD);
    com.tencent.mm.gpu.e.c.e(com.tencent.mm.gpu.e.c.wU(ak.getProcessName()), 178L, 1L);
    com.tencent.mm.gpu.d.a.agZ().a(new b(17, parama.MLD));
    AppMethodBeat.o(209630);
  }
  
  public final void onCreateEglWindowSurface(com.tencent.wxperf.jni.egl.a parama)
  {
    AppMethodBeat.i(209632);
    if (PluginGpuRes.gwd)
    {
      ay.aRX("mmkv_gpu_service_key_single").putBoolean("eglCreateSurface_status", true);
      ae.e("Gpu.OpenglHookListener", "onCreatePbufferSurface needCheckMMKV, put KEY_EGL_CREATE_SURFACE_STATUS == true");
    }
    ae.e("Gpu.OpenglHookListener", "onCreateEglWindowSurface " + parama.MLD);
    com.tencent.mm.gpu.e.c.e(com.tencent.mm.gpu.e.c.wU(ak.getProcessName()), 180L, 1L);
    com.tencent.mm.gpu.d.a.agZ().a(new b(18, parama.MLD));
    AppMethodBeat.o(209632);
  }
  
  public final void onCreatePbufferSurface(com.tencent.wxperf.jni.egl.a parama)
  {
    AppMethodBeat.i(209633);
    if (PluginGpuRes.gwd)
    {
      ay.aRX("mmkv_gpu_service_key_single").putBoolean("eglCreateSurface_status", true);
      ae.e("Gpu.OpenglHookListener", "onCreatePbufferSurface needCheckMMKV, put KEY_EGL_CREATE_SURFACE_STATUS == true");
    }
    ae.e("Gpu.OpenglHookListener", "onCreatePbufferSurface = " + parama.MLD);
    com.tencent.mm.gpu.e.c.e(com.tencent.mm.gpu.e.c.wU(ak.getProcessName()), 181L, 1L);
    com.tencent.mm.gpu.d.a.agZ().a(new b(18, parama.MLD));
    AppMethodBeat.o(209633);
  }
  
  public final void onDeleteEglContext(long paramLong)
  {
    AppMethodBeat.i(209631);
    if (PluginGpuRes.gwd)
    {
      ay.aRX("mmkv_gpu_service_key_single").putBoolean("eglDestroyContext_status", true);
      ae.e("Gpu.OpenglHookListener", "onDeleteEglContext needCheckMMKV, put KEY_EGL_CREATE_CONTEXT_STATUS == true");
    }
    ae.e("Gpu.OpenglHookListener", "onDeleteEglContext ".concat(String.valueOf(paramLong)));
    com.tencent.mm.gpu.e.c.e(com.tencent.mm.gpu.e.c.wU(ak.getProcessName()), 179L, 1L);
    com.tencent.mm.gpu.d.a.agZ().b(new b(17, paramLong));
    com.tencent.mm.gpu.d.c localc = com.tencent.mm.gpu.d.c.ahb();
    localc.gws.post(new c.3(localc, paramLong));
    AppMethodBeat.o(209631);
  }
  
  public final void onDeleteEglSurface(long paramLong)
  {
    AppMethodBeat.i(209634);
    if (PluginGpuRes.gwd)
    {
      ay.aRX("mmkv_gpu_service_key_single").putBoolean("eglDestroySurface_status", true);
      ae.e("Gpu.OpenglHookListener", "onDeleteEglSurface needCheckMMKV, put KEY_EGL_DESTROY_SURFACE_STATUS == true");
    }
    ae.e("Gpu.OpenglHookListener", "onDeleteEglSurface = ".concat(String.valueOf(paramLong)));
    com.tencent.mm.gpu.e.c.e(com.tencent.mm.gpu.e.c.wU(ak.getProcessName()), 182L, 1L);
    com.tencent.mm.gpu.d.a.agZ().b(new b(18, paramLong));
    AppMethodBeat.o(209634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.c.a
 * JD-Core Version:    0.7.0.1
 */