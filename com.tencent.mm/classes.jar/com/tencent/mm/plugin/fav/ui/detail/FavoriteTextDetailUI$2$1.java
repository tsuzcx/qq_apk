package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class FavoriteTextDetailUI$2$1
  implements n.c
{
  FavoriteTextDetailUI$2$1(FavoriteTextDetailUI.2 param2) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(74438);
    if (this.mBd.mBc.getIntent().getBooleanExtra("key_detail_can_share_to_friend", true)) {
      paraml.e(2, this.mBd.mBc.getString(2131299826));
    }
    paraml.e(0, this.mBd.mBc.getString(2131299701));
    paraml.e(1, this.mBd.mBc.getString(2131299814));
    paraml.e(3, this.mBd.mBc.getString(2131299703));
    paraml.e(4, this.mBd.mBc.getString(2131296901));
    AppMethodBeat.o(74438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.2.1
 * JD-Core Version:    0.7.0.1
 */