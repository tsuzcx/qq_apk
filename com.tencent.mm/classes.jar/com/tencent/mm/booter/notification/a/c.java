package com.tencent.mm.booter.notification.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.bx.a;
import com.tencent.mm.n.g;

public final class c
{
  public int iSE = -1;
  
  public final int X(String paramString, int paramInt)
  {
    AppMethodBeat.i(20042);
    this.iSE = a.fkG();
    if ((!g.rc(paramInt)) || (g.Lf(paramString))) {}
    try
    {
      this.iSE = R.g.dpx;
      for (;;)
      {
        label34:
        if (this.iSE < 0) {
          this.iSE = a.fkG();
        }
        paramInt = this.iSE;
        AppMethodBeat.o(20042);
        return paramInt;
        if (g.Lg(paramString)) {
          try
          {
            this.iSE = R.g.dpx;
          }
          catch (Exception paramString) {}
        }
      }
    }
    catch (Exception paramString)
    {
      break label34;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.c
 * JD-Core Version:    0.7.0.1
 */