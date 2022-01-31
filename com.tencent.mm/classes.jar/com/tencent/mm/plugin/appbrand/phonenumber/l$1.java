package com.tencent.mm.plugin.appbrand.phonenumber;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.b.k;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class l$1
  implements View.OnClickListener
{
  l$1(l paraml) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(143952);
    paramView = this.iDT.iDP;
    if (paramView != null)
    {
      paramView.c((k)this.iDT);
      AppMethodBeat.o(143952);
      return;
    }
    AppMethodBeat.o(143952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.l.1
 * JD-Core Version:    0.7.0.1
 */