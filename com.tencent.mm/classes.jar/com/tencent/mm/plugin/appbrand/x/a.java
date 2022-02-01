package com.tencent.mm.plugin.appbrand.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  public final Map<String, List<c>> kBk;
  
  private a()
  {
    AppMethodBeat.i(140790);
    this.kBk = new HashMap();
    AppMethodBeat.o(140790);
  }
  
  private void a(String paramString, b paramb)
  {
    AppMethodBeat.i(140793);
    paramString = (List)this.kBk.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(140793);
      return;
    }
    int i = 0;
    while (i < paramString.size())
    {
      paramb.a((c)paramString.get(i));
      i += 1;
    }
    AppMethodBeat.o(140793);
  }
  
  public final void K(String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(140792);
    a(paramString1, new b()
    {
      public final void a(c paramAnonymousc)
      {
        AppMethodBeat.i(140788);
        paramAnonymousc.ed(paramString2, paramString3);
        AppMethodBeat.o(140788);
      }
    });
    AppMethodBeat.o(140792);
  }
  
  public final void a(String paramString1, final String paramString2, final b.b paramb)
  {
    AppMethodBeat.i(140791);
    a(paramString1, new b()
    {
      public final void a(c paramAnonymousc)
      {
        AppMethodBeat.i(140787);
        paramAnonymousc.a(paramString2, paramb, this.lfR);
        AppMethodBeat.o(140787);
      }
    });
    AppMethodBeat.o(140791);
  }
  
  public static final class a
  {
    private static final a lXj;
    
    static
    {
      AppMethodBeat.i(140789);
      lXj = new a((byte)0);
      AppMethodBeat.o(140789);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.x.a
 * JD-Core Version:    0.7.0.1
 */