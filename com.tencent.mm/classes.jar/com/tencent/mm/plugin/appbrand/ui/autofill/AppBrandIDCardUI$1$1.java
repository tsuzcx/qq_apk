package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.fx;
import com.tencent.mm.protocal.protobuf.fy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

final class AppBrandIDCardUI$1$1
  implements b.a
{
  AppBrandIDCardUI$1$1(AppBrandIDCardUI.1 param1) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(133215);
    if ((AppBrandIDCardUI.d(this.iQA.iQz) != null) && (AppBrandIDCardUI.d(this.iQA.iQz).isShowing())) {
      AppBrandIDCardUI.d(this.iQA.iQz).dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.fsW.fta == null))
    {
      ab.e("MicroMsg.AppBrandIDCardUI", "getIDCardInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramb.fsW.fta });
      paramString = new Intent();
      paramString.putExtra("intent_err_code", 40000);
      paramString.putExtra("intent_err_msg", "network err");
      this.iQA.iQz.setResult(1, paramString);
      this.iQA.iQz.finish();
      AppMethodBeat.o(133215);
      return;
    }
    paramString = (ccl)paramb.fsW.fta;
    if (paramString.xLn == null)
    {
      ab.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
      paramString = new Intent();
      paramString.putExtra("intent_err_code", 40000);
      paramString.putExtra("intent_err_msg", "network err");
      this.iQA.iQz.setResult(1, paramString);
      this.iQA.iQz.finish();
      AppMethodBeat.o(133215);
      return;
    }
    ab.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response.err_code is %d", new Object[] { Integer.valueOf(paramString.xLn.cxa) });
    ab.i("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status:%d", new Object[] { Integer.valueOf(paramString.xMQ) });
    switch (paramString.xMQ)
    {
    default: 
      ab.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status error");
      AppMethodBeat.o(133215);
      return;
    case 0: 
      if (paramString.xLn.cxa != 0)
      {
        ab.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is not ok");
        paramb = new Intent();
        paramb.putExtra("intent_err_code", paramString.xLn.cxa);
        paramb.putExtra("intent_err_msg", paramString.xLn.cxb);
        this.iQA.iQz.setResult(1, paramb);
        this.iQA.iQz.finish();
        AppMethodBeat.o(133215);
        return;
      }
      AppBrandIDCardUI.a(this.iQA.iQz, paramString);
      AppBrandIDCardUI.e(this.iQA.iQz);
      AppMethodBeat.o(133215);
      return;
    }
    ab.i("MicroMsg.AppBrandIDCardUI", "showAlert errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramString.xLn.cxa), paramString.xLn.cxb });
    paramb = this.iQA;
    paramInt1 = paramString.xLn.cxa;
    String str = paramString.xLn.cxb;
    h.a(paramb.iQz, false, paramString.xMR.desc, paramString.xMR.title, paramb.iQz.getString(2131296678), "", new AppBrandIDCardUI.1.2(paramb, paramInt1, str), new AppBrandIDCardUI.1.3(paramb));
    AppMethodBeat.o(133215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1.1
 * JD-Core Version:    0.7.0.1
 */