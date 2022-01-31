package com.tencent.map.lib.basemap.data;

public class b
  implements Cloneable
{
  private double a = 4.9E-324D;
  private double b = 4.9E-324D;
  
  public b(double paramDouble1, double paramDouble2)
  {
    b(paramDouble1);
    a(paramDouble2);
  }
  
  public double a()
  {
    return this.a;
  }
  
  public void a(double paramDouble)
  {
    this.a = Math.max(-20037508.34D, Math.min(20037508.34D, paramDouble));
  }
  
  public double b()
  {
    return this.b;
  }
  
  public void b(double paramDouble)
  {
    this.b = Math.max(-20037508.34D, Math.min(20037508.34D, paramDouble));
  }
  
  public b c()
  {
    return new b(this.b, this.a);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject.hashCode() != hashCode()) {
        return false;
      }
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
    } while ((Double.doubleToLongBits(paramObject.b) == Double.doubleToLongBits(this.b)) && (Double.doubleToLongBits(paramObject.a) == Double.doubleToLongBits(this.a)));
    return false;
  }
  
  public int hashCode()
  {
    long l1 = Double.doubleToLongBits(this.b);
    long l2 = Double.doubleToLongBits(this.a);
    int i = (int)(l2 ^ l2 >>> 32);
    return (int)(l1 ^ l1 >>> 32) + (i + 31) * 31;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.map.lib.basemap.data.b
 * JD-Core Version:    0.7.0.1
 */