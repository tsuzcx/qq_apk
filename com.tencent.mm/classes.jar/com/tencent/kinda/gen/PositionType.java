package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum PositionType
{
  static
  {
    AppMethodBeat.i(141451);
    RELATIVE = new PositionType("RELATIVE", 0);
    ABSOLUTE = new PositionType("ABSOLUTE", 1);
    $VALUES = new PositionType[] { RELATIVE, ABSOLUTE };
    AppMethodBeat.o(141451);
  }
  
  private PositionType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.PositionType
 * JD-Core Version:    0.7.0.1
 */