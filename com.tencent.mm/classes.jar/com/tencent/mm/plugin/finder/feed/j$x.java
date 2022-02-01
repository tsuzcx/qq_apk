package com.tencent.mm.plugin.finder.feed;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.q;
import com.tencent.mm.plugin.finder.convert.q.a;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class j$x
  implements Runnable
{
  j$x(j paramj, i.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(198065);
    Object localObject = q.qrB;
    localObject = this.qrC;
    View localView = this.qrC.getRootView();
    if (localView == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(198065);
      throw ((Throwable)localObject);
    }
    q.a.a((i.b)localObject, (ViewGroup)localView, this.qrC.getRecyclerView(), true, j.w(this.qwX));
    AppMethodBeat.o(198065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.j.x
 * JD-Core Version:    0.7.0.1
 */