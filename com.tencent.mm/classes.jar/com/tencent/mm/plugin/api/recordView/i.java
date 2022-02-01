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
  static float[] laj = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] lak = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] nqU = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
  ByteBuffer buffer;
  int fSM;
  byte[] frameData;
  ByteBuffer kZC;
  private int kZI;
  ByteBuffer kZJ;
  private int kZy;
  private int ksD;
  private int ksE;
  private FloatBuffer ksa;
  FloatBuffer ksb;
  boolean lft;
  private boolean nqV;
  int nqW;
  int nqX;
  private int nqY;
  private int nqZ;
  private int nra;
  private float[] nrb;
  private boolean nrc;
  float[] nrd;
  private float[] nre;
  int nrf;
  int nsh;
  int nsi;
  private int programId;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89280);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.nqV = false;
    this.frameData = null;
    this.nqW = 0;
    this.nqX = 0;
    this.fSM = 0;
    this.nrb = new float[16];
    this.nrc = false;
    this.nrd = laj;
    Object localObject = lak;
    this.nre = Arrays.copyOf((float[])localObject, localObject.length);
    this.lft = false;
    this.nrf = 0;
    this.nsh = 0;
    this.nsi = 0;
    this.buffer = null;
    this.nsh = b.aVC();
    localObject = new int[1];
    GLES20.glGenFramebuffers(1, (int[])localObject, 0);
    if (localObject[0] == 0) {
      Log.e("MicroMsg.MMSightCameraGLUtil", "gen frame buffer error");
    }
    for (int i = 0;; i = localObject[0])
    {
      this.nsi = i;
      GLES20.glBindFramebuffer(36160, this.nsi);
      GLES20.glBindTexture(3553, this.nsh);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.nsh, 0);
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
    this.nqV = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.nrc)
    {
      Log.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "clearFrameRequest");
      this.nrc = false;
      this.nqV = false;
      this.frameData = null;
      this.nqW = -1;
      this.nqX = -1;
      AppMethodBeat.o(89283);
      return;
    }
    int i;
    if ((this.programId != 0) && (this.nqY != -1) && (this.nqZ != -1) && (this.nqW > 0) && (this.nqX > 0) && (this.frameData != null))
    {
      GLES20.glBindFramebuffer(36160, this.nsi);
      GLES20.glBindTexture(3553, this.nsh);
      GLES20.glTexImage2D(3553, 0, 6408, this.surfaceWidth, this.surfaceHeight, 0, 6408, 5121, null);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.nsh, 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
      GLES20.glUseProgram(this.programId);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.nqY);
      GLES20.glTexImage2D(3553, 0, 6409, this.nqW, this.nqX, 0, 6409, 5121, this.kZC);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.kZy, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.nqZ);
      GLES20.glTexImage2D(3553, 0, 6410, this.nqW / 2, this.nqX / 2, 0, 6410, 5121, this.kZJ);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.kZI, 1);
      Matrix.setIdentityM(this.nrb, 0);
      i = this.fSM;
      if ((this.nrf != 90) && (this.nrf != 270)) {
        break label713;
      }
      i = (this.fSM - this.nrf + 360 + 180) % 360;
    }
    label713:
    for (;;)
    {
      Matrix.setRotateM(this.nrb, 0, i, 0.0F, 0.0F, -1.0F);
      if ((this.fSM == 90) || (this.fSM == 270)) {
        Matrix.scaleM(this.nrb, 0, -1.0F, 1.0F, 1.0F);
      }
      for (;;)
      {
        GLES20.glUniformMatrix4fv(this.nra, 1, false, this.nrb, 0);
        this.ksb.position(0);
        GLES20.glVertexAttribPointer(this.ksD, 2, 5126, false, 0, this.ksb);
        GLES20.glEnableVertexAttribArray(this.ksD);
        this.ksa.position(0);
        GLES20.glVertexAttribPointer(this.ksE, 2, 5126, false, 0, this.ksa);
        GLES20.glEnableVertexAttribArray(this.ksE);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.ksD);
        GLES20.glDisableVertexAttribArray(this.ksE);
        GLES20.glBindTexture(3553, 0);
        GLES20.glFinish();
        this.buffer.position(0);
        GLES20.glReadPixels(0, 0, this.surfaceWidth, this.surfaceHeight, 6408, 5121, this.buffer);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        this.nqV = false;
        Log.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "time cost : %d", new Object[] { Long.valueOf(Util.ticksToNow(Util.currentTicks())) });
        AppMethodBeat.o(89283);
        return;
        Matrix.scaleM(this.nrb, 0, 1.0F, -1.0F, 1.0F);
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
      nqU = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
    }
    AppMethodBeat.o(89282);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(89281);
    Log.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.programId = b.aE("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.programId == 0) {
      Log.e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, load program failed!");
    }
    this.ksD = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.ksE = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.kZy = GLES20.glGetUniformLocation(this.programId, "y_texture");
    this.kZI = GLES20.glGetUniformLocation(this.programId, "uv_texture");
    this.nra = GLES20.glGetUniformLocation(this.programId, "uMatrix");
    this.nqY = b.aVC();
    this.nqZ = b.aVC();
    this.ksb = ByteBuffer.allocateDirect(this.nrd.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.ksb.put(this.nrd);
    this.ksb.position(0);
    this.ksa = ByteBuffer.allocateDirect(lak.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.ksa.put(lak);
    this.ksa.position(0);
    Log.i("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.nqY), Integer.valueOf(this.nqZ), this });
    AppMethodBeat.o(89281);
  }
  
  public static abstract interface a
  {
    public abstract void bBI();
    
    public abstract ByteBuffer getBuffer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.i
 * JD-Core Version:    0.7.0.1
 */