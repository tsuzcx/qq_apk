package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.spam.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderCreateContactUI$m
  implements View.OnClickListener
{
  FinderCreateContactUI$m(FinderCreateContactUI paramFinderCreateContactUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(199126);
    paramView = a.qIC;
    paramView = this.qLN.getString(2131766483);
    k.g(paramView, "getString(R.string.finder_sex_tip)");
    a.Zs(paramView);
    AppMethodBeat.o(199126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCreateContactUI.m
 * JD-Core Version:    0.7.0.1
 */