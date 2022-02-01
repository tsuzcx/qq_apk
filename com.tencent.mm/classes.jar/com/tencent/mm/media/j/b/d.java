package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributeYUVPosition", "attributeYUVTextureCoord", "frame", "", "uBuffer", "Ljava/nio/ByteBuffer;", "uTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "uniformUTexture", "uniformVTexture", "uniformYTexture", "uniformYUVRotateMatrix", "vBuffer", "vTextureObj", "yBuffer", "yTextureObj", "yuvProgramId", "afterRender", "", "getFrame", "release", "renderImpl", "setFrame", "Companion", "plugin-mediaeditor_release"})
public final class d
  extends a
{
  private static final String TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
  public static final d.a hrq;
  private com.tencent.mm.media.g.d hrc;
  private com.tencent.mm.media.g.d hrd;
  private com.tencent.mm.media.g.d hre;
  private int hrf;
  private int hrg;
  private int hrh;
  private int hri;
  private int hrj;
  private int hrk;
  private int hrl;
  private ByteBuffer hrm;
  private ByteBuffer hrn;
  private ByteBuffer hro;
  private byte[] hrp;
  
  static
  {
    AppMethodBeat.i(217537);
    hrq = new d.a((byte)0);
    TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
    AppMethodBeat.o(217537);
  }
  
  private d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 5);
    AppMethodBeat.i(217536);
    this.hrp = new byte[0];
    c.a locala = com.tencent.mm.media.k.c.hrD;
    this.hrf = c.a.az("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D u_texture;\n        uniform sampler2D v_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           v = texture2D(v_texture, v_texCoord).r;\n           u = texture2D(u_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
    if (this.hrf == 0) {
      ae.e(TAG, "checkInit, load program failed!");
    }
    this.hrh = GLES20.glGetAttribLocation(this.hrf, "a_position");
    this.hrg = GLES20.glGetAttribLocation(this.hrf, "a_texCoord");
    this.hri = GLES20.glGetUniformLocation(this.hrf, "y_texture");
    this.hrj = GLES20.glGetUniformLocation(this.hrf, "u_texture");
    this.hrk = GLES20.glGetUniformLocation(this.hrf, "v_texture");
    this.hrl = GLES20.glGetUniformLocation(this.hrf, "uMatrix");
    this.hrc = com.tencent.mm.media.g.c.a(true, 5L);
    this.hrd = com.tencent.mm.media.g.c.a(true, 5L);
    this.hre = com.tencent.mm.media.g.c.a(true, 5L);
    AppMethodBeat.o(217536);
  }
  
  public final void S(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(217532);
    p.h(paramArrayOfByte, "frame");
    this.hrp = paramArrayOfByte;
    AppMethodBeat.o(217532);
  }
  
  protected final void aus()
  {
    AppMethodBeat.i(217534);
    super.aus();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    AppMethodBeat.o(217534);
  }
  
  protected final void aut()
  {
    AppMethodBeat.i(217533);
    GLES30.glClear(16640);
    GLES30.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    if ((this.hrf != 0) && (this.gOm > 0) && (this.gOn > 0))
    {
      if (this.hrp.length != 0) {
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
        if ((this.hrm != null) && (this.hrn != null) && (this.hro != null))
        {
          localByteBuffer = this.hrm;
          if ((localByteBuffer != null) && (localByteBuffer.capacity() == this.gNs * this.gNt))
          {
            localByteBuffer = this.hrn;
            if ((localByteBuffer != null) && (localByteBuffer.capacity() == this.gNs * this.gNt / 4))
            {
              localByteBuffer = this.hro;
              if ((localByteBuffer != null) && (localByteBuffer.capacity() == this.gNs * this.gNs / 4)) {
                break label262;
              }
            }
          }
        }
        this.hrm = ByteBuffer.allocateDirect(this.gNs * this.gNt);
        this.hrn = ByteBuffer.allocateDirect(this.gNs * this.gNt / 4);
        this.hro = ByteBuffer.allocateDirect(this.gNs * this.gNt / 4);
        ByteBuffer localByteBuffer = this.hrm;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.hrn;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.hro;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.hrm;
        if (localByteBuffer != null) {
          localByteBuffer.put(this.hrp, 0, this.gNs * this.gNt);
        }
        localByteBuffer = this.hrm;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        localByteBuffer = this.hrn;
        if (localByteBuffer != null) {
          localByteBuffer.put(this.hrp, this.gNs * this.gNt, this.gNs * this.gNt / 4);
        }
        localByteBuffer = this.hrn;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        localByteBuffer = this.hro;
        if (localByteBuffer != null) {
          localByteBuffer.put(this.hrp, this.gNs * this.gNt + this.gNs * this.gNt / 4, this.gNs * this.gNt / 4);
        }
        localByteBuffer = this.hro;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        GLES20.glUseProgram(this.hrf);
        GLES20.glActiveTexture(33984);
        com.tencent.mm.media.g.d.a(this.hrc, this.gNs, this.gNt, 6409, (Buffer)this.hrm, 0, 0, 48);
        GLES20.glUniform1i(this.hri, 0);
        GLES20.glActiveTexture(33985);
        com.tencent.mm.media.g.d.a(this.hrd, this.gNs / 2, this.gNt / 2, 6409, (Buffer)this.hrn, 0, 0, 48);
        GLES20.glUniform1i(this.hrj, 1);
        GLES20.glActiveTexture(33986);
        com.tencent.mm.media.g.d.a(this.hre, this.gNs / 2, this.gNt / 2, 6409, (Buffer)this.hro, 0, 0, 48);
        GLES20.glUniform1i(this.hrk, 2);
        GLES20.glUniformMatrix4fv(this.hrl, 1, false, this.hql, 0);
        this.gNV.position(0);
        GLES20.glVertexAttribPointer(this.hrh, 2, 5126, false, 0, (Buffer)this.gNV);
        GLES20.glEnableVertexAttribArray(this.hrh);
        this.gNU.position(0);
        GLES20.glVertexAttribPointer(this.hrg, 2, 5126, false, 0, (Buffer)this.gNU);
        GLES20.glEnableVertexAttribArray(this.hrg);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.hrh);
        GLES20.glDisableVertexAttribArray(this.hrg);
        GLES20.glBindTexture(3553, 0);
        GLES20.glFinish();
      }
      AppMethodBeat.o(217533);
      return;
      i = 0;
      break;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(217535);
    super.release();
    this.hrc.close();
    this.hrd.close();
    AppMethodBeat.o(217535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.j.b.d
 * JD-Core Version:    0.7.0.1
 */