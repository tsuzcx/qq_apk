package com.tencent.map.tools.json;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum FieldNameStyle
{
  static
  {
    AppMethodBeat.i(180911);
    HUMP = new FieldNameStyle("HUMP", 0);
    UNDERLINE = new FieldNameStyle("UNDERLINE", 1);
    $VALUES = new FieldNameStyle[] { HUMP, UNDERLINE };
    AppMethodBeat.o(180911);
  }
  
  private FieldNameStyle() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.map.tools.json.FieldNameStyle
 * JD-Core Version:    0.7.0.1
 */