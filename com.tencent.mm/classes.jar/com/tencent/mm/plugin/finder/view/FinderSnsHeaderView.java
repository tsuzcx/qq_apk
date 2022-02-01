package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.s;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.convert.cg;
import com.tencent.mm.plugin.finder.convert.cm;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bcq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.view.recyclerview.HorizontalRecyclerView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "clearBtn", "Landroid/view/View;", "getClearBtn", "()Landroid/view/View;", "setClearBtn", "(Landroid/view/View;)V", "contentView", "getContentView", "setContentView", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "setLayoutManager", "(Landroid/support/v7/widget/LinearLayoutManager;)V", "mSnsScrollListener", "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1;", "presenter", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/HorizontalRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/HorizontalRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/HorizontalRecyclerView;)V", "viewCallback", "Lcom/tencent/mm/view/DefaultViewActionCallback;", "getViewCallback", "()Lcom/tencent/mm/view/DefaultViewActionCallback;", "visibilityChangedListener", "Lkotlin/Function1;", "", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkVisibility", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "initView", "refreshClearBtn", "setOnInterceptListener", "listener", "", "setVisibilityChangedListener", "showSettingMenu", "plugin-finder_release"})
public final class FinderSnsHeaderView
  extends FrameLayout
{
  private final String TAG;
  public View contentView;
  public LinearLayoutManager vKp;
  public k woG;
  public HorizontalRecyclerView woN;
  private kotlin.g.a.b<? super Integer, x> woO;
  public View woP;
  private final com.tencent.mm.view.c woQ;
  final e woR;
  
  public FinderSnsHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(254957);
    this.TAG = "Finder.FinderSnsHeaderView";
    this.woQ = ((com.tencent.mm.view.c)new h(this));
    this.woR = new e();
    AppMethodBeat.o(254957);
  }
  
  public FinderSnsHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254958);
    this.TAG = "Finder.FinderSnsHeaderView";
    this.woQ = ((com.tencent.mm.view.c)new h(this));
    this.woR = new e();
    AppMethodBeat.o(254958);
  }
  
  public FinderSnsHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254959);
    this.TAG = "Finder.FinderSnsHeaderView";
    this.woQ = ((com.tencent.mm.view.c)new h(this));
    this.woR = new e();
    AppMethodBeat.o(254959);
  }
  
  public final void dHd()
  {
    AppMethodBeat.i(254956);
    int i;
    Object localObject;
    if ((z.aUd() & 0x0) == 0L)
    {
      i = 1;
      localObject = this.woG;
      if (localObject == null) {
        p.btv("presenter");
      }
      if ((!((k)localObject).kgc.isEmpty()) && (i != 0)) {
        break label144;
      }
      localObject = this.contentView;
      if (localObject == null) {
        p.btv("contentView");
      }
      ((View)localObject).setVisibility(8);
      localObject = getContext();
      p.g(localObject, "context");
      setPadding(0, (int)((Context)localObject).getResources().getDimension(2131165303), 0, 0);
    }
    for (;;)
    {
      localObject = this.woO;
      if (localObject == null) {
        break label174;
      }
      View localView = this.contentView;
      if (localView == null) {
        p.btv("contentView");
      }
      ((kotlin.g.a.b)localObject).invoke(Integer.valueOf(localView.getVisibility()));
      AppMethodBeat.o(254956);
      return;
      i = 0;
      break;
      label144:
      localObject = this.contentView;
      if (localObject == null) {
        p.btv("contentView");
      }
      ((View)localObject).setVisibility(0);
      setPadding(0, 0, 0, 0);
    }
    label174:
    AppMethodBeat.o(254956);
  }
  
  final void dHe()
  {
    AppMethodBeat.i(254952);
    View localView = this.woP;
    if (localView == null) {
      p.btv("clearBtn");
    }
    localView.setVisibility(0);
    localView = this.woP;
    if (localView == null) {
      p.btv("clearBtn");
    }
    localView.post((Runnable)new f(this));
    localView = this.woP;
    if (localView == null) {
      p.btv("clearBtn");
    }
    localView.setOnClickListener((View.OnClickListener)new g(this));
    AppMethodBeat.o(254952);
  }
  
  public final View getClearBtn()
  {
    AppMethodBeat.i(254950);
    View localView = this.woP;
    if (localView == null) {
      p.btv("clearBtn");
    }
    AppMethodBeat.o(254950);
    return localView;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(254948);
    View localView = this.contentView;
    if (localView == null) {
      p.btv("contentView");
    }
    AppMethodBeat.o(254948);
    return localView;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(254955);
    RecyclerView.h localh = (RecyclerView.h)new b(this);
    AppMethodBeat.o(254955);
    return localh;
  }
  
  public final LinearLayoutManager getLayoutManager()
  {
    AppMethodBeat.i(254946);
    LinearLayoutManager localLinearLayoutManager = this.vKp;
    if (localLinearLayoutManager == null) {
      p.btv("layoutManager");
    }
    AppMethodBeat.o(254946);
    return localLinearLayoutManager;
  }
  
  public final k getPresenter()
  {
    AppMethodBeat.i(254942);
    k localk = this.woG;
    if (localk == null) {
      p.btv("presenter");
    }
    AppMethodBeat.o(254942);
    return localk;
  }
  
  public final HorizontalRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(254944);
    HorizontalRecyclerView localHorizontalRecyclerView = this.woN;
    if (localHorizontalRecyclerView == null) {
      p.btv("recyclerView");
    }
    AppMethodBeat.o(254944);
    return localHorizontalRecyclerView;
  }
  
  public final com.tencent.mm.view.c getViewCallback()
  {
    return this.woQ;
  }
  
  public final void setClearBtn(View paramView)
  {
    AppMethodBeat.i(254951);
    p.h(paramView, "<set-?>");
    this.woP = paramView;
    AppMethodBeat.o(254951);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(254949);
    p.h(paramView, "<set-?>");
    this.contentView = paramView;
    AppMethodBeat.o(254949);
  }
  
  public final void setLayoutManager(LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(254947);
    p.h(paramLinearLayoutManager, "<set-?>");
    this.vKp = paramLinearLayoutManager;
    AppMethodBeat.o(254947);
  }
  
  public final void setOnInterceptListener(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(254953);
    p.h(paramb, "listener");
    HorizontalRecyclerView localHorizontalRecyclerView = this.woN;
    if (localHorizontalRecyclerView == null) {
      p.btv("recyclerView");
    }
    localHorizontalRecyclerView.setOnInterceptChangedListener(paramb);
    AppMethodBeat.o(254953);
  }
  
  public final void setPresenter(k paramk)
  {
    AppMethodBeat.i(254943);
    p.h(paramk, "<set-?>");
    this.woG = paramk;
    AppMethodBeat.o(254943);
  }
  
  public final void setRecyclerView(HorizontalRecyclerView paramHorizontalRecyclerView)
  {
    AppMethodBeat.i(254945);
    p.h(paramHorizontalRecyclerView, "<set-?>");
    this.woN = paramHorizontalRecyclerView;
    AppMethodBeat.o(254945);
  }
  
  public final void setVisibilityChangedListener(kotlin.g.a.b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(254954);
    p.h(paramb, "listener");
    this.woO = paramb;
    AppMethodBeat.o(254954);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> EC(int paramInt)
    {
      AppMethodBeat.i(254921);
      switch (paramInt)
      {
      default: 
        localObject1 = com.tencent.mm.plugin.finder.utils.y.vXH;
        com.tencent.mm.plugin.finder.utils.y.dQ(FinderSnsHeaderView.a(this.woS), paramInt);
        localObject1 = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(254921);
        return localObject1;
      case 2004: 
        localObject1 = (com.tencent.mm.view.recyclerview.e)new cg();
        AppMethodBeat.o(254921);
        return localObject1;
      }
      Object localObject1 = new cm();
      ((cm)localObject1).tHg = 1;
      Object localObject2 = this.woS.getContext();
      p.g(localObject2, "context");
      localObject2 = ((Context)localObject2).getResources();
      p.g(localObject2, "context.resources");
      paramInt = ((Resources)localObject2).getDisplayMetrics().widthPixels;
      localObject2 = this.woS.getContext();
      p.g(localObject2, "context");
      localObject2 = ((Context)localObject2).getResources();
      p.g(localObject2, "context.resources");
      float f2 = (Math.min(((Resources)localObject2).getDisplayMetrics().heightPixels, paramInt) - com.tencent.mm.cb.a.fromDPToPix(this.woS.getContext(), 16)) / 3.5F;
      float f1 = f2;
      if (f2 <= 0.0F)
      {
        localObject2 = this.woS.getContext();
        p.g(localObject2, "context");
        f1 = ((Context)localObject2).getResources().getDimension(2131165283);
      }
      ((cm)localObject1).lineHeight = ((int)(f1 * 4.0F / 3.0F));
      localObject1 = (com.tencent.mm.view.recyclerview.e)localObject1;
      AppMethodBeat.o(254921);
      return localObject1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(254922);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
      paramRecyclerView = paramView.getContext();
      p.g(paramRecyclerView, "view.context");
      int j = (int)paramRecyclerView.getResources().getDimension(2131165289);
      paramRecyclerView = paramView.getContext();
      p.g(paramRecyclerView, "view.context");
      int k = (int)paramRecyclerView.getResources().getDimension(2131165276);
      int m = RecyclerView.bw(paramView);
      paramView = this.woS.getRecyclerView().getAdapter();
      if (paramView != null) {}
      for (int i = paramView.getItemCount(); m == 0; i = 0)
      {
        paramRect.left = j;
        paramRect.right = k;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(254922);
        return;
      }
      if (m == i - 1)
      {
        paramRect.left = k;
        paramRect.right = j;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(254922);
        return;
      }
      paramRect.left = k;
      paramRect.right = k;
      paramRect.bottom = 0;
      paramRect.top = 0;
      AppMethodBeat.o(254922);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class c
    implements g.c<com.tencent.mm.view.recyclerview.h>
  {
    c(WxRecyclerAdapter paramWxRecyclerAdapter, FinderSnsHeaderView paramFinderSnsHeaderView, k paramk) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.l
  {
    d(k paramk) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(254924);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      localObject = paramRecyclerView.getLayoutManager();
      paramRecyclerView = (RecyclerView)localObject;
      if (!(localObject instanceof LinearLayoutManager)) {
        paramRecyclerView = null;
      }
      paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
      if (paramRecyclerView != null)
      {
        paramInt = paramRecyclerView.kv();
        paramInt = this.woU.kgc.size() - paramInt;
        if (paramInt >= 0) {
          break label110;
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(254924);
        return;
        label110:
        if (5 >= paramInt)
        {
          paramRecyclerView = this.woU.woJ;
          if ((!paramRecyclerView.tUq) && (com.tencent.mm.plugin.finder.feed.model.g.tuG))
          {
            Log.i(paramRecyclerView.TAG, "begin loadMore");
            paramRecyclerView.tUq = true;
            localObject = new ch(com.tencent.mm.plugin.finder.feed.model.g.lastBuffer, paramRecyclerView.ttO);
            ((ch)localObject).pullType = 2;
            paramRecyclerView.tXj = ((ch)localObject);
            com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)paramRecyclerView.tXj);
          }
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(254925);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(254925);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(254927);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(254927);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(254926);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = com.tencent.mm.plugin.finder.report.live.k.vkd;
      com.tencent.mm.plugin.finder.report.live.k.b(paramRecyclerView, s.p.voz, "61", com.tencent.mm.plugin.finder.report.live.c.vjk);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(254926);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderSnsHeaderView paramFinderSnsHeaderView) {}
    
    public final void run()
    {
      AppMethodBeat.i(254928);
      Object localObject = new Rect();
      this.woS.getClearBtn().getHitRect((Rect)localObject);
      ((Rect)localObject).inset(((Rect)localObject).width() * -2, -((Rect)localObject).width());
      ViewParent localViewParent = this.woS.getClearBtn().getParent();
      if (localViewParent == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(254928);
        throw ((Throwable)localObject);
      }
      ((View)localViewParent).setTouchDelegate(new TouchDelegate((Rect)localObject, this.woS.getClearBtn()));
      AppMethodBeat.o(254928);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderSnsHeaderView paramFinderSnsHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(254931);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$refreshClearBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      paramView = new com.tencent.mm.ui.widget.a.e(this.woS.getContext(), 1, true);
      paramView.a((o.f)new a(this));
      paramView.a((o.g)new b(this));
      paramView.dGm();
      localObject1 = this.woS.getPresenter().aO(com.tencent.mm.plugin.finder.model.y.class);
      paramView = new StringBuilder().append(System.currentTimeMillis()).append(",1,");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        awe localawe = ((com.tencent.mm.plugin.finder.model.y)((Iterator)localObject2).next()).uOo.liveInfo;
        if (localawe != null) {}
        for (long l = localawe.liveId;; l = 0L)
        {
          ((Collection)localObject1).add(Long.valueOf(l));
          break;
        }
      }
      paramView = kotlin.a.j.a((Iterable)localObject1, (CharSequence)";", null, null, 0, null, null, 62) + ',' + ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(21530, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$refreshClearBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(254931);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$refreshClearBtn$2$1$1"})
    static final class a
      implements o.f
    {
      a(FinderSnsHeaderView.g paramg) {}
      
      public final void onCreateMMMenu(m paramm)
      {
        AppMethodBeat.i(254929);
        int i = this.woW;
        Context localContext = this.woV.woS.getContext();
        p.g(localContext, "context");
        paramm.a(i, localContext.getResources().getColor(2131099818), (CharSequence)this.woV.woS.getContext().getString(2131755764));
        if (FinderSnsHeaderView.dHf()) {
          paramm.kV(this.woX, 2131760591);
        }
        AppMethodBeat.o(254929);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$refreshClearBtn$2$1$2"})
    static final class b
      implements o.g
    {
      b(FinderSnsHeaderView.g paramg) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(254930);
        p.g(paramMenuItem, "menuItem");
        paramInt = paramMenuItem.getItemId();
        Object localObject1;
        if (paramInt == this.woW)
        {
          localObject1 = this.woV.woS.getPresenter();
          paramMenuItem = ((k)localObject1).aO(com.tencent.mm.plugin.finder.model.y.class);
          p.h(paramMenuItem, "exposed");
          d.c("FinderSnsLiveListExpose", (kotlin.g.a.a)new k.b(paramMenuItem));
          StringBuilder localStringBuilder = new StringBuilder().append(System.currentTimeMillis()).append(",2,");
          Object localObject2 = (Iterable)paramMenuItem;
          Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          Object localObject3;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((com.tencent.mm.plugin.finder.model.y)((Iterator)localObject2).next()).uOo.liveInfo;
            if (localObject3 != null) {}
            for (long l = ((awe)localObject3).liveId;; l = 0L)
            {
              localCollection.add(Long.valueOf(l));
              break;
            }
          }
          localStringBuilder = localStringBuilder.append(kotlin.a.j.a((Iterable)localCollection, (CharSequence)";", null, null, 0, null, null, 62)).append(',').append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD()).append(',');
          paramMenuItem = (Iterable)paramMenuItem;
          localCollection = (Collection)new ArrayList(kotlin.a.j.a(paramMenuItem, 10));
          localObject2 = paramMenuItem.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            paramMenuItem = ((com.tencent.mm.plugin.finder.model.y)((Iterator)localObject2).next()).uOo.snsShareInfo;
            if (paramMenuItem != null)
            {
              paramMenuItem = paramMenuItem.LLL;
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
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(21530, paramMenuItem);
          paramMenuItem = ((k)localObject1).woJ;
          paramMenuItem.kgc.clear();
          paramMenuItem.tXl.onChanged();
          AppMethodBeat.o(254930);
          return;
        }
        if (paramInt == this.woX)
        {
          paramMenuItem = this.woV.woS.getPresenter();
          localObject1 = ae.SYK;
          localObject1 = String.format("%s,%s", Arrays.copyOf(new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(3) }, 2));
          p.g(localObject1, "java.lang.String.format(format, *args)");
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(21529, (String)localObject1);
          localObject1 = paramMenuItem.dKq;
          paramMenuItem = new Intent((Context)paramMenuItem.dKq, SettingsPrivacyUI.class);
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramMenuItem.axQ(), "com/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter", "goSetting", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)paramMenuItem.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter", "goSetting", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(254930);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$viewCallback$1", "Lcom/tencent/mm/view/DefaultViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class h
    extends com.tencent.mm.view.c
  {
    public final void onChanged()
    {
      AppMethodBeat.i(254937);
      d.h((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(254937);
    }
    
    public final void onItemRangeChanged(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(254938);
      d.h((kotlin.g.a.a)new b(this, paramInt1, paramInt2));
      AppMethodBeat.o(254938);
    }
    
    public final void onItemRangeChanged(final int paramInt1, final int paramInt2, final Object paramObject)
    {
      AppMethodBeat.i(254939);
      d.h((kotlin.g.a.a)new c(this, paramInt1, paramInt2, paramObject));
      AppMethodBeat.o(254939);
    }
    
    public final void onItemRangeInserted(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(254940);
      d.h((kotlin.g.a.a)new d(this, paramInt1, paramInt2));
      AppMethodBeat.o(254940);
    }
    
    public final void onItemRangeRemoved(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(254941);
      d.h((kotlin.g.a.a)new e(this, paramInt1, paramInt2));
      AppMethodBeat.o(254941);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderSnsHeaderView.h paramh)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      b(FinderSnsHeaderView.h paramh, int paramInt1, int paramInt2)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      c(FinderSnsHeaderView.h paramh, int paramInt1, int paramInt2, Object paramObject)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class d
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      d(FinderSnsHeaderView.h paramh, int paramInt1, int paramInt2)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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