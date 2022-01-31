package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.page.z;

public abstract interface h
  extends g
{
  public static final h iGQ = new h.1();
  
  public abstract boolean EH(String paramString);
  
  public abstract a aLj();
  
  public abstract a h(z paramz);
  
  public static final class a
  {
    int iGR;
    public h.c iGS;
    public h.b iGT;
    public String path;
    
    a(z paramz)
    {
      AppMethodBeat.i(132614);
      this.iGR = paramz.hashCode();
      this.path = paramz.iuB;
      AppMethodBeat.o(132614);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.h
 * JD-Core Version:    0.7.0.1
 */