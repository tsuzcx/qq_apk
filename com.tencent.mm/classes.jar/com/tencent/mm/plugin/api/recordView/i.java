package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

final class i
  implements GLSurfaceView.Renderer
{
  static float[] eZq = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] eZr = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] gNy = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
  ByteBuffer buffer;
  private int eYZ;
  private FloatBuffer eYu;
  FloatBuffer eYv;
  int eYw;
  int eYx;
  private int eZa;
  private int eZb;
  private int eZe;
  private int eZf;
  private int eZj;
  private int eZk;
  ByteBuffer eZm;
  ByteBuffer eZn;
  private int fbH;
  private int fbI;
  boolean fcx;
  byte[] frameData;
  int gNA;
  int gNB;
  private int gNC;
  private float[] gND;
  private boolean gNE;
  float[] gNF;
  private float[] gNG;
  int gNH;
  private boolean gNz;
  int rotate;
  
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140116);
    this.fbH = 0;
    this.fbI = 0;
    this.gNz = false;
    this.frameData = null;
    this.gNA = 0;
    this.gNB = 0;
    this.rotate = 0;
    this.gND = new float[16];
    this.gNE = false;
    this.gNF = eZq;
    Object localObject = eZr;
    this.gNG = Arrays.copyOf((float[])localObject, localObject.length);
    this.fcx = false;
    this.gNH = 0;
    this.eYw = 0;
    this.eYx = 0;
    this.buffer = null;
    this.eYw = b.Vm();
    localObject = new int[1];
    GLES20.glGenFramebuffers(1, (int[])localObject, 0);
    if (localObject[0] == 0) {
      ab.e("MicroMsg.MMSightCameraGLUtil", "gen frame buffer error");
    }
    for (int i = 0;; i = localObject[0])
    {
      this.eYx = i;
      GLES20.glBindFramebuffer(36160, this.eYx);
      GLES20.glBindTexture(3553, this.eYw);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.eYw, 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      AppMethodBeat.o(140116);
      return;
    }
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    AppMethodBeat.i(76398);
    if (this.buffer == null)
    {
      AppMethodBeat.o(76398);
      return;
    }
    bo.yB();
    this.gNz = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.gNE)
    {
      ab.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "clearFrameRequest");
      this.gNE = false;
      this.gNz = false;
      this.frameData = null;
      this.gNA = -1;
      this.gNB = -1;
      AppMethodBeat.o(76398);
      return;
    }
    if ((this.eYZ != 0) && (this.eZe != -1) && (this.eZf != -1) && (this.gNA > 0) && (this.gNB > 0) && (this.frameData != null))
    {
      GLES20.glUseProgram(this.eYZ);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.eZe);
      GLES20.glTexImage2D(3553, 0, 6409, this.gNA, this.gNB, 0, 6409, 5121, this.eZm);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.eZj, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.eZf);
      GLES20.glTexImage2D(3553, 0, 6410, this.gNA / 2, this.gNB / 2, 0, 6410, 5121, this.eZn);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.eZk, 1);
      Matrix.setIdentityM(this.gND, 0);
      int i = this.rotate;
      Matrix.setRotateM(this.gND, 0, i, 0.0F, 0.0F, -1.0F);
      if ((i != 90) && (i != 270)) {
        break label560;
      }
      Matrix.scaleM(this.gND, 0, -1.0F, 1.0F, 1.0F);
    }
    for (;;)
    {
      GLES20.glUniformMatrix4fv(this.gNC, 1, false, this.gND, 0);
      this.eYv.position(0);
      GLES20.glVertexAttribPointer(this.eZa, 2, 5126, false, 0, this.eYv);
      GLES20.glEnableVertexAttribArray(this.eZa);
      this.eYu.position(0);
      GLES20.glVertexAttribPointer(this.eZb, 2, 5126, false, 0, this.eYu);
      GLES20.glEnableVertexAttribArray(this.eZb);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.eZa);
      GLES20.glDisableVertexAttribArray(this.eZb);
      GLES20.glBindTexture(3553, 0);
      this.gNz = false;
      long l = bo.yB();
      this.buffer.position(0);
      GLES20.glReadPixels(0, 0, this.fbH, this.fbI, 6408, 5121, this.buffer);
      ab.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "time cost : %d", new Object[] { Long.valueOf(bo.av(l)) });
      AppMethodBeat.o(76398);
      return;
      label560:
      Matrix.scaleM(this.gND, 0, 1.0F, -1.0F, 1.0F);
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76397);
    ab.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.fbH) || (paramInt2 != this.fbI))
    {
      ab.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.fbH = paramInt1;
      this.fbI = paramInt2;
      float f = this.fbH / this.fbI / 2.0F;
      gNy = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
    }
    AppMethodBeat.o(76397);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(76396);
    ab.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.eYZ = b.Z("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.eYZ == 0) {
      ab.e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, load program failed!");
    }
    this.eZa = GLES20.glGetAttribLocation(this.eYZ, "a_position");
    this.eZb = GLES20.glGetAttribLocation(this.eYZ, "a_texCoord");
    this.eZj = GLES20.glGetUniformLocation(this.eYZ, "y_texture");
    this.eZk = GLES20.glGetUniformLocation(this.eYZ, "uv_texture");
    this.gNC = GLES20.glGetUniformLocation(this.eYZ, "uMatrix");
    this.eZe = b.Vm();
    this.eZf = b.Vm();
    this.eYv = ByteBuffer.allocateDirect(this.gNF.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.eYv.put(this.gNF);
    this.eYv.position(0);
    this.eYu = ByteBuffer.allocateDirect(eZr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.eYu.put(eZr);
    this.eYu.position(0);
    ab.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.eZe), Integer.valueOf(this.eZf), this });
    AppMethodBeat.o(76396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.i
 * JD-Core Version:    0.7.0.1
 */