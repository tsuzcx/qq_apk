package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class h$b
  implements View.OnClickListener
{
  h$b(h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(201282);
    paramView = h.b(this.rbi);
    if (paramView != null)
    {
      paramView.invoke();
      AppMethodBeat.o(201282);
      return;
    }
    AppMethodBeat.o(201282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.b
 * JD-Core Version:    0.7.0.1
 */