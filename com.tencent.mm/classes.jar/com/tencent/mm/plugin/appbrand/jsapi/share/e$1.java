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
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

final class e$1
  implements MMActivity.a
{
  e$1(e parame, c paramc, int paramInt1, String paramString1, int paramInt2, boolean paramBoolean1, String paramString2, String paramString3, String paramString4, String paramString5, AppBrandSysConfigWC paramAppBrandSysConfigWC, String paramString6, String paramString7, String paramString8, z paramz, boolean paramBoolean2, String paramString9, int paramInt3, MMActivity paramMMActivity) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(131447);
    if (1 != paramInt1)
    {
      ab.e("MicroMsg.JsApiShareAppMessageForFakeNative", "requestCode(%d) not corrected.", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(131447);
      return;
    }
    if (-1 != paramInt2)
    {
      ab.e("MicroMsg.JsApiShareAppMessageForFakeNative", "resultCode is not RESULT_OK(%d).", new Object[] { Integer.valueOf(paramInt2) });
      this.hxC.h(this.bAX, this.hZK.j("cancel", null));
      AppMethodBeat.o(131447);
      return;
    }
    if (paramIntent == null) {}
    for (String str = null; bo.isNullOrNil(str); str = paramIntent.getStringExtra("Select_Conv_User"))
    {
      ab.e("MicroMsg.JsApiShareAppMessageForFakeNative", "mmOnActivityResult fail, toUser is null.");
      this.hxC.h(this.bAX, this.hZK.j("fail:no selected user", null));
      AppMethodBeat.o(131447);
      return;
    }
    ab.d("MicroMsg.JsApiShareAppMessageForFakeNative", "share app msg success, to: %s ", new Object[] { str });
    paramIntent = paramIntent.getStringExtra("custom_send_text");
    SendAppMessageTask localSendAppMessageTask = new SendAppMessageTask();
    localSendAppMessageTask.hZN = paramIntent;
    localSendAppMessageTask.toUser = str;
    localSendAppMessageTask.appId = this.val$appId;
    paramIntent = this.hxC.getRuntime();
    if ((paramIntent != null) && (paramIntent.wZ() != null) && ((paramIntent.wZ() instanceof AppBrandInitConfigWC)))
    {
      localSendAppMessageTask.bDc = ((AppBrandInitConfigWC)paramIntent.wZ()).bDc;
      localSendAppMessageTask.hZR = 2;
      localSendAppMessageTask.type = 2;
      localSendAppMessageTask.dqS = this.hZH;
      if (!this.hZI) {
        break label670;
      }
      paramInt1 = 1;
      label272:
      localSendAppMessageTask.hZS = paramInt1;
      localSendAppMessageTask.title = this.cbK;
      localSendAppMessageTask.description = this.hZi;
      localSendAppMessageTask.hZO = this.hZk;
      localSendAppMessageTask.hZQ = this.hZJ;
      localSendAppMessageTask.iconUrl = this.hKF.hiQ;
      localSendAppMessageTask.userName = this.fwC;
      localSendAppMessageTask.nickname = this.hKF.cqQ;
      localSendAppMessageTask.path = this.hZg;
      localSendAppMessageTask.cvs = this.hKF.hiX.gXe;
      localSendAppMessageTask.hko = this.hKF.hiX.cqq;
      localSendAppMessageTask.version = this.hKF.hiX.gXf;
      localSendAppMessageTask.url = this.hZj;
      localSendAppMessageTask.hZT = n.yd(this.val$appId).gQW.getAndIncrement();
      localSendAppMessageTask.hZV = this.hKE.hzM;
      localSendAppMessageTask.hZW = this.hKE.aAI();
      paramIntent = this.hKE.getRuntime().wS().bDh;
      if (paramIntent != null)
      {
        if (paramIntent.scene != 0) {
          break label675;
        }
        paramInt1 = 1000;
        label481:
        localSendAppMessageTask.scene = paramInt1;
        localSendAppMessageTask.cmF = bo.nullAsNil(paramIntent.cmF);
        localSendAppMessageTask.hZU = bo.nullAsNil(this.hKE.getRuntime().atS().vZ());
      }
      localSendAppMessageTask.hKA = this.hZm;
      localSendAppMessageTask.hZP = l.getRealPath(this.hZn);
      localSendAppMessageTask.fmF = this.hZq;
      paramIntent = this.hKE.aJz();
      if (paramIntent != null) {
        break label683;
      }
    }
    label670:
    label675:
    label683:
    for (paramIntent = "";; paramIntent = paramIntent.getWebView().getUrl())
    {
      localSendAppMessageTask.iaa = paramIntent;
      AppBrandMainProcessService.a(localSendAppMessageTask);
      paramIntent = new HashMap();
      paramIntent.put("shareUsrs", bo.P(str.split(",")));
      this.hxC.h(this.bAX, this.hZK.j("ok", paramIntent));
      h.bO(this.cae, this.cae.getResources().getString(2131296571));
      AppMethodBeat.o(131447);
      return;
      ab.w("MicroMsg.JsApiShareAppMessageForFakeNative", "can not retrieve init config.");
      localSendAppMessageTask.bDc = -1;
      break;
      paramInt1 = 0;
      break label272;
      paramInt1 = paramIntent.scene;
      break label481;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.e.1
 * JD-Core Version:    0.7.0.1
 */