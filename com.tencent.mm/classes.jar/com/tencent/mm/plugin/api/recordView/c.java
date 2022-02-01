package com.tencent.mm.plugin.api.recordView;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private EGL10 gjh;
  private EGLDisplay gji = EGL10.EGL_NO_DISPLAY;
  private EGLSurface gjj = EGL10.EGL_NO_SURFACE;
  private EGLContext gjl = EGL10.EGL_NO_CONTEXT;
  private SurfaceTexture hwr;
  private d jxB;
  volatile boolean jxD;
  
  public c(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    this.hwr = paramSurfaceTexture;
    this.jxB = paramd;
  }
  
  public final void run()
  {
    AppMethodBeat.i(89215);
    ae.i("MicroMsg.MMSightRecordTextureViewRenderThread", "start render thread");
    this.gjh = ((EGL10)EGLContext.getEGL());
    this.gji = this.gjh.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    int i;
    if (this.gji == EGL10.EGL_NO_DISPLAY)
    {
      ae.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl get display error: %s", new Object[] { GLUtils.getEGLErrorString(this.gjh.eglGetError()) });
      i = -1;
    }
    Object localObject3;
    while (i < 0)
    {
      ae.e("MicroMsg.MMSightRecordTextureViewRenderThread", "init gl failed");
      AppMethodBeat.o(89215);
      return;
      ??? = new int[2];
      if (!this.gjh.eglInitialize(this.gji, (int[])???))
      {
        ae.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl init error: %s", new Object[] { GLUtils.getEGLErrorString(this.gjh.eglGetError()) });
        i = -1;
      }
      else
      {
        ??? = new int[1];
        localObject3 = new EGLConfig[1];
        if (!this.gjh.eglChooseConfig(this.gji, new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344 }, (EGLConfig[])localObject3, 1, (int[])???))
        {
          ae.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl choose config failed: %s", new Object[] { GLUtils.getEGLErrorString(this.gjh.eglGetError()) });
          i = -1;
        }
        else
        {
          this.gjl = this.gjh.eglCreateContext(this.gji, localObject3[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
          this.gjj = this.gjh.eglCreateWindowSurface(this.gji, localObject3[0], this.hwr, null);
          if ((this.gjj == EGL10.EGL_NO_SURFACE) || (this.gjl == EGL10.EGL_NO_CONTEXT))
          {
            if (this.gjh.eglGetError() == 12299)
            {
              ae.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
              i = -1;
            }
            else
            {
              ae.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface failed : %s", new Object[] { GLUtils.getEGLErrorString(this.gjh.eglGetError()) });
              i = -1;
            }
          }
          else
          {
            if (!this.gjh.eglMakeCurrent(this.gji, this.gjj, this.gjj, this.gjl)) {
              ae.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglMakeCurrent failed : %s", new Object[] { GLUtils.getEGLErrorString(this.gjh.eglGetError()) });
            }
            i = 0;
          }
        }
      }
    }
    if (this.jxB != null) {
      localObject3 = this.jxB;
    }
    for (;;)
    {
      synchronized (d.lock)
      {
        ae.i("MicroMsg.MMSightRecordTextureViewRenderer", "init this %s", new Object[] { localObject3 });
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glDisable(2929);
        ((d)localObject3).gOv = b.az("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
        if (((d)localObject3).gOv == 0) {
          ae.e("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, load program failed!");
        }
        ((d)localObject3).gOw = GLES20.glGetAttribLocation(((d)localObject3).gOv, "a_position");
        ((d)localObject3).gOx = GLES20.glGetAttribLocation(((d)localObject3).gOv, "a_texCoord");
        ((d)localObject3).hri = GLES20.glGetUniformLocation(((d)localObject3).gOv, "y_texture");
        ((d)localObject3).hrs = GLES20.glGetUniformLocation(((d)localObject3).gOv, "uv_texture");
        ((d)localObject3).jxr = GLES20.glGetUniformLocation(((d)localObject3).gOv, "uMatrix");
        ((d)localObject3).jxp = b.auw();
        ((d)localObject3).jxq = b.auw();
        ((d)localObject3).gNV = ByteBuffer.allocateDirect(((d)localObject3).jxu.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ((d)localObject3).gNV.put(((d)localObject3).jxu);
        ((d)localObject3).gNV.position(0);
        ((d)localObject3).gNU = ByteBuffer.allocateDirect(d.hrx.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ((d)localObject3).gNU.put(d.hrx);
        ((d)localObject3).gNU.position(0);
        ae.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(((d)localObject3).jxp), Integer.valueOf(((d)localObject3).jxq), localObject3 });
        ae.i("MicroMsg.MMSightRecordTextureViewRenderThread", "init renderer finish");
        if (!this.jxD) {
          break;
        }
        if (this.jxB != null) {
          if (this.jxB.jxE) {}
        }
      }
      try
      {
        Thread.sleep(10L);
        localObject3 = this.jxB;
        bu.HQ();
        ((d)localObject3).jxm = true;
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GLES20.glClear(16640);
      }
      catch (InterruptedException localInterruptedException)
      {
        synchronized (d.lock)
        {
          if ((((d)localObject3).gOv != -1) && (((d)localObject3).jxp != -1) && (((d)localObject3).jxq != -1) && (((d)localObject3).jxn > 0) && (((d)localObject3).jxo > 0) && (((d)localObject3).hrt != null) && (((d)localObject3).hrm != null) && (((d)localObject3).hrt.limit() > 0) && (((d)localObject3).hrm.limit() > 0) && (((d)localObject3).hrt.position() == 0) && (((d)localObject3).hrm.position() == 0))
          {
            GLES20.glUseProgram(((d)localObject3).gOv);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, ((d)localObject3).jxp);
            GLES20.glTexImage2D(3553, 0, 6409, ((d)localObject3).jxn, ((d)localObject3).jxo, 0, 6409, 5121, ((d)localObject3).hrm);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(((d)localObject3).hri, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, ((d)localObject3).jxq);
            GLES20.glTexImage2D(3553, 0, 6410, ((d)localObject3).jxn / 2, ((d)localObject3).jxo / 2, 0, 6410, 5121, ((d)localObject3).hrt);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(((d)localObject3).hrs, 1);
            Matrix.setIdentityM(((d)localObject3).jxs, 0);
            Matrix.setRotateM(((d)localObject3).jxs, 0, ((d)localObject3).dHi, 0.0F, 0.0F, -1.0F);
            GLES20.glUniformMatrix4fv(((d)localObject3).jxr, 1, false, ((d)localObject3).jxs, 0);
            ((d)localObject3).gNV.position(0);
            GLES20.glVertexAttribPointer(((d)localObject3).gOw, 2, 5126, false, 0, ((d)localObject3).gNV);
            GLES20.glEnableVertexAttribArray(((d)localObject3).gOw);
            ((d)localObject3).gNU.position(0);
            GLES20.glVertexAttribPointer(((d)localObject3).gOx, 2, 5126, false, 0, ((d)localObject3).gNU);
            GLES20.glEnableVertexAttribArray(((d)localObject3).gOx);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(((d)localObject3).gOw);
            GLES20.glDisableVertexAttribArray(((d)localObject3).gOx);
            GLES20.glBindTexture(3553, 0);
          }
          ((d)localObject3).jxm = false;
          if (this.gjh != null)
          {
            this.gjh.eglSwapBuffers(this.gji, this.gjj);
            continue;
            localObject4 = finally;
            AppMethodBeat.o(89215);
            throw localObject4;
            localInterruptedException = localInterruptedException;
            ae.printErrStackTrace("MicroMsg.MMSightRecordTextureViewRenderThread", localInterruptedException, "", new Object[0]);
          }
        }
      }
    }
    ae.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, start destroy gl");
    d locald;
    if (this.jxB != null) {
      locald = this.jxB;
    }
    synchronized (d.lock)
    {
      if (locald.gOv >= 0)
      {
        GLES20.glDeleteProgram(locald.gOv);
        locald.gOv = -1;
      }
      if (locald.jxq >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { locald.jxq }, 0);
        locald.jxq = -1;
      }
      if (locald.jxp >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { locald.jxp }, 0);
        locald.jxp = -1;
      }
      locald.jxo = -1;
      locald.jxn = -1;
      locald.hmi = true;
      locald.hrm = null;
      locald.hrt = null;
      if ((this.gjh != null) && (this.gjl != null) && (this.gjj != null))
      {
        this.gjh.eglDestroyContext(this.gji, this.gjl);
        this.gjh.eglDestroySurface(this.gji, this.gjj);
        this.gjl = EGL10.EGL_NO_CONTEXT;
        this.gjj = EGL10.EGL_NO_SURFACE;
      }
      if (this.hwr != null) {
        this.hwr.release();
      }
      ae.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, finish destroy gl");
      AppMethodBeat.o(89215);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.c
 * JD-Core Version:    0.7.0.1
 */