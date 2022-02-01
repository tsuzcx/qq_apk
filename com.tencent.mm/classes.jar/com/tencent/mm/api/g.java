package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g
{
  static
  {
    AppMethodBeat.i(149427);
    cGy = new g("DEFAULT", 0);
    cGz = new g("DOODLE", 1);
    cGA = new g("TEXT", 2);
    cGB = new g("EMOJI", 3);
    cGC = new g("MOSAIC", 4);
    cGD = new g("CROP_PHOTO", 5);
    cGE = new g("CROP_VIDEO", 6);
    cGF = new g("FILTER", 7);
    cGG = new g[] { cGy, cGz, cGA, cGB, cGC, cGD, cGE, cGF };
    AppMethodBeat.o(149427);
  }
  
  private g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.api.g
 * JD-Core Version:    0.7.0.1
 */