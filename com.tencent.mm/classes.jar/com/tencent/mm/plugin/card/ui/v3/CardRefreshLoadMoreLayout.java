package com.tencent.mm.plugin.card.ui.v3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.HeadFooterLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/ui/v3/CardRefreshLoadMoreLayout;", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onOverScroll", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "parent", "Lcom/tencent/mm/view/HeadFooterLayout;", "dy", "dampingDy", "isEnd", "", "isVertical", "consumed", "", "type", "isTopOverScroll", "onStopScroll", "plugin-card_release"})
public final class CardRefreshLoadMoreLayout
  extends RefreshLoadMoreLayout
{
  public CardRefreshLoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(206318);
    AppMethodBeat.o(206318);
  }
  
  public CardRefreshLoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(206319);
    AppMethodBeat.o(206319);
  }
  
  public final void a(RecyclerView paramRecyclerView, HeadFooterLayout paramHeadFooterLayout, int paramInt)
  {
    AppMethodBeat.i(206317);
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramHeadFooterLayout, "parent");
    super.a(paramRecyclerView, paramHeadFooterLayout, paramInt);
    if (paramInt == 0)
    {
      if ((super.yr(true)) && (this.isRefreshing) && (this.JxO))
      {
        paramRecyclerView.kt();
        RefreshLoadMoreLayout.b(this);
        AppMethodBeat.o(206317);
      }
    }
    else if ((paramInt == 1) && (A(paramRecyclerView)) && (this.isRefreshing) && (this.JxO))
    {
      paramRecyclerView.kt();
      RefreshLoadMoreLayout.b(this);
    }
    AppMethodBeat.o(206317);
  }
  
  public final void a(RecyclerView paramRecyclerView, HeadFooterLayout paramHeadFooterLayout, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt, int paramInt3, boolean paramBoolean3)
  {
    AppMethodBeat.i(206316);
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramHeadFooterLayout, "parent");
    k.h(paramArrayOfInt, "consumed");
    if ((paramInt3 == 1) && (A(paramRecyclerView)) && (this.isRefreshing)) {
      paramRecyclerView.kt();
    }
    super.a(paramRecyclerView, paramHeadFooterLayout, paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramArrayOfInt, paramInt3, paramBoolean3);
    AppMethodBeat.o(206316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CardRefreshLoadMoreLayout
 * JD-Core Version:    0.7.0.1
 */