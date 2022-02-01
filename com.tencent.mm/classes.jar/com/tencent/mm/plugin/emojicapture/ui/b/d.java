package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "enableAlpha", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "(ZLcom/tencent/mm/sticker/StickerPack;)V", "TAG", "", "blendAttributePosition", "", "blendAttributeTextureCoord", "blendBitmapTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "blendEnableAlpha", "blendProgramId", "blendUniformCornerRadius", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformSize", "blendUniformUseNormalVideoTexture", "cubeBuffer", "Ljava/nio/FloatBuffer;", "currentBlendBitmap", "Landroid/graphics/Bitmap;", "detectFaceFbo", "detectFaceTexture", "firstFrame", "inputTextureHeight", "inputTextureWidth", "isInit", "matrix", "", "removeBackground", "renderContent", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "sizeBuffer", "textureCoordBuffer", "toTextureAttributePosition", "toTextureAttributeTextureCoord", "toTextureProgramId", "toTextureSize", "toTextureUniformExternalTexture", "videoDecodeSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoDecodeTexture", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "xLabEffectOutputTexture", "drawBlendContent", "", "useNormalVideoTexture", "videoTexture", "drawWithStickerAndRemoveBackground", "getEmojiMixContent", "", "getVideoDecodeSurfaceTexture", "init", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setBlendFrame", "blendBitmap", "setRemoveBackground", "remove", "simpleDrawVideoContent", "plugin-emojicapture_release"})
public final class d
  implements GLSurfaceView.Renderer
{
  final String TAG;
  private final float[] cKH;
  final FloatBuffer hDU;
  com.tencent.mm.plugin.xlabeffect.b hiH;
  private boolean ihq;
  public int ijY;
  public int ijZ;
  public Bitmap ika;
  int ikf;
  int ikg;
  int ikh;
  int ikj;
  int ikk;
  int ikl;
  int ikm;
  int ikn;
  int iko;
  private final FloatBuffer ikt;
  boolean isInit;
  final f rpM;
  boolean rqp;
  private final boolean rwe;
  com.tencent.mm.media.g.d rwi;
  SurfaceTexture rwj;
  com.tencent.mm.media.g.d rwk;
  int rwl;
  int rwm;
  int rwn;
  int rwo;
  int rwp;
  int rwq;
  int rwr;
  final int rws;
  int rwt;
  com.tencent.mm.media.g.d rwu;
  com.tencent.mm.media.g.d rwv;
  final FloatBuffer rww;
  public ByteBuffer rwx;
  
  public d(boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(852);
    this.rwe = paramBoolean;
    this.rpM = paramf;
    this.TAG = "MicroMsg.EmojiCaptureMixRenderer";
    this.rws = 640;
    paramf = ByteBuffer.allocateDirect(b.ilm.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(paramf, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.hDU = paramf;
    paramf = ByteBuffer.allocateDirect(b.iln.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(paramf, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.rww = paramf;
    this.ikt = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.cKH = new float[16];
    this.ihq = true;
    this.rwx = ByteBuffer.allocate(this.ijY * this.ijZ * 4);
    AppMethodBeat.o(852);
  }
  
  public final SurfaceTexture cJW()
  {
    AppMethodBeat.i(851);
    SurfaceTexture localSurfaceTexture = this.rwj;
    if (localSurfaceTexture == null) {
      p.btv("videoDecodeSurfaceTexture");
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
        long l = Util.currentTicks();
        paramGL10 = b.rvS;
        b.a.aMY();
        paramGL10 = this.rwj;
        if (paramGL10 == null) {
          p.btv("videoDecodeSurfaceTexture");
        }
        paramGL10.updateTexImage();
        if ((this.rwu == null) || (this.rwv == null))
        {
          Log.i(this.TAG, "draw frame used " + Util.ticksToNow(l) + "ms");
          AppMethodBeat.o(848);
          return;
        }
        paramGL10 = b.rvS;
        j = this.rwt;
        paramGL10 = this.rwu;
        if (paramGL10 != null)
        {
          i = paramGL10.igv;
          int k = this.rws;
          int m = this.rws;
          GLES20.glBindFramebuffer(36160, j);
          GLES20.glBindTexture(3553, i);
          GLES20.glTexImage2D(3553, 0, 6408, k, m, 0, 6408, 5121, null);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
          GLES20.glBindTexture(3553, 0);
          GLES20.glViewport(0, 0, this.rws, this.rws);
          paramGL10 = this.rwi;
          if (paramGL10 != null)
          {
            GLES20.glUseProgram(this.rwo);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, paramGL10.igv);
            GLES20.glTexParameterf(36197, 10241, 9729.0F);
            GLES20.glTexParameterf(36197, 10240, 9729.0F);
            GLES20.glTexParameterf(36197, 10242, 33071.0F);
            GLES20.glTexParameterf(36197, 10243, 33071.0F);
            GLES20.glUniform1i(this.rwr, 0);
            this.hDU.position(0);
            GLES20.glVertexAttribPointer(this.rwp, 2, 5126, false, 0, (Buffer)this.hDU);
            GLES20.glEnableVertexAttribArray(this.rwp);
            this.rww.position(0);
            this.rww.put(b.ilo);
            this.rww.position(0);
            GLES20.glVertexAttribPointer(this.rwq, 2, 5126, false, 0, (Buffer)this.rww);
            GLES20.glEnableVertexAttribArray(this.rwq);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.rwp);
            GLES20.glDisableVertexAttribArray(this.rwq);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindTexture(36197, 0);
            GLES20.glFinish();
          }
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glFinish();
          paramGL10 = b.rvS;
          b.a.aMY();
          GLES20.glViewport(0, 0, this.rws, this.rws);
          paramGL10 = this.hiH;
          if (paramGL10 != null)
          {
            localObject = this.rwu;
            if (localObject == null) {
              break label1141;
            }
            i = ((com.tencent.mm.media.g.d)localObject).igv;
            com.tencent.mm.plugin.xlabeffect.b.a(paramGL10, i);
          }
          if (this.ihq)
          {
            this.ihq = false;
            paramGL10 = this.hiH;
            if (paramGL10 != null)
            {
              localObject = this.rwu;
              if (localObject == null) {
                break label1146;
              }
              i = ((com.tencent.mm.media.g.d)localObject).igv;
              com.tencent.mm.plugin.xlabeffect.b.a(paramGL10, i);
            }
          }
          paramGL10 = this.rwv;
          if (paramGL10 != null) {
            com.tencent.mm.media.g.d.a(paramGL10, this.rws, this.rws, 0, null, 0, 0, 60);
          }
          paramGL10 = this.hiH;
          if (paramGL10 != null)
          {
            localObject = this.rwu;
            if (localObject == null) {
              break label1151;
            }
            i = ((com.tencent.mm.media.g.d)localObject).igv;
            localObject = this.rwv;
            if (localObject == null) {
              break label1156;
            }
            j = ((com.tencent.mm.media.g.d)localObject).igv;
            com.tencent.mm.plugin.xlabeffect.b.a(paramGL10, i, j, false, 60);
          }
          paramGL10 = this.rwv;
          GLES20.glFinish();
          Object localObject = b.rvS;
          b.a.aMY();
          GLES20.glViewport(0, 0, this.ijY, this.ijZ);
          if (paramGL10 == null) {
            continue;
          }
          GLES20.glViewport(0, 0, this.ijY, this.ijZ);
          GLES20.glUseProgram(this.ikf);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(3553, paramGL10.igv);
          GLES20.glTexParameterf(3553, 10241, 9729.0F);
          GLES20.glTexParameterf(3553, 10240, 9729.0F);
          GLES20.glTexParameterf(3553, 10242, 33071.0F);
          GLES20.glTexParameterf(3553, 10243, 33071.0F);
          GLES20.glUniform1i(this.ikk, 0);
          GLES20.glUniform1i(this.ikj, 2);
          GLES20.glUniform1i(this.ikn, 1);
          j = this.rwn;
          if (!this.rwe) {
            break label1161;
          }
          i = 1;
          GLES20.glUniform1i(j, i);
          if (this.ika == null) {
            break label1166;
          }
          GLES20.glActiveTexture(33985);
          paramGL10 = this.rwk;
          if (paramGL10 != null)
          {
            localObject = this.ika;
            if (localObject == null) {
              p.hyc();
            }
            com.tencent.mm.media.g.d.a(paramGL10, (Bitmap)localObject);
          }
          GLES20.glUniform1i(this.ikl, 1);
          this.hDU.position(0);
          GLES20.glVertexAttribPointer(this.ikg, 2, 5126, false, 0, (Buffer)this.hDU);
          GLES20.glEnableVertexAttribArray(this.ikg);
          this.rww.position(0);
          this.rww.put(b.iln);
          this.rww.position(0);
          GLES20.glVertexAttribPointer(this.ikh, 2, 5126, false, 0, (Buffer)this.rww);
          GLES20.glEnableVertexAttribArray(this.ikh);
          this.ikt.put(this.ijY);
          this.ikt.put(this.ijZ);
          this.ikt.position(0);
          GLES20.glUniform2fv(this.rwl, 1, this.ikt);
          i = this.rwm;
          paramGL10 = com.tencent.mm.plugin.emojicapture.model.d.roA;
          GLES20.glUniform1f(i, Math.max(this.ijY, this.ijZ) * 0.0666667F);
          Matrix.setIdentityM(this.cKH, 0);
          Matrix.scaleM(this.cKH, 0, 1.0F, -1.0F, 1.0F);
          GLES20.glUniformMatrix4fv(this.iko, 1, false, this.cKH, 0);
          if (this.ika == null) {
            break label1177;
          }
          GLES20.glUniform1i(this.ikm, 1);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(this.ikg);
          GLES20.glDisableVertexAttribArray(this.ikh);
          GLES20.glBindTexture(3553, 0);
          GLES20.glBindTexture(36197, 0);
          GLES20.glFinish();
          this.rwx.position(0);
          GLES20.glReadPixels(0, 0, this.ijY, this.ijY, 6408, 5121, (Buffer)this.rwx);
          GLES20.glUseProgram(0);
          continue;
        }
        i = 0;
      }
      catch (Exception paramGL10)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramGL10, "EmojiCaptureMixRenderer draw frame failed", new Object[0]);
        paramGL10 = e.roB;
        e.cJa();
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
      GLES20.glUniform1i(this.ikl, 1);
      continue;
      label1177:
      GLES20.glUniform1i(this.ikm, 0);
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(849);
    Log.i(this.TAG, "onSurfaceChanged, width:" + paramInt1 + ", height:" + paramInt2);
    this.ijY = paramInt1;
    this.ijZ = paramInt2;
    this.rwx = ByteBuffer.allocate(this.ijY * this.ijZ * 4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.d
 * JD-Core Version:    0.7.0.1
 */