package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.b;
import d.g.a.a;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "onClickRefresh", "Lkotlin/Function0;", "", "onClickPermission", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class h
  extends b<com.tencent.mm.plugin.finder.model.e>
{
  public static final h.a rbh;
  private final a<y> rbf;
  private final a<y> rbg;
  
  static
  {
    AppMethodBeat.i(165390);
    rbh = new h.a((byte)0);
    AppMethodBeat.o(165390);
  }
  
  public h(a<y> parama1, a<y> parama2)
  {
    this.rbf = parama1;
    this.rbg = parama2;
  }
  
  public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    AppMethodBeat.i(165387);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    parame.asD.setOnClickListener((View.OnClickListener)new d(this, parame));
    AppMethodBeat.o(165387);
  }
  
  public final int getLayoutId()
  {
    return 2131494116;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<y>
  {
    c(com.tencent.mm.view.recyclerview.e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(h paramh, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165386);
      paramView = (com.tencent.mm.plugin.finder.model.e)parame.fzs();
      if (paramView != null)
      {
        if (paramView.type == -1)
        {
          paramView = parame.adJ(2131308031);
          if (paramView != null) {
            paramView.setVisibility(8);
          }
          paramView = parame.adJ(2131303521);
          if (paramView != null) {
            paramView.setVisibility(0);
          }
          paramView = h.a(this.rbi);
          if (paramView != null)
          {
            paramView.invoke();
            AppMethodBeat.o(165386);
          }
        }
      }
      else
      {
        AppMethodBeat.o(165386);
        return;
      }
      AppMethodBeat.o(165386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h
 * JD-Core Version:    0.7.0.1
 */