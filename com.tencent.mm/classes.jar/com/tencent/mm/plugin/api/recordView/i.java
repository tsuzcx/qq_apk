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

public final class i
  implements GLSurfaceView.Renderer
{
  static float[] nFt = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] nFu = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] qpB = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
  ByteBuffer buffer;
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
  private boolean qpC;
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
  int qqM;
  int qqN;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89280);
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
    Object localObject = nFu;
    this.qpL = Arrays.copyOf((float[])localObject, localObject.length);
    this.nKe = false;
    this.qpM = 0;
    this.qqM = 0;
    this.qqN = 0;
    this.buffer = null;
    this.qqM = b.bql();
    localObject = new int[1];
    GLES20.glGenFramebuffers(1, (int[])localObject, 0);
    if (localObject[0] == 0) {
      Log.e("MicroMsg.MMSightCameraGLUtil", "gen frame buffer error");
    }
    for (int i = 0;; i = localObject[0])
    {
      this.qqN = i;
      GLES20.glBindFramebuffer(36160, this.qqN);
      GLES20.glBindTexture(3553, this.qqM);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.qqM, 0);
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
    Util.currentTicks();
    this.qpC = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.qpJ)
    {
      Log.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "clearFrameRequest");
      this.qpJ = false;
      this.qpC = false;
      this.frameData = null;
      this.qpD = -1;
      this.qpE = -1;
      AppMethodBeat.o(89283);
      return;
    }
    int i;
    if ((this.programId != 0) && (this.qpF != -1) && (this.qpG != -1) && (this.qpD > 0) && (this.qpE > 0) && (this.frameData != null))
    {
      GLES20.glBindFramebuffer(36160, this.qqN);
      GLES20.glBindTexture(3553, this.qqM);
      GLES20.glTexImage2D(3553, 0, 6408, this.surfaceWidth, this.surfaceHeight, 0, 6408, 5121, null);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.qqM, 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
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
        break label713;
      }
      i = (this.hYK - this.qpM + 360 + 180) % 360;
    }
    label713:
    for (;;)
    {
      Matrix.setRotateM(this.qpI, 0, i, 0.0F, 0.0F, -1.0F);
      if ((this.hYK == 90) || (this.hYK == 270)) {
        Matrix.scaleM(this.qpI, 0, -1.0F, 1.0F, 1.0F);
      }
      for (;;)
      {
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
        GLES20.glFinish();
        this.buffer.position(0);
        GLES20.glReadPixels(0, 0, this.surfaceWidth, this.surfaceHeight, 6408, 5121, this.buffer);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        this.qpC = false;
        Log.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "time cost : %d", new Object[] { Long.valueOf(Util.ticksToNow(Util.currentTicks())) });
        AppMethodBeat.o(89283);
        return;
        Matrix.scaleM(this.qpI, 0, 1.0F, -1.0F, 1.0F);
      }
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89282);
    Log.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.surfaceWidth) || (paramInt2 != this.surfaceHeight))
    {
      Log.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
      float f = this.surfaceWidth / this.surfaceHeight / 2.0F;
      qpB = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
    }
    AppMethodBeat.o(89282);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(89281);
    Log.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.programId = b.aN("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.programId == 0) {
      Log.e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, load program failed!");
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
    Log.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.qpF), Integer.valueOf(this.qpG), this });
    AppMethodBeat.o(89281);
  }
  
  public static abstract interface a
  {
    public abstract void cbc();
    
    public abstract ByteBuffer getBuffer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.i
 * JD-Core Version:    0.7.0.1
 */