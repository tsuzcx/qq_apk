package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.g;
import com.tencent.mm.ad.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class BizTimeLineUI$17
  implements m
{
  BizTimeLineUI$17(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final Object a(u paramu)
  {
    return null;
  }
  
  public final Object b(u paramu)
  {
    AppMethodBeat.i(301812);
    String str4;
    String str3;
    String str1;
    String str2;
    if (paramu.type == 45)
    {
      str4 = new String(Base64.decode(paramu.url, 0));
      str3 = (String)paramu.cf(String.class);
      str1 = "";
      str2 = str1;
    }
    label289:
    for (;;)
    {
      try
      {
        Object localObject2 = new i(str3);
        str2 = str1;
        str1 = ((i)localObject2).optString("fullText");
        str2 = str1;
        str3 = ((i)localObject2).optString("linkText");
        str2 = str3;
        Object localObject1;
        str3 = "";
      }
      catch (g localg1)
      {
        try
        {
          str3 = new String(Base64.decode(Util.nullAs(((i)localObject2).optString("path"), ""), 0));
          Log.d("MicroMsg.BizTimeLineUI", "appId:%s,path:%s", new Object[] { str4, str3 });
          localObject2 = new AppBrandStatObject();
          ((AppBrandStatObject)localObject2).scene = 1082;
          paramu = paramu.mSessionId;
          if (!Util.isNullOrNil(paramu))
          {
            paramu = ad.bCb().Jm(paramu);
            if (paramu != null)
            {
              paramu = paramu.getString("preUsername", null);
              ((AppBrandStatObject)localObject2).hzx = (paramu + ":3:" + str1 + ":" + str2 + ":" + str3);
              Log.d("MicroMsg.BizTimeLineUI", "sceneNote = %s", new Object[] { ((AppBrandStatObject)localObject2).hzx });
            }
          }
          ((t)h.ax(t.class)).a(this.vIB.getContext(), null, str4, 0, 0, str3, (AppBrandStatObject)localObject2);
          AppMethodBeat.o(301812);
          return null;
        }
        catch (g localg2)
        {
          break label289;
        }
        localg1 = localg1;
        str3 = "";
        localObject1 = str2;
        str2 = str3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.17
 * JD-Core Version:    0.7.0.1
 */