package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.view.recyclerview.e;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class m$b
  implements View.OnClickListener
{
  m$b(m paramm, o paramo, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(221457);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert$refresh$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.EIB.EIz.invoke(Boolean.TRUE);
    this.EIB.a(this.rNY, this.oNd);
    a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert$refresh$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(221457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.m.b
 * JD-Core Version:    0.7.0.1
 */