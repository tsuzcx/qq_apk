package com.tencent.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  static
  {
    AppMethodBeat.i(140465);
    bXM = new b("PENDING", 0);
    bXN = new b("PASS", 1);
    bXO = new b("REJECT", 2);
    bXP = new b[] { bXM, bXN, bXO };
    AppMethodBeat.o(140465);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.a.b
 * JD-Core Version:    0.7.0.1
 */