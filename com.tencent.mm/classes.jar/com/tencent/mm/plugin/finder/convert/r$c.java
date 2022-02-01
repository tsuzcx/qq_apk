package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$adjustSeekLayout$1$1"})
final class r$c
  implements Runnable
{
  r$c(View paramView1, View paramView2, i parami, View paramView3) {}
  
  public final void run()
  {
    AppMethodBeat.i(275117);
    Object localObject1 = new int[2];
    Object localObject2 = new int[2];
    this.xhb.amk.getLocationInWindow((int[])localObject1);
    this.xkO.getLocationInWindow((int[])localObject2);
    localObject2[0] -= localObject1[0];
    localObject2[1] -= localObject1[1];
    localObject1 = this.xkO;
    p.j(localObject1, "indicator");
    localObject1 = ((View)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(275117);
      throw ((Throwable)localObject1);
    }
    localObject1 = (FrameLayout.LayoutParams)localObject1;
    localObject2 = this.xjJ.getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(275117);
      throw ((Throwable)localObject1);
    }
    localObject2 = (FrameLayout.LayoutParams)localObject2;
    int i = ((FrameLayout.LayoutParams)localObject1).topMargin;
    localObject1 = this.xkO;
    p.j(localObject1, "indicator");
    ((FrameLayout.LayoutParams)localObject2).topMargin = (i + (((View)localObject1).getHeight() - this.xkN.getHeight()) / 2);
    this.xjJ.requestLayout();
    AppMethodBeat.o(275117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.r.c
 * JD-Core Version:    0.7.0.1
 */