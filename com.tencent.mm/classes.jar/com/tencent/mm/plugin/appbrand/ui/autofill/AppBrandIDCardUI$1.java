package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.appbrand.jsapi.m.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.cck;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.protocal.protobuf.cqh;
import com.tencent.mm.protocal.protobuf.cqr;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.protocal.protobuf.gc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

final class AppBrandIDCardUI$1
  implements AppBrandIDCardUI.a
{
  AppBrandIDCardUI$1(AppBrandIDCardUI paramAppBrandIDCardUI) {}
  
  private void Fh(String paramString)
  {
    AppMethodBeat.i(133228);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.AppBrandIDCardUI", "url is null");
      AppMethodBeat.o(133228);
      return;
    }
    ab.v("MicroMsg.AppBrandIDCardUI", "goToWebview url: ".concat(String.valueOf(paramString)));
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("forceHideShare", true);
    d.b(this.iQz, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(133228);
  }
  
  public final void Fe(String paramString)
  {
    AppMethodBeat.i(133225);
    ab.i("MicroMsg.AppBrandIDCardUI", "protocalUrl click");
    Fh(paramString);
    AppMethodBeat.o(133225);
  }
  
  public final void Ff(String paramString)
  {
    AppMethodBeat.i(133226);
    ab.i("MicroMsg.AppBrandIDCardUI", "urlJump click");
    Fh(paramString);
    AppMethodBeat.o(133226);
  }
  
  public final void Fg(String paramString)
  {
    AppMethodBeat.i(133227);
    ab.i("MicroMsg.AppBrandIDCardUI", "url2Jump click");
    Fh(paramString);
    AppMethodBeat.o(133227);
  }
  
  public final void a(gb paramgb)
  {
    AppMethodBeat.i(133231);
    h.qsU.e(14943, new Object[] { AppBrandIDCardUI.a(this.iQz), Integer.valueOf(7), AppBrandIDCardUI.g(this.iQz).crs });
    ab.i("MicroMsg.AppBrandIDCardUI", "sendSms");
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bzh();
    ((b.a)localObject).fsY = new bzi();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/sendsms";
    ((b.a)localObject).funcId = 1762;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).ado();
    bzh localbzh = (bzh)((com.tencent.mm.ai.b)localObject).fsV.fta;
    localbzh.cwc = AppBrandIDCardUI.a(this.iQz);
    localbzh.xLl = AppBrandIDCardUI.b(this.iQz);
    localbzh.xLm = AppBrandIDCardUI.i(this.iQz);
    localbzh.wsj = paramgb.wsj;
    localbzh.poq = paramgb.poq;
    localbzh.crs = AppBrandIDCardUI.g(this.iQz).crs;
    com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ai.b)localObject, new AppBrandIDCardUI.1.5(this));
    AppMethodBeat.o(133231);
  }
  
  public final void a(String paramString, gb paramgb)
  {
    AppMethodBeat.i(133232);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.AppBrandIDCardUI", "verifyCode is null, err, return");
      AppMethodBeat.o(133232);
      return;
    }
    ab.i("MicroMsg.AppBrandIDCardUI", "verifySms");
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cqg();
    ((b.a)localObject).fsY = new cqh();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/verifysmscode";
    ((b.a)localObject).funcId = 1721;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).ado();
    cqg localcqg = (cqg)((com.tencent.mm.ai.b)localObject).fsV.fta;
    localcqg.cwc = AppBrandIDCardUI.a(this.iQz);
    localcqg.xLl = AppBrandIDCardUI.b(this.iQz);
    localcqg.xLm = AppBrandIDCardUI.i(this.iQz);
    localcqg.wsj = paramgb.wsj;
    localcqg.crs = AppBrandIDCardUI.g(this.iQz).crs;
    localcqg.uld = paramString;
    localcqg.xLo = AppBrandIDCardUI.j(this.iQz);
    localcqg.poq = paramgb.poq;
    com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ai.b)localObject, new AppBrandIDCardUI.1.6(this));
    AppMethodBeat.o(133232);
  }
  
  public final void aMB()
  {
    AppMethodBeat.i(133222);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cck();
    ((b.a)localObject).fsY = new ccl();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/showauthorizeuserid";
    ((b.a)localObject).funcId = 1774;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).ado();
    cck localcck = (cck)((com.tencent.mm.ai.b)localObject).fsV.fta;
    localcck.cwc = AppBrandIDCardUI.a(this.iQz);
    localcck.xLl = AppBrandIDCardUI.b(this.iQz);
    localcck.xMP = AppBrandIDCardUI.c(this.iQz);
    com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ai.b)localObject, new AppBrandIDCardUI.1.1(this));
    AppMethodBeat.o(133222);
  }
  
  public final void aMC()
  {
    AppMethodBeat.i(133229);
    ab.i("MicroMsg.AppBrandIDCardUI", "verifyPassword");
    h.qsU.e(14943, new Object[] { AppBrandIDCardUI.a(this.iQz), Integer.valueOf(2), AppBrandIDCardUI.g(this.iQz).crs });
    if (AppBrandIDCardUI.g(this.iQz).xMY == null)
    {
      ab.e("MicroMsg.AppBrandIDCardUI", "showAuthorizeUserIDResp.verify_pay_req is null");
      AppMethodBeat.o(133229);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", AppBrandIDCardUI.g(this.iQz).xMY.cwc);
      localJSONObject.put("timeStamp", AppBrandIDCardUI.g(this.iQz).xMY.cqf);
      localJSONObject.put("nonceStr", AppBrandIDCardUI.g(this.iQz).xMY.xmq);
      localJSONObject.put("package", AppBrandIDCardUI.g(this.iQz).xMY.xZg);
      localJSONObject.put("signType", AppBrandIDCardUI.g(this.iQz).xMY.kwH);
      localJSONObject.put("paySign", AppBrandIDCardUI.g(this.iQz).xMY.xlD);
      h.qsU.e(14943, new Object[] { AppBrandIDCardUI.a(this.iQz), Integer.valueOf(3), AppBrandIDCardUI.g(this.iQz).crs });
      a.hWj.a(this.iQz, localJSONObject, new AppBrandIDCardUI.1.4(this));
      AppMethodBeat.o(133229);
      return;
    }
    catch (JSONException localJSONException)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandIDCardUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(133229);
    }
  }
  
  public final void aMD()
  {
    AppMethodBeat.i(133230);
    h.qsU.e(14943, new Object[] { AppBrandIDCardUI.a(this.iQz), Integer.valueOf(6), AppBrandIDCardUI.g(this.iQz).crs });
    AppMethodBeat.o(133230);
  }
  
  public final ccl aME()
  {
    AppMethodBeat.i(133233);
    ccl localccl = AppBrandIDCardUI.g(this.iQz);
    AppMethodBeat.o(133233);
    return localccl;
  }
  
  public final gc aMF()
  {
    AppMethodBeat.i(133234);
    gc localgc = AppBrandIDCardUI.k(this.iQz);
    AppMethodBeat.o(133234);
    return localgc;
  }
  
  public final void back()
  {
    AppMethodBeat.i(133224);
    AppBrandIDCardUI.f(this.iQz);
    AppMethodBeat.o(133224);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(133223);
    this.iQz.onSwipeBack();
    AppMethodBeat.o(133223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1
 * JD-Core Version:    0.7.0.1
 */