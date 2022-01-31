package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.protocal.c.ccf;
import com.tencent.mm.protocal.c.clu;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandAuthorizeUI$5
  implements w.a
{
  AppBrandAuthorizeUI$5(AppBrandAuthorizeUI paramAppBrandAuthorizeUI) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppBrandAuthorizeUI.b(this.hcu);
      return 0;
    }
    paramString = (clu)paramb.ecF.ecN;
    if (paramString == null)
    {
      AppBrandAuthorizeUI.b(this.hcu);
      y.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq failed, response is null!");
      return 0;
    }
    paramInt1 = paramString.tYN.errCode;
    paramb = paramString.tYN.aox;
    if (paramInt1 == 0)
    {
      this.hcu.hcn = paramString.tYO;
      AppBrandAuthorizeUI.a(this.hcu, this.hcu.hcn);
      return 0;
    }
    AppBrandAuthorizeUI.b(this.hcu);
    y.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq error %s", new Object[] { paramb });
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.5
 * JD-Core Version:    0.7.0.1
 */