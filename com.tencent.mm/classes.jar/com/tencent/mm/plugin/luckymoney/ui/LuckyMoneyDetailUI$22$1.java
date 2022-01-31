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

final class LuckyMoneyDetailUI$22$1
  implements Runnable
{
  LuckyMoneyDetailUI$22$1(LuckyMoneyDetailUI.22 param22, EmojiInfo paramEmojiInfo, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(42671);
    if ((this.otC != null) && (LuckyMoneyDetailUI.m(this.otD.otz) != null) && (LuckyMoneyDetailUI.m(this.otD.otz).Al().equals(this.otC.Al())))
    {
      if (this.egM)
      {
        ab.i("MicroMsg.LuckyMoneyDetailUI", "somethings success.");
        LuckyMoneyDetailUI.a(this.otD.otz, i.getEmojiStorageMgr().yNn.asP(LuckyMoneyDetailUI.m(this.otD.otz).Al()));
        LuckyMoneyDetailUI.n(this.otD.otz).setVisibility(8);
        LuckyMoneyDetailUI.o(this.otD.otz).setVisibility(0);
        LuckyMoneyDetailUI.b(this.otD.otz, LuckyMoneyDetailUI.m(this.otD.otz));
        AppMethodBeat.o(42671);
        return;
      }
      ab.i("MicroMsg.LuckyMoneyDetailUI", "somethings error.");
      LuckyMoneyDetailUI.n(this.otD.otz).setVisibility(8);
      LuckyMoneyDetailUI.p(this.otD.otz).setVisibility(0);
    }
    AppMethodBeat.o(42671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.22.1
 * JD-Core Version:    0.7.0.1
 */