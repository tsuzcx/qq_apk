package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.bx;

public abstract interface h
  extends g
{
  public static final h nIG = new h()
  {
    public final void a(ag paramAnonymousag1, ag paramAnonymousag2, bx paramAnonymousbx) {}
    
    public final boolean aeN(String paramAnonymousString)
    {
      return false;
    }
    
    public final h.a bUH()
    {
      return null;
    }
    
    public final void d(ag paramAnonymousag) {}
    
    public final void e(ag paramAnonymousag) {}
    
    public final h.a s(ag paramAnonymousag)
    {
      return null;
    }
  };
  
  public abstract boolean aeN(String paramString);
  
  public abstract a bUH();
  
  public abstract a s(ag paramag);
  
  public static final class a
  {
    int dKv;
    public h.c nIH;
    public h.b nII;
    public String path;
    
    a(ag paramag)
    {
      AppMethodBeat.i(48118);
      this.dKv = paramag.hashCode();
      this.path = paramag.nna;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.h
 * JD-Core Version:    0.7.0.1
 */