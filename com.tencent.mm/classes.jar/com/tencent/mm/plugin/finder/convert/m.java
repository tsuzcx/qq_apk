package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.model.g;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "onClickRefresh", "Lkotlin/Function0;", "", "onClickPermission", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class m
  extends e<g>
{
  public static final a tBu;
  private final kotlin.g.a.a<x> tBs;
  private final kotlin.g.a.a<x> tBt;
  
  static
  {
    AppMethodBeat.i(165390);
    tBu = new a((byte)0);
    AppMethodBeat.o(165390);
  }
  
  public m(kotlin.g.a.a<x> parama1, kotlin.g.a.a<x> parama2)
  {
    this.tBs = parama1;
    this.tBt = parama2;
  }
  
  public final void a(RecyclerView paramRecyclerView, final h paramh, int paramInt)
  {
    AppMethodBeat.i(165387);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramh.aus.setOnClickListener((View.OnClickListener)new f(this, paramh));
    AppMethodBeat.o(165387);
  }
  
  public final int getLayoutId()
  {
    return 2131494649;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(m paramm) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242868);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = m.b(this.tBv);
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242868);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(h paramh)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(m paramm, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165386);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = (g)paramh.hgv();
      if ((paramView != null) && (paramView.type == -1))
      {
        paramView = paramh.Mn(2131309181);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = paramh.Mn(2131306287);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = m.a(this.tBv);
        if (paramView != null) {
          paramView.invoke();
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.m
 * JD-Core Version:    0.7.0.1
 */