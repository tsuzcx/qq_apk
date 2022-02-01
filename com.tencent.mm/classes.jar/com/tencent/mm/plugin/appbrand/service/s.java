package com.tencent.mm.plugin.appbrand.service;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import java.util.List;

@com.tencent.mm.kernel.b.e(Dr=c.class)
public abstract interface s
  extends a
{
  public abstract String XA(String paramString);
  
  public abstract com.tencent.mm.vending.g.e<WxaAttributes> XB(String paramString);
  
  public abstract WxaAttributes Xy(String paramString);
  
  public abstract WxaAttributes Xz(String paramString);
  
  public abstract void a(String paramString, a parama);
  
  public abstract void b(String paramString, a parama);
  
  public abstract void c(String paramString, a parama);
  
  public abstract void cZ(List<String> paramList);
  
  public static abstract interface a
  {
    public abstract void onGetWeAppInfo(WxaAttributes paramWxaAttributes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.s
 * JD-Core Version:    0.7.0.1
 */