package com.tencent.mm.plugin.card.ui.v2;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cyp;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu", "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$showDeleteCardAlert$1$1"})
final class CardTicketListUI$h
  implements View.OnCreateContextMenuListener
{
  CardTicketListUI$h(CardTicketListUI paramCardTicketListUI, View paramView, cyp paramcyp) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(201404);
    paramContextMenu.add(0, 1, 0, (CharSequence)this.qgN.getString(2131755778));
    AppMethodBeat.o(201404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI.h
 * JD-Core Version:    0.7.0.1
 */