package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;

public class j
{
  private static String i = "GPUGreenScreen";
  private int a;
  private int b;
  private boolean c;
  private u d;
  private boolean e;
  private com.tencent.liteav.basic.d.e f;
  private e g;
  private boolean h;
  
  private void b()
  {
    if (this.d != null) {
      this.d.a();
    }
    this.d = null;
    this.e = false;
    this.h = false;
  }
  
  private void c()
  {
    if ((this.b != -1) && (this.b != this.a))
    {
      GLES20.glDeleteTextures(1, new int[] { this.b }, 0);
      this.b = -1;
    }
    if (this.a != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { this.a }, 0);
      this.a = -1;
    }
  }
  
  public int a(int paramInt)
  {
    return paramInt;
  }
  
  public void a()
  {
    b();
    c();
    if (this.f != null)
    {
      this.f.d();
      this.f = null;
    }
    if (this.g != null)
    {
      this.g.d();
      this.g = null;
    }
    this.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.j
 * JD-Core Version:    0.7.0.1
 */