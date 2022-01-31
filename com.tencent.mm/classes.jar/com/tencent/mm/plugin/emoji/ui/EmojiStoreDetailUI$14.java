package com.tencent.mm.plugin.emoji.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.f.a;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.vj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

final class EmojiStoreDetailUI$14
  implements n.d
{
  EmojiStoreDetailUI$14(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1001: 
      j.cW(this.jeK.mController.uMN);
      this.jeK.mController.uMN.overridePendingTransition(f.a.push_up_in, f.a.fast_faded_out);
      h.nFQ.f(13224, new Object[] { Integer.valueOf(0), Integer.valueOf(2), EmojiStoreDetailUI.a(this.jeK), "" });
      return;
    }
    paramMenuItem = EmojiStoreDetailUI.b(this.jeK).sSc + this.jeK.getString(f.h.emoji_store_source);
    j.a(this.jeK.mController.uMN, paramMenuItem, EmojiStoreDetailUI.b(this.jeK).sSd, EmojiStoreDetailUI.b(this.jeK).kSy, EmojiStoreDetailUI.b(this.jeK).sSv, EmojiLogic.AH(EmojiStoreDetailUI.a(this.jeK)), 4);
    h.nFQ.f(13224, new Object[] { Integer.valueOf(0), Integer.valueOf(1), EmojiStoreDetailUI.a(this.jeK), "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.14
 * JD-Core Version:    0.7.0.1
 */