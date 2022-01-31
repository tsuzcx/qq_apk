package com.tencent.mm.plugin.fav.ui.detail;

import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class FavoriteFileDetailUI$16$1
  implements n.c
{
  FavoriteFileDetailUI$16$1(FavoriteFileDetailUI.16 param16) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(74338);
    if (this.mAm.mAk)
    {
      FavoriteFileDetailUI.j(this.mAm.mAf);
      if ((!k.h(FavoriteFileDetailUI.a(this.mAm.mAf))) && (FavoriteFileDetailUI.a(this.mAm.mAf).wTK == 0))
      {
        if (this.mAm.bHS != 8) {
          break label143;
        }
        paraml.e(0, this.mAm.mAf.getString(2131299826));
      }
    }
    for (;;)
    {
      if (this.mAm.mAl)
      {
        paraml.e(3, this.mAm.mAf.getString(2131299703));
        paraml.e(2, this.mAm.mAf.getContext().getString(2131296901));
      }
      AppMethodBeat.o(74338);
      return;
      label143:
      if (this.mAm.bHS == 15)
      {
        paraml.e(0, this.mAm.mAf.getString(2131299826));
        paraml.e(4, this.mAm.mAf.getString(2131302872));
      }
      else if (this.mAm.bHS == 4)
      {
        paraml.e(0, this.mAm.mAf.getString(2131299826));
        paraml.e(4, this.mAm.mAf.getString(2131302872));
      }
      else
      {
        paraml.e(0, this.mAm.mAf.getString(2131299826));
        if ((this.mAm.mAl) && (FavoriteFileDetailUI.b(this.mAm.mAf).bwm())) {
          paraml.e(1, this.mAm.mAf.getString(2131299779));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.16.1
 * JD-Core Version:    0.7.0.1
 */