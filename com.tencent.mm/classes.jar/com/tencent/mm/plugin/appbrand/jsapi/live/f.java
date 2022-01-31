package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class f
  extends b
{
  private static final int CTRL_INDEX = 362;
  public static final String NAME = "removeLivePusher";
  
  public final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96119);
    super.b(parame, paramInt, paramView, paramJSONObject);
    ab.i("MicroMsg.JsApiRemoveLivePusher", "onRemoveView livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ab.w("MicroMsg.JsApiRemoveLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(96119);
      return false;
    }
    parame = (View)((CoverViewContainer)paramView).aa(View.class);
    if (!(parame instanceof AppBrandLivePusherView))
    {
      ab.e("MicroMsg.JsApiRemoveLivePusher", "targetView not AppBrandLivePusherView");
      AppMethodBeat.o(96119);
      return false;
    }
    ((AppBrandLivePusherView)parame).onExit();
    AppMethodBeat.o(96119);
    return true;
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96118);
    int i = paramJSONObject.optInt("livePusherId");
    AppMethodBeat.o(96118);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.f
 * JD-Core Version:    0.7.0.1
 */