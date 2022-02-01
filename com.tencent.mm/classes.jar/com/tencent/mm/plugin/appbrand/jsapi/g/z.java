package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.p;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class z
  extends b
{
  public static final int CTRL_INDEX = 200;
  public static final String NAME = "translateMapMarker";
  private List<Runnable> jTv;
  private AtomicBoolean jTw;
  
  public z()
  {
    AppMethodBeat.i(143695);
    this.jTv = new ArrayList();
    this.jTw = new AtomicBoolean(false);
    AppMethodBeat.o(143695);
  }
  
  private void a(c paramc, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(143699);
    a(paramc, paramInt, e(paramString, null), paramString.equals("ok"), paramBoolean);
    this.jTw.set(false);
    bam();
    AppMethodBeat.o(143699);
  }
  
  private void bam()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(143697);
        if (this.jTw.get())
        {
          AppMethodBeat.o(143697);
          return;
        }
        if (this.jTv.size() == 0)
        {
          AppMethodBeat.o(143697);
          continue;
        }
        localRunnable = (Runnable)this.jTv.remove(0);
      }
      finally {}
      Runnable localRunnable;
      if (localRunnable != null) {
        l.bqm().postToWorker(localRunnable);
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
        z.this.e(paramc, paramJSONObject, paramInt);
        AppMethodBeat.o(143693);
      }
    };
    this.jTv.add(paramc);
    bam();
    AppMethodBeat.o(143696);
  }
  
  protected final void e(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(143698);
    this.jTw.set(true);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiTranslateMapMarker", "data is invalid, err");
      a(paramc, paramInt, "fail:invalid data", false);
      AppMethodBeat.o(143698);
      return;
    }
    ad.d("MicroMsg.JsApiTranslateMapMarker", "data:%s", new Object[] { paramJSONObject.toString() });
    final com.tencent.mm.plugin.appbrand.jsapi.g.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiTranslateMapMarker", "mapView is null, return");
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
        ad.d("MicroMsg.JsApiTranslateMapMarker", "keyFramesArray size :%d", new Object[] { Integer.valueOf(paramJSONObject.length()) });
        i = 0;
        if (i < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.get(i);
          b.g localg = new b.g();
          localg.duration = ((JSONObject)localObject).optInt("duration", 0);
          if (localg.duration == 0)
          {
            ad.e("MicroMsg.JsApiTranslateMapMarker", "keyFrame.duration is zero, err continue");
          }
          else
          {
            localg.jUQ = ((float)((JSONObject)localObject).optDouble("rotate", 0.0D));
            String str2 = ((JSONObject)localObject).optString("latitude");
            if (!bt.isNullOrNil(str2)) {
              localg.latitude = bt.getDouble(str2, 0.0D);
            }
            localObject = ((JSONObject)localObject).optString("longitude");
            if (!bt.isNullOrNil((String)localObject)) {
              localg.longitude = bt.getDouble((String)localObject, 0.0D);
            }
            localLinkedList.add(localg);
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        ad.e("MicroMsg.JsApiTranslateMapMarker", "parse keyFrames error, exception : %s", new Object[] { paramJSONObject });
        a(paramc, paramInt, String.format("fail:internal error %s", new Object[] { "parse json fail" }), localb.bat());
        AppMethodBeat.o(143698);
        return;
      }
      localb.a(str1, localLinkedList, new b.p()
      {
        public final void bal() {}
        
        public final void fX(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(143694);
          ad.i("MicroMsg.JsApiTranslateMapMarker", "onMarkerTranslate result::%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            z.a(z.this, paramc, paramInt, "ok", localb.bat());
            AppMethodBeat.o(143694);
            return;
          }
          z.a(z.this, paramc, paramInt, "fail", localb.bat());
          AppMethodBeat.o(143694);
        }
      });
      AppMethodBeat.o(143698);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.z
 * JD-Core Version:    0.7.0.1
 */