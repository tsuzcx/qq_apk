package com.tencent.mm.plugin.appbrand.permission;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.widget.h.a;
import com.tencent.mm.plugin.appbrand.widget.h.b.a;
import com.tencent.mm.plugin.appbrand.widget.h.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;

final class b
{
  private static final SparseIntArray tEf;
  private static final Set<String> tEg;
  
  static
  {
    AppMethodBeat.i(47994);
    tEf = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(47991);
        paramAnonymousInt = super.get(paramAnonymousInt, ba.i.app_brand_jsapi_ban_banner_hint_other_api);
        AppMethodBeat.o(47991);
        return paramAnonymousInt;
      }
    };
    tEg = new HashSet();
    tEf.put("requestPayment".hashCode(), ba.i.app_brand_jsapi_ban_banner_hint_api_name_pay);
    tEf.put("requestVirtualPayment".hashCode(), ba.i.app_brand_jsapi_ban_banner_hint_api_name_pay);
    tEf.put("playVoice".hashCode(), ba.i.app_brand_jsapi_ban_banner_hint_api_name_play);
    tEf.put("operateMusicPlayer".hashCode(), ba.i.app_brand_jsapi_ban_banner_hint_api_name_play);
    tEf.put("shareAppMessage".hashCode(), ba.i.app_brand_jsapi_ban_banner_hint_api_name_share);
    tEf.put("onShareAppMessage".hashCode(), ba.i.app_brand_jsapi_ban_banner_hint_api_name_share);
    tEf.put("shareAppMessageDirectly".hashCode(), ba.i.app_brand_jsapi_ban_banner_hint_api_name_share);
    tEf.put("shareTimeline".hashCode(), ba.i.app_brand_jsapi_ban_banner_hint_api_name_share);
    tEf.put("onShareTimeline".hashCode(), ba.i.app_brand_jsapi_ban_banner_hint_api_name_share);
    tEf.put("launchMiniProgram".hashCode(), ba.i.app_brand_jsapi_ban_banner_hint_api_name_launch);
    tEg.add("requestPayment");
    tEg.add("requestVirtualPayment");
    tEg.add("playVoice");
    tEg.add("operateMusicPlayer");
    tEg.add("shareAppMessage");
    tEg.add("onShareAppMessage");
    tEg.add("shareAppMessageDirectly");
    tEg.add("shareTimeline");
    tEg.add("onShareTimeline");
    tEg.add("launchMiniProgram");
    tEg.add("makeVoIPCall");
    tEg.add("addCard");
    tEg.add("chooseContact");
    tEg.add("openCard");
    tEg.add("openOfflinePayView");
    tEg.add("openWCPayLQTDepositPlan");
    tEg.add("openWCPayLQTDepositPlanAdd");
    tEg.add("openWCPayLQTDetail");
    tEg.add("openWCPayLQTSave");
    tEg.add("loadPaySpeechDialectConfig");
    tEg.add("setCurrentPaySpeech");
    tEg.add("openWCCardHomePage");
    tEg.add("openWCCertHomePage");
    tEg.add("requestBizSplitBillPayment");
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
    paramString = MMApplicationContext.getResources().getString(tEf.get(paramString.hashCode()));
    o.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47992);
        Object localObject = b.this.getPageContainer();
        if (localObject != null)
        {
          localObject = ((x)localObject).getCurrentPage();
          if (localObject != null)
          {
            localObject = ((u)localObject).getCurrentPageView();
            if (localObject != null)
            {
              localObject = ((ad)localObject).txj;
              String str = this.val$message;
              if (((com.tencent.mm.plugin.appbrand.widget.h.b)localObject).ttB.isRunning())
              {
                b.a locala = ((com.tencent.mm.plugin.appbrand.widget.h.b)localObject).cSF();
                ((com.tencent.mm.plugin.appbrand.widget.h.b)localObject).cSG();
                if (((com.tencent.mm.plugin.appbrand.widget.h.b)localObject).uPy == null)
                {
                  ((com.tencent.mm.plugin.appbrand.widget.h.b)localObject).uPy = new a(((com.tencent.mm.plugin.appbrand.widget.h.b)localObject).ttB.getContext());
                  ((com.tencent.mm.plugin.appbrand.widget.h.b)localObject).uPy.c(locala);
                }
                ((com.tencent.mm.plugin.appbrand.widget.h.b)localObject).uPy.ahj(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.b
 * JD-Core Version:    0.7.0.1
 */