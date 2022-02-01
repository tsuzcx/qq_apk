package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class i
{
  private static AtomicInteger nhX;
  public HashMap<String, g> nhY;
  
  static
  {
    AppMethodBeat.i(144363);
    nhX = new AtomicInteger(1);
    AppMethodBeat.o(144363);
  }
  
  private i()
  {
    AppMethodBeat.i(144359);
    this.nhY = new HashMap();
    AppMethodBeat.o(144359);
  }
  
  public static i bPC()
  {
    AppMethodBeat.i(144361);
    i locali = a.bPD();
    AppMethodBeat.o(144361);
    return locali;
  }
  
  public static int bPw()
  {
    AppMethodBeat.i(144360);
    int i = nhX.incrementAndGet();
    AppMethodBeat.o(144360);
    return i;
  }
  
  public final g adb(String paramString)
  {
    AppMethodBeat.i(144362);
    if (this.nhY.containsKey(paramString))
    {
      paramString = (g)this.nhY.get(paramString);
      AppMethodBeat.o(144362);
      return paramString;
    }
    AppMethodBeat.o(144362);
    return null;
  }
  
  static final class a
  {
    private static i niJ;
    
    static
    {
      AppMethodBeat.i(144358);
      niJ = new i((byte)0);
      AppMethodBeat.o(144358);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.i
 * JD-Core Version:    0.7.0.1
 */