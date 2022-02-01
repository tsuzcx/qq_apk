package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.math.BigDecimal;
import org.json.JSONObject;

public final class o
  extends y<d>
{
  private static final int CTRL_INDEX = 413;
  public static final String NAME = "scrollWebviewTo";
  
  private String a(final d paramd, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138224);
    if ((paramd instanceof aa)) {
      paramd = (aa)paramd;
    }
    while (paramd == null)
    {
      paramd = e("fail:page don't exist", null);
      AppMethodBeat.o(138224);
      return paramd;
      if ((paramd instanceof q)) {
        paramd = ((q)paramd).getCurrentPageView();
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
      final int i = Math.round(g.aG(new BigDecimal(paramJSONObject.getString("scrollTop")).floatValue()));
      paramd.N(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138223);
          if (paramd.lyE == null)
          {
            AppMethodBeat.o(138223);
            return;
          }
          paramd.lyE.q(i, l);
          AppMethodBeat.o(138223);
        }
      });
      paramd = e("ok", null);
      AppMethodBeat.o(138224);
      return paramd;
    }
    catch (Exception paramd)
    {
      ac.e("MicroMsg.AppBrand.Jsapi_scrollWebviewTo", "opt scrollTop, e = %s", new Object[] { paramd });
      paramd = e("fail:invalid data " + bs.nullAsNil(paramd.getMessage()), null);
      AppMethodBeat.o(138224);
    }
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.o
 * JD-Core Version:    0.7.0.1
 */