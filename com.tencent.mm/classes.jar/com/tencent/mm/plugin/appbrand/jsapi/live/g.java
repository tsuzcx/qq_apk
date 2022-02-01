package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class g
  extends c
{
  private static final int CTRL_INDEX = 366;
  public static final String NAME = "removeLivePlayer";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145891);
    int i = paramJSONObject.optInt("livePlayerId");
    AppMethodBeat.o(145891);
    return i;
  }
  
  public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.g paramg, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145892);
    super.b(paramg, paramInt, paramView, paramJSONObject);
    Log.i("MicroMsg.JsApiRemoveLivePlayer", "onRemoveView livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.JsApiRemoveLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145892);
      return false;
    }
    paramg = (View)((CoverViewContainer)paramView).aA(View.class);
    if (!(paramg instanceof AppBrandLivePlayerView))
    {
      Log.e("MicroMsg.JsApiRemoveLivePlayer", "targetView not AppBrandLivePlayerView");
      AppMethodBeat.o(145892);
      return false;
    }
    ((AppBrandLivePlayerView)paramg).onExit();
    AppMethodBeat.o(145892);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.g
 * JD-Core Version:    0.7.0.1
 */