package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.i.b;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTipConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedTip;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;I)V", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1;", "stickItemView", "Landroid/view/View;", "getLayoutId", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "Companion", "plugin-finder_release"})
public final class q
  extends com.tencent.mm.view.recyclerview.b<m>
{
  private static boolean[] KLg;
  private static Integer[] KLh;
  public static final a qrB;
  private final int IoU;
  private final b KLf;
  private View qry;
  private final i.b qrz;
  
  static
  {
    AppMethodBeat.i(165430);
    qrB = new a((byte)0);
    KLg = new boolean[2];
    KLh = new Integer[] { Integer.valueOf(-2), Integer.valueOf(-2) };
    AppMethodBeat.o(165430);
  }
  
  public q(i.b paramb, int paramInt)
  {
    AppMethodBeat.i(197446);
    this.qrz = paramb;
    this.IoU = paramInt;
    this.KLf = new b(this);
    AppMethodBeat.o(197446);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(178135);
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    paramRecyclerView.b((RecyclerView.m)this.KLf);
    paramRecyclerView.a((RecyclerView.m)this.KLf);
    AppMethodBeat.o(178135);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(165427);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    AppMethodBeat.o(165427);
  }
  
  public final int getLayoutId()
  {
    return 2131492873;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$Companion;", "", "()V", "TAG", "", "floatModeSet", "", "getFloatModeSet", "()[Z", "setFloatModeSet", "([Z)V", "floatPositionSet", "", "", "getFloatPositionSet", "()[Ljava/lang/Integer;", "setFloatPositionSet", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "changeToDecorView", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "parent", "Landroid/view/ViewGroup;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "isHard", "", "tabType", "changeToItemView", "stickView", "Landroid/view/View;", "clickRefreshTipView", "isFloat", "getIndex", "type", "isFloatMode", "plugin-finder_release"})
  public static final class a
  {
    public static void a(View paramView, i.b paramb, int paramInt)
    {
      AppMethodBeat.i(197441);
      k.h(paramb, "viewCallback");
      if (q.fSi()[getIndex(paramInt)] == 0)
      {
        AppMethodBeat.o(197441);
        return;
      }
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      paramView = paramb.getRootView().findViewById(2131300074);
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      q.fSi()[getIndex(paramInt)] = 0;
      AppMethodBeat.o(197441);
    }
    
    public static void a(i.b paramb, ViewGroup paramViewGroup, final RecyclerView paramRecyclerView, boolean paramBoolean, final int paramInt)
    {
      AppMethodBeat.i(197440);
      k.h(paramb, "viewCallback");
      k.h(paramViewGroup, "parent");
      k.h(paramRecyclerView, "recyclerView");
      if ((q.fSi()[getIndex(paramInt)] != 0) && (!paramBoolean))
      {
        AppMethodBeat.o(197440);
        return;
      }
      final View localView3 = paramRecyclerView.findViewById(2131304476);
      if (localView3 != null) {
        localView3.setVisibility(8);
      }
      View localView2 = paramViewGroup.findViewById(2131300074);
      View localView1 = localView2;
      int i;
      if (localView2 == null)
      {
        localView1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494114, null, false);
        k.g(localView1, "stickFloatView");
        localView1.setId(2131300074);
        localView1.setElevation(ao.fromDPToPix(paramViewGroup.getContext(), 1));
        localView1.setOnClickListener((View.OnClickListener)new a(paramb, localView3, paramRecyclerView, paramInt));
        if (localView3 == null) {
          break label301;
        }
        i = localView3.getWidth();
        if (localView3 == null) {
          break label316;
        }
      }
      for (int j = localView3.getHeight();; j = (int)paramb.getResources().getDimension(2131165294))
      {
        paramb = paramViewGroup.getContext();
        k.g(paramb, "parent.context");
        paramb = paramb.getResources();
        k.g(paramb, "parent.context.resources");
        int k = paramb.getDisplayMetrics().widthPixels / 2;
        int m = i / 2;
        paramb = new FrameLayout.LayoutParams(i, j);
        paramb.leftMargin = (k - m);
        paramRecyclerView = paramViewGroup.getContext();
        k.g(paramRecyclerView, "parent.context");
        paramb.topMargin = d.h.a.bU(paramRecyclerView.getResources().getDimension(2131165289));
        paramb.gravity = 8388659;
        paramViewGroup.addView(localView1, (ViewGroup.LayoutParams)paramb);
        localView1.setVisibility(0);
        q.fSi()[getIndex(paramInt)] = 1;
        AppMethodBeat.o(197440);
        return;
        label301:
        i = ao.fromDPToPix(paramViewGroup.getContext(), 136);
        break;
        label316:
        paramb = paramViewGroup.getContext();
        k.g(paramb, "parent.context");
      }
    }
    
    public static int getIndex(int paramInt)
    {
      switch (paramInt)
      {
      case 2: 
      case 3: 
      default: 
        return 0;
      }
      return 1;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(i.b paramb, View paramView, RecyclerView paramRecyclerView, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(178127);
        paramView = q.qrB;
        q.a.a(this.qrC, 1, localView3, paramRecyclerView, paramInt);
        AppMethodBeat.o(178127);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "recyclerViewValue", "", "getRecyclerViewValue", "()[I", "value", "getValue", "check", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onScrolled", "dx", "", "dy", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.m
  {
    private final int[] KLd;
    private final int[] value;
    
    b()
    {
      AppMethodBeat.i(197444);
      this.value = new int[2];
      this.KLd = new int[2];
      AppMethodBeat.o(197444);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197443);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).be(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).lT(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).lT(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ado());
      k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      localObject1 = q.qrB;
      localObject1 = q.fSj();
      Object localObject2 = q.qrB;
      paramInt1 = localObject1[q.a.getIndex(q.a(this.qrF))].intValue();
      float f;
      if (paramInt1 > -2)
      {
        localObject1 = paramRecyclerView.getLayoutManager();
        if (localObject1 == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(197443);
          throw paramRecyclerView;
        }
        paramInt2 = ((LinearLayoutManager)localObject1).jO();
        localObject1 = paramRecyclerView.getAdapter();
        if (localObject1 == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
          AppMethodBeat.o(197443);
          throw paramRecyclerView;
        }
        int i = ((WxRecyclerAdapter)localObject1).Ibl.size() + paramInt1;
        if (paramInt2 != i) {
          break label441;
        }
        localObject1 = paramRecyclerView.cj(i);
        if (localObject1 == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
          AppMethodBeat.o(197443);
          throw paramRecyclerView;
        }
        localObject1 = (e)localObject1;
        ((e)localObject1).arI.getLocationInWindow(this.value);
        paramRecyclerView.getLocationInWindow(this.KLd);
        localObject2 = ((e)localObject1).arI;
        k.g(localObject2, "holder.itemView");
        localObject2 = ((View)localObject2).getContext();
        k.g(localObject2, "holder.itemView.context");
        f = ((Context)localObject2).getResources().getDimension(2131165292);
        if (this.KLd[1] - this.value[1] <= f) {
          break label390;
        }
        localObject1 = q.qrB;
        localObject1 = q.b(this.qrF);
        localObject2 = q.b(this.qrF).getRootView();
        if (localObject2 == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(197443);
          throw paramRecyclerView;
        }
        q.a.a((i.b)localObject1, (ViewGroup)localObject2, paramRecyclerView, false, q.a(this.qrF));
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(197443);
        return;
        label390:
        if (this.KLd[1] - this.value[1] <= f)
        {
          paramRecyclerView = q.qrB;
          q.a.a(((e)localObject1).abq(2131304476), q.b(this.qrF), q.a(this.qrF));
          continue;
          label441:
          if (paramInt1 > paramInt2)
          {
            paramRecyclerView = q.qrB;
            q.a.a(q.c(this.qrF), q.b(this.qrF), q.a(this.qrF));
          }
        }
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(197445);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(197445);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(q paramq, View paramView, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165426);
      paramView = q.qrB;
      paramView = q.b(this.qrF);
      View localView = this.qrD;
      RecyclerView localRecyclerView = this.nGG.getRecyclerView();
      k.g(localRecyclerView, "holder.recyclerView");
      q.a.a(paramView, 0, localView, localRecyclerView, q.a(this.qrF));
      AppMethodBeat.o(165426);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.q
 * JD-Core Version:    0.7.0.1
 */