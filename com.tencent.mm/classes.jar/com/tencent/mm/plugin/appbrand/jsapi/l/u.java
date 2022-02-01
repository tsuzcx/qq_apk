package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.b.r;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class u
  extends b
{
  public static final int CTRL_INDEX = 200;
  public static final String NAME = "moveMapMarkerAlong";
  
  private void a(e parame, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(192530);
    a(parame, paramInt, h(paramString, null), paramString.equals("ok"), paramBoolean);
    AppMethodBeat.o(192530);
  }
  
  public final void a(final e parame, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(192521);
    super.a(parame, paramJSONObject, paramInt);
    parame = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192767);
        u.this.d(parame, paramJSONObject, paramInt);
        AppMethodBeat.o(192767);
      }
    };
    m.clV().postToWorker(parame);
    AppMethodBeat.o(192521);
  }
  
  protected final void d(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(192528);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiMoveMapMarkerAlong", "data is invalid, err");
      a(parame, paramInt, "fail:invalid data", false);
      AppMethodBeat.o(192528);
      return;
    }
    Log.d("MicroMsg.JsApiMoveMapMarkerAlong", "data:%s", new Object[] { paramJSONObject.toString() });
    final com.tencent.mm.plugin.appbrand.jsapi.l.a.b localb = g(parame, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiMoveMapMarkerAlong", "mapView is null, return");
      a(parame, paramInt, String.format("fail:internal error %s", new Object[] { "mapview is null" }), false);
      AppMethodBeat.o(192528);
      return;
    }
    String str1 = paramJSONObject.optString("markerId");
    try
    {
      long l = paramJSONObject.optLong("duration", 0L);
      if (l == 0L)
      {
        Log.e("MicroMsg.JsApiMoveMapMarkerAlong", "duration is zero, err return");
        a(parame, paramInt, "fail:invalid data", false);
      }
      boolean bool = paramJSONObject.optBoolean("autoRotate", false);
      paramJSONObject = paramJSONObject.getJSONArray("path");
      ArrayList localArrayList = new ArrayList();
      Log.d("MicroMsg.JsApiMoveMapMarkerAlong", "path size :%d", new Object[] { Integer.valueOf(paramJSONObject.length()) });
      int i = 0;
      while (i < paramJSONObject.length())
      {
        Object localObject = (JSONObject)paramJSONObject.get(i);
        String str2 = ((JSONObject)localObject).optString("latitude");
        double d1 = 0.0D;
        double d2 = 0.0D;
        if (!Util.isNullOrNil(str2)) {
          d1 = Util.getDouble(str2, 0.0D);
        }
        localObject = ((JSONObject)localObject).optString("longitude");
        if (!Util.isNullOrNil((String)localObject)) {
          d2 = Util.getDouble((String)localObject, 0.0D);
        }
        localArrayList.add(new b.i(d1, d2));
        i += 1;
      }
      localb.a(str1, localArrayList, l, bool, new b.r()
      {
        public final void bSx()
        {
          AppMethodBeat.i(193059);
          u.a(u.this, parame, paramInt, "cancel", localb.bSF());
          AppMethodBeat.o(193059);
        }
        
        public final void il(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(193056);
          Log.i("MicroMsg.JsApiMoveMapMarkerAlong", "moveMapMarkerAlong onMarkerTranslate result::%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            u.a(u.this, parame, paramInt, "ok", localb.bSF());
            AppMethodBeat.o(193056);
            return;
          }
          u.a(u.this, parame, paramInt, "fail", localb.bSF());
          AppMethodBeat.o(193056);
        }
      });
      AppMethodBeat.o(192528);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.e("MicroMsg.JsApiMoveMapMarkerAlong", "parse data error, exception : %s", new Object[] { paramJSONObject });
      a(parame, paramInt, String.format("fail:internal error %s", new Object[] { "parse json fail" }), localb.bSF());
      AppMethodBeat.o(192528);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.u
 * JD-Core Version:    0.7.0.1
 */