package com.tencent.mm.plugin.api.recordView;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  private SurfaceTexture fbG;
  private d gNL;
  private EGL10 mEgl;
  private EGLContext mEglContext = EGL10.EGL_NO_CONTEXT;
  private EGLDisplay mEglDisplay = EGL10.EGL_NO_DISPLAY;
  private EGLSurface mEglSurface = EGL10.EGL_NO_SURFACE;
  volatile boolean needRender;
  
  public c(SurfaceTexture paramSurfaceTexture, d paramd)
  {
    this.fbG = paramSurfaceTexture;
    this.gNL = paramd;
  }
  
  public final void run()
  {
    AppMethodBeat.i(76333);
    ab.i("MicroMsg.MMSightRecordTextureViewRenderThread", "start render thread");
    this.mEgl = ((EGL10)EGLContext.getEGL());
    this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    int i;
    if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY)
    {
      ab.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl get display error: %s", new Object[] { GLUtils.getEGLErrorString(this.mEgl.eglGetError()) });
      i = -1;
    }
    Object localObject3;
    while (i < 0)
    {
      ab.e("MicroMsg.MMSightRecordTextureViewRenderThread", "init gl failed");
      AppMethodBeat.o(76333);
      return;
      ??? = new int[2];
      if (!this.mEgl.eglInitialize(this.mEglDisplay, (int[])???))
      {
        ab.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl init error: %s", new Object[] { GLUtils.getEGLErrorString(this.mEgl.eglGetError()) });
        i = -1;
      }
      else
      {
        ??? = new int[1];
        localObject3 = new EGLConfig[1];
        if (!this.mEgl.eglChooseConfig(this.mEglDisplay, new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344 }, (EGLConfig[])localObject3, 1, (int[])???))
        {
          ab.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl choose config failed: %s", new Object[] { GLUtils.getEGLErrorString(this.mEgl.eglGetError()) });
          i = -1;
        }
        else
        {
          this.mEglContext = this.mEgl.eglCreateContext(this.mEglDisplay, localObject3[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
          this.mEglSurface = this.mEgl.eglCreateWindowSurface(this.mEglDisplay, localObject3[0], this.fbG, null);
          if ((this.mEglSurface == EGL10.EGL_NO_SURFACE) || (this.mEglContext == EGL10.EGL_NO_CONTEXT))
          {
            if (this.mEgl.eglGetError() == 12299)
            {
              ab.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
              i = -1;
            }
            else
            {
              ab.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface failed : %s", new Object[] { GLUtils.getEGLErrorString(this.mEgl.eglGetError()) });
              i = -1;
            }
          }
          else
          {
            if (!this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext)) {
              ab.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglMakeCurrent failed : %s", new Object[] { GLUtils.getEGLErrorString(this.mEgl.eglGetError()) });
            }
            i = 0;
          }
        }
      }
    }
    if (this.gNL != null) {
      localObject3 = this.gNL;
    }
    for (;;)
    {
      synchronized (d.lock)
      {
        ab.i("MicroMsg.MMSightRecordTextureViewRenderer", "init this %s", new Object[] { localObject3 });
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glDisable(2929);
        ((d)localObject3).eYZ = b.Z("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
        if (((d)localObject3).eYZ == 0) {
          ab.e("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, load program failed!");
        }
        ((d)localObject3).eZa = GLES20.glGetAttribLocation(((d)localObject3).eYZ, "a_position");
        ((d)localObject3).eZb = GLES20.glGetAttribLocation(((d)localObject3).eYZ, "a_texCoord");
        ((d)localObject3).eZj = GLES20.glGetUniformLocation(((d)localObject3).eYZ, "y_texture");
        ((d)localObject3).eZk = GLES20.glGetUniformLocation(((d)localObject3).eYZ, "uv_texture");
        ((d)localObject3).gNC = GLES20.glGetUniformLocation(((d)localObject3).eYZ, "uMatrix");
        ((d)localObject3).eZe = b.Vm();
        ((d)localObject3).eZf = b.Vm();
        ((d)localObject3).eYv = ByteBuffer.allocateDirect(((d)localObject3).gNF.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ((d)localObject3).eYv.put(((d)localObject3).gNF);
        ((d)localObject3).eYv.position(0);
        ((d)localObject3).eYu = ByteBuffer.allocateDirect(d.eZr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ((d)localObject3).eYu.put(d.eZr);
        ((d)localObject3).eYu.position(0);
        ab.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(((d)localObject3).eZe), Integer.valueOf(((d)localObject3).eZf), localObject3 });
        ab.i("MicroMsg.MMSightRecordTextureViewRenderThread", "init renderer finish");
        if (!this.needRender) {
          break;
        }
        if (this.gNL != null) {
          if (this.gNL.gNN) {}
        }
      }
      try
      {
        Thread.sleep(10L);
        localObject3 = this.gNL;
        bo.yB();
        ((d)localObject3).gNz = true;
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GLES20.glClear(16640);
      }
      catch (InterruptedException localInterruptedException)
      {
        synchronized (d.lock)
        {
          if ((((d)localObject3).eYZ != -1) && (((d)localObject3).eZe != -1) && (((d)localObject3).eZf != -1) && (((d)localObject3).gNA > 0) && (((d)localObject3).gNB > 0) && (((d)localObject3).eZn != null) && (((d)localObject3).eZm != null) && (((d)localObject3).eZn.limit() > 0) && (((d)localObject3).eZm.limit() > 0) && (((d)localObject3).eZn.position() == 0) && (((d)localObject3).eZm.position() == 0))
          {
            GLES20.glUseProgram(((d)localObject3).eYZ);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, ((d)localObject3).eZe);
            GLES20.glTexImage2D(3553, 0, 6409, ((d)localObject3).gNA, ((d)localObject3).gNB, 0, 6409, 5121, ((d)localObject3).eZm);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(((d)localObject3).eZj, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, ((d)localObject3).eZf);
            GLES20.glTexImage2D(3553, 0, 6410, ((d)localObject3).gNA / 2, ((d)localObject3).gNB / 2, 0, 6410, 5121, ((d)localObject3).eZn);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 33071.0F);
            GLES20.glTexParameterf(3553, 10243, 33071.0F);
            GLES20.glUniform1i(((d)localObject3).eZk, 1);
            Matrix.setIdentityM(((d)localObject3).gND, 0);
            Matrix.setRotateM(((d)localObject3).gND, 0, ((d)localObject3).rotate, 0.0F, 0.0F, -1.0F);
            GLES20.glUniformMatrix4fv(((d)localObject3).gNC, 1, false, ((d)localObject3).gND, 0);
            ((d)localObject3).eYv.position(0);
            GLES20.glVertexAttribPointer(((d)localObject3).eZa, 2, 5126, false, 0, ((d)localObject3).eYv);
            GLES20.glEnableVertexAttribArray(((d)localObject3).eZa);
            ((d)localObject3).eYu.position(0);
            GLES20.glVertexAttribPointer(((d)localObject3).eZb, 2, 5126, false, 0, ((d)localObject3).eYu);
            GLES20.glEnableVertexAttribArray(((d)localObject3).eZb);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(((d)localObject3).eZa);
            GLES20.glDisableVertexAttribArray(((d)localObject3).eZb);
            GLES20.glBindTexture(3553, 0);
          }
          ((d)localObject3).gNz = false;
          if (this.mEgl != null)
          {
            this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface);
            continue;
            localObject4 = finally;
            AppMethodBeat.o(76333);
            throw localObject4;
            localInterruptedException = localInterruptedException;
            ab.printErrStackTrace("MicroMsg.MMSightRecordTextureViewRenderThread", localInterruptedException, "", new Object[0]);
          }
        }
      }
    }
    ab.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, start destroy gl");
    d locald;
    if (this.gNL != null) {
      locald = this.gNL;
    }
    synchronized (d.lock)
    {
      if (locald.eYZ >= 0)
      {
        GLES20.glDeleteProgram(locald.eYZ);
        locald.eYZ = -1;
      }
      if (locald.eZf >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { locald.eZf }, 0);
        locald.eZf = -1;
      }
      if (locald.eZe >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { locald.eZe }, 0);
        locald.eZe = -1;
      }
      locald.gNB = -1;
      locald.gNA = -1;
      locald.eUY = true;
      locald.eZm = null;
      locald.eZn = null;
      if ((this.mEgl != null) && (this.mEglContext != null) && (this.mEglSurface != null))
      {
        this.mEgl.eglDestroyContext(this.mEglDisplay, this.mEglContext);
        this.mEgl.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
        this.mEglContext = EGL10.EGL_NO_CONTEXT;
        this.mEglSurface = EGL10.EGL_NO_SURFACE;
      }
      if (this.fbG != null) {
        this.fbG.release();
      }
      ab.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, finish destroy gl");
      AppMethodBeat.o(76333);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.c
 * JD-Core Version:    0.7.0.1
 */