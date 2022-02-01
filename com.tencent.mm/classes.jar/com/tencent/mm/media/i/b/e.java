package com.tencent.mm.media.i.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcYuvToRgb;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributeYUVPosition", "attributeYUVTextureCoord", "frame", "", "uniformUVTexture", "uniformYTexture", "uniformYUVRotateMatrix", "uvBuffer", "Ljava/nio/ByteBuffer;", "uvTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "yBuffer", "yTextureObj", "yuvProgramId", "getFrame", "release", "", "renderImpl", "setFrame", "Companion", "plugin-mediaeditor_release"})
public final class e
  extends a
{
  private static final String TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
  public static final e.a gwc;
  private d gvR;
  private d gvS;
  private int gvT;
  private int gvU;
  private int gvV;
  private int gvW;
  private int gvX;
  private int gvY;
  private ByteBuffer gvZ;
  private ByteBuffer gwa;
  private byte[] gwb;
  
  static
  {
    AppMethodBeat.i(93867);
    gwc = new e.a((byte)0);
    TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
    AppMethodBeat.o(93867);
  }
  
  public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(93866);
    this.gwb = new byte[0];
    c.a locala = com.tencent.mm.media.j.c.gwl;
    this.gvT = c.a.ap("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D uv_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           u = texture2D(uv_texture, v_texCoord).a;\n           v = texture2D(uv_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
    if (this.gvT == 0) {
      ad.e(TAG, "checkInit, load program failed!");
    }
    this.gvV = GLES20.glGetAttribLocation(this.gvT, "a_position");
    this.gvU = GLES20.glGetAttribLocation(this.gvT, "a_texCoord");
    this.gvW = GLES20.glGetUniformLocation(this.gvT, "y_texture");
    this.gvX = GLES20.glGetUniformLocation(this.gvT, "uv_texture");
    this.gvY = GLES20.glGetUniformLocation(this.gvT, "uMatrix");
    this.gvR = com.tencent.mm.media.f.c.a(true, 5L);
    this.gvS = com.tencent.mm.media.f.c.a(true, 5L);
    AppMethodBeat.o(93866);
  }
  
  public final void U(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93863);
    k.h(paramArrayOfByte, "frame");
    this.gwb = paramArrayOfByte;
    AppMethodBeat.o(93863);
  }
  
  protected final void akv()
  {
    AppMethodBeat.i(93864);
    if ((this.gvT != 0) && (this.guK > 0) && (this.guL > 0))
    {
      if (this.gwb.length != 0) {
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
        if ((this.gvZ != null) && (this.gwa != null))
        {
          localByteBuffer = this.gvZ;
          if (localByteBuffer == null) {
            k.fvU();
          }
          if (localByteBuffer.capacity() == this.guI * this.guJ)
          {
            localByteBuffer = this.gwa;
            if (localByteBuffer == null) {
              k.fvU();
            }
            if (localByteBuffer.capacity() == this.guI * this.guJ / 2) {
              break label192;
            }
          }
        }
        this.gvZ = ByteBuffer.allocateDirect(this.guI * this.guJ);
        this.gwa = ByteBuffer.allocateDirect(this.guI * this.guJ / 2);
        ByteBuffer localByteBuffer = this.gvZ;
        if (localByteBuffer == null) {
          k.fvU();
        }
        localByteBuffer.order(ByteOrder.nativeOrder());
        localByteBuffer = this.gwa;
        if (localByteBuffer == null) {
          k.fvU();
        }
        localByteBuffer.order(ByteOrder.nativeOrder());
        label192:
        localByteBuffer = this.gvZ;
        if (localByteBuffer == null) {
          k.fvU();
        }
        localByteBuffer.put(this.gwb, 0, this.guI * this.guJ);
        localByteBuffer = this.gvZ;
        if (localByteBuffer == null) {
          k.fvU();
        }
        localByteBuffer.position(0);
        localByteBuffer = this.gwa;
        if (localByteBuffer == null) {
          k.fvU();
        }
        localByteBuffer.put(this.gwb, this.guI * this.guJ, this.guI * this.guJ / 2);
        localByteBuffer = this.gwa;
        if (localByteBuffer == null) {
          k.fvU();
        }
        localByteBuffer.position(0);
        GLES20.glUseProgram(this.gvT);
        GLES20.glActiveTexture(33984);
        d.a(this.gvR, this.guI, this.guJ, 6409, (Buffer)this.gvZ, 0, 0, 48);
        GLES20.glUniform1i(this.gvW, 0);
        GLES20.glActiveTexture(33985);
        d.a(this.gvS, this.guI / 2, this.guJ / 2, 6410, (Buffer)this.gwa, 0, 0, 48);
        GLES20.glUniform1i(this.gvX, 1);
        GLES20.glUniformMatrix4fv(this.gvY, 1, false, this.guX, 0);
        this.guT.position(0);
        GLES20.glVertexAttribPointer(this.gvV, 2, 5126, false, 0, (Buffer)this.guT);
        GLES20.glEnableVertexAttribArray(this.gvV);
        this.guS.position(0);
        GLES20.glVertexAttribPointer(this.gvU, 2, 5126, false, 0, (Buffer)this.guS);
        GLES20.glEnableVertexAttribArray(this.gvU);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.gvV);
        GLES20.glDisableVertexAttribArray(this.gvU);
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
    this.gvR.close();
    this.gvS.close();
    AppMethodBeat.o(93865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.i.b.e
 * JD-Core Version:    0.7.0.1
 */