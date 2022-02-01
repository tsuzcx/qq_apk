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

public final class i
  implements GLSurfaceView.Renderer
{
  static float[] hrw = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] hrx = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] jxl = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
  ByteBuffer buffer;
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
  private boolean jxm;
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
  int jyy;
  int jyz;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89280);
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
    Object localObject = hrx;
    this.jxv = Arrays.copyOf((float[])localObject, localObject.length);
    this.hwM = false;
    this.jxw = 0;
    this.jyy = 0;
    this.jyz = 0;
    this.buffer = null;
    this.jyy = b.auw();
    localObject = new int[1];
    GLES20.glGenFramebuffers(1, (int[])localObject, 0);
    if (localObject[0] == 0) {
      ae.e("MicroMsg.MMSightCameraGLUtil", "gen frame buffer error");
    }
    for (int i = 0;; i = localObject[0])
    {
      this.jyz = i;
      GLES20.glBindFramebuffer(36160, this.jyz);
      GLES20.glBindTexture(3553, this.jyy);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.jyy, 0);
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
    bu.HQ();
    this.jxm = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.jxt)
    {
      ae.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "clearFrameRequest");
      this.jxt = false;
      this.jxm = false;
      this.frameData = null;
      this.jxn = -1;
      this.jxo = -1;
      AppMethodBeat.o(89283);
      return;
    }
    int i;
    if ((this.gOv != 0) && (this.jxp != -1) && (this.jxq != -1) && (this.jxn > 0) && (this.jxo > 0) && (this.frameData != null))
    {
      GLES20.glBindFramebuffer(36160, this.jyz);
      GLES20.glBindTexture(3553, this.jyy);
      GLES20.glTexImage2D(3553, 0, 6408, this.surfaceWidth, this.surfaceHeight, 0, 6408, 5121, null);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.jyy, 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
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
        break label713;
      }
      i = (this.dHi - this.jxw + 360 + 180) % 360;
    }
    label713:
    for (;;)
    {
      Matrix.setRotateM(this.jxs, 0, i, 0.0F, 0.0F, -1.0F);
      if ((this.dHi == 90) || (this.dHi == 270)) {
        Matrix.scaleM(this.jxs, 0, -1.0F, 1.0F, 1.0F);
      }
      for (;;)
      {
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
        GLES20.glFinish();
        this.buffer.position(0);
        GLES20.glReadPixels(0, 0, this.surfaceWidth, this.surfaceHeight, 6408, 5121, this.buffer);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        this.jxm = false;
        ae.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "time cost : %d", new Object[] { Long.valueOf(bu.aO(bu.HQ())) });
        AppMethodBeat.o(89283);
        return;
        Matrix.scaleM(this.jxs, 0, 1.0F, -1.0F, 1.0F);
      }
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89282);
    ae.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.surfaceWidth) || (paramInt2 != this.surfaceHeight))
    {
      ae.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
      float f = this.surfaceWidth / this.surfaceHeight / 2.0F;
      jxl = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
    }
    AppMethodBeat.o(89282);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(89281);
    ae.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.gOv = b.az("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.gOv == 0) {
      ae.e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, load program failed!");
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
    ae.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.jxp), Integer.valueOf(this.jxq), this });
    AppMethodBeat.o(89281);
  }
  
  public static abstract interface a
  {
    public abstract void aVW();
    
    public abstract ByteBuffer getBuffer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.i
 * JD-Core Version:    0.7.0.1
 */