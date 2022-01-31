package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.ui.widget.b.d;

final class FavoriteFileDetailUI$16
  implements MenuItem.OnMenuItemClickListener
{
  FavoriteFileDetailUI$16(FavoriteFileDetailUI paramFavoriteFileDetailUI, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(74343);
    if (this.mAk)
    {
      FavoriteFileDetailUI.j(this.mAf);
      if ((!k.h(FavoriteFileDetailUI.a(this.mAf))) && (FavoriteFileDetailUI.a(this.mAf).wTK == 0)) {}
    }
    else if (!this.mAl)
    {
      AppMethodBeat.o(74343);
      return false;
    }
    paramMenuItem = new d(this.mAf.getContext(), 1, false);
    paramMenuItem.sao = new FavoriteFileDetailUI.16.1(this);
    paramMenuItem.sap = new FavoriteFileDetailUI.16.2(this);
    paramMenuItem.crd();
    AppMethodBeat.o(74343);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.16
 * JD-Core Version:    0.7.0.1
 */