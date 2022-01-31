package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.ui.base.n.d;

final class FavoriteSightDetailUI$4$2
  implements n.d
{
  FavoriteSightDetailUI$4$2(FavoriteSightDetailUI.4 param4) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(74418);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74418);
      return;
      com.tencent.mm.plugin.fav.a.h.i(FavoriteSightDetailUI.a(this.mAU.mAS).field_localId, 1, 0);
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Select_Conv_Type", 3);
      paramMenuItem.putExtra("scene_from", 1);
      paramMenuItem.putExtra("mutil_select_is_ret", true);
      paramMenuItem.putExtra("select_fav_local_id", FavoriteSightDetailUI.a(this.mAU.mAS).field_localId);
      d.b(this.mAU.mAS.getContext(), ".ui.transmit.SelectConversationUI", paramMenuItem, 1);
      paramMenuItem = this.mAU.mAS.mzH;
      paramMenuItem.mtf += 1;
      AppMethodBeat.o(74418);
      return;
      com.tencent.mm.ui.base.h.a(this.mAU.mAS.getContext(), this.mAU.mAS.getString(2131296902), "", new FavoriteSightDetailUI.4.2.1(this), null);
      AppMethodBeat.o(74418);
      return;
      paramMenuItem = this.mAU.mAS.mzH;
      paramMenuItem.mti += 1;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_scene", 2);
      paramMenuItem.putExtra("key_fav_item_id", FavoriteSightDetailUI.a(this.mAU.mAS).field_localId);
      b.b(this.mAU.mAS.getContext(), ".ui.FavTagEditUI", paramMenuItem);
      AppMethodBeat.o(74418);
      return;
      com.tencent.mm.plugin.fav.ui.g.a(this.mAU.mAS, FavoriteSightDetailUI.k(this.mAU.mAS), this.mAU.mAS.mzH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.4.2
 * JD-Core Version:    0.7.0.1
 */