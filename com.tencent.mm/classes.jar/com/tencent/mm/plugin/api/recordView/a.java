package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class a
  implements GLSurfaceView.Renderer
{
  static float[] nFt = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] nFu = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] qpB = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
  byte[] frameData;
  int hYK;
  private FloatBuffer mVU;
  FloatBuffer mVV;
  private int mWv;
  private int mWw;
  private int nEF;
  ByteBuffer nEJ;
  private int nEP;
  ByteBuffer nEQ;
  boolean nKe;
  private int programId;
  boolean qpC;
  int qpD;
  int qpE;
  private int qpF;
  private int qpG;
  private int qpH;
  private float[] qpI;
  private boolean qpJ;
  float[] qpK;
  private float[] qpL;
  int qpM;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public a()
  {
    AppMethodBeat.i(89190);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.qpC = false;
    this.frameData = null;
    this.qpD = 0;
    this.qpE = 0;
    this.hYK = 0;
    this.qpI = new float[16];
    this.qpJ = false;
    this.qpK = nFt;
    float[] arrayOfFloat = nFu;
    this.qpL = Arrays.copyOf(arrayOfFloat, arrayOfFloat.length);
    this.nKe = false;
    this.qpM = 0;
    AppMethodBeat.o(89190);
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    AppMethodBeat.i(89193);
    Util.currentTicks();
    this.qpC = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.qpJ)
    {
      Log.i("MicroMsg.MMSightCameraGLRenderer", "clearFrameRequest");
      this.qpJ = false;
      this.qpC = false;
      this.frameData = null;
      this.qpD = -1;
      this.qpE = -1;
      AppMethodBeat.o(89193);
      return;
    }
    int i;
    if ((this.programId != 0) && (this.qpF != -1) && (this.qpG != -1) && (this.qpD > 0) && (this.qpE > 0) && (this.frameData != null))
    {
      GLES20.glUseProgram(this.programId);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.qpF);
      GLES20.glTexImage2D(3553, 0, 6409, this.qpD, this.qpE, 0, 6409, 5121, this.nEJ);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.nEF, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.qpG);
      GLES20.glTexImage2D(3553, 0, 6410, this.qpD / 2, this.qpE / 2, 0, 6410, 5121, this.nEQ);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.nEP, 1);
      Matrix.setIdentityM(this.qpI, 0);
      i = this.hYK;
      if ((this.qpM != 90) && (this.qpM != 270)) {
        break label505;
      }
      i = (this.hYK - this.qpM + 360) % 360;
    }
    label505:
    for (;;)
    {
      if (i > 0) {
        Matrix.setRotateM(this.qpI, 0, i, 0.0F, 0.0F, -1.0F);
      }
      GLES20.glUniformMatrix4fv(this.qpH, 1, false, this.qpI, 0);
      this.mVV.position(0);
      GLES20.glVertexAttribPointer(this.mWv, 2, 5126, false, 0, this.mVV);
      GLES20.glEnableVertexAttribArray(this.mWv);
      this.mVU.position(0);
      GLES20.glVertexAttribPointer(this.mWw, 2, 5126, false, 0, this.mVU);
      GLES20.glEnableVertexAttribArray(this.mWw);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.mWv);
      GLES20.glDisableVertexAttribArray(this.mWw);
      GLES20.glBindTexture(3553, 0);
      this.qpC = false;
      AppMethodBeat.o(89193);
      return;
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89192);
    Log.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.surfaceWidth) || (paramInt2 != this.surfaceHeight))
    {
      Log.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
      float f = this.surfaceWidth / this.surfaceHeight / 2.0F;
      qpB = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
    }
    AppMethodBeat.o(89192);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(89191);
    Log.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.programId = b.aN("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.programId == 0) {
      Log.e("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, load program failed!");
    }
    this.mWv = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.mWw = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.nEF = GLES20.glGetUniformLocation(this.programId, "y_texture");
    this.nEP = GLES20.glGetUniformLocation(this.programId, "uv_texture");
    this.qpH = GLES20.glGetUniformLocation(this.programId, "uMatrix");
    this.qpF = b.bql();
    this.qpG = b.bql();
    this.mVV = ByteBuffer.allocateDirect(this.qpK.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mVV.put(this.qpK);
    this.mVV.position(0);
    this.mVU = ByteBuffer.allocateDirect(nFu.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mVU.put(nFu);
    this.mVU.position(0);
    Log.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.qpF), Integer.valueOf(this.qpG), this });
    AppMethodBeat.o(89191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.a
 * JD-Core Version:    0.7.0.1
 */