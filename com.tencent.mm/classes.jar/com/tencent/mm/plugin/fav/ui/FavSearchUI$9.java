package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.a;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.plugin.report.service.h;
import java.util.List;

final class FavSearchUI$9
  extends c
{
  FavSearchUI$9(FavSearchUI paramFavSearchUI, Context paramContext)
  {
    super(paramContext);
  }
  
  public final void NY(String paramString)
  {
    AppMethodBeat.i(74076);
    FavSearchActionView localFavSearchActionView = FavSearchUI.b(this.mxx);
    localFavSearchActionView.mEi.add(paramString);
    if (localFavSearchActionView.mya == null)
    {
      AppMethodBeat.o(74076);
      return;
    }
    localFavSearchActionView.mya.setEditHint("");
    localFavSearchActionView.mya.cj(paramString, true);
    if (localFavSearchActionView.mEk == null)
    {
      AppMethodBeat.o(74076);
      return;
    }
    localFavSearchActionView.Of(localFavSearchActionView.mya.getEditText());
    localFavSearchActionView.mEk.a(localFavSearchActionView.mzr, localFavSearchActionView.mEj, localFavSearchActionView.mEi, false);
    h.qsU.e(11126, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(74076);
  }
  
  public final void NZ(String paramString)
  {
    AppMethodBeat.i(74077);
    FavSearchActionView localFavSearchActionView = FavSearchUI.b(this.mxx);
    localFavSearchActionView.mEi.remove(paramString);
    if (localFavSearchActionView.mya == null)
    {
      AppMethodBeat.o(74077);
      return;
    }
    if (localFavSearchActionView.mEi.isEmpty()) {
      localFavSearchActionView.mya.setEditHint(localFavSearchActionView.getResources().getString(2131297065));
    }
    localFavSearchActionView.mya.removeTag(paramString);
    if (localFavSearchActionView.mEk == null)
    {
      AppMethodBeat.o(74077);
      return;
    }
    localFavSearchActionView.Of(localFavSearchActionView.mya.getEditText());
    localFavSearchActionView.mEk.a(localFavSearchActionView.mzr, localFavSearchActionView.mEj, localFavSearchActionView.mEi, true);
    AppMethodBeat.o(74077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.9
 * JD-Core Version:    0.7.0.1
 */