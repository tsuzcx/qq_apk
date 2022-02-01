package com.tencent.mm.plugin.finder.convert;

import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.ai;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.y.f;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
final class h$q
  implements Runnable
{
  h$q(e parame, y.f paramf1, y.f paramf2) {}
  
  public final void run()
  {
    AppMethodBeat.i(201332);
    int i = a.ay(this.oNd.getContext(), 2131165303);
    Rect localRect = new Rect();
    ((View)this.rNj.MLV).getHitRect(localRect);
    localRect.inset(-i, -i);
    ((ah)this.rNk.MLV).a(new ai(localRect, (View)this.rNj.MLV));
    AppMethodBeat.o(201332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.q
 * JD-Core Version:    0.7.0.1
 */