package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.cil;
import com.tencent.mm.protocal.protobuf.fy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;

final class AppBrandIDCardUI$1$4$1
  implements b.a
{
  AppBrandIDCardUI$1$4$1(AppBrandIDCardUI.1.4 param4, String paramString) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(133217);
    if ((AppBrandIDCardUI.d(this.iQC.iQA.iQz) != null) && (AppBrandIDCardUI.d(this.iQC.iQA.iQz).isShowing())) {
      AppBrandIDCardUI.d(this.iQC.iQA.iQz).dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.fsW.fta == null))
    {
      ab.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramb.fsW.fta });
      AppMethodBeat.o(133217);
      return;
    }
    paramString = (cil)paramb.fsW.fta;
    if (paramString.xLn == null)
    {
      ab.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
      Toast.makeText(this.iQC.iQA.iQz, this.iQC.iQA.iQz.getString(2131296677), 0).show();
      AppMethodBeat.o(133217);
      return;
    }
    ab.i("MicroMsg.AppBrandIDCardUI", "resp.auth_status:%d", new Object[] { Integer.valueOf(paramString.wsg) });
    switch (paramString.wsg)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(133217);
      return;
      ab.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[] { paramString.wOx });
      h.qsU.e(14943, new Object[] { AppBrandIDCardUI.a(this.iQC.iQA.iQz), Integer.valueOf(9), AppBrandIDCardUI.g(this.iQC.iQA.iQz).crs });
      paramb = new Intent();
      paramb.putExtra("intent_err_code", paramString.xLn.cxa);
      paramb.putExtra("intent_auth_token", paramString.wOx);
      this.iQC.iQA.iQz.setResult(-1, paramb);
      this.iQC.iQA.iQz.finish();
      AppMethodBeat.o(133217);
      return;
      h.qsU.e(14943, new Object[] { AppBrandIDCardUI.a(this.iQC.iQA.iQz), Integer.valueOf(5), AppBrandIDCardUI.g(this.iQC.iQA.iQz).crs });
      AppBrandIDCardUI.a(this.iQC.iQA.iQz, this.iQB);
      AppBrandIDCardUI.a(this.iQC.iQA.iQz, paramString.xSY);
      AppBrandIDCardUI.h(this.iQC.iQA.iQz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1.4.1
 * JD-Core Version:    0.7.0.1
 */