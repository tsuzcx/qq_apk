package com.tencent.mm.plugin.appbrand.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private final Map<String, List<Object>> kXr;
  
  private a()
  {
    AppMethodBeat.i(140790);
    this.kXr = new HashMap();
    AppMethodBeat.o(140790);
  }
  
  private void Uv(String paramString)
  {
    AppMethodBeat.i(192322);
    paramString = (List)this.kXr.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(192322);
      return;
    }
    int i = 0;
    while (i < paramString.size())
    {
      paramString.get(i);
      i += 1;
    }
    AppMethodBeat.o(192322);
  }
  
  public final void J(String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(140792);
    new Object() {};
    Uv(paramString1);
    AppMethodBeat.o(140792);
  }
  
  public final void a(String paramString1, final String paramString2, final b.b paramb)
  {
    AppMethodBeat.i(140791);
    new Object() {};
    Uv(paramString1);
    AppMethodBeat.o(140791);
  }
  
  static final class a
  {
    private static final a mwY;
    
    static
    {
      AppMethodBeat.i(140789);
      mwY = new a((byte)0);
      AppMethodBeat.o(140789);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.x.a
 * JD-Core Version:    0.7.0.1
 */