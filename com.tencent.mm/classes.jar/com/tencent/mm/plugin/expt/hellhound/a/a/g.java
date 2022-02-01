package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cuv;

public final class g
{
  public cuv KEO;
  public int position;
  
  final boolean agR(int paramInt)
  {
    AppMethodBeat.i(205384);
    int j = this.KEO.wxW + this.KEO.qPe;
    int i = j;
    if (paramInt != 0)
    {
      i = j;
      if (this.KEO.y == 0)
      {
        i = j;
        if (this.position == 0) {
          i = 0;
        }
      }
    }
    paramInt = this.KEO.kvo - this.KEO.Emz;
    j = Math.max(this.KEO.y, i);
    int k = this.KEO.y + this.KEO.height;
    int m = Math.min(k, paramInt);
    if (this.KEO.y >= paramInt)
    {
      AppMethodBeat.o(205384);
      return false;
    }
    if (k <= i)
    {
      AppMethodBeat.o(205384);
      return false;
    }
    if ((this.KEO.y >= i) && (k <= paramInt))
    {
      AppMethodBeat.o(205384);
      return true;
    }
    j = m - j;
    if (j / this.KEO.height >= 0.9F)
    {
      AppMethodBeat.o(205384);
      return true;
    }
    if (j / (paramInt - i) >= 0.5F)
    {
      AppMethodBeat.o(205384);
      return true;
    }
    AppMethodBeat.o(205384);
    return false;
  }
  
  public final String toString()
  {
    if (this.KEO.feedId == null) {
      return "NULL";
    }
    return this.KEO.feedId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.g
 * JD-Core Version:    0.7.0.1
 */