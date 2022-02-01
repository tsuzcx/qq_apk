package com.tencent.mm.plugin.appbrand.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  static
  {
    AppMethodBeat.i(140585);
    qKw = new b("FOREGROUND", 0);
    qKx = new b("BACKGROUND", 1);
    qKy = new b("SUSPEND", 2);
    qKz = new b("DESTROYED", 3);
    qKA = new b[] { qKw, qKx, qKy, qKz };
    AppMethodBeat.o(140585);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.b
 * JD-Core Version:    0.7.0.1
 */