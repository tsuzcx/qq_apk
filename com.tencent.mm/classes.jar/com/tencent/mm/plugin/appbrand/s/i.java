package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class i
{
  private static AtomicInteger qiG;
  public HashMap<String, g> qiH;
  
  static
  {
    AppMethodBeat.i(144363);
    qiG = new AtomicInteger(1);
    AppMethodBeat.o(144363);
  }
  
  private i()
  {
    AppMethodBeat.i(144359);
    this.qiH = new HashMap();
    AppMethodBeat.o(144359);
  }
  
  public static int cbN()
  {
    AppMethodBeat.i(144360);
    int i = qiG.incrementAndGet();
    AppMethodBeat.o(144360);
    return i;
  }
  
  public static i cbT()
  {
    AppMethodBeat.i(144361);
    i locali = a.cbU();
    AppMethodBeat.o(144361);
    return locali;
  }
  
  public final g akV(String paramString)
  {
    AppMethodBeat.i(144362);
    if (this.qiH.containsKey(paramString))
    {
      paramString = (g)this.qiH.get(paramString);
      AppMethodBeat.o(144362);
      return paramString;
    }
    AppMethodBeat.o(144362);
    return null;
  }
  
  static final class a
  {
    private static i qju;
    
    static
    {
      AppMethodBeat.i(144358);
      qju = new i((byte)0);
      AppMethodBeat.o(144358);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.i
 * JD-Core Version:    0.7.0.1
 */