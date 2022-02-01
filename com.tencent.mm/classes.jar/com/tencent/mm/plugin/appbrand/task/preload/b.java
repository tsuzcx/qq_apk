package com.tencent.mm.plugin.appbrand.task.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  static
  {
    AppMethodBeat.i(48505);
    myT = new b("LOW_LEVEL", 0);
    myU = new b("MIDDLE_LEVEL", 1);
    myV = new b("HIGH_LEVEL", 2);
    myW = new b[] { myT, myU, myV };
    AppMethodBeat.o(48505);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.b
 * JD-Core Version:    0.7.0.1
 */