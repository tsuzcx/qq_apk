package com.tencent.mm.plugin.appbrand.p;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
{
  public abstract void a(String paramString, b paramb);
  
  public abstract void a(String paramString, b paramb, a parama);
  
  public abstract String acN(String paramString);
  
  public abstract boolean bPn();
  
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
    public void a(String paramString, a.b paramb)
    {
      AppMethodBeat.i(176556);
      if (paramb != null) {
        paramb.a(a.d.ngF);
      }
      AppMethodBeat.o(176556);
    }
    
    public final void a(String paramString, a.b paramb, a.a parama)
    {
      AppMethodBeat.i(219353);
      a(paramString, paramb);
      AppMethodBeat.o(219353);
    }
    
    public final String acN(String paramString)
    {
      return "__APP__";
    }
    
    public final boolean bPn()
    {
      return false;
    }
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(134931);
      ngF = new d("OK", 0);
      ngG = new d("FAIL", 1);
      ngH = new d("CANCEL", 2);
      ngI = new d("MODULE_NOT_FOUND", 3);
      ngJ = new d[] { ngF, ngG, ngH, ngI };
      AppMethodBeat.o(134931);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.a
 * JD-Core Version:    0.7.0.1
 */