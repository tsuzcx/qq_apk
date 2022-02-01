package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum Align
{
  static
  {
    AppMethodBeat.i(135634);
    AUTO = new Align("AUTO", 0);
    FLEXSTART = new Align("FLEXSTART", 1);
    CENTER = new Align("CENTER", 2);
    FLEXEND = new Align("FLEXEND", 3);
    STRETCH = new Align("STRETCH", 4);
    BASELINE = new Align("BASELINE", 5);
    SPACEBETWEEN = new Align("SPACEBETWEEN", 6);
    SPACEAROUND = new Align("SPACEAROUND", 7);
    $VALUES = new Align[] { AUTO, FLEXSTART, CENTER, FLEXEND, STRETCH, BASELINE, SPACEBETWEEN, SPACEAROUND };
    AppMethodBeat.o(135634);
  }
  
  private Align() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.gen.Align
 * JD-Core Version:    0.7.0.1
 */