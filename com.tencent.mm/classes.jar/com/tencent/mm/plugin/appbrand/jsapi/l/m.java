package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigDecimal;
import org.json.JSONObject;

public final class m
  extends u<d>
{
  private static final int CTRL_INDEX = 413;
  public static final String NAME = "scrollWebviewTo";
  
  private String a(d paramd, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(74757);
    if ((paramd instanceof v)) {
      paramd = (v)paramd;
    }
    while (paramd == null)
    {
      paramd = j("fail:page don't exist", null);
      AppMethodBeat.o(74757);
      return paramd;
      if ((paramd instanceof r)) {
        paramd = ((r)paramd).getCurrentPageView();
      } else {
        paramd = null;
      }
    }
    long l = paramJSONObject.optLong("duration", 300L);
    if (!paramJSONObject.has("scrollTop"))
    {
      paramd = j("fail:invalid data", null);
      AppMethodBeat.o(74757);
      return paramd;
    }
    try
    {
      int i = Math.round(g.aA(new BigDecimal(paramJSONObject.getString("scrollTop")).floatValue()));
      al.d(new m.1(this, paramd, i, l));
      paramd = j("ok", null);
      AppMethodBeat.o(74757);
      return paramd;
    }
    catch (Exception paramd)
    {
      ab.e("MicroMsg.AppBrand.Jsapi_scrollWebviewTo", "opt scrollTop, e = %s", new Object[] { paramd });
      paramd = j("fail:invalid data " + bo.nullAsNil(paramd.getMessage()), null);
      AppMethodBeat.o(74757);
    }
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.m
 * JD-Core Version:    0.7.0.1
 */