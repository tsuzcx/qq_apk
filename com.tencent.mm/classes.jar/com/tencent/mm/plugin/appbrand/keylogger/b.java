package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  final Map<String, List<com.tencent.mm.plugin.appbrand.keylogger.base.b>> sjN;
  
  private b()
  {
    AppMethodBeat.i(319483);
    this.sjN = new HashMap();
    AppMethodBeat.o(319483);
  }
  
  final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(319504);
    paramString = (List)this.sjN.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(319504);
      return;
    }
    int i = 0;
    while (i < paramString.size())
    {
      paramb.a((com.tencent.mm.plugin.appbrand.keylogger.base.b)paramString.get(i));
      i += 1;
    }
    AppMethodBeat.o(319504);
  }
  
  public final void a(String paramString1, final String paramString2, final a parama, final long paramLong)
  {
    AppMethodBeat.i(319497);
    a(paramString1, new b()
    {
      public final void a(com.tencent.mm.plugin.appbrand.keylogger.base.b paramAnonymousb)
      {
        AppMethodBeat.i(319448);
        paramAnonymousb.b(paramString2, parama, paramLong);
        AppMethodBeat.o(319448);
      }
    });
    AppMethodBeat.o(319497);
  }
  
  static final class a
  {
    private static final b sUx;
    
    static
    {
      AppMethodBeat.i(319467);
      sUx = new b((byte)0);
      AppMethodBeat.o(319467);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(com.tencent.mm.plugin.appbrand.keylogger.base.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.b
 * JD-Core Version:    0.7.0.1
 */