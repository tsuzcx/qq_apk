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
  private EGL10 fJJ;
  private EGLDisplay fJK = EGL10.EGL_NO_DISPLAY;
  private EGLSurface fJL = EGL10.EGL_NO_SURFACE;
  private EGLContext fJN = EGL10.EGL_NO_CONTEXT;
  private SurfaceTexture gAZ;
  private d iBw;
  volatile boolean iBy;
  
  public c(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    this.gAZ = paramSurfaceTexture;
    this.iBw = paramd;
  }
  
  public final void run()
  {
    AppMethodBeat.i(89215);
    ad.i("MicroMsg.MMSightRecordTextureViewRenderThread", "start render thread");
    this.fJJ = ((EGL10)EGLContext.getEGL());
    this.fJK = this.fJJ.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    int i;
    if (this.fJK == EGL10.EGL_NO_DISPLAY)
    {
      ad.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl get display error: %s", new Object[] { GLUtils.getEGLErrorString(this.fJJ.eglGetError()) });
      i = -1;
    }
    Object localObject3;
    while (i < 0)
    {
      ad.e("MicroMsg.MMSightRecordTextureViewRenderThread", "init gl failed");
      AppMethodBeat.o(89215);
      return;
      ??? = new int[2];
      if (!this.fJJ.eglInitialize(this.fJK, (int[])???))
      {
        ad.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl init error: %s", new Object[] { GLUtils.getEGLErrorString(this.fJJ.eglGetError()) });
        i = -1;
      }
      else
      {
        ??? = new int[1];
        localObject3 = new EGLConfig[1];
        if (!this.fJJ.eglChooseConfig(this.fJK, new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344 }, (EGLConfig[])localObject3, 1, (int[])???))
        {
          ad.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl choose config failed: %s", new Object[] { GLUtils.getEGLErrorString(this.fJJ.eglGetError()) });
          i = -1;
        }
        else
        {
          this.fJN = this.fJJ.eglCreateContext(this.fJK, localObject3[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
          this.fJL = this.fJJ.eglCreateWindowSurface(this.fJK, localObject3[0], this.gAZ, null);
          if ((this.fJL == EGL10.EGL_NO_SURFACE) || (this.fJN == EGL10.EGL_NO_CONTEXT))
          {
            if (this.fJJ.eglGetError() == 12299)
            {
              ad.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
              i = -1;
            }
            else
            {
              ad.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface failed : %s", new Object[] { GLUtils.getEGLErrorString(this.fJJ.eglGetError()) });
              i = -1;
            }
          }
          else
          {
            if (!this.fJJ.eglMakeCurrent(this.fJK, this.fJL, this.fJL, this.fJN)) {
              ad.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglMakeCurrent failed : %s", new Object[] { GLUtils.getEGLErrorString(this.fJJ.eglGetError()) });
            }
            i = 0;
          }
        }
      }
    }
    if (this.iBw != null) {
      localObject3 = this.iBw;
    }
    for (;;)
    {
      synchronized (d.lock)
      {
        ad.i("MicroMsg.MMSightRecordTextureViewRenderer", "init this %s", new Object[] { localObject3 });
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glDisable(2929);
        ((d)localObject3).gvL = b.ap("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
        if (((d)localObject3).gvL == 0) {
          ad.e("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, load program failed!");
        }
        ((d)localObject3).gvM = GLES20.glGetAttribLocation(((d)localObject3).gvL, "a_position");
        ((d)localObject3).gvN = GLES20.glGetAttribLocation(((d)localObject3).gvL, "a_texCoord");
        ((d)localObject3).gvW = GLES20.glGetUniformLocation(((d)localObject3).gvL, "y_texture");
        ((d)localObject3).gvX = GLES20.glGetUniformLocation(((d)localObject3).gvL, "uv_texture");
        ((d)localObject3).iBm = GLES20.glGetUniformLocation(((d)localObject3).gvL, "uMatrix");
        ((d)localObject3).iBk = b.akA();
        ((d)localObject3).iBl = b.akA();
        ((d)localObject3).guT = ByteBuffer.allocateDirect(((d)localObject3).iBp.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ((d)localObject3).guT.put(((d)localObject3).iBp);
        ((d)localObject3).guT.position(0);
        ((d)localObject3).guS = ByteBuffer.allocateDirect(d.gwf.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ((d)localObject3).guS.put(d.gwf);
        ((d)localObject3).guS.position(0);
        ad.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(((d)localObject3).iBk), Integer.valueOf(((d)localObject3).iBl), localObject3 });
        ad.i("MicroMsg.MMSightRecordTextureViewRenderThread", "init renderer finish");
        if (!this.iBy) {
          break;
        }
        if (this.iBw != null) {
          if (this.iBw.iBz) {}
        }
      }
      try
      {
        Thread.sleep(10L);
        localObject3 = this.iBw;
        bt.GC();
        ((d)localObject3).iBh = true;
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GLES20.glClear(16640);
      }
      catch (InterruptedException localInterruptedException)
      {
        synchronized (d.lock)
        {
          if ((((d)localObject3).gvL != -1) && (((d)localObject3).iBk != -1) && (((d)localObject3).iBl != -1) && (((d)localObject3).iBi > 0) && (((d)localObject3).iBj > 0) && (((d)localObject3).gwa != null) && (((d)localObject3).gvZ != null) && (((d)localObject3).gwa.limit() > 0) && (((d)localObject3).gvZ.limit() > 0) && (((d)localObject3).gwa.position() == 0) && (((d)localObject3).gvZ.position() == 0))
          {
            GLES20.glUseProgram(((d)localObject3).gvL);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, ((d)localObject3).iBk);
            GLES20.glTexImage2D(3553, 0, 6409, ((d)localObject3).iBi, ((d)localObject3).iBj, 0, 6409, 5121, ((d)localObject3).gvZ);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(((d)localObject3).gvW, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, ((d)localObject3).iBl);
            GLES20.glTexImage2D(3553, 0, 6410, ((d)localObject3).iBi / 2, ((d)localObject3).iBj / 2, 0, 6410, 5121, ((d)localObject3).gwa);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(((d)localObject3).gvX, 1);
            Matrix.setIdentityM(((d)localObject3).iBn, 0);
            Matrix.setRotateM(((d)localObject3).iBn, 0, ((d)localObject3).dwp, 0.0F, 0.0F, -1.0F);
            GLES20.glUniformMatrix4fv(((d)localObject3).iBm, 1, false, ((d)localObject3).iBn, 0);
            ((d)localObject3).guT.position(0);
            GLES20.glVertexAttribPointer(((d)localObject3).gvM, 2, 5126, false, 0, ((d)localObject3).guT);
            GLES20.glEnableVertexAttribArray(((d)localObject3).gvM);
            ((d)localObject3).guS.position(0);
            GLES20.glVertexAttribPointer(((d)localObject3).gvN, 2, 5126, false, 0, ((d)localObject3).guS);
            GLES20.glEnableVertexAttribArray(((d)localObject3).gvN);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(((d)localObject3).gvM);
            GLES20.glDisableVertexAttribArray(((d)localObject3).gvN);
            GLES20.glBindTexture(3553, 0);
          }
          ((d)localObject3).iBh = false;
          if (this.fJJ != null)
          {
            this.fJJ.eglSwapBuffers(this.fJK, this.fJL);
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
    if (this.iBw != null) {
      locald = this.iBw;
    }
    synchronized (d.lock)
    {
      if (locald.gvL >= 0)
      {
        GLES20.glDeleteProgram(locald.gvL);
        locald.gvL = -1;
      }
      if (locald.iBl >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { locald.iBl }, 0);
        locald.iBl = -1;
      }
      if (locald.iBk >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { locald.iBk }, 0);
        locald.iBk = -1;
      }
      locald.iBj = -1;
      locald.iBi = -1;
      locald.gqu = true;
      locald.gvZ = null;
      locald.gwa = null;
      if ((this.fJJ != null) && (this.fJN != null) && (this.fJL != null))
      {
        this.fJJ.eglDestroyContext(this.fJK, this.fJN);
        this.fJJ.eglDestroySurface(this.fJK, this.fJL);
        this.fJN = EGL10.EGL_NO_CONTEXT;
        this.fJL = EGL10.EGL_NO_SURFACE;
      }
      if (this.gAZ != null) {
        this.gAZ.release();
      }
      ad.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, finish destroy gl");
      AppMethodBeat.o(89215);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.c
 * JD-Core Version:    0.7.0.1
 */