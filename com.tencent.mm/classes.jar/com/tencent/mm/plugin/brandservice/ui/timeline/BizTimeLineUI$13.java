package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class BizTimeLineUI$13
  implements i
{
  BizTimeLineUI$13(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final Object a(u paramu)
  {
    return null;
  }
  
  public final Object b(u paramu)
  {
    AppMethodBeat.i(194943);
    if (paramu.type == 45)
    {
      String str1 = new String(Base64.decode(paramu.url, 0));
      String str2 = new String(Base64.decode(Util.nullAs((String)paramu.ba(String.class), ""), 0));
      Log.d("MicroMsg.BizTimeLineUI", "appId:%s,path:%s", new Object[] { str1, str2 });
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1082;
      paramu = paramu.mSessionId;
      if (!Util.isNullOrNil(paramu))
      {
        paramu = ad.aVe().JV(paramu);
        if (paramu != null)
        {
          paramu = paramu.getString("preUsername", null);
          localAppBrandStatObject.dCw = (paramu + "|3");
        }
      }
      ((r)g.af(r.class)).a(this.ptt.getContext(), null, str1, 0, 0, str2, localAppBrandStatObject);
    }
    AppMethodBeat.o(194943);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.13
 * JD-Core Version:    0.7.0.1
 */