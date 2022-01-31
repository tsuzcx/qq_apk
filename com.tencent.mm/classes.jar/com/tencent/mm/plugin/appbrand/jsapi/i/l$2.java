package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.protocal.c.bor;
import com.tencent.mm.sdk.platformtools.y;

final class l$2
  implements com.tencent.mm.ipcinvoker.wx_extension.b.a
{
  l$2(l paraml, com.tencent.mm.pluginsdk.wallet.b.a parama) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    y.i("MicroMsg.JsApiSecureTunnel", "onGYNetEnd errType :" + paramInt1 + " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.ecF.ecN == null))
    {
      y.e("MicroMsg.JsApiSecureTunnel", "secureTunnel cgi failed");
      this.gxK.uv(paramString);
      return;
    }
    y.i("MicroMsg.JsApiSecureTunnel", "secureTunnel cgi success");
    paramString = ((bor)paramb.ecF.ecN).tGY;
    this.gxK.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.l.2
 * JD-Core Version:    0.7.0.1
 */