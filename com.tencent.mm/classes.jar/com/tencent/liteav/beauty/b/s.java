package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.h;
import com.tencent.liteav.basic.d.k;
import com.tencent.liteav.basic.d.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class s
  extends h
{
  public int r;
  public int s;
  public int t;
  public int u;
  public int v;
  public int w;
  private ByteBuffer x;
  private ByteBuffer y;
  
  public s(String paramString)
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", paramString);
    AppMethodBeat.i(15072);
    a(k.a, false, true);
    AppMethodBeat.o(15072);
  }
  
  public s(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(15073);
    this.t = -1;
    this.w = -1;
    a(k.a, false, true);
    AppMethodBeat.o(15073);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(15075);
    paramInt1 = a(paramInt1, paramInt2, paramInt3, this.m, this.n);
    AppMethodBeat.o(15075);
    return paramInt1;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(15076);
    this.t = paramInt2;
    this.w = paramInt3;
    paramInt1 = super.a(paramInt1, paramInt4, paramInt5);
    AppMethodBeat.o(15076);
    return paramInt1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15077);
    super.a(paramInt1, paramInt2);
    AppMethodBeat.o(15077);
  }
  
  public void a(k paramk, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(187060);
    paramk = l.a(paramk, paramBoolean1, paramBoolean2);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
    FloatBuffer localFloatBuffer = localByteBuffer.asFloatBuffer();
    localFloatBuffer.put(paramk);
    localFloatBuffer.flip();
    this.x = localByteBuffer;
    localByteBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
    localFloatBuffer = localByteBuffer.asFloatBuffer();
    localFloatBuffer.put(paramk);
    localFloatBuffer.flip();
    this.y = localByteBuffer;
    AppMethodBeat.o(187060);
  }
  
  public boolean b()
  {
    AppMethodBeat.i(15074);
    boolean bool = super.b();
    GLES20.glUseProgram(p());
    this.r = GLES20.glGetAttribLocation(p(), "inputTextureCoordinate2");
    this.u = GLES20.glGetAttribLocation(p(), "inputTextureCoordinate3");
    this.s = GLES20.glGetUniformLocation(p(), "inputImageTexture2");
    this.v = GLES20.glGetUniformLocation(p(), "inputImageTexture3");
    GLES20.glEnableVertexAttribArray(this.r);
    GLES20.glEnableVertexAttribArray(this.u);
    AppMethodBeat.o(15074);
    return bool;
  }
  
  public void i()
  {
    AppMethodBeat.i(15078);
    GLES20.glEnableVertexAttribArray(this.r);
    GLES20.glActiveTexture(33987);
    GLES20.glBindTexture(3553, this.t);
    GLES20.glUniform1i(this.s, 3);
    this.x.position(0);
    GLES20.glVertexAttribPointer(this.r, 2, 5126, false, 0, this.x);
    GLES20.glEnableVertexAttribArray(this.u);
    GLES20.glActiveTexture(33988);
    GLES20.glBindTexture(3553, this.w);
    GLES20.glUniform1i(this.v, 4);
    this.y.position(0);
    GLES20.glVertexAttribPointer(this.u, 2, 5126, false, 0, this.y);
    AppMethodBeat.o(15078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.s
 * JD-Core Version:    0.7.0.1
 */