package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class u
  extends a
{
  public static final int CTRL_INDEX = 200;
  public static final String NAME = "translateMapMarker";
  private List<Runnable> hOd;
  private AtomicBoolean hOe;
  
  public u()
  {
    AppMethodBeat.i(93874);
    this.hOd = new ArrayList();
    this.hOe = new AtomicBoolean(false);
    AppMethodBeat.o(93874);
  }
  
  private void a(c paramc, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(93878);
    a(paramc, paramInt, j(paramString, null), paramString.equals("ok"), paramBoolean);
    this.hOe.set(false);
    aDn();
    AppMethodBeat.o(93878);
  }
  
  private void aDn()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(93876);
        if (this.hOe.get())
        {
          AppMethodBeat.o(93876);
          return;
        }
        if (this.hOd.size() == 0)
        {
          AppMethodBeat.o(93876);
          continue;
        }
        localRunnable = (Runnable)this.hOd.remove(0);
      }
      finally {}
      Runnable localRunnable;
      if (localRunnable != null) {
        com.tencent.mm.plugin.appbrand.s.m.aNS().ac(localRunnable);
      }
      AppMethodBeat.o(93876);
    }
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(93875);
    super.a(paramc, paramJSONObject, paramInt);
    paramc = new u.1(this, paramc, paramJSONObject, paramInt);
    this.hOd.add(paramc);
    aDn();
    AppMethodBeat.o(93875);
  }
  
  protected final void d(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(93877);
    this.hOe.set(true);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiTranslateMapMarker", "data is invalid, err");
      a(paramc, paramInt, "fail:invalid data", false);
      AppMethodBeat.o(93877);
      return;
    }
    ab.d("MicroMsg.JsApiTranslateMapMarker", "data:%s", new Object[] { paramJSONObject.toString() });
    b localb = f(paramc, paramJSONObject);
    if (localb == null)
    {
      ab.e("MicroMsg.JsApiTranslateMapMarker", "mapView is null, return");
      a(paramc, paramInt, String.format("fail:internal error %s", new Object[] { "mapview is null" }), false);
      AppMethodBeat.o(93877);
      return;
    }
    String str1 = paramJSONObject.optString("markerId");
    for (;;)
    {
      LinkedList localLinkedList;
      int i;
      try
      {
        paramJSONObject = new JSONArray(paramJSONObject.optString("keyFrames"));
        localLinkedList = new LinkedList();
        ab.d("MicroMsg.JsApiTranslateMapMarker", "keyFramesArray size :%d", new Object[] { Integer.valueOf(paramJSONObject.length()) });
        i = 0;
        if (i < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.get(i);
          b.g localg = new b.g();
          localg.duration = ((JSONObject)localObject).optInt("duration", 0);
          if (localg.duration == 0)
          {
            ab.e("MicroMsg.JsApiTranslateMapMarker", "keyFrame.duration is zero, err continue");
          }
          else
          {
            localg.rotate = ((float)((JSONObject)localObject).optDouble("rotate", 0.0D));
            String str2 = ((JSONObject)localObject).optString("latitude");
            if (!bo.isNullOrNil(str2)) {
              localg.latitude = bo.getFloat(str2, 0.0F);
            }
            localObject = ((JSONObject)localObject).optString("longitude");
            if (!bo.isNullOrNil((String)localObject)) {
              localg.longitude = bo.getFloat((String)localObject, 0.0F);
            }
            localLinkedList.add(localg);
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        ab.e("MicroMsg.JsApiTranslateMapMarker", "parse keyFrames error, exception : %s", new Object[] { paramJSONObject });
        a(paramc, paramInt, String.format("fail:internal error %s", new Object[] { "parse json fail" }), localb.aDx());
        AppMethodBeat.o(93877);
        return;
      }
      localb.a(str1, localLinkedList, new u.2(this, paramc, paramInt, localb));
      AppMethodBeat.o(93877);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.u
 * JD-Core Version:    0.7.0.1
 */