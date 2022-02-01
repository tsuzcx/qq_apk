package com.tencent.mm.booter.notification.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.a;
import com.tencent.mm.m.f;

public final class c
{
  public int flA = -1;
  
  public final int B(String paramString, int paramInt)
  {
    AppMethodBeat.i(20042);
    this.flA = a.cYf();
    if ((!f.ll(paramInt)) || (f.pB(paramString))) {}
    try
    {
      this.flA = 2131234582;
      for (;;)
      {
        label33:
        if (this.flA < 0) {
          this.flA = a.cYf();
        }
        paramInt = this.flA;
        AppMethodBeat.o(20042);
        return paramInt;
        if (f.pC(paramString)) {
          try
          {
            this.flA = 2131234582;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.c
 * JD-Core Version:    0.7.0.1
 */