package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
  extends c
{
  private static final int CTRL_INDEX = 331;
  public static final String NAME = "updateCamera";
  
  protected final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.JsApiUpdateCamera", "onUpdateView : cameraId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      y.w("MicroMsg.JsApiUpdateCamera", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramView = (View)((CoverViewContainer)paramView).K(View.class);
    if ((paramView == null) || (!(paramView instanceof d)))
    {
      y.w("MicroMsg.JsApiUpdateCamera", "the camera view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramView = (d)paramView;
    paramInt = paramJSONObject.optInt("cameraId");
    String str1 = paramJSONObject.optString("devicePosition", "back");
    String str2 = paramJSONObject.optString("flash", "auto");
    boolean bool1 = paramJSONObject.optBoolean("needOutput", false);
    paramView.setAppId(parame.getAppId());
    paramView.ae(str1, false);
    paramView.setFlash(str2);
    paramView.setNeedOutput(bool1);
    parame = paramJSONObject.optJSONObject("position");
    int i = h.a(parame, "width", 0);
    int j = h.a(parame, "height", 0);
    y.d("MicroMsg.JsApiUpdateCamera", "onUpdateView cameraId: %d, devicePosition: %s,flash: %s,width： %d,height： %d", new Object[] { Integer.valueOf(paramInt), str1, str2, Integer.valueOf(i), Integer.valueOf(j) });
    boolean bool2 = false;
    bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (j != 0) {
        bool1 = paramView.bV(i, j);
      }
    }
    parame = paramJSONObject.optString("mode");
    if (!bk.bl(parame)) {
      paramView.setMode(parame);
    }
    parame = paramJSONObject.optJSONArray("scanArea");
    if ((parame != null) && (parame.length() == 4))
    {
      y.i("MicroMsg.JsApiUpdateCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { parame, Integer.valueOf(parame.length()) });
      paramView.o(h.my(parame.optInt(0)), h.my(parame.optInt(1)), h.my(parame.optInt(2)), h.my(parame.optInt(3)));
    }
    paramView.setScanFreq(paramJSONObject.optInt("scanFreq"));
    if (bool1)
    {
      paramView.release();
      paramView.initView();
    }
    for (;;)
    {
      return true;
      paramView.aiH();
    }
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("cameraId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.l
 * JD-Core Version:    0.7.0.1
 */