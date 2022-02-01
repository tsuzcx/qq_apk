package com.tencent.luggage.sdk.f;

import android.graphics.Bitmap;
import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ap;

public abstract interface a
  extends b
{
  public abstract String DN();
  
  public abstract void a(b paramb);
  
  public static final class a
  {
    private static final a cfr;
    
    static
    {
      AppMethodBeat.i(169461);
      cfr = new a()
      {
        public final String DN()
        {
          return null;
        }
        
        public final void a(final a.b paramAnonymousb)
        {
          AppMethodBeat.i(169459);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(169458);
              paramAnonymousb.n(null);
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
        paramc = cfr;
      }
      AppMethodBeat.o(169460);
      return paramc;
    }
  }
  
  public static abstract interface b
  {
    public abstract void n(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.f.a
 * JD-Core Version:    0.7.0.1
 */