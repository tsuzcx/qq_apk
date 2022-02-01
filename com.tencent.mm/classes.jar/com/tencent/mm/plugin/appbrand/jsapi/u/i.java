package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;

public final class i
  implements a
{
  public static i kjA;
  private a kjB;
  
  static
  {
    AppMethodBeat.i(137650);
    kjA = new i();
    AppMethodBeat.o(137650);
  }
  
  public i()
  {
    AppMethodBeat.i(137645);
    this.kjB = new a()
    {
      public final boolean a(c paramAnonymousc, ar paramAnonymousar)
      {
        return true;
      }
      
      public final int bbO()
      {
        return 20;
      }
      
      public final int bbP()
      {
        return 200;
      }
    };
    AppMethodBeat.o(137645);
  }
  
  private a bbR()
  {
    AppMethodBeat.i(137646);
    if (e.K(a.class) != null)
    {
      locala = (a)e.K(a.class);
      AppMethodBeat.o(137646);
      return locala;
    }
    a locala = this.kjB;
    AppMethodBeat.o(137646);
    return locala;
  }
  
  public final boolean a(c paramc, ar paramar)
  {
    AppMethodBeat.i(137649);
    boolean bool = bbR().a(paramc, paramar);
    AppMethodBeat.o(137649);
    return bool;
  }
  
  public final int bbO()
  {
    AppMethodBeat.i(137647);
    int i = bbR().bbO();
    AppMethodBeat.o(137647);
    return i;
  }
  
  public final int bbP()
  {
    AppMethodBeat.i(137648);
    int i = bbR().bbP();
    AppMethodBeat.o(137648);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.i
 * JD-Core Version:    0.7.0.1
 */