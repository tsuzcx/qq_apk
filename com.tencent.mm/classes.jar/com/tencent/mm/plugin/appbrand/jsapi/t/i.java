package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;

public final class i
  implements a
{
  public static i kKR;
  private a kKS;
  
  static
  {
    AppMethodBeat.i(137650);
    kKR = new i();
    AppMethodBeat.o(137650);
  }
  
  public i()
  {
    AppMethodBeat.i(137645);
    this.kKS = new a()
    {
      public final boolean a(c paramAnonymousc, ar paramAnonymousar)
      {
        return true;
      }
      
      public final int biJ()
      {
        return 20;
      }
      
      public final int biK()
      {
        return 200;
      }
    };
    AppMethodBeat.o(137645);
  }
  
  private a biM()
  {
    AppMethodBeat.i(137646);
    if (e.K(a.class) != null)
    {
      locala = (a)e.K(a.class);
      AppMethodBeat.o(137646);
      return locala;
    }
    a locala = this.kKS;
    AppMethodBeat.o(137646);
    return locala;
  }
  
  public final boolean a(c paramc, ar paramar)
  {
    AppMethodBeat.i(137649);
    boolean bool = biM().a(paramc, paramar);
    AppMethodBeat.o(137649);
    return bool;
  }
  
  public final int biJ()
  {
    AppMethodBeat.i(137647);
    int i = biM().biJ();
    AppMethodBeat.o(137647);
    return i;
  }
  
  public final int biK()
  {
    AppMethodBeat.i(137648);
    int i = biM().biK();
    AppMethodBeat.o(137648);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.i
 * JD-Core Version:    0.7.0.1
 */