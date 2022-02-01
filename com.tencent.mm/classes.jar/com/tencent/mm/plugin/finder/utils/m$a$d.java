package com.tencent.mm.plugin.finder.utils;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.t.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
final class m$a$d
  implements t.b
{
  public static final d sLI;
  
  static
  {
    AppMethodBeat.i(204496);
    sLI = new d();
    AppMethodBeat.o(204496);
  }
  
  public final void ec(View paramView)
  {
    AppMethodBeat.i(204495);
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(2131305957);
      if (paramView != null)
      {
        paramView.setTextSize(1, 14.0F);
        AppMethodBeat.o(204495);
        return;
      }
    }
    AppMethodBeat.o(204495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.m.a.d
 * JD-Core Version:    0.7.0.1
 */