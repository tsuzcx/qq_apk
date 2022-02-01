package com.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class s$b
  implements Runnable
{
  final double bSn;
  final double bSo;
  final double bSp;
  final double bSq;
  final double bSr;
  final double bSs;
  final double lat;
  final double lng;
  
  private s$b(s params, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8)
  {
    this.lat = paramDouble1;
    this.lng = paramDouble2;
    this.bSn = paramDouble3;
    this.bSo = paramDouble4;
    this.bSp = paramDouble5;
    this.bSq = paramDouble6;
    this.bSr = paramDouble7;
    this.bSs = paramDouble8;
  }
  
  public final void run()
  {
    AppMethodBeat.i(88000);
    this.bSm.a(this.lat, this.lng, this.bSn, this.bSo, this.bSp, this.bSq, this.bSr, this.bSs);
    AppMethodBeat.o(88000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.c.a.a.s.b
 * JD-Core Version:    0.7.0.1
 */