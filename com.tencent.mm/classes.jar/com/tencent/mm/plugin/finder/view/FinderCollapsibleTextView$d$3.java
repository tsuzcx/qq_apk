package com.tencent.mm.plugin.finder.view;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.view.NeatTextView;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onDismiss"})
final class FinderCollapsibleTextView$d$3
  implements PopupWindow.OnDismissListener
{
  FinderCollapsibleTextView$d$3(FinderCollapsibleTextView.d paramd) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(200033);
    this.qVC.qVB.getContentTextView().setBackgroundResource(2131101053);
    AppMethodBeat.o(200033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView.d.3
 * JD-Core Version:    0.7.0.1
 */