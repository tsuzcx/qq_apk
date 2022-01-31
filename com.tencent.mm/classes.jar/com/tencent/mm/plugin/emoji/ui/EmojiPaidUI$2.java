package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h.c;

final class EmojiPaidUI$2
  implements h.c
{
  EmojiPaidUI$2(EmojiPaidUI paramEmojiPaidUI) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_action_type", 200002);
    d.b(this.jdw, "wallet_index", ".ui.WalletIapUI", localIntent, 2001);
    y.i("MicroMsg.emoji.EmojiPaidUI", "[showMenuDialog] startActivityForResult ui.WalletIapUI");
    this.jdw.VZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiPaidUI.2
 * JD-Core Version:    0.7.0.1
 */