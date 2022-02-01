package com.tencent.mm.plugin.appbrand.permission;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Set;

final class b
{
  private static final SparseIntArray lig;
  private static final Set<String> lih;
  
  static
  {
    AppMethodBeat.i(47994);
    lig = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(47991);
        paramAnonymousInt = super.get(paramAnonymousInt, 2131755480);
        AppMethodBeat.o(47991);
        return paramAnonymousInt;
      }
    };
    lih = new HashSet();
    lig.put("requestPayment".hashCode(), 2131755476);
    lig.put("requestVirtualPayment".hashCode(), 2131755476);
    lig.put("playVoice".hashCode(), 2131755477);
    lig.put("operateMusicPlayer".hashCode(), 2131755477);
    lig.put("shareAppMessage".hashCode(), 2131755478);
    lig.put("onShareAppMessage".hashCode(), 2131755478);
    lig.put("shareAppMessageDirectly".hashCode(), 2131755478);
    lig.put("shareTimeline".hashCode(), 2131755478);
    lig.put("onShareTimeline".hashCode(), 2131755478);
    lig.put("launchMiniProgram".hashCode(), 2131755475);
    lih.add("requestPayment");
    lih.add("requestVirtualPayment");
    lih.add("playVoice");
    lih.add("operateMusicPlayer");
    lih.add("shareAppMessage");
    lih.add("onShareAppMessage");
    lih.add("shareAppMessageDirectly");
    lih.add("shareTimeline");
    lih.add("onShareTimeline");
    lih.add("launchMiniProgram");
    lih.add("makeVoIPCall");
    lih.add("addCard");
    lih.add("chooseContact");
    lih.add("openCard");
    lih.add("openOfflinePayView");
    lih.add("openWCPayLQTDepositPlan");
    lih.add("openWCPayLQTDepositPlanAdd");
    lih.add("openWCPayLQTDetail");
    lih.add("openWCPayLQTSave");
    lih.add("loadPaySpeechDialectConfig");
    lih.add("setCurrentPaySpeech");
    lih.add("openWCCardHomePage");
    lih.add("openWCCertHomePage");
    lih.add("requestBizSplitBillPayment");
    AppMethodBeat.o(47994);
  }
  
  static void m(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(47993);
    if ((paramAppBrandRuntime == null) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(47993);
      return;
    }
    paramString = aj.getResources().getString(lig.get(paramString.hashCode()));
    l.runOnUiThread(new b.2(paramAppBrandRuntime, aj.getResources().getString(2131755479, new Object[] { paramString })));
    AppMethodBeat.o(47993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.b
 * JD-Core Version:    0.7.0.1
 */