package com.tencent.mm.plugin.finder.convert;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
final class h$o
  implements Runnable
{
  h$o(ImageView paramImageView) {}
  
  public final void run()
  {
    AppMethodBeat.i(201330);
    Object localObject1 = new Rect();
    this.rNi.getHitRect((Rect)localObject1);
    ((Rect)localObject1).inset(((Rect)localObject1).width() * -2, -((Rect)localObject1).width());
    Object localObject2 = this.rNi;
    p.g(localObject2, "avatarView");
    localObject2 = ((ImageView)localObject2).getParent();
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(201330);
      throw ((Throwable)localObject1);
    }
    ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, (View)this.rNi));
    AppMethodBeat.o(201330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.o
 * JD-Core Version:    0.7.0.1
 */