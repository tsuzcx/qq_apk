package com.tencent.mm.plugin.appbrand.permission;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.widget.f.a;
import com.tencent.mm.plugin.appbrand.widget.f.b.a;
import com.tencent.mm.plugin.appbrand.widget.f.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;

final class b
{
  private static final SparseIntArray nxh;
  private static final Set<String> nxi;
  
  static
  {
    AppMethodBeat.i(47994);
    nxh = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(47991);
        paramAnonymousInt = super.get(paramAnonymousInt, 2131755518);
        AppMethodBeat.o(47991);
        return paramAnonymousInt;
      }
    };
    nxi = new HashSet();
    nxh.put("requestPayment".hashCode(), 2131755514);
    nxh.put("requestVirtualPayment".hashCode(), 2131755514);
    nxh.put("playVoice".hashCode(), 2131755515);
    nxh.put("operateMusicPlayer".hashCode(), 2131755515);
    nxh.put("shareAppMessage".hashCode(), 2131755516);
    nxh.put("onShareAppMessage".hashCode(), 2131755516);
    nxh.put("shareAppMessageDirectly".hashCode(), 2131755516);
    nxh.put("shareTimeline".hashCode(), 2131755516);
    nxh.put("onShareTimeline".hashCode(), 2131755516);
    nxh.put("launchMiniProgram".hashCode(), 2131755513);
    nxi.add("requestPayment");
    nxi.add("requestVirtualPayment");
    nxi.add("playVoice");
    nxi.add("operateMusicPlayer");
    nxi.add("shareAppMessage");
    nxi.add("onShareAppMessage");
    nxi.add("shareAppMessageDirectly");
    nxi.add("shareTimeline");
    nxi.add("onShareTimeline");
    nxi.add("launchMiniProgram");
    nxi.add("makeVoIPCall");
    nxi.add("addCard");
    nxi.add("chooseContact");
    nxi.add("openCard");
    nxi.add("openOfflinePayView");
    nxi.add("openWCPayLQTDepositPlan");
    nxi.add("openWCPayLQTDepositPlanAdd");
    nxi.add("openWCPayLQTDetail");
    nxi.add("openWCPayLQTSave");
    nxi.add("loadPaySpeechDialectConfig");
    nxi.add("setCurrentPaySpeech");
    nxi.add("openWCCardHomePage");
    nxi.add("openWCCertHomePage");
    nxi.add("requestBizSplitBillPayment");
    AppMethodBeat.o(47994);
  }
  
  static void n(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(47993);
    if ((paramAppBrandRuntime == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(47993);
      return;
    }
    paramString = MMApplicationContext.getResources().getString(nxh.get(paramString.hashCode()));
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47992);
        Object localObject = this.cBo.brh();
        if (localObject != null)
        {
          localObject = ((w)localObject).getCurrentPage();
          if (localObject != null)
          {
            localObject = ((t)localObject).getCurrentPageView();
            if (localObject != null)
            {
              localObject = ((ac)localObject).nqT;
              String str = this.val$message;
              if (((com.tencent.mm.plugin.appbrand.widget.f.b)localObject).nnq.isRunning())
              {
                b.a locala = ((com.tencent.mm.plugin.appbrand.widget.f.b)localObject).ccI();
                ((com.tencent.mm.plugin.appbrand.widget.f.b)localObject).ccJ();
                if (((com.tencent.mm.plugin.appbrand.widget.f.b)localObject).oBy == null)
                {
                  ((com.tencent.mm.plugin.appbrand.widget.f.b)localObject).oBy = new a(((com.tencent.mm.plugin.appbrand.widget.f.b)localObject).nnq.getContext());
                  ((com.tencent.mm.plugin.appbrand.widget.f.b)localObject).oBy.c(locala);
                }
                ((com.tencent.mm.plugin.appbrand.widget.f.b)localObject).oBy.agi(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.b
 * JD-Core Version:    0.7.0.1
 */