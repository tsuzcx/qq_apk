package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "enableAlpha", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "(ZLcom/tencent/mm/sticker/StickerPack;)V", "TAG", "", "blendAttributePosition", "", "blendAttributeTextureCoord", "blendBitmapTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "blendEnableAlpha", "blendProgramId", "blendUniformCornerRadius", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformSize", "blendUniformUseNormalVideoTexture", "cubeBuffer", "Ljava/nio/FloatBuffer;", "currentBlendBitmap", "Landroid/graphics/Bitmap;", "detectFaceFbo", "detectFaceTexture", "inputTextureHeight", "inputTextureWidth", "isInit", "matrix", "", "removeBackground", "renderContent", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "sizeBuffer", "textureCoordBuffer", "toTextureAttributePosition", "toTextureAttributeTextureCoord", "toTextureProgramId", "toTextureSize", "toTextureUniformExternalTexture", "videoDecodeSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoDecodeTexture", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "xLabEffectOutputTexture", "drawBlendContent", "", "useNormalVideoTexture", "videoTexture", "drawWithStickerAndRemoveBackground", "getEmojiMixContent", "", "getVideoDecodeSurfaceTexture", "init", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setBlendFrame", "blendBitmap", "setRemoveBackground", "remove", "simpleDrawVideoContent", "plugin-emojicapture_release"})
public final class d
  implements GLSurfaceView.Renderer
{
  final String TAG;
  boolean csX;
  XLabEffect fVU;
  final FloatBuffer guT;
  int gvA;
  int gvB;
  private final FloatBuffer gvG;
  public int gvl;
  public int gvm;
  public Bitmap gvn;
  int gvs;
  int gvt;
  int gvu;
  int gvw;
  int gvx;
  int gvy;
  int gvz;
  boolean oLS;
  final com.tencent.mm.sticker.e oLp;
  private final boolean oRK;
  com.tencent.mm.media.f.d oRO;
  SurfaceTexture oRP;
  com.tencent.mm.media.f.d oRQ;
  int oRR;
  int oRS;
  int oRT;
  int oRU;
  int oRV;
  int oRW;
  int oRX;
  final int oRY;
  int oRZ;
  com.tencent.mm.media.f.d oSa;
  com.tencent.mm.media.f.d oSb;
  final FloatBuffer oSc;
  private final float[] oSd;
  public ByteBuffer oSe;
  
  public d(boolean paramBoolean, com.tencent.mm.sticker.e parame)
  {
    AppMethodBeat.i(852);
    this.oRK = paramBoolean;
    this.oLp = parame;
    this.TAG = "MicroMsg.EmojiCaptureMixRenderer";
    this.oRY = 640;
    parame = ByteBuffer.allocateDirect(b.gwe.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    k.g(parame, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.guT = parame;
    parame = ByteBuffer.allocateDirect(b.gwf.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    k.g(parame, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.oSc = parame;
    this.gvG = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.oSd = new float[16];
    this.oSe = ByteBuffer.allocate(this.gvl * this.gvm * 4);
    AppMethodBeat.o(852);
  }
  
  public final SurfaceTexture bYP()
  {
    AppMethodBeat.i(851);
    SurfaceTexture localSurfaceTexture = this.oRP;
    if (localSurfaceTexture == null) {
      k.aPZ("videoDecodeSurfaceTexture");
    }
    AppMethodBeat.o(851);
    return localSurfaceTexture;
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    AppMethodBeat.i(848);
    for (;;)
    {
      try
      {
        long l = bt.GC();
        paramGL10 = b.oRy;
        b.a.akz();
        paramGL10 = this.oRP;
        if (paramGL10 == null) {
          k.aPZ("videoDecodeSurfaceTexture");
        }
        paramGL10.updateTexImage();
        if ((this.oSa == null) || (this.oSb == null))
        {
          ad.i(this.TAG, "draw frame used " + bt.aS(l) + "ms");
          AppMethodBeat.o(848);
          return;
        }
        paramGL10 = b.oRy;
        j = this.oRZ;
        paramGL10 = this.oSa;
        if (paramGL10 != null)
        {
          i = paramGL10.gro;
          int k = this.oRY;
          int m = this.oRY;
          GLES20.glBindFramebuffer(36160, j);
          GLES20.glBindTexture(3553, i);
          GLES20.glTexImage2D(3553, 0, 6408, k, m, 0, 6408, 5121, null);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
          GLES20.glBindTexture(3553, 0);
          GLES20.glViewport(0, 0, this.oRY, this.oRY);
          paramGL10 = this.oRO;
          if (paramGL10 != null)
          {
            GLES20.glUseProgram(this.oRU);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, paramGL10.gro);
            GLES20.glTexParameterf(36197, 10241, 9729.0F);
            GLES20.glTexParameterf(36197, 10240, 9729.0F);
            GLES20.glTexParameterf(36197, 10242, 33071.0F);
            GLES20.glTexParameterf(36197, 10243, 33071.0F);
            GLES20.glUniform1i(this.oRX, 0);
            this.guT.position(0);
            GLES20.glVertexAttribPointer(this.oRV, 2, 5126, false, 0, (Buffer)this.guT);
            GLES20.glEnableVertexAttribArray(this.oRV);
            this.oSc.position(0);
            this.oSc.put(b.gwg);
            this.oSc.position(0);
            GLES20.glVertexAttribPointer(this.oRW, 2, 5126, false, 0, (Buffer)this.oSc);
            GLES20.glEnableVertexAttribArray(this.oRW);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.oRV);
            GLES20.glDisableVertexAttribArray(this.oRW);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindTexture(36197, 0);
            GLES20.glFinish();
          }
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glFinish();
          paramGL10 = b.oRy;
          b.a.akz();
          GLES20.glViewport(0, 0, this.oRY, this.oRY);
          paramGL10 = this.fVU;
          if (paramGL10 != null)
          {
            localObject = this.oSa;
            if (localObject == null) {
              break label1099;
            }
            i = ((com.tencent.mm.media.f.d)localObject).gro;
            XLabEffect.a(paramGL10, i);
          }
          paramGL10 = this.oSb;
          if (paramGL10 != null) {
            com.tencent.mm.media.f.d.a(paramGL10, this.oRY, this.oRY, 0, null, 0, 0, 60);
          }
          paramGL10 = this.fVU;
          if (paramGL10 != null)
          {
            localObject = this.oSa;
            if (localObject == null) {
              break label1104;
            }
            i = ((com.tencent.mm.media.f.d)localObject).gro;
            localObject = this.oSb;
            if (localObject == null) {
              break label1109;
            }
            j = ((com.tencent.mm.media.f.d)localObject).gro;
            XLabEffect.a(paramGL10, i, j, 0L, false, 60);
          }
          paramGL10 = this.oSb;
          GLES20.glFinish();
          Object localObject = b.oRy;
          b.a.akz();
          GLES20.glViewport(0, 0, this.gvl, this.gvm);
          if (paramGL10 == null) {
            continue;
          }
          GLES20.glViewport(0, 0, this.gvl, this.gvm);
          GLES20.glUseProgram(this.gvs);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(3553, paramGL10.gro);
          GLES20.glTexParameterf(3553, 10241, 9729.0F);
          GLES20.glTexParameterf(3553, 10240, 9729.0F);
          GLES20.glTexParameterf(3553, 10242, 33071.0F);
          GLES20.glTexParameterf(3553, 10243, 33071.0F);
          GLES20.glUniform1i(this.gvx, 0);
          GLES20.glUniform1i(this.gvw, 2);
          GLES20.glUniform1i(this.gvA, 1);
          j = this.oRT;
          if (!this.oRK) {
            break label1114;
          }
          i = 1;
          GLES20.glUniform1i(j, i);
          if (this.gvn == null) {
            break label1119;
          }
          GLES20.glActiveTexture(33985);
          paramGL10 = this.oRQ;
          if (paramGL10 != null)
          {
            localObject = this.gvn;
            if (localObject == null) {
              k.fvU();
            }
            com.tencent.mm.media.f.d.a(paramGL10, (Bitmap)localObject);
          }
          GLES20.glUniform1i(this.gvy, 1);
          this.guT.position(0);
          GLES20.glVertexAttribPointer(this.gvt, 2, 5126, false, 0, (Buffer)this.guT);
          GLES20.glEnableVertexAttribArray(this.gvt);
          this.oSc.position(0);
          this.oSc.put(b.gwf);
          this.oSc.position(0);
          GLES20.glVertexAttribPointer(this.gvu, 2, 5126, false, 0, (Buffer)this.oSc);
          GLES20.glEnableVertexAttribArray(this.gvu);
          this.gvG.put(this.gvl);
          this.gvG.put(this.gvm);
          this.gvG.position(0);
          GLES20.glUniform2fv(this.oRR, 1, this.gvG);
          i = this.oRS;
          paramGL10 = com.tencent.mm.plugin.emojicapture.model.d.oJY;
          GLES20.glUniform1f(i, Math.max(this.gvl, this.gvm) * 0.0666667F);
          Matrix.setIdentityM(this.oSd, 0);
          Matrix.scaleM(this.oSd, 0, 1.0F, -1.0F, 1.0F);
          GLES20.glUniformMatrix4fv(this.gvB, 1, false, this.oSd, 0);
          if (this.gvn == null) {
            break label1130;
          }
          GLES20.glUniform1i(this.gvz, 1);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(this.gvt);
          GLES20.glDisableVertexAttribArray(this.gvu);
          GLES20.glBindTexture(3553, 0);
          GLES20.glBindTexture(36197, 0);
          GLES20.glFinish();
          this.oSe.position(0);
          GLES20.glReadPixels(0, 0, this.gvl, this.gvl, 6408, 5121, (Buffer)this.oSe);
          GLES20.glUseProgram(0);
          continue;
        }
        i = 0;
      }
      catch (Exception paramGL10)
      {
        ad.printErrStackTrace(this.TAG, (Throwable)paramGL10, "EmojiCaptureMixRenderer draw frame failed", new Object[0]);
        paramGL10 = com.tencent.mm.plugin.emojicapture.model.e.oKa;
        com.tencent.mm.plugin.emojicapture.model.e.bXS();
        AppMethodBeat.o(848);
        return;
      }
      continue;
      label1099:
      int i = 0;
      continue;
      label1104:
      i = 0;
      continue;
      label1109:
      int j = 0;
      continue;
      label1114:
      i = 0;
      continue;
      label1119:
      GLES20.glUniform1i(this.gvy, 1);
      continue;
      label1130:
      GLES20.glUniform1i(this.gvz, 0);
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(849);
    ad.i(this.TAG, "onSurfaceChanged, width:" + paramInt1 + ", height:" + paramInt2);
    this.gvl = paramInt1;
    this.gvm = paramInt2;
    this.oSe = ByteBuffer.allocate(this.gvl * this.gvm * 4);
    AppMethodBeat.o(849);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(850);
    ad.i(this.TAG, "onSurfaceCreated");
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glDisable(2929);
    AppMethodBeat.o(850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.d
 * JD-Core Version:    0.7.0.1
 */