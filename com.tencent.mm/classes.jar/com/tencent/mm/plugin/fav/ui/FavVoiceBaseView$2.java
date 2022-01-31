package com.tencent.mm.plugin.fav.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;

final class FavVoiceBaseView$2
  implements View.OnClickListener
{
  FavVoiceBaseView$2(FavVoiceBaseView paramFavVoiceBaseView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74169);
    if ((a.bO(paramView.getContext())) || (a.bM(paramView.getContext())))
    {
      AppMethodBeat.o(74169);
      return;
    }
    if ((!f.Mi()) && (!bo.isNullOrNil(FavVoiceBaseView.g(this.myp))))
    {
      t.ii(paramView.getContext());
      AppMethodBeat.o(74169);
      return;
    }
    if (!bo.bf(FavVoiceBaseView.g(this.myp), "").equals(FavVoiceBaseView.h(this.myp).path))
    {
      FavVoiceBaseView.i(this.myp);
      AppMethodBeat.o(74169);
      return;
    }
    if (FavVoiceBaseView.h(this.myp).bwz())
    {
      this.myp.bwB();
      AppMethodBeat.o(74169);
      return;
    }
    if (!FavVoiceBaseView.j(this.myp)) {
      FavVoiceBaseView.i(this.myp);
    }
    AppMethodBeat.o(74169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavVoiceBaseView.2
 * JD-Core Version:    0.7.0.1
 */