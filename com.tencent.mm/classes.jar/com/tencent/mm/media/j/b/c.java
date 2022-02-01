package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.a;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcExternalTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributePosition", "attributeTextureCoord", "externalTexture", "getExternalTexture", "()I", "setExternalTexture", "(I)V", "programId", "uniformMatrix", "uniformTexture", "release", "", "renderImpl", "setInputTexture", "texture", "plugin-mediaeditor_release"})
public final class c
  extends a
{
  private int kZq;
  public int kZr;
  private int ksD;
  private int ksE;
  private int ksF;
  private int programId;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(93860);
    this.kZr = -1;
    c.a locala = com.tencent.mm.media.k.c.lar;
    this.programId = c.a.aE("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.ksD = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.ksE = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.ksF = GLES20.glGetUniformLocation(this.programId, "texture");
    this.kZq = GLES20.glGetUniformLocation(this.programId, "uMatrix");
    AppMethodBeat.o(93860);
  }
  
  protected final void aVw()
  {
    AppMethodBeat.i(93858);
    if (this.kZr != -1)
    {
      GLES20.glUseProgram(this.programId);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, this.kZr);
      GLES20.glTexParameterf(36197, 10241, 9729.0F);
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameterf(36197, 10242, 33071.0F);
      GLES20.glTexParameterf(36197, 10243, 33071.0F);
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
      GLES20.glBindTexture(36197, 0);
      GLES20.glFinish();
    }
    AppMethodBeat.o(93858);
  }
  
  public final void release()
  {
    AppMethodBeat.i(93859);
    super.release();
    GLES20.glDeleteProgram(this.programId);
    AppMethodBeat.o(93859);
  }
  
  public final void ua(int paramInt)
  {
    this.kZr = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.j.b.c
 * JD-Core Version:    0.7.0.1
 */