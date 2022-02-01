package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.i;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "()V", "rect", "Landroid/graphics/Rect;", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1;", "view", "Landroid/view/View;", "getLayoutId", "", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  extends f<i>
{
  public static final a AKC;
  private final b AKD;
  private final Rect rect;
  private View view;
  
  static
  {
    AppMethodBeat.i(165417);
    AKC = new a((byte)0);
    AppMethodBeat.o(165417);
  }
  
  public ae()
  {
    AppMethodBeat.i(350102);
    this.rect = new Rect();
    this.AKD = new b(this);
    AppMethodBeat.o(350102);
  }
  
  private static final void a(RecyclerView paramRecyclerView, View paramView)
  {
    AppMethodBeat.i(350121);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRecyclerView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRecyclerView, "$recyclerView");
    paramView = new Intent();
    localObject = as.GSQ;
    localObject = paramRecyclerView.getContext();
    s.s(localObject, "recyclerView.context");
    as.a.a((Context)localObject, paramView, 0L, 0, false, 124);
    localObject = d.FAy;
    if (((Number)d.eVC().bmg()).intValue() == 1)
    {
      localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramRecyclerView = paramRecyclerView.getContext();
      s.s(paramRecyclerView, "recyclerView.context");
      com.tencent.mm.plugin.finder.utils.a.W(paramRecyclerView, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350121);
      return;
    }
    localObject = z.bAW();
    s.s(localObject, "getMyFinderUsername()");
    if (((CharSequence)localObject).length() > 0)
    {
      i = 1;
      label178:
      localObject = h.OAn;
      if (i == 0) {
        break label248;
      }
    }
    label248:
    for (int i = 1;; i = 2)
    {
      ((h)localObject).b(20971, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(2) });
      localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramRecyclerView = paramRecyclerView.getContext();
      s.s(paramRecyclerView, "recyclerView.context");
      com.tencent.mm.plugin.finder.utils.a.V(paramRecyclerView, paramView);
      break;
      i = 0;
      break label178;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(350172);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    paramRecyclerView.b((RecyclerView.l)this.AKD);
    paramRecyclerView.a((RecyclerView.l)this.AKD);
    AppMethodBeat.o(350172);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350177);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    ViewGroup.LayoutParams localLayoutParams = paramj.caK.getLayoutParams();
    if ((localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)localLayoutParams).cbB = true;
    }
    paramj.caK.setOnClickListener(new ae..ExternalSyntheticLambda0(paramRecyclerView));
    AppMethodBeat.o(350177);
  }
  
  public final int getLayoutId()
  {
    return e.f._feed_header_search_item;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.l
  {
    b(ae paramae) {}
    
    private static final void a(ae paramae, ah.a parama)
    {
      AppMethodBeat.i(350565);
      s.u(paramae, "this$0");
      s.u(parama, "$isExposed");
      View localView = ae.b(paramae);
      if (localView != null)
      {
        if ((!parama.aiwY) && (localView.getGlobalVisibleRect(ae.a(paramae))) && (ae.a(paramae).height() >= localView.getHeight()) && (localView.getHeight() > 0))
        {
          paramae = z.bAW();
          s.s(paramae, "getMyFinderUsername()");
          if (((CharSequence)paramae).length() > 0)
          {
            i = 1;
            paramae = h.OAn;
            if (i == 0) {
              break label147;
            }
          }
          label147:
          for (int i = 1;; i = 2)
          {
            paramae.b(20971, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(2) });
            parama.aiwY = true;
            AppMethodBeat.o(350565);
            return;
            i = 0;
            break;
          }
        }
        parama.aiwY = false;
      }
      AppMethodBeat.o(350565);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(350582);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      s.u(paramRecyclerView, "recyclerView");
      localObject = new ah.a();
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0) {
        paramRecyclerView.post(new ae.b..ExternalSyntheticLambda0(this.AKE, (ah.a)localObject));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(350582);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(350589);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedSearchConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(350589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ae
 * JD-Core Version:    0.7.0.1
 */