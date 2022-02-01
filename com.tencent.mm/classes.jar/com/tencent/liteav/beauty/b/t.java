package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.d.j;
import com.tencent.liteav.basic.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class t
  extends g
{
  private ByteBuffer r;
  public int u;
  public int v;
  public int w;
  
  public t(String paramString)
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}", paramString);
  }
  
  public t(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(15101);
    this.u = -1;
    this.w = -1;
    a(j.a, false, true);
    AppMethodBeat.o(15101);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(15107);
    this.w = paramInt2;
    paramInt1 = a(paramInt1, paramInt3, paramInt4);
    AppMethodBeat.o(15107);
    return paramInt1;
  }
  
  public void a(j paramj, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(15105);
    paramj = k.a(paramj, paramBoolean1, paramBoolean2);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
    FloatBuffer localFloatBuffer = localByteBuffer.asFloatBuffer();
    localFloatBuffer.put(paramj);
    localFloatBuffer.flip();
    this.r = localByteBuffer;
    AppMethodBeat.o(15105);
  }
  
  public boolean b()
  {
    AppMethodBeat.i(15102);
    boolean bool = super.b();
    if (bool)
    {
      this.u = GLES20.glGetAttribLocation(p(), "inputTextureCoordinate2");
      this.v = GLES20.glGetUniformLocation(p(), "inputImageTexture2");
      GLES20.glEnableVertexAttribArray(this.u);
    }
    AppMethodBeat.o(15102);
    return bool;
  }
  
  public int c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15106);
    this.w = paramInt2;
    paramInt1 = a(paramInt1, this.m, this.n);
    AppMethodBeat.o(15106);
    return paramInt1;
  }
  
  public void e()
  {
    AppMethodBeat.i(15103);
    super.e();
    AppMethodBeat.o(15103);
  }
  
  public void i()
  {
    AppMethodBeat.i(15104);
    GLES20.glActiveTexture(33987);
    GLES20.glBindTexture(3553, this.w);
    GLES20.glUniform1i(this.v, 3);
    if (this.u != -1)
    {
      GLES20.glEnableVertexAttribArray(this.u);
      this.r.position(0);
      GLES20.glVertexAttribPointer(this.u, 2, 5126, false, 0, this.r);
    }
    AppMethodBeat.o(15104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.t
 * JD-Core Version:    0.7.0.1
 */