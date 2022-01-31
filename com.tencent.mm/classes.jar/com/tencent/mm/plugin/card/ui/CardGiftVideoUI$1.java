package com.tencent.mm.plugin.card.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CardGiftVideoUI$1
  implements View.OnCreateContextMenuListener
{
  CardGiftVideoUI$1(CardGiftVideoUI paramCardGiftVideoUI) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(88448);
    paramContextMenu.add(0, 0, 0, this.kvN.getString(2131297982));
    AppMethodBeat.o(88448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI.1
 * JD-Core Version:    0.7.0.1
 */