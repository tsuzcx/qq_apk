package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.StickTopLoadingLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "actionBarLayoutChangeListener", "Lcom/tencent/mm/plugin/finder/viewmodel/component/ActionBarLayoutChangeListener;", "actionBarMergedLayout", "Landroid/view/ViewGroup;", "getActionBarMergedLayout", "()Landroid/view/ViewGroup;", "actionBarMergedLayout$delegate", "Lkotlin/Lazy;", "actionBarMergedLayoutLoc", "", "actionBarMergedLayoutLocY", "", "actionBarOverlayLayout", "getActionBarOverlayLayout", "actionBarOverlayLayout$delegate", "feedFullMergedHeaderConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullMergedHeaderConvert;", "feedFullMergedHeaderHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "headerFullMergedData", "Lcom/tencent/mm/plugin/finder/model/FinderHeaderFullMergedData;", "lastActionBarMergedLayoutLocY", "maxPosition", "onPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "getOnPreDrawListener", "()Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDrawListener$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "showingAction", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$Action;", "state", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "tabType", "getTabType", "()I", "tabType$delegate", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "checkShowStreamDividerTip", "", "getActionBarLayoutHeight", "getActionBarLayoutLocY", "hideCompleted", "isBegin", "", "action", "notifyHeaderFullMergedView", "onActionbarClick", "isDouble", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "registActionBarLayoutChangeListener", "setHeaderFullMergedData", "showActionBarTip", "isShow", "content", "", "duration", "", "showCompleted", "showTips", "transOffset", "y", "", "unRegisteActionBarLayoutChangeListener", "Action", "Companion", "plugin-finder_release"})
public final class e
  extends UIComponent
{
  private static final int Bih;
  public static final b Bii;
  public final f BhV;
  private final f BhW;
  private final com.tencent.mm.plugin.finder.viewmodel.b BhX;
  private int BhY;
  public final com.tencent.mm.plugin.finder.convert.t BhZ;
  public i Bia;
  public a Bib;
  private int[] Bic;
  private int Bid;
  private int Bie;
  private final f Bif;
  private a Big;
  private final MMHandler knk;
  public com.tencent.mm.plugin.finder.model.aj xDd;
  private final f zQD;
  private final f zVl;
  
  static
  {
    AppMethodBeat.i(269316);
    Bii = new b((byte)0);
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    p.j(localObject, "MMApplicationContext.getContext().resources");
    Bih = ((Resources)localObject).getDisplayMetrics().heightPixels * 2;
    AppMethodBeat.o(269316);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(269314);
    this.zQD = kotlin.g.ar((kotlin.g.a.a)new h(this));
    this.BhV = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.BhW = kotlin.g.ar((kotlin.g.a.a)new c(this));
    paramAppCompatActivity = com.tencent.mm.ui.component.g.Xox;
    paramAppCompatActivity = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class);
    p.j(paramAppCompatActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.BhX = ((com.tencent.mm.plugin.finder.viewmodel.b)paramAppCompatActivity);
    this.knk = new MMHandler(Looper.getMainLooper());
    this.zVl = kotlin.g.ar((kotlin.g.a.a)new n(this));
    this.BhZ = new com.tencent.mm.plugin.finder.convert.t();
    this.Bic = new int[2];
    this.Bif = kotlin.g.ar((kotlin.g.a.a)new g(this));
    AppMethodBeat.o(269314);
  }
  
  public e(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(269315);
    this.zQD = kotlin.g.ar((kotlin.g.a.a)new h(this));
    this.BhV = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.BhW = kotlin.g.ar((kotlin.g.a.a)new c(this));
    paramFragment = com.tencent.mm.ui.component.g.Xox;
    paramFragment = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class);
    p.j(paramFragment, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.BhX = ((com.tencent.mm.plugin.finder.viewmodel.b)paramFragment);
    this.knk = new MMHandler(Looper.getMainLooper());
    this.zVl = kotlin.g.ar((kotlin.g.a.a)new n(this));
    this.BhZ = new com.tencent.mm.plugin.finder.convert.t();
    this.Bic = new int[2];
    this.Bif = kotlin.g.ar((kotlin.g.a.a)new g(this));
    AppMethodBeat.o(269315);
  }
  
  private final void a(boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(269309);
    if (paramBoolean)
    {
      this.Big = parama;
      localObject = findViewById(b.f.actionBarTips);
      if (localObject != null)
      {
        ((View)localObject).animate().cancel();
        c(true, parama);
        if (((View)localObject).getVisibility() == 8)
        {
          ((View)localObject).setVisibility(0);
          ((View)localObject).setAlpha(0.0F);
          ((View)localObject).animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new l(this, parama)).start();
        }
      }
      parama = ((RefreshLoadMoreLayout)getRootView().findViewById(b.f.rl_layout)).getStickTopLoadingLayout();
      if (parama != null)
      {
        parama.ihy();
        AppMethodBeat.o(269309);
        return;
      }
      AppMethodBeat.o(269309);
      return;
    }
    Object localObject = this.Big;
    if (((localObject != null) && (((a)localObject).type == parama.type)) || (this.Big == null))
    {
      localObject = findViewById(b.f.actionBarTips);
      if (localObject != null)
      {
        ((View)localObject).animate().cancel();
        if (((View)localObject).getVisibility() == 0)
        {
          b(true, parama);
          ((View)localObject).animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new m((View)localObject, this, parama)).start();
        }
        AppMethodBeat.o(269309);
        return;
      }
    }
    AppMethodBeat.o(269309);
  }
  
  private static void b(boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(269310);
    Log.i("Finder.DoubleClickTipUIC", "[hideCompleted] isBegin=" + paramBoolean + " action=" + parama.type);
    AppMethodBeat.o(269310);
  }
  
  @SuppressLint({"ResourceType"})
  private final void c(boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(269311);
    Log.i("Finder.DoubleClickTipUIC", "[showCompleted] isBegin=" + paramBoolean + " action=" + parama.type);
    Object localObject;
    if (parama.type == 1)
    {
      if (paramBoolean)
      {
        parama = (TextView)findViewById(b.f.tips_desc);
        if (parama != null)
        {
          parama.setText((CharSequence)getContext().getResources().getString(b.j.finder_double_tips));
          parama.setVisibility(0);
        }
        parama = (WeImageView)findViewById(b.f.tips_icon);
        if (parama != null)
        {
          parama.setVisibility(0);
          parama.setIconColor(getContext().getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_8));
          parama.setRotation(-90.0F);
          parama.setImageResource(b.i.finder_self_feed_like_arrow);
          AppMethodBeat.o(269311);
          return;
        }
        AppMethodBeat.o(269311);
        return;
      }
      localObject = getFragment();
      if (localObject == null)
      {
        parama = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
        AppMethodBeat.o(269311);
        throw parama;
      }
      com.tencent.mm.plugin.finder.viewmodel.b.RK(((FinderHomeTabFragment)localObject).fEH);
      this.knk.postDelayed((Runnable)new i(this, parama), parama.duration);
      AppMethodBeat.o(269311);
      return;
    }
    if (parama.type == 2)
    {
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(22077, "");
      localObject = (TextView)findViewById(b.f.tips_desc);
      if (localObject != null)
      {
        ((TextView)localObject).setText((CharSequence)getContext().getResources().getString(b.j.finder_no_more_new_feed_tips));
        ((TextView)localObject).setVisibility(0);
      }
      localObject = (WeImageView)findViewById(b.f.tips_icon);
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(8);
      }
      this.knk.postDelayed((Runnable)new j(this, parama), parama.duration);
      AppMethodBeat.o(269311);
      return;
    }
    if (parama.type == 0)
    {
      localObject = (TextView)findViewById(b.f.tips_desc);
      if (localObject != null)
      {
        ((TextView)localObject).setText(parama.Ig);
        ((TextView)localObject).setVisibility(0);
      }
      localObject = (WeImageView)findViewById(b.f.tips_icon);
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(8);
      }
      this.knk.postDelayed((Runnable)new k(this, parama), parama.duration);
    }
    AppMethodBeat.o(269311);
  }
  
  private final int getTabType()
  {
    AppMethodBeat.i(269301);
    int i = ((Number)this.zVl.getValue()).intValue();
    AppMethodBeat.o(269301);
    return i;
  }
  
  public final ViewGroup eki()
  {
    AppMethodBeat.i(269300);
    ViewGroup localViewGroup = (ViewGroup)this.BhW.getValue();
    AppMethodBeat.o(269300);
    return localViewGroup;
  }
  
  public final ViewTreeObserver.OnPreDrawListener ekj()
  {
    AppMethodBeat.i(269302);
    ViewTreeObserver.OnPreDrawListener localOnPreDrawListener = (ViewTreeObserver.OnPreDrawListener)this.Bif.getValue();
    AppMethodBeat.o(269302);
    return localOnPreDrawListener;
  }
  
  public final void ekk()
  {
    AppMethodBeat.i(269303);
    Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
    localObject = this.Bia;
    com.tencent.mm.plugin.finder.model.aj localaj = this.xDd;
    if ((localObject != null) && (localaj != null)) {
      this.BhZ.a((i)localObject, localaj, 0);
    }
    AppMethodBeat.o(269303);
  }
  
  public final void ekl()
  {
    AppMethodBeat.i(269305);
    a(false, new a(1));
    com.tencent.mm.plugin.finder.viewmodel.b.hk(getTabType(), 10000);
    AppMethodBeat.o(269305);
  }
  
  public final void ekm()
  {
    AppMethodBeat.i(269306);
    Object localObject = getRecyclerView().getLayoutManager();
    if ((localObject instanceof LinearLayoutManager))
    {
      final int i = ((LinearLayoutManager)localObject).kJ();
      if (i != -1)
      {
        localObject = getRecyclerView();
        if (localObject != null)
        {
          ((RecyclerView)localObject).post((Runnable)new e(this, i));
          AppMethodBeat.o(269306);
          return;
        }
      }
    }
    AppMethodBeat.o(269306);
  }
  
  public final void ekn()
  {
    AppMethodBeat.i(269313);
    Log.i("Finder.DoubleClickTipUIC", "unRegisteActionBarLayoutChangeListener!");
    Object localObject = eki();
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getViewTreeObserver();
      if (localObject != null) {
        ((ViewTreeObserver)localObject).removeOnPreDrawListener(ekj());
      }
    }
    this.Bib = null;
    AppMethodBeat.o(269313);
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(269299);
    RecyclerView localRecyclerView = (RecyclerView)this.zQD.getValue();
    AppMethodBeat.o(269299);
    return localRecyclerView;
  }
  
  public final void onCreateAfter(final Bundle paramBundle)
  {
    AppMethodBeat.i(269304);
    super.onCreateAfter(paramBundle);
    paramBundle = (ViewGroup)findViewById(b.f.actionBarMergedLayout);
    getRecyclerView().a((RecyclerView.l)new f(this, paramBundle));
    AppMethodBeat.o(269304);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(269312);
    super.onDestroy();
    this.knk.removeCallbacksAndMessages(null);
    ekn();
    AppMethodBeat.o(269312);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$Action;", "", "type", "", "(I)V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "title", "", "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "getType", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-finder_release"})
  public static final class a
  {
    public static final a Bij;
    CharSequence Ig;
    long duration;
    final int type;
    
    static
    {
      AppMethodBeat.i(276875);
      Bij = new a((byte)0);
      AppMethodBeat.o(276875);
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
      AppMethodBeat.i(276876);
      String str = "Action(type=" + this.type + ")";
      AppMethodBeat.o(276876);
      return str;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$Action$Companion;", "", "()V", "TYPE_DOUBLE_CLICK_TIPS", "", "TYPE_HISTORY_TIPS", "TYPE_NORMAL_TIPS", "plugin-finder_release"})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$Companion;", "", "()V", "OFFSET", "", "OFFSET_DISTANCE", "getOFFSET_DISTANCE", "()I", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(e parame, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(225683);
      Object localObject1 = e.b(this.Bik).cK(i);
      if (localObject1 != null)
      {
        Object localObject2;
        e locale;
        if ((localObject1 instanceof i))
        {
          localObject2 = ((i)localObject1).ihX();
          if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).streamDivider != null))
          {
            localObject1 = ((BaseFinderFeed)localObject2).streamDivider;
            if (localObject1 == null) {
              break label121;
            }
            if (((bjr)localObject1).STx == 8)
            {
              locale = this.Bik;
              localObject1 = ((BaseFinderFeed)localObject2).streamDivider;
              if (localObject1 == null) {
                break label127;
              }
            }
          }
        }
        label121:
        label127:
        for (localObject1 = ((bjr)localObject1).wording;; localObject1 = null)
        {
          e.a(locale, (CharSequence)localObject1);
          ((BaseFinderFeed)localObject2).streamDivider = null;
          AppMethodBeat.o(225683);
          return;
          AppMethodBeat.o(225683);
          return;
        }
      }
      AppMethodBeat.o(225683);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "checkHeaderFullMergedShow", "", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.l
  {
    private final Rect byG;
    
    f(ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(288554);
      this.byG = new Rect();
      AppMethodBeat.o(288554);
    }
    
    private final void eko()
    {
      AppMethodBeat.i(288551);
      if (e.a(this.Bik) == null)
      {
        AppMethodBeat.o(288551);
        return;
      }
      Object localObject1 = e.b(this.Bik).getLayoutManager();
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(288551);
        throw ((Throwable)localObject1);
      }
      int i = ((LinearLayoutManager)localObject1).kJ();
      if (i == 0)
      {
        localObject1 = paramBundle;
        p.j(localObject1, "mergedLayout");
        if (((ViewGroup)localObject1).getVisibility() != 0)
        {
          localObject1 = paramBundle;
          p.j(localObject1, "mergedLayout");
          ((ViewGroup)localObject1).setVisibility(0);
        }
      }
      if (i == 0)
      {
        localObject1 = paramBundle;
        p.j(localObject1, "mergedLayout");
        if (((ViewGroup)localObject1).getHeight() > 0)
        {
          Object localObject2 = e.b(this.Bik).cK(0);
          if (localObject2 != null)
          {
            e.b(this.Bik);
            RecyclerView.getDecoratedBoundsWithMargins(((RecyclerView.v)localObject2).amk, this.byG);
            this.byG.top = Math.max(0, this.byG.top);
            this.byG.bottom = Math.max(0, this.byG.bottom);
            if (this.byG.height() > 0)
            {
              localObject1 = paramBundle;
              p.j(localObject1, "mergedLayout");
              float f = this.byG.height();
              localObject2 = ((RecyclerView.v)localObject2).amk;
              p.j(localObject2, "it.itemView");
              ((ViewGroup)localObject1).setAlpha(1.0F * f / ((View)localObject2).getHeight());
              AppMethodBeat.o(288551);
              return;
            }
            localObject1 = paramBundle;
            p.j(localObject1, "mergedLayout");
            ((ViewGroup)localObject1).setVisibility(8);
            AppMethodBeat.o(288551);
            return;
          }
          localObject1 = paramBundle;
          p.j(localObject1, "mergedLayout");
          ((ViewGroup)localObject1).setVisibility(8);
          AppMethodBeat.o(288551);
          return;
        }
      }
      if (i > 0)
      {
        localObject1 = paramBundle;
        p.j(localObject1, "mergedLayout");
        ((ViewGroup)localObject1).setVisibility(8);
      }
      AppMethodBeat.o(288551);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(288553);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null)
      {
        paramRecyclerView = new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(288553);
        throw paramRecyclerView;
      }
      int i = ((LinearLayoutManager)localObject).kJ();
      if (e.c(this.Bik) < i) {
        e.a(this.Bik, i);
      }
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
        AppMethodBeat.o(288553);
        throw paramRecyclerView;
      }
      if (i <= ((WxRecyclerAdapter)paramRecyclerView).YSk.size())
      {
        e.a(this.Bik, false, new e.a(1));
        e.a(this.Bik, 0);
      }
      for (;;)
      {
        if (paramInt == 0)
        {
          this.Bik.ekm();
          eko();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(288553);
        return;
        if ((e.c(this.Bik) - i >= 2) && (e.d(this.Bik).RJ(e.e(this.Bik)))) {
          e.a(this.Bik, true, new e.a(1));
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(288552);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      eko();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(288552);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<ViewTreeObserver.OnPreDrawListener>
  {
    g(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    h(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(e parame, e.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(270642);
      e.a(this.Bik, false, parama);
      AppMethodBeat.o(270642);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(e parame, e.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(231305);
      e.a(this.Bik, false, parama);
      AppMethodBeat.o(231305);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(e parame, e.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(289993);
      e.a(this.Bik, false, parama);
      AppMethodBeat.o(289993);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$showTips$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class l
    implements Animator.AnimatorListener
  {
    l(e parame, e.a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(242928);
      e.a(this.Bik, parama);
      AppMethodBeat.o(242928);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$showTips$2$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class m
    implements Animator.AnimatorListener
  {
    m(View paramView, e parame, e.a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(288265);
      this.xkv.setVisibility(8);
      e.f(jdField_this);
      e.a(parama);
      AppMethodBeat.o(288265);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<Integer>
  {
    n(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.e
 * JD-Core Version:    0.7.0.1
 */