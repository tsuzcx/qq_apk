package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.i;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "()V", "rect", "Landroid/graphics/Rect;", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1;", "view", "Landroid/view/View;", "getLayoutId", "", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "Companion", "plugin-finder_release"})
public final class ag
  extends e<i>
{
  public static final a tDI;
  private final Rect rect;
  private final c tDH;
  private View view;
  
  static
  {
    AppMethodBeat.i(165417);
    tDI = new a((byte)0);
    AppMethodBeat.o(165417);
  }
  
  public ag()
  {
    AppMethodBeat.i(243096);
    this.rect = new Rect();
    this.tDH = new c(this);
    AppMethodBeat.o(243096);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(243095);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    paramRecyclerView.b((RecyclerView.l)this.tDH);
    paramRecyclerView.a((RecyclerView.l)this.tDH);
    AppMethodBeat.o(243095);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.h paramh, int paramInt)
  {
    AppMethodBeat.i(165415);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    Object localObject = paramh.aus;
    p.g(localObject, "holder.itemView");
    localObject = ((View)localObject).getLayoutParams();
    if ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)localObject).aC(true);
    }
    paramh.aus.setOnClickListener((View.OnClickListener)new b(paramRecyclerView));
    AppMethodBeat.o(165415);
  }
  
  public final int getLayoutId()
  {
    return 2131492875;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(RecyclerView paramRecyclerView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165414);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = new Intent();
      localObject = FinderReporterUIC.wzC;
      localObject = this.tDJ.getContext();
      p.g(localObject, "recyclerView.context");
      FinderReporterUIC.a.a((Context)localObject, paramView, 0L, 0, false, 124);
      localObject = c.vCb;
      if (((Number)c.dwL().value()).intValue() == 1)
      {
        localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
        localObject = this.tDJ.getContext();
        p.g(localObject, "recyclerView.context");
        com.tencent.mm.plugin.finder.utils.a.D((Context)localObject, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(165414);
        return;
      }
      localObject = z.aUg();
      p.g(localObject, "ConfigStorageLogic.getMyFinderUsername()");
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        label155:
        localObject = com.tencent.mm.plugin.report.service.h.CyF;
        if (i == 0) {
          break label228;
        }
      }
      label228:
      for (int i = 1;; i = 2)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).a(20971, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(2) });
        localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
        localObject = this.tDJ.getContext();
        p.g(localObject, "recyclerView.context");
        com.tencent.mm.plugin.finder.utils.a.C((Context)localObject, paramView);
        break;
        i = 0;
        break label155;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(243093);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      localObject = new z.a();
      ((z.a)localObject).SYB = false;
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0) {
        paramRecyclerView.post((Runnable)new a(this, (z.a)localObject));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(243093);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243094);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(243094);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ag.c paramc, z.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(243092);
        Object localObject = ag.a(this.tDL.tDK);
        if (localObject != null)
        {
          if ((!this.tDM.SYB) && (((View)localObject).getGlobalVisibleRect(ag.b(this.tDL.tDK))) && (ag.b(this.tDL.tDK).height() >= ((View)localObject).getHeight()) && (((View)localObject).getHeight() > 0))
          {
            localObject = z.aUg();
            p.g(localObject, "ConfigStorageLogic.getMyFinderUsername()");
            if (((CharSequence)localObject).length() > 0)
            {
              i = 1;
              localObject = com.tencent.mm.plugin.report.service.h.CyF;
              if (i == 0) {
                break label159;
              }
            }
            label159:
            for (int i = 1;; i = 2)
            {
              ((com.tencent.mm.plugin.report.service.h)localObject).a(20971, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(2) });
              this.tDM.SYB = true;
              AppMethodBeat.o(243092);
              return;
              i = 0;
              break;
            }
          }
          this.tDM.SYB = false;
          AppMethodBeat.o(243092);
          return;
        }
        AppMethodBeat.o(243092);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ag
 * JD-Core Version:    0.7.0.1
 */