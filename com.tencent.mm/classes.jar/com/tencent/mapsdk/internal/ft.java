package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate;

public final class ft
  implements Coordinate, Cloneable
{
  public static final double a = 20037508.34D;
  public double b;
  public double c;
  
  public ft(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(222006);
    this.b = 4.9E-324D;
    this.c = 4.9E-324D;
    setX(paramDouble1);
    setY(paramDouble2);
    AppMethodBeat.o(222006);
  }
  
  private double a()
  {
    return this.b;
  }
  
  private double b()
  {
    return this.c;
  }
  
  private ft c()
  {
    AppMethodBeat.i(222029);
    ft localft = new ft(this.c, this.b);
    AppMethodBeat.o(222029);
    return localft;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(222076);
    if (paramObject == this)
    {
      AppMethodBeat.o(222076);
      return true;
    }
    if (paramObject.hashCode() != hashCode())
    {
      AppMethodBeat.o(222076);
      return false;
    }
    if (!(paramObject instanceof ft))
    {
      AppMethodBeat.o(222076);
      return false;
    }
    paramObject = (ft)paramObject;
    if ((Double.doubleToLongBits(paramObject.c) == Double.doubleToLongBits(this.c)) && (Double.doubleToLongBits(paramObject.b) == Double.doubleToLongBits(this.b)))
    {
      AppMethodBeat.o(222076);
      return true;
    }
    AppMethodBeat.o(222076);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(222085);
    long l1 = Double.doubleToLongBits(this.c);
    long l2 = Double.doubleToLongBits(this.b);
    int i = (int)(l2 ^ l2 >>> 32);
    int j = (int)(l1 ^ l1 >>> 32);
    AppMethodBeat.o(222085);
    return j + (i + 31) * 31;
  }
  
  public final void setX(double paramDouble)
  {
    AppMethodBeat.i(222056);
    this.c = Math.max(-20037508.34D, Math.min(20037508.34D, paramDouble));
    AppMethodBeat.o(222056);
  }
  
  public final void setY(double paramDouble)
  {
    AppMethodBeat.i(222051);
    this.b = Math.max(-20037508.34D, Math.min(20037508.34D, paramDouble));
    AppMethodBeat.o(222051);
  }
  
  public final void setZ(double paramDouble) {}
  
  public final String toString()
  {
    AppMethodBeat.i(222041);
    String str = "x=" + this.c + ",y=" + this.b;
    AppMethodBeat.o(222041);
    return str;
  }
  
  public final double x()
  {
    return this.c;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ft
 * JD-Core Version:    0.7.0.1
 */