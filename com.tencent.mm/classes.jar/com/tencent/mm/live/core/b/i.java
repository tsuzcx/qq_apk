package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c;
import com.tencent.mm.media.j.c.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/render/LiveYTFaceBeautyRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcessTex", "Lcom/tencent/mm/live/core/render/LiveFilterProcessTex;", "programId", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "uniformTexture", "checkInit", "", "beautyParam", "inputTexture", "release", "renderImpl", "drawWidth", "drawHeight", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "rotate", "texture", "outputTexture", "Companion", "plugin-core_release"})
public final class i
{
  public static final a qUo;
  int gvL;
  int gvM;
  int gvN;
  int gvO;
  com.tencent.mm.media.f.d oSo;
  volatile a qUn;
  com.tencent.mm.media.i.b.d zyt;
  
  static
  {
    AppMethodBeat.i(205794);
    qUo = new a((byte)0);
    AppMethodBeat.o(205794);
  }
  
  public i()
  {
    AppMethodBeat.i(205793);
    c.a locala = c.gwl;
    this.gvL = c.a.ap("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.gvM = GLES20.glGetAttribLocation(this.gvL, "a_position");
    this.gvN = GLES20.glGetAttribLocation(this.gvL, "a_texCoord");
    this.gvO = GLES20.glGetUniformLocation(this.gvL, "texture");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    if (this.zyt == null) {
      this.zyt = new com.tencent.mm.media.i.b.d(0, 0, 0, 0, 2, 0, 32);
    }
    AppMethodBeat.o(205793);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/render/LiveYTFaceBeautyRendererProgram$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.b.i
 * JD-Core Version:    0.7.0.1
 */