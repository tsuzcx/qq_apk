package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.g;
import org.json.JSONObject;

public abstract interface c
{
  public abstract void a(g paramg, String paramString1, int paramInt, String paramString2, a parama, JSONObject paramJSONObject, HalfScreenConfig paramHalfScreenConfig, c.c paramc);
  
  public abstract void a(g paramg, String paramString1, int paramInt, String paramString2, a parama, JSONObject paramJSONObject, c.c paramc);
  
  public static final class a
  {
    public String businessType;
    public String hzx;
    public int icZ;
    public String ida;
    public String qYG;
    public int scene;
    public String shW;
    public int sourceType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c
 * JD-Core Version:    0.7.0.1
 */