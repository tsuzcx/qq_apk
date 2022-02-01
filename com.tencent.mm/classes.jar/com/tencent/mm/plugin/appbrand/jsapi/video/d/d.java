package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import org.json.JSONObject;

public final class d
  extends c
{
  private static final int CTRL_INDEX = 7;
  public static final String NAME = "removeVideoPlayer";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(211262);
    int i = paramJSONObject.optInt("videoPlayerId", 0);
    AppMethodBeat.o(211262);
    return i;
  }
  
  public final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(211263);
    ae.i("MicroMsg.JsApiRemoveVideoPlayer", "onRemoveView videoPlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ae.w("MicroMsg.JsApiRemoveVideoPlayer", "view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(211263);
      return false;
    }
    final AppBrandVideoView localAppBrandVideoView = (AppBrandVideoView)((CoverViewContainer)paramView).ax(AppBrandVideoView.class);
    if (localAppBrandVideoView == null)
    {
      ae.w("MicroMsg.JsApiRemoveVideoPlayer", "view not AppBrandVideoView");
      AppMethodBeat.o(211263);
      return false;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211261);
        localAppBrandVideoView.clean();
        AppMethodBeat.o(211261);
      }
    });
    super.b(parame, paramInt, paramView, paramJSONObject);
    AppMethodBeat.o(211263);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.d
 * JD-Core Version:    0.7.0.1
 */