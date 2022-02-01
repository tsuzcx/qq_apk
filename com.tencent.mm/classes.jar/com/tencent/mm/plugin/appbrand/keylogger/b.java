package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  final Map<String, List<com.tencent.mm.plugin.appbrand.keylogger.base.b>> kXr;
  
  private b()
  {
    AppMethodBeat.i(187667);
    this.kXr = new HashMap();
    AppMethodBeat.o(187667);
  }
  
  final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(187669);
    paramString = (List)this.kXr.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(187669);
      return;
    }
    int i = 0;
    while (i < paramString.size())
    {
      paramb.a((com.tencent.mm.plugin.appbrand.keylogger.base.b)paramString.get(i));
      i += 1;
    }
    AppMethodBeat.o(187669);
  }
  
  public final void a(String paramString1, final String paramString2, final a parama, final long paramLong)
  {
    AppMethodBeat.i(187668);
    a(paramString1, new b()
    {
      public final void a(com.tencent.mm.plugin.appbrand.keylogger.base.b paramAnonymousb)
      {
        AppMethodBeat.i(187664);
        paramAnonymousb.b(paramString2, parama, paramLong);
        AppMethodBeat.o(187664);
      }
    });
    AppMethodBeat.o(187668);
  }
  
  static final class a
  {
    private static final b lCQ;
    
    static
    {
      AppMethodBeat.i(187666);
      lCQ = new b((byte)0);
      AppMethodBeat.o(187666);
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