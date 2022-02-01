package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigDecimal;
import org.json.JSONObject;

public final class t
  extends aa<com.tencent.mm.plugin.appbrand.g>
{
  private static final int CTRL_INDEX = 413;
  public static final String NAME = "scrollWebviewTo";
  
  private String a(final com.tencent.mm.plugin.appbrand.g paramg, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138224);
    if ((paramg instanceof ad)) {
      paramg = (ad)paramg;
    }
    while (paramg == null)
    {
      paramg = h("fail:page don't exist", null);
      AppMethodBeat.o(138224);
      return paramg;
      if ((paramg instanceof v)) {
        paramg = ((v)paramg).getCurrentPageView();
      } else {
        paramg = null;
      }
    }
    final long l = paramJSONObject.optLong("duration", 300L);
    if (!paramJSONObject.has("scrollTop"))
    {
      paramg = h("fail:invalid data", null);
      AppMethodBeat.o(138224);
      return paramg;
    }
    try
    {
      final int i = Math.round(com.tencent.mm.plugin.appbrand.ac.g.aU(new BigDecimal(paramJSONObject.getString("scrollTop")).floatValue()));
      paramg.P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138223);
          if (paramg.qoF == null)
          {
            AppMethodBeat.o(138223);
            return;
          }
          paramg.qoF.s(i, l);
          AppMethodBeat.o(138223);
        }
      });
      paramg = h("ok", null);
      AppMethodBeat.o(138224);
      return paramg;
    }
    catch (Exception paramg)
    {
      Log.e("MicroMsg.AppBrand.Jsapi_scrollWebviewTo", "opt scrollTop, e = %s", new Object[] { paramg });
      paramg = h("fail:invalid data " + Util.nullAsNil(paramg.getMessage()), null);
      AppMethodBeat.o(138224);
    }
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.t
 * JD-Core Version:    0.7.0.1
 */