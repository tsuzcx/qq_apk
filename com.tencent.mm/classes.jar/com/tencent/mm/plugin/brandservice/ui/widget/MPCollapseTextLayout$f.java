package com.tencent.mm.plugin.brandservice.ui.widget;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class MPCollapseTextLayout$f
  implements View.OnClickListener
{
  MPCollapseTextLayout$f(MPCollapseTextLayout paramMPCollapseTextLayout, int paramInt, MPCollapseTextLayout.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(152991);
    if (!MPCollapseTextLayout.a(this.kjp))
    {
      MPCollapseTextLayout.b(this.kjp);
      AppMethodBeat.o(152991);
      return;
    }
    MPCollapseTextLayout.c(this.kjp);
    AppMethodBeat.o(152991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPCollapseTextLayout.f
 * JD-Core Version:    0.7.0.1
 */