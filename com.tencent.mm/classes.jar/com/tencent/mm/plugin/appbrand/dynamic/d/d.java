package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.k;
import java.util.HashMap;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public d(int paramInt)
  {
    super("getSystemInfo", paramInt);
  }
  
  public final void a(com.tencent.mm.aa.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121310);
    paramJSONObject = parama.getContext();
    parama = parama.aiA();
    DisplayMetrics localDisplayMetrics = paramJSONObject.getResources().getDisplayMetrics();
    float f = localDisplayMetrics.density;
    HashMap localHashMap = new HashMap();
    localHashMap.put("model", Build.MODEL);
    localHashMap.put("pixelRatio", Float.valueOf(f));
    localHashMap.put("windowWidth", Integer.valueOf(g.vN(parama.getInt("__page_view_width", 0))));
    localHashMap.put("windowHeight", Integer.valueOf(g.vN(parama.getInt("__page_view_height", 0))));
    localHashMap.put("screenWidth", Integer.valueOf(g.vN(localDisplayMetrics.widthPixels)));
    localHashMap.put("screenHeight", Integer.valueOf(g.vN(localDisplayMetrics.heightPixels)));
    localHashMap.put("language", ad.iR(paramJSONObject));
    localHashMap.put("version", k.aD(null, com.tencent.mm.protocal.d.FFH));
    localHashMap.put("system", "Android " + Build.VERSION.RELEASE);
    parama1.bk(a(true, "", localHashMap));
    AppMethodBeat.o(121310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.d
 * JD-Core Version:    0.7.0.1
 */