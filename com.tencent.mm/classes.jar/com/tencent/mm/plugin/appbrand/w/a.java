package com.tencent.mm.plugin.appbrand.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private final Map<String, List<Object>> lba;
  
  private a()
  {
    AppMethodBeat.i(140790);
    this.lba = new HashMap();
    AppMethodBeat.o(140790);
  }
  
  private void Vg(String paramString)
  {
    AppMethodBeat.i(220897);
    paramString = (List)this.lba.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(220897);
      return;
    }
    int i = 0;
    while (i < paramString.size())
    {
      paramString.get(i);
      i += 1;
    }
    AppMethodBeat.o(220897);
  }
  
  public final void K(String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(140792);
    new Object() {};
    Vg(paramString1);
    AppMethodBeat.o(140792);
  }
  
  public final void a(String paramString1, final String paramString2, final b.b paramb)
  {
    AppMethodBeat.i(140791);
    new Object() {};
    Vg(paramString1);
    AppMethodBeat.o(140791);
  }
  
  static final class a
  {
    private static final a mBV;
    
    static
    {
      AppMethodBeat.i(140789);
      mBV = new a((byte)0);
      AppMethodBeat.o(140789);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.a
 * JD-Core Version:    0.7.0.1
 */