package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dfu;

public final class c
{
  public int position;
  public dfu qTx;
  
  final boolean CZ(int paramInt)
  {
    AppMethodBeat.i(210364);
    int j = this.qTx.yYM + this.qTx.sFm;
    int i = j;
    if (paramInt != 0)
    {
      i = j;
      if (this.qTx.y == 0)
      {
        i = j;
        if (this.position == 0) {
          i = 0;
        }
      }
    }
    paramInt = this.qTx.ltB - this.qTx.Hug;
    j = Math.max(this.qTx.y, i);
    int k = this.qTx.y + this.qTx.height;
    int m = Math.min(k, paramInt);
    if (this.qTx.y >= paramInt)
    {
      AppMethodBeat.o(210364);
      return false;
    }
    if (k <= i)
    {
      AppMethodBeat.o(210364);
      return false;
    }
    if ((this.qTx.y >= i) && (k <= paramInt))
    {
      AppMethodBeat.o(210364);
      return true;
    }
    j = m - j;
    if (j / this.qTx.height >= 0.9F)
    {
      AppMethodBeat.o(210364);
      return true;
    }
    if (j / (paramInt - i) >= 0.5F)
    {
      AppMethodBeat.o(210364);
      return true;
    }
    AppMethodBeat.o(210364);
    return false;
  }
  
  public final String toString()
  {
    if (this.qTx.feedId == null) {
      return "NULL";
    }
    return this.qTx.feedId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.c
 * JD-Core Version:    0.7.0.1
 */