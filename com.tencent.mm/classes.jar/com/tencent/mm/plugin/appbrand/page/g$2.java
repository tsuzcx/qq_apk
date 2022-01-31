package com.tencent.mm.plugin.appbrand.page;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class g$2
  implements View.OnClickListener
{
  g$2(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(134763);
    paramView = this.ivD.getPositiveButton();
    if (paramView != null)
    {
      paramView.onClick((DialogInterface)this.ivD, -1);
      AppMethodBeat.o(134763);
      return;
    }
    AppMethodBeat.o(134763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.g.2
 * JD-Core Version:    0.7.0.1
 */