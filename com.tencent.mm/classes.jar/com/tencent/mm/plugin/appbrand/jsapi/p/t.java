package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigDecimal;
import org.json.JSONObject;

public final class t
  extends ab<d>
{
  private static final int CTRL_INDEX = 413;
  public static final String NAME = "scrollWebviewTo";
  
  private String a(final d paramd, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138224);
    if ((paramd instanceof ac)) {
      paramd = (ac)paramd;
    }
    while (paramd == null)
    {
      paramd = h("fail:page don't exist", null);
      AppMethodBeat.o(138224);
      return paramd;
      if ((paramd instanceof s)) {
        paramd = ((s)paramd).getCurrentPageView();
      } else {
        paramd = null;
      }
    }
    final long l = paramJSONObject.optLong("duration", 300L);
    if (!paramJSONObject.has("scrollTop"))
    {
      paramd = h("fail:invalid data", null);
      AppMethodBeat.o(138224);
      return paramd;
    }
    try
    {
      final int i = Math.round(g.aT(new BigDecimal(paramJSONObject.getString("scrollTop")).floatValue()));
      paramd.P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138223);
          if (paramd.nmX == null)
          {
            AppMethodBeat.o(138223);
            return;
          }
          paramd.nmX.s(i, l);
          AppMethodBeat.o(138223);
        }
      });
      paramd = h("ok", null);
      AppMethodBeat.o(138224);
      return paramd;
    }
    catch (Exception paramd)
    {
      Log.e("MicroMsg.AppBrand.Jsapi_scrollWebviewTo", "opt scrollTop, e = %s", new Object[] { paramd });
      paramd = h("fail:invalid data " + Util.nullAsNil(paramd.getMessage()), null);
      AppMethodBeat.o(138224);
    }
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.t
 * JD-Core Version:    0.7.0.1
 */