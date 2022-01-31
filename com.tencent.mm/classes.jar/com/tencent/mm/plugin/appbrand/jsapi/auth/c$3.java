package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

final class c$3
  implements c.a
{
  c$3(c paramc1, com.tencent.mm.plugin.appbrand.jsapi.h paramh, f paramf, c paramc2, JSONObject paramJSONObject, int paramInt) {}
  
  public final void arq()
  {
    AppMethodBeat.i(130818);
    ab.i("MicroMsg.AppBrandAuthJsApiQueue", "about to call AuthInvoke, api[%s]", new Object[] { this.hDm.mName });
    if (!this.hDn.isRunning())
    {
      ab.e("MicroMsg.AppBrandAuthJsApiQueue", "doAuth but component not running, api = %s", new Object[] { this.hDo.getName() });
      this.hDp.sendMessage(2);
      AppMethodBeat.o(130818);
      return;
    }
    this.hDo.a(this.hDn, this.bBa, this.bAX, this.hDp);
    AppMethodBeat.o(130818);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(130819);
    String str = hashCode() + "|" + this.hDo.getName();
    AppMethodBeat.o(130819);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.c.3
 * JD-Core Version:    0.7.0.1
 */