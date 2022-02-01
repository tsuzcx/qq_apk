package com.tencent.mm.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  public int value;
  
  static
  {
    AppMethodBeat.i(9117);
    cRr = new a("DEFAULT", 0, 0);
    cRs = new a("DOODLE", 1, 3);
    cRt = new a("MOSAIC", 2, 2);
    cRu = new a("EMOJI_AND_TEXT", 3, 4);
    cRv = new a("CROP_PHOTO", 4, 2147483647);
    cRw = new a("CROP_VIDEO", 5, 2147483647);
    cRx = new a("FILTER", 6, 1);
    cRy = new a[] { cRr, cRs, cRt, cRu, cRv, cRw, cRx };
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