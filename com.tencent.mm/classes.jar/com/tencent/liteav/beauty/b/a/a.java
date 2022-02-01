package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.b.h;
import com.tencent.liteav.beauty.b.q;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
  private q v = null;
  private b w = null;
  private String x = "TXCBeauty2Filter";
  private int y = 0;
  private int z = 0;
  
  private boolean d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14989);
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
        AppMethodBeat.o(14989);
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
        AppMethodBeat.o(14989);
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
        AppMethodBeat.o(14989);
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
        AppMethodBeat.o(14989);
        return false;
      }
    }
    this.u.a(this.H, this.I);
    if (this.v == null)
    {
      this.v = new q();
      this.v.a(true);
      if (!this.v.a())
      {
        TXCLog.e(this.x, "mSharpenFilter init failed!!, break init");
        AppMethodBeat.o(14989);
        return false;
      }
    }
    this.v.a(paramInt1, paramInt2);
    AppMethodBeat.o(14989);
    return true;
  }
  
  private void g(int paramInt)
  {
    AppMethodBeat.i(14986);
    this.B = (1.0F - paramInt / 50.0F);
    if (this.u != null) {
      this.u.a(this.B);
    }
    AppMethodBeat.o(14986);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14982);
    if ((this.e == paramInt1) && (this.f == paramInt2))
    {
      AppMethodBeat.o(14982);
      return;
    }
    this.e = paramInt1;
    this.f = paramInt2;
    d(paramInt1, paramInt2);
    AppMethodBeat.o(14982);
  }
  
  public int b(int paramInt)
  {
    AppMethodBeat.i(14988);
    if (1.0F != this.E) {
      GLES20.glViewport(0, 0, this.H, this.I);
    }
    int i = this.s.b(paramInt);
    int j = this.t.c(i, paramInt);
    if (1.0F != this.E) {
      GLES20.glViewport(0, 0, this.F, this.G);
    }
    i = j;
    if (this.D > 0.7F) {
      i = this.v.b(j);
    }
    paramInt = this.w.c(i, paramInt);
    AppMethodBeat.o(14988);
    return paramInt;
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(14983);
    if (this.t != null) {
      this.t.a(paramInt / 10.0F);
    }
    this.y = paramInt;
    g(paramInt);
    AppMethodBeat.o(14983);
  }
  
  public boolean c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14981);
    boolean bool = d(paramInt1, paramInt2);
    AppMethodBeat.o(14981);
    return bool;
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(14984);
    if (this.w != null) {
      this.w.a(paramInt / 10.0F);
    }
    this.z = paramInt;
    AppMethodBeat.o(14984);
  }
  
  public void e()
  {
    AppMethodBeat.i(14991);
    super.e();
    r();
    AppMethodBeat.o(14991);
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(14985);
    if (this.w != null) {
      this.w.b(paramInt / 10.0F);
    }
    this.A = paramInt;
    AppMethodBeat.o(14985);
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(14987);
    float f = 0.7F + paramInt / 12.0F;
    if (Math.abs(this.D - f) < 0.001D)
    {
      AppMethodBeat.o(14987);
      return;
    }
    this.D = f;
    TXCLog.i(this.x, "set mSharpenLevel ".concat(String.valueOf(paramInt)));
    if (this.v != null) {
      this.v.a(this.D);
    }
    AppMethodBeat.o(14987);
  }
  
  void r()
  {
    AppMethodBeat.i(233501);
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
    AppMethodBeat.o(233501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.a.a
 * JD-Core Version:    0.7.0.1
 */