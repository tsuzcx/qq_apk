package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum LoadingImageStyle
{
  static
  {
    AppMethodBeat.i(135956);
    WHITELARGE = new LoadingImageStyle("WHITELARGE", 0);
    WHITE = new LoadingImageStyle("WHITE", 1);
    GRAY = new LoadingImageStyle("GRAY", 2);
    $VALUES = new LoadingImageStyle[] { WHITELARGE, WHITE, GRAY };
    AppMethodBeat.o(135956);
  }
  
  private LoadingImageStyle() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.gen.LoadingImageStyle
 * JD-Core Version:    0.7.0.1
 */