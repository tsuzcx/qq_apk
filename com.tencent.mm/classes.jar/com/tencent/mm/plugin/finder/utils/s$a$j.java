package com.tencent.mm.plugin.finder.utils;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.u.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
final class s$a$j
  implements u.b
{
  public static final j vWC;
  
  static
  {
    AppMethodBeat.i(253502);
    vWC = new j();
    AppMethodBeat.o(253502);
  }
  
  public final void dU(View paramView)
  {
    AppMethodBeat.i(253501);
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(2131309260);
      if (paramView != null)
      {
        paramView.setTextSize(1, 14.0F);
        AppMethodBeat.o(253501);
        return;
      }
    }
    AppMethodBeat.o(253501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.s.a.j
 * JD-Core Version:    0.7.0.1
 */