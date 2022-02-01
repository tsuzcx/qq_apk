package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sticker.f;
import d.g.b.p;
import d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "enableAlpha", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "(ZLcom/tencent/mm/sticker/StickerPack;)V", "TAG", "", "blendAttributePosition", "", "blendAttributeTextureCoord", "blendBitmapTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "blendEnableAlpha", "blendProgramId", "blendUniformCornerRadius", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformSize", "blendUniformUseNormalVideoTexture", "cubeBuffer", "Ljava/nio/FloatBuffer;", "currentBlendBitmap", "Landroid/graphics/Bitmap;", "detectFaceFbo", "detectFaceTexture", "firstFrame", "inputTextureHeight", "inputTextureWidth", "isInit", "matrix", "", "removeBackground", "renderContent", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "sizeBuffer", "textureCoordBuffer", "toTextureAttributePosition", "toTextureAttributeTextureCoord", "toTextureProgramId", "toTextureSize", "toTextureUniformExternalTexture", "videoDecodeSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoDecodeTexture", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "xLabEffectOutputTexture", "drawBlendContent", "", "useNormalVideoTexture", "videoTexture", "drawWithStickerAndRemoveBackground", "getEmojiMixContent", "", "getVideoDecodeSurfaceTexture", "init", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setBlendFrame", "blendBitmap", "setRemoveBackground", "remove", "simpleDrawVideoContent", "plugin-emojicapture_release"})
public final class d
  implements GLSurfaceView.Renderer
{
  final String TAG;
  boolean cAX;
  final FloatBuffer gLm;
  com.tencent.mm.plugin.xlabeffect.b gtl;
  private boolean hlh;
  public int hnO;
  public int hnP;
  public Bitmap hnQ;
  int hnV;
  int hnW;
  int hnX;
  int hnZ;
  int hoa;
  int hob;
  int hoc;
  int hod;
  int hoe;
  private final FloatBuffer hoj;
  boolean pSN;
  final f pSk;
  private final boolean pYB;
  com.tencent.mm.media.g.d pYF;
  SurfaceTexture pYG;
  com.tencent.mm.media.g.d pYH;
  int pYI;
  int pYJ;
  int pYK;
  int pYL;
  int pYM;
  int pYN;
  int pYO;
  final int pYP;
  int pYQ;
  com.tencent.mm.media.g.d pYR;
  com.tencent.mm.media.g.d pYS;
  final FloatBuffer pYT;
  private final float[] pYU;
  public ByteBuffer pYV;
  
  public d(boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(852);
    this.pYB = paramBoolean;
    this.pSk = paramf;
    this.TAG = "MicroMsg.EmojiCaptureMixRenderer";
    this.pYP = 640;
    paramf = ByteBuffer.allocateDirect(b.hoI.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(paramf, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.gLm = paramf;
    paramf = ByteBuffer.allocateDirect(b.hoJ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(paramf, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.pYT = paramf;
    this.hoj = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.pYU = new float[16];
    this.hlh = true;
    this.pYV = ByteBuffer.allocate(this.hnO * this.hnP * 4);
    AppMethodBeat.o(852);
  }
  
  public final SurfaceTexture ckE()
  {
    AppMethodBeat.i(851);
    SurfaceTexture localSurfaceTexture = this.pYG;
    if (localSurfaceTexture == null) {
      p.bcb("videoDecodeSurfaceTexture");
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
        long l = bt.HI();
        paramGL10 = b.pYp;
        b.a.aug();
        paramGL10 = this.pYG;
        if (paramGL10 == null) {
          p.bcb("videoDecodeSurfaceTexture");
        }
        paramGL10.updateTexImage();
        if ((this.pYR == null) || (this.pYS == null))
        {
          ad.i(this.TAG, "draw frame used " + bt.aO(l) + "ms");
          AppMethodBeat.o(848);
          return;
        }
        paramGL10 = b.pYp;
        j = this.pYQ;
        paramGL10 = this.pYR;
        if (paramGL10 != null)
        {
          i = paramGL10.hko;
          int k = this.pYP;
          int m = this.pYP;
          GLES20.glBindFramebuffer(36160, j);
          GLES20.glBindTexture(3553, i);
          GLES20.glTexImage2D(3553, 0, 6408, k, m, 0, 6408, 5121, null);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
          GLES20.glBindTexture(3553, 0);
          GLES20.glViewport(0, 0, this.pYP, this.pYP);
          paramGL10 = this.pYF;
          if (paramGL10 != null)
          {
            GLES20.glUseProgram(this.pYL);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, paramGL10.hko);
            GLES20.glTexParameterf(36197, 10241, 9729.0F);
            GLES20.glTexParameterf(36197, 10240, 9729.0F);
            GLES20.glTexParameterf(36197, 10242, 33071.0F);
            GLES20.glTexParameterf(36197, 10243, 33071.0F);
            GLES20.glUniform1i(this.pYO, 0);
            this.gLm.position(0);
            GLES20.glVertexAttribPointer(this.pYM, 2, 5126, false, 0, (Buffer)this.gLm);
            GLES20.glEnableVertexAttribArray(this.pYM);
            this.pYT.position(0);
            this.pYT.put(b.hoK);
            this.pYT.position(0);
            GLES20.glVertexAttribPointer(this.pYN, 2, 5126, false, 0, (Buffer)this.pYT);
            GLES20.glEnableVertexAttribArray(this.pYN);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.pYM);
            GLES20.glDisableVertexAttribArray(this.pYN);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindTexture(36197, 0);
            GLES20.glFinish();
          }
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glFinish();
          paramGL10 = b.pYp;
          b.a.aug();
          GLES20.glViewport(0, 0, this.pYP, this.pYP);
          paramGL10 = this.gtl;
          if (paramGL10 != null)
          {
            localObject = this.pYR;
            if (localObject == null) {
              break label1141;
            }
            i = ((com.tencent.mm.media.g.d)localObject).hko;
            com.tencent.mm.plugin.xlabeffect.b.a(paramGL10, i);
          }
          if (this.hlh)
          {
            this.hlh = false;
            paramGL10 = this.gtl;
            if (paramGL10 != null)
            {
              localObject = this.pYR;
              if (localObject == null) {
                break label1146;
              }
              i = ((com.tencent.mm.media.g.d)localObject).hko;
              com.tencent.mm.plugin.xlabeffect.b.a(paramGL10, i);
            }
          }
          paramGL10 = this.pYS;
          if (paramGL10 != null) {
            com.tencent.mm.media.g.d.a(paramGL10, this.pYP, this.pYP, 0, null, 0, 0, 60);
          }
          paramGL10 = this.gtl;
          if (paramGL10 != null)
          {
            localObject = this.pYR;
            if (localObject == null) {
              break label1151;
            }
            i = ((com.tencent.mm.media.g.d)localObject).hko;
            localObject = this.pYS;
            if (localObject == null) {
              break label1156;
            }
            j = ((com.tencent.mm.media.g.d)localObject).hko;
            com.tencent.mm.plugin.xlabeffect.b.a(paramGL10, i, j, false, 60);
          }
          paramGL10 = this.pYS;
          GLES20.glFinish();
          Object localObject = b.pYp;
          b.a.aug();
          GLES20.glViewport(0, 0, this.hnO, this.hnP);
          if (paramGL10 == null) {
            continue;
          }
          GLES20.glViewport(0, 0, this.hnO, this.hnP);
          GLES20.glUseProgram(this.hnV);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(3553, paramGL10.hko);
          GLES20.glTexParameterf(3553, 10241, 9729.0F);
          GLES20.glTexParameterf(3553, 10240, 9729.0F);
          GLES20.glTexParameterf(3553, 10242, 33071.0F);
          GLES20.glTexParameterf(3553, 10243, 33071.0F);
          GLES20.glUniform1i(this.hoa, 0);
          GLES20.glUniform1i(this.hnZ, 2);
          GLES20.glUniform1i(this.hod, 1);
          j = this.pYK;
          if (!this.pYB) {
            break label1161;
          }
          i = 1;
          GLES20.glUniform1i(j, i);
          if (this.hnQ == null) {
            break label1166;
          }
          GLES20.glActiveTexture(33985);
          paramGL10 = this.pYH;
          if (paramGL10 != null)
          {
            localObject = this.hnQ;
            if (localObject == null) {
              p.gfZ();
            }
            com.tencent.mm.media.g.d.a(paramGL10, (Bitmap)localObject);
          }
          GLES20.glUniform1i(this.hob, 1);
          this.gLm.position(0);
          GLES20.glVertexAttribPointer(this.hnW, 2, 5126, false, 0, (Buffer)this.gLm);
          GLES20.glEnableVertexAttribArray(this.hnW);
          this.pYT.position(0);
          this.pYT.put(b.hoJ);
          this.pYT.position(0);
          GLES20.glVertexAttribPointer(this.hnX, 2, 5126, false, 0, (Buffer)this.pYT);
          GLES20.glEnableVertexAttribArray(this.hnX);
          this.hoj.put(this.hnO);
          this.hoj.put(this.hnP);
          this.hoj.position(0);
          GLES20.glUniform2fv(this.pYI, 1, this.hoj);
          i = this.pYJ;
          paramGL10 = com.tencent.mm.plugin.emojicapture.model.d.pQW;
          GLES20.glUniform1f(i, Math.max(this.hnO, this.hnP) * 0.0666667F);
          Matrix.setIdentityM(this.pYU, 0);
          Matrix.scaleM(this.pYU, 0, 1.0F, -1.0F, 1.0F);
          GLES20.glUniformMatrix4fv(this.hoe, 1, false, this.pYU, 0);
          if (this.hnQ == null) {
            break label1177;
          }
          GLES20.glUniform1i(this.hoc, 1);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(this.hnW);
          GLES20.glDisableVertexAttribArray(this.hnX);
          GLES20.glBindTexture(3553, 0);
          GLES20.glBindTexture(36197, 0);
          GLES20.glFinish();
          this.pYV.position(0);
          GLES20.glReadPixels(0, 0, this.hnO, this.hnO, 6408, 5121, (Buffer)this.pYV);
          GLES20.glUseProgram(0);
          continue;
        }
        i = 0;
      }
      catch (Exception paramGL10)
      {
        ad.printErrStackTrace(this.TAG, (Throwable)paramGL10, "EmojiCaptureMixRenderer draw frame failed", new Object[0]);
        paramGL10 = e.pQY;
        e.cjI();
        AppMethodBeat.o(848);
        return;
      }
      continue;
      label1141:
      int i = 0;
      continue;
      label1146:
      i = 0;
      continue;
      label1151:
      i = 0;
      continue;
      label1156:
      int j = 0;
      continue;
      label1161:
      i = 0;
      continue;
      label1166:
      GLES20.glUniform1i(this.hob, 1);
      continue;
      label1177:
      GLES20.glUniform1i(this.hoc, 0);
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(849);
    ad.i(this.TAG, "onSurfaceChanged, width:" + paramInt1 + ", height:" + paramInt2);
    this.hnO = paramInt1;
    this.hnP = paramInt2;
    this.pYV = ByteBuffer.allocate(this.hnO * this.hnP * 4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.d
 * JD-Core Version:    0.7.0.1
 */