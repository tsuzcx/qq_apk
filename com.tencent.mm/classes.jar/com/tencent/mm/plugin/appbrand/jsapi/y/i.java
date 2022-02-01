package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;

public final class i
  implements a
{
  public static i mqN;
  private a mqO;
  
  static
  {
    AppMethodBeat.i(137650);
    mqN = new i();
    AppMethodBeat.o(137650);
  }
  
  public i()
  {
    AppMethodBeat.i(137645);
    this.mqO = new a()
    {
      public final boolean a(f paramAnonymousf, bc paramAnonymousbc)
      {
        return true;
      }
      
      public final int bID()
      {
        return 20;
      }
      
      public final int bIE()
      {
        return 200;
      }
      
      public final boolean bIF()
      {
        return false;
      }
      
      public final boolean bIG()
      {
        return false;
      }
    };
    AppMethodBeat.o(137645);
  }
  
  private a bII()
  {
    AppMethodBeat.i(137646);
    if (e.M(a.class) != null)
    {
      locala = (a)e.M(a.class);
      AppMethodBeat.o(137646);
      return locala;
    }
    a locala = this.mqO;
    AppMethodBeat.o(137646);
    return locala;
  }
  
  public final boolean a(f paramf, bc parambc)
  {
    AppMethodBeat.i(193696);
    boolean bool = bII().a(paramf, parambc);
    AppMethodBeat.o(193696);
    return bool;
  }
  
  public final int bID()
  {
    AppMethodBeat.i(137647);
    int i = bII().bID();
    AppMethodBeat.o(137647);
    return i;
  }
  
  public final int bIE()
  {
    AppMethodBeat.i(137648);
    int i = bII().bIE();
    AppMethodBeat.o(137648);
    return i;
  }
  
  public final boolean bIF()
  {
    AppMethodBeat.i(193697);
    boolean bool = bII().bIF();
    AppMethodBeat.o(193697);
    return bool;
  }
  
  public final boolean bIG()
  {
    AppMethodBeat.i(193698);
    boolean bool = bII().bIG();
    AppMethodBeat.o(193698);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.i
 * JD-Core Version:    0.7.0.1
 */