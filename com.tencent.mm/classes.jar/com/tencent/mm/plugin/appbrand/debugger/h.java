package com.tencent.mm.plugin.appbrand.debugger;

import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.av.c;
import com.tencent.mm.plugin.appbrand.appusage.al;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/debugger/MonkeyUpdateWxaUsageListNotify;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgPushingXmlHandler$IMessageHandler;", "()V", "SAMPLE", "", "handleMessage", "", "parsedKV", "", "nilAs", "as", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
public final class h
  implements av.c
{
  private final String hli = "<sysmsg type=\"AppBrandTestUpdateWxaUsageListNotify\">\n\n<AppBrandTestUpdateWxaUsageListNotify>\n\n    <DeleteCount></DeleteCount>\n\n    <DeleteList>\n\n        <DeleteAppInfo>\n\n            <UserName>%s</UserName>\n\n            <AppID>%s</AppID>\n\n            <AppType>%d</AppType>\n\n        </DeleteAppInfo>\n\n    </DeleteList>\n\n</AppBrandTestUpdateWxaUsageListNotify></sysmsg>";
  
  public final void t(Map<String, String> paramMap)
  {
    AppMethodBeat.i(134601);
    if (paramMap == null)
    {
      AppMethodBeat.o(134601);
      return;
    }
    int k = bo.getInt((String)paramMap.get(".sysmsg.AppBrandTestUpdateWxaUsageListNotify" + ".DeleteCount"), 0);
    if (k <= 0)
    {
      AppMethodBeat.o(134601);
      return;
    }
    if (k >= 0)
    {
      int i = 0;
      for (;;)
      {
        Object localObject2 = new StringBuilder().append(".sysmsg.AppBrandTestUpdateWxaUsageListNotify").append(".DeleteList.DeleteAppInfo");
        Object localObject1;
        int m;
        if (i == 0)
        {
          localObject1 = "";
          Object localObject3 = localObject1;
          localObject1 = (String)paramMap.get((String)localObject3 + ".UserName");
          localObject2 = (String)paramMap.get((String)localObject3 + ".AppID");
          m = bo.getInt((String)paramMap.get((String)localObject3 + ".AppType"), 0);
          localObject3 = (CharSequence)localObject1;
          if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
            break label326;
          }
          j = 1;
          label228:
          if (j != 0)
          {
            localObject3 = (CharSequence)localObject2;
            if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
              break label331;
            }
            j = 1;
            if (j != 0) {
              break label350;
            }
          }
          label256:
          localObject3 = (CharSequence)localObject1;
          if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
            break label336;
          }
        }
        label326:
        label331:
        label336:
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            localObject1 = q.As((String)localObject2);
          }
          if (localObject2 != null) {
            break label341;
          }
          paramMap = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(134601);
          throw paramMap;
          localObject1 = Integer.valueOf(i);
          break;
          j = 0;
          break label228;
          j = 0;
          break label256;
        }
        label341:
        al.n((String)localObject1, (String)localObject2, m);
        label350:
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(134601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.h
 * JD-Core Version:    0.7.0.1
 */