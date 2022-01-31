package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Dialog;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.ui.i.2;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

final class FavoriteFileDetailUI$16$2
  implements n.d
{
  FavoriteFileDetailUI$16$2(FavoriteFileDetailUI.16 param16) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(74342);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74342);
      return;
      if (FavoriteFileDetailUI.c(this.mAm.mAf) == 8)
      {
        paramMenuItem = com.tencent.mm.plugin.fav.a.b.b(FavoriteFileDetailUI.a(this.mAm.mAf));
        if (!e.cN(paramMenuItem))
        {
          ab.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file not exists");
          Toast.makeText(this.mAm.mAf, this.mAm.mAf.getString(2131299824), 1).show();
          AppMethodBeat.o(74342);
          return;
        }
        if (new com.tencent.mm.vfs.b(paramMenuItem).length() > 10485760L)
        {
          ab.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file too large");
          Toast.makeText(this.mAm.mAf, this.mAm.mAf.getString(2131299825), 1).show();
          AppMethodBeat.o(74342);
          return;
        }
      }
      paramMenuItem = this.mAm.mAf.mzH;
      paramMenuItem.mtf += 1;
      FavoriteFileDetailUI.a(this.mAm.mAf, FavoriteFileDetailUI.b(this.mAm.mAf));
      AppMethodBeat.o(74342);
      return;
      paramMenuItem = this.mAm.mAf.mzH;
      paramMenuItem.mtg += 1;
      Object localObject = h.b(this.mAm.mAf.getContext(), this.mAm.mAf.getString(2131299734), false, null);
      paramMenuItem = this.mAm.mAf.getContext();
      com.tencent.mm.plugin.fav.a.g localg = FavoriteFileDetailUI.b(this.mAm.mAf);
      localObject = new FavoriteFileDetailUI.16.2.1(this, (Dialog)localObject);
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(localg.field_id));
      paramMenuItem = new am("", localLinkedList, new i.2(localg, paramMenuItem, (Runnable)localObject));
      com.tencent.mm.kernel.g.Rc().a(paramMenuItem, 0);
      AppMethodBeat.o(74342);
      return;
      h.a(this.mAm.mAf.getContext(), this.mAm.mAf.getString(2131296902), "", new FavoriteFileDetailUI.16.2.2(this), null);
      AppMethodBeat.o(74342);
      return;
      paramMenuItem = this.mAm.mAf.mzH;
      paramMenuItem.mti += 1;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_scene", 2);
      paramMenuItem.putExtra("key_fav_item_id", FavoriteFileDetailUI.b(this.mAm.mAf).field_localId);
      com.tencent.mm.plugin.fav.a.b.b(this.mAm.mAf.getContext(), ".ui.FavTagEditUI", paramMenuItem);
      AppMethodBeat.o(74342);
      return;
      FavoriteFileDetailUI.k(this.mAm.mAf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.16.2
 * JD-Core Version:    0.7.0.1
 */