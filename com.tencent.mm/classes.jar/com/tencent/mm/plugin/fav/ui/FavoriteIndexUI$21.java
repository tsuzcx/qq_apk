package com.tencent.mm.plugin.fav.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.k;

final class FavoriteIndexUI$21
  implements View.OnCreateContextMenuListener
{
  FavoriteIndexUI$21(FavoriteIndexUI paramFavoriteIndexUI, int paramInt) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(74247);
    paramView = new k();
    paramContextMenuInfo = FavoriteIndexUI.a(this.myP).vZ(this.lU - this.myP.mvw.getHeaderViewsCount() - 1);
    boolean bool = paramView.t(paramContextMenuInfo);
    if (!bool) {
      paramContextMenu.add(0, 3, 0, 2131299812);
    }
    if ((bool) && (com.tencent.mm.plugin.fav.a.b.g(paramContextMenuInfo))) {
      paramContextMenu.add(0, 3, 0, 2131299812);
    }
    if (paramContextMenuInfo.field_type == 8)
    {
      paramView = com.tencent.mm.plugin.fav.a.b.c(paramContextMenuInfo);
      if ((com.tencent.mm.plugin.fav.a.b.f(paramView)) && (!com.tencent.mm.plugin.fav.a.b.g(paramView))) {
        paramContextMenu.add(0, 4, 0, 2131299767);
      }
    }
    paramContextMenu.add(0, 2, 0, 2131299703);
    paramContextMenu.add(0, 0, 0, 2131299684);
    paramContextMenu.add(0, 1, 0, 2131299756);
    AppMethodBeat.o(74247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.21
 * JD-Core Version:    0.7.0.1
 */