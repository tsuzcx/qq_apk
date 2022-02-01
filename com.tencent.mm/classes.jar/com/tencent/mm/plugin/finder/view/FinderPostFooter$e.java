package com.tencent.mm.plugin.finder.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
public final class FinderPostFooter$e
  implements View.OnClickListener
{
  public static final e wow;
  
  static
  {
    AppMethodBeat.i(254894);
    wow = new e();
    AppMethodBeat.o(254894);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(254893);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    a.a(this, "com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(254893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderPostFooter.e
 * JD-Core Version:    0.7.0.1
 */