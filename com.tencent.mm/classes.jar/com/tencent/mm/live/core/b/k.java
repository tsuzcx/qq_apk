package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.media.k.c.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/render/LiveYTFaceBeautyRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "drawHeight", "drawWidth", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcessTex", "Lcom/tencent/mm/live/core/render/LiveFilterProcessTex;", "programId", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "uniformTexture", "checkInit", "", "beautyParam", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "filterParam", "Lcom/tencent/mm/live/core/render/FilterConfig;", "inputTexture", "release", "renderImpl", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "rotate", "texture", "updateBeautyConfig", "beautyConfig", "updateFilterConfig", "filterConfig", "Companion", "plugin-core_release"})
public final class k
{
  public static final k.a hEB;
  private int hEA;
  int hEp;
  int hEq;
  d hEv;
  volatile c hEw;
  e hEx;
  private int hEy;
  private int hEz;
  int programId;
  
  static
  {
    AppMethodBeat.i(196690);
    hEB = new k.a((byte)0);
    AppMethodBeat.o(196690);
  }
  
  public k()
  {
    AppMethodBeat.i(196689);
    c.a locala = com.tencent.mm.media.k.c.ilt;
    this.programId = c.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.hEy = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.hEz = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.hEA = GLES20.glGetUniformLocation(this.programId, "texture");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    if (this.hEx == null) {
      this.hEx = new e(0, 0, 0, 0, 2, 0, 32);
    }
    AppMethodBeat.o(196689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.b.k
 * JD-Core Version:    0.7.0.1
 */