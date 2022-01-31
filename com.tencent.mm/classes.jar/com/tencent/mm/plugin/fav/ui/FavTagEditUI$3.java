package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;

final class FavTagEditUI$3
  implements MenuItem.OnMenuItemClickListener
{
  FavTagEditUI$3(FavTagEditUI paramFavTagEditUI, long paramLong) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(74139);
    if (FavTagEditUI.b(this.myh))
    {
      FavTagEditUI.c(this.myh);
      AppMethodBeat.o(74139);
      return true;
    }
    paramMenuItem = FavTagEditUI.d(this.myh).getTagList();
    Object localObject1 = FavTagEditUI.d(this.myh).getEditText().trim();
    if (!bo.isNullOrNil((String)localObject1))
    {
      paramMenuItem.remove(localObject1);
      paramMenuItem.add(localObject1);
    }
    FavTagEditUI.a(this.myh, ((ae)g.G(ae.class)).getFavItemInfoStorage().kb(this.myi));
    if (FavTagEditUI.e(this.myh) != null)
    {
      FavTagEditUI.a(FavTagEditUI.e(this.myh), paramMenuItem, this.myh.getIntent().getIntExtra("key_fav_scene", 1));
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("key_fav_result_list", paramMenuItem);
      this.myh.setResult(-1, (Intent)localObject1);
    }
    for (;;)
    {
      this.myh.finish();
      this.myh.hideVKB();
      AppMethodBeat.o(74139);
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
      this.myh.setResult(-1, (Intent)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTagEditUI.3
 * JD-Core Version:    0.7.0.1
 */