package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.model.h;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "()V", "rect", "Landroid/graphics/Rect;", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1;", "view", "Landroid/view/View;", "getLayoutId", "", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "Companion", "plugin-finder_release"})
public final class s
  extends com.tencent.mm.view.recyclerview.b<h>
{
  public static final s.a rWH;
  private final c rWG;
  private final Rect rect;
  private View view;
  
  static
  {
    AppMethodBeat.i(165417);
    rWH = new s.a((byte)0);
    AppMethodBeat.o(165417);
  }
  
  public s()
  {
    AppMethodBeat.i(201831);
    this.rect = new Rect();
    this.rWG = new c(this);
    AppMethodBeat.o(201831);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(201830);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    paramRecyclerView.b((RecyclerView.m)this.rWG);
    paramRecyclerView.a((RecyclerView.m)this.rWG);
    AppMethodBeat.o(201830);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(165415);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    Object localObject = parame.auu;
    p.g(localObject, "holder.itemView");
    localObject = ((View)localObject).getLayoutParams();
    if ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)localObject).aE(true);
    }
    parame.auu.setOnClickListener((View.OnClickListener)new b(paramRecyclerView));
    AppMethodBeat.o(165415);
  }
  
  public final int getLayoutId()
  {
    return 2131492869;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(RecyclerView paramRecyclerView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165414);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = new Intent();
      localObject = v.aAK();
      p.g(localObject, "ConfigStorageLogic.getMyFinderUsername()");
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        localObject = g.yxI;
        if (i == 0) {
          break label182;
        }
      }
      label182:
      for (int i = 1;; i = 2)
      {
        ((g)localObject).f(20971, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(2) });
        localObject = FinderReporterUIC.tnG;
        localObject = this.rWI.getContext();
        p.g(localObject, "recyclerView.context");
        FinderReporterUIC.a.a((Context)localObject, paramView, 0L, 0, false, 124);
        localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
        localObject = this.rWI.getContext();
        p.g(localObject, "recyclerView.context");
        com.tencent.mm.plugin.finder.utils.a.A((Context)localObject, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(165414);
        return;
        i = 0;
        break;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201829);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt1);
      localb.mu(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(201829);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(201828);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      if (paramInt == 0) {
        paramRecyclerView.post((Runnable)new a(this));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(201828);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(s.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(201827);
        Object localObject = s.a(this.rWK.rWJ);
        if (localObject != null)
        {
          if ((((View)localObject).getGlobalVisibleRect(s.b(this.rWK.rWJ))) && (s.b(this.rWK.rWJ).height() >= ((View)localObject).getHeight()) && (((View)localObject).getHeight() > 0))
          {
            localObject = v.aAK();
            p.g(localObject, "ConfigStorageLogic.getMyFinderUsername()");
            if (((CharSequence)localObject).length() <= 0) {
              break label136;
            }
            i = 1;
            localObject = g.yxI;
            if (i == 0) {
              break label141;
            }
          }
          label136:
          label141:
          for (int i = 1;; i = 2)
          {
            ((g)localObject).f(20971, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(2) });
            AppMethodBeat.o(201827);
            return;
            i = 0;
            break;
          }
        }
        AppMethodBeat.o(201827);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.s
 * JD-Core Version:    0.7.0.1
 */