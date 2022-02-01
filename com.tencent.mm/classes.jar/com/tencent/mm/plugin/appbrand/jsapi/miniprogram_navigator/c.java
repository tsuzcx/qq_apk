package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.d;
import org.json.JSONObject;

public abstract interface c
{
  public abstract void a(d paramd, String paramString1, int paramInt, String paramString2, a parama, JSONObject paramJSONObject, c paramc);
  
  public static final class a
  {
    public String businessType;
    public String cYP;
    public int dxE;
    public String dxF;
    public String jDS;
    public String kzK;
    public int scene;
    public int sourceType;
  }
  
  public static abstract interface b
  {
    public abstract void cancel();
    
    public abstract void proceed();
  }
  
  public static abstract interface c
  {
    public abstract void l(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c
 * JD-Core Version:    0.7.0.1
 */