package com.tencent.mm.plugin.api.recordView;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private d fwE;
  private SurfaceTexture fwG;
  private EGL10 fwH;
  private EGLDisplay fwI = EGL10.EGL_NO_DISPLAY;
  private EGLContext fwJ = EGL10.EGL_NO_CONTEXT;
  private EGLSurface fwK = EGL10.EGL_NO_SURFACE;
  volatile boolean needRender;
  
  public c(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    this.fwG = paramSurfaceTexture;
    this.fwE = paramd;
  }
  
  public final void run()
  {
    y.i("MicroMsg.MMSightRecordTextureViewRenderThread", "start render thread");
    this.fwH = ((EGL10)EGLContext.getEGL());
    this.fwI = this.fwH.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    int i;
    if (this.fwI == EGL10.EGL_NO_DISPLAY)
    {
      y.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl get display error: %s", new Object[] { GLUtils.getEGLErrorString(this.fwH.eglGetError()) });
      i = -1;
    }
    Object localObject3;
    while (i < 0)
    {
      y.e("MicroMsg.MMSightRecordTextureViewRenderThread", "init gl failed");
      return;
      ??? = new int[2];
      if (!this.fwH.eglInitialize(this.fwI, (int[])???))
      {
        y.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl init error: %s", new Object[] { GLUtils.getEGLErrorString(this.fwH.eglGetError()) });
        i = -1;
      }
      else
      {
        ??? = new int[1];
        localObject3 = new EGLConfig[1];
        if (!this.fwH.eglChooseConfig(this.fwI, new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344 }, (EGLConfig[])localObject3, 1, (int[])???))
        {
          y.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl choose config failed: %s", new Object[] { GLUtils.getEGLErrorString(this.fwH.eglGetError()) });
          i = -1;
        }
        else
        {
          this.fwJ = this.fwH.eglCreateContext(this.fwI, localObject3[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
          this.fwK = this.fwH.eglCreateWindowSurface(this.fwI, localObject3[0], this.fwG, null);
          if ((this.fwK == EGL10.EGL_NO_SURFACE) || (this.fwJ == EGL10.EGL_NO_CONTEXT))
          {
            if (this.fwH.eglGetError() == 12299)
            {
              y.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
              i = -1;
            }
            else
            {
              y.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface failed : %s", new Object[] { GLUtils.getEGLErrorString(this.fwH.eglGetError()) });
              i = -1;
            }
          }
          else
          {
            if (!this.fwH.eglMakeCurrent(this.fwI, this.fwK, this.fwK, this.fwJ)) {
              y.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglMakeCurrent failed : %s", new Object[] { GLUtils.getEGLErrorString(this.fwH.eglGetError()) });
            }
            i = 0;
          }
        }
      }
    }
    if (this.fwE != null) {
      localObject3 = this.fwE;
    }
    for (;;)
    {
      synchronized (d.lock)
      {
        y.i("MicroMsg.MMSightRecordTextureViewRenderer", "init this %s", new Object[] { localObject3 });
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glDisable(2929);
        ((d)localObject3).fwe = b.aW("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
        if (((d)localObject3).fwe == 0) {
          y.e("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, load program failed!");
        }
        ((d)localObject3).fwg = GLES20.glGetAttribLocation(((d)localObject3).fwe, "a_position");
        ((d)localObject3).fwf = GLES20.glGetAttribLocation(((d)localObject3).fwe, "a_texCoord");
        ((d)localObject3).fwh = GLES20.glGetUniformLocation(((d)localObject3).fwe, "y_texture");
        ((d)localObject3).fwi = GLES20.glGetUniformLocation(((d)localObject3).fwe, "uv_texture");
        ((d)localObject3).fwj = GLES20.glGetUniformLocation(((d)localObject3).fwe, "uMatrix");
        ((d)localObject3).fwc = b.YW();
        ((d)localObject3).fwd = b.YW();
        ((d)localObject3).fwk = ByteBuffer.allocateDirect(((d)localObject3).fwo.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ((d)localObject3).fwk.put(((d)localObject3).fwo);
        ((d)localObject3).fwk.position(0);
        ((d)localObject3).fwl = ByteBuffer.allocateDirect(d.fvU.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ((d)localObject3).fwl.put(d.fvU);
        ((d)localObject3).fwl.position(0);
        y.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(((d)localObject3).fwc), Integer.valueOf(((d)localObject3).fwd), localObject3 });
        y.i("MicroMsg.MMSightRecordTextureViewRenderThread", "init renderer finish");
        if (!this.needRender) {
          break;
        }
        if (this.fwE != null) {
          if (this.fwE.fwM) {}
        }
      }
      try
      {
        Thread.sleep(10L);
        localObject3 = this.fwE;
        bk.UZ();
        ((d)localObject3).brU = true;
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GLES20.glClear(16640);
      }
      catch (InterruptedException localInterruptedException)
      {
        synchronized (d.lock)
        {
          if ((((d)localObject3).fwe != -1) && (((d)localObject3).fwc != -1) && (((d)localObject3).fwd != -1) && (((d)localObject3).fvY > 0) && (((d)localObject3).fvZ > 0) && (((d)localObject3).fwb != null) && (((d)localObject3).fwa != null) && (((d)localObject3).fwb.limit() > 0) && (((d)localObject3).fwa.limit() > 0) && (((d)localObject3).fwb.position() == 0) && (((d)localObject3).fwa.position() == 0))
          {
            GLES20.glUseProgram(((d)localObject3).fwe);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, ((d)localObject3).fwc);
            GLES20.glTexImage2D(3553, 0, 6409, ((d)localObject3).fvY, ((d)localObject3).fvZ, 0, 6409, 5121, ((d)localObject3).fwa);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(((d)localObject3).fwh, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, ((d)localObject3).fwd);
            GLES20.glTexImage2D(3553, 0, 6410, ((d)localObject3).fvY / 2, ((d)localObject3).fvZ / 2, 0, 6410, 5121, ((d)localObject3).fwb);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(((d)localObject3).fwi, 1);
            Matrix.setIdentityM(((d)localObject3).fwm, 0);
            Matrix.setRotateM(((d)localObject3).fwm, 0, ((d)localObject3).rotate, 0.0F, 0.0F, -1.0F);
            GLES20.glUniformMatrix4fv(((d)localObject3).fwj, 1, false, ((d)localObject3).fwm, 0);
            ((d)localObject3).fwk.position(0);
            GLES20.glVertexAttribPointer(((d)localObject3).fwg, 2, 5126, false, 0, ((d)localObject3).fwk);
            GLES20.glEnableVertexAttribArray(((d)localObject3).fwg);
            ((d)localObject3).fwl.position(0);
            GLES20.glVertexAttribPointer(((d)localObject3).fwf, 2, 5126, false, 0, ((d)localObject3).fwl);
            GLES20.glEnableVertexAttribArray(((d)localObject3).fwf);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(((d)localObject3).fwg);
            GLES20.glDisableVertexAttribArray(((d)localObject3).fwf);
            GLES20.glBindTexture(3553, 0);
          }
          ((d)localObject3).brU = false;
          if (this.fwH != null)
          {
            this.fwH.eglSwapBuffers(this.fwI, this.fwK);
            continue;
            localObject4 = finally;
            throw localObject4;
            localInterruptedException = localInterruptedException;
            y.printErrStackTrace("MicroMsg.MMSightRecordTextureViewRenderThread", localInterruptedException, "", new Object[0]);
          }
        }
      }
    }
    y.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, start destroy gl");
    d locald;
    if (this.fwE != null) {
      locald = this.fwE;
    }
    synchronized (d.lock)
    {
      if (locald.fwe >= 0)
      {
        GLES20.glDeleteProgram(locald.fwe);
        locald.fwe = -1;
      }
      if (locald.fwd >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { locald.fwd }, 0);
        locald.fwd = -1;
      }
      if (locald.fwc >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { locald.fwc }, 0);
        locald.fwc = -1;
      }
      locald.fvZ = -1;
      locald.fvY = -1;
      locald.fwL = true;
      locald.fwa = null;
      locald.fwb = null;
      if ((this.fwH != null) && (this.fwJ != null) && (this.fwK != null))
      {
        this.fwH.eglDestroyContext(this.fwI, this.fwJ);
        this.fwH.eglDestroySurface(this.fwI, this.fwK);
        this.fwJ = EGL10.EGL_NO_CONTEXT;
        this.fwK = EGL10.EGL_NO_SURFACE;
      }
      if (this.fwG != null) {
        this.fwG.release();
      }
      y.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, finish destroy gl");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.c
 * JD-Core Version:    0.7.0.1
 */