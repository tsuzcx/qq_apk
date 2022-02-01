package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
{
  public abstract String Tk(String paramString);
  
  public abstract void a(String paramString, b paramb);
  
  public abstract void a(String paramString, b paramb, a parama);
  
  public abstract boolean btM();
  
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
    public final String Tk(String paramString)
    {
      return "__APP__";
    }
    
    public void a(String paramString, a.b paramb)
    {
      AppMethodBeat.i(176556);
      if (paramb != null) {
        paramb.a(a.d.lYZ);
      }
      AppMethodBeat.o(176556);
    }
    
    public final void a(String paramString, a.b paramb, a.a parama)
    {
      AppMethodBeat.i(207779);
      a(paramString, paramb);
      AppMethodBeat.o(207779);
    }
    
    public final boolean btM()
    {
      return false;
    }
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(134931);
      lYZ = new d("OK", 0);
      lZa = new d("FAIL", 1);
      lZb = new d("CANCEL", 2);
      lZc = new d("MODULE_NOT_FOUND", 3);
      lZd = new d[] { lYZ, lZa, lZb, lZc };
      AppMethodBeat.o(134931);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.a
 * JD-Core Version:    0.7.0.1
 */