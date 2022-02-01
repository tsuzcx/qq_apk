package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.br;
import com.tencent.mm.plugin.appbrand.page.z;

public abstract interface h
  extends g
{
  public static final h mxC = new h()
  {
    public final boolean UY(String paramAnonymousString)
    {
      return false;
    }
    
    public final void a(ad paramAnonymousad1, ad paramAnonymousad2, br paramAnonymousbr) {}
    
    public final h.a byp()
    {
      return null;
    }
    
    public final void d(ad paramAnonymousad) {}
    
    public final void e(ad paramAnonymousad) {}
    
    public final h.a s(ad paramAnonymousad)
    {
      return null;
    }
  };
  
  public abstract boolean UY(String paramString);
  
  public abstract a byp();
  
  public abstract a s(ad paramad);
  
  public static final class a
  {
    int dtl;
    public h.c mxD;
    public h.b mxE;
    public String path;
    
    a(ad paramad)
    {
      AppMethodBeat.i(48118);
      this.dtl = paramad.hashCode();
      this.path = paramad.mcM;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.h
 * JD-Core Version:    0.7.0.1
 */