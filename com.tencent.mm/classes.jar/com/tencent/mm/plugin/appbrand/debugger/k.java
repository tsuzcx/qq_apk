package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bj.c;
import com.tencent.mm.plugin.appbrand.appusage.am;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/debugger/MonkeyUpdateWxaUsageListNotify;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgPushingXmlHandler$IMessageHandler;", "()V", "SAMPLE", "", "handleMessage", "", "xml", "parsedKV", "", "nilAs", "as", "Lkotlin/Function0;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  implements bj.c
{
  private final String qHm = "<sysmsg type=\"AppBrandTestUpdateWxaUsageListNotify\">\n\n<AppBrandTestUpdateWxaUsageListNotify>\n\n    <DeleteCount></DeleteCount>\n\n    <DeleteList>\n\n        <DeleteAppInfo>\n\n            <UserName>%s</UserName>\n\n            <AppID>%s</AppID>\n\n            <AppType>%d</AppType>\n\n        </DeleteAppInfo>\n\n    </DeleteList>\n\n</AppBrandTestUpdateWxaUsageListNotify></sysmsg>";
  
  public final void k(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(319693);
    if (paramMap == null)
    {
      AppMethodBeat.o(319693);
      return;
    }
    int k = Util.getInt((String)paramMap.get(s.X(".sysmsg.AppBrandTestUpdateWxaUsageListNotify", ".DeleteCount")), 0);
    if (k <= 0)
    {
      AppMethodBeat.o(319693);
      return;
    }
    int i;
    if (k >= 0) {
      i = 0;
    }
    for (;;)
    {
      Object localObject1 = new StringBuilder().append(".sysmsg.AppBrandTestUpdateWxaUsageListNotify").append(".DeleteList.DeleteAppInfo");
      int m;
      if (i == 0)
      {
        paramString = "";
        Object localObject2 = paramString;
        paramString = (String)paramMap.get(s.X((String)localObject2, ".UserName"));
        localObject1 = (String)paramMap.get(s.X((String)localObject2, ".AppID"));
        m = Util.getInt((String)paramMap.get(s.X((String)localObject2, ".AppType")), 0);
        localObject2 = (CharSequence)paramString;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label273;
        }
        j = 1;
        label173:
        if (j != 0)
        {
          localObject2 = (CharSequence)localObject1;
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            break label279;
          }
          j = 1;
          label203:
          if (j != 0) {
            break label299;
          }
        }
        localObject2 = (CharSequence)paramString;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label285;
        }
      }
      label273:
      label279:
      label285:
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          paramString = ad.XL((String)localObject1);
        }
        if (localObject1 != null) {
          break label291;
        }
        paramString = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(319693);
        throw paramString;
        paramString = Integer.valueOf(i);
        break;
        j = 0;
        break label173;
        j = 0;
        break label203;
      }
      label291:
      am.D(paramString, (String)localObject1, m);
      label299:
      if (i == k)
      {
        AppMethodBeat.o(319693);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.k
 * JD-Core Version:    0.7.0.1
 */