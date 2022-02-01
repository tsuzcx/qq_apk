package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "maxPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "Lkotlin/Lazy;", "state", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "tabType", "getTabType", "()I", "tabType$delegate", "hideCompleted", "", "onActionbarClick", "isDouble", "", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "showCompleted", "showDoubleClickTip", "isShow", "Companion", "plugin-finder_release"})
public final class FinderDoubleClickTipUIC
  extends UIComponent
{
  private static final int tba;
  public static final a tbb;
  private final f sWQ;
  private final FinderHomeTabStateVM taX;
  private final f taY;
  private int taZ;
  
  static
  {
    AppMethodBeat.i(205521);
    tbb = new a((byte)0);
    Object localObject = aj.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "MMApplicationContext.getContext().resources");
    tba = ((Resources)localObject).getDisplayMetrics().heightPixels * 2;
    AppMethodBeat.o(205521);
  }
  
  public FinderDoubleClickTipUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(205520);
    this.sWQ = g.O((d.g.a.a)new c(this));
    paramFragment = com.tencent.mm.ui.component.a.KiD;
    paramFragment = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramFragment, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.taX = ((FinderHomeTabStateVM)paramFragment);
    this.taY = g.O((d.g.a.a)new f(this));
    AppMethodBeat.o(205520);
  }
  
  public FinderDoubleClickTipUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(205519);
    this.sWQ = g.O((d.g.a.a)new c(this));
    paramMMActivity = com.tencent.mm.ui.component.a.KiD;
    paramMMActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.taX = ((FinderHomeTabStateVM)paramMMActivity);
    this.taY = g.O((d.g.a.a)new f(this));
    AppMethodBeat.o(205519);
  }
  
  private final int cBz()
  {
    AppMethodBeat.i(205515);
    int i = ((Number)this.taY.getValue()).intValue();
    AppMethodBeat.o(205515);
    return i;
  }
  
  private final void mw(boolean paramBoolean)
  {
    AppMethodBeat.i(205518);
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
              ((View)localObject).animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new d(this)).start();
            }
            AppMethodBeat.o(205518);
            return;
          }
        }
      }
      AppMethodBeat.o(205518);
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
            ((View)localObject).animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new e((View)localObject, this)).start();
          }
          AppMethodBeat.o(205518);
          return;
        }
      }
    }
    AppMethodBeat.o(205518);
  }
  
  public final void ac(Bundle paramBundle)
  {
    AppMethodBeat.i(205516);
    super.ac(paramBundle);
    ((RecyclerView)this.sWQ.getValue()).a((RecyclerView.m)new b(this));
    AppMethodBeat.o(205516);
  }
  
  public final void cOl()
  {
    AppMethodBeat.i(205517);
    mw(false);
    FinderHomeTabStateVM.fY(cBz(), 10000);
    AppMethodBeat.o(205517);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$Companion;", "", "()V", "OFFSET", "", "OFFSET_DISTANCE", "getOFFSET_DISTANCE", "()I", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205510);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt1);
      localb.mr(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(205510);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(205509);
      Object localObject = new b();
      ((b)localObject).bd(paramRecyclerView);
      ((b)localObject).mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((b)localObject).ahq());
      p.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(205509);
        throw paramRecyclerView;
      }
      paramInt = ((LinearLayoutManager)localObject).km();
      if (FinderDoubleClickTipUIC.a(this.tbc) < paramInt) {
        FinderDoubleClickTipUIC.a(this.tbc, paramInt);
      }
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
        AppMethodBeat.o(205509);
        throw paramRecyclerView;
      }
      if (paramInt <= ((WxRecyclerAdapter)paramRecyclerView).Lvi.size())
      {
        FinderDoubleClickTipUIC.a(this.tbc, false);
        FinderDoubleClickTipUIC.a(this.tbc, 0);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(205509);
        return;
        if ((FinderDoubleClickTipUIC.a(this.tbc) - paramInt >= 2) && (FinderDoubleClickTipUIC.b(this.tbc).Gj(FinderDoubleClickTipUIC.c(this.tbc)))) {
          FinderDoubleClickTipUIC.a(this.tbc, true);
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<RecyclerView>
  {
    c(FinderDoubleClickTipUIC paramFinderDoubleClickTipUIC)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$showDoubleClickTip$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(FinderDoubleClickTipUIC paramFinderDoubleClickTipUIC) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(221579);
      FinderDoubleClickTipUIC.d(this.tbc);
      AppMethodBeat.o(221579);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$showDoubleClickTip$2$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    e(View paramView, FinderDoubleClickTipUIC paramFinderDoubleClickTipUIC) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(221580);
      this.rUd.setVisibility(8);
      FinderDoubleClickTipUIC.cOm();
      AppMethodBeat.o(221580);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<Integer>
  {
    f(FinderDoubleClickTipUIC paramFinderDoubleClickTipUIC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderDoubleClickTipUIC
 * JD-Core Version:    0.7.0.1
 */