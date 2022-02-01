package com.tencent.mm.media.i.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c;
import com.tencent.mm.media.j.c.a;
import d.l;
import java.nio.Buffer;
import java.nio.FloatBuffer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributePosition", "attributeTextureCoord", "inputTexture", "programId", "uniformMatrix", "uniformTexture", "renderImpl", "", "setInputTexture", "texture", "plugin-mediaeditor_release"})
public class d
  extends a
{
  public int guC;
  private int gvL;
  private int gvM;
  private int gvN;
  private int gvO;
  private int gvP;
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(93862);
    this.guC = -1;
    c.a locala = c.gwl;
    this.gvL = c.a.ap("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.gvM = GLES20.glGetAttribLocation(this.gvL, "a_position");
    this.gvN = GLES20.glGetAttribLocation(this.gvL, "a_texCoord");
    this.gvO = GLES20.glGetUniformLocation(this.gvL, "texture");
    this.gvP = GLES20.glGetUniformLocation(this.gvL, "uMatrix");
    AppMethodBeat.o(93862);
  }
  
  protected final void akv()
  {
    AppMethodBeat.i(93861);
    if (this.guC != -1)
    {
      GLES20.glUseProgram(this.gvL);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.guC);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 10497.0F);
      GLES20.glTexParameterf(3553, 10243, 10497.0F);
      GLES20.glUniform1i(this.gvO, 0);
      GLES20.glUniformMatrix4fv(this.gvP, 1, false, this.guX, 0);
      this.guT.position(0);
      GLES20.glVertexAttribPointer(this.gvM, 2, 5126, false, 0, (Buffer)this.guT);
      GLES20.glEnableVertexAttribArray(this.gvM);
      this.guS.position(0);
      GLES20.glVertexAttribPointer(this.gvN, 2, 5126, false, 0, (Buffer)this.guS);
      GLES20.glEnableVertexAttribArray(this.gvN);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.gvM);
      GLES20.glDisableVertexAttribArray(this.gvN);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
      GLES20.glFinish();
    }
    AppMethodBeat.o(93861);
  }
  
  public final void mA(int paramInt)
  {
    this.guC = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.i.b.d
 * JD-Core Version:    0.7.0.1
 */