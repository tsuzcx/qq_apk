package com.tencent.mm.plugin.appbrand.jsapi.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad.c;

public final class e
  extends b
{
  private a mFU = a.mFW;
  
  private void a(a parama)
  {
    try
    {
      this.mFU = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  protected final void S(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137910);
    super.S(paramString, paramInt1, paramInt2);
    a(a.mFZ);
    AppMethodBeat.o(137910);
  }
  
  public final c bLl()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137908);
        int i = j;
        c localc;
        switch (1.mFV[this.mFU.ordinal()])
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
          localc = super.bLl();
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
      a(a.mFW);
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
      mFW = new a("IDLE", 0);
      mFX = new a("START", 1);
      mFY = new a("PAUSE", 2);
      mFZ = new a("STOP", 3);
      mGa = new a("ERROR", 4);
      mGb = new a[] { mFW, mFX, mFY, mFZ, mGa };
      AppMethodBeat.o(137907);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.a.e
 * JD-Core Version:    0.7.0.1
 */