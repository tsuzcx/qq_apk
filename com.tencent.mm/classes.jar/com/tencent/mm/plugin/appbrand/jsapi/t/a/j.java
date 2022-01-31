package com.tencent.mm.plugin.appbrand.jsapi.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.t.g;

public final class j
  extends c
{
  private j.a ifX = j.a.ifZ;
  
  private void a(j.a parama)
  {
    try
    {
      this.ifX = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  protected final void R(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145977);
    super.R(paramString, paramInt1, paramInt2);
    a(j.a.igc);
    AppMethodBeat.o(145977);
  }
  
  public final g a(e.d paramd)
  {
    int i = 0;
    try
    {
      AppMethodBeat.i(145969);
      switch (j.1.ifY[this.ifX.ordinal()])
      {
      }
      for (;;)
      {
        if (i == 0)
        {
          paramd = new g("can not start", new Object[0]);
          AppMethodBeat.o(145969);
        }
        for (;;)
        {
          return paramd;
          i = 1;
          break;
          paramd = super.a(paramd);
          AppMethodBeat.o(145969);
        }
      }
    }
    finally {}
  }
  
  protected final void aGa()
  {
    AppMethodBeat.i(145974);
    super.aGa();
    a(j.a.iga);
    AppMethodBeat.o(145974);
  }
  
  protected final void aGb()
  {
    AppMethodBeat.i(145975);
    super.aGb();
    a(j.a.iga);
    AppMethodBeat.o(145975);
  }
  
  protected final void aGc()
  {
    AppMethodBeat.i(145976);
    super.aGc();
    a(j.a.igb);
    AppMethodBeat.o(145976);
  }
  
  public final g aGd()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(145970);
        int i = j;
        g localg;
        switch (j.1.ifY[this.ifX.ordinal()])
        {
        case 1: 
          if (i == 0)
          {
            localg = new g("can not pause", new Object[0]);
            AppMethodBeat.o(145970);
            return localg;
          }
        case 2: 
          i = 1;
          continue;
          localg = super.aGd();
          AppMethodBeat.o(145970);
          break;
        }
        i = j;
      }
      finally {}
    }
  }
  
  public final g aGf()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(145971);
        int i = j;
        g localg;
        switch (j.1.ifY[this.ifX.ordinal()])
        {
        case 1: 
        case 2: 
          if (i == 0)
          {
            localg = new g("can not resume", new Object[0]);
            AppMethodBeat.o(145971);
            return localg;
          }
        case 3: 
          i = 1;
          continue;
          localg = super.aGf();
          AppMethodBeat.o(145971);
          break;
        }
        i = j;
      }
      finally {}
    }
  }
  
  public final g aGg()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(145972);
        int i = j;
        g localg;
        switch (j.1.ifY[this.ifX.ordinal()])
        {
        case 1: 
          if (i == 0)
          {
            localg = new g("can not stop", new Object[0]);
            AppMethodBeat.o(145972);
            return localg;
          }
        case 2: 
        case 3: 
          i = 1;
          continue;
          localg = super.aGg();
          AppMethodBeat.o(145972);
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
      AppMethodBeat.i(145973);
      super.release();
      a(j.a.ifZ);
      AppMethodBeat.o(145973);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.j
 * JD-Core Version:    0.7.0.1
 */