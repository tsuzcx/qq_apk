package com.tencent.mm.booter.notification.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.bq.a;
import com.tencent.mm.k.h;

public final class c
{
  public int luB = -1;
  
  public final int ag(String paramString, int paramInt)
  {
    AppMethodBeat.i(20042);
    this.luB = a.guX();
    if ((!h.rk(paramInt)) || (h.DM(paramString))) {}
    try
    {
      this.luB = R.g.fpM;
      for (;;)
      {
        label34:
        if (this.luB < 0) {
          this.luB = a.guX();
        }
        paramInt = this.luB;
        AppMethodBeat.o(20042);
        return paramInt;
        if (h.DN(paramString)) {
          try
          {
            this.luB = R.g.fpM;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.c
 * JD-Core Version:    0.7.0.1
 */