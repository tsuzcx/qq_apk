package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
{
  public abstract String OY(String paramString);
  
  public abstract void a(String paramString, b paramb);
  
  public abstract void a(String paramString, b paramb, a parama);
  
  public abstract boolean bpc();
  
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
    public final String OY(String paramString)
    {
      return "__APP__";
    }
    
    public void a(String paramString, a.b paramb)
    {
      AppMethodBeat.i(176556);
      if (paramb != null) {
        paramb.a(a.d.lvn);
      }
      AppMethodBeat.o(176556);
    }
    
    public final void a(String paramString, a.b paramb, a.a parama)
    {
      AppMethodBeat.i(193400);
      a(paramString, paramb);
      AppMethodBeat.o(193400);
    }
    
    public final boolean bpc()
    {
      return false;
    }
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(134931);
      lvn = new d("OK", 0);
      lvo = new d("FAIL", 1);
      lvp = new d("CANCEL", 2);
      lvq = new d("MODULE_NOT_FOUND", 3);
      lvr = new d[] { lvn, lvo, lvp, lvq };
      AppMethodBeat.o(134931);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.a
 * JD-Core Version:    0.7.0.1
 */