package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h.c;

final class EmojiPaidUI$2
  implements h.c
{
  EmojiPaidUI$2(EmojiPaidUI paramEmojiPaidUI) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(53390);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(53390);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("key_action_type", 200002);
      d.b(this.lmh, "wallet_index", ".ui.WalletIapUI", localIntent, 2001);
      ab.i("MicroMsg.emoji.EmojiPaidUI", "[showMenuDialog] startActivityForResult ui.WalletIapUI");
      this.lmh.apy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiPaidUI.2
 * JD-Core Version:    0.7.0.1
 */