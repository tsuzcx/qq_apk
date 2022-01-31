package com.tencent.mm.plugin.emojicapture.ui.b;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.PTSegment;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "()V", "TAG", "", "blendAttributePosition", "", "blendAttributeTextureCoord", "blendBitmapTexture", "blendProgramId", "blendUniformCornerRadius", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformSize", "blendUniformUseNormalVideoTexture", "cubeBuffer", "Ljava/nio/FloatBuffer;", "currentBlendBitmap", "Landroid/graphics/Bitmap;", "inputTextureHeight", "inputTextureWidth", "isInit", "", "matrix", "", "ptFaceDetector", "Lcom/tencent/mm/ptsdk/PTFaceDetectorProcess;", "ptFaceFrame", "Lcom/tencent/filter/Frame;", "ptSegment", "Lcom/tencent/ttpic/PTSegment;", "removeBackground", "renderContent", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "segOutputTexture", "sizeBuffer", "stickerOutTexture", "textureCoordBuffer", "toTextureAttributePosition", "toTextureAttributeTextureCoord", "toTextureFramebuffer", "toTextureOutputTexture", "toTextureProgramId", "toTextureSize", "toTextureUniformExternalTexture", "videoDecodeSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoDecodeTexture", "changeVideoFilter", "", "path", "drawBlendContent", "useNormalVideoTexture", "videoTexture", "drawWithRemoveBackground", "drawWithStickerAndRemoveBackground", "getEmojiMixContent", "", "getVideoDecodeSurfaceTexture", "init", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setBlendFrame", "blendBitmap", "setRemoveBackground", "remove", "simpleDrawVideoContent", "plugin-emojicapture_release"})
public final class e
  implements GLSurfaceView.Renderer
{
  final String TAG;
  boolean bRB;
  public int eYJ;
  public int eYK;
  public Bitmap eYL;
  int eYM;
  int eYN;
  int eYO;
  int eYP;
  int eYQ;
  int eYR;
  int eYS;
  int eYT;
  int eYU;
  int eYV;
  private final FloatBuffer eYW;
  final FloatBuffer eYv;
  int lAW;
  SurfaceTexture lAX;
  int lAY;
  int lAZ;
  int lBa;
  int lBb;
  int lBc;
  int lBd;
  int lBe;
  int lBf;
  final int lBg;
  int lBh;
  a lBi;
  PTSegment lBj;
  h lBk;
  int lBl;
  final FloatBuffer lBm;
  public ByteBuffer lBn;
  boolean lva;
  private final float[] matrix;
  
  public e()
  {
    AppMethodBeat.i(3171);
    this.TAG = "MicroMsg.EmojiCaptureMixRenderer";
    this.lBg = 640;
    this.lBi = new a((byte)0);
    this.lBj = new PTSegment();
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(c.eZq.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    j.p(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.eYv = localFloatBuffer;
    localFloatBuffer = ByteBuffer.allocateDirect(c.eZr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    j.p(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.lBm = localFloatBuffer;
    this.eYW = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.matrix = new float[16];
    this.lBn = ByteBuffer.allocate(this.eYJ * this.eYK * 4);
    AppMethodBeat.o(3171);
  }
  
  public final SurfaceTexture bpk()
  {
    AppMethodBeat.i(3170);
    SurfaceTexture localSurfaceTexture = this.lAX;
    if (localSurfaceTexture == null) {
      j.ays("videoDecodeSurfaceTexture");
    }
    AppMethodBeat.o(3170);
    return localSurfaceTexture;
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    AppMethodBeat.i(3167);
    for (;;)
    {
      try
      {
        long l = bo.yB();
        paramGL10 = c.lAH;
        c.a.Vo();
        paramGL10 = this.lAX;
        if (paramGL10 == null) {
          j.ays("videoDecodeSurfaceTexture");
        }
        paramGL10.updateTexImage();
        boolean bool = this.lva;
        paramGL10 = c.lAH;
        paramGL10 = this.lBk;
        if (paramGL10 == null) {
          j.ays("ptFaceFrame");
        }
        int i = paramGL10.tM();
        paramGL10 = this.lBk;
        if (paramGL10 == null) {
          j.ays("ptFaceFrame");
        }
        int j = paramGL10.getTextureId();
        paramGL10 = this.lBk;
        if (paramGL10 == null) {
          j.ays("ptFaceFrame");
        }
        int k = paramGL10.width;
        paramGL10 = this.lBk;
        if (paramGL10 == null) {
          j.ays("ptFaceFrame");
        }
        c.a.r(i, j, k, paramGL10.height);
        GLES20.glViewport(0, 0, this.lBg, this.lBg);
        i = this.lAW;
        if (i != 0)
        {
          GLES20.glUseProgram(this.lBa);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, i);
          GLES20.glTexParameterf(36197, 10241, 9729.0F);
          GLES20.glTexParameterf(36197, 10240, 9729.0F);
          GLES20.glTexParameterf(36197, 10242, 33071.0F);
          GLES20.glTexParameterf(36197, 10243, 33071.0F);
          GLES20.glUniform1i(this.lBd, 0);
          this.eYv.position(0);
          GLES20.glVertexAttribPointer(this.lBb, 2, 5126, false, 0, (Buffer)this.eYv);
          GLES20.glEnableVertexAttribArray(this.lBb);
          this.lBm.position(0);
          this.lBm.put(c.eZs);
          this.lBm.position(0);
          GLES20.glVertexAttribPointer(this.lBc, 2, 5126, false, 0, (Buffer)this.lBm);
          GLES20.glEnableVertexAttribArray(this.lBc);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(this.lBb);
          GLES20.glDisableVertexAttribArray(this.lBc);
          GLES20.glBindTexture(3553, 0);
          GLES20.glBindTexture(36197, 0);
          GLES20.glFinish();
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glFinish();
        paramGL10 = c.lAH;
        c.a.Vo();
        GLES20.glViewport(0, 0, this.lBg, this.lBg);
        paramGL10 = this.lBk;
        if (paramGL10 == null) {
          j.ays("ptFaceFrame");
        }
        if (bool)
        {
          Object localObject = this.lBi;
          h localh = this.lBk;
          if (localh == null) {
            j.ays("ptFaceFrame");
          }
          localObject = a.a((a)localObject, localh, true, true, 0, 16);
          if (localObject != null) {
            if (((PTFaceAttr)localObject).getOrigFrame() != null)
            {
              paramGL10 = ((PTFaceAttr)localObject).getOrigFrame();
              j.p(paramGL10, "faceAttr.origFrame");
              try
              {
                localObject = this.lBj.segTexture((PTFaceAttr)localObject, paramGL10, 0.015F, this.lBg, this.lBg);
                j.p(localObject, "ptSegment.segTexture(fac…xtureSize, toTextureSize)");
                paramGL10 = (GL10)localObject;
              }
              catch (Exception localException)
              {
                d locald = d.ltx;
                d.bol();
                continue;
                GLES20.glUniform1i(this.eYT, 0);
                continue;
              }
              localObject = c.lAH;
              c.a.Vo();
              GLES20.glFinish();
              GLES20.glViewport(0, 0, this.eYJ, this.eYK);
              i = paramGL10.getTextureId();
              GLES20.glViewport(0, 0, this.eYJ, this.eYK);
              GLES20.glUseProgram(this.eYN);
              GLES20.glActiveTexture(33984);
              GLES20.glBindTexture(3553, i);
              GLES20.glTexParameterf(3553, 10241, 9729.0F);
              GLES20.glTexParameterf(3553, 10240, 9729.0F);
              GLES20.glTexParameterf(3553, 10242, 33071.0F);
              GLES20.glTexParameterf(3553, 10243, 33071.0F);
              GLES20.glUniform1i(this.eYR, 0);
              GLES20.glUniform1i(this.eYQ, 2);
              GLES20.glUniform1i(this.eYU, 1);
              if (this.eYL != null)
              {
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, this.eYM);
                GLUtils.texImage2D(3553, 0, this.eYL, 0);
                GLES20.glGenerateMipmap(3553);
                GLES20.glTexParameterf(3553, 10241, 9987.0F);
                GLES20.glTexParameterf(3553, 10240, 9987.0F);
                GLES20.glTexParameterf(3553, 10242, 33071.0F);
                GLES20.glTexParameterf(3553, 10243, 33071.0F);
              }
              GLES20.glUniform1i(this.eYS, 1);
              this.eYv.position(0);
              GLES20.glVertexAttribPointer(this.eYO, 2, 5126, false, 0, (Buffer)this.eYv);
              GLES20.glEnableVertexAttribArray(this.eYO);
              this.lBm.position(0);
              this.lBm.put(c.eZr);
              this.lBm.position(0);
              GLES20.glVertexAttribPointer(this.eYP, 2, 5126, false, 0, (Buffer)this.lBm);
              GLES20.glEnableVertexAttribArray(this.eYP);
              this.eYW.put(this.eYJ);
              this.eYW.put(this.eYK);
              this.eYW.position(0);
              GLES20.glUniform2fv(this.lAY, 1, this.eYW);
              i = this.lAZ;
              paramGL10 = com.tencent.mm.plugin.emojicapture.model.c.ltu;
              GLES20.glUniform1f(i, Math.max(this.eYJ, this.eYK) * 0.0666667F);
              Matrix.setIdentityM(this.matrix, 0);
              Matrix.scaleM(this.matrix, 0, 1.0F, -1.0F, 1.0F);
              GLES20.glUniformMatrix4fv(this.eYV, 1, false, this.matrix, 0);
              if (this.eYL != null)
              {
                GLES20.glUniform1i(this.eYT, 1);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(this.eYO);
                GLES20.glDisableVertexAttribArray(this.eYP);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindTexture(36197, 0);
                GLES20.glFinish();
                this.lBn.position(0);
                GLES20.glReadPixels(0, 0, this.eYJ, this.eYJ, 6408, 5121, (Buffer)this.lBn);
                GLES20.glUseProgram(0);
                ab.i(this.TAG, "draw frame used " + bo.av(l) + "ms");
                AppMethodBeat.o(3167);
                return;
              }
            }
          }
        }
      }
      catch (Exception paramGL10)
      {
        ab.printErrStackTrace(this.TAG, (Throwable)paramGL10, "EmojiCaptureMixRenderer draw frame failed", new Object[0]);
        paramGL10 = d.ltx;
        d.bof();
        AppMethodBeat.o(3167);
        return;
      }
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3168);
    ab.i(this.TAG, "onSurfaceChanged, width:" + paramInt1 + ", height:" + paramInt2);
    this.eYJ = paramInt1;
    this.eYK = paramInt2;
    this.lBn = ByteBuffer.allocate(this.eYJ * this.eYK * 4);
    AppMethodBeat.o(3168);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(3169);
    ab.i(this.TAG, "onSurfaceCreated");
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glDisable(2929);
    AppMethodBeat.o(3169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.e
 * JD-Core Version:    0.7.0.1
 */