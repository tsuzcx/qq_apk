package com.tencent.liteav.beauty.b.b;

import com.tencent.liteav.beauty.b.p;

public class a
  extends com.tencent.liteav.beauty.b.b
{
  private b r = null;
  private p s = null;
  private String t = "TXCBeauty3Filter";
  private float u = 0.0F;
  private float v = 0.0F;
  private float w = 0.0F;
  private float x = 0.0F;
  
  private boolean c(int paramInt1, int paramInt2)
  {
    if (this.r == null)
    {
      this.r = new b();
      this.r.a(true);
      if (this.r.a()) {}
    }
    do
    {
      return false;
      this.r.a(paramInt1, paramInt2);
      if (this.s != null) {
        break;
      }
      this.s = new p();
      this.s.a(true);
    } while (!this.s.a());
    this.s.a(paramInt1, paramInt2);
    return true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.e == paramInt1) && (this.f == paramInt2)) {
      return;
    }
    this.e = paramInt1;
    this.f = paramInt2;
    c(paramInt1, paramInt2);
  }
  
  public int b(int paramInt)
  {
    int i;
    if ((this.u <= 0.0F) && (this.v <= 0.0F))
    {
      i = paramInt;
      if (this.w <= 0.0F) {}
    }
    else
    {
      i = this.r.b(paramInt);
    }
    paramInt = i;
    if (this.x > 0.0F) {
      paramInt = this.s.b(i);
    }
    return paramInt;
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    return c(paramInt1, paramInt2);
  }
  
  public void c(int paramInt)
  {
    this.u = (paramInt / 10.0F);
    if (this.r != null) {
      this.r.a(this.u);
    }
  }
  
  public void d(int paramInt)
  {
    this.v = (paramInt / 10.0F);
    if (this.r != null) {
      this.r.b(this.v);
    }
  }
  
  public void e()
  {
    super.e();
    q();
  }
  
  public void e(int paramInt)
  {
    this.w = (paramInt / 10.0F);
    if (this.r != null) {
      this.r.c(this.w);
    }
  }
  
  public void f(int paramInt)
  {
    this.x = (paramInt / 20.0F);
    if (this.s != null) {
      this.s.a(this.x);
    }
  }
  
  void q()
  {
    if (this.r != null)
    {
      this.r.e();
      this.r = null;
    }
    if (this.s != null)
    {
      this.s.e();
      this.s = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.b.a
 * JD-Core Version:    0.7.0.1
 */