package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class i
{
  private static AtomicInteger maj;
  public HashMap<String, g> mak;
  
  static
  {
    AppMethodBeat.i(144363);
    maj = new AtomicInteger(1);
    AppMethodBeat.o(144363);
  }
  
  private i()
  {
    AppMethodBeat.i(144359);
    this.mak = new HashMap();
    AppMethodBeat.o(144359);
  }
  
  public static int btP()
  {
    AppMethodBeat.i(144360);
    int i = maj.incrementAndGet();
    AppMethodBeat.o(144360);
    return i;
  }
  
  public static i btV()
  {
    AppMethodBeat.i(144361);
    i locali = a.btW();
    AppMethodBeat.o(144361);
    return locali;
  }
  
  public final g Tx(String paramString)
  {
    AppMethodBeat.i(144362);
    if (this.mak.containsKey(paramString))
    {
      paramString = (g)this.mak.get(paramString);
      AppMethodBeat.o(144362);
      return paramString;
    }
    AppMethodBeat.o(144362);
    return null;
  }
  
  static final class a
  {
    private static i maY;
    
    static
    {
      AppMethodBeat.i(144358);
      maY = new i((byte)0);
      AppMethodBeat.o(144358);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.i
 * JD-Core Version:    0.7.0.1
 */