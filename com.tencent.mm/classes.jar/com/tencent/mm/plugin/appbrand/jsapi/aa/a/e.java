package com.tencent.mm.plugin.appbrand.jsapi.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aa.c;

public final class e
  extends b
{
  private a lut = a.luv;
  
  private void a(a parama)
  {
    try
    {
      this.lut = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  protected final void P(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137910);
    super.P(paramString, paramInt1, paramInt2);
    a(a.luz);
    AppMethodBeat.o(137910);
  }
  
  public final c boW()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137908);
        int i = j;
        c localc;
        switch (1.luu[this.lut.ordinal()])
        {
        case 1: 
          if (i == 0)
          {
            localc = new c("can not stop", new Object[0]);
            AppMethodBeat.o(137908);
            return localc;
          }
        case 2: 
        case 3: 
          i = 1;
          continue;
          localc = super.boW();
          AppMethodBeat.o(137908);
          break;
        }
        i = j;
      }
      finally {}
    }
  }
  
  protected final void release()
  {
    try
    {
      AppMethodBeat.i(137909);
      super.release();
      a(a.luv);
      AppMethodBeat.o(137909);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(137907);
      luv = new a("IDLE", 0);
      luw = new a("START", 1);
      luy = new a("PAUSE", 2);
      luz = new a("STOP", 3);
      luA = new a("ERROR", 4);
      luB = new a[] { luv, luw, luy, luz, luA };
      AppMethodBeat.o(137907);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.a.e
 * JD-Core Version:    0.7.0.1
 */