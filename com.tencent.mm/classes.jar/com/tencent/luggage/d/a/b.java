package com.tencent.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  static
  {
    AppMethodBeat.i(140465);
    caP = new b("PENDING", 0);
    caQ = new b("PASS", 1);
    caR = new b("REJECT", 2);
    caS = new b[] { caP, caQ, caR };
    AppMethodBeat.o(140465);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.a.b
 * JD-Core Version:    0.7.0.1
 */