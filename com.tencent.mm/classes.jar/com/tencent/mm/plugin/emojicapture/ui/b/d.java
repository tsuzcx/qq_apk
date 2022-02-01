package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "enableAlpha", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "(ZLcom/tencent/mm/sticker/StickerPack;)V", "TAG", "", "blendAttributePosition", "", "blendAttributeTextureCoord", "blendBitmapTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "blendEnableAlpha", "blendProgramId", "blendUniformCornerRadius", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformSize", "blendUniformUseNormalVideoTexture", "cubeBuffer", "Ljava/nio/FloatBuffer;", "currentBlendBitmap", "Landroid/graphics/Bitmap;", "detectFaceFbo", "detectFaceTexture", "firstFrame", "inputTextureHeight", "inputTextureWidth", "isInit", "matrix", "", "removeBackground", "renderContent", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "sizeBuffer", "textureCoordBuffer", "toTextureAttributePosition", "toTextureAttributeTextureCoord", "toTextureProgramId", "toTextureSize", "toTextureUniformExternalTexture", "videoDecodeSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoDecodeTexture", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "xLabEffectOutputTexture", "drawBlendContent", "", "useNormalVideoTexture", "videoTexture", "drawWithStickerAndRemoveBackground", "getEmojiMixContent", "", "getVideoDecodeSurfaceTexture", "init", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setBlendFrame", "blendBitmap", "setRemoveBackground", "remove", "simpleDrawVideoContent", "plugin-emojicapture_release"})
public final class d
  implements GLSurfaceView.Renderer
{
  final String TAG;
  boolean isInit;
  com.tencent.mm.plugin.xlabeffect.e jUF;
  public int kYS;
  public int kYT;
  public Bitmap kYU;
  int kYZ;
  int kZa;
  int kZb;
  int kZd;
  int kZe;
  int kZf;
  int kZg;
  int kZh;
  int kZi;
  private final FloatBuffer kZn;
  final FloatBuffer ksb;
  boolean uVV;
  final f uVs;
  private final boolean vbI;
  com.tencent.mm.media.g.d vbM;
  SurfaceTexture vbN;
  com.tencent.mm.media.g.d vbO;
  int vbP;
  int vbQ;
  int vbR;
  int vbS;
  int vbT;
  int vbU;
  int vbV;
  final int vbW;
  int vbX;
  com.tencent.mm.media.g.d vbY;
  com.tencent.mm.media.g.d vbZ;
  final FloatBuffer vca;
  private final float[] vcb;
  private boolean vcc;
  public ByteBuffer vcd;
  
  public d(boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(852);
    this.vbI = paramBoolean;
    this.uVs = paramf;
    this.TAG = "MicroMsg.EmojiCaptureMixRenderer";
    this.vbW = 640;
    paramf = ByteBuffer.allocateDirect(b.laj.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.j(paramf, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.ksb = paramf;
    paramf = ByteBuffer.allocateDirect(b.lak.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.j(paramf, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.vca = paramf;
    this.kZn = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.vcb = new float[16];
    this.vcc = true;
    this.vcd = ByteBuffer.allocate(this.kYS * this.kYT * 4);
    AppMethodBeat.o(852);
  }
  
  public final SurfaceTexture cYG()
  {
    AppMethodBeat.i(851);
    SurfaceTexture localSurfaceTexture = this.vbN;
    if (localSurfaceTexture == null) {
      p.bGy("videoDecodeSurfaceTexture");
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
        paramGL10 = b.vbw;
        b.a.aVB();
        paramGL10 = this.vbN;
        if (paramGL10 == null) {
          p.bGy("videoDecodeSurfaceTexture");
        }
        paramGL10.updateTexImage();
        if ((this.vbY == null) || (this.vbZ == null))
        {
          Log.i(this.TAG, "draw frame used " + Util.ticksToNow(l) + "ms");
          AppMethodBeat.o(848);
          return;
        }
        paramGL10 = b.vbw;
        j = this.vbX;
        paramGL10 = this.vbY;
        if (paramGL10 != null)
        {
          i = paramGL10.kVj;
          int k = this.vbW;
          int m = this.vbW;
          GLES20.glBindFramebuffer(36160, j);
          GLES20.glBindTexture(3553, i);
          GLES20.glTexImage2D(3553, 0, 6408, k, m, 0, 6408, 5121, null);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
          GLES20.glBindTexture(3553, 0);
          GLES20.glViewport(0, 0, this.vbW, this.vbW);
          paramGL10 = this.vbM;
          if (paramGL10 != null)
          {
            GLES20.glUseProgram(this.vbS);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, paramGL10.kVj);
            GLES20.glTexParameterf(36197, 10241, 9729.0F);
            GLES20.glTexParameterf(36197, 10240, 9729.0F);
            GLES20.glTexParameterf(36197, 10242, 33071.0F);
            GLES20.glTexParameterf(36197, 10243, 33071.0F);
            GLES20.glUniform1i(this.vbV, 0);
            this.ksb.position(0);
            GLES20.glVertexAttribPointer(this.vbT, 2, 5126, false, 0, (Buffer)this.ksb);
            GLES20.glEnableVertexAttribArray(this.vbT);
            this.vca.position(0);
            this.vca.put(b.lal);
            this.vca.position(0);
            GLES20.glVertexAttribPointer(this.vbU, 2, 5126, false, 0, (Buffer)this.vca);
            GLES20.glEnableVertexAttribArray(this.vbU);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.vbT);
            GLES20.glDisableVertexAttribArray(this.vbU);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindTexture(36197, 0);
            GLES20.glFinish();
          }
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glFinish();
          paramGL10 = b.vbw;
          b.a.aVB();
          GLES20.glViewport(0, 0, this.vbW, this.vbW);
          paramGL10 = this.jUF;
          if (paramGL10 != null)
          {
            localObject = this.vbY;
            if (localObject == null) {
              break label1141;
            }
            i = ((com.tencent.mm.media.g.d)localObject).kVj;
            com.tencent.mm.plugin.xlabeffect.e.a(paramGL10, i);
          }
          if (this.vcc)
          {
            this.vcc = false;
            paramGL10 = this.jUF;
            if (paramGL10 != null)
            {
              localObject = this.vbY;
              if (localObject == null) {
                break label1146;
              }
              i = ((com.tencent.mm.media.g.d)localObject).kVj;
              com.tencent.mm.plugin.xlabeffect.e.a(paramGL10, i);
            }
          }
          paramGL10 = this.vbZ;
          if (paramGL10 != null) {
            com.tencent.mm.media.g.d.a(paramGL10, this.vbW, this.vbW, 0, null, 0, 0, 60);
          }
          paramGL10 = this.jUF;
          if (paramGL10 != null)
          {
            localObject = this.vbY;
            if (localObject == null) {
              break label1151;
            }
            i = ((com.tencent.mm.media.g.d)localObject).kVj;
            localObject = this.vbZ;
            if (localObject == null) {
              break label1156;
            }
            j = ((com.tencent.mm.media.g.d)localObject).kVj;
            com.tencent.mm.plugin.xlabeffect.e.a(paramGL10, i, j, false, 60);
          }
          paramGL10 = this.vbZ;
          GLES20.glFinish();
          Object localObject = b.vbw;
          b.a.aVB();
          GLES20.glViewport(0, 0, this.kYS, this.kYT);
          if (paramGL10 == null) {
            continue;
          }
          GLES20.glViewport(0, 0, this.kYS, this.kYT);
          GLES20.glUseProgram(this.kYZ);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(3553, paramGL10.kVj);
          GLES20.glTexParameterf(3553, 10241, 9729.0F);
          GLES20.glTexParameterf(3553, 10240, 9729.0F);
          GLES20.glTexParameterf(3553, 10242, 33071.0F);
          GLES20.glTexParameterf(3553, 10243, 33071.0F);
          GLES20.glUniform1i(this.kZe, 0);
          GLES20.glUniform1i(this.kZd, 2);
          GLES20.glUniform1i(this.kZh, 1);
          j = this.vbR;
          if (!this.vbI) {
            break label1161;
          }
          i = 1;
          GLES20.glUniform1i(j, i);
          if (this.kYU == null) {
            break label1166;
          }
          GLES20.glActiveTexture(33985);
          paramGL10 = this.vbO;
          if (paramGL10 != null)
          {
            localObject = this.kYU;
            if (localObject == null) {
              p.iCn();
            }
            com.tencent.mm.media.g.d.a(paramGL10, (Bitmap)localObject);
          }
          GLES20.glUniform1i(this.kZf, 1);
          this.ksb.position(0);
          GLES20.glVertexAttribPointer(this.kZa, 2, 5126, false, 0, (Buffer)this.ksb);
          GLES20.glEnableVertexAttribArray(this.kZa);
          this.vca.position(0);
          this.vca.put(b.lak);
          this.vca.position(0);
          GLES20.glVertexAttribPointer(this.kZb, 2, 5126, false, 0, (Buffer)this.vca);
          GLES20.glEnableVertexAttribArray(this.kZb);
          this.kZn.put(this.kYS);
          this.kZn.put(this.kYT);
          this.kZn.position(0);
          GLES20.glUniform2fv(this.vbP, 1, this.kZn);
          i = this.vbQ;
          paramGL10 = com.tencent.mm.plugin.emojicapture.model.d.uUg;
          GLES20.glUniform1f(i, Math.max(this.kYS, this.kYT) * 0.0666667F);
          Matrix.setIdentityM(this.vcb, 0);
          Matrix.scaleM(this.vcb, 0, 1.0F, -1.0F, 1.0F);
          GLES20.glUniformMatrix4fv(this.kZi, 1, false, this.vcb, 0);
          if (this.kYU == null) {
            break label1177;
          }
          GLES20.glUniform1i(this.kZg, 1);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(this.kZa);
          GLES20.glDisableVertexAttribArray(this.kZb);
          GLES20.glBindTexture(3553, 0);
          GLES20.glBindTexture(36197, 0);
          GLES20.glFinish();
          this.vcd.position(0);
          GLES20.glReadPixels(0, 0, this.kYS, this.kYS, 6408, 5121, (Buffer)this.vcd);
          GLES20.glUseProgram(0);
          continue;
        }
        i = 0;
      }
      catch (Exception paramGL10)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramGL10, "EmojiCaptureMixRenderer draw frame failed", new Object[0]);
        paramGL10 = com.tencent.mm.plugin.emojicapture.model.e.uUh;
        com.tencent.mm.plugin.emojicapture.model.e.cXJ();
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
      GLES20.glUniform1i(this.kZf, 1);
      continue;
      label1177:
      GLES20.glUniform1i(this.kZg, 0);
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(849);
    Log.i(this.TAG, "onSurfaceChanged, width:" + paramInt1 + ", height:" + paramInt2);
    this.kYS = paramInt1;
    this.kYT = paramInt2;
    this.vcd = ByteBuffer.allocate(this.kYS * this.kYT * 4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.d
 * JD-Core Version:    0.7.0.1
 */