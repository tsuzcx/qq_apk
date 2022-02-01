package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.i;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderSelfUI$g
  implements View.OnClickListener
{
  FinderSelfUI$g(FinderSelfUI paramFinderSelfUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(199373);
    paramView = FinderSelfUI.a(this.qPI);
    if (paramView != null)
    {
      i locali = i.qTa;
      if (i.al((Activity)this.qPI)) {
        FinderSelfUI.a(this.qPI, paramView);
      }
      AppMethodBeat.o(199373);
      return;
    }
    AppMethodBeat.o(199373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfUI.g
 * JD-Core Version:    0.7.0.1
 */