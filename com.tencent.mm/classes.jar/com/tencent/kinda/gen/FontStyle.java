package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum FontStyle
{
  static
  {
    AppMethodBeat.i(141180);
    LIGHT = new FontStyle("LIGHT", 0);
    MEDIUM = new FontStyle("MEDIUM", 1);
    REGULAR = new FontStyle("REGULAR", 2);
    BOLD = new FontStyle("BOLD", 3);
    $VALUES = new FontStyle[] { LIGHT, MEDIUM, REGULAR, BOLD };
    AppMethodBeat.o(141180);
  }
  
  private FontStyle() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.gen.FontStyle
 * JD-Core Version:    0.7.0.1
 */