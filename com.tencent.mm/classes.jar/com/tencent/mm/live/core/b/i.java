package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/render/LiveYTFaceBeautyRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "drawHeight", "drawWidth", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcessTex", "Lcom/tencent/mm/live/core/render/LiveFilterProcessTex;", "programId", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "uniformTexture", "checkInit", "", "beautyParam", "inputTexture", "release", "renderImpl", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "rotate", "texture", "outputTexture", "Companion", "plugin-core_release"})
public final class i
{
  public static final i.a gLQ;
  int gLD;
  int gLE;
  d gLJ;
  volatile a gLK;
  e gLL;
  int gLM;
  int gLN;
  int gLO;
  int gLP;
  
  static
  {
    AppMethodBeat.i(216990);
    gLQ = new i.a((byte)0);
    AppMethodBeat.o(216990);
  }
  
  public i()
  {
    AppMethodBeat.i(216989);
    c.a locala = c.hoP;
    this.gLM = c.a.ay("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.gLN = GLES20.glGetAttribLocation(this.gLM, "a_position");
    this.gLO = GLES20.glGetAttribLocation(this.gLM, "a_texCoord");
    this.gLP = GLES20.glGetUniformLocation(this.gLM, "texture");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    if (this.gLL == null) {
      this.gLL = new e(0, 0, 0, 0, 2, 0, 32);
    }
    AppMethodBeat.o(216989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.b.i
 * JD-Core Version:    0.7.0.1
 */