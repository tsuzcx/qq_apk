package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class h
  extends c
{
  private static final int CTRL_INDEX = 362;
  public static final String NAME = "removeLivePusher";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145893);
    int i = paramJSONObject.optInt("livePusherId");
    AppMethodBeat.o(145893);
    return i;
  }
  
  public final boolean b(g paramg, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145894);
    super.b(paramg, paramInt, paramView, paramJSONObject);
    Log.i("MicroMsg.JsApiRemoveLivePusher", "onRemoveView livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.JsApiRemoveLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145894);
      return false;
    }
    paramg = (View)((CoverViewContainer)paramView).aA(View.class);
    if (!(paramg instanceof AppBrandLivePusherView))
    {
      Log.e("MicroMsg.JsApiRemoveLivePusher", "targetView not AppBrandLivePusherView");
      AppMethodBeat.o(145894);
      return false;
    }
    ((AppBrandLivePusherView)paramg).onExit();
    AppMethodBeat.o(145894);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.h
 * JD-Core Version:    0.7.0.1
 */