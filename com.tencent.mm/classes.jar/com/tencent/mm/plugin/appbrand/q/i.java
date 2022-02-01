package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class i
{
  private static AtomicInteger kUI;
  public HashMap<String, g> kUJ;
  
  static
  {
    AppMethodBeat.i(144363);
    kUI = new AtomicInteger(1);
    AppMethodBeat.o(144363);
  }
  
  private i()
  {
    AppMethodBeat.i(144359);
    this.kUJ = new HashMap();
    AppMethodBeat.o(144359);
  }
  
  public static int bil()
  {
    AppMethodBeat.i(144360);
    int i = kUI.incrementAndGet();
    AppMethodBeat.o(144360);
    return i;
  }
  
  public static i bir()
  {
    AppMethodBeat.i(144361);
    i locali = a.bis();
    AppMethodBeat.o(144361);
    return locali;
  }
  
  public final g Ld(String paramString)
  {
    AppMethodBeat.i(144362);
    if (this.kUJ.containsKey(paramString))
    {
      paramString = (g)this.kUJ.get(paramString);
      AppMethodBeat.o(144362);
      return paramString;
    }
    AppMethodBeat.o(144362);
    return null;
  }
  
  static final class a
  {
    private static i kVv;
    
    static
    {
      AppMethodBeat.i(144358);
      kVv = new i((byte)0);
      AppMethodBeat.o(144358);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.i
 * JD-Core Version:    0.7.0.1
 */