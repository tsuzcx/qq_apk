package com.tencent.mm.plugin.finder.live.report;

import android.text.TextUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.dg;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ab;
import com.tencent.mm.plugin.finder.model.ah;
import com.tencent.mm.plugin.finder.search.FinderContactSearchUI.a;
import com.tencent.mm.plugin.finder.search.g.b;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/Audience21053Report;", "", "()V", "TAG", "", "mExposureCallback", "com/tencent/mm/plugin/finder/live/report/Audience21053Report$mExposureCallback$1", "Lcom/tencent/mm/plugin/finder/live/report/Audience21053Report$mExposureCallback$1;", "mFeedExposure", "Lcom/tencent/mm/plugin/finder/live/report/HellFeedExposure;", "mFeedSingleExposure", "Lcom/tencent/mm/plugin/finder/live/report/HellFeedSingleExposure;", "getSessionBuffer", "feedId", "", "scene", "report", "", "listView", "Landroid/widget/AbsListView;", "adapter", "Landroid/widget/BaseAdapter;", "visibleState", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$VisiableState;", "firstVisibleItem", "", "visibleItemCount", "actionType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "commentscene", "event", "Lcom/tencent/mm/plugin/finder/live/report/HELL_SCROLL_EVENT;", "headerShow", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "reportOnClick", "clickData", "Lcom/tencent/mm/plugin/finder/live/report/HellVisitorClickData;", "reportOnClickOnShare", "enterData", "Lcom/tencent/mm/plugin/finder/live/report/HellVisitorEnterData;", "reportOnEnter", "reportOnExposeWhenNearby", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "clickSubTabContextId", "chnlExtra", "reportOnExposure", "liveFeed", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed;", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveItem;", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveMixSearchItem;", "index", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "plugin-finder_release"})
public final class a
{
  final String TAG;
  private final a yAb;
  private final d yAc;
  final f yAd;
  
  public a()
  {
    AppMethodBeat.i(281897);
    this.TAG = "HABBYGE-MALI.Audience21053Report";
    this.yAb = new a(this);
    this.yAc = new d((r)this.yAb);
    this.yAd = new f((r)this.yAb);
    AppMethodBeat.o(281897);
  }
  
  static String T(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(281896);
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (localObject1 != null)
    {
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      if (localObject1 == null) {}
    }
    for (Object localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).sessionBuffer;; localObject2 = null)
    {
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
        localObject1 = com.tencent.mm.plugin.finder.report.n.N(paramLong1, (int)paramLong2);
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = m.yCt;
          localObject2 = m.dDr();
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = m.yCt;
            localObject1 = m.getSessionBuffer();
          }
        }
      }
      if (localObject1 != null)
      {
        localObject2 = kotlin.n.n.l((String)localObject1, ",", ";", false);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      AppMethodBeat.o(281896);
      return localObject1;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, s.t paramt, String paramString, c paramc)
  {
    f localf = null;
    Object localObject2 = null;
    RecyclerView.LayoutManager localLayoutManager = null;
    d locald = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    AppMethodBeat.i(281891);
    kotlin.g.b.p.k(paramt, "actionType");
    kotlin.g.b.p.k(paramString, "commentscene");
    kotlin.g.b.p.k(paramc, "event");
    if ((kotlin.g.b.p.h(paramString, "94")) || (kotlin.g.b.p.h(paramString, "80")) || (kotlin.g.b.p.h(paramString, s.l.yFX.scene)) || (kotlin.g.b.p.h(paramString, s.l.yFT.scene)) || (kotlin.g.b.p.h(paramString, "26")) || (kotlin.g.b.p.h(paramString, s.l.yFS.scene)) || (kotlin.g.b.p.h(paramString, "23")) || (kotlin.g.b.p.h(paramString, "15")))
    {
      locald = this.yAc;
      kotlin.g.b.p.k(paramc, "event");
      kotlin.g.b.p.k(paramt, "actionType");
      kotlin.g.b.p.k(paramString, "commentscene");
      switch (e.$EnumSwitchMapping$0[paramc.ordinal()])
      {
      default: 
        Log.e(locald.TAG, "run, else-case, event=".concat(String.valueOf(paramc)));
        AppMethodBeat.o(281891);
        return;
      case 1: 
        if (paramRecyclerView != null)
        {
          localLayoutManager = paramRecyclerView.getLayoutManager();
          paramc = localLayoutManager;
          if (!(localLayoutManager instanceof StaggeredGridLayoutManager)) {
            paramc = null;
          }
          paramc = (StaggeredGridLayoutManager)paramc;
          if (paramc == null)
          {
            AppMethodBeat.o(281891);
            return;
          }
          locald.yAq = new WeakReference(paramc);
          if (kotlin.g.b.p.h(paramString, s.l.yFS.scene))
          {
            paramRecyclerView = paramRecyclerView.getAdapter();
            if ((paramRecyclerView instanceof g.b)) {
              break label2234;
            }
            paramRecyclerView = (RecyclerView)localObject1;
          }
        }
        break;
      }
    }
    label689:
    label951:
    label2234:
    for (;;)
    {
      paramRecyclerView = (g.b)paramRecyclerView;
      if (paramRecyclerView == null)
      {
        AppMethodBeat.o(281891);
        return;
      }
      locald.yAs = new WeakReference(paramRecyclerView);
      locald.a(paramRecyclerView, paramc, paramt, paramString);
      AppMethodBeat.o(281891);
      return;
      if (kotlin.g.b.p.h(paramString, s.l.yFT.scene))
      {
        paramRecyclerView = paramRecyclerView.getAdapter();
        if ((paramRecyclerView instanceof WxRecyclerAdapter)) {
          break label2231;
        }
        paramRecyclerView = localf;
      }
      for (;;)
      {
        paramRecyclerView = (WxRecyclerAdapter)paramRecyclerView;
        if (paramRecyclerView == null)
        {
          AppMethodBeat.o(281891);
          return;
        }
        locald.yAt = new WeakReference(paramRecyclerView);
        locald.a(paramRecyclerView, paramc, paramt, paramString);
        AppMethodBeat.o(281891);
        return;
        paramRecyclerView = paramRecyclerView.getAdapter();
        if (!(paramRecyclerView instanceof WxRecyclerAdapter)) {
          paramRecyclerView = localObject2;
        }
        for (;;)
        {
          paramRecyclerView = (WxRecyclerAdapter)paramRecyclerView;
          if (paramRecyclerView == null)
          {
            AppMethodBeat.o(281891);
            return;
          }
          locald.yAr = new WeakReference(paramRecyclerView);
          locald.b(paramRecyclerView, paramc, paramt, paramString);
          AppMethodBeat.o(281891);
          return;
          if (paramRecyclerView != null)
          {
            localObject1 = paramRecyclerView.getAdapter();
            paramc = (c)localObject1;
            if (!(localObject1 instanceof WxRecyclerAdapter)) {
              paramc = null;
            }
            paramc = (WxRecyclerAdapter)paramc;
            if (paramc == null)
            {
              AppMethodBeat.o(281891);
              return;
            }
            locald.yAv = new WeakReference(paramc);
            paramRecyclerView = paramRecyclerView.getLayoutManager();
            if ((paramRecyclerView instanceof LinearLayoutManager)) {
              break label2225;
            }
            paramRecyclerView = localLayoutManager;
          }
          for (;;)
          {
            paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
            if (paramRecyclerView == null)
            {
              AppMethodBeat.o(281891);
              return;
            }
            locald.yAu = new WeakReference(paramRecyclerView);
            locald.a(paramc, paramRecyclerView, paramt, paramString);
            AppMethodBeat.o(281891);
            return;
            if (kotlin.g.b.p.h(paramString, s.l.yFS.scene)) {
              if (paramRecyclerView != null)
              {
                paramc = paramRecyclerView.getAdapter();
                label623:
                localObject1 = paramc;
                if (!(paramc instanceof g.b)) {
                  localObject1 = null;
                }
                paramc = (g.b)localObject1;
                if (paramc != null) {
                  break label2222;
                }
                paramc = locald.yAs;
                if (paramc == null) {
                  break label689;
                }
                paramc = (g.b)paramc.get();
              }
            }
            for (;;)
            {
              if (paramc == null)
              {
                AppMethodBeat.o(281891);
                return;
                paramc = null;
                break label623;
                paramc = null;
                continue;
              }
              if (paramRecyclerView != null)
              {
                paramRecyclerView = paramRecyclerView.getLayoutManager();
                localObject1 = paramRecyclerView;
                if (!(paramRecyclerView instanceof StaggeredGridLayoutManager)) {
                  localObject1 = null;
                }
                localObject1 = (StaggeredGridLayoutManager)localObject1;
                paramRecyclerView = (RecyclerView)localObject1;
                if (localObject1 == null)
                {
                  paramRecyclerView = locald.yAq;
                  if (paramRecyclerView == null) {
                    break label765;
                  }
                }
              }
              label765:
              for (paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.get();; paramRecyclerView = null)
              {
                if (paramRecyclerView != null) {
                  break label770;
                }
                AppMethodBeat.o(281891);
                return;
                paramRecyclerView = null;
                break;
              }
              locald.a(paramc, paramRecyclerView, paramt, paramString);
              AppMethodBeat.o(281891);
              return;
              if (kotlin.g.b.p.h(paramString, s.l.yFT.scene)) {
                if (paramRecyclerView != null)
                {
                  paramc = paramRecyclerView.getAdapter();
                  localObject1 = paramc;
                  if (!(paramc instanceof WxRecyclerAdapter)) {
                    localObject1 = null;
                  }
                  paramc = (WxRecyclerAdapter)localObject1;
                  if (paramc != null) {
                    break label2219;
                  }
                  paramc = locald.yAt;
                  if (paramc == null) {
                    break label875;
                  }
                  paramc = (WxRecyclerAdapter)paramc.get();
                }
              }
              for (;;)
              {
                if (paramc == null)
                {
                  AppMethodBeat.o(281891);
                  return;
                  paramc = null;
                  break label809;
                  label875:
                  paramc = null;
                  continue;
                }
                if (paramRecyclerView != null)
                {
                  paramRecyclerView = paramRecyclerView.getLayoutManager();
                  localObject1 = paramRecyclerView;
                  if (!(paramRecyclerView instanceof StaggeredGridLayoutManager)) {
                    localObject1 = null;
                  }
                  localObject1 = (StaggeredGridLayoutManager)localObject1;
                  paramRecyclerView = (RecyclerView)localObject1;
                  if (localObject1 == null)
                  {
                    paramRecyclerView = locald.yAq;
                    if (paramRecyclerView == null) {
                      break label951;
                    }
                  }
                }
                for (paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.get();; paramRecyclerView = null)
                {
                  if (paramRecyclerView != null) {
                    break label956;
                  }
                  AppMethodBeat.o(281891);
                  return;
                  paramRecyclerView = null;
                  break;
                }
                label956:
                locald.a(paramc, paramRecyclerView, paramt, paramString);
                AppMethodBeat.o(281891);
                return;
                if (paramRecyclerView != null)
                {
                  paramc = paramRecyclerView.getAdapter();
                  label982:
                  localObject1 = paramc;
                  if (!(paramc instanceof WxRecyclerAdapter)) {
                    localObject1 = null;
                  }
                  paramc = (WxRecyclerAdapter)localObject1;
                  if (paramc != null) {
                    break label2216;
                  }
                  paramc = locald.yAr;
                  if (paramc == null) {
                    break label1048;
                  }
                  paramc = (WxRecyclerAdapter)paramc.get();
                }
                for (;;)
                {
                  if (paramc == null)
                  {
                    AppMethodBeat.o(281891);
                    return;
                    paramc = null;
                    break label982;
                    paramc = null;
                    continue;
                  }
                  if (paramRecyclerView != null)
                  {
                    paramRecyclerView = paramRecyclerView.getLayoutManager();
                    localObject1 = paramRecyclerView;
                    if (!(paramRecyclerView instanceof StaggeredGridLayoutManager)) {
                      localObject1 = null;
                    }
                    localObject1 = (StaggeredGridLayoutManager)localObject1;
                    paramRecyclerView = (RecyclerView)localObject1;
                    if (localObject1 == null)
                    {
                      paramRecyclerView = locald.yAq;
                      if (paramRecyclerView == null) {
                        break label1124;
                      }
                    }
                  }
                  label1124:
                  for (paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.get();; paramRecyclerView = null)
                  {
                    if (paramRecyclerView != null) {
                      break label1129;
                    }
                    AppMethodBeat.o(281891);
                    return;
                    paramRecyclerView = null;
                    break;
                  }
                  label1129:
                  locald.b(paramc, paramRecyclerView, paramt, paramString);
                  AppMethodBeat.o(281891);
                  return;
                  locald.dDa();
                  if (!kotlin.g.b.p.h(paramString, s.l.yFS.scene)) {
                    break;
                  }
                  locald.dDb();
                  AppMethodBeat.o(281891);
                  return;
                  locald.yAy.clear();
                  AppMethodBeat.o(281891);
                  return;
                  if ((kotlin.g.b.p.h(paramString, "61")) || (kotlin.g.b.p.h(paramString, "1")) || (kotlin.g.b.p.h(paramString, "39")) || (kotlin.g.b.p.h(paramString, "40")) || (kotlin.g.b.p.h(paramString, "21")) || (kotlin.g.b.p.h(paramString, "2")) || (kotlin.g.b.p.h(paramString, "25")) || (kotlin.g.b.p.h(paramString, "20")) || (kotlin.g.b.p.h(paramString, "18")) || (kotlin.g.b.p.h(paramString, s.l.yFR.scene)) || (kotlin.g.b.p.h(paramString, "12")) || (kotlin.g.b.p.h(paramString, s.l.yFP.scene)) || (kotlin.g.b.p.h(paramString, s.l.yFW.scene)) || (kotlin.g.b.p.h(paramString, "27")) || (kotlin.g.b.p.h(paramString, "9")) || (kotlin.g.b.p.h(paramString, "6")) || (kotlin.g.b.p.h(paramString, "16")))
                  {
                    localf = this.yAd;
                    kotlin.g.b.p.k(paramc, "event");
                    kotlin.g.b.p.k(paramt, "actionType");
                    kotlin.g.b.p.k(paramString, "commentscene");
                    switch (g.jLJ[paramc.ordinal()])
                    {
                    default: 
                      if ((paramc == c.yAi) || (paramc == c.yAk)) {
                        if (kotlin.g.b.p.h(paramString, s.l.yFR.scene)) {
                          if (paramRecyclerView != null)
                          {
                            paramc = paramRecyclerView.getAdapter();
                            localObject1 = paramc;
                            if (!(paramc instanceof FinderContactSearchUI.a)) {
                              localObject1 = null;
                            }
                            paramc = (FinderContactSearchUI.a)localObject1;
                            if (paramc != null) {
                              break label2204;
                            }
                            paramc = localf.yAA;
                            if (paramc == null) {
                              break label1845;
                            }
                            paramc = (FinderContactSearchUI.a)paramc.get();
                            if (paramc != null) {
                              break label1851;
                            }
                            AppMethodBeat.o(281891);
                          }
                        }
                      }
                      break;
                    case 1: 
                      label1512:
                      if (paramRecyclerView == null)
                      {
                        AppMethodBeat.o(281891);
                        return;
                      }
                      localObject1 = paramRecyclerView.getLayoutManager();
                      paramc = (c)localObject1;
                      if (!(localObject1 instanceof LinearLayoutManager)) {
                        paramc = null;
                      }
                      paramc = (LinearLayoutManager)paramc;
                      if (paramc == null)
                      {
                        AppMethodBeat.o(281891);
                        return;
                      }
                      localf.yAq = new WeakReference(paramc);
                      if (kotlin.g.b.p.h(paramString, s.l.yFR.scene))
                      {
                        paramRecyclerView = paramRecyclerView.getAdapter();
                        if ((paramRecyclerView instanceof FinderContactSearchUI.a)) {
                          break label2213;
                        }
                        paramRecyclerView = locald;
                      }
                      break;
                    }
                  }
                  for (;;)
                  {
                    paramRecyclerView = (FinderContactSearchUI.a)paramRecyclerView;
                    if (paramRecyclerView == null)
                    {
                      AppMethodBeat.o(281891);
                      return;
                    }
                    localf.yAA = new WeakReference(paramRecyclerView);
                    localf.a(paramRecyclerView, paramc, paramt, paramString);
                    AppMethodBeat.o(281891);
                    return;
                    paramRecyclerView = paramRecyclerView.getAdapter();
                    if (!(paramRecyclerView instanceof WxRecyclerAdapter)) {
                      paramRecyclerView = localObject3;
                    }
                    for (;;)
                    {
                      paramRecyclerView = (WxRecyclerAdapter)paramRecyclerView;
                      if (paramRecyclerView == null)
                      {
                        AppMethodBeat.o(281891);
                        return;
                      }
                      localf.yAr = new WeakReference(paramRecyclerView);
                      localf.b(paramRecyclerView, paramc, paramt, paramString);
                      AppMethodBeat.o(281891);
                      return;
                      if (paramRecyclerView == null)
                      {
                        AppMethodBeat.o(281891);
                        return;
                      }
                      localObject1 = paramRecyclerView.getAdapter();
                      paramc = (c)localObject1;
                      if (!(localObject1 instanceof WxRecyclerAdapter)) {
                        paramc = null;
                      }
                      paramc = (WxRecyclerAdapter)paramc;
                      if (paramc == null)
                      {
                        AppMethodBeat.o(281891);
                        return;
                      }
                      localf.yAr = new WeakReference(paramc);
                      paramRecyclerView = paramRecyclerView.getLayoutManager();
                      if (!(paramRecyclerView instanceof LinearLayoutManager)) {
                        paramRecyclerView = localObject4;
                      }
                      for (;;)
                      {
                        paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
                        if (paramRecyclerView == null)
                        {
                          AppMethodBeat.o(281891);
                          return;
                        }
                        localf.yAq = new WeakReference(paramRecyclerView);
                        localf.a(paramc, paramRecyclerView, paramt, paramString);
                        AppMethodBeat.o(281891);
                        return;
                        paramc = null;
                        break;
                        paramc = null;
                        break label1512;
                        label1851:
                        if (paramRecyclerView != null)
                        {
                          paramRecyclerView = paramRecyclerView.getLayoutManager();
                          localObject1 = paramRecyclerView;
                          if (!(paramRecyclerView instanceof LinearLayoutManager)) {
                            localObject1 = null;
                          }
                          localObject1 = (LinearLayoutManager)localObject1;
                          paramRecyclerView = (RecyclerView)localObject1;
                          if (localObject1 == null)
                          {
                            paramRecyclerView = localf.yAq;
                            if (paramRecyclerView == null) {
                              break label1921;
                            }
                          }
                        }
                        for (paramRecyclerView = (LinearLayoutManager)paramRecyclerView.get();; paramRecyclerView = null)
                        {
                          if (paramRecyclerView != null) {
                            break label1926;
                          }
                          AppMethodBeat.o(281891);
                          return;
                          paramRecyclerView = null;
                          break;
                        }
                        localf.a(paramc, paramRecyclerView, paramt, paramString);
                        AppMethodBeat.o(281891);
                        return;
                        if (paramRecyclerView != null)
                        {
                          paramc = paramRecyclerView.getAdapter();
                          localObject1 = paramc;
                          if (!(paramc instanceof WxRecyclerAdapter)) {
                            localObject1 = null;
                          }
                          paramc = (WxRecyclerAdapter)localObject1;
                          if (paramc != null) {
                            break label2201;
                          }
                          paramc = localf.yAr;
                          if (paramc == null) {
                            break label2018;
                          }
                          paramc = (WxRecyclerAdapter)paramc.get();
                        }
                        for (;;)
                        {
                          if (paramc == null)
                          {
                            AppMethodBeat.o(281891);
                            return;
                            paramc = null;
                            break;
                            label2018:
                            paramc = null;
                            continue;
                          }
                          if (paramRecyclerView != null)
                          {
                            paramRecyclerView = paramRecyclerView.getLayoutManager();
                            localObject1 = paramRecyclerView;
                            if (!(paramRecyclerView instanceof LinearLayoutManager)) {
                              localObject1 = null;
                            }
                            localObject1 = (LinearLayoutManager)localObject1;
                            paramRecyclerView = (RecyclerView)localObject1;
                            if (localObject1 == null)
                            {
                              paramRecyclerView = localf.yAq;
                              if (paramRecyclerView == null) {
                                break label2094;
                              }
                            }
                          }
                          for (paramRecyclerView = (LinearLayoutManager)paramRecyclerView.get();; paramRecyclerView = null)
                          {
                            if (paramRecyclerView != null) {
                              break label2099;
                            }
                            AppMethodBeat.o(281891);
                            return;
                            paramRecyclerView = null;
                            break;
                          }
                          localf.b(paramc, paramRecyclerView, paramt, paramString);
                          AppMethodBeat.o(281891);
                          return;
                          if (paramc == c.yAj)
                          {
                            if (kotlin.g.b.p.h(paramString, "12"))
                            {
                              localf.dDe();
                              AppMethodBeat.o(281891);
                              return;
                            }
                            if (kotlin.g.b.p.h(paramString, s.l.yFR.scene))
                            {
                              localf.dDb();
                              AppMethodBeat.o(281891);
                              return;
                            }
                            localf.dDa();
                            AppMethodBeat.o(281891);
                            return;
                          }
                          if (paramc == c.yAo) {
                            localf.yAy.clear();
                          }
                          AppMethodBeat.o(281891);
                          return;
                        }
                        break label1512;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(281892);
    kotlin.g.b.p.k(paramh, "liveFeed");
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkn;
    dg localdg;
    switch (((String)localObject).hashCode())
    {
    default: 
      localdg = new dg();
      localObject = k.yBj;
      k.a(localdg, paramh.userName);
      localdg.pl(paramh.feedId);
      localdg.iq(paramh.liveId);
      localdg.pt(com.tencent.mm.plugin.expt.hellhound.core.b.Fw(paramh.liveId));
      localdg.is(paramh.yAO.fwf);
      localdg.pn(paramh.yAP);
      localdg.it(paramh.pos);
      localdg.iu(0L);
      localdg.iv(paramh.yAT);
      if (localdg.agZ() != null)
      {
        localObject = localdg.agZ();
        kotlin.g.b.p.j(localObject, "struct.sessionID");
        if (kotlin.n.n.M((String)localObject, "101", false)) {
          localdg.iv(s.ba.yKF.type);
        }
      }
      else
      {
        label220:
        localdg.po(paramh.userName);
        localdg.pp(com.tencent.mm.plugin.expt.hellhound.core.b.dcv());
        localdg.iw(paramh.onlineNum);
        localdg.pq(com.tencent.mm.plugin.expt.hellhound.core.b.dct());
        localdg.px(paramh.yAU);
        localdg.pw(kotlin.n.n.l(paramh.yAV, ",", ";", false));
        if (!kotlin.n.n.M(paramh.yAP, "temp_", false)) {
          break label640;
        }
        if (!kotlin.g.b.p.h(paramh.yAP, "temp_2")) {
          break label627;
        }
        localObject = k.yBj;
        localdg.pr(k.dDm().yDi);
        label331:
        if (!kotlin.g.b.p.h(localdg.agV(), "61"))
        {
          localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.wov;
          if (!kotlin.g.b.p.h(b.a.deK(), "123")) {
            break;
          }
        }
        else
        {
          if (!TextUtils.isEmpty((CharSequence)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkt)) {
            break label678;
          }
          localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
          kotlin.g.b.p.j(localObject, "HellSessionMonitor.getInstance()");
        }
      }
      break;
    }
    label640:
    label678:
    for (localObject = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject).deL();; localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkt)
    {
      localdg.pv((String)localObject);
      if (!kotlin.g.b.p.h(localdg.agV(), "18")) {
        break label686;
      }
      Log.e(this.TAG, "filter, ConstantsFinder.FinderGetCommentScene.MMFinder_GetComment_Scene_Friend_Rec_Tab");
      AppMethodBeat.o(281892);
      return;
      if (!((String)localObject).equals("FinderFriendTabFragment")) {
        break;
      }
      while ((kotlin.g.b.p.h(paramh.yAP, s.l.yFP.scene)) || (kotlin.g.b.p.h(paramh.yAP, "17")))
      {
        AppMethodBeat.o(281892);
        return;
        if (!((String)localObject).equals("FinderMachineTabFragment")) {
          break;
        }
        while ((kotlin.g.b.p.h(paramh.yAP, s.l.yFP.scene)) || (kotlin.g.b.p.h(paramh.yAP, "17")) || (kotlin.g.b.p.h(paramh.yAP, s.l.yFW.scene)) || (kotlin.g.b.p.h(paramh.yAP, "18")))
        {
          AppMethodBeat.o(281892);
          return;
          if (!((String)localObject).equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment")) {
            break;
          }
        }
        if (!((String)localObject).equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment")) {
          break;
        }
      }
      localObject = localdg.agZ();
      kotlin.g.b.p.j(localObject, "struct.sessionID");
      if (!kotlin.n.n.M((String)localObject, "102", false)) {
        break label220;
      }
      localdg.iv(s.ba.yKG.type);
      break label220;
      label627:
      localdg.pr(paramh.yAP);
      break label331;
      long l = paramh.yAN;
      localObject = localdg.agV();
      kotlin.g.b.p.j(localObject, "struct.commentScene");
      localdg.pr(T(l, Long.parseLong((String)localObject)));
      break label331;
    }
    label686:
    localdg.bpa();
    Log.i(this.TAG, "report21053OnExposure, struct:\nuserName=" + localdg.getUserName() + '\n' + "nickName=" + paramh.nickName + '\n' + "feedID=" + localdg.agT() + '\n' + "liveIDStr=" + localdg.aiN() + '\n' + "actionTS=" + localdg.ahg() + '\n' + "action=" + localdg.ahh() + '\n' + "commentScene=" + localdg.agV() + '\n' + "index=" + localdg.aiJ() + '\n' + "enterStatus=" + localdg.ahf() + '\n' + "shareType=" + localdg.aiK() + '\n' + "shareUserName=" + localdg.aiL() + '\n' + "contextId=" + localdg.agX() + '\n' + "onlineNum=" + localdg.aiM() + '\n' + "clickTabContextId=" + localdg.agY() + '\n' + "clickSubTabContextId=" + localdg.aiS() + '\n' + "chnl_extra=" + localdg.aiR() + '\n' + "isPrivate=" + localdg.agW() + '\n' + "sessionBuffer=" + localdg.getSessionBuffer() + '\n' + "snsFeedId=" + localdg.aiO() + '\n' + "enterSessionId=" + localdg.aiP() + '\n' + "enterIconType=" + localdg.ahj() + '\n' + "snsSessionID=" + localdg.aiQ() + '\n' + "sessionID=" + localdg.agZ());
    AppMethodBeat.o(281892);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(281894);
    kotlin.g.b.p.k(paramp, "clickData");
    dg localdg = new dg();
    k localk = k.yBj;
    k.a(localdg, paramp.userName);
    localdg.pl(com.tencent.mm.plugin.expt.hellhound.core.b.Fw(paramp.feedId));
    localdg.iq(paramp.liveId);
    localdg.pt(com.tencent.mm.plugin.expt.hellhound.core.b.Fw(paramp.liveId));
    localdg.is(paramp.yAO.fwf);
    localdg.pn(paramp.yAP);
    localdg.it(paramp.yCx);
    localdg.iu(0L);
    localdg.iv(paramp.yCz);
    localdg.po(paramp.kit);
    localdg.pu(paramp.yCA);
    localdg.pp(com.tencent.mm.plugin.expt.hellhound.core.b.dcv());
    localdg.iw(paramp.yCy);
    localdg.pq(com.tencent.mm.plugin.expt.hellhound.core.b.dct());
    localdg.px(paramp.yAU);
    localdg.pw(kotlin.n.n.l(paramp.yAV, ",", ";", false));
    if (kotlin.n.n.M(paramp.yAP, "temp_", false)) {
      if (kotlin.g.b.p.h(localdg.agV(), "temp_2"))
      {
        paramp = k.yBj;
        localdg.pr(k.dDm().yDi);
        if (!kotlin.g.b.p.h(localdg.agV(), "61"))
        {
          paramp = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.wov;
          if (!kotlin.g.b.p.h(b.a.deK(), "123")) {}
        }
        else
        {
          if (!TextUtils.isEmpty((CharSequence)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkt)) {
            break label795;
          }
          paramp = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
          kotlin.g.b.p.j(paramp, "HellSessionMonitor.getInstance()");
        }
      }
    }
    label795:
    for (paramp = paramp.deL();; paramp = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkt)
    {
      localdg.pv(paramp);
      localdg.bpa();
      Log.i(this.TAG, "report21053OnClick, struct=\nfeedId=" + localdg.agT() + '\n' + "liveId=" + localdg.aiN() + '\n' + "userName=" + localdg.getUserName() + '\n' + "isPrivate=" + localdg.agW() + '\n' + "sessionID=" + localdg.agZ() + '\n' + "actionTS=" + localdg.ahg() + '\n' + "action=" + localdg.ahh() + '\n' + "commentScene=" + localdg.agV() + '\n' + "index=" + localdg.aiJ() + '\n' + "enterStatus=" + localdg.ahf() + '\n' + "contextId=" + localdg.agX() + '\n' + "onlineNum=" + localdg.aiM() + '\n' + "clickTabContextId=" + localdg.agY() + '\n' + "clickSubTabContextId=" + localdg.aiS() + '\n' + "chnl_extra=" + localdg.aiR() + '\n' + "sessionBuffer=" + localdg.getSessionBuffer() + '\n' + "enterSessionId=" + localdg.aiP() + '\n' + "enterIconType=" + localdg.ahj() + '\n' + "snsSessionID=" + localdg.aiQ() + '\n' + "shareType=" + localdg.aiK() + '\n' + "shareUserName=" + localdg.aiL() + '\n' + "snsFeedId=" + localdg.aiO());
      AppMethodBeat.o(281894);
      return;
      localdg.pr(paramp.yAP);
      break;
      long l = paramp.feedId;
      paramp = localdg.agV();
      kotlin.g.b.p.j(paramp, "struct.commentScene");
      localdg.pr(T(l, Long.parseLong(paramp)));
      break;
    }
  }
  
  public final void a(q paramq)
  {
    AppMethodBeat.i(281895);
    kotlin.g.b.p.k(paramq, "enterData");
    dg localdg = new dg();
    Object localObject = k.yBj;
    k.a(localdg, paramq.userName);
    localdg.pl(com.tencent.mm.plugin.expt.hellhound.core.b.Fw(paramq.feedId));
    localdg.iq(paramq.liveId);
    localdg.pt(com.tencent.mm.plugin.expt.hellhound.core.b.Fw(paramq.liveId));
    localdg.is(paramq.yAO.fwf);
    localdg.pn(paramq.yAP);
    localdg.it(paramq.yCx);
    localdg.iu(paramq.yCC);
    localdg.iv(paramq.yCz);
    localdg.po(paramq.kit);
    localdg.pu(paramq.yCA);
    localdg.pp(com.tencent.mm.plugin.expt.hellhound.core.b.dcv());
    localdg.iw(paramq.yCy);
    localdg.pq(com.tencent.mm.plugin.expt.hellhound.core.b.dct());
    localdg.px(paramq.yAU);
    if (kotlin.n.n.M(paramq.yAP, "temp_", false)) {
      if (kotlin.g.b.p.h(localdg.agV(), "temp_2"))
      {
        localObject = k.yBj;
        localdg.pr(k.dDm().yDi);
        if (TextUtils.isEmpty((CharSequence)localdg.getSessionBuffer())) {
          localdg.pr(paramq.yCE);
        }
        localdg.iy(paramq.enterTime);
        localdg.pw(kotlin.n.n.l(paramq.yAV, ",", ";", false));
        localObject = k.yBj;
        localdg.iz(s.at(localdg.agV(), paramq.yCD.type));
        if (!kotlin.g.b.p.h(localdg.agV(), "61"))
        {
          paramq = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.wov;
          if (!kotlin.g.b.p.h(b.a.deK(), "123")) {}
        }
        else
        {
          if (!TextUtils.isEmpty((CharSequence)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkt)) {
            break label844;
          }
          paramq = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
          kotlin.g.b.p.j(paramq, "HellSessionMonitor.getInstance()");
        }
      }
    }
    label844:
    for (paramq = paramq.deL();; paramq = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkt)
    {
      localdg.pv(paramq);
      localdg.bpa();
      Log.i(this.TAG, "report21053OnEnter, struct=\nfeedId=" + localdg.agT() + '\n' + "liveId=" + localdg.aiN() + '\n' + "userName=" + localdg.getUserName() + '\n' + "isPrivate=" + localdg.agW() + '\n' + "sessionID=" + localdg.agZ() + '\n' + "actionTS=" + localdg.ahg() + '\n' + "action=" + localdg.ahh() + '\n' + "commentScene=" + localdg.agV() + '\n' + "index=" + localdg.aiJ() + '\n' + "enterStatus=" + localdg.ahf() + '\n' + "contextId=" + localdg.agX() + '\n' + "onlineNum=" + localdg.aiM() + '\n' + "clickTabContextId=" + localdg.agY() + '\n' + "clickSubTabContextId=" + localdg.aiS() + '\n' + "sessionBuffer=" + localdg.getSessionBuffer() + '\n' + "shareType=" + localdg.aiK() + '\n' + "shareUserName=" + localdg.aiL() + '\n' + "enterSessionId=" + localdg.aiP() + '\n' + "enterIconType=" + localdg.ahj() + '\n' + "snsSessionID=" + localdg.aiQ() + '\n' + "snsFeedId=" + localdg.aiO());
      AppMethodBeat.o(281895);
      return;
      localdg.pr(paramq.yAP);
      break;
      long l = paramq.feedId;
      localObject = localdg.agV();
      kotlin.g.b.p.j(localObject, "struct.commentScene");
      localdg.pr(T(l, Long.parseLong((String)localObject)));
      break;
    }
  }
  
  public final void a(s.t paramt, int paramInt, String paramString, FeedData paramFeedData)
  {
    AppMethodBeat.i(281893);
    kotlin.g.b.p.k(paramt, "actionType");
    kotlin.g.b.p.k(paramString, "commentscene");
    if (paramFeedData == null)
    {
      AppMethodBeat.o(281893);
      return;
    }
    dg localdg = new dg();
    k localk = k.yBj;
    k.a(localdg, paramFeedData.getUserName());
    localdg.pl(com.tencent.mm.plugin.expt.hellhound.core.b.Fw(paramFeedData.getFeedId()));
    localdg.iq(paramFeedData.getLiveId());
    localdg.pt(com.tencent.mm.plugin.expt.hellhound.core.b.Fw(paramFeedData.getLiveId()));
    localdg.is(paramt.fwf);
    localdg.pn(paramString);
    localdg.it(paramInt);
    localdg.iu(0L);
    localdg.iv(0L);
    localdg.po(paramFeedData.getUserName());
    localdg.pp(com.tencent.mm.plugin.expt.hellhound.core.b.dcv());
    localdg.iw(paramFeedData.getOnlineNum());
    localdg.pq(com.tencent.mm.plugin.expt.hellhound.core.b.dct());
    if (kotlin.g.b.p.h(localdg.agV(), "temp_2"))
    {
      paramt = k.yBj;
      localdg.pr(k.dDm().yDi);
      if (!kotlin.g.b.p.h(localdg.agV(), "61"))
      {
        paramt = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.wov;
        if (!kotlin.g.b.p.h(b.a.deK(), "123")) {}
      }
      else
      {
        if (!TextUtils.isEmpty((CharSequence)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkt)) {
          break label711;
        }
        paramt = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
        kotlin.g.b.p.j(paramt, "HellSessionMonitor.getInstance()");
      }
    }
    label711:
    for (paramt = paramt.deL();; paramt = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkt)
    {
      localdg.pv(paramt);
      localdg.bpa();
      Log.i(this.TAG, "report21053OnExposure, struct-2:\nuserName=" + localdg.getUserName() + '\n' + "nickName=" + paramFeedData.getNickName() + '\n' + "feedID=" + localdg.agT() + '\n' + "liveIDStr=" + localdg.aiN() + '\n' + "actionTS=" + localdg.ahg() + '\n' + "action=" + localdg.ahh() + '\n' + "commentScene=" + localdg.agV() + '\n' + "index=" + localdg.aiJ() + '\n' + "enterStatus=" + localdg.ahf() + '\n' + "shareType=" + localdg.aiK() + '\n' + "shareUserName=" + localdg.aiL() + '\n' + "contextId=" + localdg.agX() + '\n' + "onlineNum=" + localdg.aiM() + '\n' + "clickTabContextId=" + localdg.agY() + '\n' + "isPrivate=" + localdg.agW() + '\n' + "sessionBuffer=" + localdg.getSessionBuffer() + '\n' + "snsFeedId=" + localdg.aiO() + '\n' + "enterSessionId=" + localdg.aiP() + '\n' + "enterIconType=" + localdg.ahj() + '\n' + "snsSessionID=" + localdg.aiQ() + '\n' + "sessionID=" + localdg.agZ());
      AppMethodBeat.o(281893);
      return;
      localdg.pr(kotlin.n.n.l(paramFeedData.getSessionBuffer(), ",", ";", false));
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/report/Audience21053Report$mExposureCallback$1", "Lcom/tencent/mm/plugin/finder/live/report/IFeedEventCallback;", "onAppear", "", "liveFeed", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed;", "fromSingleFlow", "", "feed", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveItem;", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveMixSearchItem;", "onDisappear", "plugin-finder_release"})
  public static final class a
    implements r
  {
    public final void a(h paramh, boolean paramBoolean)
    {
      int j = 1;
      AppMethodBeat.i(273982);
      kotlin.g.b.p.k(paramh, "liveFeed");
      Object localObject;
      if ((paramh.xrd instanceof BaseFinderFeed))
      {
        localObject = aj.AGc;
        if (!aj.w((BaseFinderFeed)paramh.xrd)) {}
      }
      for (int i = 1;; i = 0)
      {
        if ((paramh.xrd instanceof ab)) {
          paramh.a(s.t.yGY);
        }
        if ((paramh.yAS) || (i != 0) || (paramh.yAQ == h.b.yAY) || (paramh.yAR))
        {
          i = 1;
          if ((i != 0) || (!paramBoolean) || (!(paramh.xrd instanceof BaseFinderFeed))) {
            break label173;
          }
          localObject = ((BaseFinderFeed)paramh.xrd).contact;
          if ((localObject == null) || (((com.tencent.mm.plugin.finder.api.i)localObject).field_liveStatus != 1)) {
            break label168;
          }
          i = j;
          label138:
          paramh.a(s.t.yGO);
        }
        label168:
        label173:
        for (;;)
        {
          if (i != 0) {
            this.yAe.a(paramh);
          }
          AppMethodBeat.o(273982);
          return;
          i = 0;
          break;
          i = 0;
          break label138;
        }
      }
    }
    
    public final void a(i parami)
    {
      AppMethodBeat.i(273984);
      kotlin.g.b.p.k(parami, "feed");
      a locala;
      dg localdg;
      if (parami.yBc)
      {
        locala = this.yAe;
        kotlin.g.b.p.k(parami, "feed");
        localdg = new dg();
        k localk = k.yBj;
        k.a(localdg, parami.yBb.contact.getUsername());
        localdg.pl(parami.feedId);
        localdg.iq(0L);
        localdg.pt("0");
        localdg.is(parami.yAO.fwf);
        localdg.pn(parami.yAP);
        localdg.it(parami.pos);
        localdg.iu(0L);
        localdg.iv(0L);
        localdg.po("");
        localdg.pp(com.tencent.mm.plugin.expt.hellhound.core.b.dcv());
        localdg.iw(-1L);
        localdg.pq(com.tencent.mm.plugin.expt.hellhound.core.b.dct());
        if (!kotlin.n.n.M(parami.yAP, "temp_", false)) {
          break label549;
        }
        if (!kotlin.g.b.p.h(localdg.agV(), "temp_2")) {
          break label537;
        }
        localk = k.yBj;
        localdg.pr(k.dDm().yDi);
      }
      for (;;)
      {
        localdg.bpa();
        Log.i(locala.TAG, "report21053OnExposure, item, struct:\nnickName=" + parami.nickName + '\n' + "userName=" + localdg.getUserName() + '\n' + "feedID=" + localdg.agT() + '\n' + "liveIDStr=" + localdg.aiN() + '\n' + "actionTS=" + localdg.ahg() + '\n' + "action=" + localdg.ahh() + '\n' + "commentScene=" + localdg.agV() + '\n' + "index=" + localdg.aiJ() + '\n' + "enterStatus=" + localdg.ahf() + '\n' + "shareType=" + localdg.aiK() + '\n' + "shareUserName=" + localdg.aiL() + '\n' + "contextId=" + localdg.agX() + '\n' + "onlineNum=" + localdg.aiM() + '\n' + "clickTabContextId=" + localdg.agY() + '\n' + "isPrivate=" + localdg.agW() + '\n' + "sessionBuffer=" + localdg.getSessionBuffer() + '\n' + "snsFeedId=" + localdg.aiO() + '\n' + "sessionID=" + localdg.agZ());
        AppMethodBeat.o(273984);
        return;
        label537:
        localdg.pr(parami.yAP);
        continue;
        label549:
        if (com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric(parami.feedId)) {
          localdg.pr(a.T(Util.getLong(parami.feedId, -1L), Long.parseLong(parami.yAP)));
        } else {
          localdg.pr(parami.yAP);
        }
      }
    }
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(273986);
      kotlin.g.b.p.k(paramj, "feed");
      a locala;
      dg localdg;
      Object localObject;
      if (paramj.yBc)
      {
        locala = this.yAe;
        kotlin.g.b.p.k(paramj, "feed");
        localdg = new dg();
        localObject = k.yBj;
        localObject = paramj.yBd.contact;
        if (localObject != null)
        {
          String str = ((FinderContact)localObject).username;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        k.a(localdg, (String)localObject);
        localdg.pl(paramj.feedId);
        localdg.iq(0L);
        localdg.pt("0");
        localdg.is(paramj.yAO.fwf);
        localdg.pn(paramj.yAP);
        localdg.it(paramj.pos);
        localdg.iu(0L);
        localdg.iv(0L);
        localdg.po("");
        localdg.pp(com.tencent.mm.plugin.expt.hellhound.core.b.dcv());
        localdg.iw(-1L);
        localdg.pq(com.tencent.mm.plugin.expt.hellhound.core.b.dct());
        if (!kotlin.n.n.M(paramj.yAP, "temp_", false)) {
          break label614;
        }
        if (!kotlin.g.b.p.h(localdg.agV(), "temp_2")) {
          break label601;
        }
        localObject = k.yBj;
        localdg.pr(k.dDm().yDi);
      }
      for (;;)
      {
        localdg.bpa();
        Log.i(locala.TAG, "report21053OnExposure, mixsearch, struct:\nnickName=" + paramj.nickName + '\n' + "userName=" + localdg.getUserName() + '\n' + "feedID=" + localdg.agT() + '\n' + "liveIDStr=" + localdg.aiN() + '\n' + "actionTS=" + localdg.ahg() + '\n' + "action=" + localdg.ahh() + '\n' + "commentScene=" + localdg.agV() + '\n' + "index=" + localdg.aiJ() + '\n' + "enterStatus=" + localdg.ahf() + '\n' + "shareType=" + localdg.aiK() + '\n' + "shareUserName=" + localdg.aiL() + '\n' + "contextId=" + localdg.agX() + '\n' + "onlineNum=" + localdg.aiM() + '\n' + "clickTabContextId=" + localdg.agY() + '\n' + "isPrivate=" + localdg.agW() + '\n' + "sessionBuffer=" + localdg.getSessionBuffer() + '\n' + "snsFeedId=" + localdg.aiO() + '\n' + "sessionID=" + localdg.agZ());
        AppMethodBeat.o(273986);
        return;
        label601:
        localdg.pr(paramj.yAP);
        continue;
        label614:
        if (com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric(paramj.feedId))
        {
          long l = Util.getLong(paramj.feedId, -1L);
          localObject = localdg.agV();
          kotlin.g.b.p.j(localObject, "struct.commentScene");
          localdg.pr(a.T(l, Long.parseLong((String)localObject)));
        }
        else
        {
          localdg.pr(paramj.yAP);
        }
      }
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(273983);
      kotlin.g.b.p.k(paramh, "liveFeed");
      AppMethodBeat.o(273983);
    }
    
    public final void b(i parami)
    {
      AppMethodBeat.i(273985);
      kotlin.g.b.p.k(parami, "feed");
      AppMethodBeat.o(273985);
    }
    
    public final void b(j paramj)
    {
      AppMethodBeat.i(273987);
      kotlin.g.b.p.k(paramj, "feed");
      AppMethodBeat.o(273987);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.a
 * JD-Core Version:    0.7.0.1
 */