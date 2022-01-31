package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.ui.ak;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e<C extends c>
  extends s<C>
{
  public static final int CTRL_INDEX = 40;
  public static final String NAME = "getSystemInfo";
  
  public final String a(C paramC, JSONObject paramJSONObject)
  {
    return h("ok", g(paramC));
  }
  
  public Map<String, Object> g(C paramC)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("brand", Build.BRAND);
    localHashMap.put("model", Build.MODEL);
    localHashMap.put("system", "Android " + Build.VERSION.RELEASE);
    DisplayMetrics localDisplayMetrics = paramC.getContext().getResources().getDisplayMetrics();
    localHashMap.put("pixelRatio", Float.valueOf(localDisplayMetrics.density));
    localHashMap.put("screenWidth", Integer.valueOf(h.mx(localDisplayMetrics.widthPixels)));
    localHashMap.put("screenHeight", Integer.valueOf(h.mx(localDisplayMetrics.heightPixels)));
    localHashMap.put("statusBarHeight", Integer.valueOf(h.mx(ak.gy(paramC.getContext()))));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.e
 * JD-Core Version:    0.7.0.1
 */