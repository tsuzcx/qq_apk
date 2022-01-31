package com.tencent.mm.media.h.b;

import a.f.b.j;
import a.l;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b;
import com.tencent.mm.media.i.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcYuvToRgb;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributeYUVPosition", "attributeYUVTextureCoord", "frame", "", "uniformUVTexture", "uniformYTexture", "uniformYUVRotateMatrix", "uvBuffer", "Ljava/nio/ByteBuffer;", "uvTextureId", "yBuffer", "yTextureId", "yuvProgramId", "getFrame", "renderImpl", "", "setFrame", "Companion", "plugin-mediaeditor_release"})
public class e
  extends a
{
  private static final String TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
  public static final e.a eZp;
  private int eZe;
  private int eZf;
  private int eZg;
  private int eZh;
  private int eZi;
  private int eZj;
  private int eZk;
  private int eZl;
  private ByteBuffer eZm;
  private ByteBuffer eZn;
  protected byte[] eZo;
  
  static
  {
    AppMethodBeat.i(13110);
    eZp = new e.a((byte)0);
    TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
    AppMethodBeat.o(13110);
  }
  
  public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(13109);
    this.eZo = new byte[0];
    b.a locala = b.eZw;
    this.eZg = b.a.Z("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D uv_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           u = texture2D(uv_texture, v_texCoord).a;\n           v = texture2D(uv_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
    if (this.eZg == 0) {
      ab.e(TAG, "checkInit, load program failed!");
    }
    this.eZi = GLES20.glGetAttribLocation(this.eZg, "a_position");
    this.eZh = GLES20.glGetAttribLocation(this.eZg, "a_texCoord");
    this.eZj = GLES20.glGetUniformLocation(this.eZg, "y_texture");
    this.eZk = GLES20.glGetUniformLocation(this.eZg, "uv_texture");
    this.eZl = GLES20.glGetUniformLocation(this.eZg, "uMatrix");
    locala = b.eZw;
    this.eZe = b.a.Vm();
    locala = b.eZw;
    this.eZf = b.a.Vm();
    AppMethodBeat.o(13109);
  }
  
  public final void L(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13107);
    j.q(paramArrayOfByte, "frame");
    this.eZo = paramArrayOfByte;
    AppMethodBeat.o(13107);
  }
  
  protected void Vj()
  {
    AppMethodBeat.i(13108);
    if ((this.eZg != 0) && (this.eZe != -1) && (this.eZf != -1) && (this.eYl > 0) && (this.eYm > 0))
    {
      if (this.eZo.length != 0) {
        break label649;
      }
      i = 1;
      if (i != 0) {
        break label654;
      }
    }
    label649:
    label654:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((this.eZm != null) && (this.eZn != null))
        {
          localByteBuffer = this.eZm;
          if (localByteBuffer == null) {
            j.ebi();
          }
          if (localByteBuffer.capacity() == this.eYj * this.eYk)
          {
            localByteBuffer = this.eZn;
            if (localByteBuffer == null) {
              j.ebi();
            }
            if (localByteBuffer.capacity() == this.eYj * this.eYk / 2) {
              break label209;
            }
          }
        }
        this.eZm = ByteBuffer.allocateDirect(this.eYj * this.eYk);
        this.eZn = ByteBuffer.allocateDirect(this.eYj * this.eYk / 2);
        ByteBuffer localByteBuffer = this.eZm;
        if (localByteBuffer == null) {
          j.ebi();
        }
        localByteBuffer.order(ByteOrder.nativeOrder());
        localByteBuffer = this.eZn;
        if (localByteBuffer == null) {
          j.ebi();
        }
        localByteBuffer.order(ByteOrder.nativeOrder());
        label209:
        localByteBuffer = this.eZm;
        if (localByteBuffer == null) {
          j.ebi();
        }
        localByteBuffer.put(this.eZo, 0, this.eYj * this.eYk);
        localByteBuffer = this.eZm;
        if (localByteBuffer == null) {
          j.ebi();
        }
        localByteBuffer.position(0);
        localByteBuffer = this.eZn;
        if (localByteBuffer == null) {
          j.ebi();
        }
        localByteBuffer.put(this.eZo, this.eYj * this.eYk, this.eYj * this.eYk / 2);
        localByteBuffer = this.eZn;
        if (localByteBuffer == null) {
          j.ebi();
        }
        localByteBuffer.position(0);
        GLES20.glUseProgram(this.eZg);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.eZe);
        GLES20.glTexImage2D(3553, 0, 6409, this.eYj, this.eYk, 0, 6409, 5121, (Buffer)this.eZm);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 10497.0F);
        GLES20.glTexParameterf(3553, 10243, 10497.0F);
        GLES20.glUniform1i(this.eZj, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.eZf);
        GLES20.glTexImage2D(3553, 0, 6410, this.eYj / 2, this.eYk / 2, 0, 6410, 5121, (Buffer)this.eZn);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 10497.0F);
        GLES20.glTexParameterf(3553, 10243, 10497.0F);
        GLES20.glUniform1i(this.eZk, 1);
        GLES20.glUniformMatrix4fv(this.eZl, 1, false, this.eYz, 0);
        this.eYv.position(0);
        GLES20.glVertexAttribPointer(this.eZi, 2, 5126, false, 0, (Buffer)this.eYv);
        GLES20.glEnableVertexAttribArray(this.eZi);
        this.eYu.position(0);
        GLES20.glVertexAttribPointer(this.eZh, 2, 5126, false, 0, (Buffer)this.eYu);
        GLES20.glEnableVertexAttribArray(this.eZh);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.eZi);
        GLES20.glDisableVertexAttribArray(this.eZh);
        GLES20.glBindTexture(3553, 0);
        GLES20.glFinish();
      }
      AppMethodBeat.o(13108);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.h.b.e
 * JD-Core Version:    0.7.0.1
 */