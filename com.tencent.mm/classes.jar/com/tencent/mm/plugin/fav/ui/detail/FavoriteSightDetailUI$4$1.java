package com.tencent.mm.plugin.fav.ui.detail;

import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class FavoriteSightDetailUI$4$1
  implements n.c
{
  FavoriteSightDetailUI$4$1(FavoriteSightDetailUI.4 param4) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(74415);
    if ((FavoriteSightDetailUI.a(this.mAU.mAS).bwl()) && (!FavoriteSightDetailUI.j(this.mAU.mAS).t(FavoriteSightDetailUI.a(this.mAU.mAS)))) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (FavoriteSightDetailUI.b(this.mAU.mAS).wTK == 0)) {
        paraml.e(0, this.mAU.mAS.getString(2131299826));
      }
      paraml.e(4, this.mAU.mAS.getString(2131299814));
      paraml.e(3, this.mAU.mAS.getString(2131299703));
      paraml.e(2, this.mAU.mAS.getContext().getString(2131296901));
      AppMethodBeat.o(74415);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.4.1
 * JD-Core Version:    0.7.0.1
 */