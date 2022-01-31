package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import android.content.res.Resources;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.t.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.concurrent.atomic.AtomicInteger;

final class c$1
  implements MMActivity.a
{
  c$1(c paramc, p paramp, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, String paramString7, AppBrandSysConfigWC paramAppBrandSysConfigWC, String paramString8, s params, boolean paramBoolean2, String paramString9, boolean paramBoolean3, boolean paramBoolean4, String paramString10, int paramInt3, MMActivity paramMMActivity) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 16;
    if (paramInt1 != 1)
    {
      y.i("MicroMsg.JsApiShareAppMessage", "requestCode(%d) not corrected.", new Object[] { Integer.valueOf(paramInt1) });
      return;
    }
    String str;
    if (paramInt2 != -1)
    {
      y.i("MicroMsg.JsApiShareAppMessage", "resultCode is not RESULT_OK(%d)", new Object[] { Integer.valueOf(paramInt2) });
      this.gbW.C(this.dIS, this.gBw.h("cancel", null));
      paramIntent = this.val$appId;
      str = this.gBl;
      if (this.gBm) {}
      for (;;)
      {
        c.a(paramIntent, str, i, "", 3, paramInt2);
        return;
        i = 2;
      }
    }
    if (paramIntent == null)
    {
      str = null;
      if ((str != null) && (str.length() != 0)) {
        break label199;
      }
      y.e("MicroMsg.JsApiShareAppMessage", "mmOnActivityResult fail, toUser is null");
      this.gbW.C(this.dIS, this.gBw.h("fail:selected user is nil", null));
      if (!this.gBm) {
        break label193;
      }
    }
    for (;;)
    {
      c.a(this.val$appId, this.gBl, i, "", 2, paramInt2);
      return;
      str = paramIntent.getStringExtra("Select_Conv_User");
      break;
      label193:
      i = 2;
    }
    label199:
    y.i("MicroMsg.JsApiShareAppMessage", "result success toUser : %s ", new Object[] { str });
    paramIntent = paramIntent.getStringExtra("custom_send_text");
    SendAppMessageTask localSendAppMessageTask = new SendAppMessageTask();
    localSendAppMessageTask.gBE = paramIntent;
    localSendAppMessageTask.toUser = str;
    localSendAppMessageTask.appId = this.val$appId;
    localSendAppMessageTask.userName = this.egy;
    localSendAppMessageTask.title = this.dYK;
    localSendAppMessageTask.description = this.gBn;
    localSendAppMessageTask.url = this.gBo;
    localSendAppMessageTask.path = this.gBl;
    localSendAppMessageTask.type = this.bns;
    localSendAppMessageTask.gBF = this.gBp;
    localSendAppMessageTask.iconUrl = this.gpV.fPM;
    localSendAppMessageTask.bOa = this.gpV.fPS.fEM;
    localSendAppMessageTask.fRx = this.gpV.fPS.bIW;
    localSendAppMessageTask.version = this.gpV.fPS.fEN;
    localSendAppMessageTask.nickname = this.gpV.bJw;
    localSendAppMessageTask.dRD = this.gBq;
    localSendAppMessageTask.gBH = m.qI(this.val$appId).fzu.getAndIncrement();
    localSendAppMessageTask.gBJ = this.gfM.getURL();
    localSendAppMessageTask.gBK = this.gfM.agX();
    paramIntent = this.gfM.getRuntime().aab();
    if (paramIntent != null)
    {
      if (paramIntent.scene == 0)
      {
        paramInt1 = 1000;
        localSendAppMessageTask.scene = paramInt1;
        localSendAppMessageTask.bFv = bk.pm(paramIntent.bFv);
        localSendAppMessageTask.gBI = bk.pm(this.gfM.getRuntime().aac().fJO);
      }
    }
    else
    {
      localSendAppMessageTask.gpR = this.gBr;
      localSendAppMessageTask.gBG = k.getRealPath(this.gBs);
      localSendAppMessageTask.withShareTicket = this.gBm;
      localSendAppMessageTask.gBL = this.gBt;
      localSendAppMessageTask.gBM = this.gBu;
      localSendAppMessageTask.fWw = this.eal;
      localSendAppMessageTask.dWx = this.gBv;
      paramIntent = this.gfM.ans();
      if (paramIntent != null) {
        break label660;
      }
    }
    label660:
    for (paramIntent = "";; paramIntent = paramIntent.getWebView().getUrl())
    {
      localSendAppMessageTask.gBN = paramIntent;
      if (!this.gBm) {
        break label671;
      }
      localSendAppMessageTask.gfD = new c.1.1(this, localSendAppMessageTask, str, paramInt2);
      localSendAppMessageTask.ahC();
      AppBrandMainProcessService.a(localSendAppMessageTask);
      label623:
      if (this.byc == null) {
        break label732;
      }
      h.bC(this.byc, this.byc.getResources().getString(y.j.app_brand_app_msg_shared));
      return;
      paramInt1 = paramIntent.scene;
      break;
    }
    label671:
    AppBrandMainProcessService.a(localSendAppMessageTask);
    this.gbW.C(this.dIS, this.gBw.h("ok", null));
    if (str.toLowerCase().endsWith("@chatroom")) {}
    for (paramInt1 = 9;; paramInt1 = 2)
    {
      c.a(this.val$appId, this.gBl, paramInt1, "", 1, paramInt2);
      break label623;
      label732:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.c.1
 * JD-Core Version:    0.7.0.1
 */