package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  final Map<String, List<com.tencent.mm.plugin.appbrand.keylogger.base.b>> kax;
  
  private b()
  {
    AppMethodBeat.i(194840);
    this.kax = new HashMap();
    AppMethodBeat.o(194840);
  }
  
  final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(194842);
    paramString = (List)this.kax.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(194842);
      return;
    }
    int i = 0;
    while (i < paramString.size())
    {
      paramb.a((com.tencent.mm.plugin.appbrand.keylogger.base.b)paramString.get(i));
      i += 1;
    }
    AppMethodBeat.o(194842);
  }
  
  public final void a(String paramString1, final String paramString2, final a parama, final long paramLong)
  {
    AppMethodBeat.i(194841);
    a(paramString1, new b()
    {
      public final void a(com.tencent.mm.plugin.appbrand.keylogger.base.b paramAnonymousb)
      {
        AppMethodBeat.i(194837);
        paramAnonymousb.b(paramString2, parama, paramLong);
        AppMethodBeat.o(194837);
      }
    });
    AppMethodBeat.o(194841);
  }
  
  static final class a
  {
    private static final b kEz;
    
    static
    {
      AppMethodBeat.i(194839);
      kEz = new b((byte)0);
      AppMethodBeat.o(194839);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(com.tencent.mm.plugin.appbrand.keylogger.base.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.b
 * JD-Core Version:    0.7.0.1
 */