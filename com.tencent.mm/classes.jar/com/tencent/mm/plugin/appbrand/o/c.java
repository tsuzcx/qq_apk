package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
{
  private static AtomicInteger lVF;
  public HashMap<String, b> lVG;
  
  static
  {
    AppMethodBeat.i(144315);
    lVF = new AtomicInteger(1);
    AppMethodBeat.o(144315);
  }
  
  private c()
  {
    AppMethodBeat.i(144311);
    this.lVG = new HashMap();
    AppMethodBeat.o(144311);
  }
  
  public static int bte()
  {
    AppMethodBeat.i(144312);
    int i = lVF.incrementAndGet();
    AppMethodBeat.o(144312);
    return i;
  }
  
  public static c btf()
  {
    AppMethodBeat.i(144313);
    c localc = a.btg();
    AppMethodBeat.o(144313);
    return localc;
  }
  
  public final b SI(String paramString)
  {
    AppMethodBeat.i(144314);
    if (this.lVG.containsKey(paramString))
    {
      paramString = (b)this.lVG.get(paramString);
      AppMethodBeat.o(144314);
      return paramString;
    }
    AppMethodBeat.o(144314);
    return null;
  }
  
  static final class a
  {
    private static c lVH;
    
    static
    {
      AppMethodBeat.i(144310);
      lVH = new c((byte)0);
      AppMethodBeat.o(144310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.c
 * JD-Core Version:    0.7.0.1
 */