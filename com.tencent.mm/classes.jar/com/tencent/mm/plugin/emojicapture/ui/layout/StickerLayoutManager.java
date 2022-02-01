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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "TAG", "", "itemPadding", "itemWidth", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "smoothScrollToPosition", "recyclerView", "updateChild", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StickerLayoutManager
  extends LinearLayoutManager
{
  private final String TAG;
  private final int itemPadding;
  private final int wLI;
  
  public StickerLayoutManager(Context paramContext)
  {
    super(0, false);
    AppMethodBeat.i(889);
    this.TAG = "MicroMsg.StickerLayoutManager";
    this.wLI = paramContext.getResources().getDimensionPixelSize(a.d.yec);
    this.itemPadding = paramContext.getResources().getDimensionPixelSize(a.d.Edge_A);
    AppMethodBeat.o(889);
  }
  
  private final void dDo()
  {
    AppMethodBeat.i(888);
    int i = 0;
    int k = getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      View localView = getChildAt(i);
      if (localView != null)
      {
        i = getPosition(localView);
        int m = (localView.getLeft() + localView.getRight()) / 2;
        int n = getWidth() / 2;
        int i1 = localView.getRight();
        int i2 = localView.getLeft();
        if ((i != getItemCount() - 1) && (Math.abs(m - n) >= (i1 - i2) / 2)) {
          break label123;
        }
        localView.setAlpha(1.0F);
      }
      while (j >= k)
      {
        AppMethodBeat.o(888);
        return;
        label123:
        localView.setAlpha(0.3F);
      }
      i = j;
    }
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(269454);
    s.u(paramn, "recycler");
    s.u(params, "state");
    super.onLayoutChildren(paramn, params);
    dDo();
    AppMethodBeat.o(269454);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(269457);
    s.u(paramn, "recycler");
    s.u(params, "state");
    paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
    dDo();
    AppMethodBeat.o(269457);
    return paramInt;
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(887);
    bo(paramInt, (getWidth() - this.wLI) / 2 - this.itemPadding);
    AppMethodBeat.o(887);
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(269460);
    s.u(paramRecyclerView, "recyclerView");
    s.u(params, "state");
    paramRecyclerView = paramRecyclerView.getContext();
    s.s(paramRecyclerView, "recyclerView.context");
    paramRecyclerView = new a(paramRecyclerView);
    paramRecyclerView.cag = paramInt;
    startSmoothScroll((RecyclerView.r)paramRecyclerView);
    AppMethodBeat.o(269460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.layout.StickerLayoutManager
 * JD-Core Version:    0.7.0.1
 */