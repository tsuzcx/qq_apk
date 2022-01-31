package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashSet;
import java.util.Set;

public class x
{
  private static volatile boolean gRS;
  private static volatile boolean gRT;
  private static final Set<x.a> gRU;
  
  static
  {
    AppMethodBeat.i(129141);
    gRS = false;
    gRT = false;
    gRU = new HashSet();
    AppMethodBeat.o(129141);
  }
  
  public static void a(x.a parama)
  {
    AppMethodBeat.i(129138);
    try
    {
      boolean bool1 = gRS;
      boolean bool2 = gRT;
      if (!bool2)
      {
        gRU.add(parama);
        gRS = true;
        gRT = false;
      }
      if (bool1) {
        return;
      }
      if (bool2)
      {
        parama.atZ();
        AppMethodBeat.o(129138);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(129138);
    }
    parama = new x.1();
    new al().ac(new x.2(parama));
    AppMethodBeat.o(129138);
  }
  
  public static boolean aul()
  {
    try
    {
      boolean bool = gRT;
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.x
 * JD-Core Version:    0.7.0.1
 */