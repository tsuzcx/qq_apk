package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.bt;

public abstract interface h
  extends g
{
  public static final h lSO = new h()
  {
    public final boolean QH(String paramAnonymousString)
    {
      return false;
    }
    
    public final void a(ae paramAnonymousae1, ae paramAnonymousae2, bt paramAnonymousbt) {}
    
    public final h.a btr()
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
  
  public abstract boolean QH(String paramString);
  
  public abstract a btr();
  
  public abstract a q(ae paramae);
  
  public static final class a
  {
    int lSP;
    public h.c lSQ;
    public h.b lSR;
    public String path;
    
    a(ae paramae)
    {
      AppMethodBeat.i(48118);
      this.lSP = paramae.hashCode();
      this.path = paramae.lyH;
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