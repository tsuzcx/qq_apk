package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI;
import com.tencent.mm.protocal.c.bel;
import com.tencent.mm.protocal.c.vj;

final class EmojiStoreDetailUI$18
  implements View.OnClickListener
{
  EmojiStoreDetailUI$18(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClass(this.jeK, EmojiStoreV2RewardDetailUI.class);
    paramView.putExtra("extra_id", EmojiStoreDetailUI.a(this.jeK));
    paramView.putExtra("extra_iconurl", EmojiStoreDetailUI.b(this.jeK).kSy);
    paramView.putExtra("extra_name", EmojiStoreDetailUI.b(this.jeK).sSc);
    if (EmojiStoreDetailUI.b(this.jeK).sSx != null) {
      paramView.putExtra("name", EmojiStoreDetailUI.b(this.jeK).sSx.kRZ);
    }
    this.jeK.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.18
 * JD-Core Version:    0.7.0.1
 */