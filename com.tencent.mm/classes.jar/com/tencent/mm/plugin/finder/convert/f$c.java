package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class f$c
  implements View.OnClickListener
{
  f$c(f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(197407);
    paramView = f.b(this.qrl);
    if (paramView != null)
    {
      paramView.invoke();
      AppMethodBeat.o(197407);
      return;
    }
    AppMethodBeat.o(197407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.f.c
 * JD-Core Version:    0.7.0.1
 */