package com.tencent.mm.plugin.fav.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FavoriteFileDetailUI$5
  implements View.OnClickListener
{
  FavoriteFileDetailUI$5(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(107120);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    FavoriteFileDetailUI.t(this.rIw);
    a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(107120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.5
 * JD-Core Version:    0.7.0.1
 */