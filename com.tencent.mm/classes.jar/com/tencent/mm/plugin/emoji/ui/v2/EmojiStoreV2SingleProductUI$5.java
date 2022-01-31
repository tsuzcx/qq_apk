package com.tencent.mm.plugin.emoji.ui.v2;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.f.a;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

final class EmojiStoreV2SingleProductUI$5
  implements n.d
{
  EmojiStoreV2SingleProductUI$5(EmojiStoreV2SingleProductUI paramEmojiStoreV2SingleProductUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1001: 
      j.cW(this.jiI.mController.uMN);
      this.jiI.mController.uMN.overridePendingTransition(f.a.push_up_in, f.a.fast_faded_out);
      h.nFQ.f(13224, new Object[] { Integer.valueOf(2), Integer.valueOf(2), "", Integer.valueOf(EmojiStoreV2SingleProductUI.q(this.jiI)) });
      return;
    }
    paramMenuItem = this.jiI.mController.uMN;
    String str1 = EmojiStoreV2SingleProductUI.r(this.jiI);
    String str2 = EmojiStoreV2SingleProductUI.s(this.jiI);
    String str3 = EmojiStoreV2SingleProductUI.t(this.jiI);
    i.aHP();
    j.a(paramMenuItem, str1, str2, str3, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0", EmojiLogic.a(EmojiStoreV2SingleProductUI.q(this.jiI), EmojiStoreV2SingleProductUI.r(this.jiI), EmojiStoreV2SingleProductUI.s(this.jiI), EmojiStoreV2SingleProductUI.t(this.jiI), EmojiStoreV2SingleProductUI.u(this.jiI), EmojiStoreV2SingleProductUI.v(this.jiI)), 12);
    h.nFQ.f(13224, new Object[] { Integer.valueOf(2), Integer.valueOf(1), "", Integer.valueOf(EmojiStoreV2SingleProductUI.q(this.jiI)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.5
 * JD-Core Version:    0.7.0.1
 */