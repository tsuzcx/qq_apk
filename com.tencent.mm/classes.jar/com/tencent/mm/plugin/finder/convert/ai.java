package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "()V", "rect", "Landroid/graphics/Rect;", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1;", "view", "Landroid/view/View;", "getLayoutId", "", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "Companion", "plugin-finder_release"})
public final class ai
  extends e<com.tencent.mm.plugin.finder.model.i>
{
  public static final a xmj;
  private final Rect byG;
  private View view;
  private final c xmi;
  
  static
  {
    AppMethodBeat.i(165417);
    xmj = new a((byte)0);
    AppMethodBeat.o(165417);
  }
  
  public ai()
  {
    AppMethodBeat.i(290112);
    this.byG = new Rect();
    this.xmi = new c(this);
    AppMethodBeat.o(290112);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(290110);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    paramRecyclerView.b((RecyclerView.l)this.xmi);
    paramRecyclerView.a((RecyclerView.l)this.xmi);
    AppMethodBeat.o(290110);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(290111);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    Object localObject = parami.amk;
    p.j(localObject, "holder.itemView");
    localObject = ((View)localObject).getLayoutParams();
    if ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)localObject).aA(true);
    }
    parami.amk.setOnClickListener((View.OnClickListener)new b(paramRecyclerView));
    AppMethodBeat.o(290111);
  }
  
  public final int getLayoutId()
  {
    return b.g._feed_header_search_item;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(RecyclerView paramRecyclerView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165414);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = new Intent();
      localObject = aj.Bnu;
      localObject = this.xmk.getContext();
      p.j(localObject, "recyclerView.context");
      aj.a.a((Context)localObject, paramView, 0L, 0, false, 124);
      localObject = d.AjH;
      if (((Number)d.dWR().aSr()).intValue() == 1)
      {
        localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
        localObject = this.xmk.getContext();
        p.j(localObject, "recyclerView.context");
        com.tencent.mm.plugin.finder.utils.a.C((Context)localObject, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(165414);
        return;
      }
      localObject = z.bdh();
      p.j(localObject, "ConfigStorageLogic.getMyFinderUsername()");
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        label155:
        localObject = h.IzE;
        if (i == 0) {
          break label228;
        }
      }
      label228:
      for (int i = 1;; i = 2)
      {
        ((h)localObject).a(20971, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(2) });
        localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
        localObject = this.xmk.getContext();
        p.j(localObject, "recyclerView.context");
        com.tencent.mm.plugin.finder.utils.a.B((Context)localObject, paramView);
        break;
        i = 0;
        break label155;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(285344);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      localObject = new aa.a();
      ((aa.a)localObject).aaBx = false;
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0) {
        paramRecyclerView.post((Runnable)new a(this, (aa.a)localObject));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(285344);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(285345);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(285345);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ai.c paramc, aa.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(275973);
        Object localObject = ai.a(this.xmn.xmm);
        if (localObject != null)
        {
          if ((!this.xmo.aaBx) && (((View)localObject).getGlobalVisibleRect(ai.b(this.xmn.xmm))) && (ai.b(this.xmn.xmm).height() >= ((View)localObject).getHeight()) && (((View)localObject).getHeight() > 0))
          {
            localObject = z.bdh();
            p.j(localObject, "ConfigStorageLogic.getMyFinderUsername()");
            if (((CharSequence)localObject).length() > 0)
            {
              i = 1;
              localObject = h.IzE;
              if (i == 0) {
                break label159;
              }
            }
            label159:
            for (int i = 1;; i = 2)
            {
              ((h)localObject).a(20971, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(2) });
              this.xmo.aaBx = true;
              AppMethodBeat.o(275973);
              return;
              i = 0;
              break;
            }
          }
          this.xmo.aaBx = false;
          AppMethodBeat.o(275973);
          return;
        }
        AppMethodBeat.o(275973);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ai
 * JD-Core Version:    0.7.0.1
 */