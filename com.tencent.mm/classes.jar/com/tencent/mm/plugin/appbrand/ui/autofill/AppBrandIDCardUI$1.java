package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.jsapi.l.a;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bpk;
import com.tencent.mm.protocal.c.bpl;
import com.tencent.mm.protocal.c.brz;
import com.tencent.mm.protocal.c.bsa;
import com.tencent.mm.protocal.c.ccz;
import com.tencent.mm.protocal.c.cda;
import com.tencent.mm.protocal.c.cdk;
import com.tencent.mm.protocal.c.eu;
import com.tencent.mm.protocal.c.ex;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

final class AppBrandIDCardUI$1
  implements AppBrandIDCardUI.a
{
  AppBrandIDCardUI$1(AppBrandIDCardUI paramAppBrandIDCardUI) {}
  
  private void wy(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.AppBrandIDCardUI", "url is null");
      return;
    }
    y.v("MicroMsg.AppBrandIDCardUI", "goToWebview url: " + paramString);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("forceHideShare", true);
    d.b(this.hfk, "webview", ".ui.tools.WebViewUI", localIntent);
  }
  
  public final void a(ex paramex)
  {
    h.nFQ.f(14943, new Object[] { AppBrandIDCardUI.a(this.hfk), Integer.valueOf(7), AppBrandIDCardUI.g(this.hfk).bJY });
    y.i("MicroMsg.AppBrandIDCardUI", "sendSms");
    Object localObject = new com.tencent.mm.ah.b.a();
    ((com.tencent.mm.ah.b.a)localObject).ecH = new bpk();
    ((com.tencent.mm.ah.b.a)localObject).ecI = new bpl();
    ((com.tencent.mm.ah.b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/sendsms";
    ((com.tencent.mm.ah.b.a)localObject).ecG = 1762;
    ((com.tencent.mm.ah.b.a)localObject).ecJ = 0;
    ((com.tencent.mm.ah.b.a)localObject).ecK = 0;
    localObject = ((com.tencent.mm.ah.b.a)localObject).Kt();
    bpk localbpk = (bpk)((com.tencent.mm.ah.b)localObject).ecE.ecN;
    localbpk.bOL = AppBrandIDCardUI.a(this.hfk);
    localbpk.tHo = AppBrandIDCardUI.b(this.hfk);
    localbpk.tHp = AppBrandIDCardUI.i(this.hfk);
    localbpk.syB = paramex.syB;
    localbpk.mOb = paramex.mOb;
    localbpk.bJY = AppBrandIDCardUI.g(this.hfk).bJY;
    com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ah.b)localObject, new AppBrandIDCardUI.1.5(this));
  }
  
  public final void a(String paramString, ex paramex)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.AppBrandIDCardUI", "verifyCode is null, err, return");
      return;
    }
    y.i("MicroMsg.AppBrandIDCardUI", "verifySms");
    Object localObject = new com.tencent.mm.ah.b.a();
    ((com.tencent.mm.ah.b.a)localObject).ecH = new ccz();
    ((com.tencent.mm.ah.b.a)localObject).ecI = new cda();
    ((com.tencent.mm.ah.b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/verifysmscode";
    ((com.tencent.mm.ah.b.a)localObject).ecG = 1721;
    ((com.tencent.mm.ah.b.a)localObject).ecJ = 0;
    ((com.tencent.mm.ah.b.a)localObject).ecK = 0;
    localObject = ((com.tencent.mm.ah.b.a)localObject).Kt();
    ccz localccz = (ccz)((com.tencent.mm.ah.b)localObject).ecE.ecN;
    localccz.bOL = AppBrandIDCardUI.a(this.hfk);
    localccz.tHo = AppBrandIDCardUI.b(this.hfk);
    localccz.tHp = AppBrandIDCardUI.i(this.hfk);
    localccz.syB = paramex.syB;
    localccz.bJY = AppBrandIDCardUI.g(this.hfk).bJY;
    localccz.qyu = paramString;
    localccz.tHr = AppBrandIDCardUI.j(this.hfk);
    localccz.mOb = paramex.mOb;
    com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ah.b)localObject, new com.tencent.mm.ipcinvoker.wx_extension.b.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.b paramAnonymousb)
      {
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.ecF.ecN == null))
        {
          y.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousb.ecF.ecN });
          Toast.makeText(AppBrandIDCardUI.1.this.hfk, AppBrandIDCardUI.1.this.hfk.getString(y.j.app_brand_idcard_err_msg), 0).show();
          return;
        }
        paramAnonymousString = (cda)paramAnonymousb.ecF.ecN;
        if (paramAnonymousString.tHq != null)
        {
          y.i("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response errcode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousString.tHq.bPH), bk.pm(paramAnonymousString.tHq.bPI) });
          h.nFQ.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.1.this.hfk), Integer.valueOf(8), AppBrandIDCardUI.g(AppBrandIDCardUI.1.this.hfk).bJY });
          if (paramAnonymousString.tHq.bPH == 0)
          {
            h.nFQ.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.1.this.hfk), Integer.valueOf(9), AppBrandIDCardUI.g(AppBrandIDCardUI.1.this.hfk).bJY });
            y.i("MicroMsg.AppBrandIDCardUI", "verify success");
            y.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[] { paramAnonymousString.sQc });
            paramAnonymousb = new Intent();
            paramAnonymousb.putExtra("intent_err_code", paramAnonymousString.tHq.bPH);
            paramAnonymousb.putExtra("intent_auth_token", paramAnonymousString.sQc);
            AppBrandIDCardUI.1.this.hfk.setResult(-1, paramAnonymousb);
            AppBrandIDCardUI.1.this.hfk.finish();
            return;
          }
          if (paramAnonymousString.tHq.bPH == 40013)
          {
            AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.1.this.hfk.getString(y.j.app_brand_idcard_verify_err_msg_not_match));
            return;
          }
          AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.1.this.hfk.getString(y.j.app_brand_idcard_verify_err_msg_expired));
          return;
        }
        y.e("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response is null");
      }
    });
  }
  
  public final void apl()
  {
    Object localObject = new com.tencent.mm.ah.b.a();
    ((com.tencent.mm.ah.b.a)localObject).ecH = new brz();
    ((com.tencent.mm.ah.b.a)localObject).ecI = new bsa();
    ((com.tencent.mm.ah.b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/showauthorizeuserid";
    ((com.tencent.mm.ah.b.a)localObject).ecG = 1774;
    ((com.tencent.mm.ah.b.a)localObject).ecJ = 0;
    ((com.tencent.mm.ah.b.a)localObject).ecK = 0;
    localObject = ((com.tencent.mm.ah.b.a)localObject).Kt();
    brz localbrz = (brz)((com.tencent.mm.ah.b)localObject).ecE.ecN;
    localbrz.bOL = AppBrandIDCardUI.a(this.hfk);
    localbrz.tHo = AppBrandIDCardUI.b(this.hfk);
    localbrz.tIB = AppBrandIDCardUI.c(this.hfk);
    com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ah.b)localObject, new AppBrandIDCardUI.1.1(this));
  }
  
  public final void apm()
  {
    y.i("MicroMsg.AppBrandIDCardUI", "verifyPassword");
    h.nFQ.f(14943, new Object[] { AppBrandIDCardUI.a(this.hfk), Integer.valueOf(2), AppBrandIDCardUI.g(this.hfk).bJY });
    if (AppBrandIDCardUI.g(this.hfk).tIK == null)
    {
      y.e("MicroMsg.AppBrandIDCardUI", "showAuthorizeUserIDResp.verify_pay_req is null");
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", AppBrandIDCardUI.g(this.hfk).tIK.bOL);
      localJSONObject.put("timeStamp", AppBrandIDCardUI.g(this.hfk).tIK.bIK);
      localJSONObject.put("nonceStr", AppBrandIDCardUI.g(this.hfk).tIK.tmB);
      localJSONObject.put("package", AppBrandIDCardUI.g(this.hfk).tIK.tSh);
      localJSONObject.put("signType", AppBrandIDCardUI.g(this.hfk).tIK.ivD);
      localJSONObject.put("paySign", AppBrandIDCardUI.g(this.hfk).tIK.tmk);
      h.nFQ.f(14943, new Object[] { AppBrandIDCardUI.a(this.hfk), Integer.valueOf(3), AppBrandIDCardUI.g(this.hfk).bJY });
      a.gzi.a(this.hfk, localJSONObject, new AppBrandIDCardUI.1.4(this));
      return;
    }
    catch (JSONException localJSONException)
    {
      y.printErrStackTrace("MicroMsg.AppBrandIDCardUI", localJSONException, "", new Object[0]);
    }
  }
  
  public final void apn()
  {
    h.nFQ.f(14943, new Object[] { AppBrandIDCardUI.a(this.hfk), Integer.valueOf(6), AppBrandIDCardUI.g(this.hfk).bJY });
  }
  
  public final bsa apo()
  {
    return AppBrandIDCardUI.g(this.hfk);
  }
  
  public final ey app()
  {
    return AppBrandIDCardUI.k(this.hfk);
  }
  
  public final void back()
  {
    AppBrandIDCardUI.f(this.hfk);
  }
  
  public final void onSwipeBack()
  {
    this.hfk.onSwipeBack();
  }
  
  public final void wv(String paramString)
  {
    y.i("MicroMsg.AppBrandIDCardUI", "protocalUrl click");
    wy(paramString);
  }
  
  public final void ww(String paramString)
  {
    y.i("MicroMsg.AppBrandIDCardUI", "urlJump click");
    wy(paramString);
  }
  
  public final void wx(String paramString)
  {
    y.i("MicroMsg.AppBrandIDCardUI", "url2Jump click");
    wy(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1
 * JD-Core Version:    0.7.0.1
 */