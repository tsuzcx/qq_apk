package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcYuvToRgb;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributeYUVPosition", "attributeYUVTextureCoord", "frame", "", "uniformUVTexture", "uniformYTexture", "uniformYUVRotateMatrix", "uvBuffer", "Ljava/nio/ByteBuffer;", "uvTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "yBuffer", "yTextureObj", "yuvProgramId", "getFrame", "release", "", "renderImpl", "setFrame", "Companion", "plugin-mediaeditor_release"})
public final class f
  extends a
{
  private static final String TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
  public static final a kZK;
  private int kZB;
  private ByteBuffer kZC;
  private byte[] kZF;
  private d kZH;
  private int kZI;
  private ByteBuffer kZJ;
  private d kZs;
  private int kZv;
  private int kZw;
  private int kZx;
  private int kZy;
  
  static
  {
    AppMethodBeat.i(93867);
    kZK = new a((byte)0);
    TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
    AppMethodBeat.o(93867);
  }
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(93866);
    this.kZF = new byte[0];
    c.a locala = com.tencent.mm.media.k.c.lar;
    this.kZv = c.a.aE("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D uv_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           u = texture2D(uv_texture, v_texCoord).a;\n           v = texture2D(uv_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
    if (this.kZv == 0) {
      Log.e(TAG, "checkInit, load program failed!");
    }
    this.kZx = GLES20.glGetAttribLocation(this.kZv, "a_position");
    this.kZw = GLES20.glGetAttribLocation(this.kZv, "a_texCoord");
    this.kZy = GLES20.glGetUniformLocation(this.kZv, "y_texture");
    this.kZI = GLES20.glGetUniformLocation(this.kZv, "uv_texture");
    this.kZB = GLES20.glGetUniformLocation(this.kZv, "uMatrix");
    this.kZs = com.tencent.mm.media.g.c.a(true, 5L);
    this.kZH = com.tencent.mm.media.g.c.a(true, 5L);
    AppMethodBeat.o(93866);
  }
  
  protected final void aVw()
  {
    AppMethodBeat.i(93864);
    if ((this.kZv != 0) && (getDrawWidth() > 0) && (getDrawHeight() > 0))
    {
      if (this.kZF.length != 0) {
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
        if ((this.kZC != null) && (this.kZJ != null))
        {
          localByteBuffer = this.kZC;
          if (localByteBuffer == null) {
            p.iCn();
          }
          if (localByteBuffer.capacity() == aVx() * aVy())
          {
            localByteBuffer = this.kZJ;
            if (localByteBuffer == null) {
              p.iCn();
            }
            if (localByteBuffer.capacity() == aVx() * aVy() / 2) {
              break label192;
            }
          }
        }
        this.kZC = ByteBuffer.allocateDirect(aVx() * aVy());
        this.kZJ = ByteBuffer.allocateDirect(aVx() * aVy() / 2);
        ByteBuffer localByteBuffer = this.kZC;
        if (localByteBuffer == null) {
          p.iCn();
        }
        localByteBuffer.order(ByteOrder.nativeOrder());
        localByteBuffer = this.kZJ;
        if (localByteBuffer == null) {
          p.iCn();
        }
        localByteBuffer.order(ByteOrder.nativeOrder());
        label192:
        localByteBuffer = this.kZC;
        if (localByteBuffer == null) {
          p.iCn();
        }
        localByteBuffer.put(this.kZF, 0, aVx() * aVy());
        localByteBuffer = this.kZC;
        if (localByteBuffer == null) {
          p.iCn();
        }
        localByteBuffer.position(0);
        localByteBuffer = this.kZJ;
        if (localByteBuffer == null) {
          p.iCn();
        }
        localByteBuffer.put(this.kZF, aVx() * aVy(), aVx() * aVy() / 2);
        localByteBuffer = this.kZJ;
        if (localByteBuffer == null) {
          p.iCn();
        }
        localByteBuffer.position(0);
        GLES20.glUseProgram(this.kZv);
        GLES20.glActiveTexture(33984);
        d.a(this.kZs, aVx(), aVy(), 6409, (Buffer)this.kZC, 0, 0, 48);
        GLES20.glUniform1i(this.kZy, 0);
        GLES20.glActiveTexture(33985);
        d.a(this.kZH, aVx() / 2, aVy() / 2, 6410, (Buffer)this.kZJ, 0, 0, 48);
        GLES20.glUniform1i(this.kZI, 1);
        GLES20.glUniformMatrix4fv(this.kZB, 1, false, aVo(), 0);
        aVm().position(0);
        GLES20.glVertexAttribPointer(this.kZx, 2, 5126, false, 0, (Buffer)aVm());
        GLES20.glEnableVertexAttribArray(this.kZx);
        aVl().position(0);
        GLES20.glVertexAttribPointer(this.kZw, 2, 5126, false, 0, (Buffer)aVl());
        GLES20.glEnableVertexAttribArray(this.kZw);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.kZx);
        GLES20.glDisableVertexAttribArray(this.kZw);
        GLES20.glBindTexture(3553, 0);
        GLES20.glFinish();
      }
      AppMethodBeat.o(93864);
      return;
      i = 0;
      break;
    }
  }
  
  public final void ap(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93863);
    p.k(paramArrayOfByte, "frame");
    this.kZF = paramArrayOfByte;
    AppMethodBeat.o(93863);
  }
  
  public final void release()
  {
    AppMethodBeat.i(93865);
    super.release();
    this.kZs.close();
    this.kZH.close();
    AppMethodBeat.o(93865);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcYuvToRgb$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.j.b.f
 * JD-Core Version:    0.7.0.1
 */