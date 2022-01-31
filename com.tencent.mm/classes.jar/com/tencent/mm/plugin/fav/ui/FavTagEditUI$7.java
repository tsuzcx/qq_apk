package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;

final class FavTagEditUI$7
  extends c
{
  FavTagEditUI$7(FavTagEditUI paramFavTagEditUI, Context paramContext)
  {
    super(paramContext);
  }
  
  public final void NY(String paramString)
  {
    AppMethodBeat.i(74147);
    FavTagEditUI.d(this.myh).cj(paramString, true);
    if (FavTagEditUI.g(this.myh) != null) {
      FavTagEditUI.g(this.myh).ck(paramString, true);
    }
    FavTagEditUI.c(this.myh);
    AppMethodBeat.o(74147);
  }
  
  public final void NZ(String paramString)
  {
    AppMethodBeat.i(74148);
    FavTagEditUI.d(this.myh).removeTag(paramString);
    if (FavTagEditUI.g(this.myh) != null) {
      FavTagEditUI.g(this.myh).ck(paramString, false);
    }
    FavTagEditUI.c(this.myh);
    AppMethodBeat.o(74148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTagEditUI.7
 * JD-Core Version:    0.7.0.1
 */