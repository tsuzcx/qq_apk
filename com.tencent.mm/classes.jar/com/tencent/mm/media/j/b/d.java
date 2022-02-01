package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributeYUVPosition", "attributeYUVTextureCoord", "frame", "", "uBuffer", "Ljava/nio/ByteBuffer;", "uTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "uniformUTexture", "uniformVTexture", "uniformYTexture", "uniformYUVRotateMatrix", "vBuffer", "vTextureObj", "yBuffer", "yTextureObj", "yuvProgramId", "afterRender", "", "getFrame", "release", "renderImpl", "setFrame", "Companion", "plugin-mediaeditor_release"})
public final class d
  extends a
{
  private static final String TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
  public static final d.a hoC;
  private ByteBuffer hoA;
  private byte[] hoB;
  private com.tencent.mm.media.g.d hoo;
  private com.tencent.mm.media.g.d hop;
  private com.tencent.mm.media.g.d hoq;
  private int hor;
  private int hos;
  private int hot;
  private int hou;
  private int hov;
  private int how;
  private int hox;
  private ByteBuffer hoy;
  private ByteBuffer hoz;
  
  static
  {
    AppMethodBeat.i(219311);
    hoC = new d.a((byte)0);
    TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
    AppMethodBeat.o(219311);
  }
  
  private d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 5);
    AppMethodBeat.i(219310);
    this.hoB = new byte[0];
    c.a locala = com.tencent.mm.media.k.c.hoP;
    this.hor = c.a.ay("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D u_texture;\n        uniform sampler2D v_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           v = texture2D(v_texture, v_texCoord).r;\n           u = texture2D(u_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
    if (this.hor == 0) {
      ad.e(TAG, "checkInit, load program failed!");
    }
    this.hot = GLES20.glGetAttribLocation(this.hor, "a_position");
    this.hos = GLES20.glGetAttribLocation(this.hor, "a_texCoord");
    this.hou = GLES20.glGetUniformLocation(this.hor, "y_texture");
    this.hov = GLES20.glGetUniformLocation(this.hor, "u_texture");
    this.how = GLES20.glGetUniformLocation(this.hor, "v_texture");
    this.hox = GLES20.glGetUniformLocation(this.hor, "uMatrix");
    this.hoo = com.tencent.mm.media.g.c.a(true, 5L);
    this.hop = com.tencent.mm.media.g.c.a(true, 5L);
    this.hoq = com.tencent.mm.media.g.c.a(true, 5L);
    AppMethodBeat.o(219310);
  }
  
  public final void S(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(219306);
    p.h(paramArrayOfByte, "frame");
    this.hoB = paramArrayOfByte;
    AppMethodBeat.o(219306);
  }
  
  protected final void aud()
  {
    AppMethodBeat.i(219308);
    super.aud();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    AppMethodBeat.o(219308);
  }
  
  protected final void aue()
  {
    AppMethodBeat.i(219307);
    GLES30.glClear(16640);
    GLES30.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    if ((this.hor != 0) && (this.gLD > 0) && (this.gLE > 0))
    {
      if (this.hoB.length != 0) {
        break label688;
      }
      i = 1;
      if (i != 0) {
        break label693;
      }
    }
    label262:
    label688:
    label693:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((this.hoy != null) && (this.hoz != null) && (this.hoA != null))
        {
          localByteBuffer = this.hoy;
          if ((localByteBuffer != null) && (localByteBuffer.capacity() == this.gKJ * this.gKK))
          {
            localByteBuffer = this.hoz;
            if ((localByteBuffer != null) && (localByteBuffer.capacity() == this.gKJ * this.gKK / 4))
            {
              localByteBuffer = this.hoA;
              if ((localByteBuffer != null) && (localByteBuffer.capacity() == this.gKJ * this.gKJ / 4)) {
                break label262;
              }
            }
          }
        }
        this.hoy = ByteBuffer.allocateDirect(this.gKJ * this.gKK);
        this.hoz = ByteBuffer.allocateDirect(this.gKJ * this.gKK / 4);
        this.hoA = ByteBuffer.allocateDirect(this.gKJ * this.gKK / 4);
        ByteBuffer localByteBuffer = this.hoy;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.hoz;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.hoA;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.hoy;
        if (localByteBuffer != null) {
          localByteBuffer.put(this.hoB, 0, this.gKJ * this.gKK);
        }
        localByteBuffer = this.hoy;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        localByteBuffer = this.hoz;
        if (localByteBuffer != null) {
          localByteBuffer.put(this.hoB, this.gKJ * this.gKK, this.gKJ * this.gKK / 4);
        }
        localByteBuffer = this.hoz;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        localByteBuffer = this.hoA;
        if (localByteBuffer != null) {
          localByteBuffer.put(this.hoB, this.gKJ * this.gKK + this.gKJ * this.gKK / 4, this.gKJ * this.gKK / 4);
        }
        localByteBuffer = this.hoA;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        GLES20.glUseProgram(this.hor);
        GLES20.glActiveTexture(33984);
        com.tencent.mm.media.g.d.a(this.hoo, this.gKJ, this.gKK, 6409, (Buffer)this.hoy, 0, 0, 48);
        GLES20.glUniform1i(this.hou, 0);
        GLES20.glActiveTexture(33985);
        com.tencent.mm.media.g.d.a(this.hop, this.gKJ / 2, this.gKK / 2, 6409, (Buffer)this.hoz, 0, 0, 48);
        GLES20.glUniform1i(this.hov, 1);
        GLES20.glActiveTexture(33986);
        com.tencent.mm.media.g.d.a(this.hoq, this.gKJ / 2, this.gKK / 2, 6409, (Buffer)this.hoA, 0, 0, 48);
        GLES20.glUniform1i(this.how, 2);
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
      AppMethodBeat.o(219307);
      return;
      i = 0;
      break;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(219309);
    super.release();
    this.hoo.close();
    this.hop.close();
    AppMethodBeat.o(219309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.j.b.d
 * JD-Core Version:    0.7.0.1
 */