package com.tencent.mm.plugin.finder.feed.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
final class FinderFriendBlackListUI$j
  implements View.OnCreateContextMenuListener
{
  FinderFriendBlackListUI$j(FinderFriendBlackListUI paramFinderFriendBlackListUI, boolean paramBoolean) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(203150);
    int i = this.snd.smU;
    if (this.sng) {}
    for (paramView = this.snd.getString(2131767004);; paramView = this.snd.getString(2131767003))
    {
      paramContextMenu.add(0, i, 0, (CharSequence)paramView);
      AppMethodBeat.o(203150);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendBlackListUI.j
 * JD-Core Version:    0.7.0.1
 */