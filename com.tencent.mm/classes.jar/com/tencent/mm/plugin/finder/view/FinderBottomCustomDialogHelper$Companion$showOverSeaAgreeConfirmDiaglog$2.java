package com.tencent.mm.plugin.finder.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.a.e;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderBottomCustomDialogHelper$Companion$showOverSeaAgreeConfirmDiaglog$2
  implements View.OnClickListener
{
  private byte _hellAccFlag_;
  
  FinderBottomCustomDialogHelper$Companion$showOverSeaAgreeConfirmDiaglog$2(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(229617);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion$showOverSeaAgreeConfirmDiaglog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.$dialog.bYF();
    a.a(this, "com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion$showOverSeaAgreeConfirmDiaglog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(229617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper.Companion.showOverSeaAgreeConfirmDiaglog.2
 * JD-Core Version:    0.7.0.1
 */