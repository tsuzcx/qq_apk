package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.a;

final class FavTagEditUI$8
  implements MMTagPanel.a
{
  FavTagEditUI$8(FavTagEditUI paramFavTagEditUI) {}
  
  public final void Bc(String paramString)
  {
    FavTagEditUI.d(this.kdx).removeTag(paramString);
    FavTagEditUI.f(this.kdx).Db(paramString);
    FavTagEditUI.c(this.kdx);
  }
  
  public final void Bd(String paramString)
  {
    FavTagEditUI.d(this.kdx).bH(paramString, true);
    FavTagEditUI.f(this.kdx).Da(paramString);
    FavTagEditUI.c(this.kdx);
  }
  
  public final void Be(String paramString) {}
  
  public final void Bf(String paramString) {}
  
  public final void Bg(String paramString) {}
  
  public final void aJI() {}
  
  public final void i(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTagEditUI.8
 * JD-Core Version:    0.7.0.1
 */