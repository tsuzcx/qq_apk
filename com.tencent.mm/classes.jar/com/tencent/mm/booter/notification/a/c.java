package com.tencent.mm.booter.notification.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.n.f;

public final class c
{
  public int fJg = -1;
  
  public final int E(String paramString, int paramInt)
  {
    AppMethodBeat.i(20042);
    this.fJg = a.dzu();
    if ((!f.lG(paramInt)) || (f.vX(paramString))) {}
    try
    {
      this.fJg = 2131234582;
      for (;;)
      {
        label33:
        if (this.fJg < 0) {
          this.fJg = a.dzu();
        }
        paramInt = this.fJg;
        AppMethodBeat.o(20042);
        return paramInt;
        if (f.vY(paramString)) {
          try
          {
            this.fJg = 2131234582;
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