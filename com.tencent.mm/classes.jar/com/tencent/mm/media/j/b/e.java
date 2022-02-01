package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import d.l;
import java.nio.Buffer;
import java.nio.FloatBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributePosition", "attributeTextureCoord", "inputTexture", "programId", "uniformMatrix", "uniformTexture", "renderImpl", "", "setInputTexture", "texture", "plugin-mediaeditor_release"})
public class e
  extends a
{
  public int gKH;
  private int gLM;
  private int gLN;
  private int gLO;
  private int gLP;
  private int hom;
  
  public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(93862);
    this.gKH = -1;
    c.a locala = c.hoP;
    this.gLM = c.a.ay("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.gLN = GLES20.glGetAttribLocation(this.gLM, "a_position");
    this.gLO = GLES20.glGetAttribLocation(this.gLM, "a_texCoord");
    this.gLP = GLES20.glGetUniformLocation(this.gLM, "texture");
    this.hom = GLES20.glGetUniformLocation(this.gLM, "uMatrix");
    AppMethodBeat.o(93862);
  }
  
  protected final void aue()
  {
    AppMethodBeat.i(93861);
    if (this.gKH != -1)
    {
      GLES20.glUseProgram(this.gLM);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.gKH);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 10497.0F);
      GLES20.glTexParameterf(3553, 10243, 10497.0F);
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
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
      GLES20.glFinish();
    }
    AppMethodBeat.o(93861);
  }
  
  public final void nN(int paramInt)
  {
    this.gKH = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.j.b.e
 * JD-Core Version:    0.7.0.1
 */