package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.cgi.v.a;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.j;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axi;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.e.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fragmentTabType", "", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "TAG", "", "adapterData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "Lkotlin/collections/ArrayList;", "getAdapterData", "()Ljava/util/ArrayList;", "setAdapterData", "(Ljava/util/ArrayList;)V", "globalData", "getGlobalData", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "setGlobalData", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;)V", "innderAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getInnderAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setInnderAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "innderRvScrollListener", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "getInnderRvScrollListener", "()Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "setInnderRvScrollListener", "(Landroid/support/v7/widget/RecyclerView$OnScrollListener;)V", "innerLayoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getInnerLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "setInnerLayoutManager", "(Landroid/support/v7/widget/LinearLayoutManager;)V", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvertFactory", "()Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "setItemConvertFactory", "(Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;)V", "loading", "", "getLoading", "()Z", "setLoading", "(Z)V", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1;", "adjustLayout", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "bindAdapter", "bindToTargetAdapter", "payloads", "", "", "checkLoadMore", "lastPos", "convertToVisitorData", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;", "dataList", "position", "filterList", "item", "getEmptyView", "Landroid/view/View;", "context", "Landroid/content/Context;", "getLayoutId", "getScene", "gotoLive", "isLoadMoreUpdate", "needToLoadMore", "feedData", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "onBindViewHolder", "type", "isHotPatch", "onCreateViewHolder", "onDetachedFromRecyclerView", "onLoadMoreFinish", "incrementList", "liveList", "refreshFooterTips", "refreshHeadTips", "reportExposed", "updatePayload", "Companion", "plugin-finder_release"})
public final class y
  extends e<com.tencent.mm.plugin.finder.model.x>
{
  public static final a tDp;
  private final String TAG;
  boolean aWP;
  ArrayList<com.tencent.mm.plugin.finder.model.y> tDh;
  com.tencent.mm.plugin.finder.model.x tDi;
  private WxRecyclerAdapter<?> tDj;
  private LinearLayoutManager tDk;
  private RecyclerView.l tDl;
  private com.tencent.mm.view.recyclerview.f tDm;
  private final f tDn;
  private final int tDo;
  private final bbn ttO;
  
  static
  {
    AppMethodBeat.i(243067);
    tDp = new a((byte)0);
    AppMethodBeat.o(243067);
  }
  
  public y(bbn parambbn, int paramInt)
  {
    AppMethodBeat.i(243066);
    this.ttO = parambbn;
    this.tDo = paramInt;
    this.TAG = "FinderFeedLiveListConvert";
    this.tDh = new ArrayList();
    this.tDi = new com.tencent.mm.plugin.finder.model.x();
    this.tDm = ((com.tencent.mm.view.recyclerview.f)new e(this));
    this.tDn = new f(this);
    AppMethodBeat.o(243066);
  }
  
  private final void a(com.tencent.mm.plugin.finder.model.x paramx)
  {
    AppMethodBeat.i(243057);
    if (this.tDo == 1)
    {
      int j = 0;
      int i = 0;
      ArrayList localArrayList = new ArrayList();
      Object localObject = paramx.dtS;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          com.tencent.mm.plugin.finder.model.y localy = (com.tencent.mm.plugin.finder.model.y)((Iterator)localObject).next();
          if ((localy != null) && (localy.uOo.friendLikeCount > 0))
          {
            localArrayList.add(localy);
          }
          else
          {
            Log.i(this.TAG, "drop item:".concat(String.valueOf(localy)));
            i = 1;
          }
        }
      }
      if (j != 0)
      {
        p.h(localArrayList, "newList");
        paramx.dtS.clear();
        paramx.dtS.addAll((Collection)localArrayList);
        paramx.dkB();
        Log.i(this.TAG, "after filter list:".concat(String.valueOf(paramx)));
      }
    }
    AppMethodBeat.o(243057);
  }
  
  private final boolean a(h paramh, List<Object> paramList)
  {
    AppMethodBeat.i(243058);
    Object localObject = (Collection)paramList;
    int i;
    if ((localObject == null) || (((Collection)localObject).isEmpty()))
    {
      i = 1;
      if (i == 0) {
        paramList = ((Iterable)paramList).iterator();
      }
    }
    else
    {
      while (paramList.hasNext())
      {
        localObject = paramList.next();
        if ((localObject instanceof Integer))
        {
          if (p.j(localObject, Integer.valueOf(1)))
          {
            paramList = (RecyclerView)paramh.Mn(2131303502);
            if (paramList != null) {}
            for (paramList = paramList.getAdapter();; paramList = null)
            {
              if (!p.j(paramList, this.tDj)) {
                break label225;
              }
              Log.i(this.TAG, "scrollToPosition 0");
              paramh = (RecyclerView)paramh.Mn(2131303502);
              paramList = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.a(paramh, paramList.axQ(), "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert", "updatePayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Ljava/util/List;)Z", "Undefined", "scrollToPosition", "(I)V");
              paramh.scrollToPosition(((Integer)paramList.pG(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(paramh, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert", "updatePayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Ljava/util/List;)Z", "Undefined", "scrollToPosition", "(I)V");
              AppMethodBeat.o(243058);
              return true;
              i = 0;
              break;
            }
            label225:
            AppMethodBeat.o(243058);
            return false;
          }
          AppMethodBeat.o(243058);
          return false;
        }
      }
    }
    AppMethodBeat.o(243058);
    return false;
  }
  
  private static boolean dU(List<Object> paramList)
  {
    AppMethodBeat.i(243061);
    Object localObject = (Collection)paramList;
    int i;
    boolean bool1;
    if ((localObject == null) || (((Collection)localObject).isEmpty()))
    {
      i = 1;
      if (i == 0)
      {
        paramList = ((Iterable)paramList).iterator();
        bool1 = false;
      }
    }
    else
    {
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break label101;
        }
        localObject = paramList.next();
        if ((localObject instanceof Integer))
        {
          if (p.j(localObject, Integer.valueOf(2)))
          {
            bool1 = true;
            continue;
            i = 0;
            break;
          }
          bool1 = false;
        }
      }
    }
    boolean bool2 = false;
    label101:
    AppMethodBeat.o(243061);
    return bool2;
  }
  
  private static View fl(Context paramContext)
  {
    AppMethodBeat.i(243064);
    p.h(paramContext, "context");
    View localView = new View(paramContext);
    localView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(com.tencent.mm.view.d.e(paramContext, 10.0F), 1));
    AppMethodBeat.o(243064);
    return localView;
  }
  
  private final String getScene()
  {
    if (this.tDo == 1) {
      return s.j.vnU.scene;
    }
    if ((this.tDo != 3) && (this.tDo == 2)) {
      return s.j.vnV.scene;
    }
    return s.j.vnN.scene;
  }
  
  private final void j(final h paramh)
  {
    AppMethodBeat.i(243055);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)paramh.Mn(2131303502);
    this.tDj = new WxRecyclerAdapter(this.tDm, this.tDh, false);
    WxRecyclerAdapter localWxRecyclerAdapter = this.tDj;
    if (localWxRecyclerAdapter != null)
    {
      Context localContext = paramh.getContext();
      p.g(localContext, "holder.context");
      g.a(localWxRecyclerAdapter, fl(localContext), 1);
      localContext = paramh.getContext();
      p.g(localContext, "holder.context");
      g.b(localWxRecyclerAdapter, fl(localContext), 2);
      localWxRecyclerAdapter.RqP = ((g.c)new b(localWxRecyclerAdapter, this, paramh));
    }
    this.tDk = new LinearLayoutManager(0, false);
    this.tDl = ((RecyclerView.l)new c(this, paramh));
    p.g(localWxRecyclerView, "this");
    localWxRecyclerView.setAdapter((RecyclerView.a)this.tDj);
    localWxRecyclerView.setLayoutManager((RecyclerView.LayoutManager)this.tDk);
    if ((this.tDl instanceof RecyclerView.l))
    {
      paramh = this.tDl;
      if (paramh == null)
      {
        paramh = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.OnScrollListener");
        AppMethodBeat.o(243055);
        throw paramh;
      }
      localWxRecyclerView.a(paramh);
    }
    Log.i(this.TAG, "[bindAdapter] tabType:" + this.tDo + ",innderAdapter:" + this.tDj);
    AppMethodBeat.o(243055);
  }
  
  private final void k(h paramh)
  {
    AppMethodBeat.i(243060);
    int i;
    if (this.tDo == 2)
    {
      localObject = (Collection)this.tDh;
      if ((localObject == null) || (((Collection)localObject).isEmpty()))
      {
        i = 1;
        if (i == 0) {
          break label101;
        }
      }
    }
    else
    {
      Log.i(this.TAG, "refreshFooterTips,fragmentTabType:" + this.tDo);
    }
    label101:
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        paramh = paramh.Mn(2131301661);
        p.g(paramh, "holder.getView<View>(R.id.footer)");
        paramh.setVisibility(8);
        do
        {
          AppMethodBeat.o(243060);
          return;
          i = 0;
          break;
          localObject = paramh.getAdapter();
        } while (!(localObject instanceof WxRecyclerAdapter));
        localObject = ((Iterable)((WxRecyclerAdapter)localObject).data).iterator();
      }
    } while (((com.tencent.mm.view.recyclerview.a)((Iterator)localObject).next() instanceof com.tencent.mm.plugin.finder.model.x));
    Object localObject = paramh.Mn(2131301661);
    p.g(localObject, "holder.getView<View>(R.id.footer)");
    ((View)localObject).setVisibility(0);
    paramh = (TextView)paramh.Mn(2131301685);
    p.g(paramh, "footTv");
    ao.a((Paint)paramh.getPaint(), 0.8F);
    localObject = MMApplicationContext.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    paramh.setText((CharSequence)((Context)localObject).getResources().getString(2131759966));
    Log.i(this.TAG, "show footer!");
    AppMethodBeat.o(243060);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(243062);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    Log.i(this.TAG, "[onAttachedToRecyclerView]");
    AppMethodBeat.o(243062);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243056);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    j(paramh);
    paramRecyclerView.a((RecyclerView.l)this.tDn);
    paramRecyclerView = (WxRecyclerView)paramh.Mn(2131303502);
    p.g(paramRecyclerView, "this");
    com.tencent.mm.view.f.a((RecyclerView)paramRecyclerView, (e.a)new g(this));
    AppMethodBeat.o(243056);
  }
  
  public final void a(ArrayList<com.tencent.mm.plugin.finder.model.y> paramArrayList, int paramInt, h paramh)
  {
    AppMethodBeat.i(243065);
    p.h(paramArrayList, "dataList");
    p.h(paramh, "holder");
    Object localObject2 = (com.tencent.mm.plugin.finder.model.y)paramh.hgv();
    if (localObject2 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.model.y)localObject2).uOo;
      if (localObject1 == null) {
        break label112;
      }
      localObject1 = ((FinderObject)localObject1).username;
      if (localObject1 == null) {
        break label112;
      }
      localObject1 = (CharSequence)localObject1;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label106;
      }
    }
    label106:
    for (int i = 1; i == 1; i = 0)
    {
      Log.e(this.TAG, "gotoLive err username is empty!");
      AppMethodBeat.o(243065);
      return;
    }
    label112:
    long l;
    if (Util.isEqual(((com.tencent.mm.plugin.finder.model.y)localObject2).uOo.username, com.tencent.mm.model.z.aUg()))
    {
      paramArrayList = com.tencent.mm.plugin.finder.utils.a.vUU;
      localObject3 = paramh.getContext();
      p.g(localObject3, "holder.context");
      l = ((com.tencent.mm.plugin.finder.model.y)localObject2).uOo.id;
      paramh = ((com.tencent.mm.plugin.finder.model.y)localObject2).uOo.objectNonceId;
      paramArrayList = paramh;
      if (paramh == null) {
        paramArrayList = "";
      }
      localObject1 = ((com.tencent.mm.plugin.finder.model.y)localObject2).uOo.liveInfo;
      paramh = (h)localObject1;
      if (localObject1 == null) {
        paramh = new awe();
      }
      com.tencent.mm.plugin.finder.utils.a.a((Context)localObject3, l, paramArrayList, paramh, false, null, null, null, null, null, ((com.tencent.mm.plugin.finder.model.y)localObject2).uOo.sessionBuffer, null, 6128);
      AppMethodBeat.o(243065);
      return;
    }
    k.vkd.a((com.tencent.mm.plugin.finder.model.y)localObject2, ((com.tencent.mm.plugin.finder.model.y)localObject2).uOo.username, paramInt, s.p.voC, getScene());
    Object localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
    localObject2 = paramh.getContext();
    p.g(localObject2, "holder.context");
    Object localObject3 = new ArrayList();
    Object localObject4;
    if ((paramInt >= 0) && (paramInt < paramArrayList.size()))
    {
      localObject1 = (com.tencent.mm.plugin.finder.model.y)paramArrayList.get(paramInt);
      localObject4 = ((Iterable)paramArrayList).iterator();
    }
    for (;;)
    {
      label322:
      if (!((Iterator)localObject4).hasNext()) {
        break label590;
      }
      com.tencent.mm.plugin.finder.model.y localy = (com.tencent.mm.plugin.finder.model.y)((Iterator)localObject4).next();
      paramArrayList = localy.uOo.liveInfo;
      if ((paramArrayList != null) && (paramArrayList.liveStatus == 2))
      {
        String str = this.TAG;
        paramArrayList = new StringBuilder("convertToVisitorData feed:").append(localy.uOo.id).append(",is click feed:");
        l = localy.uOo.id;
        boolean bool;
        label431:
        StringBuilder localStringBuilder;
        if ((localObject1 != null) && (l == ((com.tencent.mm.plugin.finder.model.y)localObject1).uOo.id))
        {
          bool = true;
          localStringBuilder = paramArrayList.append(bool).append(",nickname:");
          paramArrayList = localy.uOo.contact;
          if (paramArrayList == null) {
            break label569;
          }
          paramArrayList = paramArrayList.nickname;
          label463:
          localStringBuilder = localStringBuilder.append(paramArrayList).append(",live status:");
          paramArrayList = localy.uOo.liveInfo;
          if (paramArrayList == null) {
            break label574;
          }
        }
        label569:
        label574:
        for (paramArrayList = Integer.valueOf(paramArrayList.liveStatus);; paramArrayList = null)
        {
          Log.i(str, paramArrayList + '!');
          l = localy.uOo.id;
          if ((localObject1 == null) || (l != ((com.tencent.mm.plugin.finder.model.y)localObject1).uOo.id)) {
            break label322;
          }
          ((ArrayList)localObject3).add(localy);
          break label322;
          localObject1 = null;
          break;
          bool = false;
          break label431;
          paramArrayList = null;
          break label463;
        }
      }
      ((ArrayList)localObject3).add(localy);
    }
    label590:
    paramInt = j.a((List)localObject3, localObject1);
    if (paramInt >= 0)
    {
      paramArrayList = new FinderLiveConfig();
      paramArrayList.uis = paramInt;
      paramArrayList.dLS = this.tDo;
      localObject1 = FinderReporterUIC.wzC;
      paramh = paramh.getContext();
      p.g(paramh, "holder.context");
      paramh = FinderReporterUIC.a.fH(paramh);
      if (paramh == null) {
        break label755;
      }
      paramh = paramh.dIx();
      if (paramh == null) {
        break label755;
      }
    }
    label755:
    for (paramInt = paramh.tCE;; paramInt = 0)
    {
      paramArrayList.tCE = paramInt;
      localObject1 = (Iterable)localObject3;
      paramh = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.finder.model.y)((Iterator)localObject1).next();
        localObject4 = m.vVH;
        paramh.add(m.q(((com.tencent.mm.plugin.finder.model.y)localObject3).uOo));
      }
      paramInt = 0;
      break;
    }
    paramArrayList.ac(new ArrayList((Collection)paramh));
    com.tencent.mm.plugin.finder.utils.a.a((Context)localObject2, paramArrayList, null, null, null, 28);
    AppMethodBeat.o(243065);
  }
  
  public final void c(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(243063);
    p.h(paramRecyclerView, "recyclerView");
    super.c(paramRecyclerView);
    Log.i(this.TAG, "[onDetachedFromRecyclerView]");
    paramRecyclerView.b((RecyclerView.l)this.tDn);
    AppMethodBeat.o(243063);
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(243054);
    if (com.tencent.mm.plugin.finder.utils.y.a(com.tencent.mm.plugin.finder.utils.y.vXH, this.tDo, 0, 2))
    {
      AppMethodBeat.o(243054);
      return 2131492880;
    }
    AppMethodBeat.o(243054);
    return 2131492885;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$Companion;", "", "()V", "EMPTY_FOOTER", "", "EMPTY_HEADER", "payloadsListScroll", "payloadsLoadMore", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$1$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release", "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$$special$$inlined$let$lambda$1"})
  public static final class b
    implements g.c<h>
  {
    b(WxRecyclerAdapter paramWxRecyclerAdapter, y paramy, h paramh) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$1$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    c(y paramy, h paramh) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(243044);
      Object localObject = new b();
      ((b)localObject).bm(paramRecyclerView);
      ((b)localObject).pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$$inlined$apply$lambda$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((b)localObject).axR());
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
        y.a(this.tDr, paramInt);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$$inlined$apply$lambda$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(243044);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243045);
      Object localObject = new b();
      ((b)localObject).bm(paramRecyclerView);
      ((b)localObject).pH(paramInt1);
      ((b)localObject).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$$inlined$apply$lambda$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = k.vkd;
      k.b(paramRecyclerView, s.p.voz, y.b(this.tDr), com.tencent.mm.plugin.finder.report.live.c.vjk);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$$inlined$apply$lambda$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(243045);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$checkLoadMore$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveStream$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamResponse;", "plugin-finder_release"})
  public static final class d
    implements v.a
  {
    public final void a(int paramInt1, int paramInt2, final String paramString, axi paramaxi)
    {
      AppMethodBeat.i(243047);
      p.h(paramaxi, "resp");
      this.tDr.aWP = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i(y.a(this.tDr), "before merge live list:" + this.tDr.tDi);
        paramString = this.tDr.tDi.a(paramaxi);
        paramaxi = (Collection)paramString;
        if ((paramaxi == null) || (paramaxi.isEmpty())) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, paramString));
          }
          Log.i(y.a(this.tDr), "after merge live list:" + this.tDr.tDi);
          AppMethodBeat.o(243047);
          return;
        }
      }
      Log.i(y.a(this.tDr), "[onCgiBack] errType=" + paramInt1 + " errCode=" + paramInt2 + " errMsg=" + paramString + '}');
      AppMethodBeat.o(243047);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(y.d paramd, ArrayList paramArrayList)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$itemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class e
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(243048);
      switch (paramInt)
      {
      default: 
        localObject = com.tencent.mm.plugin.finder.utils.y.vXH;
        com.tencent.mm.plugin.finder.utils.y.dQ(y.a(this.tDr), paramInt);
        localObject = (e)new f();
        AppMethodBeat.o(243048);
        return localObject;
      }
      Object localObject = (e)new z(y.d(this.tDr));
      AppMethodBeat.o(243048);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(243050);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(243050);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243049);
      Object localObject = new b();
      ((b)localObject).bm(paramRecyclerView);
      ((b)localObject).pH(paramInt1);
      ((b)localObject).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = k.vkd;
      k.b(paramRecyclerView, s.p.voz, y.b(this.tDr), com.tencent.mm.plugin.finder.report.live.c.vje);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(243049);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$reportExposed$1$1", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "exposedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExposedSet", "()Ljava/util/HashSet;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
  public static final class g
    extends e.a
  {
    private final HashSet<Long> tDu;
    
    g(y paramy)
    {
      AppMethodBeat.i(243052);
      this.tDu = new HashSet();
      AppMethodBeat.o(243052);
    }
    
    public final void b(final View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(243053);
      p.h(paramView, "parent");
      p.h(paramList, "exposedHolders");
      paramView = new LinkedList();
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        localObject1 = (RecyclerView.v)paramList.next();
        if ((localObject1 instanceof h))
        {
          localObject1 = ((h)localObject1).hgv();
          if (((localObject1 instanceof com.tencent.mm.plugin.finder.model.y)) && (!this.tDu.contains(Long.valueOf(((com.tencent.mm.plugin.finder.model.y)localObject1).uOo.id))))
          {
            this.tDu.add(Long.valueOf(((com.tencent.mm.plugin.finder.model.y)localObject1).uOo.id));
            paramView.add(localObject1);
          }
        }
      }
      paramList = y.a(this.tDr);
      Object localObject1 = new StringBuilder("[onChildExposeChanged] exposed=");
      Object localObject2 = (Iterable)paramView;
      Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localCollection.add(com.tencent.mm.ac.d.zs(((com.tencent.mm.plugin.finder.model.y)((Iterator)localObject2).next()).uOo.id));
      }
      Log.i(paramList, (List)localCollection);
      if (!((Collection)paramView).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          com.tencent.mm.ac.d.c("FinderFeedLiveListExpose", (kotlin.g.a.a)new q(paramView) {});
        }
        AppMethodBeat.o(243053);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.y
 * JD-Core Version:    0.7.0.1
 */