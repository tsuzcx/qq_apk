package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g
{
  static
  {
    AppMethodBeat.i(149427);
    cRC = new g("DEFAULT", 0);
    cRD = new g("DOODLE", 1);
    cRE = new g("TEXT", 2);
    cRF = new g("EMOJI", 3);
    cRG = new g("MOSAIC", 4);
    cRH = new g("CROP_PHOTO", 5);
    cRI = new g("CROP_VIDEO", 6);
    cRJ = new g("FILTER", 7);
    cRK = new g[] { cRC, cRD, cRE, cRF, cRG, cRH, cRI, cRJ };
    AppMethodBeat.o(149427);
  }
  
  private g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.api.g
 * JD-Core Version:    0.7.0.1
 */