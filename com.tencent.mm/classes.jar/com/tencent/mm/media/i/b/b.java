package com.tencent.mm.media.i.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "blendAttributeBlurBgTextureCoord", "blendAttributePosition", "blendAttributeTextureCoord", "blendBitmapTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "blendBlurTextureCoordBuff", "Ljava/nio/FloatBuffer;", "blendCenterLocationBuffer", "", "blendProgramId", "blendTextureCoordBuff", "blendUniformBlurBgTexture", "blendUniformCenterLocation", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasBlurBgTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformUseNormalVideoTexture", "blurBgBitmap", "Landroid/graphics/Bitmap;", "blurBgBitmapTextureObj", "currentBlendBitmap", "emojiBlendAttributeTextureCoord", "inputTexture", "inputTextureHeight", "inputTextureWidth", "sizeBuffer", "kotlin.jvm.PlatformType", "textureType", "release", "", "renderImpl", "setBlendBitmap", "bitmap", "flip", "", "setBlurBgBitmap", "setBlurBgTextureCoordBuff", "blurBgCoord", "setCenterLocation", "top", "", "bottom", "left", "right", "setInputTexture", "texture", "setTextureType", "type", "plugin-mediaeditor_release"})
public class b
  extends a
{
  private final String TAG;
  public int guC;
  private int gvA;
  private int gvB;
  private int gvC;
  private int gvD;
  private int gvE;
  private int gvF;
  private final FloatBuffer gvG;
  private FloatBuffer gvH;
  public FloatBuffer gvI;
  private int gvl;
  private int gvm;
  private Bitmap gvn;
  private d gvo;
  public Bitmap gvp;
  private d gvq;
  public final float[] gvr;
  private int gvs;
  private int gvt;
  private int gvu;
  private int gvv;
  private int gvw;
  private int gvx;
  private int gvy;
  private int gvz;
  public int textureType;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(205877);
    this.TAG = "MircoMsg.GLTextureRenderProcBlend";
    this.gvr = new float[4];
    this.gvG = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    Object localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.j.c.gwf.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    k.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.gvH = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.j.c.gwf.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    k.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.gvI = ((FloatBuffer)localObject);
    this.textureType = 36197;
    this.gvl = paramInt1;
    this.gvm = paramInt2;
    this.gvo = com.tencent.mm.media.f.c.a(true, 4L);
    this.gvq = com.tencent.mm.media.f.c.a(true, 4L);
    localObject = com.tencent.mm.media.j.c.gwl;
    this.gvs = c.a.ap("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        attribute vec2 a_texBlurBgCoord;\n        attribute vec2 a_texEmojiCoord;\n        varying vec2 v_texCoord;\n        varying vec2 v_texBlurBgCoord;\n        varying vec2 v_texEmojiCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n            v_texBlurBgCoord = a_texBlurBgCoord;\n            v_texEmojiCoord = a_texEmojiCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        varying vec2 v_texBlurBgCoord;\n        varying vec2 v_texEmojiCoord;\n        uniform samplerExternalOES videoExternalTexture;\n        uniform sampler2D videoNormalTexture;\n        uniform sampler2D emojiTexture;\n        uniform sampler2D blurBgTexture;\n        uniform int hasEmojiTexture;\n        uniform int useNormalVideoTexture;\n        uniform int hasBlurBgTexture;\n        uniform vec4 centerLocation; //按top bottom left right来传\n\n        vec4 blendTexture(vec4 source, vec4 blend) {\n            if (blend.a <= 0.0) {\n                return source;\n            }\n            float sourceAlpha = 1.0 - blend.a;\n            float alpha = max(source.a, blend.a);\n            float r = max(0.0, min(sourceAlpha * source.r + blend.r, 1.0));\n            float g = max(0.0, min(sourceAlpha * source.g + blend.g, 1.0));\n            float b = max(0.0, min(sourceAlpha * source.b + blend.b, 1.0));\n            vec4 result = vec4(r, g, b, alpha);\n            if (alpha != 1.0) {\n                r = r + (1.0 - alpha) * 0.95;\n                g = g + (1.0 - alpha) * 0.95;\n                b = b + (1.0 - alpha) * 0.95;\n                r = max(0.0, min(r, 1.0));\n                g = max(0.0, min(g, 1.0));\n                b = max(0.0, min(b, 1.0));\n                return vec4(r, g, b, 1.0);\n            } else {\n                return vec4(r, g, b, alpha);\n            }\n        }\n\n        void main () {\n            vec4 videoColor;\n            vec4 blendElementsColor;\n\n            if (hasBlurBgTexture == 1) {\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texBlurBgCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texBlurBgCoord);\n                }\n                if (videoColor.a != 1.0) {\n                    videoColor.a = 0.0;\n                }\n                if (gl_FragCoord.y > centerLocation[0] || gl_FragCoord.y < centerLocation[1] ||\n                    gl_FragCoord.x > centerLocation[3] || gl_FragCoord.x < centerLocation[2]) {\n                    if (hasEmojiTexture == 1) {\n                        gl_FragColor = blendTexture(texture2D(blurBgTexture, v_texCoord), texture2D(emojiTexture, v_texEmojiCoord));\n                    } else {\n                        gl_FragColor = texture2D(blurBgTexture, v_texCoord);\n                    }\n                } else {\n                    if (hasEmojiTexture == 1) {\n                        gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texEmojiCoord));\n                    } else {\n                        gl_FragColor = videoColor;\n                    }\n                }\n            } else {\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texCoord);\n                }\n                if (videoColor.a != 1.0) {\n                    videoColor.a = 0.0;\n                }\n                if (hasEmojiTexture == 1) {\n                    gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texEmojiCoord));\n                } else {\n                    gl_FragColor = videoColor;\n                }\n            }\n        }\n        ");
    this.gvt = GLES20.glGetAttribLocation(this.gvs, "a_position");
    this.gvu = GLES20.glGetAttribLocation(this.gvs, "a_texCoord");
    this.gvv = GLES20.glGetAttribLocation(this.gvs, "a_texEmojiCoord");
    this.gvF = GLES20.glGetAttribLocation(this.gvs, "a_texBlurBgCoord");
    this.gvw = GLES20.glGetUniformLocation(this.gvs, "videoExternalTexture");
    this.gvx = GLES20.glGetUniformLocation(this.gvs, "videoNormalTexture");
    this.gvy = GLES20.glGetUniformLocation(this.gvs, "emojiTexture");
    this.gvz = GLES20.glGetUniformLocation(this.gvs, "hasEmojiTexture");
    this.gvB = GLES20.glGetUniformLocation(this.gvs, "uMatrix");
    this.gvA = GLES20.glGetUniformLocation(this.gvs, "useNormalVideoTexture");
    this.gvD = GLES20.glGetUniformLocation(this.gvs, "blurBgTexture");
    this.gvC = GLES20.glGetUniformLocation(this.gvs, "hasBlurBgTexture");
    this.gvE = GLES20.glGetUniformLocation(this.gvs, "centerLocation");
    this.gvH.position(0);
    this.gvH.put(com.tencent.mm.media.j.c.gwg);
    this.gvH.position(0);
    AppMethodBeat.o(205877);
  }
  
  protected final void akv()
  {
    AppMethodBeat.i(93854);
    long l = bt.GC();
    GLES20.glUseProgram(this.gvs);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.textureType, this.guC);
    GLES20.glTexParameterf(this.textureType, 10241, 9729.0F);
    GLES20.glTexParameterf(this.textureType, 10240, 9729.0F);
    GLES20.glTexParameterf(this.textureType, 10242, 10497.0F);
    GLES20.glTexParameterf(this.textureType, 10243, 10497.0F);
    if (this.textureType == 3553)
    {
      GLES20.glUniform1i(this.gvA, 1);
      GLES20.glUniform1i(this.gvx, 0);
      GLES20.glUniform1i(this.gvw, 3);
      if (this.gvn == null) {
        break label536;
      }
      GLES20.glActiveTexture(33985);
      Object localObject = this.gvn;
      if (localObject != null) {
        d.a(this.gvo, (Bitmap)localObject);
      }
      GLES20.glUniform1i(this.gvy, 1);
      GLES20.glUniform1i(this.gvz, 1);
      label166:
      if (this.gvp == null) {
        break label555;
      }
      GLES20.glActiveTexture(33986);
      localObject = this.gvp;
      if (localObject != null) {
        d.a(this.gvq, (Bitmap)localObject);
      }
      GLES20.glUniform1i(this.gvD, 2);
      GLES20.glUniform1i(this.gvC, 1);
      localObject = ByteBuffer.allocateDirect(this.gvr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      ((FloatBuffer)localObject).put(this.gvr).position(0);
      GLES20.glUniform4fv(this.gvE, 1, (FloatBuffer)localObject);
      this.gvI.position(0);
      GLES20.glVertexAttribPointer(this.gvF, 2, 5126, false, 0, (Buffer)this.gvI);
      GLES20.glEnableVertexAttribArray(this.gvF);
    }
    for (;;)
    {
      this.guT.position(0);
      GLES20.glVertexAttribPointer(this.gvt, 2, 5126, false, 0, (Buffer)this.guT);
      GLES20.glEnableVertexAttribArray(this.gvt);
      this.guS.position(0);
      this.gvH.position(0);
      GLES20.glVertexAttribPointer(this.gvv, 2, 5126, false, 0, (Buffer)this.gvH);
      GLES20.glEnableVertexAttribArray(this.gvv);
      GLES20.glVertexAttribPointer(this.gvu, 2, 5126, false, 0, (Buffer)this.guS);
      GLES20.glEnableVertexAttribArray(this.gvu);
      GLES20.glUniformMatrix4fv(this.gvB, 1, false, this.guX, 0);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.gvt);
      GLES20.glDisableVertexAttribArray(this.gvu);
      GLES20.glDisableVertexAttribArray(this.gvv);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
      GLES20.glFinish();
      GLES20.glUseProgram(0);
      this.gvn = null;
      this.gvp = null;
      ad.i(this.TAG, "draw frame used " + bt.aS(l) + "ms");
      AppMethodBeat.o(93854);
      return;
      GLES20.glUniform1i(this.gvA, 0);
      GLES20.glUniform1i(this.gvx, 3);
      GLES20.glUniform1i(this.gvw, 0);
      break;
      label536:
      GLES20.glUniform1i(this.gvy, 1);
      GLES20.glUniform1i(this.gvz, 0);
      break label166;
      label555:
      GLES20.glUniform1i(this.gvC, 0);
      GLES20.glUniform1i(this.gvD, 2);
    }
  }
  
  public final void d(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(205875);
    k.h(paramBitmap, "bitmap");
    this.gvn = paramBitmap;
    if (paramBoolean)
    {
      this.gvH.position(0);
      this.gvH.put(com.tencent.mm.media.j.c.gwg);
      this.gvH.position(0);
      AppMethodBeat.o(205875);
      return;
    }
    this.gvH.position(0);
    this.gvH.put(com.tencent.mm.media.j.c.gwf);
    this.gvH.position(0);
    AppMethodBeat.o(205875);
  }
  
  public final void mA(int paramInt)
  {
    this.guC = paramInt;
  }
  
  public final void release()
  {
    AppMethodBeat.i(93855);
    super.release();
    this.gvo.close();
    this.gvq.close();
    AppMethodBeat.o(93855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.i.b.b
 * JD-Core Version:    0.7.0.1
 */