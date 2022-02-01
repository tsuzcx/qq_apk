package com.tencent.mm.plugin.finder.utils;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.t.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
final class m$a$b
  implements t.b
{
  public static final b sLF;
  
  static
  {
    AppMethodBeat.i(204493);
    sLF = new b();
    AppMethodBeat.o(204493);
  }
  
  public final void ec(View paramView)
  {
    AppMethodBeat.i(204492);
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(2131305957);
      if (paramView != null)
      {
        paramView.setTextSize(1, 14.0F);
        AppMethodBeat.o(204492);
        return;
      }
    }
    AppMethodBeat.o(204492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.m.a.b
 * JD-Core Version:    0.7.0.1
 */