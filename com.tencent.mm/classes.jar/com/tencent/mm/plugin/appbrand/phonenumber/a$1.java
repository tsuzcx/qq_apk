package com.tencent.mm.plugin.appbrand.phonenumber;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.b.k;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(143906);
    paramView = this.iCC.iCy;
    if (paramView != null) {
      paramView.pr(1);
    }
    paramView = a.a(this.iCC);
    if (paramView != null)
    {
      paramView.c((k)this.iCC);
      AppMethodBeat.o(143906);
      return;
    }
    AppMethodBeat.o(143906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.a.1
 * JD-Core Version:    0.7.0.1
 */