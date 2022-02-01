package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum Justify
{
  static
  {
    AppMethodBeat.i(135774);
    FLEXSTART = new Justify("FLEXSTART", 0);
    CENTER = new Justify("CENTER", 1);
    FLEXEND = new Justify("FLEXEND", 2);
    SPACEBETWEEN = new Justify("SPACEBETWEEN", 3);
    SPACEAROUND = new Justify("SPACEAROUND", 4);
    $VALUES = new Justify[] { FLEXSTART, CENTER, FLEXEND, SPACEBETWEEN, SPACEAROUND };
    AppMethodBeat.o(135774);
  }
  
  private Justify() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.Justify
 * JD-Core Version:    0.7.0.1
 */