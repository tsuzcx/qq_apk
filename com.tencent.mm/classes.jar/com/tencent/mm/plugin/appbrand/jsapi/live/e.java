package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class e
  extends b
{
  private static final int CTRL_INDEX = 366;
  public static final String NAME = "removeLivePlayer";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145891);
    int i = paramJSONObject.optInt("livePlayerId");
    AppMethodBeat.o(145891);
    return i;
  }
  
  public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145892);
    super.b(parame, paramInt, paramView, paramJSONObject);
    ad.i("MicroMsg.JsApiRemoveLivePlayer", "onRemoveView livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ad.w("MicroMsg.JsApiRemoveLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145892);
      return false;
    }
    parame = (View)((CoverViewContainer)paramView).ax(View.class);
    if (!(parame instanceof AppBrandLivePlayerView))
    {
      ad.e("MicroMsg.JsApiRemoveLivePlayer", "targetView not AppBrandLivePlayerView");
      AppMethodBeat.o(145892);
      return false;
    }
    ((AppBrandLivePlayerView)parame).onExit();
    AppMethodBeat.o(145892);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.e
 * JD-Core Version:    0.7.0.1
 */