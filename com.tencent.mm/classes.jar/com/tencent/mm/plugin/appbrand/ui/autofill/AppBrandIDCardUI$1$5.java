package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.fy;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandIDCardUI$1$5
  implements b.a
{
  AppBrandIDCardUI$1$5(AppBrandIDCardUI.1 param1) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(133219);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.fsW.fta == null))
    {
      ab.e("MicroMsg.AppBrandIDCardUI", "sendSms cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramb.fsW.fta });
      Toast.makeText(this.iQA.iQz, this.iQA.iQz.getString(2131296677), 0).show();
      AppMethodBeat.o(133219);
      return;
    }
    paramString = (bzi)paramb.fsW.fta;
    if (paramString.xLn != null)
    {
      ab.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response.err_code:%d", new Object[] { Integer.valueOf(paramString.xLn.cxa) });
      if (paramString.xLn.cxa == 0)
      {
        AppBrandIDCardUI.b(this.iQA.iQz, paramString.xLo);
        ab.i("MicroMsg.AppBrandIDCardUI", "send success, verifyToken:%s", new Object[] { paramString.xLo });
        AppMethodBeat.o(133219);
        return;
      }
      AppBrandIDCardUI.1.a(this.iQA, this.iQA.iQz.getString(2131296683));
      AppMethodBeat.o(133219);
      return;
    }
    ab.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response is null");
    AppBrandIDCardUI.1.a(this.iQA, this.iQA.iQz.getString(2131296683));
    AppMethodBeat.o(133219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1.5
 * JD-Core Version:    0.7.0.1
 */