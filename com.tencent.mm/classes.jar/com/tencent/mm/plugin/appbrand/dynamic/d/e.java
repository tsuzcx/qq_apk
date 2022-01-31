package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.mm.aa.c.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.b;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import org.json.JSONObject;

public final class e
  extends b
{
  public e(int paramInt)
  {
    super("getSystemInfoSync", paramInt);
  }
  
  protected final JSONObject a(a parama)
  {
    Context localContext = parama.getContext();
    parama = parama.CD();
    DisplayMetrics localDisplayMetrics = localContext.getResources().getDisplayMetrics();
    float f = localDisplayMetrics.density;
    HashMap localHashMap = new HashMap();
    localHashMap.put("model", q.zl());
    localHashMap.put("pixelRatio", Float.valueOf(f));
    localHashMap.put("windowWidth", Integer.valueOf(h.mx(parama.getInt("__page_view_width", 0))));
    localHashMap.put("windowHeight", Integer.valueOf(h.mx(parama.getInt("__page_view_height", 0))));
    localHashMap.put("screenWidth", Integer.valueOf(h.mx(localDisplayMetrics.widthPixels)));
    localHashMap.put("screenHeight", Integer.valueOf(h.mx(localDisplayMetrics.heightPixels)));
    localHashMap.put("language", x.fB(localContext));
    localHashMap.put("version", com.tencent.mm.sdk.platformtools.e.ag(null, d.spa));
    localHashMap.put("system", "Android " + Build.VERSION.RELEASE);
    return new JSONObject(localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.e
 * JD-Core Version:    0.7.0.1
 */