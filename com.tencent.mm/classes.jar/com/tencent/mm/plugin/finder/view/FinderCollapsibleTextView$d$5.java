package com.tencent.mm.plugin.finder.view;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.base.n.d;
import com.tencent.neattextview.textview.view.NeatTextView;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
final class FinderCollapsibleTextView$d$5
  implements n.d
{
  FinderCollapsibleTextView$d$5(FinderCollapsibleTextView.d paramd) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(200035);
    if (paramInt == 0)
    {
      paramMenuItem = aj.getContext().getSystemService("clipboard");
      if (paramMenuItem == null)
      {
        paramMenuItem = new v("null cannot be cast to non-null type android.content.ClipboardManager");
        AppMethodBeat.o(200035);
        throw paramMenuItem;
      }
      ((ClipboardManager)paramMenuItem).setText(this.qVC.qVB.getContentTextView().fli());
    }
    AppMethodBeat.o(200035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView.d.5
 * JD-Core Version:    0.7.0.1
 */