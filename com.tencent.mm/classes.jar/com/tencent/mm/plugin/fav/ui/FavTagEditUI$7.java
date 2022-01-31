package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;

final class FavTagEditUI$7
  extends c
{
  FavTagEditUI$7(FavTagEditUI paramFavTagEditUI, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void CW(String paramString)
  {
    FavTagEditUI.d(this.kdx).bH(paramString, true);
    if (FavTagEditUI.g(this.kdx) != null) {
      FavTagEditUI.g(this.kdx).bI(paramString, true);
    }
    FavTagEditUI.c(this.kdx);
  }
  
  protected final void CX(String paramString)
  {
    FavTagEditUI.d(this.kdx).removeTag(paramString);
    if (FavTagEditUI.g(this.kdx) != null) {
      FavTagEditUI.g(this.kdx).bI(paramString, false);
    }
    FavTagEditUI.c(this.kdx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTagEditUI.7
 * JD-Core Version:    0.7.0.1
 */