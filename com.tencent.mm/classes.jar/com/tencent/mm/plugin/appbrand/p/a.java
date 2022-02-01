package com.tencent.mm.plugin.appbrand.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;

public abstract interface a
{
  public abstract void a(String paramString, b paramb);
  
  public abstract void a(String paramString, b paramb, a parama);
  
  public abstract String akH(String paramString);
  
  public abstract boolean cbE();
  
  public static abstract interface a
  {
    public abstract void b(WxaPkgLoadProgress paramWxaPkgLoadProgress);
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
        paramb.a(a.d.qhp);
      }
      AppMethodBeat.o(176556);
    }
    
    public final void a(String paramString, a.b paramb, a.a parama)
    {
      AppMethodBeat.i(243527);
      a(paramString, paramb);
      AppMethodBeat.o(243527);
    }
    
    public final String akH(String paramString)
    {
      return "__APP__";
    }
    
    public final boolean cbE()
    {
      return false;
    }
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(134931);
      qhp = new d("OK", 0);
      qhq = new d("FAIL", 1);
      qhr = new d("CANCEL", 2);
      qhs = new d("MODULE_NOT_FOUND", 3);
      qht = new d[] { qhp, qhq, qhr, qhs };
      AppMethodBeat.o(134931);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.a
 * JD-Core Version:    0.7.0.1
 */