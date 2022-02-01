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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributeYUVPosition", "attributeYUVTextureCoord", "frame", "", "uBuffer", "Ljava/nio/ByteBuffer;", "uTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "uniformUTexture", "uniformVTexture", "uniformYTexture", "uniformYUVRotateMatrix", "vBuffer", "vTextureObj", "yBuffer", "yTextureObj", "yuvProgramId", "afterRender", "", "getFrame", "release", "renderImpl", "setFrame", "updateScaleType", "Companion", "plugin-mediaeditor_release"})
public final class d
  extends a
{
  private static final String TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
  public static final d.a ikM;
  private com.tencent.mm.media.g.d ikA;
  private int ikB;
  private int ikC;
  private int ikD;
  private int ikE;
  private int ikF;
  private int ikG;
  private int ikH;
  private ByteBuffer ikI;
  private ByteBuffer ikJ;
  private ByteBuffer ikK;
  private byte[] ikL;
  private com.tencent.mm.media.g.d iky;
  private com.tencent.mm.media.g.d ikz;
  
  static
  {
    AppMethodBeat.i(218768);
    ikM = new d.a((byte)0);
    TAG = "MicroMsg.GLTextureRenderProcYuvToRgb";
    AppMethodBeat.o(218768);
  }
  
  private d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, paramInt5);
    AppMethodBeat.i(218767);
    this.ikL = new byte[0];
    c.a locala = com.tencent.mm.media.k.c.ilt;
    this.ikB = c.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D u_texture;\n        uniform sampler2D v_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           v = texture2D(v_texture, v_texCoord).r;\n           u = texture2D(u_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
    if (this.ikB == 0) {
      Log.e(TAG, "checkInit, load program failed!");
    }
    this.ikD = GLES20.glGetAttribLocation(this.ikB, "a_position");
    this.ikC = GLES20.glGetAttribLocation(this.ikB, "a_texCoord");
    this.ikE = GLES20.glGetUniformLocation(this.ikB, "y_texture");
    this.ikF = GLES20.glGetUniformLocation(this.ikB, "u_texture");
    this.ikG = GLES20.glGetUniformLocation(this.ikB, "v_texture");
    this.ikH = GLES20.glGetUniformLocation(this.ikB, "uMatrix");
    this.iky = com.tencent.mm.media.g.c.a(true, 5L);
    this.ikz = com.tencent.mm.media.g.c.a(true, 5L);
    this.ikA = com.tencent.mm.media.g.c.a(true, 5L);
    AppMethodBeat.o(218767);
  }
  
  protected final void aMU()
  {
    AppMethodBeat.i(218765);
    super.aMU();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    AppMethodBeat.o(218765);
  }
  
  protected final void aMV()
  {
    AppMethodBeat.i(218764);
    GLES30.glClear(16640);
    GLES30.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    if ((this.ikB != 0) && (this.hEp > 0) && (this.hEq > 0))
    {
      if (this.ikL.length != 0) {
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
        if ((this.ikI != null) && (this.ikJ != null) && (this.ikK != null))
        {
          localByteBuffer = this.ikI;
          if ((localByteBuffer != null) && (localByteBuffer.capacity() == this.hDn * this.hDo))
          {
            localByteBuffer = this.ikJ;
            if ((localByteBuffer != null) && (localByteBuffer.capacity() == this.hDn * this.hDo / 4))
            {
              localByteBuffer = this.ikK;
              if ((localByteBuffer != null) && (localByteBuffer.capacity() == this.hDn * this.hDn / 4)) {
                break label262;
              }
            }
          }
        }
        this.ikI = ByteBuffer.allocateDirect(this.hDn * this.hDo);
        this.ikJ = ByteBuffer.allocateDirect(this.hDn * this.hDo / 4);
        this.ikK = ByteBuffer.allocateDirect(this.hDn * this.hDo / 4);
        ByteBuffer localByteBuffer = this.ikI;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.ikJ;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.ikK;
        if (localByteBuffer != null) {
          localByteBuffer.order(ByteOrder.nativeOrder());
        }
        localByteBuffer = this.ikI;
        if (localByteBuffer != null) {
          localByteBuffer.put(this.ikL, 0, this.hDn * this.hDo);
        }
        localByteBuffer = this.ikI;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        localByteBuffer = this.ikJ;
        if (localByteBuffer != null) {
          localByteBuffer.put(this.ikL, this.hDn * this.hDo, this.hDn * this.hDo / 4);
        }
        localByteBuffer = this.ikJ;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        localByteBuffer = this.ikK;
        if (localByteBuffer != null) {
          localByteBuffer.put(this.ikL, this.hDn * this.hDo + this.hDn * this.hDo / 4, this.hDn * this.hDo / 4);
        }
        localByteBuffer = this.ikK;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        GLES20.glUseProgram(this.ikB);
        GLES20.glActiveTexture(33984);
        com.tencent.mm.media.g.d.a(this.iky, this.hDn, this.hDo, 6409, (Buffer)this.ikI, 0, 0, 48);
        GLES20.glUniform1i(this.ikE, 0);
        GLES20.glActiveTexture(33985);
        com.tencent.mm.media.g.d.a(this.ikz, this.hDn / 2, this.hDo / 2, 6409, (Buffer)this.ikJ, 0, 0, 48);
        GLES20.glUniform1i(this.ikF, 1);
        GLES20.glActiveTexture(33986);
        com.tencent.mm.media.g.d.a(this.ikA, this.hDn / 2, this.hDo / 2, 6409, (Buffer)this.ikK, 0, 0, 48);
        GLES20.glUniform1i(this.ikG, 2);
        GLES20.glUniformMatrix4fv(this.ikH, 1, false, this.ijG, 0);
        this.hDU.position(0);
        GLES20.glVertexAttribPointer(this.ikD, 2, 5126, false, 0, (Buffer)this.hDU);
        GLES20.glEnableVertexAttribArray(this.ikD);
        this.hDT.position(0);
        GLES20.glVertexAttribPointer(this.ikC, 2, 5126, false, 0, (Buffer)this.hDT);
        GLES20.glEnableVertexAttribArray(this.ikC);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.ikD);
        GLES20.glDisableVertexAttribArray(this.ikC);
        GLES20.glBindTexture(3553, 0);
        GLES20.glFinish();
      }
      AppMethodBeat.o(218764);
      return;
      i = 0;
      break;
    }
  }
  
  public final void ag(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218763);
    p.h(paramArrayOfByte, "frame");
    this.ikL = paramArrayOfByte;
    AppMethodBeat.o(218763);
  }
  
  public final void release()
  {
    AppMethodBeat.i(218766);
    super.release();
    this.iky.close();
    this.ikz.close();
    AppMethodBeat.o(218766);
  }
  
  public final void rm(int paramInt)
  {
    this.scaleType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.j.b.d
 * JD-Core Version:    0.7.0.1
 */