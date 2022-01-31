package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.ayb;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiRefreshSession$RefreshSessionTask$1
  implements w.a
{
  JsApiRefreshSession$RefreshSessionTask$1(JsApiRefreshSession.RefreshSessionTask paramRefreshSessionTask) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(130541);
    ab.d("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      JsApiRefreshSession.RefreshSessionTask.b(this.hzC, 0);
      JsApiRefreshSession.RefreshSessionTask.a(this.hzC, "cgi fail");
      JsApiRefreshSession.RefreshSessionTask.a(this.hzC);
      AppMethodBeat.o(130541);
      return 0;
    }
    paramb = (ayb)paramb.fsW.fta;
    if (paramb == null)
    {
      JsApiRefreshSession.RefreshSessionTask.b(this.hzC, 0);
      ab.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest failed, response is null!");
      JsApiRefreshSession.RefreshSessionTask.b(this.hzC);
    }
    for (;;)
    {
      AppMethodBeat.o(130541);
      return 0;
      JsApiRefreshSession.RefreshSessionTask.c(this.hzC, paramb.xmS.csV);
      JsApiRefreshSession.RefreshSessionTask.a(this.hzC, paramb.xmS.csW);
      if (JsApiRefreshSession.RefreshSessionTask.c(this.hzC) == 0)
      {
        JsApiRefreshSession.RefreshSessionTask.d(this.hzC, paramb.xng);
        JsApiRefreshSession.RefreshSessionTask.c(this.hzC, paramb.xmS.csV);
        JsApiRefreshSession.RefreshSessionTask.b(this.hzC, 1);
        JsApiRefreshSession.RefreshSessionTask.d(this.hzC);
      }
      else
      {
        JsApiRefreshSession.RefreshSessionTask.c(this.hzC, paramb.xmS.csV);
        JsApiRefreshSession.RefreshSessionTask.b(this.hzC, 2);
        ab.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest ERROR %s", new Object[] { paramString });
        JsApiRefreshSession.RefreshSessionTask.e(this.hzC);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession.RefreshSessionTask.1
 * JD-Core Version:    0.7.0.1
 */