package com.tencent.map.lib.element;

public class MapPoi
{
  double a;
  String b;
  private double c;
  
  public MapPoi(double paramDouble1, double paramDouble2, String paramString)
  {
    this.c = paramDouble1;
    this.a = paramDouble2;
    this.b = paramString;
  }
  
  public double getLatitude()
  {
    return this.c;
  }
  
  public double getLongitude()
  {
    return this.a;
  }
  
  public String getPoiName()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.map.lib.element.MapPoi
 * JD-Core Version:    0.7.0.1
 */