package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b.b.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.HashMap;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a
{
  public d(int paramInt)
  {
    super("getSystemInfo", paramInt);
  }
  
  public final void a(com.tencent.mm.ac.c.a parama, JSONObject paramJSONObject, b.a<JSONObject> parama1)
  {
    AppMethodBeat.i(121310);
    paramJSONObject = parama.getContext();
    parama = parama.aZk();
    DisplayMetrics localDisplayMetrics = paramJSONObject.getResources().getDisplayMetrics();
    float f = localDisplayMetrics.density;
    HashMap localHashMap = new HashMap();
    localHashMap.put("model", q.aPo());
    localHashMap.put("pixelRatio", Float.valueOf(f));
    localHashMap.put("windowWidth", Integer.valueOf(i.DB(parama.getInt("__page_view_width", 0))));
    localHashMap.put("windowHeight", Integer.valueOf(i.DB(parama.getInt("__page_view_height", 0))));
    localHashMap.put("screenWidth", Integer.valueOf(i.DB(localDisplayMetrics.widthPixels)));
    localHashMap.put("screenHeight", Integer.valueOf(i.DB(localDisplayMetrics.heightPixels)));
    localHashMap.put("language", LocaleUtil.getCurrentLanguage(paramJSONObject));
    localHashMap.put("version", ChannelUtil.formatVersion(null, com.tencent.mm.protocal.d.Yxh));
    localHashMap.put("system", "Android " + Build.VERSION.RELEASE);
    parama1.cN(a(true, "", localHashMap));
    AppMethodBeat.o(121310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.d
 * JD-Core Version:    0.7.0.1
 */