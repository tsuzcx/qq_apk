package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class g
  extends b
{
  private static final int CTRL_INDEX = 362;
  public static final String NAME = "removeLivePusher";
  
  protected final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    super.b(parame, paramInt, paramView, paramJSONObject);
    y.i("MicroMsg.JsApiRemoveLivePusher", "onRemoveView livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      y.w("MicroMsg.JsApiRemoveLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    parame = (View)((CoverViewContainer)paramView).K(View.class);
    if (!(parame instanceof AppBrandLivePusherView))
    {
      y.e("MicroMsg.JsApiRemoveLivePusher", "targetView not AppBrandLivePusherView");
      return false;
    }
    ((AppBrandLivePusherView)parame).rX();
    return true;
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("livePusherId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.g
 * JD-Core Version:    0.7.0.1
 */