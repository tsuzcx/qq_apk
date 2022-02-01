package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributePosition", "attributeTextureCoord", "inputTexture", "programId", "uniformMatrix", "uniformTexture", "renderImpl", "", "setInputTexture", "texture", "plugin-mediaeditor_release"})
public class e
  extends a
{
  private int kZq;
  public int kre;
  private int ksD;
  private int ksE;
  private int ksF;
  private int programId;
  
  public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(93862);
    this.kre = -1;
    c.a locala = c.lar;
    this.programId = c.a.aE("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.ksD = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.ksE = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.ksF = GLES20.glGetUniformLocation(this.programId, "texture");
    this.kZq = GLES20.glGetUniformLocation(this.programId, "uMatrix");
    AppMethodBeat.o(93862);
  }
  
  protected final void aVw()
  {
    AppMethodBeat.i(93861);
    if (this.kre != -1)
    {
      GLES20.glUseProgram(this.programId);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.kre);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 10497.0F);
      GLES20.glTexParameterf(3553, 10243, 10497.0F);
      GLES20.glUniform1i(this.ksF, 0);
      GLES20.glUniformMatrix4fv(this.kZq, 1, false, aVo(), 0);
      aVm().position(0);
      GLES20.glVertexAttribPointer(this.ksD, 2, 5126, false, 0, (Buffer)aVm());
      GLES20.glEnableVertexAttribArray(this.ksD);
      aVl().position(0);
      GLES20.glVertexAttribPointer(this.ksE, 2, 5126, false, 0, (Buffer)aVl());
      GLES20.glEnableVertexAttribArray(this.ksE);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.ksD);
      GLES20.glDisableVertexAttribArray(this.ksE);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
    }
    AppMethodBeat.o(93861);
  }
  
  public final void ua(int paramInt)
  {
    this.kre = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.j.b.e
 * JD-Core Version:    0.7.0.1
 */