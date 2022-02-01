package com.tencent.mm.plugin.appbrand.permission;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.widget.g.a;
import com.tencent.mm.plugin.appbrand.widget.g.b.a;
import com.tencent.mm.plugin.appbrand.widget.g.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;

final class b
{
  private static final SparseIntArray qzj;
  private static final Set<String> qzk;
  
  static
  {
    AppMethodBeat.i(47994);
    qzj = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(47991);
        paramAnonymousInt = super.get(paramAnonymousInt, au.i.app_brand_jsapi_ban_banner_hint_other_api);
        AppMethodBeat.o(47991);
        return paramAnonymousInt;
      }
    };
    qzk = new HashSet();
    qzj.put("requestPayment".hashCode(), au.i.app_brand_jsapi_ban_banner_hint_api_name_pay);
    qzj.put("requestVirtualPayment".hashCode(), au.i.app_brand_jsapi_ban_banner_hint_api_name_pay);
    qzj.put("playVoice".hashCode(), au.i.app_brand_jsapi_ban_banner_hint_api_name_play);
    qzj.put("operateMusicPlayer".hashCode(), au.i.app_brand_jsapi_ban_banner_hint_api_name_play);
    qzj.put("shareAppMessage".hashCode(), au.i.app_brand_jsapi_ban_banner_hint_api_name_share);
    qzj.put("onShareAppMessage".hashCode(), au.i.app_brand_jsapi_ban_banner_hint_api_name_share);
    qzj.put("shareAppMessageDirectly".hashCode(), au.i.app_brand_jsapi_ban_banner_hint_api_name_share);
    qzj.put("shareTimeline".hashCode(), au.i.app_brand_jsapi_ban_banner_hint_api_name_share);
    qzj.put("onShareTimeline".hashCode(), au.i.app_brand_jsapi_ban_banner_hint_api_name_share);
    qzj.put("launchMiniProgram".hashCode(), au.i.app_brand_jsapi_ban_banner_hint_api_name_launch);
    qzk.add("requestPayment");
    qzk.add("requestVirtualPayment");
    qzk.add("playVoice");
    qzk.add("operateMusicPlayer");
    qzk.add("shareAppMessage");
    qzk.add("onShareAppMessage");
    qzk.add("shareAppMessageDirectly");
    qzk.add("shareTimeline");
    qzk.add("onShareTimeline");
    qzk.add("launchMiniProgram");
    qzk.add("makeVoIPCall");
    qzk.add("addCard");
    qzk.add("chooseContact");
    qzk.add("openCard");
    qzk.add("openOfflinePayView");
    qzk.add("openWCPayLQTDepositPlan");
    qzk.add("openWCPayLQTDepositPlanAdd");
    qzk.add("openWCPayLQTDetail");
    qzk.add("openWCPayLQTSave");
    qzk.add("loadPaySpeechDialectConfig");
    qzk.add("setCurrentPaySpeech");
    qzk.add("openWCCardHomePage");
    qzk.add("openWCCertHomePage");
    qzk.add("requestBizSplitBillPayment");
    AppMethodBeat.o(47994);
  }
  
  static void o(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(47993);
    if ((paramAppBrandRuntime == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(47993);
      return;
    }
    paramString = MMApplicationContext.getResources().getString(qzj.get(paramString.hashCode()));
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47992);
        Object localObject = this.cAw.bBX();
        if (localObject != null)
        {
          localObject = ((x)localObject).getCurrentPage();
          if (localObject != null)
          {
            localObject = ((u)localObject).getCurrentPageView();
            if (localObject != null)
            {
              localObject = ((ad)localObject).qsF;
              String str = this.val$message;
              if (((com.tencent.mm.plugin.appbrand.widget.g.b)localObject).qoX.isRunning())
              {
                b.a locala = ((com.tencent.mm.plugin.appbrand.widget.g.b)localObject).cpZ();
                ((com.tencent.mm.plugin.appbrand.widget.g.b)localObject).cqa();
                if (((com.tencent.mm.plugin.appbrand.widget.g.b)localObject).rEh == null)
                {
                  ((com.tencent.mm.plugin.appbrand.widget.g.b)localObject).rEh = new a(((com.tencent.mm.plugin.appbrand.widget.g.b)localObject).qoX.getContext());
                  ((com.tencent.mm.plugin.appbrand.widget.g.b)localObject).rEh.c(locala);
                }
                ((com.tencent.mm.plugin.appbrand.widget.g.b)localObject).rEh.anL(str);
              }
            }
          }
        }
        AppMethodBeat.o(47992);
      }
    });
    AppMethodBeat.o(47993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.b
 * JD-Core Version:    0.7.0.1
 */