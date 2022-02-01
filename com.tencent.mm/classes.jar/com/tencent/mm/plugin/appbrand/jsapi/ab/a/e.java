package com.tencent.mm.plugin.appbrand.jsapi.ab.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab.c;

public final class e
  extends b
{
  private a lyS = a.lyU;
  
  private void a(a parama)
  {
    try
    {
      this.lyS = parama;
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
    a(a.lyX);
    AppMethodBeat.o(137910);
  }
  
  public final c bpG()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137908);
        int i = j;
        c localc;
        switch (1.lyT[this.lyS.ordinal()])
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
          localc = super.bpG();
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
      a(a.lyU);
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
      lyU = new a("IDLE", 0);
      lyV = new a("START", 1);
      lyW = new a("PAUSE", 2);
      lyX = new a("STOP", 3);
      lyY = new a("ERROR", 4);
      lyZ = new a[] { lyU, lyV, lyW, lyX, lyY };
      AppMethodBeat.o(137907);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.a.e
 * JD-Core Version:    0.7.0.1
 */