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
import com.tencent.mm.sdk.platformtools.aj;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "maxPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "Lkotlin/Lazy;", "state", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "tabType", "getTabType", "()I", "tabType$delegate", "hideCompleted", "", "onActionbarClick", "isDouble", "", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "showCompleted", "showDoubleClickTip", "isShow", "Companion", "plugin-finder_release"})
public final class FinderDoubleClickTipUIC
  extends UIComponent
{
  private static final int LhV;
  public static final a LhW;
  private final f Lga;
  private final FinderHomeTabStateVM LhS;
  private final f LhT;
  private int LhU;
  
  static
  {
    AppMethodBeat.i(200369);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(FinderDoubleClickTipUIC.class), "recyclerView", "getRecyclerView()Landroid/support/v7/widget/RecyclerView;")), (d.l.k)w.a(new u(w.bk(FinderDoubleClickTipUIC.class), "tabType", "getTabType()I")) };
    LhW = new a((byte)0);
    Object localObject = aj.getContext();
    d.g.b.k.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    d.g.b.k.g(localObject, "MMApplicationContext.getContext().resources");
    LhV = ((Resources)localObject).getDisplayMetrics().heightPixels * 2;
    AppMethodBeat.o(200369);
  }
  
  public FinderDoubleClickTipUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(200375);
    this.Lga = g.E((d.g.a.a)new c(this));
    paramFragment = com.tencent.mm.ui.component.a.LCX;
    paramFragment = com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class);
    d.g.b.k.g(paramFragment, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.LhS = ((FinderHomeTabStateVM)paramFragment);
    this.LhT = g.E((d.g.a.a)new f(this));
    AppMethodBeat.o(200375);
  }
  
  public FinderDoubleClickTipUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(200374);
    this.Lga = g.E((d.g.a.a)new c(this));
    paramMMActivity = com.tencent.mm.ui.component.a.LCX;
    paramMMActivity = com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class);
    d.g.b.k.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.LhS = ((FinderHomeTabStateVM)paramMMActivity);
    this.LhT = g.E((d.g.a.a)new f(this));
    AppMethodBeat.o(200374);
  }
  
  private final int epE()
  {
    AppMethodBeat.i(200370);
    int i = ((Number)this.LhT.getValue()).intValue();
    AppMethodBeat.o(200370);
    return i;
  }
  
  private final void yR(boolean paramBoolean)
  {
    AppMethodBeat.i(200373);
    if (paramBoolean)
    {
      localObject = this.fragment;
      if (localObject != null)
      {
        localObject = ((Fragment)localObject).getView();
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(2131307260);
          if (localObject != null)
          {
            if (((View)localObject).getVisibility() == 8)
            {
              ((View)localObject).setVisibility(0);
              ((View)localObject).setAlpha(0.0F);
              ((View)localObject).animate().alpha(1.0F).setDuration(300L).withEndAction((Runnable)new d(this)).start();
            }
            AppMethodBeat.o(200373);
            return;
          }
        }
      }
      AppMethodBeat.o(200373);
      return;
    }
    Object localObject = this.fragment;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getView();
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(2131307260);
        if (localObject != null)
        {
          if (((View)localObject).getVisibility() == 0) {
            ((View)localObject).animate().alpha(0.0F).setDuration(300L).withEndAction((Runnable)new e((View)localObject, this)).start();
          }
          AppMethodBeat.o(200373);
          return;
        }
      }
    }
    AppMethodBeat.o(200373);
  }
  
  public final void ba(Bundle paramBundle)
  {
    AppMethodBeat.i(200371);
    super.ba(paramBundle);
    ((RecyclerView)this.Lga.getValue()).a((RecyclerView.m)new b(this));
    AppMethodBeat.o(200371);
  }
  
  public final void fXk()
  {
    AppMethodBeat.i(200372);
    yR(false);
    FinderHomeTabStateVM.lc(epE(), 10000);
    AppMethodBeat.o(200372);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$Companion;", "", "()V", "OFFSET", "", "OFFSET_DISTANCE", "getOFFSET_DISTANCE", "()I", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(200364);
      b localb = new b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt1);
      localb.lT(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(200364);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(200363);
      Object localObject = new b();
      ((b)localObject).be(paramRecyclerView);
      ((b)localObject).lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((b)localObject).ado());
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(200363);
        throw paramRecyclerView;
      }
      paramInt = ((LinearLayoutManager)localObject).jO();
      if (FinderDoubleClickTipUIC.a(this.LhX) < paramInt) {
        FinderDoubleClickTipUIC.a(this.LhX, paramInt);
      }
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
        AppMethodBeat.o(200363);
        throw paramRecyclerView;
      }
      if (paramInt <= ((WxRecyclerAdapter)paramRecyclerView).Ibl.size())
      {
        FinderDoubleClickTipUIC.a(this.LhX, false);
        FinderDoubleClickTipUIC.a(this.LhX, 0);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(200363);
        return;
        if ((FinderDoubleClickTipUIC.a(this.LhX) - paramInt >= 2) && (FinderDoubleClickTipUIC.b(this.LhX).ahP(FinderDoubleClickTipUIC.c(this.LhX)))) {
          FinderDoubleClickTipUIC.a(this.LhX, true);
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<RecyclerView>
  {
    c(FinderDoubleClickTipUIC paramFinderDoubleClickTipUIC)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$showDoubleClickTip$1$1"})
  static final class d
    implements Runnable
  {
    d(FinderDoubleClickTipUIC paramFinderDoubleClickTipUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(200366);
      FinderDoubleClickTipUIC.d(this.LhX);
      AppMethodBeat.o(200366);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$showDoubleClickTip$2$1"})
  static final class e
    implements Runnable
  {
    e(View paramView, FinderDoubleClickTipUIC paramFinderDoubleClickTipUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(200367);
      this.Hzm.setVisibility(8);
      FinderDoubleClickTipUIC.fXl();
      AppMethodBeat.o(200367);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderDoubleClickTipUIC
 * JD-Core Version:    0.7.0.1
 */