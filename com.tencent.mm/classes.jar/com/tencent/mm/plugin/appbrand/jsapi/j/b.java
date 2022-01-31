package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.os.Handler;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class b
  extends u<c>
{
  public abstract String Ox();
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    String str = aAR();
    HashMap localHashMap = new HashMap();
    localHashMap.put(Ox(), str);
    paramc.aAP().post(new b.1(this, paramc, paramJSONObject, str));
    return j("ok", localHashMap);
  }
  
  public abstract void a(c paramc, JSONObject paramJSONObject, String paramString);
  
  public abstract String aAR();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.b
 * JD-Core Version:    0.7.0.1
 */