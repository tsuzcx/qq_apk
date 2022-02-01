package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fy
{
  private float a;
  private float b;
  private float c;
  
  public fy(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(221928);
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    double d = e();
    if (d != 0.0D)
    {
      this.a = ((float)(this.a / d));
      this.b = ((float)(this.b / d));
      this.c = ((float)(this.c / d));
    }
    AppMethodBeat.o(221928);
  }
  
  private static fy a(fy paramfy)
  {
    AppMethodBeat.i(221946);
    float f2 = paramfy.a;
    float f1 = paramfy.b;
    f2 = (float)(f2 / paramfy.e());
    f1 = (float)(-f1 / paramfy.e());
    fy localfy2 = new fy(f2, f1, 0.0F);
    fy localfy1 = localfy2;
    if (Math.acos((localfy2.a * paramfy.a + localfy2.b * paramfy.b + localfy2.c * paramfy.c) / (localfy2.e() * paramfy.e())) * 180.0D / 3.141592653589793D != 90.0D) {
      localfy1 = new fy(-f2, -f1, 0.0F);
    }
    AppMethodBeat.o(221946);
    return localfy1;
  }
  
  private static fy a(fy paramfy1, fy paramfy2)
  {
    AppMethodBeat.i(221936);
    paramfy1 = new fy(paramfy1.a + paramfy2.a, paramfy1.b + paramfy2.b, paramfy1.c + paramfy2.c);
    AppMethodBeat.o(221936);
    return paramfy1;
  }
  
  private float b()
  {
    return this.a;
  }
  
  private static fy b(fy paramfy)
  {
    AppMethodBeat.i(221952);
    paramfy = new fy(-paramfy.a, -paramfy.b, -paramfy.c);
    AppMethodBeat.o(221952);
    return paramfy;
  }
  
  private double c(fy paramfy)
  {
    AppMethodBeat.i(221978);
    double d = Math.acos((this.a * paramfy.a + this.b * paramfy.b + this.c * paramfy.c) / (e() * paramfy.e())) * 180.0D / 3.141592653589793D;
    AppMethodBeat.o(221978);
    return d;
  }
  
  private float c()
  {
    return this.b;
  }
  
  private float d()
  {
    return this.c;
  }
  
  private double e()
  {
    AppMethodBeat.i(221989);
    double d = Math.sqrt(this.a * this.a + this.b * this.b + this.c * this.c);
    AppMethodBeat.o(221989);
    return d;
  }
  
  private void f()
  {
    AppMethodBeat.i(221996);
    double d = e();
    if (d == 0.0D)
    {
      AppMethodBeat.o(221996);
      return;
    }
    this.a = ((float)(this.a / d));
    this.b = ((float)(this.b / d));
    this.c = ((float)(this.c / d));
    AppMethodBeat.o(221996);
  }
  
  public final float[] a()
  {
    return new float[] { this.a, this.b, this.c };
  }
  
  public final String toString()
  {
    AppMethodBeat.i(222012);
    String str = this.a + "," + this.b + "," + this.c;
    AppMethodBeat.o(222012);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.internal.fy
 * JD-Core Version:    0.7.0.1
 */