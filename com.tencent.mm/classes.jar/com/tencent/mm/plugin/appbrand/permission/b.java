package com.tencent.mm.plugin.appbrand.permission;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.widget.e.a;
import com.tencent.mm.plugin.appbrand.widget.e.b.a;
import com.tencent.mm.plugin.appbrand.widget.e.f;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashSet;
import java.util.Set;

final class b
{
  private static final SparseIntArray mmH;
  private static final Set<String> mmI;
  
  static
  {
    AppMethodBeat.i(47994);
    mmH = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(47991);
        paramAnonymousInt = super.get(paramAnonymousInt, 2131755480);
        AppMethodBeat.o(47991);
        return paramAnonymousInt;
      }
    };
    mmI = new HashSet();
    mmH.put("requestPayment".hashCode(), 2131755476);
    mmH.put("requestVirtualPayment".hashCode(), 2131755476);
    mmH.put("playVoice".hashCode(), 2131755477);
    mmH.put("operateMusicPlayer".hashCode(), 2131755477);
    mmH.put("shareAppMessage".hashCode(), 2131755478);
    mmH.put("onShareAppMessage".hashCode(), 2131755478);
    mmH.put("shareAppMessageDirectly".hashCode(), 2131755478);
    mmH.put("shareTimeline".hashCode(), 2131755478);
    mmH.put("onShareTimeline".hashCode(), 2131755478);
    mmH.put("launchMiniProgram".hashCode(), 2131755475);
    mmI.add("requestPayment");
    mmI.add("requestVirtualPayment");
    mmI.add("playVoice");
    mmI.add("operateMusicPlayer");
    mmI.add("shareAppMessage");
    mmI.add("onShareAppMessage");
    mmI.add("shareAppMessageDirectly");
    mmI.add("shareTimeline");
    mmI.add("onShareTimeline");
    mmI.add("launchMiniProgram");
    mmI.add("makeVoIPCall");
    mmI.add("addCard");
    mmI.add("chooseContact");
    mmI.add("openCard");
    mmI.add("openOfflinePayView");
    mmI.add("openWCPayLQTDepositPlan");
    mmI.add("openWCPayLQTDepositPlanAdd");
    mmI.add("openWCPayLQTDetail");
    mmI.add("openWCPayLQTSave");
    mmI.add("loadPaySpeechDialectConfig");
    mmI.add("setCurrentPaySpeech");
    mmI.add("openWCCardHomePage");
    mmI.add("openWCCertHomePage");
    mmI.add("requestBizSplitBillPayment");
    AppMethodBeat.o(47994);
  }
  
  static void n(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(47993);
    if ((paramAppBrandRuntime == null) || (bu.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(47993);
      return;
    }
    paramString = ak.getResources().getString(mmH.get(paramString.hashCode()));
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47992);
        Object localObject = this.jBu.aWm();
        if (localObject != null)
        {
          localObject = ((t)localObject).getCurrentPage();
          if (localObject != null)
          {
            localObject = ((q)localObject).getCurrentPageView();
            if (localObject != null)
            {
              localObject = ((z)localObject).mgu;
              String str = this.val$message;
              if (((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).nrR.isRunning())
              {
                b.a locala = ((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).bGs();
                ((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).bGt();
                if (((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).nrT == null)
                {
                  ((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).nrT = new a(((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).nrR.getContext());
                  ((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).nrT.b(locala);
                }
                ((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).nrT.Wm(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.b
 * JD-Core Version:    0.7.0.1
 */