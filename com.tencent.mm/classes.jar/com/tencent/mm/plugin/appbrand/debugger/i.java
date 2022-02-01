package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bd.c;
import com.tencent.mm.plugin.appbrand.appusage.an;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/debugger/MonkeyUpdateWxaUsageListNotify;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgPushingXmlHandler$IMessageHandler;", "()V", "SAMPLE", "", "handleMessage", "", "xml", "parsedKV", "", "nilAs", "as", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
public final class i
  implements bd.c
{
  private final String kaN = "<sysmsg type=\"AppBrandTestUpdateWxaUsageListNotify\">\n\n<AppBrandTestUpdateWxaUsageListNotify>\n\n    <DeleteCount></DeleteCount>\n\n    <DeleteList>\n\n        <DeleteAppInfo>\n\n            <UserName>%s</UserName>\n\n            <AppID>%s</AppID>\n\n            <AppType>%d</AppType>\n\n        </DeleteAppInfo>\n\n    </DeleteList>\n\n</AppBrandTestUpdateWxaUsageListNotify></sysmsg>";
  
  public final void k(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(189031);
    if (paramMap == null)
    {
      AppMethodBeat.o(189031);
      return;
    }
    int k = bt.getInt((String)paramMap.get(".sysmsg.AppBrandTestUpdateWxaUsageListNotify" + ".DeleteCount"), 0);
    if (k <= 0)
    {
      AppMethodBeat.o(189031);
      return;
    }
    if (k >= 0)
    {
      int i = 0;
      for (;;)
      {
        Object localObject1 = new StringBuilder().append(".sysmsg.AppBrandTestUpdateWxaUsageListNotify").append(".DeleteList.DeleteAppInfo");
        int m;
        if (i == 0)
        {
          paramString = "";
          Object localObject2 = paramString;
          paramString = (String)paramMap.get((String)localObject2 + ".UserName");
          localObject1 = (String)paramMap.get((String)localObject2 + ".AppID");
          m = bt.getInt((String)paramMap.get((String)localObject2 + ".AppType"), 0);
          localObject2 = (CharSequence)paramString;
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            break label325;
          }
          j = 1;
          label225:
          if (j != 0)
          {
            localObject2 = (CharSequence)localObject1;
            if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
              break label331;
            }
            j = 1;
            label255:
            if (j != 0) {
              break label351;
            }
          }
          localObject2 = (CharSequence)paramString;
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            break label337;
          }
        }
        label325:
        label331:
        label337:
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            paramString = com.tencent.mm.plugin.appbrand.config.v.NG((String)localObject1);
          }
          if (localObject1 != null) {
            break label343;
          }
          paramString = new d.v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(189031);
          throw paramString;
          paramString = Integer.valueOf(i);
          break;
          j = 0;
          break label225;
          j = 0;
          break label255;
        }
        label343:
        an.v(paramString, (String)localObject1, m);
        label351:
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(189031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.i
 * JD-Core Version:    0.7.0.1
 */