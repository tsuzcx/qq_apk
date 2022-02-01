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

public final class a
  implements GLSurfaceView.Renderer
{
  static float[] gWC = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] gWD = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] jbh = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
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
  boolean jbi;
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
  private int surfaceHeight;
  private int surfaceWidth;
  
  public a()
  {
    AppMethodBeat.i(89190);
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
    float[] arrayOfFloat = gWD;
    this.jbr = Arrays.copyOf(arrayOfFloat, arrayOfFloat.length);
    this.hbQ = false;
    this.jbs = 0;
    AppMethodBeat.o(89190);
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    AppMethodBeat.i(89193);
    bs.Gn();
    this.jbi = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.jbp)
    {
      ac.i("MicroMsg.MMSightCameraGLRenderer", "clearFrameRequest");
      this.jbp = false;
      this.jbi = false;
      this.frameData = null;
      this.jbj = -1;
      this.jbk = -1;
      AppMethodBeat.o(89193);
      return;
    }
    int i;
    if ((this.gse != 0) && (this.jbl != -1) && (this.jbm != -1) && (this.jbj > 0) && (this.jbk > 0) && (this.frameData != null))
    {
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
        break label505;
      }
      i = (this.duc - this.jbs + 360) % 360;
    }
    label505:
    for (;;)
    {
      if (i > 0) {
        Matrix.setRotateM(this.jbo, 0, i, 0.0F, 0.0F, -1.0F);
      }
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
      this.jbi = false;
      AppMethodBeat.o(89193);
      return;
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89192);
    ac.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.surfaceWidth) || (paramInt2 != this.surfaceHeight))
    {
      ac.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
      float f = this.surfaceWidth / this.surfaceHeight / 2.0F;
      jbh = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
    }
    AppMethodBeat.o(89192);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(89191);
    ac.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.gse = b.ax("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.gse == 0) {
      ac.e("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, load program failed!");
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
    ac.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.jbl), Integer.valueOf(this.jbm), this });
    AppMethodBeat.o(89191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.a
 * JD-Core Version:    0.7.0.1
 */