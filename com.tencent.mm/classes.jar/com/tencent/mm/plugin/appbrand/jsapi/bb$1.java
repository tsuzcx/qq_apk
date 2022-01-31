package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.protocal.c.ccu;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class bb$1
  implements b.a
{
  bb$1(bb parambb, o paramo, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    boolean bool = true;
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.ecF.ecN == null))
    {
      if (paramb.ecF.ecN == null) {}
      for (;;)
      {
        y.e("MicroMsg.JsApiVerifyPlugin", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(bool) });
        this.gcp.C(this.dIS, this.ghH.h("fail:cgi fail", null));
        return;
        bool = false;
      }
    }
    paramString = (ccu)paramb.ecF.ecN;
    paramb = new HashMap();
    try
    {
      paramb.put("data", new JSONObject(paramString.tRJ));
      this.gcp.C(this.dIS, this.ghH.h("ok", paramb));
      return;
    }
    catch (Exception paramString)
    {
      this.gcp.C(this.dIS, this.ghH.h("fail:resp invalid", null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bb.1
 * JD-Core Version:    0.7.0.1
 */