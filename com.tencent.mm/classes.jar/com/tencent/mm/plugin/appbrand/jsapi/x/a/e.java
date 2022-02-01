package com.tencent.mm.plugin.appbrand.jsapi.x.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.x.c;

public final class e
  extends b
{
  private a kXu = a.kXw;
  
  private void a(a parama)
  {
    try
    {
      this.kXu = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  protected final void N(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137910);
    super.N(paramString, paramInt1, paramInt2);
    a(a.kXz);
    AppMethodBeat.o(137910);
  }
  
  public final c bll()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137908);
        int i = j;
        c localc;
        switch (1.kXv[this.kXu.ordinal()])
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
          localc = super.bll();
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
      a(a.kXw);
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
      kXw = new a("IDLE", 0);
      kXx = new a("START", 1);
      kXy = new a("PAUSE", 2);
      kXz = new a("STOP", 3);
      kXA = new a("ERROR", 4);
      kXB = new a[] { kXw, kXx, kXy, kXz, kXA };
      AppMethodBeat.o(137907);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.a.e
 * JD-Core Version:    0.7.0.1
 */