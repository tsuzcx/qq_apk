package com.tencent.mm.plugin.appbrand.service;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import java.util.List;

@com.tencent.mm.kernel.b.e(c.class)
public abstract interface i
  extends a
{
  public abstract WxaAttributes Ae(String paramString);
  
  public abstract WxaAttributes Af(String paramString);
  
  public abstract com.tencent.mm.vending.g.e<WxaAttributes> Ag(String paramString);
  
  public abstract void a(String paramString, i.a parama);
  
  public abstract void aC(List<String> paramList);
  
  public abstract void b(String paramString, i.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.i
 * JD-Core Version:    0.7.0.1
 */