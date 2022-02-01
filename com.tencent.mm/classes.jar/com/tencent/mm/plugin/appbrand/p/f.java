package com.tencent.mm.plugin.appbrand.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  private static AtomicInteger lws;
  public HashMap<String, d> lwt;
  
  static
  {
    AppMethodBeat.i(144343);
    lws = new AtomicInteger(1);
    AppMethodBeat.o(144343);
  }
  
  private f()
  {
    AppMethodBeat.i(144339);
    this.lwt = new HashMap();
    AppMethodBeat.o(144339);
  }
  
  public static int bpf()
  {
    AppMethodBeat.i(144340);
    int i = lws.incrementAndGet();
    AppMethodBeat.o(144340);
    return i;
  }
  
  public static f bpj()
  {
    AppMethodBeat.i(144341);
    f localf = a.bpk();
    AppMethodBeat.o(144341);
    return localf;
  }
  
  public final d Pj(String paramString)
  {
    AppMethodBeat.i(144342);
    if (this.lwt.containsKey(paramString))
    {
      paramString = (d)this.lwt.get(paramString);
      AppMethodBeat.o(144342);
      return paramString;
    }
    AppMethodBeat.o(144342);
    return null;
  }
  
  static final class a
  {
    private static f lwX;
    
    static
    {
      AppMethodBeat.i(144338);
      lwX = new f((byte)0);
      AppMethodBeat.o(144338);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.f
 * JD-Core Version:    0.7.0.1
 */