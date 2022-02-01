package com.tencent.mm.plugin.appbrand.jsapi.af.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.af.c;

public final class e
  extends b
{
  private a pEZ = a.pFb;
  
  public final c bXl()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137908);
        int i = j;
        c localc;
        switch (1.pFa[this.pEZ.ordinal()])
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
          localc = super.bXl();
          AppMethodBeat.o(137908);
          break;
        }
        i = j;
      }
      finally {}
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(137907);
      pFb = new a("IDLE", 0);
      pFc = new a("START", 1);
      pFd = new a("PAUSE", 2);
      pFe = new a("STOP", 3);
      pFf = new a("ERROR", 4);
      pFg = new a[] { pFb, pFc, pFd, pFe, pFf };
      AppMethodBeat.o(137907);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.a.e
 * JD-Core Version:    0.7.0.1
 */