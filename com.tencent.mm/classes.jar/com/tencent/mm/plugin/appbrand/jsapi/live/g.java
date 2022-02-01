package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.WXLivePlayer;
import org.json.JSONObject;

public final class g
  extends d
{
  private static final int CTRL_INDEX = 365;
  public static final String NAME = "updateLivePlayer";
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145895);
    int i = paramJSONObject.optInt("livePlayerId");
    AppMethodBeat.o(145895);
    return i;
  }
  
  public final boolean c(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145896);
    Log.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView : livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.JsApiUpdateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145896);
      return false;
    }
    paramh = (View)((CoverViewContainer)paramView).aB(View.class);
    if (!(paramh instanceof AppBrandLivePlayerView))
    {
      Log.e("MicroMsg.JsApiUpdateLivePlayer", "targetView not AppBrandLivePlayerView");
      AppMethodBeat.o(145896);
      return false;
    }
    paramView = (AppBrandLivePlayerView)paramh;
    paramh = k.Y(paramJSONObject);
    paramView.cFE = paramh.getBoolean("needEvent", paramView.cFE);
    paramView = paramView.lXC;
    if (!paramView.mInited) {}
    for (paramh = new i(-3, "uninited livePlayer");; paramh = new i())
    {
      Log.i("MicroMsg.AppBrandLivePlayerView", "onUpdate code:%d info:%s", new Object[] { Integer.valueOf(paramh.errorCode), paramh.errorInfo });
      AppMethodBeat.o(145896);
      return true;
      l.l("updateLivePlayer", paramh);
      paramView.a(paramh, false);
      boolean bool = paramView.cFu.isPlaying();
      paramJSONObject = paramh.getString("playUrl", paramView.cEW);
      if ((paramJSONObject != null) && (!paramJSONObject.isEmpty()) && (paramView.cEW != null) && (!paramView.cEW.equalsIgnoreCase(paramJSONObject)) && (paramView.cFu.isPlaying()))
      {
        Log.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + paramView.cEW + " playUrl-new = " + paramJSONObject);
        paramView.cFu.stopPlay(true);
      }
      paramView.cEW = paramJSONObject;
      paramInt = paramView.n(paramh);
      if ((paramInt != paramView.cFx) && (paramView.cFu.isPlaying()))
      {
        Log.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + paramView.cFx + " playType-new = " + paramInt);
        paramView.cFu.stopPlay(true);
      }
      paramView.cFx = paramInt;
      paramView.cEZ = paramh.getBoolean("autoplay", paramView.cEZ);
      if (((paramView.cEZ) || (bool)) && (paramView.cEW != null) && (!paramView.cEW.isEmpty()) && (!paramView.cFu.isPlaying()))
      {
        Log.i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
        paramView.cFu.startPlay(paramView.cEW, paramView.cFx);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.g
 * JD-Core Version:    0.7.0.1
 */