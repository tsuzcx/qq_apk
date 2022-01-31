package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bel;
import com.tencent.mm.protocal.c.vj;

final class EmojiStoreDetailUI$17
  implements View.OnClickListener
{
  EmojiStoreDetailUI$17(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClass(this.jeK, EmojiStoreV2RewardUI.class);
    paramView.putExtra("extra_id", EmojiStoreDetailUI.a(this.jeK));
    paramView.putExtra("extra_name", EmojiStoreDetailUI.b(this.jeK).sSc);
    if ((EmojiStoreDetailUI.b(this.jeK) != null) && (EmojiStoreDetailUI.b(this.jeK).sSx != null)) {
      paramView.putExtra("name", EmojiStoreDetailUI.b(this.jeK).sSx.kRZ);
    }
    paramView.putExtra("scene", EmojiStoreDetailUI.c(this.jeK));
    paramView.putExtra("pageType", 1);
    paramView.putExtra("searchID", EmojiStoreDetailUI.d(this.jeK));
    this.jeK.startActivity(paramView);
    h.nFQ.f(12738, new Object[] { EmojiStoreDetailUI.a(this.jeK), Integer.valueOf(1), Integer.valueOf(EmojiStoreDetailUI.c(this.jeK)), Integer.valueOf(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.17
 * JD-Core Version:    0.7.0.1
 */