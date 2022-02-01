package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.math.BigDecimal;
import org.json.JSONObject;

public final class p
  extends y<d>
{
  private static final int CTRL_INDEX = 413;
  public static final String NAME = "scrollWebviewTo";
  
  private String a(final d paramd, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138224);
    if ((paramd instanceof z)) {
      paramd = (z)paramd;
    }
    while (paramd == null)
    {
      paramd = e("fail:page don't exist", null);
      AppMethodBeat.o(138224);
      return paramd;
      if ((paramd instanceof r)) {
        paramd = ((r)paramd).getCurrentPageView();
      } else {
        paramd = null;
      }
    }
    final long l = paramJSONObject.optLong("duration", 300L);
    if (!paramJSONObject.has("scrollTop"))
    {
      paramd = e("fail:invalid data", null);
      AppMethodBeat.o(138224);
      return paramd;
    }
    try
    {
      final int i = Math.round(g.aJ(new BigDecimal(paramJSONObject.getString("scrollTop")).floatValue()));
      paramd.K(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138223);
          if (paramd.mcJ == null)
          {
            AppMethodBeat.o(138223);
            return;
          }
          paramd.mcJ.q(i, l);
          AppMethodBeat.o(138223);
        }
      });
      paramd = e("ok", null);
      AppMethodBeat.o(138224);
      return paramd;
    }
    catch (Exception paramd)
    {
      ae.e("MicroMsg.AppBrand.Jsapi_scrollWebviewTo", "opt scrollTop, e = %s", new Object[] { paramd });
      paramd = e("fail:invalid data " + bu.nullAsNil(paramd.getMessage()), null);
      AppMethodBeat.o(138224);
    }
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.p
 * JD-Core Version:    0.7.0.1
 */