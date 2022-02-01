package com.tencent.mm.plugin.finder.nearby.live;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ab;
import com.tencent.mm.plugin.finder.convert.af;
import com.tencent.mm.plugin.finder.convert.ag;
import com.tencent.mm.plugin.finder.convert.al;
import com.tencent.mm.plugin.finder.convert.co;
import com.tencent.mm.plugin.finder.convert.m;
import com.tencent.mm.plugin.finder.convert.v;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.g.d;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "parent", "Landroid/view/View;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;Landroid/view/View;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "Lkotlin/Lazy;", "rootScroll", "getRootScroll", "()Landroid/view/View;", "rootScroll$delegate", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "getRootScrollParent", "gotoMoreLivePage", "", "initRecyclerView", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "initRefreshLayout", "initView", "Companion", "NearbyLiveItemConvertFactory", "NearbyLiveItemDecoration", "plugin-finder_release"})
public class e
  implements b.b<bo>
{
  public static final a uRp;
  private final View hVd;
  final MMActivity tRl;
  private final kotlin.f tSX;
  private final bbn ttO;
  private final kotlin.f uRn;
  private final b.a<bo> uRo;
  
  static
  {
    AppMethodBeat.i(249146);
    uRp = new a((byte)0);
    AppMethodBeat.o(249146);
  }
  
  public e(MMActivity paramMMActivity, b.a<bo> parama, View paramView, bbn parambbn)
  {
    AppMethodBeat.i(249145);
    this.tRl = paramMMActivity;
    this.uRo = parama;
    this.hVd = paramView;
    this.ttO = parambbn;
    this.tSX = kotlin.g.ah((kotlin.g.a.a)new j(this));
    this.uRn = kotlin.g.ah((kotlin.g.a.a)new k(this));
    AppMethodBeat.o(249145);
  }
  
  private final View dls()
  {
    AppMethodBeat.i(249144);
    View localView = (View)this.uRn.getValue();
    AppMethodBeat.o(249144);
    return localView;
  }
  
  private final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(249143);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = (RefreshLoadMoreLayout)this.tSX.getValue();
    AppMethodBeat.o(249143);
    return localRefreshLoadMoreLayout;
  }
  
  public final void ab(final ArrayList<bo> paramArrayList)
  {
    AppMethodBeat.i(249139);
    p.h(paramArrayList, "data");
    Object localObject1 = dls();
    p.g(localObject1, "rootScroll");
    localObject1 = ((View)localObject1).getContext();
    p.g(localObject1, "rootScroll.context");
    localObject1 = ((Context)localObject1).getResources();
    getRlLayout().setLimitTopRequest((int)((Resources)localObject1).getDimension(2131166379) - (int)((Resources)localObject1).getDimension(2131165281));
    getRlLayout().setRefreshTargetY((int)((Resources)localObject1).getDimension(2131165308) - (int)((Resources)localObject1).getDimension(2131166379));
    getRlLayout().setDamping(1.85F);
    localObject1 = getRlLayout().getLoadMoreFooter();
    if (localObject1 != null)
    {
      localObject1 = ((View)localObject1).findViewById(2131302155);
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new h(this));
      }
    }
    getRlLayout().setActionCallback((RefreshLoadMoreLayout.a)new i(this));
    localObject1 = getRlLayout().getRecyclerView();
    Object localObject2 = new NearbyLiveViewCallback.initRecyclerView.1();
    ((NearbyLiveViewCallback.initRecyclerView.1)localObject2).setItemPrefetchEnabled(true);
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)localObject2);
    ((RecyclerView)localObject1).b((RecyclerView.h)new c());
    localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).lB();
    }
    localObject2 = new g(this, paramArrayList, (com.tencent.mm.view.recyclerview.f)new b(this.tRl, this.uRo), paramArrayList);
    ((com.tencent.mm.view.recyclerview.g)localObject2).RqP = ((g.c)new d(this, paramArrayList));
    ((com.tencent.mm.view.recyclerview.g)localObject2).RqO = ((g.d)new e(paramArrayList));
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    ((RecyclerView)localObject1).setHasFixedSize(true);
    ((RecyclerView)localObject1).setItemViewCacheSize(8);
    if (localObject1 == null)
    {
      paramArrayList = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
      AppMethodBeat.o(249139);
      throw paramArrayList;
    }
    paramArrayList = (WxRecyclerView)localObject1;
    localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
    paramArrayList.setFlingSpeedFactor(((Number)com.tencent.mm.plugin.finder.storage.c.dsZ().value()).intValue());
    com.tencent.mm.view.recyclerview.c.a((RecyclerView)localObject1, (d)new f(this));
    AppMethodBeat.o(249139);
  }
  
  public final RefreshLoadMoreLayout dcQ()
  {
    AppMethodBeat.i(249142);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = getRlLayout();
    p.g(localRefreshLoadMoreLayout, "rlLayout");
    AppMethodBeat.o(249142);
    return localRefreshLoadMoreLayout;
  }
  
  public final View dlo()
  {
    AppMethodBeat.i(249140);
    View localView = dls();
    p.g(localView, "rootScroll");
    AppMethodBeat.o(249140);
    return localView;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(249141);
    Object localObject = getRlLayout();
    if (localObject != null)
    {
      localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
      AppMethodBeat.o(249141);
      return localObject;
    }
    AppMethodBeat.o(249141);
    return null;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$NearbyLiveItemConvertFactory;", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;)V", "bindLive", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "bindMedia", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.f
  {
    final MMActivity tRl;
    final b.a<bo> uRo;
    
    public b(MMActivity paramMMActivity, b.a<bo> parama)
    {
      AppMethodBeat.i(249123);
      this.tRl = paramMMActivity;
      this.uRo = parama;
      AppMethodBeat.o(249123);
    }
    
    public final com.tencent.mm.view.recyclerview.e<?> EC(int paramInt)
    {
      AppMethodBeat.i(249122);
      switch (paramInt)
      {
      default: 
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
        {
          localObject = (Throwable)new RuntimeException("type invalid");
          AppMethodBeat.o(249122);
          throw ((Throwable)localObject);
        }
        break;
      case 4: 
      case 3002: 
        localObject = (com.tencent.mm.view.recyclerview.e)new a(this);
        AppMethodBeat.o(249122);
        return localObject;
      case 2: 
      case 3001: 
        localObject = (com.tencent.mm.view.recyclerview.e)new b(this);
        AppMethodBeat.o(249122);
        return localObject;
      case 9: 
        localObject = (com.tencent.mm.view.recyclerview.e)new c(this);
        AppMethodBeat.o(249122);
        return localObject;
      case -10: 
        localObject = (com.tencent.mm.view.recyclerview.e)new af((kotlin.g.a.b)new d(this));
        AppMethodBeat.o(249122);
        return localObject;
      case -3: 
        localObject = (com.tencent.mm.view.recyclerview.e)new ag();
        AppMethodBeat.o(249122);
        return localObject;
      case -5: 
        localObject = (com.tencent.mm.view.recyclerview.e)new ab();
        AppMethodBeat.o(249122);
        return localObject;
      case -1: 
        localObject = (com.tencent.mm.view.recyclerview.e)new m((kotlin.g.a.a)new e(this), (kotlin.g.a.a)new f(this));
        AppMethodBeat.o(249122);
        return localObject;
      }
      Log.printInfoStack("RecyclerViewAdapterEx", "type invalid", new Object[0]);
      Object localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.f();
      AppMethodBeat.o(249122);
      return localObject;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$NearbyLiveItemConvertFactory$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class a
      extends al
    {
      public final void a(h paramh, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(249113);
        p.h(paramh, "holder");
        p.h(paramBaseFinderFeed, "item");
        super.a(paramh, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        e.b.k(paramh, paramBaseFinderFeed);
        AppMethodBeat.o(249113);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$NearbyLiveItemConvertFactory$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class b
      extends v
    {
      public final void a(h paramh, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(249115);
        p.h(paramh, "holder");
        p.h(paramBaseFinderFeed, "item");
        super.a(paramh, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        e.b.k(paramh, paramBaseFinderFeed);
        AppMethodBeat.o(249115);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$NearbyLiveItemConvertFactory$getItemConvert$3", "Lcom/tencent/mm/plugin/finder/convert/NearbyLiveFeedsConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class c
      extends co
    {
      public final void a(h paramh, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(249117);
        p.h(paramh, "holder");
        p.h(paramBaseFinderFeed, "item");
        super.a(paramh, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        paramList = paramh.Mn(2131301214);
        TextView localTextView2 = (TextView)paramh.Mn(2131306606);
        TextView localTextView1 = (TextView)paramh.Mn(2131310334);
        Object localObject = paramBaseFinderFeed.feedObject.getLiveInfo();
        if ((localObject != null) && (((awe)localObject).liveStatus == 1))
        {
          p.g(paramList, "liveOnLineLayout");
          paramList.setVisibility(0);
          localObject = paramBaseFinderFeed.feedObject.getFeedObject().recommendReason;
          paramList = (List<Object>)localObject;
          if (localObject == null) {
            paramList = "";
          }
          p.g(paramList, "item.feedObject.feedObject.recommendReason ?: \"\"");
          if (!TextUtils.isEmpty((CharSequence)paramList)) {
            break label267;
          }
          p.g(localTextView2, "recReasonTv");
          localTextView2.setText((CharSequence)"直播中");
          paramList = paramBaseFinderFeed.feedObject.getLiveInfo();
          if (paramList == null) {
            break label287;
          }
          paramInt1 = paramList.LCy;
          label176:
          if (paramInt1 <= 0) {
            break label292;
          }
          p.g(localTextView1, "watchCountHistoryTv");
          paramList = y.vXH;
          localTextView1.setText((CharSequence)String.valueOf(y.LT(paramInt1)));
          localTextView1.setVisibility(0);
        }
        for (;;)
        {
          paramh = (TextView)paramh.Mn(2131300801);
          if (Util.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
            break label309;
          }
          p.g(paramh, "descTv");
          paramh.setVisibility(0);
          paramh.setText((CharSequence)paramBaseFinderFeed.feedObject.getDescriptionSpan());
          AppMethodBeat.o(249117);
          return;
          label267:
          p.g(localTextView2, "recReasonTv");
          localTextView2.setText((CharSequence)paramList);
          break;
          label287:
          paramInt1 = 0;
          break label176;
          label292:
          p.g(localTextView1, "watchCountHistoryTv");
          localTextView1.setVisibility(8);
        }
        label309:
        p.g(paramh, "descTv");
        paramh.setVisibility(8);
        AppMethodBeat.o(249117);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.b<View, x>
    {
      d(e.b paramb)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class e
      extends q
      implements kotlin.g.a.a<x>
    {
      e(e.b paramb)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class f
      extends q
      implements kotlin.g.a.a<x>
    {
      f(e.b paramb)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$NearbyLiveItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(249125);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
      paramRecyclerView = paramView.getContext();
      p.g(paramRecyclerView, "view.context");
      int i = (int)paramRecyclerView.getResources().getDimension(2131165277);
      paramRecyclerView = paramView.getContext();
      p.g(paramRecyclerView, "view.context");
      int j = (int)paramRecyclerView.getResources().getDimension(2131166347);
      paramRecyclerView = paramView.getLayoutParams();
      if (paramRecyclerView == null)
      {
        paramRect = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(249125);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).mJ())
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(249125);
        return;
      }
      paramView = paramView.getLayoutParams();
      if (paramView == null)
      {
        paramRect = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(249125);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramView).kj() % 2 == 0)
      {
        paramRect.left = i;
        paramRect.right = j;
        paramRect.bottom = j;
        paramRect.top = j;
        AppMethodBeat.o(249125);
        return;
      }
      paramRect.left = j;
      paramRect.right = i;
      paramRect.bottom = j;
      paramRect.top = j;
      AppMethodBeat.o(249125);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRecyclerView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class d
    implements g.c<h>
  {
    d(ArrayList paramArrayList) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRecyclerView$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class e
    implements g.d<h>
  {
    e(ArrayList paramArrayList) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRecyclerView$5", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "onItemExposeStart", "item", "plugin-finder_release"})
  public static final class f
    extends d<com.tencent.mm.view.recyclerview.a>
  {
    public final void a(com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a> paramb)
    {
      AppMethodBeat.i(249129);
      p.h(paramb, "item");
      if ((paramb.RqA instanceof w))
      {
        cmm localcmm = new cmm();
        Object localObject = paramb.RqA;
        if (localObject == null)
        {
          paramb = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderFeedLive");
          AppMethodBeat.o(249129);
          throw paramb;
        }
        localObject = (w)localObject;
        localcmm.hFK = ((w)localObject).lT();
        localcmm.MrJ = ((int)paramb.startTime);
        paramb = as.uOL;
        as.a(localcmm, e.b(this.uRr).getCommentScene());
        paramb = com.tencent.mm.plugin.finder.nearby.report.c.uTk;
        com.tencent.mm.plugin.finder.nearby.report.c.a(e.b(this.uRr).getCommentScene(), localcmm);
        Log.d("NearbyLiveViewCallback", "onItemExposeStart id:" + localcmm.hFK + " nick:" + ((BaseFinderFeed)localObject).feedObject.getFeedObject().nickname);
      }
      AppMethodBeat.o(249129);
    }
    
    public final void l(Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>> paramSet)
    {
      AppMethodBeat.i(249128);
      p.h(paramSet, "recordsSet");
      Log.i("NearbyLiveViewCallback", "onExposeTimeRecorded: size = " + paramSet.size());
      LinkedList localLinkedList = new LinkedList();
      paramSet = ((Iterable)paramSet).iterator();
      while (paramSet.hasNext())
      {
        com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)paramSet.next();
        if ((localb.RqA instanceof w))
        {
          cmm localcmm = new cmm();
          Object localObject = localb.RqA;
          if (localObject == null)
          {
            paramSet = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderFeedLive");
            AppMethodBeat.o(249128);
            throw paramSet;
          }
          localObject = (w)localObject;
          localcmm.hFK = ((w)localObject).lT();
          as localas = as.uOL;
          as.a(localcmm, e.b(this.uRr).getCommentScene());
          localcmm.MrJ = ((int)localb.wVY);
          localcmm.sessionBuffer = ((w)localObject).getSessionBuffer();
          localLinkedList.add(localcmm);
          Log.d("NearbyLiveViewCallback", "onExposeTimeRecorded pos:" + localb.Qgj + " exposeTime:" + localb.wVY + " nick:" + ((BaseFinderFeed)localObject).feedObject.getFeedObject().nickname);
        }
        else
        {
          Log.d("NearbyLiveViewCallback", "onExposeTimeRecorded pos:" + localb.Qgj + " exposeTime:" + localb.wVY);
        }
      }
      paramSet = com.tencent.mm.plugin.finder.nearby.report.c.uTk;
      com.tencent.mm.plugin.finder.nearby.report.c.i(e.b(this.uRr).getCommentScene(), (List)localLinkedList);
      paramSet = as.uOL;
      as.ar(localLinkedList);
      AppMethodBeat.o(249128);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRecyclerView$adapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class g
    extends WxRecyclerAdapter<bo>
  {
    g(ArrayList paramArrayList1, com.tencent.mm.view.recyclerview.f paramf, ArrayList paramArrayList2)
    {
      super(localArrayList);
    }
    
    public final void n(h paramh)
    {
      AppMethodBeat.i(249130);
      p.h(paramh, "holder");
      super.n(paramh);
      Object localObject = paramh.aus;
      p.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if ((paramh.lU() != -1) && (paramh.lU() != -9) && (paramh.lU() != -10)) {
          break label87;
        }
      }
      label87:
      for (boolean bool = true;; bool = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).aC(bool);
        AppMethodBeat.o(249130);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(249132);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      e.a(this.uRr);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(249132);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
  public static final class i
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(249133);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      Log.i("NearbyLiveViewCallback", "onRefreshBegin");
      super.ED(paramInt);
      e.b(this.uRr).onRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(249133);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(249136);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      Log.i("NearbyLiveViewCallback", "onLoadMoreEnd");
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(249136);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(249135);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Log.i("NearbyLiveViewCallback", "onLoadMoreBegin");
      super.cxo();
      e.b(this.uRr).onLoadMore();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(249135);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(249134);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramc, "reason");
      Log.i("NearbyLiveViewCallback", "onRefreshEnd");
      super.onRefreshEnd(paramc);
      e.b(this.uRr).onRefreshEnd(paramc);
      paramc = k.vkd;
      paramc = this.uRr.getRecyclerView();
      localObject = s.p.voA;
      k localk = k.vkd;
      k.a(paramc, (s.p)localObject, k.dpl().vlS, com.tencent.mm.plugin.finder.report.live.c.vjh, -100, -100);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRefreshLayout$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(249134);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    j(e parame)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<View>
  {
    k(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.e
 * JD-Core Version:    0.7.0.1
 */