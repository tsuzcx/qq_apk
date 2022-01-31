package com.tencent.mm.plugin.emoji.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.ui.base.n.d;

final class EmojiStoreDetailUI$14
  implements n.d
{
  EmojiStoreDetailUI$14(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(53431);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(53431);
      return;
      l.dJ(this.lnA.getContext());
      this.lnA.getContext().overridePendingTransition(2131034230, 2131034182);
      h.qsU.e(13224, new Object[] { Integer.valueOf(0), Integer.valueOf(2), EmojiStoreDetailUI.a(this.lnA), "" });
      AppMethodBeat.o(53431);
      return;
      paramMenuItem = EmojiStoreDetailUI.b(this.lnA).PackName + this.lnA.getString(2131299249);
      l.a(this.lnA.getContext(), paramMenuItem, EmojiStoreDetailUI.b(this.lnA).PackDesc, EmojiStoreDetailUI.b(this.lnA).IconUrl, EmojiStoreDetailUI.b(this.lnA).OldRedirectUrl, EmojiLogic.KJ(EmojiStoreDetailUI.a(this.lnA)), 4);
      h.qsU.e(13224, new Object[] { Integer.valueOf(0), Integer.valueOf(1), EmojiStoreDetailUI.a(this.lnA), "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.14
 * JD-Core Version:    0.7.0.1
 */