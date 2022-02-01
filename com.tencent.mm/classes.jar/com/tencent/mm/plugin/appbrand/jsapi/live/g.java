package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ae;
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
    ae.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView : livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ae.w("MicroMsg.JsApiUpdateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145896);
      return false;
    }
    parame = (View)((CoverViewContainer)paramView).ax(View.class);
    if (!(parame instanceof AppBrandLivePlayerView))
    {
      ae.e("MicroMsg.JsApiUpdateLivePlayer", "targetView not AppBrandLivePlayerView");
      AppMethodBeat.o(145896);
      return false;
    }
    paramView = (AppBrandLivePlayerView)parame;
    parame = k.P(paramJSONObject);
    paramView.ctl = parame.getBoolean("needEvent", paramView.ctl);
    paramView = paramView.kSw;
    if (!paramView.mInited) {}
    for (parame = new i(-3, "uninited livePlayer");; parame = new i())
    {
      ae.i("MicroMsg.AppBrandLivePlayerView", "onUpdate code:%d info:%s", new Object[] { Integer.valueOf(parame.errorCode), parame.csi });
      AppMethodBeat.o(145896);
      return true;
      l.l("updateLivePlayer", parame);
      paramView.a(parame, false);
      boolean bool = paramView.ctb.isPlaying();
      paramJSONObject = parame.getString("playUrl", paramView.csG);
      if ((paramJSONObject != null) && (!paramJSONObject.isEmpty()) && (paramView.csG != null) && (!paramView.csG.equalsIgnoreCase(paramJSONObject)) && (paramView.ctb.isPlaying()))
      {
        ae.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + paramView.csG + " playUrl-new = " + paramJSONObject);
        paramView.ctb.stopPlay(true);
      }
      paramView.csG = paramJSONObject;
      paramInt = paramView.n(parame);
      if ((paramInt != paramView.cte) && (paramView.ctb.isPlaying()))
      {
        ae.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + paramView.cte + " playType-new = " + paramInt);
        paramView.ctb.stopPlay(true);
      }
      paramView.cte = paramInt;
      paramView.csJ = parame.getBoolean("autoplay", paramView.csJ);
      if (((paramView.csJ) || (bool)) && (paramView.csG != null) && (!paramView.csG.isEmpty()) && (!paramView.ctb.isPlaying()))
      {
        ae.i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
        paramView.ctb.startPlay(paramView.csG, paramView.cte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.g
 * JD-Core Version:    0.7.0.1
 */