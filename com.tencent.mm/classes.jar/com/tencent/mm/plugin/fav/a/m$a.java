package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum m$a
{
  private int value = 0;
  
  static
  {
    AppMethodBeat.i(102687);
    mty = new a("PlayIcon", 0, 1);
    mtz = new a("EnterFullScreen", 1, 2);
    mtA = new a("EnterCompleteVideo", 2, 3);
    mtB = new a("DetailInVideo", 3, 4);
    mtC = new a("LeavelFullScreen", 4, 5);
    mtD = new a("LeaveCompleteVideo", 5, 6);
    mtE = new a("SightLoaded", 6, 7);
    mtF = new a[] { mty, mtz, mtA, mtB, mtC, mtD, mtE };
    AppMethodBeat.o(102687);
  }
  
  private m$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.m.a
 * JD-Core Version:    0.7.0.1
 */