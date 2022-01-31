package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.os.Handler;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class b
  extends s<c>
{
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    String str = ajy();
    HashMap localHashMap = new HashMap();
    localHashMap.put(ajz(), str);
    paramc.ahL().post(new b.1(this, paramc, paramJSONObject, str));
    return h("ok", localHashMap);
  }
  
  public abstract void a(c paramc, JSONObject paramJSONObject, String paramString);
  
  public abstract String ajy();
  
  public abstract String ajz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.b
 * JD-Core Version:    0.7.0.1
 */