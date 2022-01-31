package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class h$2
  implements b.a
{
  h$2(h paramh, AppBrandLivePusherView paramAppBrandLivePusherView) {}
  
  public final void BO(String paramString)
  {
    AppMethodBeat.i(96124);
    if (!bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.JsApiUpdateLivePusher", "convertWatermarkImageToLocalPath, localPath:%s", new Object[] { paramString });
      Bundle localBundle = new Bundle();
      localBundle.putString("watermarkImage", paramString);
      this.hNI.D(localBundle);
    }
    AppMethodBeat.o(96124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.h.2
 * JD-Core Version:    0.7.0.1
 */