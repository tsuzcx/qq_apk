package com.tencent.mm.plugin.finder.convert;

import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.ai;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$1$1"})
final class e$n
  implements Runnable
{
  e$n(View paramView, int paramInt, ah paramah) {}
  
  public final void run()
  {
    AppMethodBeat.i(201316);
    Rect localRect = new Rect();
    this.rMp.getHitRect(localRect);
    localRect.inset(-this.rMq, -this.rMq);
    this.rMr.a(new ai(localRect, this.rMp));
    AppMethodBeat.o(201316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e.n
 * JD-Core Version:    0.7.0.1
 */