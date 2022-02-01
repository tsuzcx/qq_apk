package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.r;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class u
  extends b
{
  public static final int CTRL_INDEX = 200;
  public static final String NAME = "moveMapMarkerAlong";
  
  private void a(c paramc, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(206468);
    a(paramc, paramInt, e(paramString, null), paramString.equals("ok"), paramBoolean);
    AppMethodBeat.o(206468);
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(206466);
    super.a(paramc, paramJSONObject, paramInt);
    paramc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206463);
        u.this.e(paramc, paramJSONObject, paramInt);
        AppMethodBeat.o(206463);
      }
    };
    com.tencent.mm.plugin.appbrand.y.m.bCj().postToWorker(paramc);
    AppMethodBeat.o(206466);
  }
  
  protected final void e(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(206467);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiMoveMapMarkerAlong", "data is invalid, err");
      a(paramc, paramInt, "fail:invalid data", false);
      AppMethodBeat.o(206467);
      return;
    }
    ae.d("MicroMsg.JsApiMoveMapMarkerAlong", "data:%s", new Object[] { paramJSONObject.toString() });
    final com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ae.e("MicroMsg.JsApiMoveMapMarkerAlong", "mapView is null, return");
      a(paramc, paramInt, String.format("fail:internal error %s", new Object[] { "mapview is null" }), false);
      AppMethodBeat.o(206467);
      return;
    }
    String str1 = paramJSONObject.optString("markerId");
    try
    {
      long l = paramJSONObject.optLong("duration", 0L);
      if (l == 0L)
      {
        ae.e("MicroMsg.JsApiMoveMapMarkerAlong", "duration is zero, err return");
        a(paramc, paramInt, "fail:invalid data", false);
      }
      boolean bool = paramJSONObject.optBoolean("autoRotate", false);
      paramJSONObject = paramJSONObject.getJSONArray("path");
      ArrayList localArrayList = new ArrayList();
      ae.d("MicroMsg.JsApiMoveMapMarkerAlong", "path size :%d", new Object[] { Integer.valueOf(paramJSONObject.length()) });
      int i = 0;
      while (i < paramJSONObject.length())
      {
        Object localObject = (JSONObject)paramJSONObject.get(i);
        String str2 = ((JSONObject)localObject).optString("latitude");
        double d1 = 0.0D;
        double d2 = 0.0D;
        if (!bu.isNullOrNil(str2)) {
          d1 = bu.getDouble(str2, 0.0D);
        }
        localObject = ((JSONObject)localObject).optString("longitude");
        if (!bu.isNullOrNil((String)localObject)) {
          d2 = bu.getDouble((String)localObject, 0.0D);
        }
        localArrayList.add(new b.i(d1, d2));
        i += 1;
      }
      localb.a(str1, localArrayList, l, bool, new b.r()
      {
        public final void blt()
        {
          AppMethodBeat.i(206465);
          u.a(u.this, paramc, paramInt, "cancel", localb.blB());
          AppMethodBeat.o(206465);
        }
        
        public final void gy(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(206464);
          ae.i("MicroMsg.JsApiMoveMapMarkerAlong", "moveMapMarkerAlong onMarkerTranslate result::%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            u.a(u.this, paramc, paramInt, "ok", localb.blB());
            AppMethodBeat.o(206464);
            return;
          }
          u.a(u.this, paramc, paramInt, "fail", localb.blB());
          AppMethodBeat.o(206464);
        }
      });
      AppMethodBeat.o(206467);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ae.e("MicroMsg.JsApiMoveMapMarkerAlong", "parse data error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, String.format("fail:internal error %s", new Object[] { "parse json fail" }), localb.blB());
      AppMethodBeat.o(206467);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.u
 * JD-Core Version:    0.7.0.1
 */