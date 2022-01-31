package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class s$b
  implements Runnable
{
  final double bpS;
  final double bpT;
  final double bpU;
  final double bpV;
  final double bpW;
  final double bpX;
  final double lat;
  final double lng;
  
  private s$b(s params, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8)
  {
    this.lat = paramDouble1;
    this.lng = paramDouble2;
    this.bpS = paramDouble3;
    this.bpT = paramDouble4;
    this.bpU = paramDouble5;
    this.bpV = paramDouble6;
    this.bpW = paramDouble7;
    this.bpX = paramDouble8;
  }
  
  public final void run()
  {
    AppMethodBeat.i(55655);
    this.bpR.a(this.lat, this.lng, this.bpS, this.bpT, this.bpU, this.bpV, this.bpW, this.bpX);
    AppMethodBeat.o(55655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.b.a.a.s.b
 * JD-Core Version:    0.7.0.1
 */