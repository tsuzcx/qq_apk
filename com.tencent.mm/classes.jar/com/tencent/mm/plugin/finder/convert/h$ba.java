package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.t.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
final class h$ba
  implements t.b
{
  public static final ba rWe;
  
  static
  {
    AppMethodBeat.i(201790);
    rWe = new ba();
    AppMethodBeat.o(201790);
  }
  
  public final void ec(View paramView)
  {
    AppMethodBeat.i(201789);
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(2131305957);
      if (paramView != null)
      {
        paramView.setTextSize(1, 14.0F);
        AppMethodBeat.o(201789);
        return;
      }
    }
    AppMethodBeat.o(201789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.ba
 * JD-Core Version:    0.7.0.1
 */