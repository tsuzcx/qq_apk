package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.ui.base.n.d;

final class FavoriteImgDetailUI$6$2
  implements n.d
{
  FavoriteImgDetailUI$6$2(FavoriteImgDetailUI.6 param6) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(74380);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74380);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_scene", 2);
      paramMenuItem.putExtra("key_fav_item_id", FavoriteImgDetailUI.b(this.mAy.mAv).field_localId);
      b.b(this.mAy.mAv.getContext(), ".ui.FavTagEditUI", paramMenuItem);
      paramMenuItem = this.mAy.mAv.mzH;
      paramMenuItem.mti += 1;
      AppMethodBeat.o(74380);
      return;
      com.tencent.mm.ui.base.h.a(this.mAy.mAv.getContext(), this.mAy.mAv.getString(2131296902), "", new FavoriteImgDetailUI.6.2.1(this), null);
      AppMethodBeat.o(74380);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Select_Conv_Type", 3);
      paramMenuItem.putExtra("scene_from", 1);
      paramMenuItem.putExtra("mutil_select_is_ret", true);
      paramMenuItem.putExtra("select_fav_local_id", FavoriteImgDetailUI.b(this.mAy.mAv).field_localId);
      d.b(this.mAy.mAv, ".ui.transmit.SelectConversationUI", paramMenuItem, 1);
      com.tencent.mm.plugin.fav.a.h.i(FavoriteImgDetailUI.b(this.mAy.mAv).field_localId, 1, 0);
      paramMenuItem = this.mAy.mAv.mzH;
      paramMenuItem.mtf += 1;
      AppMethodBeat.o(74380);
      return;
      com.tencent.mm.plugin.fav.ui.g.a(this.mAy.mAv, this.mAy.mAx, this.mAy.mAv.mzH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.6.2
 * JD-Core Version:    0.7.0.1
 */