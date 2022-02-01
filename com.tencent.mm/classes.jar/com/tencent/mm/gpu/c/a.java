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
import com.tencent.matrix.openglleak.hook.OpenGLHook;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class a
{
  private static EGLConfig eYa;
  private static EGLContext eYb;
  private static EGLSurface eYc;
  private static EGLDisplay mEGLDisplay;
  private static boolean mvk = false;
  
  public static void aXN()
  {
    AppMethodBeat.i(231767);
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
      AppMethodBeat.o(231767);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.OpenGLHookUtils", "GpuHookService.enableGpuHook :" + localException.getMessage());
      AppMethodBeat.o(231767);
    }
  }
  
  public static void hook()
  {
    AppMethodBeat.i(231761);
    boolean bool = b.aXT();
    Log.e("MicroMsg.OpenGLHookUtils", "hasUpdate = ".concat(String.valueOf(bool)));
    if (bool)
    {
      aXN();
      Log.e("MicroMsg.OpenGLHookUtils", "undo opengl this time because system gpu so change");
      AppMethodBeat.o(231761);
      return;
    }
    Object localObject1 = MultiProcessMMKV.getMMKV("mmkv_gpu_service_key_muti");
    Object localObject2 = EGL14.eglGetDisplay(0);
    mEGLDisplay = (EGLDisplay)localObject2;
    if (localObject2 == EGL14.EGL_NO_DISPLAY)
    {
      Log.e("MicroMsg.OpenGLHookUtils", "mEGLDisplay == EGL14.EGL_NO_DISPLAY");
      mvk = true;
    }
    while (mvk)
    {
      AppMethodBeat.o(231761);
      return;
      localObject2 = new int[2];
      if (!EGL14.eglInitialize(mEGLDisplay, (int[])localObject2, 0, (int[])localObject2, 1))
      {
        Log.e("MicroMsg.OpenGLHookUtils", "eglInitialize fail");
        mvk = true;
      }
      else
      {
        localObject2 = new int[1];
        Object localObject3 = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(mEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344 }, 0, (EGLConfig[])localObject3, 0, 1, (int[])localObject2, 0))
        {
          Log.e("MicroMsg.OpenGLHookUtils", "eglChooseConfig fail");
          mvk = true;
        }
        else
        {
          eYa = localObject3[0];
          MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single");
          localObject2 = EGL14.eglCreateContext(mEGLDisplay, eYa, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
          eYb = (EGLContext)localObject2;
          if (localObject2 == EGL14.EGL_NO_CONTEXT)
          {
            Log.e("MicroMsg.OpenGLHookUtils", "EGL14.eglGetError() = ".concat(String.valueOf(EGL14.eglGetError())));
            Log.e("MicroMsg.OpenGLHookUtils", "mEglContext == EGL14.EGL_NO_CONTEXT");
            mvk = true;
          }
          else
          {
            localObject2 = EGL14.eglCreatePbufferSurface(mEGLDisplay, eYa, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
            eYc = (EGLSurface)localObject2;
            if (localObject2 == EGL14.EGL_NO_SURFACE)
            {
              Log.e("MicroMsg.OpenGLHookUtils", "mEglSurface == EGL14.EGL_NO_SURFACE");
              mvk = true;
            }
            else
            {
              localObject2 = mEGLDisplay;
              localObject3 = eYc;
              if (!EGL14.eglMakeCurrent((EGLDisplay)localObject2, (EGLSurface)localObject3, (EGLSurface)localObject3, eYb))
              {
                Log.e("MicroMsg.OpenGLHookUtils", "eglMakeCurrent fail");
                mvk = true;
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
    if ((i < 0) || (j < 0))
    {
      Log.e("MicroMsg.OpenGLHookUtils", "opengl hook fail : Textures : %d,%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.gpu.d.a.hz(6L);
      com.tencent.mm.gpu.d.a.aXP();
      if ((k >= 0) && (m >= 0)) {
        break label878;
      }
      Log.e("MicroMsg.OpenGLHookUtils", "opengl hook fail : Buffers : %d,%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
      com.tencent.mm.gpu.d.a.hz(7L);
      com.tencent.mm.gpu.d.a.aXP();
      label612:
      if ((n >= 0) && (i1 >= 0)) {
        break label957;
      }
      Log.e("MicroMsg.OpenGLHookUtils", "opengl hook fail : Framebuffers : %d,%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
      com.tencent.mm.gpu.d.a.hz(8L);
      com.tencent.mm.gpu.d.a.aXP();
      label659:
      if ((i2 >= 0) && (i3 >= 0)) {
        break label1040;
      }
      Log.e("MicroMsg.OpenGLHookUtils", "opengl hook fail : Renderbuffers : %d,%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) });
      com.tencent.mm.gpu.d.a.hz(9L);
      com.tencent.mm.gpu.d.a.aXP();
      label706:
      if (i4 >= 0) {
        break label1123;
      }
      Log.e("MicroMsg.OpenGLHookUtils", "opengl hook fail : GetError : %d", new Object[] { Integer.valueOf(i4) });
      com.tencent.mm.gpu.d.a.hz(10L);
      com.tencent.mm.gpu.d.a.aXP();
    }
    for (;;)
    {
      MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single");
      EGL14.eglDestroySurface(mEGLDisplay, eYc);
      EGL14.eglDestroyContext(mEGLDisplay, eYb);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(mEGLDisplay);
      mEGLDisplay = null;
      eYa = null;
      eYb = null;
      eYc = null;
      AppMethodBeat.o(231761);
      return;
      OpenGLHook.getInstance().hook("glGenTextures", i);
      OpenGLHook.getInstance().hook("glDeleteTextures", j);
      localObject1 = new int[1];
      GLES20.glGenTextures(1, (int[])localObject1, 0);
      GLES20.glDeleteTextures(1, (int[])localObject1, 0);
      Log.i("MicroMsg.OpenGLHookUtils", "opengl hook succ : Textures : %d,%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.gpu.d.a.hz(13L);
      com.tencent.mm.gpu.d.a.aXO();
      break;
      label878:
      OpenGLHook.getInstance().hook("glGenBuffers", k);
      OpenGLHook.getInstance().hook("glDeleteBuffers", m);
      localObject1 = new int[1];
      GLES20.glGenBuffers(1, (int[])localObject1, 0);
      GLES20.glDeleteBuffers(1, (int[])localObject1, 0);
      Log.i("MicroMsg.OpenGLHookUtils", "opengl hook succ : Buffers : %d,%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
      com.tencent.mm.gpu.d.a.hz(14L);
      com.tencent.mm.gpu.d.a.aXO();
      break label612;
      label957:
      OpenGLHook.getInstance().hook("glGenFramebuffers", n);
      OpenGLHook.getInstance().hook("glDeleteFramebuffers", i1);
      localObject1 = new int[1];
      GLES20.glGenFramebuffers(1, (int[])localObject1, 0);
      GLES20.glDeleteFramebuffers(1, (int[])localObject1, 0);
      Log.i("MicroMsg.OpenGLHookUtils", "opengl hook succ : Framebuffers : %d,%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
      com.tencent.mm.gpu.d.a.hz(15L);
      com.tencent.mm.gpu.d.a.aXO();
      break label659;
      label1040:
      OpenGLHook.getInstance().hook("glGenRenderbuffers", i2);
      OpenGLHook.getInstance().hook("glDeleteRenderbuffers", i3);
      localObject1 = new int[1];
      GLES20.glGenRenderbuffers(1, (int[])localObject1, 0);
      GLES20.glDeleteRenderbuffers(1, (int[])localObject1, 0);
      Log.i("MicroMsg.OpenGLHookUtils", "opengl hook succ : Renderbuffers : %d,%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) });
      com.tencent.mm.gpu.d.a.hz(16L);
      com.tencent.mm.gpu.d.a.aXO();
      break label706;
      label1123:
      OpenGLHook.getInstance().hook("glGetError", i4);
      GLES20.glGetError();
      Log.i("MicroMsg.OpenGLHookUtils", "opengl hook succ : GetError : %d", new Object[] { Integer.valueOf(i4) });
      com.tencent.mm.gpu.d.a.hz(17L);
      com.tencent.mm.gpu.d.a.aXO();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.gpu.c.a
 * JD-Core Version:    0.7.0.1
 */