package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum EditTextRestrictType
{
  static
  {
    AppMethodBeat.i(190322);
    NONE = new EditTextRestrictType("NONE", 0);
    MONEY = new EditTextRestrictType("MONEY", 1);
    $VALUES = new EditTextRestrictType[] { NONE, MONEY };
    AppMethodBeat.o(190322);
  }
  
  private EditTextRestrictType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.EditTextRestrictType
 * JD-Core Version:    0.7.0.1
 */