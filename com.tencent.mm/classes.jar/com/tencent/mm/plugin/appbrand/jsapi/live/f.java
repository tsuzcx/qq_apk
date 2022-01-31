package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class f
  extends b
{
  private static final int CTRL_INDEX = 366;
  public static final String NAME = "removeLivePlayer";
  
  protected final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    super.b(parame, paramInt, paramView, paramJSONObject);
    y.i("MicroMsg.JsApiRemoveLivePlayer", "onRemoveView livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      y.w("MicroMsg.JsApiRemoveLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    parame = (View)((CoverViewContainer)paramView).K(View.class);
    if (!(parame instanceof AppBrandLivePlayerView))
    {
      y.e("MicroMsg.JsApiRemoveLivePlayer", "targetView not AppBrandLivePlayerView");
      return false;
    }
    ((AppBrandLivePlayerView)parame).rX();
    return true;
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("livePlayerId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.f
 * JD-Core Version:    0.7.0.1
 */