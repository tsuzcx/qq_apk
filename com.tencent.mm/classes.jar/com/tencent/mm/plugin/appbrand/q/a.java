package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;

public abstract interface a
{
  public abstract void a(String paramString, b paramb);
  
  public abstract void a(String paramString, b paramb, a parama, boolean paramBoolean);
  
  public abstract String adN(String paramString);
  
  public abstract boolean cBX();
  
  public static abstract interface a
  {
    public abstract void b(WxaPkgLoadProgress paramWxaPkgLoadProgress);
  }
  
  public static abstract interface b
  {
    public abstract void onLoadResult(a.d paramd);
  }
  
  public static class c
    implements a
  {
    public void a(String paramString, a.b paramb)
    {
      AppMethodBeat.i(176556);
      if (paramb != null) {
        paramb.onLoadResult(a.d.tma);
      }
      AppMethodBeat.o(176556);
    }
    
    public final void a(String paramString, a.b paramb, a.a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(321590);
      a(paramString, paramb);
      AppMethodBeat.o(321590);
    }
    
    public final String adN(String paramString)
    {
      return "__APP__";
    }
    
    public final boolean cBX()
    {
      return false;
    }
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(134931);
      tma = new d("OK", 0);
      tmb = new d("FAIL", 1);
      tmc = new d("CANCEL", 2);
      tmd = new d("MODULE_NOT_FOUND", 3);
      tme = new d[] { tma, tmb, tmc, tmd };
      AppMethodBeat.o(134931);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.a
 * JD-Core Version:    0.7.0.1
 */