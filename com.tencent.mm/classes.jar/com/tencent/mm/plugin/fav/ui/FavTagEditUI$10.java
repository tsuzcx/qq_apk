package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.a.d;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;

final class FavTagEditUI$10
  extends d
{
  FavTagEditUI$10(FavTagEditUI paramFavTagEditUI, Context paramContext)
  {
    super(paramContext);
  }
  
  public final void LV(String paramString)
  {
    AppMethodBeat.i(74152);
    FavTagEditUI.d(this.myh).cj(paramString, true);
    FavTagEditUI.f(this.myh).Oc(paramString);
    FavTagEditUI.d(this.myh).dEm();
    FavTagEditUI.d(this.myh).dEo();
    FavTagEditUI.c(this.myh);
    AppMethodBeat.o(74152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTagEditUI.10
 * JD-Core Version:    0.7.0.1
 */