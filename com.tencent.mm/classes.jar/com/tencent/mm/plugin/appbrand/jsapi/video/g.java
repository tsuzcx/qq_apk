package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.base.c
{
  private static final int CTRL_INDEX = 114;
  public static final String NAME = "operateVideoPlayer";
  
  protected final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    int i = -1;
    y.i("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView : videoPlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      y.w("MicroMsg.JsApiOperateVideoPlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    parame = (AppBrandVideoView)((CoverViewContainer)paramView).K(AppBrandVideoView.class);
    if (parame == null)
    {
      y.e("MicroMsg.JsApiOperateVideoPlayer", "view not AppBrandVideoView");
      return false;
    }
    paramView = paramJSONObject.optString("type");
    y.i("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView operateType=%s", new Object[] { paramView });
    switch (paramView.hashCode())
    {
    default: 
      label176:
      paramInt = -1;
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        y.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView operateType not supported: %s", new Object[] { paramView });
        return false;
        if (!paramView.equals("play")) {
          break label176;
        }
        paramInt = 0;
        continue;
        if (!paramView.equals("pause")) {
          break label176;
        }
        paramInt = 1;
        continue;
        if (!paramView.equals("stop")) {
          break label176;
        }
        paramInt = 2;
        continue;
        if (!paramView.equals("requestFullScreen")) {
          break label176;
        }
        paramInt = 3;
        continue;
        if (!paramView.equals("exitFullScreen")) {
          break label176;
        }
        paramInt = 4;
        continue;
        if (!paramView.equals("playbackRate")) {
          break label176;
        }
        paramInt = 5;
        continue;
        if (!paramView.equals("seek")) {
          break label176;
        }
        paramInt = 6;
        continue;
        if (!paramView.equals("sendDanmu")) {
          break label176;
        }
        paramInt = 7;
      }
    }
    parame.start();
    for (;;)
    {
      return true;
      parame.pause();
      continue;
      parame.stop();
      continue;
      paramView = paramJSONObject.optJSONArray("data");
      if ((paramView == null) || (paramView.length() == 0)) {
        y.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView directionArr nil");
      }
      for (paramInt = i;; paramInt = paramView.optInt(0, -1))
      {
        parame.g(true, paramInt);
        break;
      }
      parame.g(false, -1);
      continue;
      paramView = paramJSONObject.optJSONArray("data");
      if ((paramView == null) || (paramView.length() == 0))
      {
        y.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView dataArr nil");
        return false;
      }
      double d = paramView.optDouble(0, -1.0D);
      if (d < 0.0D)
      {
        y.i("MicroMsg.JsApiOperateVideoPlayer", "rate invalid %f", new Object[] { Double.valueOf(d) });
        return false;
      }
      float f = (float)d;
      y.i("MicroMsg.AppBrandVideoView", "setPlaybackRate %s", new Object[] { Float.valueOf(f) });
      parame.gDj.aj(f);
      continue;
      paramView = paramJSONObject.optJSONArray("data");
      if ((paramView == null) || (paramView.length() == 0))
      {
        y.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView dataArr nil");
        return false;
      }
      paramInt = paramView.optInt(0, -1);
      if (paramInt < 0)
      {
        y.i("MicroMsg.JsApiOperateVideoPlayer", "pos invalid %d", new Object[] { Integer.valueOf(paramInt) });
        return false;
      }
      parame.D(paramInt, false);
      continue;
      paramView = paramJSONObject.optJSONArray("data");
      if ((paramView == null) || (paramView.length() == 0))
      {
        y.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView dataArr nil");
        return false;
      }
      if (paramView.length() == 1) {
        parame.bG(paramView.optString(0, ""), "");
      } else {
        parame.bG(paramView.optString(0, ""), paramView.optString(1, ""));
      }
    }
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("videoPlayerId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.g
 * JD-Core Version:    0.7.0.1
 */