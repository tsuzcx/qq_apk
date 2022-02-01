package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
{
  private static AtomicInteger qiG;
  public HashMap<String, b> qiH;
  
  static
  {
    AppMethodBeat.i(144315);
    qiG = new AtomicInteger(1);
    AppMethodBeat.o(144315);
  }
  
  private c()
  {
    AppMethodBeat.i(144311);
    this.qiH = new HashMap();
    AppMethodBeat.o(144311);
  }
  
  public static int cbN()
  {
    AppMethodBeat.i(144312);
    int i = qiG.incrementAndGet();
    AppMethodBeat.o(144312);
    return i;
  }
  
  public static c cbO()
  {
    AppMethodBeat.i(144313);
    c localc = a.cbP();
    AppMethodBeat.o(144313);
    return localc;
  }
  
  public final b akP(String paramString)
  {
    AppMethodBeat.i(144314);
    if (this.qiH.containsKey(paramString))
    {
      paramString = (b)this.qiH.get(paramString);
      AppMethodBeat.o(144314);
      return paramString;
    }
    AppMethodBeat.o(144314);
    return null;
  }
  
  static final class a
  {
    private static c qiI;
    
    static
    {
      AppMethodBeat.i(144310);
      qiI = new c((byte)0);
      AppMethodBeat.o(144310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.c
 * JD-Core Version:    0.7.0.1
 */