package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class i
  implements GLSurfaceView.Renderer
{
  static float[] gWC = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] gWD = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] jbh = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
  ByteBuffer buffer;
  int duc;
  byte[] frameData;
  private int gWo;
  ByteBuffer gWs;
  private int gWy;
  ByteBuffer gWz;
  private FloatBuffer grD;
  FloatBuffer grE;
  private int gse;
  private int gsf;
  private int gsg;
  boolean hbQ;
  private boolean jbi;
  int jbj;
  int jbk;
  private int jbl;
  private int jbm;
  private int jbn;
  private float[] jbo;
  private boolean jbp;
  float[] jbq;
  private float[] jbr;
  int jbs;
  int jcu;
  int jcv;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89280);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.jbi = false;
    this.frameData = null;
    this.jbj = 0;
    this.jbk = 0;
    this.duc = 0;
    this.jbo = new float[16];
    this.jbp = false;
    this.jbq = gWC;
    Object localObject = gWD;
    this.jbr = Arrays.copyOf((float[])localObject, localObject.length);
    this.hbQ = false;
    this.jbs = 0;
    this.jcu = 0;
    this.jcv = 0;
    this.buffer = null;
    this.jcu = b.aru();
    localObject = new int[1];
    GLES20.glGenFramebuffers(1, (int[])localObject, 0);
    if (localObject[0] == 0) {
      ac.e("MicroMsg.MMSightCameraGLUtil", "gen frame buffer error");
    }
    for (int i = 0;; i = localObject[0])
    {
      this.jcv = i;
      GLES20.glBindFramebuffer(36160, this.jcv);
      GLES20.glBindTexture(3553, this.jcu);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.jcu, 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      AppMethodBeat.o(89280);
      return;
    }
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    AppMethodBeat.i(89283);
    if (this.buffer == null)
    {
      AppMethodBeat.o(89283);
      return;
    }
    bs.Gn();
    this.jbi = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.jbp)
    {
      ac.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "clearFrameRequest");
      this.jbp = false;
      this.jbi = false;
      this.frameData = null;
      this.jbj = -1;
      this.jbk = -1;
      AppMethodBeat.o(89283);
      return;
    }
    int i;
    if ((this.gse != 0) && (this.jbl != -1) && (this.jbm != -1) && (this.jbj > 0) && (this.jbk > 0) && (this.frameData != null))
    {
      GLES20.glBindFramebuffer(36160, this.jcv);
      GLES20.glBindTexture(3553, this.jcu);
      GLES20.glTexImage2D(3553, 0, 6408, this.surfaceWidth, this.surfaceHeight, 0, 6408, 5121, null);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.jcu, 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
      GLES20.glUseProgram(this.gse);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.jbl);
      GLES20.glTexImage2D(3553, 0, 6409, this.jbj, this.jbk, 0, 6409, 5121, this.gWs);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.gWo, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.jbm);
      GLES20.glTexImage2D(3553, 0, 6410, this.jbj / 2, this.jbk / 2, 0, 6410, 5121, this.gWz);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.gWy, 1);
      Matrix.setIdentityM(this.jbo, 0);
      i = this.duc;
      if ((this.jbs != 90) && (this.jbs != 270)) {
        break label713;
      }
      i = (this.duc - this.jbs + 360 + 180) % 360;
    }
    label713:
    for (;;)
    {
      Matrix.setRotateM(this.jbo, 0, i, 0.0F, 0.0F, -1.0F);
      if ((this.duc == 90) || (this.duc == 270)) {
        Matrix.scaleM(this.jbo, 0, -1.0F, 1.0F, 1.0F);
      }
      for (;;)
      {
        GLES20.glUniformMatrix4fv(this.jbn, 1, false, this.jbo, 0);
        this.grE.position(0);
        GLES20.glVertexAttribPointer(this.gsf, 2, 5126, false, 0, this.grE);
        GLES20.glEnableVertexAttribArray(this.gsf);
        this.grD.position(0);
        GLES20.glVertexAttribPointer(this.gsg, 2, 5126, false, 0, this.grD);
        GLES20.glEnableVertexAttribArray(this.gsg);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.gsf);
        GLES20.glDisableVertexAttribArray(this.gsg);
        GLES20.glBindTexture(3553, 0);
        GLES20.glFinish();
        this.buffer.position(0);
        GLES20.glReadPixels(0, 0, this.surfaceWidth, this.surfaceHeight, 6408, 5121, this.buffer);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        this.jbi = false;
        ac.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "time cost : %d", new Object[] { Long.valueOf(bs.aO(bs.Gn())) });
        AppMethodBeat.o(89283);
        return;
        Matrix.scaleM(this.jbo, 0, 1.0F, -1.0F, 1.0F);
      }
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89282);
    ac.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.surfaceWidth) || (paramInt2 != this.surfaceHeight))
    {
      ac.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
      float f = this.surfaceWidth / this.surfaceHeight / 2.0F;
      jbh = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
    }
    AppMethodBeat.o(89282);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(89281);
    ac.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.gse = b.ax("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.gse == 0) {
      ac.e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, load program failed!");
    }
    this.gsf = GLES20.glGetAttribLocation(this.gse, "a_position");
    this.gsg = GLES20.glGetAttribLocation(this.gse, "a_texCoord");
    this.gWo = GLES20.glGetUniformLocation(this.gse, "y_texture");
    this.gWy = GLES20.glGetUniformLocation(this.gse, "uv_texture");
    this.jbn = GLES20.glGetUniformLocation(this.gse, "uMatrix");
    this.jbl = b.aru();
    this.jbm = b.aru();
    this.grE = ByteBuffer.allocateDirect(this.jbq.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.grE.put(this.jbq);
    this.grE.position(0);
    this.grD = ByteBuffer.allocateDirect(gWD.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.grD.put(gWD);
    this.grD.position(0);
    ac.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.jbl), Integer.valueOf(this.jbm), this });
    AppMethodBeat.o(89281);
  }
  
  public static abstract interface a
  {
    public abstract void aSl();
    
    public abstract ByteBuffer getBuffer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.i
 * JD-Core Version:    0.7.0.1
 */