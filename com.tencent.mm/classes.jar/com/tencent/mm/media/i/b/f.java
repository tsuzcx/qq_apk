package com.tencent.mm.media.i.b;

import android.opengl.GLES20;
import android.opengl.GLES30;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributeYUVPosition", "attributeYUVTextureCoord", "frame", "", "uBuffer", "Ljava/nio/ByteBuffer;", "uTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "uniformUTexture", "uniformVTexture", "uniformYTexture", "uniformYUVRotateMatrix", "vBuffer", "vTextureObj", "yBuffer", "yTextureObj", "yuvProgramId", "afterRender", "", "getFrame", "release", "renderImpl", "setFrame", "Companion", "plugin-mediaeditor_release"})
public final class f
  extends a
{
  public static final a KBM;
  private static final String TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
  private d KBG;
  private d KBH;
  private int KBI;
  private int KBJ;
  private ByteBuffer KBK;
  private ByteBuffer KBL;
  private d gvR;
  private int gvT;
  private int gvU;
  private int gvV;
  private int gvW;
  private int gvY;
  private ByteBuffer gvZ;
  private byte[] gwb;
  
  static
  {
    AppMethodBeat.i(205883);
    KBM = new a((byte)0);
    TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
    AppMethodBeat.o(205883);
  }
  
  private f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 5);
    AppMethodBeat.i(205882);
    this.gwb = new byte[0];
    c.a locala = com.tencent.mm.media.j.c.gwl;
    this.gvT = c.a.ap("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D u_texture;\n        uniform sampler2D v_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           v = texture2D(v_texture, v_texCoord).r;\n           u = texture2D(u_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
    if (this.gvT == 0) {
      ad.e(TAG, "checkInit, load program failed!");
    }
    this.gvV = GLES20.glGetAttribLocation(this.gvT, "a_position");
    this.gvU = GLES20.glGetAttribLocation(this.gvT, "a_texCoord");
    this.gvW = GLES20.glGetUniformLocation(this.gvT, "y_texture");
    this.KBI = GLES20.glGetUniformLocation(this.gvT, "u_texture");
    this.KBJ = GLES20.glGetUniformLocation(this.gvT, "v_texture");
    this.gvY = GLES20.glGetUniformLocation(this.gvT, "uMatrix");
    this.gvR = com.tencent.mm.media.f.c.a(true, 5L);
    this.KBG = com.tencent.mm.media.f.c.a(true, 5L);
    this.KBH = com.tencent.mm.media.f.c.a(true, 5L);
    AppMethodBeat.o(205882);
  }
  
  public final void U(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(205878);
    k.h(paramArrayOfByte, "frame");
    this.gwb = paramArrayOfByte;
    AppMethodBeat.o(205878);
  }
  
  protected final void aku()
  {
    AppMethodBeat.i(205880);
    super.aku();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    AppMethodBeat.o(205880);
  }
  
  protected final void akv()
  {
    AppMethodBeat.i(205879);
    GLES30.glClear(16640);
    GLES30.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    if ((this.gvT != 0) && (this.guK > 0) && (this.guL > 0))
    {
      if (this.gwb.length != 0) {
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
        if ((this.gvZ != null) && (this.KBK != null) && (this.KBL != null))
        {
          localByteBuffer = this.gvZ;
          if ((localByteBuffer != null) && (localByteBuffer.capacity() == this.guI * this.guJ))
          {
            localByteBuffer = this.KBK;
            if ((localByteBuffer != null) && (localByteBuffer.capacity() == this.guI * this.guJ / 4))
            {
              localByteBuffer = this.KBL;
              if ((localByteBuffer != null) && (localByteBuffer.capacity() == this.guI * this.guI / 4)) {
                break label262;
              }
            }
          }
        }
        this.gvZ = ByteBuffer.allocateDirect(this.guI * this.guJ);
        this.KBK = ByteBuffer.allocateDirect(this.guI * this.guJ / 4);
        this.KBL = ByteBuffer.allocateDirect(this.guI * this.guJ / 4);
        ByteBuffer localByteBuffer = this.gvZ;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.KBK;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.KBL;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.gvZ;
        if (localByteBuffer != null) {
          localByteBuffer.put(this.gwb, 0, this.guI * this.guJ);
        }
        localByteBuffer = this.gvZ;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        localByteBuffer = this.KBK;
        if (localByteBuffer != null) {
          localByteBuffer.put(this.gwb, this.guI * this.guJ, this.guI * this.guJ / 4);
        }
        localByteBuffer = this.KBK;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        localByteBuffer = this.KBL;
        if (localByteBuffer != null) {
          localByteBuffer.put(this.gwb, this.guI * this.guJ + this.guI * this.guJ / 4, this.guI * this.guJ / 4);
        }
        localByteBuffer = this.KBL;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        GLES20.glUseProgram(this.gvT);
        GLES20.glActiveTexture(33984);
        d.a(this.gvR, this.guI, this.guJ, 6409, (Buffer)this.gvZ, 0, 0, 48);
        GLES20.glUniform1i(this.gvW, 0);
        GLES20.glActiveTexture(33985);
        d.a(this.KBG, this.guI / 2, this.guJ / 2, 6409, (Buffer)this.KBK, 0, 0, 48);
        GLES20.glUniform1i(this.KBI, 1);
        GLES20.glActiveTexture(33986);
        d.a(this.KBH, this.guI / 2, this.guJ / 2, 6409, (Buffer)this.KBL, 0, 0, 48);
        GLES20.glUniform1i(this.KBJ, 2);
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
      AppMethodBeat.o(205879);
      return;
      i = 0;
      break;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(205881);
    super.release();
    this.gvR.close();
    this.KBG.close();
    AppMethodBeat.o(205881);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.i.b.f
 * JD-Core Version:    0.7.0.1
 */