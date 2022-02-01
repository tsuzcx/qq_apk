package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.content.Context;
import com.google.android.exoplayer2.h.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/DataSourceFactoryCreator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/IDataSourceFactoryCreator;", "()V", "value", "", "cancelCacheWhenPlay", "getCancelCacheWhenPlay", "()Z", "setCancelCacheWhenPlay", "(Z)V", "name", "", "getName", "()Ljava/lang/String;", "create", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "context", "Landroid/content/Context;", "videoCacheService", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IVideoCacheService;", "headers", "", "luggage-commons-jsapi-video-ext_release"})
public final class c
{
  private static final String name = "DataSourceFactoryCreator";
  private static boolean pAP;
  public static final c pAQ;
  
  static
  {
    AppMethodBeat.i(228975);
    pAQ = new c();
    name = "DataSourceFactoryCreator";
    AppMethodBeat.o(228975);
  }
  
  public static g.a a(Context paramContext, f paramf, Map<String, String> paramMap)
  {
    AppMethodBeat.i(228973);
    p.k(paramContext, "context");
    if (paramMap == null)
    {
      Object localObject = i.bVn();
      p.j(localObject, "VideoCore.getInstance()");
      if (!((i)localObject).bVp())
      {
        localObject = null;
        if (paramf != null) {
          if (!pAP) {
            break label69;
          }
        }
        label69:
        for (localObject = paramf.bVm(); localObject != null; localObject = paramf.bVl())
        {
          Log.i("MicroMsg.AppBrand.DataSourceFactoryCreator", "getDataSourceFactory, return customized data source factory");
          AppMethodBeat.o(228973);
          return localObject;
        }
      }
    }
    Log.i("MicroMsg.AppBrand.DataSourceFactoryCreator", "getDataSourceFactory, return default data source factory");
    paramContext = h.b(paramContext, paramMap);
    p.j(paramContext, "ExoMediaPlayerUtils.buil…Factory(context, headers)");
    AppMethodBeat.o(228973);
    return paramContext;
  }
  
  public static boolean bWu()
  {
    return pAP;
  }
  
  public static void iK(boolean paramBoolean)
  {
    AppMethodBeat.i(228971);
    Log.i("MicroMsg.AppBrand.DataSourceFactoryCreator", "cancelCacheWhenPlay#set, value: ".concat(String.valueOf(paramBoolean)));
    pAP = paramBoolean;
    AppMethodBeat.o(228971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c
 * JD-Core Version:    0.7.0.1
 */