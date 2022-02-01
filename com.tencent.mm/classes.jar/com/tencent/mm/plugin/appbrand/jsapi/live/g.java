package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ac;
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
    ac.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView : livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ac.w("MicroMsg.JsApiUpdateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145896);
      return false;
    }
    parame = (View)((CoverViewContainer)paramView).ax(View.class);
    if (!(parame instanceof AppBrandLivePlayerView))
    {
      ac.e("MicroMsg.JsApiUpdateLivePlayer", "targetView not AppBrandLivePlayerView");
      AppMethodBeat.o(145896);
      return false;
    }
    paramView = (AppBrandLivePlayerView)parame;
    parame = k.O(paramJSONObject);
    paramView.cit = parame.getBoolean("needEvent", paramView.cit);
    paramView = paramView.kts;
    if (!paramView.mInited) {}
    for (parame = new i(-3, "uninited livePlayer");; parame = new i())
    {
      ac.i("MicroMsg.AppBrandLivePlayerView", "onUpdate code:%d info:%s", new Object[] { Integer.valueOf(parame.errorCode), parame.chn });
      AppMethodBeat.o(145896);
      return true;
      l.l("updateLivePlayer", parame);
      paramView.a(parame, false);
      boolean bool = paramView.cij.isPlaying();
      paramJSONObject = parame.getString("playUrl", paramView.chO);
      if ((paramJSONObject != null) && (!paramJSONObject.isEmpty()) && (paramView.chO != null) && (!paramView.chO.equalsIgnoreCase(paramJSONObject)) && (paramView.cij.isPlaying()))
      {
        ac.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + paramView.chO + " playUrl-new = " + paramJSONObject);
        paramView.cij.stopPlay(true);
      }
      paramView.chO = paramJSONObject;
      paramInt = paramView.n(parame);
      if ((paramInt != paramView.cim) && (paramView.cij.isPlaying()))
      {
        ac.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + paramView.cim + " playType-new = " + paramInt);
        paramView.cij.stopPlay(true);
      }
      paramView.cim = paramInt;
      paramView.chR = parame.getBoolean("autoplay", paramView.chR);
      if (((paramView.chR) || (bool)) && (paramView.chO != null) && (!paramView.chO.isEmpty()) && (!paramView.cij.isPlaying()))
      {
        ac.i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
        paramView.cij.startPlay(paramView.chO, paramView.cim);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.g
 * JD-Core Version:    0.7.0.1
 */