package com.tencent.luggage.sdk.f;

import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ar;

public abstract interface a
  extends b
{
  public abstract String Fr();
  
  public abstract void a(a.b paramb);
  
  public static final class a
  {
    private static final a cqk;
    
    static
    {
      AppMethodBeat.i(169461);
      cqk = new a()
      {
        public final String Fr()
        {
          return null;
        }
        
        public final void a(final a.b paramAnonymousb)
        {
          AppMethodBeat.i(169459);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(169458);
              paramAnonymousb.o(null);
              AppMethodBeat.o(169458);
            }
          });
          AppMethodBeat.o(169459);
        }
      };
      AppMethodBeat.o(169461);
    }
    
    public static a b(c paramc)
    {
      AppMethodBeat.i(169460);
      a locala = (a)paramc.K(a.class);
      paramc = locala;
      if (locala == null) {
        paramc = cqk;
      }
      AppMethodBeat.o(169460);
      return paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.f.a
 * JD-Core Version:    0.7.0.1
 */