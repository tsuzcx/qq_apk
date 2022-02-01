package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sticker.f;
import d.g.b.p;
import d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "enableAlpha", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "(ZLcom/tencent/mm/sticker/StickerPack;)V", "TAG", "", "blendAttributePosition", "", "blendAttributeTextureCoord", "blendBitmapTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "blendEnableAlpha", "blendProgramId", "blendUniformCornerRadius", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformSize", "blendUniformUseNormalVideoTexture", "cubeBuffer", "Ljava/nio/FloatBuffer;", "currentBlendBitmap", "Landroid/graphics/Bitmap;", "detectFaceFbo", "detectFaceTexture", "firstFrame", "inputTextureHeight", "inputTextureWidth", "isInit", "matrix", "", "removeBackground", "renderContent", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "sizeBuffer", "textureCoordBuffer", "toTextureAttributePosition", "toTextureAttributeTextureCoord", "toTextureProgramId", "toTextureSize", "toTextureUniformExternalTexture", "videoDecodeSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoDecodeTexture", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "xLabEffectOutputTexture", "drawBlendContent", "", "useNormalVideoTexture", "videoTexture", "drawWithStickerAndRemoveBackground", "getEmojiMixContent", "", "getVideoDecodeSurfaceTexture", "init", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setBlendFrame", "blendBitmap", "setRemoveBackground", "remove", "simpleDrawVideoContent", "plugin-emojicapture_release"})
public final class d
  implements GLSurfaceView.Renderer
{
  final String TAG;
  boolean cBE;
  final FloatBuffer gNV;
  com.tencent.mm.plugin.xlabeffect.b gvS;
  private boolean hnW;
  public int hqC;
  public int hqD;
  public Bitmap hqE;
  int hqJ;
  int hqK;
  int hqL;
  int hqN;
  int hqO;
  int hqP;
  int hqQ;
  int hqR;
  int hqS;
  private final FloatBuffer hqX;
  final f pYP;
  boolean pZs;
  public ByteBuffer qfA;
  private final boolean qfg;
  com.tencent.mm.media.g.d qfk;
  SurfaceTexture qfl;
  com.tencent.mm.media.g.d qfm;
  int qfn;
  int qfo;
  int qfp;
  int qfq;
  int qfr;
  int qfs;
  int qft;
  final int qfu;
  int qfv;
  com.tencent.mm.media.g.d qfw;
  com.tencent.mm.media.g.d qfx;
  final FloatBuffer qfy;
  private final float[] qfz;
  
  public d(boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(852);
    this.qfg = paramBoolean;
    this.pYP = paramf;
    this.TAG = "MicroMsg.EmojiCaptureMixRenderer";
    this.qfu = 640;
    paramf = ByteBuffer.allocateDirect(b.hrw.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(paramf, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.gNV = paramf;
    paramf = ByteBuffer.allocateDirect(b.hrx.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(paramf, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.qfy = paramf;
    this.hqX = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.qfz = new float[16];
    this.hnW = true;
    this.qfA = ByteBuffer.allocate(this.hqC * this.hqD * 4);
    AppMethodBeat.o(852);
  }
  
  public final SurfaceTexture clU()
  {
    AppMethodBeat.i(851);
    SurfaceTexture localSurfaceTexture = this.qfl;
    if (localSurfaceTexture == null) {
      p.bdF("videoDecodeSurfaceTexture");
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
        long l = bu.HQ();
        paramGL10 = b.qeU;
        b.a.auv();
        paramGL10 = this.qfl;
        if (paramGL10 == null) {
          p.bdF("videoDecodeSurfaceTexture");
        }
        paramGL10.updateTexImage();
        if ((this.qfw == null) || (this.qfx == null))
        {
          ae.i(this.TAG, "draw frame used " + bu.aO(l) + "ms");
          AppMethodBeat.o(848);
          return;
        }
        paramGL10 = b.qeU;
        j = this.qfv;
        paramGL10 = this.qfw;
        if (paramGL10 != null)
        {
          i = paramGL10.hnc;
          int k = this.qfu;
          int m = this.qfu;
          GLES20.glBindFramebuffer(36160, j);
          GLES20.glBindTexture(3553, i);
          GLES20.glTexImage2D(3553, 0, 6408, k, m, 0, 6408, 5121, null);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
          GLES20.glBindTexture(3553, 0);
          GLES20.glViewport(0, 0, this.qfu, this.qfu);
          paramGL10 = this.qfk;
          if (paramGL10 != null)
          {
            GLES20.glUseProgram(this.qfq);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, paramGL10.hnc);
            GLES20.glTexParameterf(36197, 10241, 9729.0F);
            GLES20.glTexParameterf(36197, 10240, 9729.0F);
            GLES20.glTexParameterf(36197, 10242, 33071.0F);
            GLES20.glTexParameterf(36197, 10243, 33071.0F);
            GLES20.glUniform1i(this.qft, 0);
            this.gNV.position(0);
            GLES20.glVertexAttribPointer(this.qfr, 2, 5126, false, 0, (Buffer)this.gNV);
            GLES20.glEnableVertexAttribArray(this.qfr);
            this.qfy.position(0);
            this.qfy.put(b.hry);
            this.qfy.position(0);
            GLES20.glVertexAttribPointer(this.qfs, 2, 5126, false, 0, (Buffer)this.qfy);
            GLES20.glEnableVertexAttribArray(this.qfs);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.qfr);
            GLES20.glDisableVertexAttribArray(this.qfs);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindTexture(36197, 0);
            GLES20.glFinish();
          }
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glFinish();
          paramGL10 = b.qeU;
          b.a.auv();
          GLES20.glViewport(0, 0, this.qfu, this.qfu);
          paramGL10 = this.gvS;
          if (paramGL10 != null)
          {
            localObject = this.qfw;
            if (localObject == null) {
              break label1141;
            }
            i = ((com.tencent.mm.media.g.d)localObject).hnc;
            com.tencent.mm.plugin.xlabeffect.b.a(paramGL10, i);
          }
          if (this.hnW)
          {
            this.hnW = false;
            paramGL10 = this.gvS;
            if (paramGL10 != null)
            {
              localObject = this.qfw;
              if (localObject == null) {
                break label1146;
              }
              i = ((com.tencent.mm.media.g.d)localObject).hnc;
              com.tencent.mm.plugin.xlabeffect.b.a(paramGL10, i);
            }
          }
          paramGL10 = this.qfx;
          if (paramGL10 != null) {
            com.tencent.mm.media.g.d.a(paramGL10, this.qfu, this.qfu, 0, null, 0, 0, 60);
          }
          paramGL10 = this.gvS;
          if (paramGL10 != null)
          {
            localObject = this.qfw;
            if (localObject == null) {
              break label1151;
            }
            i = ((com.tencent.mm.media.g.d)localObject).hnc;
            localObject = this.qfx;
            if (localObject == null) {
              break label1156;
            }
            j = ((com.tencent.mm.media.g.d)localObject).hnc;
            com.tencent.mm.plugin.xlabeffect.b.a(paramGL10, i, j, false, 60);
          }
          paramGL10 = this.qfx;
          GLES20.glFinish();
          Object localObject = b.qeU;
          b.a.auv();
          GLES20.glViewport(0, 0, this.hqC, this.hqD);
          if (paramGL10 == null) {
            continue;
          }
          GLES20.glViewport(0, 0, this.hqC, this.hqD);
          GLES20.glUseProgram(this.hqJ);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(3553, paramGL10.hnc);
          GLES20.glTexParameterf(3553, 10241, 9729.0F);
          GLES20.glTexParameterf(3553, 10240, 9729.0F);
          GLES20.glTexParameterf(3553, 10242, 33071.0F);
          GLES20.glTexParameterf(3553, 10243, 33071.0F);
          GLES20.glUniform1i(this.hqO, 0);
          GLES20.glUniform1i(this.hqN, 2);
          GLES20.glUniform1i(this.hqR, 1);
          j = this.qfp;
          if (!this.qfg) {
            break label1161;
          }
          i = 1;
          GLES20.glUniform1i(j, i);
          if (this.hqE == null) {
            break label1166;
          }
          GLES20.glActiveTexture(33985);
          paramGL10 = this.qfm;
          if (paramGL10 != null)
          {
            localObject = this.hqE;
            if (localObject == null) {
              p.gkB();
            }
            com.tencent.mm.media.g.d.a(paramGL10, (Bitmap)localObject);
          }
          GLES20.glUniform1i(this.hqP, 1);
          this.gNV.position(0);
          GLES20.glVertexAttribPointer(this.hqK, 2, 5126, false, 0, (Buffer)this.gNV);
          GLES20.glEnableVertexAttribArray(this.hqK);
          this.qfy.position(0);
          this.qfy.put(b.hrx);
          this.qfy.position(0);
          GLES20.glVertexAttribPointer(this.hqL, 2, 5126, false, 0, (Buffer)this.qfy);
          GLES20.glEnableVertexAttribArray(this.hqL);
          this.hqX.put(this.hqC);
          this.hqX.put(this.hqD);
          this.hqX.position(0);
          GLES20.glUniform2fv(this.qfn, 1, this.hqX);
          i = this.qfo;
          paramGL10 = com.tencent.mm.plugin.emojicapture.model.d.pXB;
          GLES20.glUniform1f(i, Math.max(this.hqC, this.hqD) * 0.0666667F);
          Matrix.setIdentityM(this.qfz, 0);
          Matrix.scaleM(this.qfz, 0, 1.0F, -1.0F, 1.0F);
          GLES20.glUniformMatrix4fv(this.hqS, 1, false, this.qfz, 0);
          if (this.hqE == null) {
            break label1177;
          }
          GLES20.glUniform1i(this.hqQ, 1);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(this.hqK);
          GLES20.glDisableVertexAttribArray(this.hqL);
          GLES20.glBindTexture(3553, 0);
          GLES20.glBindTexture(36197, 0);
          GLES20.glFinish();
          this.qfA.position(0);
          GLES20.glReadPixels(0, 0, this.hqC, this.hqC, 6408, 5121, (Buffer)this.qfA);
          GLES20.glUseProgram(0);
          continue;
        }
        i = 0;
      }
      catch (Exception paramGL10)
      {
        ae.printErrStackTrace(this.TAG, (Throwable)paramGL10, "EmojiCaptureMixRenderer draw frame failed", new Object[0]);
        paramGL10 = e.pXD;
        e.ckY();
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
      GLES20.glUniform1i(this.hqP, 1);
      continue;
      label1177:
      GLES20.glUniform1i(this.hqQ, 0);
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(849);
    ae.i(this.TAG, "onSurfaceChanged, width:" + paramInt1 + ", height:" + paramInt2);
    this.hqC = paramInt1;
    this.hqD = paramInt2;
    this.qfA = ByteBuffer.allocate(this.hqC * this.hqD * 4);
    AppMethodBeat.o(849);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(850);
    ae.i(this.TAG, "onSurfaceCreated");
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glDisable(2929);
    AppMethodBeat.o(850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.d
 * JD-Core Version:    0.7.0.1
 */