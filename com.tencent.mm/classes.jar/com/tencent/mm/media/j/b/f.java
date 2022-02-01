package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcYuvToRgb;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributeYUVPosition", "attributeYUVTextureCoord", "frame", "", "uniformUVTexture", "uniformYTexture", "uniformYUVRotateMatrix", "uvBuffer", "Ljava/nio/ByteBuffer;", "uvTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "yBuffer", "yTextureObj", "yuvProgramId", "getFrame", "release", "", "renderImpl", "setFrame", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a
{
  private static final String TAG;
  public static final f.a nEN;
  private int nEC;
  private int nED;
  private int nEE;
  private int nEF;
  private int nEI;
  private ByteBuffer nEJ;
  private byte[] nEM;
  private d nEO;
  private int nEP;
  private ByteBuffer nEQ;
  private d nEz;
  
  static
  {
    AppMethodBeat.i(93867);
    nEN = new f.a((byte)0);
    TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
    AppMethodBeat.o(93867);
  }
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(93866);
    this.nEM = new byte[0];
    c.a locala = com.tencent.mm.media.util.c.nFs;
    this.nEC = c.a.aN("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D uv_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           u = texture2D(uv_texture, v_texCoord).a;\n           v = texture2D(uv_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
    if (this.nEC == 0) {
      Log.e(TAG, "checkInit, load program failed!");
    }
    this.nEE = GLES20.glGetAttribLocation(this.nEC, "a_position");
    this.nED = GLES20.glGetAttribLocation(this.nEC, "a_texCoord");
    this.nEF = GLES20.glGetUniformLocation(this.nEC, "y_texture");
    this.nEP = GLES20.glGetUniformLocation(this.nEC, "uv_texture");
    this.nEI = GLES20.glGetUniformLocation(this.nEC, "uMatrix");
    this.nEz = com.tencent.mm.media.g.c.d(true, 5L);
    this.nEO = com.tencent.mm.media.g.c.d(true, 5L);
    AppMethodBeat.o(93866);
  }
  
  public final void ap(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93863);
    s.u(paramArrayOfByte, "frame");
    this.nEM = paramArrayOfByte;
    AppMethodBeat.o(93863);
  }
  
  protected final void bqg()
  {
    AppMethodBeat.i(93864);
    if ((this.nEC != 0) && (getDrawWidth() > 0) && (getDrawHeight() > 0))
    {
      if (this.nEM.length != 0) {
        break label493;
      }
      i = 1;
      if (i != 0) {
        break label498;
      }
    }
    label180:
    label493:
    label498:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((this.nEJ != null) && (this.nEQ != null))
        {
          localByteBuffer = this.nEJ;
          s.checkNotNull(localByteBuffer);
          if (localByteBuffer.capacity() == bpT() * bpU())
          {
            localByteBuffer = this.nEQ;
            s.checkNotNull(localByteBuffer);
            if (localByteBuffer.capacity() == bpT() * bpU() / 2) {
              break label180;
            }
          }
        }
        this.nEJ = ByteBuffer.allocateDirect(bpT() * bpU());
        this.nEQ = ByteBuffer.allocateDirect(bpT() * bpU() / 2);
        ByteBuffer localByteBuffer = this.nEJ;
        s.checkNotNull(localByteBuffer);
        localByteBuffer.order(ByteOrder.nativeOrder());
        localByteBuffer = this.nEQ;
        s.checkNotNull(localByteBuffer);
        localByteBuffer.order(ByteOrder.nativeOrder());
        localByteBuffer = this.nEJ;
        s.checkNotNull(localByteBuffer);
        localByteBuffer.put(this.nEM, 0, bpT() * bpU());
        localByteBuffer = this.nEJ;
        s.checkNotNull(localByteBuffer);
        localByteBuffer.position(0);
        localByteBuffer = this.nEQ;
        s.checkNotNull(localByteBuffer);
        localByteBuffer.put(this.nEM, bpT() * bpU(), bpT() * bpU() / 2);
        localByteBuffer = this.nEQ;
        s.checkNotNull(localByteBuffer);
        localByteBuffer.position(0);
        GLES20.glUseProgram(this.nEC);
        GLES20.glActiveTexture(33984);
        d.a(this.nEz, bpT(), bpU(), 6409, (Buffer)this.nEJ, 0, 0, 48);
        GLES20.glUniform1i(this.nEF, 0);
        GLES20.glActiveTexture(33985);
        d.a(this.nEO, bpT() / 2, bpU() / 2, 6410, (Buffer)this.nEQ, 0, 0, 48);
        GLES20.glUniform1i(this.nEP, 1);
        GLES20.glUniformMatrix4fv(this.nEI, 1, false, bpY(), 0);
        bpW().position(0);
        GLES20.glVertexAttribPointer(this.nEE, 2, 5126, false, 0, (Buffer)bpW());
        GLES20.glEnableVertexAttribArray(this.nEE);
        bpV().position(0);
        GLES20.glVertexAttribPointer(this.nED, 2, 5126, false, 0, (Buffer)bpV());
        GLES20.glEnableVertexAttribArray(this.nED);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.nEE);
        GLES20.glDisableVertexAttribArray(this.nED);
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
    this.nEz.close();
    this.nEO.close();
    AppMethodBeat.o(93865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.j.b.f
 * JD-Core Version:    0.7.0.1
 */