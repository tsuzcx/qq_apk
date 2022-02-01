package com.tencent.mm.media.j.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "blendAttributeBlurBgTextureCoord", "blendAttributePosition", "blendAttributeTextureCoord", "blendBitmapTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "blendBlurTextureCoordBuff", "Ljava/nio/FloatBuffer;", "blendCenterLocationBuffer", "", "blendProgramId", "blendTextureCoordBuff", "blendUniformBlurBgTexture", "blendUniformCenterLocation", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasBlurBgTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformUseNormalVideoTexture", "blurBgBitmap", "Landroid/graphics/Bitmap;", "blurBgBitmapTextureObj", "currentBlendBitmap", "emojiBlendAttributeTextureCoord", "inputTexture", "inputTextureHeight", "inputTextureWidth", "sizeBuffer", "kotlin.jvm.PlatformType", "textureType", "release", "", "renderImpl", "setBlendBitmap", "bitmap", "flip", "", "setBlurBgBitmap", "setBlurBgTextureCoordBuff", "blurBgCoord", "setCenterLocation", "top", "", "bottom", "left", "right", "setInputTexture", "texture", "setTextureType", "type", "plugin-mediaeditor_release"})
public class b
  extends a
{
  private final String TAG;
  public int gKH;
  private int hnO;
  private int hnP;
  private Bitmap hnQ;
  private d hnR;
  public Bitmap hnS;
  private d hnT;
  public final float[] hnU;
  private int hnV;
  private int hnW;
  private int hnX;
  private int hnY;
  private int hnZ;
  private int hoa;
  private int hob;
  private int hoc;
  private int hod;
  private int hoe;
  private int hof;
  private int hog;
  private int hoh;
  private int hoi;
  private final FloatBuffer hoj;
  private FloatBuffer hok;
  public FloatBuffer hol;
  public int textureType;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(219304);
    this.TAG = "MircoMsg.GLTextureRenderProcBlend";
    this.hnU = new float[4];
    this.hoj = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    Object localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.hoJ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.hok = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.hoJ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.hol = ((FloatBuffer)localObject);
    this.textureType = 36197;
    this.hnO = paramInt1;
    this.hnP = paramInt2;
    this.hnR = com.tencent.mm.media.g.c.a(true, 4L);
    this.hnT = com.tencent.mm.media.g.c.a(true, 4L);
    localObject = com.tencent.mm.media.k.c.hoP;
    this.hnV = c.a.ay("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        attribute vec2 a_texBlurBgCoord;\n        attribute vec2 a_texEmojiCoord;\n        varying vec2 v_texCoord;\n        varying vec2 v_texBlurBgCoord;\n        varying vec2 v_texEmojiCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n            v_texBlurBgCoord = a_texBlurBgCoord;\n            v_texEmojiCoord = a_texEmojiCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        varying vec2 v_texBlurBgCoord;\n        varying vec2 v_texEmojiCoord;\n        uniform samplerExternalOES videoExternalTexture;\n        uniform sampler2D videoNormalTexture;\n        uniform sampler2D emojiTexture;\n        uniform sampler2D blurBgTexture;\n        uniform int hasEmojiTexture;\n        uniform int useNormalVideoTexture;\n        uniform int hasBlurBgTexture;\n        uniform vec4 centerLocation; //按top bottom left right来传\n\n        vec4 blendTexture(vec4 source, vec4 blend) {\n            if (blend.a <= 0.0) {\n                return source;\n            }\n            float sourceAlpha = 1.0 - blend.a;\n            float alpha = max(source.a, blend.a);\n            float r = max(0.0, min(sourceAlpha * source.r + blend.r, 1.0));\n            float g = max(0.0, min(sourceAlpha * source.g + blend.g, 1.0));\n            float b = max(0.0, min(sourceAlpha * source.b + blend.b, 1.0));\n            vec4 result = vec4(r, g, b, alpha);\n            if (alpha != 1.0) {\n                r = r + (1.0 - alpha) * 0.95;\n                g = g + (1.0 - alpha) * 0.95;\n                b = b + (1.0 - alpha) * 0.95;\n                r = max(0.0, min(r, 1.0));\n                g = max(0.0, min(g, 1.0));\n                b = max(0.0, min(b, 1.0));\n                return vec4(r, g, b, 1.0);\n            } else {\n                return vec4(r, g, b, alpha);\n            }\n        }\n\n        void main () {\n            vec4 videoColor;\n            vec4 blendElementsColor;\n\n            if (hasBlurBgTexture == 1) {\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texBlurBgCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texBlurBgCoord);\n                }\n                if (videoColor.a != 1.0) {\n                    videoColor.a = 0.0;\n                }\n                if (gl_FragCoord.y > centerLocation[0] || gl_FragCoord.y < centerLocation[1] ||\n                    gl_FragCoord.x > centerLocation[3] || gl_FragCoord.x < centerLocation[2]) {\n                    if (hasEmojiTexture == 1) {\n                        gl_FragColor = blendTexture(texture2D(blurBgTexture, v_texCoord), texture2D(emojiTexture, v_texEmojiCoord));\n                    } else {\n                        gl_FragColor = texture2D(blurBgTexture, v_texCoord);\n                    }\n                } else {\n                    if (hasEmojiTexture == 1) {\n                        gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texEmojiCoord));\n                    } else {\n                        gl_FragColor = videoColor;\n                    }\n                }\n            } else {\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texCoord);\n                }\n                if (videoColor.a != 1.0) {\n                    videoColor.a = 0.0;\n                }\n                if (hasEmojiTexture == 1) {\n                    gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texEmojiCoord));\n                } else {\n                    gl_FragColor = videoColor;\n                }\n            }\n        }\n        ");
    this.hnW = GLES20.glGetAttribLocation(this.hnV, "a_position");
    this.hnX = GLES20.glGetAttribLocation(this.hnV, "a_texCoord");
    this.hnY = GLES20.glGetAttribLocation(this.hnV, "a_texEmojiCoord");
    this.hoi = GLES20.glGetAttribLocation(this.hnV, "a_texBlurBgCoord");
    this.hnZ = GLES20.glGetUniformLocation(this.hnV, "videoExternalTexture");
    this.hoa = GLES20.glGetUniformLocation(this.hnV, "videoNormalTexture");
    this.hob = GLES20.glGetUniformLocation(this.hnV, "emojiTexture");
    this.hoc = GLES20.glGetUniformLocation(this.hnV, "hasEmojiTexture");
    this.hoe = GLES20.glGetUniformLocation(this.hnV, "uMatrix");
    this.hod = GLES20.glGetUniformLocation(this.hnV, "useNormalVideoTexture");
    this.hog = GLES20.glGetUniformLocation(this.hnV, "blurBgTexture");
    this.hof = GLES20.glGetUniformLocation(this.hnV, "hasBlurBgTexture");
    this.hoh = GLES20.glGetUniformLocation(this.hnV, "centerLocation");
    this.hok.position(0);
    this.hok.put(com.tencent.mm.media.k.c.hoK);
    this.hok.position(0);
    AppMethodBeat.o(219304);
  }
  
  protected final void aue()
  {
    AppMethodBeat.i(93854);
    long l = bt.HI();
    GLES20.glUseProgram(this.hnV);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.textureType, this.gKH);
    GLES20.glTexParameterf(this.textureType, 10241, 9729.0F);
    GLES20.glTexParameterf(this.textureType, 10240, 9729.0F);
    GLES20.glTexParameterf(this.textureType, 10242, 10497.0F);
    GLES20.glTexParameterf(this.textureType, 10243, 10497.0F);
    if (this.textureType == 3553)
    {
      GLES20.glUniform1i(this.hod, 1);
      GLES20.glUniform1i(this.hoa, 0);
      GLES20.glUniform1i(this.hnZ, 3);
      if (this.hnQ == null) {
        break label536;
      }
      GLES20.glActiveTexture(33985);
      Object localObject = this.hnQ;
      if (localObject != null) {
        d.a(this.hnR, (Bitmap)localObject);
      }
      GLES20.glUniform1i(this.hob, 1);
      GLES20.glUniform1i(this.hoc, 1);
      label166:
      if (this.hnS == null) {
        break label555;
      }
      GLES20.glActiveTexture(33986);
      localObject = this.hnS;
      if (localObject != null) {
        d.a(this.hnT, (Bitmap)localObject);
      }
      GLES20.glUniform1i(this.hog, 2);
      GLES20.glUniform1i(this.hof, 1);
      localObject = ByteBuffer.allocateDirect(this.hnU.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      ((FloatBuffer)localObject).put(this.hnU).position(0);
      GLES20.glUniform4fv(this.hoh, 1, (FloatBuffer)localObject);
      this.hol.position(0);
      GLES20.glVertexAttribPointer(this.hoi, 2, 5126, false, 0, (Buffer)this.hol);
      GLES20.glEnableVertexAttribArray(this.hoi);
    }
    for (;;)
    {
      this.gLm.position(0);
      GLES20.glVertexAttribPointer(this.hnW, 2, 5126, false, 0, (Buffer)this.gLm);
      GLES20.glEnableVertexAttribArray(this.hnW);
      this.gLl.position(0);
      this.hok.position(0);
      GLES20.glVertexAttribPointer(this.hnY, 2, 5126, false, 0, (Buffer)this.hok);
      GLES20.glEnableVertexAttribArray(this.hnY);
      GLES20.glVertexAttribPointer(this.hnX, 2, 5126, false, 0, (Buffer)this.gLl);
      GLES20.glEnableVertexAttribArray(this.hnX);
      GLES20.glUniformMatrix4fv(this.hoe, 1, false, this.hnx, 0);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.hnW);
      GLES20.glDisableVertexAttribArray(this.hnX);
      GLES20.glDisableVertexAttribArray(this.hnY);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
      GLES20.glFinish();
      GLES20.glUseProgram(0);
      this.hnQ = null;
      this.hnS = null;
      ad.i(this.TAG, "draw frame used " + bt.aO(l) + "ms");
      AppMethodBeat.o(93854);
      return;
      GLES20.glUniform1i(this.hod, 0);
      GLES20.glUniform1i(this.hoa, 3);
      GLES20.glUniform1i(this.hnZ, 0);
      break;
      label536:
      GLES20.glUniform1i(this.hob, 1);
      GLES20.glUniform1i(this.hoc, 0);
      break label166;
      label555:
      GLES20.glUniform1i(this.hof, 0);
      GLES20.glUniform1i(this.hog, 2);
    }
  }
  
  public final void nN(int paramInt)
  {
    this.gKH = paramInt;
  }
  
  public final void release()
  {
    AppMethodBeat.i(93855);
    super.release();
    this.hnR.close();
    this.hnT.close();
    AppMethodBeat.o(93855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.j.b.b
 * JD-Core Version:    0.7.0.1
 */