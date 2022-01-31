package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMEditText;

final class QrRewardMainUI$17
  implements a.a
{
  QrRewardMainUI$17(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final void h(m paramm)
  {
    AppMethodBeat.i(41101);
    ab.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[] { paramm });
    QrRewardMainUI.a(this.kPN, (String)g.RL().Ru().get(ac.a.yIn, ""));
    QrRewardMainUI.a(this.kPN, QrRewardMainUI.o(this.kPN));
    QrRewardMainUI.a(this.kPN).setText("");
    QrRewardMainUI.m(this.kPN);
    AppMethodBeat.o(41101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.17
 * JD-Core Version:    0.7.0.1
 */