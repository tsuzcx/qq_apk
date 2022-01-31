package com.tencent.mm.plugin.appbrand.widget.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class i$1
  implements View.OnClickListener
{
  i$1(i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(102481);
    paramView = i.a(this.jjO, true);
    i.a(this.jjO).a(1, paramView);
    paramView = i.b(this.jjO);
    if (paramView != null)
    {
      paramView.c((k)this.jjO);
      AppMethodBeat.o(102481);
      return;
    }
    AppMethodBeat.o(102481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.i.1
 * JD-Core Version:    0.7.0.1
 */