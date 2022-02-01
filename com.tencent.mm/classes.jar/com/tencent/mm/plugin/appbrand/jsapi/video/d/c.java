package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  extends d
{
  private static final int CTRL_INDEX = 114;
  public static final String NAME = "operateVideoPlayer";
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(234928);
    int i = paramJSONObject.optInt("videoPlayerId");
    AppMethodBeat.o(234928);
    return i;
  }
  
  public final boolean c(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(234929);
    Log.i("MicroMsg.JsApiOperateVideoPlayer", "onOperateView videoPlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.JsApiOperateVideoPlayer", "view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(234929);
      return false;
    }
    paramh = (AppBrandVideoView)((CoverViewContainer)paramView).aB(AppBrandVideoView.class);
    if (paramh == null)
    {
      Log.e("MicroMsg.JsApiOperateVideoPlayer", "view not AppBrandVideoView");
      AppMethodBeat.o(234929);
      return false;
    }
    paramView = paramJSONObject.optString("type");
    Log.i("MicroMsg.JsApiOperateVideoPlayer", "onOperateView operateType=%s", new Object[] { paramView });
    paramInt = -1;
    switch (paramView.hashCode())
    {
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        Log.w("MicroMsg.JsApiOperateVideoPlayer", "onOperateView operateType not supported: %s", new Object[] { paramView });
        AppMethodBeat.o(234929);
        return false;
        if (paramView.equals("play"))
        {
          paramInt = 0;
          continue;
          if (paramView.equals("pause"))
          {
            paramInt = 1;
            continue;
            if (paramView.equals("stop"))
            {
              paramInt = 2;
              continue;
              if (paramView.equals("requestFullScreen"))
              {
                paramInt = 3;
                continue;
                if (paramView.equals("exitFullScreen"))
                {
                  paramInt = 4;
                  continue;
                  if (paramView.equals("playbackRate"))
                  {
                    paramInt = 5;
                    continue;
                    if (paramView.equals("seek"))
                    {
                      paramInt = 6;
                      continue;
                      if (paramView.equals("sendDanmu")) {
                        paramInt = 7;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    paramh.start();
    for (;;)
    {
      AppMethodBeat.o(234929);
      return true;
      paramh.pause();
      continue;
      paramh.stop();
      continue;
      paramView = paramJSONObject.optJSONArray("data");
      paramInt = -1;
      if ((paramView == null) || (paramView.length() == 0)) {
        Log.w("MicroMsg.JsApiOperateVideoPlayer", "onOperateView directionArr nil");
      }
      for (;;)
      {
        paramh.p(true, paramInt);
        break;
        paramInt = paramView.optInt(0, -1);
      }
      paramh.p(false, -1);
      continue;
      paramView = paramJSONObject.optJSONArray("data");
      if ((paramView == null) || (paramView.length() == 0))
      {
        Log.w("MicroMsg.JsApiOperateVideoPlayer", "onOperateView dataArr nil");
        AppMethodBeat.o(234929);
        return false;
      }
      double d = paramView.optDouble(0, -1.0D);
      if (d < 0.0D)
      {
        Log.i("MicroMsg.JsApiOperateVideoPlayer", "rate invalid %f", new Object[] { Double.valueOf(d) });
        AppMethodBeat.o(234929);
        return false;
      }
      float f = (float)d;
      Log.i("MicroMsg.Video.AppBrandVideoView", "setPlaybackRate %s", new Object[] { Float.valueOf(f) });
      paramh.mvJ.aO(f);
      continue;
      paramView = paramJSONObject.optJSONArray("data");
      if ((paramView == null) || (paramView.length() == 0))
      {
        Log.w("MicroMsg.JsApiOperateVideoPlayer", "onOperateView dataArr nil");
        AppMethodBeat.o(234929);
        return false;
      }
      d = paramView.optDouble(0, -1.0D);
      if (d < 0.0D)
      {
        Log.i("MicroMsg.JsApiOperateVideoPlayer", "pos invalid %s", new Object[] { Double.valueOf(d) });
        AppMethodBeat.o(234929);
        return false;
      }
      paramh.d(d, false);
      continue;
      paramView = paramJSONObject.optJSONArray("data");
      if ((paramView == null) || (paramView.length() == 0))
      {
        Log.w("MicroMsg.JsApiOperateVideoPlayer", "onOperateView dataArr nil");
        AppMethodBeat.o(234929);
        return false;
      }
      if (paramView.length() == 1) {
        paramh.dG(paramView.optString(0, ""), "");
      } else {
        paramh.dG(paramView.optString(0, ""), paramView.optString(1, ""));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.c
 * JD-Core Version:    0.7.0.1
 */