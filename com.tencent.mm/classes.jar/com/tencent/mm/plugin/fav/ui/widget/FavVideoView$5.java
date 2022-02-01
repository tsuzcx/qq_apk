package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FavVideoView$5
  implements View.OnClickListener
{
  FavVideoView$5(FavVideoView paramFavVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(107566);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/fav/ui/widget/FavVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (FavVideoView.e(this.Aql) != null) {
      FavVideoView.e(this.Aql).finish();
    }
    a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(107566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView.5
 * JD-Core Version:    0.7.0.1
 */