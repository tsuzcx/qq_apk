package com.tencent.mm.media.h.b;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "blendTextureScaleType", "(IIIIIII)V", "TAG", "", "blendAttributePosition", "blendAttributeTextureCoord", "blendBitmapTexture", "blendProgramId", "blendTextureCoordBuff", "Ljava/nio/FloatBuffer;", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformUseNormalVideoTexture", "currentBlendBitmap", "Landroid/graphics/Bitmap;", "inputTexture", "inputTextureHeight", "inputTextureWidth", "sizeBuffer", "kotlin.jvm.PlatformType", "renderImpl", "", "setBlendBitmap", "bitmap", "setInputTexture", "texture", "plugin-mediaeditor_release"})
public final class b
  extends a
{
  private final String TAG;
  private int eYJ;
  private int eYK;
  public Bitmap eYL;
  private int eYM;
  private int eYN;
  private int eYO;
  private int eYP;
  private int eYQ;
  private int eYR;
  private int eYS;
  private int eYT;
  private int eYU;
  private int eYV;
  private final FloatBuffer eYW;
  private FloatBuffer eYX;
  private final int eYY;
  private int eYd;
  
  private b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(13101);
    this.eYY = 1;
    this.TAG = "MircoMsg.GLTextureRenderProcBlend";
    this.eYW = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    Object localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.i.b.eZr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    j.p(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.eYX = ((FloatBuffer)localObject);
    this.eYJ = paramInt1;
    this.eYK = paramInt2;
    localObject = com.tencent.mm.media.i.b.eZw;
    this.eYM = b.a.Vm();
    localObject = com.tencent.mm.media.i.b.eZw;
    this.eYN = b.a.Z("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES videoExternalTexture;\n        uniform sampler2D videoNormalTexture;\n        uniform sampler2D emojiTexture;\n        uniform int hasEmojiTexture;\n        uniform int useNormalVideoTexture;\n\n        vec4 blendTexture(vec4 source, vec4 blend) {\n            if (blend.a <= 0.0) {\n                return source;\n            }\n            float sourceAlpha = 1.0 - blend.a;\n            float alpha = max(source.a, blend.a);\n            float r = max(0.0, min(sourceAlpha * source.r + blend.r, 1.0));\n            float g = max(0.0, min(sourceAlpha * source.g + blend.g, 1.0));\n            float b = max(0.0, min(sourceAlpha * source.b + blend.b, 1.0));\n            vec4 result = vec4(r, g, b, alpha);\n            if (alpha != 1.0) {\n                r = r + (1.0 - alpha) * 0.95;\n                g = g + (1.0 - alpha) * 0.95;\n                b = b + (1.0 - alpha) * 0.95;\n                r = max(0.0, min(r, 1.0));\n                g = max(0.0, min(g, 1.0));\n                b = max(0.0, min(b, 1.0));\n                return vec4(r, g, b, 1.0);\n            } else {\n                return vec4(r, g, b, alpha);\n            }\n        }\n\n        void main () {\n            vec4 videoColor;\n            if (useNormalVideoTexture == 1) {\n                videoColor = texture2D(videoNormalTexture, v_texCoord);\n            } else {\n                videoColor = texture2D(videoExternalTexture, v_texCoord);\n            }\n            if (videoColor.a != 1.0) {\n                videoColor.a = 0.0;\n            }\n            if (hasEmojiTexture == 1) {\n                gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texCoord));\n            } else {\n                gl_FragColor = videoColor;\n            }\n        }\n        ");
    this.eYO = GLES20.glGetAttribLocation(this.eYN, "a_position");
    this.eYP = GLES20.glGetAttribLocation(this.eYN, "a_texCoord");
    this.eYQ = GLES20.glGetUniformLocation(this.eYN, "videoExternalTexture");
    this.eYR = GLES20.glGetUniformLocation(this.eYN, "videoNormalTexture");
    this.eYS = GLES20.glGetUniformLocation(this.eYN, "emojiTexture");
    this.eYT = GLES20.glGetUniformLocation(this.eYN, "hasEmojiTexture");
    this.eYV = GLES20.glGetUniformLocation(this.eYN, "uMatrix");
    this.eYU = GLES20.glGetUniformLocation(this.eYN, "useNormalVideoTexture");
    this.eYX.position(0);
    this.eYX.put(com.tencent.mm.media.i.b.eZr);
    this.eYX.position(0);
    AppMethodBeat.o(13101);
  }
  
  protected final void Vj()
  {
    AppMethodBeat.i(13100);
    long l = bo.yB();
    GLES20.glUseProgram(this.eYN);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, this.eYd);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 10497.0F);
    GLES20.glTexParameterf(36197, 10243, 10497.0F);
    GLES20.glUniform1i(this.eYQ, 0);
    GLES20.glUniform1i(this.eYR, 2);
    if (this.eYL != null)
    {
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.eYM);
      GLUtils.texImage2D(3553, 0, this.eYL, 0);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 10497.0F);
      GLES20.glTexParameterf(3553, 10243, 10497.0F);
    }
    GLES20.glUniform1i(this.eYS, 1);
    this.eYv.position(0);
    GLES20.glVertexAttribPointer(this.eYO, 2, 5126, false, 0, (Buffer)this.eYv);
    GLES20.glEnableVertexAttribArray(this.eYO);
    this.eYu.position(0);
    this.eYX.position(0);
    GLES20.glVertexAttribPointer(this.eYP, 2, 5126, false, 0, (Buffer)this.eYX);
    GLES20.glEnableVertexAttribArray(this.eYP);
    GLES20.glUniformMatrix4fv(this.eYV, 1, false, this.eYz, 0);
    if (this.eYL != null) {
      GLES20.glUniform1i(this.eYT, 1);
    }
    for (;;)
    {
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.eYO);
      GLES20.glDisableVertexAttribArray(this.eYP);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
      GLES20.glFinish();
      GLES20.glUseProgram(0);
      this.eYL = null;
      ab.i(this.TAG, "draw frame used " + bo.av(l) + "ms");
      AppMethodBeat.o(13100);
      return;
      GLES20.glUniform1i(this.eYT, 0);
    }
  }
  
  public final void jY(int paramInt)
  {
    this.eYd = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.h.b.b
 * JD-Core Version:    0.7.0.1
 */