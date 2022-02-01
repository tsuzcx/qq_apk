package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.cpw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import java.util.Map.Entry;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"TAG", "", "compareTo", "", "Lcom/tencent/mm/protocal/protobuf/RequestPackageInfo;", "other", "", "component1", "L", "R", "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "K", "V", "", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "", "component3", "fillDevUinIfNeed", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "pollResponseItemsByRequest", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "(Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;)[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "toPkgInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaPluginCodeInfo;", "toPkgList", "", "toRequestInfo", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "verboseInfo", "plugin-appbrand-integration_release"})
public final class o
{
  private static final int a(cpw paramcpw, Object paramObject)
  {
    AppMethodBeat.i(180524);
    if ((paramObject instanceof z.b))
    {
      if ((k.g(paramcpw.djj, ((z.b)paramObject).appId)) && (paramcpw.EUq == ((z.b)paramObject).dcj) && (paramcpw.Een == ((z.b)paramObject).hxM))
      {
        if (k.g(bs.nullAsNil(paramcpw.EUn), bs.nullAsNil(((z.b)paramObject).ceF)))
        {
          AppMethodBeat.o(180524);
          return 0;
        }
        paramcpw = (CharSequence)paramcpw.EUn;
        if ((paramcpw == null) || (paramcpw.length() == 0)) {}
        for (int i = 1; (i != 0) && (k.g("__APP__", ((z.b)paramObject).ceF)); i = 0)
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
  
  public static final void a(awi paramawi)
  {
    AppMethodBeat.i(180523);
    k.h(paramawi, "$this$fillDevUinIfNeed");
    if (j.a.on(paramawi.EOl.Een)) {
      try
      {
        String str2 = ((t)j.T(t.class)).bK(paramawi.EOl.djj, paramawi.EOl.Een);
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        paramawi.EOq = new p(new JSONObject(str1).optLong("dev_key")).intValue();
        AppMethodBeat.o(180523);
        return;
      }
      catch (Throwable localThrowable)
      {
        ac.e("MicroMsg.AppBrand.CommonPkgFetcherUtils", "GetDownloadUrlReqItem.fillDevUin(" + paramawi.EOl.djj + ", " + paramawi.EOl.Een + "), throwable=" + localThrowable);
      }
    }
    AppMethodBeat.o(180523);
  }
  
  public static final <K, V> K c(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    AppMethodBeat.i(180526);
    k.h(paramEntry, "$this$component1");
    paramEntry = paramEntry.getKey();
    AppMethodBeat.o(180526);
    return paramEntry;
  }
  
  public static final <K, V> V d(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    AppMethodBeat.i(180527);
    k.h(paramEntry, "$this$component2");
    paramEntry = paramEntry.getValue();
    AppMethodBeat.o(180527);
    return paramEntry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.o
 * JD-Core Version:    0.7.0.1
 */