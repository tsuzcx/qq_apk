package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.by;

public abstract interface h
  extends g
{
  public static final h lqT = new h()
  {
    public final boolean My(String paramAnonymousString)
    {
      return false;
    }
    
    public final void a(ae paramAnonymousae1, ae paramAnonymousae2, by paramAnonymousby) {}
    
    public final h.a bmv()
    {
      return null;
    }
    
    public final void d(ae paramAnonymousae) {}
    
    public final void e(ae paramAnonymousae) {}
    
    public final h.a q(ae paramAnonymousae)
    {
      return null;
    }
  };
  
  public abstract boolean My(String paramString);
  
  public abstract a bmv();
  
  public abstract a q(ae paramae);
  
  public static final class a
  {
    int lqU;
    public h.c lqV;
    public h.b lqW;
    public String path;
    
    a(ae paramae)
    {
      AppMethodBeat.i(48118);
      this.lqU = paramae.hashCode();
      this.path = paramae.kWX;
      AppMethodBeat.o(48118);
    }
  }
  
  public static final class b
  {
    public String path;
    
    b(String paramString)
    {
      this.path = paramString;
    }
  }
  
  public static final class c
  {
    public String path;
    public int type;
    
    c(int paramInt, String paramString)
    {
      this.type = paramInt;
      this.path = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.h
 * JD-Core Version:    0.7.0.1
 */