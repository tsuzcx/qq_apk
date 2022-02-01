package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  private static AtomicInteger kUI;
  public HashMap<String, d> kUJ;
  
  static
  {
    AppMethodBeat.i(144343);
    kUI = new AtomicInteger(1);
    AppMethodBeat.o(144343);
  }
  
  private f()
  {
    AppMethodBeat.i(144339);
    this.kUJ = new HashMap();
    AppMethodBeat.o(144339);
  }
  
  public static int bil()
  {
    AppMethodBeat.i(144340);
    int i = kUI.incrementAndGet();
    AppMethodBeat.o(144340);
    return i;
  }
  
  public static f bip()
  {
    AppMethodBeat.i(144341);
    f localf = a.biq();
    AppMethodBeat.o(144341);
    return localf;
  }
  
  public final d Lb(String paramString)
  {
    AppMethodBeat.i(144342);
    if (this.kUJ.containsKey(paramString))
    {
      paramString = (d)this.kUJ.get(paramString);
      AppMethodBeat.o(144342);
      return paramString;
    }
    AppMethodBeat.o(144342);
    return null;
  }
  
  static final class a
  {
    private static f kVn;
    
    static
    {
      AppMethodBeat.i(144338);
      kVn = new f((byte)0);
      AppMethodBeat.o(144338);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.f
 * JD-Core Version:    0.7.0.1
 */