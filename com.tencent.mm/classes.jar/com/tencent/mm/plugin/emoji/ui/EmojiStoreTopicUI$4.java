package com.tencent.mm.plugin.emoji.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.n.d;

final class EmojiStoreTopicUI$4
  implements n.d
{
  EmojiStoreTopicUI$4(EmojiStoreTopicUI paramEmojiStoreTopicUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(53494);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(53494);
      return;
      l.dJ(this.lnJ.getContext());
      this.lnJ.getContext().overridePendingTransition(2131034230, 2131034182);
      h.qsU.e(13224, new Object[] { Integer.valueOf(1), Integer.valueOf(2), "", Integer.valueOf(EmojiStoreTopicUI.d(this.lnJ)) });
      AppMethodBeat.o(53494);
      return;
      paramMenuItem = this.lnJ.getContext();
      String str1 = EmojiStoreTopicUI.a(this.lnJ);
      String str2 = EmojiStoreTopicUI.e(this.lnJ);
      String str3 = EmojiStoreTopicUI.b(this.lnJ);
      i.blp();
      l.a(paramMenuItem, str1, str2, str3, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0", EmojiLogic.a(EmojiStoreTopicUI.d(this.lnJ), EmojiStoreTopicUI.a(this.lnJ), EmojiStoreTopicUI.e(this.lnJ), EmojiStoreTopicUI.b(this.lnJ), EmojiStoreTopicUI.f(this.lnJ), 0), 13);
      h.qsU.e(13224, new Object[] { Integer.valueOf(1), Integer.valueOf(1), "", Integer.valueOf(EmojiStoreTopicUI.d(this.lnJ)) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI.4
 * JD-Core Version:    0.7.0.1
 */