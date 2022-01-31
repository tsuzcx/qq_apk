package com.tencent.mm.plugin.fav.ui.detail;

import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class FavoriteTextDetailUI$3
  implements n.d
{
  FavoriteTextDetailUI$3(FavoriteTextDetailUI paramFavoriteTextDetailUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(74443);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74443);
      return;
      if ((FavoriteTextDetailUI.c(this.mBc) != null) && (FavoriteTextDetailUI.a(this.mBc) != null) && (FavoriteTextDetailUI.a(this.mBc).field_favProto != null))
      {
        FavoriteTextDetailUI.c(this.mBc).setText(FavoriteTextDetailUI.a(this.mBc).field_favProto.desc);
        h.bO(this.mBc.getContext(), this.mBc.getContext().getString(2131296896));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.3
 * JD-Core Version:    0.7.0.1
 */