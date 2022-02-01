package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.cb;

public abstract interface j
  extends i
{
  public static final j tPx = new j()
  {
    public final void a(ah paramAnonymousah1, ah paramAnonymousah2, cb paramAnonymouscb) {}
    
    public final boolean afT(String paramAnonymousString)
    {
      return false;
    }
    
    public final j.a cIM()
    {
      return null;
    }
    
    public final void e(ah paramAnonymousah) {}
    
    public final void f(ah paramAnonymousah) {}
    
    public final j.a s(ah paramAnonymousah)
    {
      return null;
    }
  };
  
  public abstract boolean afT(String paramString);
  
  public abstract a cIM();
  
  public abstract a s(ah paramah);
  
  public static final class a
  {
    int hIa;
    public String path;
    public j.c tPy;
    public j.b tPz;
    
    a(ah paramah)
    {
      AppMethodBeat.i(48118);
      this.hIa = paramah.hashCode();
      this.path = paramah.cEE();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.j
 * JD-Core Version:    0.7.0.1
 */