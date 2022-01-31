package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;

final class LuckyMoneyNewYearReceiveUI$1$1
  implements Runnable
{
  LuckyMoneyNewYearReceiveUI$1$1(LuckyMoneyNewYearReceiveUI.1 param1, EmojiInfo paramEmojiInfo, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(42783);
    if ((this.otC != null) && (LuckyMoneyNewYearReceiveUI.a(this.ouE.ouD) != null) && (LuckyMoneyNewYearReceiveUI.a(this.ouE.ouD).Al().equals(this.otC.Al())))
    {
      if (this.egM)
      {
        ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "somethings success.");
        LuckyMoneyNewYearReceiveUI.a(this.ouE.ouD, i.getEmojiStorageMgr().yNn.asP(LuckyMoneyNewYearReceiveUI.a(this.ouE.ouD).Al()));
        LuckyMoneyNewYearReceiveUI.b(this.ouE.ouD).setVisibility(8);
        LuckyMoneyNewYearReceiveUI.c(this.ouE.ouD).setVisibility(0);
        LuckyMoneyNewYearReceiveUI.c(this.ouE.ouD).setEmojiInfo(LuckyMoneyNewYearReceiveUI.a(this.ouE.ouD));
        AppMethodBeat.o(42783);
        return;
      }
      ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "somethings error.");
      LuckyMoneyNewYearReceiveUI.b(this.ouE.ouD).setVisibility(8);
      LuckyMoneyNewYearReceiveUI.d(this.ouE.ouD).setVisibility(0);
    }
    AppMethodBeat.o(42783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.1.1
 * JD-Core Version:    0.7.0.1
 */