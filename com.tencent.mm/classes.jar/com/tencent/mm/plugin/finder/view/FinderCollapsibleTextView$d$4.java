package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
final class FinderCollapsibleTextView$d$4
  implements View.OnCreateContextMenuListener
{
  FinderCollapsibleTextView$d$4(FinderCollapsibleTextView.d paramd) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(200034);
    paramContextMenu.add(0, 0, 0, (CharSequence)this.qVC.qVB.getContext().getString(2131755701));
    AppMethodBeat.o(200034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView.d.4
 * JD-Core Version:    0.7.0.1
 */