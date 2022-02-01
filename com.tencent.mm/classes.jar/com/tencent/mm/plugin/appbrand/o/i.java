package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class i
{
  private static AtomicInteger lVF;
  public HashMap<String, g> lVG;
  
  static
  {
    AppMethodBeat.i(144363);
    lVF = new AtomicInteger(1);
    AppMethodBeat.o(144363);
  }
  
  private i()
  {
    AppMethodBeat.i(144359);
    this.lVG = new HashMap();
    AppMethodBeat.o(144359);
  }
  
  public static int bte()
  {
    AppMethodBeat.i(144360);
    int i = lVF.incrementAndGet();
    AppMethodBeat.o(144360);
    return i;
  }
  
  public static i btk()
  {
    AppMethodBeat.i(144361);
    i locali = a.btl();
    AppMethodBeat.o(144361);
    return locali;
  }
  
  public final g SO(String paramString)
  {
    AppMethodBeat.i(144362);
    if (this.lVG.containsKey(paramString))
    {
      paramString = (g)this.lVG.get(paramString);
      AppMethodBeat.o(144362);
      return paramString;
    }
    AppMethodBeat.o(144362);
    return null;
  }
  
  static final class a
  {
    private static i lWs;
    
    static
    {
      AppMethodBeat.i(144358);
      lWs = new i((byte)0);
      AppMethodBeat.o(144358);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.i
 * JD-Core Version:    0.7.0.1
 */