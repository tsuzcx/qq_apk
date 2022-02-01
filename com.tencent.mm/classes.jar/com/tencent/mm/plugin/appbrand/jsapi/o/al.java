package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class al
  extends b
{
  public static final int CTRL_INDEX = 200;
  public static final String NAME = "translateMapMarker";
  private List<Runnable> sbJ;
  private AtomicBoolean sbK;
  
  public al()
  {
    AppMethodBeat.i(143695);
    this.sbJ = new ArrayList();
    this.sbK = new AtomicBoolean(false);
    AppMethodBeat.o(143695);
  }
  
  private void a(f paramf, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(143699);
    a(paramf, paramInt, ZP(paramString), paramString.equals("ok"), paramBoolean);
    this.sbK.set(false);
    csF();
    AppMethodBeat.o(143699);
  }
  
  private void csF()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(143697);
        if (this.sbK.get())
        {
          AppMethodBeat.o(143697);
          return;
        }
        if (this.sbJ.size() == 0)
        {
          AppMethodBeat.o(143697);
          continue;
        }
        localRunnable = (Runnable)this.sbJ.remove(0);
      }
      finally {}
      Runnable localRunnable;
      if (localRunnable != null) {
        o.cNm().postToWorker(localRunnable);
      }
      AppMethodBeat.o(143697);
    }
  }
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(143696);
    super.a(paramf, paramJSONObject, paramInt);
    paramf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143693);
        al.this.e(paramf, paramJSONObject, paramInt);
        AppMethodBeat.o(143693);
      }
    };
    this.sbJ.add(paramf);
    csF();
    AppMethodBeat.o(143696);
  }
  
  protected final void e(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(143698);
    this.sbK.set(true);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiTranslateMapMarker", "data is invalid, err");
      a(paramf, paramInt, "fail:invalid data", false);
      AppMethodBeat.o(143698);
      return;
    }
    Log.d("MicroMsg.JsApiTranslateMapMarker", "data:%s", new Object[] { paramJSONObject.toString() });
    final com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiTranslateMapMarker", "mapView is null, return");
      a(paramf, paramInt, String.format("fail:internal error %s", new Object[] { "mapview is null" }), false);
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
        Log.d("MicroMsg.JsApiTranslateMapMarker", "keyFramesArray size :%d", new Object[] { Integer.valueOf(paramJSONObject.length()) });
        i = 0;
        if (i < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.get(i);
          b.h localh = new b.h();
          localh.duration = ((JSONObject)localObject).optInt("duration", 0);
          if (localh.duration == 0)
          {
            Log.e("MicroMsg.JsApiTranslateMapMarker", "keyFrame.duration is zero, err continue");
          }
          else
          {
            localh.aBi = ((float)((JSONObject)localObject).optDouble("rotate", 0.0D));
            String str2 = ((JSONObject)localObject).optString("latitude");
            if (!Util.isNullOrNil(str2)) {
              localh.latitude = Util.getDouble(str2, 0.0D);
            }
            localObject = ((JSONObject)localObject).optString("longitude");
            if (!Util.isNullOrNil((String)localObject)) {
              localh.longitude = Util.getDouble((String)localObject, 0.0D);
            }
            localLinkedList.add(localh);
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        Log.e("MicroMsg.JsApiTranslateMapMarker", "parse keyFrames error, exception : %s", new Object[] { paramJSONObject });
        a(paramf, paramInt, String.format("fail:internal error %s", new Object[] { "parse json fail" }), localb.csM());
        AppMethodBeat.o(143698);
        return;
      }
      localb.a(str1, localLinkedList, new b.r()
      {
        public final void csE() {}
        
        public final void jp(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(143694);
          Log.i("MicroMsg.JsApiTranslateMapMarker", "onMarkerTranslate result::%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            al.a(al.this, paramf, paramInt, "ok", localb.csM());
            AppMethodBeat.o(143694);
            return;
          }
          al.a(al.this, paramf, paramInt, "fail", localb.csM());
          AppMethodBeat.o(143694);
        }
      });
      AppMethodBeat.o(143698);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.al
 * JD-Core Version:    0.7.0.1
 */