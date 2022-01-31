package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.protocal.c.ccf;
import com.tencent.mm.protocal.c.cme;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class AppBrandAuthorizeUI$6
  implements w.a
{
  AppBrandAuthorizeUI$6(AppBrandAuthorizeUI paramAppBrandAuthorizeUI, List paramList) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      return 0;
    }
    paramString = (cme)paramb.ecF.ecN;
    if (paramString == null)
    {
      y.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq failed, response is null!");
      return 0;
    }
    paramInt1 = paramString.tYN.errCode;
    paramString = paramString.tYN.aox;
    if (paramInt1 == 0)
    {
      y.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq OK!");
      AppBrandAuthorizeUI.b(this.hcu, this.hcy);
      AppBrandAuthorizeUI.c(this.hcu);
      return 0;
    }
    y.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq error %s", new Object[] { paramString });
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.6
 * JD-Core Version:    0.7.0.1
 */