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
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.dm;
import com.tencent.mm.plugin.finder.convert.cp;
import com.tencent.mm.plugin.finder.convert.cw;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.l;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bvv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.view.c;
import com.tencent.mm.view.k;
import com.tencent.mm.view.recyclerview.HorizontalRecyclerView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "clearBtn", "Landroid/view/View;", "getClearBtn", "()Landroid/view/View;", "setClearBtn", "(Landroid/view/View;)V", "contentView", "getContentView", "setContentView", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "mSnsScrollListener", "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1;", "presenter", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/HorizontalRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/HorizontalRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/HorizontalRecyclerView;)V", "viewCallback", "Lcom/tencent/mm/view/DefaultViewActionCallback;", "getViewCallback", "()Lcom/tencent/mm/view/DefaultViewActionCallback;", "visibilityChangedListener", "Lkotlin/Function1;", "", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkVisibility", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "initView", "refreshClearBtn", "setOnInterceptListener", "listener", "", "setVisibilityChangedListener", "showSettingMenu", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSnsHeaderView
  extends FrameLayout
{
  public LinearLayoutManager AJH;
  public p GCm;
  public HorizontalRecyclerView GCt;
  private kotlin.g.a.b<? super Integer, ah> GCu;
  public View GCv;
  private final c GCw;
  final e GCx;
  private final String TAG;
  public View contentView;
  
  public FinderSnsHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(345140);
    this.TAG = "Finder.FinderSnsHeaderView";
    this.GCw = ((c)new f(this));
    this.GCx = new e();
    AppMethodBeat.o(345140);
  }
  
  public FinderSnsHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(345151);
    this.TAG = "Finder.FinderSnsHeaderView";
    this.GCw = ((c)new f(this));
    this.GCx = new e();
    AppMethodBeat.o(345151);
  }
  
  public FinderSnsHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(345164);
    this.TAG = "Finder.FinderSnsHeaderView";
    this.GCw = ((c)new f(this));
    this.GCx = new e();
    AppMethodBeat.o(345164);
  }
  
  private static final void a(int paramInt1, FinderSnsHeaderView paramFinderSnsHeaderView, int paramInt2, MenuItem paramMenuItem, int paramInt3)
  {
    AppMethodBeat.i(345229);
    kotlin.g.b.s.u(paramFinderSnsHeaderView, "this$0");
    paramInt3 = paramMenuItem.getItemId();
    if (paramInt3 == paramInt1)
    {
      paramMenuItem = paramFinderSnsHeaderView.getPresenter();
      paramFinderSnsHeaderView = paramMenuItem.bg(com.tencent.mm.plugin.finder.model.z.class);
      kotlin.g.b.s.u(paramFinderSnsHeaderView, "exposed");
      com.tencent.mm.ae.d.e("FinderSnsLiveListExpose", (kotlin.g.a.a)new p.a(paramFinderSnsHeaderView));
      StringBuilder localStringBuilder = new StringBuilder().append(System.currentTimeMillis()).append(",2,");
      Object localObject1 = (Iterable)paramFinderSnsHeaderView;
      Collection localCollection = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((com.tencent.mm.plugin.finder.model.z)((Iterator)localObject1).next()).ECN.liveInfo;
        if (localObject2 == null) {}
        for (long l = 0L;; l = ((bip)localObject2).liveId)
        {
          localCollection.add(Long.valueOf(l));
          break;
        }
      }
      localStringBuilder = localStringBuilder.append(kotlin.a.p.a((Iterable)localCollection, (CharSequence)";", null, null, 0, null, null, 62)).append(',').append(((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN()).append(',');
      paramFinderSnsHeaderView = (Iterable)paramFinderSnsHeaderView;
      localCollection = (Collection)new ArrayList(kotlin.a.p.a(paramFinderSnsHeaderView, 10));
      localObject1 = paramFinderSnsHeaderView.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        paramFinderSnsHeaderView = ((com.tencent.mm.plugin.finder.model.z)((Iterator)localObject1).next()).ECN.snsShareInfo;
        if (paramFinderSnsHeaderView == null) {
          paramFinderSnsHeaderView = null;
        }
        for (;;)
        {
          localCollection.add(paramFinderSnsHeaderView);
          break;
          paramFinderSnsHeaderView = paramFinderSnsHeaderView.aadI;
          if (paramFinderSnsHeaderView == null)
          {
            paramFinderSnsHeaderView = null;
          }
          else
          {
            localObject2 = (Iterable)paramFinderSnsHeaderView;
            paramFinderSnsHeaderView = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              paramFinderSnsHeaderView.add(((FinderContact)((Iterator)localObject2).next()).username);
            }
            paramFinderSnsHeaderView = kotlin.a.p.a((Iterable)paramFinderSnsHeaderView, (CharSequence)";", null, null, 0, null, null, 62);
          }
        }
      }
      paramFinderSnsHeaderView = kotlin.a.p.a((Iterable)localCollection, (CharSequence)"#", null, null, 0, null, null, 62);
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(21530, paramFinderSnsHeaderView);
      paramFinderSnsHeaderView = paramMenuItem.GCp;
      paramFinderSnsHeaderView.pUj.clear();
      paramFinderSnsHeaderView.BiU.onChanged();
      AppMethodBeat.o(345229);
      return;
    }
    if (paramInt3 == paramInt2)
    {
      paramFinderSnsHeaderView = paramFinderSnsHeaderView.getPresenter();
      paramMenuItem = am.aixg;
      paramMenuItem = String.format("%s,%s", Arrays.copyOf(new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(3) }, 2));
      kotlin.g.b.s.s(paramMenuItem, "java.lang.String.format(format, *args)");
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(21529, paramMenuItem);
      paramMenuItem = paramFinderSnsHeaderView.hHU;
      paramFinderSnsHeaderView = new Intent((Context)paramFinderSnsHeaderView.hHU, SettingsPrivacyUI.class);
      paramFinderSnsHeaderView = new com.tencent.mm.hellhoundlib.b.a().cG(paramFinderSnsHeaderView);
      com.tencent.mm.hellhoundlib.a.a.b(paramMenuItem, paramFinderSnsHeaderView.aYi(), "com/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter", "goSetting", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramMenuItem.startActivity((Intent)paramFinderSnsHeaderView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramMenuItem, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter", "goSetting", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(345229);
  }
  
  private static final void a(int paramInt1, FinderSnsHeaderView paramFinderSnsHeaderView, int paramInt2, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(345202);
    kotlin.g.b.s.u(paramFinderSnsHeaderView, "this$0");
    params.a(paramInt1, paramFinderSnsHeaderView.getContext().getResources().getColor(e.b.Red), (CharSequence)paramFinderSnsHeaderView.getContext().getString(e.h.app_clear));
    paramFinderSnsHeaderView = com.tencent.mm.kernel.h.baE().ban().get(at.a.adel, Integer.valueOf(0));
    if (paramFinderSnsHeaderView == null)
    {
      paramFinderSnsHeaderView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(345202);
      throw paramFinderSnsHeaderView;
    }
    if (((Integer)paramFinderSnsHeaderView).intValue() == 1) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        params.oh(paramInt2, e.h.finder_sns_live_list_setting_tips);
      }
      AppMethodBeat.o(345202);
      return;
    }
  }
  
  private static final void a(FinderSnsHeaderView paramFinderSnsHeaderView)
  {
    AppMethodBeat.i(345185);
    kotlin.g.b.s.u(paramFinderSnsHeaderView, "this$0");
    Rect localRect = new Rect();
    paramFinderSnsHeaderView.getClearBtn().getHitRect(localRect);
    localRect.inset(localRect.width() * -2, -localRect.width());
    ViewParent localViewParent = paramFinderSnsHeaderView.getClearBtn().getParent();
    if (localViewParent == null)
    {
      paramFinderSnsHeaderView = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(345185);
      throw paramFinderSnsHeaderView;
    }
    ((View)localViewParent).setTouchDelegate(new TouchDelegate(localRect, paramFinderSnsHeaderView.getClearBtn()));
    AppMethodBeat.o(345185);
  }
  
  private static final void a(FinderSnsHeaderView paramFinderSnsHeaderView, View paramView)
  {
    AppMethodBeat.i(345244);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderSnsHeaderView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramFinderSnsHeaderView, "this$0");
    paramView = new com.tencent.mm.ui.widget.a.f(paramFinderSnsHeaderView.getContext(), 1, true);
    paramView.Vtg = new FinderSnsHeaderView..ExternalSyntheticLambda1(1, paramFinderSnsHeaderView, 2);
    paramView.GAC = new FinderSnsHeaderView..ExternalSyntheticLambda2(1, paramFinderSnsHeaderView, 2);
    paramView.dDn();
    paramView = paramFinderSnsHeaderView.getPresenter().bg(com.tencent.mm.plugin.finder.model.z.class);
    paramFinderSnsHeaderView = new StringBuilder().append(System.currentTimeMillis()).append(",1,");
    localObject1 = (Iterable)paramView;
    paramView = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((com.tencent.mm.plugin.finder.model.z)((Iterator)localObject1).next()).ECN.liveInfo;
      if (localObject2 == null) {}
      for (long l = 0L;; l = ((bip)localObject2).liveId)
      {
        paramView.add(Long.valueOf(l));
        break;
      }
    }
    paramFinderSnsHeaderView = kotlin.a.p.a((Iterable)paramView, (CharSequence)";", null, null, 0, null, null, 62) + ',' + ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(21530, paramFinderSnsHeaderView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345244);
  }
  
  public final void flj()
  {
    AppMethodBeat.i(345469);
    int i;
    if ((com.tencent.mm.model.z.bAR() & 0x0) == 0L)
    {
      i = 1;
      if ((!getPresenter().pUj.isEmpty()) && (i != 0)) {
        break label105;
      }
      getContentView().setVisibility(8);
      setPadding(0, (int)getContext().getResources().getDimension(e.c.Edge_4A), 0, 0);
    }
    for (;;)
    {
      kotlin.g.a.b localb = this.GCu;
      if (localb != null) {
        localb.invoke(Integer.valueOf(getContentView().getVisibility()));
      }
      AppMethodBeat.o(345469);
      return;
      i = 0;
      break;
      label105:
      getContentView().setVisibility(0);
      setPadding(0, 0, 0, 0);
    }
  }
  
  final void flk()
  {
    AppMethodBeat.i(345426);
    getClearBtn().setVisibility(0);
    getClearBtn().post(new FinderSnsHeaderView..ExternalSyntheticLambda3(this));
    getClearBtn().setOnClickListener(new FinderSnsHeaderView..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(345426);
  }
  
  public final View getClearBtn()
  {
    AppMethodBeat.i(345397);
    View localView = this.GCv;
    if (localView != null)
    {
      AppMethodBeat.o(345397);
      return localView;
    }
    kotlin.g.b.s.bIx("clearBtn");
    AppMethodBeat.o(345397);
    return null;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(345376);
    View localView = this.contentView;
    if (localView != null)
    {
      AppMethodBeat.o(345376);
      return localView;
    }
    kotlin.g.b.s.bIx("contentView");
    AppMethodBeat.o(345376);
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(345452);
    RecyclerView.h localh = (RecyclerView.h)new b(this);
    AppMethodBeat.o(345452);
    return localh;
  }
  
  public final LinearLayoutManager getLayoutManager()
  {
    AppMethodBeat.i(345358);
    LinearLayoutManager localLinearLayoutManager = this.AJH;
    if (localLinearLayoutManager != null)
    {
      AppMethodBeat.o(345358);
      return localLinearLayoutManager;
    }
    kotlin.g.b.s.bIx("layoutManager");
    AppMethodBeat.o(345358);
    return null;
  }
  
  public final p getPresenter()
  {
    AppMethodBeat.i(345319);
    p localp = this.GCm;
    if (localp != null)
    {
      AppMethodBeat.o(345319);
      return localp;
    }
    kotlin.g.b.s.bIx("presenter");
    AppMethodBeat.o(345319);
    return null;
  }
  
  public final HorizontalRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(345344);
    HorizontalRecyclerView localHorizontalRecyclerView = this.GCt;
    if (localHorizontalRecyclerView != null)
    {
      AppMethodBeat.o(345344);
      return localHorizontalRecyclerView;
    }
    kotlin.g.b.s.bIx("recyclerView");
    AppMethodBeat.o(345344);
    return null;
  }
  
  public final c getViewCallback()
  {
    return this.GCw;
  }
  
  public final void setClearBtn(View paramView)
  {
    AppMethodBeat.i(345411);
    kotlin.g.b.s.u(paramView, "<set-?>");
    this.GCv = paramView;
    AppMethodBeat.o(345411);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(345386);
    kotlin.g.b.s.u(paramView, "<set-?>");
    this.contentView = paramView;
    AppMethodBeat.o(345386);
  }
  
  public final void setLayoutManager(LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(345368);
    kotlin.g.b.s.u(paramLinearLayoutManager, "<set-?>");
    this.AJH = paramLinearLayoutManager;
    AppMethodBeat.o(345368);
  }
  
  public final void setOnInterceptListener(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(345439);
    kotlin.g.b.s.u(paramb, "listener");
    getRecyclerView().setOnInterceptChangedListener(paramb);
    AppMethodBeat.o(345439);
  }
  
  public final void setPresenter(p paramp)
  {
    AppMethodBeat.i(345333);
    kotlin.g.b.s.u(paramp, "<set-?>");
    this.GCm = paramp;
    AppMethodBeat.o(345333);
  }
  
  public final void setRecyclerView(HorizontalRecyclerView paramHorizontalRecyclerView)
  {
    AppMethodBeat.i(345350);
    kotlin.g.b.s.u(paramHorizontalRecyclerView, "<set-?>");
    this.GCt = paramHorizontalRecyclerView;
    AppMethodBeat.o(345350);
  }
  
  public final void setVisibilityChangedListener(kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(345448);
    kotlin.g.b.s.u(paramb, "listener");
    this.GCu = paramb;
    AppMethodBeat.o(345448);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    a(FinderSnsHeaderView paramFinderSnsHeaderView) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(344473);
      switch (paramInt)
      {
      default: 
        localObject = av.GiL;
        av.eY(FinderSnsHeaderView.b(this.GCy), paramInt);
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
        AppMethodBeat.o(344473);
        return localObject;
      case 2004: 
        localObject = (com.tencent.mm.view.recyclerview.f)new cp();
        AppMethodBeat.o(344473);
        return localObject;
      }
      Object localObject = new cw();
      FinderSnsHeaderView localFinderSnsHeaderView = this.GCy;
      ((cw)localObject).AMY = 1;
      paramInt = localFinderSnsHeaderView.getContext().getResources().getDisplayMetrics().widthPixels;
      float f2 = (Math.min(localFinderSnsHeaderView.getContext().getResources().getDisplayMetrics().heightPixels, paramInt) - com.tencent.mm.cd.a.fromDPToPix(localFinderSnsHeaderView.getContext(), 16)) / 3.5F;
      float f1 = f2;
      if (f2 <= 0.0F) {
        f1 = localFinderSnsHeaderView.getContext().getResources().getDimension(e.c.Edge_14A);
      }
      ((cw)localObject).lineHeight = ((int)(f1 * 4.0F / 3.0F));
      localObject = (com.tencent.mm.view.recyclerview.f)localObject;
      AppMethodBeat.o(344473);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$getItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.h
  {
    b(FinderSnsHeaderView paramFinderSnsHeaderView) {}
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(344460);
      kotlin.g.b.s.u(paramRect, "outRect");
      kotlin.g.b.s.u(paramView, "view");
      kotlin.g.b.s.u(paramRecyclerView, "parent");
      kotlin.g.b.s.u(params, "state");
      int j = (int)paramView.getContext().getResources().getDimension(e.c.Edge_1_5_A);
      int k = (int)paramView.getContext().getResources().getDimension(e.c.Edge_0_25A);
      int m = RecyclerView.bA(paramView);
      paramView = this.GCy.getRecyclerView().getAdapter();
      if (paramView == null) {}
      for (int i = 0; m == 0; i = paramView.getItemCount())
      {
        paramRect.left = j;
        paramRect.right = k;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(344460);
        return;
      }
      if (m == i - 1)
      {
        paramRect.left = k;
        paramRect.right = j;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(344460);
        return;
      }
      paramRect.left = k;
      paramRect.right = k;
      paramRect.bottom = 0;
      paramRect.top = 0;
      AppMethodBeat.o(344460);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements i.c<j>
  {
    c(WxRecyclerAdapter<cc> paramWxRecyclerAdapter, FinderSnsHeaderView paramFinderSnsHeaderView, p paramp) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.l
  {
    d(p paramp) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(344442);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof LinearLayoutManager))
      {
        paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
        if (paramRecyclerView != null)
        {
          localObject = this.GCz;
          paramInt = paramRecyclerView.Jx();
          paramInt = ((p)localObject).pUj.size() - paramInt;
          if (paramInt < 0) {
            break label206;
          }
          if (paramInt > 5) {
            break label201;
          }
          paramInt = 1;
        }
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          paramRecyclerView = ((p)localObject).GCp;
          if ((!paramRecyclerView.Bcz) && (l.ABD))
          {
            Log.i(paramRecyclerView.TAG, "begin loadMore");
            paramRecyclerView.Bcz = true;
            localObject = new dm(l.lastBuffer, paramRecyclerView.Auc);
            ((dm)localObject).pullType = 2;
            ah localah = ah.aiuX;
            paramRecyclerView.BiV = ((dm)localObject);
            com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramRecyclerView.BiV, 0);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(344442);
        return;
        paramRecyclerView = null;
        break;
        label201:
        paramInt = 0;
        continue;
        label206:
        paramInt = 0;
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(344452);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$initView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(344452);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(344439);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(344439);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(344431);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      ((ce)com.tencent.mm.kernel.h.ax(ce.class)).b(paramRecyclerView, q.w.DwO, "61", com.tencent.mm.plugin.finder.live.report.d.Dnk);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$mSnsScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(344431);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderView$viewCallback$1", "Lcom/tencent/mm/view/DefaultViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends c
  {
    f(FinderSnsHeaderView paramFinderSnsHeaderView) {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(344424);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.GCy));
      AppMethodBeat.o(344424);
    }
    
    public final void onItemRangeChanged(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(344430);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this.GCy, paramInt1, paramInt2));
      AppMethodBeat.o(344430);
    }
    
    public final void onItemRangeChanged(final int paramInt1, final int paramInt2, final Object paramObject)
    {
      AppMethodBeat.i(344437);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this.GCy, paramInt1, paramInt2, paramObject));
      AppMethodBeat.o(344437);
    }
    
    public final void onItemRangeInserted(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(344443);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this.GCy, paramInt1, paramInt2));
      AppMethodBeat.o(344443);
    }
    
    public final void onItemRangeRemoved(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(344451);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this.GCy, paramInt1, paramInt2));
      AppMethodBeat.o(344451);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(FinderSnsHeaderView paramFinderSnsHeaderView)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(FinderSnsHeaderView paramFinderSnsHeaderView, int paramInt1, int paramInt2)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<ah>
    {
      c(FinderSnsHeaderView paramFinderSnsHeaderView, int paramInt1, int paramInt2, Object paramObject)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends u
      implements kotlin.g.a.a<ah>
    {
      d(FinderSnsHeaderView paramFinderSnsHeaderView, int paramInt1, int paramInt2)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class e
      extends u
      implements kotlin.g.a.a<ah>
    {
      e(FinderSnsHeaderView paramFinderSnsHeaderView, int paramInt1, int paramInt2)
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