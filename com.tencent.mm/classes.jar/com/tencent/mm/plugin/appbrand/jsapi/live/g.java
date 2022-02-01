package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.rtmp.WXLivePlayer;
import org.json.JSONObject;

public final class g
  extends c
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
    parame = k.O(paramJSONObject);
    paramView.clr = parame.getBoolean("needEvent", paramView.clr);
    paramView = paramView.jSG;
    if (!paramView.mInited) {}
    for (parame = new i(-3, "uninited livePlayer");; parame = new i())
    {
      ad.i("MicroMsg.AppBrandLivePlayerView", "onUpdate code:%d info:%s", new Object[] { Integer.valueOf(parame.errorCode), parame.cko });
      AppMethodBeat.o(145896);
      return true;
      l.l("updateLivePlayer", parame);
      paramView.a(parame, false);
      boolean bool = paramView.clh.isPlaying();
      paramJSONObject = parame.getString("playUrl", paramView.ckM);
      if ((paramJSONObject != null) && (!paramJSONObject.isEmpty()) && (paramView.ckM != null) && (!paramView.ckM.equalsIgnoreCase(paramJSONObject)) && (paramView.clh.isPlaying()))
      {
        ad.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + paramView.ckM + " playUrl-new = " + paramJSONObject);
        paramView.clh.stopPlay(true);
      }
      paramView.ckM = paramJSONObject;
      paramInt = paramView.n(parame);
      if ((paramInt != paramView.clk) && (paramView.clh.isPlaying()))
      {
        ad.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + paramView.clk + " playType-new = " + paramInt);
        paramView.clh.stopPlay(true);
      }
      paramView.clk = paramInt;
      paramView.ckP = parame.getBoolean("autoplay", paramView.ckP);
      if (((paramView.ckP) || (bool)) && (paramView.ckM != null) && (!paramView.ckM.isEmpty()) && (!paramView.clh.isPlaying()))
      {
        ad.i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
        paramView.clh.startPlay(paramView.ckM, paramView.clk);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.g
 * JD-Core Version:    0.7.0.1
 */