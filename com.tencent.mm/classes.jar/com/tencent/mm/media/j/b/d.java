package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributeYUVPosition", "attributeYUVTextureCoord", "frame", "", "uBuffer", "Ljava/nio/ByteBuffer;", "uTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "uniformUTexture", "uniformVTexture", "uniformYTexture", "uniformYUVRotateMatrix", "vBuffer", "vTextureObj", "yBuffer", "yTextureObj", "yuvProgramId", "afterRender", "", "getFrame", "release", "renderImpl", "setFrame", "updateScaleType", "Companion", "plugin-mediaeditor_release"})
public final class d
  extends a
{
  private static final String TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
  public static final a kZG;
  private int kZA;
  private int kZB;
  private ByteBuffer kZC;
  private ByteBuffer kZD;
  private ByteBuffer kZE;
  private byte[] kZF;
  private com.tencent.mm.media.g.d kZs;
  private com.tencent.mm.media.g.d kZt;
  private com.tencent.mm.media.g.d kZu;
  private int kZv;
  private int kZw;
  private int kZx;
  private int kZy;
  private int kZz;
  
  static
  {
    AppMethodBeat.i(259786);
    kZG = new a((byte)0);
    TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
    AppMethodBeat.o(259786);
  }
  
  private d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, paramInt5);
    AppMethodBeat.i(259784);
    this.kZF = new byte[0];
    c.a locala = com.tencent.mm.media.k.c.lar;
    this.kZv = c.a.aE("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D u_texture;\n        uniform sampler2D v_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           v = texture2D(v_texture, v_texCoord).r;\n           u = texture2D(u_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
    if (this.kZv == 0) {
      Log.e(TAG, "checkInit, load program failed!");
    }
    this.kZx = GLES20.glGetAttribLocation(this.kZv, "a_position");
    this.kZw = GLES20.glGetAttribLocation(this.kZv, "a_texCoord");
    this.kZy = GLES20.glGetUniformLocation(this.kZv, "y_texture");
    this.kZz = GLES20.glGetUniformLocation(this.kZv, "u_texture");
    this.kZA = GLES20.glGetUniformLocation(this.kZv, "v_texture");
    this.kZB = GLES20.glGetUniformLocation(this.kZv, "uMatrix");
    this.kZs = com.tencent.mm.media.g.c.a(true, 5L);
    this.kZt = com.tencent.mm.media.g.c.a(true, 5L);
    this.kZu = com.tencent.mm.media.g.c.a(true, 5L);
    AppMethodBeat.o(259784);
  }
  
  protected final void aVv()
  {
    AppMethodBeat.i(259782);
    super.aVv();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    AppMethodBeat.o(259782);
  }
  
  protected final void aVw()
  {
    AppMethodBeat.i(259781);
    GLES30.glClear(16640);
    GLES30.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    if ((this.kZv != 0) && (getDrawWidth() > 0) && (getDrawHeight() > 0))
    {
      if (this.kZF.length != 0) {
        break label686;
      }
      i = 1;
      if (i != 0) {
        break label691;
      }
    }
    label262:
    label686:
    label691:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((this.kZC != null) && (this.kZD != null) && (this.kZE != null))
        {
          localByteBuffer = this.kZC;
          if ((localByteBuffer != null) && (localByteBuffer.capacity() == aVx() * aVy()))
          {
            localByteBuffer = this.kZD;
            if ((localByteBuffer != null) && (localByteBuffer.capacity() == aVx() * aVy() / 4))
            {
              localByteBuffer = this.kZE;
              if ((localByteBuffer != null) && (localByteBuffer.capacity() == aVx() * aVx() / 4)) {
                break label262;
              }
            }
          }
        }
        this.kZC = ByteBuffer.allocateDirect(aVx() * aVy());
        this.kZD = ByteBuffer.allocateDirect(aVx() * aVy() / 4);
        this.kZE = ByteBuffer.allocateDirect(aVx() * aVy() / 4);
        ByteBuffer localByteBuffer = this.kZC;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.kZD;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.kZE;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.kZC;
        if (localByteBuffer != null) {
          localByteBuffer.put(this.kZF, 0, aVx() * aVy());
        }
        localByteBuffer = this.kZC;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        localByteBuffer = this.kZD;
        if (localByteBuffer != null) {
          localByteBuffer.put(this.kZF, aVx() * aVy(), aVx() * aVy() / 4);
        }
        localByteBuffer = this.kZD;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        localByteBuffer = this.kZE;
        if (localByteBuffer != null) {
          localByteBuffer.put(this.kZF, aVx() * aVy() + aVx() * aVy() / 4, aVx() * aVy() / 4);
        }
        localByteBuffer = this.kZE;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        GLES20.glUseProgram(this.kZv);
        GLES20.glActiveTexture(33984);
        com.tencent.mm.media.g.d.a(this.kZs, aVx(), aVy(), 6409, (Buffer)this.kZC, 0, 0, 48);
        GLES20.glUniform1i(this.kZy, 0);
        GLES20.glActiveTexture(33985);
        com.tencent.mm.media.g.d.a(this.kZt, aVx() / 2, aVy() / 2, 6409, (Buffer)this.kZD, 0, 0, 48);
        GLES20.glUniform1i(this.kZz, 1);
        GLES20.glActiveTexture(33986);
        com.tencent.mm.media.g.d.a(this.kZu, aVx() / 2, aVy() / 2, 6409, (Buffer)this.kZE, 0, 0, 48);
        GLES20.glUniform1i(this.kZA, 2);
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
      AppMethodBeat.o(259781);
      return;
      i = 0;
      break;
    }
  }
  
  public final void ap(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(259778);
    p.k(paramArrayOfByte, "frame");
    this.kZF = paramArrayOfByte;
    AppMethodBeat.o(259778);
  }
  
  public final void release()
  {
    AppMethodBeat.i(259783);
    super.release();
    this.kZs.close();
    this.kZt.close();
    AppMethodBeat.o(259783);
  }
  
  public final void ue(int paramInt)
  {
    AppMethodBeat.i(259779);
    setScaleType(paramInt);
    AppMethodBeat.o(259779);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.j.b.d
 * JD-Core Version:    0.7.0.1
 */