package com.tencent.mm.plugin.appbrand.jsapi.ab;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class j<C extends e>
  extends aa<C>
{
  public static final int CTRL_INDEX = 40;
  public static final String NAME = "getSystemInfo";
  
  public final String a(C paramC, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137670);
    paramC = m("ok", a(paramC));
    AppMethodBeat.o(137670);
    return paramC;
  }
  
  protected Map<String, Object> a(C paramC)
  {
    AppMethodBeat.i(137671);
    HashMap localHashMap = new HashMap();
    localHashMap.put("brand", Build.BRAND);
    localHashMap.put("model", Build.MODEL);
    localHashMap.put("abi", Build.CPU_ABI);
    localHashMap.put("system", "Android " + Build.VERSION.RELEASE);
    paramC = paramC.getContext().getResources().getDisplayMetrics();
    localHashMap.put("pixelRatio", Float.valueOf(paramC.density));
    localHashMap.put("screenWidth", Integer.valueOf(g.Dg(paramC.widthPixels)));
    localHashMap.put("screenHeight", Integer.valueOf(g.Dg(paramC.heightPixels)));
    AppMethodBeat.o(137671);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.j
 * JD-Core Version:    0.7.0.1
 */