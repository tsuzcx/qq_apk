package com.tencent.map.lib.basemap.data;

public class DoublePoint
{
  public double x;
  public double y;
  
  public DoublePoint() {}
  
  public DoublePoint(double paramDouble1, double paramDouble2)
  {
    this.x = paramDouble1;
    this.y = paramDouble2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof DoublePoint))
    {
      paramObject = (DoublePoint)paramObject;
      bool1 = bool2;
      if (this.x == paramObject.x)
      {
        bool1 = bool2;
        if (this.y == paramObject.y) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void set(double paramDouble1, double paramDouble2)
  {
    this.x = paramDouble1;
    this.y = paramDouble2;
  }
  
  public String toString()
  {
    return this.x + "," + this.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.map.lib.basemap.data.DoublePoint
 * JD-Core Version:    0.7.0.1
 */