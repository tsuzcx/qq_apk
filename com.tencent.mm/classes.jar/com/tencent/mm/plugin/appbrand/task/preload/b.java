package com.tencent.mm.plugin.appbrand.task.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  static
  {
    AppMethodBeat.i(48505);
    mDU = new b("LOW_LEVEL", 0);
    mDV = new b("MIDDLE_LEVEL", 1);
    mDW = new b("HIGH_LEVEL", 2);
    mDX = new b[] { mDU, mDV, mDW };
    AppMethodBeat.o(48505);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.b
 * JD-Core Version:    0.7.0.1
 */