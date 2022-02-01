package com.tencent.mm.plugin.appbrand.jsapi.aa.e.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class g$d
  implements View.OnClickListener
{
  g$d(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(139699);
    if (this.kBA.kBv != null)
    {
      paramView = this.kBA.kBv;
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(139699);
        return;
      }
    }
    AppMethodBeat.o(139699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.g.d
 * JD-Core Version:    0.7.0.1
 */