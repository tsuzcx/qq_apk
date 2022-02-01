package com.tencent.mm.media.i.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcYuvToRgb;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributeYUVPosition", "attributeYUVTextureCoord", "frame", "", "uniformUVTexture", "uniformYTexture", "uniformYUVRotateMatrix", "uvBuffer", "Ljava/nio/ByteBuffer;", "uvTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "yBuffer", "yTextureObj", "yuvProgramId", "getFrame", "release", "", "renderImpl", "setFrame", "Companion", "plugin-mediaeditor_release"})
public final class f
  extends a
{
  private static final String TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
  public static final f.a gWA;
  private d gWi;
  private int gWl;
  private int gWm;
  private int gWn;
  private int gWo;
  private int gWr;
  private ByteBuffer gWs;
  private byte[] gWv;
  private d gWx;
  private int gWy;
  private ByteBuffer gWz;
  
  static
  {
    AppMethodBeat.i(93867);
    gWA = new f.a((byte)0);
    TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
    AppMethodBeat.o(93867);
  }
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(93866);
    this.gWv = new byte[0];
    c.a locala = com.tencent.mm.media.j.c.gWJ;
    this.gWl = c.a.ax("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D uv_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           u = texture2D(uv_texture, v_texCoord).a;\n           v = texture2D(uv_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
    if (this.gWl == 0) {
      ac.e(TAG, "checkInit, load program failed!");
    }
    this.gWn = GLES20.glGetAttribLocation(this.gWl, "a_position");
    this.gWm = GLES20.glGetAttribLocation(this.gWl, "a_texCoord");
    this.gWo = GLES20.glGetUniformLocation(this.gWl, "y_texture");
    this.gWy = GLES20.glGetUniformLocation(this.gWl, "uv_texture");
    this.gWr = GLES20.glGetUniformLocation(this.gWl, "uMatrix");
    this.gWi = com.tencent.mm.media.f.c.a(true, 5L);
    this.gWx = com.tencent.mm.media.f.c.a(true, 5L);
    AppMethodBeat.o(93866);
  }
  
  public final void T(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93863);
    k.h(paramArrayOfByte, "frame");
    this.gWv = paramArrayOfByte;
    AppMethodBeat.o(93863);
  }
  
  protected final void arr()
  {
    AppMethodBeat.i(93864);
    if ((this.gWl != 0) && (this.grV > 0) && (this.grW > 0))
    {
      if (this.gWv.length != 0) {
        break label517;
      }
      i = 1;
      if (i != 0) {
        break label522;
      }
    }
    label517:
    label522:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((this.gWs != null) && (this.gWz != null))
        {
          localByteBuffer = this.gWs;
          if (localByteBuffer == null) {
            k.fOy();
          }
          if (localByteBuffer.capacity() == this.gqZ * this.gra)
          {
            localByteBuffer = this.gWz;
            if (localByteBuffer == null) {
              k.fOy();
            }
            if (localByteBuffer.capacity() == this.gqZ * this.gra / 2) {
              break label192;
            }
          }
        }
        this.gWs = ByteBuffer.allocateDirect(this.gqZ * this.gra);
        this.gWz = ByteBuffer.allocateDirect(this.gqZ * this.gra / 2);
        ByteBuffer localByteBuffer = this.gWs;
        if (localByteBuffer == null) {
          k.fOy();
        }
        localByteBuffer.order(ByteOrder.nativeOrder());
        localByteBuffer = this.gWz;
        if (localByteBuffer == null) {
          k.fOy();
        }
        localByteBuffer.order(ByteOrder.nativeOrder());
        label192:
        localByteBuffer = this.gWs;
        if (localByteBuffer == null) {
          k.fOy();
        }
        localByteBuffer.put(this.gWv, 0, this.gqZ * this.gra);
        localByteBuffer = this.gWs;
        if (localByteBuffer == null) {
          k.fOy();
        }
        localByteBuffer.position(0);
        localByteBuffer = this.gWz;
        if (localByteBuffer == null) {
          k.fOy();
        }
        localByteBuffer.put(this.gWv, this.gqZ * this.gra, this.gqZ * this.gra / 2);
        localByteBuffer = this.gWz;
        if (localByteBuffer == null) {
          k.fOy();
        }
        localByteBuffer.position(0);
        GLES20.glUseProgram(this.gWl);
        GLES20.glActiveTexture(33984);
        d.a(this.gWi, this.gqZ, this.gra, 6409, (Buffer)this.gWs, 0, 0, 48);
        GLES20.glUniform1i(this.gWo, 0);
        GLES20.glActiveTexture(33985);
        d.a(this.gWx, this.gqZ / 2, this.gra / 2, 6410, (Buffer)this.gWz, 0, 0, 48);
        GLES20.glUniform1i(this.gWy, 1);
        GLES20.glUniformMatrix4fv(this.gWr, 1, false, this.gVu, 0);
        this.grE.position(0);
        GLES20.glVertexAttribPointer(this.gWn, 2, 5126, false, 0, (Buffer)this.grE);
        GLES20.glEnableVertexAttribArray(this.gWn);
        this.grD.position(0);
        GLES20.glVertexAttribPointer(this.gWm, 2, 5126, false, 0, (Buffer)this.grD);
        GLES20.glEnableVertexAttribArray(this.gWm);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.gWn);
        GLES20.glDisableVertexAttribArray(this.gWm);
        GLES20.glBindTexture(3553, 0);
        GLES20.glFinish();
      }
      AppMethodBeat.o(93864);
      return;
      i = 0;
      break;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(93865);
    super.release();
    this.gWi.close();
    this.gWx.close();
    AppMethodBeat.o(93865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.i.b.f
 * JD-Core Version:    0.7.0.1
 */