package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g
{
  static
  {
    AppMethodBeat.i(149427);
    cSm = new g("DEFAULT", 0);
    cSn = new g("DOODLE", 1);
    cSo = new g("TEXT", 2);
    cSp = new g("EMOJI", 3);
    cSq = new g("MOSAIC", 4);
    cSr = new g("CROP_PHOTO", 5);
    cSs = new g("CROP_VIDEO", 6);
    cSt = new g("FILTER", 7);
    cSu = new g[] { cSm, cSn, cSo, cSp, cSq, cSr, cSs, cSt };
    AppMethodBeat.o(149427);
  }
  
  private g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.api.g
 * JD-Core Version:    0.7.0.1
 */