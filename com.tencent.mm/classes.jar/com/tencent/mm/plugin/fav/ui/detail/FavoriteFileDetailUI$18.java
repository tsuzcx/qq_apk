package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o.g;

final class FavoriteFileDetailUI$18
  implements o.g
{
  FavoriteFileDetailUI$18(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(107137);
    if (Util.isNullOrNil(FavoriteFileDetailUI.a(this.tie).title)) {}
    for (paramMenuItem = this.tie.getString(2131763782);; paramMenuItem = FavoriteFileDetailUI.a(this.tie).title)
    {
      ClipboardHelper.setText(MMApplicationContext.getContext(), null, paramMenuItem);
      h.cD(this.tie, this.tie.getString(2131755773));
      AppMethodBeat.o(107137);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.18
 * JD-Core Version:    0.7.0.1
 */