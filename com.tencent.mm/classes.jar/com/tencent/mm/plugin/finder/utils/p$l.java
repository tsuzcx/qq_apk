package com.tencent.mm.plugin.finder.utils;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.t.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
final class p$l
  implements t.b
{
  public static final l sML;
  
  static
  {
    AppMethodBeat.i(204531);
    sML = new l();
    AppMethodBeat.o(204531);
  }
  
  public final void ec(View paramView)
  {
    AppMethodBeat.i(204530);
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(2131305957);
      if (paramView != null)
      {
        paramView.setTextSize(1, 14.0F);
        AppMethodBeat.o(204530);
        return;
      }
    }
    AppMethodBeat.o(204530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.p.l
 * JD-Core Version:    0.7.0.1
 */