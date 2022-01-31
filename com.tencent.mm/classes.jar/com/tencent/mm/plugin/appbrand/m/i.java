package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class i
{
  private static AtomicInteger isF;
  public HashMap<String, g> hIm;
  
  static
  {
    AppMethodBeat.i(108185);
    isF = new AtomicInteger(1);
    AppMethodBeat.o(108185);
  }
  
  private i()
  {
    AppMethodBeat.i(108181);
    this.hIm = new HashMap();
    AppMethodBeat.o(108181);
  }
  
  public static int aIg()
  {
    AppMethodBeat.i(108182);
    int i = isF.incrementAndGet();
    AppMethodBeat.o(108182);
    return i;
  }
  
  public static i aIm()
  {
    AppMethodBeat.i(108183);
    i locali = a.aIn();
    AppMethodBeat.o(108183);
    return locali;
  }
  
  public final g DU(String paramString)
  {
    AppMethodBeat.i(108184);
    if (this.hIm.containsKey(paramString))
    {
      paramString = (g)this.hIm.get(paramString);
      AppMethodBeat.o(108184);
      return paramString;
    }
    AppMethodBeat.o(108184);
    return null;
  }
  
  static final class a
  {
    private static i itg;
    
    static
    {
      AppMethodBeat.i(108180);
      itg = new i((byte)0);
      AppMethodBeat.o(108180);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.i
 * JD-Core Version:    0.7.0.1
 */