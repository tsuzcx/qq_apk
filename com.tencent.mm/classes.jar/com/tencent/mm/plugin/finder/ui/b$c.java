package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$c
  implements View.OnClickListener
{
  b$c(b paramb, View paramView, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(199115);
    paramView = this.qKO.ypN;
    if (paramView != null)
    {
      View localView = this.qKP;
      k.g(localView, "clickArea");
      paramView.n(localView, Integer.valueOf(this.fKG));
      AppMethodBeat.o(199115);
      return;
    }
    AppMethodBeat.o(199115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.b.c
 * JD-Core Version:    0.7.0.1
 */