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
  static float[] ilm = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] iln = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] kxU = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
  ByteBuffer buffer;
  int dYT;
  byte[] frameData;
  private FloatBuffer hDT;
  FloatBuffer hDU;
  private int hEy;
  private int hEz;
  private int ikE;
  ByteBuffer ikI;
  private int ikO;
  ByteBuffer ikP;
  boolean iqo;
  private boolean kxV;
  int kxW;
  int kxX;
  private int kxY;
  private int kxZ;
  private int kya;
  private float[] kyb;
  private boolean kyc;
  float[] kyd;
  private float[] kye;
  int kyf;
  int kzh;
  int kzi;
  private int programId;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89280);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.kxV = false;
    this.frameData = null;
    this.kxW = 0;
    this.kxX = 0;
    this.dYT = 0;
    this.kyb = new float[16];
    this.kyc = false;
    this.kyd = ilm;
    Object localObject = iln;
    this.kye = Arrays.copyOf((float[])localObject, localObject.length);
    this.iqo = false;
    this.kyf = 0;
    this.kzh = 0;
    this.kzi = 0;
    this.buffer = null;
    this.kzh = b.aMZ();
    localObject = new int[1];
    GLES20.glGenFramebuffers(1, (int[])localObject, 0);
    if (localObject[0] == 0) {
      Log.e("MicroMsg.MMSightCameraGLUtil", "gen frame buffer error");
    }
    for (int i = 0;; i = localObject[0])
    {
      this.kzi = i;
      GLES20.glBindFramebuffer(36160, this.kzi);
      GLES20.glBindTexture(3553, this.kzh);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.kzh, 0);
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
    this.kxV = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.kyc)
    {
      Log.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "clearFrameRequest");
      this.kyc = false;
      this.kxV = false;
      this.frameData = null;
      this.kxW = -1;
      this.kxX = -1;
      AppMethodBeat.o(89283);
      return;
    }
    int i;
    if ((this.programId != 0) && (this.kxY != -1) && (this.kxZ != -1) && (this.kxW > 0) && (this.kxX > 0) && (this.frameData != null))
    {
      GLES20.glBindFramebuffer(36160, this.kzi);
      GLES20.glBindTexture(3553, this.kzh);
      GLES20.glTexImage2D(3553, 0, 6408, this.surfaceWidth, this.surfaceHeight, 0, 6408, 5121, null);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.kzh, 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
      GLES20.glUseProgram(this.programId);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.kxY);
      GLES20.glTexImage2D(3553, 0, 6409, this.kxW, this.kxX, 0, 6409, 5121, this.ikI);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.ikE, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.kxZ);
      GLES20.glTexImage2D(3553, 0, 6410, this.kxW / 2, this.kxX / 2, 0, 6410, 5121, this.ikP);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.ikO, 1);
      Matrix.setIdentityM(this.kyb, 0);
      i = this.dYT;
      if ((this.kyf != 90) && (this.kyf != 270)) {
        break label713;
      }
      i = (this.dYT - this.kyf + 360 + 180) % 360;
    }
    label713:
    for (;;)
    {
      Matrix.setRotateM(this.kyb, 0, i, 0.0F, 0.0F, -1.0F);
      if ((this.dYT == 90) || (this.dYT == 270)) {
        Matrix.scaleM(this.kyb, 0, -1.0F, 1.0F, 1.0F);
      }
      for (;;)
      {
        GLES20.glUniformMatrix4fv(this.kya, 1, false, this.kyb, 0);
        this.hDU.position(0);
        GLES20.glVertexAttribPointer(this.hEy, 2, 5126, false, 0, this.hDU);
        GLES20.glEnableVertexAttribArray(this.hEy);
        this.hDT.position(0);
        GLES20.glVertexAttribPointer(this.hEz, 2, 5126, false, 0, this.hDT);
        GLES20.glEnableVertexAttribArray(this.hEz);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.hEy);
        GLES20.glDisableVertexAttribArray(this.hEz);
        GLES20.glBindTexture(3553, 0);
        GLES20.glFinish();
        this.buffer.position(0);
        GLES20.glReadPixels(0, 0, this.surfaceWidth, this.surfaceHeight, 6408, 5121, this.buffer);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        this.kxV = false;
        Log.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "time cost : %d", new Object[] { Long.valueOf(Util.ticksToNow(Util.currentTicks())) });
        AppMethodBeat.o(89283);
        return;
        Matrix.scaleM(this.kyb, 0, 1.0F, -1.0F, 1.0F);
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
      kxU = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
    }
    AppMethodBeat.o(89282);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(89281);
    Log.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.programId = b.aB("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.programId == 0) {
      Log.e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, load program failed!");
    }
    this.hEy = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.hEz = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.ikE = GLES20.glGetUniformLocation(this.programId, "y_texture");
    this.ikO = GLES20.glGetUniformLocation(this.programId, "uv_texture");
    this.kya = GLES20.glGetUniformLocation(this.programId, "uMatrix");
    this.kxY = b.aMZ();
    this.kxZ = b.aMZ();
    this.hDU = ByteBuffer.allocateDirect(this.kyd.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.hDU.put(this.kyd);
    this.hDU.position(0);
    this.hDT = ByteBuffer.allocateDirect(iln.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.hDT.put(iln);
    this.hDT.position(0);
    Log.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.kxY), Integer.valueOf(this.kxZ), this });
    AppMethodBeat.o(89281);
  }
  
  public static abstract interface a
  {
    public abstract void bqT();
    
    public abstract ByteBuffer getBuffer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.i
 * JD-Core Version:    0.7.0.1
 */