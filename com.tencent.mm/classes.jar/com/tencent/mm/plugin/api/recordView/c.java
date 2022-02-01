package com.tencent.mm.plugin.api.recordView;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class c
  extends Thread
{
  private EGL10 jCV;
  private EGLDisplay jCW = EGL10.EGL_NO_DISPLAY;
  private EGLSurface jCX = EGL10.EGL_NO_SURFACE;
  private EGLContext jCZ = EGL10.EGL_NO_CONTEXT;
  private SurfaceTexture leZ;
  private d nrk;
  volatile boolean nrm;
  
  public c(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    this.leZ = paramSurfaceTexture;
    this.nrk = paramd;
  }
  
  public final void run()
  {
    AppMethodBeat.i(89215);
    Log.i("MicroMsg.MMSightRecordTextureViewRenderThread", "start render thread");
    this.jCV = ((EGL10)EGLContext.getEGL());
    this.jCW = this.jCV.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    int i;
    if (this.jCW == EGL10.EGL_NO_DISPLAY)
    {
      Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl get display error: %s", new Object[] { GLUtils.getEGLErrorString(this.jCV.eglGetError()) });
      i = -1;
    }
    Object localObject3;
    while (i < 0)
    {
      Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "init gl failed");
      AppMethodBeat.o(89215);
      return;
      ??? = new int[2];
      if (!this.jCV.eglInitialize(this.jCW, (int[])???))
      {
        Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl init error: %s", new Object[] { GLUtils.getEGLErrorString(this.jCV.eglGetError()) });
        i = -1;
      }
      else
      {
        ??? = new int[1];
        localObject3 = new EGLConfig[1];
        if (!this.jCV.eglChooseConfig(this.jCW, new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344 }, (EGLConfig[])localObject3, 1, (int[])???))
        {
          Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl choose config failed: %s", new Object[] { GLUtils.getEGLErrorString(this.jCV.eglGetError()) });
          i = -1;
        }
        else
        {
          this.jCZ = this.jCV.eglCreateContext(this.jCW, localObject3[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
          this.jCX = this.jCV.eglCreateWindowSurface(this.jCW, localObject3[0], this.leZ, null);
          if ((this.jCX == EGL10.EGL_NO_SURFACE) || (this.jCZ == EGL10.EGL_NO_CONTEXT))
          {
            if (this.jCV.eglGetError() == 12299)
            {
              Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
              i = -1;
            }
            else
            {
              Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface failed : %s", new Object[] { GLUtils.getEGLErrorString(this.jCV.eglGetError()) });
              i = -1;
            }
          }
          else
          {
            if (!this.jCV.eglMakeCurrent(this.jCW, this.jCX, this.jCX, this.jCZ)) {
              Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglMakeCurrent failed : %s", new Object[] { GLUtils.getEGLErrorString(this.jCV.eglGetError()) });
            }
            i = 0;
          }
        }
      }
    }
    if (this.nrk != null) {
      localObject3 = this.nrk;
    }
    for (;;)
    {
      synchronized (d.lock)
      {
        Log.i("MicroMsg.MMSightRecordTextureViewRenderer", "init this %s", new Object[] { localObject3 });
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glDisable(2929);
        ((d)localObject3).programId = b.aE("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
        if (((d)localObject3).programId == 0) {
          Log.e("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, load program failed!");
        }
        ((d)localObject3).ksD = GLES20.glGetAttribLocation(((d)localObject3).programId, "a_position");
        ((d)localObject3).ksE = GLES20.glGetAttribLocation(((d)localObject3).programId, "a_texCoord");
        ((d)localObject3).kZy = GLES20.glGetUniformLocation(((d)localObject3).programId, "y_texture");
        ((d)localObject3).kZI = GLES20.glGetUniformLocation(((d)localObject3).programId, "uv_texture");
        ((d)localObject3).nra = GLES20.glGetUniformLocation(((d)localObject3).programId, "uMatrix");
        ((d)localObject3).nqY = b.aVC();
        ((d)localObject3).nqZ = b.aVC();
        ((d)localObject3).ksb = ByteBuffer.allocateDirect(((d)localObject3).nrd.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ((d)localObject3).ksb.put(((d)localObject3).nrd);
        ((d)localObject3).ksb.position(0);
        ((d)localObject3).ksa = ByteBuffer.allocateDirect(d.lak.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ((d)localObject3).ksa.put(d.lak);
        ((d)localObject3).ksa.position(0);
        Log.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(((d)localObject3).nqY), Integer.valueOf(((d)localObject3).nqZ), localObject3 });
        Log.i("MicroMsg.MMSightRecordTextureViewRenderThread", "init renderer finish");
        if (!this.nrm) {
          break;
        }
        if (this.nrk != null) {
          if (this.nrk.nrn) {}
        }
      }
      try
      {
        Thread.sleep(10L);
        localObject3 = this.nrk;
        Util.currentTicks();
        ((d)localObject3).nqV = true;
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GLES20.glClear(16640);
      }
      catch (InterruptedException localInterruptedException)
      {
        synchronized (d.lock)
        {
          if ((((d)localObject3).programId != -1) && (((d)localObject3).nqY != -1) && (((d)localObject3).nqZ != -1) && (((d)localObject3).nqW > 0) && (((d)localObject3).nqX > 0) && (((d)localObject3).kZJ != null) && (((d)localObject3).kZC != null) && (((d)localObject3).kZJ.limit() > 0) && (((d)localObject3).kZC.limit() > 0) && (((d)localObject3).kZJ.position() == 0) && (((d)localObject3).kZC.position() == 0))
          {
            GLES20.glUseProgram(((d)localObject3).programId);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, ((d)localObject3).nqY);
            GLES20.glTexImage2D(3553, 0, 6409, ((d)localObject3).nqW, ((d)localObject3).nqX, 0, 6409, 5121, ((d)localObject3).kZC);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(((d)localObject3).kZy, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, ((d)localObject3).nqZ);
            GLES20.glTexImage2D(3553, 0, 6410, ((d)localObject3).nqW / 2, ((d)localObject3).nqX / 2, 0, 6410, 5121, ((d)localObject3).kZJ);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(((d)localObject3).kZI, 1);
            Matrix.setIdentityM(((d)localObject3).nrb, 0);
            Matrix.setRotateM(((d)localObject3).nrb, 0, ((d)localObject3).fSM, 0.0F, 0.0F, -1.0F);
            GLES20.glUniformMatrix4fv(((d)localObject3).nra, 1, false, ((d)localObject3).nrb, 0);
            ((d)localObject3).ksb.position(0);
            GLES20.glVertexAttribPointer(((d)localObject3).ksD, 2, 5126, false, 0, ((d)localObject3).ksb);
            GLES20.glEnableVertexAttribArray(((d)localObject3).ksD);
            ((d)localObject3).ksa.position(0);
            GLES20.glVertexAttribPointer(((d)localObject3).ksE, 2, 5126, false, 0, ((d)localObject3).ksa);
            GLES20.glEnableVertexAttribArray(((d)localObject3).ksE);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(((d)localObject3).ksD);
            GLES20.glDisableVertexAttribArray(((d)localObject3).ksE);
            GLES20.glBindTexture(3553, 0);
          }
          ((d)localObject3).nqV = false;
          if (this.jCV != null)
          {
            this.jCV.eglSwapBuffers(this.jCW, this.jCX);
            continue;
            localObject4 = finally;
            AppMethodBeat.o(89215);
            throw localObject4;
            localInterruptedException = localInterruptedException;
            Log.printErrStackTrace("MicroMsg.MMSightRecordTextureViewRenderThread", localInterruptedException, "", new Object[0]);
          }
        }
      }
    }
    Log.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, start destroy gl");
    d locald;
    if (this.nrk != null) {
      locald = this.nrk;
    }
    synchronized (d.lock)
    {
      if (locald.programId >= 0)
      {
        GLES20.glDeleteProgram(locald.programId);
        locald.programId = -1;
      }
      if (locald.nqZ >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { locald.nqZ }, 0);
        locald.nqZ = -1;
      }
      if (locald.nqY >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { locald.nqY }, 0);
        locald.nqY = -1;
      }
      locald.nqX = -1;
      locald.nqW = -1;
      locald.kTS = true;
      locald.kZC = null;
      locald.kZJ = null;
      if ((this.jCV != null) && (this.jCZ != null) && (this.jCX != null))
      {
        this.jCV.eglDestroyContext(this.jCW, this.jCZ);
        this.jCV.eglDestroySurface(this.jCW, this.jCX);
        this.jCZ = EGL10.EGL_NO_CONTEXT;
        this.jCX = EGL10.EGL_NO_SURFACE;
      }
      if (this.leZ != null) {
        this.leZ.release();
      }
      Log.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, finish destroy gl");
      AppMethodBeat.o(89215);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.c
 * JD-Core Version:    0.7.0.1
 */