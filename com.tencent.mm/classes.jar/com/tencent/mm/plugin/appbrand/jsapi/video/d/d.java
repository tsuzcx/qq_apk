package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONObject;

public final class d
  extends c
{
  private static final int CTRL_INDEX = 7;
  public static final String NAME = "removeVideoPlayer";
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(234931);
    int i = paramJSONObject.optInt("videoPlayerId", 0);
    AppMethodBeat.o(234931);
    return i;
  }
  
  public final boolean b(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(234932);
    Log.i("MicroMsg.JsApiRemoveVideoPlayer", "onRemoveView videoPlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.JsApiRemoveVideoPlayer", "view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(234932);
      return false;
    }
    final AppBrandVideoView localAppBrandVideoView = (AppBrandVideoView)((CoverViewContainer)paramView).aB(AppBrandVideoView.class);
    if (localAppBrandVideoView == null)
    {
      Log.w("MicroMsg.JsApiRemoveVideoPlayer", "view not AppBrandVideoView");
      AppMethodBeat.o(234932);
      return false;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(234930);
        localAppBrandVideoView.clean();
        AppMethodBeat.o(234930);
      }
    });
    super.b(paramh, paramInt, paramView, paramJSONObject);
    AppMethodBeat.o(234932);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.d
 * JD-Core Version:    0.7.0.1
 */