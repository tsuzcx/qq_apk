package com.tencent.mm.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  public int value;
  
  static
  {
    AppMethodBeat.i(9117);
    cOM = new a("DEFAULT", 0, 0);
    cON = new a("DOODLE", 1, 3);
    cOO = new a("MOSAIC", 2, 2);
    cOP = new a("EMOJI_AND_TEXT", 3, 4);
    cOQ = new a("CROP_PHOTO", 4, 2147483647);
    cOR = new a("CROP_VIDEO", 5, 2147483647);
    cOS = new a("FILTER", 6, 1);
    cOT = new a[] { cOM, cON, cOO, cOP, cOQ, cOR, cOS };
    AppMethodBeat.o(9117);
  }
  
  private a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.e.a
 * JD-Core Version:    0.7.0.1
 */