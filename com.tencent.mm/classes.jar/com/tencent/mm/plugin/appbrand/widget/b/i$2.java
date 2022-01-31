package com.tencent.mm.plugin.appbrand.widget.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class i$2
  implements View.OnClickListener
{
  i$2(i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(102482);
    paramView = i.a(this.jjO, false);
    i.a(this.jjO).a(2, paramView);
    paramView = i.b(this.jjO);
    if (paramView != null)
    {
      paramView.c((k)this.jjO);
      AppMethodBeat.o(102482);
      return;
    }
    AppMethodBeat.o(102482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.i.2
 * JD-Core Version:    0.7.0.1
 */