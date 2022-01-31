package com.tencent.map.lib.basemap.data;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
  implements Cloneable
{
  private double a;
  private double b;
  
  public b(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(97852);
    this.a = 4.9E-324D;
    this.b = 4.9E-324D;
    b(paramDouble1);
    a(paramDouble2);
    AppMethodBeat.o(97852);
  }
  
  public double a()
  {
    return this.a;
  }
  
  public void a(double paramDouble)
  {
    AppMethodBeat.i(97853);
    this.a = Math.max(-20037508.34D, Math.min(20037508.34D, paramDouble));
    AppMethodBeat.o(97853);
  }
  
  public double b()
  {
    return this.b;
  }
  
  public void b(double paramDouble)
  {
    AppMethodBeat.i(97854);
    this.b = Math.max(-20037508.34D, Math.min(20037508.34D, paramDouble));
    AppMethodBeat.o(97854);
  }
  
  public b c()
  {
    AppMethodBeat.i(97857);
    b localb = new b(this.b, this.a);
    AppMethodBeat.o(97857);
    return localb;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(97855);
    if (paramObject == this)
    {
      AppMethodBeat.o(97855);
      return true;
    }
    if (paramObject.hashCode() != hashCode())
    {
      AppMethodBeat.o(97855);
      return false;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(97855);
      return false;
    }
    paramObject = (b)paramObject;
    if ((Double.doubleToLongBits(paramObject.b) == Double.doubleToLongBits(this.b)) && (Double.doubleToLongBits(paramObject.a) == Double.doubleToLongBits(this.a)))
    {
      AppMethodBeat.o(97855);
      return true;
    }
    AppMethodBeat.o(97855);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(97856);
    long l1 = Double.doubleToLongBits(this.b);
    long l2 = Double.doubleToLongBits(this.a);
    int i = (int)(l2 ^ l2 >>> 32);
    int j = (int)(l1 ^ l1 >>> 32);
    AppMethodBeat.o(97856);
    return j + (i + 31) * 31;
  }
  
  public String toString()
  {
    AppMethodBeat.i(97851);
    String str = "x=" + this.b + ",y=" + this.a;
    AppMethodBeat.o(97851);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.map.lib.basemap.data.b
 * JD-Core Version:    0.7.0.1
 */