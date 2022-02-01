package com.tencent.luggage.xweb_ext.extendplugin;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import java.util.Map;
import org.json.JSONObject;

public abstract interface a
{
  public abstract e QK();
  
  public abstract boolean SQ();
  
  public abstract JSONObject SR();
  
  public abstract String SS();
  
  public abstract void ST();
  
  public abstract boolean SU();
  
  public abstract void a(a.a parama);
  
  public abstract void b(a.a parama);
  
  public abstract String e(String paramString, Map<String, ? extends Object> paramMap);
  
  public abstract String er(String paramString);
  
  public abstract String getAppId();
  
  public abstract Context getContext();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.a
 * JD-Core Version:    0.7.0.1
 */