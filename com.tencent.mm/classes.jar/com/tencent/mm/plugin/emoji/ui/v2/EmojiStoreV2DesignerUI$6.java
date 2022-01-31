package com.tencent.mm.plugin.emoji.ui.v2;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.f.a;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.aix;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

final class EmojiStoreV2DesignerUI$6
  implements n.d
{
  EmojiStoreV2DesignerUI$6(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    do
    {
      return;
      j.cW(this.jgP.mController.uMN);
      this.jgP.mController.uMN.overridePendingTransition(f.a.push_up_in, f.a.fast_faded_out);
      h.nFQ.f(13224, new Object[] { Integer.valueOf(3), Integer.valueOf(2), "", Integer.valueOf(EmojiStoreV2DesignerUI.l(this.jgP)) });
      return;
    } while (EmojiStoreV2DesignerUI.m(this.jgP) == null);
    paramMenuItem = EmojiStoreV2DesignerUI.m(this.jgP).kRZ + this.jgP.getString(f.h.emoji_store_designer_source);
    j.a(this.jgP.mController.uMN, paramMenuItem, EmojiStoreV2DesignerUI.m(this.jgP).kRN, EmojiStoreV2DesignerUI.m(this.jgP).sSy, EmojiStoreV2DesignerUI.n(this.jgP), EmojiLogic.i(EmojiStoreV2DesignerUI.l(this.jgP), EmojiStoreV2DesignerUI.o(this.jgP), EmojiStoreV2DesignerUI.n(this.jgP)), 10);
    h.nFQ.f(13224, new Object[] { Integer.valueOf(3), Integer.valueOf(1), "", Integer.valueOf(EmojiStoreV2DesignerUI.l(this.jgP)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.6
 * JD-Core Version:    0.7.0.1
 */