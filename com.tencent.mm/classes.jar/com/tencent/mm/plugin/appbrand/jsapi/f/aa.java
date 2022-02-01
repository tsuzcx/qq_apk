package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.p;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class aa
  extends b
{
  public static final int CTRL_INDEX = 200;
  public static final String NAME = "translateMapMarker";
  private List<Runnable> kuh;
  private AtomicBoolean kui;
  
  public aa()
  {
    AppMethodBeat.i(143695);
    this.kuh = new ArrayList();
    this.kui = new AtomicBoolean(false);
    AppMethodBeat.o(143695);
  }
  
  private void a(c paramc, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(143699);
    a(paramc, paramInt, e(paramString, null), paramString.equals("ok"), paramBoolean);
    this.kui.set(false);
    bhf();
    AppMethodBeat.o(143699);
  }
  
  private void bhf()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(143697);
        if (this.kui.get())
        {
          AppMethodBeat.o(143697);
          return;
        }
        if (this.kuh.size() == 0)
        {
          AppMethodBeat.o(143697);
          continue;
        }
        localRunnable = (Runnable)this.kuh.remove(0);
      }
      finally {}
      Runnable localRunnable;
      if (localRunnable != null) {
        l.bxj().postToWorker(localRunnable);
      }
      AppMethodBeat.o(143697);
    }
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(143696);
    super.a(paramc, paramJSONObject, paramInt);
    paramc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143693);
        aa.this.e(paramc, paramJSONObject, paramInt);
        AppMethodBeat.o(143693);
      }
    };
    this.kuh.add(paramc);
    bhf();
    AppMethodBeat.o(143696);
  }
  
  protected final void e(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(143698);
    this.kui.set(true);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiTranslateMapMarker", "data is invalid, err");
      a(paramc, paramInt, "fail:invalid data", false);
      AppMethodBeat.o(143698);
      return;
    }
    ac.d("MicroMsg.JsApiTranslateMapMarker", "data:%s", new Object[] { paramJSONObject.toString() });
    final com.tencent.mm.plugin.appbrand.jsapi.f.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ac.e("MicroMsg.JsApiTranslateMapMarker", "mapView is null, return");
      a(paramc, paramInt, String.format("fail:internal error %s", new Object[] { "mapview is null" }), false);
      AppMethodBeat.o(143698);
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
        ac.d("MicroMsg.JsApiTranslateMapMarker", "keyFramesArray size :%d", new Object[] { Integer.valueOf(paramJSONObject.length()) });
        i = 0;
        if (i < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.get(i);
          b.g localg = new b.g();
          localg.duration = ((JSONObject)localObject).optInt("duration", 0);
          if (localg.duration == 0)
          {
            ac.e("MicroMsg.JsApiTranslateMapMarker", "keyFrame.duration is zero, err continue");
          }
          else
          {
            localg.kvB = ((float)((JSONObject)localObject).optDouble("rotate", 0.0D));
            String str2 = ((JSONObject)localObject).optString("latitude");
            if (!bs.isNullOrNil(str2)) {
              localg.latitude = bs.getDouble(str2, 0.0D);
            }
            localObject = ((JSONObject)localObject).optString("longitude");
            if (!bs.isNullOrNil((String)localObject)) {
              localg.longitude = bs.getDouble((String)localObject, 0.0D);
            }
            localLinkedList.add(localg);
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        ac.e("MicroMsg.JsApiTranslateMapMarker", "parse keyFrames error, exception : %s", new Object[] { paramJSONObject });
        a(paramc, paramInt, String.format("fail:internal error %s", new Object[] { "parse json fail" }), localb.bhm());
        AppMethodBeat.o(143698);
        return;
      }
      localb.a(str1, localLinkedList, new b.p()
      {
        public final void bhe() {}
        
        public final void gt(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(143694);
          ac.i("MicroMsg.JsApiTranslateMapMarker", "onMarkerTranslate result::%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            aa.a(aa.this, paramc, paramInt, "ok", localb.bhm());
            AppMethodBeat.o(143694);
            return;
          }
          aa.a(aa.this, paramc, paramInt, "fail", localb.bhm());
          AppMethodBeat.o(143694);
        }
      });
      AppMethodBeat.o(143698);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.aa
 * JD-Core Version:    0.7.0.1
 */