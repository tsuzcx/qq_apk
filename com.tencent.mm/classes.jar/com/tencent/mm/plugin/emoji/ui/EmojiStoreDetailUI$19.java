package com.tencent.mm.plugin.emoji.ui;

import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class EmojiStoreDetailUI$19
  extends ak
{
  EmojiStoreDetailUI$19(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(53436);
    switch (paramMessage.what)
    {
    default: 
      ab.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow message, cannt handle.");
      AppMethodBeat.o(53436);
      return;
    case 1001: 
      EmojiStoreDetailUI.e(this.lnA);
      AppMethodBeat.o(53436);
      return;
    case 1002: 
      EmojiStoreDetailUI.f(this.lnA);
      AppMethodBeat.o(53436);
      return;
    case 1003: 
      EmojiStoreDetailUI.g(this.lnA);
      AppMethodBeat.o(53436);
      return;
    case 1004: 
      if (EmojiStoreDetailUI.h(this.lnA).getVisibility() == 0)
      {
        EmojiStoreDetailUI.h(this.lnA).setVisibility(8);
        EmojiStoreDetailUI.i(this.lnA).setVisibility(0);
        EmojiStoreDetailUI.j(this.lnA).setVisibility(0);
      }
      EmojiStoreDetailUI.l(this.lnA).setProgress(EmojiStoreDetailUI.k(this.lnA));
      AppMethodBeat.o(53436);
      return;
    case 1005: 
      EmojiStoreDetailUI.m(this.lnA).scrollTo(0, 0);
      AppMethodBeat.o(53436);
      return;
    case 1006: 
      EmojiStoreDetailUI.n(this.lnA);
      AppMethodBeat.o(53436);
      return;
    }
    this.lnA.bmL();
    AppMethodBeat.o(53436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.19
 * JD-Core Version:    0.7.0.1
 */