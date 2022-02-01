package com.tencent.mm.booter.notification.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.n.g;

public final class c
{
  public int gov = -1;
  
  public final int F(String paramString, int paramInt)
  {
    AppMethodBeat.i(20042);
    this.gov = a.ezb();
    if ((!g.oJ(paramInt)) || (g.Em(paramString))) {}
    try
    {
      this.gov = 2131235544;
      for (;;)
      {
        label33:
        if (this.gov < 0) {
          this.gov = a.ezb();
        }
        paramInt = this.gov;
        AppMethodBeat.o(20042);
        return paramInt;
        if (g.En(paramString)) {
          try
          {
            this.gov = 2131235544;
          }
          catch (Exception paramString) {}
        }
      }
    }
    catch (Exception paramString)
    {
      break label33;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.c
 * JD-Core Version:    0.7.0.1
 */