package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import java.util.LinkedList;
import java.util.List;

final class FavoriteIndexUI$22
  implements n.d
{
  FavoriteIndexUI$22(FavoriteIndexUI paramFavoriteIndexUI, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(74249);
    switch (FavoriteIndexUI.d(this.myP))
    {
    default: 
      AppMethodBeat.o(74249);
      return;
    }
    if (paramMenuItem == null)
    {
      AppMethodBeat.o(74249);
      return;
    }
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74249);
      return;
      if (this.lU < this.myP.mvw.getHeaderViewsCount())
      {
        AppMethodBeat.o(74249);
        return;
      }
      ab.i("MicroMsg.FavoriteIndexUI", "do delete, long click info is %s", new Object[] { Integer.valueOf(this.lU) });
      com.tencent.mm.plugin.fav.a.b.i(FavoriteIndexUI.a(this.myP).vZ(this.lU - this.myP.mvw.getHeaderViewsCount() - 1));
      AppMethodBeat.o(74249);
      return;
      FavoriteIndexUI.a(this.myP, bo.aox());
      ab.i("MicroMsg.FavoriteIndexUI", "do edit, long click info is %s", new Object[] { Integer.valueOf(this.lU) });
      FavoriteIndexUI.a(this.myP, FavoriteIndexUI.a(this.myP).vZ(this.lU - this.myP.mvw.getHeaderViewsCount() - 1));
      FavoriteIndexUI.b(this.myP, FavoriteIndexUI.e(this.myP));
      AppMethodBeat.o(74249);
      return;
      ab.i("MicroMsg.FavoriteIndexUI", "do tag, long click info is %s", new Object[] { Integer.valueOf(this.lU) });
      paramMenuItem = FavoriteIndexUI.a(this.myP).vZ(this.lU - this.myP.mvw.getHeaderViewsCount() - 1);
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("key_fav_scene", 4);
      ((Intent)localObject).putExtra("key_fav_item_id", paramMenuItem.field_localId);
      com.tencent.mm.plugin.fav.a.b.b(this.myP.getContext(), ".ui.FavTagEditUI", (Intent)localObject);
      i.NI("FavTagEditUI");
      AppMethodBeat.o(74249);
      return;
      FavoriteIndexUI.a(this.myP, bo.aox());
      ab.i("MicroMsg.FavoriteIndexUI", "do transmit, long click info is %s", new Object[] { Integer.valueOf(this.lU) });
      FavoriteIndexUI.c(this.myP, FavoriteIndexUI.a(this.myP).vZ(this.lU - this.myP.mvw.getHeaderViewsCount() - 1));
      FavoriteIndexUI.c(this.myP, FavoriteIndexUI.f(this.myP).bwt());
      if (FavoriteIndexUI.f(this.myP) == null)
      {
        AppMethodBeat.o(74249);
        return;
      }
      paramMenuItem = new LinkedList();
      paramMenuItem.add(FavoriteIndexUI.f(this.myP));
      if (!FavoriteIndexUI.a(paramMenuItem, this.myP, new FavoriteIndexUI.22.1(this)))
      {
        AppMethodBeat.o(74249);
        return;
      }
      FavoriteIndexUI.a(this.myP, 4106);
      AppMethodBeat.o(74249);
      return;
      paramMenuItem = FavoriteIndexUI.a(this.myP).vZ(this.lU - this.myP.mvw.getHeaderViewsCount() - 1);
      localObject = new acs();
      ((acs)localObject).cIT = 1;
      ((y)com.tencent.mm.kernel.g.E(y.class)).a(this.myP.getContext(), paramMenuItem, (acs)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.22
 * JD-Core Version:    0.7.0.1
 */