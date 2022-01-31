package com.d.a.a;

final class s$b
  implements Runnable
{
  final double aZm;
  final double aZn;
  final double aZo;
  final double aZp;
  final double aZq;
  final double aZr;
  final double lat;
  final double lng;
  
  private s$b(s params, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8)
  {
    this.lat = paramDouble1;
    this.lng = paramDouble2;
    this.aZm = paramDouble3;
    this.aZn = paramDouble4;
    this.aZo = paramDouble5;
    this.aZp = paramDouble6;
    this.aZq = paramDouble7;
    this.aZr = paramDouble8;
  }
  
  public final void run()
  {
    this.aZl.b(this.lat, this.lng, this.aZm, this.aZn, this.aZo, this.aZp, this.aZq, this.aZr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.d.a.a.s.b
 * JD-Core Version:    0.7.0.1
 */