package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.a;

final class FavTagEditUI$8
  implements MMTagPanel.a
{
  FavTagEditUI$8(FavTagEditUI paramFavTagEditUI) {}
  
  public final void Le(String paramString)
  {
    AppMethodBeat.i(74149);
    FavTagEditUI.d(this.myh).removeTag(paramString);
    FavTagEditUI.f(this.myh).Od(paramString);
    FavTagEditUI.c(this.myh);
    AppMethodBeat.o(74149);
  }
  
  public final void Lf(String paramString)
  {
    AppMethodBeat.i(74150);
    FavTagEditUI.d(this.myh).cj(paramString, true);
    FavTagEditUI.f(this.myh).Oc(paramString);
    FavTagEditUI.c(this.myh);
    AppMethodBeat.o(74150);
  }
  
  public final void Lg(String paramString) {}
  
  public final void Lh(String paramString) {}
  
  public final void Li(String paramString) {}
  
  public final void bnq() {}
  
  public final void t(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTagEditUI.8
 * JD-Core Version:    0.7.0.1
 */