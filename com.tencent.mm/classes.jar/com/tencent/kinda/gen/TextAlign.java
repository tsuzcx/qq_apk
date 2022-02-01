package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum TextAlign
{
  static
  {
    AppMethodBeat.i(135992);
    LEFT = new TextAlign("LEFT", 0);
    CENTER = new TextAlign("CENTER", 1);
    RIGHT = new TextAlign("RIGHT", 2);
    $VALUES = new TextAlign[] { LEFT, CENTER, RIGHT };
    AppMethodBeat.o(135992);
  }
  
  private TextAlign() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.TextAlign
 * JD-Core Version:    0.7.0.1
 */