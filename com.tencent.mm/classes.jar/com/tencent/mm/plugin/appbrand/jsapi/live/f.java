package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class f
  extends c
{
  private static final int CTRL_INDEX = 362;
  public static final String NAME = "removeLivePusher";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145893);
    int i = paramJSONObject.optInt("livePusherId");
    AppMethodBeat.o(145893);
    return i;
  }
  
  public final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145894);
    super.b(parame, paramInt, paramView, paramJSONObject);
    ae.i("MicroMsg.JsApiRemoveLivePusher", "onRemoveView livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ae.w("MicroMsg.JsApiRemoveLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145894);
      return false;
    }
    parame = (View)((CoverViewContainer)paramView).ax(View.class);
    if (!(parame instanceof AppBrandLivePusherView))
    {
      ae.e("MicroMsg.JsApiRemoveLivePusher", "targetView not AppBrandLivePusherView");
      AppMethodBeat.o(145894);
      return false;
    }
    ((AppBrandLivePusherView)parame).onExit();
    AppMethodBeat.o(145894);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.f
 * JD-Core Version:    0.7.0.1
 */