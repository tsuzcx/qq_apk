package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.protocal.c.bel;
import com.tencent.mm.protocal.c.vj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class EmojiStoreDetailUI$6
  implements View.OnClickListener
{
  EmojiStoreDetailUI$6(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClass(this.jeK.mController.uMN, EmojiStoreV2DesignerUI.class);
    paramView.putExtra("uin", EmojiStoreDetailUI.b(this.jeK).sSx.tcH);
    paramView.putExtra("name", EmojiStoreDetailUI.b(this.jeK).sSx.kRZ);
    paramView.putExtra("headurl", EmojiStoreDetailUI.b(this.jeK).sSx.sSy);
    paramView.putExtra("rediret_url", EmojiStoreDetailUI.b(this.jeK).sSv);
    paramView.putExtra("searchID", EmojiStoreDetailUI.d(this.jeK));
    paramView.putExtra("extra_scence", 26);
    this.jeK.mController.uMN.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.6
 * JD-Core Version:    0.7.0.1
 */