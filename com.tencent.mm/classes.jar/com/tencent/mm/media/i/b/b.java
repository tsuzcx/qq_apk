package com.tencent.mm.media.i.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "blendAttributeBlurBgTextureCoord", "blendAttributePosition", "blendAttributeTextureCoord", "blendBitmapTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "blendBlurTextureCoordBuff", "Ljava/nio/FloatBuffer;", "blendCenterLocationBuffer", "", "blendProgramId", "blendTextureCoordBuff", "blendUniformBlurBgTexture", "blendUniformCenterLocation", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasBlurBgTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformUseNormalVideoTexture", "blurBgBitmap", "Landroid/graphics/Bitmap;", "blurBgBitmapTextureObj", "currentBlendBitmap", "emojiBlendAttributeTextureCoord", "inputTexture", "inputTextureHeight", "inputTextureWidth", "sizeBuffer", "kotlin.jvm.PlatformType", "textureType", "release", "", "renderImpl", "setBlendBitmap", "bitmap", "flip", "", "setBlurBgBitmap", "setBlurBgTextureCoordBuff", "blurBgCoord", "setCenterLocation", "top", "", "bottom", "left", "right", "setInputTexture", "texture", "setTextureType", "type", "plugin-mediaeditor_release"})
public class b
  extends a
{
  private final String TAG;
  private int gVI;
  private int gVJ;
  private Bitmap gVK;
  private d gVL;
  public Bitmap gVM;
  private d gVN;
  public final float[] gVO;
  private int gVP;
  private int gVQ;
  private int gVR;
  private int gVS;
  private int gVT;
  private int gVU;
  private int gVV;
  private int gVW;
  private int gVX;
  private int gVY;
  private int gVZ;
  private int gWa;
  private int gWb;
  private int gWc;
  private final FloatBuffer gWd;
  private FloatBuffer gWe;
  public FloatBuffer gWf;
  public int gqX;
  public int textureType;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(209910);
    this.TAG = "MircoMsg.GLTextureRenderProcBlend";
    this.gVO = new float[4];
    this.gWd = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    Object localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.j.c.gWD.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    k.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.gWe = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.j.c.gWD.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    k.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.gWf = ((FloatBuffer)localObject);
    this.textureType = 36197;
    this.gVI = paramInt1;
    this.gVJ = paramInt2;
    this.gVL = com.tencent.mm.media.f.c.a(true, 4L);
    this.gVN = com.tencent.mm.media.f.c.a(true, 4L);
    localObject = com.tencent.mm.media.j.c.gWJ;
    this.gVP = c.a.ax("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        attribute vec2 a_texBlurBgCoord;\n        attribute vec2 a_texEmojiCoord;\n        varying vec2 v_texCoord;\n        varying vec2 v_texBlurBgCoord;\n        varying vec2 v_texEmojiCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n            v_texBlurBgCoord = a_texBlurBgCoord;\n            v_texEmojiCoord = a_texEmojiCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        varying vec2 v_texBlurBgCoord;\n        varying vec2 v_texEmojiCoord;\n        uniform samplerExternalOES videoExternalTexture;\n        uniform sampler2D videoNormalTexture;\n        uniform sampler2D emojiTexture;\n        uniform sampler2D blurBgTexture;\n        uniform int hasEmojiTexture;\n        uniform int useNormalVideoTexture;\n        uniform int hasBlurBgTexture;\n        uniform vec4 centerLocation; //按top bottom left right来传\n\n        vec4 blendTexture(vec4 source, vec4 blend) {\n            if (blend.a <= 0.0) {\n                return source;\n            }\n            float sourceAlpha = 1.0 - blend.a;\n            float alpha = max(source.a, blend.a);\n            float r = max(0.0, min(sourceAlpha * source.r + blend.r, 1.0));\n            float g = max(0.0, min(sourceAlpha * source.g + blend.g, 1.0));\n            float b = max(0.0, min(sourceAlpha * source.b + blend.b, 1.0));\n            vec4 result = vec4(r, g, b, alpha);\n            if (alpha != 1.0) {\n                r = r + (1.0 - alpha) * 0.95;\n                g = g + (1.0 - alpha) * 0.95;\n                b = b + (1.0 - alpha) * 0.95;\n                r = max(0.0, min(r, 1.0));\n                g = max(0.0, min(g, 1.0));\n                b = max(0.0, min(b, 1.0));\n                return vec4(r, g, b, 1.0);\n            } else {\n                return vec4(r, g, b, alpha);\n            }\n        }\n\n        void main () {\n            vec4 videoColor;\n            vec4 blendElementsColor;\n\n            if (hasBlurBgTexture == 1) {\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texBlurBgCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texBlurBgCoord);\n                }\n                if (videoColor.a != 1.0) {\n                    videoColor.a = 0.0;\n                }\n                if (gl_FragCoord.y > centerLocation[0] || gl_FragCoord.y < centerLocation[1] ||\n                    gl_FragCoord.x > centerLocation[3] || gl_FragCoord.x < centerLocation[2]) {\n                    if (hasEmojiTexture == 1) {\n                        gl_FragColor = blendTexture(texture2D(blurBgTexture, v_texCoord), texture2D(emojiTexture, v_texEmojiCoord));\n                    } else {\n                        gl_FragColor = texture2D(blurBgTexture, v_texCoord);\n                    }\n                } else {\n                    if (hasEmojiTexture == 1) {\n                        gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texEmojiCoord));\n                    } else {\n                        gl_FragColor = videoColor;\n                    }\n                }\n            } else {\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texCoord);\n                }\n                if (videoColor.a != 1.0) {\n                    videoColor.a = 0.0;\n                }\n                if (hasEmojiTexture == 1) {\n                    gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texEmojiCoord));\n                } else {\n                    gl_FragColor = videoColor;\n                }\n            }\n        }\n        ");
    this.gVQ = GLES20.glGetAttribLocation(this.gVP, "a_position");
    this.gVR = GLES20.glGetAttribLocation(this.gVP, "a_texCoord");
    this.gVS = GLES20.glGetAttribLocation(this.gVP, "a_texEmojiCoord");
    this.gWc = GLES20.glGetAttribLocation(this.gVP, "a_texBlurBgCoord");
    this.gVT = GLES20.glGetUniformLocation(this.gVP, "videoExternalTexture");
    this.gVU = GLES20.glGetUniformLocation(this.gVP, "videoNormalTexture");
    this.gVV = GLES20.glGetUniformLocation(this.gVP, "emojiTexture");
    this.gVW = GLES20.glGetUniformLocation(this.gVP, "hasEmojiTexture");
    this.gVY = GLES20.glGetUniformLocation(this.gVP, "uMatrix");
    this.gVX = GLES20.glGetUniformLocation(this.gVP, "useNormalVideoTexture");
    this.gWa = GLES20.glGetUniformLocation(this.gVP, "blurBgTexture");
    this.gVZ = GLES20.glGetUniformLocation(this.gVP, "hasBlurBgTexture");
    this.gWb = GLES20.glGetUniformLocation(this.gVP, "centerLocation");
    this.gWe.position(0);
    this.gWe.put(com.tencent.mm.media.j.c.gWE);
    this.gWe.position(0);
    AppMethodBeat.o(209910);
  }
  
  protected final void arr()
  {
    AppMethodBeat.i(93854);
    long l = bs.Gn();
    GLES20.glUseProgram(this.gVP);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.textureType, this.gqX);
    GLES20.glTexParameterf(this.textureType, 10241, 9729.0F);
    GLES20.glTexParameterf(this.textureType, 10240, 9729.0F);
    GLES20.glTexParameterf(this.textureType, 10242, 10497.0F);
    GLES20.glTexParameterf(this.textureType, 10243, 10497.0F);
    if (this.textureType == 3553)
    {
      GLES20.glUniform1i(this.gVX, 1);
      GLES20.glUniform1i(this.gVU, 0);
      GLES20.glUniform1i(this.gVT, 3);
      if (this.gVK == null) {
        break label536;
      }
      GLES20.glActiveTexture(33985);
      Object localObject = this.gVK;
      if (localObject != null) {
        d.a(this.gVL, (Bitmap)localObject);
      }
      GLES20.glUniform1i(this.gVV, 1);
      GLES20.glUniform1i(this.gVW, 1);
      label166:
      if (this.gVM == null) {
        break label555;
      }
      GLES20.glActiveTexture(33986);
      localObject = this.gVM;
      if (localObject != null) {
        d.a(this.gVN, (Bitmap)localObject);
      }
      GLES20.glUniform1i(this.gWa, 2);
      GLES20.glUniform1i(this.gVZ, 1);
      localObject = ByteBuffer.allocateDirect(this.gVO.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      ((FloatBuffer)localObject).put(this.gVO).position(0);
      GLES20.glUniform4fv(this.gWb, 1, (FloatBuffer)localObject);
      this.gWf.position(0);
      GLES20.glVertexAttribPointer(this.gWc, 2, 5126, false, 0, (Buffer)this.gWf);
      GLES20.glEnableVertexAttribArray(this.gWc);
    }
    for (;;)
    {
      this.grE.position(0);
      GLES20.glVertexAttribPointer(this.gVQ, 2, 5126, false, 0, (Buffer)this.grE);
      GLES20.glEnableVertexAttribArray(this.gVQ);
      this.grD.position(0);
      this.gWe.position(0);
      GLES20.glVertexAttribPointer(this.gVS, 2, 5126, false, 0, (Buffer)this.gWe);
      GLES20.glEnableVertexAttribArray(this.gVS);
      GLES20.glVertexAttribPointer(this.gVR, 2, 5126, false, 0, (Buffer)this.grD);
      GLES20.glEnableVertexAttribArray(this.gVR);
      GLES20.glUniformMatrix4fv(this.gVY, 1, false, this.gVu, 0);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.gVQ);
      GLES20.glDisableVertexAttribArray(this.gVR);
      GLES20.glDisableVertexAttribArray(this.gVS);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
      GLES20.glFinish();
      GLES20.glUseProgram(0);
      this.gVK = null;
      this.gVM = null;
      ac.i(this.TAG, "draw frame used " + bs.aO(l) + "ms");
      AppMethodBeat.o(93854);
      return;
      GLES20.glUniform1i(this.gVX, 0);
      GLES20.glUniform1i(this.gVU, 3);
      GLES20.glUniform1i(this.gVT, 0);
      break;
      label536:
      GLES20.glUniform1i(this.gVV, 1);
      GLES20.glUniform1i(this.gVW, 0);
      break label166;
      label555:
      GLES20.glUniform1i(this.gVZ, 0);
      GLES20.glUniform1i(this.gWa, 2);
    }
  }
  
  public final void b(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(209908);
    k.h(paramBitmap, "bitmap");
    this.gVK = paramBitmap;
    if (paramBoolean)
    {
      this.gWe.position(0);
      this.gWe.put(com.tencent.mm.media.j.c.gWE);
      this.gWe.position(0);
      AppMethodBeat.o(209908);
      return;
    }
    this.gWe.position(0);
    this.gWe.put(com.tencent.mm.media.j.c.gWD);
    this.gWe.position(0);
    AppMethodBeat.o(209908);
  }
  
  public final void no(int paramInt)
  {
    this.gqX = paramInt;
  }
  
  public final void release()
  {
    AppMethodBeat.i(93855);
    super.release();
    this.gVL.close();
    this.gVN.close();
    AppMethodBeat.o(93855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.i.b.b
 * JD-Core Version:    0.7.0.1
 */