package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h.d;

final class EmojiPaidUI$2
  implements h.d
{
  EmojiPaidUI$2(EmojiPaidUI paramEmojiPaidUI) {}
  
  public final void oj(int paramInt)
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
      c.b(this.rgB, "wallet_index", ".ui.WalletIapUI", localIntent, 2001);
      Log.i("MicroMsg.emoji.EmojiPaidUI", "[showMenuDialog] startActivityForResult ui.WalletIapUI");
      this.rgB.bnj();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiPaidUI.2
 * JD-Core Version:    0.7.0.1
 */