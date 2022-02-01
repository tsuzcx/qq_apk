package com.tencent.mm.plugin.finder.convert;

import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.ai;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.g.b.y.f;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
final class h$x
  implements Runnable
{
  h$x(y.f paramf1, e parame, y.f paramf2) {}
  
  public final void run()
  {
    AppMethodBeat.i(201340);
    Rect localRect = new Rect();
    ((View)this.rNm.MLV).getHitRect(localRect);
    int i = a.ay(this.oNd.getContext(), 2131165303);
    localRect.inset(-i, -i);
    ah localah = (ah)this.rNk.MLV;
    View localView = (View)this.rNm.MLV;
    p.g(localView, "awesomeView");
    localah.a(new ai(localRect, localView));
    AppMethodBeat.o(201340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.x
 * JD-Core Version:    0.7.0.1
 */