package com.tencent.mm.plugin.appbrand.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private final Map<String, List<Object>> sjN;
  
  private a()
  {
    AppMethodBeat.i(140790);
    this.sjN = new HashMap();
    AppMethodBeat.o(140790);
  }
  
  private void agc(String paramString)
  {
    AppMethodBeat.i(317231);
    paramString = (List)this.sjN.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(317231);
      return;
    }
    int i = 0;
    while (i < paramString.size())
    {
      paramString.get(i);
      i += 1;
    }
    AppMethodBeat.o(317231);
  }
  
  public final void Q(String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(140792);
    new Object() {};
    agc(paramString1);
    AppMethodBeat.o(140792);
  }
  
  public final void a(String paramString1, final String paramString2, final b.b paramb)
  {
    AppMethodBeat.i(140791);
    new Object() {};
    agc(paramString1);
    AppMethodBeat.o(140791);
  }
  
  static final class a
  {
    private static final a tVr;
    
    static
    {
      AppMethodBeat.i(140789);
      tVr = new a((byte)0);
      AppMethodBeat.o(140789);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.a
 * JD-Core Version:    0.7.0.1
 */