package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h
  extends c
{
  private static final int CTRL_INDEX = 114;
  public static final String NAME = "operateVideoPlayer";
  
  public final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126564);
    ab.i("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView : videoPlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ab.w("MicroMsg.JsApiOperateVideoPlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126564);
      return false;
    }
    parame = (AppBrandVideoView)((CoverViewContainer)paramView).aa(AppBrandVideoView.class);
    if (parame == null)
    {
      ab.e("MicroMsg.JsApiOperateVideoPlayer", "view not AppBrandVideoView");
      AppMethodBeat.o(126564);
      return false;
    }
    paramView = paramJSONObject.optString("type");
    ab.i("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView operateType=%s", new Object[] { paramView });
    paramInt = -1;
    switch (paramView.hashCode())
    {
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        ab.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView operateType not supported: %s", new Object[] { paramView });
        AppMethodBeat.o(126564);
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
      AppMethodBeat.o(126564);
      return true;
      parame.pause();
      continue;
      parame.stop();
      continue;
      paramView = paramJSONObject.optJSONArray("data");
      paramInt = -1;
      if ((paramView == null) || (paramView.length() == 0)) {
        ab.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView directionArr nil");
      }
      for (;;)
      {
        parame.l(true, paramInt);
        break;
        paramInt = paramView.optInt(0, -1);
      }
      parame.l(false, -1);
      continue;
      paramView = paramJSONObject.optJSONArray("data");
      if ((paramView == null) || (paramView.length() == 0))
      {
        ab.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView dataArr nil");
        AppMethodBeat.o(126564);
        return false;
      }
      double d = paramView.optDouble(0, -1.0D);
      if (d < 0.0D)
      {
        ab.i("MicroMsg.JsApiOperateVideoPlayer", "rate invalid %f", new Object[] { Double.valueOf(d) });
        AppMethodBeat.o(126564);
        return false;
      }
      float f = (float)d;
      ab.i("MicroMsg.AppBrandVideoView", "setPlaybackRate %s", new Object[] { Float.valueOf(f) });
      parame.icl.ay(f);
      continue;
      paramView = paramJSONObject.optJSONArray("data");
      if ((paramView == null) || (paramView.length() == 0))
      {
        ab.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView dataArr nil");
        AppMethodBeat.o(126564);
        return false;
      }
      d = paramView.optDouble(0, -1.0D);
      if (d < 0.0D)
      {
        ab.i("MicroMsg.JsApiOperateVideoPlayer", "pos invalid %s", new Object[] { Double.valueOf(d) });
        AppMethodBeat.o(126564);
        return false;
      }
      parame.e(d, false);
      continue;
      paramView = paramJSONObject.optJSONArray("data");
      if ((paramView == null) || (paramView.length() == 0))
      {
        ab.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView dataArr nil");
        AppMethodBeat.o(126564);
        return false;
      }
      if (paramView.length() == 1) {
        parame.cp(paramView.optString(0, ""), "");
      } else {
        parame.cp(paramView.optString(0, ""), paramView.optString(1, ""));
      }
    }
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126563);
    int i = paramJSONObject.optInt("videoPlayerId");
    AppMethodBeat.o(126563);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.h
 * JD-Core Version:    0.7.0.1
 */