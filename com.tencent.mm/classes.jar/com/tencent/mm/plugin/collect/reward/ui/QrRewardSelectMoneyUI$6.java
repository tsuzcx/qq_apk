package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.modelavatar.e;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class QrRewardSelectMoneyUI$6
  implements az.b.a
{
  QrRewardSelectMoneyUI$6(QrRewardSelectMoneyUI paramQrRewardSelectMoneyUI, long paramLong) {}
  
  public final void getContactCallBack(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(63996);
    if (paramBoolean)
    {
      Log.v("MicroMsg.QrRewardSelectMoneyUI", "getContact suc; cost=" + (Util.nowMilliSecond() - this.xbx) + " ms");
      d.aS(paramString, 3);
      q.bFG().LB(paramString);
    }
    for (;;)
    {
      a.b.a(QrRewardSelectMoneyUI.c(this.xbu), paramString, 0.03F, false);
      QrRewardSelectMoneyUI.k(this.xbu, paramString);
      AppMethodBeat.o(63996);
      return;
      Log.w("MicroMsg.QrRewardSelectMoneyUI", "getContact failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.6
 * JD-Core Version:    0.7.0.1
 */