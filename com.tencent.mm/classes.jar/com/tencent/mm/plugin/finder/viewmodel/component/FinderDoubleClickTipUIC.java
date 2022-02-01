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
import com.tencent.mm.sdk.platformtools.ak;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "maxPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "Lkotlin/Lazy;", "state", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "tabType", "getTabType", "()I", "tabType$delegate", "hideCompleted", "", "onActionbarClick", "isDouble", "", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "showCompleted", "showDoubleClickTip", "isShow", "Companion", "plugin-finder_release"})
public final class FinderDoubleClickTipUIC
  extends UIComponent
{
  private static final int tlP;
  public static final FinderDoubleClickTipUIC.a tlQ;
  private final f tie;
  private final FinderHomeTabStateVM tlM;
  private final f tlN;
  private int tlO;
  
  static
  {
    AppMethodBeat.i(206131);
    tlQ = new FinderDoubleClickTipUIC.a((byte)0);
    Object localObject = ak.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "MMApplicationContext.getContext().resources");
    tlP = ((Resources)localObject).getDisplayMetrics().heightPixels * 2;
    AppMethodBeat.o(206131);
  }
  
  public FinderDoubleClickTipUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(206130);
    this.tie = g.O((d.g.a.a)new c(this));
    paramFragment = com.tencent.mm.ui.component.a.KEX;
    paramFragment = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramFragment, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.tlM = ((FinderHomeTabStateVM)paramFragment);
    this.tlN = g.O((d.g.a.a)new f(this));
    AppMethodBeat.o(206130);
  }
  
  public FinderDoubleClickTipUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(206129);
    this.tie = g.O((d.g.a.a)new c(this));
    paramMMActivity = com.tencent.mm.ui.component.a.KEX;
    paramMMActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.tlM = ((FinderHomeTabStateVM)paramMMActivity);
    this.tlN = g.O((d.g.a.a)new f(this));
    AppMethodBeat.o(206129);
  }
  
  private final int cDl()
  {
    AppMethodBeat.i(206125);
    int i = ((Number)this.tlN.getValue()).intValue();
    AppMethodBeat.o(206125);
    return i;
  }
  
  private final void mA(boolean paramBoolean)
  {
    AppMethodBeat.i(206128);
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
            AppMethodBeat.o(206128);
            return;
          }
        }
      }
      AppMethodBeat.o(206128);
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
          AppMethodBeat.o(206128);
          return;
        }
      }
    }
    AppMethodBeat.o(206128);
  }
  
  public final void ad(Bundle paramBundle)
  {
    AppMethodBeat.i(206126);
    super.ad(paramBundle);
    ((RecyclerView)this.tie.getValue()).a((RecyclerView.m)new b(this));
    AppMethodBeat.o(206126);
  }
  
  public final void cQQ()
  {
    AppMethodBeat.i(206127);
    mA(false);
    FinderHomeTabStateVM.fY(cDl(), 10000);
    AppMethodBeat.o(206127);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(206120);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt1);
      localb.mu(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(206120);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(206119);
      Object localObject = new b();
      ((b)localObject).bd(paramRecyclerView);
      ((b)localObject).mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((b)localObject).ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(206119);
        throw paramRecyclerView;
      }
      paramInt = ((LinearLayoutManager)localObject).km();
      if (FinderDoubleClickTipUIC.a(this.tlR) < paramInt) {
        FinderDoubleClickTipUIC.a(this.tlR, paramInt);
      }
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
        AppMethodBeat.o(206119);
        throw paramRecyclerView;
      }
      if (paramInt <= ((WxRecyclerAdapter)paramRecyclerView).LRV.size())
      {
        FinderDoubleClickTipUIC.a(this.tlR, false);
        FinderDoubleClickTipUIC.a(this.tlR, 0);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(206119);
        return;
        if ((FinderDoubleClickTipUIC.a(this.tlR) - paramInt >= 2) && (FinderDoubleClickTipUIC.b(this.tlR).GI(FinderDoubleClickTipUIC.c(this.tlR)))) {
          FinderDoubleClickTipUIC.a(this.tlR, true);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<RecyclerView>
  {
    c(FinderDoubleClickTipUIC paramFinderDoubleClickTipUIC)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$showDoubleClickTip$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(FinderDoubleClickTipUIC paramFinderDoubleClickTipUIC) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(206122);
      FinderDoubleClickTipUIC.d(this.tlR);
      AppMethodBeat.o(206122);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/component/FinderDoubleClickTipUIC$showDoubleClickTip$2$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    e(View paramView, FinderDoubleClickTipUIC paramFinderDoubleClickTipUIC) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(206123);
      this.scH.setVisibility(8);
      FinderDoubleClickTipUIC.cQR();
      AppMethodBeat.o(206123);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderDoubleClickTipUIC
 * JD-Core Version:    0.7.0.1
 */