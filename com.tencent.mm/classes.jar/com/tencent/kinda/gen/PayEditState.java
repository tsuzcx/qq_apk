package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum PayEditState
{
  static
  {
    AppMethodBeat.i(135964);
    DEFAULT = new PayEditState("DEFAULT", 0);
    PASSWORD = new PayEditState("PASSWORD", 1);
    $VALUES = new PayEditState[] { DEFAULT, PASSWORD };
    AppMethodBeat.o(135964);
  }
  
  private PayEditState() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.PayEditState
 * JD-Core Version:    0.7.0.1
 */