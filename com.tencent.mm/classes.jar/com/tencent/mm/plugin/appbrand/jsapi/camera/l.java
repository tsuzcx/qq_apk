package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.app.Activity;
import android.content.Context;
import android.util.Size;
import android.view.View;
import com.tencent.luggage.b.a.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.permission.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class l
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
{
  private static final int CTRL_INDEX = 329;
  public static final String NAME = "insertCamera";
  static a rQv;
  private boolean rQw;
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137472);
    int i = paramJSONObject.optInt("cameraId");
    AppMethodBeat.o(137472);
    return i;
  }
  
  public final View a(h paramh, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137471);
    this.rQw = false;
    Context localContext = paramh.getContext();
    f localf = rQv.eG(localContext);
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
        localf.aE(str2, true);
        localf.setFlash(str3);
        localf.setFrameLimitSize(i);
        localf.setNeedOutput(bool);
        localf.setResolution((String)localObject);
        localf.setPageOrientation(paramh.cdZ());
        localObject = paramJSONObject.optJSONObject("position");
        i = com.tencent.mm.plugin.appbrand.af.i.a((JSONObject)localObject, "width", 0);
        j = com.tencent.mm.plugin.appbrand.af.i.a((JSONObject)localObject, "height", 0);
        if ((i != 0) && (j != 0)) {
          localf.fs(i, j);
        }
        localObject = (e)paramh.T(e.class);
        if (localObject != null)
        {
          paramh = ((e)localObject).t(paramh);
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
          localf.F(com.tencent.mm.plugin.appbrand.af.i.DC(paramh.optInt(0)), com.tencent.mm.plugin.appbrand.af.i.DC(paramh.optInt(1)), com.tencent.mm.plugin.appbrand.af.i.DC(paramh.optInt(2)), com.tencent.mm.plugin.appbrand.af.i.DC(paramh.optInt(3)));
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
    for (paramh = localContext.getString(a.g.app_brand_accessibility_camera_normal_mode);; paramh = localContext.getString(a.g.app_brand_accessibility_camera_scan_mode))
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
      localf.F(0, 0, i, j);
      break label499;
    }
  }
  
  public final void a(h paramh, int paramInt, View paramView, final JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.jsapi.base.i parami)
  {
    AppMethodBeat.i(137473);
    Log.i("MicroMsg.JsApiInsertCamera", "onInsertView cameraId=%d", new Object[] { Integer.valueOf(paramInt) });
    paramView = (f)((CoverViewContainer)paramView).aT(View.class);
    if (paramView == null)
    {
      Log.e("MicroMsg.JsApiInsertCamera", "onInsertView(viewId : %d) failed, cameraView is null", new Object[] { Integer.valueOf(paramInt) });
      parami.aal(ZP("fail:internal error"));
      AppMethodBeat.o(137473);
      return;
    }
    paramJSONObject = new WeakReference(paramView);
    final WeakReference localWeakReference = new WeakReference(paramh);
    a(paramh, paramView, parami);
    a.a.cry().a(paramView.getCameraId(), paramView);
    paramh.a(paramView);
    paramh.a(paramView);
    paramh.a(paramView);
    k.a(paramh.getAppId(), new k.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137469);
        f localf = (f)paramJSONObject.get();
        h localh = (h)localWeakReference.get();
        if ((localf != null) && (localh != null))
        {
          localh.b(localf);
          localh.b(localf);
          localh.b(localf);
          a.a.cry().ad(localf.getCameraId(), true);
          k.b(localh.getAppId(), this);
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
    s.c(String.valueOf(paramf.getAppId()), new androidx.core.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(137470);
        f localf = (f)this.rQx.get();
        paramAnonymousArrayOfString = (com.tencent.mm.plugin.appbrand.jsapi.f)localWeakReference.get();
        if (paramAnonymousInt == 16)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0) && (localf != null) && (paramAnonymousArrayOfString != null))
          {
            a.a.cry().rPk = true;
            l.this.a(paramAnonymousArrayOfString, localf, parami);
            AppMethodBeat.o(137470);
            return;
          }
          paramAnonymousArrayOfInt = new HashMap();
          if (localf == null) {
            break label165;
          }
          paramAnonymousArrayOfInt.put("cameraId", Integer.valueOf(localf.getCameraId()));
          if (paramAnonymousArrayOfString == null) {
            break label175;
          }
          paramAnonymousArrayOfInt = new JSONObject(paramAnonymousArrayOfInt).toString();
          new i().i(paramAnonymousArrayOfString).ZR(paramAnonymousArrayOfInt).cpV();
        }
        for (;;)
        {
          a.a.cry().rPk = false;
          AppMethodBeat.o(137470);
          return;
          label165:
          Log.w("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, get Camera id fail");
          break;
          label175:
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
    boolean bool = com.tencent.luggage.l.i.a((Context)localObject, paramf, "android.permission.WRITE_EXTERNAL_STORAGE");
    a.a.cry().jk(bool);
    bool = com.tencent.luggage.l.i.a((Activity)localObject, paramf, "android.permission.CAMERA", 16, "", "");
    a.a.cry().rPk = bool;
    if (!bool)
    {
      AppMethodBeat.o(137474);
      return false;
    }
    s.afs(paramf.getAppId());
    if (!this.rQw)
    {
      parami.aal(ZP("ok"));
      paramf1.initView();
      this.rQw = true;
    }
    AppMethodBeat.o(137474);
    return true;
  }
  
  public final boolean cqw()
  {
    return true;
  }
  
  public static abstract interface a
  {
    public abstract f eG(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.l
 * JD-Core Version:    0.7.0.1
 */