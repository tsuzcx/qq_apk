package com.tencent.mm.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  public int value;
  
  static
  {
    AppMethodBeat.i(116147);
    ccL = new a("DEFAULT", 0, 0);
    ccM = new a("DOODLE", 1, 2);
    ccN = new a("MOSAIC", 2, 1);
    ccO = new a("EMOJI_AND_TEXT", 3, 3);
    ccP = new a("CROP_PHOTO", 4, 2147483647);
    ccQ = new a("CROP_VIDEO", 5, 2147483647);
    ccR = new a[] { ccL, ccM, ccN, ccO, ccP, ccQ };
    AppMethodBeat.o(116147);
  }
  
  private a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.e.a
 * JD-Core Version:    0.7.0.1
 */