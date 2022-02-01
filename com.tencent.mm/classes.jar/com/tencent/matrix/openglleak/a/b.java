package com.tencent.matrix.openglleak.a;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;

public final class b
{
  public static EGLConfig eYa;
  private static EGLContext eYb;
  private static EGLSurface eYc;
  public static EGLDisplay mEGLDisplay;
  
  public static void ayT()
  {
    Object localObject1 = EGL14.eglGetDisplay(0);
    mEGLDisplay = (EGLDisplay)localObject1;
    if (localObject1 == EGL14.EGL_NO_DISPLAY) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localObject1 = new int[2];
            } while (!EGL14.eglInitialize(mEGLDisplay, (int[])localObject1, 0, (int[])localObject1, 1));
            localObject1 = new int[1];
            localObject2 = new EGLConfig[1];
          } while (!EGL14.eglChooseConfig(mEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344 }, 0, (EGLConfig[])localObject2, 0, 1, (int[])localObject1, 0));
          eYa = localObject2[0];
          localObject1 = EGL14.eglCreateContext(mEGLDisplay, eYa, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
          eYb = (EGLContext)localObject1;
        } while (localObject1 == EGL14.EGL_NO_CONTEXT);
        localObject1 = EGL14.eglCreatePbufferSurface(mEGLDisplay, eYa, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
        eYc = (EGLSurface)localObject1;
      } while (localObject1 == EGL14.EGL_NO_SURFACE);
      localObject1 = mEGLDisplay;
      localObject2 = eYc;
    } while (!EGL14.eglMakeCurrent((EGLDisplay)localObject1, (EGLSurface)localObject2, (EGLSurface)localObject2, eYb));
    GLES20.glFlush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.matrix.openglleak.a.b
 * JD-Core Version:    0.7.0.1
 */