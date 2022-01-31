package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements b.a
{
  b$1(b paramb, q paramq, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.b paramb)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.ecF.ecN == null))
    {
      y.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramb.ecF.ecN });
      this.gkf.C(this.dIS, this.gkg.h("fail:cgi fail", null));
      return;
    }
    y.i("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData success");
    this.gkf.C(this.dIS, this.gkg.h("ok", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.b.1
 * JD-Core Version:    0.7.0.1
 */