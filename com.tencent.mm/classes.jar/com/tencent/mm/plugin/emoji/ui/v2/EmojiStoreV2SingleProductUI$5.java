package com.tencent.mm.plugin.emoji.ui.v2;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.n.d;

final class EmojiStoreV2SingleProductUI$5
  implements n.d
{
  EmojiStoreV2SingleProductUI$5(EmojiStoreV2SingleProductUI paramEmojiStoreV2SingleProductUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(53748);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(53748);
      return;
      l.dJ(this.lrz.getContext());
      this.lrz.getContext().overridePendingTransition(2131034230, 2131034182);
      h.qsU.e(13224, new Object[] { Integer.valueOf(2), Integer.valueOf(2), "", Integer.valueOf(EmojiStoreV2SingleProductUI.q(this.lrz)) });
      AppMethodBeat.o(53748);
      return;
      paramMenuItem = this.lrz.getContext();
      String str1 = EmojiStoreV2SingleProductUI.r(this.lrz);
      String str2 = EmojiStoreV2SingleProductUI.s(this.lrz);
      String str3 = EmojiStoreV2SingleProductUI.t(this.lrz);
      i.blp();
      l.a(paramMenuItem, str1, str2, str3, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0", EmojiLogic.a(EmojiStoreV2SingleProductUI.q(this.lrz), EmojiStoreV2SingleProductUI.r(this.lrz), EmojiStoreV2SingleProductUI.s(this.lrz), EmojiStoreV2SingleProductUI.t(this.lrz), EmojiStoreV2SingleProductUI.u(this.lrz), EmojiStoreV2SingleProductUI.v(this.lrz)), 12);
      h.qsU.e(13224, new Object[] { Integer.valueOf(2), Integer.valueOf(1), "", Integer.valueOf(EmojiStoreV2SingleProductUI.q(this.lrz)) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.5
 * JD-Core Version:    0.7.0.1
 */