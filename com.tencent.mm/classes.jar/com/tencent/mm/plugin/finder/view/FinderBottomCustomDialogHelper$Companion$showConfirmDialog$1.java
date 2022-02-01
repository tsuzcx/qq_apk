package com.tencent.mm.plugin.finder.view;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.a.e;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderBottomCustomDialogHelper$Companion$showConfirmDialog$1
  implements View.OnClickListener
{
  private byte _hellAccFlag_;
  
  FinderBottomCustomDialogHelper$Companion$showConfirmDialog$1(e parame, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(287529);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion$showConfirmDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.$dialog.bYF();
    paramView = this.$lok;
    if (paramView != null) {
      paramView.onClick(null, -1);
    }
    a.a(this, "com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion$showConfirmDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(287529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper.Companion.showConfirmDialog.1
 * JD-Core Version:    0.7.0.1
 */