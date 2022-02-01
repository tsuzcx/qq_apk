package com.tencent.liteav.beauty.b.b;

import com.tencent.liteav.beauty.b.r;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
  extends com.tencent.liteav.beauty.b.b
{
  private b r = null;
  private r s = null;
  private String t = "TXCBeauty3Filter";
  private float u = 0.0F;
  private float v = 0.0F;
  private float w = 0.0F;
  private float x = 0.0F;
  
  private boolean d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15004);
    if (this.r == null)
    {
      this.r = new b();
      this.r.a(true);
      if (!this.r.a())
      {
        AppMethodBeat.o(15004);
        return false;
      }
    }
    this.r.a(paramInt1, paramInt2);
    if (this.s == null)
    {
      this.s = new r();
      this.s.a(true);
      if (!this.s.a())
      {
        AppMethodBeat.o(15004);
        return false;
      }
    }
    this.s.a(paramInt1, paramInt2);
    AppMethodBeat.o(15004);
    return true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15003);
    if ((this.e == paramInt1) && (this.f == paramInt2))
    {
      AppMethodBeat.o(15003);
      return;
    }
    this.e = paramInt1;
    this.f = paramInt2;
    d(paramInt1, paramInt2);
    AppMethodBeat.o(15003);
  }
  
  public int b(int paramInt)
  {
    AppMethodBeat.i(15005);
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
    AppMethodBeat.o(15005);
    return paramInt;
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(15006);
    this.u = (paramInt / 10.0F);
    if (this.r != null) {
      this.r.a(this.u);
    }
    AppMethodBeat.o(15006);
  }
  
  public boolean c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15002);
    boolean bool = d(paramInt1, paramInt2);
    AppMethodBeat.o(15002);
    return bool;
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(15007);
    this.v = (paramInt / 10.0F);
    if (this.r != null) {
      this.r.b(this.v);
    }
    AppMethodBeat.o(15007);
  }
  
  public void e()
  {
    AppMethodBeat.i(15011);
    super.e();
    q();
    AppMethodBeat.o(15011);
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(15008);
    this.w = (paramInt / 10.0F);
    if (this.r != null) {
      this.r.c(this.w);
    }
    AppMethodBeat.o(15008);
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(15009);
    float f = paramInt / 20.0F;
    if (Math.abs(this.x - f) < 0.001D)
    {
      AppMethodBeat.o(15009);
      return;
    }
    this.x = f;
    if (this.s != null) {
      this.s.a(this.x);
    }
    AppMethodBeat.o(15009);
  }
  
  void q()
  {
    AppMethodBeat.i(15010);
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
    AppMethodBeat.o(15010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.b.a
 * JD-Core Version:    0.7.0.1
 */