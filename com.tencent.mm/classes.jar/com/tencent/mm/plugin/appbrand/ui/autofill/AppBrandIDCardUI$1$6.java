package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.cqh;
import com.tencent.mm.protocal.protobuf.fy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class AppBrandIDCardUI$1$6
  implements b.a
{
  AppBrandIDCardUI$1$6(AppBrandIDCardUI.1 param1) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(133220);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.fsW.fta == null))
    {
      ab.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramb.fsW.fta });
      Toast.makeText(this.iQA.iQz, this.iQA.iQz.getString(2131296677), 0).show();
      AppMethodBeat.o(133220);
      return;
    }
    paramString = (cqh)paramb.fsW.fta;
    if (paramString.xLn != null)
    {
      ab.i("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response errcode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramString.xLn.cxa), bo.nullAsNil(paramString.xLn.cxb) });
      h.qsU.e(14943, new Object[] { AppBrandIDCardUI.a(this.iQA.iQz), Integer.valueOf(8), AppBrandIDCardUI.g(this.iQA.iQz).crs });
      if (paramString.xLn.cxa == 0)
      {
        h.qsU.e(14943, new Object[] { AppBrandIDCardUI.a(this.iQA.iQz), Integer.valueOf(9), AppBrandIDCardUI.g(this.iQA.iQz).crs });
        ab.i("MicroMsg.AppBrandIDCardUI", "verify success");
        ab.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[] { paramString.wOx });
        paramb = new Intent();
        paramb.putExtra("intent_err_code", paramString.xLn.cxa);
        paramb.putExtra("intent_auth_token", paramString.wOx);
        this.iQA.iQz.setResult(-1, paramb);
        this.iQA.iQz.finish();
        AppMethodBeat.o(133220);
        return;
      }
      if (paramString.xLn.cxa == 40013)
      {
        AppBrandIDCardUI.1.a(this.iQA, this.iQA.iQz.getString(2131296682));
        AppMethodBeat.o(133220);
        return;
      }
      AppBrandIDCardUI.1.a(this.iQA, this.iQA.iQz.getString(2131296681));
      AppMethodBeat.o(133220);
      return;
    }
    ab.e("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response is null");
    AppMethodBeat.o(133220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1.6
 * JD-Core Version:    0.7.0.1
 */