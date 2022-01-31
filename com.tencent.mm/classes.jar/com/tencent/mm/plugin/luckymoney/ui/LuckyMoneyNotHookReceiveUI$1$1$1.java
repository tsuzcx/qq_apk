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

final class LuckyMoneyNotHookReceiveUI$1$1$1
  implements Runnable
{
  LuckyMoneyNotHookReceiveUI$1$1$1(LuckyMoneyNotHookReceiveUI.1.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(42848);
    if ((this.ovx.otC != null) && (LuckyMoneyNotHookReceiveUI.a(this.ovx.ovw.ovv) != null) && (LuckyMoneyNotHookReceiveUI.a(this.ovx.ovw.ovv).Al().equals(this.ovx.otC.Al())))
    {
      if (this.ovx.egM)
      {
        ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings success.");
        LuckyMoneyNotHookReceiveUI.a(this.ovx.ovw.ovv, i.getEmojiStorageMgr().yNn.asP(LuckyMoneyNotHookReceiveUI.a(this.ovx.ovw.ovv).Al()));
        LuckyMoneyNotHookReceiveUI.b(this.ovx.ovw.ovv).setVisibility(8);
        LuckyMoneyNotHookReceiveUI.c(this.ovx.ovw.ovv).setVisibility(0);
        LuckyMoneyNotHookReceiveUI.a(this.ovx.ovw.ovv, 3);
        LuckyMoneyNotHookReceiveUI.b(this.ovx.ovw.ovv, LuckyMoneyNotHookReceiveUI.a(this.ovx.ovw.ovv));
        AppMethodBeat.o(42848);
        return;
      }
      ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings error.");
      LuckyMoneyNotHookReceiveUI.b(this.ovx.ovw.ovv).setVisibility(8);
      LuckyMoneyNotHookReceiveUI.d(this.ovx.ovw.ovv).setVisibility(0);
      LuckyMoneyNotHookReceiveUI.a(this.ovx.ovw.ovv, 1);
    }
    AppMethodBeat.o(42848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.1.1.1
 * JD-Core Version:    0.7.0.1
 */