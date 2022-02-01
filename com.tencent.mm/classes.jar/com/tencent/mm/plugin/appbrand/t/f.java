package com.tencent.mm.plugin.appbrand.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  private static AtomicInteger tns;
  public HashMap<String, d> tnt;
  
  static
  {
    AppMethodBeat.i(144343);
    tns = new AtomicInteger(1);
    AppMethodBeat.o(144343);
  }
  
  private f()
  {
    AppMethodBeat.i(144339);
    this.tnt = new HashMap();
    AppMethodBeat.o(144339);
  }
  
  public static int cCg()
  {
    AppMethodBeat.i(144340);
    int i = tns.incrementAndGet();
    AppMethodBeat.o(144340);
    return i;
  }
  
  public static f cCk()
  {
    AppMethodBeat.i(144341);
    f localf = a.cCl();
    AppMethodBeat.o(144341);
    return localf;
  }
  
  public final d aea(String paramString)
  {
    AppMethodBeat.i(144342);
    if (this.tnt.containsKey(paramString))
    {
      paramString = (d)this.tnt.get(paramString);
      AppMethodBeat.o(144342);
      return paramString;
    }
    AppMethodBeat.o(144342);
    return null;
  }
  
  static final class a
  {
    private static f toe;
    
    static
    {
      AppMethodBeat.i(144338);
      toe = new f((byte)0);
      AppMethodBeat.o(144338);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.f
 * JD-Core Version:    0.7.0.1
 */