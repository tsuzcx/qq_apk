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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.wxperf.jni.egl.EglHook.OnChangeListener;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements OpenGLHook.a, EglHook.OnChangeListener
{
  private long hjc = 0L;
  
  public final void a(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(186153);
    if (parama.jGJ != 1285)
    {
      AppMethodBeat.o(186153);
      return;
    }
    long l = System.currentTimeMillis();
    int i;
    int j;
    if (l - this.hjc > 300000L)
    {
      this.hjc = l;
      i = com.tencent.mm.gpu.e.c.Fi(MMApplicationContext.getProcessName());
      if (i != -1)
      {
        j = PluginGpuRes.getCurrSpend();
        if (j > 0) {
          break label164;
        }
        Log.e("Gpu.GpuResReport", "spend error, spend = ".concat(String.valueOf(j)));
      }
    }
    for (;;)
    {
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186152);
          MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single");
          localMultiProcessMMKV.putInt("glGetErrorOOM_is_die", 0);
          localMultiProcessMMKV.commit();
          AppMethodBeat.o(186152);
        }
      }, 180000L);
      parama = MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single");
      parama.putInt("glGetErrorOOM_is_die", 1);
      parama.commit();
      i = com.tencent.mm.gpu.e.c.Fi(MMApplicationContext.getProcessName());
      if (i == -1) {
        break label371;
      }
      j = PluginGpuRes.getCurrSpend();
      if (j > 0) {
        break;
      }
      Log.e("Gpu.GpuResReport", "spend error, spend = ".concat(String.valueOf(j)));
      AppMethodBeat.o(186153);
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
      AppMethodBeat.o(186153);
      return;
    }
    if (j <= 60)
    {
      com.tencent.mm.gpu.e.c.e(i, 16L, 1L);
      AppMethodBeat.o(186153);
      return;
    }
    if (j <= 90)
    {
      com.tencent.mm.gpu.e.c.e(i, 25L, 1L);
      AppMethodBeat.o(186153);
      return;
    }
    if (j <= 120)
    {
      com.tencent.mm.gpu.e.c.e(i, 34L, 1L);
      AppMethodBeat.o(186153);
      return;
    }
    if (j <= 150)
    {
      com.tencent.mm.gpu.e.c.e(i, 43L, 1L);
      AppMethodBeat.o(186153);
      return;
    }
    if (j <= 180)
    {
      com.tencent.mm.gpu.e.c.e(i, 52L, 1L);
      AppMethodBeat.o(186153);
      return;
    }
    if (j <= 240)
    {
      com.tencent.mm.gpu.e.c.e(i, 61L, 1L);
      AppMethodBeat.o(186153);
      return;
    }
    if (j <= 300)
    {
      com.tencent.mm.gpu.e.c.e(i, 70L, 1L);
      AppMethodBeat.o(186153);
      return;
    }
    com.tencent.mm.gpu.e.c.e(i, 79L, 1L);
    label371:
    AppMethodBeat.o(186153);
  }
  
  public final void b(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(186154);
    parama = parama.jGI;
    if (parama.length == 0)
    {
      Log.e("Gpu.OpenglHookListener", "onGlGenTextures, ids length = 0");
      AppMethodBeat.o(186154);
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
    com.tencent.mm.gpu.d.c.axn().ae(localArrayList);
    AppMethodBeat.o(186154);
  }
  
  public final void c(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(186155);
    parama = parama.jGI;
    if (parama.length == 0)
    {
      Log.e("Gpu.OpenglHookListener", "onGlDeleteTextures, ids length = 0");
      AppMethodBeat.o(186155);
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
    com.tencent.mm.gpu.d.c.axn().af(localArrayList);
    AppMethodBeat.o(186155);
  }
  
  public final void d(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(186156);
    parama = parama.jGI;
    if (parama.length == 0)
    {
      Log.e("Gpu.OpenglHookListener", "onGlGenBuffers, ids length = 0");
      AppMethodBeat.o(186156);
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
    com.tencent.mm.gpu.d.c.axn().ae(localArrayList);
    AppMethodBeat.o(186156);
  }
  
  public final void e(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(186157);
    parama = parama.jGI;
    if (parama.length == 0)
    {
      Log.e("Gpu.OpenglHookListener", "onGlDeleteBuffers, ids length = 0");
      AppMethodBeat.o(186157);
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
    com.tencent.mm.gpu.d.c.axn().af(localArrayList);
    AppMethodBeat.o(186157);
  }
  
  public final void f(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(186158);
    parama = parama.jGI;
    if (parama.length == 0)
    {
      Log.e("Gpu.OpenglHookListener", "onGlGenFramebuffers, ids length = 0");
      AppMethodBeat.o(186158);
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
    com.tencent.mm.gpu.d.c.axn().ae(localArrayList);
    AppMethodBeat.o(186158);
  }
  
  public final void g(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(186159);
    parama = parama.jGI;
    if (parama.length == 0)
    {
      Log.e("Gpu.OpenglHookListener", "onGlDeleteFramebuffers, ids length = 0");
      AppMethodBeat.o(186159);
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
    com.tencent.mm.gpu.d.c.axn().af(localArrayList);
    AppMethodBeat.o(186159);
  }
  
  public final void h(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(186160);
    parama = parama.jGI;
    if (parama.length == 0)
    {
      Log.e("Gpu.OpenglHookListener", "onGlGenRenderbuffers, ids length = 0");
      AppMethodBeat.o(186160);
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
    com.tencent.mm.gpu.d.c.axn().ae(localArrayList);
    AppMethodBeat.o(186160);
  }
  
  public final void i(com.tencent.mm.openglapihook.a parama)
  {
    AppMethodBeat.i(186161);
    parama = parama.jGI;
    if (parama.length == 0)
    {
      Log.e("Gpu.OpenglHookListener", "onGlDeleteRenderbuffers, ids length = 0");
      AppMethodBeat.o(186161);
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
    com.tencent.mm.gpu.d.c.axn().af(localArrayList);
    AppMethodBeat.o(186161);
  }
  
  public final void onCreateEglContext(com.tencent.wxperf.jni.egl.a parama)
  {
    AppMethodBeat.i(186162);
    if (PluginGpuRes.hiS)
    {
      MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single").putBoolean("eglCreateContext_status", true);
      Log.e("Gpu.OpenglHookListener", "onCreateEglContext needCheckMMKV, put KEY_EGL_CREATE_CONTEXT_STATUS == true");
    }
    Log.e("Gpu.OpenglHookListener", "onCreateEglContext " + parama.Syr);
    com.tencent.mm.gpu.e.c.e(com.tencent.mm.gpu.e.c.Fi(MMApplicationContext.getProcessName()), 178L, 1L);
    com.tencent.mm.gpu.d.a.axl().a(new b(17, parama.Syr));
    AppMethodBeat.o(186162);
  }
  
  public final void onCreateEglWindowSurface(com.tencent.wxperf.jni.egl.a parama)
  {
    AppMethodBeat.i(186164);
    if (PluginGpuRes.hiS)
    {
      MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single").putBoolean("eglCreateSurface_status", true);
      Log.e("Gpu.OpenglHookListener", "onCreatePbufferSurface needCheckMMKV, put KEY_EGL_CREATE_SURFACE_STATUS == true");
    }
    Log.e("Gpu.OpenglHookListener", "onCreateEglWindowSurface " + parama.Syr);
    com.tencent.mm.gpu.e.c.e(com.tencent.mm.gpu.e.c.Fi(MMApplicationContext.getProcessName()), 180L, 1L);
    com.tencent.mm.gpu.d.a.axl().a(new b(18, parama.Syr));
    AppMethodBeat.o(186164);
  }
  
  public final void onCreatePbufferSurface(com.tencent.wxperf.jni.egl.a parama)
  {
    AppMethodBeat.i(186165);
    if (PluginGpuRes.hiS)
    {
      MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single").putBoolean("eglCreateSurface_status", true);
      Log.e("Gpu.OpenglHookListener", "onCreatePbufferSurface needCheckMMKV, put KEY_EGL_CREATE_SURFACE_STATUS == true");
    }
    Log.e("Gpu.OpenglHookListener", "onCreatePbufferSurface = " + parama.Syr);
    com.tencent.mm.gpu.e.c.e(com.tencent.mm.gpu.e.c.Fi(MMApplicationContext.getProcessName()), 181L, 1L);
    com.tencent.mm.gpu.d.a.axl().a(new b(18, parama.Syr));
    AppMethodBeat.o(186165);
  }
  
  public final void onDeleteEglContext(long paramLong)
  {
    AppMethodBeat.i(186163);
    if (PluginGpuRes.hiS)
    {
      MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single").putBoolean("eglDestroyContext_status", true);
      Log.e("Gpu.OpenglHookListener", "onDeleteEglContext needCheckMMKV, put KEY_EGL_CREATE_CONTEXT_STATUS == true");
    }
    Log.e("Gpu.OpenglHookListener", "onDeleteEglContext ".concat(String.valueOf(paramLong)));
    com.tencent.mm.gpu.e.c.e(com.tencent.mm.gpu.e.c.Fi(MMApplicationContext.getProcessName()), 179L, 1L);
    com.tencent.mm.gpu.d.a.axl().b(new b(17, paramLong));
    com.tencent.mm.gpu.d.c localc = com.tencent.mm.gpu.d.c.axn();
    localc.hjg.post(new c.3(localc, paramLong));
    AppMethodBeat.o(186163);
  }
  
  public final void onDeleteEglSurface(long paramLong)
  {
    AppMethodBeat.i(186166);
    if (PluginGpuRes.hiS)
    {
      MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single").putBoolean("eglDestroySurface_status", true);
      Log.e("Gpu.OpenglHookListener", "onDeleteEglSurface needCheckMMKV, put KEY_EGL_DESTROY_SURFACE_STATUS == true");
    }
    Log.e("Gpu.OpenglHookListener", "onDeleteEglSurface = ".concat(String.valueOf(paramLong)));
    com.tencent.mm.gpu.e.c.e(com.tencent.mm.gpu.e.c.Fi(MMApplicationContext.getProcessName()), 182L, 1L);
    com.tencent.mm.gpu.d.a.axl().b(new b(18, paramLong));
    AppMethodBeat.o(186166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.gpu.c.a
 * JD-Core Version:    0.7.0.1
 */