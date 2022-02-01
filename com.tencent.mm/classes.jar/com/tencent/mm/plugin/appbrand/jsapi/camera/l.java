package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.app.Activity;
import android.content.Context;
import android.util.Size;
import android.view.View;
import com.tencent.luggage.b.a.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.permission.r;
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
  static a oMz;
  private boolean oMA;
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137472);
    int i = paramJSONObject.optInt("cameraId");
    AppMethodBeat.o(137472);
    return i;
  }
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.g paramg, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137471);
    this.oMA = false;
    Context localContext = paramg.getContext();
    f localf = oMz.dM(localContext);
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
        localf.setAppId(paramg.getAppId());
        localf.setPage(paramg);
        localf.setCameraId(k);
        localf.setMode(str1);
        localf.at(str2, true);
        localf.setFlash(str3);
        localf.setFrameLimitSize(i);
        localf.setNeedOutput(bool);
        localf.setResolution((String)localObject);
        localf.setPageOrientation(paramg.bEN());
        localObject = paramJSONObject.optJSONObject("position");
        i = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject, "width", 0);
        j = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject, "height", 0);
        if ((i != 0) && (j != 0)) {
          localf.ey(i, j);
        }
        localObject = (e)paramg.K(e.class);
        if (localObject != null)
        {
          paramg = ((e)localObject).r(paramg);
          if ((paramg != null) && (paramg.length == 2) && (paramg[0] > 0) && (paramg[1] > 0))
          {
            localf.setDisplayScreenSize(new Size(paramg[0], paramg[1]));
            Log.i("MicroMsg.JsApiInsertCamera", "onInsertView screen width: %d, screen height: %d", new Object[] { Integer.valueOf(paramg[0]), Integer.valueOf(paramg[1]) });
          }
        }
        paramg = paramJSONObject.optJSONArray("scanArea");
        if ((paramg != null) && (paramg.length() == 4))
        {
          Log.i("MicroMsg.JsApiInsertCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { paramg, Integer.valueOf(paramg.length()) });
          localf.z(com.tencent.mm.plugin.appbrand.ac.g.Di(paramg.optInt(0)), com.tencent.mm.plugin.appbrand.ac.g.Di(paramg.optInt(1)), com.tencent.mm.plugin.appbrand.ac.g.Di(paramg.optInt(2)), com.tencent.mm.plugin.appbrand.ac.g.Di(paramg.optInt(3)));
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
    for (paramg = localContext.getString(a.g.app_brand_accessibility_camera_normal_mode);; paramg = localContext.getString(a.g.app_brand_accessibility_camera_scan_mode))
    {
      paramJSONObject.setContentDescription(paramg);
      paramg = new CoverViewContainer(localContext, (View)localf);
      AppMethodBeat.o(137471);
      return paramg;
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
      localf.z(0, 0, i, j);
      break label499;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.g paramg, int paramInt, View paramView, final JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.jsapi.base.i parami)
  {
    AppMethodBeat.i(137473);
    Log.i("MicroMsg.JsApiInsertCamera", "onInsertView cameraId=%d", new Object[] { Integer.valueOf(paramInt) });
    paramView = (f)((CoverViewContainer)paramView).aA(View.class);
    if (paramView == null)
    {
      Log.e("MicroMsg.JsApiInsertCamera", "onInsertView(viewId : %d) failed, cameraView is null", new Object[] { Integer.valueOf(paramInt) });
      parami.aho(h("fail:internal error", null));
      AppMethodBeat.o(137473);
      return;
    }
    paramJSONObject = new WeakReference(paramView);
    final WeakReference localWeakReference = new WeakReference(paramg);
    a(paramg, paramView, parami);
    a.a.bRr().a(paramView.getCameraId(), paramView);
    paramg.a(paramView);
    paramg.a(paramView);
    paramg.a(paramView);
    k.a(paramg.getAppId(), new k.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(137469);
        f localf = (f)paramJSONObject.get();
        com.tencent.mm.plugin.appbrand.jsapi.g localg = (com.tencent.mm.plugin.appbrand.jsapi.g)localWeakReference.get();
        if ((localf != null) && (localg != null))
        {
          localg.b(localf);
          localg.b(localf);
          localg.b(localf);
          a.a.bRr().O(localf.getCameraId(), true);
          k.b(localg.getAppId(), this);
        }
        AppMethodBeat.o(137469);
      }
    });
    paramView.setOutPutCallBack(new b() {});
    AppMethodBeat.o(137473);
  }
  
  final boolean a(com.tencent.mm.plugin.appbrand.jsapi.e parame, f paramf, final com.tencent.mm.plugin.appbrand.jsapi.base.i parami)
  {
    AppMethodBeat.i(137474);
    Object localObject = new WeakReference(paramf);
    final WeakReference localWeakReference = new WeakReference(parame);
    r.b(String.valueOf(parame.getAppId()), new androidx.core.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(137470);
        f localf = (f)this.oMB.get();
        paramAnonymousArrayOfString = (com.tencent.mm.plugin.appbrand.jsapi.e)localWeakReference.get();
        if (paramAnonymousInt == 16)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0) && (localf != null) && (paramAnonymousArrayOfString != null))
          {
            a.a.bRr().oLp = true;
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
            new i().j(paramAnonymousArrayOfString).agU(paramAnonymousArrayOfInt).bPO();
          }
          for (;;)
          {
            a.a.bRr().oLp = false;
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
            a.a.bRr().oLq = true;
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
          new i().j(paramAnonymousArrayOfString).agU(paramAnonymousArrayOfInt).bPO();
        }
        for (;;)
        {
          a.a.bRr().oLq = false;
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
    localObject = (Activity)parame.getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(137474);
      return false;
    }
    boolean bool = com.tencent.luggage.k.i.a((Activity)localObject, "android.permission.CAMERA", 16, "", "");
    a.a.bRr().oLp = bool;
    if (!bool)
    {
      AppMethodBeat.o(137474);
      return false;
    }
    bool = com.tencent.luggage.k.i.a((Activity)localObject, "android.permission.RECORD_AUDIO", 18, "", "");
    a.a.bRr().oLq = bool;
    if (!bool)
    {
      AppMethodBeat.o(137474);
      return false;
    }
    r.amk(parame.getAppId());
    if (!this.oMA)
    {
      parami.aho(h("ok", null));
      paramf.initView();
      this.oMA = true;
    }
    AppMethodBeat.o(137474);
    return true;
  }
  
  public final boolean bQz()
  {
    return true;
  }
  
  public static abstract interface a
  {
    public abstract f dM(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.l
 * JD-Core Version:    0.7.0.1
 */