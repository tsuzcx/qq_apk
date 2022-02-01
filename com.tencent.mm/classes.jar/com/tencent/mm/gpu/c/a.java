package com.tencent.mm.gpu.c;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.Looper;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.PluginGpuRes;
import com.tencent.mm.gpu.e.d;
import com.tencent.mm.openglapihook.OpenGLHook.a;
import com.tencent.mm.performance.a.a.a;
import com.tencent.mm.performance.jni.egl.EglHook.OnChangeListener;
import com.tencent.mm.performance.jni.egl.EglResourceMonitor;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements OpenGLHook.a, EglHook.OnChangeListener
{
  private long gai = 0L;
  
  public final void onCreateEglContext(EglResourceMonitor paramEglResourceMonitor)
  {
    AppMethodBeat.i(209406);
    ac.e("Gpu.OpenglHookListener", "onCreateEglContext callback ");
    ac.e("Gpu.OpenglHookListener", paramEglResourceMonitor.javaStack);
    d.e(d.tv(ai.getProcessName()), 178L, 1L);
    AppMethodBeat.o(209406);
  }
  
  public final void onCreateEglWindowSurface(EglResourceMonitor paramEglResourceMonitor)
  {
    AppMethodBeat.i(209408);
    ac.e("Gpu.OpenglHookListener", "onCreateEglWindowSurface callback ");
    ac.e("Gpu.OpenglHookListener", paramEglResourceMonitor.javaStack);
    d.e(d.tv(ai.getProcessName()), 180L, 1L);
    AppMethodBeat.o(209408);
  }
  
  public final void onCreatePbufferSurface(EglResourceMonitor paramEglResourceMonitor)
  {
    AppMethodBeat.i(209409);
    ac.e("Gpu.OpenglHookListener", "onCreatePbufferSurface callback ");
    ac.e("Gpu.OpenglHookListener", paramEglResourceMonitor.javaStack);
    d.e(d.tv(ai.getProcessName()), 181L, 1L);
    AppMethodBeat.o(209409);
  }
  
  public final void onDeleteEglContext(long paramLong)
  {
    AppMethodBeat.i(209407);
    d.e(d.tv(ai.getProcessName()), 179L, 1L);
    AppMethodBeat.o(209407);
  }
  
  public final void onDeleteEglSurface(long paramLong)
  {
    AppMethodBeat.i(209410);
    d.e(d.tv(ai.getProcessName()), 182L, 1L);
    AppMethodBeat.o(209410);
  }
  
  public final void onGetError(int paramInt)
  {
    AppMethodBeat.i(209397);
    if (paramInt != 1285)
    {
      AppMethodBeat.o(209397);
      return;
    }
    long l = System.currentTimeMillis();
    int i;
    if (l - this.gai > 300000L)
    {
      this.gai = l;
      paramInt = d.tv(ai.getProcessName());
      if (paramInt != -1)
      {
        i = PluginGpuRes.getCurrSpend();
        if (i > 0) {
          break label178;
        }
        ac.e("Gpu.GpuResReport", "spend error, spend = ".concat(String.valueOf(i)));
      }
    }
    for (;;)
    {
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(209395);
          aw localaw = aw.aKU("mmkv_gpu_service_key_single");
          localaw.putInt("glGetErrorOOM_is_die", 0);
          localaw.commit();
          AppMethodBeat.o(209395);
        }
      }, 180000L);
      aw localaw = aw.aKU("mmkv_gpu_service_key_single");
      localaw.putInt("glGetErrorOOM_is_die", 1);
      localaw.commit();
      com.tencent.e.h.JZN.aT(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(209396);
          boolean bool = PluginGpuRes.isFront();
          int i = com.tencent.mm.gpu.f.b.aep();
          String str = com.tencent.mm.performance.a.a.aMA().m(true, 0).toString();
          int j = PluginGpuRes.getCurrSpend();
          ac.e("Gpu.OpenglHookListener", "isFront = ".concat(String.valueOf(bool)));
          ac.e("Gpu.OpenglHookListener", "oomScore = ".concat(String.valueOf(i)));
          ac.e("Gpu.OpenglHookListener", "memoryInfo".concat(String.valueOf(str)));
          ac.e("Gpu.OpenglHookListener", "time = " + j + "/min");
          com.tencent.mm.plugin.report.service.h.wUl.f(20201, new Object[] { Integer.valueOf(i), str, Boolean.valueOf(bool), Integer.valueOf(j) });
          AppMethodBeat.o(209396);
        }
      });
      paramInt = d.tv(ai.getProcessName());
      if (paramInt == -1) {
        break label385;
      }
      i = PluginGpuRes.getCurrSpend();
      if (i > 0) {
        break;
      }
      ac.e("Gpu.GpuResReport", "spend error, spend = ".concat(String.valueOf(i)));
      AppMethodBeat.o(209397);
      return;
      label178:
      d.e(paramInt, 136L, 1L);
    }
    if (i <= 3) {
      d.e(paramInt, 82L, 1L);
    }
    if (i <= 30)
    {
      d.e(paramInt, 7L, 1L);
      AppMethodBeat.o(209397);
      return;
    }
    if (i <= 60)
    {
      d.e(paramInt, 16L, 1L);
      AppMethodBeat.o(209397);
      return;
    }
    if (i <= 90)
    {
      d.e(paramInt, 25L, 1L);
      AppMethodBeat.o(209397);
      return;
    }
    if (i <= 120)
    {
      d.e(paramInt, 34L, 1L);
      AppMethodBeat.o(209397);
      return;
    }
    if (i <= 150)
    {
      d.e(paramInt, 43L, 1L);
      AppMethodBeat.o(209397);
      return;
    }
    if (i <= 180)
    {
      d.e(paramInt, 52L, 1L);
      AppMethodBeat.o(209397);
      return;
    }
    if (i <= 240)
    {
      d.e(paramInt, 61L, 1L);
      AppMethodBeat.o(209397);
      return;
    }
    if (i <= 300)
    {
      d.e(paramInt, 70L, 1L);
      AppMethodBeat.o(209397);
      return;
    }
    d.e(paramInt, 79L, 1L);
    label385:
    AppMethodBeat.o(209397);
  }
  
  public final void onGlDeleteBuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(209401);
    int j = paramArrayOfInt.length;
    if (j == 0)
    {
      AppMethodBeat.o(209401);
      return;
    }
    long l = EGL14.eglGetCurrentContext().getNativeHandle();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new com.tencent.mm.gpu.d.b(2, paramArrayOfInt[i], l));
      i += 1;
    }
    com.tencent.mm.gpu.d.a.aef().W(localArrayList);
    AppMethodBeat.o(209401);
  }
  
  public final void onGlDeleteFramebuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(209403);
    int j = paramArrayOfInt.length;
    if (j == 0)
    {
      AppMethodBeat.o(209403);
      return;
    }
    long l = EGL14.eglGetCurrentContext().getNativeHandle();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new com.tencent.mm.gpu.d.b(3, paramArrayOfInt[i], l));
      i += 1;
    }
    com.tencent.mm.gpu.d.a.aef().W(localArrayList);
    AppMethodBeat.o(209403);
  }
  
  public final void onGlDeleteRenderbuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(209405);
    int j = paramArrayOfInt.length;
    if (j == 0)
    {
      AppMethodBeat.o(209405);
      return;
    }
    long l = EGL14.eglGetCurrentContext().getNativeHandle();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new com.tencent.mm.gpu.d.b(4, paramArrayOfInt[i], l));
      i += 1;
    }
    com.tencent.mm.gpu.d.a.aef().W(localArrayList);
    AppMethodBeat.o(209405);
  }
  
  public final void onGlDeleteTextures(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(209399);
    int j = paramArrayOfInt.length;
    if (j == 0)
    {
      AppMethodBeat.o(209399);
      return;
    }
    long l = EGL14.eglGetCurrentContext().getNativeHandle();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new com.tencent.mm.gpu.d.b(1, paramArrayOfInt[i], l));
      i += 1;
    }
    com.tencent.mm.gpu.d.a.aef().W(localArrayList);
    AppMethodBeat.o(209399);
  }
  
  public final void onGlGenBuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(209400);
    int j = paramArrayOfInt.length;
    if (j == 0)
    {
      AppMethodBeat.o(209400);
      return;
    }
    long l = EGL14.eglGetCurrentContext().getNativeHandle();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new com.tencent.mm.gpu.d.b(2, paramArrayOfInt[i], l));
      i += 1;
    }
    com.tencent.mm.gpu.d.a.aef().V(localArrayList);
    AppMethodBeat.o(209400);
  }
  
  public final void onGlGenFramebuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(209402);
    int j = paramArrayOfInt.length;
    if (j == 0)
    {
      AppMethodBeat.o(209402);
      return;
    }
    long l = EGL14.eglGetCurrentContext().getNativeHandle();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new com.tencent.mm.gpu.d.b(3, paramArrayOfInt[i], l));
      i += 1;
    }
    com.tencent.mm.gpu.d.a.aef().V(localArrayList);
    AppMethodBeat.o(209402);
  }
  
  public final void onGlGenRenderbuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(209404);
    int j = paramArrayOfInt.length;
    if (j == 0)
    {
      AppMethodBeat.o(209404);
      return;
    }
    long l = EGL14.eglGetCurrentContext().getNativeHandle();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new com.tencent.mm.gpu.d.b(4, paramArrayOfInt[i], l));
      i += 1;
    }
    com.tencent.mm.gpu.d.a.aef().V(localArrayList);
    AppMethodBeat.o(209404);
  }
  
  public final void onGlGenTextures(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(209398);
    int j = paramArrayOfInt.length;
    if (j == 0)
    {
      AppMethodBeat.o(209398);
      return;
    }
    long l = EGL14.eglGetCurrentContext().getNativeHandle();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new com.tencent.mm.gpu.d.b(1, paramArrayOfInt[i], l));
      i += 1;
    }
    com.tencent.mm.gpu.d.a.aef().V(localArrayList);
    AppMethodBeat.o(209398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.gpu.c.a
 * JD-Core Version:    0.7.0.1
 */