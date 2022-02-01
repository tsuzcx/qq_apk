package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.media.i.b.e;
import com.tencent.mm.media.j.c;
import com.tencent.mm.media.j.c.a;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/render/LiveYTFaceBeautyRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "drawHeight", "drawWidth", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcessTex", "Lcom/tencent/mm/live/core/render/LiveFilterProcessTex;", "programId", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "uniformTexture", "checkInit", "", "beautyParam", "inputTexture", "release", "renderImpl", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "rotate", "texture", "outputTexture", "Companion", "plugin-core_release"})
public final class i
{
  public static final i.a gsi;
  int grV;
  int grW;
  d gsb;
  volatile a gsc;
  e gsd;
  int gse;
  int gsf;
  int gsg;
  int gsh;
  
  static
  {
    AppMethodBeat.i(209332);
    gsi = new i.a((byte)0);
    AppMethodBeat.o(209332);
  }
  
  public i()
  {
    AppMethodBeat.i(209331);
    c.a locala = c.gWJ;
    this.gse = c.a.ax("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.gsf = GLES20.glGetAttribLocation(this.gse, "a_position");
    this.gsg = GLES20.glGetAttribLocation(this.gse, "a_texCoord");
    this.gsh = GLES20.glGetUniformLocation(this.gse, "texture");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    if (this.gsd == null) {
      this.gsd = new e(0, 0, 0, 0, 2, 0, 32);
    }
    AppMethodBeat.o(209331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.b.i
 * JD-Core Version:    0.7.0.1
 */