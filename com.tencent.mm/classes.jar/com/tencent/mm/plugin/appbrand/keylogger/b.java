package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  final Map<String, List<com.tencent.mm.plugin.appbrand.keylogger.base.b>> kBk;
  
  private b()
  {
    AppMethodBeat.i(200995);
    this.kBk = new HashMap();
    AppMethodBeat.o(200995);
  }
  
  final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(200997);
    paramString = (List)this.kBk.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(200997);
      return;
    }
    int i = 0;
    while (i < paramString.size())
    {
      paramb.a((com.tencent.mm.plugin.appbrand.keylogger.base.b)paramString.get(i));
      i += 1;
    }
    AppMethodBeat.o(200997);
  }
  
  public final void a(String paramString1, final String paramString2, final a parama, final long paramLong)
  {
    AppMethodBeat.i(200996);
    a(paramString1, new b()
    {
      public final void a(com.tencent.mm.plugin.appbrand.keylogger.base.b paramAnonymousb)
      {
        AppMethodBeat.i(200992);
        paramAnonymousb.b(paramString2, parama, paramLong);
        AppMethodBeat.o(200992);
      }
    });
    AppMethodBeat.o(200996);
  }
  
  static final class a
  {
    private static final b lfS;
    
    static
    {
      AppMethodBeat.i(200994);
      lfS = new b((byte)0);
      AppMethodBeat.o(200994);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(com.tencent.mm.plugin.appbrand.keylogger.base.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.b
 * JD-Core Version:    0.7.0.1
 */