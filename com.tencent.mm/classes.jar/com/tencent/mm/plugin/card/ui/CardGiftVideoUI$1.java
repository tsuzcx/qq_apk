package com.tencent.mm.plugin.card.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.plugin.card.a.g;

final class CardGiftVideoUI$1
  implements View.OnCreateContextMenuListener
{
  CardGiftVideoUI$1(CardGiftVideoUI paramCardGiftVideoUI) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.add(0, 0, 0, this.iuJ.getString(a.g.card_long_click_menu_save_video));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI.1
 * JD-Core Version:    0.7.0.1
 */