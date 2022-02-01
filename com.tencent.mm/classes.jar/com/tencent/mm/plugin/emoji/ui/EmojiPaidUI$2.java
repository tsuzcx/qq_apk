package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h.c;

final class EmojiPaidUI$2
  implements h.c
{
  EmojiPaidUI$2(EmojiPaidUI paramEmojiPaidUI) {}
  
  public final void kM(int paramInt)
  {
    AppMethodBeat.i(108951);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(108951);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("key_action_type", 200002);
      d.b(this.oCw, "wallet_index", ".ui.WalletIapUI", localIntent, 2001);
      ad.i("MicroMsg.emoji.EmojiPaidUI", "[showMenuDialog] startActivityForResult ui.WalletIapUI");
      this.oCw.aHU();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiPaidUI.2
 * JD-Core Version:    0.7.0.1
 */