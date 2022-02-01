package com.tencent.mm.plugin.appbrand.jsapi.w;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;

public final class i
  implements a
{
  public static i llc;
  private a lld;
  
  static
  {
    AppMethodBeat.i(137650);
    llc = new i();
    AppMethodBeat.o(137650);
  }
  
  public i()
  {
    AppMethodBeat.i(137645);
    this.lld = new a()
    {
      public final boolean a(c paramAnonymousc, at paramAnonymousat)
      {
        return true;
      }
      
      public final int bne()
      {
        return 20;
      }
      
      public final int bnf()
      {
        return 200;
      }
    };
    AppMethodBeat.o(137645);
  }
  
  private a bnh()
  {
    AppMethodBeat.i(137646);
    if (e.K(a.class) != null)
    {
      locala = (a)e.K(a.class);
      AppMethodBeat.o(137646);
      return locala;
    }
    a locala = this.lld;
    AppMethodBeat.o(137646);
    return locala;
  }
  
  public final boolean a(c paramc, at paramat)
  {
    AppMethodBeat.i(197251);
    boolean bool = bnh().a(paramc, paramat);
    AppMethodBeat.o(197251);
    return bool;
  }
  
  public final int bne()
  {
    AppMethodBeat.i(137647);
    int i = bnh().bne();
    AppMethodBeat.o(137647);
    return i;
  }
  
  public final int bnf()
  {
    AppMethodBeat.i(137648);
    int i = bnh().bnf();
    AppMethodBeat.o(137648);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.i
 * JD-Core Version:    0.7.0.1
 */