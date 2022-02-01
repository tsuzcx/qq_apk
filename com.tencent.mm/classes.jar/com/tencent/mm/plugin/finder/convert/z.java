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
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.az;
import com.tencent.mm.plugin.finder.live.cgi.l.a;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.l;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.ab;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.e.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.h.c;
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
import kotlin.o;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fragmentTabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "TAG", "", "adapterData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "getAdapterData", "()Ljava/util/ArrayList;", "setAdapterData", "(Ljava/util/ArrayList;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "globalData", "getGlobalData", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "setGlobalData", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;)V", "innderAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getInnderAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setInnderAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "innderRvScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getInnderRvScrollListener", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "setInnderRvScrollListener", "(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V", "innerLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getInnerLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setInnerLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvertFactory", "()Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "setItemConvertFactory", "(Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;)V", "liveIdToChange", "", "getLiveIdToChange", "()J", "setLiveIdToChange", "(J)V", "liveStatusChange", "", "getLiveStatusChange", "()Z", "setLiveStatusChange", "(Z)V", "loadMore", "getLoadMore", "setLoadMore", "loading", "getLoading", "setLoading", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1;", "paddingChangeListener", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$PaddingChangeListener;", "getPaddingChangeListener", "()Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$PaddingChangeListener;", "setPaddingChangeListener", "(Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$PaddingChangeListener;)V", "adjustLayout", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "padding", "adjustLayoutPadding", "height", "bindAdapter", "bindToTargetAdapter", "payloads", "", "", "checkLoadMore", "lastPos", "convertToVisitorData", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "dataList", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "clickFeed", "enableAdjustLayout", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "filterList", "item", "findInnderRecycyerItemIndex", "liveId", "getEmptyView", "Landroid/view/View;", "context", "Landroid/content/Context;", "getLayoutId", "getScene", "gotoLive", "position", "needToLoadMore", "feedData", "onAttachedToRecyclerView", "adapter", "onBindViewHolder", "type", "isHotPatch", "onCreateViewHolder", "onDetachedFromRecyclerView", "onLoadMoreFinish", "incrementList", "liveList", "parsePayload", "refreshFooterTips", "refreshHeadTips", "reportExposed", "updatePayload", "Companion", "PaddingChangeListener", "plugin-finder_release"})
public final class z
  extends com.tencent.mm.view.recyclerview.e<com.tencent.mm.plugin.finder.model.x>
{
  public static final a xlP;
  private final String TAG;
  boolean aGh;
  final bid xbu;
  private final com.tencent.mm.plugin.finder.feed.i xhU;
  ArrayList<bu> xlD;
  com.tencent.mm.plugin.finder.model.x xlE;
  private WxRecyclerAdapter<?> xlF;
  private LinearLayoutManager xlG;
  private RecyclerView.l xlH;
  private b xlI;
  private boolean xlJ;
  private boolean xlK;
  private long xlL;
  private com.tencent.mm.view.recyclerview.f xlM;
  private final g xlN;
  private final int xlO;
  
  static
  {
    AppMethodBeat.i(283597);
    xlP = new a((byte)0);
    AppMethodBeat.o(283597);
  }
  
  public z(com.tencent.mm.plugin.finder.feed.i parami, bid parambid, int paramInt)
  {
    AppMethodBeat.i(283596);
    this.xhU = parami;
    this.xbu = parambid;
    this.xlO = paramInt;
    this.TAG = "FinderFeedLiveListConvert";
    this.xlD = new ArrayList();
    this.xlE = new com.tencent.mm.plugin.finder.model.x();
    this.xlI = new b(this);
    this.xlM = ((com.tencent.mm.view.recyclerview.f)new f(this));
    this.xlN = new g(this);
    AppMethodBeat.o(283596);
  }
  
  private final FinderLiveBundle a(com.tencent.mm.view.recyclerview.i parami, ArrayList<y> paramArrayList, y paramy)
  {
    int k = 0;
    AppMethodBeat.i(283595);
    int i = paramArrayList.indexOf(paramy);
    FinderLiveBundle localFinderLiveBundle;
    Object localObject;
    if (i >= 0)
    {
      localFinderLiveBundle = new FinderLiveBundle();
      localFinderLiveBundle.yeA = i;
      localFinderLiveBundle.fEH = this.xlO;
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      parami = parami.getContext();
      p.j(parami, "holder.context");
      parami = aj.a.fZ(parami);
      if (parami == null) {
        break label181;
      }
      parami = parami.ekY();
      if (parami == null) {
        break label181;
      }
    }
    label181:
    for (int j = parami.xkX;; j = 0)
    {
      localFinderLiveBundle.xkX = j;
      localObject = (Iterable)paramArrayList;
      parami = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        y localy = (y)((Iterator)localObject).next();
        com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        parami.add(com.tencent.mm.plugin.finder.live.utils.a.a(localy.zAF, 0, false, 6));
      }
      i = 0;
      break;
    }
    localFinderLiveBundle.ae(new ArrayList((Collection)parami));
    paramy = paramy.zAF.nickname;
    parami = paramy;
    if (paramy == null) {
      parami = "";
    }
    localFinderLiveBundle.aCa(parami);
    parami = (y)j.M((List)paramArrayList, i);
    i = k;
    if (parami != null)
    {
      parami = parami.zAF;
      i = k;
      if (parami != null)
      {
        parami = parami.liveInfo;
        i = k;
        if (parami != null) {
          i = parami.SLO;
        }
      }
    }
    localFinderLiveBundle.extFlag = i;
    AppMethodBeat.o(283595);
    return localFinderLiveBundle;
  }
  
  private final void a(com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(283587);
    parami = parami.RD(b.f.live_list_layout);
    if (parami != null)
    {
      parami.setPadding(parami.getPaddingLeft(), paramInt, parami.getPaddingRight(), parami.getPaddingBottom());
      Log.i(this.TAG, "adjustLayoutPadding newHeight:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(283587);
      return;
    }
    AppMethodBeat.o(283587);
  }
  
  private final boolean a(com.tencent.mm.view.recyclerview.i parami, List<Object> paramList)
  {
    AppMethodBeat.i(283585);
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
          if (p.h(localObject, Integer.valueOf(1)))
          {
            paramList = (RecyclerView)parami.RD(b.f.live_onlive_list_rv);
            if (paramList != null) {}
            for (paramList = paramList.getAdapter();; paramList = null)
            {
              if (!p.h(paramList, this.xlF)) {
                break label225;
              }
              Log.i(this.TAG, "scrollToPosition 0");
              parami = (RecyclerView)parami.RD(b.f.live_onlive_list_rv);
              paramList = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(parami, paramList.aFh(), "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert", "updatePayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Ljava/util/List;)Z", "Undefined", "scrollToPosition", "(I)V");
              parami.scrollToPosition(((Integer)paramList.sf(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(parami, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert", "updatePayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Ljava/util/List;)Z", "Undefined", "scrollToPosition", "(I)V");
              AppMethodBeat.o(283585);
              return true;
              i = 0;
              break;
            }
            label225:
            AppMethodBeat.o(283585);
            return false;
          }
          AppMethodBeat.o(283585);
          return false;
        }
      }
    }
    AppMethodBeat.o(283585);
    return false;
  }
  
  private final int dpB()
  {
    AppMethodBeat.i(283590);
    Iterator localIterator = ((List)this.xlD).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext())
    {
      Object localObject = (bu)localIterator.next();
      if ((localObject instanceof y))
      {
        localObject = (y)localObject;
        com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
        if (com.tencent.mm.plugin.finder.live.view.convert.a.h(((y)localObject).zAF) == this.xlL)
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
      AppMethodBeat.o(283590);
      return i;
      j = 0;
      break label79;
      label101:
      i += 1;
      break;
      i = -1;
    }
    label113:
    AppMethodBeat.o(283590);
    return i + 1;
  }
  
  private final void ec(List<Object> paramList)
  {
    AppMethodBeat.i(283589);
    this.xlJ = false;
    this.xlK = false;
    this.xlL = 0L;
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
        if ((localObject1 instanceof o))
        {
          Object localObject2 = ((o)localObject1).Mx;
          if (p.h(localObject2, Integer.valueOf(2)))
          {
            this.xlJ = true;
            continue;
            i = 0;
            break;
          }
          if ((p.h(localObject2, Integer.valueOf(3))) && ((((o)localObject1).My instanceof Long)))
          {
            this.xlK = true;
            localObject1 = ((o)localObject1).My;
            if (localObject1 == null)
            {
              paramList = new t("null cannot be cast to non-null type kotlin.Long");
              AppMethodBeat.o(283589);
              throw paramList;
            }
            this.xlL = ((Long)localObject1).longValue();
          }
        }
      }
    }
    label187:
    AppMethodBeat.o(283589);
  }
  
  private static View fr(Context paramContext)
  {
    AppMethodBeat.i(283593);
    p.k(paramContext, "context");
    View localView = new View(paramContext);
    localView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(com.tencent.mm.view.d.e(paramContext, 10.0F), 1));
    AppMethodBeat.o(283593);
    return localView;
  }
  
  private final String getScene()
  {
    if (this.xlO == 1) {
      return s.l.yFW.scene;
    }
    if ((this.xlO != 3) && (this.xlO == 2)) {
      return s.l.yFX.scene;
    }
    return s.l.yFP.scene;
  }
  
  private final void l(final com.tencent.mm.view.recyclerview.i parami)
  {
    AppMethodBeat.i(283583);
    Object localObject = (WxRecyclerView)parami.RD(b.f.live_onlive_list_rv);
    this.xlF = new WxRecyclerAdapter(this.xlM, this.xlD, false);
    WxRecyclerAdapter localWxRecyclerAdapter = this.xlF;
    if (localWxRecyclerAdapter != null)
    {
      Context localContext = parami.getContext();
      p.j(localContext, "holder.context");
      com.tencent.mm.view.recyclerview.h.a(localWxRecyclerAdapter, fr(localContext), 1);
      localContext = parami.getContext();
      p.j(localContext, "holder.context");
      com.tencent.mm.view.recyclerview.h.b(localWxRecyclerAdapter, fr(localContext), 2);
      localWxRecyclerAdapter.YSn = ((h.c)new c(localWxRecyclerAdapter, this, parami));
    }
    parami.getContext();
    this.xlG = new LinearLayoutManager(0, false);
    this.xlH = ((RecyclerView.l)new d(this, parami));
    p.j(localObject, "this");
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)this.xlF);
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)this.xlG);
    if ((this.xlH instanceof RecyclerView.l))
    {
      parami = this.xlH;
      if (parami == null)
      {
        parami = new t("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.OnScrollListener");
        AppMethodBeat.o(283583);
        throw parami;
      }
      ((WxRecyclerView)localObject).a(parami);
    }
    ((WxRecyclerView)localObject).setHasFixedSize(true);
    localObject = this.xhU;
    parami = (com.tencent.mm.view.recyclerview.i)localObject;
    if (!(localObject instanceof az)) {
      parami = null;
    }
    parami = (az)parami;
    if (parami != null) {}
    for (parami = (MMFinderFragment)parami.xBT;; parami = null)
    {
      localObject = parami;
      if (!(parami instanceof Fragment)) {
        localObject = null;
      }
      parami = (Fragment)localObject;
      if (parami != null)
      {
        localObject = g.Xox;
        ((com.tencent.mm.plugin.finder.viewmodel.component.x)g.h(parami).i(com.tencent.mm.plugin.finder.viewmodel.component.x.class)).Bkv = true;
      }
      Log.i(this.TAG, "[bindAdapter] tabType:" + this.xlO + ",innderAdapter:" + this.xlF);
      AppMethodBeat.o(283583);
      return;
    }
  }
  
  private final void m(com.tencent.mm.view.recyclerview.i parami)
  {
    AppMethodBeat.i(283588);
    int i;
    if (this.xlO == 2)
    {
      localObject = (Collection)this.xlD;
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
      Log.i(this.TAG, "refreshFooterTips,fragmentTabType:" + this.xlO);
    }
    label101:
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        parami = parami.RD(b.f.footer);
        p.j(parami, "holder.getView<View>(R.id.footer)");
        parami.setVisibility(8);
        do
        {
          AppMethodBeat.o(283588);
          return;
          i = 0;
          break;
          localObject = parami.getAdapter();
        } while (!(localObject instanceof WxRecyclerAdapter));
        localObject = ((Iterable)((WxRecyclerAdapter)localObject).data).iterator();
      }
    } while (((com.tencent.mm.view.recyclerview.a)((Iterator)localObject).next() instanceof com.tencent.mm.plugin.finder.model.x));
    Object localObject = parami.RD(b.f.footer);
    p.j(localObject, "holder.getView<View>(R.id.footer)");
    ((View)localObject).setVisibility(0);
    parami = (TextView)parami.RD(b.f.footer_txt);
    p.j(parami, "footTv");
    ar.a((Paint)parami.getPaint(), 0.8F);
    localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    parami.setText((CharSequence)((Context)localObject).getResources().getString(b.j.finder_live_lbs_tip));
    Log.i(this.TAG, "show footer!");
    AppMethodBeat.o(283588);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(283591);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    if (com.tencent.mm.plugin.finder.utils.aj.a(com.tencent.mm.plugin.finder.utils.aj.AGc, this.xlO, 0, 2))
    {
      this.xlI.jLl = paramRecyclerView;
      paramWxRecyclerAdapter = this.xhU;
      paramRecyclerView = paramWxRecyclerAdapter;
      if (!(paramWxRecyclerAdapter instanceof az)) {
        paramRecyclerView = null;
      }
      paramRecyclerView = (az)paramRecyclerView;
      if (paramRecyclerView != null)
      {
        paramRecyclerView = (MMFinderFragment)paramRecyclerView.xBT;
        if (paramRecyclerView != null)
        {
          paramWxRecyclerAdapter = g.Xox;
          paramRecyclerView = (com.tencent.mm.plugin.finder.viewmodel.component.e)g.h((Fragment)paramRecyclerView).i(com.tencent.mm.plugin.finder.viewmodel.component.e.class);
          paramWxRecyclerAdapter = (com.tencent.mm.plugin.finder.viewmodel.component.a)this.xlI;
          p.k(paramWxRecyclerAdapter, "actionBarLayoutChangeListener");
          Log.i("Finder.DoubleClickTipUIC", "registActionBarLayoutChangeListener, actionBarLayoutChangeListener:" + paramWxRecyclerAdapter + '!');
          paramRecyclerView.Bib = paramWxRecyclerAdapter;
          paramWxRecyclerAdapter = paramRecyclerView.eki();
          if (paramWxRecyclerAdapter != null)
          {
            paramWxRecyclerAdapter = paramWxRecyclerAdapter.getViewTreeObserver();
            if (paramWxRecyclerAdapter != null) {
              paramWxRecyclerAdapter.addOnPreDrawListener(paramRecyclerView.ekj());
            }
          }
        }
      }
    }
    Log.i(this.TAG, "[onAttachedToRecyclerView]");
    AppMethodBeat.o(283591);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(283584);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    l(parami);
    paramRecyclerView.a((RecyclerView.l)this.xlN);
    paramRecyclerView = (WxRecyclerView)parami.RD(b.f.live_onlive_list_rv);
    p.j(paramRecyclerView, "this");
    com.tencent.mm.view.f.a((RecyclerView)paramRecyclerView, (e.a)new h(this));
    AppMethodBeat.o(283584);
  }
  
  public final void a(ArrayList<bu> paramArrayList, int paramInt, com.tencent.mm.view.recyclerview.i parami)
  {
    AppMethodBeat.i(283594);
    p.k(paramArrayList, "dataList");
    p.k(parami, "holder");
    Object localObject2 = parami.ihX();
    Object localObject1;
    if ((localObject2 instanceof y))
    {
      localObject1 = ((y)localObject2).zAF;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).username;
        if (localObject1 != null)
        {
          localObject1 = (CharSequence)localObject1;
          if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
          for (int i = 1; i == 1; i = 0)
          {
            Log.e(this.TAG, "gotoLive err username is empty!");
            AppMethodBeat.o(283594);
            return;
          }
        }
      }
      if (Util.isEqual(((y)localObject2).zAF.username, com.tencent.mm.model.z.bdh()))
      {
        paramArrayList = com.tencent.mm.plugin.finder.utils.a.ACH;
        localObject3 = parami.getContext();
        p.j(localObject3, "holder.context");
        long l = ((y)localObject2).zAF.id;
        parami = ((y)localObject2).zAF.objectNonceId;
        paramArrayList = parami;
        if (parami == null) {
          paramArrayList = "";
        }
        localObject1 = ((y)localObject2).zAF.liveInfo;
        parami = (com.tencent.mm.view.recyclerview.i)localObject1;
        if (localObject1 == null) {
          parami = new bac();
        }
        com.tencent.mm.plugin.finder.utils.a.a((Context)localObject3, l, paramArrayList, parami, null, null, null, null, null, ((y)localObject2).zAF.sessionBuffer, null, null, 7152);
        AppMethodBeat.o(283594);
        return;
      }
      k.yBj.a((y)localObject2, ((y)localObject2).zAF.username, paramInt, s.t.yGP, getScene());
      localObject1 = (Iterable)paramArrayList;
      paramArrayList = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label403:
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = ((Iterator)localObject1).next();
        bu localbu = (bu)localObject3;
        if ((localbu instanceof y))
        {
          bac localbac = ((y)localbu).zAF.liveInfo;
          if ((localbac != null) && (localbac.liveStatus == 2) && (!p.h(localbu, localObject2))) {}
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label403;
          }
          paramArrayList.add(localObject3);
          break;
        }
      }
      paramArrayList = (List)paramArrayList;
      localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
      Object localObject3 = parami.getContext();
      p.j(localObject3, "holder.context");
      localObject2 = a(parami, (ArrayList)paramArrayList, (y)localObject2);
      paramArrayList = this.xbu;
      if (paramArrayList != null)
      {
        parami = paramArrayList.wmL;
        paramArrayList = parami;
        if (parami != null) {}
      }
      else
      {
        paramArrayList = "";
      }
      parami = this.xbu;
      if (parami != null)
      {
        localObject1 = parami.wmz;
        parami = (com.tencent.mm.view.recyclerview.i)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        parami = "";
      }
      com.tencent.mm.plugin.finder.utils.a.a((Context)localObject3, (FinderLiveBundle)localObject2, paramArrayList, parami, null, 16);
      AppMethodBeat.o(283594);
      return;
    }
    if ((localObject2 instanceof ab))
    {
      paramArrayList = (com.tencent.c.a.b.a.e)com.tencent.mm.kernel.h.ag(com.tencent.c.a.b.a.e.class);
      parami = parami.getContext();
      p.j(parami, "holder.context");
      localObject1 = new Intent();
      localObject2 = this.xlE.xGO;
      if (localObject2 != null)
      {
        ((Intent)localObject1).putExtra("nearby_live_target_last_buffer_params_key", ((com.tencent.mm.cd.b)localObject2).toByteArray());
        ((Intent)localObject1).putExtra("nearby_live_target_auto_refresh_params_key", true);
        Log.i(this.TAG, "gotoLive lastBuffer:".concat(String.valueOf(localObject2)));
      }
      localObject2 = this.xbu;
      if (localObject2 != null) {
        ((Intent)localObject1).putExtra("key_context_id", ((bid)localObject2).wmL);
      }
      paramArrayList.enterNearbyLiveMoreUI(parami, (Intent)localObject1);
      k.yBj.a(null, null, paramInt, s.t.yGZ, getScene());
    }
    AppMethodBeat.o(283594);
  }
  
  public final void e(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(283592);
    p.k(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    Log.i(this.TAG, "[onDetachedFromRecyclerView]");
    paramRecyclerView.b((RecyclerView.l)this.xlN);
    Object localObject = this.xhU;
    paramRecyclerView = (RecyclerView)localObject;
    if (!(localObject instanceof az)) {
      paramRecyclerView = null;
    }
    paramRecyclerView = (az)paramRecyclerView;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = (MMFinderFragment)paramRecyclerView.xBT;
      if (paramRecyclerView != null)
      {
        localObject = g.Xox;
        ((com.tencent.mm.plugin.finder.viewmodel.component.e)g.h((Fragment)paramRecyclerView).i(com.tencent.mm.plugin.finder.viewmodel.component.e.class)).ekn();
        AppMethodBeat.o(283592);
        return;
      }
    }
    AppMethodBeat.o(283592);
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(283582);
    if (com.tencent.mm.plugin.finder.utils.aj.a(com.tencent.mm.plugin.finder.utils.aj.AGc, this.xlO, 0, 2))
    {
      i = b.g._finder_feed_full_live_list;
      AppMethodBeat.o(283582);
      return i;
    }
    int i = b.g._finder_feed_live_list;
    AppMethodBeat.o(283582);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$Companion;", "", "()V", "EMPTY_FOOTER", "", "EMPTY_HEADER", "payloadsChangeItemStatus", "payloadsListScroll", "payloadsLoadMore", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$PaddingChangeListener;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/ActionBarLayoutChangeListener;", "convert", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert;", "(Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert;)V", "getConvert", "()Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onLayoutLocChange", "", "locY", "", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.plugin.finder.viewmodel.component.a
  {
    RecyclerView jLl;
    private final z xlQ;
    
    public b(z paramz)
    {
      AppMethodBeat.i(282098);
      this.xlQ = paramz;
      AppMethodBeat.o(282098);
    }
    
    public final void Md(int paramInt)
    {
      AppMethodBeat.i(282097);
      Object localObject2 = this.jLl;
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof WxRecyclerView)) {
        localObject1 = null;
      }
      localObject1 = (WxRecyclerView)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((WxRecyclerView)localObject1).cK(0);
        if (localObject1 != null)
        {
          if ((localObject1 instanceof com.tencent.mm.view.recyclerview.i))
          {
            localObject2 = ((com.tencent.mm.view.recyclerview.i)localObject1).ihX();
            if (((localObject2 instanceof com.tencent.mm.plugin.finder.model.x)) && (p.h(localObject2, this.xlQ.xlE))) {
              z.a(this.xlQ, (com.tencent.mm.view.recyclerview.i)localObject1, paramInt);
            }
          }
          AppMethodBeat.o(282097);
          return;
        }
      }
      AppMethodBeat.o(282097);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$1$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release", "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$$special$$inlined$let$lambda$1"})
  public static final class c
    implements h.c<com.tencent.mm.view.recyclerview.i>
  {
    c(WxRecyclerAdapter paramWxRecyclerAdapter, z paramz, com.tencent.mm.view.recyclerview.i parami) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$1$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.l
  {
    d(z paramz, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(287058);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$$inlined$apply$lambda$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
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
        z.a(this.xlS, paramInt);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$$inlined$apply$lambda$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(287058);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(287059);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$$inlined$apply$lambda$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = k.yBj;
      k.b(paramRecyclerView, s.t.yGM, z.b(this.xlS), com.tencent.mm.plugin.finder.live.report.c.yAn);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$bindAdapter$$inlined$apply$lambda$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(287059);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$checkLoadMore$1", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveStream$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamResponse;", "plugin-finder_release"})
  public static final class e
    implements l.a
  {
    public final void a(int paramInt1, int paramInt2, final String paramString, bcu parambcu)
    {
      AppMethodBeat.i(274483);
      p.k(parambcu, "resp");
      this.xlS.aGh = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i(z.a(this.xlS), "before merge live list:" + this.xlS.xlE);
        paramString = this.xlS.xlE.a(parambcu);
        parambcu = (Collection)paramString;
        if ((parambcu == null) || (parambcu.isEmpty())) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramString));
          }
          Log.i(z.a(this.xlS), "after merge live list:" + this.xlS.xlE);
          AppMethodBeat.o(274483);
          return;
        }
      }
      Log.i(z.a(this.xlS), "[onCgiBack] errType=" + paramInt1 + " errCode=" + paramInt2 + " errMsg=" + paramString + '}');
      AppMethodBeat.o(274483);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(z.e parame, ArrayList paramArrayList)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$itemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class f
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(266178);
      switch (paramInt)
      {
      default: 
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        com.tencent.mm.plugin.finder.utils.aj.em(z.a(this.xlS), paramInt);
        localObject = (com.tencent.mm.view.recyclerview.e)new f();
        AppMethodBeat.o(266178);
        return localObject;
      case 2004: 
        localObject = (com.tencent.mm.view.recyclerview.e)new aa(z.d(this.xlS));
        AppMethodBeat.o(266178);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.e)new ac(z.d(this.xlS));
      AppMethodBeat.o(266178);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class g
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(288628);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(288628);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(288627);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = k.yBj;
      k.b(paramRecyclerView, s.t.yGM, z.b(this.xlS), com.tencent.mm.plugin.finder.live.report.c.yAh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(288627);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedLiveListConvert$reportExposed$1$1", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "exposedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExposedSet", "()Ljava/util/HashSet;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
  public static final class h
    extends e.a
  {
    private final HashSet<Long> xlV;
    
    h(z paramz)
    {
      AppMethodBeat.i(220548);
      this.xlV = new HashSet();
      AppMethodBeat.o(220548);
    }
    
    public final void b(final View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(220557);
      p.k(paramView, "parent");
      p.k(paramList, "exposedHolders");
      paramView = new LinkedList();
      Object localObject1 = ((Iterable)paramList).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
        if ((localObject2 instanceof com.tencent.mm.view.recyclerview.i))
        {
          localObject2 = ((com.tencent.mm.view.recyclerview.i)localObject2).ihX();
          if (((localObject2 instanceof y)) && (!this.xlV.contains(Long.valueOf(((y)localObject2).zAF.id))))
          {
            this.xlV.add(Long.valueOf(((y)localObject2).zAF.id));
            paramView.add(localObject2);
          }
        }
      }
      localObject1 = z.a(this.xlS);
      Object localObject2 = new StringBuilder("[onChildExposeChanged] exposed=");
      Object localObject3 = (Iterable)paramView;
      Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localCollection.add(com.tencent.mm.ae.d.Fw(((y)((Iterator)localObject3).next()).zAF.id));
      }
      Log.i((String)localObject1, (List)localCollection);
      int i;
      if (!((Collection)paramView).isEmpty())
      {
        i = 1;
        if (i != 0) {
          com.tencent.mm.ae.d.c("FinderFeedLiveListExpose", (kotlin.g.a.a)new q(paramView) {});
        }
        if (((Collection)paramList).isEmpty()) {
          break label451;
        }
        i = 1;
        label301:
        if (i == 0) {
          break label467;
        }
        paramList = z.c(this.xlS);
        paramView = paramList;
        if (!(paramList instanceof az)) {
          paramView = null;
        }
        paramView = (az)paramView;
        if (paramView == null) {
          break label456;
        }
      }
      label451:
      label456:
      for (paramView = (MMFinderFragment)paramView.xBT;; paramView = null)
      {
        paramList = paramView;
        if (!(paramView instanceof Fragment)) {
          paramList = null;
        }
        paramView = (Fragment)paramList;
        if (paramView == null) {
          break label467;
        }
        paramList = g.Xox;
        paramView = (com.tencent.mm.plugin.finder.viewmodel.component.x)g.h(paramView).i(com.tencent.mm.plugin.finder.viewmodel.component.x.class);
        Log.i("FinderFriendsLeftSlideGuideUIC", "hideTips， " + paramView.ekD());
        if (!paramView.ekD()) {
          break label461;
        }
        paramList = paramView.dNu();
        if (paramList == null) {
          break label461;
        }
        paramList.setVisibility(8);
        com.tencent.mm.plugin.finder.viewmodel.component.x.ekE();
        com.tencent.mm.plugin.finder.viewmodel.component.x.Bkx = null;
        com.tencent.mm.plugin.finder.viewmodel.component.x.Bky = false;
        paramView.Bkw = false;
        AppMethodBeat.o(220557);
        return;
        i = 0;
        break;
        i = 0;
        break label301;
      }
      label461:
      AppMethodBeat.o(220557);
      return;
      label467:
      AppMethodBeat.o(220557);
    }
    
    public final boolean dpC()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.z
 * JD-Core Version:    0.7.0.1
 */