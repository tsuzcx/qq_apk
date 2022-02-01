package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sticker.f;
import d.g.b.k;
import d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "enableAlpha", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "(ZLcom/tencent/mm/sticker/StickerPack;)V", "TAG", "", "blendAttributePosition", "", "blendAttributeTextureCoord", "blendBitmapTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "blendEnableAlpha", "blendProgramId", "blendUniformCornerRadius", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformSize", "blendUniformUseNormalVideoTexture", "cubeBuffer", "Ljava/nio/FloatBuffer;", "currentBlendBitmap", "Landroid/graphics/Bitmap;", "detectFaceFbo", "detectFaceTexture", "inputTextureHeight", "inputTextureWidth", "isInit", "matrix", "", "removeBackground", "renderContent", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "sizeBuffer", "textureCoordBuffer", "toTextureAttributePosition", "toTextureAttributeTextureCoord", "toTextureProgramId", "toTextureSize", "toTextureUniformExternalTexture", "videoDecodeSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoDecodeTexture", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "xLabEffectOutputTexture", "drawBlendContent", "", "useNormalVideoTexture", "videoTexture", "drawWithStickerAndRemoveBackground", "getEmojiMixContent", "", "getVideoDecodeSurfaceTexture", "init", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setBlendFrame", "blendBitmap", "setRemoveBackground", "remove", "simpleDrawVideoContent", "plugin-emojicapture_release"})
public final class d
  implements GLSurfaceView.Renderer
{
  final String TAG;
  boolean cqf;
  XLabEffect fZP;
  public int gVI;
  public int gVJ;
  public Bitmap gVK;
  int gVP;
  int gVQ;
  int gVR;
  int gVT;
  int gVU;
  int gVV;
  int gVW;
  int gVX;
  int gVY;
  private final FloatBuffer gWd;
  final FloatBuffer grE;
  final f poJ;
  boolean ppm;
  private final boolean puW;
  com.tencent.mm.media.f.d pva;
  SurfaceTexture pvb;
  com.tencent.mm.media.f.d pvc;
  int pvd;
  int pve;
  int pvf;
  int pvg;
  int pvh;
  int pvi;
  int pvj;
  final int pvk;
  int pvl;
  com.tencent.mm.media.f.d pvm;
  com.tencent.mm.media.f.d pvn;
  final FloatBuffer pvo;
  private final float[] pvp;
  public ByteBuffer pvq;
  
  public d(boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(852);
    this.puW = paramBoolean;
    this.poJ = paramf;
    this.TAG = "MicroMsg.EmojiCaptureMixRenderer";
    this.pvk = 640;
    paramf = ByteBuffer.allocateDirect(b.gWC.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    k.g(paramf, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.grE = paramf;
    paramf = ByteBuffer.allocateDirect(b.gWD.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    k.g(paramf, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.pvo = paramf;
    this.gWd = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.pvp = new float[16];
    this.pvq = ByteBuffer.allocate(this.gVI * this.gVJ * 4);
    AppMethodBeat.o(852);
  }
  
  public final SurfaceTexture cga()
  {
    AppMethodBeat.i(851);
    SurfaceTexture localSurfaceTexture = this.pvb;
    if (localSurfaceTexture == null) {
      k.aVY("videoDecodeSurfaceTexture");
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
        long l = bs.Gn();
        paramGL10 = b.puK;
        b.a.art();
        paramGL10 = this.pvb;
        if (paramGL10 == null) {
          k.aVY("videoDecodeSurfaceTexture");
        }
        paramGL10.updateTexImage();
        if ((this.pvm == null) || (this.pvn == null))
        {
          ac.i(this.TAG, "draw frame used " + bs.aO(l) + "ms");
          AppMethodBeat.o(848);
          return;
        }
        paramGL10 = b.puK;
        j = this.pvl;
        paramGL10 = this.pvm;
        if (paramGL10 != null)
        {
          i = paramGL10.gRW;
          int k = this.pvk;
          int m = this.pvk;
          GLES20.glBindFramebuffer(36160, j);
          GLES20.glBindTexture(3553, i);
          GLES20.glTexImage2D(3553, 0, 6408, k, m, 0, 6408, 5121, null);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
          GLES20.glBindTexture(3553, 0);
          GLES20.glViewport(0, 0, this.pvk, this.pvk);
          paramGL10 = this.pva;
          if (paramGL10 != null)
          {
            GLES20.glUseProgram(this.pvg);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, paramGL10.gRW);
            GLES20.glTexParameterf(36197, 10241, 9729.0F);
            GLES20.glTexParameterf(36197, 10240, 9729.0F);
            GLES20.glTexParameterf(36197, 10242, 33071.0F);
            GLES20.glTexParameterf(36197, 10243, 33071.0F);
            GLES20.glUniform1i(this.pvj, 0);
            this.grE.position(0);
            GLES20.glVertexAttribPointer(this.pvh, 2, 5126, false, 0, (Buffer)this.grE);
            GLES20.glEnableVertexAttribArray(this.pvh);
            this.pvo.position(0);
            this.pvo.put(b.gWE);
            this.pvo.position(0);
            GLES20.glVertexAttribPointer(this.pvi, 2, 5126, false, 0, (Buffer)this.pvo);
            GLES20.glEnableVertexAttribArray(this.pvi);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.pvh);
            GLES20.glDisableVertexAttribArray(this.pvi);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindTexture(36197, 0);
            GLES20.glFinish();
          }
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glFinish();
          paramGL10 = b.puK;
          b.a.art();
          GLES20.glViewport(0, 0, this.pvk, this.pvk);
          paramGL10 = this.fZP;
          if (paramGL10 != null)
          {
            localObject = this.pvm;
            if (localObject == null) {
              break label1099;
            }
            i = ((com.tencent.mm.media.f.d)localObject).gRW;
            XLabEffect.a(paramGL10, i);
          }
          paramGL10 = this.pvn;
          if (paramGL10 != null) {
            com.tencent.mm.media.f.d.a(paramGL10, this.pvk, this.pvk, 0, null, 0, 0, 60);
          }
          paramGL10 = this.fZP;
          if (paramGL10 != null)
          {
            localObject = this.pvm;
            if (localObject == null) {
              break label1104;
            }
            i = ((com.tencent.mm.media.f.d)localObject).gRW;
            localObject = this.pvn;
            if (localObject == null) {
              break label1109;
            }
            j = ((com.tencent.mm.media.f.d)localObject).gRW;
            XLabEffect.a(paramGL10, i, j, 0L, false, 60);
          }
          paramGL10 = this.pvn;
          GLES20.glFinish();
          Object localObject = b.puK;
          b.a.art();
          GLES20.glViewport(0, 0, this.gVI, this.gVJ);
          if (paramGL10 == null) {
            continue;
          }
          GLES20.glViewport(0, 0, this.gVI, this.gVJ);
          GLES20.glUseProgram(this.gVP);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(3553, paramGL10.gRW);
          GLES20.glTexParameterf(3553, 10241, 9729.0F);
          GLES20.glTexParameterf(3553, 10240, 9729.0F);
          GLES20.glTexParameterf(3553, 10242, 33071.0F);
          GLES20.glTexParameterf(3553, 10243, 33071.0F);
          GLES20.glUniform1i(this.gVU, 0);
          GLES20.glUniform1i(this.gVT, 2);
          GLES20.glUniform1i(this.gVX, 1);
          j = this.pvf;
          if (!this.puW) {
            break label1114;
          }
          i = 1;
          GLES20.glUniform1i(j, i);
          if (this.gVK == null) {
            break label1119;
          }
          GLES20.glActiveTexture(33985);
          paramGL10 = this.pvc;
          if (paramGL10 != null)
          {
            localObject = this.gVK;
            if (localObject == null) {
              k.fOy();
            }
            com.tencent.mm.media.f.d.a(paramGL10, (Bitmap)localObject);
          }
          GLES20.glUniform1i(this.gVV, 1);
          this.grE.position(0);
          GLES20.glVertexAttribPointer(this.gVQ, 2, 5126, false, 0, (Buffer)this.grE);
          GLES20.glEnableVertexAttribArray(this.gVQ);
          this.pvo.position(0);
          this.pvo.put(b.gWD);
          this.pvo.position(0);
          GLES20.glVertexAttribPointer(this.gVR, 2, 5126, false, 0, (Buffer)this.pvo);
          GLES20.glEnableVertexAttribArray(this.gVR);
          this.gWd.put(this.gVI);
          this.gWd.put(this.gVJ);
          this.gWd.position(0);
          GLES20.glUniform2fv(this.pvd, 1, this.gWd);
          i = this.pve;
          paramGL10 = com.tencent.mm.plugin.emojicapture.model.d.pnw;
          GLES20.glUniform1f(i, Math.max(this.gVI, this.gVJ) * 0.0666667F);
          Matrix.setIdentityM(this.pvp, 0);
          Matrix.scaleM(this.pvp, 0, 1.0F, -1.0F, 1.0F);
          GLES20.glUniformMatrix4fv(this.gVY, 1, false, this.pvp, 0);
          if (this.gVK == null) {
            break label1130;
          }
          GLES20.glUniform1i(this.gVW, 1);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(this.gVQ);
          GLES20.glDisableVertexAttribArray(this.gVR);
          GLES20.glBindTexture(3553, 0);
          GLES20.glBindTexture(36197, 0);
          GLES20.glFinish();
          this.pvq.position(0);
          GLES20.glReadPixels(0, 0, this.gVI, this.gVI, 6408, 5121, (Buffer)this.pvq);
          GLES20.glUseProgram(0);
          continue;
        }
        i = 0;
      }
      catch (Exception paramGL10)
      {
        ac.printErrStackTrace(this.TAG, (Throwable)paramGL10, "EmojiCaptureMixRenderer draw frame failed", new Object[0]);
        paramGL10 = e.pny;
        e.cff();
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
      GLES20.glUniform1i(this.gVV, 1);
      continue;
      label1130:
      GLES20.glUniform1i(this.gVW, 0);
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(849);
    ac.i(this.TAG, "onSurfaceChanged, width:" + paramInt1 + ", height:" + paramInt2);
    this.gVI = paramInt1;
    this.gVJ = paramInt2;
    this.pvq = ByteBuffer.allocate(this.gVI * this.gVJ * 4);
    AppMethodBeat.o(849);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(850);
    ac.i(this.TAG, "onSurfaceCreated");
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glDisable(2929);
    AppMethodBeat.o(850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.d
 * JD-Core Version:    0.7.0.1
 */