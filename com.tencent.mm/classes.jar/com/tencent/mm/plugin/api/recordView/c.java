package com.tencent.mm.plugin.api.recordView;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private EGL10 fNp;
  private EGLDisplay fNq = EGL10.EGL_NO_DISPLAY;
  private EGLSurface fNr = EGL10.EGL_NO_SURFACE;
  private EGLContext fNt = EGL10.EGL_NO_CONTEXT;
  private SurfaceTexture hbv;
  private d jbx;
  volatile boolean jbz;
  
  public c(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    this.hbv = paramSurfaceTexture;
    this.jbx = paramd;
  }
  
  public final void run()
  {
    AppMethodBeat.i(89215);
    ac.i("MicroMsg.MMSightRecordTextureViewRenderThread", "start render thread");
    this.fNp = ((EGL10)EGLContext.getEGL());
    this.fNq = this.fNp.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    int i;
    if (this.fNq == EGL10.EGL_NO_DISPLAY)
    {
      ac.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl get display error: %s", new Object[] { GLUtils.getEGLErrorString(this.fNp.eglGetError()) });
      i = -1;
    }
    Object localObject3;
    while (i < 0)
    {
      ac.e("MicroMsg.MMSightRecordTextureViewRenderThread", "init gl failed");
      AppMethodBeat.o(89215);
      return;
      ??? = new int[2];
      if (!this.fNp.eglInitialize(this.fNq, (int[])???))
      {
        ac.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl init error: %s", new Object[] { GLUtils.getEGLErrorString(this.fNp.eglGetError()) });
        i = -1;
      }
      else
      {
        ??? = new int[1];
        localObject3 = new EGLConfig[1];
        if (!this.fNp.eglChooseConfig(this.fNq, new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344 }, (EGLConfig[])localObject3, 1, (int[])???))
        {
          ac.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl choose config failed: %s", new Object[] { GLUtils.getEGLErrorString(this.fNp.eglGetError()) });
          i = -1;
        }
        else
        {
          this.fNt = this.fNp.eglCreateContext(this.fNq, localObject3[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
          this.fNr = this.fNp.eglCreateWindowSurface(this.fNq, localObject3[0], this.hbv, null);
          if ((this.fNr == EGL10.EGL_NO_SURFACE) || (this.fNt == EGL10.EGL_NO_CONTEXT))
          {
            if (this.fNp.eglGetError() == 12299)
            {
              ac.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
              i = -1;
            }
            else
            {
              ac.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface failed : %s", new Object[] { GLUtils.getEGLErrorString(this.fNp.eglGetError()) });
              i = -1;
            }
          }
          else
          {
            if (!this.fNp.eglMakeCurrent(this.fNq, this.fNr, this.fNr, this.fNt)) {
              ac.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglMakeCurrent failed : %s", new Object[] { GLUtils.getEGLErrorString(this.fNp.eglGetError()) });
            }
            i = 0;
          }
        }
      }
    }
    if (this.jbx != null) {
      localObject3 = this.jbx;
    }
    for (;;)
    {
      synchronized (d.lock)
      {
        ac.i("MicroMsg.MMSightRecordTextureViewRenderer", "init this %s", new Object[] { localObject3 });
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glDisable(2929);
        ((d)localObject3).gse = b.ax("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
        if (((d)localObject3).gse == 0) {
          ac.e("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, load program failed!");
        }
        ((d)localObject3).gsf = GLES20.glGetAttribLocation(((d)localObject3).gse, "a_position");
        ((d)localObject3).gsg = GLES20.glGetAttribLocation(((d)localObject3).gse, "a_texCoord");
        ((d)localObject3).gWo = GLES20.glGetUniformLocation(((d)localObject3).gse, "y_texture");
        ((d)localObject3).gWy = GLES20.glGetUniformLocation(((d)localObject3).gse, "uv_texture");
        ((d)localObject3).jbn = GLES20.glGetUniformLocation(((d)localObject3).gse, "uMatrix");
        ((d)localObject3).jbl = b.aru();
        ((d)localObject3).jbm = b.aru();
        ((d)localObject3).grE = ByteBuffer.allocateDirect(((d)localObject3).jbq.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ((d)localObject3).grE.put(((d)localObject3).jbq);
        ((d)localObject3).grE.position(0);
        ((d)localObject3).grD = ByteBuffer.allocateDirect(d.gWD.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ((d)localObject3).grD.put(d.gWD);
        ((d)localObject3).grD.position(0);
        ac.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(((d)localObject3).jbl), Integer.valueOf(((d)localObject3).jbm), localObject3 });
        ac.i("MicroMsg.MMSightRecordTextureViewRenderThread", "init renderer finish");
        if (!this.jbz) {
          break;
        }
        if (this.jbx != null) {
          if (this.jbx.jbA) {}
        }
      }
      try
      {
        Thread.sleep(10L);
        localObject3 = this.jbx;
        bs.Gn();
        ((d)localObject3).jbi = true;
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GLES20.glClear(16640);
      }
      catch (InterruptedException localInterruptedException)
      {
        synchronized (d.lock)
        {
          if ((((d)localObject3).gse != -1) && (((d)localObject3).jbl != -1) && (((d)localObject3).jbm != -1) && (((d)localObject3).jbj > 0) && (((d)localObject3).jbk > 0) && (((d)localObject3).gWz != null) && (((d)localObject3).gWs != null) && (((d)localObject3).gWz.limit() > 0) && (((d)localObject3).gWs.limit() > 0) && (((d)localObject3).gWz.position() == 0) && (((d)localObject3).gWs.position() == 0))
          {
            GLES20.glUseProgram(((d)localObject3).gse);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, ((d)localObject3).jbl);
            GLES20.glTexImage2D(3553, 0, 6409, ((d)localObject3).jbj, ((d)localObject3).jbk, 0, 6409, 5121, ((d)localObject3).gWs);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(((d)localObject3).gWo, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, ((d)localObject3).jbm);
            GLES20.glTexImage2D(3553, 0, 6410, ((d)localObject3).jbj / 2, ((d)localObject3).jbk / 2, 0, 6410, 5121, ((d)localObject3).gWz);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(((d)localObject3).gWy, 1);
            Matrix.setIdentityM(((d)localObject3).jbo, 0);
            Matrix.setRotateM(((d)localObject3).jbo, 0, ((d)localObject3).duc, 0.0F, 0.0F, -1.0F);
            GLES20.glUniformMatrix4fv(((d)localObject3).jbn, 1, false, ((d)localObject3).jbo, 0);
            ((d)localObject3).grE.position(0);
            GLES20.glVertexAttribPointer(((d)localObject3).gsf, 2, 5126, false, 0, ((d)localObject3).grE);
            GLES20.glEnableVertexAttribArray(((d)localObject3).gsf);
            ((d)localObject3).grD.position(0);
            GLES20.glVertexAttribPointer(((d)localObject3).gsg, 2, 5126, false, 0, ((d)localObject3).grD);
            GLES20.glEnableVertexAttribArray(((d)localObject3).gsg);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(((d)localObject3).gsf);
            GLES20.glDisableVertexAttribArray(((d)localObject3).gsg);
            GLES20.glBindTexture(3553, 0);
          }
          ((d)localObject3).jbi = false;
          if (this.fNp != null)
          {
            this.fNp.eglSwapBuffers(this.fNq, this.fNr);
            continue;
            localObject4 = finally;
            AppMethodBeat.o(89215);
            throw localObject4;
            localInterruptedException = localInterruptedException;
            ac.printErrStackTrace("MicroMsg.MMSightRecordTextureViewRenderThread", localInterruptedException, "", new Object[0]);
          }
        }
      }
    }
    ac.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, start destroy gl");
    d locald;
    if (this.jbx != null) {
      locald = this.jbx;
    }
    synchronized (d.lock)
    {
      if (locald.gse >= 0)
      {
        GLES20.glDeleteProgram(locald.gse);
        locald.gse = -1;
      }
      if (locald.jbm >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { locald.jbm }, 0);
        locald.jbm = -1;
      }
      if (locald.jbl >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { locald.jbl }, 0);
        locald.jbl = -1;
      }
      locald.jbk = -1;
      locald.jbj = -1;
      locald.gRc = true;
      locald.gWs = null;
      locald.gWz = null;
      if ((this.fNp != null) && (this.fNt != null) && (this.fNr != null))
      {
        this.fNp.eglDestroyContext(this.fNq, this.fNt);
        this.fNp.eglDestroySurface(this.fNq, this.fNr);
        this.fNt = EGL10.EGL_NO_CONTEXT;
        this.fNr = EGL10.EGL_NO_SURFACE;
      }
      if (this.hbv != null) {
        this.hbv.release();
      }
      ac.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, finish destroy gl");
      AppMethodBeat.o(89215);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.c
 * JD-Core Version:    0.7.0.1
 */