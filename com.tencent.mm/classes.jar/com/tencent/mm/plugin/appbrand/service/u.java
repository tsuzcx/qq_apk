package com.tencent.mm.plugin.appbrand.service;

import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.plugin.appbrand.appcache.bd;

@e(c.class)
public abstract interface u
  extends a
{
  public abstract void a(String paramString, int paramInt, b paramb, a parama);
  
  public abstract void r(String paramString1, String paramString2, int paramInt);
  
  public static abstract interface a
  {
    public abstract void onError(int paramInt, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void a(bd parambd, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.u
 * JD-Core Version:    0.7.0.1
 */