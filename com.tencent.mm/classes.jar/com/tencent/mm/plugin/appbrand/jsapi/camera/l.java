package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.app.Activity;
import android.content.Context;
import android.util.Size;
import android.view.View;
import com.tencent.luggage.h.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.o;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a
{
  private static final int CTRL_INDEX = 329;
  public static final String NAME = "insertCamera";
  static a jMD;
  private boolean jME;
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137472);
    int i = paramJSONObject.optInt("cameraId");
    AppMethodBeat.o(137472);
    return i;
  }
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137471);
    this.jME = false;
    Context localContext = parame.getContext();
    f localf = jMD.dj(localContext);
    int k = paramJSONObject.optInt("cameraId");
    String str1 = paramJSONObject.optString("mode", "normal");
    String str2 = paramJSONObject.optString("devicePosition", "back");
    String str3 = paramJSONObject.optString("flash", "auto");
    Object localObject = paramJSONObject.optString("size");
    int j = 288;
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        i = j;
        label155:
        boolean bool = paramJSONObject.optBoolean("needOutput", false);
        localObject = paramJSONObject.optString("resolution", "medium");
        localf.setAppId(parame.getAppId());
        localf.setPage(parame);
        localf.setCameraId(k);
        localf.setMode(str1);
        localf.an(str2, true);
        localf.setFlash(str3);
        localf.setFrameLimitSize(i);
        localf.setNeedOutput(bool);
        localf.setResolution((String)localObject);
        localObject = paramJSONObject.optJSONObject("position");
        i = com.tencent.mm.plugin.appbrand.aa.g.a((JSONObject)localObject, "width", 0);
        j = com.tencent.mm.plugin.appbrand.aa.g.a((JSONObject)localObject, "height", 0);
        if ((i != 0) && (j != 0)) {
          localf.dM(i, j);
        }
        localObject = (e)parame.K(e.class);
        if (localObject != null)
        {
          parame = ((e)localObject).p(parame);
          if ((parame != null) && (parame.length == 2) && (parame[0] > 0) && (parame[1] > 0))
          {
            localf.setDisplayScreenSize(new Size(parame[0], parame[1]));
            ad.i("MicroMsg.JsApiInsertCamera", "onInsertView screen width: %d, screen height: %d", new Object[] { Integer.valueOf(parame[0]), Integer.valueOf(parame[1]) });
          }
        }
        parame = paramJSONObject.optJSONArray("scanArea");
        if ((parame != null) && (parame.length() == 4))
        {
          ad.i("MicroMsg.JsApiInsertCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { parame, Integer.valueOf(parame.length()) });
          localf.w(com.tencent.mm.plugin.appbrand.aa.g.um(parame.optInt(0)), com.tencent.mm.plugin.appbrand.aa.g.um(parame.optInt(1)), com.tencent.mm.plugin.appbrand.aa.g.um(parame.optInt(2)), com.tencent.mm.plugin.appbrand.aa.g.um(parame.optInt(3)));
          label486:
          localf.setScanFreq(paramJSONObject.optInt("scanFreq"));
          bool = paramJSONObject.optBoolean("centerCrop");
          localf.setPreviewCenterCrop(bool);
          ad.d("MicroMsg.JsApiInsertCamera", "inflateView cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d, centerCrop: %b", new Object[] { Integer.valueOf(k), str2, str3, Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) });
          paramJSONObject = localf.getView();
          if (!"normal".equals(str1)) {
            break label705;
          }
        }
        break;
      }
      break;
    }
    label705:
    for (parame = localContext.getString(2131755283);; parame = localContext.getString(2131755284))
    {
      paramJSONObject.setContentDescription(parame);
      parame = new CoverViewContainer(localContext, (View)localf);
      AppMethodBeat.o(137471);
      return parame;
      if (!((String)localObject).equals("small")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject).equals("medium")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject).equals("large")) {
        break;
      }
      i = 2;
      break;
      i = 288;
      break label155;
      i = 480;
      break label155;
      i = 720;
      break label155;
      localf.w(0, 0, i, j);
      break label486;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, final JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.jsapi.base.g paramg)
  {
    AppMethodBeat.i(137473);
    ad.i("MicroMsg.JsApiInsertCamera", "onInsertView cameraId=%d", new Object[] { Integer.valueOf(paramInt) });
    paramView = (f)((CoverViewContainer)paramView).ax(View.class);
    if (paramView == null)
    {
      ad.e("MicroMsg.JsApiInsertCamera", "onInsertView(viewId : %d) failed, cameraView is null", new Object[] { Integer.valueOf(paramInt) });
      paramg.HQ(e("fail:internal error", null));
      AppMethodBeat.o(137473);
      return;
    }
    paramJSONObject = new WeakReference(paramView);
    final WeakReference localWeakReference = new WeakReference(parame);
    a(parame, paramView, paramg);
    a.a.aZh().a(paramView.getCameraId(), paramView);
    parame.a(paramView);
    parame.a(paramView);
    parame.a(paramView);
    com.tencent.mm.plugin.appbrand.g.a(parame.getAppId(), new g.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137469);
        f localf = (f)paramJSONObject.get();
        com.tencent.mm.plugin.appbrand.jsapi.e locale = (com.tencent.mm.plugin.appbrand.jsapi.e)localWeakReference.get();
        if ((localf != null) && (locale != null))
        {
          locale.b(localf);
          locale.b(localf);
          locale.b(localf);
          a.a.aZh().I(localf.getCameraId(), true);
          com.tencent.mm.plugin.appbrand.g.b(locale.getAppId(), this);
        }
        AppMethodBeat.o(137469);
      }
    });
    paramView.setOutPutCallBack(new b() {});
    AppMethodBeat.o(137473);
  }
  
  final boolean a(c paramc, f paramf, final com.tencent.mm.plugin.appbrand.jsapi.base.g paramg)
  {
    AppMethodBeat.i(137474);
    Object localObject = new WeakReference(paramf);
    final WeakReference localWeakReference = new WeakReference(paramc);
    o.b(String.valueOf(paramc.getAppId()), new android.support.v4.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(137470);
        f localf = (f)this.jMF.get();
        paramAnonymousArrayOfString = (c)localWeakReference.get();
        if (paramAnonymousInt == 16)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0) && (localf != null) && (paramAnonymousArrayOfString != null))
          {
            a.a.aZh().jLz = true;
            l.this.a(paramAnonymousArrayOfString, localf, paramg);
            AppMethodBeat.o(137470);
            return;
          }
          paramAnonymousArrayOfInt = new HashMap();
          if (localf != null)
          {
            paramAnonymousArrayOfInt.put("cameraId", Integer.valueOf(localf.getCameraId()));
            if (paramAnonymousArrayOfString == null) {
              break label175;
            }
            paramAnonymousArrayOfInt = new JSONObject(paramAnonymousArrayOfInt).toString();
            new i().h(paramAnonymousArrayOfString).HK(paramAnonymousArrayOfInt).aXQ();
          }
          for (;;)
          {
            a.a.aZh().jLz = false;
            AppMethodBeat.o(137470);
            return;
            ad.w("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, get Camera id fail");
            break;
            label175:
            ad.w("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, dispatch data fail");
          }
        }
        if (paramAnonymousInt == 18)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0) && (localf != null) && (paramAnonymousArrayOfString != null))
          {
            a.a.aZh().jLA = true;
            l.this.a(paramAnonymousArrayOfString, localf, paramg);
            AppMethodBeat.o(137470);
            return;
          }
          paramAnonymousArrayOfInt = new HashMap();
          if (localf == null) {
            break label322;
          }
          paramAnonymousArrayOfInt.put("cameraId", Integer.valueOf(localf.getCameraId()));
          if (paramAnonymousArrayOfString == null) {
            break label332;
          }
          paramAnonymousArrayOfInt = new JSONObject(paramAnonymousArrayOfInt).toString();
          new i().h(paramAnonymousArrayOfString).HK(paramAnonymousArrayOfInt).aXQ();
        }
        for (;;)
        {
          a.a.aZh().jLA = false;
          AppMethodBeat.o(137470);
          return;
          label322:
          ad.w("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, get Camera id fail");
          break;
          label332:
          ad.w("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, dispatch data fail");
        }
      }
    });
    localObject = (Activity)paramc.getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(137474);
      return false;
    }
    boolean bool = h.a((Activity)localObject, "android.permission.CAMERA", 16, "", "");
    a.a.aZh().jLz = bool;
    if (!bool)
    {
      AppMethodBeat.o(137474);
      return false;
    }
    bool = h.a((Activity)localObject, "android.permission.RECORD_AUDIO", 18, "", "");
    a.a.aZh().jLA = bool;
    if (!bool)
    {
      AppMethodBeat.o(137474);
      return false;
    }
    o.Mi(paramc.getAppId());
    if (!this.jME)
    {
      paramg.HQ(e("ok", null));
      paramf.initView();
      this.jME = true;
    }
    AppMethodBeat.o(137474);
    return true;
  }
  
  public final boolean aYw()
  {
    return true;
  }
  
  public static abstract interface a
  {
    public abstract f dj(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.l
 * JD-Core Version:    0.7.0.1
 */