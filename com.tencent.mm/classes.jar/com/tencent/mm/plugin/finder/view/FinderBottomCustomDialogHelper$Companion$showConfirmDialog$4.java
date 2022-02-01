package com.tencent.mm.plugin.finder.view;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.e;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
final class FinderBottomCustomDialogHelper$Companion$showConfirmDialog$4
  implements q.f
{
  FinderBottomCustomDialogHelper$Companion$showConfirmDialog$4(e parame, RoundedCornerFrameLayout paramRoundedCornerFrameLayout) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(221925);
    paramo.clear();
    this.$dialog.setFooterView(null);
    this.$dialog.setFooterView((View)this.$rootViewContainer);
    AppMethodBeat.o(221925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper.Companion.showConfirmDialog.4
 * JD-Core Version:    0.7.0.1
 */