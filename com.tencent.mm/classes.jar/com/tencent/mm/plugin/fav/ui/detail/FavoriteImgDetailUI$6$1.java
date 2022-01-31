package com.tencent.mm.plugin.fav.ui.detail;

import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class FavoriteImgDetailUI$6$1
  implements n.c
{
  FavoriteImgDetailUI$6$1(FavoriteImgDetailUI.6 param6) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(74377);
    if (FavoriteImgDetailUI.a(this.mAy.mAv)) {
      paraml.e(2, this.mAy.mAv.getString(2131299826));
    }
    paraml.e(3, this.mAy.mAv.getString(2131299814));
    paraml.e(0, this.mAy.mAv.getString(2131299703));
    paraml.e(1, this.mAy.mAv.getContext().getString(2131296901));
    AppMethodBeat.o(74377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.6.1
 * JD-Core Version:    0.7.0.1
 */