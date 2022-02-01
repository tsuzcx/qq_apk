package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum PositionType
{
  static
  {
    AppMethodBeat.i(135970);
    RELATIVE = new PositionType("RELATIVE", 0);
    ABSOLUTE = new PositionType("ABSOLUTE", 1);
    $VALUES = new PositionType[] { RELATIVE, ABSOLUTE };
    AppMethodBeat.o(135970);
  }
  
  private PositionType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.gen.PositionType
 * JD-Core Version:    0.7.0.1
 */