package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class BizTimeLineUI$10
  implements h
{
  BizTimeLineUI$10(BizTimeLineUI paramBizTimeLineUI)
  {
    AppMethodBeat.i(160484);
    AppMethodBeat.o(160484);
  }
  
  public final Object a(u paramu)
  {
    return null;
  }
  
  public final Object b(u paramu)
  {
    AppMethodBeat.i(209512);
    if (paramu.type == 45)
    {
      String str1 = new String(Base64.decode(paramu.url, 0));
      String str2 = new String(Base64.decode(bt.bI((String)paramu.aY(String.class), ""), 0));
      ad.d("MicroMsg.BizTimeLineUI", "appId:%s,path:%s", new Object[] { str1, str2 });
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1082;
      paramu = paramu.mSessionId;
      if (!bt.isNullOrNil(paramu))
      {
        paramu = y.aBq().AF(paramu);
        if (paramu != null)
        {
          paramu = paramu.getString("preUsername", null);
          localAppBrandStatObject.dkh = (paramu + "|3");
        }
      }
      ((o)g.ab(o.class)).a(this.ocb.getContext(), null, str1, 0, 0, str2, localAppBrandStatObject);
    }
    AppMethodBeat.o(209512);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.10
 * JD-Core Version:    0.7.0.1
 */