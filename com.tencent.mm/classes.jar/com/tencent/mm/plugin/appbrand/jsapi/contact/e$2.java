package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class e$2
  implements b.a
{
  e$2(e parame, e.a parama, z paramz, AppBrandSysConfigWC paramAppBrandSysConfigWC) {}
  
  public final void a(int paramInt1, int paramInt2, final String paramString, b paramb)
  {
    AppMethodBeat.i(131001);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.fsW.fta == null))
    {
      ab.e("MicroMsg.JsApiEnterContact", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramb.fsW.fta });
      if (this.hKD != null) {
        this.hKD.a(false, "fail:cgi fail", null);
      }
      AppMethodBeat.o(131001);
      return;
    }
    paramString = (aqg)paramb.fsW.fta;
    ab.i("MicroMsg.JsApiEnterContact", "getsubbusinessinfo success, subBusinessUsername:%s", new Object[] { paramString.xfE });
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(131000);
        e.2.this.hKC.a(e.2.this.hKE, e.2.this.hKF, paramString.xfE, e.2.this.hKD);
        AppMethodBeat.o(131000);
      }
    });
    AppMethodBeat.o(131001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.e.2
 * JD-Core Version:    0.7.0.1
 */