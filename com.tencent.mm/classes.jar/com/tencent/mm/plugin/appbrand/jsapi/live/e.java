package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class e
  extends b
{
  private static final int CTRL_INDEX = 366;
  public static final String NAME = "removeLivePlayer";
  
  public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96117);
    super.b(parame, paramInt, paramView, paramJSONObject);
    ab.i("MicroMsg.JsApiRemoveLivePlayer", "onRemoveView livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ab.w("MicroMsg.JsApiRemoveLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(96117);
      return false;
    }
    parame = (View)((CoverViewContainer)paramView).aa(View.class);
    if (!(parame instanceof AppBrandLivePlayerView))
    {
      ab.e("MicroMsg.JsApiRemoveLivePlayer", "targetView not AppBrandLivePlayerView");
      AppMethodBeat.o(96117);
      return false;
    }
    ((AppBrandLivePlayerView)parame).onExit();
    AppMethodBeat.o(96117);
    return true;
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96116);
    int i = paramJSONObject.optInt("livePlayerId");
    AppMethodBeat.o(96116);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.e
 * JD-Core Version:    0.7.0.1
 */