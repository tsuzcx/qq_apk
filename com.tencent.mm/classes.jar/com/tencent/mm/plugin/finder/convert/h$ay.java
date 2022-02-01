package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.t.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
final class h$ay
  implements t.b
{
  public static final ay rNM;
  
  static
  {
    AppMethodBeat.i(201361);
    rNM = new ay();
    AppMethodBeat.o(201361);
  }
  
  public final void ec(View paramView)
  {
    AppMethodBeat.i(201360);
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(2131305957);
      if (paramView != null)
      {
        paramView.setTextSize(1, 14.0F);
        AppMethodBeat.o(201360);
        return;
      }
    }
    AppMethodBeat.o(201360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.ay
 * JD-Core Version:    0.7.0.1
 */