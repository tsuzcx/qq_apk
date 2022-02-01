package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.Size;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class q
  extends d
{
  private static final int CTRL_INDEX = 331;
  public static final String NAME = "updateCamera";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137483);
    int i = paramJSONObject.optInt("cameraId");
    AppMethodBeat.o(137483);
    return i;
  }
  
  public final boolean c(com.tencent.mm.plugin.appbrand.jsapi.g paramg, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137484);
    Log.i("MicroMsg.JsApiUpdateCamera", "onUpdateView : cameraId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.JsApiUpdateCamera", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137484);
      return false;
    }
    paramView = (View)((CoverViewContainer)paramView).aA(View.class);
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
    paramView.setAppId(paramg.getAppId());
    paramView.at((String)localObject, false);
    paramView.setFlash(str);
    paramView.setNeedOutput(bool);
    JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
    int i = com.tencent.mm.plugin.appbrand.ac.g.a(localJSONObject, "width", 0);
    int j = com.tencent.mm.plugin.appbrand.ac.g.a(localJSONObject, "height", 0);
    Log.d("MicroMsg.JsApiUpdateCamera", "onUpdateView cameraId: %d, devicePosition: %s,flash: %s,width： %d,height： %d", new Object[] { Integer.valueOf(paramInt), localObject, str, Integer.valueOf(i), Integer.valueOf(j) });
    if ((i != 0) && (j != 0)) {}
    for (bool = paramView.ey(i, j);; bool = false)
    {
      localObject = (e)paramg.K(e.class);
      if (localObject != null)
      {
        paramg = ((e)localObject).r(paramg);
        if ((paramg != null) && (paramg.length == 2) && (paramg[0] > 0) && (paramg[1] > 0))
        {
          paramView.setDisplayScreenSize(new Size(paramg[0], paramg[1]));
          Log.i("MicroMsg.JsApiUpdateCamera", "onUpdateView screen width: %d, screen height: %d", new Object[] { Integer.valueOf(paramg[0]), Integer.valueOf(paramg[1]) });
        }
      }
      paramg = paramJSONObject.optString("mode");
      if (!Util.isNullOrNil(paramg)) {
        paramView.setMode(paramg);
      }
      paramg = paramJSONObject.optJSONArray("scanArea");
      if ((paramg != null) && (paramg.length() == 4))
      {
        Log.i("MicroMsg.JsApiUpdateCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { paramg, Integer.valueOf(paramg.length()) });
        paramView.z(com.tencent.mm.plugin.appbrand.ac.g.Di(paramg.optInt(0)), com.tencent.mm.plugin.appbrand.ac.g.Di(paramg.optInt(1)), com.tencent.mm.plugin.appbrand.ac.g.Di(paramg.optInt(2)), com.tencent.mm.plugin.appbrand.ac.g.Di(paramg.optInt(3)));
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
        paramView.bRv();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.q
 * JD-Core Version:    0.7.0.1
 */