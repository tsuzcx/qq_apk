package com.tencent.mm.plugin.appbrand.permission;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Set;

final class b
{
  private static final SparseIntArray iBk;
  private static final Set<String> iBl;
  
  static
  {
    AppMethodBeat.i(132508);
    iBk = new b.1();
    iBl = new HashSet();
    iBk.put("requestPayment".hashCode(), 2131296695);
    iBk.put("requestVirtualPayment".hashCode(), 2131296695);
    iBk.put("playVoice".hashCode(), 2131296696);
    iBk.put("operateMusicPlayer".hashCode(), 2131296696);
    iBk.put("shareAppMessage".hashCode(), 2131296697);
    iBk.put("onShareAppMessage".hashCode(), 2131296697);
    iBk.put("shareAppMessageDirectly".hashCode(), 2131296697);
    iBk.put("shareTimeline".hashCode(), 2131296697);
    iBk.put("onMenuShareTimeline".hashCode(), 2131296697);
    iBk.put("launchMiniProgram".hashCode(), 2131296694);
    iBl.add("requestPayment");
    iBl.add("requestVirtualPayment");
    iBl.add("playVoice");
    iBl.add("operateMusicPlayer");
    iBl.add("shareAppMessage");
    iBl.add("onShareAppMessage");
    iBl.add("shareAppMessageDirectly");
    iBl.add("shareTimeline");
    iBl.add("onMenuShareTimeline");
    iBl.add("launchMiniProgram");
    iBl.add("makeVoIPCall");
    iBl.add("addCard");
    iBl.add("chooseContact");
    iBl.add("openCard");
    iBl.add("openOfflinePayView");
    iBl.add("openWCPayLQTDepositPlan");
    iBl.add("openWCPayLQTDepositPlanAdd");
    iBl.add("openWCPayLQTDetail");
    iBl.add("openWCPayLQTSave");
    iBl.add("loadPaySpeechDialectConfig");
    iBl.add("setCurrentPaySpeech");
    iBl.add("openWCCardHomePage");
    iBl.add("openWCCertHomePage");
    AppMethodBeat.o(132508);
  }
  
  static void k(i parami, String paramString)
  {
    AppMethodBeat.i(132507);
    if ((parami == null) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(132507);
      return;
    }
    paramString = ah.getResources().getString(iBk.get(paramString.hashCode()));
    m.runOnUiThread(new b.2(parami, ah.getResources().getString(2131296698, new Object[] { paramString })));
    AppMethodBeat.o(132507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.b
 * JD-Core Version:    0.7.0.1
 */