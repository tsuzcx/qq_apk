package com.tencent.mm.plugin.appbrand.task.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  static
  {
    AppMethodBeat.i(48505);
    qSw = new c("LOW_LEVEL", 0);
    qSx = new c("MIDDLE_LEVEL", 1);
    qSy = new c("HIGH_LEVEL", 2);
    qSz = new c[] { qSw, qSx, qSy };
    AppMethodBeat.o(48505);
  }
  
  private c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.c
 * JD-Core Version:    0.7.0.1
 */