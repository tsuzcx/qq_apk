package com.tencent.mm.plugin.finder.utils;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.u.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
final class q$a$a
  implements u.b
{
  public static final a vWc;
  
  static
  {
    AppMethodBeat.i(253468);
    vWc = new a();
    AppMethodBeat.o(253468);
  }
  
  public final void dU(View paramView)
  {
    AppMethodBeat.i(253467);
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(2131309260);
      if (paramView != null)
      {
        paramView.setTextSize(1, 14.0F);
        AppMethodBeat.o(253467);
        return;
      }
    }
    AppMethodBeat.o(253467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.q.a.a
 * JD-Core Version:    0.7.0.1
 */