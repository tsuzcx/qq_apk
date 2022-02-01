package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.xlabeffect.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "enableAlpha", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "(ZLcom/tencent/mm/sticker/StickerPack;)V", "TAG", "", "blendAttributePosition", "", "blendAttributeTextureCoord", "blendBitmapTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "blendEnableAlpha", "blendProgramId", "blendUniformCornerRadius", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformSize", "blendUniformUseNormalVideoTexture", "cubeBuffer", "Ljava/nio/FloatBuffer;", "currentBlendBitmap", "Landroid/graphics/Bitmap;", "detectFaceFbo", "detectFaceTexture", "firstFrame", "inputTextureHeight", "inputTextureWidth", "isInit", "matrix", "", "removeBackground", "renderContent", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "sizeBuffer", "textureCoordBuffer", "toTextureAttributePosition", "toTextureAttributeTextureCoord", "toTextureProgramId", "toTextureSize", "toTextureUniformExternalTexture", "videoDecodeSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoDecodeTexture", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "xLabEffectOutputTexture", "drawBlendContent", "", "useNormalVideoTexture", "videoTexture", "drawWithStickerAndRemoveBackground", "getEmojiMixContent", "", "getVideoDecodeSurfaceTexture", "init", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setBlendFrame", "blendBitmap", "setRemoveBackground", "remove", "simpleDrawVideoContent", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements GLSurfaceView.Renderer
{
  final String TAG;
  boolean isInit;
  final FloatBuffer mVV;
  k muW;
  public int nDY;
  public int nDZ;
  public Bitmap nEa;
  int nEf;
  int nEg;
  int nEh;
  int nEj;
  int nEk;
  int nEl;
  int nEm;
  int nEn;
  int nEo;
  private final FloatBuffer nEt;
  final f yhU;
  boolean yis;
  com.tencent.mm.media.g.d ynF;
  SurfaceTexture ynG;
  com.tencent.mm.media.g.d ynH;
  int ynI;
  int ynJ;
  int ynK;
  int ynL;
  int ynM;
  int ynN;
  int ynO;
  final int ynP;
  int ynQ;
  com.tencent.mm.media.g.d ynR;
  com.tencent.mm.media.g.d ynS;
  final FloatBuffer ynT;
  private final float[] ynU;
  private boolean ynV;
  public ByteBuffer ynW;
  private final boolean yns;
  
  public d(boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(852);
    this.yns = paramBoolean;
    this.yhU = paramf;
    this.TAG = "MicroMsg.EmojiCaptureMixRenderer";
    this.ynP = 640;
    paramf = ByteBuffer.allocateDirect(b.nFt.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    s.s(paramf, "allocateDirect(EmojiCapt…eOrder()).asFloatBuffer()");
    this.mVV = paramf;
    paramf = ByteBuffer.allocateDirect(b.nFu.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    s.s(paramf, "allocateDirect(EmojiCapt…eOrder()).asFloatBuffer()");
    this.ynT = paramf;
    this.nEt = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.ynU = new float[16];
    this.ynV = true;
    this.ynW = ByteBuffer.allocate(this.nDY * this.nDZ * 4);
    AppMethodBeat.o(852);
  }
  
  public final SurfaceTexture dEX()
  {
    AppMethodBeat.i(851);
    SurfaceTexture localSurfaceTexture = this.ynG;
    if (localSurfaceTexture == null)
    {
      s.bIx("videoDecodeSurfaceTexture");
      AppMethodBeat.o(851);
      return null;
    }
    AppMethodBeat.o(851);
    return localSurfaceTexture;
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    AppMethodBeat.i(848);
    for (;;)
    {
      Object localObject;
      try
      {
        long l = Util.currentTicks();
        paramGL10 = b.ynr;
        b.a.bqi();
        localObject = this.ynG;
        paramGL10 = (GL10)localObject;
        if (localObject == null)
        {
          s.bIx("videoDecodeSurfaceTexture");
          paramGL10 = null;
        }
        paramGL10.updateTexImage();
        if ((this.ynR == null) || (this.ynS == null))
        {
          Log.i(this.TAG, "draw frame used " + Util.ticksToNow(l) + "ms");
          AppMethodBeat.o(848);
          return;
        }
        paramGL10 = b.ynr;
        j = this.ynQ;
        paramGL10 = this.ynR;
        if (paramGL10 == null)
        {
          i = 0;
          int k = this.ynP;
          int m = this.ynP;
          GLES20.glBindFramebuffer(36160, j);
          GLES20.glBindTexture(3553, i);
          GLES20.glTexImage2D(3553, 0, 6408, k, m, 0, 6408, 5121, null);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
          GLES20.glBindTexture(3553, 0);
          GLES20.glViewport(0, 0, this.ynP, this.ynP);
          paramGL10 = this.ynF;
          if (paramGL10 != null)
          {
            GLES20.glUseProgram(this.ynL);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, paramGL10.nAF);
            GLES20.glTexParameterf(36197, 10241, 9729.0F);
            GLES20.glTexParameterf(36197, 10240, 9729.0F);
            GLES20.glTexParameterf(36197, 10242, 33071.0F);
            GLES20.glTexParameterf(36197, 10243, 33071.0F);
            GLES20.glUniform1i(this.ynO, 0);
            this.mVV.position(0);
            GLES20.glVertexAttribPointer(this.ynM, 2, 5126, false, 0, (Buffer)this.mVV);
            GLES20.glEnableVertexAttribArray(this.ynM);
            this.ynT.position(0);
            this.ynT.put(b.nFv);
            this.ynT.position(0);
            GLES20.glVertexAttribPointer(this.ynN, 2, 5126, false, 0, (Buffer)this.ynT);
            GLES20.glEnableVertexAttribArray(this.ynN);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.ynM);
            GLES20.glDisableVertexAttribArray(this.ynN);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindTexture(36197, 0);
            GLES20.glFinish();
          }
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glFinish();
          paramGL10 = b.ynr;
          b.a.bqi();
          GLES20.glViewport(0, 0, this.ynP, this.ynP);
          paramGL10 = this.muW;
          if (paramGL10 != null)
          {
            localObject = this.ynR;
            if (localObject != null) {
              break label1129;
            }
            i = 0;
            k.a(paramGL10, i);
          }
          if (this.ynV)
          {
            this.ynV = false;
            paramGL10 = this.muW;
            if (paramGL10 != null)
            {
              localObject = this.ynR;
              if (localObject != null) {
                break label1138;
              }
              i = 0;
              k.a(paramGL10, i);
            }
          }
          paramGL10 = this.ynS;
          if (paramGL10 != null) {
            com.tencent.mm.media.g.d.a(paramGL10, this.ynP, this.ynP, 0, null, 0, 0, 60);
          }
          paramGL10 = this.muW;
          if (paramGL10 != null)
          {
            localObject = this.ynR;
            if (localObject != null) {
              break label1147;
            }
            i = 0;
            localObject = this.ynS;
            if (localObject != null) {
              break label1156;
            }
            j = 0;
            k.a(paramGL10, i, j, false, 60);
          }
          paramGL10 = this.ynS;
          GLES20.glFinish();
          localObject = b.ynr;
          b.a.bqi();
          GLES20.glViewport(0, 0, this.nDY, this.nDZ);
          if (paramGL10 == null) {
            continue;
          }
          GLES20.glViewport(0, 0, this.nDY, this.nDZ);
          GLES20.glUseProgram(this.nEf);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(3553, paramGL10.nAF);
          GLES20.glTexParameterf(3553, 10241, 9729.0F);
          GLES20.glTexParameterf(3553, 10240, 9729.0F);
          GLES20.glTexParameterf(3553, 10242, 33071.0F);
          GLES20.glTexParameterf(3553, 10243, 33071.0F);
          GLES20.glUniform1i(this.nEk, 0);
          GLES20.glUniform1i(this.nEj, 2);
          GLES20.glUniform1i(this.nEn, 1);
          j = this.ynK;
          if (!this.yns) {
            break label1187;
          }
          i = 1;
          GLES20.glUniform1i(j, i);
          if (this.nEa == null) {
            break label1165;
          }
          GLES20.glActiveTexture(33985);
          paramGL10 = this.ynH;
          if (paramGL10 != null)
          {
            localObject = this.nEa;
            s.checkNotNull(localObject);
            com.tencent.mm.media.g.d.a(paramGL10, (Bitmap)localObject);
          }
          GLES20.glUniform1i(this.nEl, 1);
          this.mVV.position(0);
          GLES20.glVertexAttribPointer(this.nEg, 2, 5126, false, 0, (Buffer)this.mVV);
          GLES20.glEnableVertexAttribArray(this.nEg);
          this.ynT.position(0);
          this.ynT.put(b.nFu);
          this.ynT.position(0);
          GLES20.glVertexAttribPointer(this.nEh, 2, 5126, false, 0, (Buffer)this.ynT);
          GLES20.glEnableVertexAttribArray(this.nEh);
          this.nEt.put(this.nDY);
          this.nEt.put(this.nDZ);
          this.nEt.position(0);
          GLES20.glUniform2fv(this.ynI, 1, this.nEt);
          i = this.ynJ;
          paramGL10 = com.tencent.mm.plugin.emojicapture.model.d.ygM;
          GLES20.glUniform1f(i, Math.max(this.nDY, this.nDZ) * 0.0666667F);
          Matrix.setIdentityM(this.ynU, 0);
          Matrix.scaleM(this.ynU, 0, 1.0F, -1.0F, 1.0F);
          GLES20.glUniformMatrix4fv(this.nEo, 1, false, this.ynU, 0);
          if (this.nEa == null) {
            break label1176;
          }
          GLES20.glUniform1i(this.nEm, 1);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(this.nEg);
          GLES20.glDisableVertexAttribArray(this.nEh);
          GLES20.glBindTexture(3553, 0);
          GLES20.glBindTexture(36197, 0);
          GLES20.glFinish();
          this.ynW.position(0);
          GLES20.glReadPixels(0, 0, this.nDY, this.nDY, 6408, 5121, (Buffer)this.ynW);
          GLES20.glUseProgram(0);
          continue;
        }
        i = paramGL10.nAF;
      }
      catch (Exception paramGL10)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramGL10, "EmojiCaptureMixRenderer draw frame failed", new Object[0]);
        paramGL10 = e.ygT;
        e.dDZ();
        AppMethodBeat.o(848);
        return;
      }
      continue;
      label1129:
      int i = ((com.tencent.mm.media.g.d)localObject).nAF;
      continue;
      label1138:
      i = ((com.tencent.mm.media.g.d)localObject).nAF;
      continue;
      label1147:
      i = ((com.tencent.mm.media.g.d)localObject).nAF;
      continue;
      label1156:
      int j = ((com.tencent.mm.media.g.d)localObject).nAF;
      continue;
      label1165:
      GLES20.glUniform1i(this.nEl, 1);
      continue;
      label1176:
      GLES20.glUniform1i(this.nEm, 0);
      continue;
      label1187:
      i = 0;
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(849);
    Log.i(this.TAG, "onSurfaceChanged, width:" + paramInt1 + ", height:" + paramInt2);
    this.nDY = paramInt1;
    this.nDZ = paramInt2;
    this.ynW = ByteBuffer.allocate(this.nDY * this.nDZ * 4);
    AppMethodBeat.o(849);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(850);
    Log.i(this.TAG, "onSurfaceCreated");
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glDisable(2929);
    AppMethodBeat.o(850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.d
 * JD-Core Version:    0.7.0.1
 */