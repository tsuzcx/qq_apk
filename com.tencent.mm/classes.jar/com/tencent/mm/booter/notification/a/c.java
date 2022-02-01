package com.tencent.mm.booter.notification.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.m.f;

public final class c
{
  public int foU = -1;
  
  public final int B(String paramString, int paramInt)
  {
    AppMethodBeat.i(20042);
    this.foU = a.dlN();
    if ((!f.lf(paramInt)) || (f.sM(paramString))) {}
    try
    {
      this.foU = 2131234582;
      for (;;)
      {
        label33:
        if (this.foU < 0) {
          this.foU = a.dlN();
        }
        paramInt = this.foU;
        AppMethodBeat.o(20042);
        return paramInt;
        if (f.sN(paramString)) {
          try
          {
            this.foU = 2131234582;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.c
 * JD-Core Version:    0.7.0.1
 */