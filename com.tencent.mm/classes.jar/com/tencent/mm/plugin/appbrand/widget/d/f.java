package com.tencent.mm.plugin.appbrand.widget.d;

public final class f
{
  public final double x;
  public final double y;
  
  public f(double paramDouble1, double paramDouble2)
  {
    this.x = paramDouble1;
    this.y = paramDouble2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof f)) {
      return false;
    }
    return (this.x == ((f)paramObject).x) && (this.y == ((f)paramObject).y);
  }
  
  public final String toString()
  {
    return "Point{x=" + this.x + ", y=" + this.y + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.f
 * JD-Core Version:    0.7.0.1
 */