package com.tencent.mm.plugin.finder.utils;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.u.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
final class s$a$c
  implements u.b
{
  public static final c vWy;
  
  static
  {
    AppMethodBeat.i(253495);
    vWy = new c();
    AppMethodBeat.o(253495);
  }
  
  public final void dU(View paramView)
  {
    AppMethodBeat.i(253494);
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(2131309260);
      if (paramView != null)
      {
        paramView.setTextSize(1, 14.0F);
        AppMethodBeat.o(253494);
        return;
      }
    }
    AppMethodBeat.o(253494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.s.a.c
 * JD-Core Version:    0.7.0.1
 */