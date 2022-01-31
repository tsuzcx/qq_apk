package com.tencent.mm.plugin.emoji.ui;

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

final class EmojiStoreTopicUI$4
  implements n.d
{
  EmojiStoreTopicUI$4(EmojiStoreTopicUI paramEmojiStoreTopicUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1001: 
      j.cW(this.jeT.mController.uMN);
      this.jeT.mController.uMN.overridePendingTransition(f.a.push_up_in, f.a.fast_faded_out);
      h.nFQ.f(13224, new Object[] { Integer.valueOf(1), Integer.valueOf(2), "", Integer.valueOf(EmojiStoreTopicUI.d(this.jeT)) });
      return;
    }
    paramMenuItem = this.jeT.mController.uMN;
    String str1 = EmojiStoreTopicUI.a(this.jeT);
    String str2 = EmojiStoreTopicUI.e(this.jeT);
    String str3 = EmojiStoreTopicUI.b(this.jeT);
    i.aHP();
    j.a(paramMenuItem, str1, str2, str3, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0", EmojiLogic.a(EmojiStoreTopicUI.d(this.jeT), EmojiStoreTopicUI.a(this.jeT), EmojiStoreTopicUI.e(this.jeT), EmojiStoreTopicUI.b(this.jeT), EmojiStoreTopicUI.f(this.jeT), 0), 13);
    h.nFQ.f(13224, new Object[] { Integer.valueOf(1), Integer.valueOf(1), "", Integer.valueOf(EmojiStoreTopicUI.d(this.jeT)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI.4
 * JD-Core Version:    0.7.0.1
 */