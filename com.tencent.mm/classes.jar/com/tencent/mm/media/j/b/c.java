package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.a;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcExternalTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributePosition", "attributeTextureCoord", "externalTexture", "getExternalTexture", "()I", "setExternalTexture", "(I)V", "programId", "uniformMatrix", "uniformTexture", "release", "", "renderImpl", "setInputTexture", "texture", "plugin-mediaeditor_release"})
public final class c
  extends a
{
  private int hEA;
  private int hEy;
  private int hEz;
  private int ikw;
  public int ikx;
  private int programId;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(93860);
    this.ikx = -1;
    c.a locala = com.tencent.mm.media.k.c.ilt;
    this.programId = c.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.hEy = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.hEz = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.hEA = GLES20.glGetUniformLocation(this.programId, "texture");
    this.ikw = GLES20.glGetUniformLocation(this.programId, "uMatrix");
    AppMethodBeat.o(93860);
  }
  
  protected final void aMV()
  {
    AppMethodBeat.i(93858);
    if (this.ikx != -1)
    {
      GLES20.glUseProgram(this.programId);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, this.ikx);
      GLES20.glTexParameterf(36197, 10241, 9729.0F);
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameterf(36197, 10242, 33071.0F);
      GLES20.glTexParameterf(36197, 10243, 33071.0F);
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
  
  public final void rl(int paramInt)
  {
    this.ikx = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.j.b.c
 * JD-Core Version:    0.7.0.1
 */