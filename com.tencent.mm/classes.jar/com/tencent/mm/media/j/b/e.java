package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import d.l;
import java.nio.Buffer;
import java.nio.FloatBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributePosition", "attributeTextureCoord", "inputTexture", "programId", "uniformMatrix", "uniformTexture", "renderImpl", "", "setInputTexture", "texture", "plugin-mediaeditor_release"})
public class e
  extends a
{
  public int gNq;
  private int gOv;
  private int gOw;
  private int gOx;
  private int gOy;
  private int hra;
  
  public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(93862);
    this.gNq = -1;
    c.a locala = c.hrD;
    this.gOv = c.a.az("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.gOw = GLES20.glGetAttribLocation(this.gOv, "a_position");
    this.gOx = GLES20.glGetAttribLocation(this.gOv, "a_texCoord");
    this.gOy = GLES20.glGetUniformLocation(this.gOv, "texture");
    this.hra = GLES20.glGetUniformLocation(this.gOv, "uMatrix");
    AppMethodBeat.o(93862);
  }
  
  protected final void aut()
  {
    AppMethodBeat.i(93861);
    if (this.gNq != -1)
    {
      GLES20.glUseProgram(this.gOv);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.gNq);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 10497.0F);
      GLES20.glTexParameterf(3553, 10243, 10497.0F);
      GLES20.glUniform1i(this.gOy, 0);
      GLES20.glUniformMatrix4fv(this.hra, 1, false, this.hql, 0);
      this.gNV.position(0);
      GLES20.glVertexAttribPointer(this.gOw, 2, 5126, false, 0, (Buffer)this.gNV);
      GLES20.glEnableVertexAttribArray(this.gOw);
      this.gNU.position(0);
      GLES20.glVertexAttribPointer(this.gOx, 2, 5126, false, 0, (Buffer)this.gNU);
      GLES20.glEnableVertexAttribArray(this.gOx);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.gOw);
      GLES20.glDisableVertexAttribArray(this.gOx);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
      GLES20.glFinish();
    }
    AppMethodBeat.o(93861);
  }
  
  public final void nQ(int paramInt)
  {
    this.gNq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.j.b.e
 * JD-Core Version:    0.7.0.1
 */