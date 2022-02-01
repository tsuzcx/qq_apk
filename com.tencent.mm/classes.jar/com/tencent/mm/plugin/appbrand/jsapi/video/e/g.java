package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/InferContentTypeLogic;", "", "()V", "inferer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IContentTypeInferer;", "getInferer", "()Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IContentTypeInferer;", "value", "", "useContentInferer", "getUseContentInferer", "()Z", "setUseContentInferer", "(Z)V", "useNewInputStream", "getUseNewInputStream", "setUseNewInputStream", "infer", "", "videoCacheService", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IVideoCacheService;", "uri", "Landroid/net/Uri;", "luggage-commons-jsapi-video-ext_release"})
public final class g
{
  private static boolean pzO;
  private static boolean pzP;
  public static final g pzQ;
  
  static
  {
    AppMethodBeat.i(229111);
    pzQ = new g();
    pzO = true;
    AppMethodBeat.o(229111);
  }
  
  public static int a(f paramf, Uri paramUri)
  {
    AppMethodBeat.i(229110);
    boolean bool = pzO;
    Log.i("MicroMsg.InferContentTypeLogic", "inferer#get, useContentInferer: ".concat(String.valueOf(bool)));
    if (bool) {}
    for (d locald = (d)b.pzD;; locald = (d)j.pAg)
    {
      int i = locald.a(paramf, paramUri);
      AppMethodBeat.o(229110);
      return i;
    }
  }
  
  public static boolean bWm()
  {
    return pzO;
  }
  
  public static boolean bWn()
  {
    return pzP;
  }
  
  public static void iI(boolean paramBoolean)
  {
    AppMethodBeat.i(229107);
    Log.i("MicroMsg.InferContentTypeLogic", "useContentInferer#set, value: ".concat(String.valueOf(paramBoolean)));
    pzO = paramBoolean;
    AppMethodBeat.o(229107);
  }
  
  public static void iJ(boolean paramBoolean)
  {
    AppMethodBeat.i(229109);
    Log.i("MicroMsg.InferContentTypeLogic", "useNewInputStream#set, value: ".concat(String.valueOf(paramBoolean)));
    pzP = paramBoolean;
    AppMethodBeat.o(229109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.g
 * JD-Core Version:    0.7.0.1
 */