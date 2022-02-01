package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.a;
import d.l;
import java.nio.Buffer;
import java.nio.FloatBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcExternalTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributePosition", "attributeTextureCoord", "externalTexture", "getExternalTexture", "()I", "setExternalTexture", "(I)V", "programId", "uniformMatrix", "uniformTexture", "release", "", "renderImpl", "setInputTexture", "texture", "plugin-mediaeditor_release"})
public final class c
  extends a
{
  private int gLM;
  private int gLN;
  private int gLO;
  private int gLP;
  private int hom;
  public int hon;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(93860);
    this.hon = -1;
    c.a locala = com.tencent.mm.media.k.c.hoP;
    this.gLM = c.a.ay("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.gLN = GLES20.glGetAttribLocation(this.gLM, "a_position");
    this.gLO = GLES20.glGetAttribLocation(this.gLM, "a_texCoord");
    this.gLP = GLES20.glGetUniformLocation(this.gLM, "texture");
    this.hom = GLES20.glGetUniformLocation(this.gLM, "uMatrix");
    AppMethodBeat.o(93860);
  }
  
  protected final void aue()
  {
    AppMethodBeat.i(93858);
    if (this.hon != -1)
    {
      GLES20.glUseProgram(this.gLM);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, this.hon);
      GLES20.glTexParameterf(36197, 10241, 9729.0F);
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameterf(36197, 10242, 33071.0F);
      GLES20.glTexParameterf(36197, 10243, 33071.0F);
      GLES20.glUniform1i(this.gLP, 0);
      GLES20.glUniformMatrix4fv(this.hom, 1, false, this.hnx, 0);
      this.gLm.position(0);
      GLES20.glVertexAttribPointer(this.gLN, 2, 5126, false, 0, (Buffer)this.gLm);
      GLES20.glEnableVertexAttribArray(this.gLN);
      this.gLl.position(0);
      GLES20.glVertexAttribPointer(this.gLO, 2, 5126, false, 0, (Buffer)this.gLl);
      GLES20.glEnableVertexAttribArray(this.gLO);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.gLN);
      GLES20.glDisableVertexAttribArray(this.gLO);
      GLES20.glBindTexture(36197, 0);
      GLES20.glFinish();
    }
    AppMethodBeat.o(93858);
  }
  
  public final void nN(int paramInt)
  {
    this.hon = paramInt;
  }
  
  public final void release()
  {
    AppMethodBeat.i(93859);
    super.release();
    GLES20.glDeleteProgram(this.gLM);
    AppMethodBeat.o(93859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.j.b.c
 * JD-Core Version:    0.7.0.1
 */