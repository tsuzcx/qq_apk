package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AndroidDpiLevel
{
  static
  {
    AppMethodBeat.i(141148);
    LDPI = new AndroidDpiLevel("LDPI", 0);
    MDPI = new AndroidDpiLevel("MDPI", 1);
    HDPI = new AndroidDpiLevel("HDPI", 2);
    XXHDPI = new AndroidDpiLevel("XXHDPI", 3);
    XXXHDPI = new AndroidDpiLevel("XXXHDPI", 4);
    UNKNOWN = new AndroidDpiLevel("UNKNOWN", 5);
    $VALUES = new AndroidDpiLevel[] { LDPI, MDPI, HDPI, XXHDPI, XXXHDPI, UNKNOWN };
    AppMethodBeat.o(141148);
  }
  
  private AndroidDpiLevel() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.AndroidDpiLevel
 * JD-Core Version:    0.7.0.1
 */