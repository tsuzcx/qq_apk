package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum Language
{
  static
  {
    AppMethodBeat.i(101190);
    zh = new Language("zh", 0);
    en = new Language("en", 1);
    $VALUES = new Language[] { zh, en };
    AppMethodBeat.o(101190);
  }
  
  private Language() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.Language
 * JD-Core Version:    0.7.0.1
 */