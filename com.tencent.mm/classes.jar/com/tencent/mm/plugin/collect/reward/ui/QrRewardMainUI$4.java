package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class QrRewardMainUI$4
  implements n.c
{
  QrRewardMainUI$4(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(41086);
    String str2 = this.kPN.getString(2131302218);
    if (QrRewardMainUI.o(this.kPN))
    {
      str1 = this.kPN.getString(2131302224);
      paraml.a(1, str2, str1);
      str2 = this.kPN.getString(2131302219);
      if (QrRewardMainUI.o(this.kPN)) {
        break label93;
      }
    }
    label93:
    for (String str1 = this.kPN.getString(2131302224);; str1 = "")
    {
      paraml.a(2, str2, str1);
      AppMethodBeat.o(41086);
      return;
      str1 = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.4
 * JD-Core Version:    0.7.0.1
 */