package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.media.util.c.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/render/LiveYTFaceBeautyRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "drawHeight", "drawWidth", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcessTex", "Lcom/tencent/mm/live/core/render/LiveFilterProcessTex;", "programId", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "uniformTexture", "checkInit", "", "beautyParam", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "filterParam", "Lcom/tencent/mm/live/core/render/FilterConfig;", "inputTexture", "release", "renderImpl", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "rotate", "texture", "setLiveScene", "scene", "updateBeautyConfig", "beautyConfig", "updateFilterConfig", "filterConfig", "Companion", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j.a mWr;
  int mWn;
  int mWo;
  d mWs;
  public volatile c mWt;
  e mWu;
  private int mWv;
  private int mWw;
  private int mWx;
  int programId;
  
  static
  {
    AppMethodBeat.i(247685);
    mWr = new j.a((byte)0);
    AppMethodBeat.o(247685);
  }
  
  public j()
  {
    AppMethodBeat.i(247676);
    c.a locala = com.tencent.mm.media.util.c.nFs;
    this.programId = c.a.aN("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.mWv = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.mWw = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.mWx = GLES20.glGetUniformLocation(this.programId, "texture");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    if (this.mWu == null) {
      this.mWu = new e(0, 0, 0, 0, 2, 0, 32);
    }
    AppMethodBeat.o(247676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.b.j
 * JD-Core Version:    0.7.0.1
 */