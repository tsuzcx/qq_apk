package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.b.h;
import com.tencent.liteav.beauty.b.o;

public class a
  extends com.tencent.liteav.beauty.b.b
{
  private int A = 0;
  private float B = 1.0F;
  private final float C = 0.7F;
  private float D = 0.8F;
  private float E = 2.0F;
  private int F = 0;
  private int G = 0;
  private int H = 0;
  private int I = 0;
  private c r = null;
  private d s = null;
  private e t = null;
  private h u = null;
  private o v = null;
  private b w = null;
  private String x = "TXCBeauty2Filter";
  private int y = 0;
  private int z = 0;
  
  private boolean c(int paramInt1, int paramInt2)
  {
    this.F = paramInt1;
    this.G = paramInt2;
    this.H = paramInt1;
    this.I = paramInt2;
    if (1.0F != this.E)
    {
      this.H = ((int)(this.H / this.E));
      this.I = ((int)(this.I / this.E));
    }
    TXCLog.i(this.x, "mResampleRatio " + this.E + " mResampleWidth " + this.H + " mResampleHeight " + this.I);
    if (this.w == null)
    {
      this.w = new b();
      this.w.a(true);
      if (!this.w.a())
      {
        TXCLog.e(this.x, "mBeautyBlendFilter init failed!!, break init");
        return false;
      }
    }
    this.w.a(paramInt1, paramInt2);
    if (this.s == null)
    {
      this.s = new d();
      this.s.a(true);
      if (!this.s.a())
      {
        TXCLog.e(this.x, "m_horizontalFilter init failed!!, break init");
        return false;
      }
    }
    this.s.a(this.H, this.I);
    if (this.t == null)
    {
      this.t = new e();
      this.t.a(true);
      if (1.0F == this.E) {}
      for (boolean bool = false;; bool = true)
      {
        this.t.b(bool);
        if (this.t.a()) {
          break;
        }
        TXCLog.e(this.x, "m_verticalFilter init failed!!, break init");
        return false;
      }
    }
    this.t.a(this.H, this.I);
    if (this.u == null)
    {
      this.u = new h(1.0F);
      this.u.a(true);
      if (!this.u.a())
      {
        TXCLog.e(this.x, "m_gammaFilter init failed!!, break init");
        return false;
      }
    }
    this.u.a(this.H, this.I);
    if (this.v == null)
    {
      this.v = new o();
      this.v.a(true);
      if (!this.v.a())
      {
        TXCLog.e(this.x, "mSharpenFilter init failed!!, break init");
        return false;
      }
    }
    this.v.a(paramInt1, paramInt2);
    return true;
  }
  
  private void g(int paramInt)
  {
    this.B = (1.0F - paramInt / 50.0F);
    if (this.u != null) {
      this.u.a(this.B);
    }
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
    if (1.0F != this.E) {
      GLES20.glViewport(0, 0, this.H, this.I);
    }
    int i = this.s.b(paramInt);
    int j = this.t.b(i, paramInt);
    if (1.0F != this.E) {
      GLES20.glViewport(0, 0, this.F, this.G);
    }
    i = j;
    if (this.D > 0.7F) {
      i = this.v.b(j);
    }
    return this.w.b(i, paramInt);
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    return c(paramInt1, paramInt2);
  }
  
  public void c(int paramInt)
  {
    if (this.t != null) {
      this.t.a(paramInt / 10.0F);
    }
    this.y = paramInt;
    g(paramInt);
  }
  
  public void d(int paramInt)
  {
    if (this.w != null) {
      this.w.a(paramInt / 10.0F);
    }
    this.z = paramInt;
  }
  
  public void e()
  {
    super.e();
    q();
  }
  
  public void e(int paramInt)
  {
    if (this.w != null) {
      this.w.b(paramInt / 10.0F);
    }
    this.A = paramInt;
  }
  
  public void f(int paramInt)
  {
    this.D = (0.7F + paramInt / 12.0F);
    TXCLog.i(this.x, "set mSharpenLevel " + paramInt);
    if (this.v != null) {
      this.v.a(this.D);
    }
  }
  
  void q()
  {
    if (this.w != null)
    {
      this.w.d();
      this.w = null;
    }
    if (this.s != null)
    {
      this.s.d();
      this.s = null;
    }
    if (this.t != null)
    {
      this.t.d();
      this.t = null;
    }
    if (this.u != null)
    {
      this.u.d();
      this.u = null;
    }
    if (this.v != null)
    {
      this.v.d();
      this.v = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.a.a
 * JD-Core Version:    0.7.0.1
 */