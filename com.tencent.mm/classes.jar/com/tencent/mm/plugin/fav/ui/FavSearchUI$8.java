package com.tencent.mm.plugin.fav.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.k;

final class FavSearchUI$8
  implements View.OnCreateContextMenuListener
{
  FavSearchUI$8(FavSearchUI paramFavSearchUI, int paramInt) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(106827);
    paramContextMenuInfo = new k();
    paramView = FavSearchUI.j(this.tfp).Id(this.vi - FavSearchUI.b(this.tfp).getHeaderViewsCount() - 1);
    boolean bool = paramContextMenuInfo.u(paramView);
    if (!bool) {
      paramContextMenu.add(0, 3, 0, 2131759311);
    }
    if ((bool) && (com.tencent.mm.plugin.fav.a.b.g(paramView))) {
      paramContextMenu.add(0, 3, 0, 2131759311);
    }
    if (paramView.field_type == 8)
    {
      paramContextMenuInfo = com.tencent.mm.plugin.fav.a.b.c(paramView);
      if ((com.tencent.mm.plugin.fav.a.b.g(paramContextMenuInfo)) && (!com.tencent.mm.plugin.fav.a.b.h(paramContextMenuInfo))) {
        paramContextMenu.add(0, 4, 0, 2131759263);
      }
    }
    paramContextMenu.add(0, 2, 0, 2131759199);
    if (paramView.tad) {
      paramContextMenu.add(0, 5, 0, 2131759234);
    }
    paramContextMenu.add(0, 0, 0, 2131759173);
    paramContextMenu.add(0, 1, 0, 2131759252);
    AppMethodBeat.o(106827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.8
 * JD-Core Version:    0.7.0.1
 */