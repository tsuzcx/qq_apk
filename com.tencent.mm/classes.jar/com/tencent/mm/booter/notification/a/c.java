package com.tencent.mm.booter.notification.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.a;
import com.tencent.mm.m.f;

public final class c
{
  public int ebo = -1;
  
  public final int B(String paramString, int paramInt)
  {
    AppMethodBeat.i(16010);
    this.ebo = a.bYt();
    if ((!f.iX(paramInt)) || (f.lw(paramString))) {}
    try
    {
      this.ebo = 2130840765;
      for (;;)
      {
        label33:
        if (this.ebo < 0) {
          this.ebo = a.bYt();
        }
        paramInt = this.ebo;
        AppMethodBeat.o(16010);
        return paramInt;
        if (f.lx(paramString)) {
          try
          {
            this.ebo = 2130840765;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.c
 * JD-Core Version:    0.7.0.1
 */