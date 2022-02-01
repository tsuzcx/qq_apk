package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.r;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class af
  extends b
{
  public static final int CTRL_INDEX = 200;
  public static final String NAME = "translateMapMarker";
  private List<Runnable> kPF;
  private AtomicBoolean kPG;
  
  public af()
  {
    AppMethodBeat.i(143695);
    this.kPF = new ArrayList();
    this.kPG = new AtomicBoolean(false);
    AppMethodBeat.o(143695);
  }
  
  private void a(c paramc, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(143699);
    a(paramc, paramInt, e(paramString, null), paramString.equals("ok"), paramBoolean);
    this.kPG.set(false);
    bkK();
    AppMethodBeat.o(143699);
  }
  
  private void bkK()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(143697);
        if (this.kPG.get())
        {
          AppMethodBeat.o(143697);
          return;
        }
        if (this.kPF.size() == 0)
        {
          AppMethodBeat.o(143697);
          continue;
        }
        localRunnable = (Runnable)this.kPF.remove(0);
      }
      finally {}
      Runnable localRunnable;
      if (localRunnable != null) {
        com.tencent.mm.plugin.appbrand.z.m.bBp().postToWorker(localRunnable);
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
        af.this.e(paramc, paramJSONObject, paramInt);
        AppMethodBeat.o(143693);
      }
    };
    this.kPF.add(paramc);
    bkK();
    AppMethodBeat.o(143696);
  }
  
  protected final void e(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(143698);
    this.kPG.set(true);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiTranslateMapMarker", "data is invalid, err");
      a(paramc, paramInt, "fail:invalid data", false);
      AppMethodBeat.o(143698);
      return;
    }
    ad.d("MicroMsg.JsApiTranslateMapMarker", "data:%s", new Object[] { paramJSONObject.toString() });
    final com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
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
          b.h localh = new b.h();
          localh.duration = ((JSONObject)localObject).optInt("duration", 0);
          if (localh.duration == 0)
          {
            ad.e("MicroMsg.JsApiTranslateMapMarker", "keyFrame.duration is zero, err continue");
          }
          else
          {
            localh.kRD = ((float)((JSONObject)localObject).optDouble("rotate", 0.0D));
            String str2 = ((JSONObject)localObject).optString("latitude");
            if (!bt.isNullOrNil(str2)) {
              localh.latitude = bt.getDouble(str2, 0.0D);
            }
            localObject = ((JSONObject)localObject).optString("longitude");
            if (!bt.isNullOrNil((String)localObject)) {
              localh.longitude = bt.getDouble((String)localObject, 0.0D);
            }
            localLinkedList.add(localh);
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        ad.e("MicroMsg.JsApiTranslateMapMarker", "parse keyFrames error, exception : %s", new Object[] { paramJSONObject });
        a(paramc, paramInt, String.format("fail:internal error %s", new Object[] { "parse json fail" }), localb.bkR());
        AppMethodBeat.o(143698);
        return;
      }
      localb.a(str1, localLinkedList, new b.r()
      {
        public final void bkJ() {}
        
        public final void gz(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(143694);
          ad.i("MicroMsg.JsApiTranslateMapMarker", "onMarkerTranslate result::%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            af.a(af.this, paramc, paramInt, "ok", localb.bkR());
            AppMethodBeat.o(143694);
            return;
          }
          af.a(af.this, paramc, paramInt, "fail", localb.bkR());
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.af
 * JD-Core Version:    0.7.0.1
 */