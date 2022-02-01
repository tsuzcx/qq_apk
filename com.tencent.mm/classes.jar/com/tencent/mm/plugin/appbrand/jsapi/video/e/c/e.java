package com.tencent.mm.plugin.appbrand.jsapi.video.e.c;

import android.content.Context;
import com.google.android.exoplayer2.h.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/DataSourceFactoryCreator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/IDataSourceFactoryCreator;", "()V", "value", "", "cancelCacheWhenPlay", "getCancelCacheWhenPlay", "()Z", "setCancelCacheWhenPlay", "(Z)V", "name", "", "getName", "()Ljava/lang/String;", "create", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "context", "Landroid/content/Context;", "videoCacheService", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IVideoCacheService;", "headers", "", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final String name;
  public static final e sFN;
  private static boolean sFO;
  
  static
  {
    AppMethodBeat.i(328719);
    sFN = new e();
    name = "DataSourceFactoryCreator";
    AppMethodBeat.o(328719);
  }
  
  public static g.a a(Context paramContext, f paramf, Map<String, String> paramMap)
  {
    AppMethodBeat.i(328714);
    s.u(paramContext, "context");
    if ((paramMap == null) && (!i.cvD().sAx))
    {
      g.a locala = null;
      if (paramf != null) {
        if (!sFO) {
          break label61;
        }
      }
      label61:
      for (locala = paramf.cvC(); locala != null; locala = paramf.cvB())
      {
        Log.i("MicroMsg.AppBrand.DataSourceFactoryCreator", "getDataSourceFactory, return customized data source factory");
        AppMethodBeat.o(328714);
        return locala;
      }
    }
    Log.i("MicroMsg.AppBrand.DataSourceFactoryCreator", "getDataSourceFactory, return default data source factory");
    paramContext = k.b(paramContext, paramMap);
    s.s(paramContext, "buildDefaultDataSourceFactory(context, headers)");
    AppMethodBeat.o(328714);
    return paramContext;
  }
  
  public static boolean cwG()
  {
    return sFO;
  }
  
  public static void jO(boolean paramBoolean)
  {
    AppMethodBeat.i(328706);
    Log.i("MicroMsg.AppBrand.DataSourceFactoryCreator", s.X("cancelCacheWhenPlay#set, value: ", Boolean.valueOf(paramBoolean)));
    sFO = paramBoolean;
    AppMethodBeat.o(328706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c.e
 * JD-Core Version:    0.7.0.1
 */