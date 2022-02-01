package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;

public final class i
  implements a
{
  public static i poU;
  private a poV;
  
  static
  {
    AppMethodBeat.i(137650);
    poU = new i();
    AppMethodBeat.o(137650);
  }
  
  public i()
  {
    AppMethodBeat.i(137645);
    this.poV = new a()
    {
      public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.e paramAnonymouse, az paramAnonymousaz)
      {
        return true;
      }
      
      public final int bUl()
      {
        return 20;
      }
      
      public final int bUm()
      {
        return 200;
      }
      
      public final boolean bUn()
      {
        return false;
      }
      
      public final boolean bUo()
      {
        return false;
      }
      
      public final boolean bUp()
      {
        return false;
      }
    };
    AppMethodBeat.o(137645);
  }
  
  private a bUq()
  {
    AppMethodBeat.i(137646);
    if (com.tencent.luggage.a.e.K(a.class) != null)
    {
      locala = (a)com.tencent.luggage.a.e.K(a.class);
      AppMethodBeat.o(137646);
      return locala;
    }
    a locala = this.poV;
    AppMethodBeat.o(137646);
    return locala;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.e parame, az paramaz)
  {
    AppMethodBeat.i(205881);
    boolean bool = bUq().a(parame, paramaz);
    AppMethodBeat.o(205881);
    return bool;
  }
  
  public final int bUl()
  {
    AppMethodBeat.i(137647);
    int i = bUq().bUl();
    AppMethodBeat.o(137647);
    return i;
  }
  
  public final int bUm()
  {
    AppMethodBeat.i(137648);
    int i = bUq().bUm();
    AppMethodBeat.o(137648);
    return i;
  }
  
  public final boolean bUn()
  {
    AppMethodBeat.i(205883);
    boolean bool = bUq().bUn();
    AppMethodBeat.o(205883);
    return bool;
  }
  
  public final boolean bUo()
  {
    AppMethodBeat.i(205884);
    boolean bool = bUq().bUo();
    AppMethodBeat.o(205884);
    return bool;
  }
  
  public final boolean bUp()
  {
    AppMethodBeat.i(205885);
    boolean bool = bUq().bUp();
    AppMethodBeat.o(205885);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.i
 * JD-Core Version:    0.7.0.1
 */