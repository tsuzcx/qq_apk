package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
{
  private static AtomicInteger maj;
  public HashMap<String, b> mak;
  
  static
  {
    AppMethodBeat.i(144315);
    maj = new AtomicInteger(1);
    AppMethodBeat.o(144315);
  }
  
  private c()
  {
    AppMethodBeat.i(144311);
    this.mak = new HashMap();
    AppMethodBeat.o(144311);
  }
  
  public static int btP()
  {
    AppMethodBeat.i(144312);
    int i = maj.incrementAndGet();
    AppMethodBeat.o(144312);
    return i;
  }
  
  public static c btQ()
  {
    AppMethodBeat.i(144313);
    c localc = a.btR();
    AppMethodBeat.o(144313);
    return localc;
  }
  
  public final b Tr(String paramString)
  {
    AppMethodBeat.i(144314);
    if (this.mak.containsKey(paramString))
    {
      paramString = (b)this.mak.get(paramString);
      AppMethodBeat.o(144314);
      return paramString;
    }
    AppMethodBeat.o(144314);
    return null;
  }
  
  static final class a
  {
    private static c mal;
    
    static
    {
      AppMethodBeat.i(144310);
      mal = new c((byte)0);
      AppMethodBeat.o(144310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.c
 * JD-Core Version:    0.7.0.1
 */