package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum m$d
{
  private int value = 0;
  
  static
  {
    AppMethodBeat.i(102696);
    mtQ = new d("Samll", 0, 1);
    mtR = new d("Full", 1, 2);
    mtS = new d("Complete", 2, 3);
    mtT = new d[] { mtQ, mtR, mtS };
    AppMethodBeat.o(102696);
  }
  
  private m$d(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.m.d
 * JD-Core Version:    0.7.0.1
 */