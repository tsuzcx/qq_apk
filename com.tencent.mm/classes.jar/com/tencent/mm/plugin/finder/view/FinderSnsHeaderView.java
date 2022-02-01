package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.cl;
import com.tencent.mm.plugin.finder.convert.cn;
import com.tencent.mm.plugin.finder.convert.ct;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.view.recyclerview.HorizontalRecyclerView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "clearBtn", "Landroid/view/View;", "getClearBtn", "()Landroid/view/View;", "setClearBtn", "(Landroid/view/View;)V", "contentView", "getContentView", "setContentView", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "mSnsScrollListener", "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1;", "presenter", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/HorizontalRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/HorizontalRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/HorizontalRecyclerView;)V", "viewCallback", "Lcom/tencent/mm/view/DefaultViewActionCallback;", "getViewCallback", "()Lcom/tencent/mm/view/DefaultViewActionCallback;", "visibilityChangedListener", "Lkotlin/Function1;", "", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkVisibility", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "initView", "refreshClearBtn", "setOnInterceptListener", "listener", "", "setVisibilityChangedListener", "showSettingMenu", "plugin-finder_release"})
public final class FinderSnsHeaderView
  extends FrameLayout
{
  public m AZP;
  public HorizontalRecyclerView AZW;
  private kotlin.g.a.b<? super Integer, x> AZX;
  public View AZY;
  private final com.tencent.mm.view.c AZZ;
  public LinearLayoutManager Arh;
  final e Baa;
  private final String TAG;
  public View contentView;
  
  public FinderSnsHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(274509);
    this.TAG = "Finder.FinderSnsHeaderView";
    this.AZZ = ((com.tencent.mm.view.c)new h(this));
    this.Baa = new e();
    AppMethodBeat.o(274509);
  }
  
  public FinderSnsHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(274510);
    this.TAG = "Finder.FinderSnsHeaderView";
    this.AZZ = ((com.tencent.mm.view.c)new h(this));
    this.Baa = new e();
    AppMethodBeat.o(274510);
  }
  
  public FinderSnsHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(274511);
    this.TAG = "Finder.FinderSnsHeaderView";
    this.AZZ = ((com.tencent.mm.view.c)new h(this));
    this.Baa = new e();
    AppMethodBeat.o(274511);
  }
  
  public final void eje()
  {
    AppMethodBeat.i(274508);
    int i;
    Object localObject;
    if ((z.bde() & 0x0) == 0L)
    {
      i = 1;
      localObject = this.AZP;
      if (localObject == null) {
        p.bGy("presenter");
      }
      if ((!((m)localObject).mXB.isEmpty()) && (i != 0)) {
        break label144;
      }
      localObject = this.contentView;
      if (localObject == null) {
        p.bGy("contentView");
      }
      ((View)localObject).setVisibility(8);
      localObject = getContext();
      p.j(localObject, "context");
      setPadding(0, (int)((Context)localObject).getResources().getDimension(b.d.Edge_4A), 0, 0);
    }
    for (;;)
    {
      localObject = this.AZX;
      if (localObject == null) {
        break label174;
      }
      View localView = this.contentView;
      if (localView == null) {
        p.bGy("contentView");
      }
      ((kotlin.g.a.b)localObject).invoke(Integer.valueOf(localView.getVisibility()));
      AppMethodBeat.o(274508);
      return;
      i = 0;
      break;
      label144:
      localObject = this.contentView;
      if (localObject == null) {
        p.bGy("contentView");
      }
      ((View)localObject).setVisibility(0);
      setPadding(0, 0, 0, 0);
    }
    label174:
    AppMethodBeat.o(274508);
  }
  
  final void ejf()
  {
    AppMethodBeat.i(274500);
    View localView = this.AZY;
    if (localView == null) {
      p.bGy("clearBtn");
    }
    localView.setVisibility(0);
    localView = this.AZY;
    if (localView == null) {
      p.bGy("clearBtn");
    }
    localView.post((Runnable)new f(this));
    localView = this.AZY;
    if (localView == null) {
      p.bGy("clearBtn");
    }
    localView.setOnClickListener((View.OnClickListener)new g(this));
    AppMethodBeat.o(274500);
  }
  
  public final View getClearBtn()
  {
    AppMethodBeat.i(274496);
    View localView = this.AZY;
    if (localView == null) {
      p.bGy("clearBtn");
    }
    AppMethodBeat.o(274496);
    return localView;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(274492);
    View localView = this.contentView;
    if (localView == null) {
      p.bGy("contentView");
    }
    AppMethodBeat.o(274492);
    return localView;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(274506);
    RecyclerView.h localh = (RecyclerView.h)new b(this);
    AppMethodBeat.o(274506);
    return localh;
  }
  
  public final LinearLayoutManager getLayoutManager()
  {
    AppMethodBeat.i(274490);
    LinearLayoutManager localLinearLayoutManager = this.Arh;
    if (localLinearLayoutManager == null) {
      p.bGy("layoutManager");
    }
    AppMethodBeat.o(274490);
    return localLinearLayoutManager;
  }
  
  public final m getPresenter()
  {
    AppMethodBeat.i(274486);
    m localm = this.AZP;
    if (localm == null) {
      p.bGy("presenter");
    }
    AppMethodBeat.o(274486);
    return localm;
  }
  
  public final HorizontalRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(274488);
    HorizontalRecyclerView localHorizontalRecyclerView = this.AZW;
    if (localHorizontalRecyclerView == null) {
      p.bGy("recyclerView");
    }
    AppMethodBeat.o(274488);
    return localHorizontalRecyclerView;
  }
  
  public final com.tencent.mm.view.c getViewCallback()
  {
    return this.AZZ;
  }
  
  public final void setClearBtn(View paramView)
  {
    AppMethodBeat.i(274498);
    p.k(paramView, "<set-?>");
    this.AZY = paramView;
    AppMethodBeat.o(274498);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(274494);
    p.k(paramView, "<set-?>");
    this.contentView = paramView;
    AppMethodBeat.o(274494);
  }
  
  public final void setLayoutManager(LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(274491);
    p.k(paramLinearLayoutManager, "<set-?>");
    this.Arh = paramLinearLayoutManager;
    AppMethodBeat.o(274491);
  }
  
  public final void setOnInterceptListener(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(274502);
    p.k(paramb, "listener");
    HorizontalRecyclerView localHorizontalRecyclerView = this.AZW;
    if (localHorizontalRecyclerView == null) {
      p.bGy("recyclerView");
    }
    localHorizontalRecyclerView.setOnInterceptChangedListener(paramb);
    AppMethodBeat.o(274502);
  }
  
  public final void setPresenter(m paramm)
  {
    AppMethodBeat.i(274487);
    p.k(paramm, "<set-?>");
    this.AZP = paramm;
    AppMethodBeat.o(274487);
  }
  
  public final void setRecyclerView(HorizontalRecyclerView paramHorizontalRecyclerView)
  {
    AppMethodBeat.i(274489);
    p.k(paramHorizontalRecyclerView, "<set-?>");
    this.AZW = paramHorizontalRecyclerView;
    AppMethodBeat.o(274489);
  }
  
  public final void setVisibilityChangedListener(kotlin.g.a.b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(274504);
    p.k(paramb, "listener");
    this.AZX = paramb;
    AppMethodBeat.o(274504);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(290053);
      switch (paramInt)
      {
      default: 
        localObject1 = aj.AGc;
        aj.em(FinderSnsHeaderView.a(this.Bab), paramInt);
        localObject1 = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(290053);
        return localObject1;
      case 2004: 
        localObject1 = (com.tencent.mm.view.recyclerview.e)new cn();
        AppMethodBeat.o(290053);
        return localObject1;
      }
      Object localObject1 = new ct();
      ((ct)localObject1).xpS = 1;
      Object localObject2 = this.Bab.getContext();
      p.j(localObject2, "context");
      localObject2 = ((Context)localObject2).getResources();
      p.j(localObject2, "context.resources");
      paramInt = ((Resources)localObject2).getDisplayMetrics().widthPixels;
      localObject2 = this.Bab.getContext();
      p.j(localObject2, "context");
      localObject2 = ((Context)localObject2).getResources();
      p.j(localObject2, "context.resources");
      float f2 = (Math.min(((Resources)localObject2).getDisplayMetrics().heightPixels, paramInt) - com.tencent.mm.ci.a.fromDPToPix(this.Bab.getContext(), 16)) / 3.5F;
      float f1 = f2;
      if (f2 <= 0.0F)
      {
        localObject2 = this.Bab.getContext();
        p.j(localObject2, "context");
        f1 = ((Context)localObject2).getResources().getDimension(b.d.Edge_14A);
      }
      ((ct)localObject1).lineHeight = ((int)(f1 * 4.0F / 3.0F));
      localObject1 = (com.tencent.mm.view.recyclerview.e)localObject1;
      AppMethodBeat.o(290053);
      return localObject1;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$getItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(273198);
      p.k(paramRect, "outRect");
      p.k(paramView, "view");
      p.k(paramRecyclerView, "parent");
      p.k(params, "state");
      paramRecyclerView = paramView.getContext();
      p.j(paramRecyclerView, "view.context");
      int j = (int)paramRecyclerView.getResources().getDimension(b.d.Edge_1_5_A);
      paramRecyclerView = paramView.getContext();
      p.j(paramRecyclerView, "view.context");
      int k = (int)paramRecyclerView.getResources().getDimension(b.d.Edge_0_25A);
      int m = RecyclerView.bh(paramView);
      paramView = this.Bab.getRecyclerView().getAdapter();
      if (paramView != null) {}
      for (int i = paramView.getItemCount(); m == 0; i = 0)
      {
        paramRect.left = j;
        paramRect.right = k;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(273198);
        return;
      }
      if (m == i - 1)
      {
        paramRect.left = k;
        paramRect.right = j;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(273198);
        return;
      }
      paramRect.left = k;
      paramRect.right = k;
      paramRect.bottom = 0;
      paramRect.top = 0;
      AppMethodBeat.o(273198);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class c
    implements h.c<i>
  {
    c(WxRecyclerAdapter paramWxRecyclerAdapter, FinderSnsHeaderView paramFinderSnsHeaderView, m paramm) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.l
  {
    d(m paramm) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(289406);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      localObject = paramRecyclerView.getLayoutManager();
      paramRecyclerView = (RecyclerView)localObject;
      if (!(localObject instanceof LinearLayoutManager)) {
        paramRecyclerView = null;
      }
      paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
      if (paramRecyclerView != null)
      {
        paramInt = paramRecyclerView.kM();
        paramInt = this.Bad.mXB.size() - paramInt;
        if (paramInt >= 0) {
          break label110;
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(289406);
        return;
        label110:
        if (5 >= paramInt)
        {
          paramRecyclerView = this.Bad.AZS;
          if ((!paramRecyclerView.xFl) && (com.tencent.mm.plugin.finder.feed.model.l.xcp))
          {
            Log.i(paramRecyclerView.TAG, "begin loadMore");
            paramRecyclerView.xFl = true;
            localObject = new cl(com.tencent.mm.plugin.finder.feed.model.l.lastBuffer, paramRecyclerView.xbu);
            ((cl)localObject).pullType = 2;
            paramRecyclerView.xJj = ((cl)localObject);
            com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)paramRecyclerView.xJj);
          }
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(289408);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(289408);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(285376);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(285376);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(285375);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = k.yBj;
      k.b(paramRecyclerView, s.t.yGM, "61", com.tencent.mm.plugin.finder.live.report.c.yAn);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(285375);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderSnsHeaderView paramFinderSnsHeaderView) {}
    
    public final void run()
    {
      AppMethodBeat.i(279885);
      Object localObject = new Rect();
      this.Bab.getClearBtn().getHitRect((Rect)localObject);
      ((Rect)localObject).inset(((Rect)localObject).width() * -2, -((Rect)localObject).width());
      ViewParent localViewParent = this.Bab.getClearBtn().getParent();
      if (localViewParent == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(279885);
        throw ((Throwable)localObject);
      }
      ((View)localViewParent).setTouchDelegate(new TouchDelegate((Rect)localObject, this.Bab.getClearBtn()));
      AppMethodBeat.o(279885);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderSnsHeaderView paramFinderSnsHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(281105);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$refreshClearBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = new com.tencent.mm.ui.widget.a.e(this.Bab.getContext(), 1, true);
      paramView.a((q.f)new a(this));
      paramView.a((q.g)new b(this));
      paramView.eik();
      localObject1 = this.Bab.getPresenter().aL(y.class);
      paramView = new StringBuilder().append(System.currentTimeMillis()).append(",1,");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        bac localbac = ((y)((Iterator)localObject2).next()).zAF.liveInfo;
        if (localbac != null) {}
        for (long l = localbac.liveId;; l = 0L)
        {
          ((Collection)localObject1).add(Long.valueOf(l));
          break;
        }
      }
      paramView = kotlin.a.j.a((Iterable)localObject1, (CharSequence)";", null, null, 0, null, null, 62) + ',' + ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(21530, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$refreshClearBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(281105);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$refreshClearBtn$2$1$1"})
    static final class a
      implements q.f
    {
      a(FinderSnsHeaderView.g paramg) {}
      
      public final void onCreateMMMenu(o paramo)
      {
        AppMethodBeat.i(269775);
        int i = this.Baf;
        Context localContext = this.Bae.Bab.getContext();
        p.j(localContext, "context");
        paramo.a(i, localContext.getResources().getColor(b.c.Red), (CharSequence)this.Bae.Bab.getContext().getString(b.j.app_clear));
        if (FinderSnsHeaderView.ejg()) {
          paramo.mn(this.Bag, b.j.finder_sns_live_list_setting_tips);
        }
        AppMethodBeat.o(269775);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$refreshClearBtn$2$1$2"})
    static final class b
      implements q.g
    {
      b(FinderSnsHeaderView.g paramg) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(278469);
        p.j(paramMenuItem, "menuItem");
        paramInt = paramMenuItem.getItemId();
        Object localObject1;
        if (paramInt == this.Baf)
        {
          localObject1 = this.Bae.Bab.getPresenter();
          paramMenuItem = ((m)localObject1).aL(y.class);
          p.k(paramMenuItem, "exposed");
          d.c("FinderSnsLiveListExpose", (kotlin.g.a.a)new m.b(paramMenuItem));
          StringBuilder localStringBuilder = new StringBuilder().append(System.currentTimeMillis()).append(",2,");
          Object localObject2 = (Iterable)paramMenuItem;
          Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          Object localObject3;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((y)((Iterator)localObject2).next()).zAF.liveInfo;
            if (localObject3 != null) {}
            for (long l = ((bac)localObject3).liveId;; l = 0L)
            {
              localCollection.add(Long.valueOf(l));
              break;
            }
          }
          localStringBuilder = localStringBuilder.append(kotlin.a.j.a((Iterable)localCollection, (CharSequence)";", null, null, 0, null, null, 62)).append(',').append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr()).append(',');
          paramMenuItem = (Iterable)paramMenuItem;
          localCollection = (Collection)new ArrayList(kotlin.a.j.a(paramMenuItem, 10));
          localObject2 = paramMenuItem.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            paramMenuItem = ((y)((Iterator)localObject2).next()).zAF.snsShareInfo;
            if (paramMenuItem != null)
            {
              paramMenuItem = paramMenuItem.STE;
              if (paramMenuItem != null)
              {
                localObject3 = (Iterable)paramMenuItem;
                paramMenuItem = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
                localObject3 = ((Iterable)localObject3).iterator();
                while (((Iterator)localObject3).hasNext()) {
                  paramMenuItem.add(((FinderContact)((Iterator)localObject3).next()).username);
                }
              }
            }
            for (paramMenuItem = kotlin.a.j.a((Iterable)paramMenuItem, (CharSequence)";", null, null, 0, null, null, 62);; paramMenuItem = null)
            {
              localCollection.add(paramMenuItem);
              break;
            }
          }
          paramMenuItem = kotlin.a.j.a((Iterable)localCollection, (CharSequence)"#", null, null, 0, null, null, 62);
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(21530, paramMenuItem);
          paramMenuItem = ((m)localObject1).AZS;
          paramMenuItem.mXB.clear();
          paramMenuItem.xJl.onChanged();
          AppMethodBeat.o(278469);
          return;
        }
        if (paramInt == this.Bag)
        {
          paramMenuItem = this.Bae.Bab.getPresenter();
          localObject1 = af.aaBG;
          localObject1 = String.format("%s,%s", Arrays.copyOf(new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(3) }, 2));
          p.j(localObject1, "java.lang.String.format(format, *args)");
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(21529, (String)localObject1);
          localObject1 = paramMenuItem.fDf;
          paramMenuItem = new Intent((Context)paramMenuItem.fDf, SettingsPrivacyUI.class);
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramMenuItem.aFh(), "com/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter", "goSetting", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)paramMenuItem.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter", "goSetting", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(278469);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$viewCallback$1", "Lcom/tencent/mm/view/DefaultViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class h
    extends com.tencent.mm.view.c
  {
    public final void onChanged()
    {
      AppMethodBeat.i(288277);
      d.uiThread((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(288277);
    }
    
    public final void onItemRangeChanged(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(288278);
      d.uiThread((kotlin.g.a.a)new b(this, paramInt1, paramInt2));
      AppMethodBeat.o(288278);
    }
    
    public final void onItemRangeChanged(final int paramInt1, final int paramInt2, final Object paramObject)
    {
      AppMethodBeat.i(288279);
      d.uiThread((kotlin.g.a.a)new c(this, paramInt1, paramInt2, paramObject));
      AppMethodBeat.o(288279);
    }
    
    public final void onItemRangeInserted(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(288280);
      d.uiThread((kotlin.g.a.a)new d(this, paramInt1, paramInt2));
      AppMethodBeat.o(288280);
    }
    
    public final void onItemRangeRemoved(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(288281);
      d.uiThread((kotlin.g.a.a)new e(this, paramInt1, paramInt2));
      AppMethodBeat.o(288281);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderSnsHeaderView.h paramh)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      b(FinderSnsHeaderView.h paramh, int paramInt1, int paramInt2)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      c(FinderSnsHeaderView.h paramh, int paramInt1, int paramInt2, Object paramObject)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class d
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      d(FinderSnsHeaderView.h paramh, int paramInt1, int paramInt2)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class e
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      e(FinderSnsHeaderView.h paramh, int paramInt1, int paramInt2)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderSnsHeaderView
 * JD-Core Version:    0.7.0.1
 */