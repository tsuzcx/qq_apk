package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum m$d
{
  private int value = 0;
  
  static
  {
    AppMethodBeat.i(103436);
    rtl = new d("Samll", 0, 1);
    rtm = new d("Full", 1, 2);
    rtn = new d("Complete", 2, 3);
    rto = new d[] { rtl, rtm, rtn };
    AppMethodBeat.o(103436);
  }
  
  private m$d(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.m.d
 * JD-Core Version:    0.7.0.1
 */