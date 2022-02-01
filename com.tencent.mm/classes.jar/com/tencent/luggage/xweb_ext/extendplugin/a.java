package com.tencent.luggage.xweb_ext.extendplugin;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.Map;
import org.json.JSONObject;

public abstract interface a
{
  public abstract c Eo();
  
  public abstract boolean FI();
  
  public abstract JSONObject FJ();
  
  public abstract String FK();
  
  public abstract void FL();
  
  public abstract void a(a.a parama);
  
  public abstract void b(a.a parama);
  
  public abstract String dw(String paramString);
  
  public abstract String f(String paramString, Map<String, ? extends Object> paramMap);
  
  public abstract String getAppId();
  
  public abstract Context getContext();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.a
 * JD-Core Version:    0.7.0.1
 */