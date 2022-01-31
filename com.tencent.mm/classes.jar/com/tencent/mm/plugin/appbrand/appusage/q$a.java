package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum q$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(129604);
    hbL = new a("FORCE_OFF", 0, 0);
    hbM = new a("FORCE_ON", 1, 1);
    hbN = new a("DYNAMIC_THRESHOLD", 2, 2);
    hbO = new a[] { hbL, hbM, hbN };
    AppMethodBeat.o(129604);
  }
  
  private q$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.q.a
 * JD-Core Version:    0.7.0.1
 */