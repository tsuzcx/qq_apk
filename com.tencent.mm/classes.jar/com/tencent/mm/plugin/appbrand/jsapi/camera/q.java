package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.Size;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class q
  extends d
{
  private static final int CTRL_INDEX = 331;
  public static final String NAME = "updateCamera";
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137483);
    int i = paramJSONObject.optInt("cameraId");
    AppMethodBeat.o(137483);
    return i;
  }
  
  public final boolean c(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137484);
    Log.i("MicroMsg.JsApiUpdateCamera", "onUpdateView : cameraId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.JsApiUpdateCamera", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137484);
      return false;
    }
    paramView = (View)((CoverViewContainer)paramView).aT(View.class);
    if ((paramView == null) || (!(paramView instanceof f)))
    {
      Log.w("MicroMsg.JsApiUpdateCamera", "the camera view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137484);
      return false;
    }
    paramView = (f)paramView;
    paramInt = paramJSONObject.optInt("cameraId");
    Object localObject = paramJSONObject.optString("devicePosition", "back");
    String str = paramJSONObject.optString("flash", "auto");
    boolean bool = paramJSONObject.optBoolean("needOutput", false);
    paramView.setAppId(paramh.getAppId());
    paramView.aE((String)localObject, false);
    paramView.setFlash(str);
    paramView.setNeedOutput(bool);
    JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
    int i = i.a(localJSONObject, "width", 0);
    int j = i.a(localJSONObject, "height", 0);
    Log.d("MicroMsg.JsApiUpdateCamera", "onUpdateView cameraId: %d, devicePosition: %s,flash: %s,width： %d,height： %d", new Object[] { Integer.valueOf(paramInt), localObject, str, Integer.valueOf(i), Integer.valueOf(j) });
    if ((i != 0) && (j != 0)) {}
    for (bool = paramView.fs(i, j);; bool = false)
    {
      localObject = (e)paramh.T(e.class);
      if (localObject != null)
      {
        paramh = ((e)localObject).t(paramh);
        if ((paramh != null) && (paramh.length == 2) && (paramh[0] > 0) && (paramh[1] > 0))
        {
          paramView.setDisplayScreenSize(new Size(paramh[0], paramh[1]));
          Log.i("MicroMsg.JsApiUpdateCamera", "onUpdateView screen width: %d, screen height: %d", new Object[] { Integer.valueOf(paramh[0]), Integer.valueOf(paramh[1]) });
        }
      }
      paramh = paramJSONObject.optString("mode");
      if (!Util.isNullOrNil(paramh)) {
        paramView.setMode(paramh);
      }
      paramh = paramJSONObject.optJSONArray("scanArea");
      if ((paramh != null) && (paramh.length() == 4))
      {
        Log.i("MicroMsg.JsApiUpdateCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { paramh, Integer.valueOf(paramh.length()) });
        paramView.F(i.DC(paramh.optInt(0)), i.DC(paramh.optInt(1)), i.DC(paramh.optInt(2)), i.DC(paramh.optInt(3)));
      }
      paramView.setScanFreq(paramJSONObject.optInt("scanFreq"));
      if (bool)
      {
        paramView.release();
        paramView.initView();
      }
      for (;;)
      {
        AppMethodBeat.o(137484);
        return true;
        paramView.crB();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.q
 * JD-Core Version:    0.7.0.1
 */