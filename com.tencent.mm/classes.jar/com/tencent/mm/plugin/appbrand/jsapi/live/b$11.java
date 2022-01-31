package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class b$11
  implements b.a
{
  b$11(b paramb, AppBrandLivePusherView paramAppBrandLivePusherView, String paramString) {}
  
  public final void BO(String paramString)
  {
    AppMethodBeat.i(96102);
    if (!bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, localPath:%s", new Object[] { paramString });
      Bundle localBundle = new Bundle();
      localBundle.putString("backgroundImage", paramString);
      this.hNI.D(localBundle);
      AppMethodBeat.o(96102);
      return;
    }
    ab.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, load background image fail");
    paramString = new HashMap();
    paramString.put("url", this.val$url);
    this.hNI.a(10004, "load background image fail", paramString);
    AppMethodBeat.o(96102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.11
 * JD-Core Version:    0.7.0.1
 */