package com.tencent.mm.emoji.panel.layout;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-emojisdk_release"})
public final class a$g
  extends RecyclerView.l
{
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(199989);
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
    p.h(paramRecyclerView, "recyclerView");
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    Log.i("MicroMsg.CenterPagerSnapHelper", "onScrollStateChanged:" + paramInt + ", snapPosition:" + this.hbV.hbQ);
    if (paramInt == 0)
    {
      this.hbV.hbN = false;
      this.hbV.avW();
    }
    if (paramInt == 1)
    {
      this.hbV.hbN = true;
      paramRecyclerView = this.hbV.hbT;
      if (paramRecyclerView != null) {
        paramRecyclerView.pr(this.hbV.hbQ);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    AppMethodBeat.o(199989);
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199990);
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt1);
    localb.pH(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(199990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.layout.a.g
 * JD-Core Version:    0.7.0.1
 */