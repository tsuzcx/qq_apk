package com.tencent.mm.plugin.api.recordView;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private EGL10 ggP;
  private EGLDisplay ggQ = EGL10.EGL_NO_DISPLAY;
  private EGLSurface ggR = EGL10.EGL_NO_SURFACE;
  private EGLContext ggT = EGL10.EGL_NO_CONTEXT;
  private SurfaceTexture htD;
  private d juG;
  volatile boolean juI;
  
  public c(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    this.htD = paramSurfaceTexture;
    this.juG = paramd;
  }
  
  public final void run()
  {
    AppMethodBeat.i(89215);
    ad.i("MicroMsg.MMSightRecordTextureViewRenderThread", "start render thread");
    this.ggP = ((EGL10)EGLContext.getEGL());
    this.ggQ = this.ggP.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    int i;
    if (this.ggQ == EGL10.EGL_NO_DISPLAY)
    {
      ad.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl get display error: %s", new Object[] { GLUtils.getEGLErrorString(this.ggP.eglGetError()) });
      i = -1;
    }
    Object localObject3;
    while (i < 0)
    {
      ad.e("MicroMsg.MMSightRecordTextureViewRenderThread", "init gl failed");
      AppMethodBeat.o(89215);
      return;
      ??? = new int[2];
      if (!this.ggP.eglInitialize(this.ggQ, (int[])???))
      {
        ad.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl init error: %s", new Object[] { GLUtils.getEGLErrorString(this.ggP.eglGetError()) });
        i = -1;
      }
      else
      {
        ??? = new int[1];
        localObject3 = new EGLConfig[1];
        if (!this.ggP.eglChooseConfig(this.ggQ, new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344 }, (EGLConfig[])localObject3, 1, (int[])???))
        {
          ad.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl choose config failed: %s", new Object[] { GLUtils.getEGLErrorString(this.ggP.eglGetError()) });
          i = -1;
        }
        else
        {
          this.ggT = this.ggP.eglCreateContext(this.ggQ, localObject3[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
          this.ggR = this.ggP.eglCreateWindowSurface(this.ggQ, localObject3[0], this.htD, null);
          if ((this.ggR == EGL10.EGL_NO_SURFACE) || (this.ggT == EGL10.EGL_NO_CONTEXT))
          {
            if (this.ggP.eglGetError() == 12299)
            {
              ad.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
              i = -1;
            }
            else
            {
              ad.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface failed : %s", new Object[] { GLUtils.getEGLErrorString(this.ggP.eglGetError()) });
              i = -1;
            }
          }
          else
          {
            if (!this.ggP.eglMakeCurrent(this.ggQ, this.ggR, this.ggR, this.ggT)) {
              ad.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglMakeCurrent failed : %s", new Object[] { GLUtils.getEGLErrorString(this.ggP.eglGetError()) });
            }
            i = 0;
          }
        }
      }
    }
    if (this.juG != null) {
      localObject3 = this.juG;
    }
    for (;;)
    {
      synchronized (d.lock)
      {
        ad.i("MicroMsg.MMSightRecordTextureViewRenderer", "init this %s", new Object[] { localObject3 });
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glDisable(2929);
        ((d)localObject3).gLM = b.ay("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
        if (((d)localObject3).gLM == 0) {
          ad.e("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, load program failed!");
        }
        ((d)localObject3).gLN = GLES20.glGetAttribLocation(((d)localObject3).gLM, "a_position");
        ((d)localObject3).gLO = GLES20.glGetAttribLocation(((d)localObject3).gLM, "a_texCoord");
        ((d)localObject3).hou = GLES20.glGetUniformLocation(((d)localObject3).gLM, "y_texture");
        ((d)localObject3).hoE = GLES20.glGetUniformLocation(((d)localObject3).gLM, "uv_texture");
        ((d)localObject3).juw = GLES20.glGetUniformLocation(((d)localObject3).gLM, "uMatrix");
        ((d)localObject3).juu = b.auh();
        ((d)localObject3).juv = b.auh();
        ((d)localObject3).gLm = ByteBuffer.allocateDirect(((d)localObject3).juz.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ((d)localObject3).gLm.put(((d)localObject3).juz);
        ((d)localObject3).gLm.position(0);
        ((d)localObject3).gLl = ByteBuffer.allocateDirect(d.hoJ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ((d)localObject3).gLl.put(d.hoJ);
        ((d)localObject3).gLl.position(0);
        ad.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(((d)localObject3).juu), Integer.valueOf(((d)localObject3).juv), localObject3 });
        ad.i("MicroMsg.MMSightRecordTextureViewRenderThread", "init renderer finish");
        if (!this.juI) {
          break;
        }
        if (this.juG != null) {
          if (this.juG.juJ) {}
        }
      }
      try
      {
        Thread.sleep(10L);
        localObject3 = this.juG;
        bt.HI();
        ((d)localObject3).jur = true;
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GLES20.glClear(16640);
      }
      catch (InterruptedException localInterruptedException)
      {
        synchronized (d.lock)
        {
          if ((((d)localObject3).gLM != -1) && (((d)localObject3).juu != -1) && (((d)localObject3).juv != -1) && (((d)localObject3).jus > 0) && (((d)localObject3).jut > 0) && (((d)localObject3).hoF != null) && (((d)localObject3).hoy != null) && (((d)localObject3).hoF.limit() > 0) && (((d)localObject3).hoy.limit() > 0) && (((d)localObject3).hoF.position() == 0) && (((d)localObject3).hoy.position() == 0))
          {
            GLES20.glUseProgram(((d)localObject3).gLM);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, ((d)localObject3).juu);
            GLES20.glTexImage2D(3553, 0, 6409, ((d)localObject3).jus, ((d)localObject3).jut, 0, 6409, 5121, ((d)localObject3).hoy);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(((d)localObject3).hou, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, ((d)localObject3).juv);
            GLES20.glTexImage2D(3553, 0, 6410, ((d)localObject3).jus / 2, ((d)localObject3).jut / 2, 0, 6410, 5121, ((d)localObject3).hoF);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(((d)localObject3).hoE, 1);
            Matrix.setIdentityM(((d)localObject3).jux, 0);
            Matrix.setRotateM(((d)localObject3).jux, 0, ((d)localObject3).dGc, 0.0F, 0.0F, -1.0F);
            GLES20.glUniformMatrix4fv(((d)localObject3).juw, 1, false, ((d)localObject3).jux, 0);
            ((d)localObject3).gLm.position(0);
            GLES20.glVertexAttribPointer(((d)localObject3).gLN, 2, 5126, false, 0, ((d)localObject3).gLm);
            GLES20.glEnableVertexAttribArray(((d)localObject3).gLN);
            ((d)localObject3).gLl.position(0);
            GLES20.glVertexAttribPointer(((d)localObject3).gLO, 2, 5126, false, 0, ((d)localObject3).gLl);
            GLES20.glEnableVertexAttribArray(((d)localObject3).gLO);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(((d)localObject3).gLN);
            GLES20.glDisableVertexAttribArray(((d)localObject3).gLO);
            GLES20.glBindTexture(3553, 0);
          }
          ((d)localObject3).jur = false;
          if (this.ggP != null)
          {
            this.ggP.eglSwapBuffers(this.ggQ, this.ggR);
            continue;
            localObject4 = finally;
            AppMethodBeat.o(89215);
            throw localObject4;
            localInterruptedException = localInterruptedException;
            ad.printErrStackTrace("MicroMsg.MMSightRecordTextureViewRenderThread", localInterruptedException, "", new Object[0]);
          }
        }
      }
    }
    ad.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, start destroy gl");
    d locald;
    if (this.juG != null) {
      locald = this.juG;
    }
    synchronized (d.lock)
    {
      if (locald.gLM >= 0)
      {
        GLES20.glDeleteProgram(locald.gLM);
        locald.gLM = -1;
      }
      if (locald.juv >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { locald.juv }, 0);
        locald.juv = -1;
      }
      if (locald.juu >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { locald.juu }, 0);
        locald.juu = -1;
      }
      locald.jut = -1;
      locald.jus = -1;
      locald.hju = true;
      locald.hoy = null;
      locald.hoF = null;
      if ((this.ggP != null) && (this.ggT != null) && (this.ggR != null))
      {
        this.ggP.eglDestroyContext(this.ggQ, this.ggT);
        this.ggP.eglDestroySurface(this.ggQ, this.ggR);
        this.ggT = EGL10.EGL_NO_CONTEXT;
        this.ggR = EGL10.EGL_NO_SURFACE;
      }
      if (this.htD != null) {
        this.htD.release();
      }
      ad.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, finish destroy gl");
      AppMethodBeat.o(89215);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.c
 * JD-Core Version:    0.7.0.1
 */