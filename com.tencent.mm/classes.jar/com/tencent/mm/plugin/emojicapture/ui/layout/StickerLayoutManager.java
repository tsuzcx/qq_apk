package com.tencent.mm.plugin.emojicapture.ui.layout;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.a.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "TAG", "", "itemPadding", "itemWidth", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "smoothScrollToPosition", "recyclerView", "updateChild", "plugin-emojicapture_release"})
public final class StickerLayoutManager
  extends LinearLayoutManager
{
  private final String TAG;
  private final int itemPadding;
  private final int tHY;
  
  public StickerLayoutManager(Context paramContext)
  {
    super(0, false);
    AppMethodBeat.i(889);
    this.TAG = "MicroMsg.StickerLayoutManager";
    this.tHY = paramContext.getResources().getDimensionPixelSize(a.d.uRo);
    this.itemPadding = paramContext.getResources().getDimensionPixelSize(a.d.Edge_A);
    AppMethodBeat.o(889);
  }
  
  private final void cWY()
  {
    AppMethodBeat.i(888);
    int i = 0;
    int j = getChildCount();
    if (i < j)
    {
      View localView = getChildAt(i);
      if (localView == null) {}
      for (;;)
      {
        i += 1;
        break;
        p.j(localView, "getChildAt(i) ?: continue");
        int k = getPosition(localView);
        int m = (localView.getLeft() + localView.getRight()) / 2;
        int n = getWidth() / 2;
        int i1 = localView.getRight();
        int i2 = localView.getLeft();
        if ((k == getItemCount() - 1) || (Math.abs(m - n) < (i1 - i2) / 2)) {
          localView.setAlpha(1.0F);
        } else {
          localView.setAlpha(0.3F);
        }
      }
    }
    AppMethodBeat.o(888);
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(203330);
    p.k(paramn, "recycler");
    p.k(params, "state");
    super.onLayoutChildren(paramn, params);
    cWY();
    AppMethodBeat.o(203330);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(203338);
    p.k(paramn, "recycler");
    p.k(params, "state");
    paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
    cWY();
    AppMethodBeat.o(203338);
    return paramInt;
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(887);
    au(paramInt, (getWidth() - this.tHY) / 2 - this.itemPadding);
    AppMethodBeat.o(887);
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(203343);
    p.k(paramRecyclerView, "recyclerView");
    p.k(params, "state");
    paramRecyclerView = paramRecyclerView.getContext();
    p.j(paramRecyclerView, "recyclerView.context");
    paramRecyclerView = new a(paramRecyclerView);
    paramRecyclerView.cV(paramInt);
    startSmoothScroll((RecyclerView.r)paramRecyclerView);
    AppMethodBeat.o(203343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.layout.StickerLayoutManager
 * JD-Core Version:    0.7.0.1
 */