package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class m
  extends b
{
  private static final int CTRL_INDEX = 330;
  public static final String NAME = "removeCamera";
  
  public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126254);
    super.b(parame, paramInt, paramView, paramJSONObject);
    ab.i("MicroMsg.JsApiRemoveCamera", "onRemoveView cameraId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ab.w("MicroMsg.JsApiRemoveCamera", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126254);
      return false;
    }
    paramView = (View)((CoverViewContainer)paramView).aa(View.class);
    if ((paramView == null) || (!(paramView instanceof e)))
    {
      ab.w("MicroMsg.JsApiRemoveCamera", "the camera view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126254);
      return false;
    }
    paramView = (e)paramView;
    parame.b(paramView);
    parame.b(paramView);
    parame.b(paramView);
    paramView.release();
    AppMethodBeat.o(126254);
    return true;
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126253);
    int i = paramJSONObject.optInt("cameraId", 0);
    AppMethodBeat.o(126253);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.m
 * JD-Core Version:    0.7.0.1
 */