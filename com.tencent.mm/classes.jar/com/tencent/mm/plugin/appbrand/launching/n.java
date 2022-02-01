package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.protocal.protobuf.btu;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map.Entry;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"TAG", "", "compareTo", "", "Lcom/tencent/mm/protocal/protobuf/RequestPackageInfo;", "other", "", "component1", "L", "R", "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "K", "V", "", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "", "component3", "fillDevUinIfNeed", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "pollResponseItemsByRequest", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "(Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;)[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "toPkgInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaPluginCodeInfo;", "toPkgList", "", "toRequestInfo", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "forcedVersion", "verboseInfo", "plugin-appbrand-integration_release"})
public final class n
{
  private static final int a(dyi paramdyi, Object paramObject)
  {
    AppMethodBeat.i(180524);
    if ((paramObject instanceof x.a))
    {
      if ((kotlin.g.b.p.h(paramdyi.appid, ((x.a)paramObject).appId)) && (paramdyi.TnG == ((x.a)paramObject).fyH) && (paramdyi.RYL == ((x.a)paramObject).cBU))
      {
        if (kotlin.g.b.p.h(Util.nullAsNil(paramdyi.TnI), Util.nullAsNil(((x.a)paramObject).cAy)))
        {
          AppMethodBeat.o(180524);
          return 0;
        }
        paramdyi = (CharSequence)paramdyi.TnI;
        if ((paramdyi == null) || (paramdyi.length() == 0)) {}
        for (int i = 1; (i != 0) && (kotlin.g.b.p.h("__APP__", ((x.a)paramObject).cAy)); i = 0)
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
  
  public static final void a(btu parambtu)
  {
    AppMethodBeat.i(180523);
    kotlin.g.b.p.k(parambtu, "$this$fillDevUinIfNeed");
    if (j.a.vB(parambtu.TdO.RYL)) {
      try
      {
        if (parambtu.TdO.TnG == 6) {}
        String str1;
        for (int i = new com.tencent.mm.b.p(((ar)m.W(ar.class)).ev(parambtu.TdO.appid, parambtu.ufy)).intValue();; i = new com.tencent.mm.b.p(new JSONObject(str1).optLong("dev_key")).intValue())
        {
          parambtu.TdT = i;
          AppMethodBeat.o(180523);
          return;
          String str2 = ((s)m.W(s.class)).cs(parambtu.TdO.appid, parambtu.TdO.RYL);
          str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
        }
        AppMethodBeat.o(180523);
      }
      catch (Throwable localThrowable)
      {
        Log.e("MicroMsg.AppBrand.CommonPkgFetcherUtils", "GetDownloadUrlReqItem.fillDevUin(" + parambtu.TdO.appid + ", " + parambtu.TdO.RYL + "), throwable=" + localThrowable);
      }
    }
  }
  
  public static final <K, V> K f(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    AppMethodBeat.i(180526);
    kotlin.g.b.p.k(paramEntry, "$this$component1");
    paramEntry = paramEntry.getKey();
    AppMethodBeat.o(180526);
    return paramEntry;
  }
  
  public static final <K, V> V g(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    AppMethodBeat.i(180527);
    kotlin.g.b.p.k(paramEntry, "$this$component2");
    paramEntry = paramEntry.getValue();
    AppMethodBeat.o(180527);
    return paramEntry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.n
 * JD-Core Version:    0.7.0.1
 */