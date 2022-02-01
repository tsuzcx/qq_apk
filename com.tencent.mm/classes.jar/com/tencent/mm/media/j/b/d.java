package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributeYUVPosition", "attributeYUVTextureCoord", "frame", "", "uBuffer", "Ljava/nio/ByteBuffer;", "uTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "uniformUTexture", "uniformVTexture", "uniformYTexture", "uniformYUVRotateMatrix", "vBuffer", "vTextureObj", "yBuffer", "yTextureObj", "yuvProgramId", "afterRender", "", "getFrame", "release", "renderImpl", "setFrame", "updateScaleType", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  private static final String TAG;
  public static final d.a nEy;
  private com.tencent.mm.media.g.d nEA;
  private com.tencent.mm.media.g.d nEB;
  private int nEC;
  private int nED;
  private int nEE;
  private int nEF;
  private int nEG;
  private int nEH;
  private int nEI;
  private ByteBuffer nEJ;
  private ByteBuffer nEK;
  private ByteBuffer nEL;
  private byte[] nEM;
  private com.tencent.mm.media.g.d nEz;
  
  static
  {
    AppMethodBeat.i(237745);
    nEy = new d.a((byte)0);
    TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
    AppMethodBeat.o(237745);
  }
  
  private d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, paramInt5);
    AppMethodBeat.i(237742);
    this.nEM = new byte[0];
    c.a locala = com.tencent.mm.media.util.c.nFs;
    this.nEC = c.a.aN("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D u_texture;\n        uniform sampler2D v_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           v = texture2D(v_texture, v_texCoord).r;\n           u = texture2D(u_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
    if (this.nEC == 0) {
      Log.e(TAG, "checkInit, load program failed!");
    }
    this.nEE = GLES20.glGetAttribLocation(this.nEC, "a_position");
    this.nED = GLES20.glGetAttribLocation(this.nEC, "a_texCoord");
    this.nEF = GLES20.glGetUniformLocation(this.nEC, "y_texture");
    this.nEG = GLES20.glGetUniformLocation(this.nEC, "u_texture");
    this.nEH = GLES20.glGetUniformLocation(this.nEC, "v_texture");
    this.nEI = GLES20.glGetUniformLocation(this.nEC, "uMatrix");
    this.nEz = com.tencent.mm.media.g.c.d(true, 5L);
    this.nEA = com.tencent.mm.media.g.c.d(true, 5L);
    this.nEB = com.tencent.mm.media.g.c.d(true, 5L);
    AppMethodBeat.o(237742);
  }
  
  public final void ap(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(237747);
    s.u(paramArrayOfByte, "frame");
    this.nEM = paramArrayOfByte;
    AppMethodBeat.o(237747);
  }
  
  protected final void bqf()
  {
    AppMethodBeat.i(237768);
    super.bqf();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    AppMethodBeat.o(237768);
  }
  
  protected final void bqg()
  {
    AppMethodBeat.i(237765);
    GLES30.glClear(16640);
    GLES30.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    label55:
    ByteBuffer localByteBuffer;
    if ((this.nEC != 0) && (getDrawWidth() > 0) && (getDrawHeight() > 0))
    {
      if (this.nEM.length != 0) {
        break label706;
      }
      i = 1;
      if (i != 0) {
        break label711;
      }
      i = 1;
      if (i != 0) {
        label140:
        if ((this.nEJ != null) && (this.nEK != null) && (this.nEL != null))
        {
          localByteBuffer = this.nEJ;
          if ((localByteBuffer == null) || (localByteBuffer.capacity() != bpT() * bpU())) {
            break label716;
          }
          i = 1;
          label107:
          if (i != 0)
          {
            localByteBuffer = this.nEK;
            if ((localByteBuffer == null) || (localByteBuffer.capacity() != bpT() * bpU() / 4)) {
              break label721;
            }
            i = 1;
            if (i != 0)
            {
              localByteBuffer = this.nEL;
              if ((localByteBuffer == null) || (localByteBuffer.capacity() != bpT() * bpT() / 4)) {
                break label726;
              }
            }
          }
        }
      }
    }
    label706:
    label711:
    label716:
    label721:
    label726:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.nEJ = ByteBuffer.allocateDirect(bpT() * bpU());
        this.nEK = ByteBuffer.allocateDirect(bpT() * bpU() / 4);
        this.nEL = ByteBuffer.allocateDirect(bpT() * bpU() / 4);
        localByteBuffer = this.nEJ;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.nEK;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.nEL;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
      }
      localByteBuffer = this.nEJ;
      if (localByteBuffer != null) {
        localByteBuffer.put(this.nEM, 0, bpT() * bpU());
      }
      localByteBuffer = this.nEJ;
      if (localByteBuffer != null) {
        localByteBuffer.position(0);
      }
      localByteBuffer = this.nEK;
      if (localByteBuffer != null) {
        localByteBuffer.put(this.nEM, bpT() * bpU(), bpT() * bpU() / 4);
      }
      localByteBuffer = this.nEK;
      if (localByteBuffer != null) {
        localByteBuffer.position(0);
      }
      localByteBuffer = this.nEL;
      if (localByteBuffer != null) {
        localByteBuffer.put(this.nEM, bpT() * bpU() + bpT() * bpU() / 4, bpT() * bpU() / 4);
      }
      localByteBuffer = this.nEL;
      if (localByteBuffer != null) {
        localByteBuffer.position(0);
      }
      GLES20.glUseProgram(this.nEC);
      GLES20.glActiveTexture(33984);
      com.tencent.mm.media.g.d.a(this.nEz, bpT(), bpU(), 6409, (Buffer)this.nEJ, 0, 0, 48);
      GLES20.glUniform1i(this.nEF, 0);
      GLES20.glActiveTexture(33985);
      com.tencent.mm.media.g.d.a(this.nEA, bpT() / 2, bpU() / 2, 6409, (Buffer)this.nEK, 0, 0, 48);
      GLES20.glUniform1i(this.nEG, 1);
      GLES20.glActiveTexture(33986);
      com.tencent.mm.media.g.d.a(this.nEB, bpT() / 2, bpU() / 2, 6409, (Buffer)this.nEL, 0, 0, 48);
      GLES20.glUniform1i(this.nEH, 2);
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
      AppMethodBeat.o(237765);
      return;
      i = 0;
      break;
      i = 0;
      break label55;
      i = 0;
      break label107;
      i = 0;
      break label140;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(237773);
    super.release();
    this.nEz.close();
    this.nEA.close();
    AppMethodBeat.o(237773);
  }
  
  public final void ud(int paramInt)
  {
    AppMethodBeat.i(237753);
    setScaleType(paramInt);
    AppMethodBeat.o(237753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.j.b.d
 * JD-Core Version:    0.7.0.1
 */