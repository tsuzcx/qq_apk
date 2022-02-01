package com.tencent.mm.plugin.appbrand.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class i
{
  private static AtomicInteger lws;
  public HashMap<String, g> lwt;
  
  static
  {
    AppMethodBeat.i(144363);
    lws = new AtomicInteger(1);
    AppMethodBeat.o(144363);
  }
  
  private i()
  {
    AppMethodBeat.i(144359);
    this.lwt = new HashMap();
    AppMethodBeat.o(144359);
  }
  
  public static int bpf()
  {
    AppMethodBeat.i(144360);
    int i = lws.incrementAndGet();
    AppMethodBeat.o(144360);
    return i;
  }
  
  public static i bpl()
  {
    AppMethodBeat.i(144361);
    i locali = a.bpm();
    AppMethodBeat.o(144361);
    return locali;
  }
  
  public final g Pl(String paramString)
  {
    AppMethodBeat.i(144362);
    if (this.lwt.containsKey(paramString))
    {
      paramString = (g)this.lwt.get(paramString);
      AppMethodBeat.o(144362);
      return paramString;
    }
    AppMethodBeat.o(144362);
    return null;
  }
  
  static final class a
  {
    private static i lxf;
    
    static
    {
      AppMethodBeat.i(144358);
      lxf = new i((byte)0);
      AppMethodBeat.o(144358);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.i
 * JD-Core Version:    0.7.0.1
 */