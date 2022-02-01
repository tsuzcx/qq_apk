package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/InferContentTypeLogic;", "", "()V", "inferer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/IContentTypeInferer;", "getInferer", "()Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/IContentTypeInferer;", "value", "", "useContentInferer", "getUseContentInferer", "()Z", "setUseContentInferer", "(Z)V", "infer", "", "uri", "Landroid/net/Uri;", "luggage-commons-jsapi-video-ext_release"})
public final class i
{
  private static boolean mCC;
  public static final i mCD;
  
  static
  {
    AppMethodBeat.i(235244);
    mCD = new i();
    mCC = true;
    AppMethodBeat.o(235244);
  }
  
  public static boolean bKL()
  {
    return mCC;
  }
  
  public static void hS(boolean paramBoolean)
  {
    AppMethodBeat.i(235242);
    Log.i("MicroMsg.InferContentTypeLogic", "useContentInferer#set, value: ".concat(String.valueOf(paramBoolean)));
    mCC = paramBoolean;
    AppMethodBeat.o(235242);
  }
  
  public static int r(Uri paramUri)
  {
    AppMethodBeat.i(235243);
    boolean bool = mCC;
    Log.i("MicroMsg.InferContentTypeLogic", "inferer#get, useContentInferer: ".concat(String.valueOf(bool)));
    if (bool) {}
    for (h localh = (h)c.mBV;; localh = (h)l.mCK)
    {
      int i = localh.r(paramUri);
      AppMethodBeat.o(235243);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.i
 * JD-Core Version:    0.7.0.1
 */