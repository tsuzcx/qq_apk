package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum LeftBarButtonType
{
  static
  {
    AppMethodBeat.i(141431);
    BACK = new LeftBarButtonType("BACK", 0);
    CANCEL = new LeftBarButtonType("CANCEL", 1);
    NONE = new LeftBarButtonType("NONE", 2);
    $VALUES = new LeftBarButtonType[] { BACK, CANCEL, NONE };
    AppMethodBeat.o(141431);
  }
  
  private LeftBarButtonType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.LeftBarButtonType
 * JD-Core Version:    0.7.0.1
 */