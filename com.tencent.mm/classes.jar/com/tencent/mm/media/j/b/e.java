package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c;
import com.tencent.mm.media.util.c.a;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributePosition", "attributeTextureCoord", "inputTexture", "programId", "uniformMatrix", "uniformTexture", "renderImpl", "", "setInputTexture", "texture", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public class e
  extends a
{
  public int mVb;
  private int mWv;
  private int mWw;
  private int mWx;
  private int nEw;
  private int programId;
  
  public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(93862);
    this.mVb = -1;
    c.a locala = c.nFs;
    this.programId = c.a.aN("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.mWv = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.mWw = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.mWx = GLES20.glGetUniformLocation(this.programId, "texture");
    this.nEw = GLES20.glGetUniformLocation(this.programId, "uMatrix");
    AppMethodBeat.o(93862);
  }
  
  protected final void bqg()
  {
    AppMethodBeat.i(93861);
    if ((this.mVb != -1) && (GLES20.glIsTexture(this.mVb)))
    {
      GLES20.glUseProgram(this.programId);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.mVb);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 10497.0F);
      GLES20.glTexParameterf(3553, 10243, 10497.0F);
      GLES20.glUniform1i(this.mWx, 0);
      GLES20.glUniformMatrix4fv(this.nEw, 1, false, bpY(), 0);
      bpW().position(0);
      GLES20.glVertexAttribPointer(this.mWv, 2, 5126, false, 0, (Buffer)bpW());
      GLES20.glEnableVertexAttribArray(this.mWv);
      bpV().position(0);
      GLES20.glVertexAttribPointer(this.mWw, 2, 5126, false, 0, (Buffer)bpV());
      GLES20.glEnableVertexAttribArray(this.mWw);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.mWv);
      GLES20.glDisableVertexAttribArray(this.mWw);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
    }
    AppMethodBeat.o(93861);
  }
  
  public final void uc(int paramInt)
  {
    this.mVb = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.j.b.e
 * JD-Core Version:    0.7.0.1
 */