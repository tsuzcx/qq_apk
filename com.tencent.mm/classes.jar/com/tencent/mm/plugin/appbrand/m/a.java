package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
{
  public abstract String SB(String paramString);
  
  public abstract void a(String paramString, b paramb);
  
  public abstract void a(String paramString, b paramb, a parama);
  
  public abstract boolean btb();
  
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
    public final String SB(String paramString)
    {
      return "__APP__";
    }
    
    public void a(String paramString, a.b paramb)
    {
      AppMethodBeat.i(176556);
      if (paramb != null) {
        paramb.a(a.d.lUw);
      }
      AppMethodBeat.o(176556);
    }
    
    public final void a(String paramString, a.b paramb, a.a parama)
    {
      AppMethodBeat.i(197293);
      a(paramString, paramb);
      AppMethodBeat.o(197293);
    }
    
    public final boolean btb()
    {
      return false;
    }
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(134931);
      lUw = new d("OK", 0);
      lUx = new d("FAIL", 1);
      lUy = new d("CANCEL", 2);
      lUz = new d("MODULE_NOT_FOUND", 3);
      lUA = new d[] { lUw, lUx, lUy, lUz };
      AppMethodBeat.o(134931);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.a
 * JD-Core Version:    0.7.0.1
 */