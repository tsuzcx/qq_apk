package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class a
  implements GLSurfaceView.Renderer
{
  static float[] hrw = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] hrx = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] jxl = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
  int dHi;
  byte[] frameData;
  private FloatBuffer gNU;
  FloatBuffer gNV;
  private int gOv;
  private int gOw;
  private int gOx;
  private int hri;
  ByteBuffer hrm;
  private int hrs;
  ByteBuffer hrt;
  boolean hwM;
  boolean jxm;
  int jxn;
  int jxo;
  private int jxp;
  private int jxq;
  private int jxr;
  private float[] jxs;
  private boolean jxt;
  float[] jxu;
  private float[] jxv;
  int jxw;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public a()
  {
    AppMethodBeat.i(89190);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.jxm = false;
    this.frameData = null;
    this.jxn = 0;
    this.jxo = 0;
    this.dHi = 0;
    this.jxs = new float[16];
    this.jxt = false;
    this.jxu = hrw;
    float[] arrayOfFloat = hrx;
    this.jxv = Arrays.copyOf(arrayOfFloat, arrayOfFloat.length);
    this.hwM = false;
    this.jxw = 0;
    AppMethodBeat.o(89190);
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    AppMethodBeat.i(89193);
    bu.HQ();
    this.jxm = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.jxt)
    {
      ae.i("MicroMsg.MMSightCameraGLRenderer", "clearFrameRequest");
      this.jxt = false;
      this.jxm = false;
      this.frameData = null;
      this.jxn = -1;
      this.jxo = -1;
      AppMethodBeat.o(89193);
      return;
    }
    int i;
    if ((this.gOv != 0) && (this.jxp != -1) && (this.jxq != -1) && (this.jxn > 0) && (this.jxo > 0) && (this.frameData != null))
    {
      GLES20.glUseProgram(this.gOv);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.jxp);
      GLES20.glTexImage2D(3553, 0, 6409, this.jxn, this.jxo, 0, 6409, 5121, this.hrm);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.hri, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.jxq);
      GLES20.glTexImage2D(3553, 0, 6410, this.jxn / 2, this.jxo / 2, 0, 6410, 5121, this.hrt);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.hrs, 1);
      Matrix.setIdentityM(this.jxs, 0);
      i = this.dHi;
      if ((this.jxw != 90) && (this.jxw != 270)) {
        break label505;
      }
      i = (this.dHi - this.jxw + 360) % 360;
    }
    label505:
    for (;;)
    {
      if (i > 0) {
        Matrix.setRotateM(this.jxs, 0, i, 0.0F, 0.0F, -1.0F);
      }
      GLES20.glUniformMatrix4fv(this.jxr, 1, false, this.jxs, 0);
      this.gNV.position(0);
      GLES20.glVertexAttribPointer(this.gOw, 2, 5126, false, 0, this.gNV);
      GLES20.glEnableVertexAttribArray(this.gOw);
      this.gNU.position(0);
      GLES20.glVertexAttribPointer(this.gOx, 2, 5126, false, 0, this.gNU);
      GLES20.glEnableVertexAttribArray(this.gOx);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.gOw);
      GLES20.glDisableVertexAttribArray(this.gOx);
      GLES20.glBindTexture(3553, 0);
      this.jxm = false;
      AppMethodBeat.o(89193);
      return;
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89192);
    ae.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.surfaceWidth) || (paramInt2 != this.surfaceHeight))
    {
      ae.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
      float f = this.surfaceWidth / this.surfaceHeight / 2.0F;
      jxl = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
    }
    AppMethodBeat.o(89192);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(89191);
    ae.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.gOv = b.az("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.gOv == 0) {
      ae.e("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, load program failed!");
    }
    this.gOw = GLES20.glGetAttribLocation(this.gOv, "a_position");
    this.gOx = GLES20.glGetAttribLocation(this.gOv, "a_texCoord");
    this.hri = GLES20.glGetUniformLocation(this.gOv, "y_texture");
    this.hrs = GLES20.glGetUniformLocation(this.gOv, "uv_texture");
    this.jxr = GLES20.glGetUniformLocation(this.gOv, "uMatrix");
    this.jxp = b.auw();
    this.jxq = b.auw();
    this.gNV = ByteBuffer.allocateDirect(this.jxu.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.gNV.put(this.jxu);
    this.gNV.position(0);
    this.gNU = ByteBuffer.allocateDirect(hrx.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.gNU.put(hrx);
    this.gNU.position(0);
    ae.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.jxp), Integer.valueOf(this.jxq), this });
    AppMethodBeat.o(89191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.a
 * JD-Core Version:    0.7.0.1
 */