package com.tencent.mm.plugin.finder.nearby.live;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ad;
import com.tencent.mm.plugin.finder.convert.ah;
import com.tencent.mm.plugin.finder.convert.ai;
import com.tencent.mm.plugin.finder.convert.by;
import com.tencent.mm.plugin.finder.convert.n;
import com.tencent.mm.plugin.finder.live.report.h.a;
import com.tencent.mm.plugin.finder.live.report.h.b;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.au;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.h.d;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Set<Lcom.tencent.mm.view.recyclerview.b<Lcom.tencent.mm.view.recyclerview.a;>;>;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "parent", "Landroid/view/View;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isForceNightMode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;Landroid/view/View;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "audience21053Report", "Lcom/tencent/mm/plugin/finder/live/report/Audience21053Report;", "clLayout", "kotlin.jvm.PlatformType", "getClLayout", "()Landroid/view/View;", "clLayout$delegate", "Lkotlin/Lazy;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "rootScroll", "getRootScroll", "rootScroll$delegate", "adapteViewBackGroundColor", "", "getActivity", "getChnlExtra", "", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "getRootScrollParent", "gotoMoreLivePage", "initRecyclerView", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "initRefreshLayout", "initView", "isLocalCityPage", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "Companion", "NearbyLiveItemConvertFactory", "NearbyLiveItemDecoration", "plugin-finder-nearby_release"})
public class f
  implements b.b<bu>
{
  public static final a zEK;
  private final View kJC;
  final MMActivity xCd;
  private final kotlin.f xDO;
  private final bid xbu;
  private final boolean xnL;
  private final kotlin.f zEF;
  private final kotlin.f zEG;
  private com.tencent.mm.plugin.finder.live.report.a zEH;
  private final AbsNearByFragment zEI;
  private final b.a<bu> zEJ;
  
  static
  {
    AppMethodBeat.i(200080);
    zEK = new a((byte)0);
    AppMethodBeat.o(200080);
  }
  
  public f(MMActivity paramMMActivity, AbsNearByFragment paramAbsNearByFragment, b.a<bu> parama, View paramView, bid parambid, boolean paramBoolean)
  {
    AppMethodBeat.i(200079);
    this.xCd = paramMMActivity;
    this.zEI = paramAbsNearByFragment;
    this.zEJ = parama;
    this.kJC = paramView;
    this.xbu = parambid;
    this.xnL = paramBoolean;
    this.xDO = g.ar((kotlin.g.a.a)new k(this));
    this.zEF = g.ar((kotlin.g.a.a)new d(this));
    this.zEG = g.ar((kotlin.g.a.a)new l(this));
    this.zEH = new com.tencent.mm.plugin.finder.live.report.a();
    AppMethodBeat.o(200079);
  }
  
  private final View dLF()
  {
    AppMethodBeat.i(200076);
    View localView = (View)this.zEF.getValue();
    AppMethodBeat.o(200076);
    return localView;
  }
  
  private final boolean dLG()
  {
    return this.xbu.xkX == 112;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(200074);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.xDO.getValue();
    AppMethodBeat.o(200074);
    return localRefreshLoadMoreLayout;
  }
  
  public final void ab(final ArrayList<bu> paramArrayList)
  {
    AppMethodBeat.i(200071);
    p.k(paramArrayList, "data");
    if (this.xnL)
    {
      getRlLayout().setBackgroundColor(this.kJC.getResources().getColor(com.tencent.mm.plugin.finder.nearby.f.a.Dark_0));
      dLF().setBackgroundColor(this.kJC.getResources().getColor(com.tencent.mm.plugin.finder.nearby.f.a.Dark_0));
      getRlLayout().getRecyclerView().setBackgroundDrawable(this.kJC.getResources().getDrawable(com.tencent.mm.plugin.finder.nearby.f.c.finder_live_square_rv_corner_bg));
    }
    Object localObject1;
    for (;;)
    {
      localObject1 = (View)this.zEG.getValue();
      p.j(localObject1, "rootScroll");
      localObject1 = ((View)localObject1).getContext();
      p.j(localObject1, "rootScroll.context");
      localObject1 = ((Context)localObject1).getResources();
      getRlLayout().setLimitTopRequest((int)((Resources)localObject1).getDimension(com.tencent.mm.plugin.finder.nearby.f.b.finder_timeline_refresh_height) - (int)((Resources)localObject1).getDimension(com.tencent.mm.plugin.finder.nearby.f.b.Edge_12A));
      getRlLayout().setRefreshTargetY((int)((Resources)localObject1).getDimension(com.tencent.mm.plugin.finder.nearby.f.b.Edge_6A) - (int)((Resources)localObject1).getDimension(com.tencent.mm.plugin.finder.nearby.f.b.finder_timeline_refresh_height));
      getRlLayout().setDamping(1.85F);
      getRlLayout().setSuperNestedScroll(false);
      localObject1 = getRlLayout().getLoadMoreFooter();
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).findViewById(com.tencent.mm.plugin.finder.nearby.f.d.goto_more_live_tv);
        if (localObject1 != null) {
          ((View)localObject1).setOnClickListener((View.OnClickListener)new i(this));
        }
      }
      getRlLayout().setActionCallback((RefreshLoadMoreLayout.a)new j(this));
      localObject1 = getRlLayout().getRecyclerView();
      localObject2 = new NearbyLiveViewCallback.initRecyclerView.1();
      ((NearbyLiveViewCallback.initRecyclerView.1)localObject2).setItemPrefetchEnabled(true);
      ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)localObject2);
      ((RecyclerView)localObject1).b((RecyclerView.h)new c(this.xbu.xkX));
      localObject2 = ((RecyclerView)localObject1).getItemAnimator();
      if (localObject2 != null) {
        ((RecyclerView.f)localObject2).n(0L);
      }
      localObject2 = new h(this, paramArrayList, (com.tencent.mm.view.recyclerview.f)new b(this.xCd, this.zEJ, this.xnL, dLG(), this.xbu.xkX), paramArrayList);
      ((com.tencent.mm.view.recyclerview.h)localObject2).YSn = ((h.c)new e(this, paramArrayList));
      ((com.tencent.mm.view.recyclerview.h)localObject2).YSm = ((h.d)new f(this, paramArrayList));
      ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
      ((RecyclerView)localObject1).setHasFixedSize(true);
      ((RecyclerView)localObject1).setItemViewCacheSize(8);
      if (localObject1 != null) {
        break;
      }
      paramArrayList = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
      AppMethodBeat.o(200071);
      throw paramArrayList;
      if (dLG())
      {
        getRlLayout().setBackgroundColor(this.kJC.getResources().getColor(com.tencent.mm.plugin.finder.nearby.f.a.BW_93));
        dLF().setBackgroundColor(this.kJC.getResources().getColor(com.tencent.mm.plugin.finder.nearby.f.a.BW_93));
      }
      else
      {
        getRlLayout().setBackgroundColor(this.kJC.getResources().getColor(com.tencent.mm.plugin.finder.nearby.f.a.BW_100));
        dLF().setBackgroundColor(this.kJC.getResources().getColor(com.tencent.mm.plugin.finder.nearby.f.a.BW_100));
      }
    }
    paramArrayList = (WxRecyclerView)localObject1;
    Object localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    paramArrayList.setFlingSpeedFactor(((Number)com.tencent.mm.plugin.finder.storage.d.dUr().aSr()).intValue());
    c.a((RecyclerView)localObject1, (com.tencent.mm.view.recyclerview.d)new g(this));
    AppMethodBeat.o(200071);
  }
  
  public final RefreshLoadMoreLayout dtq()
  {
    AppMethodBeat.i(200073);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = getRlLayout();
    p.j(localRefreshLoadMoreLayout, "rlLayout");
    AppMethodBeat.o(200073);
    return localRefreshLoadMoreLayout;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(200072);
    Object localObject = getRlLayout();
    if (localObject != null)
    {
      localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
      AppMethodBeat.o(200072);
      return localObject;
    }
    AppMethodBeat.o(200072);
    return null;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(200077);
    p.k(paramConfiguration, "newConfig");
    getRlLayout().onChanged();
    AppMethodBeat.o(200077);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$NearbyLiveItemConvertFactory;", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isForceNightMode", "", "isLocalCityPage", "commentScene", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;ZZI)V", "bindLive", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "jumpProfile", "context", "Landroid/content/Context;", "feedId", "", "username", "", "plugin-finder-nearby_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.f
  {
    final MMActivity xCd;
    final int xkX;
    private final boolean xnL;
    final b.a<bu> zEJ;
    private final boolean zEL;
    
    public b(MMActivity paramMMActivity, b.a<bu> parama, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
    {
      AppMethodBeat.i(201788);
      this.xCd = paramMMActivity;
      this.zEJ = parama;
      this.xnL = paramBoolean1;
      this.zEL = paramBoolean2;
      this.xkX = paramInt;
      AppMethodBeat.o(201788);
    }
    
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(201785);
      switch (paramInt)
      {
      default: 
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
        {
          localObject = (Throwable)new RuntimeException("type invalid");
          AppMethodBeat.o(201785);
          throw ((Throwable)localObject);
        }
        break;
      case 9: 
        localObject = com.tencent.mm.plugin.finder.nearby.live.base.a.zEO;
        localObject = (e)new a(this, com.tencent.mm.plugin.finder.nearby.live.base.a.dLH(), this.xnL, this.zEL, (kotlin.g.a.m)new b(this));
        AppMethodBeat.o(201785);
        return localObject;
      case -10: 
        localObject = (e)new ah((kotlin.g.a.b)new c(this));
        AppMethodBeat.o(201785);
        return localObject;
      case -3: 
        localObject = (e)new ai();
        AppMethodBeat.o(201785);
        return localObject;
      case -5: 
        localObject = (e)new ad();
        AppMethodBeat.o(201785);
        return localObject;
      case 6: 
        localObject = (e)new by(this.xnL);
        AppMethodBeat.o(201785);
        return localObject;
      case -1: 
        localObject = (e)new n((kotlin.g.a.a)new d(this), (kotlin.g.a.a)new e(this), this.xnL);
        AppMethodBeat.o(201785);
        return localObject;
      }
      Log.printInfoStack("RecyclerViewAdapterEx", "type invalid", new Object[0]);
      Object localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
      AppMethodBeat.o(201785);
      return localObject;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$NearbyLiveItemConvertFactory$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/nearby/live/convert/NearbyLiveFeedsConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder-nearby_release"})
    public static final class a
      extends com.tencent.mm.plugin.finder.nearby.live.convert.a
    {
      a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, kotlin.g.a.m paramm)
      {
        super(paramBoolean2, paramm, localm);
      }
      
      public final void a(i parami, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(200422);
        p.k(parami, "holder");
        p.k(paramBaseFinderFeed, "item");
        super.a(parami, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        View localView = parami.RD(com.tencent.mm.plugin.finder.nearby.f.d.finder_live_online_layout);
        TextView localTextView2 = (TextView)parami.RD(com.tencent.mm.plugin.finder.nearby.f.d.rec_reason_tv);
        TextView localTextView1 = (TextView)parami.RD(com.tencent.mm.plugin.finder.nearby.f.d.watch_count_history_tv);
        paramList = paramBaseFinderFeed.feedObject.getLiveInfo();
        if ((paramList != null) && (paramList.liveStatus == 1))
        {
          p.j(localView, "liveOnLineLayout");
          localView.setVisibility(0);
          String str = paramBaseFinderFeed.feedObject.getFeedObject().recommendReason;
          paramList = str;
          if (str == null) {
            paramList = "";
          }
          p.j(paramList, "item.feedObject.feedObject.recommendReason ?: \"\"");
          if (!TextUtils.isEmpty((CharSequence)paramList)) {
            break label227;
          }
          localView.setVisibility(8);
          paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getLiveInfo();
          if (paramBaseFinderFeed == null) {
            break label253;
          }
          paramInt1 = paramBaseFinderFeed.SFG;
          label166:
          if (paramInt1 <= 0) {
            break label258;
          }
          p.j(localTextView1, "watchCountHistoryTv");
          localTextView1.setText((CharSequence)String.valueOf(com.tencent.mm.plugin.finder.utils.m.QI(paramInt1)));
          localTextView1.setVisibility(0);
        }
        for (;;)
        {
          parami = (TextView)parami.RD(com.tencent.mm.plugin.finder.nearby.f.d.finder_desc);
          p.j(parami, "descTv");
          parami.setVisibility(8);
          AppMethodBeat.o(200422);
          return;
          label227:
          p.j(localTextView2, "recReasonTv");
          localTextView2.setText((CharSequence)paramList);
          localView.setVisibility(0);
          break;
          label253:
          paramInt1 = 0;
          break label166;
          label258:
          p.j(localTextView1, "watchCountHistoryTv");
          localTextView1.setVisibility(8);
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "feedId", "", "username", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.m<Long, String, x>
    {
      b(f.b paramb)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.b<View, x>
    {
      c(f.b paramb)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.a<x>
    {
      d(f.b paramb)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class e
      extends q
      implements kotlin.g.a.a<x>
    {
      e(f.b paramb)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$NearbyLiveItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "commentScene", "", "(I)V", "getCommentScene", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder-nearby_release"})
  public static final class c
    extends RecyclerView.h
  {
    private final int xkX;
    
    public c(int paramInt)
    {
      this.xkX = paramInt;
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(202819);
      p.k(paramRect, "outRect");
      p.k(paramView, "view");
      p.k(paramRecyclerView, "parent");
      p.k(params, "state");
      paramRecyclerView = com.tencent.mm.plugin.finder.nearby.live.base.a.zEO;
      int i = com.tencent.mm.plugin.finder.nearby.live.base.a.dLH();
      paramRecyclerView = com.tencent.mm.plugin.finder.nearby.live.base.a.zEO;
      int j = com.tencent.mm.plugin.finder.nearby.live.base.a.dLH() / 2;
      paramRecyclerView = paramView.getLayoutParams();
      if (paramRecyclerView == null)
      {
        paramRect = new t("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(202819);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).mF())
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(202819);
        return;
      }
      paramView = paramView.getLayoutParams();
      if (paramView == null)
      {
        paramRect = new t("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(202819);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramView).kv() % 2 == 0)
      {
        paramRect.left = i;
        paramRect.right = j;
        paramRect.bottom = j;
        paramRect.top = j;
        AppMethodBeat.o(202819);
        return;
      }
      paramRect.left = j;
      paramRect.right = i;
      paramRect.bottom = j;
      paramRect.top = j;
      AppMethodBeat.o(202819);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<View>
  {
    d(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRecyclerView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder-nearby_release"})
  public static final class e
    implements h.c<i>
  {
    e(ArrayList paramArrayList) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRecyclerView$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder-nearby_release"})
  public static final class f
    implements h.d<i>
  {
    f(ArrayList paramArrayList) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRecyclerView$5", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "onItemExposeStart", "item", "plugin-finder-nearby_release"})
  public static final class g
    extends com.tencent.mm.view.recyclerview.d<com.tencent.mm.view.recyclerview.a>
  {
    public final void a(com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a> paramb)
    {
      AppMethodBeat.i(199525);
      p.k(paramb, "item");
      if ((paramb.YRY instanceof w))
      {
        cve localcve = new cve();
        Object localObject = paramb.YRY;
        if (localObject == null)
        {
          paramb = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderFeedLive");
          AppMethodBeat.o(199525);
          throw paramb;
        }
        localObject = (w)localObject;
        localcve.xbk = ((w)localObject).mf();
        localcve.TCN = ((int)paramb.startTime);
        paramb = au.zBf;
        au.a(localcve, f.b(this.zEN).getCommentScene());
        paramb = com.tencent.mm.plugin.finder.nearby.report.d.zJm;
        com.tencent.mm.plugin.finder.nearby.report.d.a(f.b(this.zEN).getCommentScene(), localcve);
        Log.d("NearbyLiveViewCallback", "onItemExposeStart id:" + localcve.xbk + " nick:" + ((BaseFinderFeed)localObject).feedObject.getFeedObject().nickname);
      }
      AppMethodBeat.o(199525);
    }
    
    public final void l(Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>> paramSet)
    {
      AppMethodBeat.i(199521);
      p.k(paramSet, "recordsSet");
      Log.i("NearbyLiveViewCallback", "onExposeTimeRecorded: size = " + paramSet.size());
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = ((Iterable)paramSet).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)localIterator.next();
        if ((localb.YRY instanceof w))
        {
          paramSet = new cve();
          Object localObject1 = localb.YRY;
          if (localObject1 == null)
          {
            paramSet = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderFeedLive");
            AppMethodBeat.o(199521);
            throw paramSet;
          }
          w localw = (w)localObject1;
          paramSet.xbk = localw.mf();
          localObject1 = au.zBf;
          au.a(paramSet, f.b(this.zEN).getCommentScene());
          paramSet.TCN = ((int)localb.BHT);
          paramSet.TCO = localb.XDo;
          paramSet.sessionBuffer = localw.getSessionBuffer();
          localLinkedList.add(paramSet);
          com.tencent.mm.plugin.finder.live.report.a locala = f.f(this.zEN);
          bu localbu = (bu)localw;
          int i = localb.XDo;
          s.t localt = s.t.yGN;
          String str1 = String.valueOf(f.b(this.zEN).getCommentScene());
          paramSet = f.d(this.zEN);
          if (paramSet != null)
          {
            localObject1 = paramSet.aiS();
            paramSet = (Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>>)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramSet = "";
          }
          String str2 = f.e(this.zEN);
          p.k(localbu, "feed");
          p.k(localt, "actionType");
          p.k(str1, "commentscene");
          p.k(paramSet, "clickSubTabContextId");
          p.k(str2, "chnlExtra");
          long l1 = localbu.mf();
          String str3 = com.tencent.mm.plugin.expt.hellhound.core.b.Fw(l1);
          p.j(str3, "HellhoundUtil.long2UnsignedString(feedIdL)");
          localObject1 = com.tencent.mm.plugin.finder.live.report.h.yAW;
          Object localObject2 = h.a.a(localbu);
          if ((localbu instanceof BaseFinderFeed)) {}
          for (localObject1 = ((BaseFinderFeed)localbu).feedObject.getUserName();; localObject1 = "")
          {
            Object localObject3 = ((com.tencent.mm.vending.j.d)localObject2).ieT();
            p.j(localObject3, "tuple3.`$1`()");
            long l2 = ((Number)localObject3).longValue();
            localObject3 = ((com.tencent.mm.vending.j.d)localObject2).ieU();
            p.j(localObject3, "tuple3.`$2`()");
            int j = ((Number)localObject3).intValue();
            localObject3 = com.tencent.mm.plugin.finder.live.report.h.yAW;
            localObject3 = h.a.b(localbu);
            h.b localb1 = h.b.yAX;
            localObject2 = ((com.tencent.mm.vending.j.d)localObject2).ieV();
            p.j(localObject2, "tuple3.`$3`()");
            locala.a(new com.tencent.mm.plugin.finder.live.report.h(localbu, (String)localObject1, i, str3, l1, l2, localt, str1, j, (String)localObject3, localb1, true, ((Boolean)localObject2).booleanValue(), 0, null, paramSet, str2, 24576));
            Log.d("NearbyLiveViewCallback", "onExposeTimeRecorded pos:" + localb.XDo + " exposeTime:" + localb.BHT + " nick:" + localw.feedObject.getFeedObject().nickname);
            break;
          }
        }
        Log.d("NearbyLiveViewCallback", "onExposeTimeRecorded pos:" + localb.XDo + " exposeTime:" + localb.BHT);
      }
      paramSet = com.tencent.mm.plugin.finder.nearby.report.d.zJm;
      com.tencent.mm.plugin.finder.nearby.report.d.k(f.b(this.zEN).getCommentScene(), (List)localLinkedList);
      paramSet = au.zBf;
      au.aI(localLinkedList);
      AppMethodBeat.o(199521);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRecyclerView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder-nearby_release"})
  public static final class h
    extends WxRecyclerAdapter<bu>
  {
    h(ArrayList paramArrayList1, com.tencent.mm.view.recyclerview.f paramf, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void p(i parami)
    {
      AppMethodBeat.i(203432);
      p.k(parami, "holder");
      super.p(parami);
      Object localObject = parami.amk;
      p.j(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if ((parami.mg() != -1) && (parami.mg() != -9) && (parami.mg() != -10) && (parami.mg() != 6)) {
          break label96;
        }
      }
      label96:
      for (boolean bool = true;; bool = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).aA(bool);
        AppMethodBeat.o(203432);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199696);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      f.a(this.zEN);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(199696);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder-nearby_release"})
  public static final class j
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(199387);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      Log.i("NearbyLiveViewCallback", "onRefreshBegin");
      super.Ie(paramInt);
      f.b(this.zEN).onRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(199387);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(199398);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      Log.i("NearbyLiveViewCallback", "onLoadMoreEnd");
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(199398);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(199395);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Log.i("NearbyLiveViewCallback", "onLoadMoreBegin");
      super.cKQ();
      f.b(this.zEN).onLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(199395);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(199392);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      Log.i("NearbyLiveViewCallback", "onRefreshEnd");
      super.onRefreshEnd(paramc);
      f.b(this.zEN).onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(199392);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    k(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<View>
  {
    l(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.f
 * JD-Core Version:    0.7.0.1
 */