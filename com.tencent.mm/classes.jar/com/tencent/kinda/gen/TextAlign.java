package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum TextAlign
{
  static
  {
    AppMethodBeat.i(141472);
    LEFT = new TextAlign("LEFT", 0);
    CENTER = new TextAlign("CENTER", 1);
    RIGHT = new TextAlign("RIGHT", 2);
    $VALUES = new TextAlign[] { LEFT, CENTER, RIGHT };
    AppMethodBeat.o(141472);
  }
  
  private TextAlign() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.TextAlign
 * JD-Core Version:    0.7.0.1
 */