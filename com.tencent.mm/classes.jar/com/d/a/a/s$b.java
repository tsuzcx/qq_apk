package com.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class s$b
  implements Runnable
{
  final double cai;
  final double caj;
  final double cak;
  final double cal;
  final double cam;
  final double can;
  final double lat;
  final double lng;
  
  private s$b(s params, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8)
  {
    this.lat = paramDouble1;
    this.lng = paramDouble2;
    this.cai = paramDouble3;
    this.caj = paramDouble4;
    this.cak = paramDouble5;
    this.cal = paramDouble6;
    this.cam = paramDouble7;
    this.can = paramDouble8;
  }
  
  public final void run()
  {
    AppMethodBeat.i(88000);
    this.cah.a(this.lat, this.lng, this.cai, this.caj, this.cak, this.cal, this.cam, this.can);
    AppMethodBeat.o(88000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.d.a.a.s.b
 * JD-Core Version:    0.7.0.1
 */