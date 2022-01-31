package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMEditText;

final class QrRewardMainUI$3
  implements a.a
{
  QrRewardMainUI$3(QrRewardMainUI paramQrRewardMainUI, h paramh) {}
  
  public final void h(m paramm)
  {
    AppMethodBeat.i(41085);
    ab.i("MicroMsg.QrRewardMainUI", "set succ: %s, %s", new Object[] { this.kPO.jVh, QrRewardMainUI.a(this.kPN).getText() });
    if (this.kPO.jVh.equals(QrRewardMainUI.c(this.kPN)))
    {
      g.RL().Ru().set(ac.a.yIn, QrRewardMainUI.c(this.kPN));
      QrRewardMainUI.m(this.kPN);
    }
    AppMethodBeat.o(41085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.3
 * JD-Core Version:    0.7.0.1
 */