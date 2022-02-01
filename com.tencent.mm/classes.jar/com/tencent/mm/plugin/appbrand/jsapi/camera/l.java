package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.app.Activity;
import android.content.Context;
import android.util.Size;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.sdk.platformtools.Log;
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
  static a lQf;
  private boolean lQg;
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137472);
    int i = paramJSONObject.optInt("cameraId");
    AppMethodBeat.o(137472);
    return i;
  }
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137471);
    this.lQg = false;
    Context localContext = paramh.getContext();
    f localf = lQf.dN(localContext);
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
        localf.setAppId(paramh.getAppId());
        localf.setPage(paramh);
        localf.setCameraId(k);
        localf.setMode(str1);
        localf.ar(str2, true);
        localf.setFlash(str3);
        localf.setFrameLimitSize(i);
        localf.setNeedOutput(bool);
        localf.setResolution((String)localObject);
        localf.setPageOrientation(paramh.btO());
        localObject = paramJSONObject.optJSONObject("position");
        i = g.a((JSONObject)localObject, "width", 0);
        j = g.a((JSONObject)localObject, "height", 0);
        if ((i != 0) && (j != 0)) {
          localf.dZ(i, j);
        }
        localObject = (e)paramh.M(e.class);
        if (localObject != null)
        {
          paramh = ((e)localObject).p(paramh);
          if ((paramh != null) && (paramh.length == 2) && (paramh[0] > 0) && (paramh[1] > 0))
          {
            localf.setDisplayScreenSize(new Size(paramh[0], paramh[1]));
            Log.i("MicroMsg.JsApiInsertCamera", "onInsertView screen width: %d, screen height: %d", new Object[] { Integer.valueOf(paramh[0]), Integer.valueOf(paramh[1]) });
          }
        }
        paramh = paramJSONObject.optJSONArray("scanArea");
        if ((paramh != null) && (paramh.length() == 4))
        {
          Log.i("MicroMsg.JsApiInsertCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { paramh, Integer.valueOf(paramh.length()) });
          localf.x(g.zD(paramh.optInt(0)), g.zD(paramh.optInt(1)), g.zD(paramh.optInt(2)), g.zD(paramh.optInt(3)));
          label499:
          localf.setScanFreq(paramJSONObject.optInt("scanFreq"));
          bool = paramJSONObject.optBoolean("centerCrop");
          localf.setPreviewCenterCrop(bool);
          Log.d("MicroMsg.JsApiInsertCamera", "inflateView cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d, centerCrop: %b", new Object[] { Integer.valueOf(k), str2, str3, Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) });
          paramJSONObject = localf.getView();
          if (!"normal".equals(str1)) {
            break label719;
          }
        }
        break;
      }
      break;
    }
    label719:
    for (paramh = localContext.getString(2131755319);; paramh = localContext.getString(2131755320))
    {
      paramJSONObject.setContentDescription(paramh);
      paramh = new CoverViewContainer(localContext, (View)localf);
      AppMethodBeat.o(137471);
      return paramh;
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
      break label499;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt, View paramView, final JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.jsapi.base.i parami)
  {
    AppMethodBeat.i(137473);
    Log.i("MicroMsg.JsApiInsertCamera", "onInsertView cameraId=%d", new Object[] { Integer.valueOf(paramInt) });
    paramView = (f)((CoverViewContainer)paramView).aB(View.class);
    if (paramView == null)
    {
      Log.e("MicroMsg.JsApiInsertCamera", "onInsertView(viewId : %d) failed, cameraView is null", new Object[] { Integer.valueOf(paramInt) });
      parami.ZA(h("fail:internal error", null));
      AppMethodBeat.o(137473);
      return;
    }
    paramJSONObject = new WeakReference(paramView);
    final WeakReference localWeakReference = new WeakReference(paramh);
    a(paramh, paramView, parami);
    a.a.bFI().a(paramView.getCameraId(), paramView);
    paramh.a(paramView);
    paramh.a(paramView);
    paramh.a(paramView);
    com.tencent.mm.plugin.appbrand.h.a(paramh.getAppId(), new h.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137469);
        f localf = (f)paramJSONObject.get();
        com.tencent.mm.plugin.appbrand.jsapi.h localh = (com.tencent.mm.plugin.appbrand.jsapi.h)localWeakReference.get();
        if ((localf != null) && (localh != null))
        {
          localh.b(localf);
          localh.b(localf);
          localh.b(localf);
          a.a.bFI().M(localf.getCameraId(), true);
          com.tencent.mm.plugin.appbrand.h.b(localh.getAppId(), this);
        }
        AppMethodBeat.o(137469);
      }
    });
    paramView.setOutPutCallBack(new b() {});
    AppMethodBeat.o(137473);
  }
  
  final boolean a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, f paramf1, final com.tencent.mm.plugin.appbrand.jsapi.base.i parami)
  {
    AppMethodBeat.i(137474);
    Object localObject = new WeakReference(paramf1);
    final WeakReference localWeakReference = new WeakReference(paramf);
    r.b(String.valueOf(paramf.getAppId()), new android.support.v4.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(137470);
        f localf = (f)this.lQh.get();
        paramAnonymousArrayOfString = (com.tencent.mm.plugin.appbrand.jsapi.f)localWeakReference.get();
        if (paramAnonymousInt == 16)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0) && (localf != null) && (paramAnonymousArrayOfString != null))
          {
            a.a.bFI().lOV = true;
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
            new i().h(paramAnonymousArrayOfString).Zh(paramAnonymousArrayOfInt).bEo();
          }
          for (;;)
          {
            a.a.bFI().lOV = false;
            AppMethodBeat.o(137470);
            return;
            Log.w("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, get Camera id fail");
            break;
            label175:
            Log.w("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, dispatch data fail");
          }
        }
        if (paramAnonymousInt == 18)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0) && (localf != null) && (paramAnonymousArrayOfString != null))
          {
            a.a.bFI().lOW = true;
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
          new i().h(paramAnonymousArrayOfString).Zh(paramAnonymousArrayOfInt).bEo();
        }
        for (;;)
        {
          a.a.bFI().lOW = false;
          AppMethodBeat.o(137470);
          return;
          label322:
          Log.w("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, get Camera id fail");
          break;
          label332:
          Log.w("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, dispatch data fail");
        }
      }
    });
    localObject = (Activity)paramf.getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(137474);
      return false;
    }
    boolean bool = com.tencent.luggage.h.i.a((Activity)localObject, "android.permission.CAMERA", 16, "", "");
    a.a.bFI().lOV = bool;
    if (!bool)
    {
      AppMethodBeat.o(137474);
      return false;
    }
    bool = com.tencent.luggage.h.i.a((Activity)localObject, "android.permission.RECORD_AUDIO", 18, "", "");
    a.a.bFI().lOW = bool;
    if (!bool)
    {
      AppMethodBeat.o(137474);
      return false;
    }
    r.aeq(paramf.getAppId());
    if (!this.lQg)
    {
      parami.ZA(h("ok", null));
      paramf1.initView();
      this.lQg = true;
    }
    AppMethodBeat.o(137474);
    return true;
  }
  
  public final boolean bEV()
  {
    return true;
  }
  
  public static abstract interface a
  {
    public abstract f dN(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.l
 * JD-Core Version:    0.7.0.1
 */