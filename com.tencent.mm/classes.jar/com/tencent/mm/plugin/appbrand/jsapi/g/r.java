package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.p;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class r
  extends b
{
  public static final int CTRL_INDEX = 200;
  public static final String NAME = "moveMapMarkerAlong";
  
  private void a(c paramc, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(195155);
    a(paramc, paramInt, e(paramString, null), paramString.equals("ok"), paramBoolean);
    AppMethodBeat.o(195155);
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(195153);
    super.a(paramc, paramJSONObject, paramInt);
    paramc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195150);
        r.this.e(paramc, paramJSONObject, paramInt);
        AppMethodBeat.o(195150);
      }
    };
    l.bqm().postToWorker(paramc);
    AppMethodBeat.o(195153);
  }
  
  protected final void e(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(195154);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiMoveMapMarkerAlong", "data is invalid, err");
      a(paramc, paramInt, "fail:invalid data", false);
      AppMethodBeat.o(195154);
      return;
    }
    ad.d("MicroMsg.JsApiMoveMapMarkerAlong", "data:%s", new Object[] { paramJSONObject.toString() });
    final com.tencent.mm.plugin.appbrand.jsapi.g.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiMoveMapMarkerAlong", "mapView is null, return");
      a(paramc, paramInt, String.format("fail:internal error %s", new Object[] { "mapview is null" }), false);
      AppMethodBeat.o(195154);
      return;
    }
    String str1 = paramJSONObject.optString("markerId");
    try
    {
      long l = paramJSONObject.optLong("duration", 0L);
      if (l == 0L)
      {
        ad.e("MicroMsg.JsApiMoveMapMarkerAlong", "duration is zero, err return");
        a(paramc, paramInt, "fail:invalid data", false);
      }
      boolean bool = paramJSONObject.optBoolean("autoRotate", false);
      paramJSONObject = paramJSONObject.getJSONArray("path");
      ArrayList localArrayList = new ArrayList();
      ad.d("MicroMsg.JsApiMoveMapMarkerAlong", "path size :%d", new Object[] { Integer.valueOf(paramJSONObject.length()) });
      int i = 0;
      while (i < paramJSONObject.length())
      {
        Object localObject = (JSONObject)paramJSONObject.get(i);
        String str2 = ((JSONObject)localObject).optString("latitude");
        double d1 = 0.0D;
        double d2 = 0.0D;
        if (!bt.isNullOrNil(str2)) {
          d1 = bt.getDouble(str2, 0.0D);
        }
        localObject = ((JSONObject)localObject).optString("longitude");
        if (!bt.isNullOrNil((String)localObject)) {
          d2 = bt.getDouble((String)localObject, 0.0D);
        }
        localArrayList.add(new b.h(d1, d2));
        i += 1;
      }
      localb.a(str1, localArrayList, l, bool, new b.p()
      {
        public final void bal()
        {
          AppMethodBeat.i(195152);
          r.a(r.this, paramc, paramInt, "cancel", localb.bat());
          AppMethodBeat.o(195152);
        }
        
        public final void fX(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(195151);
          ad.i("MicroMsg.JsApiMoveMapMarkerAlong", "moveMapMarkerAlong onMarkerTranslate result::%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            r.a(r.this, paramc, paramInt, "ok", localb.bat());
            AppMethodBeat.o(195151);
            return;
          }
          r.a(r.this, paramc, paramInt, "fail", localb.bat());
          AppMethodBeat.o(195151);
        }
      });
      AppMethodBeat.o(195154);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ad.e("MicroMsg.JsApiMoveMapMarkerAlong", "parse data error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, String.format("fail:internal error %s", new Object[] { "parse json fail" }), localb.bat());
      AppMethodBeat.o(195154);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.r
 * JD-Core Version:    0.7.0.1
 */