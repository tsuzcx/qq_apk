package com.tencent.mm.plugin.bottle.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.d;

final class BottleConversationUI$10
  implements n.d
{
  BottleConversationUI$10(BottleConversationUI paramBottleConversationUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(18565);
    BottleConversationUI.a(this.jSo, BottleConversationUI.e(this.jSo));
    AppMethodBeat.o(18565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleConversationUI.10
 * JD-Core Version:    0.7.0.1
 */