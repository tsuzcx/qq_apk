package com.tencent.mm.plugin.finder.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderCollapsibleTextView$e
  implements View.OnClickListener
{
  FinderCollapsibleTextView$e(FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(200036);
    this.qVB.getCollapseTextView().callOnClick();
    AppMethodBeat.o(200036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView.e
 * JD-Core Version:    0.7.0.1
 */