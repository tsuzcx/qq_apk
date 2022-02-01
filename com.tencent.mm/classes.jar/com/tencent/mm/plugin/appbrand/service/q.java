package com.tencent.mm.plugin.appbrand.service;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import java.util.List;

@com.tencent.mm.kernel.b.e(gf=c.class)
public abstract interface q
  extends a
{
  public abstract void a(String paramString, q.a parama);
  
  public abstract WxaAttributes aeW(String paramString);
  
  public abstract WxaAttributes aeX(String paramString);
  
  public abstract String aeY(String paramString);
  
  public abstract com.tencent.mm.vending.g.e<WxaAttributes> aeZ(String paramString);
  
  public abstract void b(String paramString, q.a parama);
  
  public abstract void bo(List<String> paramList);
  
  public abstract void c(String paramString, q.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.q
 * JD-Core Version:    0.7.0.1
 */