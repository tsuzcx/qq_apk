package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  private static AtomicInteger lVF;
  public HashMap<String, d> lVG;
  
  static
  {
    AppMethodBeat.i(144343);
    lVF = new AtomicInteger(1);
    AppMethodBeat.o(144343);
  }
  
  private f()
  {
    AppMethodBeat.i(144339);
    this.lVG = new HashMap();
    AppMethodBeat.o(144339);
  }
  
  public static int bte()
  {
    AppMethodBeat.i(144340);
    int i = lVF.incrementAndGet();
    AppMethodBeat.o(144340);
    return i;
  }
  
  public static f bti()
  {
    AppMethodBeat.i(144341);
    f localf = a.btj();
    AppMethodBeat.o(144341);
    return localf;
  }
  
  public final d SM(String paramString)
  {
    AppMethodBeat.i(144342);
    if (this.lVG.containsKey(paramString))
    {
      paramString = (d)this.lVG.get(paramString);
      AppMethodBeat.o(144342);
      return paramString;
    }
    AppMethodBeat.o(144342);
    return null;
  }
  
  static final class a
  {
    private static f lWk;
    
    static
    {
      AppMethodBeat.i(144338);
      lWk = new f((byte)0);
      AppMethodBeat.o(144338);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.f
 * JD-Core Version:    0.7.0.1
 */