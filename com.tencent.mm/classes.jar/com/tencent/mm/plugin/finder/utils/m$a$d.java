package com.tencent.mm.plugin.finder.utils;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.t.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
final class m$a$d
  implements t.b
{
  public static final d sWT;
  
  static
  {
    AppMethodBeat.i(205116);
    sWT = new d();
    AppMethodBeat.o(205116);
  }
  
  public final void ec(View paramView)
  {
    AppMethodBeat.i(205115);
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(2131305957);
      if (paramView != null)
      {
        paramView.setTextSize(1, 14.0F);
        AppMethodBeat.o(205115);
        return;
      }
    }
    AppMethodBeat.o(205115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.m.a.d
 * JD-Core Version:    0.7.0.1
 */