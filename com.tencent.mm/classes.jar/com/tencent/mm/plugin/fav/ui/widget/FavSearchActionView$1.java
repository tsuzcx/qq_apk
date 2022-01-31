package com.tencent.mm.plugin.fav.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class FavSearchActionView$1
  implements FavTagPanel.a
{
  FavSearchActionView$1(FavSearchActionView paramFavSearchActionView) {}
  
  public final void Le(String paramString)
  {
    AppMethodBeat.i(74682);
    ab.d("MicroMsg.FavSearchActionView", "unselected tag %s", new Object[] { paramString });
    FavSearchActionView.a(this.mEl).removeTag(paramString);
    Lg(paramString);
    AppMethodBeat.o(74682);
  }
  
  public final void Lf(String paramString) {}
  
  public final void Lg(String paramString)
  {
    AppMethodBeat.i(74683);
    FavSearchActionView.a(this.mEl, FavSearchActionView.a(this.mEl).getEditText());
    FavSearchActionView.b(this.mEl).remove(paramString);
    FavSearchActionView.c(this.mEl);
    if (FavSearchActionView.d(this.mEl) == null)
    {
      AppMethodBeat.o(74683);
      return;
    }
    FavSearchActionView.d(this.mEl).a(FavSearchActionView.e(this.mEl), FavSearchActionView.f(this.mEl), FavSearchActionView.b(this.mEl), true);
    AppMethodBeat.o(74683);
  }
  
  public final void Lh(String paramString)
  {
    AppMethodBeat.i(74684);
    FavSearchActionView.a(this.mEl, FavSearchActionView.a(this.mEl).getEditText());
    FavSearchActionView.c(this.mEl);
    if (FavSearchActionView.d(this.mEl) == null)
    {
      AppMethodBeat.o(74684);
      return;
    }
    FavSearchActionView.d(this.mEl).a(paramString, FavSearchActionView.e(this.mEl), FavSearchActionView.f(this.mEl), FavSearchActionView.b(this.mEl));
    AppMethodBeat.o(74684);
  }
  
  public final void Li(String paramString)
  {
    AppMethodBeat.i(74685);
    FavSearchActionView.a(this.mEl, paramString);
    FavSearchActionView.d(this.mEl).a(FavSearchActionView.e(this.mEl), FavSearchActionView.f(this.mEl), FavSearchActionView.b(this.mEl), false);
    AppMethodBeat.o(74685);
  }
  
  public final void Og(String paramString)
  {
    AppMethodBeat.i(74687);
    ab.d("MicroMsg.FavSearchActionView", "unselected type %s", new Object[] { paramString });
    FavSearchActionView.a(this.mEl);
    FavSearchActionView.a(this.mEl, FavSearchActionView.a(this.mEl).getEditText());
    FavSearchActionView.e(this.mEl).remove(FavSearchActionView.ao(this.mEl.getContext(), paramString));
    FavSearchActionView.c(this.mEl);
    if (FavSearchActionView.d(this.mEl) != null) {
      FavSearchActionView.d(this.mEl).a(FavSearchActionView.e(this.mEl), FavSearchActionView.f(this.mEl), FavSearchActionView.b(this.mEl), true);
    }
    AppMethodBeat.o(74687);
  }
  
  public final void bnq()
  {
    AppMethodBeat.i(74686);
    if (FavSearchActionView.d(this.mEl) == null)
    {
      AppMethodBeat.o(74686);
      return;
    }
    FavSearchActionView.d(this.mEl).apO();
    AppMethodBeat.o(74686);
  }
  
  public final void t(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.1
 * JD-Core Version:    0.7.0.1
 */