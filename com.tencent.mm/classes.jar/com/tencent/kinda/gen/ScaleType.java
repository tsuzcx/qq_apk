package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ScaleType
{
  static
  {
    AppMethodBeat.i(141454);
    FILL = new ScaleType("FILL", 0);
    ASPECTFIT = new ScaleType("ASPECTFIT", 1);
    ASPECTFILL = new ScaleType("ASPECTFILL", 2);
    CENTER = new ScaleType("CENTER", 3);
    $VALUES = new ScaleType[] { FILL, ASPECTFIT, ASPECTFILL, CENTER };
    AppMethodBeat.o(141454);
  }
  
  private ScaleType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.ScaleType
 * JD-Core Version:    0.7.0.1
 */