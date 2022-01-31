package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Iterator;

final class FavTagEditUI$3
  implements MenuItem.OnMenuItemClickListener
{
  FavTagEditUI$3(FavTagEditUI paramFavTagEditUI, long paramLong) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (FavTagEditUI.b(this.kdx))
    {
      FavTagEditUI.c(this.kdx);
      return true;
    }
    paramMenuItem = FavTagEditUI.d(this.kdx).getTagList();
    Object localObject1 = FavTagEditUI.d(this.kdx).getEditText().trim();
    if (!bk.bl((String)localObject1))
    {
      paramMenuItem.remove(localObject1);
      paramMenuItem.add(localObject1);
    }
    FavTagEditUI.a(this.kdx, ((ae)g.t(ae.class)).getFavItemInfoStorage().eE(this.kdy));
    if (FavTagEditUI.e(this.kdx) != null)
    {
      FavTagEditUI.a(FavTagEditUI.e(this.kdx), paramMenuItem, this.kdx.getIntent().getIntExtra("key_fav_scene", 1));
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("key_fav_result_list", paramMenuItem);
      this.kdx.setResult(-1, (Intent)localObject1);
    }
    for (;;)
    {
      this.kdx.finish();
      this.kdx.XM();
      return true;
      localObject1 = new String[paramMenuItem.size()];
      Object localObject2 = paramMenuItem.iterator();
      int i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1[i] = ((String)((Iterator)localObject2).next());
        i += 1;
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("key_fav_result_array", (String[])localObject1);
      ((Intent)localObject2).putExtra("key_fav_result_list", paramMenuItem);
      this.kdx.setResult(-1, (Intent)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTagEditUI.3
 * JD-Core Version:    0.7.0.1
 */