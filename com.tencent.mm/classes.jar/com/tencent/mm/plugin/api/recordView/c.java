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
  private EGL10 mcJ;
  private EGLDisplay mcK = EGL10.EGL_NO_DISPLAY;
  private EGLSurface mcL = EGL10.EGL_NO_SURFACE;
  private EGLContext mcN = EGL10.EGL_NO_CONTEXT;
  private SurfaceTexture nwH;
  private d qpR;
  volatile boolean qpT;
  
  public c(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    this.nwH = paramSurfaceTexture;
    this.qpR = paramd;
  }
  
  public final void run()
  {
    AppMethodBeat.i(89215);
    Log.i("MicroMsg.MMSightRecordTextureViewRenderThread", "start render thread");
    this.mcJ = ((EGL10)EGLContext.getEGL());
    this.mcK = this.mcJ.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    int i;
    if (this.mcK == EGL10.EGL_NO_DISPLAY)
    {
      Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl get display error: %s", new Object[] { GLUtils.getEGLErrorString(this.mcJ.eglGetError()) });
      i = -1;
    }
    Object localObject3;
    while (i < 0)
    {
      Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "init gl failed");
      AppMethodBeat.o(89215);
      return;
      ??? = new int[2];
      if (!this.mcJ.eglInitialize(this.mcK, (int[])???))
      {
        Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl init error: %s", new Object[] { GLUtils.getEGLErrorString(this.mcJ.eglGetError()) });
        i = -1;
      }
      else
      {
        ??? = new int[1];
        localObject3 = new EGLConfig[1];
        if (!this.mcJ.eglChooseConfig(this.mcK, new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344 }, (EGLConfig[])localObject3, 1, (int[])???))
        {
          Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl choose config failed: %s", new Object[] { GLUtils.getEGLErrorString(this.mcJ.eglGetError()) });
          i = -1;
        }
        else
        {
          this.mcN = this.mcJ.eglCreateContext(this.mcK, localObject3[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
          this.mcL = this.mcJ.eglCreateWindowSurface(this.mcK, localObject3[0], this.nwH, null);
          if ((this.mcL == EGL10.EGL_NO_SURFACE) || (this.mcN == EGL10.EGL_NO_CONTEXT))
          {
            if (this.mcJ.eglGetError() == 12299)
            {
              Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
              i = -1;
            }
            else
            {
              Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface failed : %s", new Object[] { GLUtils.getEGLErrorString(this.mcJ.eglGetError()) });
              i = -1;
            }
          }
          else
          {
            if (!this.mcJ.eglMakeCurrent(this.mcK, this.mcL, this.mcL, this.mcN)) {
              Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglMakeCurrent failed : %s", new Object[] { GLUtils.getEGLErrorString(this.mcJ.eglGetError()) });
            }
            i = 0;
          }
        }
      }
    }
    if (this.qpR != null) {
      localObject3 = this.qpR;
    }
    for (;;)
    {
      synchronized (d.lock)
      {
        Log.i("MicroMsg.MMSightRecordTextureViewRenderer", "init this %s", new Object[] { localObject3 });
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glDisable(2929);
        ((d)localObject3).programId = b.aN("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
        if (((d)localObject3).programId == 0) {
          Log.e("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, load program failed!");
        }
        ((d)localObject3).mWv = GLES20.glGetAttribLocation(((d)localObject3).programId, "a_position");
        ((d)localObject3).mWw = GLES20.glGetAttribLocation(((d)localObject3).programId, "a_texCoord");
        ((d)localObject3).nEF = GLES20.glGetUniformLocation(((d)localObject3).programId, "y_texture");
        ((d)localObject3).nEP = GLES20.glGetUniformLocation(((d)localObject3).programId, "uv_texture");
        ((d)localObject3).qpH = GLES20.glGetUniformLocation(((d)localObject3).programId, "uMatrix");
        ((d)localObject3).qpF = b.bql();
        ((d)localObject3).qpG = b.bql();
        ((d)localObject3).mVV = ByteBuffer.allocateDirect(((d)localObject3).qpK.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ((d)localObject3).mVV.put(((d)localObject3).qpK);
        ((d)localObject3).mVV.position(0);
        ((d)localObject3).mVU = ByteBuffer.allocateDirect(d.nFu.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ((d)localObject3).mVU.put(d.nFu);
        ((d)localObject3).mVU.position(0);
        Log.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(((d)localObject3).qpF), Integer.valueOf(((d)localObject3).qpG), localObject3 });
        Log.i("MicroMsg.MMSightRecordTextureViewRenderThread", "init renderer finish");
        if (!this.qpT) {
          break;
        }
        if (this.qpR != null) {
          if (this.qpR.qpU) {}
        }
      }
      try
      {
        Thread.sleep(10L);
        localObject3 = this.qpR;
        Util.currentTicks();
        ((d)localObject3).qpC = true;
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GLES20.glClear(16640);
      }
      catch (InterruptedException localInterruptedException)
      {
        synchronized (d.lock)
        {
          if ((((d)localObject3).programId != -1) && (((d)localObject3).qpF != -1) && (((d)localObject3).qpG != -1) && (((d)localObject3).qpD > 0) && (((d)localObject3).qpE > 0) && (((d)localObject3).nEQ != null) && (((d)localObject3).nEJ != null) && (((d)localObject3).nEQ.limit() > 0) && (((d)localObject3).nEJ.limit() > 0) && (((d)localObject3).nEQ.position() == 0) && (((d)localObject3).nEJ.position() == 0))
          {
            GLES20.glUseProgram(((d)localObject3).programId);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, ((d)localObject3).qpF);
            GLES20.glTexImage2D(3553, 0, 6409, ((d)localObject3).qpD, ((d)localObject3).qpE, 0, 6409, 5121, ((d)localObject3).nEJ);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(((d)localObject3).nEF, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, ((d)localObject3).qpG);
            GLES20.glTexImage2D(3553, 0, 6410, ((d)localObject3).qpD / 2, ((d)localObject3).qpE / 2, 0, 6410, 5121, ((d)localObject3).nEQ);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(((d)localObject3).nEP, 1);
            Matrix.setIdentityM(((d)localObject3).qpI, 0);
            Matrix.setRotateM(((d)localObject3).qpI, 0, ((d)localObject3).hYK, 0.0F, 0.0F, -1.0F);
            GLES20.glUniformMatrix4fv(((d)localObject3).qpH, 1, false, ((d)localObject3).qpI, 0);
            ((d)localObject3).mVV.position(0);
            GLES20.glVertexAttribPointer(((d)localObject3).mWv, 2, 5126, false, 0, ((d)localObject3).mVV);
            GLES20.glEnableVertexAttribArray(((d)localObject3).mWv);
            ((d)localObject3).mVU.position(0);
            GLES20.glVertexAttribPointer(((d)localObject3).mWw, 2, 5126, false, 0, ((d)localObject3).mVU);
            GLES20.glEnableVertexAttribArray(((d)localObject3).mWw);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(((d)localObject3).mWv);
            GLES20.glDisableVertexAttribArray(((d)localObject3).mWw);
            GLES20.glBindTexture(3553, 0);
          }
          ((d)localObject3).qpC = false;
          if (this.mcJ != null)
          {
            this.mcJ.eglSwapBuffers(this.mcK, this.mcL);
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
    if (this.qpR != null) {
      locald = this.qpR;
    }
    synchronized (d.lock)
    {
      if (locald.programId >= 0)
      {
        GLES20.glDeleteProgram(locald.programId);
        locald.programId = -1;
      }
      if (locald.qpG >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { locald.qpG }, 0);
        locald.qpG = -1;
      }
      if (locald.qpF >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { locald.qpF }, 0);
        locald.qpF = -1;
      }
      locald.qpE = -1;
      locald.qpD = -1;
      locald.nzB = true;
      locald.nEJ = null;
      locald.nEQ = null;
      if ((this.mcJ != null) && (this.mcN != null) && (this.mcL != null))
      {
        this.mcJ.eglDestroyContext(this.mcK, this.mcN);
        this.mcJ.eglDestroySurface(this.mcK, this.mcL);
        this.mcN = EGL10.EGL_NO_CONTEXT;
        this.mcL = EGL10.EGL_NO_SURFACE;
      }
      if (this.nwH != null) {
        this.nwH.release();
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