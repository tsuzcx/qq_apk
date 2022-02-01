package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.g;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "onClickRefresh", "Lkotlin/Function0;", "", "onClickPermission", "forceEnableNightMode", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Z)V", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class n
  extends e<g>
{
  public static final a xjg;
  private final kotlin.g.a.a<x> xjd;
  private final kotlin.g.a.a<x> xje;
  private final boolean xjf;
  
  static
  {
    AppMethodBeat.i(165390);
    xjg = new a((byte)0);
    AppMethodBeat.o(165390);
  }
  
  public n(kotlin.g.a.a<x> parama1, kotlin.g.a.a<x> parama2, boolean paramBoolean)
  {
    this.xjd = parama1;
    this.xje = parama2;
    this.xjf = paramBoolean;
  }
  
  public final void a(RecyclerView paramRecyclerView, final i parami, int paramInt)
  {
    AppMethodBeat.i(277525);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    parami.amk.setOnClickListener((View.OnClickListener)new f(this, parami));
    AppMethodBeat.o(277525);
  }
  
  public final int getLayoutId()
  {
    if (this.xjf) {
      return b.g.finder_timeline_empty_view_night_mode;
    }
    return b.g.finder_timeline_empty_view;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(n paramn, i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165386);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = (g)parami.ihX();
      if ((paramView != null) && (paramView.type == -1))
      {
        paramView = parami.RD(b.f.tips_layout);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = parami.RD(b.f.progress_convert);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = n.a(this.xjh);
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
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.n
 * JD-Core Version:    0.7.0.1
 */