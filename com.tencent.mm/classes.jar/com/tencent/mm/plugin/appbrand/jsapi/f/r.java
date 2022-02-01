package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.p;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
    AppMethodBeat.i(205029);
    a(paramc, paramInt, e(paramString, null), paramString.equals("ok"), paramBoolean);
    AppMethodBeat.o(205029);
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(205027);
    super.a(paramc, paramJSONObject, paramInt);
    paramc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205024);
        r.this.e(paramc, paramJSONObject, paramInt);
        AppMethodBeat.o(205024);
      }
    };
    l.bxj().postToWorker(paramc);
    AppMethodBeat.o(205027);
  }
  
  protected final void e(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(205028);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiMoveMapMarkerAlong", "data is invalid, err");
      a(paramc, paramInt, "fail:invalid data", false);
      AppMethodBeat.o(205028);
      return;
    }
    ac.d("MicroMsg.JsApiMoveMapMarkerAlong", "data:%s", new Object[] { paramJSONObject.toString() });
    final com.tencent.mm.plugin.appbrand.jsapi.f.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ac.e("MicroMsg.JsApiMoveMapMarkerAlong", "mapView is null, return");
      a(paramc, paramInt, String.format("fail:internal error %s", new Object[] { "mapview is null" }), false);
      AppMethodBeat.o(205028);
      return;
    }
    String str1 = paramJSONObject.optString("markerId");
    try
    {
      long l = paramJSONObject.optLong("duration", 0L);
      if (l == 0L)
      {
        ac.e("MicroMsg.JsApiMoveMapMarkerAlong", "duration is zero, err return");
        a(paramc, paramInt, "fail:invalid data", false);
      }
      boolean bool = paramJSONObject.optBoolean("autoRotate", false);
      paramJSONObject = paramJSONObject.getJSONArray("path");
      ArrayList localArrayList = new ArrayList();
      ac.d("MicroMsg.JsApiMoveMapMarkerAlong", "path size :%d", new Object[] { Integer.valueOf(paramJSONObject.length()) });
      int i = 0;
      while (i < paramJSONObject.length())
      {
        Object localObject = (JSONObject)paramJSONObject.get(i);
        String str2 = ((JSONObject)localObject).optString("latitude");
        double d1 = 0.0D;
        double d2 = 0.0D;
        if (!bs.isNullOrNil(str2)) {
          d1 = bs.getDouble(str2, 0.0D);
        }
        localObject = ((JSONObject)localObject).optString("longitude");
        if (!bs.isNullOrNil((String)localObject)) {
          d2 = bs.getDouble((String)localObject, 0.0D);
        }
        localArrayList.add(new b.h(d1, d2));
        i += 1;
      }
      localb.a(str1, localArrayList, l, bool, new b.p()
      {
        public final void bhe()
        {
          AppMethodBeat.i(205026);
          r.a(r.this, paramc, paramInt, "cancel", localb.bhm());
          AppMethodBeat.o(205026);
        }
        
        public final void gt(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(205025);
          ac.i("MicroMsg.JsApiMoveMapMarkerAlong", "moveMapMarkerAlong onMarkerTranslate result::%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            r.a(r.this, paramc, paramInt, "ok", localb.bhm());
            AppMethodBeat.o(205025);
            return;
          }
          r.a(r.this, paramc, paramInt, "fail", localb.bhm());
          AppMethodBeat.o(205025);
        }
      });
      AppMethodBeat.o(205028);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ac.e("MicroMsg.JsApiMoveMapMarkerAlong", "parse data error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, String.format("fail:internal error %s", new Object[] { "parse json fail" }), localb.bhm());
      AppMethodBeat.o(205028);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.r
 * JD-Core Version:    0.7.0.1
 */