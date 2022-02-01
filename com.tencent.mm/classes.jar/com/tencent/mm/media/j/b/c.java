package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcExternalTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "attributePosition", "attributeTextureCoord", "externalTexture", "getExternalTexture", "()I", "setExternalTexture", "(I)V", "programId", "uniformMatrix", "uniformTexture", "release", "", "renderImpl", "setInputTexture", "texture", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  private final String TAG;
  private int mWv;
  private int mWw;
  private int mWx;
  private int nEw;
  public int nEx;
  private int programId;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(93860);
    this.nEx = -1;
    this.TAG = "MicroMsg.GLTextureRenderProcExternalTexture";
    c.a locala = com.tencent.mm.media.util.c.nFs;
    this.programId = c.a.aN("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.mWv = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.mWw = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.mWx = GLES20.glGetUniformLocation(this.programId, "texture");
    this.nEw = GLES20.glGetUniformLocation(this.programId, "uMatrix");
    AppMethodBeat.o(93860);
  }
  
  protected final void bqg()
  {
    AppMethodBeat.i(93858);
    if ((this.nEx != -1) && (GLES20.glIsTexture(this.nEx)))
    {
      GLES20.glUseProgram(this.programId);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, this.nEx);
      GLES20.glTexParameterf(36197, 10241, 9729.0F);
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameterf(36197, 10242, 33071.0F);
      GLES20.glTexParameterf(36197, 10243, 33071.0F);
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
      GLES20.glBindTexture(36197, 0);
      AppMethodBeat.o(93858);
      return;
    }
    Log.e(this.TAG, "draw with invalid texture");
    AppMethodBeat.o(93858);
  }
  
  public final void release()
  {
    AppMethodBeat.i(93859);
    super.release();
    GLES20.glDeleteProgram(this.programId);
    AppMethodBeat.o(93859);
  }
  
  public final void uc(int paramInt)
  {
    this.nEx = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.j.b.c
 * JD-Core Version:    0.7.0.1
 */