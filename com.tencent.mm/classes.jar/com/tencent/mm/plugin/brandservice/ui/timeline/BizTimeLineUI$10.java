package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

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
    AppMethodBeat.i(208467);
    if (paramu.type == 45)
    {
      String str1 = new String(Base64.decode(paramu.url, 0));
      String str2 = new String(Base64.decode(bu.bI((String)paramu.aY(String.class), ""), 0));
      ae.d("MicroMsg.BizTimeLineUI", "appId:%s,path:%s", new Object[] { str1, str2 });
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1082;
      paramu = paramu.mSessionId;
      if (!bu.isNullOrNil(paramu))
      {
        paramu = z.aBG().Bp(paramu);
        if (paramu != null)
        {
          paramu = paramu.getString("preUsername", null);
          localAppBrandStatObject.dlj = (paramu + "|3");
        }
      }
      ((p)g.ab(p.class)).a(this.ohP.getContext(), null, str1, 0, 0, str2, localAppBrandStatObject);
    }
    AppMethodBeat.o(208467);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.10
 * JD-Core Version:    0.7.0.1
 */