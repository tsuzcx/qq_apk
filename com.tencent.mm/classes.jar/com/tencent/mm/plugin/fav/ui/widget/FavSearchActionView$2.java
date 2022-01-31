package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class FavSearchActionView$2
  implements View.OnClickListener
{
  FavSearchActionView$2(FavSearchActionView paramFavSearchActionView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74688);
    if (FavSearchActionView.d(this.mEl) == null)
    {
      AppMethodBeat.o(74688);
      return;
    }
    FavSearchActionView.a(this.mEl).dEr();
    FavSearchActionView.a(this.mEl).dEm();
    FavSearchActionView.f(this.mEl).clear();
    FavSearchActionView.b(this.mEl).clear();
    FavSearchActionView.d(this.mEl).a(FavSearchActionView.e(this.mEl), FavSearchActionView.f(this.mEl), FavSearchActionView.b(this.mEl), true);
    FavSearchActionView.c(this.mEl);
    AppMethodBeat.o(74688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.2
 * JD-Core Version:    0.7.0.1
 */