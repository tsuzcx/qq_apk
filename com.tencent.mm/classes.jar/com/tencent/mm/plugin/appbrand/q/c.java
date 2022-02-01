package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
{
  private static AtomicInteger kUI;
  public HashMap<String, b> kUJ;
  
  static
  {
    AppMethodBeat.i(144315);
    kUI = new AtomicInteger(1);
    AppMethodBeat.o(144315);
  }
  
  private c()
  {
    AppMethodBeat.i(144311);
    this.kUJ = new HashMap();
    AppMethodBeat.o(144311);
  }
  
  public static int bil()
  {
    AppMethodBeat.i(144312);
    int i = kUI.incrementAndGet();
    AppMethodBeat.o(144312);
    return i;
  }
  
  public static c bim()
  {
    AppMethodBeat.i(144313);
    c localc = a.bin();
    AppMethodBeat.o(144313);
    return localc;
  }
  
  public final b KY(String paramString)
  {
    AppMethodBeat.i(144314);
    if (this.kUJ.containsKey(paramString))
    {
      paramString = (b)this.kUJ.get(paramString);
      AppMethodBeat.o(144314);
      return paramString;
    }
    AppMethodBeat.o(144314);
    return null;
  }
  
  static final class a
  {
    private static c kUK;
    
    static
    {
      AppMethodBeat.i(144310);
      kUK = new c((byte)0);
      AppMethodBeat.o(144310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.c
 * JD-Core Version:    0.7.0.1
 */