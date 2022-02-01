package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.base.c
{
  private static final int CTRL_INDEX = 114;
  public static final String NAME = "operateVideoPlayer";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(194419);
    int i = paramJSONObject.optInt("videoPlayerId");
    AppMethodBeat.o(194419);
    return i;
  }
  
  public final boolean c(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(194420);
    ac.i("MicroMsg.JsApiOperateVideoPlayer", "onOperateView videoPlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ac.w("MicroMsg.JsApiOperateVideoPlayer", "view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(194420);
      return false;
    }
    parame = (AppBrandVideoView)((CoverViewContainer)paramView).ax(AppBrandVideoView.class);
    if (parame == null)
    {
      ac.e("MicroMsg.JsApiOperateVideoPlayer", "view not AppBrandVideoView");
      AppMethodBeat.o(194420);
      return false;
    }
    paramView = paramJSONObject.optString("type");
    ac.i("MicroMsg.JsApiOperateVideoPlayer", "onOperateView operateType=%s", new Object[] { paramView });
    paramInt = -1;
    switch (paramView.hashCode())
    {
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        ac.w("MicroMsg.JsApiOperateVideoPlayer", "onOperateView operateType not supported: %s", new Object[] { paramView });
        AppMethodBeat.o(194420);
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
    parame.start();
    for (;;)
    {
      AppMethodBeat.o(194420);
      return true;
      parame.pause();
      continue;
      parame.stop();
      continue;
      paramView = paramJSONObject.optJSONArray("data");
      paramInt = -1;
      if ((paramView == null) || (paramView.length() == 0)) {
        ac.w("MicroMsg.JsApiOperateVideoPlayer", "onOperateView directionArr nil");
      }
      for (;;)
      {
        parame.q(true, paramInt);
        break;
        paramInt = paramView.optInt(0, -1);
      }
      parame.q(false, -1);
      continue;
      paramView = paramJSONObject.optJSONArray("data");
      if ((paramView == null) || (paramView.length() == 0))
      {
        ac.w("MicroMsg.JsApiOperateVideoPlayer", "onOperateView dataArr nil");
        AppMethodBeat.o(194420);
        return false;
      }
      double d = paramView.optDouble(0, -1.0D);
      if (d < 0.0D)
      {
        ac.i("MicroMsg.JsApiOperateVideoPlayer", "rate invalid %f", new Object[] { Double.valueOf(d) });
        AppMethodBeat.o(194420);
        return false;
      }
      float f = (float)d;
      ac.i("MicroMsg.Video.AppBrandVideoView", "setPlaybackRate %s", new Object[] { Float.valueOf(f) });
      parame.kOc.aB(f);
      continue;
      paramView = paramJSONObject.optJSONArray("data");
      if ((paramView == null) || (paramView.length() == 0))
      {
        ac.w("MicroMsg.JsApiOperateVideoPlayer", "onOperateView dataArr nil");
        AppMethodBeat.o(194420);
        return false;
      }
      d = paramView.optDouble(0, -1.0D);
      if (d < 0.0D)
      {
        ac.i("MicroMsg.JsApiOperateVideoPlayer", "pos invalid %s", new Object[] { Double.valueOf(d) });
        AppMethodBeat.o(194420);
        return false;
      }
      parame.d(d, false);
      continue;
      paramView = paramJSONObject.optJSONArray("data");
      if ((paramView == null) || (paramView.length() == 0))
      {
        ac.w("MicroMsg.JsApiOperateVideoPlayer", "onOperateView dataArr nil");
        AppMethodBeat.o(194420);
        return false;
      }
      if (paramView.length() == 1) {
        parame.dn(paramView.optString(0, ""), "");
      } else {
        parame.dn(paramView.optString(0, ""), paramView.optString(1, ""));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.c
 * JD-Core Version:    0.7.0.1
 */