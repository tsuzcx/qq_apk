package com.tencent.mm.media.i.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c;
import com.tencent.mm.media.j.c.a;
import d.l;
import java.nio.Buffer;
import java.nio.FloatBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributePosition", "attributeTextureCoord", "inputTexture", "programId", "uniformMatrix", "uniformTexture", "renderImpl", "", "setInputTexture", "texture", "plugin-mediaeditor_release"})
public class e
  extends a
{
  private int gWg;
  public int gqX;
  private int gse;
  private int gsf;
  private int gsg;
  private int gsh;
  
  public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(93862);
    this.gqX = -1;
    c.a locala = c.gWJ;
    this.gse = c.a.ax("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.gsf = GLES20.glGetAttribLocation(this.gse, "a_position");
    this.gsg = GLES20.glGetAttribLocation(this.gse, "a_texCoord");
    this.gsh = GLES20.glGetUniformLocation(this.gse, "texture");
    this.gWg = GLES20.glGetUniformLocation(this.gse, "uMatrix");
    AppMethodBeat.o(93862);
  }
  
  protected final void arr()
  {
    AppMethodBeat.i(93861);
    if (this.gqX != -1)
    {
      GLES20.glUseProgram(this.gse);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.gqX);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 10497.0F);
      GLES20.glTexParameterf(3553, 10243, 10497.0F);
      GLES20.glUniform1i(this.gsh, 0);
      GLES20.glUniformMatrix4fv(this.gWg, 1, false, this.gVu, 0);
      this.grE.position(0);
      GLES20.glVertexAttribPointer(this.gsf, 2, 5126, false, 0, (Buffer)this.grE);
      GLES20.glEnableVertexAttribArray(this.gsf);
      this.grD.position(0);
      GLES20.glVertexAttribPointer(this.gsg, 2, 5126, false, 0, (Buffer)this.grD);
      GLES20.glEnableVertexAttribArray(this.gsg);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.gsf);
      GLES20.glDisableVertexAttribArray(this.gsg);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
      GLES20.glFinish();
    }
    AppMethodBeat.o(93861);
  }
  
  public final void no(int paramInt)
  {
    this.gqX = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.i.b.e
 * JD-Core Version:    0.7.0.1
 */