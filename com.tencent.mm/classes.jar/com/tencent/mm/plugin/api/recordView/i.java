package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class i
  implements GLSurfaceView.Renderer
{
  static float[] hoI = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] hoJ = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] juq = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
  ByteBuffer buffer;
  int dGc;
  byte[] frameData;
  private int gLM;
  private int gLN;
  private int gLO;
  private FloatBuffer gLl;
  FloatBuffer gLm;
  private int hoE;
  ByteBuffer hoF;
  private int hou;
  ByteBuffer hoy;
  boolean htY;
  private float[] juA;
  int juB;
  private boolean jur;
  int jus;
  int jut;
  private int juu;
  private int juv;
  private int juw;
  private float[] jux;
  private boolean juy;
  float[] juz;
  int jvD;
  int jvE;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89280);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.jur = false;
    this.frameData = null;
    this.jus = 0;
    this.jut = 0;
    this.dGc = 0;
    this.jux = new float[16];
    this.juy = false;
    this.juz = hoI;
    Object localObject = hoJ;
    this.juA = Arrays.copyOf((float[])localObject, localObject.length);
    this.htY = false;
    this.juB = 0;
    this.jvD = 0;
    this.jvE = 0;
    this.buffer = null;
    this.jvD = b.auh();
    localObject = new int[1];
    GLES20.glGenFramebuffers(1, (int[])localObject, 0);
    if (localObject[0] == 0) {
      ad.e("MicroMsg.MMSightCameraGLUtil", "gen frame buffer error");
    }
    for (int i = 0;; i = localObject[0])
    {
      this.jvE = i;
      GLES20.glBindFramebuffer(36160, this.jvE);
      GLES20.glBindTexture(3553, this.jvD);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.jvD, 0);
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
    bt.HI();
    this.jur = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.juy)
    {
      ad.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "clearFrameRequest");
      this.juy = false;
      this.jur = false;
      this.frameData = null;
      this.jus = -1;
      this.jut = -1;
      AppMethodBeat.o(89283);
      return;
    }
    int i;
    if ((this.gLM != 0) && (this.juu != -1) && (this.juv != -1) && (this.jus > 0) && (this.jut > 0) && (this.frameData != null))
    {
      GLES20.glBindFramebuffer(36160, this.jvE);
      GLES20.glBindTexture(3553, this.jvD);
      GLES20.glTexImage2D(3553, 0, 6408, this.surfaceWidth, this.surfaceHeight, 0, 6408, 5121, null);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.jvD, 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
      GLES20.glUseProgram(this.gLM);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.juu);
      GLES20.glTexImage2D(3553, 0, 6409, this.jus, this.jut, 0, 6409, 5121, this.hoy);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.hou, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.juv);
      GLES20.glTexImage2D(3553, 0, 6410, this.jus / 2, this.jut / 2, 0, 6410, 5121, this.hoF);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.hoE, 1);
      Matrix.setIdentityM(this.jux, 0);
      i = this.dGc;
      if ((this.juB != 90) && (this.juB != 270)) {
        break label713;
      }
      i = (this.dGc - this.juB + 360 + 180) % 360;
    }
    label713:
    for (;;)
    {
      Matrix.setRotateM(this.jux, 0, i, 0.0F, 0.0F, -1.0F);
      if ((this.dGc == 90) || (this.dGc == 270)) {
        Matrix.scaleM(this.jux, 0, -1.0F, 1.0F, 1.0F);
      }
      for (;;)
      {
        GLES20.glUniformMatrix4fv(this.juw, 1, false, this.jux, 0);
        this.gLm.position(0);
        GLES20.glVertexAttribPointer(this.gLN, 2, 5126, false, 0, this.gLm);
        GLES20.glEnableVertexAttribArray(this.gLN);
        this.gLl.position(0);
        GLES20.glVertexAttribPointer(this.gLO, 2, 5126, false, 0, this.gLl);
        GLES20.glEnableVertexAttribArray(this.gLO);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.gLN);
        GLES20.glDisableVertexAttribArray(this.gLO);
        GLES20.glBindTexture(3553, 0);
        GLES20.glFinish();
        this.buffer.position(0);
        GLES20.glReadPixels(0, 0, this.surfaceWidth, this.surfaceHeight, 6408, 5121, this.buffer);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        this.jur = false;
        ad.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "time cost : %d", new Object[] { Long.valueOf(bt.aO(bt.HI())) });
        AppMethodBeat.o(89283);
        return;
        Matrix.scaleM(this.jux, 0, 1.0F, -1.0F, 1.0F);
      }
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89282);
    ad.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.surfaceWidth) || (paramInt2 != this.surfaceHeight))
    {
      ad.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
      float f = this.surfaceWidth / this.surfaceHeight / 2.0F;
      juq = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
    }
    AppMethodBeat.o(89282);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(89281);
    ad.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.gLM = b.ay("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.gLM == 0) {
      ad.e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, load program failed!");
    }
    this.gLN = GLES20.glGetAttribLocation(this.gLM, "a_position");
    this.gLO = GLES20.glGetAttribLocation(this.gLM, "a_texCoord");
    this.hou = GLES20.glGetUniformLocation(this.gLM, "y_texture");
    this.hoE = GLES20.glGetUniformLocation(this.gLM, "uv_texture");
    this.juw = GLES20.glGetUniformLocation(this.gLM, "uMatrix");
    this.juu = b.auh();
    this.juv = b.auh();
    this.gLm = ByteBuffer.allocateDirect(this.juz.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.gLm.put(this.juz);
    this.gLm.position(0);
    this.gLl = ByteBuffer.allocateDirect(hoJ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.gLl.put(hoJ);
    this.gLl.position(0);
    ad.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.juu), Integer.valueOf(this.juv), this });
    AppMethodBeat.o(89281);
  }
  
  public static abstract interface a
  {
    public abstract void aVx();
    
    public abstract ByteBuffer getBuffer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.i
 * JD-Core Version:    0.7.0.1
 */