package com.tencent.mm.plugin.card.ui.v3;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.HeadFooterLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v3/CardRefreshLoadMoreLayout;", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onOverScroll", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Lcom/tencent/mm/view/HeadFooterLayout;", "dy", "dampingDy", "isEnd", "", "isVertical", "consumed", "", "type", "isTopOverScroll", "onStopScroll", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CardRefreshLoadMoreLayout
  extends RefreshLoadMoreLayout
{
  public CardRefreshLoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(293858);
    AppMethodBeat.o(293858);
  }
  
  public CardRefreshLoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(293863);
    AppMethodBeat.o(293863);
  }
  
  public final void a(RecyclerView paramRecyclerView, HeadFooterLayout paramHeadFooterLayout, int paramInt)
  {
    AppMethodBeat.i(293874);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramHeadFooterLayout, "parent");
    super.a(paramRecyclerView, paramHeadFooterLayout, paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(293874);
      return;
      if ((RefreshLoadMoreLayout.a((RefreshLoadMoreLayout)this, false, null, 3)) && (jME()) && (this.agJf))
      {
        paramRecyclerView.JO();
        RefreshLoadMoreLayout.b((RefreshLoadMoreLayout)this);
        AppMethodBeat.o(293874);
        return;
        if ((N(paramRecyclerView)) && (jME()) && (this.agJf))
        {
          paramRecyclerView.JO();
          RefreshLoadMoreLayout.b((RefreshLoadMoreLayout)this);
        }
      }
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, HeadFooterLayout paramHeadFooterLayout, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt, int paramInt3, boolean paramBoolean3)
  {
    AppMethodBeat.i(293868);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramHeadFooterLayout, "parent");
    s.u(paramArrayOfInt, "consumed");
    if ((paramInt3 == 1) && (N(paramRecyclerView)) && (jME())) {
      paramRecyclerView.JO();
    }
    super.a(paramRecyclerView, paramHeadFooterLayout, paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramArrayOfInt, paramInt3, paramBoolean3);
    AppMethodBeat.o(293868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CardRefreshLoadMoreLayout
 * JD-Core Version:    0.7.0.1
 */