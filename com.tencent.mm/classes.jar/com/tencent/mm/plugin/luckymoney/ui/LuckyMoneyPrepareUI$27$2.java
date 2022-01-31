package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.b.a.ac;
import com.tencent.mm.plugin.emojicapture.api.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;

final class LuckyMoneyPrepareUI$27$2
  implements n.d
{
  LuckyMoneyPrepareUI$27$2(LuckyMoneyPrepareUI.27 param27) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(142079);
    ab.i("MicroMsg.LuckyMoneyPrepareUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", new Object[] { Integer.valueOf(paramMenuItem.getItemId()) });
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(142079);
      return;
      LuckyMoneyPrepareUI.b(this.owQ.owL, 1);
      c.h(this.owQ.owL, null, 4);
      LuckyMoneyPrepareUI.a(this.owQ.owL, new ac());
      LuckyMoneyPrepareUI.h(this.owQ.owL).cRI = 4L;
      LuckyMoneyPrepareUI.h(this.owQ.owL).ake();
      AppMethodBeat.o(142079);
      return;
      LuckyMoneyPrepareUI.b(this.owQ.owL, 2);
      LuckyMoneyPrepareUI.y(this.owQ.owL);
      AppMethodBeat.o(142079);
      return;
      LuckyMoneyPrepareUI.z(this.owQ.owL);
      paramMenuItem = LuckyMoneyPrepareUI.A(this.owQ.owL);
      paramMenuItem.oxb.setTag("");
      paramMenuItem.oxc.setVisibility(0);
      paramMenuItem.oxd.setVisibility(8);
      LuckyMoneyPrepareUI.a(this.owQ.owL, null);
      LuckyMoneyPrepareUI.a(this.owQ.owL, new ac());
      LuckyMoneyPrepareUI.h(this.owQ.owL).cRI = 5L;
      LuckyMoneyPrepareUI.h(this.owQ.owL).ake();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.27.2
 * JD-Core Version:    0.7.0.1
 */