package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  final Map<String, List<com.tencent.mm.plugin.appbrand.keylogger.base.b>> mgp;
  
  private b()
  {
    AppMethodBeat.i(221278);
    this.mgp = new HashMap();
    AppMethodBeat.o(221278);
  }
  
  final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(221280);
    paramString = (List)this.mgp.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(221280);
      return;
    }
    int i = 0;
    while (i < paramString.size())
    {
      paramb.a((com.tencent.mm.plugin.appbrand.keylogger.base.b)paramString.get(i));
      i += 1;
    }
    AppMethodBeat.o(221280);
  }
  
  public final void a(String paramString1, final String paramString2, final a parama, final long paramLong)
  {
    AppMethodBeat.i(221279);
    a(paramString1, new b()
    {
      public final void a(com.tencent.mm.plugin.appbrand.keylogger.base.b paramAnonymousb)
      {
        AppMethodBeat.i(221275);
        paramAnonymousb.b(paramString2, parama, paramLong);
        AppMethodBeat.o(221275);
      }
    });
    AppMethodBeat.o(221279);
  }
  
  static final class a
  {
    private static final b mPe;
    
    static
    {
      AppMethodBeat.i(221277);
      mPe = new b((byte)0);
      AppMethodBeat.o(221277);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(com.tencent.mm.plugin.appbrand.keylogger.base.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.b
 * JD-Core Version:    0.7.0.1
 */