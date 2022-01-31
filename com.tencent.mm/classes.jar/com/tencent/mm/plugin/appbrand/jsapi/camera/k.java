package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class k
  extends b
{
  private static final int CTRL_INDEX = 330;
  public static final String NAME = "removeCamera";
  
  protected final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    super.b(parame, paramInt, paramView, paramJSONObject);
    y.i("MicroMsg.JsApiRemoveCamera", "onRemoveView cameraId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      y.w("MicroMsg.JsApiRemoveCamera", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramView = (View)((CoverViewContainer)paramView).K(View.class);
    if ((paramView == null) || (!(paramView instanceof d)))
    {
      y.w("MicroMsg.JsApiRemoveCamera", "the camera view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramView = (d)paramView;
    parame.b(paramView);
    parame.b(paramView);
    parame.b(paramView);
    paramView.release();
    return true;
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("cameraId", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.k
 * JD-Core Version:    0.7.0.1
 */