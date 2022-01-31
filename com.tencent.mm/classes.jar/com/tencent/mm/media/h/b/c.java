package com.tencent.mm.media.h.b;

import a.l;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b;
import com.tencent.mm.media.i.b.a;
import java.nio.Buffer;
import java.nio.FloatBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcExternalTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributePosition", "attributeTextureCoord", "externalTexture", "getExternalTexture", "()I", "setExternalTexture", "(I)V", "programId", "uniformMatrix", "uniformTexture", "release", "", "renderImpl", "setInputTexture", "texture", "plugin-mediaeditor_release"})
public class c
  extends a
{
  private int eYZ;
  protected int eYa;
  private int eZa;
  private int eZb;
  private int eZc;
  private int eZd;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(13104);
    this.eYa = -1;
    b.a locala = b.eZw;
    this.eYZ = b.a.Z("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.eZa = GLES20.glGetAttribLocation(this.eYZ, "a_position");
    this.eZb = GLES20.glGetAttribLocation(this.eYZ, "a_texCoord");
    this.eZc = GLES20.glGetUniformLocation(this.eYZ, "texture");
    this.eZd = GLES20.glGetUniformLocation(this.eYZ, "uMatrix");
    AppMethodBeat.o(13104);
  }
  
  protected void Vj()
  {
    AppMethodBeat.i(13102);
    if (this.eYa != -1)
    {
      GLES20.glUseProgram(this.eYZ);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, this.eYa);
      GLES20.glTexParameterf(36197, 10241, 9729.0F);
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameterf(36197, 10242, 10497.0F);
      GLES20.glTexParameterf(36197, 10243, 10497.0F);
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
      GLES20.glBindTexture(36197, 0);
      GLES20.glFinish();
    }
    AppMethodBeat.o(13102);
  }
  
  public final void jY(int paramInt)
  {
    this.eYa = paramInt;
  }
  
  public void release()
  {
    AppMethodBeat.i(13103);
    super.release();
    GLES20.glDeleteProgram(this.eYZ);
    AppMethodBeat.o(13103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.h.b.c
 * JD-Core Version:    0.7.0.1
 */