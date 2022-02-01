package com.tencent.mm.plugin.card.ui.v3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.HeadFooterLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/ui/v3/CardRefreshLoadMoreLayout;", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onOverScroll", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "parent", "Lcom/tencent/mm/view/HeadFooterLayout;", "dy", "dampingDy", "isEnd", "", "isVertical", "consumed", "", "type", "isTopOverScroll", "onStopScroll", "plugin-card_release"})
public final class CardRefreshLoadMoreLayout
  extends RefreshLoadMoreLayout
{
  public CardRefreshLoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192744);
    AppMethodBeat.o(192744);
  }
  
  public CardRefreshLoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192745);
    AppMethodBeat.o(192745);
  }
  
  public final void a(RecyclerView paramRecyclerView, HeadFooterLayout paramHeadFooterLayout, int paramInt)
  {
    AppMethodBeat.i(192743);
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramHeadFooterLayout, "parent");
    super.a(paramRecyclerView, paramHeadFooterLayout, paramInt);
    if (paramInt == 0)
    {
      if ((super.xi(true)) && (this.isRefreshing) && (this.HXe))
      {
        paramRecyclerView.kl();
        RefreshLoadMoreLayout.j(this);
        AppMethodBeat.o(192743);
      }
    }
    else if ((paramInt == 1) && (s(paramRecyclerView)) && (this.isRefreshing) && (this.HXe))
    {
      paramRecyclerView.kl();
      RefreshLoadMoreLayout.j(this);
    }
    AppMethodBeat.o(192743);
  }
  
  public final void a(RecyclerView paramRecyclerView, HeadFooterLayout paramHeadFooterLayout, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt, int paramInt3, boolean paramBoolean3)
  {
    AppMethodBeat.i(192742);
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramHeadFooterLayout, "parent");
    k.h(paramArrayOfInt, "consumed");
    if ((paramInt3 == 1) && (s(paramRecyclerView)) && (this.isRefreshing)) {
      paramRecyclerView.kl();
    }
    super.a(paramRecyclerView, paramHeadFooterLayout, paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramArrayOfInt, paramInt3, paramBoolean3);
    AppMethodBeat.o(192742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CardRefreshLoadMoreLayout
 * JD-Core Version:    0.7.0.1
 */