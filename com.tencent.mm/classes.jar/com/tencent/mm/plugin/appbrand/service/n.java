package com.tencent.mm.plugin.appbrand.service;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import java.util.List;

@com.tencent.mm.kernel.b.e(c.class)
public abstract interface n
  extends a
{
  public abstract WxaAttributes Nt(String paramString);
  
  public abstract WxaAttributes Nu(String paramString);
  
  public abstract com.tencent.mm.vending.g.e<WxaAttributes> Nv(String paramString);
  
  public abstract void a(String paramString, a parama);
  
  public abstract void b(String paramString, a parama);
  
  public abstract void bd(List<String> paramList);
  
  public static abstract interface a
  {
    public abstract void b(WxaAttributes paramWxaAttributes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.n
 * JD-Core Version:    0.7.0.1
 */