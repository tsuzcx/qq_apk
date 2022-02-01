package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.convert.s;
import com.tencent.mm.plugin.finder.model.ah;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "actionBarOverlayLayout", "Landroid/view/ViewGroup;", "getActionBarOverlayLayout", "()Landroid/view/ViewGroup;", "actionBarOverlayLayout$delegate", "Lkotlin/Lazy;", "feedFullMergedHeaderConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullMergedHeaderConvert;", "feedFullMergedHeaderHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "headerFullMergedData", "Lcom/tencent/mm/plugin/finder/model/FinderHeaderFullMergedData;", "maxPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "state", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "tabType", "getTabType", "()I", "tabType$delegate", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "checkShowStreamDividerTip", "", "hideCompleted", "isBegin", "", "action", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$Action;", "notifyHeaderFullMergedView", "onActionbarClick", "isDouble", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setHeaderFullMergedData", "showActionBarTip", "isShow", "content", "", "duration", "", "showCompleted", "showTips", "transOffset", "y", "", "Action", "Companion", "plugin-finder_release"})
public final class FinderActionBarOverlayUIC
  extends UIComponent
{
  private static final int wvh;
  public static final b wvi;
  private final MMHandler hAk;
  public ah tSk;
  private final f vPc;
  private final f vau;
  public final f wvc;
  private final FinderHomeTabStateVM wvd;
  private int wve;
  public final s wvf;
  public com.tencent.mm.view.recyclerview.h wvg;
  
  static
  {
    AppMethodBeat.i(255432);
    wvi = new b((byte)0);
    Object localObject = MMApplicationContext.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "MMApplicationContext.getContext().resources");
    wvh = ((Resources)localObject).getDisplayMetrics().heightPixels * 2;
    AppMethodBeat.o(255432);
  }
  
  public FinderActionBarOverlayUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(255431);
    this.vau = kotlin.g.ah((kotlin.g.a.a)new e(this));
    this.wvc = kotlin.g.ah((kotlin.g.a.a)new c(this));
    paramFragment = com.tencent.mm.ui.component.a.PRN;
    paramFragment = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramFragment, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.wvd = ((FinderHomeTabStateVM)paramFragment);
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.vPc = kotlin.g.ah((kotlin.g.a.a)new k(this));
    this.wvf = new s();
    AppMethodBeat.o(255431);
  }
  
  public FinderActionBarOverlayUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255430);
    this.vau = kotlin.g.ah((kotlin.g.a.a)new e(this));
    this.wvc = kotlin.g.ah((kotlin.g.a.a)new c(this));
    paramAppCompatActivity = com.tencent.mm.ui.component.a.PRN;
    paramAppCompatActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramAppCompatActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.wvd = ((FinderHomeTabStateVM)paramAppCompatActivity);
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.vPc = kotlin.g.ah((kotlin.g.a.a)new k(this));
    this.wvf = new s();
    AppMethodBeat.o(255430);
  }
  
  private final void a(boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(255426);
    if (paramBoolean)
    {
      localView = findViewById(2131296361);
      if (localView != null)
      {
        localView.animate().cancel();
        c(true, parama);
        if (localView.getVisibility() == 8)
        {
          localView.setVisibility(0);
          localView.setAlpha(0.0F);
          localView.animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new i(this, parama)).start();
        }
        AppMethodBeat.o(255426);
        return;
      }
      AppMethodBeat.o(255426);
      return;
    }
    View localView = findViewById(2131296361);
    if (localView != null)
    {
      localView.animate().cancel();
      if (localView.getVisibility() == 0)
      {
        b(true, parama);
        localView.animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new j(localView, this, parama)).start();
      }
      AppMethodBeat.o(255426);
      return;
    }
    AppMethodBeat.o(255426);
  }
  
  private static void b(boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(255427);
    Log.i("Finder.DoubleClickTipUIC", "[hideCompleted] isBegin=" + paramBoolean + " action=" + parama.type);
    AppMethodBeat.o(255427);
  }
  
  @SuppressLint({"ResourceType"})
  private final void c(boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(255428);
    Log.i("Finder.DoubleClickTipUIC", "[showCompleted] isBegin=" + paramBoolean + " action=" + parama.type);
    Object localObject;
    if (parama.type == 1)
    {
      if (paramBoolean)
      {
        parama = (TextView)findViewById(2131309177);
        if (parama != null)
        {
          parama.setText((CharSequence)getContext().getResources().getString(2131759673));
          parama.setVisibility(0);
        }
        parama = (WeImageView)findViewById(2131309180);
        if (parama != null)
        {
          parama.setVisibility(0);
          parama.setIconColor(getContext().getResources().getColor(2131100620));
          parama.setRotation(-90.0F);
          parama.setImageResource(2131690287);
          AppMethodBeat.o(255428);
          return;
        }
        AppMethodBeat.o(255428);
        return;
      }
      localObject = getFragment();
      if (localObject == null)
      {
        parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
        AppMethodBeat.o(255428);
        throw parama;
      }
      FinderHomeTabStateVM.Ms(((FinderHomeTabFragment)localObject).dLS);
      this.hAk.postDelayed((Runnable)new f(this, parama), parama.duration);
      AppMethodBeat.o(255428);
      return;
    }
    if (parama.type == 2)
    {
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(22077, "");
      localObject = (TextView)findViewById(2131309177);
      if (localObject != null)
      {
        ((TextView)localObject).setText((CharSequence)getContext().getResources().getString(2131760342));
        ((TextView)localObject).setVisibility(0);
      }
      localObject = (WeImageView)findViewById(2131309180);
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(8);
      }
      this.hAk.postDelayed((Runnable)new g(this, parama), parama.duration);
      AppMethodBeat.o(255428);
      return;
    }
    if (parama.type == 0)
    {
      localObject = (TextView)findViewById(2131309177);
      if (localObject != null)
      {
        ((TextView)localObject).setText(parama.title);
        ((TextView)localObject).setVisibility(0);
      }
      localObject = (WeImageView)findViewById(2131309180);
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(8);
      }
      this.hAk.postDelayed((Runnable)new h(this, parama), parama.duration);
    }
    AppMethodBeat.o(255428);
  }
  
  private final int getTabType()
  {
    AppMethodBeat.i(255421);
    int i = ((Number)this.vPc.getValue()).intValue();
    AppMethodBeat.o(255421);
    return i;
  }
  
  public final void dHW()
  {
    AppMethodBeat.i(255422);
    Object localObject = y.vXH;
    localObject = this.wvg;
    ah localah = this.tSk;
    if ((localObject != null) && (localah != null)) {
      this.wvf.a((com.tencent.mm.view.recyclerview.h)localObject, localah, 0);
    }
    AppMethodBeat.o(255422);
  }
  
  public final void dHX()
  {
    AppMethodBeat.i(255424);
    a(false, new a(1));
    FinderHomeTabStateVM.gu(getTabType(), 10000);
    AppMethodBeat.o(255424);
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(255420);
    RecyclerView localRecyclerView = (RecyclerView)this.vau.getValue();
    AppMethodBeat.o(255420);
    return localRecyclerView;
  }
  
  public final void onCreateAfter(final Bundle paramBundle)
  {
    AppMethodBeat.i(255423);
    super.onCreateAfter(paramBundle);
    paramBundle = (ViewGroup)findViewById(2131296359);
    getRecyclerView().a((RecyclerView.l)new d(this, paramBundle));
    AppMethodBeat.o(255423);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255429);
    super.onDestroy();
    this.hAk.removeCallbacksAndMessages(null);
    AppMethodBeat.o(255429);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$Action;", "", "type", "", "(I)V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "title", "", "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "getType", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-finder_release"})
  public static final class a
  {
    public static final a wvj;
    long duration;
    CharSequence title;
    final int type;
    
    static
    {
      AppMethodBeat.i(255406);
      wvj = new a((byte)0);
      AppMethodBeat.o(255406);
    }
    
    public a(int paramInt)
    {
      this.type = paramInt;
      this.duration = 5000L;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.type != paramObject.type) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.type;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(255407);
      String str = "Action(type=" + this.type + ")";
      AppMethodBeat.o(255407);
      return str;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$Action$Companion;", "", "()V", "TYPE_DOUBLE_CLICK_TIPS", "", "TYPE_HISTORY_TIPS", "TYPE_NORMAL_TIPS", "plugin-finder_release"})
    public static final class a {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$Companion;", "", "()V", "OFFSET", "", "OFFSET_DISTANCE", "getOFFSET_DISTANCE", "()I", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    c(FinderActionBarOverlayUIC paramFinderActionBarOverlayUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "checkHeaderFullMergedShow", "", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.l
  {
    private final Rect rect;
    
    d(ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(255412);
      this.rect = new Rect();
      AppMethodBeat.o(255412);
    }
    
    private final void dHY()
    {
      AppMethodBeat.i(255409);
      if (FinderActionBarOverlayUIC.a(this.wvk) == null)
      {
        AppMethodBeat.o(255409);
        return;
      }
      Object localObject1 = FinderActionBarOverlayUIC.b(this.wvk).getLayoutManager();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(255409);
        throw ((Throwable)localObject1);
      }
      int i = ((LinearLayoutManager)localObject1).ks();
      if (i == 0)
      {
        localObject1 = paramBundle;
        p.g(localObject1, "mergedLayout");
        if (((ViewGroup)localObject1).getVisibility() != 0)
        {
          localObject1 = paramBundle;
          p.g(localObject1, "mergedLayout");
          ((ViewGroup)localObject1).setVisibility(0);
        }
      }
      if (i == 0)
      {
        localObject1 = paramBundle;
        p.g(localObject1, "mergedLayout");
        if (((ViewGroup)localObject1).getHeight() > 0)
        {
          Object localObject2 = FinderActionBarOverlayUIC.b(this.wvk).ch(0);
          if (localObject2 != null)
          {
            FinderActionBarOverlayUIC.b(this.wvk);
            RecyclerView.getDecoratedBoundsWithMargins(((RecyclerView.v)localObject2).aus, this.rect);
            this.rect.top = Math.max(0, this.rect.top);
            this.rect.bottom = Math.max(0, this.rect.bottom);
            if (this.rect.height() > 0)
            {
              localObject1 = paramBundle;
              p.g(localObject1, "mergedLayout");
              float f = this.rect.height();
              localObject2 = ((RecyclerView.v)localObject2).aus;
              p.g(localObject2, "it.itemView");
              ((ViewGroup)localObject1).setAlpha(1.0F * f / ((View)localObject2).getHeight());
              AppMethodBeat.o(255409);
              return;
            }
            localObject1 = paramBundle;
            p.g(localObject1, "mergedLayout");
            ((ViewGroup)localObject1).setVisibility(8);
            AppMethodBeat.o(255409);
            return;
          }
          localObject1 = paramBundle;
          p.g(localObject1, "mergedLayout");
          ((ViewGroup)localObject1).setVisibility(8);
          AppMethodBeat.o(255409);
          return;
        }
      }
      if (i > 0)
      {
        localObject1 = paramBundle;
        p.g(localObject1, "mergedLayout");
        ((ViewGroup)localObject1).setVisibility(8);
      }
      AppMethodBeat.o(255409);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(255411);
      Object localObject = new b();
      ((b)localObject).bm(paramRecyclerView);
      ((b)localObject).pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(255411);
        throw paramRecyclerView;
      }
      int i = ((LinearLayoutManager)localObject).ks();
      if (FinderActionBarOverlayUIC.c(this.wvk) < i) {
        FinderActionBarOverlayUIC.a(this.wvk, i);
      }
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
        AppMethodBeat.o(255411);
        throw paramRecyclerView;
      }
      if (i <= ((WxRecyclerAdapter)paramRecyclerView).RqM.size())
      {
        FinderActionBarOverlayUIC.a(this.wvk, false, new FinderActionBarOverlayUIC.a(1));
        FinderActionBarOverlayUIC.a(this.wvk, 0);
      }
      for (;;)
      {
        if (paramInt == 0) {
          dHY();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(255411);
        return;
        if ((FinderActionBarOverlayUIC.c(this.wvk) - i >= 2) && (FinderActionBarOverlayUIC.d(this.wvk).Mr(FinderActionBarOverlayUIC.e(this.wvk)))) {
          FinderActionBarOverlayUIC.a(this.wvk, true, new FinderActionBarOverlayUIC.a(1));
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(255410);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      dHY();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(255410);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    e(FinderActionBarOverlayUIC paramFinderActionBarOverlayUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderActionBarOverlayUIC paramFinderActionBarOverlayUIC, FinderActionBarOverlayUIC.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(255414);
      FinderActionBarOverlayUIC.a(this.wvk, false, parama);
      AppMethodBeat.o(255414);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(FinderActionBarOverlayUIC paramFinderActionBarOverlayUIC, FinderActionBarOverlayUIC.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(255415);
      FinderActionBarOverlayUIC.a(this.wvk, false, parama);
      AppMethodBeat.o(255415);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(FinderActionBarOverlayUIC paramFinderActionBarOverlayUIC, FinderActionBarOverlayUIC.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(255416);
      FinderActionBarOverlayUIC.a(this.wvk, false, parama);
      AppMethodBeat.o(255416);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$showTips$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    i(FinderActionBarOverlayUIC paramFinderActionBarOverlayUIC, FinderActionBarOverlayUIC.a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(255417);
      FinderActionBarOverlayUIC.a(this.wvk, parama);
      AppMethodBeat.o(255417);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$showTips$2$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class j
    implements Animator.AnimatorListener
  {
    j(View paramView, FinderActionBarOverlayUIC paramFinderActionBarOverlayUIC, FinderActionBarOverlayUIC.a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(255418);
      this.tCl.setVisibility(8);
      FinderActionBarOverlayUIC.a(parama);
      AppMethodBeat.o(255418);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<Integer>
  {
    k(FinderActionBarOverlayUIC paramFinderActionBarOverlayUIC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderActionBarOverlayUIC
 * JD-Core Version:    0.7.0.1
 */