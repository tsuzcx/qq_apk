package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bsa;
import com.tencent.mm.protocal.c.bwc;
import com.tencent.mm.protocal.c.bwd;
import com.tencent.mm.protocal.c.eu;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;

final class AppBrandIDCardUI$1$4
  implements com.tencent.mm.plugin.appbrand.jsapi.l.b.b
{
  AppBrandIDCardUI$1$4(AppBrandIDCardUI.1 param1) {}
  
  public final void f(boolean paramBoolean, final String paramString)
  {
    if (paramBoolean)
    {
      h.nFQ.f(14943, new Object[] { AppBrandIDCardUI.a(this.hfl.hfk), Integer.valueOf(4), AppBrandIDCardUI.g(this.hfl.hfk).bJY });
      Object localObject = new com.tencent.mm.ah.b.a();
      ((com.tencent.mm.ah.b.a)localObject).ecH = new bwc();
      ((com.tencent.mm.ah.b.a)localObject).ecI = new bwd();
      ((com.tencent.mm.ah.b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/submitauthorizeuserid";
      ((com.tencent.mm.ah.b.a)localObject).ecG = 1721;
      ((com.tencent.mm.ah.b.a)localObject).ecJ = 0;
      ((com.tencent.mm.ah.b.a)localObject).ecK = 0;
      localObject = ((com.tencent.mm.ah.b.a)localObject).Kt();
      bwc localbwc = (bwc)((com.tencent.mm.ah.b)localObject).ecE.ecN;
      localbwc.bOL = AppBrandIDCardUI.a(this.hfl.hfk);
      localbwc.tHo = AppBrandIDCardUI.b(this.hfl.hfk);
      localbwc.tHp = paramString;
      localbwc.bJY = AppBrandIDCardUI.g(this.hfl.hfk).bJY;
      AppBrandIDCardUI.d(this.hfl.hfk).show();
      com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ah.b)localObject, new com.tencent.mm.ipcinvoker.wx_extension.b.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.b paramAnonymousb)
        {
          if ((AppBrandIDCardUI.d(AppBrandIDCardUI.1.4.this.hfl.hfk) != null) && (AppBrandIDCardUI.d(AppBrandIDCardUI.1.4.this.hfl.hfk).isShowing())) {
            AppBrandIDCardUI.d(AppBrandIDCardUI.1.4.this.hfl.hfk).dismiss();
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.ecF.ecN == null))
          {
            y.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousb.ecF.ecN });
            return;
          }
          paramAnonymousString = (bwd)paramAnonymousb.ecF.ecN;
          if (paramAnonymousString.tHq == null)
          {
            y.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
            Toast.makeText(AppBrandIDCardUI.1.4.this.hfl.hfk, AppBrandIDCardUI.1.4.this.hfl.hfk.getString(y.j.app_brand_idcard_err_msg), 0).show();
            return;
          }
          y.i("MicroMsg.AppBrandIDCardUI", "resp.auth_status:%d", new Object[] { Integer.valueOf(paramAnonymousString.syA) });
          switch (paramAnonymousString.syA)
          {
          default: 
            return;
          case 0: 
            y.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[] { paramAnonymousString.sQc });
            h.nFQ.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.1.4.this.hfl.hfk), Integer.valueOf(9), AppBrandIDCardUI.g(AppBrandIDCardUI.1.4.this.hfl.hfk).bJY });
            paramAnonymousb = new Intent();
            paramAnonymousb.putExtra("intent_err_code", paramAnonymousString.tHq.bPH);
            paramAnonymousb.putExtra("intent_auth_token", paramAnonymousString.sQc);
            AppBrandIDCardUI.1.4.this.hfl.hfk.setResult(-1, paramAnonymousb);
            AppBrandIDCardUI.1.4.this.hfl.hfk.finish();
            return;
          }
          h.nFQ.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.1.4.this.hfl.hfk), Integer.valueOf(5), AppBrandIDCardUI.g(AppBrandIDCardUI.1.4.this.hfl.hfk).bJY });
          AppBrandIDCardUI.a(AppBrandIDCardUI.1.4.this.hfl.hfk, paramString);
          AppBrandIDCardUI.a(AppBrandIDCardUI.1.4.this.hfl.hfk, paramAnonymousString.tMO);
          AppBrandIDCardUI.h(AppBrandIDCardUI.1.4.this.hfl.hfk);
        }
      });
    }
    y.i("MicroMsg.AppBrandIDCardUI", "verifyOk:%b", new Object[] { Boolean.valueOf(paramBoolean) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1.4
 * JD-Core Version:    0.7.0.1
 */