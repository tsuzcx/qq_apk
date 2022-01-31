package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.czl;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandAuthorizeUI$14
  implements w.a
{
  AppBrandAuthorizeUI$14(AppBrandAuthorizeUI paramAppBrandAuthorizeUI) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(132906);
    ab.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppBrandAuthorizeUI.e(this.iLF);
      AppMethodBeat.o(132906);
      return 0;
    }
    paramString = (czl)paramb.fsW.fta;
    if (paramString == null)
    {
      AppBrandAuthorizeUI.e(this.iLF);
      ab.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq failed, response is null!");
    }
    for (;;)
    {
      AppMethodBeat.o(132906);
      return 0;
      paramInt1 = paramString.ygj.errCode;
      paramb = paramString.ygj.errMsg;
      if (paramInt1 == 0)
      {
        this.iLF.iLy = paramString.ygk;
        AppBrandAuthorizeUI.a(this.iLF, this.iLF.iLy);
      }
      else
      {
        AppBrandAuthorizeUI.e(this.iLF);
        ab.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq error %s", new Object[] { paramb });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.14
 * JD-Core Version:    0.7.0.1
 */