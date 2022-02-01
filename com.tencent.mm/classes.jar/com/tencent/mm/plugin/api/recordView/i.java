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
  static float[] gwe = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] gwf = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] iBg = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
  ByteBuffer buffer;
  int dwp;
  byte[] frameData;
  boolean gBu;
  private FloatBuffer guS;
  FloatBuffer guT;
  private int gvL;
  private int gvM;
  private int gvN;
  private int gvW;
  private int gvX;
  ByteBuffer gvZ;
  ByteBuffer gwa;
  private boolean iBh;
  int iBi;
  int iBj;
  private int iBk;
  private int iBl;
  private int iBm;
  private float[] iBn;
  private boolean iBo;
  float[] iBp;
  private float[] iBq;
  int iBr;
  int iCu;
  int iCv;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89280);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.iBh = false;
    this.frameData = null;
    this.iBi = 0;
    this.iBj = 0;
    this.dwp = 0;
    this.iBn = new float[16];
    this.iBo = false;
    this.iBp = gwe;
    Object localObject = gwf;
    this.iBq = Arrays.copyOf((float[])localObject, localObject.length);
    this.gBu = false;
    this.iBr = 0;
    this.iCu = 0;
    this.iCv = 0;
    this.buffer = null;
    this.iCu = b.akA();
    localObject = new int[1];
    GLES20.glGenFramebuffers(1, (int[])localObject, 0);
    if (localObject[0] == 0) {
      ad.e("MicroMsg.MMSightCameraGLUtil", "gen frame buffer error");
    }
    for (int i = 0;; i = localObject[0])
    {
      this.iCv = i;
      GLES20.glBindFramebuffer(36160, this.iCv);
      GLES20.glBindTexture(3553, this.iCu);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.iCu, 0);
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
    bt.GC();
    this.iBh = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.iBo)
    {
      ad.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "clearFrameRequest");
      this.iBo = false;
      this.iBh = false;
      this.frameData = null;
      this.iBi = -1;
      this.iBj = -1;
      AppMethodBeat.o(89283);
      return;
    }
    int i;
    if ((this.gvL != 0) && (this.iBk != -1) && (this.iBl != -1) && (this.iBi > 0) && (this.iBj > 0) && (this.frameData != null))
    {
      GLES20.glBindFramebuffer(36160, this.iCv);
      GLES20.glBindTexture(3553, this.iCu);
      GLES20.glTexImage2D(3553, 0, 6408, this.surfaceWidth, this.surfaceHeight, 0, 6408, 5121, null);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.iCu, 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
      GLES20.glUseProgram(this.gvL);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.iBk);
      GLES20.glTexImage2D(3553, 0, 6409, this.iBi, this.iBj, 0, 6409, 5121, this.gvZ);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.gvW, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.iBl);
      GLES20.glTexImage2D(3553, 0, 6410, this.iBi / 2, this.iBj / 2, 0, 6410, 5121, this.gwa);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.gvX, 1);
      Matrix.setIdentityM(this.iBn, 0);
      i = this.dwp;
      if ((this.iBr != 90) && (this.iBr != 270)) {
        break label713;
      }
      i = (this.dwp - this.iBr + 360 + 180) % 360;
    }
    label713:
    for (;;)
    {
      Matrix.setRotateM(this.iBn, 0, i, 0.0F, 0.0F, -1.0F);
      if ((this.dwp == 90) || (this.dwp == 270)) {
        Matrix.scaleM(this.iBn, 0, -1.0F, 1.0F, 1.0F);
      }
      for (;;)
      {
        GLES20.glUniformMatrix4fv(this.iBm, 1, false, this.iBn, 0);
        this.guT.position(0);
        GLES20.glVertexAttribPointer(this.gvM, 2, 5126, false, 0, this.guT);
        GLES20.glEnableVertexAttribArray(this.gvM);
        this.guS.position(0);
        GLES20.glVertexAttribPointer(this.gvN, 2, 5126, false, 0, this.guS);
        GLES20.glEnableVertexAttribArray(this.gvN);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.gvM);
        GLES20.glDisableVertexAttribArray(this.gvN);
        GLES20.glBindTexture(3553, 0);
        GLES20.glFinish();
        this.buffer.position(0);
        GLES20.glReadPixels(0, 0, this.surfaceWidth, this.surfaceHeight, 6408, 5121, this.buffer);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        this.iBh = false;
        ad.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "time cost : %d", new Object[] { Long.valueOf(bt.aS(bt.GC())) });
        AppMethodBeat.o(89283);
        return;
        Matrix.scaleM(this.iBn, 0, 1.0F, -1.0F, 1.0F);
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
      iBg = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
    }
    AppMethodBeat.o(89282);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(89281);
    ad.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.gvL = b.ap("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.gvL == 0) {
      ad.e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, load program failed!");
    }
    this.gvM = GLES20.glGetAttribLocation(this.gvL, "a_position");
    this.gvN = GLES20.glGetAttribLocation(this.gvL, "a_texCoord");
    this.gvW = GLES20.glGetUniformLocation(this.gvL, "y_texture");
    this.gvX = GLES20.glGetUniformLocation(this.gvL, "uv_texture");
    this.iBm = GLES20.glGetUniformLocation(this.gvL, "uMatrix");
    this.iBk = b.akA();
    this.iBl = b.akA();
    this.guT = ByteBuffer.allocateDirect(this.iBp.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.guT.put(this.iBp);
    this.guT.position(0);
    this.guS = ByteBuffer.allocateDirect(gwf.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.guS.put(gwf);
    this.guS.position(0);
    ad.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.iBk), Integer.valueOf(this.iBl), this });
    AppMethodBeat.o(89281);
  }
  
  public static abstract interface a
  {
    public abstract void aLu();
    
    public abstract ByteBuffer getBuffer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.i
 * JD-Core Version:    0.7.0.1
 */