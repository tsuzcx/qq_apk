package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributePosition", "attributeTextureCoord", "inputTexture", "programId", "uniformMatrix", "uniformTexture", "renderImpl", "", "setInputTexture", "texture", "plugin-mediaeditor_release"})
public class e
  extends a
{
  public int hDl;
  private int hEA;
  private int hEy;
  private int hEz;
  private int ikw;
  private int programId;
  
  public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(93862);
    this.hDl = -1;
    c.a locala = c.ilt;
    this.programId = c.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.hEy = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.hEz = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.hEA = GLES20.glGetUniformLocation(this.programId, "texture");
    this.ikw = GLES20.glGetUniformLocation(this.programId, "uMatrix");
    AppMethodBeat.o(93862);
  }
  
  protected final void aMV()
  {
    AppMethodBeat.i(93861);
    if (this.hDl != -1)
    {
      GLES20.glUseProgram(this.programId);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.hDl);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 10497.0F);
      GLES20.glTexParameterf(3553, 10243, 10497.0F);
      GLES20.glUniform1i(this.hEA, 0);
      GLES20.glUniformMatrix4fv(this.ikw, 1, false, this.ijG, 0);
      this.hDU.position(0);
      GLES20.glVertexAttribPointer(this.hEy, 2, 5126, false, 0, (Buffer)this.hDU);
      GLES20.glEnableVertexAttribArray(this.hEy);
      this.hDT.position(0);
      GLES20.glVertexAttribPointer(this.hEz, 2, 5126, false, 0, (Buffer)this.hDT);
      GLES20.glEnableVertexAttribArray(this.hEz);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.hEy);
      GLES20.glDisableVertexAttribArray(this.hEz);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
    }
    AppMethodBeat.o(93861);
  }
  
  public final void rl(int paramInt)
  {
    this.hDl = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.j.b.e
 * JD-Core Version:    0.7.0.1
 */