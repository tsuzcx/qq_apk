package com.tencent.mm.booter.notification.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.a;
import com.tencent.mm.n.f;

public final class c
{
  public int fHc = -1;
  
  public final int D(String paramString, int paramInt)
  {
    AppMethodBeat.i(20042);
    this.fHc = a.dwe();
    if ((!f.lE(paramInt)) || (f.vB(paramString))) {}
    try
    {
      this.fHc = 2131234582;
      for (;;)
      {
        label33:
        if (this.fHc < 0) {
          this.fHc = a.dwe();
        }
        paramInt = this.fHc;
        AppMethodBeat.o(20042);
        return paramInt;
        if (f.vC(paramString)) {
          try
          {
            this.fHc = 2131234582;
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