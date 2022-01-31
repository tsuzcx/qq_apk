package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.luggage.j.f;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a
{
  private static final int CTRL_INDEX = 329;
  public static final String NAME = "insertCamera";
  static h.a gpa;
  
  protected final View a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    Context localContext = parame.getContext();
    d locald = gpa.cj(localContext);
    int i = paramJSONObject.optInt("cameraId");
    Object localObject = paramJSONObject.optString("mode", "normal");
    String str1 = paramJSONObject.optString("devicePosition", "back");
    String str2 = paramJSONObject.optString("flash", "auto");
    boolean bool = paramJSONObject.optBoolean("needOutput", false);
    locald.setAppId(parame.getAppId());
    locald.setPage(parame);
    locald.setCameraId(i);
    locald.setMode((String)localObject);
    locald.ae(str1, true);
    locald.setFlash(str2);
    locald.setNeedOutput(bool);
    localObject = paramJSONObject.optJSONObject("position");
    int j = com.tencent.mm.plugin.appbrand.u.h.a((JSONObject)localObject, "width", 0);
    int k = com.tencent.mm.plugin.appbrand.u.h.a((JSONObject)localObject, "height", 0);
    if ((j != 0) && (k != 0)) {
      locald.bV(j, k);
    }
    localObject = paramJSONObject.optJSONArray("scanArea");
    if ((localObject != null) && (((JSONArray)localObject).length() == 4))
    {
      y.i("MicroMsg.JsApiInsertCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { localObject, Integer.valueOf(((JSONArray)localObject).length()) });
      locald.o(com.tencent.mm.plugin.appbrand.u.h.my(((JSONArray)localObject).optInt(0)), com.tencent.mm.plugin.appbrand.u.h.my(((JSONArray)localObject).optInt(1)), com.tencent.mm.plugin.appbrand.u.h.my(((JSONArray)localObject).optInt(2)), com.tencent.mm.plugin.appbrand.u.h.my(((JSONArray)localObject).optInt(3)));
    }
    for (;;)
    {
      locald.setScanFreq(paramJSONObject.optInt("scanFreq"));
      y.d("MicroMsg.JsApiInsertCamera", "inflateView cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d", new Object[] { Integer.valueOf(i), str1, str2, Integer.valueOf(j), Integer.valueOf(k) });
      a(parame, locald);
      return new CoverViewContainer(localContext, (View)locald);
      locald.o(0, 0, j, k);
    }
  }
  
  protected final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.JsApiInsertCamera", "onInsertView cameraId=%d", new Object[] { Integer.valueOf(paramInt) });
    paramView = (d)((CoverViewContainer)paramView).K(View.class);
    if (paramView == null)
    {
      y.w("MicroMsg.JsApiInsertCamera", "onInsertView(viewId : %d) failed, cameraView is null", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    paramJSONObject = a.a.aiD();
    int i = paramView.getCameraId();
    paramJSONObject.goq.put(Integer.valueOf(i), paramView);
    parame.a(paramView);
    parame.a(paramView);
    parame.a(paramView);
    g.a(parame.getAppId(), new h.1(this, parame, paramView, paramInt));
    paramView.setOutPutCallBack(new h.2(this));
  }
  
  final boolean a(c paramc, d paramd)
  {
    com.tencent.mm.plugin.appbrand.permission.e.b(String.valueOf(paramc.getAppId()), new h.3(this, paramc, paramd));
    Activity localActivity = (Activity)paramc.getContext();
    if (localActivity == null) {
      return false;
    }
    boolean bool = f.a(localActivity, "android.permission.CAMERA", 16, "", "");
    a.a.aiD().gon = bool;
    if (!bool) {
      return false;
    }
    bool = f.a(localActivity, "android.permission.RECORD_AUDIO", 18, "", "");
    a.a.aiD().goo = bool;
    if (!bool) {
      return false;
    }
    com.tencent.mm.plugin.appbrand.permission.e.vX(paramc.getAppId());
    paramd.initView();
    return true;
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("cameraId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.h
 * JD-Core Version:    0.7.0.1
 */