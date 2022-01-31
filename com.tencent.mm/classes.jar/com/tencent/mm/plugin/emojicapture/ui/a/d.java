package com.tencent.mm.plugin.emojicapture.ui.a;

import a.d.b.g;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.tencent.mm.plugin.emojicapture.model.c;
import com.tencent.mm.plugin.emojicapture.model.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.ttpic.PTSegment;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class d
  implements GLSurfaceView.Renderer
{
  private final String TAG = "MicroMsg.EmojiCaptureMixRenderer";
  boolean dBn;
  final FloatBuffer fwk;
  boolean jll;
  int jrA;
  int jrB;
  int jrC;
  int jrD;
  int jrE;
  int jrF;
  private final int jrG = 512;
  int jrH;
  PTSegment jrI = new PTSegment();
  final FloatBuffer jrJ;
  private final FloatBuffer jrK;
  public ByteBuffer jrL;
  public int jrj;
  public int jrk;
  public Bitmap jrl;
  int jrm;
  SurfaceTexture jrn;
  int jro;
  int jrp;
  int jrq;
  int jrr;
  int jrs;
  int jrt;
  int jru;
  int jrv;
  int jrw;
  int jrx;
  int jry;
  int jrz;
  private final float[] matrix;
  
  public d()
  {
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(b.fvS.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    g.j(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.fwk = localFloatBuffer;
    localFloatBuffer = ByteBuffer.allocateDirect(b.fvU.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    g.j(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.jrJ = localFloatBuffer;
    this.jrK = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.matrix = new float[16];
    this.jrL = ByteBuffer.allocate(this.jrj * this.jrk * 4);
  }
  
  private final void j(boolean paramBoolean, int paramInt)
  {
    GLES20.glViewport(0, 0, this.jrj, this.jrk);
    GLES20.glUseProgram(this.jrp);
    GLES20.glActiveTexture(33984);
    if (!paramBoolean)
    {
      GLES20.glBindTexture(36197, paramInt);
      GLES20.glTexParameterf(36197, 10241, 9729.0F);
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameterf(36197, 10242, 33071.0F);
      GLES20.glTexParameterf(36197, 10243, 33071.0F);
      GLES20.glUniform1i(this.jrs, 0);
      GLES20.glUniform1i(this.jrt, 2);
      int i = this.jry;
      if (!paramBoolean) {
        break label562;
      }
      paramInt = 1;
      label102:
      GLES20.glUniform1i(i, paramInt);
      if (this.jrl != null)
      {
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.jro);
        GLUtils.texImage2D(3553, 0, this.jrl, 0);
        GLES20.glGenerateMipmap(3553);
        GLES20.glTexParameterf(3553, 10241, 9987.0F);
        GLES20.glTexParameterf(3553, 10240, 9987.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
      }
      GLES20.glUniform1i(this.jru, 1);
      this.fwk.position(0);
      GLES20.glVertexAttribPointer(this.jrq, 2, 5126, false, 0, (Buffer)this.fwk);
      GLES20.glEnableVertexAttribArray(this.jrq);
      this.jrJ.position(0);
      this.jrJ.put(b.fvU);
      this.jrJ.position(0);
      GLES20.glVertexAttribPointer(this.jrr, 2, 5126, false, 0, (Buffer)this.jrJ);
      GLES20.glEnableVertexAttribArray(this.jrr);
      this.jrK.put(this.jrj);
      this.jrK.put(this.jrk);
      this.jrK.position(0);
      GLES20.glUniform2fv(this.jrv, 1, this.jrK);
      paramInt = this.jrw;
      c.a locala = c.jko;
      GLES20.glUniform1f(paramInt, Math.max(this.jrj, this.jrk) * 0.0666667F);
      Matrix.setIdentityM(this.matrix, 0);
      Matrix.scaleM(this.matrix, 0, 1.0F, -1.0F, 1.0F);
      GLES20.glUniformMatrix4fv(this.jrz, 1, false, this.matrix, 0);
      if (this.jrl == null) {
        break label567;
      }
      GLES20.glUniform1i(this.jrx, 1);
    }
    for (;;)
    {
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.jrq);
      GLES20.glDisableVertexAttribArray(this.jrr);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
      GLES20.glFinish();
      this.jrL.position(0);
      GLES20.glReadPixels(0, 0, this.jrj, this.jrj, 6408, 5121, (Buffer)this.jrL);
      GLES20.glUseProgram(0);
      return;
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.jrt, 0);
      GLES20.glUniform1i(this.jrs, 2);
      break;
      label562:
      paramInt = 0;
      break label102;
      label567:
      GLES20.glUniform1i(this.jrx, 0);
    }
  }
  
  public final SurfaceTexture aLa()
  {
    SurfaceTexture localSurfaceTexture = this.jrn;
    if (localSurfaceTexture == null) {
      g.ahh("videoDecodeSurfaceTexture");
    }
    return localSurfaceTexture;
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    long l = bk.UZ();
    paramGL10 = b.jqU;
    b.a.aKZ();
    paramGL10 = this.jrn;
    if (paramGL10 == null) {
      g.ahh("videoDecodeSurfaceTexture");
    }
    paramGL10.updateTexImage();
    if (this.jll)
    {
      paramGL10 = b.jqU;
      b.a.r(this.jrE, this.jrF, this.jrG, this.jrG);
      GLES20.glViewport(0, 0, this.jrG, this.jrG);
      int i = this.jrm;
      if (i != 0)
      {
        GLES20.glUseProgram(this.jrA);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glTexParameterf(36197, 10241, 9729.0F);
        GLES20.glTexParameterf(36197, 10240, 9729.0F);
        GLES20.glTexParameterf(36197, 10242, 33071.0F);
        GLES20.glTexParameterf(36197, 10243, 33071.0F);
        GLES20.glUniform1i(this.jrD, 0);
        this.fwk.position(0);
        GLES20.glVertexAttribPointer(this.jrB, 2, 5126, false, 0, (Buffer)this.fwk);
        GLES20.glEnableVertexAttribArray(this.jrB);
        this.jrJ.position(0);
        this.jrJ.put(b.jqT);
        this.jrJ.position(0);
        GLES20.glVertexAttribPointer(this.jrC, 2, 5126, false, 0, (Buffer)this.jrJ);
        GLES20.glEnableVertexAttribArray(this.jrC);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.jrB);
        GLES20.glDisableVertexAttribArray(this.jrC);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindTexture(36197, 0);
        GLES20.glFinish();
      }
      GLES20.glBindFramebuffer(36160, 0);
      paramGL10 = b.jqU;
      b.a.aKZ();
      GLES20.glViewport(0, 0, this.jrG, this.jrG);
      this.jrH = this.jrI.segTexture(this.jrF, 0.015F, this.jrG, this.jrG);
      paramGL10 = b.jqU;
      b.a.aKZ();
      GLES20.glViewport(0, 0, this.jrj, this.jrk);
      j(true, this.jrH);
    }
    for (;;)
    {
      y.i(this.TAG, "draw frame used " + bk.cp(l) + "ms");
      return;
      j(false, this.jrm);
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    y.i(this.TAG, "onSurfaceChanged, width:" + paramInt1 + ", height:" + paramInt2);
    this.jrj = paramInt1;
    this.jrk = paramInt2;
    this.jrL = ByteBuffer.allocate(this.jrj * this.jrk * 4);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    y.i(this.TAG, "onSurfaceCreated");
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glDisable(2929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.d
 * JD-Core Version:    0.7.0.1
 */