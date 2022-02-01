package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.f;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "onClickRefresh", "Lkotlin/Function0;", "", "onClickPermission", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class i
  extends com.tencent.mm.view.recyclerview.b<f>
{
  public static final i.a rWj;
  private final d.g.a.a<z> rWh;
  private final d.g.a.a<z> rWi;
  
  static
  {
    AppMethodBeat.i(165390);
    rWj = new i.a((byte)0);
    AppMethodBeat.o(165390);
  }
  
  public i(d.g.a.a<z> parama1, d.g.a.a<z> parama2)
  {
    this.rWh = parama1;
    this.rWi = parama2;
  }
  
  public final void a(RecyclerView paramRecyclerView, final e parame, int paramInt)
  {
    AppMethodBeat.i(165387);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    parame.auu.setOnClickListener((View.OnClickListener)new d(this, parame));
    AppMethodBeat.o(165387);
  }
  
  public final int getLayoutId()
  {
    return 2131494116;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(i parami, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165386);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = (f)parame.fUY();
      if ((paramView != null) && (paramView.type == -1))
      {
        paramView = parame.GD(2131308031);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = parame.GD(2131303521);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = i.a(this.rWk);
        if (paramView != null) {
          paramView.invoke();
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.i
 * JD-Core Version:    0.7.0.1
 */