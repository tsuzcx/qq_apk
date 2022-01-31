package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class h
  extends b
{
  private static final int CTRL_INDEX = 7;
  public static final String NAME = "removeVideoPlayer";
  
  protected final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.JsApiRemoveVideoPlayer", "onRemoveView videoPlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      y.w("MicroMsg.JsApiRemoveVideoPlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    AppBrandVideoView localAppBrandVideoView = (AppBrandVideoView)((CoverViewContainer)paramView).K(AppBrandVideoView.class);
    if (localAppBrandVideoView == null)
    {
      y.w("MicroMsg.JsApiRemoveVideoPlayer", "onRemoveView not AppBrandVideoView");
      return false;
    }
    ai.d(new h.1(this, localAppBrandVideoView));
    super.b(parame, paramInt, paramView, paramJSONObject);
    return true;
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("videoPlayerId", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.h
 * JD-Core Version:    0.7.0.1
 */