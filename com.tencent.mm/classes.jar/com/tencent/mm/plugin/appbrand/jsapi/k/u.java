package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.r;
import com.tencent.mm.plugin.appbrand.jsapi.p;
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
  
  private void a(f paramf, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(234556);
    a(paramf, paramInt, h(paramString, null), paramString.equals("ok"), paramBoolean);
    AppMethodBeat.o(234556);
  }
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(234554);
    super.a(paramf, paramJSONObject, paramInt);
    paramf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(234551);
        u.this.e(paramf, paramJSONObject, paramInt);
        AppMethodBeat.o(234551);
      }
    };
    m.bZn().postToWorker(paramf);
    AppMethodBeat.o(234554);
  }
  
  protected final void e(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(234555);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiMoveMapMarkerAlong", "data is invalid, err");
      a(paramf, paramInt, "fail:invalid data", false);
      AppMethodBeat.o(234555);
      return;
    }
    Log.d("MicroMsg.JsApiMoveMapMarkerAlong", "data:%s", new Object[] { paramJSONObject.toString() });
    final com.tencent.mm.plugin.appbrand.jsapi.k.a.b localb = h(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiMoveMapMarkerAlong", "mapView is null, return");
      a(paramf, paramInt, String.format("fail:internal error %s", new Object[] { "mapview is null" }), false);
      AppMethodBeat.o(234555);
      return;
    }
    String str1 = paramJSONObject.optString("markerId");
    try
    {
      long l = paramJSONObject.optLong("duration", 0L);
      if (l == 0L)
      {
        Log.e("MicroMsg.JsApiMoveMapMarkerAlong", "duration is zero, err return");
        a(paramf, paramInt, "fail:invalid data", false);
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
        public final void bGP()
        {
          AppMethodBeat.i(234553);
          u.a(u.this, paramf, paramInt, "cancel", localb.bGX());
          AppMethodBeat.o(234553);
        }
        
        public final void hv(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(234552);
          Log.i("MicroMsg.JsApiMoveMapMarkerAlong", "moveMapMarkerAlong onMarkerTranslate result::%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            u.a(u.this, paramf, paramInt, "ok", localb.bGX());
            AppMethodBeat.o(234552);
            return;
          }
          u.a(u.this, paramf, paramInt, "fail", localb.bGX());
          AppMethodBeat.o(234552);
        }
      });
      AppMethodBeat.o(234555);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.e("MicroMsg.JsApiMoveMapMarkerAlong", "parse data error, exception : %s", new Object[] { paramJSONObject });
      a(paramf, paramInt, String.format("fail:internal error %s", new Object[] { "parse json fail" }), localb.bGX());
      AppMethodBeat.o(234555);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.u
 * JD-Core Version:    0.7.0.1
 */