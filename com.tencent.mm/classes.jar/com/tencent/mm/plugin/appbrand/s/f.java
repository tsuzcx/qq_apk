package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  private static AtomicInteger nhX;
  public HashMap<String, d> nhY;
  
  static
  {
    AppMethodBeat.i(144343);
    nhX = new AtomicInteger(1);
    AppMethodBeat.o(144343);
  }
  
  private f()
  {
    AppMethodBeat.i(144339);
    this.nhY = new HashMap();
    AppMethodBeat.o(144339);
  }
  
  public static f bPA()
  {
    AppMethodBeat.i(144341);
    f localf = a.bPB();
    AppMethodBeat.o(144341);
    return localf;
  }
  
  public static int bPw()
  {
    AppMethodBeat.i(144340);
    int i = nhX.incrementAndGet();
    AppMethodBeat.o(144340);
    return i;
  }
  
  public final d acZ(String paramString)
  {
    AppMethodBeat.i(144342);
    if (this.nhY.containsKey(paramString))
    {
      paramString = (d)this.nhY.get(paramString);
      AppMethodBeat.o(144342);
      return paramString;
    }
    AppMethodBeat.o(144342);
    return null;
  }
  
  static final class a
  {
    private static f niB;
    
    static
    {
      AppMethodBeat.i(144338);
      niB = new f((byte)0);
      AppMethodBeat.o(144338);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.f
 * JD-Core Version:    0.7.0.1
 */