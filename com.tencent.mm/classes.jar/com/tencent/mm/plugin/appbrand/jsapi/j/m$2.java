package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.pluginsdk.wallet.c.a;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.sdk.platformtools.ab;

final class m$2
  implements b.a
{
  m$2(m paramm, c.a parama) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(131363);
    ab.i("MicroMsg.JsApiSecureTunnel", "onGYNetEnd errType :" + paramInt1 + " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.fsW.fta == null))
    {
      ab.e("MicroMsg.JsApiSecureTunnel", "secureTunnel cgi failed");
      this.hUk.CF(paramString);
      AppMethodBeat.o(131363);
      return;
    }
    ab.i("MicroMsg.JsApiSecureTunnel", "secureTunnel cgi success");
    paramString = ((byo)paramb.fsW.fta).xKV;
    this.hUk.onSuccess(paramString);
    AppMethodBeat.o(131363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.m.2
 * JD-Core Version:    0.7.0.1
 */