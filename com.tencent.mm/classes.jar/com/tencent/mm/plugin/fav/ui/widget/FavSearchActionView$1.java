package com.tencent.mm.plugin.fav.ui.widget;

import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class FavSearchActionView$1
  implements FavTagPanel.a
{
  FavSearchActionView$1(FavSearchActionView paramFavSearchActionView) {}
  
  public final void Bc(String paramString)
  {
    y.d("MicroMsg.FavSearchActionView", "unselected tag %s", new Object[] { paramString });
    FavSearchActionView.a(this.kjG).removeTag(paramString);
    Be(paramString);
  }
  
  public final void Bd(String paramString) {}
  
  public final void Be(String paramString)
  {
    FavSearchActionView.a(this.kjG, FavSearchActionView.a(this.kjG).getEditText());
    FavSearchActionView.b(this.kjG).remove(paramString);
    FavSearchActionView.c(this.kjG);
    if (FavSearchActionView.d(this.kjG) == null) {
      return;
    }
    FavSearchActionView.d(this.kjG).a(FavSearchActionView.e(this.kjG), FavSearchActionView.f(this.kjG), FavSearchActionView.b(this.kjG), true);
  }
  
  public final void Bf(String paramString)
  {
    FavSearchActionView.a(this.kjG, FavSearchActionView.a(this.kjG).getEditText());
    FavSearchActionView.c(this.kjG);
    if (FavSearchActionView.d(this.kjG) == null) {
      return;
    }
    FavSearchActionView.d(this.kjG).a(paramString, FavSearchActionView.e(this.kjG), FavSearchActionView.f(this.kjG), FavSearchActionView.b(this.kjG));
  }
  
  public final void Bg(String paramString)
  {
    FavSearchActionView.a(this.kjG, paramString);
    FavSearchActionView.d(this.kjG).a(FavSearchActionView.e(this.kjG), FavSearchActionView.f(this.kjG), FavSearchActionView.b(this.kjG), false);
  }
  
  public final void De(String paramString)
  {
    y.d("MicroMsg.FavSearchActionView", "unselected type %s", new Object[] { paramString });
    FavTagPanel.aSd();
    FavSearchActionView.a(this.kjG, FavSearchActionView.a(this.kjG).getEditText());
    FavSearchActionView.e(this.kjG).remove(FavSearchActionView.ag(this.kjG.getContext(), paramString));
    FavSearchActionView.c(this.kjG);
    if (FavSearchActionView.d(this.kjG) != null) {
      FavSearchActionView.d(this.kjG).a(FavSearchActionView.e(this.kjG), FavSearchActionView.f(this.kjG), FavSearchActionView.b(this.kjG), true);
    }
  }
  
  public final void aJI()
  {
    if (FavSearchActionView.d(this.kjG) == null) {
      return;
    }
    FavSearchActionView.d(this.kjG).Wm();
  }
  
  public final void i(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.1
 * JD-Core Version:    0.7.0.1
 */