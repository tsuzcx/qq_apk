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
  private EGLDisplay gSA = EGL10.EGL_NO_DISPLAY;
  private EGLSurface gSB = EGL10.EGL_NO_SURFACE;
  private EGLContext gSD = EGL10.EGL_NO_CONTEXT;
  private EGL10 gSz;
  private SurfaceTexture ipT;
  private d kyk;
  volatile boolean kym;
  
  public c(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    this.ipT = paramSurfaceTexture;
    this.kyk = paramd;
  }
  
  public final void run()
  {
    AppMethodBeat.i(89215);
    Log.i("MicroMsg.MMSightRecordTextureViewRenderThread", "start render thread");
    this.gSz = ((EGL10)EGLContext.getEGL());
    this.gSA = this.gSz.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    int i;
    if (this.gSA == EGL10.EGL_NO_DISPLAY)
    {
      Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl get display error: %s", new Object[] { GLUtils.getEGLErrorString(this.gSz.eglGetError()) });
      i = -1;
    }
    Object localObject3;
    while (i < 0)
    {
      Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "init gl failed");
      AppMethodBeat.o(89215);
      return;
      ??? = new int[2];
      if (!this.gSz.eglInitialize(this.gSA, (int[])???))
      {
        Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl init error: %s", new Object[] { GLUtils.getEGLErrorString(this.gSz.eglGetError()) });
        i = -1;
      }
      else
      {
        ??? = new int[1];
        localObject3 = new EGLConfig[1];
        if (!this.gSz.eglChooseConfig(this.gSA, new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344 }, (EGLConfig[])localObject3, 1, (int[])???))
        {
          Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl choose config failed: %s", new Object[] { GLUtils.getEGLErrorString(this.gSz.eglGetError()) });
          i = -1;
        }
        else
        {
          this.gSD = this.gSz.eglCreateContext(this.gSA, localObject3[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
          this.gSB = this.gSz.eglCreateWindowSurface(this.gSA, localObject3[0], this.ipT, null);
          if ((this.gSB == EGL10.EGL_NO_SURFACE) || (this.gSD == EGL10.EGL_NO_CONTEXT))
          {
            if (this.gSz.eglGetError() == 12299)
            {
              Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
              i = -1;
            }
            else
            {
              Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface failed : %s", new Object[] { GLUtils.getEGLErrorString(this.gSz.eglGetError()) });
              i = -1;
            }
          }
          else
          {
            if (!this.gSz.eglMakeCurrent(this.gSA, this.gSB, this.gSB, this.gSD)) {
              Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglMakeCurrent failed : %s", new Object[] { GLUtils.getEGLErrorString(this.gSz.eglGetError()) });
            }
            i = 0;
          }
        }
      }
    }
    if (this.kyk != null) {
      localObject3 = this.kyk;
    }
    for (;;)
    {
      synchronized (d.lock)
      {
        Log.i("MicroMsg.MMSightRecordTextureViewRenderer", "init this %s", new Object[] { localObject3 });
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glDisable(2929);
        ((d)localObject3).programId = b.aB("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
        if (((d)localObject3).programId == 0) {
          Log.e("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, load program failed!");
        }
        ((d)localObject3).hEy = GLES20.glGetAttribLocation(((d)localObject3).programId, "a_position");
        ((d)localObject3).hEz = GLES20.glGetAttribLocation(((d)localObject3).programId, "a_texCoord");
        ((d)localObject3).ikE = GLES20.glGetUniformLocation(((d)localObject3).programId, "y_texture");
        ((d)localObject3).ikO = GLES20.glGetUniformLocation(((d)localObject3).programId, "uv_texture");
        ((d)localObject3).kya = GLES20.glGetUniformLocation(((d)localObject3).programId, "uMatrix");
        ((d)localObject3).kxY = b.aMZ();
        ((d)localObject3).kxZ = b.aMZ();
        ((d)localObject3).hDU = ByteBuffer.allocateDirect(((d)localObject3).kyd.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ((d)localObject3).hDU.put(((d)localObject3).kyd);
        ((d)localObject3).hDU.position(0);
        ((d)localObject3).hDT = ByteBuffer.allocateDirect(d.iln.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ((d)localObject3).hDT.put(d.iln);
        ((d)localObject3).hDT.position(0);
        Log.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(((d)localObject3).kxY), Integer.valueOf(((d)localObject3).kxZ), localObject3 });
        Log.i("MicroMsg.MMSightRecordTextureViewRenderThread", "init renderer finish");
        if (!this.kym) {
          break;
        }
        if (this.kyk != null) {
          if (this.kyk.kyn) {}
        }
      }
      try
      {
        Thread.sleep(10L);
        localObject3 = this.kyk;
        Util.currentTicks();
        ((d)localObject3).kxV = true;
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GLES20.glClear(16640);
      }
      catch (InterruptedException localInterruptedException)
      {
        synchronized (d.lock)
        {
          if ((((d)localObject3).programId != -1) && (((d)localObject3).kxY != -1) && (((d)localObject3).kxZ != -1) && (((d)localObject3).kxW > 0) && (((d)localObject3).kxX > 0) && (((d)localObject3).ikP != null) && (((d)localObject3).ikI != null) && (((d)localObject3).ikP.limit() > 0) && (((d)localObject3).ikI.limit() > 0) && (((d)localObject3).ikP.position() == 0) && (((d)localObject3).ikI.position() == 0))
          {
            GLES20.glUseProgram(((d)localObject3).programId);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, ((d)localObject3).kxY);
            GLES20.glTexImage2D(3553, 0, 6409, ((d)localObject3).kxW, ((d)localObject3).kxX, 0, 6409, 5121, ((d)localObject3).ikI);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(((d)localObject3).ikE, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, ((d)localObject3).kxZ);
            GLES20.glTexImage2D(3553, 0, 6410, ((d)localObject3).kxW / 2, ((d)localObject3).kxX / 2, 0, 6410, 5121, ((d)localObject3).ikP);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(((d)localObject3).ikO, 1);
            Matrix.setIdentityM(((d)localObject3).kyb, 0);
            Matrix.setRotateM(((d)localObject3).kyb, 0, ((d)localObject3).dYT, 0.0F, 0.0F, -1.0F);
            GLES20.glUniformMatrix4fv(((d)localObject3).kya, 1, false, ((d)localObject3).kyb, 0);
            ((d)localObject3).hDU.position(0);
            GLES20.glVertexAttribPointer(((d)localObject3).hEy, 2, 5126, false, 0, ((d)localObject3).hDU);
            GLES20.glEnableVertexAttribArray(((d)localObject3).hEy);
            ((d)localObject3).hDT.position(0);
            GLES20.glVertexAttribPointer(((d)localObject3).hEz, 2, 5126, false, 0, ((d)localObject3).hDT);
            GLES20.glEnableVertexAttribArray(((d)localObject3).hEz);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(((d)localObject3).hEy);
            GLES20.glDisableVertexAttribArray(((d)localObject3).hEz);
            GLES20.glBindTexture(3553, 0);
          }
          ((d)localObject3).kxV = false;
          if (this.gSz != null)
          {
            this.gSz.eglSwapBuffers(this.gSA, this.gSB);
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
    if (this.kyk != null) {
      locald = this.kyk;
    }
    synchronized (d.lock)
    {
      if (locald.programId >= 0)
      {
        GLES20.glDeleteProgram(locald.programId);
        locald.programId = -1;
      }
      if (locald.kxZ >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { locald.kxZ }, 0);
        locald.kxZ = -1;
      }
      if (locald.kxY >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { locald.kxY }, 0);
        locald.kxY = -1;
      }
      locald.kxX = -1;
      locald.kxW = -1;
      locald.ife = true;
      locald.ikI = null;
      locald.ikP = null;
      if ((this.gSz != null) && (this.gSD != null) && (this.gSB != null))
      {
        this.gSz.eglDestroyContext(this.gSA, this.gSD);
        this.gSz.eglDestroySurface(this.gSA, this.gSB);
        this.gSD = EGL10.EGL_NO_CONTEXT;
        this.gSB = EGL10.EGL_NO_SURFACE;
      }
      if (this.ipT != null) {
        this.ipT.release();
      }
      Log.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, finish destroy gl");
      AppMethodBeat.o(89215);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.c
 * JD-Core Version:    0.7.0.1
 */