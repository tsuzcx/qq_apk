package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  private static AtomicInteger qiG;
  public HashMap<String, d> qiH;
  
  static
  {
    AppMethodBeat.i(144343);
    qiG = new AtomicInteger(1);
    AppMethodBeat.o(144343);
  }
  
  private f()
  {
    AppMethodBeat.i(144339);
    this.qiH = new HashMap();
    AppMethodBeat.o(144339);
  }
  
  public static int cbN()
  {
    AppMethodBeat.i(144340);
    int i = qiG.incrementAndGet();
    AppMethodBeat.o(144340);
    return i;
  }
  
  public static f cbR()
  {
    AppMethodBeat.i(144341);
    f localf = a.cbS();
    AppMethodBeat.o(144341);
    return localf;
  }
  
  public final d akT(String paramString)
  {
    AppMethodBeat.i(144342);
    if (this.qiH.containsKey(paramString))
    {
      paramString = (d)this.qiH.get(paramString);
      AppMethodBeat.o(144342);
      return paramString;
    }
    AppMethodBeat.o(144342);
    return null;
  }
  
  static final class a
  {
    private static f qjm;
    
    static
    {
      AppMethodBeat.i(144338);
      qjm = new f((byte)0);
      AppMethodBeat.o(144338);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.f
 * JD-Core Version:    0.7.0.1
 */