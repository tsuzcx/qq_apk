package com.tencent.mm.plugin.appbrand.jsapi.y.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.y.c;

public final class e
  extends b
{
  private a kwg = a.kwi;
  
  private void a(a parama)
  {
    try
    {
      this.kwg = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  protected final void O(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137910);
    super.O(paramString, paramInt1, paramInt2);
    a(a.kwl);
    AppMethodBeat.o(137910);
  }
  
  public final c ber()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137908);
        int i = j;
        c localc;
        switch (1.kwh[this.kwg.ordinal()])
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
          localc = super.ber();
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
      a(a.kwi);
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
      kwi = new a("IDLE", 0);
      kwj = new a("START", 1);
      kwk = new a("PAUSE", 2);
      kwl = new a("STOP", 3);
      kwm = new a("ERROR", 4);
      kwn = new a[] { kwi, kwj, kwk, kwl, kwm };
      AppMethodBeat.o(137907);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.a.e
 * JD-Core Version:    0.7.0.1
 */