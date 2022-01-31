package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import java.util.LinkedList;
import java.util.List;

final class FavoriteIndexUI$18
  implements n.d
{
  FavoriteIndexUI$18(FavoriteIndexUI paramFavoriteIndexUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (FavoriteIndexUI.e(this.kee))
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (paramMenuItem == null);
          localObject = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
          switch (paramMenuItem.getItemId())
          {
          default: 
            return;
          }
        } while (((AdapterView.AdapterContextMenuInfo)localObject).position < this.kee.kba.getHeaderViewsCount());
        y.i("MicroMsg.FavoriteIndexUI", "do delete, long click info is %s", new Object[] { Integer.valueOf(((AdapterView.AdapterContextMenuInfo)localObject).position) });
        com.tencent.mm.plugin.fav.a.b.i(FavoriteIndexUI.a(this.kee).rd(((AdapterView.AdapterContextMenuInfo)localObject).position - this.kee.kba.getHeaderViewsCount() - 1));
        return;
        FavoriteIndexUI.a(this.kee, bk.UX());
        y.i("MicroMsg.FavoriteIndexUI", "do edit, long click info is %s", new Object[] { Integer.valueOf(((AdapterView.AdapterContextMenuInfo)localObject).position) });
        FavoriteIndexUI.a(this.kee, FavoriteIndexUI.a(this.kee).rd(((AdapterView.AdapterContextMenuInfo)localObject).position - this.kee.kba.getHeaderViewsCount() - 1));
        FavoriteIndexUI.b(this.kee, FavoriteIndexUI.f(this.kee));
        return;
        y.i("MicroMsg.FavoriteIndexUI", "do tag, long click info is %s", new Object[] { Integer.valueOf(((AdapterView.AdapterContextMenuInfo)localObject).position) });
        paramMenuItem = FavoriteIndexUI.a(this.kee).rd(((AdapterView.AdapterContextMenuInfo)localObject).position - this.kee.kba.getHeaderViewsCount() - 1);
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("key_fav_scene", 4);
        ((Intent)localObject).putExtra("key_fav_item_id", paramMenuItem.field_localId);
        com.tencent.mm.plugin.fav.a.b.a(this.kee.mController.uMN, ".ui.FavTagEditUI", (Intent)localObject);
        i.CG("FavTagEditUI");
        return;
        FavoriteIndexUI.a(this.kee, bk.UX());
        y.i("MicroMsg.FavoriteIndexUI", "do transmit, long click info is %s", new Object[] { Integer.valueOf(((AdapterView.AdapterContextMenuInfo)localObject).position) });
        FavoriteIndexUI.c(this.kee, FavoriteIndexUI.a(this.kee).rd(((AdapterView.AdapterContextMenuInfo)localObject).position - this.kee.kba.getHeaderViewsCount() - 1));
        FavoriteIndexUI.c(this.kee, FavoriteIndexUI.g(this.kee).aQe());
      } while (FavoriteIndexUI.g(this.kee) == null);
      paramMenuItem = new LinkedList();
      paramMenuItem.add(FavoriteIndexUI.g(this.kee));
    } while (!FavoriteIndexUI.a(paramMenuItem, this.kee, new FavoriteIndexUI.18.1(this)));
    FavoriteIndexUI.a(this.kee, 4106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.18
 * JD-Core Version:    0.7.0.1
 */