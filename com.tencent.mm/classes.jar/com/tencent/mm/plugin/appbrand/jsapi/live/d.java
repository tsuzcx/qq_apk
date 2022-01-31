package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends c
{
  private static final int CTRL_INDEX = 367;
  public static final String NAME = "operateLivePlayer";
  
  protected final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.JsApiOperateLivePlayer", "onUpdateView : livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      y.w("MicroMsg.JsApiOperateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      label43:
      return false;
    }
    parame = (View)((CoverViewContainer)paramView).K(View.class);
    if (!(parame instanceof AppBrandLivePlayerView))
    {
      y.e("MicroMsg.JsApiOperateLivePlayer", "targetView not AppBrandLivePlayerView");
      return false;
    }
    parame = (AppBrandLivePlayerView)parame;
    paramView = paramJSONObject.optString("type");
    y.i("MicroMsg.JsApiOperateLivePlayer", "onUpdateView operateType=%s", new Object[] { paramView });
    paramInt = -1;
    switch (paramView.hashCode())
    {
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        parame = parame.grW.ue(paramView);
        y.i("MicroMsg.AppBrandLivePlayerView", "onOperate code:%d info:%s", new Object[] { Integer.valueOf(parame.errorCode), parame.gst });
        if (parame.errorCode != 0) {
          break label43;
        }
        return true;
        if (paramView.equals("requestFullScreen"))
        {
          paramInt = 0;
          continue;
          if (paramView.equals("exitFullScreen")) {
            paramInt = 1;
          }
        }
        break;
      }
    }
    paramView = paramJSONObject.optJSONArray("data");
    if ((paramView == null) || (paramView.length() == 0)) {
      y.w("MicroMsg.JsApiOperateLivePlayer", "onUpdateView directionArr nil");
    }
    for (paramInt = 0;; paramInt = paramView.optInt(0, 0))
    {
      y.i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen direction:%s", new Object[] { Integer.valueOf(paramInt) });
      if (parame.grX != null) {
        break;
      }
      y.w("MicroMsg.AppBrandLivePlayerView", "enterFullScreen mFullScreenDelegate null");
      return false;
    }
    if (parame.grX.isFullScreen())
    {
      y.i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen already full screen");
      return true;
    }
    parame.grX.lu(paramInt);
    parame.grZ = paramInt;
    parame.dd(true);
    return true;
    y.i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen");
    if (parame.grX == null)
    {
      y.w("MicroMsg.AppBrandLivePlayerView", "quitFullScreen mFullScreenDelegate null");
      return false;
    }
    if (!parame.grX.isFullScreen())
    {
      y.i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen already quit full screen");
      return true;
    }
    parame.grX.aiZ();
    return true;
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("livePlayerId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.d
 * JD-Core Version:    0.7.0.1
 */