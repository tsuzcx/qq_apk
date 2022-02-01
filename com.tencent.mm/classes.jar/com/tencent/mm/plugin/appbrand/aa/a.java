package com.tencent.mm.plugin.appbrand.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private final Map<String, List<Object>> pew;
  
  private a()
  {
    AppMethodBeat.i(140790);
    this.pew = new HashMap();
    AppMethodBeat.o(140790);
  }
  
  private void amS(String paramString)
  {
    AppMethodBeat.i(242980);
    paramString = (List)this.pew.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(242980);
      return;
    }
    int i = 0;
    while (i < paramString.size())
    {
      paramString.get(i);
      i += 1;
    }
    AppMethodBeat.o(242980);
  }
  
  public final void L(String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(140792);
    new Object() {};
    amS(paramString1);
    AppMethodBeat.o(140792);
  }
  
  public final void a(String paramString1, final String paramString2, final b.b paramb)
  {
    AppMethodBeat.i(140791);
    new Object() {};
    amS(paramString1);
    AppMethodBeat.o(140791);
  }
  
  static final class a
  {
    private static final a qQB;
    
    static
    {
      AppMethodBeat.i(140789);
      qQB = new a((byte)0);
      AppMethodBeat.o(140789);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.a
 * JD-Core Version:    0.7.0.1
 */