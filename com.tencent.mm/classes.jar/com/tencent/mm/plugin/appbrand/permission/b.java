package com.tencent.mm.plugin.appbrand.permission;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Set;

final class b
{
  private static final SparseIntArray mhJ;
  private static final Set<String> mhK;
  
  static
  {
    AppMethodBeat.i(47994);
    mhJ = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(47991);
        paramAnonymousInt = super.get(paramAnonymousInt, 2131755480);
        AppMethodBeat.o(47991);
        return paramAnonymousInt;
      }
    };
    mhK = new HashSet();
    mhJ.put("requestPayment".hashCode(), 2131755476);
    mhJ.put("requestVirtualPayment".hashCode(), 2131755476);
    mhJ.put("playVoice".hashCode(), 2131755477);
    mhJ.put("operateMusicPlayer".hashCode(), 2131755477);
    mhJ.put("shareAppMessage".hashCode(), 2131755478);
    mhJ.put("onShareAppMessage".hashCode(), 2131755478);
    mhJ.put("shareAppMessageDirectly".hashCode(), 2131755478);
    mhJ.put("shareTimeline".hashCode(), 2131755478);
    mhJ.put("onShareTimeline".hashCode(), 2131755478);
    mhJ.put("launchMiniProgram".hashCode(), 2131755475);
    mhK.add("requestPayment");
    mhK.add("requestVirtualPayment");
    mhK.add("playVoice");
    mhK.add("operateMusicPlayer");
    mhK.add("shareAppMessage");
    mhK.add("onShareAppMessage");
    mhK.add("shareAppMessageDirectly");
    mhK.add("shareTimeline");
    mhK.add("onShareTimeline");
    mhK.add("launchMiniProgram");
    mhK.add("makeVoIPCall");
    mhK.add("addCard");
    mhK.add("chooseContact");
    mhK.add("openCard");
    mhK.add("openOfflinePayView");
    mhK.add("openWCPayLQTDepositPlan");
    mhK.add("openWCPayLQTDepositPlanAdd");
    mhK.add("openWCPayLQTDetail");
    mhK.add("openWCPayLQTSave");
    mhK.add("loadPaySpeechDialectConfig");
    mhK.add("setCurrentPaySpeech");
    mhK.add("openWCCardHomePage");
    mhK.add("openWCCertHomePage");
    mhK.add("requestBizSplitBillPayment");
    AppMethodBeat.o(47994);
  }
  
  static void n(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(47993);
    if ((paramAppBrandRuntime == null) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(47993);
      return;
    }
    paramString = aj.getResources().getString(mhJ.get(paramString.hashCode()));
    m.runOnUiThread(new b.2(paramAppBrandRuntime, aj.getResources().getString(2131755479, new Object[] { paramString })));
    AppMethodBeat.o(47993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.b
 * JD-Core Version:    0.7.0.1
 */