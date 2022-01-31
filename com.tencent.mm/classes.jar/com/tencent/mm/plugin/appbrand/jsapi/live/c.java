package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.base.c
{
  private static final int CTRL_INDEX = 367;
  public static final String NAME = "operateLivePlayer";
  
  public final boolean aCb()
  {
    return true;
  }
  
  public final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject, g paramg)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(96111);
    ab.i("MicroMsg.JsApiOperateLivePlayer", "onOperateView : livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ab.w("MicroMsg.JsApiOperateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(96111);
      return false;
    }
    Object localObject1 = (View)((CoverViewContainer)paramView).aa(View.class);
    if (!(localObject1 instanceof AppBrandLivePlayerView))
    {
      ab.e("MicroMsg.JsApiOperateLivePlayer", "targetView not AppBrandLivePlayerView");
      AppMethodBeat.o(96111);
      return false;
    }
    localObject1 = (AppBrandLivePlayerView)localObject1;
    Object localObject2 = paramJSONObject.optString("type");
    ab.i("MicroMsg.JsApiOperateLivePlayer", "onOperateView operateType=%s", new Object[] { localObject2 });
    if (((String)localObject2).equalsIgnoreCase("snapshot"))
    {
      ((AppBrandLivePlayerView)localObject1).setSnapshotListener(new c.1(this, paramg, parame));
      if (!((AppBrandLivePlayerView)localObject1).Cd("snapshot")) {
        paramg.BS(j("fail:snapshot error", null));
      }
      boolean bool = super.b(parame, paramInt, paramView, paramJSONObject, paramg);
      AppMethodBeat.o(96111);
      return bool;
    }
    if (((String)localObject2).equalsIgnoreCase("requestFullScreen"))
    {
      localObject2 = paramJSONObject.optJSONArray("data");
      if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0))
      {
        ab.w("MicroMsg.JsApiOperateLivePlayer", "onOperateView directionArr nil");
        i = 0;
        label240:
        ab.i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen direction:%s", new Object[] { Integer.valueOf(i) });
        if (((AppBrandLivePlayerView)localObject1).hNr != null) {
          break label313;
        }
        ab.w("MicroMsg.AppBrandLivePlayerView", "enterFullScreen mFullScreenDelegate null");
        i = 0;
        label277:
        if (i == 0) {
          break label372;
        }
      }
      label313:
      label372:
      for (localObject1 = "ok";; localObject1 = "fail")
      {
        paramg.BS(j((String)localObject1, null));
        break;
        i = ((JSONArray)localObject2).optInt(0, 0);
        break label240;
        if (((AppBrandLivePlayerView)localObject1).hNr.isFullScreen())
        {
          ab.i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen already full screen");
          i = j;
          break label277;
        }
        ((AppBrandLivePlayerView)localObject1).hNr.oc(i);
        ((AppBrandLivePlayerView)localObject1).hNt = i;
        ((AppBrandLivePlayerView)localObject1).eg(true);
        i = j;
        break label277;
      }
    }
    if (((String)localObject2).equalsIgnoreCase("exitFullScreen"))
    {
      ab.i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen");
      if (((AppBrandLivePlayerView)localObject1).hNr == null)
      {
        ab.w("MicroMsg.AppBrandLivePlayerView", "quitFullScreen mFullScreenDelegate null");
        label411:
        if (i == 0) {
          break label477;
        }
      }
      label477:
      for (localObject1 = "ok";; localObject1 = "fail")
      {
        paramg.BS(j((String)localObject1, null));
        break;
        if (!((AppBrandLivePlayerView)localObject1).hNr.isFullScreen())
        {
          ab.i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen already quit full screen");
          i = 1;
          break label411;
        }
        ((AppBrandLivePlayerView)localObject1).hNr.aDh();
        i = 1;
        break label411;
      }
    }
    if (((AppBrandLivePlayerView)localObject1).Cd((String)localObject2)) {}
    for (localObject1 = "ok";; localObject1 = "fail")
    {
      paramg.BS(j((String)localObject1, null));
      break;
    }
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96110);
    int i = paramJSONObject.optInt("livePlayerId");
    AppMethodBeat.o(96110);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.c
 * JD-Core Version:    0.7.0.1
 */