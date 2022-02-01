package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
{
  private static AtomicInteger nhX;
  public HashMap<String, b> nhY;
  
  static
  {
    AppMethodBeat.i(144315);
    nhX = new AtomicInteger(1);
    AppMethodBeat.o(144315);
  }
  
  private c()
  {
    AppMethodBeat.i(144311);
    this.nhY = new HashMap();
    AppMethodBeat.o(144311);
  }
  
  public static int bPw()
  {
    AppMethodBeat.i(144312);
    int i = nhX.incrementAndGet();
    AppMethodBeat.o(144312);
    return i;
  }
  
  public static c bPx()
  {
    AppMethodBeat.i(144313);
    c localc = a.bPy();
    AppMethodBeat.o(144313);
    return localc;
  }
  
  public final b acV(String paramString)
  {
    AppMethodBeat.i(144314);
    if (this.nhY.containsKey(paramString))
    {
      paramString = (b)this.nhY.get(paramString);
      AppMethodBeat.o(144314);
      return paramString;
    }
    AppMethodBeat.o(144314);
    return null;
  }
  
  static final class a
  {
    private static c nhZ;
    
    static
    {
      AppMethodBeat.i(144310);
      nhZ = new c((byte)0);
      AppMethodBeat.o(144310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.c
 * JD-Core Version:    0.7.0.1
 */