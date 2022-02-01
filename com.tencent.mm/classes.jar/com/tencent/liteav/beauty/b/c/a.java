package com.tencent.liteav.beauty.b.c;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
  extends com.tencent.liteav.beauty.b.b
{
  private d r = null;
  private d s = null;
  private b t = null;
  private c u = null;
  private d v = null;
  private d w = null;
  private float x = 0.2F;
  private float y = 0.2F;
  private float z = 0.2F;
  
  private boolean d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221454);
    if (this.r == null)
    {
      this.r = new d(true);
      this.r.a(true);
      if (!this.r.a())
      {
        TXCLog.e("TXCBeauty4Filter", "mSkinBlurFilterVertical init failed!!, break init");
        AppMethodBeat.o(221454);
        return false;
      }
    }
    if (this.s == null)
    {
      this.s = new d(false);
      this.s.a(true);
      if (!this.s.a())
      {
        TXCLog.e("TXCBeauty4Filter", "mSkinBlurFilterHorizontal init failed!!, break init");
        AppMethodBeat.o(221454);
        return false;
      }
    }
    if (this.t == null)
    {
      this.t = new b();
      this.t.a(true);
      if (!this.t.a())
      {
        TXCLog.e("TXCBeauty4Filter", "mBorderFilter init failed!!, break init");
        AppMethodBeat.o(221454);
        return false;
      }
    }
    if (this.v == null)
    {
      this.v = new d(true);
      this.v.a(true);
      if (!this.v.a())
      {
        TXCLog.e("TXCBeauty4Filter", "mBorderBlurFilterVertical init failed!!, break init");
        AppMethodBeat.o(221454);
        return false;
      }
    }
    if (this.w == null)
    {
      this.w = new d(false);
      this.w.a(true);
      if (!this.w.a())
      {
        TXCLog.e("TXCBeauty4Filter", "mBorderBlurFilterHorizontal init failed!!, break init");
        AppMethodBeat.o(221454);
        return false;
      }
    }
    if (this.u == null)
    {
      this.u = new c();
      this.u.a(true);
      if (!this.u.a())
      {
        TXCLog.e("TXCBeauty4Filter", "mSmoothFilter init failed!!, break init");
        AppMethodBeat.o(221454);
        return false;
      }
    }
    this.u.a(360.0F, 640.0F);
    this.u.a(this.x);
    this.u.b(this.y);
    this.u.c(this.z);
    a(paramInt1, paramInt2);
    AppMethodBeat.o(221454);
    return true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221453);
    super.a(paramInt1, paramInt2);
    this.e = paramInt1;
    this.f = paramInt2;
    this.r.a(paramInt1, paramInt2);
    this.s.a(paramInt1, paramInt2);
    this.t.a(paramInt1, paramInt2);
    this.v.a(paramInt1, paramInt2);
    this.w.a(paramInt1, paramInt2);
    this.u.a(paramInt1, paramInt2);
    AppMethodBeat.o(221453);
  }
  
  public int b(int paramInt)
  {
    AppMethodBeat.i(221455);
    int i;
    if ((this.x <= 0.0F) && (this.y <= 0.0F))
    {
      i = paramInt;
      if (this.z <= 0.0F) {}
    }
    else
    {
      i = this.r.b(paramInt);
      i = this.s.b(i);
      int j = this.t.c(paramInt, i);
      j = this.v.b(j);
      j = this.w.b(j);
      i = this.u.a(paramInt, i, j);
    }
    AppMethodBeat.o(221455);
    return i;
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(221456);
    this.x = (paramInt / 10.0F);
    if (this.u != null) {
      this.u.a(this.x);
    }
    AppMethodBeat.o(221456);
  }
  
  public boolean c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221452);
    this.e = paramInt1;
    this.f = paramInt2;
    boolean bool = d(paramInt1, paramInt2);
    AppMethodBeat.o(221452);
    return bool;
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(221457);
    this.y = (paramInt / 10.0F);
    if (this.u != null) {
      this.u.b(this.y);
    }
    AppMethodBeat.o(221457);
  }
  
  public void e()
  {
    AppMethodBeat.i(221461);
    super.e();
    q();
    AppMethodBeat.o(221461);
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(221458);
    this.z = (paramInt / 10.0F);
    if (this.u != null) {
      this.u.c(this.z);
    }
    AppMethodBeat.o(221458);
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(221459);
    this.u.d(paramInt / 10.0F);
    AppMethodBeat.o(221459);
  }
  
  void q()
  {
    AppMethodBeat.i(221460);
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
    if (this.t != null)
    {
      this.t.e();
      this.t = null;
    }
    if (this.u != null)
    {
      this.u.e();
      this.u = null;
    }
    if (this.v != null)
    {
      this.v.e();
      this.v = null;
    }
    if (this.w != null)
    {
      this.w.e();
      this.w = null;
    }
    AppMethodBeat.o(221460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.c.a
 * JD-Core Version:    0.7.0.1
 */