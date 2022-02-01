package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  private static AtomicInteger maj;
  public HashMap<String, d> mak;
  
  static
  {
    AppMethodBeat.i(144343);
    maj = new AtomicInteger(1);
    AppMethodBeat.o(144343);
  }
  
  private f()
  {
    AppMethodBeat.i(144339);
    this.mak = new HashMap();
    AppMethodBeat.o(144339);
  }
  
  public static int btP()
  {
    AppMethodBeat.i(144340);
    int i = maj.incrementAndGet();
    AppMethodBeat.o(144340);
    return i;
  }
  
  public static f btT()
  {
    AppMethodBeat.i(144341);
    f localf = a.btU();
    AppMethodBeat.o(144341);
    return localf;
  }
  
  public final d Tv(String paramString)
  {
    AppMethodBeat.i(144342);
    if (this.mak.containsKey(paramString))
    {
      paramString = (d)this.mak.get(paramString);
      AppMethodBeat.o(144342);
      return paramString;
    }
    AppMethodBeat.o(144342);
    return null;
  }
  
  static final class a
  {
    private static f maQ;
    
    static
    {
      AppMethodBeat.i(144338);
      maQ = new f((byte)0);
      AppMethodBeat.o(144338);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.f
 * JD-Core Version:    0.7.0.1
 */