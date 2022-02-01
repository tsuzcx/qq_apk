package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dah;

public final class c
{
  public int position;
  public dah qkB;
  
  final boolean Cm(int paramInt)
  {
    AppMethodBeat.i(195217);
    int j = this.qkB.xJx + this.qkB.rKm;
    int i = j;
    if (paramInt != 0)
    {
      i = j;
      if (this.qkB.y == 0)
      {
        i = j;
        if (this.position == 0) {
          i = 0;
        }
      }
    }
    paramInt = this.qkB.kWC - this.qkB.FJy;
    j = Math.max(this.qkB.y, i);
    int k = this.qkB.y + this.qkB.height;
    int m = Math.min(k, paramInt);
    if (this.qkB.y >= paramInt)
    {
      AppMethodBeat.o(195217);
      return false;
    }
    if (k <= i)
    {
      AppMethodBeat.o(195217);
      return false;
    }
    if ((this.qkB.y >= i) && (k <= paramInt))
    {
      AppMethodBeat.o(195217);
      return true;
    }
    j = m - j;
    if (j / this.qkB.height >= 0.9F)
    {
      AppMethodBeat.o(195217);
      return true;
    }
    if (j / (paramInt - i) >= 0.5F)
    {
      AppMethodBeat.o(195217);
      return true;
    }
    AppMethodBeat.o(195217);
    return false;
  }
  
  public final String toString()
  {
    if (this.qkB.feedId == null) {
      return "NULL";
    }
    return this.qkB.feedId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.c
 * JD-Core Version:    0.7.0.1
 */