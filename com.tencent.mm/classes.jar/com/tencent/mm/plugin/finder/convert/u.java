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
import com.tencent.mm.plugin.finder.feed.x.b;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTipConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedTip;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;I)V", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1;", "stickItemView", "Landroid/view/View;", "getLayoutId", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "Companion", "plugin-finder_release"})
public final class u
  extends com.tencent.mm.view.recyclerview.b<r>
{
  private static boolean[] rbK;
  private static Integer[] rbL;
  public static final a rbM;
  private final int diw;
  private View rbH;
  private final c rbI;
  private final x.b rbJ;
  
  static
  {
    AppMethodBeat.i(165430);
    rbM = new a((byte)0);
    rbK = new boolean[2];
    rbL = new Integer[] { Integer.valueOf(-2), Integer.valueOf(-2) };
    AppMethodBeat.o(165430);
  }
  
  public u(x.b paramb, int paramInt)
  {
    AppMethodBeat.i(201321);
    this.rbJ = paramb;
    this.diw = paramInt;
    this.rbI = new c(this);
    AppMethodBeat.o(201321);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(178135);
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    paramRecyclerView.b((RecyclerView.m)this.rbI);
    paramRecyclerView.a((RecyclerView.m)this.rbI);
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$Companion;", "", "()V", "TAG", "", "floatModeSet", "", "getFloatModeSet", "()[Z", "setFloatModeSet", "([Z)V", "floatPositionSet", "", "", "getFloatPositionSet", "()[Ljava/lang/Integer;", "setFloatPositionSet", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "changeToDecorView", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "parent", "Landroid/view/ViewGroup;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "isHard", "", "tabType", "changeToItemView", "stickView", "Landroid/view/View;", "clickRefreshTipView", "isFloat", "getIndex", "type", "isFloatMode", "plugin-finder_release"})
  public static final class a
  {
    public static void a(View paramView, x.b paramb, int paramInt)
    {
      AppMethodBeat.i(201316);
      k.h(paramb, "viewCallback");
      if (u.csY()[getIndex(paramInt)] == 0)
      {
        AppMethodBeat.o(201316);
        return;
      }
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      paramView = paramb.getRootView().findViewById(2131300074);
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      u.csY()[getIndex(paramInt)] = 0;
      AppMethodBeat.o(201316);
    }
    
    public static void a(x.b paramb, ViewGroup paramViewGroup, final RecyclerView paramRecyclerView, boolean paramBoolean, final int paramInt)
    {
      AppMethodBeat.i(201315);
      k.h(paramb, "viewCallback");
      k.h(paramViewGroup, "parent");
      k.h(paramRecyclerView, "recyclerView");
      if ((u.csY()[getIndex(paramInt)] != 0) && (!paramBoolean))
      {
        AppMethodBeat.o(201315);
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
        paramb.topMargin = d.h.a.cj(paramRecyclerView.getResources().getDimension(2131165289));
        paramb.gravity = 8388659;
        paramViewGroup.addView(localView1, (ViewGroup.LayoutParams)paramb);
        localView1.setVisibility(0);
        u.csY()[getIndex(paramInt)] = 1;
        AppMethodBeat.o(201315);
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
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(x.b paramb, View paramView, RecyclerView paramRecyclerView, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(178127);
        paramView = u.rbM;
        u.a.a(this.rbN, 1, localView3, paramRecyclerView, paramInt);
        AppMethodBeat.o(178127);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(u paramu, View paramView, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165426);
      paramView = u.rbM;
      paramView = u.a(this.rbQ);
      View localView = this.rbO;
      RecyclerView localRecyclerView = this.ojH.getRecyclerView();
      k.g(localRecyclerView, "holder.recyclerView");
      u.a.a(paramView, 0, localView, localRecyclerView, u.b(this.rbQ));
      AppMethodBeat.o(165426);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "recyclerViewValue", "", "getRecyclerViewValue", "()[I", "value", "getValue", "check", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onScrolled", "dx", "", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.m
  {
    private final int[] rbE;
    private final int[] value;
    
    c()
    {
      AppMethodBeat.i(201319);
      this.value = new int[2];
      this.rbE = new int[2];
      AppMethodBeat.o(201319);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201318);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bb(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).lS(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).lS(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aeE());
      k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      localObject1 = u.rbM;
      localObject1 = u.csZ();
      Object localObject2 = u.rbM;
      paramInt1 = localObject1[u.a.getIndex(u.b(this.rbQ))].intValue();
      float f;
      if (paramInt1 > -2)
      {
        localObject1 = paramRecyclerView.getLayoutManager();
        if (localObject1 == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(201318);
          throw paramRecyclerView;
        }
        paramInt2 = ((LinearLayoutManager)localObject1).jW();
        localObject1 = paramRecyclerView.getAdapter();
        if (localObject1 == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
          AppMethodBeat.o(201318);
          throw paramRecyclerView;
        }
        int i = ((WxRecyclerAdapter)localObject1).JCb.size() + paramInt1;
        if (paramInt2 != i) {
          break label441;
        }
        localObject1 = paramRecyclerView.ci(i);
        if (localObject1 == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
          AppMethodBeat.o(201318);
          throw paramRecyclerView;
        }
        localObject1 = (e)localObject1;
        ((e)localObject1).asD.getLocationInWindow(this.value);
        paramRecyclerView.getLocationInWindow(this.rbE);
        localObject2 = ((e)localObject1).asD;
        k.g(localObject2, "holder.itemView");
        localObject2 = ((View)localObject2).getContext();
        k.g(localObject2, "holder.itemView.context");
        f = ((Context)localObject2).getResources().getDimension(2131165292);
        if (this.rbE[1] - this.value[1] <= f) {
          break label390;
        }
        localObject1 = u.rbM;
        localObject1 = u.a(this.rbQ);
        localObject2 = u.a(this.rbQ).getRootView();
        if (localObject2 == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(201318);
          throw paramRecyclerView;
        }
        u.a.a((x.b)localObject1, (ViewGroup)localObject2, paramRecyclerView, false, u.b(this.rbQ));
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(201318);
        return;
        label390:
        if (this.rbE[1] - this.value[1] <= f)
        {
          paramRecyclerView = u.rbM;
          u.a.a(((e)localObject1).adJ(2131304476), u.a(this.rbQ), u.b(this.rbQ));
          continue;
          label441:
          if (paramInt1 > paramInt2)
          {
            paramRecyclerView = u.rbM;
            u.a.a(u.c(this.rbQ), u.a(this.rbQ), u.b(this.rbQ));
          }
        }
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(201320);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(201320);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.u
 * JD-Core Version:    0.7.0.1
 */