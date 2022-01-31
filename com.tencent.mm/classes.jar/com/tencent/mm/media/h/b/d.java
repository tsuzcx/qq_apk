package com.tencent.mm.media.h.b;

import a.l;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b;
import com.tencent.mm.media.i.b.a;
import java.nio.Buffer;
import java.nio.FloatBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributePosition", "attributeTextureCoord", "inputTexture", "programId", "uniformMatrix", "uniformTexture", "renderImpl", "", "setInputTexture", "texture", "plugin-mediaeditor_release"})
public final class d
  extends a
{
  private int eYZ;
  private int eYd;
  private int eZa;
  private int eZb;
  private int eZc;
  private int eZd;
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(13106);
    this.eYd = -1;
    b.a locala = b.eZw;
    this.eYZ = b.a.Z("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.eZa = GLES20.glGetAttribLocation(this.eYZ, "a_position");
    this.eZb = GLES20.glGetAttribLocation(this.eYZ, "a_texCoord");
    this.eZc = GLES20.glGetUniformLocation(this.eYZ, "texture");
    this.eZd = GLES20.glGetUniformLocation(this.eYZ, "uMatrix");
    AppMethodBeat.o(13106);
  }
  
  protected final void Vj()
  {
    AppMethodBeat.i(13105);
    if (this.eYd != -1)
    {
      GLES20.glUseProgram(this.eYZ);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.eYd);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 10497.0F);
      GLES20.glTexParameterf(3553, 10243, 10497.0F);
      GLES20.glUniform1i(this.eZc, 0);
      GLES20.glUniformMatrix4fv(this.eZd, 1, false, this.eYz, 0);
      this.eYv.position(0);
      GLES20.glVertexAttribPointer(this.eZa, 2, 5126, false, 0, (Buffer)this.eYv);
      GLES20.glEnableVertexAttribArray(this.eZa);
      this.eYu.position(0);
      GLES20.glVertexAttribPointer(this.eZb, 2, 5126, false, 0, (Buffer)this.eYu);
      GLES20.glEnableVertexAttribArray(this.eZb);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.eZa);
      GLES20.glDisableVertexAttribArray(this.eZb);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
      GLES20.glFinish();
    }
    AppMethodBeat.o(13105);
  }
  
  public final void jY(int paramInt)
  {
    this.eYd = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.h.b.d
 * JD-Core Version:    0.7.0.1
 */