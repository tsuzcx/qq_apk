package com.tencent.mm.plugin.appbrand.jsapi.pay;

import java.util.Map;

public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public static abstract interface a
  {
    public abstract void o(String paramString, Map<String, Object> paramMap);
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, String paramString, Map<String, Object> paramMap);
  }
  
  public static abstract interface c
    extends a.b
  {
    public abstract void b(int paramInt, String paramString, Map<String, Object> paramMap);
  }
  
  public static abstract interface d
  {
    public abstract void p(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.a
 * JD-Core Version:    0.7.0.1
 */