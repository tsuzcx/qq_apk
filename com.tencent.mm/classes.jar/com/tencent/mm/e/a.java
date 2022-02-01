package com.tencent.mm.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  public int value;
  
  static
  {
    AppMethodBeat.i(9117);
    dbe = new a("DEFAULT", 0, 0);
    dbf = new a("DOODLE", 1, 3);
    dbg = new a("MOSAIC", 2, 2);
    dbh = new a("EMOJI_AND_TEXT", 3, 4);
    dbi = new a("CROP_PHOTO", 4, 2147483647);
    dbj = new a("CROP_VIDEO", 5, 2147483647);
    dbk = new a("FILTER", 6, 1);
    dbl = new a[] { dbe, dbf, dbg, dbh, dbi, dbj, dbk };
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