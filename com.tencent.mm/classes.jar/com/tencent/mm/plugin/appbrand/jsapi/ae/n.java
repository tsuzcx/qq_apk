package com.tencent.mm.plugin.appbrand.jsapi.ae;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import kotlin.a.ak;
import kotlin.g.b.s;
import org.json.JSONObject;

public class n<C extends f>
  extends ab<C>
{
  public static final int CTRL_INDEX = 40;
  public static final String NAME = "getSystemInfo";
  private final c<C> swW;
  
  public n()
  {
    this(null);
  }
  
  public n(c<C> paramc)
  {
    this.swW = paramc;
  }
  
  public final String a(C paramC, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137670);
    long l = Util.currentTicks();
    try
    {
      localObject = this.swW;
      if (localObject == null)
      {
        paramJSONObject = null;
        if (paramJSONObject == null) {
          break label167;
        }
        bool = true;
        label30:
        localObject = paramJSONObject;
        if (paramJSONObject != null) {}
      }
    }
    finally
    {
      Object localObject;
      boolean bool = false;
      Log.i("MicroMsg.JsApiGetSystemInfo", "invoke cost:%dms, byNewImpl?:%b", new Object[] { Long.valueOf(Util.currentTicks() - l), Boolean.valueOf(bool) });
      AppMethodBeat.o(137670);
    }
    try
    {
      localObject = a(paramC);
      paramC = m("ok", (Map)localObject);
      Log.i("MicroMsg.JsApiGetSystemInfo", "invoke cost:%dms, byNewImpl?:%b", new Object[] { Long.valueOf(Util.currentTicks() - l), Boolean.valueOf(bool) });
      AppMethodBeat.o(137670);
      return paramC;
    }
    finally
    {
      break label177;
      i = 1;
    }
    localObject = this.swW;
    s.u(paramC, "component");
    if (paramJSONObject == null) {}
    for (paramJSONObject = null;; paramJSONObject = paramJSONObject.optString("type"))
    {
      CharSequence localCharSequence = (CharSequence)paramJSONObject;
      if (localCharSequence == null) {
        break;
      }
      if (localCharSequence.length() != 0) {
        break label230;
      }
      break;
    }
    label167:
    label177:
    label230:
    label233:
    for (;;)
    {
      localObject = ((c)localObject).a(paramJSONObject, paramC);
      paramJSONObject = (JSONObject)localObject;
      if (localObject != null) {
        break;
      }
      paramJSONObject = ak.kkZ();
      break;
      bool = false;
      break label30;
      for (;;)
      {
        if (i == 0) {
          break label233;
        }
        paramJSONObject = null;
        break;
        int i = 0;
      }
    }
  }
  
  protected Map<String, Object> a(C paramC)
  {
    AppMethodBeat.i(137671);
    HashMap localHashMap = new HashMap();
    localHashMap.put("brand", Build.BRAND);
    localHashMap.put("model", q.aPo());
    localHashMap.put("abi", Build.CPU_ABI);
    localHashMap.put("system", "Android " + Build.VERSION.RELEASE);
    paramC = paramC.getContext().getResources().getDisplayMetrics();
    localHashMap.put("pixelRatio", Float.valueOf(paramC.density));
    localHashMap.put("screenWidth", Integer.valueOf(i.DA(paramC.widthPixels)));
    localHashMap.put("screenHeight", Integer.valueOf(i.DA(paramC.heightPixels)));
    AppMethodBeat.o(137671);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.n
 * JD-Core Version:    0.7.0.1
 */