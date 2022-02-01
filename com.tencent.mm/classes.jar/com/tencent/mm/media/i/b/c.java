package com.tencent.mm.media.i.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c.a;
import d.l;
import java.nio.Buffer;
import java.nio.FloatBuffer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcExternalTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributePosition", "attributeTextureCoord", "externalTexture", "getExternalTexture", "()I", "setExternalTexture", "(I)V", "programId", "uniformMatrix", "uniformTexture", "release", "", "renderImpl", "setInputTexture", "texture", "plugin-mediaeditor_release"})
public final class c
  extends a
{
  private int gvL;
  private int gvM;
  private int gvN;
  private int gvO;
  private int gvP;
  private int gvQ;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(93860);
    this.gvQ = -1;
    c.a locala = com.tencent.mm.media.j.c.gwl;
    this.gvL = c.a.ap("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.gvM = GLES20.glGetAttribLocation(this.gvL, "a_position");
    this.gvN = GLES20.glGetAttribLocation(this.gvL, "a_texCoord");
    this.gvO = GLES20.glGetUniformLocation(this.gvL, "texture");
    this.gvP = GLES20.glGetUniformLocation(this.gvL, "uMatrix");
    AppMethodBeat.o(93860);
  }
  
  protected final void akv()
  {
    AppMethodBeat.i(93858);
    if (this.gvQ != -1)
    {
      GLES20.glUseProgram(this.gvL);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, this.gvQ);
      GLES20.glTexParameterf(36197, 10241, 9729.0F);
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameterf(36197, 10242, 33071.0F);
      GLES20.glTexParameterf(36197, 10243, 33071.0F);
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
      GLES20.glBindTexture(36197, 0);
      GLES20.glFinish();
    }
    AppMethodBeat.o(93858);
  }
  
  public final void mA(int paramInt)
  {
    this.gvQ = paramInt;
  }
  
  public final void release()
  {
    AppMethodBeat.i(93859);
    super.release();
    GLES20.glDeleteProgram(this.gvL);
    AppMethodBeat.o(93859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.i.b.c
 * JD-Core Version:    0.7.0.1
 */