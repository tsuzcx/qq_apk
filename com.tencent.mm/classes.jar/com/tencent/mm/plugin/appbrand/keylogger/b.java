package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  final Map<String, List<com.tencent.mm.plugin.appbrand.keylogger.base.b>> lba;
  
  private b()
  {
    AppMethodBeat.i(201234);
    this.lba = new HashMap();
    AppMethodBeat.o(201234);
  }
  
  final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(201236);
    paramString = (List)this.lba.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(201236);
      return;
    }
    int i = 0;
    while (i < paramString.size())
    {
      paramb.a((com.tencent.mm.plugin.appbrand.keylogger.base.b)paramString.get(i));
      i += 1;
    }
    AppMethodBeat.o(201236);
  }
  
  public final void a(String paramString1, final String paramString2, final a parama, final long paramLong)
  {
    AppMethodBeat.i(201235);
    a(paramString1, new b()
    {
      public final void a(com.tencent.mm.plugin.appbrand.keylogger.base.b paramAnonymousb)
      {
        AppMethodBeat.i(201231);
        paramAnonymousb.b(paramString2, parama, paramLong);
        AppMethodBeat.o(201231);
      }
    });
    AppMethodBeat.o(201235);
  }
  
  static final class a
  {
    private static final b lHp;
    
    static
    {
      AppMethodBeat.i(201233);
      lHp = new b((byte)0);
      AppMethodBeat.o(201233);
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