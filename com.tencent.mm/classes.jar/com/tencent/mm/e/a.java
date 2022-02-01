package com.tencent.mm.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  public int value;
  
  static
  {
    AppMethodBeat.i(9117);
    hoJ = new a("DEFAULT", 0, 0);
    hoK = new a("DOODLE", 1, 3);
    hoL = new a("MOSAIC", 2, 2);
    hoM = new a("EMOJI_AND_TEXT", 3, 4);
    hoN = new a("CROP_PHOTO", 4, 2147483647);
    hoO = new a("CROP_VIDEO", 5, 2147483647);
    hoP = new a("FILTER", 6, 1);
    hoQ = new a[] { hoJ, hoK, hoL, hoM, hoN, hoO, hoP };
    AppMethodBeat.o(9117);
  }
  
  private a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.e.a
 * JD-Core Version:    0.7.0.1
 */