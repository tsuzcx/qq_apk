package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.z.b.b.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public d(int paramInt)
  {
    super("getSystemInfo", paramInt);
  }
  
  public final void a(com.tencent.mm.z.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(10830);
    paramJSONObject = parama.getContext();
    parama = parama.Qx();
    DisplayMetrics localDisplayMetrics = paramJSONObject.getResources().getDisplayMetrics();
    float f = localDisplayMetrics.density;
    HashMap localHashMap = new HashMap();
    localHashMap.put("model", Build.MODEL);
    localHashMap.put("pixelRatio", Float.valueOf(f));
    localHashMap.put("windowWidth", Integer.valueOf(com.tencent.mm.plugin.appbrand.s.g.pN(parama.getInt("__page_view_width", 0))));
    localHashMap.put("windowHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.s.g.pN(parama.getInt("__page_view_height", 0))));
    localHashMap.put("screenWidth", Integer.valueOf(com.tencent.mm.plugin.appbrand.s.g.pN(localDisplayMetrics.widthPixels)));
    localHashMap.put("screenHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.s.g.pN(localDisplayMetrics.heightPixels)));
    localHashMap.put("language", aa.gP(paramJSONObject));
    localHashMap.put("version", com.tencent.mm.sdk.platformtools.g.au(null, com.tencent.mm.protocal.d.whH));
    localHashMap.put("system", "Android " + Build.VERSION.RELEASE);
    parama1.aj(a(true, "", localHashMap));
    AppMethodBeat.o(10830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.d
 * JD-Core Version:    0.7.0.1
 */