package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import android.content.res.Resources;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.u.a;
import com.tencent.mm.plugin.appbrand.launching.params.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.weishi.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.concurrent.atomic.AtomicInteger;

final class c$1
  implements MMActivity.a
{
  c$1(c paramc, com.tencent.mm.plugin.appbrand.service.c paramc1, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, String paramString7, AppBrandSysConfigWC paramAppBrandSysConfigWC, String paramString8, z paramz, boolean paramBoolean2, String paramString9, boolean paramBoolean3, boolean paramBoolean4, String paramString10, int paramInt3, AppBrandInitConfigWC paramAppBrandInitConfigWC, MMActivity paramMMActivity) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(131439);
    if (paramInt1 != 1)
    {
      ab.i("MicroMsg.JsApiShareAppMessage", "requestCode(%d) not corrected.", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(131439);
      return;
    }
    String str;
    if (paramInt2 != -1)
    {
      ab.i("MicroMsg.JsApiShareAppMessage", "resultCode is not RESULT_OK(%d)", new Object[] { Integer.valueOf(paramInt2) });
      this.hxC.h(this.bAX, this.hZs.j("cancel", null));
      paramIntent = this.val$appId;
      str = this.hZg;
      if (this.hZh) {}
      for (paramInt1 = 16;; paramInt1 = 2)
      {
        c.a(paramIntent, str, paramInt1, "", 3, paramInt2);
        AppMethodBeat.o(131439);
        return;
      }
    }
    if (paramIntent == null)
    {
      str = null;
      if ((str != null) && (str.length() != 0)) {
        break label217;
      }
      ab.e("MicroMsg.JsApiShareAppMessage", "mmOnActivityResult fail, toUser is null");
      this.hxC.h(this.bAX, this.hZs.j("fail:selected user is nil", null));
      if (!this.hZh) {
        break label212;
      }
    }
    label212:
    for (paramInt1 = 16;; paramInt1 = 2)
    {
      c.a(this.val$appId, this.hZg, paramInt1, "", 2, paramInt2);
      AppMethodBeat.o(131439);
      return;
      str = paramIntent.getStringExtra("Select_Conv_User");
      break;
    }
    label217:
    ab.i("MicroMsg.JsApiShareAppMessage", "result success toUser : %s ", new Object[] { str });
    paramIntent = paramIntent.getStringExtra("custom_send_text");
    SendAppMessageTask localSendAppMessageTask = new SendAppMessageTask();
    localSendAppMessageTask.hZN = paramIntent;
    localSendAppMessageTask.toUser = str;
    localSendAppMessageTask.appId = this.val$appId;
    o localo = this.hxC.getRuntime();
    if ((localo != null) && (localo.wZ() != null) && ((localo.wZ() instanceof AppBrandInitConfigWC)))
    {
      localSendAppMessageTask.bDc = ((AppBrandInitConfigWC)localo.wZ()).bDc;
      localSendAppMessageTask.userName = this.fwC;
      localSendAppMessageTask.title = this.cbK;
      localSendAppMessageTask.description = this.hZi;
      localSendAppMessageTask.url = this.hZj;
      localSendAppMessageTask.path = this.hZg;
      localSendAppMessageTask.type = this.bHS;
      localSendAppMessageTask.hZO = this.hZk;
      localSendAppMessageTask.iconUrl = this.hKF.hiQ;
      localSendAppMessageTask.cvs = this.hKF.hiX.gXe;
      localSendAppMessageTask.hko = this.hKF.hiX.cqq;
      localSendAppMessageTask.version = this.hKF.hiX.gXf;
      localSendAppMessageTask.nickname = this.hKF.cqQ;
      localSendAppMessageTask.fhC = this.hZl;
      localSendAppMessageTask.hZT = n.yd(this.val$appId).gQW.getAndIncrement();
      localSendAppMessageTask.hZV = this.hKE.hzM;
      localSendAppMessageTask.hZW = this.hKE.aAI();
      paramIntent = this.hKE.getRuntime().wS().bDh;
      if (paramIntent != null)
      {
        if (paramIntent.scene != 0) {
          break label860;
        }
        paramInt1 = 1000;
        label532:
        localSendAppMessageTask.scene = paramInt1;
        localSendAppMessageTask.cmF = bo.nullAsNil(paramIntent.cmF);
        localSendAppMessageTask.hZU = bo.nullAsNil(this.hKE.getRuntime().atS().vZ());
      }
      localSendAppMessageTask.hKA = this.hZm;
      localSendAppMessageTask.hZP = l.getRealPath(this.hZn);
      localSendAppMessageTask.withShareTicket = this.hZh;
      localSendAppMessageTask.hZX = this.hZo;
      localSendAppMessageTask.hZY = this.hZp;
      localSendAppMessageTask.cacheKey = this.cbQ;
      localSendAppMessageTask.fmF = this.hZq;
      paramIntent = this.hKE.aJz();
      if (paramIntent != null) {
        break label868;
      }
      paramIntent = "";
      label652:
      localSendAppMessageTask.iaa = paramIntent;
      if (g.J(localo))
      {
        localSendAppMessageTask.hZR = 3;
        if (this.hZr.bDa != null)
        {
          localSendAppMessageTask.iab = this.hZr.bDa.appId;
          localSendAppMessageTask.iac = this.hZr.bDa.appName;
          localSendAppMessageTask.iad = this.hZr.bDa.inF;
          localSendAppMessageTask.iae = this.hZr.bDa.thumbUrl;
          if (bo.isNullOrNil(localSendAppMessageTask.hZO))
          {
            localSendAppMessageTask.hZP = this.hZr.bDa.inD;
            localSendAppMessageTask.hKA = false;
          }
        }
      }
      if (!this.hZh) {
        break label879;
      }
      localSendAppMessageTask.hxp = new c.1.1(this, localSendAppMessageTask, str, paramInt2);
      localSendAppMessageTask.aBj();
      AppBrandMainProcessService.a(localSendAppMessageTask);
    }
    for (;;)
    {
      if (this.cae != null) {
        com.tencent.mm.ui.base.h.bO(this.cae, this.cae.getResources().getString(2131296571));
      }
      AppMethodBeat.o(131439);
      return;
      ab.w("MicroMsg.JsApiShareAppMessage", "hy: can not retrieve init config");
      localSendAppMessageTask.bDc = -1;
      break;
      label860:
      paramInt1 = paramIntent.scene;
      break label532;
      label868:
      paramIntent = paramIntent.getWebView().getUrl();
      break label652;
      label879:
      AppBrandMainProcessService.a(localSendAppMessageTask);
      this.hxC.h(this.bAX, this.hZs.j("ok", null));
      paramInt1 = 2;
      if (str.toLowerCase().endsWith("@chatroom")) {
        paramInt1 = 9;
      }
      c.a(this.val$appId, this.hZg, paramInt1, "", 1, paramInt2);
      if ("wxfe02ecfe70800f46".equalsIgnoreCase(this.val$appId)) {
        com.tencent.mm.plugin.report.service.h.qsU.e(16979, new Object[] { this.val$appId, this.hZg, Integer.valueOf(0), Integer.valueOf(3) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.c.1
 * JD-Core Version:    0.7.0.1
 */