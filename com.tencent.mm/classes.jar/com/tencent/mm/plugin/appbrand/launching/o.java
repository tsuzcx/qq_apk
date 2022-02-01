package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.protocal.protobuf.bag;
import com.tencent.mm.protocal.protobuf.cvb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import java.util.Map.Entry;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"TAG", "", "compareTo", "", "Lcom/tencent/mm/protocal/protobuf/RequestPackageInfo;", "other", "", "component1", "L", "R", "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "K", "V", "", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "", "component3", "fillDevUinIfNeed", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "pollResponseItemsByRequest", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "(Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;)[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "toPkgInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaPluginCodeInfo;", "toPkgList", "", "toRequestInfo", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "verboseInfo", "plugin-appbrand-integration_release"})
public final class o
{
  private static final int a(cvb paramcvb, Object paramObject)
  {
    AppMethodBeat.i(180524);
    if ((paramObject instanceof z.b))
    {
      if ((d.g.b.p.i(paramcvb.duW, ((z.b)paramObject).appId)) && (paramcvb.GDN == ((z.b)paramObject).dnF) && (paramcvb.FKM == ((z.b)paramObject).hQh))
      {
        if (d.g.b.p.i(bt.nullAsNil(paramcvb.GDK), bt.nullAsNil(((z.b)paramObject).coW)))
        {
          AppMethodBeat.o(180524);
          return 0;
        }
        paramcvb = (CharSequence)paramcvb.GDK;
        if ((paramcvb == null) || (paramcvb.length() == 0)) {}
        for (int i = 1; (i != 0) && (d.g.b.p.i("__APP__", ((z.b)paramObject).coW)); i = 0)
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
  
  public static final void a(bag parambag)
  {
    AppMethodBeat.i(180523);
    d.g.b.p.h(parambag, "$this$fillDevUinIfNeed");
    if (j.a.oN(parambag.Gxp.FKM)) {
      try
      {
        String str2 = ((t)j.T(t.class)).bN(parambag.Gxp.duW, parambag.Gxp.FKM);
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        parambag.Gxu = new com.tencent.mm.b.p(new JSONObject(str1).optLong("dev_key")).intValue();
        AppMethodBeat.o(180523);
        return;
      }
      catch (Throwable localThrowable)
      {
        ad.e("MicroMsg.AppBrand.CommonPkgFetcherUtils", "GetDownloadUrlReqItem.fillDevUin(" + parambag.Gxp.duW + ", " + parambag.Gxp.FKM + "), throwable=" + localThrowable);
      }
    }
    AppMethodBeat.o(180523);
  }
  
  public static final <K, V> K c(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    AppMethodBeat.i(180526);
    d.g.b.p.h(paramEntry, "$this$component1");
    paramEntry = paramEntry.getKey();
    AppMethodBeat.o(180526);
    return paramEntry;
  }
  
  public static final <K, V> V d(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    AppMethodBeat.i(180527);
    d.g.b.p.h(paramEntry, "$this$component2");
    paramEntry = paramEntry.getValue();
    AppMethodBeat.o(180527);
    return paramEntry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.o
 * JD-Core Version:    0.7.0.1
 */