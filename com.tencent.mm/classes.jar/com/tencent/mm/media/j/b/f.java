package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcYuvToRgb;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributeYUVPosition", "attributeYUVTextureCoord", "frame", "", "uniformUVTexture", "uniformYTexture", "uniformYUVRotateMatrix", "uvBuffer", "Ljava/nio/ByteBuffer;", "uvTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "yBuffer", "yTextureObj", "yuvProgramId", "getFrame", "release", "", "renderImpl", "setFrame", "Companion", "plugin-mediaeditor_release"})
public final class f
  extends a
{
  private static final String TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
  public static final f.a hoG;
  private byte[] hoB;
  private d hoD;
  private int hoE;
  private ByteBuffer hoF;
  private d hoo;
  private int hor;
  private int hos;
  private int hot;
  private int hou;
  private int hox;
  private ByteBuffer hoy;
  
  static
  {
    AppMethodBeat.i(93867);
    hoG = new f.a((byte)0);
    TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
    AppMethodBeat.o(93867);
  }
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(93866);
    this.hoB = new byte[0];
    c.a locala = com.tencent.mm.media.k.c.hoP;
    this.hor = c.a.ay("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D uv_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           u = texture2D(uv_texture, v_texCoord).a;\n           v = texture2D(uv_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
    if (this.hor == 0) {
      ad.e(TAG, "checkInit, load program failed!");
    }
    this.hot = GLES20.glGetAttribLocation(this.hor, "a_position");
    this.hos = GLES20.glGetAttribLocation(this.hor, "a_texCoord");
    this.hou = GLES20.glGetUniformLocation(this.hor, "y_texture");
    this.hoE = GLES20.glGetUniformLocation(this.hor, "uv_texture");
    this.hox = GLES20.glGetUniformLocation(this.hor, "uMatrix");
    this.hoo = com.tencent.mm.media.g.c.a(true, 5L);
    this.hoD = com.tencent.mm.media.g.c.a(true, 5L);
    AppMethodBeat.o(93866);
  }
  
  public final void S(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93863);
    p.h(paramArrayOfByte, "frame");
    this.hoB = paramArrayOfByte;
    AppMethodBeat.o(93863);
  }
  
  protected final void aue()
  {
    AppMethodBeat.i(93864);
    if ((this.hor != 0) && (this.gLD > 0) && (this.gLE > 0))
    {
      if (this.hoB.length != 0) {
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
        if ((this.hoy != null) && (this.hoF != null))
        {
          localByteBuffer = this.hoy;
          if (localByteBuffer == null) {
            p.gfZ();
          }
          if (localByteBuffer.capacity() == this.gKJ * this.gKK)
          {
            localByteBuffer = this.hoF;
            if (localByteBuffer == null) {
              p.gfZ();
            }
            if (localByteBuffer.capacity() == this.gKJ * this.gKK / 2) {
              break label192;
            }
          }
        }
        this.hoy = ByteBuffer.allocateDirect(this.gKJ * this.gKK);
        this.hoF = ByteBuffer.allocateDirect(this.gKJ * this.gKK / 2);
        ByteBuffer localByteBuffer = this.hoy;
        if (localByteBuffer == null) {
          p.gfZ();
        }
        localByteBuffer.order(ByteOrder.nativeOrder());
        localByteBuffer = this.hoF;
        if (localByteBuffer == null) {
          p.gfZ();
        }
        localByteBuffer.order(ByteOrder.nativeOrder());
        label192:
        localByteBuffer = this.hoy;
        if (localByteBuffer == null) {
          p.gfZ();
        }
        localByteBuffer.put(this.hoB, 0, this.gKJ * this.gKK);
        localByteBuffer = this.hoy;
        if (localByteBuffer == null) {
          p.gfZ();
        }
        localByteBuffer.position(0);
        localByteBuffer = this.hoF;
        if (localByteBuffer == null) {
          p.gfZ();
        }
        localByteBuffer.put(this.hoB, this.gKJ * this.gKK, this.gKJ * this.gKK / 2);
        localByteBuffer = this.hoF;
        if (localByteBuffer == null) {
          p.gfZ();
        }
        localByteBuffer.position(0);
        GLES20.glUseProgram(this.hor);
        GLES20.glActiveTexture(33984);
        d.a(this.hoo, this.gKJ, this.gKK, 6409, (Buffer)this.hoy, 0, 0, 48);
        GLES20.glUniform1i(this.hou, 0);
        GLES20.glActiveTexture(33985);
        d.a(this.hoD, this.gKJ / 2, this.gKK / 2, 6410, (Buffer)this.hoF, 0, 0, 48);
        GLES20.glUniform1i(this.hoE, 1);
        GLES20.glUniformMatrix4fv(this.hox, 1, false, this.hnx, 0);
        this.gLm.position(0);
        GLES20.glVertexAttribPointer(this.hot, 2, 5126, false, 0, (Buffer)this.gLm);
        GLES20.glEnableVertexAttribArray(this.hot);
        this.gLl.position(0);
        GLES20.glVertexAttribPointer(this.hos, 2, 5126, false, 0, (Buffer)this.gLl);
        GLES20.glEnableVertexAttribArray(this.hos);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.hot);
        GLES20.glDisableVertexAttribArray(this.hos);
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
    this.hoo.close();
    this.hoD.close();
    AppMethodBeat.o(93865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.j.b.f
 * JD-Core Version:    0.7.0.1
 */