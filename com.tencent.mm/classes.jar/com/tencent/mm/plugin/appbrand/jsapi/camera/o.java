package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class o
  extends b
{
  private static final int CTRL_INDEX = 330;
  public static final String NAME = "removeCamera";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137481);
    int i = paramJSONObject.optInt("cameraId", 0);
    AppMethodBeat.o(137481);
    return i;
  }
  
  public final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137482);
    super.b(parame, paramInt, paramView, paramJSONObject);
    ac.i("MicroMsg.JsApiRemoveCamera", "onRemoveView cameraId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ac.w("MicroMsg.JsApiRemoveCamera", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137482);
      return false;
    }
    paramView = (View)((CoverViewContainer)paramView).ax(View.class);
    if ((paramView == null) || (!(paramView instanceof f)))
    {
      ac.w("MicroMsg.JsApiRemoveCamera", "the camera view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137482);
      return false;
    }
    paramView = (f)paramView;
    parame.b(paramView);
    parame.b(paramView);
    parame.b(paramView);
    a.a.bfZ().I(paramView.getCameraId(), true);
    paramView.release();
    AppMethodBeat.o(137482);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.o
 * JD-Core Version:    0.7.0.1
 */