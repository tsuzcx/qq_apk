package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.protocal.protobuf.doo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map.Entry;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"TAG", "", "compareTo", "", "Lcom/tencent/mm/protocal/protobuf/RequestPackageInfo;", "other", "", "component1", "L", "R", "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "K", "V", "", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "", "component3", "fillDevUinIfNeed", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "pollResponseItemsByRequest", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "(Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;)[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "toPkgInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaPluginCodeInfo;", "toPkgList", "", "toRequestInfo", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "verboseInfo", "plugin-appbrand-integration_release"})
public final class o
{
  private static final int a(doo paramdoo, Object paramObject)
  {
    AppMethodBeat.i(180524);
    if ((paramObject instanceof y.b))
    {
      if ((kotlin.g.b.p.j(paramdoo.dNI, ((y.b)paramObject).appId)) && (paramdoo.MbZ == ((y.b)paramObject).packageType) && (paramdoo.KXC == ((y.b)paramObject).iOo))
      {
        if (kotlin.g.b.p.j(Util.nullAsNil(paramdoo.MbW), Util.nullAsNil(((y.b)paramObject).cBp)))
        {
          AppMethodBeat.o(180524);
          return 0;
        }
        paramdoo = (CharSequence)paramdoo.MbW;
        if ((paramdoo == null) || (paramdoo.length() == 0)) {}
        for (int i = 1; (i != 0) && (kotlin.g.b.p.j("__APP__", ((y.b)paramObject).cBp)); i = 0)
        {
          AppMethodBeat.o(180524);
          return 0;
        }
        AppMethodBeat.o(180524);
        return 1;
      }
      AppMethodBeat.o(180524);
      return 1;
    }
    AppMethodBeat.o(180524);
    return -1;
  }
  
  public static final void a(bml parambml)
  {
    AppMethodBeat.i(180523);
    kotlin.g.b.p.h(parambml, "$this$fillDevUinIfNeed");
    if (j.a.sE(parambml.LVf.KXC)) {
      try
      {
        String str2 = ((t)n.W(t.class)).bU(parambml.LVf.dNI, parambml.LVf.KXC);
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        parambml.LVk = new com.tencent.mm.b.p(new JSONObject(str1).optLong("dev_key")).intValue();
        AppMethodBeat.o(180523);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.e("MicroMsg.AppBrand.CommonPkgFetcherUtils", "GetDownloadUrlReqItem.fillDevUin(" + parambml.LVf.dNI + ", " + parambml.LVf.KXC + "), throwable=" + localThrowable);
      }
    }
    AppMethodBeat.o(180523);
  }
  
  public static final <K, V> K e(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    AppMethodBeat.i(180526);
    kotlin.g.b.p.h(paramEntry, "$this$component1");
    paramEntry = paramEntry.getKey();
    AppMethodBeat.o(180526);
    return paramEntry;
  }
  
  public static final <K, V> V f(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    AppMethodBeat.i(180527);
    kotlin.g.b.p.h(paramEntry, "$this$component2");
    paramEntry = paramEntry.getValue();
    AppMethodBeat.o(180527);
    return paramEntry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.o
 * JD-Core Version:    0.7.0.1
 */