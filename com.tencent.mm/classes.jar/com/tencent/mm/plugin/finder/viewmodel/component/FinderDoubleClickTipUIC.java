package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.SimpleUIComponent;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import d.f;
import d.g;
import d.g.b.u;
import d.g.b.w;
import d.v;
import java.util.ArrayList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "maxPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "Lkotlin/Lazy;", "state", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "tabType", "getTabType", "()I", "tabType$delegate", "hideCompleted", "", "onActionbarClick", "isDouble", "", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "showCompleted", "showDoubleClickTip", "isShow", "Companion", "plugin-finder_release"})
public final class FinderDoubleClickTipUIC
  extends UIComponent
{
  private static final int sdy;
  public static final FinderDoubleClickTipUIC.a sdz;
  private final f rZE;
  private final FinderHomeTabStateVM sdv;
  private final f sdw;
  private int sdx;
  
  static
  {
    AppMethodBeat.i(204494);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(FinderDoubleClickTipUIC.class), "recyclerView", "getRecyclerView()Landroid/support/v7/widget/RecyclerView;")), (d.l.k)w.a(new u(w.bn(FinderDoubleClickTipUIC.class), "tabType", "getTabType()I")) };
    sdz = new FinderDoubleClickTipUIC.a((byte)0);
    Object localObject = ai.getContext();
    d.g.b.k.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    d.g.b.k.g(localObject, "MMApplicationContext.getContext().resources");
    sdy = ((Resources)localObject).getDisplayMetrics().heightPixels * 2;
    AppMethodBeat.o(204494);
  }
  
  public FinderDoubleClickTipUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(204500);
    this.rZE = g.K((d.g.a.a)new c(this));
    paramFragment = com.tencent.mm.ui.component.a.IrY;
    paramFragment = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class);
    d.g.b.k.g(paramFragment, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.sdv = ((FinderHomeTabStateVM)paramFragment);
    this.sdw = g.K((d.g.a.a)new f(this));
    AppMethodBeat.o(204500);
  }
  
  public FinderDoubleClickTipUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(204499);
    this.rZE = g.K((d.g.a.a)new c(this));
    paramMMActivity = com.tencent.mm.ui.component.a.IrY;
    paramMMActivity = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class);
    d.g.b.k.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.sdv = ((FinderHomeTabStateVM)paramMMActivity);
    this.sdw = g.K((d.g.a.a)new f(this));
    AppMethodBeat.o(204499);
  }
  
  private final int cvi()
  {
    AppMethodBeat.i(204495);
    int i = ((Number)this.sdw.getValue()).intValue();
    AppMethodBeat.o(204495);
    return i;
  }
  
  private final void md(boolean paramBoolean)
  {
    AppMethodBeat.i(204498);
    if (paramBoolean)
    {
      localObject = this.fragment;
      if (localObject != null)
      {
        localObject = ((Fragment)localObject).getView();
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(2131307264);
          if (localObject != null)
          {
            if (((View)localObject).getVisibility() == 8)
            {
              ((View)localObject).setVisibility(0);
              ((View)localObject).setAlpha(0.0F);
              ((View)localObject).animate().alpha(1.0F).setDuration(300L).withEndAction((Runnable)new d(this)).start();
            }
            AppMethodBeat.o(204498);
            return;
          }
        }
      }
      AppMethodBeat.o(204498);
      return;
    }
    Object localObject = this.fragment;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getView();
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(2131307264);
        if (localObject != null)
        {
          if (((View)localObject).getVisibility() == 0) {
            ((View)localObject).animate().alpha(0.0F).setDuration(300L).withEndAction((Runnable)new e((View)localObject, this)).start();
          }
          AppMethodBeat.o(204498);
          return;
        }
      }
    }
    AppMethodBeat.o(204498);
  }
  
  public final void Z(Bundle paramBundle)
  {
    AppMethodBeat.i(204496);
    super.Z(paramBundle);
    ((RecyclerView)this.rZE.getValue()).a((RecyclerView.m)new b(this));
    AppMethodBeat.o(204496);
  }
  
  public final void cFT()
  {
    AppMethodBeat.i(204497);
    md(false);
    FinderHomeTabStateVM.fK(cvi(), 10000);
    AppMethodBeat.o(204497);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204489);
      b localb = new b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt1);
      localb.lS(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(204489);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(204488);
      Object localObject = new b();
      ((b)localObject).bb(paramRecyclerView);
      ((b)localObject).lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((b)localObject).aeE());
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(204488);
        throw paramRecyclerView;
      }
      paramInt = ((LinearLayoutManager)localObject).jW();
      if (FinderDoubleClickTipUIC.a(this.sdA) < paramInt) {
        FinderDoubleClickTipUIC.a(this.sdA, paramInt);
      }
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
        AppMethodBeat.o(204488);
        throw paramRecyclerView;
      }
      if (paramInt <= ((WxRecyclerAdapter)paramRecyclerView).JCb.size())
      {
        FinderDoubleClickTipUIC.a(this.sdA, false);
        FinderDoubleClickTipUIC.a(this.sdA, 0);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(204488);
        return;
        if ((FinderDoubleClickTipUIC.a(this.sdA) - paramInt >= 2) && (FinderDoubleClickTipUIC.b(this.sdA).EV(FinderDoubleClickTipUIC.c(this.sdA)))) {
          FinderDoubleClickTipUIC.a(this.sdA, true);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<RecyclerView>
  {
    c(FinderDoubleClickTipUIC paramFinderDoubleClickTipUIC)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$showDoubleClickTip$1$1"})
  static final class d
    implements Runnable
  {
    d(FinderDoubleClickTipUIC paramFinderDoubleClickTipUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(204491);
      FinderDoubleClickTipUIC.d(this.sdA);
      AppMethodBeat.o(204491);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$showDoubleClickTip$2$1"})
  static final class e
    implements Runnable
  {
    e(View paramView, FinderDoubleClickTipUIC paramFinderDoubleClickTipUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(204492);
      this.rgs.setVisibility(8);
      FinderDoubleClickTipUIC.cFU();
      AppMethodBeat.o(204492);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    f(FinderDoubleClickTipUIC paramFinderDoubleClickTipUIC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderDoubleClickTipUIC
 * JD-Core Version:    0.7.0.1
 */