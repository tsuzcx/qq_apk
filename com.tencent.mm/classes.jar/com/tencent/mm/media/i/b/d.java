package com.tencent.mm.media.i.b;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributeYUVPosition", "attributeYUVTextureCoord", "frame", "", "uBuffer", "Ljava/nio/ByteBuffer;", "uTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "uniformUTexture", "uniformVTexture", "uniformYTexture", "uniformYUVRotateMatrix", "vBuffer", "vTextureObj", "yBuffer", "yTextureObj", "yuvProgramId", "afterRender", "", "getFrame", "release", "renderImpl", "setFrame", "Companion", "plugin-mediaeditor_release"})
public final class d
  extends a
{
  private static final String TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
  public static final d.a gWw;
  private com.tencent.mm.media.f.d gWi;
  private com.tencent.mm.media.f.d gWj;
  private com.tencent.mm.media.f.d gWk;
  private int gWl;
  private int gWm;
  private int gWn;
  private int gWo;
  private int gWp;
  private int gWq;
  private int gWr;
  private ByteBuffer gWs;
  private ByteBuffer gWt;
  private ByteBuffer gWu;
  private byte[] gWv;
  
  static
  {
    AppMethodBeat.i(209916);
    gWw = new d.a((byte)0);
    TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
    AppMethodBeat.o(209916);
  }
  
  private d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 5);
    AppMethodBeat.i(209915);
    this.gWv = new byte[0];
    c.a locala = com.tencent.mm.media.j.c.gWJ;
    this.gWl = c.a.ax("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D u_texture;\n        uniform sampler2D v_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           v = texture2D(v_texture, v_texCoord).r;\n           u = texture2D(u_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
    if (this.gWl == 0) {
      ac.e(TAG, "checkInit, load program failed!");
    }
    this.gWn = GLES20.glGetAttribLocation(this.gWl, "a_position");
    this.gWm = GLES20.glGetAttribLocation(this.gWl, "a_texCoord");
    this.gWo = GLES20.glGetUniformLocation(this.gWl, "y_texture");
    this.gWp = GLES20.glGetUniformLocation(this.gWl, "u_texture");
    this.gWq = GLES20.glGetUniformLocation(this.gWl, "v_texture");
    this.gWr = GLES20.glGetUniformLocation(this.gWl, "uMatrix");
    this.gWi = com.tencent.mm.media.f.c.a(true, 5L);
    this.gWj = com.tencent.mm.media.f.c.a(true, 5L);
    this.gWk = com.tencent.mm.media.f.c.a(true, 5L);
    AppMethodBeat.o(209915);
  }
  
  public final void T(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(209911);
    k.h(paramArrayOfByte, "frame");
    this.gWv = paramArrayOfByte;
    AppMethodBeat.o(209911);
  }
  
  protected final void arq()
  {
    AppMethodBeat.i(209913);
    super.arq();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    AppMethodBeat.o(209913);
  }
  
  protected final void arr()
  {
    AppMethodBeat.i(209912);
    GLES30.glClear(16640);
    GLES30.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    if ((this.gWl != 0) && (this.grV > 0) && (this.grW > 0))
    {
      if (this.gWv.length != 0) {
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
        if ((this.gWs != null) && (this.gWt != null) && (this.gWu != null))
        {
          localByteBuffer = this.gWs;
          if ((localByteBuffer != null) && (localByteBuffer.capacity() == this.gqZ * this.gra))
          {
            localByteBuffer = this.gWt;
            if ((localByteBuffer != null) && (localByteBuffer.capacity() == this.gqZ * this.gra / 4))
            {
              localByteBuffer = this.gWu;
              if ((localByteBuffer != null) && (localByteBuffer.capacity() == this.gqZ * this.gqZ / 4)) {
                break label262;
              }
            }
          }
        }
        this.gWs = ByteBuffer.allocateDirect(this.gqZ * this.gra);
        this.gWt = ByteBuffer.allocateDirect(this.gqZ * this.gra / 4);
        this.gWu = ByteBuffer.allocateDirect(this.gqZ * this.gra / 4);
        ByteBuffer localByteBuffer = this.gWs;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.gWt;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.gWu;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.gWs;
        if (localByteBuffer != null) {
          localByteBuffer.put(this.gWv, 0, this.gqZ * this.gra);
        }
        localByteBuffer = this.gWs;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        localByteBuffer = this.gWt;
        if (localByteBuffer != null) {
          localByteBuffer.put(this.gWv, this.gqZ * this.gra, this.gqZ * this.gra / 4);
        }
        localByteBuffer = this.gWt;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        localByteBuffer = this.gWu;
        if (localByteBuffer != null) {
          localByteBuffer.put(this.gWv, this.gqZ * this.gra + this.gqZ * this.gra / 4, this.gqZ * this.gra / 4);
        }
        localByteBuffer = this.gWu;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        GLES20.glUseProgram(this.gWl);
        GLES20.glActiveTexture(33984);
        com.tencent.mm.media.f.d.a(this.gWi, this.gqZ, this.gra, 6409, (Buffer)this.gWs, 0, 0, 48);
        GLES20.glUniform1i(this.gWo, 0);
        GLES20.glActiveTexture(33985);
        com.tencent.mm.media.f.d.a(this.gWj, this.gqZ / 2, this.gra / 2, 6409, (Buffer)this.gWt, 0, 0, 48);
        GLES20.glUniform1i(this.gWp, 1);
        GLES20.glActiveTexture(33986);
        com.tencent.mm.media.f.d.a(this.gWk, this.gqZ / 2, this.gra / 2, 6409, (Buffer)this.gWu, 0, 0, 48);
        GLES20.glUniform1i(this.gWq, 2);
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
      AppMethodBeat.o(209912);
      return;
      i = 0;
      break;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(209914);
    super.release();
    this.gWi.close();
    this.gWj.close();
    AppMethodBeat.o(209914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.i.b.d
 * JD-Core Version:    0.7.0.1
 */