package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
final class aq$g
  implements q.f
{
  aq$g(aq paramaq) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(262797);
    p.j(paramo, "it");
    if (paramo.hJO())
    {
      Context localContext = this.yoR.kiF.getContext();
      p.j(localContext, "root.context");
      int i = localContext.getResources().getColor(b.c.Red);
      localContext = this.yoR.kiF.getContext();
      p.j(localContext, "root.context");
      paramo.a(162, i, (CharSequence)localContext.getResources().getString(b.j.finder_put_in_black_list));
    }
    AppMethodBeat.o(262797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.aq.g
 * JD-Core Version:    0.7.0.1
 */