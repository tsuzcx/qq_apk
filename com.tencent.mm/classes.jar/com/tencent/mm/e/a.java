package com.tencent.mm.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  public int value;
  
  static
  {
    AppMethodBeat.i(9117);
    dac = new a("DEFAULT", 0, 0);
    dad = new a("DOODLE", 1, 3);
    dae = new a("MOSAIC", 2, 2);
    daf = new a("EMOJI_AND_TEXT", 3, 4);
    dag = new a("CROP_PHOTO", 4, 2147483647);
    dah = new a("CROP_VIDEO", 5, 2147483647);
    dai = new a("FILTER", 6, 1);
    daj = new a[] { dac, dad, dae, daf, dag, dah, dai };
    AppMethodBeat.o(9117);
  }
  
  private a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.e.a
 * JD-Core Version:    0.7.0.1
 */