package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dgo;

public final class c
{
  public int position;
  public dgo rbv;
  
  final boolean Dm(int paramInt)
  {
    AppMethodBeat.i(196024);
    int j = this.rbv.zpn + this.rbv.sQl;
    int i = j;
    if (paramInt != 0)
    {
      i = j;
      if (this.rbv.y == 0)
      {
        i = j;
        if (this.position == 0) {
          i = 0;
        }
      }
    }
    paramInt = this.rbv.lya - this.rbv.HNJ;
    j = Math.max(this.rbv.y, i);
    int k = this.rbv.y + this.rbv.height;
    int m = Math.min(k, paramInt);
    if (this.rbv.y >= paramInt)
    {
      AppMethodBeat.o(196024);
      return false;
    }
    if (k <= i)
    {
      AppMethodBeat.o(196024);
      return false;
    }
    if ((this.rbv.y >= i) && (k <= paramInt))
    {
      AppMethodBeat.o(196024);
      return true;
    }
    j = m - j;
    if (j / this.rbv.height >= 0.9F)
    {
      AppMethodBeat.o(196024);
      return true;
    }
    if (j / (paramInt - i) >= 0.5F)
    {
      AppMethodBeat.o(196024);
      return true;
    }
    AppMethodBeat.o(196024);
    return false;
  }
  
  public final String toString()
  {
    if (this.rbv.feedId == null) {
      return "NULL";
    }
    return this.rbv.feedId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.c
 * JD-Core Version:    0.7.0.1
 */