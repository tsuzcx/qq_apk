package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.pluginsdk.wallet.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

final class m$1
  implements c.a
{
  m$1(m paramm, r paramr, int paramInt) {}
  
  public final void CF(String paramString)
  {
    AppMethodBeat.i(131362);
    ab.i("MicroMsg.JsApiSecureTunnel", "secureTunnel callback fail");
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_desc", paramString);
    this.bAW.h(this.bAX, this.hUj.j("fail", localHashMap));
    AppMethodBeat.o(131362);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(131361);
    ab.i("MicroMsg.JsApiSecureTunnel", "secureTunnel callback success: %s", new Object[] { paramString });
    HashMap localHashMap = new HashMap();
    localHashMap.put("respbuf", paramString);
    this.bAW.h(this.bAX, this.hUj.j("ok", localHashMap));
    AppMethodBeat.o(131361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.m.1
 * JD-Core Version:    0.7.0.1
 */