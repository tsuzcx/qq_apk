package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.protocal.protobuf.cip;
import com.tencent.mm.protocal.protobuf.erm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"TAG", "", "compareTo", "", "Lcom/tencent/mm/protocal/protobuf/RequestPackageInfo;", "other", "", "component1", "L", "R", "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "K", "V", "", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "", "component3", "fillDevUinIfNeed", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "pollResponseItemsByRequest", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "(Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;)[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "toPkgInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaPluginCodeInfo;", "toPkgList", "", "toRequestInfo", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "forcedVersion", "verboseInfo", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class o
{
  private static final int a(erm paramerm, Object paramObject)
  {
    AppMethodBeat.i(180524);
    if ((paramObject instanceof z.a))
    {
      if ((s.p(paramerm.appid, ((z.a)paramObject).appId)) && (paramerm.aazp == ((z.a)paramObject).hDq) && (paramerm.Tqb == ((z.a)paramObject).euz))
      {
        if (s.p(Util.nullAsNil(paramerm.aazm), Util.nullAsNil(((z.a)paramObject).esT)))
        {
          AppMethodBeat.o(180524);
          return 0;
        }
        paramerm = (CharSequence)paramerm.aazm;
        if ((paramerm == null) || (paramerm.length() == 0)) {}
        for (int i = 1; (i != 0) && (s.p("__APP__", ((z.a)paramObject).esT)); i = 0)
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
  
  public static final void a(cip paramcip)
  {
    AppMethodBeat.i(180523);
    s.u(paramcip, "<this>");
    if (k.a.vK(paramcip.aard.Tqb)) {
      try
      {
        if (paramcip.aard.aazp == 6) {}
        String str1;
        for (int i = new p(((at)n.ag(at.class)).eN(paramcip.aard.appid, paramcip.xlz)).intValue();; i = new p(new JSONObject(str1).optLong("dev_key")).intValue())
        {
          paramcip.aari = i;
          AppMethodBeat.o(180523);
          return;
          String str2 = ((t)n.ag(t.class)).cR(paramcip.aard.appid, paramcip.aard.Tqb);
          str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
        }
        AppMethodBeat.o(180523);
      }
      finally
      {
        Log.e("MicroMsg.AppBrand.CommonPkgFetcherUtils", "GetDownloadUrlReqItem.fillDevUin(" + paramcip.aard.appid + ", " + paramcip.aard.Tqb + "), throwable=" + localObject);
      }
    }
  }
  
  public static final <K, V> K j(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    AppMethodBeat.i(180526);
    s.u(paramEntry, "<this>");
    paramEntry = paramEntry.getKey();
    AppMethodBeat.o(180526);
    return paramEntry;
  }
  
  public static final <K, V> V k(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    AppMethodBeat.i(180527);
    s.u(paramEntry, "<this>");
    paramEntry = paramEntry.getValue();
    AppMethodBeat.o(180527);
    return paramEntry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.o
 * JD-Core Version:    0.7.0.1
 */