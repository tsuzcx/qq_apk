package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate;

public final class fl
  implements Coordinate
{
  public double a;
  public double b;
  
  public fl() {}
  
  public fl(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  private fl a(double paramDouble)
  {
    AppMethodBeat.i(221752);
    fl localfl = new fl(this.a * paramDouble, this.b * paramDouble);
    AppMethodBeat.o(221752);
    return localfl;
  }
  
  private fl a(float paramFloat)
  {
    AppMethodBeat.i(221791);
    fl localfl = new fl((float)(Math.cos(paramFloat) * this.a - Math.sin(paramFloat) * this.b), (float)(Math.sin(paramFloat) * this.a + Math.cos(paramFloat) * this.b));
    AppMethodBeat.o(221791);
    return localfl;
  }
  
  private fl a(int paramInt)
  {
    AppMethodBeat.i(221788);
    double d2 = this.a;
    double d1 = this.b;
    int i = 0;
    while (i < paramInt)
    {
      double d3 = -d2;
      i += 1;
      d2 = d1;
      d1 = d3;
    }
    fl localfl = new fl(d2, d1);
    AppMethodBeat.o(221788);
    return localfl;
  }
  
  private fl a(fl paramfl)
  {
    AppMethodBeat.i(221730);
    double d1 = paramfl.a;
    double d2 = paramfl.b;
    paramfl = new fl(d1 + this.a, d2 + this.b);
    AppMethodBeat.o(221730);
    return paramfl;
  }
  
  private fl a(fl paramfl, float paramFloat)
  {
    AppMethodBeat.i(221797);
    fl localfl = b(paramfl);
    localfl = new fl((float)(Math.cos(paramFloat) * localfl.a - Math.sin(paramFloat) * localfl.b), (float)(Math.sin(paramFloat) * localfl.a + Math.cos(paramFloat) * localfl.b));
    double d1 = paramfl.a;
    double d2 = paramfl.b;
    paramfl = new fl(d1 + localfl.a, d2 + localfl.b);
    AppMethodBeat.o(221797);
    return paramfl;
  }
  
  private boolean a()
  {
    return (this.a >= 0.0D) && (this.a <= 1.0D) && (this.b >= 0.0D) && (this.b <= 1.0D);
  }
  
  private float b()
  {
    AppMethodBeat.i(221765);
    float f = (float)Math.hypot(this.a, this.b);
    AppMethodBeat.o(221765);
    return f;
  }
  
  private fl b(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(221721);
    fl localfl = new fl(this.a + paramDouble1, this.b + paramDouble2);
    AppMethodBeat.o(221721);
    return localfl;
  }
  
  private fl b(fl paramfl)
  {
    AppMethodBeat.i(221747);
    double d1 = paramfl.a;
    double d2 = paramfl.b;
    paramfl = new fl(this.a - d1, this.b - d2);
    AppMethodBeat.o(221747);
    return paramfl;
  }
  
  private float c(fl paramfl)
  {
    AppMethodBeat.i(221772);
    float f = paramfl.b(this).b();
    AppMethodBeat.o(221772);
    return f;
  }
  
  private fl c()
  {
    AppMethodBeat.i(221777);
    double d = 1.0D / b();
    fl localfl = new fl(this.a * d, d * this.b);
    AppMethodBeat.o(221777);
    return localfl;
  }
  
  private fl c(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(221741);
    fl localfl = new fl(this.a - paramDouble1, this.b - paramDouble2);
    AppMethodBeat.o(221741);
    return localfl;
  }
  
  private fl d()
  {
    AppMethodBeat.i(221781);
    double d = 1.0D / b();
    fl localfl = new fl(this.a * d, d * this.b);
    AppMethodBeat.o(221781);
    return localfl;
  }
  
  private fl d(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(221758);
    fl localfl = new fl(this.a * paramDouble1, this.b * paramDouble2);
    AppMethodBeat.o(221758);
    return localfl;
  }
  
  private static boolean e(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(221805);
    if (Double.compare(paramDouble1, paramDouble2) == 0)
    {
      AppMethodBeat.o(221805);
      return false;
    }
    if (Math.abs(paramDouble1 - paramDouble2) > 1.0E-006D)
    {
      AppMethodBeat.o(221805);
      return true;
    }
    AppMethodBeat.o(221805);
    return false;
  }
  
  public final void a(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(221815);
    if ((paramObject instanceof fl))
    {
      paramObject = (fl)paramObject;
      if ((!e(this.a, paramObject.a)) && (!e(this.b, paramObject.b)))
      {
        AppMethodBeat.o(221815);
        return true;
      }
      AppMethodBeat.o(221815);
      return false;
    }
    AppMethodBeat.o(221815);
    return false;
  }
  
  public final void setX(double paramDouble)
  {
    this.a = paramDouble;
  }
  
  public final void setY(double paramDouble)
  {
    this.b = paramDouble;
  }
  
  public final void setZ(double paramDouble) {}
  
  public final String toString()
  {
    AppMethodBeat.i(221824);
    String str = this.a + "," + this.b;
    AppMethodBeat.o(221824);
    return str;
  }
  
  public final double x()
  {
    return this.a;
  }
  
  public final double y()
  {
    return this.b;
  }
  
  public final double z()
  {
    return 0.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.fl
 * JD-Core Version:    0.7.0.1
 */