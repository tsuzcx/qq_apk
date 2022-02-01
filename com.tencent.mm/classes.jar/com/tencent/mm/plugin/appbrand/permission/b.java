package com.tencent.mm.plugin.appbrand.permission;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.e.a;
import com.tencent.mm.plugin.appbrand.widget.e.b.a;
import com.tencent.mm.plugin.appbrand.widget.e.f;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashSet;
import java.util.Set;

final class b
{
  private static final SparseIntArray lHY;
  private static final Set<String> lHZ;
  
  static
  {
    AppMethodBeat.i(47994);
    lHY = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(47991);
        paramAnonymousInt = super.get(paramAnonymousInt, 2131755480);
        AppMethodBeat.o(47991);
        return paramAnonymousInt;
      }
    };
    lHZ = new HashSet();
    lHY.put("requestPayment".hashCode(), 2131755476);
    lHY.put("requestVirtualPayment".hashCode(), 2131755476);
    lHY.put("playVoice".hashCode(), 2131755477);
    lHY.put("operateMusicPlayer".hashCode(), 2131755477);
    lHY.put("shareAppMessage".hashCode(), 2131755478);
    lHY.put("onShareAppMessage".hashCode(), 2131755478);
    lHY.put("shareAppMessageDirectly".hashCode(), 2131755478);
    lHY.put("shareTimeline".hashCode(), 2131755478);
    lHY.put("onShareTimeline".hashCode(), 2131755478);
    lHY.put("launchMiniProgram".hashCode(), 2131755475);
    lHZ.add("requestPayment");
    lHZ.add("requestVirtualPayment");
    lHZ.add("playVoice");
    lHZ.add("operateMusicPlayer");
    lHZ.add("shareAppMessage");
    lHZ.add("onShareAppMessage");
    lHZ.add("shareAppMessageDirectly");
    lHZ.add("shareTimeline");
    lHZ.add("onShareTimeline");
    lHZ.add("launchMiniProgram");
    lHZ.add("makeVoIPCall");
    lHZ.add("addCard");
    lHZ.add("chooseContact");
    lHZ.add("openCard");
    lHZ.add("openOfflinePayView");
    lHZ.add("openWCPayLQTDepositPlan");
    lHZ.add("openWCPayLQTDepositPlanAdd");
    lHZ.add("openWCPayLQTDetail");
    lHZ.add("openWCPayLQTSave");
    lHZ.add("loadPaySpeechDialectConfig");
    lHZ.add("setCurrentPaySpeech");
    lHZ.add("openWCCardHomePage");
    lHZ.add("openWCCertHomePage");
    lHZ.add("requestBizSplitBillPayment");
    AppMethodBeat.o(47994);
  }
  
  static void m(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(47993);
    if ((paramAppBrandRuntime == null) || (bs.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(47993);
      return;
    }
    paramString = ai.getResources().getString(lHY.get(paramString.hashCode()));
    l.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47992);
        Object localObject = this.jfp.aSA();
        if (localObject != null)
        {
          localObject = ((u)localObject).getCurrentPage();
          if (localObject != null)
          {
            localObject = ((r)localObject).getCurrentPageView();
            if (localObject != null)
            {
              localObject = ((aa)localObject).lCB;
              String str = this.val$message;
              if (((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).mMl.isRunning())
              {
                b.a locala = ((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).bBv();
                ((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).bBw();
                if (((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).mMn == null)
                {
                  ((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).mMn = new a(((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).mMl.getContext());
                  ((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).mMn.b(locala);
                }
                ((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).mMn.Sd(str);
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