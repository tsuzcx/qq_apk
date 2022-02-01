package com.tencent.mm.media.j.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "blendAttributeBlurBgTextureCoord", "blendAttributePosition", "blendAttributeTextureCoord", "blendBitmapTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "blendBlurTextureCoordBuff", "Ljava/nio/FloatBuffer;", "blendCenterLocationBuffer", "", "blendProgramId", "blendTextureCoordBuff", "blendUniformBlurBgTexture", "blendUniformCenterLocation", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasBlurBgTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformUseNormalVideoTexture", "blurBgBitmap", "Landroid/graphics/Bitmap;", "blurBgBitmapTextureObj", "currentBlendBitmap", "emojiBlendAttributeTextureCoord", "inputTexture", "inputTextureHeight", "inputTextureWidth", "sizeBuffer", "kotlin.jvm.PlatformType", "textureType", "release", "", "renderImpl", "setBlendBitmap", "bitmap", "flip", "", "setBlurBgBitmap", "setBlurBgTextureCoordBuff", "blurBgCoord", "setCenterLocation", "top", "", "bottom", "left", "right", "setInputTexture", "texture", "setTextureType", "type", "plugin-mediaeditor_release"})
public class b
  extends a
{
  private final String TAG;
  private int kYS;
  private int kYT;
  private Bitmap kYU;
  private d kYV;
  public Bitmap kYW;
  private d kYX;
  public final float[] kYY;
  private int kYZ;
  private int kZa;
  private int kZb;
  private int kZc;
  private int kZd;
  private int kZe;
  private int kZf;
  private int kZg;
  private int kZh;
  private int kZi;
  private int kZj;
  private int kZk;
  private int kZl;
  private int kZm;
  private final FloatBuffer kZn;
  private FloatBuffer kZo;
  public FloatBuffer kZp;
  public int kre;
  public int textureType;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(259125);
    this.TAG = "MircoMsg.GLTextureRenderProcBlend";
    this.kYY = new float[4];
    this.kZn = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    Object localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.lak.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.j(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.kZo = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.lak.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.j(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.kZp = ((FloatBuffer)localObject);
    this.textureType = 36197;
    this.kYS = paramInt1;
    this.kYT = paramInt2;
    this.kYV = com.tencent.mm.media.g.c.a(true, 4L);
    this.kYX = com.tencent.mm.media.g.c.a(true, 4L);
    localObject = com.tencent.mm.media.k.c.lar;
    this.kYZ = c.a.aE("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        attribute vec2 a_texBlurBgCoord;\n        attribute vec2 a_texEmojiCoord;\n        varying vec2 v_texCoord;\n        varying vec2 v_texBlurBgCoord;\n        varying vec2 v_texEmojiCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n            v_texBlurBgCoord = a_texBlurBgCoord;\n            v_texEmojiCoord = a_texEmojiCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        varying vec2 v_texBlurBgCoord;\n        varying vec2 v_texEmojiCoord;\n        uniform samplerExternalOES videoExternalTexture;\n        uniform sampler2D videoNormalTexture;\n        uniform sampler2D emojiTexture;\n        uniform sampler2D blurBgTexture;\n        uniform int hasEmojiTexture;\n        uniform int useNormalVideoTexture;\n        uniform int hasBlurBgTexture;\n        uniform vec4 centerLocation; //按top bottom left right来传\n\n        vec4 blendTexture(vec4 source, vec4 blend) {\n            if (blend.a <= 0.0) {\n                return source;\n            }\n            float sourceAlpha = 1.0 - blend.a;\n            float alpha = max(source.a, blend.a);\n            float r = max(0.0, min(sourceAlpha * source.r + blend.r, 1.0));\n            float g = max(0.0, min(sourceAlpha * source.g + blend.g, 1.0));\n            float b = max(0.0, min(sourceAlpha * source.b + blend.b, 1.0));\n            vec4 result = vec4(r, g, b, alpha);\n            if (alpha != 1.0) {\n                r = r + (1.0 - alpha) * 0.95;\n                g = g + (1.0 - alpha) * 0.95;\n                b = b + (1.0 - alpha) * 0.95;\n                r = max(0.0, min(r, 1.0));\n                g = max(0.0, min(g, 1.0));\n                b = max(0.0, min(b, 1.0));\n                return vec4(r, g, b, 1.0);\n            } else {\n                return vec4(r, g, b, alpha);\n            }\n        }\n\n        void main () {\n            vec4 videoColor;\n            vec4 blendElementsColor;\n\n            if (hasBlurBgTexture == 1) {\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texBlurBgCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texBlurBgCoord);\n                }\n                if (videoColor.a != 1.0) {\n                    videoColor.a = 0.0;\n                }\n                if (gl_FragCoord.y > centerLocation[0] || gl_FragCoord.y < centerLocation[1] ||\n                    gl_FragCoord.x > centerLocation[3] || gl_FragCoord.x < centerLocation[2]) {\n                    if (hasEmojiTexture == 1) {\n                        gl_FragColor = blendTexture(texture2D(blurBgTexture, v_texCoord), texture2D(emojiTexture, v_texEmojiCoord));\n                    } else {\n                        gl_FragColor = texture2D(blurBgTexture, v_texCoord);\n                    }\n                } else {\n                    if (hasEmojiTexture == 1) {\n                        gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texEmojiCoord));\n                    } else {\n                        gl_FragColor = videoColor;\n                    }\n                }\n            } else {\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texCoord);\n                }\n                if (videoColor.a != 1.0) {\n                    videoColor.a = 0.0;\n                }\n                if (hasEmojiTexture == 1) {\n                    gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texEmojiCoord));\n                } else {\n                    gl_FragColor = videoColor;\n                }\n            }\n        }\n        ");
    this.kZa = GLES20.glGetAttribLocation(this.kYZ, "a_position");
    this.kZb = GLES20.glGetAttribLocation(this.kYZ, "a_texCoord");
    this.kZc = GLES20.glGetAttribLocation(this.kYZ, "a_texEmojiCoord");
    this.kZm = GLES20.glGetAttribLocation(this.kYZ, "a_texBlurBgCoord");
    this.kZd = GLES20.glGetUniformLocation(this.kYZ, "videoExternalTexture");
    this.kZe = GLES20.glGetUniformLocation(this.kYZ, "videoNormalTexture");
    this.kZf = GLES20.glGetUniformLocation(this.kYZ, "emojiTexture");
    this.kZg = GLES20.glGetUniformLocation(this.kYZ, "hasEmojiTexture");
    this.kZi = GLES20.glGetUniformLocation(this.kYZ, "uMatrix");
    this.kZh = GLES20.glGetUniformLocation(this.kYZ, "useNormalVideoTexture");
    this.kZk = GLES20.glGetUniformLocation(this.kYZ, "blurBgTexture");
    this.kZj = GLES20.glGetUniformLocation(this.kYZ, "hasBlurBgTexture");
    this.kZl = GLES20.glGetUniformLocation(this.kYZ, "centerLocation");
    this.kZo.position(0);
    this.kZo.put(com.tencent.mm.media.k.c.lal);
    this.kZo.position(0);
    AppMethodBeat.o(259125);
  }
  
  protected final void aVw()
  {
    AppMethodBeat.i(93854);
    long l = Util.currentTicks();
    GLES20.glUseProgram(this.kYZ);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.textureType, this.kre);
    GLES20.glTexParameterf(this.textureType, 10241, 9729.0F);
    GLES20.glTexParameterf(this.textureType, 10240, 9729.0F);
    GLES20.glTexParameterf(this.textureType, 10242, 10497.0F);
    GLES20.glTexParameterf(this.textureType, 10243, 10497.0F);
    if (this.textureType == 3553)
    {
      GLES20.glUniform1i(this.kZh, 1);
      GLES20.glUniform1i(this.kZe, 0);
      GLES20.glUniform1i(this.kZd, 3);
      if (this.kYU == null) {
        break label536;
      }
      GLES20.glActiveTexture(33985);
      Object localObject = this.kYU;
      if (localObject != null) {
        d.a(this.kYV, (Bitmap)localObject);
      }
      GLES20.glUniform1i(this.kZf, 1);
      GLES20.glUniform1i(this.kZg, 1);
      label166:
      if (this.kYW == null) {
        break label555;
      }
      GLES20.glActiveTexture(33986);
      localObject = this.kYW;
      if (localObject != null) {
        d.a(this.kYX, (Bitmap)localObject);
      }
      GLES20.glUniform1i(this.kZk, 2);
      GLES20.glUniform1i(this.kZj, 1);
      localObject = ByteBuffer.allocateDirect(this.kYY.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      ((FloatBuffer)localObject).put(this.kYY).position(0);
      GLES20.glUniform4fv(this.kZl, 1, (FloatBuffer)localObject);
      this.kZp.position(0);
      GLES20.glVertexAttribPointer(this.kZm, 2, 5126, false, 0, (Buffer)this.kZp);
      GLES20.glEnableVertexAttribArray(this.kZm);
    }
    for (;;)
    {
      aVm().position(0);
      GLES20.glVertexAttribPointer(this.kZa, 2, 5126, false, 0, (Buffer)aVm());
      GLES20.glEnableVertexAttribArray(this.kZa);
      aVl().position(0);
      this.kZo.position(0);
      GLES20.glVertexAttribPointer(this.kZc, 2, 5126, false, 0, (Buffer)this.kZo);
      GLES20.glEnableVertexAttribArray(this.kZc);
      GLES20.glVertexAttribPointer(this.kZb, 2, 5126, false, 0, (Buffer)aVl());
      GLES20.glEnableVertexAttribArray(this.kZb);
      GLES20.glUniformMatrix4fv(this.kZi, 1, false, aVo(), 0);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.kZa);
      GLES20.glDisableVertexAttribArray(this.kZb);
      GLES20.glDisableVertexAttribArray(this.kZc);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
      GLES20.glFinish();
      GLES20.glUseProgram(0);
      this.kYU = null;
      this.kYW = null;
      Log.i(this.TAG, "draw frame used " + Util.ticksToNow(l) + "ms");
      AppMethodBeat.o(93854);
      return;
      GLES20.glUniform1i(this.kZh, 0);
      GLES20.glUniform1i(this.kZe, 3);
      GLES20.glUniform1i(this.kZd, 0);
      break;
      label536:
      GLES20.glUniform1i(this.kZf, 1);
      GLES20.glUniform1i(this.kZg, 0);
      break label166;
      label555:
      GLES20.glUniform1i(this.kZj, 0);
      GLES20.glUniform1i(this.kZk, 2);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(93855);
    super.release();
    this.kYV.close();
    this.kYX.close();
    AppMethodBeat.o(93855);
  }
  
  public final void ua(int paramInt)
  {
    this.kre = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.j.b.b
 * JD-Core Version:    0.7.0.1
 */