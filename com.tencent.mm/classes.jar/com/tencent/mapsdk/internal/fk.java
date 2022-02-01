package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fk
{
  public final double a;
  public final double b;
  public final double c;
  public final double d;
  public final double e;
  public final double f;
  
  public fk(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(221715);
    this.a = paramDouble1;
    this.b = paramDouble3;
    this.c = paramDouble2;
    this.d = paramDouble4;
    this.e = ((paramDouble1 + paramDouble2) / 2.0D);
    this.f = ((paramDouble3 + paramDouble4) / 2.0D);
    AppMethodBeat.o(221715);
  }
  
  private boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return (paramDouble1 < this.c) && (this.a < paramDouble2) && (paramDouble3 < this.d) && (this.b < paramDouble4);
  }
  
  private boolean a(fl paramfl)
  {
    AppMethodBeat.i(221726);
    boolean bool = a(paramfl.a, paramfl.b);
    AppMethodBeat.o(221726);
    return bool;
  }
  
  private boolean b(fk paramfk)
  {
    return (paramfk.a >= this.a) && (paramfk.c <= this.c) && (paramfk.b >= this.b) && (paramfk.d <= this.d);
  }
  
  public final boolean a(double paramDouble1, double paramDouble2)
  {
    return (this.a <= paramDouble1) && (paramDouble1 <= this.c) && (this.b <= paramDouble2) && (paramDouble2 <= this.d);
  }
  
  public final boolean a(fk paramfk)
  {
    AppMethodBeat.i(221756);
    boolean bool = a(paramfk.a, paramfk.c, paramfk.b, paramfk.d);
    AppMethodBeat.o(221756);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.fk
 * JD-Core Version:    0.7.0.1
 */