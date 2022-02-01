package com.google.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  static
  {
    AppMethodBeat.i(222287);
    bOI = new b("BEGIN_ARRAY", 0);
    bOJ = new b("END_ARRAY", 1);
    bOK = new b("BEGIN_OBJECT", 2);
    bOL = new b("END_OBJECT", 3);
    bOM = new b("NAME", 4);
    bON = new b("STRING", 5);
    bOO = new b("NUMBER", 6);
    bOP = new b("BOOLEAN", 7);
    bOQ = new b("NULL", 8);
    bOR = new b("END_DOCUMENT", 9);
    bOS = new b[] { bOI, bOJ, bOK, bOL, bOM, bON, bOO, bOP, bOQ, bOR };
    AppMethodBeat.o(222287);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.d.b
 * JD-Core Version:    0.7.0.1
 */