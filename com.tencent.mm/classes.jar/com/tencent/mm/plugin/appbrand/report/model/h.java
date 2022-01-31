package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.mm.plugin.appbrand.page.s;

public abstract interface h
  extends g
{
  public static final h gYz = new h.1();
  
  public abstract a aok();
  
  public abstract a g(s params);
  
  public abstract boolean wd(String paramString);
  
  public static final class a
  {
    int gYA;
    public h.c gYB;
    public h.b gYC;
    public String path;
    
    a(s params)
    {
      this.gYA = params.hashCode();
      this.path = params.ahc();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.h
 * JD-Core Version:    0.7.0.1
 */