package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcelable;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.launching.AppBrandCgiPrefetchApi.PullPrefetchResultReq;
import com.tencent.mm.plugin.appbrand.launching.AppBrandCgiPrefetchApi.a;
import com.tencent.mm.plugin.appbrand.launching.AppBrandCgiPrefetchedResp;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/storage/JsApiPrivateGetBackgroundFetchData;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  @Deprecated
  public static final int CTRL_INDEX = -2;
  @Deprecated
  public static final String NAME = "private_getBackgroundFetchData";
  private static final a swj;
  
  static
  {
    AppMethodBeat.i(326604);
    swj = new a((byte)0);
    AppMethodBeat.o(326604);
  }
  
  private static final void a(com.tencent.mm.plugin.appbrand.service.c paramc, int paramInt1, int paramInt2, j paramj)
  {
    AppMethodBeat.i(326603);
    s.u(paramj, "this$0");
    paramc.getRuntime();
    Object localObject = paramc.getRuntime().getInitConfig().eoQ;
    s.s(localObject, "instanceId");
    s.u(localObject, "instanceId");
    localObject = (AppBrandCgiPrefetchedResp)com.tencent.mm.ipcinvoker.j.a(MMApplicationContext.getMainProcessName(), (Parcelable)new AppBrandCgiPrefetchApi.PullPrefetchResultReq((String)localObject, paramInt1), AppBrandCgiPrefetchApi.a.class);
    if ((localObject != null) && (((AppBrandCgiPrefetchedResp)localObject).errCode == 0))
    {
      Map localMap = (Map)new HashMap();
      localMap.put("fetchedData", ((AppBrandCgiPrefetchedResp)localObject).result);
      paramc.callback(paramInt2, paramj.a(a.e.rVt, localMap));
      AppMethodBeat.o(326603);
      return;
    }
    paramc.callback(paramInt2, paramj.a(null, a.e.rVx, null));
    AppMethodBeat.o(326603);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/storage/JsApiPrivateGetBackgroundFetchData$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.j
 * JD-Core Version:    0.7.0.1
 */