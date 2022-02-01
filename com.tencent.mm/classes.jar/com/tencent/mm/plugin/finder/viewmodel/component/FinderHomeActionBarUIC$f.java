package com.tencent.mm.plugin.finder.viewmodel.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderHomeActionBarUIC$f
  implements View.OnClickListener
{
  public static final f tbJ;
  
  static
  {
    AppMethodBeat.i(205562);
    tbJ = new f();
    AppMethodBeat.o(205562);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(205561);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(205561);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeActionBarUIC.f
 * JD-Core Version:    0.7.0.1
 */