package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.ca;

public abstract interface h
  extends g
{
  public static final h qKS = new h()
  {
    public final void a(ah paramAnonymousah1, ah paramAnonymousah2, ca paramAnonymousca) {}
    
    public final boolean amH(String paramAnonymousString)
    {
      return false;
    }
    
    public final h.a chR()
    {
      return null;
    }
    
    public final void e(ah paramAnonymousah) {}
    
    public final void f(ah paramAnonymousah) {}
    
    public final h.a q(ah paramAnonymousah)
    {
      return null;
    }
  };
  
  public abstract boolean amH(String paramString);
  
  public abstract a chR();
  
  public abstract a q(ah paramah);
  
  public static final class a
  {
    int fDk;
    public String path;
    public h.c qKT;
    public h.b qKU;
    
    a(ah paramah)
    {
      AppMethodBeat.i(48118);
      this.fDk = paramah.hashCode();
      this.path = paramah.qoI;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.h
 * JD-Core Version:    0.7.0.1
 */