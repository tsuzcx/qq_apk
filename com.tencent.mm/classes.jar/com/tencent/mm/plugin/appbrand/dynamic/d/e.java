package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.z.c.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class e
  extends b
{
  public e(int paramInt)
  {
    super("getSystemInfoSync", paramInt);
  }
  
  public final JSONObject a(a parama)
  {
    AppMethodBeat.i(10831);
    Context localContext = parama.getContext();
    parama = parama.Qx();
    DisplayMetrics localDisplayMetrics = localContext.getResources().getDisplayMetrics();
    float f = localDisplayMetrics.density;
    HashMap localHashMap = new HashMap();
    localHashMap.put("model", Build.MODEL);
    localHashMap.put("pixelRatio", Float.valueOf(f));
    localHashMap.put("windowWidth", Integer.valueOf(com.tencent.mm.plugin.appbrand.s.g.pN(parama.getInt("__page_view_width", 0))));
    localHashMap.put("windowHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.s.g.pN(parama.getInt("__page_view_height", 0))));
    localHashMap.put("screenWidth", Integer.valueOf(com.tencent.mm.plugin.appbrand.s.g.pN(localDisplayMetrics.widthPixels)));
    localHashMap.put("screenHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.s.g.pN(localDisplayMetrics.heightPixels)));
    localHashMap.put("language", aa.gP(localContext));
    localHashMap.put("version", com.tencent.mm.sdk.platformtools.g.au(null, d.whH));
    localHashMap.put("system", "Android " + Build.VERSION.RELEASE);
    parama = new JSONObject(localHashMap);
    AppMethodBeat.o(10831);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.e
 * JD-Core Version:    0.7.0.1
 */