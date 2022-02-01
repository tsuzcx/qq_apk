package com.google.c.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  static
  {
    AppMethodBeat.i(208799);
    dIn = new b("BEGIN_ARRAY", 0);
    dIo = new b("END_ARRAY", 1);
    dIp = new b("BEGIN_OBJECT", 2);
    dIq = new b("END_OBJECT", 3);
    dIr = new b("NAME", 4);
    dIs = new b("STRING", 5);
    dIt = new b("NUMBER", 6);
    dIu = new b("BOOLEAN", 7);
    dIv = new b("NULL", 8);
    dIw = new b("END_DOCUMENT", 9);
    dIx = new b[] { dIn, dIo, dIp, dIq, dIr, dIs, dIt, dIu, dIv, dIw };
    AppMethodBeat.o(208799);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.d.b
 * JD-Core Version:    0.7.0.1
 */