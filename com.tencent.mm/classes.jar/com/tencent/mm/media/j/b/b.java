package com.tencent.mm.media.j.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "blendAttributeBlurBgTextureCoord", "blendAttributePosition", "blendAttributeTextureCoord", "blendBitmapTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "blendBlurTextureCoordBuff", "Ljava/nio/FloatBuffer;", "blendCenterLocationBuffer", "", "blendProgramId", "blendTextureCoordBuff", "blendUniformBlurBgTexture", "blendUniformCenterLocation", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasBlurBgTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformUseNormalVideoTexture", "blurBgBitmap", "Landroid/graphics/Bitmap;", "blurBgBitmapTextureObj", "currentBlendBitmap", "emojiBlendAttributeTextureCoord", "inputTexture", "inputTextureHeight", "inputTextureWidth", "sizeBuffer", "kotlin.jvm.PlatformType", "textureType", "release", "", "renderImpl", "setBlendBitmap", "bitmap", "flip", "", "setBlurBgBitmap", "setBlurBgTextureCoordBuff", "blurBgCoord", "setCenterLocation", "top", "", "bottom", "left", "right", "setInputTexture", "texture", "setTextureType", "type", "plugin-mediaeditor_release"})
public class b
  extends a
{
  private final String TAG;
  public int gNq;
  private int hqC;
  private int hqD;
  private Bitmap hqE;
  private d hqF;
  public Bitmap hqG;
  private d hqH;
  public final float[] hqI;
  private int hqJ;
  private int hqK;
  private int hqL;
  private int hqM;
  private int hqN;
  private int hqO;
  private int hqP;
  private int hqQ;
  private int hqR;
  private int hqS;
  private int hqT;
  private int hqU;
  private int hqV;
  private int hqW;
  private final FloatBuffer hqX;
  private FloatBuffer hqY;
  public FloatBuffer hqZ;
  public int textureType;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(217530);
    this.TAG = "MircoMsg.GLTextureRenderProcBlend";
    this.hqI = new float[4];
    this.hqX = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    Object localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.hrx.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.hqY = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.hrx.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.hqZ = ((FloatBuffer)localObject);
    this.textureType = 36197;
    this.hqC = paramInt1;
    this.hqD = paramInt2;
    this.hqF = com.tencent.mm.media.g.c.a(true, 4L);
    this.hqH = com.tencent.mm.media.g.c.a(true, 4L);
    localObject = com.tencent.mm.media.k.c.hrD;
    this.hqJ = c.a.az("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        attribute vec2 a_texBlurBgCoord;\n        attribute vec2 a_texEmojiCoord;\n        varying vec2 v_texCoord;\n        varying vec2 v_texBlurBgCoord;\n        varying vec2 v_texEmojiCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n            v_texBlurBgCoord = a_texBlurBgCoord;\n            v_texEmojiCoord = a_texEmojiCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        varying vec2 v_texBlurBgCoord;\n        varying vec2 v_texEmojiCoord;\n        uniform samplerExternalOES videoExternalTexture;\n        uniform sampler2D videoNormalTexture;\n        uniform sampler2D emojiTexture;\n        uniform sampler2D blurBgTexture;\n        uniform int hasEmojiTexture;\n        uniform int useNormalVideoTexture;\n        uniform int hasBlurBgTexture;\n        uniform vec4 centerLocation; //按top bottom left right来传\n\n        vec4 blendTexture(vec4 source, vec4 blend) {\n            if (blend.a <= 0.0) {\n                return source;\n            }\n            float sourceAlpha = 1.0 - blend.a;\n            float alpha = max(source.a, blend.a);\n            float r = max(0.0, min(sourceAlpha * source.r + blend.r, 1.0));\n            float g = max(0.0, min(sourceAlpha * source.g + blend.g, 1.0));\n            float b = max(0.0, min(sourceAlpha * source.b + blend.b, 1.0));\n            vec4 result = vec4(r, g, b, alpha);\n            if (alpha != 1.0) {\n                r = r + (1.0 - alpha) * 0.95;\n                g = g + (1.0 - alpha) * 0.95;\n                b = b + (1.0 - alpha) * 0.95;\n                r = max(0.0, min(r, 1.0));\n                g = max(0.0, min(g, 1.0));\n                b = max(0.0, min(b, 1.0));\n                return vec4(r, g, b, 1.0);\n            } else {\n                return vec4(r, g, b, alpha);\n            }\n        }\n\n        void main () {\n            vec4 videoColor;\n            vec4 blendElementsColor;\n\n            if (hasBlurBgTexture == 1) {\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texBlurBgCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texBlurBgCoord);\n                }\n                if (videoColor.a != 1.0) {\n                    videoColor.a = 0.0;\n                }\n                if (gl_FragCoord.y > centerLocation[0] || gl_FragCoord.y < centerLocation[1] ||\n                    gl_FragCoord.x > centerLocation[3] || gl_FragCoord.x < centerLocation[2]) {\n                    if (hasEmojiTexture == 1) {\n                        gl_FragColor = blendTexture(texture2D(blurBgTexture, v_texCoord), texture2D(emojiTexture, v_texEmojiCoord));\n                    } else {\n                        gl_FragColor = texture2D(blurBgTexture, v_texCoord);\n                    }\n                } else {\n                    if (hasEmojiTexture == 1) {\n                        gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texEmojiCoord));\n                    } else {\n                        gl_FragColor = videoColor;\n                    }\n                }\n            } else {\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texCoord);\n                }\n                if (videoColor.a != 1.0) {\n                    videoColor.a = 0.0;\n                }\n                if (hasEmojiTexture == 1) {\n                    gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texEmojiCoord));\n                } else {\n                    gl_FragColor = videoColor;\n                }\n            }\n        }\n        ");
    this.hqK = GLES20.glGetAttribLocation(this.hqJ, "a_position");
    this.hqL = GLES20.glGetAttribLocation(this.hqJ, "a_texCoord");
    this.hqM = GLES20.glGetAttribLocation(this.hqJ, "a_texEmojiCoord");
    this.hqW = GLES20.glGetAttribLocation(this.hqJ, "a_texBlurBgCoord");
    this.hqN = GLES20.glGetUniformLocation(this.hqJ, "videoExternalTexture");
    this.hqO = GLES20.glGetUniformLocation(this.hqJ, "videoNormalTexture");
    this.hqP = GLES20.glGetUniformLocation(this.hqJ, "emojiTexture");
    this.hqQ = GLES20.glGetUniformLocation(this.hqJ, "hasEmojiTexture");
    this.hqS = GLES20.glGetUniformLocation(this.hqJ, "uMatrix");
    this.hqR = GLES20.glGetUniformLocation(this.hqJ, "useNormalVideoTexture");
    this.hqU = GLES20.glGetUniformLocation(this.hqJ, "blurBgTexture");
    this.hqT = GLES20.glGetUniformLocation(this.hqJ, "hasBlurBgTexture");
    this.hqV = GLES20.glGetUniformLocation(this.hqJ, "centerLocation");
    this.hqY.position(0);
    this.hqY.put(com.tencent.mm.media.k.c.hry);
    this.hqY.position(0);
    AppMethodBeat.o(217530);
  }
  
  protected final void aut()
  {
    AppMethodBeat.i(93854);
    long l = bu.HQ();
    GLES20.glUseProgram(this.hqJ);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.textureType, this.gNq);
    GLES20.glTexParameterf(this.textureType, 10241, 9729.0F);
    GLES20.glTexParameterf(this.textureType, 10240, 9729.0F);
    GLES20.glTexParameterf(this.textureType, 10242, 10497.0F);
    GLES20.glTexParameterf(this.textureType, 10243, 10497.0F);
    if (this.textureType == 3553)
    {
      GLES20.glUniform1i(this.hqR, 1);
      GLES20.glUniform1i(this.hqO, 0);
      GLES20.glUniform1i(this.hqN, 3);
      if (this.hqE == null) {
        break label536;
      }
      GLES20.glActiveTexture(33985);
      Object localObject = this.hqE;
      if (localObject != null) {
        d.a(this.hqF, (Bitmap)localObject);
      }
      GLES20.glUniform1i(this.hqP, 1);
      GLES20.glUniform1i(this.hqQ, 1);
      label166:
      if (this.hqG == null) {
        break label555;
      }
      GLES20.glActiveTexture(33986);
      localObject = this.hqG;
      if (localObject != null) {
        d.a(this.hqH, (Bitmap)localObject);
      }
      GLES20.glUniform1i(this.hqU, 2);
      GLES20.glUniform1i(this.hqT, 1);
      localObject = ByteBuffer.allocateDirect(this.hqI.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      ((FloatBuffer)localObject).put(this.hqI).position(0);
      GLES20.glUniform4fv(this.hqV, 1, (FloatBuffer)localObject);
      this.hqZ.position(0);
      GLES20.glVertexAttribPointer(this.hqW, 2, 5126, false, 0, (Buffer)this.hqZ);
      GLES20.glEnableVertexAttribArray(this.hqW);
    }
    for (;;)
    {
      this.gNV.position(0);
      GLES20.glVertexAttribPointer(this.hqK, 2, 5126, false, 0, (Buffer)this.gNV);
      GLES20.glEnableVertexAttribArray(this.hqK);
      this.gNU.position(0);
      this.hqY.position(0);
      GLES20.glVertexAttribPointer(this.hqM, 2, 5126, false, 0, (Buffer)this.hqY);
      GLES20.glEnableVertexAttribArray(this.hqM);
      GLES20.glVertexAttribPointer(this.hqL, 2, 5126, false, 0, (Buffer)this.gNU);
      GLES20.glEnableVertexAttribArray(this.hqL);
      GLES20.glUniformMatrix4fv(this.hqS, 1, false, this.hql, 0);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.hqK);
      GLES20.glDisableVertexAttribArray(this.hqL);
      GLES20.glDisableVertexAttribArray(this.hqM);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
      GLES20.glFinish();
      GLES20.glUseProgram(0);
      this.hqE = null;
      this.hqG = null;
      ae.i(this.TAG, "draw frame used " + bu.aO(l) + "ms");
      AppMethodBeat.o(93854);
      return;
      GLES20.glUniform1i(this.hqR, 0);
      GLES20.glUniform1i(this.hqO, 3);
      GLES20.glUniform1i(this.hqN, 0);
      break;
      label536:
      GLES20.glUniform1i(this.hqP, 1);
      GLES20.glUniform1i(this.hqQ, 0);
      break label166;
      label555:
      GLES20.glUniform1i(this.hqT, 0);
      GLES20.glUniform1i(this.hqU, 2);
    }
  }
  
  public final void nQ(int paramInt)
  {
    this.gNq = paramInt;
  }
  
  public final void release()
  {
    AppMethodBeat.i(93855);
    super.release();
    this.hqF.close();
    this.hqH.close();
    AppMethodBeat.o(93855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.j.b.b
 * JD-Core Version:    0.7.0.1
 */