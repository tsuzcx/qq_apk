package com.tencent.mm.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  public int value;
  
  static
  {
    AppMethodBeat.i(9117);
    fkw = new a("DEFAULT", 0, 0);
    fkx = new a("DOODLE", 1, 3);
    fky = new a("MOSAIC", 2, 2);
    fkz = new a("EMOJI_AND_TEXT", 3, 4);
    fkA = new a("CROP_PHOTO", 4, 2147483647);
    fkB = new a("CROP_VIDEO", 5, 2147483647);
    fkC = new a("FILTER", 6, 1);
    fkD = new a[] { fkw, fkx, fky, fkz, fkA, fkB, fkC };
    AppMethodBeat.o(9117);
  }
  
  private a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.e.a
 * JD-Core Version:    0.7.0.1
 */