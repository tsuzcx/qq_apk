package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.bg;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.ac;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.ab;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.g.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bne;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.e.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fragmentTabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "TAG", "", "adapterData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "getAdapterData", "()Ljava/util/ArrayList;", "setAdapterData", "(Ljava/util/ArrayList;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "globalData", "getGlobalData", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "setGlobalData", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;)V", "innderAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getInnderAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setInnderAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "innderRvScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getInnderRvScrollListener", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "setInnderRvScrollListener", "(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V", "innerLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getInnerLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setInnerLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvertFactory", "()Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "setItemConvertFactory", "(Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;)V", "liveIdToChange", "", "getLiveIdToChange", "()J", "setLiveIdToChange", "(J)V", "liveStatusChange", "", "getLiveStatusChange", "()Z", "setLiveStatusChange", "(Z)V", "loadMore", "getLoadMore", "setLoadMore", "loading", "getLoading", "setLoading", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1;", "paddingChangeListener", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$PaddingChangeListener;", "getPaddingChangeListener", "()Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$PaddingChangeListener;", "setPaddingChangeListener", "(Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$PaddingChangeListener;)V", "adjustLayout", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "padding", "adjustLayoutPadding", "height", "bindAdapter", "bindToTargetAdapter", "payloads", "", "", "checkLoadMore", "lastPos", "convertToVisitorData", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "dataList", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "clickFeed", "enableAdjustLayout", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "filterList", "item", "findInnderRecycyerItemIndex", "liveId", "getEmptyView", "Landroid/view/View;", "context", "Landroid/content/Context;", "getLayoutId", "getScene", "gotoLive", "position", "needToLoadMore", "feedData", "onAttachedToRecyclerView", "adapter", "onBindViewHolder", "type", "isHotPatch", "onCreateViewHolder", "onDetachedFromRecyclerView", "onLoadMoreFinish", "incrementList", "liveList", "parsePayload", "refreshFooterTips", "refreshHeadTips", "reportExposed", "updatePayload", "Companion", "PaddingChangeListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends com.tencent.mm.view.recyclerview.f<com.tencent.mm.plugin.finder.model.y>
{
  public static final a AJU;
  private final com.tencent.mm.plugin.finder.feed.i AIh;
  private final int AJV;
  ArrayList<cc> AJW;
  com.tencent.mm.plugin.finder.model.y AJX;
  private WxRecyclerAdapter<?> AJY;
  private LinearLayoutManager AJZ;
  private RecyclerView.l AKa;
  private b AKb;
  private boolean AKc;
  private boolean AKd;
  private long AKe;
  private com.tencent.mm.view.recyclerview.g AKf;
  private final g AKg;
  final bui Auc;
  private final String TAG;
  boolean loading;
  
  static
  {
    AppMethodBeat.i(350686);
    AJU = new a((byte)0);
    AppMethodBeat.o(350686);
  }
  
  public w(com.tencent.mm.plugin.finder.feed.i parami, bui parambui, int paramInt)
  {
    AppMethodBeat.i(350560);
    this.AIh = parami;
    this.Auc = parambui;
    this.AJV = paramInt;
    this.TAG = "FinderFeedLiveListConvert";
    this.AJW = new ArrayList();
    this.AJX = new com.tencent.mm.plugin.finder.model.y();
    this.AKb = new b(this);
    this.AKf = ((com.tencent.mm.view.recyclerview.g)new f(this));
    this.AKg = new g(this);
    AppMethodBeat.o(350560);
  }
  
  private final FinderLiveBundle a(j paramj, ArrayList<com.tencent.mm.plugin.finder.model.z> paramArrayList, com.tencent.mm.plugin.finder.model.z paramz)
  {
    int k = 0;
    AppMethodBeat.i(350637);
    int j = paramArrayList.indexOf(paramz);
    FinderLiveBundle localFinderLiveBundle;
    Object localObject;
    int i;
    if (j >= 0)
    {
      localFinderLiveBundle = new FinderLiveBundle();
      localFinderLiveBundle.CEY = j;
      localFinderLiveBundle.hJx = this.AJV;
      localObject = as.GSQ;
      paramj = paramj.context;
      s.s(paramj, "holder.context");
      paramj = as.a.hu(paramj);
      if (paramj != null) {
        break label184;
      }
      i = 0;
    }
    for (;;)
    {
      localFinderLiveBundle.AJo = i;
      localObject = (Iterable)paramArrayList;
      paramj = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.finder.model.z localz = (com.tencent.mm.plugin.finder.model.z)((Iterator)localObject).next();
        com.tencent.mm.kernel.c.a locala = h.ax(com.tencent.mm.plugin.g.class);
        s.s(locala, "service(IFinderCommonLiveService::class.java)");
        paramj.add(g.a.a((com.tencent.mm.plugin.g)locala, localz.ECN, 0, 6));
      }
      j = 0;
      break;
      label184:
      paramj = paramj.fou();
      if (paramj == null) {
        i = 0;
      } else {
        i = paramj.AJo;
      }
    }
    localFinderLiveBundle.ag(new ArrayList((Collection)paramj));
    paramz = paramz.ECN.nickname;
    paramj = paramz;
    if (paramz == null) {
      paramj = "";
    }
    localFinderLiveBundle.awv(paramj);
    paramj = (com.tencent.mm.plugin.finder.model.z)p.ae((List)paramArrayList, j);
    if (paramj == null) {
      i = k;
    }
    for (;;)
    {
      localFinderLiveBundle.extFlag = i;
      AppMethodBeat.o(350637);
      return localFinderLiveBundle;
      paramj = paramj.ECN;
      i = k;
      if (paramj != null)
      {
        paramj = paramj.liveInfo;
        i = k;
        if (paramj != null) {
          i = paramj.ZRR;
        }
      }
    }
  }
  
  private final boolean a(j paramj, List<Object> paramList)
  {
    AppMethodBeat.i(350586);
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
          if (s.p(localObject, Integer.valueOf(1)))
          {
            paramList = (RecyclerView)paramj.UH(e.e.live_onlive_list_rv);
            if (paramList == null) {}
            for (paramList = null;; paramList = paramList.getAdapter())
            {
              if (!s.p(paramList, this.AJY)) {
                break label225;
              }
              Log.i(this.TAG, "scrollToPosition 0");
              paramj = (RecyclerView)paramj.UH(e.e.live_onlive_list_rv);
              paramList = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(paramj, paramList.aYi(), "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert", "updatePayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Ljava/util/List;)Z", "Undefined", "scrollToPosition", "(I)V");
              paramj.scrollToPosition(((Integer)paramList.sb(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(paramj, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert", "updatePayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Ljava/util/List;)Z", "Undefined", "scrollToPosition", "(I)V");
              AppMethodBeat.o(350586);
              return true;
              i = 0;
              break;
            }
            label225:
            AppMethodBeat.o(350586);
            return false;
          }
          AppMethodBeat.o(350586);
          return false;
        }
      }
    }
    AppMethodBeat.o(350586);
    return false;
  }
  
  private final void d(j paramj, int paramInt)
  {
    AppMethodBeat.i(350595);
    paramj = paramj.UH(e.e.live_list_layout);
    if (paramj != null)
    {
      paramj.setPadding(paramj.getPaddingLeft(), paramInt, paramj.getPaddingRight(), paramj.getPaddingBottom());
      Log.i(this.TAG, s.X("adjustLayoutPadding newHeight:", Integer.valueOf(paramInt)));
    }
    AppMethodBeat.o(350595);
  }
  
  private final int dXF()
  {
    AppMethodBeat.i(350620);
    Iterator localIterator = ((List)this.AJW).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext())
    {
      Object localObject = (cc)localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.finder.model.z))
      {
        localObject = (com.tencent.mm.plugin.finder.model.z)localObject;
        com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
        if (com.tencent.mm.plugin.finder.live.view.convert.a.i(((com.tencent.mm.plugin.finder.model.z)localObject).ECN) == this.AKe)
        {
          j = 1;
          label79:
          if (j == 0) {
            break label101;
          }
        }
      }
    }
    for (;;)
    {
      if (i != -1) {
        break label113;
      }
      AppMethodBeat.o(350620);
      return i;
      j = 0;
      break label79;
      label101:
      i += 1;
      break;
      i = -1;
    }
    label113:
    AppMethodBeat.o(350620);
    return i + 1;
  }
  
  private final void fY(List<Object> paramList)
  {
    AppMethodBeat.i(350613);
    this.AKc = false;
    this.AKd = false;
    this.AKe = 0L;
    Object localObject1 = (Collection)paramList;
    int i;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      i = 1;
      if (i == 0) {
        paramList = ((Iterable)paramList).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label187;
        }
        localObject1 = paramList.next();
        if ((localObject1 instanceof r))
        {
          Object localObject2 = ((r)localObject1).bsC;
          if (s.p(localObject2, Integer.valueOf(2)))
          {
            this.AKc = true;
            continue;
            i = 0;
            break;
          }
          if ((s.p(localObject2, Integer.valueOf(3))) && ((((r)localObject1).bsD instanceof Long)))
          {
            this.AKd = true;
            localObject1 = ((r)localObject1).bsD;
            if (localObject1 == null)
            {
              paramList = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
              AppMethodBeat.o(350613);
              throw paramList;
            }
            this.AKe = ((Long)localObject1).longValue();
          }
        }
      }
    }
    label187:
    AppMethodBeat.o(350613);
  }
  
  private final String getScene()
  {
    if (this.AJV == 1) {
      return q.n.DtA.scene;
    }
    if ((this.AJV != 3) && (this.AJV == 2)) {
      return q.n.DtB.scene;
    }
    return q.n.Dtt.scene;
  }
  
  private static View gq(Context paramContext)
  {
    AppMethodBeat.i(350627);
    s.u(paramContext, "context");
    View localView = new View(paramContext);
    localView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(com.tencent.mm.view.d.e(paramContext, 10.0F), 1));
    AppMethodBeat.o(350627);
    return localView;
  }
  
  private final void r(j paramj)
  {
    AppMethodBeat.i(350575);
    Object localObject = (WxRecyclerView)paramj.UH(e.e.live_onlive_list_rv);
    this.AJY = new WxRecyclerAdapter(this.AKf, this.AJW, false);
    WxRecyclerAdapter localWxRecyclerAdapter = this.AJY;
    if (localWxRecyclerAdapter != null)
    {
      com.tencent.mm.view.recyclerview.i locali = (com.tencent.mm.view.recyclerview.i)localWxRecyclerAdapter;
      Context localContext = paramj.context;
      s.s(localContext, "holder.context");
      com.tencent.mm.view.recyclerview.i.a(locali, gq(localContext), 1);
      locali = (com.tencent.mm.view.recyclerview.i)localWxRecyclerAdapter;
      paramj = paramj.context;
      s.s(paramj, "holder.context");
      com.tencent.mm.view.recyclerview.i.b(locali, gq(paramj), 2);
      localWxRecyclerAdapter.agOe = ((i.c)new c(localWxRecyclerAdapter, this));
    }
    this.AJZ = new LinearLayoutManager(0, false);
    this.AKa = ((RecyclerView.l)new d(this));
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)this.AJY);
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)this.AJZ);
    if (this.AKa != null)
    {
      paramj = this.AKa;
      if (paramj == null)
      {
        paramj = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.OnScrollListener");
        AppMethodBeat.o(350575);
        throw paramj;
      }
      ((WxRecyclerView)localObject).a(paramj);
    }
    ((WxRecyclerView)localObject).setHasFixedSize(true);
    paramj = this.AIh;
    if ((paramj instanceof bg))
    {
      paramj = (bg)paramj;
      if (paramj != null) {
        break label330;
      }
      paramj = null;
      label241:
      if (!(paramj instanceof Fragment)) {
        break label341;
      }
    }
    label330:
    label341:
    for (paramj = (Fragment)paramj;; paramj = null)
    {
      if (paramj != null)
      {
        localObject = k.aeZF;
        ((ab)k.y(paramj).q(ab.class)).GQp = true;
      }
      Log.i(this.TAG, "[bindAdapter] tabType:" + this.AJV + ",innderAdapter:" + this.AJY);
      AppMethodBeat.o(350575);
      return;
      paramj = null;
      break;
      paramj = (MMFinderFragment)paramj.AZg;
      break label241;
    }
  }
  
  private final void s(j paramj)
  {
    AppMethodBeat.i(350604);
    Object localObject;
    int i;
    if (this.AJV == 2)
    {
      localObject = (Collection)this.AJW;
      if ((localObject == null) || (((Collection)localObject).isEmpty()))
      {
        i = 1;
        if (i == 0) {
          break label85;
        }
      }
    }
    else
    {
      Log.i(this.TAG, s.X("refreshFooterTips,fragmentTabType:", Integer.valueOf(this.AJV)));
    }
    label85:
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        paramj.UH(e.e.footer).setVisibility(8);
        do
        {
          AppMethodBeat.o(350604);
          return;
          i = 0;
          break;
          localObject = paramj.mlt;
        } while (!(localObject instanceof WxRecyclerAdapter));
        localObject = ((Iterable)((WxRecyclerAdapter)localObject).data).iterator();
      }
    } while (((com.tencent.mm.view.recyclerview.a)((Iterator)localObject).next() instanceof com.tencent.mm.plugin.finder.model.y));
    paramj.UH(e.e.footer).setVisibility(0);
    paramj = (TextView)paramj.UH(e.e.footer_txt);
    aw.a((Paint)paramj.getPaint(), 0.8F);
    paramj.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_live_lbs_tip));
    Log.i(this.TAG, "show footer!");
    AppMethodBeat.o(350604);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(350705);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    this.AKb.mkw = paramRecyclerView;
    paramRecyclerView = this.AIh;
    if ((paramRecyclerView instanceof bg)) {}
    for (paramRecyclerView = (bg)paramRecyclerView;; paramRecyclerView = null)
    {
      if (paramRecyclerView != null)
      {
        paramRecyclerView = (MMFinderFragment)paramRecyclerView.AZg;
        if (paramRecyclerView != null)
        {
          paramWxRecyclerAdapter = k.aeZF;
          paramRecyclerView = (com.tencent.mm.plugin.finder.viewmodel.component.e)k.y((Fragment)paramRecyclerView).q(com.tencent.mm.plugin.finder.viewmodel.component.e.class);
          paramWxRecyclerAdapter = (com.tencent.mm.plugin.finder.viewmodel.component.a)this.AKb;
          s.u(paramWxRecyclerAdapter, "actionBarLayoutChangeListener");
          Log.i("Finder.DoubleClickTipUIC", "registActionBarLayoutChangeListener, actionBarLayoutChangeListener:" + paramWxRecyclerAdapter + '!');
          paramRecyclerView.GMD = paramWxRecyclerAdapter;
          paramWxRecyclerAdapter = paramRecyclerView.fmZ();
          if (paramWxRecyclerAdapter != null)
          {
            paramWxRecyclerAdapter = paramWxRecyclerAdapter.getViewTreeObserver();
            if (paramWxRecyclerAdapter != null) {
              paramWxRecyclerAdapter.addOnPreDrawListener(paramRecyclerView.fna());
            }
          }
        }
      }
      Log.i(this.TAG, "[onAttachedToRecyclerView]");
      AppMethodBeat.o(350705);
      return;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350697);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    r(paramj);
    paramRecyclerView.a((RecyclerView.l)this.AKg);
    paramRecyclerView = (WxRecyclerView)paramj.UH(e.e.live_onlive_list_rv);
    s.s(paramRecyclerView, "this");
    com.tencent.mm.view.f.a((RecyclerView)paramRecyclerView, (e.a)new h(this));
    AppMethodBeat.o(350697);
  }
  
  public final void a(ArrayList<cc> paramArrayList, int paramInt, j paramj)
  {
    AppMethodBeat.i(350721);
    s.u(paramArrayList, "dataList");
    s.u(paramj, "holder");
    Object localObject2 = paramj.CSA;
    Object localObject1;
    if ((localObject2 instanceof com.tencent.mm.plugin.finder.model.z))
    {
      localObject1 = ((com.tencent.mm.plugin.finder.model.z)localObject2).ECN;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).username;
        if (localObject1 != null) {
          if (((CharSequence)localObject1).length() == 0)
          {
            i = 1;
            if (i != 1) {
              break label114;
            }
          }
        }
      }
      label114:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label120;
        }
        Log.e(this.TAG, "gotoLive err username is empty!");
        AppMethodBeat.o(350721);
        return;
        i = 0;
        break;
      }
      label120:
      if (Util.isEqual(((com.tencent.mm.plugin.finder.model.z)localObject2).ECN.username, com.tencent.mm.model.z.bAW()))
      {
        paramArrayList = h.ax(com.tencent.mm.plugin.f.class);
        s.s(paramArrayList, "service(IActivityRouter::class.java)");
        localObject3 = (com.tencent.mm.plugin.f)paramArrayList;
        localObject4 = paramj.context;
        s.s(localObject4, "holder.context");
        long l = ((com.tencent.mm.plugin.finder.model.z)localObject2).ECN.id;
        paramj = ((com.tencent.mm.plugin.finder.model.z)localObject2).ECN.objectNonceId;
        paramArrayList = paramj;
        if (paramj == null) {
          paramArrayList = "";
        }
        localObject1 = ((com.tencent.mm.plugin.finder.model.z)localObject2).ECN.liveInfo;
        paramj = (j)localObject1;
        if (localObject1 == null) {
          paramj = new bip();
        }
        f.a.a((com.tencent.mm.plugin.f)localObject3, (Context)localObject4, l, paramArrayList, paramj, null, null, null, null, null, ((com.tencent.mm.plugin.finder.model.z)localObject2).ECN.sessionBuffer, null, null, 7152);
        AppMethodBeat.o(350721);
        return;
      }
      ((ce)h.ax(ce.class)).a((com.tencent.mm.plugin.finder.model.z)localObject2, ((com.tencent.mm.plugin.finder.model.z)localObject2).ECN.username, paramInt, q.w.DwR, getScene());
      localObject1 = (Iterable)paramArrayList;
      paramArrayList = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label405:
      label442:
      label445:
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = ((Iterator)localObject1).next();
        localObject4 = (cc)localObject3;
        if ((localObject4 instanceof com.tencent.mm.plugin.finder.model.z))
        {
          bip localbip = ((com.tencent.mm.plugin.finder.model.z)localObject4).ECN.liveInfo;
          if ((localbip != null) && (localbip.liveStatus == 2))
          {
            paramInt = 1;
            if ((paramInt != 0) && (!s.p(localObject4, localObject2))) {
              break label442;
            }
          }
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label445;
          }
          paramArrayList.add(localObject3);
          break;
          paramInt = 0;
          break label405;
        }
      }
      paramArrayList = (List)paramArrayList;
      localObject1 = h.ax(com.tencent.mm.plugin.f.class);
      s.s(localObject1, "service(IActivityRouter::class.java)");
      Object localObject3 = (com.tencent.mm.plugin.f)localObject1;
      Object localObject4 = paramj.context;
      s.s(localObject4, "holder.context");
      localObject2 = a(paramj, (ArrayList)paramArrayList, (com.tencent.mm.plugin.finder.model.z)localObject2);
      paramArrayList = this.Auc;
      if (paramArrayList == null)
      {
        paramArrayList = "";
        paramj = this.Auc;
        if (paramj != null) {
          break label572;
        }
        paramj = "";
      }
      for (;;)
      {
        f.a.a((com.tencent.mm.plugin.f)localObject3, (Context)localObject4, (FinderLiveBundle)localObject2, paramArrayList, paramj, null, false, 48);
        AppMethodBeat.o(350721);
        return;
        paramj = paramArrayList.zIO;
        paramArrayList = paramj;
        if (paramj != null) {
          break;
        }
        paramArrayList = "";
        break;
        label572:
        localObject1 = paramj.zIB;
        paramj = (j)localObject1;
        if (localObject1 == null) {
          paramj = "";
        }
      }
    }
    if ((localObject2 instanceof ac))
    {
      paramArrayList = (com.tencent.d.a.b.a.e)h.az(com.tencent.d.a.b.a.e.class);
      paramj = paramj.context;
      s.s(paramj, "holder.context");
      localObject1 = new Intent();
      localObject2 = this.AJX.AEA;
      if (localObject2 != null)
      {
        ((Intent)localObject1).putExtra("nearby_live_target_last_buffer_params_key", ((com.tencent.mm.bx.b)localObject2).toByteArray());
        ((Intent)localObject1).putExtra("nearby_live_target_auto_refresh_params_key", true);
        Log.i(this.TAG, s.X("gotoLive lastBuffer:", localObject2));
      }
      localObject2 = this.Auc;
      if (localObject2 != null) {
        ((Intent)localObject1).putExtra("key_context_id", ((bui)localObject2).zIO);
      }
      localObject2 = ah.aiuX;
      paramArrayList.enterNearbyLiveMoreUI(paramj, (Intent)localObject1);
      ((ce)h.ax(ce.class)).a(null, null, paramInt, q.w.Dxb, getScene());
    }
    AppMethodBeat.o(350721);
  }
  
  public final void e(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(350712);
    s.u(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    Log.i(this.TAG, "[onDetachedFromRecyclerView]");
    paramRecyclerView.b((RecyclerView.l)this.AKg);
    paramRecyclerView = this.AIh;
    if ((paramRecyclerView instanceof bg)) {}
    for (paramRecyclerView = (bg)paramRecyclerView;; paramRecyclerView = null)
    {
      if (paramRecyclerView != null)
      {
        paramRecyclerView = (MMFinderFragment)paramRecyclerView.AZg;
        if (paramRecyclerView != null)
        {
          k localk = k.aeZF;
          ((com.tencent.mm.plugin.finder.viewmodel.component.e)k.y((Fragment)paramRecyclerView).q(com.tencent.mm.plugin.finder.viewmodel.component.e.class)).fne();
        }
      }
      AppMethodBeat.o(350712);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return e.f._finder_feed_full_live_list;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$Companion;", "", "()V", "EMPTY_FOOTER", "", "EMPTY_HEADER", "payloadsChangeItemStatus", "payloadsListScroll", "payloadsLoadMore", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$PaddingChangeListener;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/ActionBarLayoutChangeListener;", "convert", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert;", "(Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert;)V", "getConvert", "()Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onLayoutLocChange", "", "locY", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.finder.viewmodel.component.a
  {
    private final w AKh;
    RecyclerView mkw;
    
    public b(w paramw)
    {
      AppMethodBeat.i(349709);
      this.AKh = paramw;
      AppMethodBeat.o(349709);
    }
    
    public final void Nh(int paramInt)
    {
      AppMethodBeat.i(349714);
      Object localObject1 = this.mkw;
      if ((localObject1 instanceof WxRecyclerView)) {}
      for (localObject1 = (WxRecyclerView)localObject1;; localObject1 = null)
      {
        if (localObject1 != null)
        {
          localObject1 = ((WxRecyclerView)localObject1).fU(0);
          if ((localObject1 != null) && ((localObject1 instanceof j)))
          {
            Object localObject2 = ((j)localObject1).CSA;
            if (((localObject2 instanceof com.tencent.mm.plugin.finder.model.y)) && (s.p(localObject2, this.AKh.AJX))) {
              w.a(this.AKh, (j)localObject1, paramInt);
            }
          }
        }
        AppMethodBeat.o(349714);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$1$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements i.c<j>
  {
    c(WxRecyclerAdapter<?> paramWxRecyclerAdapter, w paramw) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$1$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.l
  {
    d(w paramw) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(349719);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$1$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof LinearLayoutManager)) {}
      for (paramRecyclerView = (LinearLayoutManager)paramRecyclerView;; paramRecyclerView = null)
      {
        if (paramRecyclerView != null) {
          w.a(this.AKj, paramRecyclerView.Jx());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$1$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(349719);
        return;
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(349730);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$1$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      ((ce)h.ax(ce.class)).b(paramRecyclerView, q.w.DwO, w.b(this.AKj), com.tencent.mm.plugin.finder.live.report.d.Dnk);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$1$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(349730);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$checkLoadMore$1", "Lcom/tencent/mm/plugin/findersdk/api/ICgiFinderLiveStreamCallback;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamResponse;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.plugin.findersdk.a.u
  {
    e(w paramw) {}
    
    public final void a(int paramInt1, int paramInt2, final String paramString, bne parambne)
    {
      AppMethodBeat.i(349705);
      s.u(parambne, "resp");
      this.AKj.loading = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i(w.a(this.AKj), s.X("before merge live list:", this.AKj.AJX));
        com.tencent.mm.plugin.finder.model.y localy = this.AKj.AJX;
        s.u(parambne, "resp");
        Object localObject1 = parambne.object;
        Log.i("FinderFeedLiveList", s.X("merge remote list size:", Integer.valueOf(((LinkedList)localObject1).size())));
        localy.AEA = parambne.lastBuffer;
        boolean bool;
        if (parambne.continueFlag > 0)
        {
          bool = true;
          localy.ECL = bool;
          paramString = new LinkedList();
          s.s(localObject1, "remote");
          parambne = ((Iterable)localObject1).iterator();
        }
        for (;;)
        {
          label146:
          if (!parambne.hasNext()) {
            break label417;
          }
          localObject1 = (FinderObject)parambne.next();
          Object localObject2 = (List)localy.hqL;
          paramInt1 = 0;
          localObject2 = ((List)localObject2).iterator();
          label189:
          label225:
          label231:
          label248:
          int i;
          if (((Iterator)localObject2).hasNext()) {
            if (((cc)((Iterator)localObject2).next()).bZA() == ((FinderObject)localObject1).id)
            {
              paramInt2 = 1;
              if (paramInt2 == 0) {
                break label332;
              }
              paramInt2 = paramInt1;
              localObject2 = (List)paramString;
              paramInt1 = 0;
              localObject2 = ((List)localObject2).iterator();
              if (!((Iterator)localObject2).hasNext()) {
                break label357;
              }
              if (((FinderObject)((Iterator)localObject2).next()).id != ((FinderObject)localObject1).id) {
                break label344;
              }
              i = 1;
              label283:
              if (i == 0) {
                break label350;
              }
            }
          }
          for (;;)
          {
            if ((paramInt2 != -1) || (paramInt1 != -1)) {
              break label362;
            }
            localObject2 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
            if (!com.tencent.mm.plugin.finder.live.view.convert.a.j((FinderObject)localObject1)) {
              break label362;
            }
            paramString.add(localObject1);
            break label146;
            bool = false;
            break;
            paramInt2 = 0;
            break label225;
            label332:
            paramInt1 += 1;
            break label189;
            paramInt2 = -1;
            break label231;
            label344:
            i = 0;
            break label283;
            label350:
            paramInt1 += 1;
            break label248;
            label357:
            paramInt1 = -1;
          }
          label362:
          localObject2 = new StringBuilder("merge live list feed:");
          com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
          Log.i("FinderFeedLiveList", com.tencent.mm.plugin.finder.live.view.convert.a.i((FinderObject)localObject1) + ',' + ((FinderObject)localObject1).nickname + " exist!");
        }
        label417:
        if (paramString.size() > 0)
        {
          paramString = com.tencent.mm.plugin.finder.model.y.hc((List)paramString);
          localy.hqL.addAll((Collection)paramString);
          localy.eDn();
          localy.eDp();
          parambne = (Collection)paramString;
          if ((parambne != null) && (!parambne.isEmpty())) {
            break label534;
          }
        }
        label534:
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.AKj, paramString));
          }
          Log.i(w.a(this.AKj), s.X("after merge live list:", this.AKj.AJX));
          AppMethodBeat.o(349705);
          return;
          paramString = null;
          break;
        }
      }
      Log.i(w.a(this.AKj), "[onCgiBack] errType=" + paramInt1 + " errCode=" + paramInt2 + " errMsg=" + paramString + '}');
      AppMethodBeat.o(349705);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(w paramw, ArrayList<com.tencent.mm.plugin.finder.model.z> paramArrayList)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$itemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.view.recyclerview.g
  {
    f(w paramw) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(349689);
      switch (paramInt)
      {
      default: 
        localObject = av.GiL;
        av.eY(w.a(this.AKj), paramInt);
        localObject = (com.tencent.mm.view.recyclerview.f)new g();
        AppMethodBeat.o(349689);
        return localObject;
      case 2004: 
        localObject = (com.tencent.mm.view.recyclerview.f)new x(w.d(this.AKj));
        AppMethodBeat.o(349689);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.f)new y(w.d(this.AKj));
      AppMethodBeat.o(349689);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends RecyclerView.l
  {
    g(w paramw) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(349694);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(349694);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(349688);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      ((ce)h.ax(ce.class)).b(paramRecyclerView, q.w.DwO, w.b(this.AKj), com.tencent.mm.plugin.finder.live.report.d.Dne);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(349688);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$reportExposed$1$1", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "exposedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExposedSet", "()Ljava/util/HashSet;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends e.a
  {
    private final HashSet<Long> AKl;
    
    h(w paramw)
    {
      AppMethodBeat.i(349685);
      this.AKl = new HashSet();
      AppMethodBeat.o(349685);
    }
    
    public final void b(View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(349699);
      s.u(paramView, "parent");
      s.u(paramList, "exposedHolders");
      paramView = new LinkedList();
      Object localObject1 = ((Iterable)paramList).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
        if ((localObject2 instanceof j))
        {
          localObject2 = ((j)localObject2).CSA;
          if (((localObject2 instanceof com.tencent.mm.plugin.finder.model.z)) && (!this.AKl.contains(Long.valueOf(((com.tencent.mm.plugin.finder.model.z)localObject2).ECN.id))))
          {
            this.AKl.add(Long.valueOf(((com.tencent.mm.plugin.finder.model.z)localObject2).ECN.id));
            paramView.add(localObject2);
          }
        }
      }
      localObject1 = w.a(this.AKj);
      Object localObject3 = (Iterable)paramView;
      Object localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(com.tencent.mm.ae.d.hF(((com.tencent.mm.plugin.finder.model.z)((Iterator)localObject3).next()).ECN.id));
      }
      Log.i((String)localObject1, s.X("[onChildExposeChanged] exposed=", (List)localObject2));
      int i;
      if (!((Collection)paramView).isEmpty())
      {
        i = 1;
        if (i != 0) {
          com.tencent.mm.ae.d.e("FinderFeedLiveListExpose", (kotlin.g.a.a)new a(paramView, this.AKj));
        }
        if (((Collection)paramList).isEmpty()) {
          break label419;
        }
        i = 1;
        label290:
        if (i != 0)
        {
          paramView = w.c(this.AKj);
          if (!(paramView instanceof bg)) {
            break label424;
          }
          paramView = (bg)paramView;
          label314:
          if (paramView != null) {
            break label429;
          }
          paramView = null;
          label320:
          if (!(paramView instanceof Fragment)) {
            break label440;
          }
        }
      }
      label419:
      label424:
      label429:
      label440:
      for (paramView = (Fragment)paramView;; paramView = null)
      {
        if (paramView != null)
        {
          paramList = k.aeZF;
          paramView = (ab)k.y(paramView).q(ab.class);
          Log.i("FinderFriendsLeftSlideGuideUIC", s.X("hideTips， ", Boolean.valueOf(paramView.fnI())));
          if (paramView.fnI())
          {
            paramList = paramView.eIW();
            if (paramList != null)
            {
              paramList.setVisibility(8);
              ab.fnJ();
              ab.GQr = null;
              ab.GQs = false;
              paramView.GQq = false;
            }
          }
        }
        AppMethodBeat.o(349699);
        return;
        i = 0;
        break;
        i = 0;
        break label290;
        paramView = null;
        break label314;
        paramView = (MMFinderFragment)paramView.AZg;
        break label320;
      }
    }
    
    public final boolean dXG()
    {
      return true;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(LinkedList<com.tencent.mm.plugin.finder.model.z> paramLinkedList, w paramw)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.w
 * JD-Core Version:    0.7.0.1
 */