package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.Size;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p
  extends c
{
  private static final int CTRL_INDEX = 331;
  public static final String NAME = "updateCamera";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137483);
    int i = paramJSONObject.optInt("cameraId");
    AppMethodBeat.o(137483);
    return i;
  }
  
  public final boolean c(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137484);
    ac.i("MicroMsg.JsApiUpdateCamera", "onUpdateView : cameraId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ac.w("MicroMsg.JsApiUpdateCamera", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137484);
      return false;
    }
    paramView = (View)((CoverViewContainer)paramView).ax(View.class);
    if ((paramView == null) || (!(paramView instanceof f)))
    {
      ac.w("MicroMsg.JsApiUpdateCamera", "the camera view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137484);
      return false;
    }
    paramView = (f)paramView;
    paramInt = paramJSONObject.optInt("cameraId");
    Object localObject = paramJSONObject.optString("devicePosition", "back");
    String str = paramJSONObject.optString("flash", "auto");
    boolean bool = paramJSONObject.optBoolean("needOutput", false);
    paramView.setAppId(parame.getAppId());
    paramView.ao((String)localObject, false);
    paramView.setFlash(str);
    paramView.setNeedOutput(bool);
    JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
    int i = g.a(localJSONObject, "width", 0);
    int j = g.a(localJSONObject, "height", 0);
    ac.d("MicroMsg.JsApiUpdateCamera", "onUpdateView cameraId: %d, devicePosition: %s,flash: %s,width： %d,height： %d", new Object[] { Integer.valueOf(paramInt), localObject, str, Integer.valueOf(i), Integer.valueOf(j) });
    if ((i != 0) && (j != 0)) {}
    for (bool = paramView.dM(i, j);; bool = false)
    {
      localObject = (e)parame.K(e.class);
      if (localObject != null)
      {
        parame = ((e)localObject).p(parame);
        if ((parame != null) && (parame.length == 2) && (parame[0] > 0) && (parame[1] > 0))
        {
          paramView.setDisplayScreenSize(new Size(parame[0], parame[1]));
          ac.i("MicroMsg.JsApiUpdateCamera", "onUpdateView screen width: %d, screen height: %d", new Object[] { Integer.valueOf(parame[0]), Integer.valueOf(parame[1]) });
        }
      }
      parame = paramJSONObject.optString("mode");
      if (!bs.isNullOrNil(parame)) {
        paramView.setMode(parame);
      }
      parame = paramJSONObject.optJSONArray("scanArea");
      if ((parame != null) && (parame.length() == 4))
      {
        ac.i("MicroMsg.JsApiUpdateCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { parame, Integer.valueOf(parame.length()) });
        paramView.w(g.ve(parame.optInt(0)), g.ve(parame.optInt(1)), g.ve(parame.optInt(2)), g.ve(parame.optInt(3)));
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
        paramView.bgd();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.p
 * JD-Core Version:    0.7.0.1
 */