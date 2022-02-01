package com.tencent.mm.plugin.card.ui.v3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.HeadFooterLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v3/CardRefreshLoadMoreLayout;", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onOverScroll", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "parent", "Lcom/tencent/mm/view/HeadFooterLayout;", "dy", "dampingDy", "isEnd", "", "isVertical", "consumed", "", "type", "isTopOverScroll", "onStopScroll", "plugin-card_release"})
public final class CardRefreshLoadMoreLayout
  extends RefreshLoadMoreLayout
{
  public CardRefreshLoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(201484);
    AppMethodBeat.o(201484);
  }
  
  public CardRefreshLoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(201485);
    AppMethodBeat.o(201485);
  }
  
  public final void a(RecyclerView paramRecyclerView, HeadFooterLayout paramHeadFooterLayout, int paramInt)
  {
    AppMethodBeat.i(201483);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramHeadFooterLayout, "parent");
    super.a(paramRecyclerView, paramHeadFooterLayout, paramInt);
    if (paramInt == 0)
    {
      if ((RefreshLoadMoreLayout.a(this, false, null, 3)) && (this.isRefreshing) && (this.RlW))
      {
        paramRecyclerView.kQ();
        RefreshLoadMoreLayout.a(this);
        AppMethodBeat.o(201483);
      }
    }
    else if ((paramInt == 1) && (w(paramRecyclerView)) && (this.isRefreshing) && (this.RlW))
    {
      paramRecyclerView.kQ();
      RefreshLoadMoreLayout.a(this);
    }
    AppMethodBeat.o(201483);
  }
  
  public final void a(RecyclerView paramRecyclerView, HeadFooterLayout paramHeadFooterLayout, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt, int paramInt3, boolean paramBoolean3)
  {
    AppMethodBeat.i(201482);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramHeadFooterLayout, "parent");
    p.h(paramArrayOfInt, "consumed");
    if ((paramInt3 == 1) && (w(paramRecyclerView)) && (this.isRefreshing)) {
      paramRecyclerView.kQ();
    }
    super.a(paramRecyclerView, paramHeadFooterLayout, paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramArrayOfInt, paramInt3, paramBoolean3);
    AppMethodBeat.o(201482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CardRefreshLoadMoreLayout
 * JD-Core Version:    0.7.0.1
 */