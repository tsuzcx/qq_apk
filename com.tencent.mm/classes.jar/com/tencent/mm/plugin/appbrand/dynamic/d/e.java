package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
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
    AppMethodBeat.i(121311);
    Context localContext = parama.getContext();
    parama = parama.aZk();
    DisplayMetrics localDisplayMetrics = localContext.getResources().getDisplayMetrics();
    float f = localDisplayMetrics.density;
    HashMap localHashMap = new HashMap();
    localHashMap.put("model", q.aPo());
    localHashMap.put("pixelRatio", Float.valueOf(f));
    localHashMap.put("windowWidth", Integer.valueOf(i.DB(parama.getInt("__page_view_width", 0))));
    localHashMap.put("windowHeight", Integer.valueOf(i.DB(parama.getInt("__page_view_height", 0))));
    localHashMap.put("screenWidth", Integer.valueOf(i.DB(localDisplayMetrics.widthPixels)));
    localHashMap.put("screenHeight", Integer.valueOf(i.DB(localDisplayMetrics.heightPixels)));
    localHashMap.put("language", LocaleUtil.getCurrentLanguage(localContext));
    localHashMap.put("version", ChannelUtil.formatVersion(null, d.Yxh));
    localHashMap.put("system", "Android " + Build.VERSION.RELEASE);
    parama = new JSONObject(localHashMap);
    AppMethodBeat.o(121311);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.e
 * JD-Core Version:    0.7.0.1
 */