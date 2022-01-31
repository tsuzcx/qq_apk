package com.tencent.mm.plugin.emoji.ui;

import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class EmojiStoreDetailUI$19
  extends ah
{
  EmojiStoreDetailUI$19(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      y.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow message, cannt handle.");
      return;
    case 1001: 
      EmojiStoreDetailUI.e(this.jeK);
      return;
    case 1002: 
      EmojiStoreDetailUI.f(this.jeK);
      return;
    case 1003: 
      EmojiStoreDetailUI.g(this.jeK);
      return;
    case 1004: 
      if (EmojiStoreDetailUI.h(this.jeK).getVisibility() == 0)
      {
        EmojiStoreDetailUI.h(this.jeK).setVisibility(8);
        EmojiStoreDetailUI.i(this.jeK).setVisibility(0);
        EmojiStoreDetailUI.j(this.jeK).setVisibility(0);
      }
      EmojiStoreDetailUI.l(this.jeK).setProgress(EmojiStoreDetailUI.k(this.jeK));
      return;
    case 1005: 
      EmojiStoreDetailUI.m(this.jeK).scrollTo(0, 0);
      return;
    case 1006: 
      EmojiStoreDetailUI.n(this.jeK);
      return;
    }
    this.jeK.aJj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.19
 * JD-Core Version:    0.7.0.1
 */