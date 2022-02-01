package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.rtmp.WXLivePlayer;
import org.json.JSONObject;

public final class g
  extends d
{
  private static final int CTRL_INDEX = 365;
  public static final String NAME = "updateLivePlayer";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145895);
    int i = paramJSONObject.optInt("livePlayerId");
    AppMethodBeat.o(145895);
    return i;
  }
  
  public final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145896);
    ad.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView : livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ad.w("MicroMsg.JsApiUpdateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145896);
      return false;
    }
    parame = (View)((CoverViewContainer)paramView).ax(View.class);
    if (!(parame instanceof AppBrandLivePlayerView))
    {
      ad.e("MicroMsg.JsApiUpdateLivePlayer", "targetView not AppBrandLivePlayerView");
      AppMethodBeat.o(145896);
      return false;
    }
    paramView = (AppBrandLivePlayerView)parame;
    parame = k.P(paramJSONObject);
    paramView.csI = parame.getBoolean("needEvent", paramView.csI);
    paramView = paramView.kOO;
    if (!paramView.mInited) {}
    for (parame = new i(-3, "uninited livePlayer");; parame = new i())
    {
      ad.i("MicroMsg.AppBrandLivePlayerView", "onUpdate code:%d info:%s", new Object[] { Integer.valueOf(parame.errorCode), parame.crF });
      AppMethodBeat.o(145896);
      return true;
      l.l("updateLivePlayer", parame);
      paramView.a(parame, false);
      boolean bool = paramView.csy.isPlaying();
      paramJSONObject = parame.getString("playUrl", paramView.csd);
      if ((paramJSONObject != null) && (!paramJSONObject.isEmpty()) && (paramView.csd != null) && (!paramView.csd.equalsIgnoreCase(paramJSONObject)) && (paramView.csy.isPlaying()))
      {
        ad.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + paramView.csd + " playUrl-new = " + paramJSONObject);
        paramView.csy.stopPlay(true);
      }
      paramView.csd = paramJSONObject;
      paramInt = paramView.n(parame);
      if ((paramInt != paramView.csB) && (paramView.csy.isPlaying()))
      {
        ad.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + paramView.csB + " playType-new = " + paramInt);
        paramView.csy.stopPlay(true);
      }
      paramView.csB = paramInt;
      paramView.csg = parame.getBoolean("autoplay", paramView.csg);
      if (((paramView.csg) || (bool)) && (paramView.csd != null) && (!paramView.csd.isEmpty()) && (!paramView.csy.isPlaying()))
      {
        ad.i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
        paramView.csy.startPlay(paramView.csd, paramView.csB);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.g
 * JD-Core Version:    0.7.0.1
 */