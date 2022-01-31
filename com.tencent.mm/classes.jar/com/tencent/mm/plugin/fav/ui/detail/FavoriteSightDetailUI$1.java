package com.tencent.mm.plugin.fav.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class FavoriteSightDetailUI$1
  implements View.OnClickListener
{
  FavoriteSightDetailUI$1(FavoriteSightDetailUI paramFavoriteSightDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74408);
    if ((a.bO(paramView.getContext())) || (a.bM(paramView.getContext())))
    {
      AppMethodBeat.o(74408);
      return;
    }
    ab.i("MicroMsg.FavoriteSightDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(FavoriteSightDetailUI.a(this.mAS).field_id), Long.valueOf(FavoriteSightDetailUI.a(this.mAS).field_localId), Integer.valueOf(FavoriteSightDetailUI.a(this.mAS).field_itemStatus) });
    if (FavoriteSightDetailUI.a(this.mAS).isDone())
    {
      if (b.f(FavoriteSightDetailUI.b(this.mAS)))
      {
        m.a(m.a.mtz, FavoriteSightDetailUI.a(this.mAS));
        FavoriteSightDetailUI.a(this.mAS, true, paramView.getContext());
        AppMethodBeat.o(74408);
        return;
      }
      if (bo.isNullOrNil(FavoriteSightDetailUI.b(this.mAS).wSC))
      {
        FavoriteSightDetailUI.a(this.mAS, false, paramView.getContext());
        AppMethodBeat.o(74408);
        return;
      }
      ab.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
      if (!FavoriteSightDetailUI.a(this.mAS).bwp()) {
        break label327;
      }
      b.l(FavoriteSightDetailUI.a(this.mAS));
    }
    for (;;)
    {
      FavoriteSightDetailUI.a(this.mAS, false);
      AppMethodBeat.o(74408);
      return;
      if (FavoriteSightDetailUI.a(this.mAS).bwq())
      {
        if (!bo.isNullOrNil(FavoriteSightDetailUI.b(this.mAS).wSC)) {
          break;
        }
        FavoriteSightDetailUI.a(this.mAS, false, paramView.getContext());
        AppMethodBeat.o(74408);
        return;
      }
      if ((!FavoriteSightDetailUI.a(this.mAS).isDownloading()) && (!FavoriteSightDetailUI.a(this.mAS).bwo())) {
        break;
      }
      if (FavoriteSightDetailUI.c(this.mAS).getVisibility() == 8) {
        FavoriteSightDetailUI.a(this.mAS, false);
      }
      AppMethodBeat.o(74408);
      return;
      label327:
      b.m(FavoriteSightDetailUI.a(this.mAS));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.1
 * JD-Core Version:    0.7.0.1
 */