package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum no$b
{
  final int value;
  
  static
  {
    AppMethodBeat.i(2592);
    fhM = new b("SHAREAPPMSG", 0, 1);
    fhN = new b("CLICKAPPMSG", 1, 2);
    fhO = new b("CLICKSUBSCRIBETV", 2, 3);
    fhP = new b("CLICKSTARTGAME", 3, 4);
    fhQ = new b[] { fhM, fhN, fhO, fhP };
    AppMethodBeat.o(2592);
  }
  
  private no$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.no.b
 * JD-Core Version:    0.7.0.1
 */