package com.tencent.mm.gpu.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.f.c;
import com.tencent.mm.gpu.g.b;
import com.tencent.mm.openglapihook.OpenGLHook;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class a
{
  private static EGLConfig jUW;
  private static EGLContext jUX;
  private static EGLSurface jUY;
  private static boolean jUZ = false;
  private static EGLDisplay mEGLDisplay;
  
  public static void aEI()
  {
    AppMethodBeat.i(210858);
    Log.i("MicroMsg.OpenGLHookUtils", "[sunny]ec:%d,t:%s,itv:%d", new Object[] { Integer.valueOf(1), "OpenGL_Api_Hook", Integer.valueOf(120) });
    try
    {
      Intent localIntent = new Intent();
      Context localContext = MMApplicationContext.getContext();
      localIntent.setComponent(new ComponentName(localContext.getPackageName(), "com.tencent.mm.plugin.rubbishbin.RubbishBinServiceImpl"));
      localIntent.putExtra("exec_time", 1);
      localIntent.putExtra("interval", 120);
      localIntent.putExtra("exec_tag", "OpenGL_Api_Hook");
      localContext.startService(localIntent);
      Log.e("MicroMsg.OpenGLHookUtils", "PluginGpuRes startGpuHookService success");
      AppMethodBeat.o(210858);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.OpenGLHookUtils", "GpuHookService.enableGpuHook :" + localException.getMessage());
      AppMethodBeat.o(210858);
    }
  }
  
  public static void hook()
  {
    AppMethodBeat.i(210857);
    boolean bool = b.aES();
    Log.e("MicroMsg.OpenGLHookUtils", "hasUpdate = ".concat(String.valueOf(bool)));
    if (bool)
    {
      aEI();
      Log.e("MicroMsg.OpenGLHookUtils", "undo opengl this time because system gpu so change");
      AppMethodBeat.o(210857);
      return;
    }
    Object localObject1 = MultiProcessMMKV.getMMKV("mmkv_gpu_service_key_muti");
    Object localObject2 = EGL14.eglGetDisplay(0);
    mEGLDisplay = (EGLDisplay)localObject2;
    if (localObject2 == EGL14.EGL_NO_DISPLAY)
    {
      Log.e("MicroMsg.OpenGLHookUtils", "mEGLDisplay == EGL14.EGL_NO_DISPLAY");
      jUZ = true;
    }
    while (jUZ)
    {
      AppMethodBeat.o(210857);
      return;
      localObject2 = new int[2];
      if (!EGL14.eglInitialize(mEGLDisplay, (int[])localObject2, 0, (int[])localObject2, 1))
      {
        Log.e("MicroMsg.OpenGLHookUtils", "eglInitialize fail");
        jUZ = true;
      }
      else
      {
        localObject2 = new int[1];
        Object localObject3 = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(mEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344 }, 0, (EGLConfig[])localObject3, 0, 1, (int[])localObject2, 0))
        {
          Log.e("MicroMsg.OpenGLHookUtils", "eglChooseConfig fail");
          jUZ = true;
        }
        else
        {
          jUW = localObject3[0];
          MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single");
          localObject2 = EGL14.eglCreateContext(mEGLDisplay, jUW, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
          jUX = (EGLContext)localObject2;
          if (localObject2 == EGL14.EGL_NO_CONTEXT)
          {
            Log.e("MicroMsg.OpenGLHookUtils", "EGL14.eglGetError() = ".concat(String.valueOf(EGL14.eglGetError())));
            Log.e("MicroMsg.OpenGLHookUtils", "mEglContext == EGL14.EGL_NO_CONTEXT");
            jUZ = true;
          }
          else
          {
            localObject2 = EGL14.eglCreatePbufferSurface(mEGLDisplay, jUW, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
            jUY = (EGLSurface)localObject2;
            if (localObject2 == EGL14.EGL_NO_SURFACE)
            {
              Log.e("MicroMsg.OpenGLHookUtils", "mEglSurface == EGL14.EGL_NO_SURFACE");
              jUZ = true;
            }
            else
            {
              localObject2 = mEGLDisplay;
              localObject3 = jUY;
              if (!EGL14.eglMakeCurrent((EGLDisplay)localObject2, (EGLSurface)localObject3, (EGLSurface)localObject3, jUX))
              {
                Log.e("MicroMsg.OpenGLHookUtils", "eglMakeCurrent fail");
                jUZ = true;
              }
              else
              {
                GLES20.glFlush();
              }
            }
          }
        }
      }
    }
    int i = ((MultiProcessMMKV)localObject1).getInt("glGenTextures_index", -1);
    int j = ((MultiProcessMMKV)localObject1).getInt("glDeleteTextures_index", -1);
    int k = ((MultiProcessMMKV)localObject1).getInt("glGenBuffers_index", -1);
    int m = ((MultiProcessMMKV)localObject1).getInt("glDeleteBuffers_index", -1);
    int n = ((MultiProcessMMKV)localObject1).getInt("glGenFramebuffers_index", -1);
    int i1 = ((MultiProcessMMKV)localObject1).getInt("glDeleteFramebuffers_index", -1);
    int i2 = ((MultiProcessMMKV)localObject1).getInt("glGenRenderbuffers_index", -1);
    int i3 = ((MultiProcessMMKV)localObject1).getInt("glDeleteRenderbuffers_index", -1);
    int i4 = ((MultiProcessMMKV)localObject1).getInt("glGetError_index", -1);
    OpenGLHook.getInstance().init();
    OpenGLHook.getInstance().setListener(new com.tencent.mm.gpu.d.a());
    if ((i < 0) || (j < 0))
    {
      Log.e("MicroMsg.OpenGLHookUtils", "opengl hook fail : Textures : %d,%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      c.f(1403L, 6L, 1L);
      c.aEO();
      if ((k >= 0) && (m >= 0)) {
        break label915;
      }
      Log.e("MicroMsg.OpenGLHookUtils", "opengl hook fail : Buffers : %d,%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
      c.f(1403L, 7L, 1L);
      c.aEO();
      label633:
      if ((n >= 0) && (i1 >= 0)) {
        break label998;
      }
      Log.e("MicroMsg.OpenGLHookUtils", "opengl hook fail : Framebuffers : %d,%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
      c.f(1403L, 8L, 1L);
      c.aEO();
      label684:
      if ((i2 >= 0) && (i3 >= 0)) {
        break label1085;
      }
      Log.e("MicroMsg.OpenGLHookUtils", "opengl hook fail : Renderbuffers : %d,%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) });
      c.f(1403L, 9L, 1L);
      c.aEO();
      label735:
      if (i4 >= 0) {
        break label1172;
      }
      Log.e("MicroMsg.OpenGLHookUtils", "opengl hook fail : GetError : %d", new Object[] { Integer.valueOf(i4) });
      c.f(1403L, 10L, 1L);
      c.aEO();
    }
    for (;;)
    {
      MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single");
      EGL14.eglDestroySurface(mEGLDisplay, jUY);
      EGL14.eglDestroyContext(mEGLDisplay, jUX);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(mEGLDisplay);
      mEGLDisplay = null;
      jUW = null;
      jUX = null;
      jUY = null;
      AppMethodBeat.o(210857);
      return;
      OpenGLHook.getInstance().hook("glGenTextures", i);
      OpenGLHook.getInstance().hook("glDeleteTextures", j);
      localObject1 = new int[1];
      GLES20.glGenTextures(1, (int[])localObject1, 0);
      GLES20.glDeleteTextures(1, (int[])localObject1, 0);
      Log.i("MicroMsg.OpenGLHookUtils", "opengl hook succ : Textures : %d,%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      c.f(1403L, 13L, 1L);
      c.aEN();
      break;
      label915:
      OpenGLHook.getInstance().hook("glGenBuffers", k);
      OpenGLHook.getInstance().hook("glDeleteBuffers", m);
      localObject1 = new int[1];
      GLES20.glGenBuffers(1, (int[])localObject1, 0);
      GLES20.glDeleteBuffers(1, (int[])localObject1, 0);
      Log.i("MicroMsg.OpenGLHookUtils", "opengl hook succ : Buffers : %d,%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
      c.f(1403L, 14L, 1L);
      c.aEN();
      break label633;
      label998:
      OpenGLHook.getInstance().hook("glGenFramebuffers", n);
      OpenGLHook.getInstance().hook("glDeleteFramebuffers", i1);
      localObject1 = new int[1];
      GLES20.glGenFramebuffers(1, (int[])localObject1, 0);
      GLES20.glDeleteFramebuffers(1, (int[])localObject1, 0);
      Log.i("MicroMsg.OpenGLHookUtils", "opengl hook succ : Framebuffers : %d,%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
      c.f(1403L, 15L, 1L);
      c.aEN();
      break label684;
      label1085:
      OpenGLHook.getInstance().hook("glGenRenderbuffers", i2);
      OpenGLHook.getInstance().hook("glDeleteRenderbuffers", i3);
      localObject1 = new int[1];
      GLES20.glGenRenderbuffers(1, (int[])localObject1, 0);
      GLES20.glDeleteRenderbuffers(1, (int[])localObject1, 0);
      Log.i("MicroMsg.OpenGLHookUtils", "opengl hook succ : Renderbuffers : %d,%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) });
      c.f(1403L, 16L, 1L);
      c.aEN();
      break label735;
      label1172:
      OpenGLHook.getInstance().hook("glGetError", i4);
      GLES20.glGetError();
      Log.i("MicroMsg.OpenGLHookUtils", "opengl hook succ : GetError : %d", new Object[] { Integer.valueOf(i4) });
      c.f(1403L, 17L, 1L);
      c.aEN();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.gpu.c.a
 * JD-Core Version:    0.7.0.1
 */