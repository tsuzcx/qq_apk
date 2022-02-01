package com.tencent.mm.plugin.appbrand.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  static
  {
    AppMethodBeat.i(140585);
    iQK = new b("FOREGROUND", 0);
    iQL = new b("BACKGROUND", 1);
    iQM = new b("SUSPEND", 2);
    iQN = new b("DESTROYED", 3);
    iQO = new b[] { iQK, iQL, iQM, iQN };
    AppMethodBeat.o(140585);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.b
 * JD-Core Version:    0.7.0.1
 */