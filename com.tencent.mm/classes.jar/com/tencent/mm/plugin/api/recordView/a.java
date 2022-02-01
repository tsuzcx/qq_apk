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

public final class a
  implements GLSurfaceView.Renderer
{
  static float[] hoI = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] hoJ = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] juq = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
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
  boolean jur;
  int jus;
  int jut;
  private int juu;
  private int juv;
  private int juw;
  private float[] jux;
  private boolean juy;
  float[] juz;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public a()
  {
    AppMethodBeat.i(89190);
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
    float[] arrayOfFloat = hoJ;
    this.juA = Arrays.copyOf(arrayOfFloat, arrayOfFloat.length);
    this.htY = false;
    this.juB = 0;
    AppMethodBeat.o(89190);
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    AppMethodBeat.i(89193);
    bt.HI();
    this.jur = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.juy)
    {
      ad.i("MicroMsg.MMSightCameraGLRenderer", "clearFrameRequest");
      this.juy = false;
      this.jur = false;
      this.frameData = null;
      this.jus = -1;
      this.jut = -1;
      AppMethodBeat.o(89193);
      return;
    }
    int i;
    if ((this.gLM != 0) && (this.juu != -1) && (this.juv != -1) && (this.jus > 0) && (this.jut > 0) && (this.frameData != null))
    {
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
        break label505;
      }
      i = (this.dGc - this.juB + 360) % 360;
    }
    label505:
    for (;;)
    {
      if (i > 0) {
        Matrix.setRotateM(this.jux, 0, i, 0.0F, 0.0F, -1.0F);
      }
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
      this.jur = false;
      AppMethodBeat.o(89193);
      return;
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89192);
    ad.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.surfaceWidth) || (paramInt2 != this.surfaceHeight))
    {
      ad.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
      float f = this.surfaceWidth / this.surfaceHeight / 2.0F;
      juq = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
    }
    AppMethodBeat.o(89192);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(89191);
    ad.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.gLM = b.ay("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.gLM == 0) {
      ad.e("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, load program failed!");
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
    ad.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.juu), Integer.valueOf(this.juv), this });
    AppMethodBeat.o(89191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.a
 * JD-Core Version:    0.7.0.1
 */