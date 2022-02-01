package com.tencent.mm.plugin.appbrand.jsapi.ad;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;

public final class i
  implements a
{
  public static i stI;
  private a stJ;
  
  static
  {
    AppMethodBeat.i(137650);
    stI = new i();
    AppMethodBeat.o(137650);
  }
  
  public i()
  {
    AppMethodBeat.i(137645);
    this.stJ = new a()
    {
      public final boolean a(f paramAnonymousf, bc paramAnonymousbc)
      {
        return true;
      }
      
      public final boolean cuA()
      {
        return false;
      }
      
      public final boolean cuB()
      {
        return false;
      }
      
      public final boolean cuC()
      {
        return false;
      }
      
      public final int cuy()
      {
        return 20;
      }
      
      public final int cuz()
      {
        return 200;
      }
    };
    AppMethodBeat.o(137645);
  }
  
  private a cuE()
  {
    AppMethodBeat.i(137646);
    if (e.T(a.class) != null)
    {
      locala = (a)e.T(a.class);
      AppMethodBeat.o(137646);
      return locala;
    }
    a locala = this.stJ;
    AppMethodBeat.o(137646);
    return locala;
  }
  
  public final boolean a(f paramf, bc parambc)
  {
    AppMethodBeat.i(329505);
    boolean bool = cuE().a(paramf, parambc);
    AppMethodBeat.o(329505);
    return bool;
  }
  
  public final boolean cuA()
  {
    AppMethodBeat.i(329509);
    boolean bool = cuE().cuA();
    AppMethodBeat.o(329509);
    return bool;
  }
  
  public final boolean cuB()
  {
    AppMethodBeat.i(329512);
    boolean bool = cuE().cuB();
    AppMethodBeat.o(329512);
    return bool;
  }
  
  public final boolean cuC()
  {
    AppMethodBeat.i(329515);
    boolean bool = cuE().cuC();
    AppMethodBeat.o(329515);
    return bool;
  }
  
  public final int cuy()
  {
    AppMethodBeat.i(137647);
    int i = cuE().cuy();
    AppMethodBeat.o(137647);
    return i;
  }
  
  public final int cuz()
  {
    AppMethodBeat.i(137648);
    int i = cuE().cuz();
    AppMethodBeat.o(137648);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.i
 * JD-Core Version:    0.7.0.1
 */