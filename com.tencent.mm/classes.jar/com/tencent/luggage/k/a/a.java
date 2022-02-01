package com.tencent.luggage.k.a;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.Map;
import org.json.JSONObject;

public abstract interface a
{
  public abstract c Dj();
  
  public abstract boolean EA();
  
  public abstract JSONObject EB();
  
  public abstract String EC();
  
  public abstract void ED();
  
  public abstract void a(a.a parama);
  
  public abstract void b(a.a parama);
  
  public abstract String cD(String paramString);
  
  public abstract String d(String paramString, Map<String, ? extends Object> paramMap);
  
  public abstract String getAppId();
  
  public abstract Context getContext();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.k.a.a
 * JD-Core Version:    0.7.0.1
 */