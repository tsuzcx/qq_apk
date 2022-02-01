package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
final class o$s
  implements Runnable
{
  o$s(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(242905);
    Object localObject = this.qhp.aus;
    p.g(localObject, "holder.itemView");
    localObject = ((View)localObject).getLayoutParams();
    View localView = this.qhp.aus;
    p.g(localView, "holder.itemView");
    ((ViewGroup.LayoutParams)localObject).height = (localView.getHeight() - 1);
    AppMethodBeat.o(242905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.o.s
 * JD-Core Version:    0.7.0.1
 */