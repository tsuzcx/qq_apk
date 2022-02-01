package com.tencent.mm.plugin.finder.nearby.newlivesquare;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ath;
import com.tencent.mm.protocal.protobuf.atw;
import com.tencent.mm.protocal.protobuf.bad;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.refreshLayout.WxRefreshLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragmentViewCallback;", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragmentPresenter;", "parentView", "Landroid/view/View;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Landroidx/fragment/app/Fragment;Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragmentPresenter;Landroid/view/View;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "adapter", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/NewEntranceAdapter;", "audience21053Report", "Lcom/tencent/mm/plugin/finder/live/report/Audience21053Report;", "autoPlayManager", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager;", "caller", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener;", "cgiLastResp", "Lcom/tencent/mm/protocal/protobuf/FinderNavLiveStreamResponse;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "currRedDotFeedId", "", "feedDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "finderGetLiveTabsResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveTabsResponse;", "finderNearbyRefreshEventListener", "com/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragmentViewCallback$finderNearbyRefreshEventListener$1", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragmentViewCallback$finderNearbyRefreshEventListener$1;", "getFragment", "()Landroidx/fragment/app/Fragment;", "isHasBeenLoadFromNetwork", "", "isRefreshingOrLoadingMore", "lastNoticeSnapshot", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "nearbyLiveViewItemClick", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/NewEntranceViewItemClick;", "getParentView", "()Landroid/view/View;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragmentPresenter;", "recommendTabs", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewLayoutManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderStaggeredGridLayoutManager;", "refreshLayout", "Lcom/tencent/mm/view/refreshLayout/WxRefreshLayout;", "rvScrollAutoPlayChecker", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/NewEntranceRVScrollAutoPlayChecker;", "workerScope", "checkNoticeStatus", "", "cleanRedDotInCache", "getAndCleanObjectIdForRedDotSystem", "getFollowListObjectIds", "", "getObjectIdsWithOutFollow", "handleClickReport", "feed", "position", "", "handleExposeReport", "record", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "initView", "loadDataWithCgi", "fromHead", "containerId", "pullType", "relatedObjectId", "gciListenerWithInterdict", "Lkotlin/Function1;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "gciListenerWithOutInterdict", "loadLastExitData", "loadPrefetchData", "onCreate", "onDestroy", "onPause", "onResume", "onRvRefreshOrLoadMoreCall", "isRefresh", "source", "onStart", "onStop", "onTabListResponse", "tabs", "resp", "recordCurNoticeStatus", "registerEvent", "startToScrollWhereRedDotHere", "transResponseToListData", "insertAfterObjectId", "cleanCurrent", "unRegisterEvent", "Companion", "SpacesItemDecoration", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final a EMH;
  final bui Auc;
  final aq CSl;
  com.tencent.mm.plugin.finder.nearby.live.play.e EIX;
  private com.tencent.mm.plugin.finder.live.report.a EJr;
  private final c EMI;
  private boolean EMJ;
  FinderStaggeredGridLayoutManager EMK;
  final ArrayList<cc> EML;
  com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.h EMM;
  WxRefreshLayout EMN;
  final h EMO;
  com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.j EMP;
  long EMQ;
  bqr EMR;
  private final com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.a EMS;
  final List<bnn> EMT;
  bad EMU;
  final LiveEntranceFragmentViewCallback.finderNearbyRefreshEventListener.1 EMV;
  String akhD;
  private boolean akhE;
  final Fragment fragment;
  final MMActivity lzt;
  final aq mainScope;
  RecyclerView mkw;
  final View uJh;
  
  static
  {
    AppMethodBeat.i(340469);
    EMH = new a((byte)0);
    AppMethodBeat.o(340469);
  }
  
  public f(MMActivity paramMMActivity, Fragment paramFragment, View paramView, bui parambui)
  {
    AppMethodBeat.i(340268);
    this.lzt = paramMMActivity;
    this.fragment = paramFragment;
    this.EMI = null;
    this.uJh = paramView;
    this.Auc = parambui;
    this.mainScope = ar.kBZ();
    this.CSl = ar.d((kotlin.d.f)bg.kCi());
    this.EML = new ArrayList();
    this.EMO = new h();
    this.EJr = new com.tencent.mm.plugin.finder.live.report.a();
    this.EMS = new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.a(this.Auc, this.lzt, this.fragment);
    this.EMT = ((List)new ArrayList());
    this.EMV = new LiveEntranceFragmentViewCallback.finderNearbyRefreshEventListener.1(this, this.lzt);
    Log.i("Finder.LiveEntranceFragmentViewCallback", "#init");
    AppMethodBeat.o(340268);
  }
  
  private static final void a(f paramf, bqr parambqr, long paramLong)
  {
    AppMethodBeat.i(340347);
    Object localObject1 = ((Iterable)paramf.EML).iterator();
    int i = 0;
    int j = -1;
    Object localObject2;
    for (;;)
    {
      int k = i;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = ((Iterator)localObject1).next();
      i = k + 1;
      if (k < 0) {
        kotlin.a.p.kkW();
      }
      localObject2 = (cc)localObject2;
      if (((localObject2 instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b)) && (((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b)localObject2).feedObject.getFeedObject().id == paramLong)) {
        j = k + 1;
      }
    }
    if (j == -1)
    {
      AppMethodBeat.o(340347);
      return;
    }
    bna localbna;
    bmz localbmz;
    FinderItem localFinderItem;
    if (parambqr != null)
    {
      parambqr = parambqr.ZYB;
      if (parambqr != null)
      {
        localObject2 = ((Iterable)parambqr).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localbna = (bna)((Iterator)localObject2).next();
          if (localbna.type == 4)
          {
            parambqr = localbna.YBg;
            if (parambqr != null)
            {
              Iterator localIterator = ((Iterable)parambqr).iterator();
              i = j;
              j = i;
              if (localIterator.hasNext())
              {
                localbmz = (bmz)localIterator.next();
                parambqr = localbmz.ZIo;
                if (parambqr == null) {
                  break label470;
                }
                localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
                parambqr = kotlin.a.p.listOf(parambqr);
                localObject1 = av.GiL;
                localFinderItem = (FinderItem)kotlin.a.p.oL(d.a.a(parambqr, av.Ui(0), paramf.Auc));
                if (localFinderItem == null) {
                  break label470;
                }
                localObject1 = null;
                parambqr = (bqr)localObject1;
                switch (localbmz.style)
                {
                default: 
                  parambqr = (bqr)localObject1;
                case 5: 
                  label319:
                  if (parambqr == null) {
                    break label470;
                  }
                  paramf.EML.add(i, parambqr);
                  localObject1 = paramf.EMM;
                  if (localObject1 != null) {
                    ((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.h)localObject1).fW(i);
                  }
                  Log.i("Finder.LiveEntranceFragmentViewCallback", kotlin.g.b.s.X("#transResponseToListData insertAfterObjectId success! userName=", parambqr.feedObject.getUserName()));
                  i += 1;
                }
              }
            }
          }
        }
      }
    }
    label470:
    for (;;)
    {
      break;
      kotlin.g.b.s.s(localbna, "container");
      parambqr = (com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b)new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.j(localFinderItem, localbna, localbmz.ZVJ);
      break label319;
      kotlin.g.b.s.s(localbna, "container");
      parambqr = localbmz.ZVH;
      kotlin.g.b.s.s(parambqr, "card.relate_living");
      parambqr = (com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b)new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.l(localFinderItem, localbna, (List)parambqr, localbmz.ZVK, localbmz.ZVJ);
      break label319;
      AppMethodBeat.o(340347);
      return;
    }
  }
  
  private final void a(bqr parambqr, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(340322);
    Log.i("Finder.LiveEntranceFragmentViewCallback", "#transResponseToListData insertAfterObjectId=" + paramLong + " cleanCurrent=" + paramBoolean);
    int i;
    if (paramBoolean)
    {
      i = this.EML.size();
      this.EML.clear();
      localObject1 = this.EMM;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.h)localObject1).bB(0, i);
        localObject1 = ah.aiuX;
      }
    }
    if (paramLong != 0L)
    {
      a(this, parambqr, paramLong);
      AppMethodBeat.o(340322);
      return;
    }
    Object localObject1 = eFM();
    Object localObject2 = kLq();
    Object localObject3;
    Object localObject4;
    if (parambqr != null)
    {
      localObject3 = parambqr.ZYB;
      if (localObject3 != null)
      {
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bna)((Iterator)localObject3).next();
          if (((bna)localObject4).type == 1)
          {
            localObject4 = ((bna)localObject4).YBg;
            kotlin.g.b.s.s(localObject4, "container.card_list");
            y((List)localObject1, (List)localObject4);
          }
          else
          {
            localObject4 = ((bna)localObject4).YBg;
            kotlin.g.b.s.s(localObject4, "container.card_list");
            y((List)localObject2, (List)localObject4);
          }
        }
        localObject1 = ah.aiuX;
      }
    }
    localObject1 = this.EMR;
    if (localObject1 == null)
    {
      paramBoolean = false;
      Log.i("Finder.LiveEntranceFragmentViewCallback", kotlin.g.b.s.X("#transResponseToListData skipAsyncLoadLiveInfo=", Boolean.valueOf(paramBoolean)));
      if (parambqr == null) {
        break label830;
      }
      localObject1 = parambqr.ZYB;
      if (localObject1 == null) {
        break label830;
      }
      localObject2 = ((Iterable)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bna)((Iterator)localObject2).next();
          if (((bna)localObject3).type == 4)
          {
            i = 0;
            localObject1 = ((Iterable)this.EML).iterator();
            label341:
            if (((Iterator)localObject1).hasNext())
            {
              if (!((cc)((Iterator)localObject1).next() instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b)) {
                break label2334;
              }
              i += 1;
            }
          }
        }
      }
    }
    label530:
    label2334:
    for (;;)
    {
      break label341;
      paramBoolean = ((bqr)localObject1).ZYD;
      break;
      i = ((bna)localObject3).YBg.size() + i;
      switch (((bna)localObject3).ZVN)
      {
      }
      label437:
      Object localObject5;
      label584:
      label629:
      do
      {
        do
        {
          do
          {
            for (localObject1 = "count_restrict解释-0:不限制 1:限制奇数 2:限制偶数\n";; localObject1 = "count_restrict解释-0:不限制 1:限制奇数 2:限制偶数\n")
            {
              Log.i("Finder.LiveEntranceFragmentViewCallback", kotlin.g.b.s.X("#transResponseToListData count_restrict status: ", localObject1));
              localObject4 = j.akhI;
              j.kLu().invoke(kotlin.g.b.s.X("卡片奇偶数列表整理情况:count_restrict=", Integer.valueOf(((bna)localObject3).ZVN)), localObject1);
              break;
            }
          } while (i % 2 != 0);
          localObject1 = ((bna)localObject3).YBg;
          kotlin.g.b.s.s(localObject1, "container.card_list");
          if (((Collection)localObject1).isEmpty()) {
            break label629;
          }
          i = 1;
        } while (i == 0);
        localObject4 = (bmz)((bna)localObject3).YBg.removeLast();
        localObject5 = new StringBuilder().append("count_restrict解释-0:不限制 1:限制奇数 2:限制偶数\n").append(" remove id=");
        localObject1 = ((bmz)localObject4).ZIo;
        if (localObject1 == null)
        {
          localObject1 = null;
          localObject5 = ((StringBuilder)localObject5).append(localObject1).append(", name=");
          localObject1 = ((bmz)localObject4).ZIo;
          if (localObject1 != null) {
            break label648;
          }
        }
        for (localObject1 = null;; localObject1 = ((FinderObject)localObject1).nickname)
        {
          localObject1 = localObject1;
          break;
          i = 0;
          break label530;
          localObject1 = Long.valueOf(((FinderObject)localObject1).id);
          break label584;
        }
      } while (i % 2 != 1);
      localObject1 = ((bna)localObject3).YBg;
      kotlin.g.b.s.s(localObject1, "container.card_list");
      if (!((Collection)localObject1).isEmpty())
      {
        i = 1;
        label697:
        if (i == 0) {
          break label800;
        }
        localObject4 = (bmz)((bna)localObject3).YBg.removeLast();
        localObject5 = new StringBuilder().append("count_restrict解释-0:不限制 1:限制奇数 2:限制偶数\n").append(" remove id=");
        localObject1 = ((bmz)localObject4).ZIo;
        if (localObject1 != null) {
          break label802;
        }
        localObject1 = null;
        label751:
        localObject5 = ((StringBuilder)localObject5).append(localObject1).append(", name=");
        localObject1 = ((bmz)localObject4).ZIo;
        if (localObject1 != null) {
          break label815;
        }
      }
      label800:
      label802:
      label815:
      for (localObject1 = null;; localObject1 = ((FinderObject)localObject1).nickname)
      {
        localObject1 = localObject1;
        break label437;
        i = 0;
        break label697;
        break;
        localObject1 = Long.valueOf(((FinderObject)localObject1).id);
        break label751;
      }
      localObject1 = ah.aiuX;
      label830:
      if (parambqr != null)
      {
        parambqr = parambqr.ZYB;
        if (parambqr != null)
        {
          localObject2 = ((Iterable)parambqr).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (bna)((Iterator)localObject2).next();
            Log.i("Finder.LiveEntranceFragmentViewCallback", "#transResponseToListData container.type=" + ((bna)localObject3).type + " container.container_id=" + ((bna)localObject3).Zpm + " container.card_list.size=" + ((bna)localObject3).YBg.size());
            kotlin.g.b.s.s(localObject3, "container");
            if (a(this, (bna)localObject3))
            {
              AppMethodBeat.o(340322);
              return;
            }
            Object localObject6;
            Object localObject7;
            ArrayList localArrayList;
            switch (((bna)localObject3).type)
            {
            default: 
              break;
            case 1: 
              parambqr = this.EML;
              localObject1 = new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.f((bna)localObject3);
              localObject3 = ((bna)localObject3).YBg;
              if (localObject3 != null)
              {
                localObject3 = ((Iterable)localObject3).iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = ((bmz)((Iterator)localObject3).next()).ZIo;
                  if (localObject4 != null)
                  {
                    localObject5 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
                    localObject4 = kotlin.a.p.listOf(localObject4);
                    localObject5 = av.GiL;
                    localObject4 = (FinderItem)kotlin.a.p.oL(d.a.a((List)localObject4, av.Ui(0), this.Auc));
                    if (localObject4 != null)
                    {
                      ((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.f)localObject1).EML.add(new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.e((FinderItem)localObject4));
                      localObject4 = ah.aiuX;
                      localObject4 = ah.aiuX;
                    }
                    localObject4 = ah.aiuX;
                    localObject4 = ah.aiuX;
                  }
                }
                localObject3 = ah.aiuX;
              }
              localObject3 = ah.aiuX;
              parambqr.add(localObject1);
              parambqr = this.EMM;
              if (parambqr != null)
              {
                parambqr.fW(this.EML.size() - 1);
                parambqr = ah.aiuX;
              }
              break;
            case 2: 
              localObject4 = this.EML;
              localObject5 = new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.d((bna)localObject3);
              parambqr = ((bna)localObject3).YBg;
              if (parambqr != null)
              {
                localObject6 = ((Iterable)parambqr).iterator();
                while (((Iterator)localObject6).hasNext())
                {
                  localObject1 = (bmz)((Iterator)localObject6).next();
                  parambqr = ((bmz)localObject1).ZIo;
                  if (parambqr != null)
                  {
                    localObject7 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
                    parambqr = kotlin.a.p.listOf(parambqr);
                    localObject7 = av.GiL;
                    localObject7 = (FinderItem)kotlin.a.p.oL(d.a.a(parambqr, av.Ui(0), this.Auc));
                    if (localObject7 != null)
                    {
                      localArrayList = ((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.d)localObject5).EML;
                      parambqr = ((bmz)localObject1).ZVI;
                      if (parambqr != null) {
                        break label1385;
                      }
                      parambqr = null;
                      localObject1 = ((bmz)localObject1).ZVI;
                      if (localObject1 != null) {
                        break label1393;
                      }
                    }
                    for (localObject1 = null;; localObject1 = ((atw)localObject1).ZDM)
                    {
                      localArrayList.add(new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.c((FinderItem)localObject7, (bna)localObject3, paramBoolean, parambqr, (String)localObject1, 2));
                      parambqr = ah.aiuX;
                      parambqr = ah.aiuX;
                      parambqr = ah.aiuX;
                      parambqr = ah.aiuX;
                      break;
                      parambqr = parambqr.wording;
                      break label1328;
                    }
                  }
                }
                parambqr = ah.aiuX;
              }
              parambqr = ah.aiuX;
              ((ArrayList)localObject4).add(localObject5);
              parambqr = this.EMM;
              if (parambqr != null)
              {
                parambqr.fW(this.EML.size() - 1);
                parambqr = ah.aiuX;
              }
              break;
            case 5: 
              localObject4 = this.EML;
              localObject5 = new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.b((bna)localObject3);
              parambqr = ((bna)localObject3).YBg;
              if (parambqr != null)
              {
                parambqr = (Iterable)parambqr;
                i = 0;
                localObject6 = parambqr.iterator();
                while (((Iterator)localObject6).hasNext())
                {
                  parambqr = ((Iterator)localObject6).next();
                  if (i < 0) {
                    kotlin.a.p.kkW();
                  }
                  parambqr = (bmz)parambqr;
                  localObject7 = parambqr.ZVL;
                  if (localObject7 != null)
                  {
                    localArrayList = ((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.b)localObject5).EML;
                    localObject1 = parambqr.ttL;
                    parambqr = (bqr)localObject1;
                    if (localObject1 == null) {
                      parambqr = "";
                    }
                    localArrayList.add(new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.a((ath)localObject7, parambqr, (bna)localObject3, i, ((bna)localObject3).YBg.size()));
                    parambqr = ah.aiuX;
                    parambqr = ah.aiuX;
                  }
                  i += 1;
                }
                parambqr = ah.aiuX;
              }
              parambqr = ah.aiuX;
              ((ArrayList)localObject4).add(localObject5);
              parambqr = this.EMM;
              if (parambqr != null)
              {
                parambqr.fW(this.EML.size() - 1);
                parambqr = ah.aiuX;
              }
              break;
            case 3: 
              parambqr = this.EML;
              localObject1 = new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.m((bna)localObject3);
              localObject3 = ((bna)localObject3).YBg;
              if (localObject3 != null)
              {
                localObject3 = ((Iterable)localObject3).iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (bmz)((Iterator)localObject3).next();
                  localObject5 = g.ENe;
                  localObject5 = (List)((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.m)localObject1).EML;
                  kotlin.g.b.s.s(localObject4, "card");
                  g.a((List)localObject5, (bmz)localObject4, (com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.m)localObject1, this.Auc);
                }
                localObject3 = ah.aiuX;
              }
              localObject3 = ah.aiuX;
              parambqr.add(localObject1);
              parambqr = this.EMM;
              if (parambqr != null)
              {
                parambqr.fW(this.EML.size() - 1);
                parambqr = ah.aiuX;
              }
              break;
            case 4: 
              label1385:
              label1393:
              parambqr = this.EML;
              if (!parambqr.isEmpty())
              {
                localObject1 = (cc)kotlin.a.p.oN((List)parambqr);
                if ((localObject1 != null) && (((cc)localObject1).bZB() == 4))
                {
                  i = 1;
                  if (i != 0) {
                    break label2101;
                  }
                }
              }
              else
              {
                i = 1;
                if (i == 0) {
                  break label2107;
                }
                if (parambqr != null)
                {
                  localObject4 = this.EML;
                  localObject1 = ((bna)localObject3).name;
                  parambqr = (bqr)localObject1;
                  if (localObject1 == null) {
                    parambqr = "";
                  }
                  parambqr = new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.h(parambqr, (bna)localObject3);
                  parambqr.tabs.addAll((Collection)this.EMT);
                  localObject1 = ah.aiuX;
                  ((ArrayList)localObject4).add(parambqr);
                  parambqr = this.EMM;
                  if (parambqr != null)
                  {
                    parambqr.fW(this.EML.size() - 1);
                    parambqr = ah.aiuX;
                  }
                }
                parambqr = ((bna)localObject3).YBg;
                if (parambqr == null) {
                  break label2259;
                }
                parambqr = ((Iterable)parambqr).iterator();
                do
                {
                  if (!parambqr.hasNext()) {
                    break;
                  }
                  localObject1 = (bmz)parambqr.next();
                  localObject4 = ((bmz)localObject1).ZIo;
                } while (localObject4 == null);
                localObject5 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
                localObject4 = kotlin.a.p.listOf(localObject4);
                localObject5 = av.GiL;
                localObject4 = (FinderItem)kotlin.a.p.oL(d.a.a((List)localObject4, av.Ui(0), this.Auc));
                if (localObject4 != null) {
                  switch (((bmz)localObject1).style)
                  {
                  }
                }
              }
              for (;;)
              {
                localObject1 = ah.aiuX;
                localObject1 = ah.aiuX;
                localObject1 = ah.aiuX;
                localObject1 = ah.aiuX;
                break label1967;
                i = 0;
                break;
                i = 0;
                break label1847;
                parambqr = null;
                break label1852;
                this.EML.add(new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.j((FinderItem)localObject4, (bna)localObject3, ((bmz)localObject1).ZVJ));
                localObject1 = this.EMM;
                if (localObject1 != null)
                {
                  ((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.h)localObject1).fW(this.EML.size() - 1);
                  localObject1 = ah.aiuX;
                  continue;
                  localObject5 = this.EML;
                  localObject6 = ((bmz)localObject1).ZVH;
                  kotlin.g.b.s.s(localObject6, "card.relate_living");
                  ((ArrayList)localObject5).add(new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.l((FinderItem)localObject4, (bna)localObject3, (List)localObject6, ((bmz)localObject1).ZVK, ((bmz)localObject1).ZVJ));
                  localObject1 = this.EMM;
                  if (localObject1 != null)
                  {
                    ((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.h)localObject1).fW(this.EML.size() - 1);
                    localObject1 = ah.aiuX;
                  }
                }
              }
              parambqr = ah.aiuX;
              label2259:
              parambqr = (cc)kotlin.a.p.oN((List)this.EML);
              if (parambqr != null)
              {
                if ((parambqr instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.a))
                {
                  ((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.a)parambqr).f(((bna)localObject3).Zpn);
                  ((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.a)parambqr).QQ(((bna)localObject3).BeA);
                }
                parambqr = ah.aiuX;
                parambqr = ah.aiuX;
              }
              break;
            }
          }
          parambqr = ah.aiuX;
        }
      }
      label1328:
      label1847:
      label1852:
      AppMethodBeat.o(340322);
      label1967:
      label2101:
      label2107:
      return;
    }
  }
  
  private static final boolean a(f paramf, bna parambna)
  {
    AppMethodBeat.i(340367);
    Iterator localIterator = ((Iterable)paramf.EML).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject = (cc)localObject;
      if (((localObject instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.a)) && (!(localObject instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b)) && (((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.a)localObject).eFS() == parambna.Zpm))
      {
        ((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.a)localObject).QQ(parambna.BeA);
        ((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.a)localObject).f(parambna.Zpn);
        paramf = paramf.EMO;
        i = parambna.Zpm;
        parambna = parambna.YBg;
        kotlin.g.b.s.s(parambna, "container.card_list");
        parambna = (List)parambna;
        kotlin.g.b.s.u(parambna, "cards");
        paramf = ((Iterable)paramf.listeners).iterator();
        while (paramf.hasNext()) {
          ((h.a)paramf.next()).E(i, parambna);
        }
        Log.i("Finder.LiveEntranceFragmentViewCallback", "#transResponseToListData-oldContainerAppend insert container_id=container.container_id");
        AppMethodBeat.o(340367);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(340367);
    return false;
  }
  
  private final List<Long> eFM()
  {
    AppMethodBeat.i(340283);
    List localList = (List)new ArrayList();
    Iterator localIterator = ((Iterable)this.EML).iterator();
    while (localIterator.hasNext())
    {
      cc localcc = (cc)localIterator.next();
      if ((localcc instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.f)) {
        localList.addAll((Collection)((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.f)localcc).eFR());
      }
    }
    AppMethodBeat.o(340283);
    return localList;
  }
  
  static long kLs()
  {
    long l2 = 0L;
    AppMethodBeat.i(370487);
    Object localObject = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
    com.tencent.mm.plugin.finder.extension.reddot.p localp = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject).Su("FinderLiveEntrance");
    long l1 = l2;
    if (localp != null)
    {
      l1 = l2;
      if (localp.avK("FinderLiveEntrance") != null)
      {
        l1 = l2;
        if (localp.field_ctrInfo.type == 16)
        {
          ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject).e(localp);
          localObject = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject).avs("NearbyLiveTab");
          if (localObject != null) {
            break label126;
          }
        }
      }
    }
    label126:
    for (l1 = 0L;; l1 = ((btx)localObject).object_id)
    {
      Log.i("Finder.LiveEntranceFragmentViewCallback", "#disposeRedDotInSystem");
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().TL("FinderLiveEntrance");
      AppMethodBeat.o(370487);
      return l1;
    }
  }
  
  private static final void y(List<Long> paramList, List<bmz> paramList1)
  {
    AppMethodBeat.i(340356);
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = paramList1.iterator();
    if (localIterator.hasNext())
    {
      bmz localbmz = (bmz)localIterator.next();
      paramList1 = localbmz.ZIo;
      long l;
      label57:
      StringBuilder localStringBuilder2;
      if (paramList1 == null)
      {
        l = 0L;
        if (!paramList.contains(Long.valueOf(l))) {
          break label157;
        }
        localStringBuilder2 = new StringBuilder("id=");
        paramList1 = localbmz.ZIo;
        if (paramList1 != null) {
          break label159;
        }
        paramList1 = null;
        label94:
        localStringBuilder2 = localStringBuilder2.append(paramList1).append(" name=");
        paramList1 = localbmz.ZIo;
        if (paramList1 != null) {
          break label170;
        }
      }
      label157:
      label159:
      label170:
      for (paramList1 = null;; paramList1 = paramList1.nickname)
      {
        localStringBuilder1.append(kotlin.g.b.s.X(paramList1, "\n"));
        localIterator.remove();
        break;
        l = paramList1.id;
        break label57;
        break;
        paramList1 = Long.valueOf(paramList1.id);
        break label94;
      }
    }
    paramList = localStringBuilder1.toString();
    kotlin.g.b.s.s(paramList, "it");
    int i;
    if (((CharSequence)paramList).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label255;
      }
    }
    for (;;)
    {
      if (paramList != null)
      {
        Log.i("Finder.LiveEntranceFragmentViewCallback", kotlin.g.b.s.X("#checkAndRemoveDuplicateData remove: ", paramList));
        paramList1 = j.akhI;
        j.kLu().invoke("有重复内容，已移除", paramList);
      }
      AppMethodBeat.o(340356);
      return;
      i = 0;
      break;
      label255:
      paramList = null;
    }
  }
  
  final List<Long> kLq()
  {
    AppMethodBeat.i(370516);
    List localList = (List)new ArrayList();
    Iterator localIterator = ((Iterable)this.EML).iterator();
    while (localIterator.hasNext())
    {
      cc localcc = (cc)localIterator.next();
      if (((localcc instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.a)) && (!(localcc instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.f))) {
        localList.addAll((Collection)((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.a)localcc).eFR());
      }
    }
    AppMethodBeat.o(370516);
    return localList;
  }
  
  final void kLr()
  {
    AppMethodBeat.i(370518);
    final long l = this.EMQ;
    if (l == 0L)
    {
      AppMethodBeat.o(370518);
      return;
    }
    kotlinx.coroutines.j.a(this.mainScope, null, null, (kotlin.g.a.m)new j(this, l, null), 3);
    AppMethodBeat.o(370518);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragmentViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragmentViewCallback$SpacesItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragmentViewCallback;)V", "LONG_MARGIN", "", "SHORT_MARGIN", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends RecyclerView.h
  {
    private final int EMW;
    private final int EMX;
    
    public b()
    {
      AppMethodBeat.i(340293);
      this.EMW = bd.fromDPToPix(MMApplicationContext.getContext(), 6);
      this.EMX = bd.fromDPToPix(MMApplicationContext.getContext(), 12);
      AppMethodBeat.o(340293);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(340300);
      kotlin.g.b.s.u(paramRect, "outRect");
      kotlin.g.b.s.u(paramView, "view");
      kotlin.g.b.s.u(paramRecyclerView, "parent");
      kotlin.g.b.s.u(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      int j = RecyclerView.bA(paramView);
      if ((j < 0) || (j >= f.d(this.EMY).size()))
      {
        AppMethodBeat.o(340300);
        return;
      }
      paramView = f.d(this.EMY).get(j);
      kotlin.g.b.s.s(paramView, "feedDataList[position]");
      if (!((cc)paramView instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b))
      {
        AppMethodBeat.o(340300);
        return;
      }
      int i = 1;
      if (j > 0)
      {
        j -= 1;
        paramView = f.d(this.EMY).get(j);
        kotlin.g.b.s.s(paramView, "feedDataList[position]");
        if (((cc)paramView instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b))
        {
          if (i == 0) {}
          for (i = 1;; i = 0) {
            break;
          }
        }
      }
      if (i != 0)
      {
        j = this.EMX;
        paramRect.left = j;
        if (i == 0) {
          break label227;
        }
      }
      label227:
      for (i = this.EMW;; i = this.EMX)
      {
        paramRect.right = i;
        paramRect.bottom = bd.fromDPToPix(MMApplicationContext.getContext(), 12);
        AppMethodBeat.o(340300);
        return;
        j = this.EMW;
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragmentViewCallback$initView$1", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "getOutsideFinderGetLiveTabsResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveTabsResponse;", "getOutsideLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "loadData", "", "containerId", "", "containerLastBuffer", "gciListener", "Lkotlin/Function1;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderNavLiveStreamResponse;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements b
  {
    c(f paramf) {}
    
    public final void d(int paramInt, kotlin.g.a.b<? super b.a<bqr>, ah> paramb)
    {
      AppMethodBeat.i(340296);
      kotlin.g.b.s.u(paramb, "gciListener");
      f.a(this.EMY, false, paramInt, 2, 0L, paramb, null, 40);
      AppMethodBeat.o(340296);
    }
    
    public final com.tencent.mm.bx.b eFK()
    {
      AppMethodBeat.i(340305);
      Object localObject = f.a(this.EMY);
      if (localObject == null)
      {
        AppMethodBeat.o(340305);
        return null;
      }
      localObject = ((bqr)localObject).ZEQ;
      AppMethodBeat.o(340305);
      return localObject;
    }
    
    public final bad eFL()
    {
      AppMethodBeat.i(340314);
      bad localbad = f.b(this.EMY);
      AppMethodBeat.o(340314);
      return localbad;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragmentViewCallback$initView$2$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements i.c<com.tencent.mm.view.recyclerview.j>
  {
    d(f paramf) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.nearby.live.play.e>
  {
    e(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragmentViewCallback$initView$6", "Lcom/tencent/mm/view/refreshLayout/listener/OnRefreshAction;", "onLoadMore", "", "onRefresh", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.mm.view.refreshLayout.d.b
  {
    g(f paramf) {}
    
    public final void onLoadMore()
    {
      AppMethodBeat.i(370481);
      f.a(this.EMY, false, "rv-load-more");
      AppMethodBeat.o(370481);
    }
    
    public final void onRefresh()
    {
      AppMethodBeat.i(370478);
      f.a(this.EMY, true, "rv-refresh");
      AppMethodBeat.o(370478);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    h(f paramf, int paramInt1, int paramInt2, boolean paramBoolean, long paramLong, kotlin.g.a.b<? super b.a<bqr>, ah> paramb1, kotlin.g.a.b<? super b.a<bqr>, ah> paramb2, kotlin.d.d<? super h> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(340334);
      paramd = new h(this.EMY, this.AEt, this.EMZ, this.ENa, this.ENb, this.akhG, this.akhH, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(340334);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(340327);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(340327);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        paramObject = (com.tencent.mm.plugin.datapreloader.a)new com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi.c((kotlin.g.a.a)new a(this.AEt, this.EMZ, this.ENa, this.EMY, this.ENb), (cb)paramObject.getCoroutineContext().get((kotlin.d.f.c)cb.ajws));
        localObject = (kotlin.d.d)this;
        this.label = 1;
        localObject = paramObject.e(true, (kotlin.d.d)localObject);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(340327);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        localObject = (b.a)paramObject;
        paramObject = f.f(this.EMY).getCoroutineContext();
        localObject = (kotlin.g.a.m)new kotlin.d.b.a.k((b.a)localObject, this.EMY)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(340250);
            paramAnonymousObject = (kotlin.d.d)new 1(this.Awo, this.EMY, this.ENb, this.akhG, this.ENa, this.akhH, paramAnonymousd);
            AppMethodBeat.o(340250);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            boolean bool3 = true;
            AppMethodBeat.i(340244);
            Object localObject = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(340244);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            Log.i("Finder.LiveEntranceFragmentViewCallback", "#loadDataWithCgi cgi end. errType=" + this.Awo.errType + " errCode=" + this.Awo.errCode);
            boolean bool1;
            if ((this.Awo.errType == 0) && (this.Awo.errCode == 0))
            {
              f.b(this.EMY, (bqr)this.Awo.ott);
              paramAnonymousObject = i.akhB;
              paramAnonymousObject = f.a(this.EMY);
              if ((paramAnonymousObject != null) && (paramAnonymousObject.akhs == true))
              {
                bool1 = true;
                i.PY(bool1);
                paramAnonymousObject = com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.a.ENf;
                paramAnonymousObject = f.a(this.EMY);
                if ((paramAnonymousObject == null) || (paramAnonymousObject.akhs != true)) {
                  break label338;
                }
                bool1 = true;
                label195:
                com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.a.PZ(bool1);
                paramAnonymousObject = a.EMv;
                paramAnonymousObject = f.a(this.EMY);
                if (paramAnonymousObject != null) {
                  break label344;
                }
                i = 0;
                label218:
                a.pk(i * 60L * 1000L);
                paramAnonymousObject = this.EMY;
                localObject = f.a(this.EMY);
                long l = this.ENb;
                if ((this.akhG != null) || (!this.ENa)) {
                  break label352;
                }
                bool1 = true;
                label268:
                f.a(paramAnonymousObject, (bqr)localObject, l, bool1);
              }
            }
            for (int i = 1;; i = 0)
            {
              if (this.akhG != null)
              {
                this.akhG.invoke(this.Awo);
                paramAnonymousObject = this.akhH;
                if (paramAnonymousObject != null) {
                  paramAnonymousObject.invoke(this.Awo);
                }
                paramAnonymousObject = ah.aiuX;
                AppMethodBeat.o(340244);
                return paramAnonymousObject;
                bool1 = false;
                break;
                label338:
                bool1 = false;
                break label195;
                label344:
                i = paramAnonymousObject.ZKX;
                break label218;
                label352:
                bool1 = false;
                break label268;
              }
              label465:
              boolean bool2;
              if (i != 0)
              {
                kotlinx.coroutines.j.a(f.f(this.EMY), null, null, (kotlin.g.a.m)new kotlin.d.b.a.k(this.EMY, null)
                {
                  int label;
                  
                  public final kotlin.d.d<ah> create(Object paramAnonymous2Object, kotlin.d.d<?> paramAnonymous2d)
                  {
                    AppMethodBeat.i(340270);
                    paramAnonymous2Object = (kotlin.d.d)new 1(this.EMY, paramAnonymous2d);
                    AppMethodBeat.o(340270);
                    return paramAnonymous2Object;
                  }
                  
                  public final Object invokeSuspend(Object paramAnonymous2Object)
                  {
                    AppMethodBeat.i(340263);
                    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
                    switch (this.label)
                    {
                    default: 
                      paramAnonymous2Object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                      AppMethodBeat.o(340263);
                      throw paramAnonymous2Object;
                    case 0: 
                      ResultKt.throwOnFailure(paramAnonymous2Object);
                      paramAnonymous2Object = (kotlin.d.d)this;
                      this.label = 1;
                      if (bb.e(50L, paramAnonymous2Object) == locala)
                      {
                        AppMethodBeat.o(340263);
                        return locala;
                      }
                      break;
                    case 1: 
                      ResultKt.throwOnFailure(paramAnonymous2Object);
                    }
                    paramAnonymous2Object = f.g(this.EMY);
                    if (paramAnonymous2Object != null) {
                      paramAnonymous2Object.y(f.h(this.EMY));
                    }
                    paramAnonymous2Object = ah.aiuX;
                    AppMethodBeat.o(340263);
                    return paramAnonymous2Object;
                  }
                }, 3);
                paramAnonymousObject = f.a(this.EMY);
                if (paramAnonymousObject != null)
                {
                  int j = paramAnonymousObject.wrl;
                  if (j > 0)
                  {
                    paramAnonymousObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
                    com.tencent.mm.plugin.finder.live.utils.a.aBP().putInt("finder_live_watch_count_down_refresh_interval", j);
                  }
                }
                if (!f.i(this.EMY))
                {
                  f.j(this.EMY);
                  f.k(this.EMY);
                  paramAnonymousObject = f.a(this.EMY);
                  if (paramAnonymousObject != null) {
                    break label674;
                  }
                  bool1 = false;
                  if (!bool1) {
                    break label683;
                  }
                  bool2 = true;
                  label473:
                  Log.i("Finder.LiveEntranceFragmentViewCallback", kotlin.g.b.s.X("#loadDataWithCgi cgi end skipGetAllLiveTabs=", Boolean.valueOf(bool2)));
                  if (!bool1)
                  {
                    paramAnonymousObject = this.EMY.fragment;
                    localObject = com.tencent.mm.ui.component.k.aeZF;
                    paramAnonymousObject = (e)com.tencent.mm.ui.component.k.y(paramAnonymousObject).q(e.class);
                    localObject = com.tencent.mm.ui.component.k.aeZF;
                    localObject = ((as)com.tencent.mm.ui.component.k.d(paramAnonymousObject.getActivity()).q(as.class)).fou();
                    com.tencent.mm.plugin.finder.nearby.report.b localb = com.tencent.mm.plugin.finder.nearby.report.b.EQs;
                    com.tencent.mm.plugin.finder.nearby.report.b.eGF();
                    paramAnonymousObject.EMe = new com.tencent.mm.plugin.finder.nearby.live.square.tab.c((bui)localObject, 9);
                    com.tencent.mm.kernel.h.aZW().a(4210, (com.tencent.mm.am.h)paramAnonymousObject);
                    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramAnonymousObject.EMe, 0);
                  }
                }
              }
              paramAnonymousObject = f.l(this.EMY);
              if (paramAnonymousObject == null)
              {
                kotlin.g.b.s.bIx("refreshLayout");
                paramAnonymousObject = null;
                label617:
                if (i == 0) {
                  break label692;
                }
                bool1 = true;
                label624:
                paramAnonymousObject.Od(bool1);
                localObject = f.l(this.EMY);
                paramAnonymousObject = localObject;
                if (localObject == null)
                {
                  kotlin.g.b.s.bIx("refreshLayout");
                  paramAnonymousObject = null;
                }
                if (i == 0) {
                  break label698;
                }
              }
              label674:
              label683:
              label692:
              label698:
              for (bool1 = bool3;; bool1 = false)
              {
                paramAnonymousObject.Oe(bool1);
                break;
                bool1 = paramAnonymousObject.ZYC;
                break label465;
                bool2 = false;
                break label473;
                break label617;
                bool1 = false;
                break label624;
              }
            }
          }
        };
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 2;
        if (kotlinx.coroutines.l.a(paramObject, (kotlin.g.a.m)localObject, locald) != locala) {
          break label249;
        }
        AppMethodBeat.o(340327);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label249:
      paramObject = ah.aiuX;
      AppMethodBeat.o(340327);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderNavLiveStreamResponse;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<com.tencent.mm.plugin.findersdk.b.c<bqr>>
    {
      a(int paramInt1, int paramInt2, boolean paramBoolean, f paramf, long paramLong)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    i(f paramf, kotlin.d.d<? super i> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(340325);
      paramObject = (kotlin.d.d)new i(this.EMY, paramd);
      AppMethodBeat.o(340325);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(340318);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(340318);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlin.d.d)this;
        this.label = 1;
        if (bb.e(50L, paramObject) == locala)
        {
          AppMethodBeat.o(340318);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = f.g(this.EMY);
      if (paramObject != null) {
        paramObject.y(f.h(this.EMY));
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(340318);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    Object Uf;
    Object VC;
    long Yx;
    int aai;
    int label;
    
    j(f paramf, long paramLong, kotlin.d.d<? super j> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(340337);
      paramObject = (kotlin.d.d)new j(this.EMY, l, paramd);
      AppMethodBeat.o(340337);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(340331);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      long l;
      f localf;
      int i;
      Object localObject1;
      int j;
      Object localObject2;
      int k;
      label340:
      int m;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(340331);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlin.d.d)this;
        this.label = 1;
        if (bb.e(1000L, paramObject) == locala)
        {
          AppMethodBeat.o(340331);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (Iterable)f.d(this.EMY);
        l = l;
        localf = this.EMY;
        i = 0;
        paramObject = paramObject.iterator();
        if (!paramObject.hasNext()) {
          break label618;
        }
        localObject1 = paramObject.next();
        j = i + 1;
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        localObject2 = (cc)localObject1;
        if (((localObject2 instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b)) && (((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b)localObject2).feedObject.getFeedObject().id == l))
        {
          if (i + 2 < f.d(localf).size()) {
            i += 2;
          }
          for (;;)
          {
            f.a(localf, i);
            i = j;
            break;
            if (i + 1 < f.d(localf).size()) {
              i += 1;
            }
          }
        }
        localObject1 = new ah.f();
        if ((localObject2 instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.m)) {
          ((ah.f)localObject1).aqH = ((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.m)localObject2).ENs;
        }
        if ((localObject2 instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.d)) {
          ((ah.f)localObject1).aqH = ((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.d)localObject2).ENs;
        }
        localObject2 = (bna)((ah.f)localObject1).aqH;
        if (localObject2 == null) {
          break label613;
        }
        localObject2 = ((bna)localObject2).YBg;
        if (localObject2 == null) {
          break label613;
        }
        localObject2 = (Iterable)localObject2;
        k = 0;
        localObject2 = ((Iterable)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label613;
        }
        Object localObject3 = ((Iterator)localObject2).next();
        if (k < 0) {
          kotlin.a.p.kkW();
        }
        localObject3 = ((bmz)localObject3).ZIo;
        if ((localObject3 != null) && (((FinderObject)localObject3).id == l)) {
          m = 1;
        }
        break;
      }
      while (m != 0)
      {
        k = i;
        if (i + 1 < f.d(localf).size()) {
          k = i + 1;
        }
        f.a(localf, k);
        this.L$0 = localf;
        this.Uf = paramObject;
        this.VC = localObject1;
        this.Yx = l;
        this.aai = j;
        this.label = 2;
        if (bb.e(500L, this) != locala) {
          break label632;
        }
        AppMethodBeat.o(340331);
        return locala;
        m = 0;
        continue;
        j = this.aai;
        l = this.Yx;
        localObject1 = (ah.f)this.VC;
        localObject2 = (Iterator)this.Uf;
        localf = (f)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject2;
      }
      label613:
      label618:
      label632:
      for (;;)
      {
        localObject2 = f.n(localf);
        i = ((bna)((ah.f)localObject1).aqH).Zpm;
        localObject1 = ((Iterable)((h)localObject2).listeners).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((h.a)((Iterator)localObject1).next()).bz(i, l);
        }
        i = j;
        break;
        k += 1;
        break label340;
        i = j;
        break;
        f.kLt();
        paramObject = ah.aiuX;
        AppMethodBeat.o(340331);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.f
 * JD-Core Version:    0.7.0.1
 */