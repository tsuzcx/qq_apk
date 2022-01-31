package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class FavoriteVoiceDetailUI$2$2
  implements n.d
{
  FavoriteVoiceDetailUI$2$2(FavoriteVoiceDetailUI.2 param2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(74482);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74482);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_scene", 2);
      paramMenuItem.putExtra("key_fav_item_id", FavoriteVoiceDetailUI.a(this.mBx.mBw).field_localId);
      b.b(this.mBx.mBw.getContext(), ".ui.FavTagEditUI", paramMenuItem);
      paramMenuItem = this.mBx.mBw.mzH;
      paramMenuItem.mti += 1;
      AppMethodBeat.o(74482);
      return;
      h.a(this.mBx.mBw.getContext(), this.mBx.mBw.getString(2131296902), "", new FavoriteVoiceDetailUI.2.2.1(this), null);
      AppMethodBeat.o(74482);
      return;
      com.tencent.mm.plugin.fav.ui.g.a(this.mBx.mBw, FavoriteVoiceDetailUI.b(this.mBx.mBw), this.mBx.mBw.mzH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI.2.2
 * JD-Core Version:    0.7.0.1
 */