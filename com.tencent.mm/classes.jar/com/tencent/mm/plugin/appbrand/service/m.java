package com.tencent.mm.plugin.appbrand.service;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import java.util.List;

@com.tencent.mm.kernel.b.e(c.class)
public abstract interface m
  extends a
{
  public abstract WxaAttributes Ka(String paramString);
  
  public abstract WxaAttributes Kb(String paramString);
  
  public abstract com.tencent.mm.vending.g.e<WxaAttributes> Kc(String paramString);
  
  public abstract void a(String paramString, a parama);
  
  public abstract void b(String paramString, a parama);
  
  public abstract void bb(List<String> paramList);
  
  public static abstract interface a
  {
    public abstract void b(WxaAttributes paramWxaAttributes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.m
 * JD-Core Version:    0.7.0.1
 */