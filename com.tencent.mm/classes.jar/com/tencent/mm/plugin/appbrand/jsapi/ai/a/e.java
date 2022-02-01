package com.tencent.mm.plugin.appbrand.jsapi.ai.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai.c;

public final class e
  extends b
{
  private a sKk = a.sKm;
  
  public final c cxx()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137908);
        int i = j;
        c localc;
        switch (1.sKl[this.sKk.ordinal()])
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
          localc = super.cxx();
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
      sKm = new a("IDLE", 0);
      sKn = new a("START", 1);
      sKo = new a("PAUSE", 2);
      sKp = new a("STOP", 3);
      sKq = new a("ERROR", 4);
      sKr = new a[] { sKm, sKn, sKo, sKp, sKq };
      AppMethodBeat.o(137907);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.a.e
 * JD-Core Version:    0.7.0.1
 */