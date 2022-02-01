package com.tencent.mm.plugin.fts.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FTSActionBarSearchView$1
  implements View.OnClickListener
{
  FTSActionBarSearchView$1(FTSActionBarSearchView paramFTSActionBarSearchView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(265933);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/fts/ui/widget/FTSActionBarSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.HCH.jCM();
    this.HCH.showVKB();
    a.a(this, "com/tencent/mm/plugin/fts/ui/widget/FTSActionBarSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(265933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSActionBarSearchView.1
 * JD-Core Version:    0.7.0.1
 */