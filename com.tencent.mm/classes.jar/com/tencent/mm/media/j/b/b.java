package com.tencent.mm.media.j.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "blendAttributeBlurBgTextureCoord", "blendAttributePosition", "blendAttributeTextureCoord", "blendBitmapTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "blendBlurTextureCoordBuff", "Ljava/nio/FloatBuffer;", "blendCenterLocationBuffer", "", "blendProgramId", "blendTextureCoordBuff", "blendUniformBlurBgTexture", "blendUniformCenterLocation", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasBlurBgTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformUseNormalVideoTexture", "blurBgBitmap", "Landroid/graphics/Bitmap;", "blurBgBitmapTextureObj", "currentBlendBitmap", "emojiBlendAttributeTextureCoord", "inputTexture", "inputTextureHeight", "inputTextureWidth", "sizeBuffer", "kotlin.jvm.PlatformType", "textureType", "release", "", "renderImpl", "setBlendBitmap", "bitmap", "flip", "", "setBlurBgBitmap", "setBlurBgTextureCoordBuff", "blurBgCoord", "setCenterLocation", "top", "", "bottom", "left", "right", "setInputTexture", "texture", "setTextureType", "type", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
  extends a
{
  private final String TAG;
  public int mVb;
  private int nDY;
  private int nDZ;
  private Bitmap nEa;
  private d nEb;
  public Bitmap nEc;
  private d nEd;
  public final float[] nEe;
  private int nEf;
  private int nEg;
  private int nEh;
  private int nEi;
  private int nEj;
  private int nEk;
  private int nEl;
  private int nEm;
  private int nEn;
  private int nEo;
  private int nEp;
  private int nEq;
  private int nEr;
  private int nEs;
  private final FloatBuffer nEt;
  private FloatBuffer nEu;
  public FloatBuffer nEv;
  public int textureType;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(237749);
    this.TAG = "MircoMsg.GLTextureRenderProcBlend";
    this.nEe = new float[4];
    this.nEt = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    Object localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.util.c.nFu.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    s.s(localObject, "allocateDirect(GLEnviron…eOrder()).asFloatBuffer()");
    this.nEu = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.util.c.nFu.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    s.s(localObject, "allocateDirect(GLEnviron…eOrder()).asFloatBuffer()");
    this.nEv = ((FloatBuffer)localObject);
    this.textureType = 36197;
    this.nDY = paramInt1;
    this.nDZ = paramInt2;
    this.nEb = com.tencent.mm.media.g.c.d(true, 4L);
    this.nEd = com.tencent.mm.media.g.c.d(true, 4L);
    localObject = com.tencent.mm.media.util.c.nFs;
    this.nEf = c.a.aN("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        attribute vec2 a_texBlurBgCoord;\n        attribute vec2 a_texEmojiCoord;\n        varying vec2 v_texCoord;\n        varying vec2 v_texBlurBgCoord;\n        varying vec2 v_texEmojiCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n            v_texBlurBgCoord = a_texBlurBgCoord;\n            v_texEmojiCoord = a_texEmojiCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        varying vec2 v_texBlurBgCoord;\n        varying vec2 v_texEmojiCoord;\n        uniform samplerExternalOES videoExternalTexture;\n        uniform sampler2D videoNormalTexture;\n        uniform sampler2D emojiTexture;\n        uniform sampler2D blurBgTexture;\n        uniform int hasEmojiTexture;\n        uniform int useNormalVideoTexture;\n        uniform int hasBlurBgTexture;\n        uniform vec4 centerLocation; //按top bottom left right来传\n\n        vec4 blendTexture(vec4 source, vec4 blend) {\n            if (blend.a <= 0.0) {\n                return source;\n            }\n            float sourceAlpha = 1.0 - blend.a;\n            float alpha = max(source.a, blend.a);\n            float r = max(0.0, min(sourceAlpha * source.r + blend.r, 1.0));\n            float g = max(0.0, min(sourceAlpha * source.g + blend.g, 1.0));\n            float b = max(0.0, min(sourceAlpha * source.b + blend.b, 1.0));\n            vec4 result = vec4(r, g, b, alpha);\n            if (alpha != 1.0) {\n                r = r + (1.0 - alpha) * 0.95;\n                g = g + (1.0 - alpha) * 0.95;\n                b = b + (1.0 - alpha) * 0.95;\n                r = max(0.0, min(r, 1.0));\n                g = max(0.0, min(g, 1.0));\n                b = max(0.0, min(b, 1.0));\n                return vec4(r, g, b, 1.0);\n            } else {\n                return vec4(r, g, b, alpha);\n            }\n        }\n\n        void main () {\n            vec4 videoColor;\n            vec4 blendElementsColor;\n\n            if (hasBlurBgTexture == 1) {\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texBlurBgCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texBlurBgCoord);\n                }\n                if (videoColor.a != 1.0) {\n                    videoColor.a = 0.0;\n                }\n                if (gl_FragCoord.y > centerLocation[0] || gl_FragCoord.y < centerLocation[1] ||\n                    gl_FragCoord.x > centerLocation[3] || gl_FragCoord.x < centerLocation[2]) {\n                    if (hasEmojiTexture == 1) {\n                        gl_FragColor = blendTexture(texture2D(blurBgTexture, v_texCoord), texture2D(emojiTexture, v_texEmojiCoord));\n                    } else {\n                        gl_FragColor = texture2D(blurBgTexture, v_texCoord);\n                    }\n                } else {\n                    if (hasEmojiTexture == 1) {\n                        gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texEmojiCoord));\n                    } else {\n                        gl_FragColor = videoColor;\n                    }\n                }\n            } else {\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texCoord);\n                }\n                if (videoColor.a != 1.0) {\n                    videoColor.a = 0.0;\n                }\n                if (hasEmojiTexture == 1) {\n                    gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texEmojiCoord));\n                } else {\n                    gl_FragColor = videoColor;\n                }\n            }\n        }\n        ");
    this.nEg = GLES20.glGetAttribLocation(this.nEf, "a_position");
    this.nEh = GLES20.glGetAttribLocation(this.nEf, "a_texCoord");
    this.nEi = GLES20.glGetAttribLocation(this.nEf, "a_texEmojiCoord");
    this.nEs = GLES20.glGetAttribLocation(this.nEf, "a_texBlurBgCoord");
    this.nEj = GLES20.glGetUniformLocation(this.nEf, "videoExternalTexture");
    this.nEk = GLES20.glGetUniformLocation(this.nEf, "videoNormalTexture");
    this.nEl = GLES20.glGetUniformLocation(this.nEf, "emojiTexture");
    this.nEm = GLES20.glGetUniformLocation(this.nEf, "hasEmojiTexture");
    this.nEo = GLES20.glGetUniformLocation(this.nEf, "uMatrix");
    this.nEn = GLES20.glGetUniformLocation(this.nEf, "useNormalVideoTexture");
    this.nEq = GLES20.glGetUniformLocation(this.nEf, "blurBgTexture");
    this.nEp = GLES20.glGetUniformLocation(this.nEf, "hasBlurBgTexture");
    this.nEr = GLES20.glGetUniformLocation(this.nEf, "centerLocation");
    this.nEu.position(0);
    this.nEu.put(com.tencent.mm.media.util.c.nFv);
    this.nEu.position(0);
    AppMethodBeat.o(237749);
  }
  
  protected final void bqg()
  {
    AppMethodBeat.i(93854);
    long l = Util.currentTicks();
    GLES20.glUseProgram(this.nEf);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.textureType, this.mVb);
    GLES20.glTexParameterf(this.textureType, 10241, 9729.0F);
    GLES20.glTexParameterf(this.textureType, 10240, 9729.0F);
    GLES20.glTexParameterf(this.textureType, 10242, 10497.0F);
    GLES20.glTexParameterf(this.textureType, 10243, 10497.0F);
    if (this.textureType == 3553)
    {
      GLES20.glUniform1i(this.nEn, 1);
      GLES20.glUniform1i(this.nEk, 0);
      GLES20.glUniform1i(this.nEj, 3);
      if (this.nEa == null) {
        break label536;
      }
      GLES20.glActiveTexture(33985);
      Object localObject = this.nEa;
      if (localObject != null) {
        d.a(this.nEb, (Bitmap)localObject);
      }
      GLES20.glUniform1i(this.nEl, 1);
      GLES20.glUniform1i(this.nEm, 1);
      label166:
      if (this.nEc == null) {
        break label555;
      }
      GLES20.glActiveTexture(33986);
      localObject = this.nEc;
      if (localObject != null) {
        d.a(this.nEd, (Bitmap)localObject);
      }
      GLES20.glUniform1i(this.nEq, 2);
      GLES20.glUniform1i(this.nEp, 1);
      localObject = ByteBuffer.allocateDirect(this.nEe.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      ((FloatBuffer)localObject).put(this.nEe).position(0);
      GLES20.glUniform4fv(this.nEr, 1, (FloatBuffer)localObject);
      this.nEv.position(0);
      GLES20.glVertexAttribPointer(this.nEs, 2, 5126, false, 0, (Buffer)this.nEv);
      GLES20.glEnableVertexAttribArray(this.nEs);
    }
    for (;;)
    {
      bpW().position(0);
      GLES20.glVertexAttribPointer(this.nEg, 2, 5126, false, 0, (Buffer)bpW());
      GLES20.glEnableVertexAttribArray(this.nEg);
      bpV().position(0);
      this.nEu.position(0);
      GLES20.glVertexAttribPointer(this.nEi, 2, 5126, false, 0, (Buffer)this.nEu);
      GLES20.glEnableVertexAttribArray(this.nEi);
      GLES20.glVertexAttribPointer(this.nEh, 2, 5126, false, 0, (Buffer)bpV());
      GLES20.glEnableVertexAttribArray(this.nEh);
      GLES20.glUniformMatrix4fv(this.nEo, 1, false, bpY(), 0);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.nEg);
      GLES20.glDisableVertexAttribArray(this.nEh);
      GLES20.glDisableVertexAttribArray(this.nEi);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
      GLES20.glFinish();
      GLES20.glUseProgram(0);
      this.nEa = null;
      this.nEc = null;
      Log.i(this.TAG, "draw frame used " + Util.ticksToNow(l) + "ms");
      AppMethodBeat.o(93854);
      return;
      GLES20.glUniform1i(this.nEn, 0);
      GLES20.glUniform1i(this.nEk, 3);
      GLES20.glUniform1i(this.nEj, 0);
      break;
      label536:
      GLES20.glUniform1i(this.nEl, 1);
      GLES20.glUniform1i(this.nEm, 0);
      break label166;
      label555:
      GLES20.glUniform1i(this.nEp, 0);
      GLES20.glUniform1i(this.nEq, 2);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(93855);
    super.release();
    this.nEb.close();
    this.nEd.close();
    AppMethodBeat.o(93855);
  }
  
  public final void uc(int paramInt)
  {
    this.mVb = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.j.b.b
 * JD-Core Version:    0.7.0.1
 */