package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.app.Activity;
import android.content.Context;
import android.util.Size;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
{
  private static final int CTRL_INDEX = 329;
  public static final String NAME = "insertCamera";
  static a kLt;
  private boolean kLu;
  
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
    this.kLu = false;
    Context localContext = parame.getContext();
    f localf = kLt.ds(localContext);
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
        localf.ap(str2, true);
        localf.setFlash(str3);
        localf.setFrameLimitSize(i);
        localf.setNeedOutput(bool);
        localf.setResolution((String)localObject);
        localObject = paramJSONObject.optJSONObject("position");
        i = g.a((JSONObject)localObject, "width", 0);
        j = g.a((JSONObject)localObject, "height", 0);
        if ((i != 0) && (j != 0)) {
          localf.dO(i, j);
        }
        localObject = (e)parame.K(e.class);
        if (localObject != null)
        {
          parame = ((e)localObject).p(parame);
          if ((parame != null) && (parame.length == 2) && (parame[0] > 0) && (parame[1] > 0))
          {
            localf.setDisplayScreenSize(new Size(parame[0], parame[1]));
            ae.i("MicroMsg.JsApiInsertCamera", "onInsertView screen width: %d, screen height: %d", new Object[] { Integer.valueOf(parame[0]), Integer.valueOf(parame[1]) });
          }
        }
        parame = paramJSONObject.optJSONArray("scanArea");
        if ((parame != null) && (parame.length() == 4))
        {
          ae.i("MicroMsg.JsApiInsertCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { parame, Integer.valueOf(parame.length()) });
          localf.x(g.vO(parame.optInt(0)), g.vO(parame.optInt(1)), g.vO(parame.optInt(2)), g.vO(parame.optInt(3)));
          label486:
          localf.setScanFreq(paramJSONObject.optInt("scanFreq"));
          bool = paramJSONObject.optBoolean("centerCrop");
          localf.setPreviewCenterCrop(bool);
          ae.d("MicroMsg.JsApiInsertCamera", "inflateView cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d, centerCrop: %b", new Object[] { Integer.valueOf(k), str2, str3, Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) });
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
      localf.x(0, 0, i, j);
      break label486;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, final JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.jsapi.base.i parami)
  {
    AppMethodBeat.i(137473);
    ae.i("MicroMsg.JsApiInsertCamera", "onInsertView cameraId=%d", new Object[] { Integer.valueOf(paramInt) });
    paramView = (f)((CoverViewContainer)paramView).ax(View.class);
    if (paramView == null)
    {
      ae.e("MicroMsg.JsApiInsertCamera", "onInsertView(viewId : %d) failed, cameraView is null", new Object[] { Integer.valueOf(paramInt) });
      parami.PZ(e("fail:internal error", null));
      AppMethodBeat.o(137473);
      return;
    }
    paramJSONObject = new WeakReference(paramView);
    final WeakReference localWeakReference = new WeakReference(parame);
    a(parame, paramView, parami);
    a.a.bkm().a(paramView.getCameraId(), paramView);
    parame.a(paramView);
    parame.a(paramView);
    parame.a(paramView);
    com.tencent.mm.plugin.appbrand.h.a(parame.getAppId(), new h.c()
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
          a.a.bkm().I(localf.getCameraId(), true);
          com.tencent.mm.plugin.appbrand.h.b(locale.getAppId(), this);
        }
        AppMethodBeat.o(137469);
      }
    });
    paramView.setOutPutCallBack(new b() {});
    AppMethodBeat.o(137473);
  }
  
  final boolean a(c paramc, f paramf, final com.tencent.mm.plugin.appbrand.jsapi.base.i parami)
  {
    AppMethodBeat.i(137474);
    Object localObject = new WeakReference(paramf);
    final WeakReference localWeakReference = new WeakReference(paramc);
    r.b(String.valueOf(paramc.getAppId()), new android.support.v4.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(137470);
        f localf = (f)this.kLv.get();
        paramAnonymousArrayOfString = (c)localWeakReference.get();
        if (paramAnonymousInt == 16)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0) && (localf != null) && (paramAnonymousArrayOfString != null))
          {
            a.a.bkm().kKp = true;
            l.this.a(paramAnonymousArrayOfString, localf, parami);
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
            new i().h(paramAnonymousArrayOfString).PQ(paramAnonymousArrayOfInt).bja();
          }
          for (;;)
          {
            a.a.bkm().kKp = false;
            AppMethodBeat.o(137470);
            return;
            ae.w("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, get Camera id fail");
            break;
            label175:
            ae.w("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, dispatch data fail");
          }
        }
        if (paramAnonymousInt == 18)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0) && (localf != null) && (paramAnonymousArrayOfString != null))
          {
            a.a.bkm().kKq = true;
            l.this.a(paramAnonymousArrayOfString, localf, parami);
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
          new i().h(paramAnonymousArrayOfString).PQ(paramAnonymousArrayOfInt).bja();
        }
        for (;;)
        {
          a.a.bkm().kKq = false;
          AppMethodBeat.o(137470);
          return;
          label322:
          ae.w("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, get Camera id fail");
          break;
          label332:
          ae.w("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, dispatch data fail");
        }
      }
    });
    localObject = (Activity)paramc.getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(137474);
      return false;
    }
    boolean bool = com.tencent.luggage.h.h.a((Activity)localObject, "android.permission.CAMERA", 16, "", "");
    a.a.bkm().kKp = bool;
    if (!bool)
    {
      AppMethodBeat.o(137474);
      return false;
    }
    bool = com.tencent.luggage.h.h.a((Activity)localObject, "android.permission.RECORD_AUDIO", 18, "", "");
    a.a.bkm().kKq = bool;
    if (!bool)
    {
      AppMethodBeat.o(137474);
      return false;
    }
    r.UC(paramc.getAppId());
    if (!this.kLu)
    {
      parami.PZ(e("ok", null));
      paramf.initView();
      this.kLu = true;
    }
    AppMethodBeat.o(137474);
    return true;
  }
  
  public final boolean bjF()
  {
    return true;
  }
  
  public static abstract interface a
  {
    public abstract f ds(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.l
 * JD-Core Version:    0.7.0.1
 */