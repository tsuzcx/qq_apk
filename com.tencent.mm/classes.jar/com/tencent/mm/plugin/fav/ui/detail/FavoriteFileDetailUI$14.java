package com.tencent.mm.plugin.fav.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class FavoriteFileDetailUI$14
  implements View.OnClickListener
{
  FavoriteFileDetailUI$14(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74336);
    ab.i("MicroMsg.FavoriteFileDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(FavoriteFileDetailUI.b(this.mAf).field_id), Long.valueOf(FavoriteFileDetailUI.b(this.mAf).field_localId), Integer.valueOf(FavoriteFileDetailUI.b(this.mAf).field_itemStatus) });
    if (!f.Mi())
    {
      h.h(this.mAf.getContext(), 2131299762, 2131299680);
      AppMethodBeat.o(74336);
      return;
    }
    if ((FavoriteFileDetailUI.b(this.mAf).bwp()) || (bo.isNullOrNil(FavoriteFileDetailUI.a(this.mAf).wSC))) {
      b.l(FavoriteFileDetailUI.b(this.mAf));
    }
    for (;;)
    {
      FavoriteFileDetailUI.g(this.mAf);
      AppMethodBeat.o(74336);
      return;
      if (!FavoriteFileDetailUI.f(this.mAf))
      {
        b.a(FavoriteFileDetailUI.b(this.mAf), FavoriteFileDetailUI.a(this.mAf), true);
      }
      else
      {
        FavoriteFileDetailUI.b(this.mAf).field_itemStatus = 7;
        b.b(FavoriteFileDetailUI.a(this.mAf), 18, -1L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.14
 * JD-Core Version:    0.7.0.1
 */