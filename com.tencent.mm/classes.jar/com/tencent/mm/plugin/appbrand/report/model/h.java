package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.bs;

public abstract interface h
  extends g
{
  public static final h msF = new h()
  {
    public final boolean Un(String paramAnonymousString)
    {
      return false;
    }
    
    public final void a(ae paramAnonymousae1, ae paramAnonymousae2, bs paramAnonymousbs) {}
    
    public final h.a bxw()
    {
      return null;
    }
    
    public final void d(ae paramAnonymousae) {}
    
    public final void e(ae paramAnonymousae) {}
    
    public final h.a r(ae paramAnonymousae)
    {
      return null;
    }
  };
  
  public abstract boolean Un(String paramString);
  
  public abstract a bxw();
  
  public abstract a r(ae paramae);
  
  public static final class a
  {
    int dsf;
    public h.c msG;
    public h.b msH;
    public String path;
    
    a(ae paramae)
    {
      AppMethodBeat.i(48118);
      this.dsf = paramae.hashCode();
      this.path = paramae.lYf;
      AppMethodBeat.o(48118);
    }
  }
  
  public static final class c
  {
    public String path;
    public int type;
    
    c(int paramInt)
    {
      this(paramInt, null);
    }
    
    c(int paramInt, String paramString)
    {
      this.type = paramInt;
      this.path = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.h
 * JD-Core Version:    0.7.0.1
 */