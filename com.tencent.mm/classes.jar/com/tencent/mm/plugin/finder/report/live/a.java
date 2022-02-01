package com.tencent.mm.plugin.finder.report.live;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cp;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.search.FinderContactSearchUI.a;
import com.tencent.mm.plugin.finder.search.f.b;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/Audience21053Report;", "", "()V", "TAG", "", "mExposureCallback", "com/tencent/mm/plugin/finder/report/live/Audience21053Report$mExposureCallback$1", "Lcom/tencent/mm/plugin/finder/report/live/Audience21053Report$mExposureCallback$1;", "mFeedExposure", "Lcom/tencent/mm/plugin/finder/report/live/HellFeedExposure;", "mFeedSingleExposure", "Lcom/tencent/mm/plugin/finder/report/live/HellFeedSingleExposure;", "report", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "actionType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "commentscene", "event", "Lcom/tencent/mm/plugin/finder/report/live/HELL_SCROLL_EVENT;", "listView", "Landroid/widget/AbsListView;", "adapter", "Landroid/widget/BaseAdapter;", "visibleState", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$VisiableState;", "firstVisibleItem", "", "visibleItemCount", "headerShow", "", "reportOnClick", "clickData", "Lcom/tencent/mm/plugin/finder/report/live/HellVisitorClickData;", "reportOnClickOnShare", "enterData", "Lcom/tencent/mm/plugin/finder/report/live/HellVisitorEnterData;", "reportOnEnter", "reportOnExposure", "liveFeed", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed;", "feed", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveItem;", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveMixSearchItem;", "index", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "plugin-finder_release"})
public final class a
{
  final String TAG;
  private final a viY;
  private final d viZ;
  final f vja;
  
  public a()
  {
    AppMethodBeat.i(250901);
    this.TAG = "HABBYGE-MALI.Audience21053Report";
    this.viY = new a(this);
    this.viZ = new d((r)this.viY);
    this.vja = new f((r)this.viY);
    AppMethodBeat.o(250901);
  }
  
  public final void a(RecyclerView paramRecyclerView, s.p paramp, String paramString, c paramc)
  {
    f localf = null;
    Object localObject2 = null;
    RecyclerView.LayoutManager localLayoutManager = null;
    d locald = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    AppMethodBeat.i(250897);
    kotlin.g.b.p.h(paramp, "actionType");
    kotlin.g.b.p.h(paramString, "commentscene");
    kotlin.g.b.p.h(paramc, "event");
    if ((kotlin.g.b.p.j(paramString, "94")) || (kotlin.g.b.p.j(paramString, "80")) || (kotlin.g.b.p.j(paramString, s.j.vnV.scene)) || (kotlin.g.b.p.j(paramString, s.j.vnR.scene)) || (kotlin.g.b.p.j(paramString, "26")) || (kotlin.g.b.p.j(paramString, s.j.vnQ.scene)) || (kotlin.g.b.p.j(paramString, "15")))
    {
      locald = this.viZ;
      kotlin.g.b.p.h(paramc, "event");
      kotlin.g.b.p.h(paramp, "actionType");
      kotlin.g.b.p.h(paramString, "commentscene");
      switch (e.$EnumSwitchMapping$0[paramc.ordinal()])
      {
      default: 
        Log.e(locald.TAG, "run, else-case, event=".concat(String.valueOf(paramc)));
        AppMethodBeat.o(250897);
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
            AppMethodBeat.o(250897);
            return;
          }
          locald.vjn = new WeakReference(paramc);
          if (kotlin.g.b.p.j(paramString, s.j.vnQ.scene))
          {
            paramRecyclerView = paramRecyclerView.getAdapter();
            if ((paramRecyclerView instanceof f.b)) {
              break label2222;
            }
            paramRecyclerView = (RecyclerView)localObject1;
          }
        }
        break;
      }
    }
    label681:
    label1833:
    label2219:
    label2222:
    for (;;)
    {
      paramRecyclerView = (f.b)paramRecyclerView;
      if (paramRecyclerView == null)
      {
        AppMethodBeat.o(250897);
        return;
      }
      locald.vjp = new WeakReference(paramRecyclerView);
      locald.a(paramRecyclerView, paramc, paramp, paramString);
      AppMethodBeat.o(250897);
      return;
      if (kotlin.g.b.p.j(paramString, s.j.vnR.scene))
      {
        paramRecyclerView = paramRecyclerView.getAdapter();
        if ((paramRecyclerView instanceof WxRecyclerAdapter)) {
          break label2219;
        }
        paramRecyclerView = localf;
      }
      for (;;)
      {
        paramRecyclerView = (WxRecyclerAdapter)paramRecyclerView;
        if (paramRecyclerView == null)
        {
          AppMethodBeat.o(250897);
          return;
        }
        locald.vjq = new WeakReference(paramRecyclerView);
        locald.a(paramRecyclerView, paramc, paramp, paramString);
        AppMethodBeat.o(250897);
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
            AppMethodBeat.o(250897);
            return;
          }
          locald.vjo = new WeakReference(paramRecyclerView);
          locald.b(paramRecyclerView, paramc, paramp, paramString);
          AppMethodBeat.o(250897);
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
              AppMethodBeat.o(250897);
              return;
            }
            locald.vjs = new WeakReference(paramc);
            paramRecyclerView = paramRecyclerView.getLayoutManager();
            if ((paramRecyclerView instanceof LinearLayoutManager)) {
              break label2213;
            }
            paramRecyclerView = localLayoutManager;
          }
          for (;;)
          {
            paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
            if (paramRecyclerView == null)
            {
              AppMethodBeat.o(250897);
              return;
            }
            locald.vjr = new WeakReference(paramRecyclerView);
            locald.a(paramc, paramRecyclerView, paramp, paramString);
            AppMethodBeat.o(250897);
            return;
            if (kotlin.g.b.p.j(paramString, s.j.vnQ.scene)) {
              if (paramRecyclerView != null)
              {
                paramc = paramRecyclerView.getAdapter();
                label615:
                localObject1 = paramc;
                if (!(paramc instanceof f.b)) {
                  localObject1 = null;
                }
                paramc = (f.b)localObject1;
                if (paramc != null) {
                  break label2210;
                }
                paramc = locald.vjp;
                if (paramc == null) {
                  break label681;
                }
                paramc = (f.b)paramc.get();
              }
            }
            for (;;)
            {
              if (paramc == null)
              {
                AppMethodBeat.o(250897);
                return;
                paramc = null;
                break label615;
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
                  paramRecyclerView = locald.vjn;
                  if (paramRecyclerView == null) {
                    break label757;
                  }
                }
              }
              label757:
              for (paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.get();; paramRecyclerView = null)
              {
                if (paramRecyclerView != null) {
                  break label762;
                }
                AppMethodBeat.o(250897);
                return;
                paramRecyclerView = null;
                break;
              }
              label762:
              locald.a(paramc, paramRecyclerView, paramp, paramString);
              AppMethodBeat.o(250897);
              return;
              if (kotlin.g.b.p.j(paramString, s.j.vnR.scene)) {
                if (paramRecyclerView != null)
                {
                  paramc = paramRecyclerView.getAdapter();
                  localObject1 = paramc;
                  if (!(paramc instanceof WxRecyclerAdapter)) {
                    localObject1 = null;
                  }
                  paramc = (WxRecyclerAdapter)localObject1;
                  if (paramc != null) {
                    break label2207;
                  }
                  paramc = locald.vjq;
                  if (paramc == null) {
                    break label867;
                  }
                  paramc = (WxRecyclerAdapter)paramc.get();
                }
              }
              for (;;)
              {
                if (paramc == null)
                {
                  AppMethodBeat.o(250897);
                  return;
                  paramc = null;
                  break label801;
                  label867:
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
                    paramRecyclerView = locald.vjn;
                    if (paramRecyclerView == null) {
                      break label943;
                    }
                  }
                }
                label943:
                for (paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.get();; paramRecyclerView = null)
                {
                  if (paramRecyclerView != null) {
                    break label948;
                  }
                  AppMethodBeat.o(250897);
                  return;
                  paramRecyclerView = null;
                  break;
                }
                label948:
                locald.a(paramc, paramRecyclerView, paramp, paramString);
                AppMethodBeat.o(250897);
                return;
                if (paramRecyclerView != null)
                {
                  paramc = paramRecyclerView.getAdapter();
                  label974:
                  localObject1 = paramc;
                  if (!(paramc instanceof WxRecyclerAdapter)) {
                    localObject1 = null;
                  }
                  paramc = (WxRecyclerAdapter)localObject1;
                  if (paramc != null) {
                    break label2204;
                  }
                  paramc = locald.vjo;
                  if (paramc == null) {
                    break label1040;
                  }
                  paramc = (WxRecyclerAdapter)paramc.get();
                }
                for (;;)
                {
                  if (paramc == null)
                  {
                    AppMethodBeat.o(250897);
                    return;
                    paramc = null;
                    break label974;
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
                      paramRecyclerView = locald.vjn;
                      if (paramRecyclerView == null) {
                        break label1116;
                      }
                    }
                  }
                  label1116:
                  for (paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.get();; paramRecyclerView = null)
                  {
                    if (paramRecyclerView != null) {
                      break label1121;
                    }
                    AppMethodBeat.o(250897);
                    return;
                    paramRecyclerView = null;
                    break;
                  }
                  label1121:
                  locald.b(paramc, paramRecyclerView, paramp, paramString);
                  AppMethodBeat.o(250897);
                  return;
                  locald.dpa();
                  if (!kotlin.g.b.p.j(paramString, s.j.vnQ.scene)) {
                    break;
                  }
                  locald.dpb();
                  AppMethodBeat.o(250897);
                  return;
                  locald.vjv.clear();
                  AppMethodBeat.o(250897);
                  return;
                  if ((kotlin.g.b.p.j(paramString, "61")) || (kotlin.g.b.p.j(paramString, "1")) || (kotlin.g.b.p.j(paramString, "39")) || (kotlin.g.b.p.j(paramString, "40")) || (kotlin.g.b.p.j(paramString, "21")) || (kotlin.g.b.p.j(paramString, "2")) || (kotlin.g.b.p.j(paramString, "25")) || (kotlin.g.b.p.j(paramString, "20")) || (kotlin.g.b.p.j(paramString, "18")) || (kotlin.g.b.p.j(paramString, s.j.vnP.scene)) || (kotlin.g.b.p.j(paramString, "12")) || (kotlin.g.b.p.j(paramString, s.j.vnN.scene)) || (kotlin.g.b.p.j(paramString, s.j.vnU.scene)) || (kotlin.g.b.p.j(paramString, "27")) || (kotlin.g.b.p.j(paramString, "9")) || (kotlin.g.b.p.j(paramString, "6")) || (kotlin.g.b.p.j(paramString, "16")))
                  {
                    localf = this.vja;
                    kotlin.g.b.p.h(paramc, "event");
                    kotlin.g.b.p.h(paramp, "actionType");
                    kotlin.g.b.p.h(paramString, "commentscene");
                    switch (g.haE[paramc.ordinal()])
                    {
                    default: 
                      if ((paramc == c.vjf) || (paramc == c.vjh)) {
                        if (kotlin.g.b.p.j(paramString, s.j.vnP.scene)) {
                          if (paramRecyclerView != null)
                          {
                            paramc = paramRecyclerView.getAdapter();
                            localObject1 = paramc;
                            if (!(paramc instanceof FinderContactSearchUI.a)) {
                              localObject1 = null;
                            }
                            paramc = (FinderContactSearchUI.a)localObject1;
                            if (paramc != null) {
                              break label2192;
                            }
                            paramc = localf.vjx;
                            if (paramc == null) {
                              break label1833;
                            }
                            paramc = (FinderContactSearchUI.a)paramc.get();
                            if (paramc != null) {
                              break label1839;
                            }
                            AppMethodBeat.o(250897);
                          }
                        }
                      }
                      break;
                    case 1: 
                      label1500:
                      if (paramRecyclerView == null)
                      {
                        AppMethodBeat.o(250897);
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
                        AppMethodBeat.o(250897);
                        return;
                      }
                      localf.vjn = new WeakReference(paramc);
                      if (kotlin.g.b.p.j(paramString, s.j.vnP.scene))
                      {
                        paramRecyclerView = paramRecyclerView.getAdapter();
                        if ((paramRecyclerView instanceof FinderContactSearchUI.a)) {
                          break label2201;
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
                      AppMethodBeat.o(250897);
                      return;
                    }
                    localf.vjx = new WeakReference(paramRecyclerView);
                    localf.a(paramRecyclerView, paramc, paramp, paramString);
                    AppMethodBeat.o(250897);
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
                        AppMethodBeat.o(250897);
                        return;
                      }
                      localf.vjo = new WeakReference(paramRecyclerView);
                      localf.b(paramRecyclerView, paramc, paramp, paramString);
                      AppMethodBeat.o(250897);
                      return;
                      if (paramRecyclerView == null)
                      {
                        AppMethodBeat.o(250897);
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
                        AppMethodBeat.o(250897);
                        return;
                      }
                      localf.vjo = new WeakReference(paramc);
                      paramRecyclerView = paramRecyclerView.getLayoutManager();
                      if (!(paramRecyclerView instanceof LinearLayoutManager)) {
                        paramRecyclerView = localObject4;
                      }
                      for (;;)
                      {
                        paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
                        if (paramRecyclerView == null)
                        {
                          AppMethodBeat.o(250897);
                          return;
                        }
                        localf.vjn = new WeakReference(paramRecyclerView);
                        localf.a(paramc, paramRecyclerView, paramp, paramString);
                        AppMethodBeat.o(250897);
                        return;
                        paramc = null;
                        break;
                        paramc = null;
                        break label1500;
                        label1839:
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
                            paramRecyclerView = localf.vjn;
                            if (paramRecyclerView == null) {
                              break label1909;
                            }
                          }
                        }
                        label1909:
                        for (paramRecyclerView = (LinearLayoutManager)paramRecyclerView.get();; paramRecyclerView = null)
                        {
                          if (paramRecyclerView != null) {
                            break label1914;
                          }
                          AppMethodBeat.o(250897);
                          return;
                          paramRecyclerView = null;
                          break;
                        }
                        label1914:
                        localf.a(paramc, paramRecyclerView, paramp, paramString);
                        AppMethodBeat.o(250897);
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
                            break label2189;
                          }
                          paramc = localf.vjo;
                          if (paramc == null) {
                            break label2006;
                          }
                          paramc = (WxRecyclerAdapter)paramc.get();
                        }
                        for (;;)
                        {
                          if (paramc == null)
                          {
                            AppMethodBeat.o(250897);
                            return;
                            paramc = null;
                            break;
                            label2006:
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
                              paramRecyclerView = localf.vjn;
                              if (paramRecyclerView == null) {
                                break label2082;
                              }
                            }
                          }
                          for (paramRecyclerView = (LinearLayoutManager)paramRecyclerView.get();; paramRecyclerView = null)
                          {
                            if (paramRecyclerView != null) {
                              break label2087;
                            }
                            AppMethodBeat.o(250897);
                            return;
                            paramRecyclerView = null;
                            break;
                          }
                          localf.b(paramc, paramRecyclerView, paramp, paramString);
                          AppMethodBeat.o(250897);
                          return;
                          if (paramc == c.vjg)
                          {
                            if (kotlin.g.b.p.j(paramString, "12"))
                            {
                              localf.dpe();
                              AppMethodBeat.o(250897);
                              return;
                            }
                            if (kotlin.g.b.p.j(paramString, s.j.vnP.scene))
                            {
                              localf.dpb();
                              AppMethodBeat.o(250897);
                              return;
                            }
                            localf.dpa();
                            AppMethodBeat.o(250897);
                            return;
                          }
                          if (paramc == c.vjl) {
                            localf.vjv.clear();
                          }
                          AppMethodBeat.o(250897);
                          return;
                        }
                        break label1500;
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
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(250899);
    kotlin.g.b.p.h(paramp, "clickData");
    cp localcp = new cp();
    Object localObject = k.vkd;
    k.a(localcp, paramp.userName);
    localcp.mR(com.tencent.mm.plugin.expt.hellhound.core.b.zs(paramp.feedId));
    localcp.hy(paramp.liveId);
    localcp.mY(com.tencent.mm.plugin.expt.hellhound.core.b.zs(paramp.liveId));
    localcp.hA(paramp.vjL.dDw);
    localcp.mT(paramp.vjM);
    localcp.hB(paramp.vln);
    localcp.hC(0L);
    localcp.hD(paramp.vlp);
    localcp.mU(paramp.vlq);
    localcp.mZ(paramp.vlr);
    localcp.mV(com.tencent.mm.plugin.expt.hellhound.core.b.cND());
    localcp.hE(paramp.vlo);
    localcp.mW(com.tencent.mm.plugin.expt.hellhound.core.b.cNB());
    if (n.J(paramp.vjM, "temp_", false)) {
      if (kotlin.g.b.p.j(localcp.ach(), "temp_2"))
      {
        paramp = k.vkd;
        localcp.mX(k.dpl().vlV);
        if (kotlin.g.b.p.j(localcp.ach(), "61"))
        {
          if (!TextUtils.isEmpty((CharSequence)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEy)) {
            break label758;
          }
          paramp = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
          kotlin.g.b.p.g(paramp, "HellSessionMonitor.getInstance()");
        }
      }
    }
    label758:
    for (paramp = paramp.cPR();; paramp = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEy)
    {
      localcp.na(paramp);
      localcp.bfK();
      Log.i(this.TAG, "report21053OnClick, struct=\nfeedId=" + localcp.acf() + '\n' + "liveId=" + localcp.adY() + '\n' + "userName=" + localcp.getUserName() + '\n' + "isPrivate=" + localcp.aci() + '\n' + "sessionID=" + localcp.acl() + '\n' + "actionTS=" + localcp.acs() + '\n' + "action=" + localcp.act() + '\n' + "commentScene=" + localcp.ach() + '\n' + "index=" + localcp.adU() + '\n' + "enterStatus=" + localcp.acr() + '\n' + "contextId=" + localcp.acj() + '\n' + "onlineNum=" + localcp.adX() + '\n' + "clickTabContextId=" + localcp.ack() + '\n' + "sessionBuffer=" + localcp.getSessionBuffer() + '\n' + "enterSessionId=" + localcp.aea() + '\n' + "enterIconType=" + localcp.acv() + '\n' + "snsSessionID=" + localcp.aeb() + '\n' + "shareType=" + localcp.adV() + '\n' + "shareUserName=" + localcp.adW() + '\n' + "snsFeedId=" + localcp.adZ());
      AppMethodBeat.o(250899);
      return;
      localcp.mX(paramp.vjM);
      break;
      localObject = com.tencent.mm.plugin.finder.report.k.vfA;
      long l = paramp.feedId;
      localObject = localcp.ach();
      kotlin.g.b.p.g(localObject, "struct.commentScene");
      localObject = com.tencent.mm.plugin.finder.report.k.G(l, Integer.parseInt((String)localObject));
      if (localObject != null)
      {
        String str = n.j((String)localObject, ",", ";", false);
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = paramp.vjM;
      }
      localcp.mX((String)localObject);
      break;
    }
  }
  
  public final void a(q paramq)
  {
    AppMethodBeat.i(250900);
    kotlin.g.b.p.h(paramq, "enterData");
    cp localcp = new cp();
    Object localObject = k.vkd;
    k.a(localcp, paramq.userName);
    localcp.mR(com.tencent.mm.plugin.expt.hellhound.core.b.zs(paramq.feedId));
    localcp.hy(paramq.liveId);
    localcp.mY(com.tencent.mm.plugin.expt.hellhound.core.b.zs(paramq.liveId));
    localcp.hA(paramq.vjL.dDw);
    localcp.mT(paramq.vjM);
    localcp.hB(paramq.vln);
    localcp.hC(paramq.vlt);
    localcp.hD(paramq.vlp);
    localcp.mU(paramq.vlq);
    localcp.mZ(paramq.vlr);
    localcp.mV(com.tencent.mm.plugin.expt.hellhound.core.b.cND());
    localcp.hE(paramq.vlo);
    localcp.mW(com.tencent.mm.plugin.expt.hellhound.core.b.cNB());
    if (n.J(paramq.vjM, "temp_", false)) {
      if (kotlin.g.b.p.j(localcp.ach(), "temp_2"))
      {
        localObject = k.vkd;
        localcp.mX(k.dpl().vlV);
        localcp.hG(paramq.enterTime);
        localObject = k.vkd;
        localcp.hH(s.as(localcp.ach(), paramq.vlu.type));
        if (kotlin.g.b.p.j(localcp.ach(), "61"))
        {
          if (!TextUtils.isEmpty((CharSequence)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEy)) {
            break label799;
          }
          paramq = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
          kotlin.g.b.p.g(paramq, "HellSessionMonitor.getInstance()");
        }
      }
    }
    label799:
    for (paramq = paramq.cPR();; paramq = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEy)
    {
      localcp.na(paramq);
      localcp.bfK();
      Log.i(this.TAG, "report21053OnEnter, struct=\nfeedId=" + localcp.acf() + '\n' + "liveId=" + localcp.adY() + '\n' + "userName=" + localcp.getUserName() + '\n' + "isPrivate=" + localcp.aci() + '\n' + "sessionID=" + localcp.acl() + '\n' + "actionTS=" + localcp.acs() + '\n' + "action=" + localcp.act() + '\n' + "commentScene=" + localcp.ach() + '\n' + "index=" + localcp.adU() + '\n' + "enterStatus=" + localcp.acr() + '\n' + "contextId=" + localcp.acj() + '\n' + "onlineNum=" + localcp.adX() + '\n' + "clickTabContextId=" + localcp.ack() + '\n' + "sessionBuffer=" + localcp.getSessionBuffer() + '\n' + "shareType=" + localcp.adV() + '\n' + "shareUserName=" + localcp.adW() + '\n' + "enterSessionId=" + localcp.aea() + '\n' + "enterIconType=" + localcp.acv() + '\n' + "snsSessionID=" + localcp.aeb() + '\n' + "snsFeedId=" + localcp.adZ());
      AppMethodBeat.o(250900);
      return;
      localcp.mX(paramq.vjM);
      break;
      localObject = com.tencent.mm.plugin.finder.report.k.vfA;
      long l = paramq.feedId;
      localObject = localcp.ach();
      kotlin.g.b.p.g(localObject, "struct.commentScene");
      localObject = com.tencent.mm.plugin.finder.report.k.G(l, Integer.parseInt((String)localObject));
      if (localObject != null)
      {
        String str = n.j((String)localObject, ",", ";", false);
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = paramq.vjM;
      }
      localcp.mX((String)localObject);
      break;
    }
  }
  
  public final void a(s.p paramp, int paramInt, String paramString, FeedData paramFeedData)
  {
    AppMethodBeat.i(250898);
    kotlin.g.b.p.h(paramp, "actionType");
    kotlin.g.b.p.h(paramString, "commentscene");
    if (paramFeedData == null)
    {
      AppMethodBeat.o(250898);
      return;
    }
    cp localcp = new cp();
    k localk = k.vkd;
    k.a(localcp, paramFeedData.getUserName());
    localcp.mR(com.tencent.mm.plugin.expt.hellhound.core.b.zs(paramFeedData.getFeedId()));
    localcp.hy(paramFeedData.getLiveId());
    localcp.mY(com.tencent.mm.plugin.expt.hellhound.core.b.zs(paramFeedData.getLiveId()));
    localcp.hA(paramp.dDw);
    localcp.mT(paramString);
    localcp.hB(paramInt);
    localcp.hC(0L);
    localcp.hD(0L);
    localcp.mU(paramFeedData.getUserName());
    localcp.mV(com.tencent.mm.plugin.expt.hellhound.core.b.cND());
    localcp.hE(paramFeedData.getOnlineNum());
    localcp.mW(com.tencent.mm.plugin.expt.hellhound.core.b.cNB());
    if (kotlin.g.b.p.j(localcp.ach(), "temp_2"))
    {
      paramp = k.vkd;
      localcp.mX(k.dpl().vlV);
      if (kotlin.g.b.p.j(localcp.ach(), "61"))
      {
        if (!TextUtils.isEmpty((CharSequence)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEy)) {
          break label696;
        }
        paramp = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
        kotlin.g.b.p.g(paramp, "HellSessionMonitor.getInstance()");
      }
    }
    label696:
    for (paramp = paramp.cPR();; paramp = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEy)
    {
      localcp.na(paramp);
      localcp.bfK();
      Log.i(this.TAG, "report21053OnExposure, struct-2:\nuserName=" + localcp.getUserName() + '\n' + "nickName=" + paramFeedData.getNickName() + '\n' + "feedID=" + localcp.acf() + '\n' + "liveIDStr=" + localcp.adY() + '\n' + "actionTS=" + localcp.acs() + '\n' + "action=" + localcp.act() + '\n' + "commentScene=" + localcp.ach() + '\n' + "index=" + localcp.adU() + '\n' + "enterStatus=" + localcp.acr() + '\n' + "shareType=" + localcp.adV() + '\n' + "shareUserName=" + localcp.adW() + '\n' + "contextId=" + localcp.acj() + '\n' + "onlineNum=" + localcp.adX() + '\n' + "clickTabContextId=" + localcp.ack() + '\n' + "isPrivate=" + localcp.aci() + '\n' + "sessionBuffer=" + localcp.getSessionBuffer() + '\n' + "snsFeedId=" + localcp.adZ() + '\n' + "enterSessionId=" + localcp.aea() + '\n' + "enterIconType=" + localcp.acv() + '\n' + "snsSessionID=" + localcp.aeb() + '\n' + "sessionID=" + localcp.acl());
      AppMethodBeat.o(250898);
      return;
      localcp.mX(n.j(paramFeedData.getSessionBuffer(), ",", ";", false));
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/report/live/Audience21053Report$mExposureCallback$1", "Lcom/tencent/mm/plugin/finder/report/live/IFeedEventCallback;", "onAppear", "", "liveFeed", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed;", "fromSingleFlow", "", "feed", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveItem;", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveMixSearchItem;", "onDisappear", "plugin-finder_release"})
  public static final class a
    implements r
  {
    public final void a(h paramh)
    {
      AppMethodBeat.i(250892);
      kotlin.g.b.p.h(paramh, "liveFeed");
      AppMethodBeat.o(250892);
    }
    
    public final void a(h paramh, boolean paramBoolean)
    {
      int j = 1;
      AppMethodBeat.i(250891);
      kotlin.g.b.p.h(paramh, "liveFeed");
      Object localObject;
      if ((paramh.tIu instanceof BaseFinderFeed))
      {
        localObject = y.vXH;
        if (!y.w((BaseFinderFeed)paramh.tIu)) {}
      }
      label208:
      label1125:
      for (int i = 1;; i = 0)
      {
        if ((paramh.vjP) || (i != 0) || (paramh.vjN == h.b.vjT) || (paramh.vjO))
        {
          i = 1;
          if ((i != 0) || (!paramBoolean) || (!(paramh.tIu instanceof BaseFinderFeed))) {
            break label1133;
          }
          localObject = ((BaseFinderFeed)paramh.tIu).contact;
          if ((localObject == null) || (((g)localObject).field_liveStatus != 1)) {
            break label875;
          }
          i = j;
          label121:
          localObject = s.p.voB;
          kotlin.g.b.p.h(localObject, "<set-?>");
          paramh.vjL = ((s.p)localObject);
        }
        label875:
        label1133:
        for (;;)
        {
          a locala;
          cp localcp;
          if (i != 0)
          {
            locala = this.vjb;
            kotlin.g.b.p.h(paramh, "liveFeed");
            localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEs;
            switch (((String)localObject).hashCode())
            {
            default: 
              localcp = new cp();
              localObject = k.vkd;
              k.a(localcp, paramh.userName);
              localcp.mR(paramh.feedId);
              localcp.hy(paramh.liveId);
              localcp.mY(com.tencent.mm.plugin.expt.hellhound.core.b.zs(paramh.liveId));
              localcp.hA(paramh.vjL.dDw);
              localcp.mT(paramh.vjM);
              localcp.hB(paramh.pos);
              localcp.hC(0L);
              localcp.hD(paramh.vjQ);
              localcp.mU(paramh.userName);
              localcp.mV(com.tencent.mm.plugin.expt.hellhound.core.b.cND());
              localcp.hE(paramh.onlineNum);
              localcp.mW(com.tencent.mm.plugin.expt.hellhound.core.b.cNB());
              if (n.J(paramh.vjM, "temp_", false)) {
                if (kotlin.g.b.p.j(paramh.vjM, "temp_2"))
                {
                  localObject = k.vkd;
                  localcp.mX(k.dpl().vlV);
                  if (kotlin.g.b.p.j(localcp.ach(), "61"))
                  {
                    if (!TextUtils.isEmpty((CharSequence)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEy)) {
                      break label1125;
                    }
                    localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                    kotlin.g.b.p.g(localObject, "HellSessionMonitor.getInstance()");
                  }
                }
              }
              break;
            }
          }
          for (localObject = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject).cPR();; localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEy)
          {
            localcp.na((String)localObject);
            localcp.bfK();
            Log.i(locala.TAG, "report21053OnExposure, struct:\nuserName=" + localcp.getUserName() + '\n' + "nickName=" + paramh.nickName + '\n' + "feedID=" + localcp.acf() + '\n' + "liveIDStr=" + localcp.adY() + '\n' + "actionTS=" + localcp.acs() + '\n' + "action=" + localcp.act() + '\n' + "commentScene=" + localcp.ach() + '\n' + "index=" + localcp.adU() + '\n' + "enterStatus=" + localcp.acr() + '\n' + "shareType=" + localcp.adV() + '\n' + "shareUserName=" + localcp.adW() + '\n' + "contextId=" + localcp.acj() + '\n' + "onlineNum=" + localcp.adX() + '\n' + "clickTabContextId=" + localcp.ack() + '\n' + "isPrivate=" + localcp.aci() + '\n' + "sessionBuffer=" + localcp.getSessionBuffer() + '\n' + "snsFeedId=" + localcp.adZ() + '\n' + "enterSessionId=" + localcp.aea() + '\n' + "enterIconType=" + localcp.acv() + '\n' + "snsSessionID=" + localcp.aeb() + '\n' + "sessionID=" + localcp.acl());
            AppMethodBeat.o(250891);
            return;
            i = 0;
            break;
            i = 0;
            break label121;
            if (!((String)localObject).equals("FinderFriendTabFragment")) {
              break label208;
            }
            while ((kotlin.g.b.p.j(paramh.vjM, s.j.vnN.scene)) || (kotlin.g.b.p.j(paramh.vjM, "17")))
            {
              AppMethodBeat.o(250891);
              return;
              if (!((String)localObject).equals("FinderMachineTabFragment")) {
                break;
              }
              while ((kotlin.g.b.p.j(paramh.vjM, s.j.vnN.scene)) || (kotlin.g.b.p.j(paramh.vjM, "17")) || (kotlin.g.b.p.j(paramh.vjM, s.j.vnU.scene)) || (kotlin.g.b.p.j(paramh.vjM, "18")))
              {
                AppMethodBeat.o(250891);
                return;
                if (!((String)localObject).equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment")) {
                  break;
                }
              }
              if (!((String)localObject).equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment")) {
                break;
              }
            }
            localcp.mX(paramh.vjM);
            break label397;
            localObject = com.tencent.mm.plugin.finder.report.k.vfA;
            long l = paramh.vjK;
            localObject = localcp.ach();
            kotlin.g.b.p.g(localObject, "struct.commentScene");
            localObject = com.tencent.mm.plugin.finder.report.k.G(l, Integer.parseInt((String)localObject));
            if (localObject != null)
            {
              String str = n.j((String)localObject, ",", ";", false);
              localObject = str;
              if (str != null) {}
            }
            else
            {
              localObject = paramh.vjM;
            }
            localcp.mX((String)localObject);
            break label397;
          }
        }
      }
    }
    
    public final void a(i parami)
    {
      AppMethodBeat.i(250893);
      kotlin.g.b.p.h(parami, "feed");
      a locala;
      cp localcp;
      Object localObject;
      if (parami.vjX)
      {
        locala = this.vjb;
        kotlin.g.b.p.h(parami, "feed");
        localcp = new cp();
        localObject = k.vkd;
        k.a(localcp, parami.vjW.contact.getUsername());
        localcp.mR(parami.feedId);
        localcp.hy(0L);
        localcp.mY("0");
        localcp.hA(parami.vjL.dDw);
        localcp.mT(parami.vjM);
        localcp.hB(parami.pos);
        localcp.hC(0L);
        localcp.hD(0L);
        localcp.mU("");
        localcp.mV(com.tencent.mm.plugin.expt.hellhound.core.b.cND());
        localcp.hE(-1L);
        localcp.mW(com.tencent.mm.plugin.expt.hellhound.core.b.cNB());
        if (!n.J(parami.vjM, "temp_", false)) {
          break label592;
        }
        if (!kotlin.g.b.p.j(localcp.ach(), "temp_2")) {
          break label579;
        }
        localObject = k.vkd;
        localcp.mX(k.dpl().vlV);
      }
      for (;;)
      {
        localcp.bfK();
        Log.i(locala.TAG, "report21053OnExposure, item, struct:\nnickName=" + parami.nickName + '\n' + "userName=" + localcp.getUserName() + '\n' + "feedID=" + localcp.acf() + '\n' + "liveIDStr=" + localcp.adY() + '\n' + "actionTS=" + localcp.acs() + '\n' + "action=" + localcp.act() + '\n' + "commentScene=" + localcp.ach() + '\n' + "index=" + localcp.adU() + '\n' + "enterStatus=" + localcp.acr() + '\n' + "shareType=" + localcp.adV() + '\n' + "shareUserName=" + localcp.adW() + '\n' + "contextId=" + localcp.acj() + '\n' + "onlineNum=" + localcp.adX() + '\n' + "clickTabContextId=" + localcp.ack() + '\n' + "isPrivate=" + localcp.aci() + '\n' + "sessionBuffer=" + localcp.getSessionBuffer() + '\n' + "snsFeedId=" + localcp.adZ() + '\n' + "sessionID=" + localcp.acl());
        AppMethodBeat.o(250893);
        return;
        label579:
        localcp.mX(parami.vjM);
        continue;
        label592:
        if (com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric(parami.feedId))
        {
          long l = Util.getLong(parami.feedId, -1L);
          localObject = com.tencent.mm.plugin.finder.report.k.vfA;
          localObject = localcp.ach();
          kotlin.g.b.p.g(localObject, "struct.commentScene");
          localObject = com.tencent.mm.plugin.finder.report.k.G(l, Integer.parseInt((String)localObject));
          if (localObject != null)
          {
            String str = n.j((String)localObject, ",", ";", false);
            localObject = str;
            if (str != null) {}
          }
          else
          {
            localObject = parami.vjM;
          }
          localcp.mX((String)localObject);
        }
        else
        {
          localcp.mX(parami.vjM);
        }
      }
    }
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(250895);
      kotlin.g.b.p.h(paramj, "feed");
      a locala;
      cp localcp;
      Object localObject;
      String str;
      if (paramj.vjX)
      {
        locala = this.vjb;
        kotlin.g.b.p.h(paramj, "feed");
        localcp = new cp();
        localObject = k.vkd;
        localObject = paramj.vjY.contact;
        if (localObject != null)
        {
          str = ((FinderContact)localObject).username;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        k.a(localcp, (String)localObject);
        localcp.mR(paramj.feedId);
        localcp.hy(0L);
        localcp.mY("0");
        localcp.hA(paramj.vjL.dDw);
        localcp.mT(paramj.vjM);
        localcp.hB(paramj.pos);
        localcp.hC(0L);
        localcp.hD(0L);
        localcp.mU("");
        localcp.mV(com.tencent.mm.plugin.expt.hellhound.core.b.cND());
        localcp.hE(-1L);
        localcp.mW(com.tencent.mm.plugin.expt.hellhound.core.b.cNB());
        if (!n.J(paramj.vjM, "temp_", false)) {
          break label619;
        }
        if (!kotlin.g.b.p.j(localcp.ach(), "temp_2")) {
          break label606;
        }
        localObject = k.vkd;
        localcp.mX(k.dpl().vlV);
      }
      for (;;)
      {
        localcp.bfK();
        Log.i(locala.TAG, "report21053OnExposure, mixsearch, struct:\nnickName=" + paramj.nickName + '\n' + "userName=" + localcp.getUserName() + '\n' + "feedID=" + localcp.acf() + '\n' + "liveIDStr=" + localcp.adY() + '\n' + "actionTS=" + localcp.acs() + '\n' + "action=" + localcp.act() + '\n' + "commentScene=" + localcp.ach() + '\n' + "index=" + localcp.adU() + '\n' + "enterStatus=" + localcp.acr() + '\n' + "shareType=" + localcp.adV() + '\n' + "shareUserName=" + localcp.adW() + '\n' + "contextId=" + localcp.acj() + '\n' + "onlineNum=" + localcp.adX() + '\n' + "clickTabContextId=" + localcp.ack() + '\n' + "isPrivate=" + localcp.aci() + '\n' + "sessionBuffer=" + localcp.getSessionBuffer() + '\n' + "snsFeedId=" + localcp.adZ() + '\n' + "sessionID=" + localcp.acl());
        AppMethodBeat.o(250895);
        return;
        label606:
        localcp.mX(paramj.vjM);
        continue;
        label619:
        if (com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric(paramj.feedId))
        {
          long l = Util.getLong(paramj.feedId, -1L);
          localObject = com.tencent.mm.plugin.finder.report.k.vfA;
          localObject = localcp.ach();
          kotlin.g.b.p.g(localObject, "struct.commentScene");
          localObject = com.tencent.mm.plugin.finder.report.k.G(l, Integer.parseInt((String)localObject));
          if (localObject != null)
          {
            str = n.j((String)localObject, ",", ";", false);
            localObject = str;
            if (str != null) {}
          }
          else
          {
            localObject = paramj.vjM;
          }
          localcp.mX((String)localObject);
        }
        else
        {
          localcp.mX(paramj.vjM);
        }
      }
    }
    
    public final void b(i parami)
    {
      AppMethodBeat.i(250894);
      kotlin.g.b.p.h(parami, "feed");
      AppMethodBeat.o(250894);
    }
    
    public final void b(j paramj)
    {
      AppMethodBeat.i(250896);
      kotlin.g.b.p.h(paramj, "feed");
      AppMethodBeat.o(250896);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.live.a
 * JD-Core Version:    0.7.0.1
 */