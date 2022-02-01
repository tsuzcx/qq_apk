package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
{
  public abstract String KR(String paramString);
  
  public abstract void a(String paramString, b paramb);
  
  public abstract void a(String paramString, b paramb, a parama);
  
  public abstract boolean bii();
  
  public static abstract interface a
  {
    public abstract void b(c paramc);
  }
  
  public static abstract interface b
  {
    public abstract void a(a.d paramd);
  }
  
  public static class c
    implements a
  {
    public final String KR(String paramString)
    {
      return "__APP__";
    }
    
    public void a(String paramString, a.b paramb)
    {
      AppMethodBeat.i(176556);
      if (paramb != null) {
        paramb.a(a.d.kTI);
      }
      AppMethodBeat.o(176556);
    }
    
    public final void a(String paramString, a.b paramb, a.a parama)
    {
      AppMethodBeat.i(176555);
      a(paramString, paramb);
      AppMethodBeat.o(176555);
    }
    
    public final boolean bii()
    {
      return false;
    }
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(134931);
      kTI = new d("OK", 0);
      kTJ = new d("FAIL", 1);
      kTK = new d("CANCEL", 2);
      kTL = new d("MODULE_NOT_FOUND", 3);
      kTM = new d[] { kTI, kTJ, kTK, kTL };
      AppMethodBeat.o(134931);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.a
 * JD-Core Version:    0.7.0.1
 */