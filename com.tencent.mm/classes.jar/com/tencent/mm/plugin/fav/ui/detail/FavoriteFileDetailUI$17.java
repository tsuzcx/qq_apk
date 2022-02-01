package com.tencent.mm.plugin.fav.ui.detail;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class FavoriteFileDetailUI$17
  implements n.d
{
  FavoriteFileDetailUI$17(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(107137);
    ClipboardManager localClipboardManager = (ClipboardManager)ai.getContext().getSystemService("clipboard");
    if (bs.isNullOrNil(FavoriteFileDetailUI.a(this.qQl).title)) {}
    for (paramMenuItem = this.qQl.getString(2131761808);; paramMenuItem = FavoriteFileDetailUI.a(this.qQl).title)
    {
      localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramMenuItem));
      h.cg(this.qQl, this.qQl.getString(2131755702));
      AppMethodBeat.o(107137);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.17
 * JD-Core Version:    0.7.0.1
 */