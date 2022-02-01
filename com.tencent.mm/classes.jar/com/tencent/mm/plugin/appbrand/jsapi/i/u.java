package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.r;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
    AppMethodBeat.i(186153);
    a(paramc, paramInt, e(paramString, null), paramString.equals("ok"), paramBoolean);
    AppMethodBeat.o(186153);
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(186151);
    super.a(paramc, paramJSONObject, paramInt);
    paramc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186148);
        u.this.e(paramc, paramJSONObject, paramInt);
        AppMethodBeat.o(186148);
      }
    };
    com.tencent.mm.plugin.appbrand.z.m.bBp().postToWorker(paramc);
    AppMethodBeat.o(186151);
  }
  
  protected final void e(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(186152);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiMoveMapMarkerAlong", "data is invalid, err");
      a(paramc, paramInt, "fail:invalid data", false);
      AppMethodBeat.o(186152);
      return;
    }
    ad.d("MicroMsg.JsApiMoveMapMarkerAlong", "data:%s", new Object[] { paramJSONObject.toString() });
    final com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiMoveMapMarkerAlong", "mapView is null, return");
      a(paramc, paramInt, String.format("fail:internal error %s", new Object[] { "mapview is null" }), false);
      AppMethodBeat.o(186152);
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
        localArrayList.add(new b.i(d1, d2));
        i += 1;
      }
      localb.a(str1, localArrayList, l, bool, new b.r()
      {
        public final void bkJ()
        {
          AppMethodBeat.i(186150);
          u.a(u.this, paramc, paramInt, "cancel", localb.bkR());
          AppMethodBeat.o(186150);
        }
        
        public final void gz(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(186149);
          ad.i("MicroMsg.JsApiMoveMapMarkerAlong", "moveMapMarkerAlong onMarkerTranslate result::%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            u.a(u.this, paramc, paramInt, "ok", localb.bkR());
            AppMethodBeat.o(186149);
            return;
          }
          u.a(u.this, paramc, paramInt, "fail", localb.bkR());
          AppMethodBeat.o(186149);
        }
      });
      AppMethodBeat.o(186152);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ad.e("MicroMsg.JsApiMoveMapMarkerAlong", "parse data error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, String.format("fail:internal error %s", new Object[] { "parse json fail" }), localb.bkR());
      AppMethodBeat.o(186152);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.u
 * JD-Core Version:    0.7.0.1
 */