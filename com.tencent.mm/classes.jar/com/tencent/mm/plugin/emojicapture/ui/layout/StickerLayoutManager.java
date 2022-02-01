package com.tencent.mm.plugin.emojicapture.ui.layout;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "TAG", "", "itemPadding", "itemWidth", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "smoothScrollToPosition", "recyclerView", "updateChild", "plugin-emojicapture_release"})
public final class StickerLayoutManager
  extends LinearLayoutManager
{
  private final String TAG;
  private final int itemPadding;
  private final int oXj;
  
  public StickerLayoutManager(Context paramContext)
  {
    super(0);
    AppMethodBeat.i(889);
    this.TAG = "MicroMsg.StickerLayoutManager";
    this.oXj = paramContext.getResources().getDimensionPixelSize(2131166206);
    this.itemPadding = paramContext.getResources().getDimensionPixelSize(2131165303);
    AppMethodBeat.o(889);
  }
  
  private final void clZ()
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
        p.g(localView, "getChildAt(i) ?: continue");
        int k = bB(localView);
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
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(885);
    p.h(paramo, "recycler");
    p.h(paramt, "state");
    paramInt = super.a(paramInt, paramo, paramt);
    clZ();
    AppMethodBeat.o(885);
    return paramInt;
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.t paramt, int paramInt)
  {
    AppMethodBeat.i(886);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramt, "state");
    paramRecyclerView = paramRecyclerView.getContext();
    p.g(paramRecyclerView, "recyclerView.context");
    paramRecyclerView = new a(paramRecyclerView);
    paramRecyclerView.cz(paramInt);
    a((RecyclerView.s)paramRecyclerView);
    AppMethodBeat.o(886);
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(884);
    p.h(paramo, "recycler");
    p.h(paramt, "state");
    super.c(paramo, paramt);
    clZ();
    AppMethodBeat.o(884);
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(887);
    ag(paramInt, (getWidth() - this.oXj) / 2 - this.itemPadding);
    AppMethodBeat.o(887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.layout.StickerLayoutManager
 * JD-Core Version:    0.7.0.1
 */