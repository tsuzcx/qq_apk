package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigDecimal;
import org.json.JSONObject;

public final class t
  extends ab<g>
{
  private static final int CTRL_INDEX = 413;
  public static final String NAME = "scrollWebviewTo";
  
  private String a(final g paramg, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138224);
    if ((paramg instanceof ad)) {
      paramg = (ad)paramg;
    }
    while (paramg == null)
    {
      paramg = ZP("fail:page don't exist");
      AppMethodBeat.o(138224);
      return paramg;
      if ((paramg instanceof y)) {
        paramg = ((y)paramg).getCurrentPageView();
      } else {
        paramg = null;
      }
    }
    final long l = paramJSONObject.optLong("duration", 300L);
    if (!paramJSONObject.has("scrollTop"))
    {
      paramg = ZP("fail:invalid data");
      AppMethodBeat.o(138224);
      return paramg;
    }
    try
    {
      final int i = Math.round(i.bW(new BigDecimal(paramJSONObject.getString("scrollTop")).floatValue()));
      paramg.V(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138223);
          if (paramg.tti == null)
          {
            AppMethodBeat.o(138223);
            return;
          }
          paramg.tti.w(i, l);
          AppMethodBeat.o(138223);
        }
      });
      paramg = ZP("ok");
      AppMethodBeat.o(138224);
      return paramg;
    }
    catch (Exception paramg)
    {
      Log.e("MicroMsg.AppBrand.Jsapi_scrollWebviewTo", "opt scrollTop, e = %s", new Object[] { paramg });
      paramg = ZP("fail:invalid data " + Util.nullAsNil(paramg.getMessage()));
      AppMethodBeat.o(138224);
    }
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.t
 * JD-Core Version:    0.7.0.1
 */