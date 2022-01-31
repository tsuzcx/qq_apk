package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class g<C extends c>
  extends u<C>
{
  public static final int CTRL_INDEX = 40;
  public static final String NAME = "getSystemInfo";
  
  public final String a(C paramC, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126415);
    paramC = j("ok", a(paramC));
    AppMethodBeat.o(126415);
    return paramC;
  }
  
  protected Map<String, Object> a(C paramC)
  {
    AppMethodBeat.i(126416);
    HashMap localHashMap = new HashMap();
    localHashMap.put("brand", Build.BRAND);
    localHashMap.put("model", Build.MODEL);
    localHashMap.put("system", "Android " + Build.VERSION.RELEASE);
    paramC = paramC.getContext().getResources().getDisplayMetrics();
    localHashMap.put("pixelRatio", Float.valueOf(paramC.density));
    localHashMap.put("screenWidth", Integer.valueOf(com.tencent.mm.plugin.appbrand.s.g.pM(paramC.widthPixels)));
    localHashMap.put("screenHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.s.g.pM(paramC.heightPixels)));
    AppMethodBeat.o(126416);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.g
 * JD-Core Version:    0.7.0.1
 */