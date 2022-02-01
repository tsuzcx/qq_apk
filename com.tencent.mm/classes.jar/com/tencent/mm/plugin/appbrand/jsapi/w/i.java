package com.tencent.mm.plugin.appbrand.jsapi.w;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;

public final class i
  implements a
{
  public static i lhq;
  private a lhr;
  
  static
  {
    AppMethodBeat.i(137650);
    lhq = new i();
    AppMethodBeat.o(137650);
  }
  
  public i()
  {
    AppMethodBeat.i(137645);
    this.lhr = new a()
    {
      public final boolean a(c paramAnonymousc, at paramAnonymousat)
      {
        return true;
      }
      
      public final int bmv()
      {
        return 20;
      }
      
      public final int bmw()
      {
        return 200;
      }
    };
    AppMethodBeat.o(137645);
  }
  
  private a bmy()
  {
    AppMethodBeat.i(137646);
    if (e.K(a.class) != null)
    {
      locala = (a)e.K(a.class);
      AppMethodBeat.o(137646);
      return locala;
    }
    a locala = this.lhr;
    AppMethodBeat.o(137646);
    return locala;
  }
  
  public final boolean a(c paramc, at paramat)
  {
    AppMethodBeat.i(195020);
    boolean bool = bmy().a(paramc, paramat);
    AppMethodBeat.o(195020);
    return bool;
  }
  
  public final int bmv()
  {
    AppMethodBeat.i(137647);
    int i = bmy().bmv();
    AppMethodBeat.o(137647);
    return i;
  }
  
  public final int bmw()
  {
    AppMethodBeat.i(137648);
    int i = bmy().bmw();
    AppMethodBeat.o(137648);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.i
 * JD-Core Version:    0.7.0.1
 */